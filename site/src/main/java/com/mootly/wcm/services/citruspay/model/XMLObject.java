package com.mootly.wcm.services.citruspay.model;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;


public class XMLObject {
	
	public static <T extends XMLObject> T loadFromXml(String xmlInput,T objectClass) throws JAXBException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        JAXBContext jc = JAXBContext.newInstance(objectClass.getClass());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        T theObjectInstance =  (T) unmarshaller.unmarshal(new StringReader(xmlInput));
        return theObjectInstance;
	}
	
	
	
	public String convertToXML() {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			//NamespacePrefixMapper prefixMapper = new ITRPrefixMapper();
			//jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", prefixMapper);
			jaxbMarshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
			//jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://incometaxindiaefiling.gov.in/main ITRMain13.xsd");			
			jaxbMarshaller.marshal(this, sw);
			//request.setAttribute("xml",sw.toString());
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
		
	}
}
