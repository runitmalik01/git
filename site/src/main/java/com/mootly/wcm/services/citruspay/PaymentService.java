package com.mootly.wcm.services.citruspay;

import java.util.Arrays;
import java.util.Comparator;

import com.mootly.wcm.services.SequenceGenerator;

public interface PaymentService {
	public static enum BANK_ISSUER {
		ICICI_BANK("CID001",true,"ICICI Bank"),
		AXIS_BANK("CID002",true,"AXIS Bank"),
		CITIBANK("CID003",false,"Citibank"),
		YES_BANK("CID004",true,"YES Bank"),
		SBI_BANK("CID005",true,"SBI Bank"),
		DEUTSCHE_BANK("CID006",true,"Deutsche Bank"),
		UNION_BANK("CID007",true,"Union Bank"),
		INDIAN_BANK("CID008",true,"Indian Bank"),
		FEDERAL_BANK("CID009",true,"Federal Bank"),
		HDFC_BANK("CID010",true,"HDFC Bank"),
		IDBI_BANK("CID011",false,"IDBI Bank"),
		STATE_BANK_OF_HYDERABAD("CID012",true,"State Bank of Hyderabad"),
		STATE_BANK_OF_BIKANER_AND_JAIPUR("CID013",true,"State Bank of Bikaner and Jaipur"),
		STATE_BANK_OF_MYSORE("CID014",true,"State Bank of Mysore"),
		STATE_BANK_OF_TRAVANCORE("CID015",false,"State Bank of Travancore"),
		ANDHRA_BANK("CID016",false,"Andhra Bank"),
		BANK_OF_BAHRAIN_KUWAIT("CID017",false,"Bank of Bahrain & Kuwait"),
		BANK_OF_BARODA_CORPORATE_ACCOUNTS("CID018",false,"Bank of Baroda Corporate Accounts"),
		BANK_OF_INDIA("CID019",true,"Bank of India"),
		BANK_OF_BARODA_RETAIL_ACCOUNTS("CID020",false,"Bank of Baroda Retail Accounts"),
		BANK_OF_MAHARASHTRA("CID021",true,"Bank of Maharashtra"),
		CATHOLIC_SYRIAN_BANK("CID022",false,"Catholic Syrian Bank"),
		CENTRAL_BANK_OF_INDIA("CID023",true,"Central Bank of India"),
		CITY_UNION_BANK("CID024",true,"City Union Bank"),
		CORPORATION_BANK("CID025",true,"Corporation Bank"),
		DCB_BANK_DEVELOPMENT_CREDIT_BANK("CID026",false,"DCB Bank ( Development Credit Bank )"),
		INDIAN_OVERSEAS_BANK("CID027",true,"Indian Overseas Bank"),
		INDUSIND_BANK("CID028",false,"IndusInd Bank"),
		ING_VYSYA_BANK("CID029",false,"ING Vysya Bank"),
		JAMMU_KASHMIR_BANK("CID030",false,"Jammu & Kashmir Bank"),
		KARNATAKA_BANK("CID031",true,"Karnataka Bank"),
		KARURVYSYA_BANK("CID032",false,"KarurVysya Bank"),
		KOTAK_MAHINDRA_BANK("CID033",true,"Kotak Mahindra Bank"),
		LAKSHMI_VILAS_BANK_NETBANKING("CID034",false,"Lakshmi Vilas Bank NetBanking"),
		ORIENTAL_BANK_OF_COMMERCE("CID035",false,"Oriental Bank of Commerce"),
		PUNJAB_NATIONAL_BANK_CORPORATE_ACCOUNTS("CID036",false,"Punjab National Bank Corporate Accounts"),
		SOUTH_INDIAN_BANK("CID037",false,"South Indian Bank"),
		STANDARD_CHARTERED_BANK("CID038",false,"Standard Chartered Bank"),
		SYNDICATE_BANK("CID039",false,"Syndicate Bank"),
		TAMILNAD_MERCANTILE_BANK("CID040",false,"Tamilnad Mercantile Bank"),
		UNITED_BANK_OF_INDIA("CID041",true,"United Bank of India"),
		VIJAYA_BANK("CID042",true,"Vijaya Bank"),
		STATE_BANK_OF_PATIALA("CID043",true,"State Bank of Patiala"),
		PUNJAB_NATIONAL_BANK_RETAIL_ACCOUNTS("CID044",false,"Punjab National Bank Retail Accounts");
/*
		ICICI_BANK("CID001",true,"ICICI Bank"),
		AXIS_BANK("CID002",true,"AXIS Bank"),
		CITIBANK("CID003",false),
		YES_BANK("CID004",false),
		SBI_BANK("CID005",false),
		DEUTSCHE_BANK("CID006",true,"Deutsche Bank"),
		UNION_BANK("CID007",true,"Union Bank"),
		INDIAN_BANK("CID008",true,"Indian Bank"),
		FEDERAL_BANK("CID009",true,"Federal Bank"),
		HDFC_BANK("CID010",false),
		IDBI_BANK("CID011",false),
		STATE_BANK_OF_HYDERABAD("CID012",false),
		STATE_BANK_OF_BIKANER_AND_JAIPUR("CID013",false),
		STATE_BANK_OF_MYSORE("CID014",false),
		STATE_BANK_OF_TRAVANCORE("CID015",false),
		ANDHRA_BANK("CID016",false),
		BANK_OF_BAHRAIN_KUWAIT("CID017",false),
		BANK_OF_BARODA_CORPORATE_ACCOUNTS("CID018",false),
		BANK_OF_INDIA("CID019",false),
		BANK_OF_BARODA_RETAIL_ACCOUNTS("CID020",false),
		BANK_OF_MAHARASHTRA("CID021",false),
		CATHOLIC_SYRIAN_BANK("CID022",false),
		CENTRAL_BANK_OF_INDIA("CID023",true,"Central Bank of India"),
		CITY_UNION_BANK("CID024",false),
		CORPORATION_BANK("CID025",false),
		DCB_BANK_DEVELOPMENT_CREDIT_BANK("CID026",false),
		INDIAN_OVERSEAS_BANK("CID027",true,"Indian Overseas Bank"),
		INDUSIND_BANK("CID028",false),
		ING_VYSYA_BANK("CID029",false),
		JAMMU_KASHMIR_BANK("CID030",false),
		KARNATAKA_BANK("CID031",false),
		KARURVYSYA_BANK("CID032",false),
		KOTAK_MAHINDRA_BANK("CID033",false),
		LAKSHMI_VILAS_BANK_NETBANKING("CID034",false),
		ORIENTAL_BANK_OF_COMMERCE("CID035",false),
		PUNJAB_NATIONAL_BANK_CORPORATE_ACCOUNTS("CID036",false),
		SOUTH_INDIAN_BANK("CID037",false),
		STANDARD_CHARTERED_BANK("CID038",false),
		SYNDICATE_BANK("CID039",false),
		TAMILNAD_MERCANTILE_BANK("CID040",false),
		UNITED_BANK_OF_INDIA("CID041",true,"United Bank of India"),
		VIJAYA_BANK("CID042",true,"Vijaya Bank"),
		STATE_BANK_OF_PATIALA("CID043",false),
		PUNJAB_NATIONAL_BANK_RETAIL_ACCOUNTS("CID044",false);

		*/
		
		public final String getIssuerCode() {
			return issuerCode;
		}

		public final boolean isAppliesToMotoAPI() {
			return appliesToMotoAPI;
		}
		
		public final String getDisplayName() {
			return displayName;
		}
		
		public static final BANK_ISSUER[] getSortedValues() {
			BANK_ISSUER[] newValues = Arrays.copyOf(values(), values().length);
			Arrays.sort(newValues, new compareBankIssueDisplayName());
			return newValues;
		}
		
		public static final BANK_ISSUER getByIssuerCode(String issuerCode) {
			for (BANK_ISSUER bankIssuer:BANK_ISSUER.values()) {
				if (bankIssuer.getIssuerCode() != null && bankIssuer.getIssuerCode().equalsIgnoreCase(issuerCode)) {
					return bankIssuer;
				}
			}
			return null;
		}


		String issuerCode;
		String displayName;
		boolean appliesToMotoAPI;
		
		BANK_ISSUER (String issuerCode,boolean appliesToMotoAPI) {
			this.issuerCode = issuerCode;
			this.appliesToMotoAPI = appliesToMotoAPI;
			this.displayName = issuerCode;
		}
		
		BANK_ISSUER (String issuerCode,boolean appliesToMotoAPI,String displayName) {
			this.issuerCode = issuerCode;
			this.appliesToMotoAPI = appliesToMotoAPI;
			this.displayName = displayName;
		}
		
		static class compareBankIssueDisplayName implements Comparator<BANK_ISSUER> {
			@Override
			public int compare(BANK_ISSUER o1, BANK_ISSUER o2) {
				// TODO Auto-generated method stub
				return (o1.getDisplayName().compareTo(o2.getDisplayName()));
			}
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
	public final static String PARAM_MERCHANT_ID="merchantId";
	public final static String PARAM_CURRENCY="currency";
	public final static String PARAM_ORDER_AMOUNT="orderAmount";
	
	String getAccessKey();
	String getSecretKey();
	String getMerchantId();
	String getCheckoutURL();
	String getCurrency();
	String getHMACSignatureSSL(String merchantTxId,String amount);
	String getHMACSignatureMOTO(String merchantTxId,String amount);
	CITRUS_CONTENT_TYPE getContentType();
	CITRUS_CONTENT_TYPE getAccept();	
	
	String newMerchantTxnId();
	
	void setSequenceGenerator(SequenceGenerator sequenceGenerator);
	SequenceGenerator getSequenceGenerator();
	
	String getPaysealMerchantId();
	String getPaysealNoResultMessage();
	String getPaysealNoResultCode();

}
