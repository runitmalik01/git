package com.mootly.wcm.member;


import java.awt.PageAttributes;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.services.SequenceGenerator;

/**
 * 
 * @author admin
 *
 */
@PrimaryBean(primaryBeanClass=InvoiceDocument.class)
@ChildBean(childBeanClass=InvoiceDocumentDetail.class)
@FormFields(fieldNames={})
@RequiredFields(fieldNames={})
@DataTypeValidationFields(fieldNames={},dataTypes={})
public class MemberInvoice extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(MemberInvoice.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of clubbing of income");
		}

	}
	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	} 
	
	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		super.beforeSave(request);
		FormMap existingMap = getFormMap();
		PAGE_ACTION pageAction = getPageAction();
		SequenceGenerator sequenceGenerator = getSequenceGenerator();
		if (pageAction != null && pageAction == PAGE_ACTION.NEW_CHILD) {
			FormField invoiceNumberField = new FormField("invoiceNumber");
			Long invoiceNumber = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_INVOICE);
			invoiceNumberField.addValue(String.valueOf(invoiceNumber));
			existingMap.addFormField(invoiceNumberField);
		}
		return true;
	}
}




