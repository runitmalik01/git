package com.mootly.wcm.services.ditws;

import java.util.GregorianCalendar;
import java.util.Map;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;


public interface Retrieve26ASInformation {	
	public Twenty26ASResponse retrieve26ASInformation(String PAN,GregorianCalendar DOB,String assessmentYear)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
