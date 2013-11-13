package com.mootly.wcm.beans.events;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.compound.InvoiceRefundDetail;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.citruspay.model.enquiry.EnquiryResponse;

/**
 * 
 * @author admin
 *
 */
public final class InvoicePaymentEnquiryHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean> {

		final EnquiryResponse enquiryResponse;
		final String paymentTransactionId;
		final PaymentType paymentType;

		public InvoicePaymentEnquiryHandler(EnquiryResponse enquiryResponse,String paymentTransactionId, PaymentType paymentType) {
			this.enquiryResponse = enquiryResponse;
			this.paymentTransactionId = paymentTransactionId;
			this.paymentType = paymentType;
		}

		@Override
		public void beforeFillChildBeanMap(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			if (hippoBean instanceof InvoicePaymentDetail) {
				InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) hippoBean;
				if (enquiryResponse.getTxnType().equals("SALE")) {
					invoicePaymentDetail.setRespCodeStr(enquiryResponse.getRespCode().name());
					invoicePaymentDetail.setRespMsg(enquiryResponse.getRespMsg());
					invoicePaymentDetail.setRespCode(enquiryResponse.getRespCode());
					if (enquiryResponse.getPgTxnId() != null) invoicePaymentDetail.setPgTxnId(enquiryResponse.getPgTxnId());
					invoicePaymentDetail.setTxnAmount(Double.valueOf(enquiryResponse.getAmount()));
					invoicePaymentDetail.setRrn(enquiryResponse.getRRN());
					invoicePaymentDetail.setAuthIdCode(enquiryResponse.getAuthIdCode());
					invoicePaymentDetail.setTxnDateTime(enquiryResponse.getTxnDateTime());
					//this has been verified
					invoicePaymentDetail.setPaymentVerificationStatusStr(PaymentVerificationStatus.VERIFIED.name());
				}
			}
			else if (hippoBean instanceof InvoiceRefundDetail) {
				InvoiceRefundDetail invoiceRefundDetail = (InvoiceRefundDetail) hippoBean;
				if (enquiryResponse.getTxnType().equals("REFUND")) {
					invoiceRefundDetail.setPaymentTransactionId(paymentTransactionId);
					invoiceRefundDetail.setPaymentType(paymentType);
					if (enquiryResponse.getRespMsg() != null) invoiceRefundDetail.setRespMsg(enquiryResponse.getRespMsg());
					//if (enquiryResponse.getRespCode() != null) invoiceRefundDetail.setRespCode(enquiryResponse.getRespCode());
					if (enquiryResponse.getAmount() != null) invoiceRefundDetail.setTxnAmount(Double.valueOf(enquiryResponse.getAmount()));
					if (enquiryResponse.getPgTxnId() != null) invoiceRefundDetail.setPgTxnId(enquiryResponse.getPgTxnId());
					if (enquiryResponse.getRRN() != null) invoiceRefundDetail.setRrn(enquiryResponse.getRRN());
					if (enquiryResponse.getAuthIdCode() != null) invoiceRefundDetail.setAuthIdCode(enquiryResponse.getAuthIdCode());
					invoiceRefundDetail.setTxnDateTime(enquiryResponse.getTxnDateTime());
					invoiceRefundDetail.setPaymentVerificationStatusStr(PaymentVerificationStatus.VERIFIED.name());
					//if (enquiryResponse.getRespCode() != null) invoiceRefundDetail.setRespCodeStr(enquiryResponse.getRespCode().name());
				}
			}
		}
}
