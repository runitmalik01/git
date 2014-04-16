package com.mootly.wcm.services.sms;


public interface SMSProvider {
	void sendTextMessage(String mobileNumbers,String message,String expiryInMinutes,boolean isAsync);
}
