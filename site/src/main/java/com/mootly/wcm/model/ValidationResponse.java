package com.mootly.wcm.model;

public class ValidationResponse {
	boolean isValid;
	String errors;
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	
	
}
