package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.CapGain;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP;
import in.gov.incometaxindiaefiling.y2012_2013.IncFromOS;
import in.gov.incometaxindiaefiling.y2012_2013.LongTerm;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI.ProfBusGain;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBPA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCGFor23;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCGFor4;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleVIA;
import in.gov.incometaxindiaefiling.y2012_2013.ShortTerm;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.BroughtFwdLossesDocument;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

public class PartB_TI {

	FormSixteenDocument formSixteenDocument = null;
	SalaryIncomeDocument salaryIncomeDocument = null;
	HouseProperty housePropertyDocument = null;
	OtherSourcesDocument otherSourcesDocument = null;
	DeductionDocument deductionDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;
	ScheduleSIDocument scheduleSIDocument= null;
	CapitalAssetDocument capitalAssetDocument = null;
	IncBusinessProfessionDoc incBusinessProfessionDoc = null;
	ProfitAndLossDocument profitAndLossDocument = null;
	OtherInformationDocument otherInformationDocument = null;
	ScheduleDPMDocument scheduleDPMDocument = null;
	ScheduleDOADocument scheduleDOADocument = null;
	ScheduleESRDocument scheduleESRDocument = null;
	DeductionSchedTenADocumemt deductionSchedTenADocumemt = null;
	IncomeFromFirmsDocument incomeFromFirmsDocument = null;

	public PartB_TI(FormSixteenDocument formSixteenDocument, SalaryIncomeDocument salaryIncomeDocument, HouseProperty housePropertyDocument ,
			OtherSourcesDocument otherSourcesDocument, DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation,
			ScheduleSIDocument scheduleSIDocument, CapitalAssetDocument capitalAssetDocument, IncBusinessProfessionDoc incBusinessProfessionDoc,
			ProfitAndLossDocument profitAndLossDocument, OtherInformationDocument otherInformationDocument, ScheduleDPMDocument scheduleDPMDocument,
			ScheduleDOADocument scheduleDOADocument, ScheduleESRDocument scheduleESRDocument, DeductionSchedTenADocumemt deductionSchedTenADocumemt,
			IncomeFromFirmsDocument incomeFromFirmsDocument){
		this.formSixteenDocument = formSixteenDocument;
		this.salaryIncomeDocument = salaryIncomeDocument;
		this.housePropertyDocument = housePropertyDocument;
		this.otherSourcesDocument = otherSourcesDocument;
		this.deductionDocument = deductionDocument;
		this.memberPersonalInformation = memberPersonalInformation;
		this.scheduleSIDocument = scheduleSIDocument;
		this.capitalAssetDocument = capitalAssetDocument;
		this.incBusinessProfessionDoc = incBusinessProfessionDoc;
		this.profitAndLossDocument = profitAndLossDocument;
		this.otherInformationDocument = otherInformationDocument;
		this.scheduleDPMDocument = scheduleDPMDocument;
		this.scheduleDOADocument = scheduleDOADocument;
		this.scheduleESRDocument = scheduleESRDocument;
		this.deductionSchedTenADocumemt = deductionSchedTenADocumemt;
		this.incomeFromFirmsDocument = incomeFromFirmsDocument;
	}

	public PartBTI getPartBTI(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		PartBTI partBTI = new PartBTI();
		String itrSelection =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		XmlCalculation xmlCalculation = new XmlCalculation();
		Map<String,Object> resultMapLosses = xmlCalculation.lossesCalc(financialYear, inputBeans);

		//Getting value of Total Salary Income
		BigInteger incomeSalaries= new BigInteger("0");
		if(formSixteenDocument != null){
			List<FormSixteenDetail> formSixteenDetails = formSixteenDocument.getFormSixteenDetailList();
			if ( formSixteenDetails != null && formSixteenDetails.size() > 0 ){
				for (FormSixteenDetail formSixteenDetail:formSixteenDetails)  {
					incomeSalaries= incomeSalaries.add(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax()));
				}
			}
		}
		if(salaryIncomeDocument!=null){
			incomeSalaries = incomeSalaries.add(indianCurrencyHelper.bigIntegerRound(salaryIncomeDocument.getTotal()));
		}
		partBTI.setSalaries(incomeSalaries);

		//Getting value of Total House Income
		BigInteger incomeHP = new BigInteger("0");
		if(housePropertyDocument != null){
			incomeHP = indianCurrencyHelper.bigIntegerRound(housePropertyDocument.getTotal_HouseIncome());
		}
		if(incomeHP.compareTo(BigInteger.ZERO) > 0){
			partBTI.setIncomeFromHP(incomeHP);
		}else
			partBTI.setIncomeFromHP(new BigInteger("0"));

		ProfBusGain profBusGain = new ProfBusGain();

		//getting Schedule BP for ITR4 (in case of ITR2 else loop will set all values to Zero because ProfBusGain not required in ITR2)
		if(itrSelection.equals("ITR4")){
			ITR4_ScheduleBP iTR4_ScheduleBP = new ITR4_ScheduleBP(incBusinessProfessionDoc, profitAndLossDocument, otherInformationDocument,
					scheduleDPMDocument, scheduleDOADocument, scheduleESRDocument, deductionSchedTenADocumemt);
			ITR4ScheduleBP iTR4ScheduleBP = iTR4_ScheduleBP.getITR4ScheduleBP(itr, financialYear, inputBeans);

			profBusGain.setProfGainNoSpecBus(iTR4ScheduleBP.getBusinessIncOthThanSpec().getNetPLBusOthThanSpec7A7B7C());
			if(iTR4ScheduleBP.getSpecBusinessInc().getAdjustedPLFrmSpecuBus() > 0){
				profBusGain.setProfGainSpecBus(BigInteger.valueOf(iTR4ScheduleBP.getSpecBusinessInc().getAdjustedPLFrmSpecuBus()));
			}else
				profBusGain.setProfGainSpecBus(new BigInteger("0"));
			if(iTR4ScheduleBP.getSpecifiedBusinessInc().getPLFrmSpecifiedBus() > 0){
				profBusGain.setProfGainSpecifiedBus(BigInteger.valueOf(iTR4ScheduleBP.getSpecifiedBusinessInc().getPLFrmSpecifiedBus()));
			}else
				profBusGain.setProfGainSpecifiedBus(new BigInteger("0"));

			if((BigInteger.valueOf(profBusGain.getProfGainNoSpecBus()).add(profBusGain.getProfGainSpecBus())
					.add(profBusGain.getProfGainSpecifiedBus())).compareTo(BigInteger.ZERO) > 0){
				profBusGain.setTotProfBusGain(BigInteger.valueOf(profBusGain.getProfGainNoSpecBus()).add(profBusGain.getProfGainSpecBus())
						.add(profBusGain.getProfGainSpecifiedBus()));
			}else
				profBusGain.setTotProfBusGain(new BigInteger("0"));

			partBTI.setProfBusGain(profBusGain);
		}else if(itrSelection.equals("ITR3")){
			ITR3_ScheduleBPA iTR3_ScheduleBPA = new ITR3_ScheduleBPA(incomeFromFirmsDocument);
			ScheduleBPA scheduleBPA = iTR3_ScheduleBPA.getScheduleBPA(itr);
			profBusGain.setProfGainNoSpecBus(0);
			profBusGain.setProfGainSpecBus(new BigInteger("0"));
			profBusGain.setProfGainSpecifiedBus(new BigInteger("0"));
			if(scheduleBPA != null){
				long totBP = scheduleBPA.getTotal().getAggreNetIncome();
				if(totBP > 0){
					profBusGain.setTotProfBusGain(BigInteger.valueOf(totBP));
				}else
					profBusGain.setTotProfBusGain(new BigInteger("0"));
			}else
				profBusGain.setTotProfBusGain(new BigInteger("0"));
			partBTI.setProfBusGain(profBusGain);
		}else{
			profBusGain.setProfGainNoSpecBus(0);
			profBusGain.setProfGainSpecBus(new BigInteger("0"));
			profBusGain.setProfGainSpecifiedBus(new BigInteger("0"));
			profBusGain.setTotProfBusGain(new BigInteger("0"));
			partBTI.setProfBusGain(profBusGain);
		}

		//Capital Gain
		CapGain capGain = new CapGain();
		if(itrSelection.equals("ITR4")){

			CapitalGainScheduleFor4 capitalGainScheduleFor4 = new CapitalGainScheduleFor4(capitalAssetDocument, scheduleDPMDocument, scheduleDOADocument);
			ScheduleCGFor4 scheduleCGFor4 = capitalGainScheduleFor4.getScheduleCGFor4(itr, financialYear, inputBeans);

			ShortTerm shortTerm = new ShortTerm();
			shortTerm.setShortTermUs111A(scheduleCGFor4.getShortTermCapGainFor4().getNRIAssetSec48Dtl().getNRI111AApplicable()
					+ scheduleCGFor4.getShortTermCapGainFor4().getOtherAsset111AApplicable().getBalCG());
			shortTerm.setShortTermOther(scheduleCGFor4.getShortTermCapGainFor4().getTotalSTCG() - shortTerm.getShortTermUs111A());
			shortTerm.setTotalShortTerm(shortTerm.getShortTermOther() + shortTerm.getShortTermUs111A());
			capGain.setShortTerm(shortTerm);

			LongTerm longTerm = new LongTerm();
			longTerm.setLongTermIndexation(scheduleCGFor4.getLongTermCapGain4().getTotalLTCG()
					- scheduleCGFor4.getLongTermCapGain4().getOtherAssetProviso112().getBalLTCG112()
					- scheduleCGFor4.getLongTermCapGain4().getUnlistedSecurities());
			longTerm.setLongTermWOIndexation( scheduleCGFor4.getLongTermCapGain4().getOtherAssetProviso112().getBalLTCG112()
					+ scheduleCGFor4.getLongTermCapGain4().getUnlistedSecurities());

			long longTermIndex = longTerm.getLongTermIndexation();
			long longTermWOIndex = longTerm.getLongTermWOIndexation();
			long longterm = longTermIndex + longTermWOIndex;

			if(longterm > 0){
				longTerm.setTotalLongTerm(BigInteger.valueOf(longterm));
			}else
				longTerm.setTotalLongTerm(new BigInteger("0"));
			capGain.setLongTerm(longTerm);

			long totalCapitalGain = shortTerm.getTotalShortTerm() + longTerm.getTotalLongTerm().longValue();
			if(totalCapitalGain > 0){
				capGain.setTotalCapGains(BigInteger.valueOf(totalCapitalGain));
			}else
				capGain.setTotalCapGains(new BigInteger("0"));
		}else{

			CapitalGainDocumentSchedules capitalGainDocumentSchedules = new CapitalGainDocumentSchedules(capitalAssetDocument);
			ScheduleCGFor23 scheduleCGFor23 = capitalGainDocumentSchedules.getSchedulecCgFor23(itr, financialYear, inputBeans);

			ShortTerm shortTerm = new ShortTerm();
			shortTerm.setShortTermUs111A(scheduleCGFor23.getShortTermCapGainFor23().getNRIAssetSec48Dtl().getNRI111AApplicable()
					+ scheduleCGFor23.getShortTermCapGainFor23().getOtherAsset111AApplicable().getBalCG());
			shortTerm.setShortTermOther(scheduleCGFor23.getShortTermCapGainFor23().getTotalSTCG() - shortTerm.getShortTermUs111A());
			shortTerm.setTotalShortTerm(shortTerm.getShortTermOther() + shortTerm.getShortTermUs111A());
			capGain.setShortTerm(shortTerm);

			LongTerm longTerm = new LongTerm();
			longTerm.setLongTermIndexation(scheduleCGFor23.getLongTermCapGain23().getTotalLTCG()
					- scheduleCGFor23.getLongTermCapGain23().getOtherAssetProviso112().getBalLTCG112()
					- scheduleCGFor23.getLongTermCapGain23().getUnlistedSecurities().longValue());
			longTerm.setLongTermWOIndexation( scheduleCGFor23.getLongTermCapGain23().getOtherAssetProviso112().getBalLTCG112()
					+ scheduleCGFor23.getLongTermCapGain23().getUnlistedSecurities().longValue());

			long longTermIndex = longTerm.getLongTermIndexation();
			long longTermWOIndex = longTerm.getLongTermWOIndexation();
			long longterm = longTermIndex + longTermWOIndex;

			if(longterm > 0){
				longTerm.setTotalLongTerm(BigInteger.valueOf(longterm));
			}else
				longTerm.setTotalLongTerm(new BigInteger("0"));
			capGain.setLongTerm(longTerm);

			long totalCapitalGain = shortTerm.getTotalShortTerm() + longTerm.getTotalLongTerm().longValue();
			if(totalCapitalGain > 0){
				capGain.setTotalCapGains(BigInteger.valueOf(totalCapitalGain));
			}else
				capGain.setTotalCapGains(new BigInteger("0"));
		}

		partBTI.setCapGain(capGain);

		//Getting values of other income
		IncFromOS incFromOS = new IncFromOS();
		double incomeOtherThanRaceHorse = 0;
		double incomeFromLotteries = 0;
		double incomeFromRaceHorse = 0;
		double agricultureIncome = 0;
		if(otherSourcesDocument!=null){
			incomeOtherThanRaceHorse = otherSourcesDocument.getTotalint() + otherSourcesDocument.getTotalOther_income() - otherSourcesDocument.getTotalexpense();
			incomeFromRaceHorse = otherSourcesDocument.getBalance();
			incomeFromLotteries = otherSourcesDocument.getLotteryOrhorse_income();
			agricultureIncome = otherSourcesDocument.getAgriculture_income();
		}
		if(incomeOtherThanRaceHorse > 0){
			incFromOS.setOtherSrcThanOwnRaceHorse(indianCurrencyHelper.longRound(incomeOtherThanRaceHorse));
		}else
			incFromOS.setOtherSrcThanOwnRaceHorse(0);
		incFromOS.setWinLotteriesRacesGambling(indianCurrencyHelper.bigIntegerRound(incomeFromLotteries));
		if(incomeFromRaceHorse > 0){
			incFromOS.setFromOwnRaceHorse(indianCurrencyHelper.bigIntegerRound(incomeFromRaceHorse));
		}else
			incFromOS.setFromOwnRaceHorse(new BigInteger("0"));
		incFromOS.setTotIncFromOS(BigInteger.valueOf(incFromOS.getOtherSrcThanOwnRaceHorse()).add(incFromOS.getWinLotteriesRacesGambling()).add(incFromOS.getFromOwnRaceHorse()));
		partBTI.setIncFromOS(incFromOS);

		//total of SalaryIncome+HouseIncome+CapitalGain+OtherIncome+ProfitandGainfromBP
		partBTI.setTotalTI(partBTI.getSalaries().add(partBTI.getIncomeFromHP()).add(capGain.getTotalCapGains()).add(incFromOS.getTotIncFromOS()).add(profBusGain.getTotProfBusGain()));

		//total of 2vii and 3vii of Schedule CYLA in case of ITR2 and total of 2x,3x,4x of CYLA in case of ITR4
		partBTI.setCurrentYearLoss(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalHPLossSetoff").toString())+Double.parseDouble(resultMapLosses.get("totalOILossSetoff").toString())+
				Double.parseDouble(resultMapLosses.get("totalBILossSetoff").toString())));

		//totalTI - CurrentYearLoss
		partBTI.setBalanceAfterSetoffLosses(partBTI.getTotalTI().subtract(partBTI.getCurrentYearLoss()));

		// 2vii of Schedule BFLA in case of ITR2 and total of 2x,3x,4x of Schedule BFLA in case of ITR4
		if(itrSelection.equals("ITR4")){
			BroughtFwdLossesDocument broughtFwdLossesDocument = (BroughtFwdLossesDocument) inputBeans.get(BroughtFwdLossesDocument.class.getSimpleName().toLowerCase());
			ITR4_ScheduleBFLA iTR4_ScheduleBFLA = new ITR4_ScheduleBFLA(broughtFwdLossesDocument);
			ScheduleBFLA scheduleBFLA = iTR4_ScheduleBFLA.getScheduleBFLA(itr, financialYear, inputBeans);
			partBTI.setBroughtFwdLossesSetoff(scheduleBFLA.getTotalBFLossSetOff().getTotAllUs35Cl4Setoff().add(scheduleBFLA.getTotalBFLossSetOff().getTotBFLossSetoff())
					.add(scheduleBFLA.getTotalBFLossSetOff().getTotUnabsorbedDeprSetoff()));
		}else
			partBTI.setBroughtFwdLossesSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalBFLossSetOff").toString())));

		//BalanceAfterSetoffLosses - BroughtFrwdLossesSetoff
		partBTI.setGrossTotalIncome(partBTI.getBalanceAfterSetoffLosses().subtract(partBTI.getBroughtFwdLossesSetoff()));

		Map<String,Double> resultMap = xmlCalculation.getSumOfScheduleSIisInActiveSection(financialYear, inputBeans);
		Double incChargeTaxSplRate111A112 = resultMap.get("sumInActiveSection");
		Double minChargeIncome = resultMap.get("minChargeIncome");
		partBTI.setIncChargeableTaxSplRates(indianCurrencyHelper.bigIntegerRound(incChargeTaxSplRate111A112));

		//Total Deduction (Should not be greater than GrossTotalIncome - IncChargableTaxSplRates)
		DeductionVIASchedules deductionVIASchedules = new DeductionVIASchedules(deductionDocument, memberPersonalInformation,otherSourcesDocument);
		ScheduleVIA scheduleVIA = deductionVIASchedules.getScheduleVIA(itr, financialYear, inputBeans);
		BigInteger totEligibleDeduction = new BigInteger("0");
		totEligibleDeduction = scheduleVIA.getDeductUndChapVIA().getTotalChapVIADeductions();
		BigInteger diffGrossIncNIncChargeable = new BigInteger("0");
		diffGrossIncNIncChargeable = partBTI.getGrossTotalIncome().subtract(partBTI.getIncChargeableTaxSplRates());
		if(totEligibleDeduction.compareTo(BigInteger.ZERO) > 0){
			if(diffGrossIncNIncChargeable.longValue() > totEligibleDeduction.longValue() && totEligibleDeduction.longValue() > 0){
				partBTI.setDeductionsUnderScheduleVIA(totEligibleDeduction);
			}else if(diffGrossIncNIncChargeable.longValue() < totEligibleDeduction.longValue() && diffGrossIncNIncChargeable.longValue() > 0){
				partBTI.setDeductionsUnderScheduleVIA(diffGrossIncNIncChargeable);
			}else
				partBTI.setDeductionsUnderScheduleVIA(new BigInteger("0"));
		}else
			partBTI.setDeductionsUnderScheduleVIA(new BigInteger("0"));
		//GrossTotalIncome - Deduction
		partBTI.setTotalIncome(partBTI.getGrossTotalIncome().subtract(partBTI.getDeductionsUnderScheduleVIA()));

		partBTI.setIncChargeTaxSplRate111A112(indianCurrencyHelper.bigIntegerRound(minChargeIncome));

		//Agriculture Income taking from Other Income Screen
		partBTI.setNetAgricultureIncomeOrOtherIncomeForRate(indianCurrencyHelper.bigIntegerRound(agricultureIncome));

		//TotalIncome - IncChargeTaxSplRate111A112 + Agriculture Income
		partBTI.setAggregateIncome((partBTI.getTotalIncome().subtract(partBTI.getIncChargeTaxSplRate111A112())).add(partBTI.getNetAgricultureIncomeOrOtherIncomeForRate()));

		Double currYrHILoss = Double.parseDouble(resultMapLosses.get("currYearHouseIncomeLoss").toString());
		Double currYrLTCLoss = Double.parseDouble(resultMapLosses.get("currYearLTCLoss").toString());
		Double currYrRaceHrsLoss = Double.parseDouble(resultMapLosses.get("currYearRaceHorseLoss").toString());
		Double currYrSTCLoss = Double.parseDouble(resultMapLosses.get("currYearSTCLoss").toString());
		Double currYrBILoss = Double.parseDouble(resultMapLosses.get("currYearBusinessIncomeLoss").toString());
		Double currYrSILoss = Double.parseDouble(resultMapLosses.get("currYearSpecifiedIncomeLoss").toString());
		Double currYrSPILoss = Double.parseDouble(resultMapLosses.get("currYearSpeculativeIncomeLoss").toString());
		Double totalCurrYrLoss = currYrHILoss + currYrLTCLoss + currYrRaceHrsLoss + currYrSTCLoss + currYrBILoss + currYrSILoss + currYrSPILoss;
		partBTI.setLossesOfCurrentYearCarriedFwd(indianCurrencyHelper.bigIntegerRound(totalCurrYrLoss));

		return partBTI;
	}
}
