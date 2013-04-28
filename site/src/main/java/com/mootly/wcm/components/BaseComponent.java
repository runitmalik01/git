/**
 * Copyright (C) 2010-2011 Hippo B.V.
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

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseComponent extends BaseHstComponent {
	private static final Logger log = LoggerFactory.getLogger(BaseComponent.class);
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        
        ComponentUtil.doRedirectionOnWrongLandingMount(request, response);
        
        request.setAttribute("preview", isPreview(request));
        request.setAttribute("composermode", request.getRequestContext().getResolvedMount().getMount().isOfType("composermode"));
        
        String cmsApplicationUrl = request.getRequestContext().getContainerConfiguration().getString("cms.location", "/cms/");
        request.setAttribute("cmsApplicationUrl", cmsApplicationUrl);
        
        request.setAttribute("loggedin", request.getUserPrincipal() != null);
        
        String theme = getParameter("theme",request);
        String template = getParameter("template",request);
        String bodyCssClass = getParameter("bodyCssClass",request);
        String contentCssClass = getParameter("contentCssClass",request);
        String widgetsCssClass = getParameter("widgetsCssClass",request);
//        if (log.isInfoEnabled()) {
//        	log.info("theme:" + theme);
//        	log.info("template:" + template);
//        	log.info("bodyCssClass:" + bodyCssClass);
//        	log.info("contentCssClass:" + contentCssClass);
//        	log.info("widgetsCssClass:" + widgetsCssClass);
//        }
        if (theme != null) request.setAttribute("theme", theme);
        if (template != null) request.setAttribute("template", template);
        if (bodyCssClass != null) request.setAttribute("bodyCssClass", bodyCssClass);
        if (contentCssClass != null) request.setAttribute("contentCssClass", contentCssClass);
        if (widgetsCssClass != null) request.setAttribute("widgetsCssClass", widgetsCssClass);
        
        HippoBean siteContentBaseBean = getSiteContentBaseBean(request);
        if (siteContentBaseBean != null) request.setAttribute("siteContentBaseBean", siteContentBaseBean);
    }
    
    protected void redirectToNotFoundPage(HstResponse response) {
        try {
            response.forward("/404");
        } catch (IOException e) {
            throw new HstComponentException(e);
        }
    }

}
