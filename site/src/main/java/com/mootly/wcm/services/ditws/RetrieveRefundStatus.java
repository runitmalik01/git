package com.mootly.wcm.services.ditws;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface RetrieveRefundStatus {	
	public String retrieveRefundStatusRAW(String PAN,String assessmentYear) throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
