package com.mootly.wcm.validation;

public class HippoBeanValidationWarning {
	
	String[] messageArgs = null;
	String message;
	
	public HippoBeanValidationWarning() {
		// TODO Auto-generated constructor stub
	}
	
	public HippoBeanValidationWarning(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	
	public String[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(String[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
