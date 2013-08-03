package com.mootly.wcm.validation;

public class HippoBeanValidationError  {
	String[] messageArgs = null;
	String message;
	
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
		this.message = message;
		// TODO Auto-generated constructor stub
	}

}
