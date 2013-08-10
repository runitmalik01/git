package com.mootly.wcm.services.ditws.soap;

import java.io.Serializable;
import java.util.List;

public class SOAPCallElement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4458872356563496687L;
	String name;
	String nsPrefix;
	String ns;
	String value;
	String xsiType;
	public SOAPCallElementType soapCallElementType;
	List<SOAPCallElementAttribute> soapCallElementAttributes;
	
	public SOAPCallElement(SOAPCallElementType soapCallElementType) {
		this.soapCallElementType = soapCallElementType;
		this.name = null;
		this.nsPrefix = null;
		this.ns=null;
		this.value =null;
	}
	
	public SOAPCallElement(SOAPCallElementType soapCallElementType,String name,String nsPrefix,String ns,String value) {
		this.soapCallElementType = soapCallElementType;
		this.name = name;
		this.nsPrefix = nsPrefix;
		this.ns=ns;
		this.value = value;
	}
	
	public SOAPCallElement(SOAPCallElementType soapCallElementType,String name,String value) {
		this.soapCallElementType = soapCallElementType;
		this.name = name;
		this.value = value;
	}
	
	
	public List<SOAPCallElementAttribute> getSoapCallElementAttributes() {
		return soapCallElementAttributes;
	}

	public void setSoapCallElementAttributes(
			List<SOAPCallElementAttribute> soapCallElementAttributes) {
		this.soapCallElementAttributes = soapCallElementAttributes;
	}

	public SOAPCallElementType getSoapCallElementType() {
		return soapCallElementType;
	}

	public void setSoapCallElementType(SOAPCallElementType soapCallElementType) {
		this.soapCallElementType = soapCallElementType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNsPrefix() {
		return nsPrefix;
	}

	public void setNsPrefix(String nsPrefix) {
		this.nsPrefix = nsPrefix;
	}

	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getXsiType() {
		return xsiType;
	}

	public void setXsiType(String xsiType) {
		this.xsiType = xsiType;
	}
	
	
}
