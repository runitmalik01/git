package com.mootly.wcm.services.ditws;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrieveTANResponse;

public interface RetrieveTANInformation {	
	public RetrieveTANResponse retrieveTANInformation(String userName,String password,String certChain, String signature, String TAN) throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
