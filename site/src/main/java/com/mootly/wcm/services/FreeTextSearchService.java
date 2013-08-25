/**
 * 
 */
package com.mootly.wcm.services;

import org.hippoecm.hst.content.beans.standard.HippoBean;

/**
 * @author BEN-10
 *
 */
public interface FreeTextSearchService {

	public boolean getFreeTextResultOnMember(HippoBean serviceRequestBean, String freeText, HippoBean targetHippoBean);
	
}
