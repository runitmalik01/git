package com.mootly.wcm.services.ds.exception;

/**
 * Accept only .pfx certificate
 * @author admin
 *
 */
public class MissingDigitalCertificateException extends Exception {

	public MissingDigitalCertificateException() {
		super();
	}
	
	public MissingDigitalCertificateException(Exception ex) {
		super(ex);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

