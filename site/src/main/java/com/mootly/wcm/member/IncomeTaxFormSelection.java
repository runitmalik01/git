package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper.DataTypeValidationType;
import com.mootly.wcm.beans.IncomeTaxFormSelectionDocument;
import com.mootly.wcm.components.ITReturnComponent;
@PrimaryBean(primaryBeanClass=IncomeTaxFormSelectionDocument.class)
@FormFields(fieldNames={"income_tax_form_selection"})
@RequiredFields(fieldNames={"income_tax_form_selection"})
@DataTypeValidationFields(fieldNames={"income_tax_form_selection"},dataTypes= {DataTypeValidationType.ITR})
public class IncomeTaxFormSelection extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(IncomeTaxFormSelection.class);

	@SuppressWarnings("deprecation")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}