package com.mootly.wcm.member;


import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.compound.IncomeFromFirmsDetail;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=IncomeFromFirmsDocument.class)
@ChildBean(childBeanClass=IncomeFromFirmsDetail.class)

@FormFields(fieldNames={"firm_PAN","salary_BonusRcv","interest_Rcv","total_SalaryAndInterest","expenses_RelTotal","netIncome"})

public class IncomeFromFirmsITR3 extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of income from firms in itr3");
		}

	}
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of income from firms in itr3");
		}
		request.setAttribute("InCorrectPan", request.getParameter("InCorrectPan"));

	}
	
@Override
public boolean validate(HstRequest request, HstResponse response, FormMap formMap){
	if(super.validate(request, response, formMap)){
		String panNo= formMap.getField("firm_PAN").getValue();
		log.info("tanNo"+panNo+"KKKKK"+panNo.charAt(3));
		
		if(panNo.charAt(3) != 'F'){
			formMap.addMessage("InCorrectPan", "FourthcharPan.is.F");
			response.setRenderParameter("InCorrectPan", "FourthcharPan.is.F");
			
			return false;
		}
	}
	
	return super.validate(request, response, formMap);
		
	
}
}




