package com.mootly.wcm.model.schedules.y2012_2013;

import java.math.BigInteger;
import java.util.List;

import in.gov.incometaxindiaefiling.y2012_2013.IncFromOS;
import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.CoOwners;
import in.gov.incometaxindiaefiling.y2012_2013.Deductions;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PropertyDetails;
import in.gov.incometaxindiaefiling.y2012_2013.Rentdetails;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleHP;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries.Salarys;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleOS;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleOS.IncFromOwnHorse;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleOS.IncOthThanOwnRaceHorse;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleOS.IncOthThanOwnRaceHorse.OthersGrossDtls;

import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class OtherIncomeDocumentSchedules {

	OtherSourcesDocument OSdocument = null;

	public OtherIncomeDocumentSchedules(OtherSourcesDocument OSdocument) {
		this.OSdocument = OSdocument;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */

	public ScheduleOS getScheduleOS(ITR itr){

		ScheduleOS scheduleOS = new ScheduleOS();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		BigInteger otherGross = new BigInteger("0");
		boolean hasValidOtherIncome = false;
		if(OSdocument != null){
			//Income Other than race horse
			IncOthThanOwnRaceHorse incOthThanOwnRaceHorse=new IncOthThanOwnRaceHorse();
			incOthThanOwnRaceHorse.setDividendGross(indianCurrencyHelper.bigIntegerRound(OSdocument.getDividends()));
			incOthThanOwnRaceHorse.setInterestGross(indianCurrencyHelper.bigIntegerRound(OSdocument.getTotalint()));
			incOthThanOwnRaceHorse.setRentFromMachPlantBldgs(indianCurrencyHelper.bigIntegerRound(OSdocument.getIncome_rent_machine()));

			if(OSdocument.getFamily_pension() != 0){
				OthersGrossDtls othersGrossDtls = new OthersGrossDtls();
				othersGrossDtls.setSourceDescription("Family Pension");
				othersGrossDtls.setSourceAmount(indianCurrencyHelper.bigIntegerRound(OSdocument.getFamily_pension()));
				otherGross = otherGross.add(indianCurrencyHelper.bigIntegerRound(OSdocument.getFamily_pension()));
				incOthThanOwnRaceHorse.getOthersGrossDtls().add(othersGrossDtls);
			}
			if(OSdocument.getIncome_other() != 0){
				OthersGrossDtls othersGrossDtls = new OthersGrossDtls();
				othersGrossDtls.setSourceDescription("Income Others");
				othersGrossDtls.setSourceAmount(indianCurrencyHelper.bigIntegerRound(OSdocument.getIncome_other()));
				otherGross = otherGross.add(indianCurrencyHelper.bigIntegerRound(OSdocument.getIncome_other()));
				incOthThanOwnRaceHorse.getOthersGrossDtls().add(othersGrossDtls);
			}
			incOthThanOwnRaceHorse.setOthersGross(otherGross);
			incOthThanOwnRaceHorse.setTotalOSGross(incOthThanOwnRaceHorse.getDividendGross().add(incOthThanOwnRaceHorse.getInterestGross()).add(incOthThanOwnRaceHorse.getRentFromMachPlantBldgs()).add(incOthThanOwnRaceHorse.getOthersGross()));

			Deductions deductions = new Deductions();
			Double deductionExpenses = OSdocument.getDeduction_57() + OSdocument.getFamilypension_deduction() + OSdocument.getOtherdeduction();
			deductions.setExpenses(indianCurrencyHelper.bigIntegerRound(deductionExpenses));
			deductions.setDepreciation(indianCurrencyHelper.bigIntegerRound(OSdocument.getDepreciation()));
			deductions.setTotDeductions(deductions.getExpenses().add(deductions.getDepreciation()));
			incOthThanOwnRaceHorse.setDeductions(deductions);

			incOthThanOwnRaceHorse.setBalanceNoRaceHorse((incOthThanOwnRaceHorse.getTotalOSGross().subtract(deductions.getTotDeductions())).longValue());
			scheduleOS.setIncOthThanOwnRaceHorse(incOthThanOwnRaceHorse);

			scheduleOS.setWinLottRacePuzz(indianCurrencyHelper.longRound(OSdocument.getLotteryOrhorse_income()));
			if(incOthThanOwnRaceHorse.getBalanceNoRaceHorse() > 0){
				scheduleOS.setTotOthSrcNoRaceHorse(scheduleOS.getWinLottRacePuzz() + incOthThanOwnRaceHorse.getBalanceNoRaceHorse());
			}else
				scheduleOS.setTotOthSrcNoRaceHorse(scheduleOS.getWinLottRacePuzz());

			IncFromOwnHorse incFromOwnHorse = new IncFromOwnHorse();
			incFromOwnHorse.setReceipts(indianCurrencyHelper.bigIntegerRound(OSdocument.getReceipts()));
			incFromOwnHorse.setDeductSec57(indianCurrencyHelper.bigIntegerRound(OSdocument.getDedus57()));
			incFromOwnHorse.setBalanceOwnRaceHorse(indianCurrencyHelper.longRound(OSdocument.getBalance()));
			scheduleOS.setIncFromOwnHorse(incFromOwnHorse);

			if(incFromOwnHorse.getBalanceOwnRaceHorse() > 0){
				scheduleOS.setIncChargeable(BigInteger.valueOf(incFromOwnHorse.getBalanceOwnRaceHorse() + scheduleOS.getTotOthSrcNoRaceHorse()));
			}else
				scheduleOS.setIncChargeable(BigInteger.valueOf(scheduleOS.getTotOthSrcNoRaceHorse()));
			if(!hasValidOtherIncome) hasValidOtherIncome = true;
		}
		if(hasValidOtherIncome){
			return scheduleOS;
		}else
			return null;
	}
}
