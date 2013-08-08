package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=ScheduleFiveADocument.class)
@FormFields(fieldNames={"name_spouse","pan_spouse","capital_gains","other_sources","house_property","total"})
@RequiredBeans(requiredBeans=MemberPersonalInformation.class)

public class Sch5A extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of schedule5a screen");
		}
		MemberPersonalInformation objMemberPersonalInformation=(MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		String isPortugese = objMemberPersonalInformation.getPortugesecivil();
		if(isPortugese.equals("N")) request.setAttribute("isPortugese", "No");
		else request.setAttribute("isPortugese", "Yes");
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of schedule 5a screen");
		}

	} }




