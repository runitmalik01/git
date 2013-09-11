/**
 * 
 * User: pankaj
 * Date: 
 * 
 */

package com.mootly.wcm.beans;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;

public abstract class IncBusinessProfessionVar extends BaseDocument implements
		ContentNodeBinder, FormMapFiller {

	private Double profitBeforeTax;
	private Double profitLoss_SpecualtiveBusiness;
	private Double profitLoss_SpecifiedBusiness;
	private Double incomeCredited_ProfitLossAcc;
	private Double profitLoss_IncludeSchPL;
	private Double shareIncome_Firms;
	private Double shareIncome_Firms_AOP;
	private Double exemptIncome_AnyOther;
	private Double balance;
	private Double total_ExemptIncome;
	private Double expenseDebit_HeadsInc;
	private Double expenseDebit_ExemptInc;
	private Double total_Expense;
	private Double adjusted_ProfitLoss;
	private Double depreAllow_us32_1_ii;
	private Double depreAllow_us32_1_i;
	private Double depreciation_total;
	private Double plAfter_AdjustDepr;
	private Double amountDebit_sec36;
	private Double amountDebit_sec37;
	private Double amountDebit_sec40;
	private Double amountDebit_sec40A;
	private Double amountDebit_sec43B;
	private Double interestDisallow_sec23;
	private Double deemedIncome_Sec41;
	private Double deemedIncome_Sec33AB;
	private Double addItem_sec28to44DA;
	private Double anyIncNotInclude_PLAcc;
	private Double totalIncome_sec;
	private Double deductionAllow_Sec32_1_iii;
	private Double amountDed_Sec35;
	private Double amountDisAllow_Sec40;

	private Double amountDisAllow_Sec43B;
	private Double amountDebited_ToProfitLoss;
	private Double amountAllow_Deduction;
	private Double excessAmountAllow_Deduction;
	private Double anyOtherAmountAllow_Deduction;
	private Double total_Deduction;
	private Double income_AfterDed;
	private Double section44AD;
	private Double section44AE;
	private Double section44AF;
	private Double section44B;

	private Double section44BB;
	private Double section44BBA;
	private Double section44BBB;
	private Double section44D;
	private Double section44DA;
	private Double chapter_XII_G;
	private Double firstSchedule_ITAct;
	private Double total_Sections;
	private Double plBefore_DedUs10A;
	private Double deduction_Sec10A;
	private Double deduction_Sec10AA;
	private Double deduction_total10;
	private Double netPL_otherthanSpeculative_SpecifiedBuss;
	private Double netPL_otherthanSpeculative_SpecifiedBuss1;
	private Double netPl_FromBP;
	private Double computeInc_SpeculativeBuss;
	private Double addAccordance_28to44DA;
	private Double dedAccordance_28to44DA;
	private Double pl_SpeculativeBuss;
	private Double netPLFrom_SPecifiedInc;
	private Double additionAcc28to44D;
	private Double dedAcc28to44DEx35AD;
	private Double pl_SpecifiedBuss;
	private Double dedAcc35AD;
	private Double pl_SpecifiedBussNet;
	private Double depreciation_PL;
	private Double incomeChargeable_PL;

	// getter methods
	public Double getProfitBeforeTax() {
		if (profitBeforeTax == null)
			profitBeforeTax = getProperty("mootlywcm:profitBeforeTax");
		return profitBeforeTax;
	}

	public Double getProfitLoss_SpecualtiveBusiness() {
		if (profitLoss_SpecualtiveBusiness == null)
			profitLoss_SpecualtiveBusiness = getProperty("mootlywcm:profitLoss_SpecualtiveBusiness");
		return profitLoss_SpecualtiveBusiness;
	}

	public Double getProfitLoss_SpecifiedBusiness() {
		if (profitLoss_SpecifiedBusiness == null)
			profitLoss_SpecifiedBusiness = getProperty("mootlywcm:profitLoss_SpecifiedBusiness");
		return profitLoss_SpecifiedBusiness;
	}

	public Double getIncomeCredited_ProfitLossAcc() {
		if (incomeCredited_ProfitLossAcc == null)
			incomeCredited_ProfitLossAcc = getProperty("mootlywcm:incomeCredited_ProfitLossAcc");
		return incomeCredited_ProfitLossAcc;
	}

	public Double getProfitLoss_IncludeSchPL() {
		if (profitLoss_IncludeSchPL == null)
			profitLoss_IncludeSchPL = getProperty("mootlywcm:profitLoss_IncludeSchPL");
		return profitLoss_IncludeSchPL;
	}

	public Double getShareIncome_Firms() {
		if (shareIncome_Firms == null)
			shareIncome_Firms = getProperty("mootlywcm:shareIncome_Firms");
		return shareIncome_Firms;
	}

	public Double getShareIncome_Firms_AOP() {
		if (shareIncome_Firms_AOP == null)
			shareIncome_Firms_AOP = getProperty("mootlywcm:shareIncome_Firms_AOP");
		return shareIncome_Firms_AOP;
	}

	public Double getExemptIncome_AnyOther() {
		if (exemptIncome_AnyOther == null)
			exemptIncome_AnyOther = getProperty("mootlywcm:exemptIncome_AnyOther");
		return exemptIncome_AnyOther;
	}

	public Double getBalance() {
		if (balance == null)
			balance = getProperty("mootlywcm:balance");
		return balance;
	}

	public Double getTotal_ExemptIncome() {
		if (total_ExemptIncome == null)
			total_ExemptIncome = getProperty("mootlywcm:total_ExemptIncome");
		return total_ExemptIncome;
	}

	public Double getExpenseDebit_HeadsInc() {
		if (expenseDebit_HeadsInc == null)
			expenseDebit_HeadsInc = getProperty("mootlywcm:expenseDebit_HeadsInc");
		return expenseDebit_HeadsInc;
	}

	public Double getExpenseDebit_ExemptInc() {
		if (expenseDebit_ExemptInc == null)
			expenseDebit_ExemptInc = getProperty("mootlywcm:expenseDebit_ExemptInc");
		return expenseDebit_ExemptInc;
	}

	public Double getTotal_Expense() {
		if (total_Expense == null)
			total_Expense = getProperty("mootlywcm:total_Expense");
		return total_Expense;
	}

	public Double getAdjusted_ProfitLoss() {
		if (adjusted_ProfitLoss == null)
			adjusted_ProfitLoss = getProperty("mootlywcm:adjusted_ProfitLoss");
		return adjusted_ProfitLoss;
	}

	public Double getDepreAllow_us32_1_ii() {
		if (depreAllow_us32_1_ii == null)
			depreAllow_us32_1_ii = getProperty("mootlywcm:depreAllow_us32_1_ii");
		return depreAllow_us32_1_ii;
	}

	public Double getDepreAllow_us32_1_i() {
		if (depreAllow_us32_1_i == null)
			depreAllow_us32_1_i = getProperty("mootlywcm:depreAllow_us32_1_i");
		return depreAllow_us32_1_i;
	}

	public Double getDepreciation_total() {
		if (depreciation_total == null)
			depreciation_total = getProperty("mootlywcm:depreciation_total");
		return depreciation_total;
	}

	public Double getPlAfter_AdjustDepr() {
		if (plAfter_AdjustDepr == null)
			plAfter_AdjustDepr = getProperty("mootlywcm:plAfter_AdjustDepr");
		return plAfter_AdjustDepr;
	}

	public Double getAmountDebit_sec36() {
		if (amountDebit_sec36 == null)
			amountDebit_sec36 = getProperty("mootlywcm:amountDebit_sec36");
		return amountDebit_sec36;
	}

	public Double getAmountDebit_sec37() {
		if (amountDebit_sec37 == null)
			amountDebit_sec37 = getProperty("mootlywcm:amountDebit_sec37");
		return amountDebit_sec37;
	}

	public Double getAmountDebit_sec40() {
		if (amountDebit_sec40 == null)
			amountDebit_sec40 = getProperty("mootlywcm:amountDebit_sec40");
		return amountDebit_sec40;
	}

	public Double getAmountDebit_sec40A() {
		if (amountDebit_sec40A == null)
			amountDebit_sec40A = getProperty("mootlywcm:amountDebit_sec40A");
		return amountDebit_sec40A;
	}

	public Double getAmountDebit_sec43B() {
		if (amountDebit_sec43B == null)
			amountDebit_sec43B = getProperty("mootlywcm:amountDebit_sec43B");
		return amountDebit_sec43B;
	}

	public Double getInterestDisallow_sec23() {
		if (interestDisallow_sec23 == null)
			interestDisallow_sec23 = getProperty("mootlywcm:interestDisallow_sec23");
		return interestDisallow_sec23;
	}

	public Double getDeemedIncome_Sec41() {
		if (deemedIncome_Sec41 == null)
			deemedIncome_Sec41 = getProperty("mootlywcm:deemedIncome_Sec41");
		return deemedIncome_Sec41;
	}

	public Double getDeemedIncome_Sec33AB() {
		if (deemedIncome_Sec33AB == null)
			deemedIncome_Sec33AB = getProperty("mootlywcm:deemedIncome_Sec33AB");
		return deemedIncome_Sec33AB;
	}

	public Double getAddItem_sec28to44DA() {
		if (addItem_sec28to44DA == null)
			addItem_sec28to44DA = getProperty("mootlywcm:addItem_sec28to44DA");
		return addItem_sec28to44DA;
	}

	public Double getAnyIncNotInclude_PLAcc() {
		if (anyIncNotInclude_PLAcc == null)
			anyIncNotInclude_PLAcc = getProperty("mootlywcm:anyIncNotInclude_PLAcc");
		return anyIncNotInclude_PLAcc;
	}

	public Double getTotalIncome_sec() {
		if (totalIncome_sec == null)
			totalIncome_sec = getProperty("mootlywcm:totalIncome_sec");
		return totalIncome_sec;
	}

	public Double getDeductionAllow_Sec32_1_iii() {
		if (deductionAllow_Sec32_1_iii == null)
			deductionAllow_Sec32_1_iii = getProperty("mootlywcm:deductionAllow_Sec32_1_iii");
		return deductionAllow_Sec32_1_iii;
	}

	public Double getAmountDed_Sec35() {
		if (amountDed_Sec35 == null)
			amountDed_Sec35 = getProperty("mootlywcm:amountDed_Sec35");
		return amountDed_Sec35;
	}

	public Double getAmountDisAllow_Sec40() {
		if (amountDisAllow_Sec40 == null)
			amountDisAllow_Sec40 = getProperty("mootlywcm:amountDisAllow_Sec40");
		return amountDisAllow_Sec40;
	}

	public Double getAmountDisAllow_Sec43B() {
		if (amountDisAllow_Sec43B == null)
			amountDisAllow_Sec43B = getProperty("mootlywcm:amountDisAllow_Sec43B");
		return amountDisAllow_Sec43B;
	}

	public Double getAmountAllow_Deduction() {
		if (amountAllow_Deduction == null)
			amountAllow_Deduction = getProperty("mootlywcm:amountAllow_Deduction");
		return amountAllow_Deduction;
	}

	public Double getAmountDebited_ToProfitLoss() {
		if (amountDebited_ToProfitLoss == null)
			amountDebited_ToProfitLoss = getProperty("mootlywcm:amountDebited_ToProfitLoss");
		return amountDebited_ToProfitLoss;
	}

	public Double getExcessAmountAllow_Deduction() {
		if (excessAmountAllow_Deduction == null)
			excessAmountAllow_Deduction = getProperty("mootlywcm:excessAmountAllow_Deduction");
		return excessAmountAllow_Deduction;
	}

	public Double getAnyOtherAmountAllow_Deduction() {
		if (anyOtherAmountAllow_Deduction == null)
			anyOtherAmountAllow_Deduction = getProperty("mootlywcm:anyOtherAmountAllow_Deduction");
		return anyOtherAmountAllow_Deduction;
	}

	public Double getTotal_Deduction() {
		if (total_Deduction == null)
			total_Deduction = getProperty("mootlywcm:total_Deduction");
		return total_Deduction;
	}

	public Double getIncome_AfterDed() {
		if (income_AfterDed == null)
			income_AfterDed = getProperty("mootlywcm:income_AfterDed");
		return income_AfterDed;
	}

	public Double getSection44AD() {
		if (section44AD == null)
			section44AD = getProperty("mootlywcm:section44AD");
		return section44AD;
	}

	public Double getSection44AE() {
		if (section44AE == null)
			section44AE = getProperty("mootlywcm:section44AE");
		return section44AE;
	}

	public Double getSection44AF() {
		if (section44AF == null)
			section44AF = getProperty("mootlywcm:section44AF");
		return section44AF;
	}

	public Double getSection44B() {
		if (section44B == null)
			section44B = getProperty("mootlywcm:section44B");
		return section44B;
	}

	public Double getSection44BB() {
		if (section44BB == null)
			section44BB = getProperty("mootlywcm:section44BB");
		return section44BB;
	}

	public Double getSection44BBA() {
		if (section44BBA == null)
			section44BBA = getProperty("mootlywcm:section44BBA");
		return section44BBA;
	}

	public Double getSection44BBB() {
		if (section44BBB == null)
			section44BBB = getProperty("mootlywcm:section44BBB");
		return section44BBB;
	}

	public Double getSection44D() {
		if (section44D == null)
			section44D = getProperty("mootlywcm:section44D");
		return section44D;
	}

	public Double getSection44DA() {
		if (section44DA == null)
			section44DA = getProperty("mootlywcm:section44DA");
		return section44DA;
	}

	public Double getChapter_XII_G() {
		if (chapter_XII_G == null)
			chapter_XII_G = getProperty("mootlywcm:chapter_XII_G");
		return chapter_XII_G;
	}

	public Double getFirstSchedule_ITAct() {
		if (firstSchedule_ITAct == null)
			firstSchedule_ITAct = getProperty("mootlywcm:firstSchedule_ITAct");
		return firstSchedule_ITAct;
	}

	public Double getTotal_Sections() {
		if (total_Sections == null)
			total_Sections = getProperty("mootlywcm:total_Sections");
		return total_Sections;
	}

	public Double getPlBefore_DedUs10A() {
		if (plBefore_DedUs10A == null)
			plBefore_DedUs10A = getProperty("mootlywcm:plBefore_DedUs10A");
		return plBefore_DedUs10A;
	}

	public Double getDeduction_Sec10A() {
		if (deduction_Sec10A == null)
			deduction_Sec10A = getProperty("mootlywcm:deduction_Sec10A");
		return deduction_Sec10A;
	}

	public Double getDeduction_Sec10AA() {
		if (deduction_Sec10AA == null)
			deduction_Sec10AA = getProperty("mootlywcm:deduction_Sec10AA");
		return deduction_Sec10AA;
	}

	public Double getDeduction_total10() {
		if (deduction_total10 == null)
			deduction_total10 = getProperty("mootlywcm:deduction_total10");
		return deduction_total10;
	}

	public Double getNetPL_otherthanSpeculative_SpecifiedBuss() {
		if (netPL_otherthanSpeculative_SpecifiedBuss == null)
			netPL_otherthanSpeculative_SpecifiedBuss = getProperty("mootlywcm:netPL_otherthanSpeculative_SpecifiedBuss");
		return netPL_otherthanSpeculative_SpecifiedBuss;
	}

	public Double getNetPL_otherthanSpeculative_SpecifiedBuss1() {
		if (netPL_otherthanSpeculative_SpecifiedBuss1 == null)
			netPL_otherthanSpeculative_SpecifiedBuss1 = getProperty("mootlywcm:netPL_otherthanSpeculative_SpecifiedBuss1");
		return netPL_otherthanSpeculative_SpecifiedBuss1;
	}

	public Double getNetPl_FromBP() {
		if (netPl_FromBP == null)
			netPl_FromBP = getProperty("mootlywcm:netPl_FromBP");
		return netPl_FromBP;
	}

	public Double getComputeInc_SpeculativeBuss() {
		if (computeInc_SpeculativeBuss == null)
			computeInc_SpeculativeBuss = getProperty("mootlywcm:computeInc_SpeculativeBuss");
		return computeInc_SpeculativeBuss;
	}

	public Double getDedAccordance_28to44DA() {
		if (dedAccordance_28to44DA == null)
			dedAccordance_28to44DA = getProperty("mootlywcm:dedAccordance_28to44DA");
		return dedAccordance_28to44DA;
	}

	public Double getAddAccordance_28to44DA() {
		if (addAccordance_28to44DA == null)
			addAccordance_28to44DA = getProperty("mootlywcm:addAccordance_28to44DA");
		return addAccordance_28to44DA;
	}

	public Double getPl_SpeculativeBuss() {
		if (pl_SpeculativeBuss == null)
			pl_SpeculativeBuss = getProperty("mootlywcm:pl_SpeculativeBuss");
		return pl_SpeculativeBuss;
	}

	public Double getNetPLFrom_SPecifiedInc() {
		if (netPLFrom_SPecifiedInc == null)
			netPLFrom_SPecifiedInc = getProperty("mootlywcm:netPLFrom_SPecifiedInc");
		return netPLFrom_SPecifiedInc;
	}

	public Double getPl_SpecifiedBussNet() {
		if (pl_SpecifiedBussNet == null)
			pl_SpecifiedBussNet = getProperty("mootlywcm:pl_SpecifiedBussNet");
		return pl_SpecifiedBussNet;
	}

	public Double getDedAcc35AD() {
		if (dedAcc35AD == null)
			dedAcc35AD = getProperty("mootlywcm:dedAcc35AD");
		return dedAcc35AD;
	}

	public Double getIncomeChargeable_PL() {
		if (incomeChargeable_PL == null)
			incomeChargeable_PL = getProperty("mootlywcm:incomeChargeable_PL");
		return incomeChargeable_PL;
	}

	public Double getDedAcc28to44DEx35AD() {
		if (dedAcc28to44DEx35AD == null)
			dedAcc28to44DEx35AD = getProperty("mootlywcm:dedAcc28to44DEx35AD");
		return dedAcc28to44DEx35AD;
	}

	public Double getAdditionAcc28to44D() {
		if (additionAcc28to44D == null)
			additionAcc28to44D = getProperty("mootlywcm:additionAcc28to44D");
		return additionAcc28to44D;
	}

	public Double getPl_SpecifiedBuss() {
		if (pl_SpecifiedBuss == null)
			pl_SpecifiedBuss = getProperty("mootlywcm:pl_SpecifiedBuss");
		return pl_SpecifiedBuss;
	}

	public Double getDepreciation_PL() {
		if (depreciation_PL == null)
			depreciation_PL = getProperty("mootlywcm:depreciation_PL");
		return depreciation_PL;
	}

	// set method

	public final void setProfitBeforeTax(Double profitBeforeTax) {
		this.profitBeforeTax = profitBeforeTax;
	}

	public final void setProfitLoss_SpecualtiveBusiness(
			Double profitLoss_SpecualtiveBusiness) {
		this.profitLoss_SpecualtiveBusiness = profitLoss_SpecualtiveBusiness;
	}

	public final void setProfitLoss_SpecifiedBusiness(
			Double profitLoss_SpecifiedBusiness) {
		this.profitLoss_SpecifiedBusiness = profitLoss_SpecifiedBusiness;
	}

	public final void setIncomeCredited_ProfitLossAcc(
			Double incomeCredited_ProfitLossAcc) {
		this.incomeCredited_ProfitLossAcc = incomeCredited_ProfitLossAcc;
	}

	public final void setProfitLoss_IncludeSchPL(Double profitLoss_IncludeSchPL) {
		this.profitLoss_IncludeSchPL = profitLoss_IncludeSchPL;
	}

	public final void setShareIncome_Firms(Double shareIncome_Firms) {
		this.shareIncome_Firms = shareIncome_Firms;
	}

	public final void setShareIncome_Firms_AOP(Double shareIncome_Firms_AOP) {
		this.shareIncome_Firms_AOP = shareIncome_Firms_AOP;
	}

	public final void setExemptIncome_AnyOther(Double exemptIncome_AnyOther) {
		this.exemptIncome_AnyOther = exemptIncome_AnyOther;
	}

	public final void setBalance(Double balance) {
		this.balance = balance;
	}

	public final void setTotal_ExemptIncome(Double total_ExemptIncome) {
		this.total_ExemptIncome = total_ExemptIncome;
	}

	public void setExpenseDebit_HeadsInc(Double expenseDebit_HeadsInc) {
		this.expenseDebit_HeadsInc = expenseDebit_HeadsInc;
	}

	public void setExpenseDebit_ExemptInc(Double expenseDebit_ExemptInc) {
		this.expenseDebit_ExemptInc = expenseDebit_ExemptInc;
	}

	public final void setTotal_Expense(Double total_Expense) {
		this.total_Expense = total_Expense;
	}

	public void setAdjusted_ProfitLoss(Double adjusted_ProfitLoss) {
		this.adjusted_ProfitLoss = adjusted_ProfitLoss;
	}

	public final void setDepreAllow_us32_1_ii(Double depreAllow_us32_1_ii) {
		this.depreAllow_us32_1_ii = depreAllow_us32_1_ii;
	}

	public void setDepreAllow_us32_1_i(Double depreAllow_us32_1_i) {
		this.depreAllow_us32_1_i = depreAllow_us32_1_i;
	}

	public void setDepreciation_total(Double depreciation_total) {
		this.depreciation_total = depreciation_total;
	}

	public void setPlAfter_AdjustDepr(Double plAfter_AdjustDepr) {
		this.plAfter_AdjustDepr = plAfter_AdjustDepr;
	}

	public void setAmountDebit_sec36(Double amountDebit_sec36) {
		this.amountDebit_sec36 = amountDebit_sec36;
	}

	public void setAmountDebit_sec37(Double amountDebit_sec37) {
		this.amountDebit_sec37 = amountDebit_sec37;
	}

	public void setAmountDebit_sec40(Double amountDebit_sec40) {
		this.amountDebit_sec40 = amountDebit_sec40;
	}

	public void setAmountDebit_sec40A(Double amountDebit_sec40A) {
		this.amountDebit_sec40A = amountDebit_sec40A;
	}

	public void setAmountDebit_sec43B(Double amountDebit_sec43B) {
		this.amountDebit_sec43B = amountDebit_sec43B;
	}

	public void setInterestDisallow_sec23(Double interestDisallow_sec23) {
		this.interestDisallow_sec23 = interestDisallow_sec23;
	}

	public void setDeemedIncome_Sec41(Double deemedIncome_Sec41) {
		this.deemedIncome_Sec41 = deemedIncome_Sec41;
	}

	public void setDeemedIncome_Sec33AB(Double deemedIncome_Sec33AB) {
		this.deemedIncome_Sec33AB = deemedIncome_Sec33AB;
	}

	public void setAddItem_sec28to44DA(Double addItem_sec28to44DA) {
		this.addItem_sec28to44DA = addItem_sec28to44DA;
	}

	public void setAnyIncNotInclude_PLAcc(Double anyIncNotInclude_PLAcc) {
		this.anyIncNotInclude_PLAcc = anyIncNotInclude_PLAcc;
	}

	public void setTotalIncome_sec(Double totalIncome_sec) {
		this.totalIncome_sec = totalIncome_sec;
	}

	public void setDeductionAllow_Sec32_1_iii(Double deductionAllow_Sec32_1_iii) {
		this.deductionAllow_Sec32_1_iii = deductionAllow_Sec32_1_iii;
	}

	public void setAmountDed_Sec35(Double amountDed_Sec35) {
		this.amountDed_Sec35 = amountDed_Sec35;
	}

	public void setAmountDisAllow_Sec40(Double amountDisAllow_Sec40) {
		this.amountDisAllow_Sec40 = amountDisAllow_Sec40;
	}

	public void setAmountDisAllow_Sec43B(Double amountDisAllow_Sec43B) {
		this.amountDisAllow_Sec43B = amountDisAllow_Sec43B;
	}

	public void setAmountDebited_ToProfitLoss(Double amountDebited_ToProfitLoss) {
		this.amountDebited_ToProfitLoss = amountDebited_ToProfitLoss;
	}

	public void setAmountAllow_Deduction(Double amountAllow_Deduction) {
		this.amountAllow_Deduction = amountAllow_Deduction;
	}

	public void setExcessAmountAllow_Deduction(
			Double excessAmountAllow_Deduction) {
		this.excessAmountAllow_Deduction = excessAmountAllow_Deduction;
	}

	public void setAnyOtherAmountAllow_Deduction(
			Double anyOtherAmountAllow_Deduction) {
		this.anyOtherAmountAllow_Deduction = anyOtherAmountAllow_Deduction;
	}

	public void setTotal_Deduction(Double total_Deduction) {
		this.total_Deduction = total_Deduction;
	}

	public void setIncome_AfterDed(Double income_AfterDed) {
		this.income_AfterDed = income_AfterDed;
	}

	public void setSection44AD(Double section44AD) {
		this.section44AD = section44AD;
	}

	public void setSection44AE(Double section44AE) {
		this.section44AE = section44AE;
	}

	public void setSection44AF(Double section44AF) {
		this.section44AF = section44AF;
	}

	public void setSection44B(Double section44B) {
		this.section44B = section44B;
	}

	public void setSection44BB(Double section44BB) {
		this.section44BB = section44BB;
	}

	public void setSection44BBA(Double section44BBA) {
		this.section44BBA = section44BBA;
	}

	public void setSection44BBB(Double section44BBB) {
		this.section44BBB = section44BBB;
	}

	public void setSection44D(Double section44D) {
		this.section44D = section44D;
	}

	public void setSection44DA(Double section44DA) {
		this.section44DA = section44DA;
	}

	public void setChapter_XII_G(Double chapter_XII_G) {
		this.chapter_XII_G = chapter_XII_G;
	}

	public void setFirstSchedule_ITAct(Double firstSchedule_ITAct) {
		this.firstSchedule_ITAct = firstSchedule_ITAct;
	}

	public final void setTotal_Sections(Double total_Sections) {
		this.total_Sections = total_Sections;
	}

	public final void setPlBefore_DedUs10A(Double plBefore_DedUs10A) {
		this.plBefore_DedUs10A = plBefore_DedUs10A;
	}

	public final void setDeduction_Sec10A(Double deduction_Sec10A) {
		this.deduction_Sec10A = deduction_Sec10A;
	}

	public final void setDeduction_Sec10AA(Double deduction_Sec10AA) {
		this.deduction_Sec10AA = deduction_Sec10AA;
	}

	public void setDeduction_total10(Double deduction_total10) {
		this.deduction_total10 = deduction_total10;
	}

	public void setNetPL_otherthanSpeculative_SpecifiedBuss(
			Double netPL_otherthanSpeculative_SpecifiedBuss) {
		this.netPL_otherthanSpeculative_SpecifiedBuss = netPL_otherthanSpeculative_SpecifiedBuss;
	}

	public void setNetPL_otherthanSpeculative_SpecifiedBuss1(
			Double netPL_otherthanSpeculative_SpecifiedBuss1) {
		this.netPL_otherthanSpeculative_SpecifiedBuss1 = netPL_otherthanSpeculative_SpecifiedBuss1;
	}

	public void setNetPl_FromBP(Double netPl_FromBP) {
		this.netPl_FromBP = netPl_FromBP;
	}

	public void setComputeInc_SpeculativeBuss(Double computeInc_SpeculativeBuss) {
		this.computeInc_SpeculativeBuss = computeInc_SpeculativeBuss;
	}

	public void setNetPLFrom_SPecifiedInc(Double netPLFrom_SPecifiedInc) {
		this.netPLFrom_SPecifiedInc = netPLFrom_SPecifiedInc;
	}

	public void setAddAccordance_28to44DA(Double addAccordance_28to44DA) {
		this.addAccordance_28to44DA = addAccordance_28to44DA;
	}

	public void setPl_SpeculativeBuss(Double pl_SpeculativeBuss) {
		this.pl_SpeculativeBuss = pl_SpeculativeBuss;
	}

	public void setDedAccordance_28to44DA(Double dedAccordance_28to44DA) {
		this.dedAccordance_28to44DA = dedAccordance_28to44DA;
	}

	public void setPl_SpecifiedBussNet(Double pl_SpecifiedBussNet) {
		this.pl_SpecifiedBussNet = pl_SpecifiedBussNet;
	}

	public final void setDedAcc35AD(Double dedAcc35AD) {
		this.dedAcc35AD = dedAcc35AD;
	}

	public final void setIncomeChargeable_PL(Double incomeChargeable_PL) {
		this.incomeChargeable_PL = incomeChargeable_PL;
	}

	public final void setAdditionAcc28to44D(Double additionAcc28to44D) {
		this.additionAcc28to44D = additionAcc28to44D;
	}

	public final void setDedAcc28to44DEx35AD(Double dedAcc28to44DEx35AD) {
		this.dedAcc28to44DEx35AD = dedAcc28to44DEx35AD;
	}

	public final void setDepreciation_PL(Double depreciation_PL) {
		this.depreciation_PL = depreciation_PL;
	}

	public final void setPl_SpecifiedBuss(Double pl_SpecifiedBuss) {
		this.pl_SpecifiedBuss = pl_SpecifiedBuss;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {

			IncBusinessProfessionDoc objIncBusinessProfessionDoc = (IncBusinessProfessionDoc) content;
			node.setProperty("mootlywcm:profitBeforeTax",
					objIncBusinessProfessionDoc.getProfitBeforeTax());
			node.setProperty("mootlywcm:profitLoss_SpecualtiveBusiness",
					objIncBusinessProfessionDoc
							.getProfitLoss_SpecualtiveBusiness());
			node.setProperty("mootlywcm:profitLoss_SpecifiedBusiness",
					objIncBusinessProfessionDoc
							.getProfitLoss_SpecifiedBusiness());
			node.setProperty("mootlywcm:incomeCredited_ProfitLossAcc",
					objIncBusinessProfessionDoc
							.getIncomeCredited_ProfitLossAcc());
			node.setProperty("mootlywcm:profitLoss_IncludeSchPL",
					objIncBusinessProfessionDoc.getProfitLoss_IncludeSchPL());
			node.setProperty("mootlywcm:shareIncome_Firms",
					objIncBusinessProfessionDoc.getShareIncome_Firms());
			node.setProperty("mootlywcm:shareIncome_Firms_AOP",
					objIncBusinessProfessionDoc.getShareIncome_Firms_AOP());
			node.setProperty("mootlywcm:exemptIncome_AnyOther",
					objIncBusinessProfessionDoc.getExemptIncome_AnyOther());
			node.setProperty("mootlywcm:balance",
					objIncBusinessProfessionDoc.getBalance());
			node.setProperty("mootlywcm:total_ExemptIncome",
					objIncBusinessProfessionDoc.getTotal_ExemptIncome());
			node.setProperty("mootlywcm:expenseDebit_HeadsInc",
					objIncBusinessProfessionDoc.getExpenseDebit_HeadsInc());
			node.setProperty("mootlywcm:expenseDebit_ExemptInc",
					objIncBusinessProfessionDoc.getExpenseDebit_ExemptInc());
			node.setProperty("mootlywcm:total_Expense",
					objIncBusinessProfessionDoc.getTotal_Expense());
			node.setProperty("mootlywcm:adjusted_ProfitLoss",
					objIncBusinessProfessionDoc.getAdjusted_ProfitLoss());
			node.setProperty("mootlywcm:depreAllow_us32_1_ii",
					objIncBusinessProfessionDoc.getDepreAllow_us32_1_ii());
			node.setProperty("mootlywcm:depreAllow_us32_1_i",
					objIncBusinessProfessionDoc.getDepreAllow_us32_1_i());
			node.setProperty("mootlywcm:depreciation_total",
					objIncBusinessProfessionDoc.getDepreciation_total());
			node.setProperty("mootlywcm:plAfter_AdjustDepr",
					objIncBusinessProfessionDoc.getPlAfter_AdjustDepr());
			node.setProperty("mootlywcm:amountDebit_sec36",
					objIncBusinessProfessionDoc.getAmountDebit_sec36());
			node.setProperty("mootlywcm:amountDebit_sec37",
					objIncBusinessProfessionDoc.getAmountDebit_sec37());
			node.setProperty("mootlywcm:amountDebit_sec40",
					objIncBusinessProfessionDoc.getAmountDebit_sec40());
			node.setProperty("mootlywcm:amountDebit_sec40A",
					objIncBusinessProfessionDoc.getAmountDebit_sec40A());
			node.setProperty("mootlywcm:amountDebit_sec43B",
					objIncBusinessProfessionDoc.getAmountDebit_sec43B());
			node.setProperty("mootlywcm:interestDisallow_sec23",
					objIncBusinessProfessionDoc.getInterestDisallow_sec23());
			node.setProperty("mootlywcm:section44D",
					objIncBusinessProfessionDoc.getSection44D());
			node.setProperty("mootlywcm:deemedIncome_Sec41",
					objIncBusinessProfessionDoc.getDeemedIncome_Sec41());
			node.setProperty("mootlywcm:deemedIncome_Sec33AB",
					objIncBusinessProfessionDoc.getDeemedIncome_Sec33AB());
			node.setProperty("mootlywcm:addItem_sec28to44DA",
					objIncBusinessProfessionDoc.getAddItem_sec28to44DA());
			node.setProperty("mootlywcm:anyIncNotInclude_PLAcc",
					objIncBusinessProfessionDoc.getAnyIncNotInclude_PLAcc());
			node.setProperty("mootlywcm:totalIncome_sec",
					objIncBusinessProfessionDoc.getTotalIncome_sec());

			node.setProperty("mootlywcm:deductionAllow_Sec32_1_iii",
					objIncBusinessProfessionDoc.getDeductionAllow_Sec32_1_iii());
			node.setProperty("mootlywcm:amountDed_Sec35",
					objIncBusinessProfessionDoc.getAmountDed_Sec35());
			node.setProperty("mootlywcm:amountDisAllow_Sec40",
					objIncBusinessProfessionDoc.getAmountDisAllow_Sec40());
			node.setProperty("mootlywcm:amountDisAllow_Sec43B",
					objIncBusinessProfessionDoc.getAmountDisAllow_Sec43B());
			node.setProperty("mootlywcm:amountDebited_ToProfitLoss",
					objIncBusinessProfessionDoc.getAmountDebited_ToProfitLoss());
			node.setProperty("mootlywcm:amountAllow_Deduction",
					objIncBusinessProfessionDoc.getAmountAllow_Deduction());
			node.setProperty("mootlywcm:excessAmountAllow_Deduction",
					objIncBusinessProfessionDoc
							.getExcessAmountAllow_Deduction());
			node.setProperty("mootlywcm:anyOtherAmountAllow_Deduction",
					objIncBusinessProfessionDoc
							.getAnyOtherAmountAllow_Deduction());
			node.setProperty("mootlywcm:total_Deduction",
					objIncBusinessProfessionDoc.getTotal_Deduction());
			node.setProperty("mootlywcm:income_AfterDed",
					objIncBusinessProfessionDoc.getIncome_AfterDed());
			node.setProperty("mootlywcm:section44AD",
					objIncBusinessProfessionDoc.getSection44AD());
			node.setProperty("mootlywcm:section44AE",
					objIncBusinessProfessionDoc.getSection44AE());
			node.setProperty("mootlywcm:section44AF",
					objIncBusinessProfessionDoc.getSection44AF());
			node.setProperty("mootlywcm:section44B",
					objIncBusinessProfessionDoc.getSection44B());
			node.setProperty("mootlywcm:section44BB",
					objIncBusinessProfessionDoc.getSection44BB());
			node.setProperty("mootlywcm:section44BBA",
					objIncBusinessProfessionDoc.getSection44BBA());
			node.setProperty("mootlywcm:section44BBB",
					objIncBusinessProfessionDoc.getSection44BBB());
			node.setProperty("mootlywcm:section44DA",
					objIncBusinessProfessionDoc.getSection44DA());
			node.setProperty("mootlywcm:chapter_XII_G",
					objIncBusinessProfessionDoc.getChapter_XII_G());
			node.setProperty("mootlywcm:firstSchedule_ITAct",
					objIncBusinessProfessionDoc.getFirstSchedule_ITAct());
			node.setProperty("mootlywcm:total_Sections",
					objIncBusinessProfessionDoc.getTotal_Sections());
			node.setProperty("mootlywcm:plBefore_DedUs10A",
					objIncBusinessProfessionDoc.getPlBefore_DedUs10A());
			node.setProperty("mootlywcm:deduction_Sec10A",
					objIncBusinessProfessionDoc.getDeduction_Sec10A());
			node.setProperty("mootlywcm:deduction_Sec10AA",
					objIncBusinessProfessionDoc.getDeduction_Sec10AA());
			node.setProperty("mootlywcm:deduction_total10",
					objIncBusinessProfessionDoc.getDeduction_total10());

			node.setProperty(
					"mootlywcm:netPL_otherthanSpeculative_SpecifiedBuss",
					objIncBusinessProfessionDoc
							.getNetPL_otherthanSpeculative_SpecifiedBuss());
			node.setProperty(
					"mootlywcm:netPL_otherthanSpeculative_SpecifiedBuss1",
					objIncBusinessProfessionDoc
							.getNetPL_otherthanSpeculative_SpecifiedBuss1());
			node.setProperty("mootlywcm:netPl_FromBP",
					objIncBusinessProfessionDoc.getNetPl_FromBP());
			node.setProperty("mootlywcm:computeInc_SpeculativeBuss",
					objIncBusinessProfessionDoc.getComputeInc_SpeculativeBuss());
			node.setProperty("mootlywcm:netPLFrom_SPecifiedInc",
					objIncBusinessProfessionDoc.getNetPLFrom_SPecifiedInc());
			node.setProperty("mootlywcm:addAccordance_28to44DA",
					objIncBusinessProfessionDoc.getAddAccordance_28to44DA());
			node.setProperty("mootlywcm:pl_SpeculativeBuss",
					objIncBusinessProfessionDoc.getPl_SpeculativeBuss());
			node.setProperty("mootlywcm:dedAccordance_28to44DA",
					objIncBusinessProfessionDoc.getDedAccordance_28to44DA());
			node.setProperty("mootlywcm:pl_SpecifiedBussNet",
					objIncBusinessProfessionDoc.getPl_SpecifiedBussNet());
			node.setProperty("mootlywcm:dedAcc35AD",
					objIncBusinessProfessionDoc.getDedAcc35AD());
			node.setProperty("mootlywcm:incomeChargeable_PL",
					objIncBusinessProfessionDoc.getIncomeChargeable_PL());
			node.setProperty("mootlywcm:additionAcc28to44D",
					objIncBusinessProfessionDoc.getAdditionAcc28to44D());
			node.setProperty("mootlywcm:dedAcc28to44DEx35AD",
					objIncBusinessProfessionDoc.getDedAcc28to44DEx35AD());
			node.setProperty("mootlywcm:depreciation_PL",
					objIncBusinessProfessionDoc.getDepreciation_PL());
			node.setProperty("mootlywcm:pl_SpecifiedBuss",
					objIncBusinessProfessionDoc.getPl_SpecifiedBuss());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding", rex);
		}
		return true;
	}
}
