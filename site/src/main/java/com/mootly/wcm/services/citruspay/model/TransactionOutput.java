package com.mootly.wcm.services.citruspay.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
    "txId",
    "txRefNo",
    "pgTxnNo",
    "txStatus",
    "amount",
    "txMsg",
    "firstName",
    "lastName",
    "mobile",
    "address",
    "addressCity",
    "addressState",
    "addressZip",
    "cardHolderName",
    "cardNumber",
    "cardType",
    "cvvNumber",
    "expiryMonth",
    "expiryYear"
})
@XmlRootElement( name = "createTransactionResponse" )
public class TransactionOutput extends XMLObject {
	@XmlElement(name = "txId", required = true)
	String txId;
	@XmlElement(name = "txRefNo", required = false)
	String txRefNo;	
	@XmlElement(name = "pgTxnNo", required = false)
	String pgTxnNo;
	@XmlElement(name = "txStatus", required = false)
	String txStatus;
	@XmlElement(name = "amount", required = false)
	String amount;
	@XmlElement(name = "txMsg", required = false)
	String txMsg;
	@XmlElement(name = "firstName", required = false)
	String firstName;
	@XmlElement(name = "lastName", required = false)
	String lastName;
	@XmlElement(name = "email", required = false)
	String email;
	@XmlElement(name = "addressStreet1", required = false)
	String addressCity;
	@XmlElement(name = "addressCity", required = false)
	String addressState;
	@XmlElement(name = "mobileNo", required = false)
	String addressZip;
	@XmlElement(name = "signature", required = false)
	String cardHolderName;
	@XmlElement(name = "cardNumber", required = false)
	String cardNumber;
	@XmlElement(name = "cardType", required = false)
	String cardType;
	@XmlElement(name = "cvvNumber", required = false)
	String cvvNumber;
	@XmlElement(name = "expiryMonth", required = false)
	String expiryMonth;
	@XmlElement(name = "expiryYear", required = false)
	String expiryYear;
	
}
