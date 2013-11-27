package org.onehippo.forge.security.support.springsecurity.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.onehippo.forge.security.support.springsecurity.utils.SpringSecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class MootlySimpleUrlAuthenticationSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler{

	 protected final Log logger = LogFactory.getLog(getClass());
	 public static final String WEB_ATTRIBUTE_RESELLER_PATH = "webResellerPath";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		clearAuthenticationAttributes(request);

		// Use the DefaultSavedRequest URL
		SpringSecurityUtils springSecurityUtils = new SpringSecurityUtils();
		String determinedTargetURL = determineTargetUrl(request, response);
		if (authentication != null && authentication.getDetails() != null && authentication.getDetails() instanceof HippoMountDetail) {
			HippoMountDetail hippoMountDetail = (HippoMountDetail) authentication.getDetails();
			String resellerId = hippoMountDetail.getResellerId();
			Boolean isReseller = hippoMountDetail.getIsReseller();
			if (isReseller) {
				determinedTargetURL = "/r/" + resellerId + determinedTargetURL;
				String resellerPrefix = "/r/" + resellerId;
				HttpSession session = request.getSession(true);
	            if (session != null) {
	                request.getSession().setAttribute(WEB_ATTRIBUTE_RESELLER_PATH, resellerPrefix);
	            }
			}
			if (logger.isInfoEnabled()) {
				logger.info("resellerId:" + resellerId);
				logger.info("isReseller:" + isReseller);
			}
		}
		String targetUrl = springSecurityUtils.buildRedirectUrl(determinedTargetURL ,  request);

		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}
}
