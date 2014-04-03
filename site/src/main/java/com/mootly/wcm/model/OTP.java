package com.mootly.wcm.model;

import java.util.Calendar;

/**
 * One time password
 * @author Amit
 *
 */
public class OTP {
	
	final String token;
	final Calendar timeGeneration;
	final Calendar timeExpiration;
	
	public OTP(String token,Calendar timeGeneration,Calendar timeExpiration) {
		this.token = token;
		this.timeGeneration = timeGeneration;
		this.timeExpiration = timeExpiration;
	}

	public boolean isExpired() {
		return timeExpiration.after(timeGeneration);
	}

	public String getToken() {
		return token;
	}

	public Calendar getTimeGeneration() {
		return timeGeneration;
	}

	public Calendar getTimeExpiration() {
		return timeExpiration;
	}
}
