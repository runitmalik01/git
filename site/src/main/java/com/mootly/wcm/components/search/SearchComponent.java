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

package com.mootly.wcm.components.search;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

public class SearchComponent extends AbstractSearchComponent {

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        String strShowFacetedDocuments = request.getRequestContext().getResolvedSiteMapItem().getLocalParameter("showFacetedDocuments");
        String strShowTaggedDocuments = request.getRequestContext().getResolvedSiteMapItem().getLocalParameter("showTaggedDocuments");
        Boolean paramShowFacetedDocuments = false;
        Boolean paramShowTaggedDocuments = false;
        if (strShowFacetedDocuments != null) {
        	paramShowFacetedDocuments = Boolean.valueOf(strShowFacetedDocuments);
        }
        if (strShowTaggedDocuments != null) {
        	paramShowTaggedDocuments = Boolean.valueOf(strShowTaggedDocuments);
        }
        if (!showTaggedDocuments(request) && !showFacetedDocuments(request)) {
	        String query = getQuery(request);
	            searchDocuments(request, query);
	        }
    }
}
