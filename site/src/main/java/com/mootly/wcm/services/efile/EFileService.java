package com.mootly.wcm.services.efile;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ds.DigitalSignatureService;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;
import com.mootly.wcm.services.efile.exception.EFileException;

public interface EFileService {
	
	/**
	 * 
	 * @param XML
	 * @param pan
	 * @param financialYear
	 * @return
	 */
	EFileResponse eFile(String xml,String resellerId,String pan,FinancialYear financialYear,String canonicalPathToMemberIncomeTaxFolder) throws EFileException;
	EFileResponse eFile(String xml,String resellerId,String pan,FinancialYear financialYear,DigitalSignatureWrapper assesseSignature,DigitalSignatureWrapper eriSubUserSignature) throws EFileException;
	
	String findJCRPathToAssesseDigitalSignature(String jcrPathToMemberPersonalInformation);
	
	String findJCRPathToERISubUserDigitalSignature(String jcrPathToMemberPersonalInformation);
	
	DigitalSignatureService getSignatureService();
	void setDigitalSignatureService(DigitalSignatureService digitalSignatureService);
	
	
}
