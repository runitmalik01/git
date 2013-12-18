package com.mootly.wcm.services.ds.exception;

/**
 * Accept only .pfx certificate
 * @author admin
 *
 */
public class InvalidDigitalSignatureException extends Exception {

	public InvalidDigitalSignatureException() {
		super();
	}
	
	public InvalidDigitalSignatureException(Exception ex) {
		super(ex);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

