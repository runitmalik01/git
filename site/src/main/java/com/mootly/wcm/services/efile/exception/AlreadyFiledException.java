package com.mootly.wcm.services.efile.exception;

/**
 * Accept only .pfx certificate
 * @author admin
 *
 */
public class AlreadyFiledException extends Exception {

	public AlreadyFiledException() {
		super();
	}
	
	public AlreadyFiledException(Exception ex) {
		super(ex);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

