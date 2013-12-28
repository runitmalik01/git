package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITRScheduleFSI;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleFSI;

import java.util.List;

import com.mootly.wcm.beans.ForeignIncomeDocument;
import com.mootly.wcm.beans.compound.ForeignIncomeDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ForeignIncomeScheduleFSI {
	ForeignIncomeDocument foreignIncomeDoc = null;

	public ForeignIncomeScheduleFSI(ForeignIncomeDocument ForeignIncome){
		this.foreignIncomeDoc = ForeignIncome;

	}
	public ITRScheduleFSI getITRScheduleFSI (ITR itr){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ITRScheduleFSI iTRScheduleFSI = new ITRScheduleFSI();
		boolean hasValidForeignIncome = false;
		if(foreignIncomeDoc!=null){
			List<ForeignIncomeDetail> foreignIncomeDetail =  foreignIncomeDoc.getForeignIncomeDetailList();
			if ( foreignIncomeDetail != null && foreignIncomeDetail.size() > 0 ){
				for(ForeignIncomeDetail foreignIncomedet:foreignIncomeDetail){
					ScheduleFSI scheduleFSI = new ScheduleFSI();
					scheduleFSI.setCountryCode(foreignIncomedet.getCountry_Code());
					scheduleFSI.setCountryName(foreignIncomedet.getCountry_Name());
					scheduleFSI.setTaxIdentificationNo(foreignIncomedet.getTaxpayer_ID());
					scheduleFSI.setIncFromSal(indianCurrencyHelper.bigIntegerRound(foreignIncomedet.getIncome_Salary()));
					scheduleFSI.setIncFromHP(indianCurrencyHelper.bigIntegerRound(foreignIncomedet.getIncome_House()));
					scheduleFSI.setIncFromBusiness(indianCurrencyHelper.bigIntegerRound(foreignIncomedet.getIncome_Business()));
					scheduleFSI.setIncCapGain(indianCurrencyHelper.bigIntegerRound(foreignIncomedet.getIncome_Capitalgain()));
					scheduleFSI.setIncOthSrc(indianCurrencyHelper.bigIntegerRound(foreignIncomedet.getIncome_Othersources()));
					scheduleFSI.setTotalCountryWise(indianCurrencyHelper.bigIntegerRound(foreignIncomedet.getIncome_Total()));


					iTRScheduleFSI.getScheduleFSI().add(scheduleFSI);
					iTRScheduleFSI.setTotalIncomeOutIndia(indianCurrencyHelper.bigIntegerRound(foreignIncomeDoc.getTotal_Amount()));
					iTRScheduleFSI.setTotalIncomeOutIndiaDTAA(indianCurrencyHelper.bigIntegerRound(foreignIncomeDoc.getIncomeApplDtaa()));
					iTRScheduleFSI.setTotalIncomeOutIndiaWoDTAA(indianCurrencyHelper.bigIntegerRound(foreignIncomeDoc.getIncomeNotApplDtaa()));
					if(!hasValidForeignIncome) hasValidForeignIncome = true;
				}
			}
		}
		if(hasValidForeignIncome){
			return iTRScheduleFSI;
		}
		return null;
	}

}
