package com.mootly.wcm.citruspay;


import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.citruspay.PaymentService.BANK_ISSUER;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.ditws.RetrieveITRV;

public class TestCitrusNetBankingTransaction  {
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
	
	/**
	 * Map<String,Object> acceptITRPaymentByNetBanking(String memberLoginName, FinancialYear financialYear, String PAN,
			String returnURL,String notifyURL,
			BANK_ISSUER bankIssuer, String amount, String email,
			String firstName, String lastName, String mobile,String address, String addressCity,String addressState, String addressZip);
	 */
	@Test
	public void testTransaction() {
		Transaction transaction =	ac.getBean(Transaction.class);
		Map<String, Object> output = transaction.acceptITRPaymentByNetBanking(
										null,
										"amitpatkar@gmail.com", FinancialYear.TwentyTweleve, "ABNPP4706G", 
										"http://www.wealth4india/site/blah","http://www.wealth4india/site/blah",
										BANK_ISSUER.ICICI_BANK,"0.50","amitpatkar@gmail.com",
										"Amit","Patkar","9090909090","Address","addressCity","Goa","123456");
		System.out.println(output);
	}
	/*
	@Test
	public void testEnquiry() {
		Enquiry enquiry =	ac.getBean(Enquiry.class);
		Map<String, Object> output = enquiry.doEnquiry("ASDASDASD");
		System.out.println(output);
	}
	*/
}
