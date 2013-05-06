
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

public class FormSixteen extends FormSixteenSectionB implements ContentNodeBinder, FormMapFiller {
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
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto_generated method stub

	}
}
