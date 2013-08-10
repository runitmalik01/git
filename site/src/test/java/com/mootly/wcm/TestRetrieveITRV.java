package com.mootly.wcm;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.services.ditws.ITRVStatus;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.impl.RetrieveITRVImpl;

public class TestRetrieveITRV  {
	ApplicationContext ac = null;
	RetrieveITRV retrieveITRV  = null;
	
	@Before
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		ac = new ClassPathXmlApplicationContext("DITConnectorContext.xml");		
	}
	
	@Test
	public void testRetrieveITRVStatus() {
		RetrieveITRV retrieveITRV =	ac.getBean(RetrieveITRVImpl.class);
		try {
			ITRVStatus itvStatus = retrieveITRV.retrieveITRVStatus("bhmps2932k", "2013-14");
			System.out.println(itvStatus);
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
