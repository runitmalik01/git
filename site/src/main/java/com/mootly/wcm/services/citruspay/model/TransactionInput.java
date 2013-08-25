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
    "paymentMode",
    "issuerCode",
    "merchantTxnId",
    "amount",
    "firstName",
    "lastName",
    "address",
    "addressCity",
    "addressState",
    "addressZip",
    "email",
    "mobile",
    "cardType",
    "cardNumber",
    "cardHolderName",
    "expiryMonth",
    "expiryYear",
    "cvvNumber",
    "returnUrl",
    "notifyUrl"
})
@XmlRootElement( name = "createTransactionRequest" )
public class TransactionInput  extends XMLObject  {
	@XmlElement(name = "paymentMode", required = true)
	String paymentMode;
	@XmlElement(name = "issuerCode", required = false)
	String issuerCode;	
	@XmlElement(name = "merchantTxnId", required = false)
	String merchantTxnId;
	@XmlElement(name = "amount", required = false)
	String amount;
	@XmlElement(name = "email", required = false)
	String email;
	@XmlElement(name = "firstName", required = false)
	String firstName;
	@XmlElement(name = "lastName", required = false)
	String lastName;
	@XmlElement(name = "mobile", required = false)
	String mobile;
	@XmlElement(name = "address", required = false)
	String address;
	@XmlElement(name = "addressCity", required = false)
	String addressCity;
	@XmlElement(name = "addressState", required = false)
	String addressState;
	@XmlElement(name = "addressZip", required = false)
	String addressZip;
	@XmlElement(name = "cardHolderName", required = false)
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
	
	@XmlElement(name = "returnUrl", required = false)
	String returnUrl;
	
	@XmlElement(name = "notifyUrl", required = false)
	String notifyUrl;
	
	public final String getPaymentMode() {
		return paymentMode;
	}
	public final void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public final String getIssuerCode() {
		return issuerCode;
	}
	public final void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}
	public final String getMerchantTxnId() {
		return merchantTxnId;
	}
	public final void setMerchantTxnId(String merchantTxnId) {
		this.merchantTxnId = merchantTxnId;
	}
	public final String getAmount() {
		return amount;
	}
	public final void setAmount(String amount) {
		this.amount = amount;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getFirstName() {
		return firstName;
	}
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public final String getLastName() {
		return lastName;
	}
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public final String getMobile() {
		return mobile;
	}
	public final void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	public final String getAddressCity() {
		return addressCity;
	}
	public final void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public final String getAddressState() {
		return addressState;
	}
	public final void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public final String getAddressZip() {
		return addressZip;
	}
	public final void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	public final String getCardHolderName() {
		return cardHolderName;
	}
	public final void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public final String getCardNumber() {
		return cardNumber;
	}
	public final void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public final String getCardType() {
		return cardType;
	}
	public final void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public final String getCvvNumber() {
		return cvvNumber;
	}
	public final void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public final String getExpiryMonth() {
		return expiryMonth;
	}
	public final void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public final String getExpiryYear() {
		return expiryYear;
	}
	public final void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public final String getReturnUrl() {
		return returnUrl;
	}
	public final void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public final String getNotifyUrl() {
		return notifyUrl;
	}
	public final void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
}
