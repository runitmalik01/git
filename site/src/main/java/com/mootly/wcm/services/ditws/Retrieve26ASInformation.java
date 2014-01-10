package com.mootly.wcm.services.ditws;

import java.util.GregorianCalendar;



import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;

import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;


public interface Retrieve26ASInformation {	
	public Twenty26ASResponse retrieve26ASInformation(String userName,String password,String certChain, String signature, String PAN,GregorianCalendar DOB,String assessmentYear,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm)  throws MissingInformationException,DataMismatchException,InvalidFormatException;
}
