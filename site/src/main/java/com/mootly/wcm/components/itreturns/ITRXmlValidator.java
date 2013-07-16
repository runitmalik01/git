/*
 * In this class we are creating XML
 * @author Dhananjay
 * 07/05/2013
 */


package com.mootly.wcm.components.itreturns;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.meterware.httpunit.javascript.JavaScript.Form;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ValidationResponse;
import com.mootly.wcm.services.ITRXmlGeneratorServiceFactory;
import com.mootly.wcm.services.XmlGeneratorService;


public class ITRXmlValidator extends BaseComponent {
	ITRXmlGeneratorServiceFactory itrXmlGeneratorServiceFactory = null;
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		itrXmlGeneratorServiceFactory = context.getBean(com.mootly.wcm.services.ITRXmlGeneratorServiceFactory.class);
	}
	
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		FormMap formMap = new FormMap(request,new String[] {"xml","isValid","errors","financialYear"});
		FormUtils.populate(request, formMap);
		if (formMap != null) {
			if (formMap.getField("xml") != null) request.setAttribute("xml", formMap.getField("xml").getValue());
			if (formMap.getField("isValid") != null) request.setAttribute("isValid", formMap.getField("isValid").getValue());
			if (formMap.getField("errors") != null) request.setAttribute("errors", formMap.getField("errors").getValue());
			if (formMap.getField("financialYear") != null) request.setAttribute("financialYear", formMap.getField("financialYear").getValue());
		}
		request.setAttribute("formMap", formMap);
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		String requestFY = request.getParameter("financialYear");
		FinancialYear financialYear = FinancialYear.getByDisplayName(requestFY);
		super.doAction(request, response);
		String xml = request.getParameter("xml");		
		XmlGeneratorService xmlGeneratorService = itrXmlGeneratorServiceFactory.getInstance(financialYear);
		FormMap formMap = new FormMap(request,new String[] {"xml","isValid","errors","financialYear"});
		try {
			ValidationResponse vr = xmlGeneratorService.validateXml(xml);	
			Map<String,String> isValidMap = new HashMap<String, String>(1);
			isValidMap.put("isValid",String.valueOf( vr.isValid() ));
			formMap.getField("isValid").setValues(isValidMap);
			
			Map<String,String> errorsMap = new HashMap<String, String>(1);
			errorsMap.put("errors",String.valueOf( vr.getErrors() ));
			formMap.getField("errors").setValues(errorsMap);
			
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
