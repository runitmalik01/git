package com.mootly.wcm.services.ditws.soap;

import javax.xml.namespace.QName;

public class SOAPCallElementAttribute {
	final QName name;
	final String value;
	
	public SOAPCallElementAttribute(QName name,String value) {
		this.name = name;
		this.value = value;
	}

	public QName getName() {
		return name;
	}

	public String getValue() {
		return value;
	}	
	
}
