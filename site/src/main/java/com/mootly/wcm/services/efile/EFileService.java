package com.mootly.wcm.services.efile;

import com.mootly.wcm.model.FinancialYear;

public interface EFileService {
	
	public EFileResponse eFile(String userName,String password,String pan,FinancialYear financialYear,String filePath) throws ServerUnderMaintenanceException,SiteUnavailableException,AuthenticationException, InvalidReturnException;
}
