package com.mootly.wcm.services.citruspay;

import java.util.Map;

import com.mootly.wcm.model.FinancialYear;

public interface Transaction extends PaymentService {
	public static enum PAYMENT_MODE {NET_BANKING,CREDIT_CARD, DEBIT_CARD};
	public static enum CARD_TYPE {VISA,MCRD, MTRO};
	
	Map<String,Object> acceptITRPaymentByNetBanking(String memberLoginName, FinancialYear financialYear, String PAN,
			String returnURL,String notifyURL,
			BANK_ISSUER bankIssuer, String amount, String email,
			String firstName, String lastName, String mobile,String address, String addressCity,String addressState, String addressZip);
	Map<String,Object> acceptITRPaymentByDebitOrCreditCard(String memberLoginName,FinancialYear financialYear, String PAN,String returnURL,String notifyURL, PAYMENT_MODE paymentNode, String cardHolderName, String cardNumber, CARD_TYPE cardType, String cvvNumber, String expiryMonth, String expiryYear,String amount,String email, String firstName, String lastName, String mobile,String address, String addressCity,String addressState, String addressZip);
}
