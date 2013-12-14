package com.mootly.wcm.validation;

public abstract class HippoBeanValidationGeneric  {
	public enum ACTION {DISPLAY_NOTICE,REDIRECT,DISPLAY_DIALOG}
	public enum REDIRECT_TARGET {REF_ID,ABSOLUTE_URL,RELATIVE_URL};
	String[] messageArgs = null;
	String message;
	
	ACTION action;
	
	public String[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(String[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	
	public HippoBeanValidationGeneric() {
		// TODO Auto-generated constructor stub
	}

	public HippoBeanValidationGeneric(String message) {
		this.message = message;
		// TODO Auto-generated constructor stub
	}

}
