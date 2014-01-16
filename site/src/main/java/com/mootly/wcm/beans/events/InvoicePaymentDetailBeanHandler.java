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
	final boolean isSavedByVendor;
	final boolean isGatewayForm;

	public InvoicePaymentDetailBeanHandler(PaymentType paymentType,HstRequest hstRequest,String strPaymentTransactionId,boolean isSavedByVendor,boolean isGatewayForm) {
		this.paymentType = paymentType;
		this.hstRequest = hstRequest;
		this.strPaymentTransactionId = strPaymentTransactionId;
		this.isSavedByVendor = isSavedByVendor;
		this.isGatewayForm = isGatewayForm;
	}
	
	public final PaymentType getPaymentType() {
		return paymentType;
	}



	public final HstRequest getHstRequest() {
		return hstRequest;
	}



	public final boolean isSavedByVendor() {
		return isSavedByVendor;
	}



	public final boolean isGatewayForm() {
		return isGatewayForm;
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
			InvoiceDocument invoiceDocument = (InvoiceDocument) hstRequest.getAttribute("parentBean");
			invoicePaymentDetail.setPaymentDate(IndianGregorianCalendar.getCurrentDateInIndiaAsDate());
			if (invoiceDocument != null ) {	
				//invoicePaymentDetail.setPaymentAmount(invoiceDocument.getAmountDue());
			}
		}
	}

	//Updates Payment Amount as user-input amount from PaymentType Screen
	
	@Override
	public void afterFillChildBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		//super.afterFillChildBeanMap(hippoBean);
		if (hippoBean != null && hippoBean instanceof InvoicePaymentDetail) {
			InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) hippoBean;
			InvoiceDocument invoiceDocument = (InvoiceDocument) hstRequest.getAttribute("parentBean");
			if (invoiceDocument != null ) {
				if(invoicePaymentDetail.getPaymentType() == PaymentType.CASH){
					invoicePaymentDetail.setPaymentAmount(invoicePaymentDetail.getCashAmount());
					//	System.out.println("CASH:::"+invoicePaymentDetail.getPaymentAmount());

				}
				else if(invoicePaymentDetail.getPaymentType() == PaymentType.CHECK){
					invoicePaymentDetail.setPaymentAmount(invoicePaymentDetail.getCheckAmount());
					//System.out.println("CHEQUE:::"+invoicePaymentDetail.getPaymentAmount());
				}
				else if(invoicePaymentDetail.getPaymentType() == PaymentType.RTGS){
					invoicePaymentDetail.setPaymentAmount(invoicePaymentDetail.getRtgsAmount());
					//	System.out.println("RTGS:::"+invoicePaymentDetail.getPaymentAmount());
				}
				
				if (isSavedByVendor) {
					if (invoicePaymentDetail.getVendor_txnAmount() != null) {
						invoicePaymentDetail.setTxnAmount(invoicePaymentDetail.getVendor_txnAmount());
					}
					if (invoicePaymentDetail.getPaymentVerificationStatusStr()!= null) {
						invoicePaymentDetail.setPaymentVerificationStatusStr(invoicePaymentDetail.getPaymentVerificationStatusStr());
					}
				}
				//let the amount due be the paymentAmount
				if (invoicePaymentDetail.getPaymentType().getRequiresGateway()) {
					invoicePaymentDetail.setPaymentAmount( invoiceDocument.getAmountDue() );
				}
				//invoicePaymentDetail.setTxnAmount(invoiceDocument.getAmountDue());				
			}
		}
	}
}
