package com.mootly.wcm.utils;


import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBPA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCGFor4;
import in.gov.incometaxindiaefiling.y2012_2013.TaxPayment;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.ScheduleDPMDetails;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.member.MonthCalculate;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.schedules.y2012_2013.CapitalGainScheduleFor4;
import com.mootly.wcm.model.schedules.y2012_2013.ITR3_ScheduleBPA;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4_ScheduleBP;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;


@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class,
		HouseIncomeDetail.class,HouseProperty.class,OtherSourcesDocument.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class,TdsFromSalaryDocument.class,
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class,FormSixteenDocument.class,FormSixteenDetail.class,
		AdjustmentOfLossesDoc.class,AdjustmentOfLossesCom.class})

public class XmlCalculation implements XmlCalculationImplement {

	private static final Logger log = LoggerFactory.getLogger(XmlCalculation.class);
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
	public Double LossFrmSpecifiedBuss = 0d;
	public Double totalLossFrmSpecifiedBuss = 0d;
	public Double NonSpeculationBusinessLoss = 0d;
	public Double totalNonSpeculationBusinessLoss = 0d;
	public Double SpeculationBusinessLoss = 0d;
	public Double totalSpeculationBusinessLoss = 0d;
	public Double BusinessorProfessionLoss = 0d;
	public Double totalBusinessorProfessionLoss = 0d;

	// for ITR4
	public long businessIncome = 0;
	public long speculativeIncome = 0;
	public long specifiedIncome = 0;
	public Double shortTermCG = 0d;
	public Double longTermCG = 0d;

	/**
	 * This Method is used to return Gross Total(SalaryIncome+HouseIncome+OtherIncome)
	 * @return long
	 * @param request, response
	 * @author Dhananjay
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
	 * Added on 26/07/2013
	 * @author Dhananjay
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

	/**
	 * This Method is used for Losses Calculation
	 * @return Map
	 * @param FinancialYear, inputBeans
	 * Added on 26/07/2013
	 * @author Dhananjay
	 * */

	public Map<String,Object> lossesCalc(FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) inputBeans.get(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) inputBeans.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) inputBeans.get(HouseProperty.class.getSimpleName().toLowerCase());
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		String itrSelection =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");

		//added for ITR4 on 26-sep-2012 by Dhananjay
		IncBusinessProfessionDoc incBusinessProfessionDoc = (IncBusinessProfessionDoc) inputBeans.get(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase());
		ProfitAndLossDocument profitAndLossDocument = (ProfitAndLossDocument) inputBeans.get(ProfitAndLossDocument.class.getSimpleName().toLowerCase());
		OtherInformationDocument otherInformationDocument = (OtherInformationDocument) inputBeans.get(OtherInformationDocument.class.getSimpleName().toLowerCase());
		ScheduleDPMDocument scheduleDPMDocument = (ScheduleDPMDocument) inputBeans.get(ScheduleDPMDocument.class.getSimpleName().toLowerCase());
		ScheduleDOADocument scheduleDOADocument = (ScheduleDOADocument) inputBeans.get(ScheduleDOADocument.class.getSimpleName().toLowerCase());
		ScheduleESRDocument scheduleESRDocument = (ScheduleESRDocument) inputBeans.get(ScheduleESRDocument.class.getSimpleName().toLowerCase());
		DeductionSchedTenADocumemt deductionSchedTenADocumemt = (DeductionSchedTenADocumemt) inputBeans.get(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase());
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) inputBeans.get(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		IncomeFromFirmsDocument incomeFromFirmsDocument = (IncomeFromFirmsDocument) inputBeans.get(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase());

		grossTotal(financialYear, inputBeans);
		Map<String,Map<String, Object>> resultMap = capitalGainChilds(financialYear, inputBeans);
		// getting Schedule BP to get values of Business Income, Speculative Income and Specified Income

		ITR4_ScheduleBP iTR4_ScheduleBP = new ITR4_ScheduleBP(incBusinessProfessionDoc,profitAndLossDocument,otherInformationDocument,
				scheduleDPMDocument,scheduleDOADocument,scheduleESRDocument,deductionSchedTenADocumemt);
		ITR4ScheduleBP iTR4ScheduleBP = iTR4_ScheduleBP.getITR4ScheduleBP(null, financialYear, inputBeans);

		if(itrSelection.equals("ITR4")){
			businessIncome = iTR4ScheduleBP.getBusinessIncOthThanSpec().getNetPLBusOthThanSpec7A7B7C();
			speculativeIncome = iTR4ScheduleBP.getSpecBusinessInc().getAdjustedPLFrmSpecuBus();
			specifiedIncome = iTR4ScheduleBP.getSpecifiedBusinessInc().getPLFrmSpecifiedBus();

			//here what we are trying to do we will adjust business income loss with specified income and speculative income
			if(businessIncome < 0){
				if(specifiedIncome > 0){
					businessIncome = businessIncome + specifiedIncome;
					if(businessIncome>0){
						specifiedIncome = businessIncome;
						businessIncome = 0;
					}else
						specifiedIncome = 0;
				}
				if(speculativeIncome > 0){
					businessIncome = businessIncome + speculativeIncome;
				}
				if(businessIncome>0){
					speculativeIncome = businessIncome;
					businessIncome = 0;
				}else
					speculativeIncome = 0;
			}

			CapitalGainScheduleFor4 capitalGainScheduleFor4= new CapitalGainScheduleFor4(capitalAssetDocument,scheduleDPMDocument,scheduleDOADocument);
			ScheduleCGFor4 scheduleCGFor4 = capitalGainScheduleFor4.getScheduleCGFor4(null, financialYear, inputBeans);
			shortTermCG = (double) scheduleCGFor4.getShortTermCapGainFor4().getTotalSTCG();
			longTermCG = (double) scheduleCGFor4.getLongTermCapGain4().getTotalLTCG();
		}else{
			shortTermCG = Double.parseDouble(resultMap.get("STCGSST").get("totCG").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("totCG").toString());
			longTermCG = Double.parseDouble(resultMap.get("LTCGINDEX").get("totCG").toString()) + Double.parseDouble(resultMap.get("LTCGNINDEX").get("totCG").toString());
			if(incomeFromFirmsDocument != null)
				businessIncome = incomeFromFirmsDocument.getVal_NetIncome().longValue();
		}

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
					//added for ITR4
					if(adjustmentOfLossesCom.getNameOfHead().equals("Loss From Specified Business")){
						LossFrmSpecifiedBuss = adjustmentOfLossesCom.getAmount();
						totalLossFrmSpecifiedBuss = totalLossFrmSpecifiedBuss + LossFrmSpecifiedBuss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Non Speculation Business Loss")){
						NonSpeculationBusinessLoss = adjustmentOfLossesCom.getAmount();
						totalNonSpeculationBusinessLoss = totalNonSpeculationBusinessLoss + NonSpeculationBusinessLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Speculation Business Loss")){
						SpeculationBusinessLoss = adjustmentOfLossesCom.getAmount();
						totalSpeculationBusinessLoss = totalSpeculationBusinessLoss + SpeculationBusinessLoss;
					}
					//end
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
		totalMapForLosses.put("itrSelection",itrSelection);
		totalMapForLosses.put("salaryIncome",longsalarytotal);
		totalMapForLosses.put("houseIncome",incomeHouseProperty);
		totalMapForLosses.put("otherIncome",incomeOtherThanRaceHorse);
		totalMapForLosses.put("maintainingRaceHorseIncome",incomeFromRaceHorse);
		totalMapForLosses.put("LTCGain",longTermCG);
		totalMapForLosses.put("STCGain",shortTermCG);
		totalMapForLosses.put("houseIncomeLoss", totalHPLoss);
		totalMapForLosses.put("LTCLoss", totalLTCLoss);
		totalMapForLosses.put("STCLoss", totalSTCLoss);
		totalMapForLosses.put("MaintainingRaceHorseLoss", totalMaintainingRaceHorseLoss);

		//added for ITR4
		totalMapForLosses.put("businessIncome",businessIncome);
		if(speculativeIncome > 0){
			totalMapForLosses.put("speculativeIncome",speculativeIncome);
		}else
			totalMapForLosses.put("speculativeIncome",0);
		if(specifiedIncome > 0){
			totalMapForLosses.put("specifiedIncome",specifiedIncome);
		}else
			totalMapForLosses.put("specifiedIncome",0);
		totalMapForLosses.put("LossFrmSpecifiedBuss", totalLossFrmSpecifiedBuss);
		totalMapForLosses.put("NonSpeculationBusinessLoss", totalNonSpeculationBusinessLoss);
		totalMapForLosses.put("SpeculationBusinessLoss", totalSpeculationBusinessLoss);
		//end

		Map<String,String[]> paramMap = new HashMap<String, String[]>();
		Map<String,Object> resultMapLosses = ScreenCalculatorService.getScreenCalculations("lossesCalculation.js", paramMap, totalMapForLosses);

		return resultMapLosses;
	}

	/**
	 * This Method is used for Interest Calculation
	 * @return Map
	 * @param Finincial Year, Input Beans, BigInteger
	 * Added on 15/08/2013
	 * @author Dhananjay
	 * @throws ParseException
	 * */

	public Map<String,Object> interestCalc(FinancialYear financialYear,Map<String,HippoBean> inputBeans, BigInteger netTaxLiability){

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) inputBeans.get(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) inputBeans.get(FormSixteenDocument.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) inputBeans.get(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) inputBeans.get(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) inputBeans.get(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());

		IndianCurrencyHelper indianCurrencyHelper =  new IndianCurrencyHelper();
		Map<String,Object> totalMapForJS = new HashMap<String, Object>();
		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>(); //not being used any where

		BigInteger bigTdsSlry=new BigInteger ("0");
		BigInteger bigTotalTdsSlry=new BigInteger ("0");
		Double tdsSalary = 0d;
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList();
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					Double tds1 = 0d;
					Double tds2 = 0d;
					if(formSixteenDetail.getDed_ent_1()!=null)
						tds1 = formSixteenDetail.getDed_ent_1();
					if(formSixteenDetail.getDed_ent_3()!=null)
						tds2 = formSixteenDetail.getDed_ent_3();
					tdsSalary =tds1 + tds2;
					bigTdsSlry=indianCurrencyHelper.bigIntegerRound(tdsSalary);
					bigTotalTdsSlry= bigTotalTdsSlry.add(bigTdsSlry);

				}
			}
		}
		BigInteger bigTdsPension = new BigInteger("0");
		BigInteger bigTotalTdsPension = new BigInteger("0");
		if( salaryIncomeDocument!=null){
			List<SalaryIncomeDetail> listOfSalaryIncomeDetail = salaryIncomeDocument.getSalaryIncomeDetailList();
			if ( listOfSalaryIncomeDetail != null && listOfSalaryIncomeDetail.size() > 0 ){
				for(SalaryIncomeDetail salaryIncomeDetail:listOfSalaryIncomeDetail){
					if(salaryIncomeDetail.getTdsPension()!=null){
						bigTdsPension=indianCurrencyHelper.bigIntegerRound(salaryIncomeDetail.getTdsPension());
						bigTotalTdsPension= bigTotalTdsPension.add(bigTdsPension);
					}
				}
			}
		}
		BigInteger bigTdsOther=new BigInteger ("0");
		if(tdsFromothersDocument!=null){
			bigTdsOther=indianCurrencyHelper.bigIntegerRound(tdsFromothersDocument.getTotal_Amount());
		}
		BigInteger TDS = new BigInteger("0");
		TDS = bigTotalTdsSlry.add(bigTdsOther).add(bigTotalTdsPension);
		BigInteger TaxLiability = new BigInteger("0");
		TaxLiability = netTaxLiability.subtract(TDS);

		/*
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
		 */
		int diffInMonths = 0;
		DateFormat formatter ;
		Date currentDate = null;
		Date fixedDueDate = null;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			currentDate = formatter.parse(ITRXmlGeneratorServiceCommon.getCurrentDateInIndiaAsString());
			fixedDueDate = indianCurrencyHelper.parsedate("31/07/"+financialYear.getEndYear());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date varDueDate = financialYear.getDueDate(memberPersonalInformation.getSelectedITRForm(), memberPersonalInformation.getState()).getTime();

		if(currentDate.after(varDueDate)){
			diffInMonths = indianCurrencyHelper.getDiffInMonths(fixedDueDate, currentDate);
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

		double nettaxLiability = TaxLiability.doubleValue() - dtotalamount;
		Interest234BCalc interest234BCalc = new Interest234BCalc();
		Double intB = interest234BCalc.getInterest235B(financialYear, nettaxLiability, TaxLiability.doubleValue(), selfAssesmetTaxDocument);

		Map<String,Object> totalMapForINTREST = new HashMap<String, Object>();

		//totalMapForINTREST.put("aytaxmp",currentdatemonth);
		//totalMapForINTREST.put("ddate", DueDate);
		totalMapForINTREST.put("aytaxd", TaxLiability.longValue());
		totalMapForINTREST.put("aytaxp", dtotalamount);
		totalMapForINTREST.put("atpq2", dsum12);
		totalMapForINTREST.put("atpq3", dsum3+dsum12);
		totalMapForINTREST.put("atpq4", dsum4+dsum3+dsum12);
		totalMapForINTREST.put("atlq2", 0);
		totalMapForINTREST.put("atlq3", 0);
		totalMapForINTREST.put("atlq4", 0);
		totalMapForINTREST.put("resultIntB", intB);
		totalMapForINTREST.put("dueDateFor234A", diffInMonths);
		Map<String,String[]> paramMap = new HashMap<String, String[]>();
		Map<String,Object> resultMapINTEREST = ScreenCalculatorService.getScreenCalculations("interestCalculation.js", paramMap, totalMapForINTREST);

		return resultMapINTEREST;
	}

	/**
	 * This Method is used for Tax Calculation
	 * @return Map
	 * @param Finincial Year, Input Beans, long
	 * Added on 16/08/2013
	 * @author Dhananjay
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

	/**
	 * This Method is used to put losses details in xml
	 * @return Map
	 * @param Finincial Year, Input Beans
	 * Added on 17/08/2013
	 * @author Dhananjay
	 * */

	public Map<String,List<AdjustmentOfLossesCom>> lossesCFLChilds(FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) inputBeans.get(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());
		Map<String,List<AdjustmentOfLossesCom>> totalMapForJS = new HashMap<String, List<AdjustmentOfLossesCom>>();

		List<AdjustmentOfLossesCom> lossesDetails = adjustmentOfLossesDoc.getAdjustmentOfLossesList();
		if ( lossesDetails != null && lossesDetails.size() > 0 ){
			for(AdjustmentOfLossesCom adjustmentOfLossesCom:lossesDetails){
				List<AdjustmentOfLossesCom> childBean = new ArrayList<AdjustmentOfLossesCom>();
				int diff = indianCurrencyHelper.diffBtwAssessmentYear(financialYear,adjustmentOfLossesCom.getAssessmentYear());
				if(totalMapForJS.containsKey(String.valueOf(diff))&& (!totalMapForJS.isEmpty())){
					childBean =  totalMapForJS.get(String.valueOf(diff));
					childBean.add(adjustmentOfLossesCom);
					totalMapForJS.put(String.valueOf(diff), childBean);
				}else{
					childBean.add(adjustmentOfLossesCom);
					totalMapForJS.put(String.valueOf(diff), childBean);
				}
			}
		}
		return totalMapForJS;
	}

	/**
	 * This Method is used to get total of SI
	 * @return Map
	 * @param Finincial Year, Input Beans
	 * Added on 22/08/2013
	 * @author Dhananjay
	 * */

	public Map<String,Double> getSumOfScheduleSIisInActiveSection(FinancialYear financialYear, Map<String , HippoBean> inputBean){

		Map<String,Double> resultMap = new HashMap<String, Double>();
		Double sumInActiveSection = 0d;
		Double totalCalTax = 0d;
		Double minChargeIncome = 0d;
		//ScheduleSIDocument siDoc = (ScheduleSIDocument) inputBean.get(ScheduleSIDocument.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) inputBean.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) inputBean.get(CapitalAssetDocument.class.getSimpleName().toLowerCase());

		if(capitalAssetDocument != null){
			Map<String, Map<String, Object>> resultScheduleSISection = capitalAssetDocument.getScheduleSIService(financialYear, inputBean);
			for(String key : resultScheduleSISection.keySet()){
				sumInActiveSection = sumInActiveSection + Double.parseDouble(resultScheduleSISection.get(key).get("userAmount").toString());
				totalCalTax = totalCalTax + Double.parseDouble(resultScheduleSISection.get(key).get("taxOnIncome").toString());
				minChargeIncome = minChargeIncome + Double.parseDouble(resultScheduleSISection.get(key).get("minChargIncome").toString());
			}
		}
		if(otherSourcesDocument != null){
			Map<String, Map<String, Object>> resultScheduleSISection = otherSourcesDocument.getScheduleSIService(financialYear, inputBean);
			for(String key : resultScheduleSISection.keySet()){
				sumInActiveSection = sumInActiveSection + Double.parseDouble(resultScheduleSISection.get(key).get("userAmount").toString());
				totalCalTax = totalCalTax + Double.parseDouble(resultScheduleSISection.get(key).get("taxOnIncome").toString());
				minChargeIncome = minChargeIncome + Double.parseDouble(resultScheduleSISection.get(key).get("minChargIncome").toString());
			}
		}
		resultMap.put("sumInActiveSection", sumInActiveSection);
		resultMap.put("totalCalTax", totalCalTax);
		resultMap.put("minChargeIncome", minChargeIncome);

		return resultMap;
	}

	/**
	 * This Method is used to get details of Capital Gain
	 * @return Map
	 * @param Finincial Year, Input Beans
	 * Added on 23/08/2013
	 * @author Dhananjay
	 * */

	public Map<String,Map<String, Object>> capitalGainChilds(FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) inputBeans.get(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		Map<String,List<CapitalAssetDetail>> totalMapForJS = new HashMap<String, List<CapitalAssetDetail>>();
		Map<String,Map<String, Object>> resultMap = new HashMap<String,Map<String, Object>>();
		Map<String, Object> resultMapSTCGSST = new HashMap<String, Object>();
		Map<String, Object> resultMapSTCGNSST = new HashMap<String, Object>();
		Map<String, Object> resultMapLTCGNINDEX = new HashMap<String, Object>();
		Map<String, Object> resultMapLTCGINDEX = new HashMap<String, Object>();

		totalMapForJS.put("STCGSST", new ArrayList<CapitalAssetDetail>());
		totalMapForJS.put("STCGNSST", new ArrayList<CapitalAssetDetail>());
		totalMapForJS.put("LTCGNINDEX", new ArrayList<CapitalAssetDetail>());
		totalMapForJS.put("LTCGINDEX", new ArrayList<CapitalAssetDetail>());
		if(capitalAssetDocument != null){
			List<CapitalAssetDetail> capitalGainDetails = capitalAssetDocument.getCapitalAssetDetailList();
			if ( capitalGainDetails != null && capitalGainDetails.size() > 0 ){
				for(CapitalAssetDetail capitalAssetDetail:capitalGainDetails){
					List<CapitalAssetDetail> shortTermChildBean = new ArrayList<CapitalAssetDetail>();
					List<CapitalAssetDetail> longTermChildBean = new ArrayList<CapitalAssetDetail>();

					if(capitalAssetDetail.getCapitalGainTaxST() != null && capitalAssetDetail.getAssetType().equals("SHARES") && capitalAssetDetail.getSstCharge().equals("Y")){
						if(totalMapForJS.containsKey("STCGSST")&& (!totalMapForJS.isEmpty())){
							shortTermChildBean =  totalMapForJS.get("STCGSST");
							shortTermChildBean.add(capitalAssetDetail);
							totalMapForJS.put("STCGSST", shortTermChildBean);
						}else{
							shortTermChildBean.add(capitalAssetDetail);
							totalMapForJS.put("STCGSST", shortTermChildBean);
						}
					}else if((capitalAssetDetail.getCapitalGainTaxST() != null && capitalAssetDetail.getAssetType().equals("SHARES") && capitalAssetDetail.getSstCharge().equals("N"))||
							(capitalAssetDetail.getCapitalGainTaxST() != null && capitalAssetDetail.getAssetType().equals("OTH"))){
						if(totalMapForJS.containsKey("STCGNSST")&& (!totalMapForJS.isEmpty())){
							shortTermChildBean =  totalMapForJS.get("STCGNSST");
							shortTermChildBean.add(capitalAssetDetail);
							totalMapForJS.put("STCGNSST", shortTermChildBean);
						}else{
							shortTermChildBean.add(capitalAssetDetail);
							totalMapForJS.put("STCGNSST", shortTermChildBean);
						}
					}else if(capitalAssetDetail.getCapitalGainTaxLT() != null && capitalAssetDetail.getAssetType().equals("SHARES")
							&& capitalAssetDetail.getSstCharge().equals("N") && capitalAssetDetail.getIndex().equals("N")){
						if(totalMapForJS.containsKey("LTCGNINDEX")&& (!totalMapForJS.isEmpty())){
							longTermChildBean = totalMapForJS.get("LTCGNINDEX");
							longTermChildBean.add(capitalAssetDetail);
							totalMapForJS.put("LTCGNINDEX", longTermChildBean);
						}else{
							longTermChildBean.add(capitalAssetDetail);
							totalMapForJS.put("LTCGNINDEX", longTermChildBean);
						}
					}else if((capitalAssetDetail.getCapitalGainTaxLT() != null && capitalAssetDetail.getAssetType().equals("SHARES") && capitalAssetDetail.getSstCharge().equals("N")
							&& capitalAssetDetail.getIndex().equals("Y"))||(capitalAssetDetail.getCapitalGainTaxLT() != null && capitalAssetDetail.getAssetType().equals("OTH"))){
						if(totalMapForJS.containsKey("LTCGINDEX")&& (!totalMapForJS.isEmpty())){
							longTermChildBean = totalMapForJS.get("LTCGINDEX");
							longTermChildBean.add(capitalAssetDetail);
							totalMapForJS.put("LTCGINDEX", longTermChildBean);
						}else{
							longTermChildBean.add(capitalAssetDetail);
							totalMapForJS.put("LTCGINDEX", longTermChildBean);
						}
					}
				}
			}
		}

		resultMapSTCGSST = getCapitalGainCalc(totalMapForJS.get("STCGSST"));
		resultMapSTCGNSST = getCapitalGainCalc(totalMapForJS.get("STCGNSST"));
		resultMapLTCGNINDEX = getCapitalGainCalc(totalMapForJS.get("LTCGNINDEX"));
		resultMapLTCGINDEX = getCapitalGainCalc(totalMapForJS.get("LTCGINDEX"));

		resultMap.put("STCGSST", resultMapSTCGSST );
		resultMap.put("STCGNSST", resultMapSTCGNSST );
		resultMap.put("LTCGNINDEX", resultMapLTCGNINDEX );
		resultMap.put("LTCGINDEX", resultMapLTCGINDEX );

		return resultMap;
	}

	/**
	 * This Method is used to calculate capital gains
	 * @return Map
	 * @param Finincial Year, Input Beans
	 * Added on 23/08/2013
	 * @author Dhananjay
	 * */

	public Map<String, Object> getCapitalGainCalc(List<CapitalAssetDetail> childBean){

		Map<String, Object> resultMapST = new HashMap<String, Object>();
		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>(); //not being used any where
		resultMapST.put("fullConsi", 0);
		resultMapST.put("aquis", 0);
		resultMapST.put("improv", 0);
		resultMapST.put("expend", 0);
		resultMapST.put("balance", 0);
		resultMapST.put("loss", 0);
		resultMapST.put("dedn", 0);
		resultMapST.put("nri111A", 0);
		resultMapST.put("nri111AN", 0);
		resultMapST.put("deemedAmt", 0);
		resultMapST.put("nri48A", 0);
		resultMapST.put("unlstsec", 0);

		if(childBean != null && childBean.size() > 0){
			for(CapitalAssetDetail capitalAssetDetail : childBean){
				resultMapST.put("fullConsi", capitalAssetDetail.getSaleConsideration() + Double.parseDouble(resultMapST.get("fullConsi").toString()));
				resultMapST.put("aquis", capitalAssetDetail.getCostAcquisition() + Double.parseDouble(resultMapST.get("aquis").toString()));
				resultMapST.put("improv", capitalAssetDetail.getCostImprovement() + Double.parseDouble(resultMapST.get("improv").toString()));
				resultMapST.put("expend", capitalAssetDetail.getCostTransfer() + Double.parseDouble(resultMapST.get("expend").toString()));
				resultMapST.put("balance", capitalAssetDetail.getBalance() + Double.parseDouble(resultMapST.get("balance").toString()));
				resultMapST.put("loss", capitalAssetDetail.getLoss_sec94() + Double.parseDouble(resultMapST.get("loss").toString()));
				resultMapST.put("dedn", capitalAssetDetail.getDed_sec54() + Double.parseDouble(resultMapST.get("dedn").toString()));
				resultMapST.put("nri111A", capitalAssetDetail.getAsset_111() + Double.parseDouble(resultMapST.get("nri111A").toString()));
				resultMapST.put("nri111AN", capitalAssetDetail.getAssetnt111() + Double.parseDouble(resultMapST.get("nri111AN").toString()));
				resultMapST.put("deemedAmt", capitalAssetDetail.getAmtdeemed() + Double.parseDouble(resultMapST.get("deemedAmt").toString()));
				resultMapST.put("nri48A", capitalAssetDetail.getSection48() + Double.parseDouble(resultMapST.get("nri48A").toString()));
				resultMapST.put("unlstsec", capitalAssetDetail.getUnlstdSecurity() + Double.parseDouble(resultMapST.get("unlstsec").toString()));
			}
		}
		return ScreenCalculatorService.getScreenCalculations("scheduleCG.js", requestParameterMap, resultMapST);
	}

	/**
	 * This Method is used to get Accrural of Capital Gain
	 * @return Map
	 * @param Finincial Year, Input Beans
	 * Added on 23/08/2013
	 * @author Dhananjay
	 * */

	public Map<String, Object> getAccruralOfCG(FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		Map<String, Object> resultMapST = new HashMap<String, Object>();
		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>(); //not being used any where
		resultMapST.put("capitalGainDetails", null);
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) inputBeans.get(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		if(capitalAssetDocument != null){
			List<CapitalAssetDetail> capitalGainDetails = capitalAssetDocument.getCapitalAssetDetailList();
			if ( capitalGainDetails != null && capitalGainDetails.size() > 0 ){
				resultMapST.put("capitalGainDetails", capitalGainDetails);
			}
		}
		return ScreenCalculatorService.getScreenCalculations("accruralOfCG.js", requestParameterMap, resultMapST);
	}
	/**
	 * This method is used to calculate the Gross Total of Income which is exempt i.e
	 * <br/>we will not include that income on which Flat Rate will Applicable.
	 *
	 * @param financialYear {@link FinancialYear}
	 * @param inputBeans {@link Map} of type <{@link String}, {@link HippoBean}>
	 *
	 * @return {@link Long} value of Gross Income
	 * */
	public long getGrossTotalOfIncomeWTFlateRate(FinancialYear financialYear,Map<String,HippoBean> inputBeans){
		long grosstotal = 0l;
		long otherincome = 0l;
		long houseIncomeTotal = 0l;
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
					houseIncomeTotal = houseIncomeTotal+indianCurrencyHelper.longRound(houseIncomeDetail.getTotal_houseIncome());
				}
			}
		}

		if(otherSourcesDocument!=null){
			//we will not exempt income on which we apply flat rates.
			otherincome = indianCurrencyHelper.longRound(otherSourcesDocument.getTaxable_income() - otherSourcesDocument.getLotteryOrhorse_income() - otherSourcesDocument.getBank_detail_saving());
			otherincome = (otherincome > 0) ? otherincome : 0l;
		}
		grosstotal = longsalarytotal+houseIncomeTotal+otherincome;

		return grosstotal;
	}
}
