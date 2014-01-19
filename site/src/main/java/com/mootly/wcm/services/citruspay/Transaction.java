package com.mootly.wcm.services.citruspay;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.PaymentType;
import com.opus.epg.sfa.java.PGResponse;

public interface Transaction extends PaymentService {
	//public static enum PAYMENT_MODE {NET_BANKING,CREDIT_CARD, DEBIT_CARD};
	public static enum CARD_TYPE {VISA,MCRD, MTRO};
	
	public static enum ENQUIRY_RESP_CODE { 	
		SUCCESS("0","11"), //i have noticed that it gives 11 for REFUND enquiries
		ERROR_ISSUER("1"),
		TRANSACTION_FAILURE("2"),
		INCOMPLETE_TRANSACTION("4");
		
		final String[] code;
		final List<String> listOfCodes;
		
		/**
		 * For the hack of it just accept arrays of code
		 * @param code
		 */
		ENQUIRY_RESP_CODE(String... code) {
			this.code = code;
			listOfCodes = Arrays.asList(this.code);
		}
		
		public final String getCode() {
			return code[0];
		}
		
		public final String[] getCodes() {
			return code;
		}
		
		public final List<String> getListOfCodes() {
			return listOfCodes;
		}

		public static ENQUIRY_RESP_CODE getByCode(String code) {
			for (ENQUIRY_RESP_CODE aRespCode: ENQUIRY_RESP_CODE.values()) {			
				if (aRespCode.getListOfCodes().contains(code)) {
					return aRespCode;
				}
			}
			return TRANSACTION_FAILURE;
		}
	}
	
	public static String RETURN_URL_KEY = "returnUrl";
	
	Map<String,Object> acceptITRPaymentByNetBanking(
			String newMerchantTxnId,
			String memberLoginName, FinancialYear financialYear, String PAN,
			String returnURL,String notifyURL,
			BANK_ISSUER bankIssuer, String amount, String email,
			String firstName, String lastName, String mobile,String address, String addressCity,String addressState, String addressZip);
	
	PGResponse acceptITRPaymentByDebitOrCreditCard(String memberLoginName,FinancialYear financialYear, String PAN,String returnURL,String notifyURL, PaymentType paymentType, String cardHolderName, String cardNumber, CARD_TYPE cardType, String cvvNumber, String expiryMonth, String expiryYear,String amount,String email, String firstName, String lastName, String mobile,String address, String addressCity,String addressState, String addressZip) throws Exception;
}
