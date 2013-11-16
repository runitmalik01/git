package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.CurrAssetLoanAdv;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.CashOrBankBal;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.Inventories;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.Provisions;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.FixedAsset;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.Investments;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.Investments.LongTermInv;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.Investments.TradeInv;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundApply.MiscAdjust;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundSrc;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundSrc.LoanFunds;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundSrc.LoanFunds.SecrLoan;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundSrc.LoanFunds.SecrLoan.RupeeLoan;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundSrc.LoanFunds.UnsecrLoan;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundSrc.PropFund;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.FundSrc.PropFund.ResrNSurp;
import in.gov.incometaxindiaefiling.y2013_2014.PARTABS.NoBooksOfAccBS;

import java.lang.reflect.Field;
import java.math.BigInteger;

import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.beans.BalanceSheetDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class PartA_BS {
	
	BalanceSheetDocument balanceSheetDocument = null;

	public PartA_BS(BalanceSheetDocument balanceSheetDocument) {
		// TODO Auto-generated constructor stub
		this.balanceSheetDocument = balanceSheetDocument;
	}
	
	public PARTABS getPartABalanceSheet(ITR itr,FinancialYear financialYear){
		IndianCurrencyHelper helper = new IndianCurrencyHelper();
		PARTABS partabs = new PARTABS();
		PARTABS.FundSrc fundSrc = new FundSrc();
		PARTABS.FundSrc.PropFund propFund = new PropFund();
		PARTABS.FundSrc.PropFund.ResrNSurp resrNSurp = new ResrNSurp();
		PARTABS.FundSrc.LoanFunds loanFunds = new LoanFunds();
		PARTABS.FundSrc.LoanFunds.SecrLoan secrLoan = new SecrLoan();
		PARTABS.FundSrc.LoanFunds.SecrLoan.RupeeLoan rupeeLoan = new RupeeLoan();
		PARTABS.FundSrc.LoanFunds.UnsecrLoan unsecrLoan = new UnsecrLoan();
		PARTABS.FundApply fundApply = new FundApply();
		PARTABS.FundApply.FixedAsset fixedAsset = new FixedAsset();
		PARTABS.FundApply.CurrAssetLoanAdv currAssetLoanAdv = new CurrAssetLoanAdv();
		PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset currAsset = new CurrAsset();
		PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.Inventories inventories = new Inventories();
		PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.CashOrBankBal cashOrBankBal = new CashOrBankBal();
		PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv currLiabilitiesProv = new CurrLiabilitiesProv();
		PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities currLiabilities = new CurrLiabilities();
		PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.Provisions provisions = new Provisions();
		PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv loanAdv = new LoanAdv();
		PARTABS.FundApply.Investments investments = new Investments();
		PARTABS.FundApply.Investments.LongTermInv longTermInv = new LongTermInv();
		PARTABS.FundApply.Investments.TradeInv tradeInv = new TradeInv();
		PARTABS.FundApply.MiscAdjust miscAdjust = new MiscAdjust();
		PARTABS.NoBooksOfAccBS noBooksOfAccBS = new NoBooksOfAccBS();
		if(balanceSheetDocument == null){
			BalanceSheetDocument dummySheetDocument = new BalanceSheetDocument();
			Field[] balSheetFields = BalanceSheetDocument.class.getDeclaredFields();
			for(Field balField:balSheetFields){
				if(balField.getType().getSimpleName().equalsIgnoreCase(Double.class.getSimpleName())){
					DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(dummySheetDocument);
					directFieldAccessor.setPropertyValue(balField.getName(), 0d);
				}
			}
			balanceSheetDocument = dummySheetDocument;
		}
		if(balanceSheetDocument != null){
			resrNSurp.setCapResr(helper.bigIntegerRound(balanceSheetDocument.getCapReserve()));
			resrNSurp.setStatResr(helper.bigIntegerRound(balanceSheetDocument.getStatReserve()));
			resrNSurp.setOthResr(helper.bigIntegerRound(balanceSheetDocument.getOtherReserve()));
			resrNSurp.setRevResr(helper.bigIntegerRound(balanceSheetDocument.getReavReserve()));
			resrNSurp.setTotResrNSurp(resrNSurp.getCapResr().add(resrNSurp.getOthResr().add(resrNSurp.getRevResr().add(resrNSurp.getStatResr()))));
			
			propFund.setPropCap(helper.longRound(balanceSheetDocument.getPropCapital()));
			propFund.setResrNSurp(resrNSurp);
			propFund.setTotPropFund(propFund.getResrNSurp().getTotResrNSurp().longValue()+propFund.getPropCap());
			
			rupeeLoan.setFrmBank(helper.bigIntegerRound(balanceSheetDocument.getRupLoanBank()));
			rupeeLoan.setFrmOthrs(helper.bigIntegerRound(balanceSheetDocument.getRupLoanOther()));
			rupeeLoan.setTotRupeeLoan(rupeeLoan.getFrmBank().add(rupeeLoan.getFrmOthrs()));
			secrLoan.setForeignCurrLoan(helper.bigIntegerRound(balanceSheetDocument.getForgnCurrLoan()));
			secrLoan.setRupeeLoan(rupeeLoan);
			secrLoan.setTotSecrLoan(secrLoan.getRupeeLoan().getTotRupeeLoan().add(secrLoan.getForeignCurrLoan()));
			
			unsecrLoan.setFrmBank(helper.bigIntegerRound(balanceSheetDocument.getUnsecLoanBank()));
			unsecrLoan.setFrmOthrs(helper.bigIntegerRound(balanceSheetDocument.getUnsecLoanOther()));
			unsecrLoan.setTotUnSecrLoan(unsecrLoan.getFrmBank().add(unsecrLoan.getFrmOthrs()));
			loanFunds.setSecrLoan(secrLoan);
			loanFunds.setUnsecrLoan(unsecrLoan);
			loanFunds.setTotLoanFund(loanFunds.getUnsecrLoan().getTotUnSecrLoan().add(loanFunds.getSecrLoan().getTotSecrLoan()));
			
			fundSrc.setLoanFunds(loanFunds);
			fundSrc.setPropFund(propFund);
			fundSrc.setDeferredTax(helper.bigIntegerRound(balanceSheetDocument.getDefTaxLiability()));
			fundSrc.setTotFundSrc(helper.longRound(balanceSheetDocument.getSourcOfFund()));
			
			fixedAsset.setCapWrkProg(helper.bigIntegerRound(balanceSheetDocument.getCapWorkProgrss()));
			fixedAsset.setDepreciation(helper.bigIntegerRound(balanceSheetDocument.getDepreciation()));
			fixedAsset.setGrossBlock(helper.bigIntegerRound(balanceSheetDocument.getGrossBlock()));
			fixedAsset.setNetBlock(fixedAsset.getGrossBlock().subtract(fixedAsset.getDepreciation()).doubleValue() > 0d ? fixedAsset.getGrossBlock().subtract(fixedAsset.getDepreciation()) : new BigInteger("0"));
			fixedAsset.setTotFixedAsset(helper.bigIntegerRound(balanceSheetDocument.getGrossFixedAsset()));
			
			inventories.setFinOrTradGood(helper.bigIntegerRound(balanceSheetDocument.getFinishGoods()));
			inventories.setRawMatl(helper.bigIntegerRound(balanceSheetDocument.getRawMaterial()));
			inventories.setStkInProcess(helper.bigIntegerRound(balanceSheetDocument.getStockProcess()));
			inventories.setStoresConsumables(helper.bigIntegerRound(balanceSheetDocument.getStoresConsum()));
			inventories.setTotInventries(inventories.getFinOrTradGood().add(inventories.getRawMatl().add(inventories.getStkInProcess().add(inventories.getStoresConsumables()))));
			
			cashOrBankBal.setBankBal(helper.longRound(balanceSheetDocument.getBalanceBank()));
			cashOrBankBal.setCashinHand(helper.bigIntegerRound(balanceSheetDocument.getCashInHand()));
			cashOrBankBal.setTotCashOrBankBal(cashOrBankBal.getBankBal() + cashOrBankBal.getCashinHand().longValue());
			currAsset.setCashOrBankBal(cashOrBankBal);
			currAsset.setInventories(inventories);
			currAsset.setSndryDebtors(helper.bigIntegerRound(balanceSheetDocument.getSundryDebtor()));
			currAsset.setOthCurrAsset(helper.longRound(balanceSheetDocument.getOtherCurrAsset()));
			currAsset.setTotCurrAsset(helper.longRound(balanceSheetDocument.getGrossCurrAssets()));
			
			currLiabilities.setAccrIntNotDue(helper.bigIntegerRound(balanceSheetDocument.getInterestAcuurNtLoan()));
			currLiabilities.setAccrIntonLeasedAsset(helper.bigIntegerRound(balanceSheetDocument.getInterestAcuurOnabove()));
			currLiabilities.setLiabForLeasedAsset(helper.bigIntegerRound(balanceSheetDocument.getLaibLeaseAsset()));
			currLiabilities.setSundryCred(helper.bigIntegerRound(balanceSheetDocument.getSundryCreditor()));
			currLiabilities.setTotCurrLiabilities(helper.bigIntegerRound(balanceSheetDocument.getGrossCurrLiability()));
			
			provisions.setITProvision(helper.bigIntegerRound(balanceSheetDocument.getIncometaxProvis()));
			provisions.setOthProvision(helper.bigIntegerRound(balanceSheetDocument.getOtherProvis()));
			provisions.setWTProvision(helper.bigIntegerRound(balanceSheetDocument.getWealthTaxProvis()));
			provisions.setELSuperAnnGratProvision(helper.bigIntegerRound(balanceSheetDocument.getLeaveProvis()));
			provisions.setTotProvisions(helper.bigIntegerRound(balanceSheetDocument.getGrossProvision()));
			currLiabilitiesProv.setCurrLiabilities(currLiabilities);
			currLiabilitiesProv.setProvisions(provisions);
			currLiabilitiesProv.setTotCurrLiabilitiesProvision(helper.bigIntegerRound(balanceSheetDocument.getGrossCurrLaibilProvison()));
			
			loanAdv.setAdvRecoverable(helper.bigIntegerRound(balanceSheetDocument.getAdvancRecover()));
			loanAdv.setBalWithRevAuth(helper.bigIntegerRound(balanceSheetDocument.getBalWthRevenAuth()));
			loanAdv.setDeposits(helper.bigIntegerRound(balanceSheetDocument.getLoanAdvanCorpOthr()));
			loanAdv.setTotLoanAdv(helper.bigIntegerRound(balanceSheetDocument.getGrossCurrAssLoanAdvan()));
			currAssetLoanAdv.setCurrAsset(currAsset);
			currAssetLoanAdv.setCurrLiabilitiesProv(currLiabilitiesProv);
			currAssetLoanAdv.setLoanAdv(loanAdv);
			currAssetLoanAdv.setNetCurrAsset(helper.longRound(balanceSheetDocument.getNetCurrAssets()));
			currAssetLoanAdv.setTotCurrAssetLoanAdv(currAssetLoanAdv.getLoanAdv().getTotLoanAdv().longValue()+currAssetLoanAdv.getCurrAsset().getTotCurrAsset());
			
			longTermInv.setGovOthSecUnQoted(helper.bigIntegerRound(balanceSheetDocument.getLtInvestUnquot()));
			longTermInv.setGovtOthSecQuoted(helper.bigIntegerRound(balanceSheetDocument.getLtInvestQuot()));
			longTermInv.setTotLongTermInv(longTermInv.getGovOthSecUnQoted().add(longTermInv.getGovtOthSecQuoted()));
			tradeInv.setDebenture(helper.bigIntegerRound(balanceSheetDocument.getStInvestDebent()));
			tradeInv.setEquityShares(helper.bigIntegerRound(balanceSheetDocument.getStInvestEquity()));
			tradeInv.setPreferShares(helper.bigIntegerRound(balanceSheetDocument.getStInvestPrefShare()));
			tradeInv.setTotTradeInv(tradeInv.getDebenture().add(tradeInv.getEquityShares().add(tradeInv.getPreferShares())));
			investments.setLongTermInv(longTermInv);
			investments.setTradeInv(tradeInv);
			investments.setTotInvestments(helper.bigIntegerRound(balanceSheetDocument.getGrossInvest()));
			
			miscAdjust.setMiscExpndr(helper.bigIntegerRound(balanceSheetDocument.getMiscellanExpend()));
			miscAdjust.setDefTaxAsset(helper.bigIntegerRound(balanceSheetDocument.getDeftaxAssets()));
			miscAdjust.setAccumaltedLosses(helper.bigIntegerRound(balanceSheetDocument.getProfLoassAccn()));
			miscAdjust.setTotMiscAdjust(miscAdjust.getAccumaltedLosses().add(miscAdjust.getDefTaxAsset().add(miscAdjust.getMiscExpndr())));
			
			fundApply.setCurrAssetLoanAdv(currAssetLoanAdv);
			fundApply.setFixedAsset(fixedAsset);
			fundApply.setInvestments(investments);
			fundApply.setMiscAdjust(miscAdjust);
			fundApply.setTotFundApply(helper.longRound(balanceSheetDocument.getGrossAppliFund()));
			
			noBooksOfAccBS.setCashBalAmt(helper.bigIntegerRound(balanceSheetDocument.getCashBalance()));
			noBooksOfAccBS.setTotStkInTradAmt(helper.bigIntegerRound(balanceSheetDocument.getTotalStockTrade()));
			noBooksOfAccBS.setTotSundryCrdAmt(helper.bigIntegerRound(balanceSheetDocument.getTotalSundryCreditor()));
			noBooksOfAccBS.setTotSundryDbtAmt(helper.bigIntegerRound(balanceSheetDocument.getTotalSundryDebtor()));
			
			partabs.setFundSrc(fundSrc);
			partabs.setNoBooksOfAccBS(noBooksOfAccBS);
			partabs.setFundApply(fundApply);
		}
		
		return partabs;
	}
}
