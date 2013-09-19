/**
 * 
 */
package com.mootly.wcm.services;

import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.model.ITRXmlValidation;

/**
 * @author admin
 *
 */
public interface ITRScreenXmlValidateService {

	public void getValidateXmlBasedOnReqScreen(HstRequest request,HstResponse response);
	
	public boolean getValidateType(ITRXmlValidation VALIDATE,HippoFolder parentFolder,int checkNoOfChild);
	
}
