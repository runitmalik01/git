package com.mootly.wcm.services.ditws;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrieveRefundResponse;


public interface RetrieveRefundStatus {	
	public RetrieveRefundResponse retrieveRefundStatus(String userName,String password,String certChain, String signature, String PAN,String assessmentYear) throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
