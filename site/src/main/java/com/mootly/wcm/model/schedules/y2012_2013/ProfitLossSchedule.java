package com.mootly.wcm.model.schedules.y2012_2013;

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

import java.lang.reflect.Field;
import java.math.BigInteger;

import org.springframework.beans.DirectFieldAccessor;

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
				if(field.getType().getSimpleName().equals(String.class.getSimpleName())){
					if(field.getName().equals("isAccountMaintain")){
						directFieldAccessor.setPropertyValue(field.getName(), "Yes");
					}
				}
			}
			this.profitAndLossDocument = profitAndLossDocumentDummy;
		}

		if(profitAndLossDocument.getIsAccountMaintain().equals("Yes")){
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
			exciseCustomsVATB.setVATorSaleTax(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getVat_SalesTaxPL()));
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
			noBooksOfAccPL.setGrossReceipt(new BigInteger("0"));
			noBooksOfAccPL.setGrossProfit(0);
			noBooksOfAccPL.setExpenses(new BigInteger("0"));
			noBooksOfAccPL.setNetProfit(0);
			pARTAPL.setNoBooksOfAccPL(noBooksOfAccPL);
		}

		if(profitAndLossDocument.getIsAccountMaintain().equals("No")){
			CreditsToPL creditsToPL = new CreditsToPL();
			creditsToPL.setBusinessReceipts(new BigInteger("0"));
			ExciseCustomsVAT exciseCustomsVAT = new ExciseCustomsVAT();
			exciseCustomsVAT.setUnionExciseDuty(new BigInteger("0"));
			exciseCustomsVAT.setServiceTax(new BigInteger("0"));
			exciseCustomsVAT.setVATorSaleTax(new BigInteger("0"));
			exciseCustomsVAT.setOthDutyTaxCess(new BigInteger("0"));
			exciseCustomsVAT.setTotExciseCustomsVAT(new BigInteger("0"));
			creditsToPL.setExciseCustomsVAT(exciseCustomsVAT);

			OthIncome othIncome = new OthIncome();
			othIncome.setRentInc(new BigInteger("0"));
			othIncome.setComissions(new BigInteger("0"));
			othIncome.setDividends(new BigInteger("0"));
			othIncome.setInterestInc(new BigInteger("0"));
			othIncome.setProfitOnSaleFixedAsset(0);
			othIncome.setProfitOnInvChrSTT(0);
			othIncome.setProfitOnOthInv(0);
			othIncome.setProfitOnCurrFluct(0);
			othIncome.setProfitOnAgriIncome(0);
			othIncome.setMiscOthIncome(0);
			othIncome.setTotOthIncome(0);
			creditsToPL.setOthIncome(othIncome);

			creditsToPL.setClosingStock(new BigInteger("0"));
			creditsToPL.setTotCreditsToPL(0);
			pARTAPL.setCreditsToPL(creditsToPL);

			DebitsToPL debitsToPL  = new DebitsToPL();
			debitsToPL.setOpeningStock(new BigInteger("0"));
			debitsToPL.setPurchases(new BigInteger("0"));
			DutyTaxPay dutyTaxPay = new DutyTaxPay();
			ExciseCustomsVAT exciseCustomsVATB = new ExciseCustomsVAT();
			exciseCustomsVATB.setCustomDuty(new BigInteger("0"));
			exciseCustomsVATB.setCounterVailDuty(new BigInteger("0"));
			exciseCustomsVATB.setSplAddDuty(new BigInteger("0"));
			exciseCustomsVATB.setUnionExciseDuty(new BigInteger("0"));
			exciseCustomsVATB.setServiceTax(new BigInteger("0"));
			//exciseCustomsVATB.setVATorSaleTax(new BigInteger("0")); remaining field pankaj forgot to make a method for this now working
			exciseCustomsVATB.setOthDutyTaxCess(new BigInteger("0"));
			exciseCustomsVATB.setTotExciseCustomsVAT(new BigInteger("0"));
			dutyTaxPay.setExciseCustomsVAT(exciseCustomsVATB);
			debitsToPL.setDutyTaxPay(dutyTaxPay);
			debitsToPL.setFreight(new BigInteger("0"));
			debitsToPL.setConsumptionOfStores(new BigInteger("0"));
			debitsToPL.setPowerFuel(new BigInteger("0"));
			debitsToPL.setRentExpdr(new BigInteger("0"));
			debitsToPL.setRepairsBldg(new BigInteger("0"));
			debitsToPL.setRepairMach(new BigInteger("0"));
			EmployeeComp employeeComp = new EmployeeComp();
			employeeComp.setSalsWages(new BigInteger("0"));
			employeeComp.setBonus(new BigInteger("0"));
			employeeComp.setMedExpReimb(new BigInteger("0"));
			employeeComp.setLeaveEncash(new BigInteger("0"));
			employeeComp.setLeaveTravelBenft(new BigInteger("0"));
			employeeComp.setContToSuperAnnFund(new BigInteger("0"));
			employeeComp.setContToPF(new BigInteger("0"));
			employeeComp.setContToGratFund(new BigInteger("0"));
			employeeComp.setContToOthFund(new BigInteger("0"));
			employeeComp.setOthEmpBenftExpdr(new BigInteger("0"));
			employeeComp.setTotEmployeeComp(new BigInteger("0"));
			debitsToPL.setEmployeeComp(employeeComp);
			Insurances insurances = new Insurances();
			insurances.setMedInsur(new BigInteger("0"));
			insurances.setLifeInsur(new BigInteger("0"));
			insurances.setKeyManInsur(new BigInteger("0"));
			insurances.setOthInsur(new BigInteger("0"));
			insurances.setTotInsurances(new BigInteger("0"));
			debitsToPL.setInsurances(insurances);
			debitsToPL.setStaffWelfareExp(new BigInteger("0"));
			debitsToPL.setEntertainment(new BigInteger("0"));
			debitsToPL.setHospitality(new BigInteger("0"));
			debitsToPL.setConference(new BigInteger("0"));
			debitsToPL.setSalePromoExp(new BigInteger("0"));
			debitsToPL.setAdvertisement(new BigInteger("0"));
			debitsToPL.setCommissionExpdr(new BigInteger("0"));
			debitsToPL.setHotelBoardLodge(new BigInteger("0"));
			debitsToPL.setTravelExp(new BigInteger("0"));
			debitsToPL.setConveyanceExp(new BigInteger("0"));
			debitsToPL.setTelephoneExp(new BigInteger("0"));
			debitsToPL.setGuestHouseExp(new BigInteger("0"));
			debitsToPL.setClubExp(new BigInteger("0"));
			debitsToPL.setFestivalCelebExp(new BigInteger("0"));
			debitsToPL.setScholarship(new BigInteger("0"));
			debitsToPL.setGift(new BigInteger("0"));
			debitsToPL.setDonation(new BigInteger("0"));
			RatesTaxesPays ratesTaxesPays = new RatesTaxesPays();
			ExciseCustomsVAT exciseCustomsVATC = new ExciseCustomsVAT();
			exciseCustomsVATC.setUnionExciseDuty(new BigInteger("0"));
			exciseCustomsVATC.setServiceTax(new BigInteger("0"));
			exciseCustomsVATC.setVATorSaleTax(new BigInteger("0"));
			exciseCustomsVATC.setOthDutyTaxCess(new BigInteger("0"));
			exciseCustomsVATC.setCess(new BigInteger("0"));
			exciseCustomsVATC.setTotExciseCustomsVAT(new BigInteger("0"));
			ratesTaxesPays.setExciseCustomsVAT(exciseCustomsVATC);
			debitsToPL.setRatesTaxesPays(ratesTaxesPays);
			debitsToPL.setAuditFee(new BigInteger("0"));
			debitsToPL.setOtherExpenses(new BigInteger("0"));
			debitsToPL.setBadDebt(new BigInteger("0"));
			debitsToPL.setProvForBadDoubtDebt(0);
			debitsToPL.setOthProvisionsExpdr(0);
			debitsToPL.setPBIDTA(0);
			debitsToPL.setInterestExpdr(new BigInteger("0"));
			debitsToPL.setDepreciationAmort(new BigInteger("0"));
			debitsToPL.setPBT(0);
			pARTAPL.setDebitsToPL(debitsToPL);

			TaxProvAppr taxProvAppr = new TaxProvAppr();
			taxProvAppr.setProvForCurrTax(0);
			taxProvAppr.setProvDefTax(0);
			taxProvAppr.setProfitAfterTax(0);
			taxProvAppr.setBalBFPrevYr(0);
			taxProvAppr.setAmtAvlAppr(0);
			taxProvAppr.setTrfToReserves(0);
			taxProvAppr.setProprietorAccBalTrf(0);
			pARTAPL.setTaxProvAppr(taxProvAppr);

			NoBooksOfAccPL noBooksOfAccPL = new NoBooksOfAccPL();
			noBooksOfAccPL.setGrossReceipt(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getGross_Recepients()));
			noBooksOfAccPL.setGrossProfit(profitAndLossDocument.getGross_Profit().longValue());
			noBooksOfAccPL.setExpenses(indianCurrencyHelper.bigIntegerRound(profitAndLossDocument.getExpenses_NoAccount()));
			noBooksOfAccPL.setNetProfit(profitAndLossDocument.getNet_Profit().longValue());
			pARTAPL.setNoBooksOfAccPL(noBooksOfAccPL);
		}

		return pARTAPL;
	}

}
