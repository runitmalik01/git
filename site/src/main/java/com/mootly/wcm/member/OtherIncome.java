
/*
 * In this class we are creating a document for storing value of Contact Information details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;


import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=OtherSourcesDocument.class)
@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@FormFields(fieldNames={"Gov_income","Kissan","Bank_detail_fdr","Bank_detail_saving","Indira","intnsc","Otherint",
		"Totalint","Family_pension","Dividends","Income_rent_machine","Income_other","Deduction_57",
		"TotalOther_income","Familypension_deduction","Otherdeduction","depreciation",
		"totalexpense","Dividends_uti","Interest_income","Dividends_mutualfund","Agriculture_income",
		"Dividends_indian_companies","Otherincome","Total_taxfree_income","Taxable_income"})
@DataTypeValidationFields(fieldNames={
		"Gov_income","Kissan","Bank_detail_fdr","Bank_detail_saving","Indira","intnsc","Otherint",
		"Totalint","Family_pension","Dividends","Income_rent_machine","Income_other","Deduction_57",
		"TotalOther_income","Familypension_deduction","Otherdeduction","depreciation",
		"totalexpense","Dividends_uti","Interest_income","Dividends_mutualfund","Agriculture_income",
		"Dividends_indian_companies","Otherincome","Total_taxfree_income","Taxable_income"
},dataTypes={
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL
}
		)

public class OtherIncome extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(OtherIncome.class);
	private static String eRROR_MAX_ALLOWED=null; 
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
		request.setAttribute("Max_allowed_ITR1", eRROR_MAX_ALLOWED);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("i am in do action of otherincome");
		}
	}
	//Change by Amit Patkar 07/23/2013 Replace doBeforeSave by validate
	/**
	 * 
	 */
	@Override
	protected boolean validate(HstRequest request, HstResponse response,
			FormMap formMap) {
		// TODO Auto-generated method stub
		boolean ret = super.validate(request, response, formMap);		
		if (ret) {
			boolean con_exempt=true;
			String max_allowed_exempt=request.getRequestContext().getResolvedSiteMapItem().getParameter("max_allowed_exempt");
			String total_taxfree_income=getFormMap().getField("Total_taxfree_income").getValue();
			MemberPersonalInformation personalinfo=(MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			if(max_allowed_exempt!=null){
				if(personalinfo.getSelectedITRForm().toString().equals("ITR1")){
					if(Integer.parseInt(total_taxfree_income) > Integer.parseInt(max_allowed_exempt)){
						log.info("Exceed Over Limit For ITR1");
						eRROR_MAX_ALLOWED="err.maxallowed.exceed";
						getFormMap().addMessage("Total_taxfree_income", "err.maxallowed.exceed");
						con_exempt=false;
					}else{
						eRROR_MAX_ALLOWED=null;
					}
				}
			}
			return con_exempt;
		}
		else {
			return ret;
		}		
	}	
}
