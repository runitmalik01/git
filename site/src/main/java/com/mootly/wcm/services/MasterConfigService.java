/**
 * Control the Mater Properties of Member of Filing Tax 
 */
package com.mootly.wcm.services;

import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

/**
 * @author BEN-10
 *
 */
public class MasterConfigService {

	static ResourceBundle mstrRb=ResourceBundle.getBundle("master_config");
	
	public static String shouldValidate5thChar(){
		if(mstrRb!=null){
			String check=mstrRb.getString("itreturn.pan.shouldValidate5thChar");
			if(check!=null && StringUtils.isNotEmpty(check)){
				return check;
			}
		}
		return null;
	}
	
	public static String shouldValidateDate(){
		if(mstrRb!=null){
			String check=mstrRb.getString("itreturn.dob.shouldValidateDob");
			if(check!=null&& StringUtils.isNotEmpty(check)){
				return check;
			}
		}
		return null;
	}
}
