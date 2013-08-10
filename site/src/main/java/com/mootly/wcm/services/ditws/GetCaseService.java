package com.mootly.wcm.services.ditws;

import java.util.Hashtable;


public interface GetCaseService {	
	public Hashtable getCase(String caseId) throws DITException;
}
