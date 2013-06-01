/*
 * By abhishek
 * This code will work when user click on activation link
 * 30/01/2013
 * 
 */



package com.mootly.wcm.member;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.MemberDetail;
import com.mootly.wcm.components.ITReturnComponent;
@PrimaryBean(primaryBeanClass=MemberDocument.class)
@ChildBean(childBeanClass=MemberDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"attachment","notes"})
public class Attachments extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(Attachments.class);

	public static final String SUCCESS= "success";
	@SuppressWarnings("deprecation")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		//super.doBeforeRender(request, response);
		log.info("i am in attachments");
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto_generated method stub
		super.doAction(request, response);
	}

}
