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

	public String shouldValidate5thChar(){
		ResourceBundle mstrRb=ResourceBundle.getBundle("master_config");
		if(mstrRb!=null){
			String check=mstrRb.getString("itreturn.pan.shouldValidate5thChar");
			if(check!=null && StringUtils.isNotEmpty(check)){
				return check;
			}
		}
		return null;
	}
}
