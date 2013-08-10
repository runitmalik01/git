/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 * User: abhishek
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */

package com.mootly.wcm.beans.compound;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import javax.jcr.RepositoryException;
import javax.sound.midi.MidiDevice.Info;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.FormSixteenDocument;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:formsixteendetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class FormSixteenDetail extends FormSixteenSectionB{
	static final public String NAMESPACE = "mootlywcm:formsixteendetail";
	static final public String NODE_NAME = FormSixteenDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(FormSixteenDetail.class); 

	private String personalInfoUuid;

	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	//for personal information

	//for personal information
	public final String getPersonalInfoUuid() {
		return personalInfoUuid;
	}

	public final void setPersonalInfoUuid(String personalInfoUuid) {
		this.personalInfoUuid = personalInfoUuid;
	}

	public PersonalInformation getPersonalInformation() {
		HippoBean bean = getBean(NT_PERSONAL_INFO_LINK);
		if (!(bean instanceof HippoMirror)) {
			return null;
		}

		PersonalInformation prdBean = (PersonalInformation) ((HippoMirror) bean).getReferencedBean();

		if (prdBean == null) {
			return null;
		}
		return prdBean;
	}

	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto_generated method stub
		try {
			if (log.isInfoEnabled()) {
				log.info("im in bind to node");
			}
			node.setProperty("mootlywcm:empcat", getEmploye_category());
			node.setProperty("mootlywcm:employer", getEmployer());
			node.setProperty("mootlywcm:addrs", getAddressdetail());
			node.setProperty("mootlywcm:state", getState());
			node.setProperty("mootlywcm:city", getCity());
			node.setProperty("mootlywcm:pin", getPin());
			node.setProperty("mootlywcm:address", getAddress());
			node.setProperty("mootlywcm:employee", getEmployee());
			node.setProperty("mootlywcm:pandeductor", getPan_deductor());
			node.setProperty("mootlywcm:tandeductor", getTan_deductor());
			node.setProperty("mootlywcm:panemployee", getPan_employee());
			node.setProperty("mootlywcm:qtr1", getQuarter_1());
			node.setProperty("mootlywcm:qtr2", getQuarter_2());
			node.setProperty("mootlywcm:qtr3", getQuarter_3());
			node.setProperty("mootlywcm:qtr4", getQuarter_4());
			node.setProperty("mootlywcm:ack1", getAcknowledge_1());
			node.setProperty("mootlywcm:ack2", getAcknowledge_2());
			node.setProperty("mootlywcm:ack3", getAcknowledge_3());
			node.setProperty("mootlywcm:ack4", getAcknowledge_4());
			node.setProperty("mootlywcm:frm1", getFrom_1());
			node.setProperty("mootlywcm:frm2", getFrom_2());
			node.setProperty("mootlywcm:frm3", getFrom_3());
			node.setProperty("mootlywcm:frm4", getFrom_4());
			node.setProperty("mootlywcm:to1", getTo_1());
			node.setProperty("mootlywcm:to2", getTo_2());
			node.setProperty("mootlywcm:to3", getTo_3());
			node.setProperty("mootlywcm:to4", getTo_4());
			node.setProperty("mootlywcm:yr1", getYear1());
			node.setProperty("mootlywcm:yr2", getYear2());
			node.setProperty("mootlywcm:yr3", getYear3());
			node.setProperty("mootlywcm:yr4", getYear4());
			if(getGross_a()!=null){
				node.setProperty("mootlywcm:grossa", getGross_a());
			}
			if(getGross_b()!=null){
				node.setProperty("mootlywcm:grossb", getGross_b());}
			if(getGross_c()!=null){
				node.setProperty("mootlywcm:grossc", getGross_c());}
			if(getGross_total()!=null){
				node.setProperty("mootlywcm:grosstotal", getGross_total());}
			if(getLess_allowance_1()!=null){
				node.setProperty("mootlywcm:lessalwnc1", getLess_allowance_1());}
			if(getLess_rs_1()!=null){
				node.setProperty("mootlywcm:lessrs1", getLess_rs_1());}
			if(getLess_total_1()!=null){
				node.setProperty("mootlywcm:lesstot1", getLess_total_1());}
			if(getLess_allowance_2()!=null){
				node.setProperty("mootlywcm:lessalwnc2", getLess_allowance_2());}
			if(getLess_rs_2()!=null){
				node.setProperty("mootlywcm:lessrs2", getLess_rs_2());}
			if(getLess_total_2()!=null){
				node.setProperty("mootlywcm:lesstot2", getLess_total_2());}
			if(getBalance()!=null){
				node.setProperty("mootlywcm:balance", getBalance());}
			if(getDeductions_entertainment()!=null){
				node.setProperty("mootlywcm:dedenter", getDeductions_entertainment());}
			if(getDeductions_tax()!=null){
				node.setProperty("mootlywcm:dedtax", getDeductions_tax());}
			if(getDeductions_total()!=null){
				node.setProperty("mootlywcm:dedtot", getDeductions_total());}
			if(getIncome_chargable_tax()!=null){
				node.setProperty("mootlywcm:incomechargtot", getIncome_chargable_tax());}
			if(getAdditional_1()!=null){
				node.setProperty("mootlywcm:add1", getAdditional_1());}
			if(getAdditional_2()!=null){
				node.setProperty("mootlywcm:add2", getAdditional_2());}
			if(getGross_income_total()!=null){
				node.setProperty("mootlywcm:grossincometot", getGross_income_total());}
			if(getDed_underchapter_6a()!=null){
				node.setProperty("mootlywcm:dedundrch6a", getDed_underchapter_6a());}
			if(getC_1()!=null){
				node.setProperty("mootlywcm:80c1", getC_1());}
			if(getC_2()!=null){
				node.setProperty("mootlywcm:80c2", getC_2());}
			if(getC_3()!=null){
				node.setProperty("mootlywcm:80c3", getC_3());}
			if(getC_4()!=null){
				node.setProperty("mootlywcm:80c4", getC_4());}
			if(getC_5()!=null){
				node.setProperty("mootlywcm:80c5", getC_5());}
			if(getC_6a()!=null){
				node.setProperty("mootlywcm:80c6a", getC_6a());}
			if(getC_6b()!=null){
				node.setProperty("mootlywcm:80c6b", getC_6b());}
			if(getC_6c()!=null){
				node.setProperty("mootlywcm:80c6c", getC_6c());}
			if(getCcc_1()!=null){
				node.setProperty("mootlywcm:80ccc1", getCcc_1());}
			if(getCcc_2()!=null){
				node.setProperty("mootlywcm:80ccc2", getCcc_2());}
			if(getCcd_1()!=null){
				node.setProperty("mootlywcm:80ccd1", getCcd_1());}
			if(getCcd_2()!=null){
				node.setProperty("mootlywcm:80ccd2", getCcd_2());}
			if(getA_section()!=null){
				node.setProperty("mootlywcm:asec", getA_section());}
			if(getA_section_1()!=null){
				node.setProperty("mootlywcm:asec1", getA_section_1());}
			if(getA_section_2()!=null){
				node.setProperty("mootlywcm:asec2", getA_section_2());}
			if(getA_section_3()!=null){
				node.setProperty("mootlywcm:asec3", getA_section_3());}
			if(getB_section()!=null){
				node.setProperty("mootlywcm:bsec", getB_section());}
			if(getB_section_1()!=null){
				node.setProperty("mootlywcm:bsec1", getB_section_1());}
			if(getB_section_2()!=null){
				node.setProperty("mootlywcm:bsec2", getB_section_2());}
			if(getB_section_3()!=null){
				node.setProperty("mootlywcm:bsec3", getB_section_3());}
			if(getC_section()!=null){
				node.setProperty("mootlywcm:csec", getC_section());}
			if(getC_section_1()!=null){
				node.setProperty("mootlywcm:csec1", getC_section_1());}
			if(getC_section_2()!=null){
				node.setProperty("mootlywcm:csec2", getC_section_2());}
			if(getC_section_3()!=null){
				node.setProperty("mootlywcm:csec3", getC_section_3());}
			if(getD_section()!=null){
				node.setProperty("mootlywcm:dsec", getD_section());}
			if(getD_section_1()!=null){
				node.setProperty("mootlywcm:dsec1", getD_section_1());}
			if(getD_section_2()!=null){
				node.setProperty("mootlywcm:dsec2", getD_section_2());}
			if(getD_section_3()!=null){
				node.setProperty("mootlywcm:dsec3", getD_section_3());}
			if(getE_section()!=null){
				node.setProperty("mootlywcm:esec", getE_section());}
			if(getE_section_1()!=null){
				node.setProperty("mootlywcm:esec1", getE_section_1());}
			if(getE_section_2()!=null){
				node.setProperty("mootlywcm:esec2", getE_section_2());}
			if(getE_section_3()!=null){
				node.setProperty("mootlywcm:esec3", getE_section_3());}
			if(getAggregate()!=null){
				node.setProperty("mootlywcm:aggrigate", getAggregate());}
			if(getTotal_income_1()!=null){
				node.setProperty("mootlywcm:totincome1", getTotal_income_1());}
			if(getTotal_income_2()!=null){
				node.setProperty("mootlywcm:totincome2", getTotal_income_2());}
			if(getTax_total_income_1()!=null){
				node.setProperty("mootlywcm:taxtotincome1", getTax_total_income_1());}
			if(getTax_total_income_2()!=null){
				node.setProperty("mootlywcm:taxtotincome2", getTax_total_income_2());}
			if(getSurcharge_1()!=null){
				node.setProperty("mootlywcm:surcharge1", getSurcharge_1());}
			if(getSurcharge_2()!=null){
				node.setProperty("mootlywcm:surcharge2", getSurcharge_2());}
			if(getEducation_cess()!=null){
				node.setProperty("mootlywcm:educess", getEducation_cess());}
			if(getTax_payable()!=null){
				node.setProperty("mootlywcm:taxpay", getTax_payable());}
			if(getRelief_1()!=null){
				node.setProperty("mootlywcm:relief1", getRelief_1());}
			if(getRelief_2()!=null){
				node.setProperty("mootlywcm:relief2", getRelief_2());}
			if(getTax_payable1()!=null){
				node.setProperty("mootlywcm:taxpayable", getTax_payable1());}
			if(getTax_payable_1()!=null){
				node.setProperty("mootlywcm:taxpayable1", getTax_payable_1());}
			if(getTax_payable_2() !=null){
				node.setProperty("mootlywcm:taxpayable2", getTax_payable_2());}
			if(getDed_ent_1()!=null){
				node.setProperty("mootlywcm:dedent1", getDed_ent_1());}
			if(getDed_ent_2()!=null){
				node.setProperty("mootlywcm:dedent2", getDed_ent_2());}
			if(getDed_ent_3()!=null){
				node.setProperty("mootlywcm:dedent3", getDed_ent_3());}
			if(getDed_ent_4()!=null){
				node.setProperty("mootlywcm:dedent4", getDed_ent_4());}
			if(getRelief_11()!=null){
				node.setProperty("mootlywcm:relief1.1", getRelief_11());}
			if(getRelief_12()!=null){
				node.setProperty("mootlywcm:relief1.2", getRelief_12());}
			node.setProperty("mootlywcm:formsixteenuuid", getForm16Uuid());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	@Override


	public <T extends HippoBean> void cloneBean(T sourceBean) {
		if (log.isInfoEnabled()) {
			log.info("im in clone");}
		FormSixteenDetail objFormSixteen = (FormSixteenDetail) sourceBean;
		setEmploye_category(objFormSixteen.getEmploye_category());
		setEmployer(objFormSixteen.getEmployer());
		setAddress(objFormSixteen.getAddress());
		setEmployee(objFormSixteen.getEmployee());
		setPan_deductor(objFormSixteen.getPan_deductor());
		setTan_deductor(objFormSixteen.getTan_deductor());
		setPan_employee(objFormSixteen.getPan_employee());
		setQuarter_1(objFormSixteen.getQuarter_1());
		setAcknowledge_1(objFormSixteen.getAcknowledge_1());
		setFrom_1(objFormSixteen.getFrom_1());
		setTo_1(objFormSixteen.getTo_1());
		setYear1(objFormSixteen.getYear1());
		setQuarter_2(objFormSixteen.getQuarter_2());
		setAcknowledge_2(objFormSixteen.getAcknowledge_2());
		setFrom_2(objFormSixteen.getFrom_2());
		setTo_2(objFormSixteen.getTo_2());
		setYear2(objFormSixteen.getYear2());
		setQuarter_3(objFormSixteen.getQuarter_3());
		setAcknowledge_3(objFormSixteen.getAcknowledge_3());
		setFrom_3(objFormSixteen.getFrom_3());
		setTo_3(objFormSixteen.getTo_3());
		setYear3(objFormSixteen.getYear3());
		setQuarter_4(objFormSixteen.getQuarter_4());
		setAcknowledge_4(objFormSixteen.getAcknowledge_4());
		setFrom_4(objFormSixteen.getFrom_4());
		setTo_4(objFormSixteen.getTo_4());
		setYear4(objFormSixteen.getYear4());
		setGross_a(objFormSixteen.getGross_a());
		setGross_b(objFormSixteen.getGross_b());
		setGross_c(objFormSixteen.getGross_c());
		setGross_total(objFormSixteen.getGross_total());
		setLess_allowance_1(objFormSixteen.getLess_allowance_1());
		setLess_rs_1(objFormSixteen.getLess_rs_1());
		setLess_total_1(objFormSixteen.getLess_total_1());
		setLess_allowance_2(objFormSixteen.getLess_allowance_2());
		setLess_rs_2(objFormSixteen.getLess_rs_2());
		setLess_total_2(objFormSixteen.getLess_total_2());
		setBalance(objFormSixteen.getBalance());
		setDeductions_entertainment(objFormSixteen.getDeductions_entertainment());
		setDeductions_tax(objFormSixteen.getDeductions_tax());
		setDeductions_total(objFormSixteen.getDeductions_total());
		setIncome_chargable_total(objFormSixteen.getIncome_chargable_tax());
		setAdditional_1(objFormSixteen.getAdditional_1());
		setAdditional_2(objFormSixteen.getAdditional_2());
		setGross_income_total(objFormSixteen.getGross_income_total());
		setDed_underchapter_6a(objFormSixteen.getDed_underchapter_6a());
		setC_1(objFormSixteen.getC_1());
		setC_2(objFormSixteen.getC_2());
		setC_3(objFormSixteen.getC_3());
		setC_4(objFormSixteen.getC_4());
		setC_5(objFormSixteen.getC_5());
		setC_6a(objFormSixteen.getC_6a());
		setC_6b(objFormSixteen.getC_6b());
		setC_6c(objFormSixteen.getC_6c());
		setCcc_1(objFormSixteen.getCcc_1());
		setCcc_2(objFormSixteen.getCcc_2());
		setCcd_1(objFormSixteen.getCcd_1());
		setCcd_2(objFormSixteen.getCcd_2());
		setA_section(objFormSixteen.getA_section());
		setA_section_1(objFormSixteen.getA_section_1());
		setA_section_2(objFormSixteen.getA_section_2());
		setA_section_3(objFormSixteen.getA_section_3());
		setB_section(objFormSixteen.getB_section());
		setB_section_1(objFormSixteen.getB_section_1());
		setB_section_2(objFormSixteen.getB_section_2());
		setB_section_3(objFormSixteen.getB_section_3());
		setC_section(objFormSixteen.getC_section());
		setC_section_1(objFormSixteen.getC_section_1());
		setC_section_2(objFormSixteen.getC_section_2());
		setC_section_3(objFormSixteen.getC_section_3());
		setD_section(objFormSixteen.getD_section());
		setD_section_1(objFormSixteen.getD_section_1());
		setD_section_2(objFormSixteen.getD_section_2());
		setD_section_3(objFormSixteen.getD_section_3());
		setE_section(objFormSixteen.getE_section());
		setE_section_1(objFormSixteen.getE_section_1());
		setE_section_2(objFormSixteen.getE_section_2());
		setE_section_3(objFormSixteen.getE_section_3());
		setAggregate(objFormSixteen.getAggregate());
		setTotal_income_1(objFormSixteen.getTotal_income_1());
		setTotal_income_2(objFormSixteen.getTotal_income_2());
		setTax_total_income_1(objFormSixteen.getTax_total_income_1());
		setTax_total_income_2(objFormSixteen.getTax_total_income_2());
		setSurcharge_1(objFormSixteen.getSurcharge_1());
		setSurcharge_2(objFormSixteen.getSurcharge_2());
		setEducation_cess(objFormSixteen.getEducation_cess());
		setTax_payable(objFormSixteen.getTax_payable());
		setTax_payable1(objFormSixteen.getTax_payable1());
		setTax_payable_1(objFormSixteen.getTax_payable_1());
		setTax_payable_2(objFormSixteen.getTax_payable_2());
		setRelief_1(objFormSixteen.getRelief_1());
		setRelief_2(objFormSixteen.getRelief_2());
		setRelief_11(objFormSixteen.getRelief_11());
		setRelief_12(objFormSixteen.getRelief_12());
		setDed_ent1(objFormSixteen.getDed_ent_1());
		setDed_ent2(objFormSixteen.getDed_ent_2());
		setDed_ent3(objFormSixteen.getDed_ent_3());
		setDed_ent4(objFormSixteen.getDed_ent_4());	
		setAddressdetail(objFormSixteen.getAddressdetail());
		setCity(objFormSixteen.getCity());
		setState(objFormSixteen.getState());
		setPin(objFormSixteen.getPin());	
		setForm16Uuid(objFormSixteen.getForm16Uuid());
	}


}
