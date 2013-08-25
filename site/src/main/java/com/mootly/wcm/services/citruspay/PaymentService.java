package com.mootly.wcm.services.citruspay;

import com.mootly.wcm.services.SequenceGenerator;

public interface PaymentService {
	public static enum BANK_ISSUER {
		ICICI_BANK("CID001",true),
		AXIS_BANK("CID002",true);
		
		
		public final String getIssuerCode() {
			return issuerCode;
		}

		public final boolean isAppliesToMotoAPI() {
			return appliesToMotoAPI;
		}

		String issuerCode;
		boolean appliesToMotoAPI;
		
		BANK_ISSUER (String issuerCode,boolean appliesToMotoAPI) {
			this.issuerCode = issuerCode;
			this.appliesToMotoAPI = appliesToMotoAPI;
		}
		
	}
	
	public static enum CITRUS_CONTENT_TYPE {
		XML ("application/xml"),JSON("application/json");
		
		String headerString;
		
		CITRUS_CONTENT_TYPE(String headerString) {
			this.headerString = headerString;
		}
		
		public String getHeaderString() {
			return headerString;
		}
	};
	
	public final static String PARAM_PAYMENT_MODE = "paymentMode";
	public final static String PARAM_ISSUER_CODE = "issuerCode";
	public final static String PARAM_MERCHANT_TXN_ID = "merchantTxnId";
	
	
	String getAccessKey();
	String getSecretKey();
	String getHMACSignature(String merchantTxId,String amount);
	CITRUS_CONTENT_TYPE getContentType();
	CITRUS_CONTENT_TYPE getAccept();	
	
	String newMerchantTxnId();
	
	void setSequenceGenerator(SequenceGenerator sequenceGenerator);
	SequenceGenerator getSequenceGenerator();

}
