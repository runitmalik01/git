/**
 * Control the Mater Properties of Member of Filing Tax 
 */
package com.mootly.wcm.services;

import java.util.ResourceBundle;

/**
 * @author BEN-10
 *
 */
public class MasterConfigService implements ConfigService {

	static MasterConfigService masterConfigService = null;
	
	ResourceBundle mstrRb = null;
	
	private MasterConfigService() {
		mstrRb = ResourceBundle.getBundle("master_config");
	}
	
	public synchronized static MasterConfigService getInstance() {
		if (masterConfigService == null) {
			masterConfigService = new MasterConfigService();
		}
		return masterConfigService;
	}
	
	
	
	public Boolean shouldValidate5thChar(){
		return getBoolean("itreturn.pan.shouldValidate5thChar");
	}
	
	public Boolean shouldValidateDate(){
		return getBoolean("itreturn.dob.shouldValidateDob");
	}

	public Boolean shouldContinueWithInvalidPAN(){
	    	return getBoolean("itreturn.ditValidPAN.continueWithInvalidPAN");
	}
	
	@Override
	public String[] getArray(String propertyKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getString(String propertyKey) {
		// TODO Auto-generated method stub
		if (mstrRb.containsKey(propertyKey)) {
			return mstrRb.getString(propertyKey);
		}
		else {
			return null;
		}
	}

	@Override
	public String getString(String propertyKey, String defaultValue) {
		// TODO Auto-generated method stub
		String retVal = getString(propertyKey);
		if (retVal == null) {
			return defaultValue;
		}
		else {
			return null;
		}
	}

	@Override
	public Boolean getBoolean(String propertyKey) {
		// TODO Auto-generated method stub
		String retVal = getString(propertyKey);
		return Boolean.valueOf(retVal);
	}

	@Override
	public Boolean getBoolean(String propertyKey, Boolean defaultValue) {
		// TODO Auto-generated method stub
		String retVal = getString(propertyKey);
		if (retVal == null) {
			return defaultValue;
		}
		else {
			return Boolean.valueOf(retVal);
		}
	}

	@Override
	public Integer getInteger(String propertyKey) {
		// TODO Auto-generated method stub
		String retVal = getString(propertyKey);
		return Integer.valueOf(retVal);
	}

	@Override
	public <T> T getValue(String propertyKey, T propertyType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
