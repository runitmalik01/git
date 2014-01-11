package com.mootly.wcm.services.ditws;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrieveITRVStatusResponse;


public interface RetrieveITRVStatusByAckNumber extends DITSOAPService {	
	public RetrieveITRVStatusResponse retrieveITRVByTokenAndPAN(String userName, String password, String certChain,
			String signature,String tokenID,String PAN,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
