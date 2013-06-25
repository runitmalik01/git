/*
 * In this class we are creating XML
 * @author Dhananjay
 * 07/05/2013
 */


package com.mootly.wcm.member;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.ValueListBeans;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.services.ITRXmlGeneratorServiceFactory;
import com.mootly.wcm.services.XmlGeneratorService;

@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class,
		HouseIncomeDetail.class,HouseProperty.class,OtherSourcesDocument.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class,TdsFromSalaryDocument.class,
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class,SelfAssesmentTaxDetail.class,SalaryIncomeDetail.class,DeductionDocument.class,
		DeductionDocumentDetail.class,InterestDoc.class,FormSixteenDocument.class,FormSixteenDetail.class,RebateSec90Document.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@ValueListBeans(paths={"deduction-sections-${financialYear}","deduction-section-heads-${financialYear}","deduction-section-maxallowed-${financialYear}"},
accessKey={"deduction_sections","deduction_section_heads","deduction_section_maxallowed"})
public class XmlGenerator extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(XmlGenerator.class);
	ITRXmlGeneratorServiceFactory itrXmlGeneratorServiceFactory = null;
	String servletPath = null;
	String xsltPath = null;

	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		itrXmlGeneratorServiceFactory = context.getBean(com.mootly.wcm.services.ITRXmlGeneratorServiceFactory.class);
		xsltPath = servletContext.getRealPath("/xslt/ITRSummary.xsl");
	}
	//DecimalFormat decimalFormat=new DecimalFormat("#.#");
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		boolean isDownload = false;
		String whtToDownload = null; //I HATE IT use ENUM
		super.doBeforeRender(request, response);
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		String ITR = memberPersonalInformation.getFlexField("flex_string_ITRForm", "");
		request.setAttribute("ITR", ITR);

		if (getPublicRequestParameter(request, "show") != null) request.setAttribute("show",getPublicRequestParameter(request, "show"));
		if (getPublicRequestParameter(request, "download") != null) {
			request.setAttribute("download",getPublicRequestParameter(request, "download"));
			isDownload = true;
			if (getPublicRequestParameter(request, "xml") != null) {
				whtToDownload = "xml";
			}
			else {
				whtToDownload = "pdf";
			}
		}
		//simple test
		ITRForm whichITRForm = ITRForm.getEnumByDisplayName(getLocalParameter("formName", request));
		if (whichITRForm.equals(ITRForm.UNKNOWN)) {
			whichITRForm = ITRForm.ITR1;
		}
		//time to hand over
		if (itrXmlGeneratorServiceFactory != null) {
			XmlGeneratorService xmlGeneratorService = itrXmlGeneratorServiceFactory.getInstance(getFinancialYear());
			if (xmlGeneratorService != null) {
				try {
					xmlGeneratorService.generateXml(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.error("Error in generating XML",e);
				}
			}
		}
		//now lets check if we have theForm
		//lets attempt a PDF
		if (isDownload && whtToDownload != null && whtToDownload.equals("pdf")) {
			try {
				String xml = (String) request.getAttribute("xml");
				DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				InputSource is = new InputSource(new StringReader(xml));
				org.w3c.dom.Document aDom = db.parse(is);
				FileInputStream fi = new FileInputStream(xsltPath);
				StreamSource stylesource = new StreamSource(fi); 
				Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
				StringWriter sw = new StringWriter();
				StreamSource sSource = new StreamSource(new StringReader(xml));
				StreamResult sResult = new StreamResult(sw);
				transformer.transform(sSource,sResult);
				fi.close();


				String theHTML = sw.toString();
				if (log.isInfoEnabled()) {
					log.info(theHTML);
				}
				Document document = new Document();
				String tmpDir = System.getProperty("java.io.tmpdir");
				String uuid = UUID.randomUUID().toString();
				String filePath = tmpDir + "/" + uuid + ".pdf";
				request.setAttribute("filePath", filePath);
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
				writer.setInitialLeading(12.5f);
				document.open();
				XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(theHTML));
				document.close();
				writer.close();


				if (isDownload) {
					request.setAttribute("fileName", "itReturnSummary.pdf");
					response.setRenderPath("jsp/member/downloadfile.jsp");
				}
				//now we have the BYTES, this can be used, but we need to be careful the SERVER may get overload, we can use tmp file for this
				//laterz
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block

				log.error("Error during parsing configuration"+e);
			} catch (FactoryConfigurationError e) {
				// TODO Auto-generated catch block

				log.error("Error factory configuration"+e);
			} catch (SAXException e) {
				// TODO Auto-generated catch block

				log.error("Error from sax exceptions"+e);
			} catch (IOException e) {
				// TODO Auto-generated catch block

				log.error("Error from IO exceptions"+e);
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block

				log.error("Transforming  exceptions"+e);
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block

				log.error("Transforming factory exceptions"+e);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block

				log.error("Transformer exceptions"+e);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block

				log.error("Document  exceptions"+e);
			}
		}
		else if (isDownload && whtToDownload != null && whtToDownload.equals("xml")) {
			if (isDownload) {
				request.setAttribute("fileName", "itReturnXML.xml");
				response.setRenderPath("jsp/member/downloadfile.jsp");				
			}			
		}
		//Object theForm = request.getAttribute("theForm");
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}
