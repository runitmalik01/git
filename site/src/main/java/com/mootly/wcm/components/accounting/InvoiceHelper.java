package com.mootly.wcm.components.accounting;

import org.hippoecm.hst.core.component.HstRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.compound.InvoiceRefundDetail;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentVerificationStatus;

public final class InvoiceHelper {
	final static Logger log = LoggerFactory.getLogger(InvoiceHelper.class);
	/**
	 * public final String PROP_PG_TXN_ID = "mootlywcm:pgTxnId";
	 * public final String PROP_AUTH_ID_CODE = "mootlywcm:authIdCode";
	 * public final String PROP_RRN = "mootlywcm:rrn";
	 * @param request
	 * @param pgTxnId
	 * @param authIdCode
	 * @param rrn
	 * @return
	 */
	public static boolean refundExists(HstRequest request,PaymentType paymentType, String paymentTransactionId, String pgTxnId,String authIdCode,String rrn,InvoiceDocument invoiceDocument) {
		
		if (invoiceDocument == null || invoiceDocument.getInvoiceRefundDetailList() == null  || invoiceDocument.getInvoiceRefundDetailList().size() == 0 ) {
			return false;
		}
		
		for (InvoiceRefundDetail invoiceRefundDetail:invoiceDocument.getInvoiceRefundDetailList() ) {
			boolean condition1 = ( invoiceRefundDetail.getPaymentVerificationStatus() != null &&  invoiceRefundDetail.getPaymentVerificationStatus() == PaymentVerificationStatus.VERIFIED);
			boolean condition2 = (invoiceRefundDetail.getPaymentType() == paymentType);
			boolean condition3 = invoiceRefundDetail.getPaymentTransactionId().equals(paymentTransactionId);
			boolean condition4 = invoiceRefundDetail.getPgTxnId().equals(pgTxnId);
			boolean condition5 = invoiceRefundDetail.getAuthIdCode().equals(authIdCode);
			boolean condition6 =  invoiceRefundDetail.getRrn().equals(rrn);
			if (log.isInfoEnabled()) {
				log.info("Condition1:"+  condition1);
				log.info("Condition2:"+  condition2);
				log.info("Condition3:"+  condition3);
				log.info("Condition4:"+  condition4);
				log.info("Condition5:"+  condition5);
				log.info("Condition6:"+  condition6);
			}
			if ( condition1 && condition2 && condition3 && condition4 && condition5 && condition6) {
				if (log.isInfoEnabled()) {
					log.info("Condition true for " + invoiceRefundDetail.toString());
				}
				return true;
			}
		}
		return false;	
	}
}
