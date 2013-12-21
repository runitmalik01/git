package com.mootly.wcm.services.efile;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ditws.SubmitBulkITR;
import com.mootly.wcm.services.ds.DigitalSignatureService;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;
import com.mootly.wcm.services.efile.exception.DigtalSignatureAssesseeFailure;
import com.mootly.wcm.services.efile.exception.DigtalSignatureERIUserFailure;
import com.mootly.wcm.services.efile.exception.EFileException;

public interface EFileService {
	
	/**
	 * 
	 * @param XML
	 * @param pan
	 * @param financialYear
	 * @return
	 */
	EFileResponse eFile(String userName, String password,String xml,String resellerId,String pan,FinancialYear financialYear,String canonicalPathToMemberIncomeTaxFolder) throws DigtalSignatureAssesseeFailure,DigtalSignatureERIUserFailure, EFileException;
	EFileResponse eFile(String userName, String password,String xml,String resellerId,String pan,FinancialYear financialYear,DigitalSignatureWrapper assesseSignature,DigitalSignatureWrapper eriSubUserSignature) throws DigtalSignatureAssesseeFailure,DigtalSignatureERIUserFailure, EFileException;
	
	String findJCRPathToAssesseDigitalSignature(String jcrPathToMemberPersonalInformation) throws LoginException, RepositoryException;
	
	String findJCRPathToERISubUserDigitalSignature(String jcrPathToMemberPersonalInformation) throws LoginException, RepositoryException;
	
	DigitalSignatureService getSignatureService();
	void setDigitalSignatureService(DigitalSignatureService digitalSignatureService);
	
	SubmitBulkITR getSubmitBulkITRService();
	void setSubmitBulkITRService(SubmitBulkITR submitBulkITRService);
	
}
