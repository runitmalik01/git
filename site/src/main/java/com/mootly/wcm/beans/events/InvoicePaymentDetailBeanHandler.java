package com.mootly.wcm.beans.events;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;

import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.PaymentType;

public class InvoicePaymentDetailBeanHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean>{
	final PaymentType paymentType;
	final String strPaymentTransactionId;
	final HstRequest hstRequest;
	
	public InvoicePaymentDetailBeanHandler(PaymentType paymentType,HstRequest hstRequest,String strPaymentTransactionId) {
		this.paymentType = paymentType;
		this.hstRequest = hstRequest;
		this.strPaymentTransactionId = strPaymentTransactionId;
	}
	
	public final String getStrPaymentTransactionId() {
		return strPaymentTransactionId;
	}

	@Override
	public void afterCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//SequenceGenerator sequenceGenerator = getSequenceGenerator();
		if (hippoBean != null && hippoBean instanceof InvoicePaymentDetail) {
			InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) hippoBean;
			invoicePaymentDetail.setPaymentTransactionId(strPaymentTransactionId);
			invoicePaymentDetail.setPaymentType(paymentType);
			invoicePaymentDetail.setPaymentDate(IndianGregorianCalendar.getCurrentDateInIndiaAsDate());
			InvoiceDocument invoiceDocument = (InvoiceDocument) hstRequest.getAttribute("parentBean");
			if (invoiceDocument != null ) {
				invoicePaymentDetail.setPaymentAmount(invoiceDocument.getAmountDue());
			}
		}
	}
	
	//Updates the payment details(txnAmount) after Vendor Verification
	@Override
	public void afterFillChildBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		//super.afterFillChildBeanMap(hippoBean);
		if (hippoBean != null && hippoBean instanceof InvoicePaymentDetail) {
			InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) hippoBean;
			InvoiceDocument invoiceDocument = (InvoiceDocument) hstRequest.getAttribute("parentBean");
			if (invoiceDocument != null ) {
				//invoicePaymentDetail.setPaymentAmount(invoiceDocument.getAmountDue());
				invoicePaymentDetail.setTxnAmount(invoiceDocument.getAmountDue());
				
			}
		}
	}
}
