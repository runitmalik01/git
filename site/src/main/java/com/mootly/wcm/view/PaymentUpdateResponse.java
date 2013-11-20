package com.mootly.wcm.view;

import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentUpdateType;

public class PaymentUpdateResponse {
	final PaymentType paymentType;
	final String txnAmount;	
	final PaymentUpdateType paymentUpdateType;
	
	public PaymentUpdateResponse(PaymentUpdateType paymentUpdateType,PaymentType paymentType,String txnAmount) {
		// TODO Auto-generated constructor stub
		this.paymentUpdateType = paymentUpdateType;
		this.paymentType = paymentType;
		this.txnAmount = txnAmount;
	}

	public final PaymentType getPaymentType() {
		return paymentType;
	}

	public final String getTxnAmount() {
		return txnAmount;
	}

	public final PaymentUpdateType getPaymentUpdateType() {
		return paymentUpdateType;
	}
	
}
