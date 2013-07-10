package com.mootly.wcm.services.efile;

import com.mootly.wcm.model.FinancialYear;

public class IncomeTaxIndiaEFilingService implements EFileService{

	@Override
	public EFileResponse eFile(String userName, String password, String pan,
			FinancialYear financialYear, String filePath)
			throws ServerUnderMaintenanceException, SiteUnavailableException,
			AuthenticationException, InvalidReturnException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
