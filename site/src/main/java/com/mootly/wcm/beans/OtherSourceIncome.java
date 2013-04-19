
/**
 * 
 * User: abhishek
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */


package com.mootly.wcm.beans;
import java.util.Calendar;
import java.util.Date;

import javax.jcr.RepositoryException;
import javax.jcr.Value;

import static com.mootly.wcm.utils.Constants.PROP_PI_AREA_LOCALITY;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMPLOYER_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FATHER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FILING_STATUS;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FLAT_FLOOR_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PAN;
import static com.mootly.wcm.utils.Constants.PROP_PI_PERSONALINFO_LINK;
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_RESIDENT_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_SEX;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.components.ITReturnComponent;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:OtherSourceIncome")
public class OtherSourceIncome extends BaseDocument implements ContentNodeBinder, FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:OtherSourceIncome";
	static final public String NODE_NAME = "OtherSourceIncome";
	private String Gov_income;
	private String Kissan_patra;
	private String Bank_detail;
	private String Indira_patra;
	private String Int_nsc;
	private String Other_interest;
	private String Total_interest;
	private String Family_pension;
	private String Dividends;
	private String Lottery_horse_income;
	private String Income_rent_machine;
	private String Income_maintain;
	private String Other_income;
	private String Income_other;
	private String Deduction_57;
	private String TotalOther_income;
	private String Familypension_deduction;
	private String Other_deduction;
	private String Depreciation;
	private String Total_expenses;
	private String Dividends_uti;
	private String Interest_income;
	private String Dividends_mutualfund;
	private String Agriculture_income;
	private String Dividends_indian_companies;
	private String Total_taxfree_income;
	private String Taxable_income;

	//for personal information
	public final String getGov_income() {
		if (Gov_income == null) Gov_income = getProperty("mootlywcm:Gov_income");
		return Gov_income;
	}

	public final String getKissan_patra() {
		if (Kissan_patra == null) Kissan_patra = getProperty("mootlywcm:Kissan_patra");
		return Kissan_patra;
	}
	public final String getBank_detail() {
		if (Bank_detail == null) Bank_detail = getProperty("mootlywcm:Bank_detail");
		return Bank_detail;
	}
	public final String getIndira_patra() {
		if (Indira_patra == null) Indira_patra = getProperty("mootlywcm:Indira_patra");
		return Indira_patra;
	}
	public final String getInt_nsc() {
		if (Int_nsc == null) Int_nsc = getProperty("mootlywcm:Int_nsc");
		return Int_nsc;
	}
	public final String getOther_interest() {
		if (Other_interest == null) Other_interest = getProperty("mootlywcm:Other_interest");
		return Other_interest;
	}
	public final String getTotal_interest() {
		if (Total_interest == null) Total_interest = getProperty("mootlywcm:Total_interest");
		return Total_interest;
	}
	public String getFamily_pension() {
		if (Family_pension == null) Family_pension = getProperty("mootlywcm:Family_pension");
		return Family_pension;
	}

	public final String getDividends() {
		if (Dividends== null) Dividends = getProperty("mootlywcm:Dividends");
		return Dividends;
	}
	public final String getLottery_horse_income() {
		if (Lottery_horse_income== null) Lottery_horse_income = getProperty("mootlywcm:Lottery_horse_income");
		return Lottery_horse_income;
	}
	public final String getIncome_rent_machine() {
		if (Income_rent_machine== null) Income_rent_machine = getProperty("mootlywcm:Income_rent_machine");
		return Income_rent_machine;
	}
	public final String getIncome_maintain() {
		if (Income_maintain== null) Income_maintain = getProperty("mootlywcm:Income_maintain");
		return Income_maintain;
	}
	public final String getTaxable_income() {
		if (Taxable_income== null) Taxable_income = getProperty("mootlywcm:Taxable_income");
		return Taxable_income;
	}
	public final String getOther_income() {
		if (Other_income== null) Other_income = getProperty("mootlywcm:Other_income");
		return Other_income;
	}
	public final String getIncome_other() {
		if (Income_other== null) Income_other = getProperty("mootlywcm:Income_other");
		return Income_other;
	}
	public final String getDeduction_57() {
		if (Deduction_57== null) Deduction_57 = getProperty("mootlywcm:Deduction_57");
		return Deduction_57;
	}
	public final String getTotalOther_income() {
		if (TotalOther_income== null) TotalOther_income = getProperty("mootlywcm:TotalOther_income");
		return TotalOther_income;
	}
	public final String getFamilypension_deduction() {
		if (Familypension_deduction== null) Familypension_deduction = getProperty("mootlywcm:Familypension_deduction");
		return Familypension_deduction;
	}
	public final String getOther_deduction() {
		if (Other_deduction== null) Other_deduction = getProperty("mootlywcm:Other_deduction");
		return Other_deduction;
	}
	public final String getDepreciation() {
		if (Depreciation== null) Depreciation = getProperty("mootlywcm:Depreciation");
		return Depreciation;
	}
	public final String getTotal_expenses() {
		if (Total_expenses== null) Total_expenses = getProperty("mootlywcm:Total_expenses");
		return Total_expenses;
	}
	public final String getDividends_uti() {
		if (Dividends_uti== null) Dividends_uti = getProperty("mootlywcm:Dividends_uti");
		return Dividends_uti;
	}
	public final String getDividends_mutualfund() {
		if (Dividends_mutualfund== null) Dividends_mutualfund = getProperty("mootlywcm:Dividends_mutualfund");
		return Dividends_mutualfund;
	}
	public final String getAgriculture_income() {
		if (Agriculture_income== null) Agriculture_income = getProperty("mootlywcm:Agriculture_income");
		return Agriculture_income;
	}
	public final String getDividends_indian_companies() {
		if (Dividends_indian_companies== null) Dividends_indian_companies = getProperty("mootlywcm:Dividends_indian_companies");
		return Dividends_indian_companies;
	}
	public final String getInterest_income() {
		if (Interest_income== null) Interest_income = getProperty("mootlywcm:Interest_income");
		return Interest_income;
	}
	public final String getTotal_taxfree_income() {
		if (Total_taxfree_income== null) Total_taxfree_income = getProperty("mootlywcm:Total_taxfree_income");
		return Total_taxfree_income;
	}

	// set method for otherincome document

	public final void setGov_income(String Gov_income) {
		this.Gov_income = Gov_income;
	}
	public final void setKissan_patra(String Kissan_patra) {
		this.Kissan_patra = Kissan_patra;
	}
	public final void setBank_detail(String Bank_detail) {
		this.Bank_detail = Bank_detail;
	}
	public final void setInt_nsc(String Int_nsc) {
		this.Int_nsc = Int_nsc;
	}
	public final void setIndira_patra(String Indira_patra) {
		this.Indira_patra = Indira_patra;
	}
	public final void setOther_interest(String Other_interest) {
		this.Other_interest = Other_interest;
	}
	public final void setDeduction_57(String Deduction_57) {
		this.Deduction_57 = Deduction_57;
	}
	public void setOther_income(String Other_income) {
		this.Other_income = Other_income;
	}
	public void setAgriculture_income(String Agriculture_income) {
		this.Agriculture_income = Agriculture_income;
	}
	public void setTotalOther_income(String TotalOther_income) {
		this.TotalOther_income = TotalOther_income;
	}
	public final void setLottery_horse_income(String Lottery_horse_income) {
		this.Lottery_horse_income = Lottery_horse_income;
	}
	public void setIncome_rent_machine(String Income_rent_machine) {
		this.Income_rent_machine = Income_rent_machine;
	}
	public void setIncome_maintain(String Income_maintain) {
		this.Income_maintain = Income_maintain;
	}
	public final void setDividends(String Dividends) {
		this.Dividends = Dividends;
	}
	public void setFamily_pension(String Family_pension) {
		this.Family_pension = Family_pension;
	}
	public void setTotal_interest(String Total_interest) {
		this.Total_interest = Total_interest;
	}
	public void setDividends_indian_companies(String Dividends_indian_companies) {
		this.Dividends_indian_companies = Dividends_indian_companies;
	}
	public void setTotal_expenses(String Total_expenses) {
		this.Total_expenses = Total_expenses;
	}
	public void setDividends_uti(String Dividends_uti) {
		this.Dividends_uti = Dividends_uti;
	}
	public void setIncome_other(String Income_other) {
		this.Income_other = Income_other;
	}
	public void setDepreciation(String Depreciation) {
		this.Depreciation = Depreciation;
	}
	public void setOther_deduction(String Other_deduction) {
		this.Other_deduction = Other_deduction;
	}
	public void setFamilypension_deduction(String Familypension_deduction) {
		this.Familypension_deduction = Familypension_deduction;
	}
	public void setTaxable_income(String Taxable_income) {
		this.Taxable_income = Taxable_income;
	}
	public void setInterest_income(String Interest_income) {
		this.Interest_income = Interest_income;
	}
	public void setDividends_mutualfund(String Dividends_mutualfund) {
		this.Dividends_mutualfund = Dividends_mutualfund;
	}
	public void setTotal_taxfree_income(String Total_taxfree_income) {
		this.Total_taxfree_income = Total_taxfree_income;
	}

	/* public MemberPersonalInformation getMemberPersoanlInformation() {
	    	HippoBean bean = getBean(PROP_PI_PERSONALINFO_LINK);
	    	if (!(bean instanceof HippoMirror)) {
	    		return null;
	    	}
	    	MemberPersonalInformation prdBean = (MemberPersonalInformation) ((HippoMirror) bean).getReferencedBean();
	    	if (prdBean == null) {
	    		return null;
	    	}
	    	return prdBean;
	    }
	 */
	//for personal information

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {

			OtherSourceIncome otherincome = (OtherSourceIncome) content;

			node.setProperty("mootlywcm:Gov_income", otherincome.getGov_income());
			node.setProperty("mootlywcm:Kissan_patra", otherincome.getKissan_patra());
			node.setProperty("mootlywcm:Bank_detail", otherincome.getBank_detail());
			node.setProperty("mootlywcm:Indira_patra", otherincome.getIndira_patra());
			node.setProperty("mootlywcm:Int_nsc", otherincome.getInt_nsc());
			node.setProperty("mootlywcm:Other_interest", otherincome.getOther_interest());
			node.setProperty("mootlywcm:Total_interest", otherincome.getTotal_interest());
			node.setProperty("mootlywcm:Family_pension", otherincome.getFamily_pension());
			node.setProperty("mootlywcm:Dividends", otherincome.getDividends());
			node.setProperty("mootlywcm:Lottery_horse_income", otherincome.getLottery_horse_income());
			node.setProperty("mootlywcm:Income_rent_machine", otherincome.getIncome_rent_machine());
			node.setProperty("mootlywcm:Income_maintain", otherincome.getIncome_maintain());
			node.setProperty("mootlywcm:Taxable_income", otherincome.getTaxable_income());
			node.setProperty("mootlywcm:Income_other", otherincome.getIncome_other());
			node.setProperty("mootlywcm:TotalOther_income", otherincome.getTotalOther_income());
			node.setProperty("mootlywcm:Deduction_57", otherincome.getDeduction_57());
			node.setProperty("mootlywcm:Depreciation", otherincome.getDepreciation());
			node.setProperty("mootlywcm:Total_expenses", otherincome.getTotal_expenses());
			node.setProperty("mootlywcm:Familypension_deduction", otherincome.getFamilypension_deduction());
			node.setProperty("mootlywcm:Divivends_uti", otherincome.getDividends_uti());
			node.setProperty("mootlywcm:Dividends_mutualfund", otherincome.getDividends_mutualfund());
			node.setProperty("mootlywcm:Dividends_indian_companies", otherincome.getDividends_indian_companies());
			node.setProperty("mootlywcm:Other_income", otherincome.getOther_income());
			node.setProperty("mootlywcm:Total_taxfree_income", otherincome.getTotal_taxfree_income());
			node.setProperty("mootlywcm:Other_interest", otherincome.getOther_interest());
			node.setProperty("mootlywcm:Agriculture_income", otherincome.getAgriculture_income());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;

		if (formMap.getField("Gov_income") != null){
			setGov_income(formMap.getField("Gov_income").getValue());
		}
		if (formMap.getField("Kissan_patra") != null){
			setKissan_patra(formMap.getField("Kissan_patra").getValue());
		}
		if (formMap.getField("Bank_detail") != null) {
			setBank_detail(formMap.getField("Bank_detail").getValue());
		}
		if (formMap.getField("Indira_patra") != null){
			setIndira_patra(formMap.getField("Indira_patra").getValue());
		}
		if (formMap.getField("Int_nsc") != null) {
			setInt_nsc(formMap.getField("Int_nsc").getValue());
		}
		if (formMap.getField("Other_interest") != null){
			setOther_interest(formMap.getField("Other_interest").getValue());
		}
		if (formMap.getField("Total_interest") != null) {
			setTotal_interest(formMap.getField("Total_interest").getValue());
		}
		if (formMap.getField("Family_pension") != null){
			setFamily_pension(formMap.getField("Family_pension").getValue());
		}
		if (formMap.getField("Dividends") != null) {
			setDividends(formMap.getField("Dividends").getValue());
		}
		if (formMap.getField("Deduction_57") != null){
			setDeduction_57(formMap.getField("Deduction_57").getValue());
		}
		if (formMap.getField("Total_expenses") != null){
			setTotal_expenses(formMap.getField("Total_expenses").getValue());
		}
		if (formMap.getField("Familypension_deduction") != null){
			setFamilypension_deduction(formMap.getField("Familypension_deduction").getValue());
		}
		if (formMap.getField("TotalOther_income") != null) {
			setTotalOther_income(formMap.getField("TotalOther_income").getValue());
		}
		if (formMap.getField("Lottery_horse_income") != null){
			setLottery_horse_income(formMap.getField("Lottery_horse_income").getValue());
		}
		if (formMap.getField("Depreciation") != null) {
			setDepreciation(formMap.getField("Depreciation").getValue());
		}
		if (formMap.getField("Income_rent_machine") != null){
			setIncome_rent_machine(formMap.getField("Income_rent_machine").getValue());
		}
		if (formMap.getField("Income_maintain") != null){
			setIncome_maintain(formMap.getField("Income_maintain").getValue());
		}
		if (formMap.getField("Dividends_uti") != null){
			setDividends_uti(formMap.getField("Dividends_uti").getValue());
		}
		if (formMap.getField("Dividends_mutualfund") != null) {
			setDividends_mutualfund(formMap.getField("Dividends_mutualfund").getValue());
		}
		if (formMap.getField("Dividends_indian_companies") != null) {
			setDividends_indian_companies(formMap.getField("Dividends_indian_companies").getValue());
		}
		if (formMap.getField("Agriculture_income") != null) {
			setAgriculture_income(formMap.getField("Agriculture_income").getValue());
		}
		if (formMap.getField("Other_income") != null) {
			setOther_income(formMap.getField("Other_income").getValue());
		}
		if (formMap.getField("Income_other") != null) {
			setIncome_other(formMap.getField("Income_other").getValue());
		}
		if (formMap.getField("Total_taxfree_income") != null){
			setTotal_taxfree_income(formMap.getField("Total_taxfree_income").getValue());
		}
		if (formMap.getField("Taxable_income") != null){
			setTaxable_income(formMap.getField("Taxable_income").getValue());
		}
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
}
