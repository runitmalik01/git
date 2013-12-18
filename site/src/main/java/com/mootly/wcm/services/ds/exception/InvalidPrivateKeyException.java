package com.mootly.wcm.services.ds.exception;

/**
 * Accept only .pfx certificate
 * @author admin
 *
 */
public class InvalidPrivateKeyException extends Exception {

	public InvalidPrivateKeyException() {
		super();
	}
	
	public InvalidPrivateKeyException(Exception ex) {
		super(ex);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

