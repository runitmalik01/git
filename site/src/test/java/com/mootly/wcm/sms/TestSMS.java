package com.mootly.wcm.sms;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.model.OTP;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.otp.impl.TOTPGeneratorService;
import com.mootly.wcm.services.sms.SMSProvider;

public class TestSMS {
	
	ApplicationContext ac = null;
	RetrieveITRV retrieveITRV  = null;
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		try {
			ac = new ClassPathXmlApplicationContext("applicationContext.xml");	
		}catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void test26ASInformation() {
		SMSProvider smsProvider =	ac.getBean(SMSProvider.class);
		TOTPGeneratorService totpGeneratorService = new TOTPGeneratorService();
		OTP otp = totpGeneratorService.generate();
		//9468326649 - Kusujm Ji
		//919910368563 NAndini
		//9899209691 UMASHANKAR
		smsProvider.sendTextMessage("919818167923", "ALOK AMIT HERE SKYPE CALL EMERGENCY !!" , "20", false);
		
	}
}
