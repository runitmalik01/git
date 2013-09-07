package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.ClubIncomeDocument;
import com.mootly.wcm.beans.compound.ClubIncomeDetail;
import com.mootly.wcm.components.ITReturnComponent;


/*
 * Author:Pankaj Singh
 * Date:24/06/2013
 * Description:It is component for clubbing of income
 */
@PrimaryBean(primaryBeanClass=ClubIncomeDocument.class)
@ChildBean(childBeanClass=ClubIncomeDetail.class)
@FormFields(fieldNames={"name_person","pan_person","relationship","nature_income","amountclub"})
@RequiredFields(fieldNames={"name_person","relationship","nature_income","amountclub"})
@DataTypeValidationFields(fieldNames={
		"pan_person"
},
dataTypes={DataTypeValidationType.PAN
		})
public class ClubIncome extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of clubbing of income");
		}

	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of clubbing of income");
		}

	} }




