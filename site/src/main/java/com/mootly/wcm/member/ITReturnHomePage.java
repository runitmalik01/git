/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.components.itreturns.AbstractITReturnHomePage;

public class ITReturnHomePage extends AbstractITReturnHomePage {

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		super.doAction(request, response);
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public HippoBean getScope(HstRequest request) {
		// TODO Auto-generated method stub
		return getPanFolder();
	}

}
