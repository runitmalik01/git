/**
 * 
 */
package com.mootly.wcm.services;

import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

/**
 * @author admin
 *
 */
public interface ITRScreenXmlValidateService {

	public void getValidateXmlBasedOnReqScreen(HstRequest request,HstResponse response);
	
	public boolean getValidateType(String documentBeanName,HippoFolder parentFolder,int checkNoOfChild);
	
}
