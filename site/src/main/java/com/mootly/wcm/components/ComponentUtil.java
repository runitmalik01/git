/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.components;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.configuration.hosting.Mount;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.hst.core.linking.HstLinkCreator;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.hippoecm.hst.core.request.ResolvedMount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.utils.UserAgentUtils;

public final class ComponentUtil {
    
    private static final Logger log = LoggerFactory.getLogger(BaseComponent.class);

    private static final String DEFAULT_MOUNT_TYPE_MOBILE = "mobile";
    private static final String DEFAULT_MOUNT_ALIAS_MOBILE = "mobile";
    
    private static final String REDIRECTION_ON_WRONG_LANDING_MOUNT_DONE_ATTR = ComponentUtil.class.getName() + ".redirectionOnWrongLandingMount.done";
    
    private ComponentUtil() {
        
    }
    
    public static int parseIntParameter(String name, String value, int defaultValue, Logger log) {
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                log.warn("Illegal value for parameter '" + name + "': " + value);
            }
        }
        return defaultValue;
    }
    
    public static boolean parseAscendingParameter(String name, String value, boolean defaultValue, Logger log) {
        if ("ascending".equals(value)) {
            return true;
        } else if ("descending".equals(value)) {
            return false;
        } else if (value != null && value.trim().length() > 0) {
            log.warn("Illegal value for parameter '" + name + "': " + value);
        }
        return defaultValue;
    }
    
    public static boolean doRedirectionOnWrongLandingMount(HstRequest request, HstResponse response,String resellerId) {
        HstRequestContext requestContext = request.getRequestContext();
        
        if (requestContext.getAttribute(REDIRECTION_ON_WRONG_LANDING_MOUNT_DONE_ATTR) != null) {
            return false;
        }
        
        requestContext.setAttribute(REDIRECTION_ON_WRONG_LANDING_MOUNT_DONE_ATTR, Boolean.TRUE);
        
        boolean isMobileUserAgent = UserAgentUtils.isMobile(request);
        ResolvedMount resolvedMount = requestContext.getResolvedMount();
        boolean isMountForMobile = resolvedMount.getMount().isOfType(DEFAULT_MOUNT_TYPE_MOBILE);
        
        if (!isMountForMobile) {
            for (String type : resolvedMount.getMount().getTypes()) {
                if (StringUtils.contains(type, DEFAULT_MOUNT_TYPE_MOBILE)) {
                    isMountForMobile = true;
                    break;
                }
            }
        }
        
        if (isMobileUserAgent && !isMountForMobile) {
            if (log.isDebugEnabled()) {
                log.debug("Redirecting to mobile mount for User-Agent: '{}'.", request.getHeader("User-Agent"));
            }
            sendRedirectToMount(request, response, DEFAULT_MOUNT_ALIAS_MOBILE);
        }
        else if (resellerId != null && !resolvedMount.getMount().getAlias().equals(resellerId)) {
        	String shouldNotRedirectToProperMount = request.getRequestContext().getResolvedSiteMapItem().getParameter("shouldNotRedirectToProperMount");
        	if (shouldNotRedirectToProperMount != null && "true".equals(shouldNotRedirectToProperMount)) {
        		try {
					response.forward("/404");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	return false;
        	}
        	else {
        		sendRedirectToMount(request, response, resellerId);
        	}
        }
        return true;
    }
    
    public static void sendRedirectToMount(HstRequest request, HstResponse response, String alias) {
        HstRequestContext requestContext = request.getRequestContext();
        Mount mount = requestContext.getMount(alias);
        
        if (mount == null) {
            log.warn("Cannot find a mount by alias, '{}'. Redirection is skipped.", alias);
            return;
        }
        
        if (requestContext.getResolvedMount().getMount().equals(mount)) {
            log.warn("Already in the same mount by alias, '{}'. Redirection is skipped.", alias);
            return;
        }
        
        HstLinkCreator linkCreator = requestContext.getHstLinkCreator();
        String pathInfo = requestContext.getResolvedSiteMapItem().getPathInfo();
        HstLink link = linkCreator.create(pathInfo, mount);
        
        if (link == null) {
            log.warn("Cannot create a link with the mount aliased '{}'. Redirection is skipped.", alias);
            return;
        }
        
        String urlString = link.toUrlForm(requestContext, false);
        
        if (urlString == null) {
            log.warn("Cannot generate a link url with the mount aliased '{}'. Redirection is skipped.", alias);
            return;
        }
        
    	response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    	response.setHeader( "Location", urlString);
    	response.setHeader( "Connection", "close" );
            //response.sendRedirect(urlString);
    }

}
