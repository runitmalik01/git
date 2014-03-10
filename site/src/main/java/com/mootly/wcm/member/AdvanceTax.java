package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will take value from Tdsfromsalary.jsp and pass it to bean
 * 
 * I am adding this comment to test for the conflicts . It is new checkout project and nothing else has been changed in this file [PANKAJ]
 */
@PrimaryBean(primaryBeanClass = AdvanceTaxDocument.class)
@ChildBean(childBeanClass = AdvanceTaxDetail.class)
@FormFields(fieldNames = { "bsr_codeadv", "date_creditadv",
		"Serial_challanadv", "amountadv" })
@RequiredFields(fieldNames = { "bsr_codeadv", "date_creditadv",
		"Serial_challanadv", "amountadv" })
@DataTypeValidationFields(fieldNames = { "bsr_codeadv", "Serial_challanadv",
		"amountadv", "date_creditadv" }, dataTypes = {
		DataTypeValidationType.BSR, DataTypeValidationType.CHALLANNO,
		DataTypeValidationType.DECIMAL, DataTypeValidationType.INDIANDATE })
public class AdvanceTax extends ITReturnComponent {
	private static final Logger log = LoggerFactory
			.getLogger(TdsFromSalary.class);

	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if (log.isInfoEnabled()) {
			log.info("this is do before render of advance  tax");
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if (log.isInfoEnabled()) {
			log.info("this is do Action of advance  tax");
		}
	}
}
