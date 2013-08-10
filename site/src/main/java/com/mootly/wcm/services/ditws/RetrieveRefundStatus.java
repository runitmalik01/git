package com.mootly.wcm.services.ditws;

import java.util.Hashtable;


public interface RetrieveRefundStatus {	
	public Hashtable getCase(String caseId) throws DITException;
}
