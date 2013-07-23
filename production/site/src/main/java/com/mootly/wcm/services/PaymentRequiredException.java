package com.mootly.wcm.services;

import com.mootly.wcm.model.ValidationResponse;

public class PaymentRequiredException extends Exception {
	ValidationResponse validationResponse;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentRequiredException() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentRequiredException(ValidationResponse validationResponse) {
		// TODO Auto-generated constructor stub
		this.validationResponse = validationResponse;
	}

	public PaymentRequiredException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PaymentRequiredException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PaymentRequiredException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PaymentRequiredException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ValidationResponse getValidationResponse() {
		return validationResponse;
	}

	public void setValidationResponse(ValidationResponse validationResponse) {
		this.validationResponse = validationResponse;
	}
	
	

}
