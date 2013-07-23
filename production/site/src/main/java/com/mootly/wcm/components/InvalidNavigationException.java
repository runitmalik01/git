package com.mootly.wcm.components;

public class InvalidNavigationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidNavigationException () {
		super();			
	}
	
	public InvalidNavigationException(String message) {
		super(message);
	}
	
	public InvalidNavigationException(Throwable cause) {
		super(cause);
	}
	
	public InvalidNavigationException(String message,Throwable cause) {
		super(message,cause);
	}
}
