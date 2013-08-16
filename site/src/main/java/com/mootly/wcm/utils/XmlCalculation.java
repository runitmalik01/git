package com.mootly.wcm.utils;


import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;


@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class,
		HouseIncomeDetail.class,HouseProperty.class,OtherSourcesDocument.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class,TdsFromSalaryDocument.class,
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class,FormSixteenDocument.class,FormSixteenDetail.class,
		AdjustmentOfLossesDoc.class,AdjustmentOfLossesCom.class})

public class XmlCalculation implements XmlCalculationImplement {

	//Declare global variables to use them in various Schedules
	public long longsalarytotal=0;
	public long houseIncome=0;
	public long houseIncomeTotal=0;
	public long grosstotal=0;
	public long otherincome=0;

	public Double HPLoss = 0d;
	public Double totalHPLoss = 0d;
	public Double LTCLoss = 0d;
	public Double totalLTCLoss = 0d;
	public Double STCLoss = 0d;
	public Double totalSTCLoss = 0d;
	public Double MaintainingRaceHorseLoss = 0d;
	public Double totalMaintainingRaceHorseLoss = 0d;

	/**
	 * This Method is used to return Gross Total(SalaryIncome+HouseIncome+OtherIncome)
	 * @return long
	 * @param request, response
	 *
	 * */

	@Override
	public long grossTotal(HstRequest request,HstResponse response){
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		//HouseIncomeDetail houseIncomeDetail = (HouseIncomeDetail) inputBeans.get(HouseIncomeDetail.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		//BigInteger salarytotal=new BigInteger("0");
		BigInteger GrossIncome=new BigInteger("0");
		BigInteger GrossIncomeTotal=new BigInteger("0");

		if( formSixteenDocument!=null){
			if ( formSixteenDocument.getFormSixteenDetailList() != null && formSixteenDocument.getFormSixteenDetailList().size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:formSixteenDocument.getFormSixteenDetailList()){
					if(formSixteenDetail.getIncome_chargable_tax()!=null){
						GrossIncome=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax());
						GrossIncomeTotal=GrossIncomeTotal.add(GrossIncome);
					}
				}
			}
		}
		BigInteger Penson=new BigInteger("0");
		if(salaryIncomeDocument!=null){
			Penson = indianCurrencyHelper.bigIntegerRound(salaryIncomeDocument.getTotal());
		}
		BigInteger TotalSalaryIncome=new BigInteger("0");
		TotalSalaryIncome = GrossIncomeTotal.add(Penson);
		longsalarytotal = TotalSalaryIncome.longValue();

		if(houseProperty!=null){
			if (houseProperty.getHouseIncomeDetailList() != null && houseProperty.getHouseIncomeDetailList().size() > 0 ){
				for(HouseIncomeDetail houseIncomeDetail: houseProperty.getHouseIncomeDetailList()){
					houseIncome = indianCurrencyHelper.longRound(houseIncomeDetail.getIncome_hproperty());
					houseIncomeTotal = houseIncomeTotal+houseIncome;
				}
			}
		}

		if(otherSourcesDocument!=null){
			otherincome = indianCurrencyHelper.longRound(otherSourcesDocument.getTaxable_income());
		}
		grosstotal = longsalarytotal+houseIncomeTotal+otherincome;

		return grosstotal;
	}

	public long grossTotal(FinancialYear financialYear,Map<String,HippoBean> inputBeans){
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) inputBeans.get(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		//HouseIncomeDetail houseIncomeDetail = (HouseIncomeDetail) inputBeans.get(HouseIncomeDetail.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) inputBeans.get(FormSixteenDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) inputBeans.get(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) inputBeans.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		//BigInteger salarytotal=new BigInteger("0");
		BigInteger GrossIncome=new BigInteger("0");
		BigInteger GrossIncomeTotal=new BigInteger("0");

		if( formSixteenDocument!=null){
			if ( formSixteenDocument.getFormSixteenDetailList() != null && formSixteenDocument.getFormSixteenDetailList().size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:formSixteenDocument.getFormSixteenDetailList()){
					if(formSixteenDetail.getIncome_chargable_tax()!=null){
						GrossIncome=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax());
						GrossIncomeTotal=GrossIncomeTotal.add(GrossIncome);
					}
				}
			}
		}
		BigInteger Penson=new BigInteger("0");
		if(salaryIncomeDocument!=null){
			Penson = indianCurrencyHelper.bigIntegerRound(salaryIncomeDocument.getTotal());
		}
		BigInteger TotalSalaryIncome=new BigInteger("0");
		TotalSalaryIncome = GrossIncomeTotal.add(Penson);
		longsalarytotal = TotalSalaryIncome.longValue();

		if(houseProperty!=null){
			if (houseProperty.getHouseIncomeDetailList() != null && houseProperty.getHouseIncomeDetailList().size() > 0 ){
				for(HouseIncomeDetail houseIncomeDetail: houseProperty.getHouseIncomeDetailList()){
					houseIncome = indianCurrencyHelper.longRound(houseIncomeDetail.getIncome_hproperty());
					houseIncomeTotal = houseIncomeTotal+houseIncome;
				}
			}
		}

		if(otherSourcesDocument!=null){
			otherincome = indianCurrencyHelper.longRound(otherSourcesDocument.getTaxable_income());
		}
		grosstotal = longsalarytotal+houseIncomeTotal+otherincome;

		return grosstotal;
	}

	/**
	 * This Method is used for Losses Calculation
	 * @return void
	 * @param request, response
	 * Added on 26/07/2013 by Dhananjay
	 * */

	public Map<String,Object> lossesCalc(HstRequest request,HstResponse response){

		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) request.getAttribute(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());
		grossTotal(request, response);

		if(adjustmentOfLossesDoc != null){
			List<AdjustmentOfLossesCom> listofAdjustmentOfLossesCom = adjustmentOfLossesDoc.getAdjustmentOfLossesList() ;
			if ( listofAdjustmentOfLossesCom != null && listofAdjustmentOfLossesCom.size() > 0 ){
				for(AdjustmentOfLossesCom adjustmentOfLossesCom:listofAdjustmentOfLossesCom){
					if(adjustmentOfLossesCom.getNameOfHead().equals("House Property Loss")){
						HPLoss = adjustmentOfLossesCom.getAmount();
						totalHPLoss = totalHPLoss + HPLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Long Term Capital Loss")){
						LTCLoss = adjustmentOfLossesCom.getAmount();
						totalLTCLoss = totalLTCLoss + LTCLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Short Term Capital Loss")){
						STCLoss = adjustmentOfLossesCom.getAmount();
						totalSTCLoss = totalSTCLoss + STCLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Owning and Maintaining Race Horses")){
						MaintainingRaceHorseLoss = adjustmentOfLossesCom.getAmount();
						totalMaintainingRaceHorseLoss = totalMaintainingRaceHorseLoss + MaintainingRaceHorseLoss;
					}
				}
			}
		}
		Map<String,Object> totalMapForLosses = new HashMap<String, Object>();
		totalMapForLosses.put("salaryIncome",longsalarytotal);
		totalMapForLosses.put("houseIncome",houseIncomeTotal);
		totalMapForLosses.put("otherIncome",otherincome);
		totalMapForLosses.put("maintainingRaceHorseIncome",0);
		totalMapForLosses.put("LTCGain",0);
		totalMapForLosses.put("STCGain",0);
		totalMapForLosses.put("houseIncomeLoss", totalHPLoss);
		totalMapForLosses.put("LTCLoss", totalLTCLoss);
		totalMapForLosses.put("STCLoss", totalSTCLoss);
		totalMapForLosses.put("MaintainingRaceHorseLoss", totalMaintainingRaceHorseLoss);

		Map<String,Object> resultMapLosses = ScreenCalculatorService.getScreenCalculations("lossesCalculation.js", request.getParameterMap(), totalMapForLosses);

		return resultMapLosses;
	}

	public Map<String,Object> lossesCalc(FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) inputBeans.get(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) inputBeans.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) inputBeans.get(HouseProperty.class.getSimpleName().toLowerCase());
		grossTotal(financialYear, inputBeans);

		if(adjustmentOfLossesDoc != null){
			List<AdjustmentOfLossesCom> listofAdjustmentOfLossesCom = adjustmentOfLossesDoc.getAdjustmentOfLossesList() ;
			if ( listofAdjustmentOfLossesCom != null && listofAdjustmentOfLossesCom.size() > 0 ){
				for(AdjustmentOfLossesCom adjustmentOfLossesCom:listofAdjustmentOfLossesCom){
					if(adjustmentOfLossesCom.getNameOfHead().equals("House Property Loss")){
						HPLoss = adjustmentOfLossesCom.getAmount();
						totalHPLoss = totalHPLoss + HPLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Long Term Capital Loss")){
						LTCLoss = adjustmentOfLossesCom.getAmount();
						totalLTCLoss = totalLTCLoss + LTCLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Short Term Capital Loss")){
						STCLoss = adjustmentOfLossesCom.getAmount();
						totalSTCLoss = totalSTCLoss + STCLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Owning and Maintaining Race Horses")){
						MaintainingRaceHorseLoss = adjustmentOfLossesCom.getAmount();
						totalMaintainingRaceHorseLoss = totalMaintainingRaceHorseLoss + MaintainingRaceHorseLoss;
					}
				}
			}
		}
		double incomeOtherThanRaceHorse = 0;
		double incomeFromRaceHorse = 0;
		if(otherSourcesDocument != null){
			incomeOtherThanRaceHorse = otherSourcesDocument.getTotalint() + otherSourcesDocument.getTotalOther_income() - otherSourcesDocument.getTotalexpense();
			incomeFromRaceHorse =  otherSourcesDocument.getBalance();
		}
		double incomeHouseProperty = 0;
		if(houseProperty != null){
			incomeHouseProperty = houseProperty.getTotal_HouseIncome();
		}
		Map<String,Object> totalMapForLosses = new HashMap<String, Object>();
		totalMapForLosses.put("salaryIncome",longsalarytotal);
		totalMapForLosses.put("houseIncome",incomeHouseProperty);
		totalMapForLosses.put("otherIncome",incomeOtherThanRaceHorse);
		totalMapForLosses.put("maintainingRaceHorseIncome",incomeFromRaceHorse);
		totalMapForLosses.put("LTCGain",0);
		totalMapForLosses.put("STCGain",0);
		totalMapForLosses.put("houseIncomeLoss", totalHPLoss);
		totalMapForLosses.put("LTCLoss", totalLTCLoss);
		totalMapForLosses.put("STCLoss", totalSTCLoss);
		totalMapForLosses.put("MaintainingRaceHorseLoss", totalMaintainingRaceHorseLoss);
		Map<String,String[]> paramMap = new HashMap<String, String[]>();
		Map<String,Object> resultMapLosses = ScreenCalculatorService.getScreenCalculations("lossesCalculation.js", paramMap, totalMapForLosses);

		return resultMapLosses;
	}

	/**
	 * This Method is used for Interest Calculation
	 * @return Map
	 * @param Finincial Year, Input Beans, BigInteger
	 * Added on 15/08/2013 by Dhananjay
	 * */

	public Map<String,Object> interestCalc(FinancialYear financialYear,Map<String,HippoBean> inputBeans, BigInteger netTaxLiability){

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) inputBeans.get(AdvanceTaxDocument.class.getSimpleName().toLowerCase());

		//current date
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		final Date currentdate=cal.getTime();
		//conversion of date into string
		String strDate=new Date().toString();
		//current month
		@SuppressWarnings("deprecation")
		int year=currentdate.getYear()+1900-1;
		int currentdatemonth = 0;

		//Added on 06/08/2013 for Checking Conditions for Due Date
		long DueDate = 0;
		boolean isPastDue = financialYear.isPastDue(memberPersonalInformation.getSelectedITRForm(), memberPersonalInformation.getState());
		if (isPastDue) {
			if(memberPersonalInformation.getState().equals("34")){
				DueDate = 10;
			}else{
				DueDate = 7;
			}
		}
		else {
			DueDate = 0;
		}

		//end of due date selection

		if(year==2012){
			currentdatemonth =currentdate.getMonth()+1;
		}else
			if(year==2013){
				currentdatemonth =currentdate.getMonth()+1+12;
			}

		double dtotalamount=0.0d;
		double dsum1=0.0d;
		double dsum2=0.0d;
		double dsum3=0.0d;
		double dsum4=0.0d;
		double dsum5=0.0d;
		double dsum12=0.0d;

		if(advanceTaxDocument!= null){

			dtotalamount = advanceTaxDocument.getTotal_Amount();
			dsum1=advanceTaxDocument.getTotal_Sum1();
			dsum2=advanceTaxDocument.getTotal_Sum2();
			dsum3=advanceTaxDocument.getTotal_Sum3();
			dsum4=advanceTaxDocument.getTotal_Sum4();
			dsum5=advanceTaxDocument.getTotal_Sum5();
			dsum12=dsum1+dsum2;

		}
		Map<String,Object> totalMapForINTREST = new HashMap<String, Object>();
		totalMapForINTREST.put("aytaxmp",currentdatemonth);
		totalMapForINTREST.put("ddate", DueDate);
		totalMapForINTREST.put("aytaxd", netTaxLiability.longValue());
		totalMapForINTREST.put("aytaxp", dtotalamount);
		totalMapForINTREST.put("atpq2", dsum12);
		totalMapForINTREST.put("atpq3", dsum3+dsum12);
		totalMapForINTREST.put("atpq4", dsum4+dsum3+dsum12);
		totalMapForINTREST.put("atlq2", 0);
		totalMapForINTREST.put("atlq3", 0);
		totalMapForINTREST.put("atlq4", 0);
		Map<String,String[]> paramMap = new HashMap<String, String[]>();
		Map<String,Object> resultMapINTEREST = ScreenCalculatorService.getScreenCalculations("interestCalculation.js", paramMap, totalMapForINTREST);

		return resultMapINTEREST;
	}

	/**
	 * This Method is used for Tax Calculation
	 * @return Map
	 * @param Finincial Year, Input Beans, long
	 * Added on 16/08/2013 by Dhananjay
	 * */

	public Map<String,Object> taxCalc(FinancialYear financialYear,Map<String,HippoBean> inputBeans, long taxableIncome){

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());

		Map<String,Object> totalMapForJS = new HashMap<String, Object>();
		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>(); //not being used any where

		totalMapForJS.put("cbassyear",financialYear.getDisplayAssessmentYear());
		totalMapForJS.put("cbasstype", memberPersonalInformation.getFilingStatus());
		totalMapForJS.put("cbresistatus",memberPersonalInformation.getResidentCategory());
		totalMapForJS.put("txtNetIncome",taxableIncome);
		boolean SeniorCitizen = financialYear.isSeniorCitizen(memberPersonalInformation.getDOB().getTime());
		if(SeniorCitizen){
			boolean SuperSeniorCitizen = financialYear.isSuperSeniorCitizen(memberPersonalInformation.getDOB().getTime());
			if(SuperSeniorCitizen){
				totalMapForJS.put("cbasscategory","Super Senior Citizen");
			}else
				totalMapForJS.put("cbasscategory","Senior Citizen");
		}
		else
			totalMapForJS.put("cbasscategory",memberPersonalInformation.getSex());

		Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", requestParameterMap, totalMapForJS);

		return resultMap;
	}

}
