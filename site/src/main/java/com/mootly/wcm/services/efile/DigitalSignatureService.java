package com.mootly.wcm.services.efile;

import java.io.File;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.efile.model.DigitalSignature;

public interface DigitalSignatureService {
	
	DigitalSignature getDigitalSignature(File file) ;
	DigitalSignature getDigitalSignatureFromRepository(String jcrPath) ;
	
	
	/**
	 * 
	 * @param digitalSignature
	 * @param financialYear
	 * @return
	 */
	boolean isValid(DigitalSignature digitalSignature,FinancialYear financialYear);
	
	
	
	
}
