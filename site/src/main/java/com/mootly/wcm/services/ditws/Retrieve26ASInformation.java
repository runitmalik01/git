package com.mootly.wcm.services.ditws;

import java.util.Map;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface Retrieve26ASInformation {	
	public Map<String,Object> retrieve26ASInformation(String PAN,String DOB,String assessmentYear)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
