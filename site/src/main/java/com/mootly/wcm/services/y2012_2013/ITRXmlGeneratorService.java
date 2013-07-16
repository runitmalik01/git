package com.mootly.wcm.services.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;

import java.io.File;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.model.ValidationResponse;
import com.mootly.wcm.services.ITR1XmlGeneratorService;
import com.mootly.wcm.services.ITR2XmlGeneratorService;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.XmlGeneratorService;

public class ITRXmlGeneratorService extends ITRXmlGeneratorServiceCommon  implements XmlGeneratorService {
	DocumentBuilder parser = null;
	SchemaFactory factory = null;
	Schema schema = null;
	Validator validator = null;
	
	private static Logger log = LoggerFactory.getLogger(ITRXmlGeneratorService.class);
	@Override
	public void generateXml(HstRequest request,HstResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.generateXml(request, response);
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR1")){
			ITR1XmlGeneratorService.generateITR1(request, response);
		}
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR2")){
			ITR2XmlGeneratorService.generateITR2(request, response);
		}
	}
	
	public void validateXmlCommon(String xml) throws Exception {
		
	}
	
	@Override
	public ValidationResponse validateXml(String xml) throws Exception {
		ValidationResponse vr = new ValidationResponse();
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		sf.setResourceResolver(new ClasspathResourceResolver());
		InputStream inputStream1= this.getClass().getClassLoader().getResourceAsStream("in/gov/incometaxindiaefiling/y2012_2013/ITRMain13.xsd");
		
		Source streamSource = new StreamSource(inputStream1);
        Schema schema = sf.newSchema(streamSource); 
 
        JAXBContext jc = JAXBContext.newInstance(ITR.class);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        MyValidationEventHandler myValidationHandler = new MyValidationEventHandler();
        unmarshaller.setEventHandler(myValidationHandler);
        
        ITR theObject = (ITR) unmarshaller.unmarshal(new StringReader(xml));
        
        vr.setValid(!myValidationHandler.hasError());
        vr.setErrors(myValidationHandler.getAllErrors());
        
        //if (myValidationHandler != null && myValidationHandler.hasError()) {
        //	System.out.println(myValidationHandler.getAllErrors());
        //}
        //System.out.println("STOP");
        
        return vr;
		
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


