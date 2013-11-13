package com.mootly.wcm.beans.events;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;

import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.services.SequenceGenerator;

public class InvoicePaymentDetailBeanHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean>{
	final PaymentType paymentType;
	String strPaymentTransactionId = null;
	final HstRequest hstRequest;
	final SequenceGenerator sequenceGenerator;
	
	public InvoicePaymentDetailBeanHandler(PaymentType paymentType,HstRequest hstRequest,SequenceGenerator sequenceGenerator) {
		this.paymentType = paymentType;
		this.hstRequest = hstRequest;
		this.sequenceGenerator = sequenceGenerator;
	}
	
	public final String getStrPaymentTransactionId() {
		return strPaymentTransactionId;
	}

	@Override
	public void afterCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//SequenceGenerator sequenceGenerator = getSequenceGenerator();
		Long paymentTransactionId = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_PAYMENT);
		if (hippoBean != null && hippoBean instanceof InvoicePaymentDetail) {
			InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) hippoBean;
			strPaymentTransactionId = String.valueOf(paymentTransactionId);
			invoicePaymentDetail.setPaymentTransactionId(strPaymentTransactionId);
			invoicePaymentDetail.setPaymentType(paymentType);
			invoicePaymentDetail.setPaymentDate(IndianGregorianCalendar.getCurrentDateInIndiaAsDate());
			InvoiceDocument invoiceDocument = (InvoiceDocument) hstRequest.getAttribute("parentBean");
			if (invoiceDocument != null ) {
				invoicePaymentDetail.setPaymentAmount(invoiceDocument.getAmountDue());
			}
		}
	}
}
