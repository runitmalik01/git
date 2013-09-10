
/**
 * 
 * User: pankaj
 * Date: 
 * Time: 
 * 
 */


package com.mootly.wcm.beans;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.member.ITRScheduleSI;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRScheduleSISections;
import com.mootly.wcm.services.ITRAdditionalScheduleService;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:incbusinessprofessiondoc")
public class IncBusinessProfessionDoc extends IncBusinessProfessionVar{
	static final public String NAMESPACE = "mootlywcm:incbusinessprofessiondoc";
	static final public String NODE_NAME = "incbusinessprofessiondoc";
	
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		
		
		double val_profitBeforeTax=0.0d;
		if (formMap.getField("profitBeforeTax").getValue().isEmpty()){
			setProfitBeforeTax(val_profitBeforeTax);
		}
		else{
			String strProfitBeforeTax=formMap.getField("profitBeforeTax").getValue();
			val_profitBeforeTax= Double.parseDouble(strProfitBeforeTax);
			setProfitBeforeTax(val_profitBeforeTax);
		}
		double val_profitLoss_SpecualtiveBusiness=0.0d;
		if (formMap.getField("profitLoss_SpecualtiveBusiness").getValue().isEmpty()) {
			setProfitLoss_SpecualtiveBusiness(val_profitLoss_SpecualtiveBusiness);
		}
		else{
			String strprofitLoss_SpecualtiveBusiness=formMap.getField("profitLoss_SpecualtiveBusiness").getValue();
			val_profitLoss_SpecualtiveBusiness= Double.parseDouble(strprofitLoss_SpecualtiveBusiness);
			setProfitLoss_SpecualtiveBusiness(val_profitLoss_SpecualtiveBusiness);
		}
		double val_profitLoss_SpecifiedBusiness=0.0d;
		if (formMap.getField("profitLoss_SpecifiedBusiness").getValue().isEmpty()) {
			setProfitLoss_SpecifiedBusiness(val_profitLoss_SpecifiedBusiness);
		}
		else{
			String strprofitLoss_SpecifiedBusiness=formMap.getField("profitLoss_SpecifiedBusiness").getValue();
			val_profitLoss_SpecifiedBusiness= Double.parseDouble(strprofitLoss_SpecifiedBusiness);
			setProfitLoss_SpecifiedBusiness(val_profitLoss_SpecifiedBusiness);
		}
		double val_incomeCredited_ProfitLossAcc=0.0d;
		if (formMap.getField("incomeCredited_ProfitLossAcc").getValue().isEmpty()){
			setIncomeCredited_ProfitLossAcc(val_incomeCredited_ProfitLossAcc);
		}
		else{
			String strincomeCredited_ProfitLossAcc=formMap.getField("incomeCredited_ProfitLossAcc").getValue();
			val_incomeCredited_ProfitLossAcc= Double.parseDouble(strincomeCredited_ProfitLossAcc);

			setIncomeCredited_ProfitLossAcc(val_incomeCredited_ProfitLossAcc);
		}
         double val_profitLoss_IncludeSchPL=0.0d;
		if (formMap.getField("profitLoss_IncludeSchPL").getValue().isEmpty()){
			setProfitLoss_IncludeSchPL(val_profitLoss_IncludeSchPL);
		}
		else{
			String strprofitLoss_IncludeSchPL=formMap.getField("profitLoss_IncludeSchPL").getValue();
			val_profitLoss_IncludeSchPL= Double.parseDouble(strprofitLoss_IncludeSchPL);

			setProfitLoss_IncludeSchPL(val_profitLoss_IncludeSchPL);
		}
          double val_shareIncome_Firms=0.0d;
		if (formMap.getField("shareIncome_Firms").getValue().isEmpty()) {
			setShareIncome_Firms(val_shareIncome_Firms);
		}
		else{
			String strshareIncome_Firms=formMap.getField("shareIncome_Firms").getValue();
			val_shareIncome_Firms= Double.parseDouble(strshareIncome_Firms);
			setShareIncome_Firms(val_shareIncome_Firms);
		}
		double val_shareIncome_Firms_AOP=0.0d;
		if (formMap.getField("shareIncome_Firms_AOP").getValue().isEmpty()){
			setShareIncome_Firms_AOP(val_shareIncome_Firms_AOP);
		}
		else{
			String strshareIncome_Firms_AOP=formMap.getField("shareIncome_Firms_AOP").getValue();
			val_shareIncome_Firms_AOP= Double.parseDouble(strshareIncome_Firms_AOP);
			setShareIncome_Firms_AOP(val_shareIncome_Firms_AOP);
		}
		double val_exemptIncome_AnyOther=0.0d;
		if (formMap.getField("exemptIncome_AnyOther").getValue().isEmpty()) {
			setExemptIncome_AnyOther(val_exemptIncome_AnyOther);
		}
		else{    
			String strexemptIncome_AnyOther=formMap.getField("exemptIncome_AnyOther").getValue();
			val_exemptIncome_AnyOther= Double.parseDouble(strexemptIncome_AnyOther);
			setExemptIncome_AnyOther(val_exemptIncome_AnyOther);
		} 
		double val_balance=0.0d; 
		if (formMap.getField("balance").getValue().isEmpty()){
			setBalance(val_balance);
		}
		else{
			String strbalance=formMap.getField("balance").getValue();
			val_balance= Double.parseDouble(strbalance);
			setBalance(val_balance);
		}
		double val_total_ExemptIncome=0.0d; 
		if (formMap.getField("total_ExemptIncome").getValue().isEmpty()){
			setTotal_ExemptIncome(val_balance);
		}
		else{
			String strtotal_ExemptIncome=formMap.getField("total_ExemptIncome").getValue();
			val_total_ExemptIncome= Double.parseDouble(strtotal_ExemptIncome);
			setTotal_ExemptIncome(val_total_ExemptIncome);
		}
		double val_expenseDebit_HeadsInc=0.0d;
		if (formMap.getField("expenseDebit_HeadsInc").getValue().isEmpty()) {
			setExpenseDebit_HeadsInc(val_expenseDebit_HeadsInc);
		}
		else{
			String strexpenseDebit_HeadsInc=formMap.getField("expenseDebit_HeadsInc").getValue();
			val_expenseDebit_HeadsInc= Double.parseDouble(strexpenseDebit_HeadsInc);
			setExpenseDebit_HeadsInc(val_expenseDebit_HeadsInc);
		}
		double val_expenseDebit_ExemptInc=0.0d;
		if (formMap.getField("expenseDebit_ExemptInc").getValue().isEmpty()){
			setExpenseDebit_ExemptInc(val_expenseDebit_ExemptInc);
		}
		else{
			String strexpenseDebit_ExemptInc=formMap.getField("expenseDebit_ExemptInc").getValue();
			val_expenseDebit_ExemptInc= Double.parseDouble(strexpenseDebit_ExemptInc);
			setExpenseDebit_ExemptInc(val_expenseDebit_ExemptInc);
		}
		double val_total_Expense=0.0d;
		if (formMap.getField("total_Expense").getValue().isEmpty()){
			setTotal_Expense(val_total_Expense);
		}
		else{
			String strtotal_Expense=formMap.getField("total_Expense").getValue();
			val_total_Expense= Double.parseDouble(strtotal_Expense);
			 setTotal_Expense(val_total_Expense);
		}
		double val_adjusted_ProfitLoss=0.0d;
		if (formMap.getField("adjusted_ProfitLoss").getValue().isEmpty()){
			setAdjusted_ProfitLoss(val_adjusted_ProfitLoss);
		}
		else{
			String stradjusted_ProfitLoss=formMap.getField("adjusted_ProfitLoss").getValue();
			val_adjusted_ProfitLoss= Double.parseDouble(stradjusted_ProfitLoss);
			setAdjusted_ProfitLoss(val_adjusted_ProfitLoss);
		}
		double val_depreAllow_us32_1_ii=0.0d;
		if (formMap.getField("depreAllow_us32_1_ii").getValue().isEmpty()) {
			setDepreAllow_us32_1_ii(val_depreAllow_us32_1_ii);
		}
		else{
			String strdepreAllow_us32_1_ii=formMap.getField("depreAllow_us32_1_ii").getValue();
			val_depreAllow_us32_1_ii= Double.parseDouble(strdepreAllow_us32_1_ii);
			setDepreAllow_us32_1_ii(val_depreAllow_us32_1_ii);
		}
		double val_depreAllow_us32_1_i=0.0d;
		if (formMap.getField("depreAllow_us32_1_i").getValue().isEmpty()) {
			setDepreAllow_us32_1_i(val_depreAllow_us32_1_i);
		}
		else{
			String strdepreAllow_us32_1_i=formMap.getField("depreAllow_us32_1_i").getValue();
			val_depreAllow_us32_1_i= Double.parseDouble(strdepreAllow_us32_1_i);
			setDepreAllow_us32_1_i(val_depreAllow_us32_1_i);
		}
		double val_depreciation_total=0.0d;
		if (formMap.getField("depreciation_total").getValue().isEmpty()){
			setDepreciation_total(val_depreciation_total);
		}
		else{
			String strdepreciation_total=formMap.getField("depreciation_total").getValue();
			val_depreciation_total= Double.parseDouble(strdepreciation_total);
			setDepreciation_total(val_depreciation_total);
		}
		double val_plAfter_AdjustDepr=0.0d;
		if (formMap.getField("plAfter_AdjustDepr").getValue().isEmpty()){
			setPlAfter_AdjustDepr(val_plAfter_AdjustDepr);
		}
		else{
			String strplAfter_AdjustDepr=formMap.getField("plAfter_AdjustDepr").getValue();
			val_plAfter_AdjustDepr= Double.parseDouble(strplAfter_AdjustDepr);
			setPlAfter_AdjustDepr(val_plAfter_AdjustDepr);
		}
		double val_amountDebit_sec36=0.0d;
		if (formMap.getField("amountDebit_sec36").getValue().isEmpty()) {
			setAmountDebit_sec36(val_amountDebit_sec36);
		}
		else{
			String stramountDebit_sec36=formMap.getField("amountDebit_sec36").getValue();
			val_amountDebit_sec36= Double.parseDouble(stramountDebit_sec36);
			setAmountDebit_sec36(val_amountDebit_sec36);
		}
		double val_amountDebit_sec37=0.0d;
		if (formMap.getField("amountDebit_sec37").getValue().isEmpty()) {
			setAmountDebit_sec37(val_amountDebit_sec37);	
		}
		else{
			String stramountDebit_sec37=formMap.getField("amountDebit_sec37").getValue();
			val_amountDebit_sec37= Double.parseDouble(stramountDebit_sec37);
			setAmountDebit_sec37(val_amountDebit_sec37);
		}
		double val_amountDebit_sec40=0.0d;
		if (formMap.getField("amountDebit_sec40").getValue().isEmpty()) {
			setAmountDebit_sec40(val_amountDebit_sec40);
		}
		else{
			String stramountDebit_sec40=formMap.getField("amountDebit_sec40").getValue();
			val_amountDebit_sec40= Double.parseDouble(stramountDebit_sec40);
			setAmountDebit_sec40(val_amountDebit_sec40);
		}
		double val_amountDebit_sec40A=0.0d;
		if (formMap.getField("amountDebit_sec40A").getValue().isEmpty()) {
			setAmountDebit_sec40A(val_amountDebit_sec40A);
		}
		else{  
			String stramountDebit_sec40A=formMap.getField("amountDebit_sec40A").getValue();
			val_amountDebit_sec40A= Double.parseDouble(stramountDebit_sec40A);
			setAmountDebit_sec40A(val_amountDebit_sec40A);
		}
		double val_amountDebit_sec43B=0.0d;
		if (formMap.getField("amountDebit_sec43B").getValue().isEmpty()) {
			setAmountDebit_sec43B(val_amountDebit_sec43B);
		}
		else{
			String amountDebit_sec43Bstr=formMap.getField("amountDebit_sec43B").getValue();
			val_amountDebit_sec43B= Double.parseDouble(amountDebit_sec43Bstr);
			setAmountDebit_sec43B(val_amountDebit_sec43B);
		}
		
		double val_interestDisallow_sec23=0.0d;
		if (formMap.getField("interestDisallow_sec23").getValue().isEmpty()){
			setInterestDisallow_sec23(val_interestDisallow_sec23);
		}
		else{
			String strinterestDisallow_sec23=formMap.getField("interestDisallow_sec23").getValue();
			val_interestDisallow_sec23= Double.parseDouble(strinterestDisallow_sec23);
			setInterestDisallow_sec23(val_interestDisallow_sec23);
		}
		double val_deemedIncome_Sec41=0.0d;
		if (formMap.getField("deemedIncome_Sec41").getValue().isEmpty()){
			setDeemedIncome_Sec41(val_deemedIncome_Sec41);
		}
		else{
			String strdeemedIncome_Sec41=formMap.getField("deemedIncome_Sec41").getValue();
			val_deemedIncome_Sec41= Double.parseDouble(strdeemedIncome_Sec41);
			setDeemedIncome_Sec41(val_deemedIncome_Sec41);
		} 
		double val_deemedIncome_Sec33AB=0.0d; 
		if (formMap.getField("deemedIncome_Sec33AB").getValue().isEmpty()){
			setDeemedIncome_Sec33AB(val_deemedIncome_Sec33AB);
		}
		else{
			String strdeemedIncome_Sec33AB=formMap.getField("deemedIncome_Sec33AB").getValue();
			val_deemedIncome_Sec33AB= Double.parseDouble(strdeemedIncome_Sec33AB);
			 setDeemedIncome_Sec33AB(val_deemedIncome_Sec33AB);
		}
		double val_addItem_sec28to44DA=0.0d;
		if (formMap.getField("addItem_sec28to44DA").getValue().isEmpty()){
			setAddItem_sec28to44DA(val_addItem_sec28to44DA);
		}
		else{
			String straddItem_sec28to44DA=formMap.getField("addItem_sec28to44DA").getValue();
			val_addItem_sec28to44DA= Double.parseDouble(straddItem_sec28to44DA);
			setAddItem_sec28to44DA(val_addItem_sec28to44DA);
		}
		double val_anyIncNotInclude_PLAcc=0.0d;
		if (formMap.getField("anyIncNotInclude_PLAcc").getValue().isEmpty()){  
			setAnyIncNotInclude_PLAcc(val_anyIncNotInclude_PLAcc);
		}
		else{
			String stranyIncNotInclude_PLAcc=formMap.getField("anyIncNotInclude_PLAcc").getValue();
			val_anyIncNotInclude_PLAcc= Double.parseDouble(stranyIncNotInclude_PLAcc);
			setAnyIncNotInclude_PLAcc(val_anyIncNotInclude_PLAcc);
		}
		double val_totalIncome_sec=0.0d;
		if (formMap.getField("totalIncome_sec").getValue().isEmpty()){
			setTotalIncome_sec(val_totalIncome_sec);
		}
		else{
			String strtotalIncome_sec=formMap.getField("totalIncome_sec").getValue();
			val_totalIncome_sec= Double.parseDouble(strtotalIncome_sec);
			setTotalIncome_sec(val_totalIncome_sec);
		}
		double val_deductionAllow_Sec32_1_iii=0.0d;
		if (formMap.getField("deductionAllow_Sec32_1_iii").getValue().isEmpty()){
			setDeductionAllow_Sec32_1_iii(val_deductionAllow_Sec32_1_iii);
		}
		else{
			String strdeductionAllow_Sec32_1_iii=formMap.getField("deductionAllow_Sec32_1_iii").getValue();
			val_deductionAllow_Sec32_1_iii= Double.parseDouble(strdeductionAllow_Sec32_1_iii);
			setDeductionAllow_Sec32_1_iii(val_deductionAllow_Sec32_1_iii);
		}
		double val_amountDed_Sec35=0.0d;
		if (formMap.getField("amountDed_Sec35").getValue().isEmpty()){
			setAmountDed_Sec35(val_amountDed_Sec35);
		}
		else{
			String stramountDed_Sec35=formMap.getField("amountDed_Sec35").getValue();
			val_amountDed_Sec35= Double.parseDouble(stramountDed_Sec35);
			setAmountDed_Sec35(val_amountDed_Sec35);
		}
		double val_amountDisAllow_Sec40=0.0d;
		if (formMap.getField("amountDisAllow_Sec40").getValue().isEmpty()){
			setAmountDisAllow_Sec40(val_amountDisAllow_Sec40);
		}
		else{
			String stramountDisAllow_Sec40=formMap.getField("amountDisAllow_Sec40").getValue();
			val_amountDisAllow_Sec40= Double.parseDouble(stramountDisAllow_Sec40);
			setAmountDisAllow_Sec40(val_amountDisAllow_Sec40);
		}
		double val_amountDisAllow_Sec43B=0.0d;
		if (formMap.getField("amountDisAllow_Sec43B").getValue().isEmpty()){
			setAmountDisAllow_Sec43B(val_amountDisAllow_Sec43B);
		}
		else{
			String stramountDisAllow_Sec43B=formMap.getField("amountDisAllow_Sec43B").getValue();
			val_amountDisAllow_Sec43B= Double.parseDouble(stramountDisAllow_Sec43B);
			setAmountDisAllow_Sec43B(val_amountDisAllow_Sec43B);
		}
		double val_amountDebited_ToProfitLoss=0.0d;
		if (formMap.getField("amountDebited_ToProfitLoss").getValue().isEmpty()){
			setAmountDebited_ToProfitLoss(val_amountDebited_ToProfitLoss);
		}
		else{
			String stramountDebited_ToProfitLoss=formMap.getField("amountDebited_ToProfitLoss").getValue();
			val_amountDebited_ToProfitLoss= Double.parseDouble(stramountDebited_ToProfitLoss);
			setAmountDebited_ToProfitLoss(val_amountDebited_ToProfitLoss);
		}
		double val_amountAllow_Deduction=0.0d;
		if (formMap.getField("amountAllow_Deduction").getValue().isEmpty()){
			setAmountAllow_Deduction(val_amountAllow_Deduction);
		}
		else{
			String stramountAllow_Deduction=formMap.getField("amountAllow_Deduction").getValue();
			val_amountAllow_Deduction= Double.parseDouble(stramountAllow_Deduction);
			setAmountAllow_Deduction(val_amountAllow_Deduction);
		}
		double val_excessAmountAllow_Deduction=0.0d;
		if (formMap.getField("excessAmountAllow_Deduction").getValue().isEmpty()){
			setExcessAmountAllow_Deduction(val_excessAmountAllow_Deduction);
		}
		else{
			String strexcessAmountAllow_Deduction=formMap.getField("excessAmountAllow_Deduction").getValue();
			val_excessAmountAllow_Deduction= Double.parseDouble(strexcessAmountAllow_Deduction);
			setExcessAmountAllow_Deduction(val_excessAmountAllow_Deduction);
		}
		double val_anyOtherAmountAllow_Deduction=0.0d;
		if (formMap.getField("anyOtherAmountAllow_Deduction").getValue().isEmpty()){
			setAnyOtherAmountAllow_Deduction(val_anyOtherAmountAllow_Deduction);
		}
		else{
			String stranyOtherAmountAllow_Deduction=formMap.getField("anyOtherAmountAllow_Deduction").getValue();
			val_anyOtherAmountAllow_Deduction= Double.parseDouble(stranyOtherAmountAllow_Deduction);
			setAnyOtherAmountAllow_Deduction(val_anyOtherAmountAllow_Deduction);
		}
		double val_total_Deduction=0.0d;
		if (formMap.getField("total_Deduction").getValue().isEmpty()){
			setTotal_Deduction(val_total_Deduction);
		}
		else{
			String strtotal_Deduction=formMap.getField("total_Deduction").getValue();
			val_total_Deduction= Double.parseDouble(strtotal_Deduction);
			setTotal_Deduction(val_total_Deduction);
		}
		double val_income_AfterDed=0.0d;
		if (formMap.getField("income_AfterDed").getValue().isEmpty()){
			setIncome_AfterDed(val_income_AfterDed);
		}
		else{
			String strincome_AfterDed=formMap.getField("income_AfterDed").getValue();
			val_income_AfterDed= Double.parseDouble(strincome_AfterDed);
			setIncome_AfterDed(val_income_AfterDed);
		}
		
		double val_section44AD=0.0d;
		if (formMap.getField("section44AD").getValue().isEmpty()){
			setSection44AD(val_section44AD);
		}
		else{
			String strsection44AD=formMap.getField("section44AD").getValue();
			val_section44AD= Double.parseDouble(strsection44AD);
			setSection44AD(val_section44AD);
		}
		double val_section44AE=0.0d;
		if (formMap.getField("section44AE").getValue().isEmpty()){
			setSection44AE(val_section44AE);
		}
		else{
			String strsection44AE=formMap.getField("section44AE").getValue();
			val_section44AE= Double.parseDouble(strsection44AE);
			setSection44AE(val_section44AE);
		}
		double val_section44AF=0.0d;
		if (formMap.getField("section44AF").getValue().isEmpty()){
			setSection44AF(val_section44AF);
		}
		else{
			String strsection44AF=formMap.getField("section44AF").getValue();
			val_section44AF= Double.parseDouble(strsection44AF);
			setSection44AF(val_section44AF);
		}
		double val_section44B=0.0d;
		if (formMap.getField("section44B").getValue().isEmpty()){
			setSection44B(val_section44B);
		}
		else{
			String strsection44B=formMap.getField("section44B").getValue();
			val_section44B= Double.parseDouble(strsection44B);
			setSection44B(val_section44B);
		}
		double val_section44BB=0.0d;
		if (formMap.getField("section44BB").getValue().isEmpty()){
			setSection44BB(val_section44BB);
		}
		else{
			String strsection44BB=formMap.getField("section44BB").getValue();
			val_section44BB= Double.parseDouble(strsection44BB);
			setSection44BB(val_section44BB);
		}
		double val_section44BBA=0.0d;
		if (formMap.getField("section44BBA").getValue().isEmpty()){
			setSection44BBA(val_section44BBA);
		}
		else{
			String strsection44BBA=formMap.getField("section44BBA").getValue();
			val_section44BBA= Double.parseDouble(strsection44BBA);
			setSection44BBA(val_section44BBA);
		}
		double val_section44BBB=0.0d;
		if (formMap.getField("section44BBB").getValue().isEmpty()){
			setSection44BBB(val_section44BBB);
		}
		else{
			String strsection44BBB=formMap.getField("section44BBB").getValue();
			val_section44BBB= Double.parseDouble(strsection44BBB);
			setSection44BBB(val_section44BBB);
		}
		double val_section44D=0.0d;
		if (formMap.getField("section44D").getValue().isEmpty()){
			setSection44D(val_section44D);
		}
		else{
			String strsection44D=formMap.getField("section44D").getValue();
			val_section44D= Double.parseDouble(strsection44D);
			setSection44D(val_section44D);
		}
		double val_section44DA=0.0d;
		if (formMap.getField("section44DA").getValue().isEmpty()){
			setSection44DA(val_section44DA);
		}
		else{
			String strsection44DA=formMap.getField("section44DA").getValue();
			val_section44DA= Double.parseDouble(strsection44DA);
			setSection44DA(val_section44DA);
		}
		double val_chapter_XII_G=0.0d;
		if (formMap.getField("chapter_XII_G").getValue().isEmpty()){
			setChapter_XII_G(val_chapter_XII_G);
		}
		else{
			String strchapter_XII_G=formMap.getField("chapter_XII_G").getValue();
			val_chapter_XII_G= Double.parseDouble(strchapter_XII_G);
			setChapter_XII_G(val_chapter_XII_G);
		}
		double val_firstSchedule_ITAct=0.0d;
		if (formMap.getField("firstSchedule_ITAct").getValue().isEmpty()) {
			setFirstSchedule_ITAct(val_firstSchedule_ITAct);
		}
		else{
			String strfirstSchedule_ITAct=formMap.getField("firstSchedule_ITAct").getValue();
			val_firstSchedule_ITAct= Double.parseDouble(strfirstSchedule_ITAct);
			setFirstSchedule_ITAct(val_firstSchedule_ITAct);
		}
		double val_total_Sections=0.0d;
		if (formMap.getField("total_Sections").getValue().isEmpty()) {
			setTotal_Sections(val_total_Sections);
		}
		else{
			String strtotal_Sections=formMap.getField("total_Sections").getValue();
			val_total_Sections= Double.parseDouble(strtotal_Sections);
			setTotal_Sections(val_total_Sections);
		}
		double val_plBefore_DedUs10A=0.0d;
		if (formMap.getField("plBefore_DedUs10A").getValue().isEmpty()){
			setPlBefore_DedUs10A(val_plBefore_DedUs10A);
		}
		else{
			String strplBefore_DedUs10A=formMap.getField("plBefore_DedUs10A").getValue();
			val_plBefore_DedUs10A= Double.parseDouble(strplBefore_DedUs10A);
			setPlBefore_DedUs10A(val_plBefore_DedUs10A);
		}
         double val_deduction_Sec10A=0.0d;
		if (formMap.getField("deduction_Sec10A").getValue().isEmpty()){
			setDeduction_Sec10A(val_deduction_Sec10A);
		}
		else{
			String strdeduction_Sec10A=formMap.getField("deduction_Sec10A").getValue();
			val_deduction_Sec10A= Double.parseDouble(strdeduction_Sec10A);
			setDeduction_Sec10A(val_deduction_Sec10A);
		}
          double val_deduction_Sec10AA=0.0d;
		if (formMap.getField("deduction_Sec10AA").getValue().isEmpty()) {
			setDeduction_Sec10AA(val_deduction_Sec10AA);
		}
		else{
			String strdeduction_Sec10AA=formMap.getField("deduction_Sec10AA").getValue();
			val_deduction_Sec10AA= Double.parseDouble(strdeduction_Sec10AA);
			setDeduction_Sec10AA(val_deduction_Sec10AA);
		}
		double val_deduction_total10=0.0d;
		if (formMap.getField("deduction_total10").getValue().isEmpty()){
			setDeduction_total10(val_deduction_total10);
		}
		else{
			String strdeduction_total10=formMap.getField("deduction_total10").getValue();
			val_deduction_total10= Double.parseDouble(strdeduction_total10);
			setDeduction_total10(val_deduction_total10);
		}
		
		
		double val_netPL_otherthanSpeculative_SpecifiedBuss=0.0d;
		if (formMap.getField("netPL_otherthanSpeculative_SpecifiedBuss").getValue().isEmpty()){
			setNetPL_otherthanSpeculative_SpecifiedBuss(val_netPL_otherthanSpeculative_SpecifiedBuss);
		}
		else{
			String strnetPL_otherthanSpeculative_SpecifiedBuss=formMap.getField("netPL_otherthanSpeculative_SpecifiedBuss").getValue();
			val_netPL_otherthanSpeculative_SpecifiedBuss= Double.parseDouble(strnetPL_otherthanSpeculative_SpecifiedBuss);
			setNetPL_otherthanSpeculative_SpecifiedBuss(val_netPL_otherthanSpeculative_SpecifiedBuss);
		}
		double val_netPl_FromBP=0.0d;
		if (formMap.getField("netPl_FromBP").getValue().isEmpty()){
			setNetPl_FromBP(val_netPl_FromBP);
		}
		else{
			String strnetPl_FromBP=formMap.getField("netPl_FromBP").getValue();
			val_netPl_FromBP= Double.parseDouble(strnetPl_FromBP);
			setNetPl_FromBP(val_netPl_FromBP);
		}
		double val_computeInc_SpeculativeBuss=0.0d;
		if (formMap.getField("computeInc_SpeculativeBuss").getValue().isEmpty()){
			setComputeInc_SpeculativeBuss(val_computeInc_SpeculativeBuss);
		}
		else{
			String strcomputeInc_SpeculativeBuss=formMap.getField("computeInc_SpeculativeBuss").getValue();
			val_computeInc_SpeculativeBuss= Double.parseDouble(strcomputeInc_SpeculativeBuss);
			setComputeInc_SpeculativeBuss(val_computeInc_SpeculativeBuss);
		}
		double val_netPLFrom_SPecifiedInc=0.0d;
		if (formMap.getField("netPLFrom_SPecifiedInc").getValue().isEmpty()){
			setNetPLFrom_SPecifiedInc(val_netPLFrom_SPecifiedInc);
		}
		else{
			String strnetPLFrom_SPecifiedInc=formMap.getField("netPLFrom_SPecifiedInc").getValue();
			val_netPLFrom_SPecifiedInc= Double.parseDouble(strnetPLFrom_SPecifiedInc);
			setNetPLFrom_SPecifiedInc(val_netPLFrom_SPecifiedInc);
		}
		double val_addAccordance_28to44DA=0.0d;
		if (formMap.getField("addAccordance_28to44DA").getValue().isEmpty()){
			setAddAccordance_28to44DA(val_addAccordance_28to44DA);
		}
		else{
			String straddAccordance_28to44DA=formMap.getField("addAccordance_28to44DA").getValue();
			val_addAccordance_28to44DA= Double.parseDouble(straddAccordance_28to44DA);
			setAddAccordance_28to44DA(val_addAccordance_28to44DA);
		}
		double val_pl_SpeculativeBuss=0.0d;
		if (formMap.getField("pl_SpeculativeBuss").getValue().isEmpty()){
			setPl_SpeculativeBuss(val_pl_SpeculativeBuss);
		}
		else{
			String strpl_SpeculativeBuss=formMap.getField("pl_SpeculativeBuss").getValue();
			val_pl_SpeculativeBuss= Double.parseDouble(strpl_SpeculativeBuss);
			setPl_SpeculativeBuss(val_pl_SpeculativeBuss);
		}
		double val_dedAccordance_28to44DA=0.0d;
		if (formMap.getField("dedAccordance_28to44DA").getValue().isEmpty()){
			setDedAccordance_28to44DA(val_dedAccordance_28to44DA);
		}
		else{
			String strdedAccordance_28to44DA=formMap.getField("dedAccordance_28to44DA").getValue();
			val_dedAccordance_28to44DA= Double.parseDouble(strdedAccordance_28to44DA);
			setDedAccordance_28to44DA(val_dedAccordance_28to44DA);
		}
		double val_pl_SpecifiedBussNet=0.0d;
		if (formMap.getField("pl_SpecifiedBussNet").getValue().isEmpty()) {
			setPl_SpecifiedBussNet(val_pl_SpecifiedBussNet);
		}
		else{
			String strpl_SpecifiedBussNet=formMap.getField("pl_SpecifiedBussNet").getValue();
			val_pl_SpecifiedBussNet= Double.parseDouble(strpl_SpecifiedBussNet);
			setPl_SpecifiedBussNet(val_pl_SpecifiedBussNet);
		}
		double val_dedAcc35AD=0.0d;
		if (formMap.getField("dedAcc35AD").getValue().isEmpty()) {
			setDedAcc35AD(val_dedAcc35AD);
		}
		else{
			String strdedAcc35AD=formMap.getField("dedAcc35AD").getValue();
			val_dedAcc35AD= Double.parseDouble(strdedAcc35AD);
			setDedAcc35AD(val_dedAcc35AD);
		}
		double val_additionAcc28to44D=0.0d;
		if (formMap.getField("additionAcc28to44D").getValue().isEmpty()) {
			setAdditionAcc28to44D(val_additionAcc28to44D);
		}
		else{
			String stradditionAcc28to44D=formMap.getField("additionAcc28to44D").getValue();
			val_additionAcc28to44D= Double.parseDouble(stradditionAcc28to44D);
			setAdditionAcc28to44D(val_additionAcc28to44D);
		}
		double val_dedAcc28to44DEx35AD=0.0d;
		if (formMap.getField("dedAcc28to44DEx35AD").getValue().isEmpty()) {
			setDedAcc28to44DEx35AD(val_dedAcc28to44DEx35AD);
		}
		else{
			String strdedAcc28to44DEx35AD=formMap.getField("dedAcc28to44DEx35AD").getValue();
			val_dedAcc28to44DEx35AD= Double.parseDouble(strdedAcc28to44DEx35AD);
			setDedAcc28to44DEx35AD(val_dedAcc28to44DEx35AD);
		}
		double val_pl_SpecifiedBuss=0.0d;
		if (formMap.getField("pl_SpecifiedBuss").getValue().isEmpty()) {
			setPl_SpecifiedBuss(val_pl_SpecifiedBuss);
		}
		else{
			String strpl_SpecifiedBuss=formMap.getField("pl_SpecifiedBuss").getValue();
			val_pl_SpecifiedBuss= Double.parseDouble(strpl_SpecifiedBuss);
			setPl_SpecifiedBuss(val_pl_SpecifiedBuss);
		}
		double val_depreciation_PL=0.0d;
		if (formMap.getField("depreciation_PL").getValue().isEmpty()) {
			setDepreciation_PL(val_depreciation_PL);
		}
		else{
			String strdepreciation_PL=formMap.getField("depreciation_PL").getValue();
			val_depreciation_PL= Double.parseDouble(strdepreciation_PL);
			setDepreciation_PL(val_depreciation_PL);
		}
		
		
		
		double val_incomeChargeable_PL=0.0d;
		if (formMap.getField("incomeChargeable_PL").getValue().isEmpty()) {
			setIncomeChargeable_PL(val_incomeChargeable_PL);
		}
		else{
			String strincomeChargeable_PL=formMap.getField("incomeChargeable_PL").getValue();
			val_incomeChargeable_PL= Double.parseDouble(strincomeChargeable_PL);
			setIncomeChargeable_PL(val_incomeChargeable_PL);
		}
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
	
	
}
