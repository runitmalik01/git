/*
 * In this class we are creating XML
 * @author Dhananjay
 * 07/05/2013
 */


package com.mootly.wcm.components.itreturns;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.meterware.httpunit.javascript.JavaScript.Form;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ValidationResponse;
import com.mootly.wcm.services.ITRXmlGeneratorServiceFactory;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.utils.MootlyFormUtils;


public class ITRXmlValidator extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ITRXmlValidator.class);
	ITRXmlGeneratorServiceFactory itrXmlGeneratorServiceFactory = null;
	String xsltPath = null;
	// Create a factory for disk-based file items
	DiskFileItemFactory factory = null;
	File repository = null;
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		itrXmlGeneratorServiceFactory = context.getBean(com.mootly.wcm.services.ITRXmlGeneratorServiceFactory.class);
		xsltPath = servletContext.getRealPath("/xslt/ITRSummary.xsl");

		// Configure a repository (to ensure a secure temp location is used)
		//ServletContext servletContext = this.getServletConfig().getServletContext();factory 		
	}
	
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		FormMap formMap = new FormMap(request,new String[] {"xml","isValid","errors","financialYear","itReturnType","reason","PAN"});
		String publicParameterUUID = getPublicRequestParameter(request, "uuid");
		if(publicParameterUUID==null){
			publicParameterUUID=(String)request.getSession().getAttribute("uuid");
		}
		if (publicParameterUUID != null) {
			try {
				FormUtils.validateId(publicParameterUUID);
				MootlyFormUtils.populate(request, publicParameterUUID, formMap);
				if (formMap != null) {
					request.setAttribute("savedValuesFormMap", formMap);
				}
			}catch (IllegalArgumentException ie) {
				publicParameterUUID = null;
			}
		}
		else {
			FormUtils.populate(request, formMap);
		}
		if (formMap != null) {
			if (formMap.getField("xml") != null) request.setAttribute("xml", formMap.getField("xml").getValue());
			if (formMap.getField("isValid") != null) request.setAttribute("isValid", formMap.getField("isValid").getValue());
			if (formMap.getField("errors") != null) request.setAttribute("errors", formMap.getField("errors").getValue());
			if (formMap.getField("financialYear") != null) request.setAttribute("financialYear", formMap.getField("financialYear").getValue());
			
			if (formMap.getField("reason") != null) request.setAttribute("reason", formMap.getField("reason").getValue());
			if (formMap.getField("PAN") != null) request.setAttribute("PAN", formMap.getField("PAN").getValue());
			if (formMap.getField("itReturnType") != null) request.setAttribute("itReturnType", formMap.getField("itReturnType").getValue());
		}
		request.setAttribute("formMap", formMap);
		//now lets check if there is XML and XSL lets parse and create a summary
		String xml = null;
		if (formMap != null && formMap.getField("xml") != null &&  formMap.getField("xml").getValue() != null ) {
			FileInputStream fi;
			try {
				fi = new FileInputStream(xsltPath);
				xml = formMap.getField("xml").getValue();
				StreamSource stylesource = new StreamSource(fi);
				Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
				transformer.setParameter("showLogo", "false");
				StringWriter sw = new StringWriter();
				StreamSource sSource = new StreamSource(new StringReader(xml));
				StreamResult sResult = new StreamResult(sw);
				transformer.transform(sSource,sResult);
				fi.close();
				String theComputationSummary = sw.toString();
				request.setAttribute("theComputationSummary", theComputationSummary);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub		
		super.doAction(request, response);
		FormMap formMap = new FormMap(request,new String[] {"xml","isValid","errors","financialYear"});
		String xml = null;
		try {
			boolean isMultipart =  ServletFileUpload.isMultipartContent(request);
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			File repository = new File (System.getProperty("java.io.tmpdir") );
			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			ValidationResponse vr = null;
			// Parse the request
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			InputStream inputStreamToValidate = null;
			if (items != null && items.size() > 0 ){
				for (FileItem anItem:items) {
					if (!anItem.isFormField() && anItem.getName() != null && !"".equals(anItem.getName())) {						
						inputStreamToValidate = anItem.getInputStream();
						xml = IOUtils.toString(inputStreamToValidate);
						Map<String,String> xmlMap = new HashMap<String, String>(1);
						xmlMap.put("xml", xml);
						formMap.getField("xml").setValues(xmlMap);
					}
				}				
				for (FileItem anItem:items) {
					if (anItem.isFormField()) {
						if(formMap.getField(anItem.getFieldName()) != null ){							
							if (anItem.getFieldName().equals("xml")) {
								if (inputStreamToValidate == null) {
									xml = anItem.getString();
									Map<String,String> xmlMap = new HashMap<String, String>(1);
									xmlMap.put("xml", xml);
									formMap.getField("xml").setValues(xmlMap);
								}
								else {
									continue;
								}
							}
							else {
								formMap.getField(anItem.getFieldName()).addValue(anItem.getString());
							}
						}
					}					
				}
				
				String financialYearDisplayName = formMap.getField("financialYear").getValue();
				FinancialYear financialYear= FinancialYear.getByDisplayName(financialYearDisplayName);
				XmlGeneratorService xmlGeneratorService = itrXmlGeneratorServiceFactory.getInstance(financialYear);
				//if (inputStreamToValidate != null) {
				//	vr = xmlGeneratorService.validateXml( inputStreamToValidate );
				//}
				//else 
				if (formMap.getField("xml") != null && formMap.getField("xml").getValue() != null) {
					//xml = formMap.getField("xml").getValue(); 
					vr = xmlGeneratorService.validateXml( formMap.getField("xml").getValue() );
				}
			}			
			if (vr != null) {
				Map<String,String> isValidMap = new HashMap<String, String>(1);
				isValidMap.put("isValid",String.valueOf( vr.isValid() ));
				formMap.getField("isValid").setValues(isValidMap);
				
				Map<String,String> errorsMap = new HashMap<String, String>(1);
				errorsMap.put("errors",String.valueOf( vr.getErrors() ));
				formMap.getField("errors").setValues(errorsMap);
			}
			
			FormUtils.persistFormMap(request, response, formMap, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			
			Map<String,String> isValidMap = new HashMap<String, String>(1);
			isValidMap.put("isValid",String.valueOf( false ));
			formMap.getField("isValid").setValues(isValidMap);
			
			Map<String,String> exceptionTrace = new HashMap<String, String>(1);
			exceptionTrace.put("errors","Invalid XML");
			formMap.getField("errors").setValues(exceptionTrace);
			
			FormUtils.persistFormMap(request, response, formMap, null);
		}		
	}
}
