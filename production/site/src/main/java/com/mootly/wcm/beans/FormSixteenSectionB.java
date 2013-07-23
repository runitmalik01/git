/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.beans;

import org.hippoecm.hst.component.support.forms.FormMap;

public abstract class FormSixteenSectionB extends FormSixteenSectionA {
	
	
	public void fill(FormMap formMap) {
		// TODO Auto_generated method stub
		if (formMap == null) return;


		if (formMap.getField("employer") != null){
			setEmployer(formMap.getField("employer").getValue());
		}
		if (formMap.getField("employee") != null){
			setEmployee(formMap.getField("employee").getValue());
		}
		if (formMap.getField("pan_deductor") != null){
			setPan_deductor(formMap.getField("pan_deductor").getValue());
		}
		if (formMap.getField("tan_deductor") != null){
			setTan_deductor(formMap.getField("tan_deductor").getValue());
		}
		if (formMap.getField("pan_employee") != null){
			setPan_employee(formMap.getField("pan_employee").getValue());
		}
		if (formMap.getField("quarter_1") != null){
			setQuarter_1(formMap.getField("quarter_1").getValue());
		}
		if (formMap.getField("quarter_2") != null){
			setQuarter_2(formMap.getField("quarter_2").getValue());
		}
		if (formMap.getField("quarter_3") != null){
			setQuarter_3(formMap.getField("quarter_3").getValue());
		}
		if (formMap.getField("quarter_4") != null){
			setQuarter_4(formMap.getField("quarter_4").getValue());
		}
		if (formMap.getField("acknowledge_1") != null){
			setAcknowledge_1(formMap.getField("acknowledge_1").getValue());
		}
		if (formMap.getField("acknowledge_2") != null){
			setAcknowledge_2(formMap.getField("acknowledge_2").getValue());
		}
		if (formMap.getField("acknowledge_3") != null){
			setAcknowledge_3(formMap.getField("acknowledge_3").getValue());
		}
		if (formMap.getField("acknowledge_4") != null){
			setAcknowledge_4(formMap.getField("acknowledge_4").getValue());
		}
		if (formMap.getField("from_1") != null){
			setFrom_1(formMap.getField("from_1").getValue());
		}
		if (formMap.getField("from_2") != null){
			setFrom_2(formMap.getField("from_2").getValue());
		}
		if (formMap.getField("from_3") != null){
			setFrom_3(formMap.getField("from_3").getValue());
		}
		if (formMap.getField("from_4") != null){
			setFrom_4(formMap.getField("from_4").getValue());
		}
		if (formMap.getField("to_1") != null){
			setTo_1(formMap.getField("to_1").getValue());
		}
		if (formMap.getField("to_2") != null){
			setTo_2(formMap.getField("to_2").getValue());
		}
		if (formMap.getField("to_3") != null){
			setTo_3(formMap.getField("to_3").getValue());
		}
		if (formMap.getField("to_4") != null){
			setTo_4(formMap.getField("to_4").getValue());
		}
		if (formMap.getField("year1") != null){
			setYear1(formMap.getField("year1").getValue());
		}
		if (formMap.getField("year2") != null){
			setYear2(formMap.getField("year2").getValue());
		}
		if (formMap.getField("year3") != null){
			setYear3(formMap.getField("year3").getValue());
			log.info("value of year is"+formMap.getField("year3").getValue());
		}
		if (formMap.getField("year4") != null){
			setYear4(formMap.getField("year4").getValue());
		}
		if (formMap.getField("gross_a") != null) {
			String strgross_a=formMap.getField("gross_a").getValue();
			double amt= Double.parseDouble(strgross_a);
			log.info("value of amt is"+amt);
			setGross_a(amt);
		}
		if (formMap.getField("gross_b") != null) {
			String strgross_b=formMap.getField("gross_b").getValue();
			double amt= Double.parseDouble(strgross_b);
			log.info("value of amt is"+amt);
			setGross_b(amt);
		}
		if (formMap.getField("gross_c") != null) {
			String strgross_c=formMap.getField("gross_c").getValue();
			double amt= Double.parseDouble(strgross_c);
			log.info("value of amt is"+amt);
			setGross_c(amt);
		}
		if (formMap.getField("gross_total") != null) {
			String strgross_total=formMap.getField("gross_total").getValue();
			double amt= Double.parseDouble(strgross_total);
			log.info("value of amt is"+amt);
			setGross_total(amt);
		}
		if (formMap.getField("less_allowance_1") != null) {
			String strBankdetail=formMap.getField("less_allowance_1").getValue();
			double amt= Double.parseDouble(strBankdetail);
			log.info("value of amt is"+amt);
			setLess_allowance_1(amt);
		}
		if (formMap.getField("less_rs_1") != null) {
			String strBankdetail=formMap.getField("less_rs_1").getValue();
			double amt= Double.parseDouble(strBankdetail);
			setLess_rs_1(amt);
		}
		if (formMap.getField("less_total_1") != null) {
			String strBankdetail=formMap.getField("less_total_1").getValue();
			double amt= Double.parseDouble(strBankdetail);
			setLess_total_1(amt);
		}
		if (formMap.getField("less_allowance_2") != null) {
			String strBankdetail=formMap.getField("less_allowance_2").getValue();
			double amt= Double.parseDouble(strBankdetail);
			log.info("value of amt is"+amt);
			setLess_allowance_2(amt);
		}
		if (formMap.getField("less_rs_2") != null) {
			String strBankdetail=formMap.getField("less_rs_2").getValue();
			double amt= Double.parseDouble(strBankdetail);
			setLess_rs_2(amt);
		}
		if (formMap.getField("less_total_2") != null) {
			String strBankdetail=formMap.getField("less_total_2").getValue();
			double amt= Double.parseDouble(strBankdetail);
			setLess_total_2(amt);
		}
		if (formMap.getField("balance") != null) {
			String strbalance=formMap.getField("balance").getValue();
			double amt= Double.parseDouble(strbalance);
			setBalance(amt);
		}
		if (formMap.getField("deductions_tax") != null) {
			String strBankdetail=formMap.getField("deductions_tax").getValue();
			double amt= Double.parseDouble(strBankdetail);
			log.info("value of amt is"+amt);
			setDeductions_tax(amt);
		}
		if (formMap.getField("deductions_entertainment") != null) {
			String strBankdetail=formMap.getField("deductions_entertainment").getValue();
			double amt= Double.parseDouble(strBankdetail);
			log.info("value of amt is"+amt);
			setDeductions_entertainment(amt);
		}
		if (formMap.getField("deductions_total") != null) {
			String strBankdetail=formMap.getField("deductions_total").getValue();
			double amt= Double.parseDouble(strBankdetail);
			log.info("value of amt is"+amt);
			setDeductions_total(amt);
		}
		if (formMap.getField("income_chargable_total") != null) {
			String strBankdetail=formMap.getField("income_chargable_total").getValue();
			double amt= Double.parseDouble(strBankdetail);
			log.info("value of amt is"+amt);
			setIncome_chargable_total(amt);
		}
		if (formMap.getField("additional_1") != null) {
			String strBankdetail=formMap.getField("additional_1").getValue();
			double amt= Double.parseDouble(strBankdetail);
			setAdditional_1(amt);
		}
		if (formMap.getField("additional_2") != null) {
			String strBankdetail=formMap.getField("additional_2").getValue();
			double amt= Double.parseDouble(strBankdetail);
			setAdditional_2(amt);
		}
		if (formMap.getField("gross_income_total") != null){
			String strKissanpatra=formMap.getField("gross_income_total").getValue();
			double amt= Double.parseDouble(strKissanpatra);
			setGross_income_total(amt);
		}

		if (formMap.getField("ded_underchapter_6a") != null){
			String strIndirapatra=formMap.getField("ded_underchapter_6a").getValue();
			double amt= Double.parseDouble(strIndirapatra);
			setDed_underchapter_6a(amt);
		}
		if (formMap.getField("c_1") != null) {
			String strInt_nsc=formMap.getField("c_1").getValue();
			double amt= Double.parseDouble(strInt_nsc);
			setC_1(amt);
		}
		if (formMap.getField("c_2") != null) {
			String strInt_nsc=formMap.getField("c_2").getValue();
			double amt= Double.parseDouble(strInt_nsc);
			setC_2(amt);
		}if (formMap.getField("c_3") != null) {
			String strInt_nsc=formMap.getField("c_3").getValue();
			double amt= Double.parseDouble(strInt_nsc);
			setC_3(amt);
		}
		if (formMap.getField("c_4") != null) {
			String strInt_nsc=formMap.getField("c_4").getValue();
			double amt= Double.parseDouble(strInt_nsc);
			setC_4(amt);
		}
		if (formMap.getField("c_5") != null) {
			String strInt_nsc=formMap.getField("c_5").getValue();
			double amt= Double.parseDouble(strInt_nsc);
			setC_5(amt);
		}
		if (formMap.getField("c_6a") != null) {
			String strInt_nsc=formMap.getField("c_6a").getValue();
			double amt= Double.parseDouble(strInt_nsc);
			setC_6a(amt);
		}
		if (formMap.getField("c_6b") != null) {
			String strInt_nsc=formMap.getField("c_6b").getValue();
			double amt= Double.parseDouble(strInt_nsc);
			setC_6b(amt);
		}
		if (formMap.getField("c_6c") != null) {
			String strInt_nsc=formMap.getField("c_6c").getValue();
			double amt= Double.parseDouble(strInt_nsc);
			setC_6c(amt);
		}
		if (formMap.getField("ccc_1") != null){
			String strOther_interest=formMap.getField("ccc_1").getValue();
			double amt= Double.parseDouble(strOther_interest);
			setCcc_1(amt);
		}
		if (formMap.getField("ccc_2") != null){
			String strOther_interest=formMap.getField("ccc_2").getValue();
			double amt= Double.parseDouble(strOther_interest);
			setCcc_2(amt);
		}
		if (formMap.getField("ccd_1") != null){
			String strOther_interest=formMap.getField("ccd_1").getValue();
			double amt= Double.parseDouble(strOther_interest);
			setCcd_1(amt);
		}
		if (formMap.getField("ccd_2") != null){
			String strOther_interest=formMap.getField("ccd_2").getValue();
			double amt= Double.parseDouble(strOther_interest);
			setCcd_2(amt);
		}
		if (formMap.getField("a_section") != null) {
			String strTotal_interest=formMap.getField("a_section").getValue();
			setA_section(strTotal_interest);
		}
		if (formMap.getField("a_section_1") != null) {
			String strTotal_interest=formMap.getField("a_section_1").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setA_section_1(amt);
		}
		if (formMap.getField("a_section_2") != null) {
			String strTotal_interest=formMap.getField("a_section_2").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setA_section_2(amt);
		}
		if (formMap.getField("a_section_3") != null) {
			String strTotal_interest=formMap.getField("a_section_3").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setA_section_3(amt);
		}
		if (formMap.getField("b_section") != null) {
			String strTotal_interest=formMap.getField("b_section").getValue();
			log.info("value of a section is"+strTotal_interest);
			setB_section(strTotal_interest);
		}
		if (formMap.getField("b_section_1") != null) {
			String strTotal_interest=formMap.getField("b_section_1").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setB_section_1(amt);
		}
		if (formMap.getField("b_section_2") != null) {
			String strTotal_interest=formMap.getField("b_section_2").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setB_section_2(amt);
		}
		if (formMap.getField("b_section_3") != null) {
			String strTotal_interest=formMap.getField("b_section_3").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setB_section_3(amt);
		}
		if (formMap.getField("c_section") != null) {
			String strTotal_interest=formMap.getField("c_section").getValue();

			setC_section(strTotal_interest);
		}
		if (formMap.getField("c_section_1") != null) {
			String strTotal_interest=formMap.getField("c_section_1").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setC_section_1(amt);
		}
		if (formMap.getField("c_section_2") != null) {
			String strTotal_interest=formMap.getField("c_section_2").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setC_section_2(amt);
		}
		if (formMap.getField("c_section_3") != null) {
			String strTotal_interest=formMap.getField("c_section_3").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setC_section_3(amt);
		}
		if (formMap.getField("d_section") != null) {
			String strTotal_interest=formMap.getField("d_section").getValue();

			setD_section(strTotal_interest);
		}
		if (formMap.getField("d_section_1") != null) {
			String strTotal_interest=formMap.getField("d_section_1").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setD_section_1(amt);
		}
		if (formMap.getField("d_section_2") != null) {
			String strTotal_interest=formMap.getField("d_section_2").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setD_section_2(amt);
		}
		if (formMap.getField("d_section_3") != null) {
			String strTotal_interest=formMap.getField("d_section_3").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setD_section_3(amt);
		}
		if (formMap.getField("e_section") != null) {
			String stre_section=formMap.getField("e_section").getValue();
			setE_section(stre_section);
		}
		if (formMap.getField("e_section_1") != null) {
			String strTotal_interest=formMap.getField("e_section_1").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setE_section_1(amt);
		}
		if (formMap.getField("e_section_2") != null) {
			String strTotal_interest=formMap.getField("e_section_2").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setE_section_2(amt);
		}
		if (formMap.getField("e_section_3") != null) {
			String strTotal_interest=formMap.getField("e_section_3").getValue();
			double amt= Double.parseDouble(strTotal_interest);
			setE_section_3(amt);
		}
		if (formMap.getField("aggregate") != null){
			String strFamily_pension=formMap.getField("aggregate").getValue();
			double amt= Double.parseDouble(strFamily_pension);
			setAggregate(amt);
		}
		if (formMap.getField("total_income_1") != null) {
			String strDividends=formMap.getField("total_income_1").getValue();
			double amt= Double.parseDouble(strDividends);
			setTotal_income_1(amt);
		}
		if (formMap.getField("total_income_2") != null) {
			String strDividends=formMap.getField("total_income_2").getValue();
			double amt= Double.parseDouble(strDividends);
			setTotal_income_2(amt);
		}
		if (formMap.getField("tax_total_income_1") != null) {
			String strDividends=formMap.getField("tax_total_income_1").getValue();
			double amt= Double.parseDouble(strDividends);
			setTax_total_income_1(amt);
		}
		if (formMap.getField("tax_total_income_2") != null) {
			String strDividends=formMap.getField("tax_total_income_2").getValue();
			double amt= Double.parseDouble(strDividends);
			setTax_total_income_2(amt);
		}
		if (formMap.getField("surcharge_1") != null){
			String strDeduction_57=formMap.getField("surcharge_1").getValue();
			double amt= Double.parseDouble(strDeduction_57);
			setSurcharge_1(amt);
		}
		if (formMap.getField("surcharge_2") != null){
			String strDeduction_57=formMap.getField("surcharge_2").getValue();
			double amt= Double.parseDouble(strDeduction_57);
			setSurcharge_2(amt);
		}
		if (formMap.getField("education_cess") != null){
			String strTotal_expenses=formMap.getField("education_cess").getValue();
			double amt= Double.parseDouble(strTotal_expenses);
			log.info("expense is"+amt);
			setEducation_cess(amt);
		}
		if (formMap.getField("tax_payable") != null){
			String strstrTotalOther_income=formMap.getField("tax_payable").getValue();
			double amt= Double.parseDouble(strstrTotalOther_income);
			setTax_payable(amt);
		}
		if (formMap.getField("relief_1") != null) {
			String strTotalOther_income=formMap.getField("relief_1").getValue();
			double amt= Double.parseDouble(strTotalOther_income);
			setRelief_1(amt);
		}
		if (formMap.getField("relief_2") != null) {
			String strTotalOther_income=formMap.getField("relief_2").getValue();
			double amt= Double.parseDouble(strTotalOther_income);
			setRelief_2(amt);
		}
		if (formMap.getField("tax_payable1") != null){
			String strLottery_horse_income=formMap.getField("tax_payable1").getValue();
			double amt= Double.parseDouble(strLottery_horse_income);
			setTax_payable1(amt);
		}
		if (formMap.getField("tax_payable_1") != null) {
			String strDepreciation=formMap.getField("tax_payable_1").getValue();
			double amt= Double.parseDouble(strDepreciation);
			setTax_payable_1(amt);
		}
		if (formMap.getField("tax_payable_2") != null) {
			String strDepreciation=formMap.getField("tax_payable_2").getValue();
			double amt= Double.parseDouble(strDepreciation);
			setTax_payable_2(amt);
		}
		if (formMap.getField("ded_ent1") != null) {
			String strDepreciation=formMap.getField("ded_ent1").getValue();
			double amt= Double.parseDouble(strDepreciation);
			setDed_ent1(amt);
		}
		if (formMap.getField("ded_ent2") != null) {
			String strDepreciation=formMap.getField("ded_ent2").getValue();
			double amt= Double.parseDouble(strDepreciation);
			setDed_ent2(amt);
		}
		if (formMap.getField("ded_ent3") != null) {
			String strDepreciation=formMap.getField("ded_ent3").getValue();
			double amt= Double.parseDouble(strDepreciation);
			setDed_ent3(amt);
		}
		if (formMap.getField("ded_ent4") != null) {
			String strDepreciation=formMap.getField("ded_ent4").getValue();
			double amt= Double.parseDouble(strDepreciation);
			setDed_ent4(amt);
		}
		if (formMap.getField("relief_11") != null){
			String strIncome_rent_machine=formMap.getField("relief_11").getValue();
			double amt= Double.parseDouble(strIncome_rent_machine);
			setRelief_11(amt);
		}
		if (formMap.getField("relief_12") != null){
			String strIncome_maintain=formMap.getField("relief_12").getValue();
			double amt= Double.parseDouble(strIncome_maintain);
			setRelief_12(amt);
		}
	}
	
	
	
	
	
	
	
}