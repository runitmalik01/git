package com.mootly.wcm.member;


import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.DetailOfTrustDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.DetailOfTrustDetail;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=DetailOfTrustDocument.class)
@ChildBean(childBeanClass=DetailOfTrustDetail.class)
@FormFields(fieldNames={"country_code","name_trust","address_trust","name_othertrust","address_othertrust","name_settlor","address_settlor","name_beneficiaries","address_beneficiaries","country_name"})



public class TrustDetail extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of details of trust");
		}
		request.setAttribute("checkForNRI", request.getParameter("invalid.user"));
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of details of trust");
		}
	} 
	//Check for NRI
	@Override
	public boolean validate(HstRequest request, HstResponse response,
			FormMap formMap) {
		// TODO Auto-generated method stub
		if(super.validate(request, response, formMap)){
			boolean hasAValidUser = true;
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			if(memberPersonalInformation != null){
				if(StringUtils.isNotBlank(memberPersonalInformation.getResidentCategory()) && !memberPersonalInformation.getResidentCategory().equals("RES")){
					hasAValidUser = false;
					response.setRenderParameter("invalid.user", "nri.not.allowed");
					return hasAValidUser;
				}
			}
		}
		return super.validate(request, response, formMap);
	}	
}




