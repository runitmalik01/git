package com.mootly.wcm.services.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ValidationResponse;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.XmlGeneratorService;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class ITRXmlGeneratorService extends ITRXmlGeneratorServiceCommon  implements XmlGeneratorService {
	DocumentBuilder parser = null;
	SchemaFactory factory = null;
	Schema schema = null;
	Validator validator = null;

	private static Logger log = LoggerFactory.getLogger(ITRXmlGeneratorService.class);

	@Override
	public String generateXml(HstRequest request,HstResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.generateXml(request, response);
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR1")){
			return ITR1XmlGeneratorService.generateITR1(request, response);
		}
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR2")){
			return ITR2XmlGeneratorService.generateITR2(request, response);
		}
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR4S")){
			return ITR4SXmlGeneratorService.generateITR4S(request, response);
		}
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR4")){
			return ITR4XmlGeneratorService.generateITR4(request, response);
		}
		return null;
	}

	@Override
	public Map<String,Object> generateXml(FinancialYear financialYear,
			Map<String, HippoBean> inputBeans) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> returnMap = null;
		super.generateXml(financialYear, inputBeans);
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR1")){
			returnMap = ITR1XmlGeneratorService.generateITR1(financialYear, inputBeans);
		}
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR2")){
			returnMap = ITR2XmlGeneratorService.generateITR2(financialYear, inputBeans);
		}
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR4S")){
			returnMap = ITR4SXmlGeneratorService.generateITR4S(financialYear, inputBeans);
		}
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR4")){
			returnMap = ITR4XmlGeneratorService.generateITR4(financialYear, inputBeans);
		}

		return returnMap;
	}

	@Override
	public String getConsolidateReturnsToBulk(List<Object> listOfItrForms) {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ITR.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			NamespacePrefixMapper prefixMapper = new ITRPrefixMapper();
			jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", prefixMapper);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://incometaxindiaefiling.gov.in/main ITRMain13.xsd");
			ITR itReturn = new ITR();
			for (Object anObj:listOfItrForms) {
				if (anObj instanceof ITR1) {
					itReturn.getITR1().add((ITR1)anObj);
				}
			}
			jaxbMarshaller.marshal(itReturn, sw);
			//request.setAttribute("xml",sw.toString());
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Unmarshaller validateXmlGetUnmarshaller() throws Exception {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		sf.setResourceResolver(new ClasspathResourceResolver());
		InputStream inputStream1= this.getClass().getClassLoader().getResourceAsStream("in/gov/incometaxindiaefiling/y2012_2013/ITRMain13.xsd");

		Source streamSource = new StreamSource(inputStream1);
        Schema schema = sf.newSchema(streamSource);

        JAXBContext jc = JAXBContext.newInstance(ITR.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);

        return unmarshaller;

	}

	public ValidationEventHandler validateXmlSetValidationEventHandler(Unmarshaller unmarshaller) throws Exception {
		MyValidationEventHandler myValidationHandler = new MyValidationEventHandler();
	    unmarshaller.setEventHandler(myValidationHandler);
	    return myValidationHandler;
	}

	public ValidationResponse validateXmlGetErrors(Unmarshaller unmarshaller) throws Exception {
		MyValidationEventHandler myValidationHandler = (MyValidationEventHandler) unmarshaller.getEventHandler();
		ValidationResponse vr = new ValidationResponse();
	    vr.setValid(!myValidationHandler.hasError());
        vr.setErrors(myValidationHandler.getAllErrors());

        return vr;
	}

	@Override
	public ValidationResponse validateXml(InputStream inputStream)
			throws Exception {
		// TODO Auto-generated method stub
		Unmarshaller unmarshaller = validateXmlGetUnmarshaller();
		validateXmlSetValidationEventHandler(unmarshaller);
		ITR itr = (ITR) unmarshaller.unmarshal(inputStream);
		ValidationResponse validationResponse = validateXmlGetErrors(unmarshaller);
		return validationResponse;
	}

	@Override
	public ValidationResponse validateXml(String xml) throws Exception {
		Unmarshaller unmarshaller = validateXmlGetUnmarshaller();
		validateXmlSetValidationEventHandler(unmarshaller);
		ITR itr = (ITR) unmarshaller.unmarshal(new StringReader(xml));
		ValidationResponse validationResponse = validateXmlGetErrors(unmarshaller);
		return validationResponse;
	}
	
	@Override
	public ValidationResponse validateXmlCorp(InputStream inputStream)
			throws Exception {
		// TODO Auto-generated method stub
		Unmarshaller unmarshaller = validateXmlGetUnmarshallerCorp();		
		validateXmlSetValidationEventHandler(unmarshaller);
		in.gov.incometaxindiaefiling.y2012_2013.corp.ITR itr = (in.gov.incometaxindiaefiling.y2012_2013.corp.ITR) unmarshaller.unmarshal(inputStream);
		ValidationResponse validationResponse = validateXmlGetErrors(unmarshaller);
		return validationResponse;
	}
	
	@Override
	public ValidationResponse validateXmlCorp(String xml) throws Exception {			
		Unmarshaller unmarshaller = validateXmlGetUnmarshallerCorp();		
		validateXmlSetValidationEventHandler(unmarshaller);
		in.gov.incometaxindiaefiling.y2012_2013.corp.ITR itr = (in.gov.incometaxindiaefiling.y2012_2013.corp.ITR) unmarshaller.unmarshal(new StringReader(xml));
		ValidationResponse validationResponse = validateXmlGetErrors(unmarshaller);
		return validationResponse;
	}
	
	public Unmarshaller validateXmlGetUnmarshallerCorp() throws Exception {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		sf.setResourceResolver(new ClasspathResourceResolver());
		InputStream inputStream1= this.getClass().getClassLoader().getResourceAsStream("in/gov/incometaxindiaefiling/y2012_2013/CorpITRMain13.xsd");
		
		Source streamSource = new StreamSource(inputStream1);
        Schema schema = sf.newSchema(streamSource); 
 
        JAXBContext jc = JAXBContext.newInstance(in.gov.incometaxindiaefiling.y2012_2013.corp.ITR.class);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        
        return unmarshaller;
      
	}


	/**
	* This is an implementation of LSResourceResolver that can resolve XML schemas from the classpath
	*/
	private class ClasspathResourceResolver implements LSResourceResolver {
		private DOMImplementationLS domImplementationLS;
		Logger logger= LoggerFactory.getLogger(ClasspathResourceResolver.class);

		private ClasspathResourceResolver() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
			//System.setProperty(DOMImplementationRegistry.PROPERTY, "org.apache.xerces.dom.DOMImplementationSourceImpl");
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			domImplementationLS = (DOMImplementationLS) registry.getDOMImplementation("LS");
		}

		public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId,String baseURI) {
			logger.info("==== Resolving '" + type + "' '" + namespaceURI + "' '" + publicId + "' '" + systemId + "' '" + baseURI + "'");

			LSInput lsInput = domImplementationLS.createLSInput();
			if (systemId.contains("master")) {
				log.debug("STOP");
			}
			String whatToSearch = systemId;
			//if ( systemId != null && systemId.startsWith("./")) whatToSearch = systemId.substring(2);
			if ( systemId != null && systemId.startsWith("./")) whatToSearch = systemId.substring(2);
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("in/gov/incometaxindiaefiling/y2012_2013/" + whatToSearch);//getClass().getResourceAsStream("/" + systemId);
			if (is == null) {
				System.out.println("STOP");
			}
			else {
				lsInput.setByteStream(is);
				lsInput.setSystemId(systemId);
			}
			return lsInput;
		}
	}

	public class MyValidationEventHandler implements ValidationEventHandler {
		StringBuffer allErrors = new StringBuffer();

		public boolean hasError() {
			return ((allErrors == null || allErrors.length() == 0) ? false : true );
		}

		public String getAllErrors() {
			return allErrors.toString();
		}

	    public boolean handleEvent(ValidationEvent event) {
	    	String lineSeparator = System.getProperty("line.separator");

	    	allErrors.append("EVENT").append(lineSeparator).append(lineSeparator);
	        allErrors.append("SEVERITY:  " + event.getSeverity()).append(lineSeparator);
	        allErrors.append("MESSAGE:  " + event.getMessage()).append(lineSeparator);
	        allErrors.append("LINKED EXCEPTION:  " + event.getLinkedException()).append(lineSeparator);
	        allErrors.append("LOCATOR").append(lineSeparator);
	        allErrors.append("    LINE NUMBER:  " + event.getLocator().getLineNumber()).append(lineSeparator);
	        allErrors.append("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber()).append(lineSeparator);
	        allErrors.append("    OFFSET:  " + event.getLocator().getOffset()).append(lineSeparator);
	        allErrors.append("    OBJECT:  " + event.getLocator().getObject()).append(lineSeparator);
	        allErrors.append("    NODE:  " + event.getLocator().getNode()).append(lineSeparator);
	        allErrors.append("    URL:  " + event.getLocator().getURL()).append(lineSeparator);

	        return true;
	    }

	}
}


