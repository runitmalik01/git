package com.mootly.wcm.services.ditws;

import java.util.Map;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;


public interface RetrievePANInformation {	
	public static enum VALIDATION_RESULT {NOT_INITIATED,ERROR,DOB,FATHERS_NAME,ASSESS_FULL_NAME};
	public RetrievePANResponse retrievePANInformation(String PAN) throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
