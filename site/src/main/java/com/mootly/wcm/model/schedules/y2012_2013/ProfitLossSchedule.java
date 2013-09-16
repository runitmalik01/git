package com.mootly.wcm.model.schedules.y2012_2013;

import java.lang.reflect.Field;
import java.math.BigInteger;

import org.springframework.beans.DirectFieldAccessor;

import in.gov.incometaxindiaefiling.y2012_2013.ExciseCustomsVAT;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.CreditsToPL;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.CreditsToPL.OthIncome;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.DebitsToPL;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.DebitsToPL.DutyTaxPay;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.DebitsToPL.EmployeeComp;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.DebitsToPL.Insurances;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.DebitsToPL.RatesTaxesPays;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.NoBooksOfAccPL;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL.TaxProvAppr;

import com.mootly.wcm.beans.AssetAndLiabilityDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.ProfitAndLossVariables;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ProfitLossSchedule {

	ProfitAndLossDocument profitAndLossDocument = null;

	public ProfitLossSchedule(ProfitAndLossDocument profitAndLossDocument){
		this.profitAndLossDocument = profitAndLossDocument;
	}

	public PARTAPL getPARTAPL(ITR itr){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		PARTAPL pARTAPL = new PARTAPL();


		//To set Dummy if Document is null
		if(profitAndLossDocument == null){
			ProfitAndLossDocument profitAndLossDocumentDummy = new ProfitAndLossDocument();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(profitAndLossDocumentDummy);
			Field[] fields =  ProfitAndLossVariables.class.getDeclaredFields();
			for(Field field : fields){
				if(field.getType().getSimpleName().equals(Double.class.getSimpleName())){
					directFieldAccessor.setPropertyValue(field.getName(), 0d);
				}
			}
			this.profitAndLossDocument = profitAndLossDocumentDummy;
		}

		CreditsToPL creditsToPL = new CreditsToPL();
		creditsToPL.setBusinessReceipts(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getSales_GrossBusiness()));
		ExciseCustomsVAT exciseCustomsVAT = new ExciseCustomsVAT();
		exciseCustomsVAT.setUnionExciseDuty(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getUnion_ExciseDuties()));
		exciseCustomsVAT.setServiceTax(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getservice_Tax()));
		exciseCustomsVAT.setVATorSaleTax(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getVat_SalesTax()));
		exciseCustomsVAT.setOthDutyTaxCess(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getAny_OtherTax()));
		exciseCustomsVAT.setTotExciseCustomsVAT(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getTotal_DutyTaxCess()));
		creditsToPL.setExciseCustomsVAT(exciseCustomsVAT);

		OthIncome othIncome = new OthIncome();
		othIncome.setRentInc(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getRent()));
		othIncome.setComissions(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getCommission()));
		othIncome.setDividends(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getDividends()));
		othIncome.setInterestInc(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getInterest()));
		othIncome.setProfitOnSaleFixedAsset(profitAndLossDocument.getProfit_FixedAsset().longValue());
		othIncome.setProfitOnInvChrSTT(profitAndLossDocument.getProfit_InvestmentSTT().longValue());
		othIncome.setProfitOnOthInv(profitAndLossDocument.getProfit_OtherInvestment().longValue());
		othIncome.setProfitOnCurrFluct(profitAndLossDocument.getProfit_CurrencyFluctuation().longValue());
		othIncome.setProfitOnAgriIncome(profitAndLossDocument.getAgricultural_Income().longValue());
		othIncome.setMiscOthIncome(profitAndLossDocument.getAny_OtherIncome().longValue());
		othIncome.setTotOthIncome(profitAndLossDocument.getTotal_OtherIncome().longValue());
		creditsToPL.setOthIncome(othIncome);

		creditsToPL.setClosingStock(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getClosing_Stocks()));
		creditsToPL.setTotCreditsToPL(profitAndLossDocument.getTotal_CreditAccount().longValue());
		pARTAPL.setCreditsToPL(creditsToPL);

		DebitsToPL debitsToPL  = new DebitsToPL();
		debitsToPL.setOpeningStock(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getOpening_Stocks()));
		debitsToPL.setPurchases(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getPurchases()));
		DutyTaxPay dutyTaxPay = new DutyTaxPay();
		ExciseCustomsVAT exciseCustomsVATB = new ExciseCustomsVAT();
		exciseCustomsVATB.setCustomDuty(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getCustom_Duty()));
		exciseCustomsVATB.setCounterVailDuty(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getCounter_vailingDuty()));
		exciseCustomsVATB.setSplAddDuty(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getSpecial_addtionalDuty()));
		exciseCustomsVATB.setUnionExciseDuty(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getUnion_ExciseDuty()));
		exciseCustomsVATB.setServiceTax(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getService_TaxPL()));
		//exciseCustomsVATB.setVATorSaleTax(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getVat_Sales())); remaining field pankaj forgot to make a method for this now working
		exciseCustomsVATB.setOthDutyTaxCess(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getAnyOther_TaxPaid()));
		exciseCustomsVATB.setTotExciseCustomsVAT(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getTotal()));
		dutyTaxPay.setExciseCustomsVAT(exciseCustomsVATB);
		debitsToPL.setDutyTaxPay(dutyTaxPay);
		debitsToPL.setFreight(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getFreight()));
		debitsToPL.setConsumptionOfStores(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getConsumption_Stores()));
		debitsToPL.setPowerFuel(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getPower_Fuels()));
		debitsToPL.setRentExpdr(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getRents_PL()));
		debitsToPL.setRepairsBldg(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getRepairs_Buildings()));
		debitsToPL.setRepairMach(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getRepairs_Machinery()));
		EmployeeComp employeeComp = new EmployeeComp();
		employeeComp.setSalsWages(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getSalaries_Wages()));
		employeeComp.setBonus(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getBonus_PL()));
		employeeComp.setMedExpReimb(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getReimbursement_MedicalExpenses()));
		employeeComp.setLeaveEncash(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getLeave_Encasement()));
		employeeComp.setLeaveTravelBenft(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getLeave_TravelBenefits()));
		employeeComp.setContToSuperAnnFund(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getApproved_SuperannuationFund()));
		employeeComp.setContToPF(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getRecog_ProvidendFund()));
		employeeComp.setContToGratFund(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getRecog_GratuityFund()));
		employeeComp.setContToOthFund(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getAny_OtherFund()));
		employeeComp.setOthEmpBenftExpdr(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getAny_otherBenefit()));
		employeeComp.setTotEmployeeComp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getTotal_Compensation()));
		debitsToPL.setEmployeeComp(employeeComp);
		Insurances insurances = new Insurances();
		insurances.setMedInsur(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getMedical_Insurance()));
		insurances.setLifeInsur(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getLife_Insurance()));
		insurances.setKeyManInsur(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getKeyman_Insurance()));
		insurances.setOthInsur(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getOther_Insurance()));
		insurances.setTotInsurances(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getTotalExpense_Insurance()));
		debitsToPL.setInsurances(insurances);
		debitsToPL.setStaffWelfareExp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getStaff_WelfareExpense()));
		debitsToPL.setEntertainment(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getEntertainment_PL()));
		debitsToPL.setHospitality(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getHospitality_PL()));
		debitsToPL.setConference(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getConference_PL()));
		debitsToPL.setSalePromoExp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getSales_Promotion()));
		debitsToPL.setAdvertisement(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getAdvertisement_PL()));
		debitsToPL.setCommissionExpdr(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getCommission_PL()));
		debitsToPL.setHotelBoardLodge(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getBoarding_Lodging()));
		debitsToPL.setTravelExp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getTravelling_Expenses()));
		debitsToPL.setConveyanceExp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getConveyance_Expenses()));
		debitsToPL.setTelephoneExp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getTelephone_Expenses()));
		debitsToPL.setGuestHouseExp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getGuestHouse_Expenses()));
		debitsToPL.setClubExp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getClub_Expenses()));
		debitsToPL.setFestivalCelebExp(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getFestivalCeleb_Expenses()));
		debitsToPL.setScholarship(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getScholarship_PL()));
		debitsToPL.setGift(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getGifts_PL()));
		debitsToPL.setDonation(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getDonation_PL()));
		RatesTaxesPays ratesTaxesPays = new RatesTaxesPays();
		ExciseCustomsVAT exciseCustomsVATC = new ExciseCustomsVAT();
		exciseCustomsVATC.setUnionExciseDuty(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getUnion_ExciseDuty2()));
		exciseCustomsVATC.setServiceTax(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getService_Tax2()));
		exciseCustomsVATC.setVATorSaleTax(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getVat_Salestax2()));
		exciseCustomsVATC.setOthDutyTaxCess(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getCess_PL()));
		exciseCustomsVATC.setCess(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getAnyOther_RateInclSTT()));
		exciseCustomsVATC.setTotExciseCustomsVAT(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getTotalRates_TaxesPaid()));
		ratesTaxesPays.setExciseCustomsVAT(exciseCustomsVATC);
		debitsToPL.setRatesTaxesPays(ratesTaxesPays);
		debitsToPL.setAuditFee(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getAudit_Fee()));
		debitsToPL.setOtherExpenses(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getOther_Expenses()));
		debitsToPL.setBadDebt(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getBad_Debts()));
		debitsToPL.setProvForBadDoubtDebt(profitAndLossDocument.getBad_DoubtfulDebts().longValue());
		debitsToPL.setOthProvisionsExpdr(profitAndLossDocument.getOther_Provisions().longValue());
		debitsToPL.setPBIDTA(profitAndLossDocument.getProfitBefore_InterestTaxes().longValue());
		debitsToPL.setInterestExpdr(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getInterest_PL()));
		debitsToPL.setDepreciationAmort(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getDepreciation_PL()));
		debitsToPL.setPBT(profitAndLossDocument.getProfit_BeforeTaxes().longValue());
		pARTAPL.setDebitsToPL(debitsToPL);

		TaxProvAppr taxProvAppr = new TaxProvAppr();
		taxProvAppr.setProvForCurrTax(profitAndLossDocument.getProv_CurrentTax().longValue());
		taxProvAppr.setProvDefTax(profitAndLossDocument.getProv_DeferredTax().longValue());
		taxProvAppr.setProfitAfterTax(profitAndLossDocument.getProfit_AfterTax().longValue());
		taxProvAppr.setBalBFPrevYr(profitAndLossDocument.getBalance_PreviousYear().longValue());
		taxProvAppr.setAmtAvlAppr(profitAndLossDocument.getAmount_Appropriation().longValue());
		taxProvAppr.setTrfToReserves(profitAndLossDocument.getTransReserves_Surplus().longValue());
		taxProvAppr.setProprietorAccBalTrf(profitAndLossDocument.getBalanceCarried_BalanceSheet().longValue());
		pARTAPL.setTaxProvAppr(taxProvAppr);

		NoBooksOfAccPL noBooksOfAccPL = new NoBooksOfAccPL();
		noBooksOfAccPL.setGrossReceipt(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getGross_Recepients()));
		noBooksOfAccPL.setGrossProfit(profitAndLossDocument.getGross_Profit().longValue());
		noBooksOfAccPL.setExpenses(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getExpenses_NoAccount()));
		noBooksOfAccPL.setNetProfit(profitAndLossDocument.getNet_Profit().longValue());
		pARTAPL.setNoBooksOfAccPL(noBooksOfAccPL);

		return pARTAPL;
	}

}
