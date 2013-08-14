package com.mootly.wcm.model.schedules.y2012_2013;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ScreenCalculatorService;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTTI;

public class PartB_TTI {

	FormSixteenDocument formSixteenDocument = null;
	SalaryIncomeDocument salaryIncomeDocument = null;
	HouseProperty housePropertyDocument = null;
	OtherSourcesDocument otherSourcesDocument = null;
	DeductionDocument deductionDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;

	public PartB_TTI(FormSixteenDocument formSixteenDocument, SalaryIncomeDocument salaryIncomeDocument, HouseProperty housePropertyDocument ,
			OtherSourcesDocument otherSourcesDocument, DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation){
		this.formSixteenDocument = formSixteenDocument;
		this.salaryIncomeDocument = salaryIncomeDocument;
		this.housePropertyDocument = housePropertyDocument;
		this.otherSourcesDocument = otherSourcesDocument;
		this.deductionDocument = deductionDocument;
		this.memberPersonalInformation = memberPersonalInformation;
	}

	public PartBTTI getPartBTTI(ITR itr, FinancialYear financialYear, Map<String,HippoBean> inputBeans){
		PartBTTI partBTTI = new PartBTTI();
		PartB_TI partB_TI = new PartB_TI(formSixteenDocument, salaryIncomeDocument, housePropertyDocument, otherSourcesDocument, deductionDocument, memberPersonalInformation);
		PartBTI partBTI = partB_TI.getPartBTI(itr, financialYear, inputBeans);
		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>(); //not being used any where

		long aggregateIncome = 0;
		aggregateIncome = partBTI.getAggregateIncome().longValue();

		Map<String,Object> totalMapForJS = new HashMap<String, Object>();

		totalMapForJS.put("cbassyear",financialYear.getDisplayAssessmentYear());
		totalMapForJS.put("cbasstype", memberPersonalInformation.getFilingStatus());
		totalMapForJS.put("cbresistatus",memberPersonalInformation.getResidentCategory());

		if(aggregateIncome>0)
			totalMapForJS.put("txtNetIncome",aggregateIncome);
		if(aggregateIncome<=0)
			totalMapForJS.put("txtNetIncome",0);
		boolean isSeniorCitizen = financialYear.isSeniorCitizen(memberPersonalInformation.getDOB().getTime());
		if(isSeniorCitizen){
			boolean isSuperSeniorCitizen = financialYear.isSuperSeniorCitizen(memberPersonalInformation.getDOB().getTime());
			if(isSuperSeniorCitizen){
				totalMapForJS.put("cbasscategory","Super Senior Citizen");
			}else
				totalMapForJS.put("cbasscategory","Senior Citizen");
		}
		else
			totalMapForJS.put("cbasscategory",memberPersonalInformation.getSex());

		Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", requestParameterMap, totalMapForJS);
		//ITR1 Tax Computation (without calculation) with null values
		//itr1TaxComputation.setTotalTaxPayable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtTax").toString())));

		return partBTTI;
	}
}
