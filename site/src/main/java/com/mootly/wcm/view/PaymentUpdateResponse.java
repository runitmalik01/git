package com.mootly.wcm.view;

import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentUpdateType;

public class PaymentUpdateResponse {
	final PaymentType paymentType;
	final String txnAmount;	
	final PaymentUpdateType paymentUpdateType;
	final boolean isSuccess;
	
	public PaymentUpdateResponse(PaymentUpdateType paymentUpdateType,PaymentType paymentType,String txnAmount,boolean isSuccess) {
		// TODO Auto-generated constructor stub
		this.paymentUpdateType = paymentUpdateType;
		this.paymentType = paymentType;
		this.txnAmount = txnAmount;
		this.isSuccess = isSuccess;
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

	public final boolean isSuccess() {
		return isSuccess;
	}
	
}
