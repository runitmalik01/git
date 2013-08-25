package com.mootly.wcm.services.citruspay.model;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class XMLObject {
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
