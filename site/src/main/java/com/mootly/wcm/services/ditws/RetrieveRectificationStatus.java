package com.mootly.wcm.services.ditws;

import java.util.Map;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface RetrieveRectificationStatus {	
	Map<String,Object> retrieveRectificationStatus(String PAN,String assessmentYear) throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
