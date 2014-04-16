package com.mootly.wcm.services.sync;

public interface SyncToExternalDb {
	
	void insert(String XML) throws Exception;
}
