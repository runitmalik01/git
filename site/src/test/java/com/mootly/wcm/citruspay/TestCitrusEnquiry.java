package com.mootly.wcm.citruspay;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.services.citruspay.Enquiry;
import com.mootly.wcm.services.citruspay.model.enquiry.TxnEnquiryResponse;
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
		TxnEnquiryResponse txnEnquiryResponse = enquiry.doEnquiry("10017");
		System.out.println(txnEnquiryResponse.toString());
	}
}
