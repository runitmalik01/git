
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
@Node(jcrType = "mootlywcm:formsixteen")

public class FormSixteen extends FormSixteenSectionA    implements ContentNodeBinder, FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:formsixteen";
	static final public String NODE_NAME = "formsixteen";

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
		// TODO Auto_generated method stub
		try {

			FormSixteen objformsixteen = (FormSixteen) content;

			node.setProperty("mootlywcm:employer", objformsixteen.getEmployer());
			node.setProperty("mootlywcm:employee", objformsixteen.getEmployee());
			node.setProperty("mootlywcm:pandeductor", objformsixteen.getPan_deductor());
			node.setProperty("mootlywcm:tandeductor", objformsixteen.getTan_deductor());
			node.setProperty("mootlywcm:panemployee", objformsixteen.getPan_employee());
			node.setProperty("mootlywcm:qtr1", objformsixteen.getQuarter_1());
			node.setProperty("mootlywcm:qtr2", objformsixteen.getQuarter_2());
			node.setProperty("mootlywcm:qtr3", objformsixteen.getQuarter_3());
			node.setProperty("mootlywcm:qtr4", objformsixteen.getQuarter_4());
			node.setProperty("mootlywcm:ack1", objformsixteen.getAcknowledge_1());
			node.setProperty("mootlywcm:ack2", objformsixteen.getAcknowledge_2());
			node.setProperty("mootlywcm:ack3", objformsixteen.getAcknowledge_3());
			node.setProperty("mootlywcm:ack4", objformsixteen.getAcknowledge_4());
			node.setProperty("mootlywcm:frm1", objformsixteen.getFrom_1());
			node.setProperty("mootlywcm:frm2", objformsixteen.getFrom_2());
			node.setProperty("mootlywcm:frm3", objformsixteen.getFrom_3());
			node.setProperty("mootlywcm:frm4", objformsixteen.getFrom_4());
			node.setProperty("mootlywcm:to1", objformsixteen.getTo_1());
			node.setProperty("mootlywcm:to2", objformsixteen.getTo_2());
			node.setProperty("mootlywcm:to3", objformsixteen.getTo_3());
			node.setProperty("mootlywcm:to4", objformsixteen.getTo_4());
			node.setProperty("mootlywcm:yr1", objformsixteen.getYear1());
			node.setProperty("mootlywcm:yr2", objformsixteen.getYear2());
			node.setProperty("mootlywcm:yr3", objformsixteen.getYear3());
			node.setProperty("mootlywcm:yr4", objformsixteen.getYear4());
			node.setProperty("mootlywcm:grossb", objformsixteen.getGross_b());
			node.setProperty("mootlywcm:grossc", objformsixteen.getGross_c());
			node.setProperty("mootlywcm:grosstotal", objformsixteen.getGross_total());
			node.setProperty("mootlywcm:lessalwnc1", objformsixteen.getLess_allowance_1());
			node.setProperty("mootlywcm:lessrs1", objformsixteen.getLess_rs_1());
			node.setProperty("mootlywcm:lesstot1", objformsixteen.getLess_total_1());
			node.setProperty("mootlywcm:lessalwnc2", objformsixteen.getLess_allowance_2());
			node.setProperty("mootlywcm:lessrs2", objformsixteen.getLess_rs_2());
			node.setProperty("mootlywcm:lesstot2", objformsixteen.getLess_total_2());
			node.setProperty("mootlywcm:balance", objformsixteen.getBalance());
			node.setProperty("mootlywcm:dedenter", objformsixteen.getDeductions_entertainment());
			node.setProperty("mootlywcm:dedtax", objformsixteen.getDeductions_tax());
			node.setProperty("mootlywcm:dedtot", objformsixteen.getDeductions_total());
			node.setProperty("mootlywcm:incomechargtot", objformsixteen.getIncome_chargable_tax());
			node.setProperty("mootlywcm:add1", objformsixteen.getAdditional_1());
			node.setProperty("mootlywcm:add2", objformsixteen.getAdditional_2());
			node.setProperty("mootlywcm:grossincometot", objformsixteen.getGross_income_total());
			node.setProperty("mootlywcm:dedundrch6a", objformsixteen.getDed_underchapter_6a());
			node.setProperty("mootlywcm:80c1", objformsixteen.getC_1());
			node.setProperty("mootlywcm:80c2", objformsixteen.getC_2());
			node.setProperty("mootlywcm:80c3", objformsixteen.getC_3());
			node.setProperty("mootlywcm:80c4", objformsixteen.getC_4());
			node.setProperty("mootlywcm:80c5", objformsixteen.getC_5());
			node.setProperty("mootlywcm:80c6a", objformsixteen.getC_6a());
			node.setProperty("mootlywcm:80c6b", objformsixteen.getC_6b());
			node.setProperty("mootlywcm:80c6c", objformsixteen.getC_6c());
			node.setProperty("mootlywcm:80ccc1", objformsixteen.getCcc_1());
			node.setProperty("mootlywcm:80ccc2", objformsixteen.getCcc_2());
			node.setProperty("mootlywcm:80ccd1", objformsixteen.getCcd_1());
			node.setProperty("mootlywcm:80ccd2", objformsixteen.getCcd_2());
			node.setProperty("mootlywcm:asec", objformsixteen.getA_section());
			node.setProperty("mootlywcm:asec1", objformsixteen.getA_section_1());
			node.setProperty("mootlywcm:asec2", objformsixteen.getA_section_2());
			node.setProperty("mootlywcm:asec3", objformsixteen.getA_section_3());
			node.setProperty("mootlywcm:bsec", objformsixteen.getB_section());
			node.setProperty("mootlywcm:bsec1", objformsixteen.getB_section_1());
			node.setProperty("mootlywcm:bsec2", objformsixteen.getB_section_2());
			node.setProperty("mootlywcm:bsec3", objformsixteen.getB_section_3());
			node.setProperty("mootlywcm:csec", objformsixteen.getC_section());
			node.setProperty("mootlywcm:csec1", objformsixteen.getC_section_1());
			node.setProperty("mootlywcm:csec2", objformsixteen.getC_section_2());
			node.setProperty("mootlywcm:csec3", objformsixteen.getC_section_3());
			node.setProperty("mootlywcm:dsec", objformsixteen.getD_section());
			node.setProperty("mootlywcm:dsec1", objformsixteen.getD_section_1());
			node.setProperty("mootlywcm:dsec2", objformsixteen.getD_section_2());
			node.setProperty("mootlywcm:dsec3", objformsixteen.getD_section_3());
			node.setProperty("mootlywcm:esec", objformsixteen.getE_section());
			node.setProperty("mootlywcm:esec1", objformsixteen.getE_section_1());
			node.setProperty("mootlywcm:esec2", objformsixteen.getE_section_2());
			node.setProperty("mootlywcm:esec3", objformsixteen.getE_section_3());
			node.setProperty("mootlywcm:aggrigate", objformsixteen.getAggregate());
			node.setProperty("mootlywcm:totincome1", objformsixteen.getTotal_income_1());
			node.setProperty("mootlywcm:totincome2", objformsixteen.getTotal_income_2());
			node.setProperty("mootlywcm:taxtotincome1", objformsixteen.getTax_total_income_1());
			node.setProperty("mootlywcm:taxtotincome2", objformsixteen.getTax_total_income_2());
			node.setProperty("mootlywcm:surcharge1", objformsixteen.getSurcharge_1());
			node.setProperty("mootlywcm:surcharge2", objformsixteen.getSurcharge_2());
			node.setProperty("mootlywcm:educess", objformsixteen.getEducation_cess());
			node.setProperty("mootlywcm:taxpay", objformsixteen.getTax_payable());
			node.setProperty("mootlywcm:relief1", objformsixteen.getRelief_1());
			node.setProperty("mootlywcm:relief2", objformsixteen.getRelief_2());
			node.setProperty("mootlywcm:taxpayable", objformsixteen.getTax_payable1());
			node.setProperty("mootlywcm:taxpayable1", objformsixteen.getTax_payable_1());
			node.setProperty("mootlywcm:taxpayable2", objformsixteen.getTax_payable_2());
			node.setProperty("mootlywcm:dedent1", objformsixteen.getDed_ent_1());
			node.setProperty("mootlywcm:dedent2", objformsixteen.getDed_ent_2());
			node.setProperty("mootlywcm:dedent3", objformsixteen.getDed_ent_3());
			node.setProperty("mootlywcm:dedent4", objformsixteen.getDed_ent_4());
			node.setProperty("mootlywcm:relief1.1", objformsixteen.getRelief_11());
			node.setProperty("mootlywcm:relief1.2", objformsixteen.getRelief_12());



		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
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
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto_generated method stub

	}
}
