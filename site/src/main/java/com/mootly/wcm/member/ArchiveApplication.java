/*
 * In this class we are creating a document for storing value of Personal Information details of user
 * according to form 16.
 * @author 
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;


@PrimaryBean(primaryBeanClass=MemberPersonalInformation.class)
public class ArchiveApplication extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(ArchiveApplication.class);

	MemberPersonalInformation parentBean=null;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		parentBean=(MemberPersonalInformation)request.getAttribute("parentBean");		
	}
}
