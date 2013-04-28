/*
 * In this class we are creating a document for storing value of Deduction details of user
 * according to form 16.
 * @author Priyank
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.security;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;


public class LogoutSuccess extends BaseComponent{

	private static final Logger log = LoggerFactory.getLogger(LogoutSuccess.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if (log.isInfoEnabled()) {
			log.info("Successful Logout has occurred.");
		}
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}