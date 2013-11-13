package com.mootly.wcm.beans.events;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.services.SequenceGenerator;

public class InvoiceDocumentBeanHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean> {

	final SequenceGenerator sequenceGenerator;
	public InvoiceDocumentBeanHandler(SequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}
	@Override
	public void afterCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//SequenceGenerator sequenceGenerator = getSequenceGenerator();
		Long invoiceNumber = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_INVOICE);
		if (hippoBean != null && hippoBean instanceof InvoiceDocument) {
			InvoiceDocument invoiceDocument = (InvoiceDocument) hippoBean;
			invoiceDocument.setInvoiceNumber(String.valueOf(invoiceNumber));
		}
	}
}
