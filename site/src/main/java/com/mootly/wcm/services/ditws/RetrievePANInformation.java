package com.mootly.wcm.services.ditws;

import java.util.Hashtable;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface RetrievePANInformation {	
	public Hashtable retrievePANInformation(String userName,String password, String PAN) throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
