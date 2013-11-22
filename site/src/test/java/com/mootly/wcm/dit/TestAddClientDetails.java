package com.mootly.wcm.dit;


import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.services.ditws.AddClientDetails;
import com.mootly.wcm.services.ditws.AddClientDetails.AddClientOption;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.RetrieveRectificationStatus;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.AddClientDetailsResponse;

public class TestAddClientDetails  {
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
	public void testAddClientDetails() {
		AddClientDetails addClientDetails =	ac.getBean(AddClientDetails.class);
		try {
			AddClientDetailsResponse output = addClientDetails.addClientDetails("username", "password", "certChain", "signature", "PAN", IndianGregorianCalendar.getIndianInstance(), "email", AddClientOption.tdsOption, "TAN", FinancialYear.TwentyThirteen);
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
