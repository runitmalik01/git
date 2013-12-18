package com.mootly.wcm.services.efile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ds.DigitalSignatureService;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;
import com.mootly.wcm.services.efile.exception.EFileException;
import com.mootly.wcm.services.impl.SystemRepositorySupportProvider;

public class IncomeTaxIndiaEFilingService extends SystemRepositorySupportProvider implements EFileService {
	private static Logger log = LoggerFactory.getLogger(IncomeTaxIndiaEFilingService.class);
	
	DigitalSignatureService digitalSignatureService;
	
	@Override
	public EFileResponse eFile(String xml, String resellerId,String pan,
			FinancialYear financialYear, String canonicalPathToMemberIncomeTaxFolder)
					throws EFileException {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("xml:" + xml);
			log.info("pan:" + pan);
			log.info("financialYear:" + financialYear);
			log.info("canonicalPathToMemberIncomeTax:" + canonicalPathToMemberIncomeTaxFolder);
		}
		//this is the flow
		return null;
	}

	@Override
	public EFileResponse eFile(String xml, String resellerId, String pan,
			FinancialYear financialYear,
			DigitalSignatureWrapper assesseSignature,
			DigitalSignatureWrapper eriSubUserSignature) throws EFileException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String findJCRPathToAssesseDigitalSignature(
			String jcrPathToMemberPersonalInformation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String findJCRPathToERISubUserDigitalSignature(
			String jcrPathToMemberPersonalInformation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DigitalSignatureService getSignatureService() {
		// TODO Auto-generated method stub
		return digitalSignatureService;
	}
	
	@Override
	public void setDigitalSignatureService(
			DigitalSignatureService digitalSignatureService) {
		// TODO Auto-generated method stub
		this.digitalSignatureService = digitalSignatureService;
	}
}
