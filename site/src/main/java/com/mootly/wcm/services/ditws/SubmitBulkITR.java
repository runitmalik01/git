package com.mootly.wcm.services.ditws;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.efile.EFileResponse;


public interface SubmitBulkITR extends DITSOAPService {	
	public EFileResponse submitBulkITR(String userName,String password,String certChain, String signature, byte[] bytes)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
