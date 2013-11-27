package org.onehippo.forge.security.support.springsecurity.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onehippo.forge.security.support.springsecurity.authentication.logout.HippoLogoutFilter;
import org.onehippo.forge.security.support.springsecurity.utils.SpringSecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class MootlyHippoLogoutFilter extends HippoLogoutFilter {

	public MootlyHippoLogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler... handlers) {
		super(logoutSuccessHandler, handlers);
	}

	public MootlyHippoLogoutFilter(String logoutSuccessUrl, LogoutHandler... handlers) {
		super(logoutSuccessUrl, handlers);
	}

	@Override
	protected boolean requiresLogout(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			if (authentication.getDetails() != null && authentication.getDetails() instanceof HippoMountDetail) {
				HippoMountDetail hippoMountDetail = (HippoMountDetail) authentication.getDetails();
	            if (hippoMountDetail != null) {
	            	  String resellerPrefix = "/r/" + hippoMountDetail.getResellerId();
	            	  String strToCheck = "";
	            	  String uriToCheck = "";
	            	  if (request.getContextPath() != null) {
	            		  strToCheck = request.getContextPath();
	            		  uriToCheck = request.getContextPath();
	            	  }
	            	  uriToCheck += "/r/";
	            	  strToCheck +=  resellerPrefix;
	            	  if (uri.startsWith(uriToCheck) && !uri.startsWith(strToCheck)) {
	            		  return true;
	            	  }
	            }
			}
		}
		int pathParamIndex = uri.indexOf(';');

		if (pathParamIndex > 0) {
			// strip everything from the first semi-colon
			uri = uri.substring(0, pathParamIndex);
		}

		int queryParamIndex = uri.indexOf('?');

		if (queryParamIndex > 0) {
			// strip everything from the first question mark
			uri = uri.substring(0, queryParamIndex);
		}

		if ("".equals(request.getContextPath())) {
			return uri.endsWith(getFilterProcessesUrl());
		}

		SpringSecurityUtils springSecurityUtils = new SpringSecurityUtils();
		String requestPath = request.getServletPath();

		if (!StringUtils.contains(requestPath, getFilterProcessesUrl())) {
			return false;
		}


		if (springSecurityUtils.requestComesFromCms(request)) {
			requestPath = springSecurityUtils.getCmsPreviewPrefix()  + getFilterProcessesUrl();
		}

		return uri.endsWith(requestPath);
	}

}
