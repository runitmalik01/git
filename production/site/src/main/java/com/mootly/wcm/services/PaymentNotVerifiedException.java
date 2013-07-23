package com.mootly.wcm.services;

import com.mootly.wcm.model.ValidationResponse;

public class PaymentNotVerifiedException extends Exception {
	ValidationResponse validationResponse;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentNotVerifiedException() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentNotVerifiedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PaymentNotVerifiedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PaymentNotVerifiedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PaymentNotVerifiedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
