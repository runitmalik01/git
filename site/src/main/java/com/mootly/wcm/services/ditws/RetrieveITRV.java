package com.mootly.wcm.services.ditws;

import java.util.Hashtable;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface RetrieveITRV extends DITSOAPService {	
	public ITRVStatus retrieveITRVStatus(String PAN,String assessmentYear) throws MissingInformationException,DataMismatchException,InvalidFormatException;
	public Hashtable retrieveITRVByAcknowledgementNumber(String acknowledgementNumber)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
	public Hashtable retrieveITRVByTokenAndPAN(String tokenID,String PAN)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
