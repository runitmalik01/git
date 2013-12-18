package com.mootly.wcm.services;

import javax.jcr.Credentials;
import javax.jcr.Repository;

public interface SystemRepositorySupport {

	void setSystemRepository(Repository systemRepository);
	Repository getSystemRepository();
	
	void setSystemCredentials(Credentials systemCreds);
	Credentials getSystemCredentials();
	
	void setQueryLanguage(String queryLanguage);
	String getQueryLanguage();
}
