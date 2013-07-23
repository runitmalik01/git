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
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=TdsFromothersDocument.class)
@ChildBean(childBeanClass=TdsOthersDetail.class)

@FormFields(fieldNames={"tan_deductortdsoth","name_deductortdsoth","tds_certificatetdsoth","financial_yeartdsoth","total_taxdeductedtdsoth","amounttdsoth"})

public class TdsFromOthers extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of tds from salary");
		}
		
		request.getAttribute("financialYear");
		int eight=FinancialYear.TwentyEight.getStartYear();
		request.setAttribute("eight", eight);
		int nine=FinancialYear.TwentyNine.getStartYear();
		request.setAttribute("nine", nine);
		int ten=FinancialYear.TwentyTen.getStartYear();
		request.setAttribute("ten", ten);
		int eleven=FinancialYear.TwentyEleven.getStartYear();
		request.setAttribute("eleven", eleven);
		int twelve=FinancialYear.TwentyTweleve.getStartYear();
		request.setAttribute("twelve", twelve);
		int thirteen=FinancialYear.TwentyThirteen.getStartYear();
		request.setAttribute("thirteen", thirteen);
		int forteen=FinancialYear.TwentyForteen.getStartYear();
		request.setAttribute("forteen", forteen);
		int fifteen=FinancialYear.TwentyFifteen.getStartYear();
		request.setAttribute("fifteen", fifteen);
		
		if(log.isInfoEnabled()){
			log.info("checking financial ye"+fifteen);
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of tds from salary");
		}
		
	} }
	
	
	

