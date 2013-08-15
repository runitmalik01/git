package com.mootly.wcm.services.ditws;

import java.io.File;
import java.util.Map;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;


public interface SubmitBulkITR extends DITSOAPService {	
	public Map<String,Object> submitBulkITR(File theZipFile)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
