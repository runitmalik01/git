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
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.NatureInvestmentDocument;
import com.mootly.wcm.beans.compound.NatureInvestmentDetail;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=NatureInvestmentDocument.class)
@ChildBean(childBeanClass=NatureInvestmentDetail.class)
@FormFields(fieldNames={"country_code","nature_asset","total_investment","country_name"})



public class NatureInvestment extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of natute of investment");
		}
		request.setAttribute("checkForNRI", request.getParameter("invalid.user"));
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of natute of investment");
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




