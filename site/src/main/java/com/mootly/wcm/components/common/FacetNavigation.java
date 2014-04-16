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

package com.mootly.wcm.components.common;

import org.apache.cxf.common.util.StringUtils;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFacetChildNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoFacetNavigationBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.hippoecm.hst.util.PathUtils;
import org.hippoecm.hst.util.SearchInputParsingUtils;
import org.hippoecm.hst.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnInitData;

public class FacetNavigation extends BaseComponent {

    public static final Logger log = LoggerFactory.getLogger(FacetNavigation.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        ITReturnInitData itReturnInitData = getITRInitData(request);
        HippoBean scope = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
        
        
        String query = this.getPublicRequestParameter(request, "query");
        if (query != null) {
            query = SearchInputParsingUtils.parse(query, false);
            request.setAttribute("query", query);
        }

        String order = this.getPublicRequestParameter(request, "order");
        if (order != null) {
            request.setAttribute("order", order);
        }
       
        ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
        String resolvedContentPath = PathUtils.normalizePath(resolvedSiteMapItem.getRelativeContentPath());
        HippoFacetChildNavigationBean resolvedContentBean = null;
        
        HippoFacetNavigationBean facNavBean = null;
        
        String scopeRelativePath = request.getRequestContext().getResolvedSiteMapItem().getParameter("scopeRelativePath");
        String facetedNavLocation = getParameter("facetnav.location", request);
        if (scopeRelativePath != null && facetedNavLocation == null) {
        	String theRelativePath =  (scope.getCanonicalPath() + "/" + scopeRelativePath).substring(getSiteContentBaseBean(request).getCanonicalPath().length()-1);
        	resolvedContentPath = scopeRelativePath + "/searchfacets";
        	
        	facNavBean = BeanUtils.getFacetNavigationBean(request, "resellers/" + itReturnInitData.getResellerId() + "/" + scopeRelativePath  + "/searchfacets", query, objectConverter);
        }
        // when the resolved sitemap item is /search, resolved content path can be null...
        ///content/documents/mootlywcm/resellers/w4india/documents/knowledgearticles/searchfacets

        if (!StringUtils.isEmpty(resolvedContentPath)) {
            //resolvedContentBean = getITRInitData(request).getSiteContentBaseBeanForReseller(request).getBean("documents/knowledgearticles/searchfacets", HippoFacetChildNavigationBean.class);
        }

        if (facNavBean == null) {
            // perform a free text search within the facet indicated by the component parameter 'facetnav.location'
            //String facetedNavLocation = getParameter("facetnav.location", request);
            if (facetedNavLocation == null) {
                log.warn("Please configure the 'facetnav.location' component parameter.");
                return;
            }
            facNavBean = BeanUtils.getFacetNavigationBean(request, facetedNavLocation, query, getObjectConverter());
        }

        request.setAttribute("facetnav", facNavBean);

        if (facNavBean instanceof HippoFacetChildNavigationBean) {
            request.setAttribute("childNav", "true");
        }
    }
}
