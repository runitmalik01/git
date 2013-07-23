package com.mootly.wcm.components;

public class InvalidPANException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidPANException () {
		super();			
	}
	
	public InvalidPANException(String message) {
		super(message);
	}
	
	public InvalidPANException(Throwable cause) {
		super(cause);
	}
	
	public InvalidPANException(String message,Throwable cause) {
		super(message,cause);
	}
}
