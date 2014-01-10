package com.mootly.wcm.dit;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.SubmitBulkITR;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.efile.EFileResponse;

public class TestSubmitBulkITR  {
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
	public void testBulkITR() {
		SubmitBulkITR submitBulkITR =	ac.getBean(SubmitBulkITR.class);
		try {
			EFileResponse output = submitBulkITR.submitBulkITR("","","","",null,null,null);
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
