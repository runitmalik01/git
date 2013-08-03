package com.mootly.wcm.validation;

public class HippoBeanValidationError extends Exception {
	String[] messageArgs = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(String[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	
	public HippoBeanValidationError() {
		// TODO Auto-generated constructor stub
	}

	public HippoBeanValidationError(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HippoBeanValidationError(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HippoBeanValidationError(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HippoBeanValidationError(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
