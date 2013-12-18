package com.mootly.wcm.services.impl;

import javax.jcr.Credentials;
import javax.jcr.Repository;
import javax.jcr.query.Query;

import org.hippoecm.hst.site.HstServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.SystemRepositorySupport;

public abstract class SystemRepositorySupportProvider implements SystemRepositorySupport {

	static final Logger log = LoggerFactory.getLogger(SystemRepositorySupportProvider.class);
	private Repository systemRepository;

	private Credentials systemCreds;

	private String queryLanguage = Query.XPATH;
	@Override
	public void setSystemRepository(Repository systemRepository) {
		// TODO Auto-generated method stub
		this.systemRepository = systemRepository;
	}

	@Override
	public Repository getSystemRepository() {
		// TODO Auto-generated method stub
		if (systemRepository == null) {
			systemRepository = HstServices.getComponentManager().getComponent(Repository.class.getName());
		}
		return systemRepository;
	}

	@Override
	public void setSystemCredentials(Credentials systemCreds) {
		// TODO Auto-generated method stub
		this.systemCreds = systemCreds;
	}

	@Override
	public Credentials getSystemCredentials() {
		// TODO Auto-generated method stub
		if (systemCreds == null) {
			systemCreds = HstServices.getComponentManager().getComponent(Credentials.class.getName() + ".hstconfigreader");
		}

		return systemCreds;
	}

	@Override
	public void setQueryLanguage(String queryLanguage) {
		// TODO Auto-generated method stub
		this.queryLanguage = queryLanguage;
	}

	@Override
	public String getQueryLanguage() {
		// TODO Auto-generated method stub
		return queryLanguage;
	}

}
