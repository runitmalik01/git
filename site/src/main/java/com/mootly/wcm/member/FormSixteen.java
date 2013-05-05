/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

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
import com.mootly.wcm.components.ITReturnComponent;
@PrimaryBean(primaryBeanClass=com.mootly.wcm.beans.FormSixteen.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"employer","employee","pan_deductor","tan_deductor","pan_employee","quarter_1","acknowledge_1","from_1","to_1","year_1",
		"quarter_2","acknowledge_2","from_2","to_2","year_2","quarter_3","acknowledge_3","from_3","to_3","year_3","quarter_4","acknowledge_4",
		"from_4","to_4","year_4","gross_b","gross_c","gross_total","less_allowance_1","less_rs_1","less_total_1","less_allowance_2","less_rs_2",
		"less_total_2","deductions_entertainment","deductions_tax","deductions_total","income_chargable_total","additional_1","additional_2",
		"gross_income_total","ded_underchapter_6a","c_1","c_2","c_3","c_4","c_5","c_6a","c_6b","c_6c","ccc_1","ccc_2","ccd_1",
		"ccd_2","a_section","a_section_1","a_section_2","a_section_3","b_section","b_section_1","b_section_2","b_section_3","c_section","c_section_1",
		"c_section_2","c_section_3","d_section","d_section_1","d_section_2","d_section_3","e_section","e_section_1","e_section_2","e_section_3",
		"aggregate","total_income_1","total_income_2","tax_total_income_1","tax_total_income_2","surcharge_1","surcharge_2",
		"education_cess","tax_payable","relief_1","relief_2","tax_payable1","tax_payable_1","tax_payable_2","ded_ent1","ded_ent2",
		"ded_ent3","ded_ent4","relief_11","relief_12"})
public class FormSixteen extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(FormSixteen.class);

	@SuppressWarnings("deprecation")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto_generated method stub
		super.doAction(request, response);
	}

}
