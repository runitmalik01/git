package com.mootly.wcm.services.ditws;

import com.mootly.wcm.services.ditws.soap.SOAPService;

public interface DITSOAPService {
	
	public static final String FAULT_STRING_INVALID_PAN = "Invalid PAN. Please retry.";
	public static final String FAULT_STRING_INVALID_ASSESSMENT_YEAR = "Enter Valid Assessment Year";
	
	public static final String FAULT_STRING_NO_RETURN_FOR_ASSESSMENT_YEAR = "No e-Return has been filed for this PAN and Assessment Year.";
	
	public static final String PARAM_RESULT ="result";
	
	public static final String PARAM_USER_NAME="userName";
	public static final String PARAM_PASSWORD ="password";
	public static final String PARAM_CERT_CHAIN ="certChain";
	public static final String PARAM_SIGNATURE ="signature";
	
	public static final String PARAM_PAN ="PAN";
	public static final String PARAM_PAN_NUMBER ="panNumber";
	public static final String PARAM_PAN_NO ="panNo";
	
	public static final String PARAM_EMAIL = "EMAIL";
	public static final String PARAM_ADD_CLIENT_OPTION = "addClientOption";
	
	public static final String PARAM_TAN ="TAN";
	public static final String PARAM_DOB ="DOB";
	
	public static final String PARAM_ASSESSMENT_YEAR = "assessmentYear";
	
	public static final String PARAM_ACK_NO = "acknowledgementNo";
	
	
	
	String getUserName();
	
	String getPassword();
	
	String getCertChain();
	
	String getSignature();
	
	SOAPService getSoapService();
}
