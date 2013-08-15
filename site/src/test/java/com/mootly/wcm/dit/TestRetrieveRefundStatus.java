package com.mootly.wcm.dit;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.RetrieveRefundStatus;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;

public class TestRetrieveRefundStatus  {
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
	public void testRetrieveRefundStatus() {
		RetrieveRefundStatus retrieveRefundStatus =	ac.getBean(RetrieveRefundStatus.class);
		try {
			String output = retrieveRefundStatus.retrieveRefundStatusRAW("ABNPP1234G", "2013-14");
			System.out.println(output);
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
