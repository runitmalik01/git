package com.mootly.wcm.services.ditws.soap;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPFault;


/**
 * 
 * @author amit.patkar
 */
public abstract class SOAPResponseBase {
	
	String soapFaultString; //when Consona makes a call to FMW
	String soapFaultCode; //when Consona makes a call to FMW
	SOAPFault soapFault; //when Consona makes a call to FMW
	
	String fmwResponseStatus;
	String fmwErrorCode; // FMW will return this
	String fmwErrorMessage; // FMW will return this
	String fmwErrorSummary; // FMW will return this
	
	String fmwFaultCode;
	String fmwFaultSummary;
	String fmwFaultDetail;	

	SOAPBody soapBody;
	
	static final String  ERROR_SCHEMA_NS_URI="http://www.vmware.com/middleware/error/schemas";
	
	boolean exceptionInParsing = false;
	String parsingExceptionMessage = null;
	
	public SOAPResponseBase(SOAPBody soapBody) {		
		this.soapBody = soapBody;
		parseSoapBody();
	}
		
	public boolean isError() {
		if (fmwErrorCode != null || fmwErrorMessage != null || fmwFaultCode != null || shouldRetry()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean shouldRetry() {
		if (exceptionInParsing || soapFault != null || isSystemError()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public abstract boolean isSystemError();
	
	public String getErrorMessage() {
		//need to send Retry Reason 
		if (exceptionInParsing) {
			return parsingExceptionMessage;
		}
		else if  (soapFault != null) {
			return soapFault.toString();
		}
		else if (fmwErrorMessage != null) {
			return fmwErrorMessage;
		}
		else if (fmwErrorCode != null) {
			return fmwErrorCode;
		}
		else if (fmwFaultCode != null) {
			return fmwFaultCode;
		}
		else{
			return "REASON UNKNOWN";
		}
	}
	
	
	protected void parseSoapBody () {
		try {
			soapFault =soapBody.getFault();
			if (soapFault != null) {
				soapFaultString = soapFault.toString();
				soapFaultCode = soapFault.getFaultCode();				
			}			
			else {
				
				
			}
		}catch (Exception ex) {
			//any error here will result in error
			exceptionInParsing = true;	
			parsingExceptionMessage = ex.getMessage();
		}
	}

	public String getFmwErrorCode() {
		return fmwErrorCode;
	}

	public void setFmwErrorCode(String fmwErrorCode) {
		this.fmwErrorCode = fmwErrorCode;
	}		
	
	
}
