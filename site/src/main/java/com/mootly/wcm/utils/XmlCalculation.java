package com.mootly.wcm.utils;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//HouseIncomeDetail houseIncomeDetail = (HouseIncomeDetail) request.getAttribute(HouseIncomeDetail.class.getSimpleName().toLowerCase());
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

}
