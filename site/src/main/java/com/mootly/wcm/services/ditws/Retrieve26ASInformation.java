package com.mootly.wcm.services.ditws;

import java.util.Hashtable;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface Retrieve26ASInformation {	
	public Hashtable retrieve26ASInformation(String userName,String password,String PAN,String DOB,String assessmentYear)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
