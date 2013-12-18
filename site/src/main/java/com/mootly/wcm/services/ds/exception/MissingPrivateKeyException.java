package com.mootly.wcm.services.ds.exception;

/**
 * Accept only .pfx certificate
 * @author admin
 *
 */
public class MissingPrivateKeyException extends Exception {

	public MissingPrivateKeyException() {
		super();
	}
	
	public MissingPrivateKeyException(Exception ex) {
		super(ex);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

