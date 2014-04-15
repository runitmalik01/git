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

import java.util.Iterator;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mootly.wcm.beans.Document;
import com.mootly.wcm.beans.Faq;
import com.mootly.wcm.beans.KnowledgeArticle;
import com.mootly.wcm.beans.NewsItem;
import com.mootly.wcm.utils.PageableCollection;

public class ContentDelivery extends AbstractSearchComponent {

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        HippoBean theBean = getContentBean(request);
        if (theBean != null) {
        	showFacetedDocuments(request);
        }
        else {
        	searchDocuments(request, null);
        }
        String format = request.getRequestContext().getResolvedSiteMapItem().getLocalParameter("format");
        if (format != null) request.setAttribute("format",format);
        PageableCollection<HippoBean> results = null;
        results = (PageableCollection<HippoBean>) request.getAttribute("searchResult");
        if (results != null && results.getItems() != null) {
        	JSONArray jsonArray = new JSONArray();
        	try {
        		int indx = 0;
            	for (Iterator<? extends HippoBean>itResult = results.getItems().iterator();itResult.hasNext();){
            		HippoBean hippoBean = itResult.next();
            		if (hippoBean instanceof Faq) {
            			Faq baseDocument = (Faq) hippoBean;
            			JSONObject jsonObject = new JSONObject();
            			jsonObject.put("title", baseDocument.getQuestion());
            		}
            		else if (hippoBean instanceof Document) {
            			Document baseDocument = (Document) hippoBean;
            			JSONObject jsonObject = new JSONObject();
            			jsonObject.put("title", baseDocument.getTitle());
            			jsonArray.put(indx++,jsonObject);
            		}
            		else if (hippoBean instanceof NewsItem) {
            			NewsItem baseDocument = (NewsItem) hippoBean;
            			JSONObject jsonObject = new JSONObject();
            			jsonObject.put("title", baseDocument.getTitle());
            			jsonArray.put(indx++,jsonObject);
            		}
            		else if (hippoBean instanceof KnowledgeArticle) {
            			NewsItem baseDocument = (NewsItem) hippoBean;
            			JSONObject jsonObject = new JSONObject();
            			jsonObject.put("title", baseDocument.getTitle());
            			jsonArray.put(indx++,jsonObject);
            		}
            	}
        	}catch (JSONException e) {
        		//log.error("JSON Exception",e);
        	}
        	request.setAttribute("jsonResult",jsonArray.toString());
        }
    }
}
