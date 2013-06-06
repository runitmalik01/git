/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.components.ITReturnComponent;
@PrimaryBean(primaryBeanClass=FormSixteenDocument.class)
@ChildBean(childBeanClass=FormSixteenDetail.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@FormFields(fieldNames={"Employe_category","employer","employee","pan_deductor","tan_deductor","pan_employee","quarter_1","acknowledge_1","from_1","to_1","year1",
		"quarter_2","acknowledge_2","from_2","to_2","year2","quarter_3","acknowledge_3","from_3","to_3","year3","quarter_4","acknowledge_4",
		"from_4","to_4","year4","gross_a","gross_b","gross_c","gross_total","less_allowance_1","less_rs_1","less_total_1","less_allowance_2","less_rs_2",
		"less_total_2","deductions_entertainment","deductions_tax","deductions_total","income_chargable_total","additional_1","additional_2",
		"gross_income_total","ded_underchapter_6a","c_1","c_2","c_3","c_4","c_5","c_6a","c_6b","c_6c","ccc_1","ccc_2","ccd_1","balance",
		"ccd_2","a_section","a_section_1","a_section_2","a_section_3","b_section","b_section_1","b_section_2","b_section_3","c_section","c_section_1",
		"c_section_2","c_section_3","d_section","d_section_1","d_section_2","d_section_3","e_section","e_section_1","e_section_2","e_section_3",
		"aggregate","total_income_1","total_income_2","tax_total_income_1","tax_total_income_2","surcharge_1","surcharge_2",
		"education_cess","tax_payable","relief_1","relief_2","tax_payable1","tax_payable_1","tax_payable_2","ded_ent1","ded_ent2",
		"ded_ent3","ded_ent4","relief_11","relief_12","uuidform16"})

public class FormSixteen extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(FormSixteen.class);


	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);	
		if (getPageAction() != null && getPageAction().equals(PAGE_ACTION.EDIT_CHILD) && getChildBean() != null) {
			FormSixteenDetail form16Detail=(FormSixteenDetail) getChildBean();
			request.getRequestContext().setAttribute("form16InEditMode",Boolean.TRUE);
			request.getRequestContext().setAttribute("form16UniqueUUID",form16Detail.getForm16Uuid());
		}
		//request.getRequestContext().getResolvedSiteMapItem().getHstSiteMapItem().toString();
		// this code is check to open the partial submit form with check that action is what
		if(request.getParameter("partialSubmit")!=null){
			if(request.getRequestContext().getResolvedSiteMapItem().getParameter("action").equalsIgnoreCase("formsixteen_NEW_CHILD")){
				FormSixteenDocument form16=(FormSixteenDocument)request.getAttribute("parentBean");
				String lastCanonicalUuid=form16.getFormSixteenDetailList().get(form16.getFormSixteenDetailList().size()-1).getCanonicalUUID();
				String modUrlToRedirect=getScriptName()+"/"+lastCanonicalUuid+"/formsixteenedit";
				try {
					response.sendRedirect(modUrlToRedirect);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		if (getPageAction().equals(PAGE_ACTION.NEW_CHILD)) {
			FormSixteenDetail formSixteenDetail = (FormSixteenDetail) getChildBean();
			if (formSixteenDetail != null) {
				formSixteenDetail.setForm16Uuid(UUID.randomUUID().toString());
			}
		} 
		return super.beforeSave(request);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto_generated method stub
		super.doAction(request, response);
	}

}
