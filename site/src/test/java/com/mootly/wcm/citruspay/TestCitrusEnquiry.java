package com.mootly.wcm.citruspay;


import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.citruspay.Enquiry;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.PaymentService.BANK_ISSUER;
import com.mootly.wcm.services.citruspay.Transaction.CARD_TYPE;
import com.mootly.wcm.services.citruspay.Transaction.PAYMENT_MODE;
import com.mootly.wcm.services.ditws.RetrieveITRV;

public class TestCitrusEnquiry  {
	ApplicationContext ac = null;
	RetrieveITRV retrieveITRV  = null;
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		try {
			ac = new ClassPathXmlApplicationContext("CitrusIntegrationContext.xml");	
		}catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	@Test
	public void testEnquiry() {
		Enquiry enquiry =	ac.getBean(Enquiry.class);
		Map<String, Object> output = enquiry.doEnquiry("4612441873415491391");
		System.out.println(output);
	}
}
