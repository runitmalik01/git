package com.mootly.wcm.services;

import com.mootly.wcm.model.ValidationResponse;

public class InvalidXMLException extends Exception {
	ValidationResponse validationResponse;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidXMLException() {
		// TODO Auto-generated constructor stub
	}
	
	public InvalidXMLException(ValidationResponse validationResponse) {
		// TODO Auto-generated constructor stub
		this.validationResponse = validationResponse;
	}

	public InvalidXMLException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidXMLException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidXMLException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidXMLException(String message, Throwable cause,
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
