package com.mootly.wcm.services.ditws;

import java.util.Hashtable;


public interface RetrieveRectificationStatus {	
	public Hashtable getCase(String caseId) throws DITException;
}
