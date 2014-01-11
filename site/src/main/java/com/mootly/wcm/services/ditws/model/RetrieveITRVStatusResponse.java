package com.mootly.wcm.services.ditws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.mootly.wcm.services.citruspay.model.XMLObject;

//<ns2:result><![CDATA[<STATUSRESPONSE><STATUS><PAN>AWBPR0486J</PAN><ACK>860562120080114</ACK><MESSAGE>Success</MESSAGE><ERROR_CODE>null</ERROR_CODE><ERROR_MESSAGE>null</ERROR_MESSAGE></STATUS></STATUSRESPONSE>]]></ns2:result>

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "PAN",
    "ack",
    "message",
    "errorCode",
    "errorMessage"
})
@XmlRootElement( name = "STATUS" )
public class RetrieveITRVStatusResponse extends XMLObject{
	@XmlElement(name="PAN")
	String PAN;
	@XmlElement(name="ACK")
	String ack;
	@XmlElement(name="MESSAGE")
	String message;
	@XmlElement(name="ERROR_CODE")
	String errorCode;
	@XmlElement(name="ERROR_MESSAGE")
	String errorMessage;
	
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public String getAck() {
		return ack;
	}
	public void setAck(String ack) {
		this.ack = ack;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
