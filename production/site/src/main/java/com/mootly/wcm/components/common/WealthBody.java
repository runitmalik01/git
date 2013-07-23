package com.mootly.wcm.components.common;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.http.HttpSession;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.Member;


public class WealthBody extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(WealthBody.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response)  {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);		
	}
       
    @Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException{
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}