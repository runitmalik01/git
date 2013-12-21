package com.mootly.wcm.services.efile.exception;

/**
 * Accept only .pfx certificate
 * @author admin
 *
 */
public class DigtalSignatureAssesseeFailure extends Exception {

	/**
	 * 
	 */
	public DigtalSignatureAssesseeFailure() {
		super();
	}
	
	/**
	 * 
	 * @param ex
	 */
	public DigtalSignatureAssesseeFailure(Exception ex) {
		super(ex);
	}
	
	/**
	 * 
	 * @param message
	 */
	public DigtalSignatureAssesseeFailure(String message) {
		super(message);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

