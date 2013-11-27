/**
 * 
 */
package org.onehippo.forge.security.support.springsecurity.authentication;

import org.springframework.security.core.AuthenticationException;

/**
 * @author admin
 *
 */
public final class MootlyAuthenticationException extends
		AuthenticationException {
	
	HippoMountDetail hippoMountDetail;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 */
	public MootlyAuthenticationException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param msg
	 * @param t
	 */
	public MootlyAuthenticationException(String msg, Throwable t) {
		super(msg, t);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param msg
	 * @param extraInformation
	 */
	public MootlyAuthenticationException(String msg, Object extraInformation) {
		super(msg, extraInformation);
		// TODO Auto-generated constructor stub
	}

}
