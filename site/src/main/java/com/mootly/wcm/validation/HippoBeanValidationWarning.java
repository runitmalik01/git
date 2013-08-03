package com.mootly.wcm.validation;

public class HippoBeanValidationWarning extends Exception {
	String[] messageArgs = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HippoBeanValidationWarning() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(String[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	public HippoBeanValidationWarning(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HippoBeanValidationWarning(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HippoBeanValidationWarning(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HippoBeanValidationWarning(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
