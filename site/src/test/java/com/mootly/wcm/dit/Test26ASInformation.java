package com.mootly.wcm.dit;


import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;

public class Test26ASInformation  {
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
	public void test26ASInformation() {
		Retrieve26ASInformation retrieve26ASInformation =	ac.getBean(Retrieve26ASInformation.class);
		try {
			GregorianCalendar grego = IndianGregorianCalendar.getCurrentDateInIndiaAsDate();
			grego.set(Calendar.DAY_OF_MONTH, 12);
			grego.set(Calendar.MONTH, 11);
			grego.set(Calendar.YEAR, 1965);
			Twenty26ASResponse twentyASResponse  = retrieve26ASInformation.retrieve26ASInformation("ABNPP1234G", grego , "2013-14");
			System.out.println(twentyASResponse.toString());
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
