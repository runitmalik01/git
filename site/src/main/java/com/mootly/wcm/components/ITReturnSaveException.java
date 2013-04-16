package com.mootly.wcm.components;

public class ITReturnSaveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ITReturnSaveException () {
		super();			
	}
	
	public ITReturnSaveException(String message) {
		super(message);
	}
	
	public ITReturnSaveException(Throwable cause) {
		super(cause);
	}
	
	public ITReturnSaveException(String message,Throwable cause) {
		super(message,cause);
	}
}
