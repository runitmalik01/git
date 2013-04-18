package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=TdsFromSalaryDocument.class)
@ChildBean(childBeanClass=TdsFromSalaryDetail.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"tan_employer","name_employer","income_chargeable","total_taxdeducted"})
@RequiredFields(fieldNames={"tan_employer","name_employer","income_chargeable","total_taxdeducted"})
public class TdsFromSalary extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		System.out.println("this is do before render of tds from salary");
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		System.out.println("this is do Action of tds from salary");
	} }
	
	
	

