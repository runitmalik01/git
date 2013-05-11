/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.beans.compound;

import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FormSixteenSectionA extends HippoItem {
private final static Logger log = LoggerFactory.getLogger(FormSixteenSectionA.class); 
	
	private String employer;
	private String employee;
	private String pan_deductor;
	private String tan_deductor;
	private String pan_employee;
	private String quarter_1;
	private String acknowledge_1;
	private String from_1;
	private String to_1;
	private String year1;
	private String quarter_2;
	private String acknowledge_2;
	private String from_2;
	private String to_2;
	private String year2;
	private String quarter_3;
	private String acknowledge_3;
	private String from_3;
	private String to_3;
	private String year3;
	private String quarter_4;
	private String acknowledge_4;
	private String from_4;
	private String to_4;
	private String year4;
	private Double gross_a;
	private Double gross_b;
	private Double gross_c;
	private Double gross_total;
	private Double less_allowance_1;
	private Double less_rs_1;
	private Double less_total_1;
	private Double less_allowance_2;
	private Double less_rs_2;
	private Double less_total_2;
	private Double balance;
	private Double deductions_entertainment;
	private Double deductions_tax;
	private Double deductions_total;
	private Double income_chargable_total;
	private Double additional_1;
	private Double additional_2;
	private Double gross_income_total;
	private Double ded_underchapter_6a;
	private Double c_1;
	private Double c_2;
	private Double c_3;
	private Double c_4;
	private Double c_5;
	private Double c_6a;
	private Double c_6b;
	private Double c_6c;
	private Double ccc_1;
	private Double ccc_2;
	private Double ccd_1;
	private Double ccd_2;
	private String a_section;
	private Double a_section_1;
	private Double a_section_2;
	private Double a_section_3;
	private String b_section;
	private Double b_section_1;
	private Double b_section_2;
	private Double b_section_3;
	private String c_section;
	private Double c_section_1;
	private Double c_section_2;
	private Double c_section_3;
	private String d_section;
	private Double d_section_1;
	private Double d_section_2;
	private Double d_section_3;
	private String e_section;
	private Double e_section_1;
	private Double e_section_2;
	private Double e_section_3;
	private Double aggregate;
	private Double total_income_1;
	private Double total_income_2;
	private Double tax_total_income_1;
	private Double tax_total_income_2;
	private Double surcharge_1;
	private Double surcharge_2;
	private Double education_cess;
	private Double tax_payable;
	private Double relief_1;
	private Double relief_2;
	private Double tax_payable1;
	private Double tax_payable_1;
	private Double tax_payable_2;
	private Double ded_ent1;
	private Double ded_ent2;
	private Double ded_ent3;
	private Double ded_ent4;
	private Double relief_11;
	private Double relief_12;



	//for personal information
	public  String getEmployer() {
		if (employer == null) employer = getProperty("mootlywcm:employer");
		return employer;
	}
	public  String getEmployee() {
		if (employee == null) employee = getProperty("mootlywcm:employee");
		return employee;
	}
	public  String getPan_deductor() {
		if (pan_deductor  == null) pan_deductor = getProperty("mootlywcm:pandeductor");
		return pan_deductor;
	}
	public  String getTan_deductor() {
		if (tan_deductor == null) pan_deductor = getProperty("mootlywcm:tandeductor");
		return tan_deductor;
	}
	public  String getPan_employee() {
		if (pan_employee == null) pan_employee = getProperty("mootlywcm:panemployee");
		return pan_employee;
	}
	public  String getQuarter_1() {
		if (quarter_1 == null) quarter_1 = getProperty("mootlywcm:qtr1");
		return quarter_1;
	}
	public  String getAcknowledge_1() {
		if (acknowledge_1 == null) acknowledge_1 = getProperty("mootlywcm:ack1");
		return acknowledge_1;
	}
	public  String getFrom_1() {
		if (from_1 == null) from_1 = getProperty("mootlywcm:frm1");
		return from_1;
	}
	public  String getTo_1() {
		if (to_1 == null) to_1 = getProperty("mootlywcm:to1");
		return to_1;
	}
	public  String getYear1() {
		if (year1 == null) year1 = getProperty("mootlywcm:yr1");
		return year1;
	}
	public  String getQuarter_2() {
		if (quarter_2 == null) quarter_2 = getProperty("mootlywcm:qtr2");
		return quarter_2;
	}
	public  String getAcknowledge_2() {
		if (acknowledge_2 == null) acknowledge_2 = getProperty("mootlywcm:ack2");
		return acknowledge_2;
	}
	public  String getFrom_2() {
		if (from_2 == null) from_2 = getProperty("mootlywcm:frm2");
		return from_2;
	}
	public  String getTo_2() {
		if (to_2 == null) to_2 = getProperty("mootlywcm:to2");
		return to_2;
	}
	public  String getYear2() {
		if (year2 == null) year2 = getProperty("mootlywcm:yr2");
		return year2;
	}
	public  String getQuarter_3() {
		if (quarter_3 == null) quarter_3 = getProperty("mootlywcm:qtr3");
		return quarter_3;
	}
	public  String getAcknowledge_3() {
		if (acknowledge_3 == null) acknowledge_3 = getProperty("mootlywcm:ack3");
		return acknowledge_3;
	}
	public  String getFrom_3() {
		if (from_3 == null) from_3 = getProperty("mootlywcm:frm3");
		return from_3;
	}
	public  String getTo_3() {
		if (to_3 == null) to_3 = getProperty("mootlywcm:to3");
		return to_3;
	}
	public  String getYear3() {
		if (year3 == null) year3 = getProperty("mootlywcm:yr3");
		return year3;
	}
	public  String getQuarter_4() {
		if (quarter_4 == null) quarter_4 = getProperty("mootlywcm:qtr4");
		return quarter_4;
	}
	public  String getAcknowledge_4() {
		if (acknowledge_4 == null) acknowledge_4 = getProperty("mootlywcm:ack4");
		return acknowledge_4;
	}
	public  String getFrom_4() {
		if (from_4 == null) from_4 = getProperty("mootlywcm:frm4");
		return from_4;
	}
	public  String getTo_4() {
		if (to_4 == null) to_4 = getProperty("mootlywcm:to4");
		return to_4;
	}
	public  String getYear4() {
		if (year4 == null) year4 = getProperty("mootlywcm:yr4");
		return year4;
	}
	public  Double getGross_a() {
		if (gross_a == null) gross_a = getProperty("mootlywcm:grossa");
		return gross_a;
	}
	public  Double getGross_b() {
		if (gross_b == null) gross_b = getProperty("mootlywcm:grossb");
		return gross_b;
	}
	public  Double getGross_c() {
		if (gross_c == null) gross_c = getProperty("mootlywcm:grossc");
		return gross_c;
	}
	public  Double getGross_total() {
		if (gross_total == null) gross_total = getProperty("mootlywcm:grosstotal");
		return gross_total;
	}
	public  Double getLess_allowance_1() {
		if (less_allowance_1 == null) less_allowance_1 = getProperty("mootlywcm:lessalwnc1");
		return less_allowance_1;
	}
	public  Double getLess_rs_1() {
		if (less_rs_1 == null) less_rs_1 = getProperty("mootlywcm:lessrs1");
		return less_rs_1;
	}
	public  Double getLess_total_1() {
		if (less_total_1 == null) less_total_1 = getProperty("mootlywcm:lesstot1");
		return less_total_1;
	}
	public  Double getLess_allowance_2() {
		if (less_allowance_2 == null) less_allowance_2 = getProperty("mootlywcm:lessalwnc2");
		return less_allowance_2;
	}
	public  Double getLess_rs_2() {
		if (less_rs_2 == null) less_rs_2 = getProperty("mootlywcm:lessrs2");
		return less_rs_2;
	}
	public  Double getLess_total_2() {
		if (less_total_2 == null) less_total_2 = getProperty("mootlywcm:lesstot2");
		return less_total_2;
	}
	public  Double getBalance() {
		if (balance == null) balance = getProperty("mootlywcm:balance");
		return balance;
	}
	public  Double getDeductions_entertainment() {
		if (deductions_entertainment == null) deductions_entertainment = getProperty("mootlywcm:dedenter");
		return deductions_entertainment;
	}
	public  Double getDeductions_tax() {
		if (deductions_tax == null) deductions_tax = getProperty("mootlywcm:dedtax");
		return deductions_tax;
	}
	public  Double getDeductions_total() {
		if (deductions_total == null) deductions_total = getProperty("mootlywcm:dedtot");
		return deductions_total;
	}
	public  Double getIncome_chargable_tax() {
		if (income_chargable_total == null) income_chargable_total = getProperty("mootlywcm:incomechargtot");
		return income_chargable_total;
	}
	public  Double getAdditional_1() {
		if (additional_1 == null) additional_1 = getProperty("mootlywcm:add1");
		return additional_1;
	}
	public  Double getAdditional_2() {
		if (additional_2 == null) additional_2 = getProperty("mootlywcm:add2");
		return additional_2;
	}
	public  Double getGross_income_total() {
		if (gross_income_total == null) gross_income_total = getProperty("mootlywcm:grossincometot");
		return gross_income_total;
	}
	public  Double getDed_underchapter_6a() {
		if (ded_underchapter_6a == null) ded_underchapter_6a = getProperty("mootlywcm:dedundrch6a");
		return ded_underchapter_6a;
	}
	public  Double getC_1() {
		if (c_1 == null) c_1 = getProperty("mootlywcm:80c1");
		return c_1;
	}
	public  Double getC_2() {
		if (c_2 == null) c_2 = getProperty("mootlywcm:80c2");
		return c_2;
	}
	public  Double getC_3() {
		if (c_3 == null) c_3 = getProperty("mootlywcm:80c3");
		return c_3;
	}
	public  Double getC_4() {
		if (c_4 == null) c_4 = getProperty("mootlywcm:80c4");
		return c_4;
	}
	public  Double getC_5() {
		if (c_5 == null) c_5 = getProperty("mootlywcm:80c5");
		return c_5;
	}
	public  Double getC_6a() {
		if (c_6a == null) c_6a = getProperty("mootlywcm:80c6a");
		return c_6a;
	}
	public  Double getC_6b() {
		if (c_6b == null) c_6b = getProperty("mootlywcm:80c6b");
		return c_6b;
	}
	public  Double getC_6c() {
		if (c_6c == null) c_6c = getProperty("mootlywcm:80c6c");
		return c_6c;
	}
	public  Double getCcc_1() {
		if (ccc_1 == null) ccc_1 = getProperty("mootlywcm:80ccc1");
		return ccc_1;
	}
	public  Double getCcc_2() {
		if (ccc_2 == null) ccc_2 = getProperty("mootlywcm:80ccc2");
		return ccc_2;
	}
	public  Double getCcd_1() {
		if (ccd_1 == null) ccd_1 = getProperty("mootlywcm:80ccd1");
		return ccd_1;
	}
	public  Double getCcd_2() {
		if (ccd_2 == null) ccd_2 = getProperty("mootlywcm:80ccd2");
		return ccd_2;
	}
	public  String getA_section() {
		if (a_section == null) a_section = getProperty("mootlywcm:asec");
		return a_section;
	}
	public  Double getA_section_1() {
		if (a_section_1 == null) a_section_1 = getProperty("mootlywcm:asec1");
		return a_section_1;
	}
	public  Double getA_section_2() {
		if (a_section_2 == null) a_section_2 = getProperty("mootlywcm:asec2");
		return a_section_2;
	}
	public  Double getA_section_3() {
		if (a_section_3 == null) a_section_3 = getProperty("mootlywcm:asec3");
		return a_section_3;
	}
	public  String getB_section() {
		if (b_section == null) b_section = getProperty("mootlywcm:bsec");
		return b_section;
	}
	public  Double getB_section_1() {
		if (b_section_1 == null) b_section_1 = getProperty("mootlywcm:bsec1");
		return b_section_1;
	}
	public  Double getB_section_2() {
		if (b_section_2 == null) b_section_2 = getProperty("mootlywcm:bsec2");
		return b_section_2;
	}
	public  Double getB_section_3() {
		if (b_section_3 == null) b_section_3 = getProperty("mootlywcm:bsec3");
		return b_section_3;
	}
	public  String getC_section() {
		if (c_section == null) c_section = getProperty("mootlywcm:csec");
		return c_section;
	}
	public  Double getC_section_1() {
		if (c_section_1 == null) c_section_1 = getProperty("mootlywcm:csec1");
		return c_section_1;
	}
	public  Double getC_section_2() {
		if (c_section_2 == null) c_section_2 = getProperty("mootlywcm:csec2");
		return c_section_2;
	}
	public  Double getC_section_3() {
		if (c_section_3 == null) c_section_3 = getProperty("mootlywcm:csec3");
		return c_section_3;
	}
	public  String getD_section() {
		if (d_section == null) d_section = getProperty("mootlywcm:dsec");
		return d_section;
	}
	public  Double getD_section_1() {
		if (d_section_1 == null) d_section_1 = getProperty("mootlywcm:dsec1");
		return d_section_1;
	}
	public  Double getD_section_2() {
		if (d_section_2 == null) d_section_2 = getProperty("mootlywcm:dsec2");
		return d_section_2;
	}
	public  Double getD_section_3() {
		if (d_section_3 == null) d_section_3 = getProperty("mootlywcm:dsec3");
		return d_section_3;
	}

	public  String getE_section() {
		if (e_section == null) e_section = getProperty("mootlywcm:esec");
		return e_section;
	}
	public  Double getE_section_1() {
		if (e_section_1 == null) e_section_1 = getProperty("mootlywcm:esec1");
		return e_section_1;
	}
	public  Double getE_section_2() {
		if (e_section_2 == null) e_section_2 = getProperty("mootlywcm:esec2");
		return e_section_2;
	}
	public  Double getE_section_3() {
		if (e_section_3 == null) e_section_3 = getProperty("mootlywcm:esec3");
		return e_section_3;
	}
	public  Double getAggregate() {
		if (aggregate == null) aggregate = getProperty("mootlywcm:aggrigate");
		return aggregate;
	}
	public  Double getTotal_income_1() {
		if (total_income_1 == null) total_income_1 = getProperty("mootlywcm:totincome1");
		return total_income_1;
	}
	public  Double getTotal_income_2() {
		if (total_income_2 == null) total_income_2 = getProperty("mootlywcm:totincome2");
		return total_income_2;
	}
	public  Double getTax_total_income_1() {
		if (tax_total_income_1 == null) tax_total_income_1 = getProperty("mootlywcm:taxtotincome1");
		return tax_total_income_1;
	}
	public  Double getTax_total_income_2() {
		if (tax_total_income_2 == null) tax_total_income_2 = getProperty("mootlywcm:taxtotincome2");
		return tax_total_income_2;
	}
	public  Double getSurcharge_1() {
		if (surcharge_1 == null) surcharge_1 = getProperty("mootlywcm:surcharge1");
		return surcharge_1;
	}
	public  Double getSurcharge_2() {
		if (surcharge_2 == null) surcharge_2 = getProperty("mootlywcm:surcharge2");
		return surcharge_2;
	}
	public  Double getEducation_cess() {
		if (education_cess == null) education_cess = getProperty("mootlywcm:educess");
		return education_cess;
	}
	public  Double getTax_payable() {
		if (tax_payable == null) tax_payable = getProperty("mootlywcm:taxpay");
		return tax_payable;
	}
	public  Double getRelief_1() {
		if (relief_1 == null) relief_1 = getProperty("mootlywcm:relief1");
		return relief_1;
	}
	public  Double getRelief_2() {
		if (relief_2 == null) relief_2 = getProperty("mootlywcm:relief2");
		return relief_2;
	}
	public  Double getTax_payable1() {
		if (tax_payable1 == null) tax_payable1 = getProperty("mootlywcm:taxpayable1");
		return tax_payable1;
	}
	public  Double getTax_payable_1() {
		if (tax_payable_1 == null) tax_payable_1 = getProperty("mootlywcm:taxpayable1");
		return tax_payable_1;
	}
	public  Double getTax_payable_2() {
		if (tax_payable_2 == null) tax_payable_2 = getProperty("mootlywcm:taxpayable2");
		return tax_payable_2;
	}
	public  Double getDed_ent_1() {
		if (ded_ent1 == null) ded_ent1 = getProperty("mootlywcm:dedent1");
		return ded_ent1;
	}
	public  Double getDed_ent_2() {
		if (ded_ent2 == null) ded_ent2 = getProperty("mootlywcm:dedent2");
		return ded_ent2;
	}
	public  Double getDed_ent_3() {
		if (ded_ent3 == null) ded_ent3 = getProperty("mootlywcm:dedent3");
		return ded_ent3;
	}
	public  Double getDed_ent_4() {
		if (ded_ent4 == null) ded_ent4 = getProperty("mootlywcm:dedent4");
		return ded_ent4;
	}
	public  Double getRelief_11() {
		if (relief_11 == null) relief_11 = getProperty("mootlywcm:relief1.1");
		return relief_11;
	}
	public  Double getRelief_12() {
		if (relief_12 == null) relief_12 = getProperty("mootlywcm:relief1.2");
		return relief_12;
	}

	// for setter method
	public final void  setEmployer(String employer) {
		this.employer = employer;
	}
	public final void setEmployee(String employee) {
		this.employee = employee;
	}
	public final void setPan_deductor(String pan_deductor) {
		this.pan_deductor = pan_deductor;
	}
	public final void setTan_deductor(String tan_deductor) {
		this.tan_deductor = tan_deductor;
	}
	public final void setPan_employee(String pan_employee) {
		this.pan_employee = pan_employee;
	}
	public final void setQuarter_1(String quarter_1) {
		this.quarter_1 = quarter_1;
	}
	public final void setAcknowledge_1(String acknowledge_1) {
		this.acknowledge_1 = acknowledge_1;
	}
	public final void setFrom_1(String from_1) {
		this.from_1 = from_1;
	}
	public final void setTo_1(String to_1) {
		this.to_1 = to_1;
	}
	public final void setYear1(String year1) {
		this.year1 = year1;
	}
	public final void setQuarter_2(String quarter_2) {
		this.quarter_2 = quarter_2;
	}
	public final void setAcknowledge_2(String acknowledge_2) {
		this.acknowledge_2 = acknowledge_2;
	}
	public final void setFrom_2(String from_2) {
		this.from_2 = from_2;
	}
	public final void setTo_2(String to_2) {
		this.to_2 = to_2;
	}
	public final void setYear2(String year2) {
		this.year2 = year2;
	}
	public final void setQuarter_3(String quarter_3) {
		this.quarter_3 = quarter_3;
	}
	public final void setAcknowledge_3(String acknowledge_3) {
		this.acknowledge_3 = acknowledge_3;
	}
	public final void setFrom_3(String from_3) {
		this.from_3 = from_3;
	}
	public final void setTo_3(String to_3) {
		this.to_3 = to_3;
	}
	public final void setYear3(String year3) {
		this.year3 = year3;
	}
	public final void setQuarter_4(String quarter_4) {
		this.quarter_4 = quarter_4;
	}
	public final void setAcknowledge_4(String acknowledge_4) {
		this.acknowledge_4 = acknowledge_4;
	}
	public final void setFrom_4(String from_4) {
		this.from_4 = from_4;
	}
	public final void setTo_4(String to_4) {
		this.to_4 = to_4;
	}
	public final void setYear4(String year4) {
		this.year4 = year4;
	}
	public final void setGross_a(Double gross_a) {
		this.gross_a = gross_a;
	}
	public final void setGross_b(Double gross_b) {
		this.gross_b = gross_b;
	}
	public final void setGross_c(Double gross_c) {
		this.gross_c = gross_c;
	}
	public final void setGross_total(Double gross_total) {
		this.gross_total = gross_total;
	}
	public void setLess_allowance_1(Double less_allowance_1) {
		this.less_allowance_1 = less_allowance_1;
	}
	public void setLess_rs_1(Double less_rs_1) {
		this.less_rs_1 = less_rs_1;
	}
	public void setLess_total_1(Double less_total_1) {
		this.less_total_1 = less_total_1;
	}
	public void setLess_allowance_2(Double less_allowance_2) {
		this.less_allowance_2 = less_allowance_2;
	}
	public void setLess_rs_2(Double less_rs_2) {
		this.less_rs_2 = less_rs_2;
	}
	public void setLess_total_2(Double less_total_2) {
		this.less_total_2 = less_total_2;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void setDeductions_entertainment(Double deductions_entertainment) {
		this.deductions_entertainment = deductions_entertainment;
	}
	public void setDeductions_tax(Double deductions_tax) {
		this.deductions_tax = deductions_tax;
	}
	public final void setDeductions_total(Double deductions_total) {
		this.deductions_total = deductions_total;
	}
	public void setIncome_chargable_total(Double income_chargable_total) {
		this.income_chargable_total = income_chargable_total;
	}
	public void setAdditional_1(Double additional_1) {
		this.additional_1 = additional_1;
	}
	public void setAdditional_2(Double additional_2) {
		this.additional_2 = additional_2;
	}
	public final void setGross_income_total(Double gross_income_total) {
		this.gross_income_total = gross_income_total;
	}
	public void setDed_underchapter_6a(Double ded_underchapter_6a) {
		this.ded_underchapter_6a = ded_underchapter_6a;
	}
	public void setC_1(Double c_1) {
		this.c_1 = c_1;
	}
	public void setC_2(Double c_2) {
		this.c_2 = c_2;
	}
	public void setC_3(Double c_3) {
		this.c_3 = c_3;
	}
	public void setC_4(Double c_4) {
		this.c_4 = c_4;
	}
	public void setC_5(Double c_5) {
		this.c_5 = c_5;
	}
	public void setC_6a(Double c_6a) {
		this.c_6a = c_6a;
	}
	public void setC_6b(Double c_6b) {
		this.c_6b = c_6b;
	}
	public void setC_6c(Double c_6c) {
		this.c_6c = c_6c;
	}
	public void setCcc_1(Double ccc_1) {
		this.ccc_1 = ccc_1;
	}
	public void setCcc_2(Double ccc_2) {
		this.ccc_2 = ccc_2;
	}
	public void setCcd_1(Double ccd_1) {
		this.ccd_1 = ccd_1;
	}
	public void setCcd_2(Double ccd_2) {
		this.ccd_2 = ccd_2;
	}
	public void setA_section(String a_section) {
		this.a_section = a_section;
	}
	public void setA_section_1(Double a_section_1) {
		this.a_section_1 = a_section_1;
	}
	public void setA_section_2(Double a_section_2) {
		this.a_section_2 = a_section_2;
	}
	public void setA_section_3(Double a_section_3) {
		this.a_section_3 = a_section_3;
	}
	public void setB_section(String b_section) {
		this.b_section = b_section;
	}
	public void setB_section_1(Double b_section_1) {
		this.b_section_1 = b_section_1;
	}
	public void setB_section_2(Double b_section_2) {
		this.b_section_2 = b_section_2;
	}
	public void setB_section_3(Double b_section_3) {
		this.b_section_3 = b_section_3;
	}
	public void setC_section(String c_section) {
		this.c_section = c_section;
	}
	public void setC_section_1(Double c_section_1) {
		this.c_section_1 = c_section_1;
	}
	public void setC_section_2(Double c_section_2) {
		this.c_section_2 = c_section_2;
	}
	public void setC_section_3(Double c_section_3) {
		this.c_section_3 = c_section_3;
	}
	public void setD_section(String d_section) {
		this.d_section = d_section;
	}
	public void setD_section_1(Double d_section_1) {
		this.d_section_1 = d_section_1;
	}
	public void setD_section_2(Double d_section_2) {
		this.d_section_2 = d_section_2;
	}
	public void setD_section_3(Double d_section_3) {
		this.d_section_3 = d_section_3;
	}
	public void setE_section(String e_section) {
		this.e_section = e_section;
	}
	public void setE_section_1(Double e_section_1) {
		this.e_section_1 = e_section_1;
	}
	public void setE_section_2(Double e_section_2) {
		this.e_section_2 = e_section_2;
	}
	public void setE_section_3(Double e_section_3) {
		this.e_section_3 = e_section_3;
	}

	public void setAggregate(Double aggregate) {
		this.aggregate = aggregate;
	}
	public void setTotal_income_1(Double total_income_1) {
		this.total_income_1 = total_income_1;
	}
	public void setTotal_income_2(Double total_income_2) {
		this.total_income_2 = total_income_2;
	}
	public void setTax_total_income_1(Double tax_total_income_1) {
		this.tax_total_income_1 = tax_total_income_1;
	}
	public void setTax_total_income_2(Double tax_total_income_2) {
		this.tax_total_income_2 = tax_total_income_2;
	}
	public void setSurcharge_1(Double surcharge_1) {
		this.surcharge_1 = surcharge_1;
	}
	public void setSurcharge_2(Double surcharge_2) {
		this.surcharge_2 = surcharge_2;
	}
	public void setEducation_cess(Double education_cess) {
		this.education_cess = education_cess;
	}
	public void setTax_payable(Double tax_payable) {
		this.tax_payable = tax_payable;
	}
	public void setRelief_1(Double relief_1) {
		this.relief_1 = relief_1;
	}
	public void setRelief_2(Double relief_2) {
		this.relief_2 = relief_2;
	}
	public void setTax_payable1(Double tax_payable1) {
		this.tax_payable1 = tax_payable1;
	}
	public void setTax_payable_1(Double tax_payable_1) {
		this.tax_payable_1 = tax_payable_1;
	}
	public void setTax_payable_2(Double tax_payable_2) {
		this.tax_payable_2 = tax_payable_2;
	}
	public void setDed_ent1(Double ded_ent1) {
		this.ded_ent1 = ded_ent1;
	}
	public void setDed_ent2(Double ded_ent2) {
		this.ded_ent2 = ded_ent2;
	}
	public void setDed_ent3(Double ded_ent3) {
		this.ded_ent3 = ded_ent3;
	}
	public void setDed_ent4(Double ded_ent4) {
		this.ded_ent4 = ded_ent4;
	}
	public void setRelief_11(Double relief_11) {
		this.relief_11 = relief_11;
	}
	public void setRelief_12(Double relief_12) {
		this.relief_12 = relief_12;
	}

}
