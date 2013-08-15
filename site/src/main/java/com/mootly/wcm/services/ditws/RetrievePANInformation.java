package com.mootly.wcm.services.ditws;

import java.util.Map;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface RetrievePANInformation {	
	public Map<String,Object> retrievePANInformation(String PAN) throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
