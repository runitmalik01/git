
/*
 * In this class we are creating a document for storing value of Contact Information details of user
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
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.OtherSourceIncome;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=OtherSourceIncome.class)
@FormFields(fieldNames={"Gov_income","Kissan_patra","Bank_detail","Indira_patra","Int_nsc","Other_interest",
		"Total_interest","Family_pension","Dividends","Lottery_horse_income","Income_rent_machine","Income_maintain","Income_other","Deduction_57",
		"TotalOther_income","Familypension_deduction","Other_deduction","Depreciation",
		"Total_expenses","Dividends_uti","Interest_income","Dividends_mutualfund","Agriculture_income",
		"Dividends_indian_companies","Other_income","Total_taxfree_income","Taxable_income"})
public class OtherIncome extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(OtherIncome.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);		
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}
