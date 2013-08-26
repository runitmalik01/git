package com.mootly.wcm.services.citruspay.impl;

import java.net.HttpURLConnection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.model.TransactionInput;
import com.mootly.wcm.services.http.HTTPConnectionException;
import com.mootly.wcm.services.http.HTTPConnectionService;

/**
 * Final Implementation of Transaction Service
 * @author admin
 *
 */
public class TransactionServiceImpl extends PaymentServiceXML implements Transaction, ApplicationContextAware {
	
	final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	//XPath xPath;
	ApplicationContext applicationContext;
	HTTPConnectionService httpConnectionService;
	
	public final HTTPConnectionService getHttpConnectionService() {
		return httpConnectionService;
	}

	public final void setHttpConnectionService(
			HTTPConnectionService httpConnectionService) {
		this.httpConnectionService = httpConnectionService;
	}

	private Map<String, Object> acceptITRPayment(TransactionInput transactionInput) {
		return null;
	}
	
	public HttpURLConnection getHttpUrlConnection() {
		return (HttpURLConnection) applicationContext.getBean("transactionServiceHTTPConnection");
	}
	
	
	@Override
	public Map<String, Object> acceptITRPaymentByDebitOrCreditCard(
			String memberLoginName, FinancialYear financialYear, String PAN,
			String returnURL,String notifyURL,
			PAYMENT_MODE paymentNode, String cardHolderName, String cardNumber,
			CARD_TYPE cardType, String cvvNumber, String expiryMonth,
			String expiryYear, String amount, String email, String firstName,
			String lastName, String mobile,String address, String addressCity,String addressState, String addressZip) {
		// TODO Auto-generated method stub
		String merchantTxId = newMerchantTxnId();
		String hMacSignature = getHMACSignature(merchantTxId, amount);
		
		Map<String,String> headers = getHeaders(hMacSignature);
		//lets make the body
		TransactionInput transactionInput = new TransactionInput();
		transactionInput.setMerchantTxnId(merchantTxId);
		transactionInput.setPaymentMode(paymentNode.name());
		transactionInput.setCardHolderName(cardHolderName);
		transactionInput.setCardNumber(cardNumber);
		transactionInput.setCardType(cardType.name());
		transactionInput.setCvvNumber(cvvNumber);
		transactionInput.setExpiryMonth(expiryMonth);
		transactionInput.setExpiryYear(expiryYear);
		transactionInput.setAmount(amount);
		transactionInput.setFirstName(firstName);
		transactionInput.setLastName(lastName);
		transactionInput.setEmail(email);
		
		transactionInput.setMobile(mobile);
		
		transactionInput.setAddress(address);
		transactionInput.setAddressCity(addressCity);
		transactionInput.setAddressState(addressState);
		transactionInput.setAddressZip(addressZip);
		
		transactionInput.setReturnUrl(returnURL);
		//transactionInput.setNotifyUrl(notifyURL);
		
		
		String xml = transactionInput.convertToXML();
		if (logger.isInfoEnabled()) {
			logger.info("transactionInput.toXML() " + xml);
		}
		try {
			String returnXml = httpConnectionService.doPost(headers, xml, getHttpUrlConnection());
		} catch (HTTPConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error in doPost",e);
		}
		return null;
	}
	
	/**
	 * //create transaction or chanrge
		//sample xml request for net banking: 
		 * <createTransactionRequest>
		 * <merchantTxnId>t12345t1</merchantTxnId>
		 * <amount>1.0</amount>
		 * <firstName>Test</firstName>
		 * <lastName>Test</lastName>
		 * <address>Test</address>
		 * <addressCity>Pune</addressCity>
		 * <addressState>Goa</addressState>
		 * <addressZip>123456</addressZip>
		 * <email>test@test.com</email>
		 * <mobile>1234567890</mobile>
		 * <paymentMode>NET_BANKING</paymentMode>
		 * <issuerCode>CID009</issuerCode>
		 * <returnUrl>http://127.0.0.1:8080/Kit-Test/jsp/TestMotoResponse.jsp</returnUrl>
		 * <notifyUrl>http://127.0.0.1:8080/Kit-Test/jsp/TestNotifyResponse.jsp</notifyUrl>
		 * </createTransactionRequest>
	 */
	
	@Override
	public Map<String, Object> acceptITRPaymentByNetBanking(
			String memberLoginName, FinancialYear financialYear, String PAN,
			String returnURL,String notifyURL,
			BANK_ISSUER bankIssuer, String amount, String email,
			String firstName, String lastName, String mobile,String address, String addressCity,String addressState, String addressZip) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String merchantTxId = newMerchantTxnId();
		String hMacSignature = getHMACSignature(merchantTxId, amount);
		
		Map<String,String> headers = getHeaders(hMacSignature);
		//lets make the body
		TransactionInput transactionInput = new TransactionInput();
		transactionInput.setMerchantTxnId(merchantTxId);		
		transactionInput.setAmount(amount);
		transactionInput.setFirstName(firstName);
		transactionInput.setLastName(lastName);
		
		transactionInput.setAddress(address);
		transactionInput.setAddressCity(addressCity);
		transactionInput.setAddressState(addressState);
		transactionInput.setAddressZip(addressZip);
		
		transactionInput.setPaymentMode(PAYMENT_MODE.NET_BANKING.name());
		transactionInput.setIssuerCode(bankIssuer.getIssuerCode());
		
		transactionInput.setEmail(email);
		transactionInput.setMobile(mobile);
		
		transactionInput.setReturnUrl(returnURL);
		transactionInput.setNotifyUrl(notifyURL);
		
		String xml = transactionInput.convertToXML();	
		if (logger.isInfoEnabled()) {
			logger.info("transactionInput.toXML() " + xml);
		}
		try {
			String returnXml = httpConnectionService.doPost(headers, xml, getHttpUrlConnection());
		} catch (HTTPConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error in doPost",e);
		}
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
	
	
	
}