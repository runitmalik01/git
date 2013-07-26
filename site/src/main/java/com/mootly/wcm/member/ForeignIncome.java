package com.mootly.wcm.member;


import java.util.ArrayList;
import java.util.List;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.ForeignIncomeDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.ForeignIncomeDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=ForeignIncomeDocument.class)
@ChildBean(childBeanClass=ForeignIncomeDetail.class)
@FormFields(fieldNames={"country_code","taxpayer_ID","income_salary","income_house","income_business","income_capitalgain","income_othersources","income_total","country_name"})
//@RequiredFields(fieldNames={"tan_deductortdsoth","name_deductortdsoth","total_taxdeductedtdsoth","amounttdsoth"})
/*
@DataTypeValidationFields(fieldNames={
		"tan_deductortdsoth",
		"total_taxdeductedtdsoth",
		"tds_certificatetdsoth",
		"amounttdsoth"
},
dataTypes={
		DataTypeValidationType.TAN,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.TDSCERTIFICATE,
		DataTypeValidationType.DECIMAL
}
		)
		*/
public class ForeignIncome extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ForeignIncome.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of foreign income");
		}


	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of foreign income");
		}

	} }




