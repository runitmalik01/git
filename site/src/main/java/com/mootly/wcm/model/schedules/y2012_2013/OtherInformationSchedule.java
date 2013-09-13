package com.mootly.wcm.model.schedules.y2012_2013;

import java.math.BigInteger;

import in.gov.incometaxindiaefiling.y2012_2013.AmtUs43B;
import in.gov.incometaxindiaefiling.y2012_2013.ExciseCustomsVAT;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.AmtDisall43B;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.AmtDisallUs36;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.AmtDisallUs37;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.AmtDisallUs40;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.AmtDisallUs40A;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.AmtDisallUs43BPyNowAll;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.AmtExciseCustomsVATOutstanding;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.MethodOfValClgStk;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAOI.NoCredToPLAmt;

import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class OtherInformationSchedule {

	OtherInformationDocument otherInformationDocument = null;

	public OtherInformationSchedule(OtherInformationDocument otherInformationDocument){
		this.otherInformationDocument = otherInformationDocument;
	}

	public PARTAOI getPARTAOI(ITR itr){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		PARTAOI pARTAOI= new PARTAOI();

		if(otherInformationDocument != null){

			pARTAOI.setMethodOfAcct(otherInformationDocument.getAccounting_employed());
			pARTAOI.setChangeInAcctMethFlg(otherInformationDocument.getMethod_accounting());
			pARTAOI.setProfDeviatDueAcctMeth(otherInformationDocument.getProfit_deviation().longValue());

			MethodOfValClgStk methodOfValClgStk = new MethodOfValClgStk();
			methodOfValClgStk.setValRawMaterial(otherInformationDocument.getRaw_material());
			methodOfValClgStk.setValFinishedGoods(otherInformationDocument.getFinished_goods());
			methodOfValClgStk.setChngStockValMetFlg(otherInformationDocument.getStock_valuation());
			methodOfValClgStk.setEffectOnPL(otherInformationDocument.getLoss_deviation().longValue());
			pARTAOI.setMethodOfValClgStk(methodOfValClgStk);

			NoCredToPLAmt noCredToPLAmt = new NoCredToPLAmt();
			noCredToPLAmt.setSection28Items(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getItem_section28()));
			noCredToPLAmt.setProformaCreditsDue(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getProforma_credits()));
			noCredToPLAmt.setPrevYrEscalClaim(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getEscalation_claims()));
			noCredToPLAmt.setOthItemInc(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getOther_income()));
			noCredToPLAmt.setCapReceipt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getCapital_receipt()));
			noCredToPLAmt.setTotNoCredToPLAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotal_amount()));
			pARTAOI.setNoCredToPLAmt(noCredToPLAmt);

			AmtDisallUs36 amtDisallUs36 = new AmtDisallUs36();
			amtDisallUs36.setStkInsurPrem(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getPremiumpaid_damage()));
			amtDisallUs36.setEmpHealthInsurPrem(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getPremiumpaid_health()));
			amtDisallUs36.setEmpBonusCommSum(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpaid_bonus()));
			amtDisallUs36.setIntOnBorrCap(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getInterest_borrowed()));
			amtDisallUs36.setZeroCoupBondDisc(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getDiscount_zerocoupon()));
			amtDisallUs36.setRecogPFContribAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getContributions_provident()));
			amtDisallUs36.setAppSuperAnnFundAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getContributions_superannuation()));
			amtDisallUs36.setAppGratFundAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getContributions_gratuity()));
			amtDisallUs36.setOthFundAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getContributions_other()));
			amtDisallUs36.setBadDebtDoubtAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_debts()));
			amtDisallUs36.setBadDebtDoubtProvn(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getProvision_debts()));
			amtDisallUs36.setSpecResrvTranfr(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_transferred()));
			amtDisallUs36.setFamPlanPromoExp(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getExpenditure_promoting()));
			amtDisallUs36.setEmpContributionCredits(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSum_received()));
			amtDisallUs36.setOthDisallowances(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getOther_disallowance()));
			amtDisallUs36.setTotAmtDisallUs36(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_disallowable()));
			pARTAOI.setAmtDisallUs36(amtDisallUs36);

			AmtDisallUs37 amtDisallUs37 = new AmtDisallUs37();
			amtDisallUs37.setPersonalExp(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getExpenditure_personal()));
			amtDisallUs37.setPoliticPartyExp(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getExpenditure_advertisement()));
			amtDisallUs37.setLawVoilatPenalExp(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getExpenditure_penalty()));
			amtDisallUs37.setOthPenalFineExp(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getOther_penalty()));
			amtDisallUs37.setOffenceExp(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getExpenditure_incurred()));
			amtDisallUs37.setContigentLiability(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_liability()));
			amtDisallUs37.setAmtNotPartTotInc(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_expenditure()));
			amtDisallUs37.setOthAmtNotAllowUs37(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getOther_amountus37()));
			amtDisallUs37.setTotAmtDisallUs37(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_disallowableus37()));
			pARTAOI.setAmtDisallUs37(amtDisallUs37);

			AmtDisallUs40 amtDisallUs40 = new AmtDisallUs40();
			amtDisallUs40.setNonCompChapXVIIBAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_disallowanceus40()));
			amtDisallUs40.setSTTAmt(new BigInteger("0"));
			amtDisallUs40.setFBTAmt(new BigInteger("0"));
			amtDisallUs40.setTaxAmtOnProfits(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_ratelevied()));
			amtDisallUs40.setWTAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_wealthtax()));
			amtDisallUs40.setIntSalBonPartner(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_commission()));
			amtDisallUs40.setOthDisallow(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getOther_disallowance2()));
			amtDisallUs40.setTotAmtDisallUs40(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_disallowanceus40()));
			amtDisallUs40.setAmtDisallUs40PyNowAll(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmountdisallowable_us40B()));
			pARTAOI.setAmtDisallUs40(amtDisallUs40);

			AmtDisallUs40A amtDisallUs40A = new AmtDisallUs40A();
			amtDisallUs40A.setAmtPaidUs40A2B(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_persons()));
			amtDisallUs40A.setAmtGT20KCash(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_excesstwth()));
			amtDisallUs40A.setProvPmtGrat(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getProvision_gratuity()));
			amtDisallUs40A.setContToSetupTrust(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpaid_assessee()));
			amtDisallUs40A.setOthDisallow(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAnyother_disallowance()));
			amtDisallUs40A.setTotAmtDisallUs40A(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_disallowanceus40()));
			pARTAOI.setAmtDisallUs40A(amtDisallUs40A);

			AmtDisallUs43BPyNowAll amtDisallUs43BPyNowAll = new AmtDisallUs43BPyNowAll();
			AmtUs43B amtUs43B = new AmtUs43B();
			amtUs43B.setTaxDutyCesAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSum_naturetax()));
			amtUs43B.setContToEmpPFSFGF(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_provident()));
			amtUs43B.setEmpBonusComm(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_employee()));
			amtUs43B.setIntPayaleToFI(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_institution()));
			amtUs43B.setIntPayaleToFISchBank(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_bank()));
			amtUs43B.setLeaveEncashPayable(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_encashment()));
			amtUs43B.setTotAmtUs43B(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_us43()));
			amtDisallUs43BPyNowAll.setAmtUs43B(amtUs43B);
			pARTAOI.setAmtDisallUs43BPyNowAll(amtDisallUs43BPyNowAll);

			AmtDisall43B amtDisall43B = new AmtDisall43B();
			AmtUs43B amtUs43 = new AmtUs43B();
			amtUs43.setTaxDutyCesAmt(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSum_naturetax43b()));
			amtUs43.setContToEmpPFSFGF(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_provident43b()));
			amtUs43.setEmpBonusComm(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_employee43b()));
			amtUs43.setIntPayaleToFI(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_institution43b()));
			amtUs43.setIntPayaleToFISchBank(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_bank43b()));
			amtUs43.setLeaveEncashPayable(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getSumpayable_encashment43b()));
			amtUs43.setTotAmtUs43B(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_us43b()));
			amtDisall43B.setAmtUs43B(amtUs43);
			pARTAOI.setAmtDisall43B(amtDisall43B);

			AmtExciseCustomsVATOutstanding amtExciseCustomsVATOutstanding = new AmtExciseCustomsVATOutstanding();
			ExciseCustomsVAT exciseCustomsVAT = new ExciseCustomsVAT();
			exciseCustomsVAT.setUnionExciseDuty(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getUnion_excise()));
			exciseCustomsVAT.setServiceTax(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getService_tax()));
			exciseCustomsVAT.setVATorSaleTax(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getVat_tax()));
			exciseCustomsVAT.setOthDutyTaxCess(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getOther_tax()));
			exciseCustomsVAT.setTotExciseCustomsVAT(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_outstanding()));
			amtExciseCustomsVATOutstanding.setExciseCustomsVAT(exciseCustomsVAT);
			pARTAOI.setAmtExciseCustomsVATOutstanding(amtExciseCustomsVATOutstanding);

			pARTAOI.setDeemedProfUs33ABs(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_deemed()));
			pARTAOI.setProfTaxAmtUs41(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_profit()));
			pARTAOI.setPriorAmtIncCrDrPL(otherInformationDocument.getAmount_income().longValue());

		}else{
			pARTAOI.setMethodOfAcct("MERC");
			pARTAOI.setChangeInAcctMethFlg("N");
			pARTAOI.setProfDeviatDueAcctMeth(0);

			MethodOfValClgStk methodOfValClgStk = new MethodOfValClgStk();
			methodOfValClgStk.setValRawMaterial("1");
			methodOfValClgStk.setValFinishedGoods("1");
			methodOfValClgStk.setChngStockValMetFlg("N");
			methodOfValClgStk.setEffectOnPL(0);
			pARTAOI.setMethodOfValClgStk(methodOfValClgStk);

			NoCredToPLAmt noCredToPLAmt = new NoCredToPLAmt();
			noCredToPLAmt.setSection28Items(new BigInteger("0"));
			noCredToPLAmt.setProformaCreditsDue(new BigInteger("0"));
			noCredToPLAmt.setPrevYrEscalClaim(new BigInteger("0"));
			noCredToPLAmt.setOthItemInc(new BigInteger("0"));
			noCredToPLAmt.setCapReceipt(new BigInteger("0"));
			noCredToPLAmt.setTotNoCredToPLAmt(new BigInteger("0"));
			pARTAOI.setNoCredToPLAmt(noCredToPLAmt);

			AmtDisallUs36 amtDisallUs36 = new AmtDisallUs36();
			amtDisallUs36.setStkInsurPrem(new BigInteger("0"));
			amtDisallUs36.setEmpHealthInsurPrem(new BigInteger("0"));
			amtDisallUs36.setEmpBonusCommSum(new BigInteger("0"));
			amtDisallUs36.setIntOnBorrCap(new BigInteger("0"));
			amtDisallUs36.setZeroCoupBondDisc(new BigInteger("0"));
			amtDisallUs36.setRecogPFContribAmt(new BigInteger("0"));
			amtDisallUs36.setAppSuperAnnFundAmt(new BigInteger("0"));
			amtDisallUs36.setAppGratFundAmt(new BigInteger("0"));
			amtDisallUs36.setOthFundAmt(new BigInteger("0"));
			amtDisallUs36.setBadDebtDoubtAmt(new BigInteger("0"));
			amtDisallUs36.setBadDebtDoubtProvn(new BigInteger("0"));
			amtDisallUs36.setSpecResrvTranfr(new BigInteger("0"));
			amtDisallUs36.setFamPlanPromoExp(new BigInteger("0"));
			amtDisallUs36.setEmpContributionCredits(new BigInteger("0"));
			amtDisallUs36.setOthDisallowances(new BigInteger("0"));
			amtDisallUs36.setTotAmtDisallUs36(new BigInteger("0"));
			pARTAOI.setAmtDisallUs36(amtDisallUs36);

			AmtDisallUs37 amtDisallUs37 = new AmtDisallUs37();
			amtDisallUs37.setPersonalExp(new BigInteger("0"));
			amtDisallUs37.setPoliticPartyExp(new BigInteger("0"));
			amtDisallUs37.setLawVoilatPenalExp(new BigInteger("0"));
			amtDisallUs37.setOthPenalFineExp(new BigInteger("0"));
			amtDisallUs37.setOffenceExp(new BigInteger("0"));
			amtDisallUs37.setContigentLiability(new BigInteger("0"));
			amtDisallUs37.setAmtNotPartTotInc(new BigInteger("0"));
			amtDisallUs37.setOthAmtNotAllowUs37(new BigInteger("0"));
			amtDisallUs37.setTotAmtDisallUs37(new BigInteger("0"));
			pARTAOI.setAmtDisallUs37(amtDisallUs37);

			AmtDisallUs40 amtDisallUs40 = new AmtDisallUs40();
			amtDisallUs40.setNonCompChapXVIIBAmt(new BigInteger("0"));
			amtDisallUs40.setSTTAmt(new BigInteger("0"));
			amtDisallUs40.setFBTAmt(new BigInteger("0"));
			amtDisallUs40.setTaxAmtOnProfits(new BigInteger("0"));
			amtDisallUs40.setWTAmt(new BigInteger("0"));
			amtDisallUs40.setIntSalBonPartner(new BigInteger("0"));
			amtDisallUs40.setOthDisallow(new BigInteger("0"));
			amtDisallUs40.setTotAmtDisallUs40(new BigInteger("0"));
			amtDisallUs40.setAmtDisallUs40PyNowAll(new BigInteger("0"));
			pARTAOI.setAmtDisallUs40(amtDisallUs40);

			AmtDisallUs40A amtDisallUs40A = new AmtDisallUs40A();
			amtDisallUs40A.setAmtPaidUs40A2B(new BigInteger("0"));
			amtDisallUs40A.setAmtGT20KCash(new BigInteger("0"));
			amtDisallUs40A.setProvPmtGrat(new BigInteger("0"));
			amtDisallUs40A.setContToSetupTrust(new BigInteger("0"));
			amtDisallUs40A.setOthDisallow(new BigInteger("0"));
			amtDisallUs40A.setTotAmtDisallUs40A(new BigInteger("0"));
			pARTAOI.setAmtDisallUs40A(amtDisallUs40A);

			AmtDisallUs43BPyNowAll amtDisallUs43BPyNowAll = new AmtDisallUs43BPyNowAll();
			AmtUs43B amtUs43B = new AmtUs43B();
			amtUs43B.setTaxDutyCesAmt(new BigInteger("0"));
			amtUs43B.setContToEmpPFSFGF(new BigInteger("0"));
			amtUs43B.setEmpBonusComm(new BigInteger("0"));
			amtUs43B.setIntPayaleToFI(new BigInteger("0"));
			amtUs43B.setIntPayaleToFISchBank(new BigInteger("0"));
			amtUs43B.setLeaveEncashPayable(new BigInteger("0"));
			amtUs43B.setTotAmtUs43B(new BigInteger("0"));
			amtDisallUs43BPyNowAll.setAmtUs43B(amtUs43B);
			pARTAOI.setAmtDisallUs43BPyNowAll(amtDisallUs43BPyNowAll);

			AmtDisall43B amtDisall43B = new AmtDisall43B();
			AmtUs43B amtUs43 = new AmtUs43B();
			amtUs43.setTaxDutyCesAmt(new BigInteger("0"));
			amtUs43.setContToEmpPFSFGF(new BigInteger("0"));
			amtUs43.setEmpBonusComm(new BigInteger("0"));
			amtUs43.setIntPayaleToFI(new BigInteger("0"));
			amtUs43.setIntPayaleToFISchBank(new BigInteger("0"));
			amtUs43.setLeaveEncashPayable(new BigInteger("0"));
			amtUs43.setTotAmtUs43B(new BigInteger("0"));
			amtDisall43B.setAmtUs43B(amtUs43);
			pARTAOI.setAmtDisall43B(amtDisall43B);

			AmtExciseCustomsVATOutstanding amtExciseCustomsVATOutstanding = new AmtExciseCustomsVATOutstanding();
			ExciseCustomsVAT exciseCustomsVAT = new ExciseCustomsVAT();
			exciseCustomsVAT.setUnionExciseDuty(new BigInteger("0"));
			exciseCustomsVAT.setServiceTax(new BigInteger("0"));
			exciseCustomsVAT.setVATorSaleTax(new BigInteger("0"));
			exciseCustomsVAT.setOthDutyTaxCess(new BigInteger("0"));
			exciseCustomsVAT.setTotExciseCustomsVAT(new BigInteger("0"));
			amtExciseCustomsVATOutstanding.setExciseCustomsVAT(exciseCustomsVAT);
			pARTAOI.setAmtExciseCustomsVATOutstanding(amtExciseCustomsVATOutstanding);

			pARTAOI.setDeemedProfUs33ABs(new BigInteger("0"));
			pARTAOI.setProfTaxAmtUs41(new BigInteger("0"));
			pARTAOI.setPriorAmtIncCrDrPL(0);
		}

		return pARTAOI;
	}
}
