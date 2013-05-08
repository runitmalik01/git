
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
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=OtherSourcesDocument.class)
@FormFields(fieldNames={"Gov_income","Kissan","Bank_detail_fdr","Bank_detail_saving","Indira","intnsc","Otherint",
		"Totalint","Family_pension","Dividends","Lottery_horse_income","Income_rent_machine","Income_maintain","Income_other","Deduction_57",
		"TotalOther_income","Familypension_deduction","Otherdeduction","depreciation",
		"totalexpense","Dividends_uti","Interest_income","Dividends_mutualfund","Agriculture_income",
		"Dividends_indian_companies","Otherincome","Total_taxfree_income","Taxable_income"})
public class OtherIncome extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(OtherIncome.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		if(log.isInfoEnabled()){
			log.info("This is Other Income page");
		}
		super.doBeforeRender(request, response);	
		String hideHorseIncome = getParameter("hidehorseincome", request);
		request.setAttribute("hideHorseIncome", "hideHorseIncome");
		if(log.isInfoEnabled()){
			log.info(hideHorseIncome+" do before render hideHorseIncome");
		}
		
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("i am in do action of otherincome");
		}
	}
}
