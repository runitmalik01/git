package com.mootly.wcm.services.ditws;

import java.util.Hashtable;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface SubmitBulkITR {	
	public Hashtable submitBulkITR(String userName,String password,String certChain,String signature,String hexZipFile)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
