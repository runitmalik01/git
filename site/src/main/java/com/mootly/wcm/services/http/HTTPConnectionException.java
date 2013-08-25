package com.mootly.wcm.services.http;

public final class HTTPConnectionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int responseCode;
	String responseMessage;
	String theCompleteMessage;
	
	
	public HTTPConnectionException() {
		// TODO Auto-generated constructor stub
	}

	public HTTPConnectionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HTTPConnectionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HTTPConnectionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HTTPConnectionException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public final int getResponseCode() {
		return responseCode;
	}

	public final void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public final String getResponseMessage() {
		return responseMessage;
	}

	public final void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public final String getTheCompleteMessage() {
		return theCompleteMessage;
	}

	public final void setTheCompleteMessage(String theCompleteMessage) {
		this.theCompleteMessage = theCompleteMessage;
	}
	

}
