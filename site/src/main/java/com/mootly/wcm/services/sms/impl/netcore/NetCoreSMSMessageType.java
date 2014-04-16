package com.mootly.wcm.services.sms.impl.netcore;

public enum NetCoreSMSMessageType {
	TEXT ("1"),WAP ("5"),MULTI_LINGUAL("2"),PICTURE("8"),VCARD("11"),FLASH_ENGLISH("12"),FLASH_MULTI_LINGUAL("15");
	
	public String getTheCode() {
		return theCode;
	}
	
	NetCoreSMSMessageType(String theCode) {
		this.theCode = theCode;
	}
	
	String theCode;
}
