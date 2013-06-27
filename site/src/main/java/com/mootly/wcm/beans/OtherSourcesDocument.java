
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
@Node(jcrType = "mootlywcm:othersourcesdocument")
public class OtherSourcesDocument extends BaseDocument implements ContentNodeBinder, FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:othersourcesdocument";
	static final public String NODE_NAME = "othersources";
	private Double Gov_income;
	private Double Kissan;
	private Double Bank_detail_fdr;
	private Double Bank_detail_saving;
	private Double Indira;
	private Double intnsc;
	private Double Otherint;
	private Double Totalint;
	private Double Family_pension;
	private Double Dividends;
	private Double Lottery_horse_income;
	private Double Income_rent_machine;
	private Double Income_maintain;
	private Double Otherincome;
	private Double Income_other;
	private Double Deduction_57;
	private Double TotalOther_income;
	private Double Familypension_deduction;
	private Double Otherdeduction;
	private Double depreciation;
	private Double totalexpense;
	private Double Dividends_uti;
	private Double Interest_income;
	private Double Dividends_mutualfund;
	private Double Agriculture_income;
	private Double Dividends_indian_companies;
	private Double Total_taxfree_income;
	private Double Taxable_income;

	//for personal information
	public  Double getGov_income() {
		if (Gov_income == null) Gov_income = getProperty("mootlywcm:Gov_income");
		return Gov_income;
	}
	public  Double getKissan() {
		if (Kissan == null) Kissan = getProperty("mootlywcm:Kissanpatra");
		return Kissan;
	}
	public  Double getBank_detail_fdr() {
		if (Bank_detail_fdr == null) Bank_detail_fdr = getProperty("mootlywcm:Bank_detail_fdr");
		return Bank_detail_fdr;
	}
	public  Double getBank_detail_saving() {
		if (Bank_detail_saving == null) Bank_detail_saving = getProperty("mootlywcm:Bank_detail_saving");
		return Bank_detail_saving;
	}
	public  Double getIndira() {
		if (Indira == null) Indira = getProperty("mootlywcm:Indirapatra");
		return Indira;
	}
	public  Double getIntnsc() {
		if (intnsc == null) intnsc = getProperty("mootlywcm:Intnsc");
		return intnsc;
	}
	public  Double getOtherint() {
		if (Otherint == null) Otherint = getProperty("mootlywcm:Other_interest");
		return Otherint;
	}
	public  Double getTotalint() {
		if (Totalint == null) Totalint = getProperty("mootlywcm:Total_interest");
		return Totalint;
	}
	public Double getFamily_pension() {
		if (Family_pension == null) Family_pension = getProperty("mootlywcm:Family_pension");
		return Family_pension;
	}
	public  Double getDividends() {
		if (Dividends== null) Dividends = getProperty("mootlywcm:Dividends");
		return Dividends;
	}
	public  Double getLottery_horse_income() {
		if (Lottery_horse_income== null) Lottery_horse_income = getProperty("mootlywcm:Lottery_horse_income");
		return Lottery_horse_income;
	}
	public  Double getIncome_rent_machine() {
		if (Income_rent_machine== null) Income_rent_machine = getProperty("mootlywcm:Income_rent_machine");
		return Income_rent_machine;
	}
	public  Double getIncome_maintain() {
		if (Income_maintain== null) Income_maintain = getProperty("mootlywcm:Income_maintain");
		return Income_maintain;
	}
	public  Double getTaxable_income() {
		if (Taxable_income== null) Taxable_income = getProperty("mootlywcm:Taxable_income");
		return Taxable_income;
	}

	public  Double getOtherincome() {
		if (Otherincome== null) Otherincome = getProperty("mootlywcm:Other_income");
		return Otherincome;
	}
	public  Double getIncome_other() {
		if (Income_other== null) Income_other = getProperty("mootlywcm:Income_other");
		return Income_other;
	}
	public  Double getDeduction_57() {
		if (Deduction_57== null) Deduction_57 = getProperty("mootlywcm:Deduction_57");
		return Deduction_57;
	}
	public  Double getTotalOther_income() {
		if (TotalOther_income== null) TotalOther_income = getProperty("mootlywcm:TotalOther_income");
		return TotalOther_income;
	}
	public  Double getFamilypension_deduction() {
		if (Familypension_deduction== null) Familypension_deduction = getProperty("mootlywcm:Familypension_deduction");
		return Familypension_deduction;
	}
	public  Double getOtherdeduction() {
		if (Otherdeduction== null) Otherdeduction = getProperty("mootlywcm:Other_deduction");
		return Otherdeduction;
	}
	public  Double getDepreciation() {
		if (depreciation== null) depreciation = getProperty("mootlywcm:Depreciation");
		return depreciation;
	}
	public  Double getTotalexpense() {
		if (totalexpense== null) totalexpense = getProperty("mootlywcm:Total_expenses");
		return totalexpense;
	}
	public  Double getDividends_uti() {
		if (Dividends_uti== null) Dividends_uti = getProperty("mootlywcm:Dividends_uti");
		return Dividends_uti;
	}
	public  Double getDividends_mutualfund() {
		if (Dividends_mutualfund== null) Dividends_mutualfund = getProperty("mootlywcm:Dividends_mutualfund");
		return Dividends_mutualfund;
	}
	public  Double getAgriculture_income() {
		if (Agriculture_income== null) Agriculture_income = getProperty("mootlywcm:Agriculture_income");
		return Agriculture_income;
	}
	public  Double getDividends_indian_companies() {
		if (Dividends_indian_companies== null) Dividends_indian_companies = getProperty("mootlywcm:Dividends_indian_companies");
		return Dividends_indian_companies;
	}
	public  Double getInterest_income() {
		if (Interest_income== null) Interest_income = getProperty("mootlywcm:Interest_income");
		return Interest_income;
	}
	public  Double getTotal_taxfree_income() {
		if (Total_taxfree_income== null) Total_taxfree_income = getProperty("mootlywcm:Total_taxfree_income");
		return Total_taxfree_income;
	}

	// set method for otherincome document

	public final void  setGov_income(Double Gov_income) {
		this.Gov_income = Gov_income;
	}
	public final void setKissan(Double Kissan) {
		this.Kissan = Kissan;
	}
	public final void setBank_detail_fdr(Double Bank_detail_fdr) {
		this.Bank_detail_fdr = Bank_detail_fdr;
	}
	public final void setBank_detail_saving(Double Bank_detail_saving) {
		this.Bank_detail_saving = Bank_detail_saving;
	}
	public final void setIntnsc(Double intnsc) {
		this.intnsc = intnsc;
	}
	public final void setIndira(Double Indira) {
		this.Indira = Indira;
	}
	public final void setOtherint(Double Otherint) {
		this.Otherint = Otherint;
	}
	public final void setDeduction_57(Double Deduction_57) {
		this.Deduction_57 = Deduction_57;
	}
	public void setOtherincome(Double Otherincome) {
		this.Otherincome = Otherincome;
	}
	public void setAgriculture_income(Double Agriculture_income) {
		this.Agriculture_income = Agriculture_income;
	}
	public void setTotalOther_income(Double TotalOther_income) {
		this.TotalOther_income = TotalOther_income;
	}
	public final void setLottery_horse_income(Double Lottery_horse_income) {
		this.Lottery_horse_income = Lottery_horse_income;
	}
	public void setIncome_rent_machine(Double Income_rent_machine) {
		this.Income_rent_machine = Income_rent_machine;
	}
	public void setIncome_maintain(Double Income_maintain) {
		this.Income_maintain = Income_maintain;
	}
	public final void setDividends(Double Dividends) {
		this.Dividends = Dividends;
	}
	public void setFamily_pension(Double Family_pension) {
		this.Family_pension = Family_pension;
	}
	public void setTotalint(Double Totalint) {
		this.Totalint = Totalint;
	}
	public void setDividends_indian_companies(Double Dividends_indian_companies) {
		this.Dividends_indian_companies = Dividends_indian_companies;
	}
	public void setTotalexpense(Double totalexpense) {
		this.totalexpense = totalexpense;
	}
	public void setDividends_uti(Double Dividends_uti) {
		this.Dividends_uti = Dividends_uti;
	}
	public void setIncome_other(Double Income_other) {
		this.Income_other = Income_other;
	}
	public void setDepreciation(Double depreciation) {
		this.depreciation = depreciation;
	}
	public void setOtherdeduction(Double Otherdeduction) {
		this.Otherdeduction = Otherdeduction;
	}
	public void setFamilypension_deduction(Double Familypension_deduction) {
		this.Familypension_deduction = Familypension_deduction;
	}
	public void setTaxable_income(Double Taxable_income) {
		this.Taxable_income = Taxable_income;
	}
	public void setInterest_income(Double Interest_income) {
		this.Interest_income = Interest_income;
	}
	public void setDividends_mutualfund(Double Dividends_mutualfund) {
		this.Dividends_mutualfund = Dividends_mutualfund;
	}
	public void setTotal_taxfree_income(Double Total_taxfree_income) {
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

			OtherSourcesDocument otherincome = (OtherSourcesDocument) content;
			if (getGov_income() != null) {
				node.setProperty("mootlywcm:Gov_income", getGov_income());
			}if(getKissan()!=null){
				node.setProperty("mootlywcm:Kissan_patra", otherincome.getKissan());
			}if(getBank_detail_fdr()!=null){
				node.setProperty("mootlywcm:Bank_detail_fdr", otherincome.getBank_detail_fdr());
			}if(getBank_detail_saving()!=null){
				node.setProperty("mootlywcm:Bank_detail_saving", otherincome.getBank_detail_saving());
			}
			node.setProperty("mootlywcm:Indira_patra", otherincome.getIndira());
			node.setProperty("mootlywcm:Intnsc", otherincome.getIntnsc());
			node.setProperty("mootlywcm:Other_interest", otherincome.getOtherint());
			node.setProperty("mootlywcm:Total_interest", otherincome.getTotalint());
			node.setProperty("mootlywcm:Family_pension", otherincome.getFamily_pension());
			node.setProperty("mootlywcm:Dividends", otherincome.getDividends());
			node.setProperty("mootlywcm:Lottery_horse_income", otherincome.getLottery_horse_income());
			node.setProperty("mootlywcm:Income_rent_machine", otherincome.getIncome_rent_machine());
			node.setProperty("mootlywcm:Income_maintain", otherincome.getIncome_maintain());
			node.setProperty("mootlywcm:Deduction_57", otherincome.getDeduction_57());
			node.setProperty("mootlywcm:Income_other", otherincome.getIncome_other());
			node.setProperty("mootlywcm:TotalOther_income", otherincome.getTotalOther_income());
			node.setProperty("mootlywcm:Familypension_deduction", otherincome.getFamilypension_deduction());
			node.setProperty("mootlywcm:Other_deduction", otherincome.getOtherdeduction());
			node.setProperty("mootlywcm:Depreciation", otherincome.getDepreciation());
			node.setProperty("mootlywcm:Total_expenses", otherincome.getTotalexpense());
			node.setProperty("mootlywcm:Divivends_uti", otherincome.getDividends_uti());
			node.setProperty("mootlywcm:Interest_income", otherincome.getInterest_income());
			node.setProperty("mootlywcm:Dividends_mutualfund", otherincome.getDividends_mutualfund());
			node.setProperty("mootlywcm:Agriculture_income", otherincome.getAgriculture_income());
			node.setProperty("mootlywcm:Dividends_indian_companies", otherincome.getDividends_indian_companies());
			node.setProperty("mootlywcm:Other_income", otherincome.getOtherincome());
			node.setProperty("mootlywcm:Total_taxfree_income", otherincome.getTotal_taxfree_income());
			node.setProperty("mootlywcm:Taxable_income", otherincome.getTaxable_income());


		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;

		if (formMap.getField("Gov_income").getValue().isEmpty()){}
		else{
			String strGov_income=formMap.getField("Gov_income").getValue();
			double amt= Double.parseDouble(strGov_income);

			setGov_income(amt);
		}
		if (formMap.getField("Bank_detail_fdr").getValue().isEmpty()) {}
		else{
			String strBankdetail=formMap.getField("Bank_detail_fdr").getValue();
			double amt= Double.parseDouble(strBankdetail);

			setBank_detail_fdr(amt);
		}
		if (formMap.getField("Bank_detail_saving").getValue().isEmpty()) {}
		else{
			String strBankdetail=formMap.getField("Bank_detail_saving").getValue();
			double amt= Double.parseDouble(strBankdetail);
			setBank_detail_saving(amt);
		}
		if (formMap.getField("Kissan").getValue().isEmpty()){}
		else{
			String strKissanpatra=formMap.getField("Kissan").getValue();
			double amt= Double.parseDouble(strKissanpatra);

			setKissan(amt);
		}

		if (formMap.getField("Indira").getValue().isEmpty()){}
		else{
			String strIndirapatra=formMap.getField("Indira").getValue();
			double amt= Double.parseDouble(strIndirapatra);

			setIndira(amt);
		}

		if (formMap.getField("intnsc").getValue().isEmpty()) {}
		else{
			String strInt_nsc=formMap.getField("intnsc").getValue();
			double amt= Double.parseDouble(strInt_nsc);

			setIntnsc(amt);
		}
		if (formMap.getField("Otherint").getValue().isEmpty()){}
		else{
			String strOther_interest=formMap.getField("Otherint").getValue();
			double amt= Double.parseDouble(strOther_interest);
			setOtherint(amt);
		}
		if (formMap.getField("Totalint").getValue().isEmpty()) {}
		else{
			String strTotal_interest=formMap.getField("Totalint").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setTotalint(amt);
		}
		if (formMap.getField("Family_pension").getValue().isEmpty()){}
		else{
			String strFamily_pension=formMap.getField("Family_pension").getValue();
			double amt= Double.parseDouble(strFamily_pension);
			setFamily_pension(amt);
		}
		if (formMap.getField("Dividends").getValue().isEmpty()) {}
		else{
			String strDividends=formMap.getField("Dividends").getValue();
			double amt= Double.parseDouble(strDividends);
			setDividends(amt);
		}
		if (formMap.getField("Deduction_57").getValue().isEmpty()){}
		else{
			String strDeduction_57=formMap.getField("Deduction_57").getValue();
			double amt= Double.parseDouble(strDeduction_57);
			setDeduction_57(amt);
		}
		if (formMap.getField("totalexpense").getValue().isEmpty()){}
		else{
			String strTotal_expenses=formMap.getField("totalexpense").getValue();
			double amt= Double.parseDouble(strTotal_expenses);

			setTotalexpense(amt);
		}
		if (formMap.getField("Familypension_deduction").getValue().isEmpty()){}
		else{
			String strstrTotalOther_income=formMap.getField("Familypension_deduction").getValue();
			double amt= Double.parseDouble(strstrTotalOther_income);

			setFamilypension_deduction(amt);
		}
		if (formMap.getField("TotalOther_income").getValue().isEmpty()) {}
		else{
			String strTotalOther_income=formMap.getField("TotalOther_income").getValue();
			double amt= Double.parseDouble(strTotalOther_income);

			setTotalOther_income(amt);
		}
		/*if (formMap.getField("Lottery_horse_income").getValue().isEmpty()){}
		else{
			String strLottery_horse_income=formMap.getField("Lottery_horse_income").getValue();
			double amt= Double.parseDouble(strLottery_horse_income);
			log.info("expense is"+amt);
			setLottery_horse_income(amt);
		}*/
		if (formMap.getField("depreciation").getValue().isEmpty()) {}
		else{
			String strDepreciation=formMap.getField("depreciation").getValue();
			double amt= Double.parseDouble(strDepreciation);

			setDepreciation(amt);
		}
		if (formMap.getField("Income_rent_machine").getValue().isEmpty()){}
		else{
			String strIncome_rent_machine=formMap.getField("Income_rent_machine").getValue();
			double amt= Double.parseDouble(strIncome_rent_machine);

			setIncome_rent_machine(amt);
		}
	/*	if (formMap.getField("Income_maintain").getValue().isEmpty()){}
		else{
			String strIncome_maintain=formMap.getField("Income_maintain").getValue();
			double amt= Double.parseDouble(strIncome_maintain);

			setIncome_maintain(amt);
		}*/
		if (formMap.getField("Dividends_uti").getValue().isEmpty()){}
		else{
			String strDividends_uti=formMap.getField("Dividends_uti").getValue();
			double amt= Double.parseDouble(strDividends_uti);

			setDividends_uti(amt);
		}
		if (formMap.getField("Dividends_mutualfund").getValue().isEmpty()) {}
		else{
			String strDividends_mutualfund=formMap.getField("Dividends_mutualfund").getValue();
			double amt= Double.parseDouble(strDividends_mutualfund);

			setDividends_mutualfund(amt);
		}
		if (formMap.getField("Dividends_indian_companies").getValue().isEmpty()) {}
		else{
			String strDividends_indian_companies=formMap.getField("Dividends_indian_companies").getValue();
			double amt= Double.parseDouble(strDividends_indian_companies);

			setDividends_indian_companies(amt);
		}
		if (formMap.getField("Agriculture_income").getValue().isEmpty()) {}
		else{
			String strAgriculture_income=formMap.getField("Agriculture_income").getValue();
			double amt= Double.parseDouble(strAgriculture_income);

			setAgriculture_income(amt);
		}
		if (formMap.getField("Otherincome").getValue().isEmpty()) {}
		else{
			String strOther_income=formMap.getField("Otherincome").getValue();
			double amt= Double.parseDouble(strOther_income);

			setOtherincome(amt);
		}
		if (formMap.getField("Income_other").getValue().isEmpty()) {}
		else{
			String strIncome_other=formMap.getField("Income_other").getValue();
			double amt= Double.parseDouble(strIncome_other);

			setIncome_other(amt);
		}
		if (formMap.getField("Total_taxfree_income").getValue().isEmpty()){}
		else{
			String strTotal_taxfree_income=formMap.getField("Total_taxfree_income").getValue();
			double amt= Double.parseDouble(strTotal_taxfree_income);

			setTotal_taxfree_income(amt);
		}
		if (formMap.getField("Interest_income").getValue().isEmpty()){}
		else{
			String strInterest_income=formMap.getField("Interest_income").getValue();
			double amt= Double.parseDouble(strInterest_income);

			setInterest_income(amt);
		}
		if (formMap.getField("Taxable_income").getValue().isEmpty()){}
		else{
			String strTaxable_income=formMap.getField("Taxable_income").getValue();
			double amt= Double.parseDouble(strTaxable_income);

			setTaxable_income(amt);
		}
		if (formMap.getField("Otherdeduction").getValue().isEmpty()){}
		else{
			String strTaxable_income=formMap.getField("Otherdeduction").getValue();
			double amt= Double.parseDouble(strTaxable_income);

			setOtherdeduction(amt);
		}
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
}
