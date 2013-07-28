package com.mootly.wcm.services.y2012_2013;

public class ITRPrefixMapper extends com.sun.xml.bind.marshaller.NamespacePrefixMapper {
	@Override
	public String getPreferredPrefix(String namespaceUri,
			String suggestion,
			boolean requirePrefix) {
		// TODO Auto-generated method stub
		if (namespaceUri.equals("http://incometaxindiaefiling.gov.in/ITR1")) {
			return "ITR1FORM";
		}
		else if (namespaceUri.equals("http://incometaxindiaefiling.gov.in/ITR2")) {
			return "ITR2FORM";
		}
		else if (namespaceUri.equals("http://incometaxindiaefiling.gov.in/ITR3")) {
			return "ITR3FORM";
		}
		else if (namespaceUri.equals("http://incometaxindiaefiling.gov.in/ITR4")) {
			return "ITR4FORM";
		}
		else if (namespaceUri.equals("http://incometaxindiaefiling.gov.in/ITR4S")) {
			return "ITR4SFORM";
		}
		else if (namespaceUri.equals("http://incometaxindiaefiling.gov.in/main")) {
			return "ITRETURN";
		}
		else if (namespaceUri.equals("http://incometaxindiaefiling.gov.in/master")) {
			return "ITRForm";
		}
		else if (namespaceUri.equals("http://www.w3.org/2001/XMLSchema-instance")) {
			return "xsi";
		}
		else if (namespaceUri.equals("") || !requirePrefix) {
			return "ITRForm";
		}
		return suggestion;
	}
}
