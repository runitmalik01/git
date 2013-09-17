package org.onehippo.forge.security.support.springsecurity.authentication;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class MootlyWebAuthenticationDetails extends WebAuthenticationDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Logger log = LoggerFactory.getLogger(HippoUserDetailsServiceImpl.class);
	
	private String mountIdentifier = null;
	public MootlyWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		mountIdentifier = request.getParameter("c");
	}
	

	public final String getMountIdentifier() {
		return mountIdentifier;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
