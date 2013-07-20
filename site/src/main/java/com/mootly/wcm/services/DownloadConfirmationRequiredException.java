package com.mootly.wcm.services;

import com.mootly.wcm.model.ValidationResponse;

public class DownloadConfirmationRequiredException extends Exception {
	ValidationResponse validationResponse;
	
	String uuidOfSavedForm;
	String htmlSummary;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DownloadConfirmationRequiredException() {
		// TODO Auto-generated constructor stub
	}
	
	public DownloadConfirmationRequiredException(ValidationResponse validationResponse) {
		// TODO Auto-generated constructor stub
		this.validationResponse = validationResponse;
	}

	public DownloadConfirmationRequiredException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DownloadConfirmationRequiredException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DownloadConfirmationRequiredException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DownloadConfirmationRequiredException(String message, Throwable cause,
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

	public String getUuidOfSavedForm() {
		return uuidOfSavedForm;
	}

	public void setUuidOfSavedForm(String uuidOfSavedForm) {
		this.uuidOfSavedForm = uuidOfSavedForm;
	}

	public String getHtmlSummary() {
		return htmlSummary;
	}

	public void setHtmlSummary(String htmlSummary) {
		this.htmlSummary = htmlSummary;
	}
	
	
	

}
