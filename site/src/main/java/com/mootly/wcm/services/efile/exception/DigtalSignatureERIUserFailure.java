package com.mootly.wcm.services.efile.exception;

/**
 * Accept only .pfx certificate
 * @author admin
 *
 */
public class DigtalSignatureERIUserFailure extends Exception {

	/**
	 * 
	 */
	public DigtalSignatureERIUserFailure() {
		super();
	}
	
	/**
	 * 
	 * @param ex
	 */
	public DigtalSignatureERIUserFailure(Exception ex) {
		super(ex);
	}
	
	/**
	 * 
	 * @param message
	 */
	public DigtalSignatureERIUserFailure(String message) {
		super(message);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

