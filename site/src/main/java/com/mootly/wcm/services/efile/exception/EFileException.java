package com.mootly.wcm.services.efile.exception;

/**
 * Accept only .pfx certificate
 * @author admin
 *
 */
public class EFileException extends Exception {

	/**
	 * 
	 */
	public EFileException() {
		super();
	}
	
	/**
	 * 
	 * @param ex
	 */
	public EFileException(Exception ex) {
		super(ex);
	}
	
	/**
	 * 
	 * @param message
	 */
	public EFileException(String message) {
		super(message);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

