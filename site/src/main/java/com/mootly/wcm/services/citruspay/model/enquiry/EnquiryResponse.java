package com.mootly.wcm.services.citruspay.model.enquiry;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.Transaction.ENQUIRY_RESP_CODE;
import com.mootly.wcm.services.citruspay.model.XMLObject;

/*
 * //create transaction or chanrge
//sample xml request for net banking: 
 * <createTransactionRequest><merchantTxnId>t12345t1</merchantTxnId><amount>1.0</amount><firstName>Test</firstName><lastName>Test</lastName><address>Test</address>
//<addressCity>Pune</addressCity><addressState>Goa</addressState><addressZip>123456</addressZip><email>test@test.com</email><mobile>1234567890</mobile><paymentMode>NET_BANKING</paymentMode>
//<issuerCode>CID009</issuerCode><returnUrl>http://127.0.0.1:8080/Kit-Test/jsp/TestMotoResponse.jsp</returnUrl><notifyUrl>http://127.0.0.1:8080/Kit-Test/jsp/TestNotifyResponse.jsp</notifyUrl></createTransactionRequest>
//signature text for above request: merchantAccessKey=HS6Q0E1N40OUSYCJXMX5&transactionId=t12345t1&amount=1.0
// sample response:
//<?xml version="1.0" encoding="UTF-8" standalone="yes"?><createTransactionResponse><redirectUrl>https://14.140.42.101/mpi/PaymentMoto.jsp?txnId=0ED2C23B210DF56A9F69C92426F32EB2245575E72B94C8E8</redirectUrl>
//</createTransactionResponse> 
//Note: For Moto Integration redirect to the redirectUrl
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "respCode",
    "respMsg",
    "txnId",
    "pgTxnId",
    "authIdCode",
    "RRN",
    "txnType",
    "amount",
    "txnDateTime",
    "paymentMode",
    "maskedCardNumber",
    "txnGateway",
    "issuerCode",
    "cardType",
    "cvRespCode"
})
@XmlRootElement( name = "enquiryResponse" )
public class EnquiryResponse extends XMLObject {
	@XmlElement(name = "respCode", required = false)
	String respCode;
	@XmlElement(name = "respMsg", required = false)
	String respMsg;
	@XmlElement(name = "txnId", required = false)
	String txnId;
	@XmlElement(name = "pgTxnId", required = false)
	String pgTxnId;
	@XmlElement(name = "authIdCode", required = false)
	String authIdCode;
	@XmlElement(name = "RRN", required = false)
	String RRN;
	@XmlElement(name = "txnType", required = false)
	String txnType;
	@XmlElement(name = "amount", required = false)
	String amount;
	@XmlElement(name = "txnDateTime", required = false)
	String txnDateTime;
	@XmlElement(name = "paymentMode", required = false)
	String paymentMode;
	@XmlElement(name = "maskedCardNumber", required = false)
	String maskedCardNumber;
	
	@XmlElement(name = "txnGateway", required = false)
	String txnGateway;
	
	@XmlElement(name = "issuerCode", required = false)
	String issuerCode;
	
	@XmlElement(name = "cardType", required = false)
	String cardType;
	
	@XmlElement(name = "cvRespCode", required = false)
	String cvRespCode;

	public final Transaction.ENQUIRY_RESP_CODE getRespCode() {
		if (respCode != null) {
			try {
				return ENQUIRY_RESP_CODE.getByCode(respCode);
			}catch (IllegalArgumentException e) {
				
			}
		}
		return null;
	}

	public final String getRespMsg() {
		return respMsg;
	}

	public final String getTxnId() {
		return txnId;
	}

	public final String getPgTxnId() {
		return pgTxnId;
	}

	public final String getAuthIdCode() {
		return authIdCode;
	}
	
	public final String getRRN() {
		return RRN;
	}
	

	public final String getTxnType() {
		return txnType;
	}

	public final String getAmount() {
		return amount;
	}

	public final String getTxnDateTime() {
		return txnDateTime;
	}

	public final PaymentType getPaymentType() {
		if (paymentMode != null) {
			try {
				return PaymentType.valueOf(paymentMode);
			}catch (IllegalArgumentException e) {
				
			}
		}
		return null;
	}

	public final String getMaskedCardNumber() {
		return maskedCardNumber;
	}

	public final String getTxnGateway() {
		return txnGateway;
	}

	public final String getIssuerCode() {
		return issuerCode;
	}

	public final String getCardType() {
		return cardType;
	}
	
	public final String getCvRespCode() {
		return cvRespCode;
	}

	public final void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public final void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public final void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public final void setPgTxnId(String pgTxnId) {
		this.pgTxnId = pgTxnId;
	}

	public final void setAuthIdCode(String authIdCode) {
		this.authIdCode = authIdCode;
	}

	public final void setRRN(String rRN) {
		RRN = rRN;
	}

	public final void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public final void setAmount(String amount) {
		this.amount = amount;
	}

	public final void setTxnDateTime(String txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	public final void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public final void setMaskedCardNumber(String maskedCardNumber) {
		this.maskedCardNumber = maskedCardNumber;
	}

	public final void setTxnGateway(String txnGateway) {
		this.txnGateway = txnGateway;
	}

	public final void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}

	public final void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public final void setCvRespCode(String cvRespCode) {
		this.cvRespCode = cvRespCode;
	}
	
}
