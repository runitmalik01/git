package com.mootly.wcm.dit;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.RetrieveRectificationStatus;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrieveRectificationResponse;

public class TestRetrieveRectificationStatus  {
	ApplicationContext ac = null;
	RetrieveITRV retrieveITRV  = null;
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		try {
			ac = new ClassPathXmlApplicationContext("DITConnectorContext.xml");	
		}catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void testRetrieveRectificationStatus() {
		RetrieveRectificationStatus retrieveRectificationStatus =	ac.getBean(RetrieveRectificationStatus.class);
		try {
			RetrieveRectificationResponse retrieveRectificationResponse = retrieveRectificationStatus.retrieveRectificationStatus("ERIU101869", "arun@123", "certChain1", "signature1", "ABNPP1234G", FinancialYear.TwentyTweleve.getAssessmentYearForDITSOAPCall());
			
		} catch (MissingInformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
