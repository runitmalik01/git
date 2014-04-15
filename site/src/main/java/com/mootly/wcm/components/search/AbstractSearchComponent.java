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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryManager;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.content.beans.standard.HippoDocumentIterator;
import org.hippoecm.hst.content.beans.standard.HippoFacetChildNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoFacetNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.util.SearchInputParsingUtils;
import org.hippoecm.hst.utils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.Document;
import com.mootly.wcm.beans.Faq;
import com.mootly.wcm.beans.KnowledgeArticle;
import com.mootly.wcm.beans.NewsItem;
import com.mootly.wcm.beans.SimpleDocument;
import com.mootly.wcm.beans.cms.PageDocument;
import com.mootly.wcm.components.ComponentUtil;
import com.mootly.wcm.components.TagComponent;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.PageableCollection;

public class AbstractSearchComponent extends TagComponent {

    private static final String PARAM_QUERY = "query";

    private static final Logger log = LoggerFactory.getLogger(AbstractSearchComponent.class);

    /**
     * 
     * @param request
     * @return the not yet parsed request parameter 'query' and <code>null</code> if there was no such parameter
     */
    protected String getQuery(HstRequest request) {
        return getPublicRequestParameter(request, PARAM_QUERY);
    }

    protected int getPageSize(HstRequest request) {
        String pageSizeParam = getParameter(Constants.PAGE_SIZE, request);
        return ComponentUtil.parseIntParameter(Constants.PAGE_SIZE, pageSizeParam, Constants.DEFAULT_PAGE_SIZE, log);
    }

    protected int getCurrentPage(HstRequest request) {
        String currentPageParam = getPublicRequestParameter(request, Constants.PAGE);
        return ComponentUtil.parseIntParameter(Constants.PAGE, currentPageParam, Constants.DEFAULT_PAGE_NUMBER, log);
    }

    protected boolean showTaggedDocuments(HstRequest request) {
        List<? extends HippoBean> taggedBeans = getRelatedBeans(request);

        if (taggedBeans.isEmpty()) {
            // no tagged documents available
            return false;
        } else {
            // only show tagged documents

            // we only want subtypes of mootlywcm:document.
            // TODO: replace this by limiting the search tag sources to 
            // mootlywcm:documents once the tagcloud plugin supports this.
        	HippoBean scope = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
            List<HippoBean> taggedDocuments = new ArrayList<HippoBean>();
            for (HippoBean bean : taggedBeans) {
                if (bean instanceof Document || bean instanceof SimpleDocument) {
                	if (bean.getCanonicalPath().startsWith(scope.getCanonicalPath())) {
                		taggedDocuments.add(bean);
                	}
                	else{
                		log.info(bean.getCanonicalPath() + " does not start with " + scope.getCanonicalPath());
                	}
                }
            }

            int pageSize = getPageSize(request);
            int currentPage = getCurrentPage(request);

            @SuppressWarnings("unchecked")
            PageableCollection tagged = new PageableCollection(taggedDocuments, pageSize, currentPage);
            request.setAttribute("searchResult", tagged);

            return true;
        }
    }

    protected void searchDocuments(final HstRequest request,final String query) {
        
        String parsedQuery = SearchInputParsingUtils.parse(query,false);
        
        request.setAttribute("query", StringEscapeUtils.escapeHtml(parsedQuery));
        HippoBean scope = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
        
        String scopeRelativePath = request.getRequestContext().getResolvedSiteMapItem().getParameter("scopeRelativePath");
        if (scopeRelativePath != null) {
        	scope =  scope.getBean(scopeRelativePath);
        }
        else {
        	scope =  scope.getBean("documents");
        }
        
        String screenHead = request.getRequestContext().getResolvedSiteMapItem().getParameter("screen.head");
        String screenSubHead = request.getRequestContext().getResolvedSiteMapItem().getParameter("screen.subHead");
        if (screenHead != null) request.setAttribute("screenHead",screenHead);
        if (screenSubHead != null) request.setAttribute("screenSubHead",screenSubHead);
        
        if (scope == null) {
            log.error("Scope for search is null");
            return;
        }
        else {
        	if (log.isInfoEnabled()) {
        		log.info("Scope Path is :"+ scope.getPath());
        	}
        	request.setAttribute("theScopeBean", scope);
        }

        try {
            HstQueryManager manager = getQueryManager(request);
            @SuppressWarnings("unchecked")            
            HstQuery hstQuery = null;                    
            if (hstQuery == null) { 
            	if (scopeRelativePath != null) {
            		hstQuery = manager.createQuery(scope);
            	}
            	else {
            		hstQuery = manager.createQuery(scope);
            	}
            	Filter excludeFolders = hstQuery.createFilter();
            	excludeFolders.addNotEqualTo("jcr:primaryType", "hippostd:folder");
            	hstQuery.setFilter(excludeFolders);
            }
            //hstQuery = manager.createQuery(scope);

            //HippoBean assetScope = getAssetBaseBean(request);
            //hstQuery.addScopes(Collections.singletonList(assetScope));

            if (!StringUtils.isEmpty(parsedQuery)) {
                Filter filter = hstQuery.createFilter();
                hstQuery.setFilter(filter);
                
                // title field
                Filter titleFilter = hstQuery.createFilter();
                titleFilter.addContains("@mootlywcm:title", parsedQuery);
                // summary field
                Filter summaryFilter = hstQuery.createFilter();
                summaryFilter.addContains("@mootlywcm:summary", parsedQuery);
                // full text
                Filter fullTextFilter = hstQuery.createFilter();
                fullTextFilter.addContains(".", parsedQuery);

                filter.addOrFilter(titleFilter);
                filter.addOrFilter(summaryFilter);
                filter.addOrFilter(fullTextFilter);
                //https://issues.onehippo.com/browse/mootlywcm-254
                //hstQuery.addOrderByDescending("mootlywcm:rating");
            }else{
                hstQuery.addOrderByDescending("hippostdpubwf:creationDate");
            }
            
            HstQueryResult result = hstQuery.execute();
            int totalSize = result.getSize();
            
            HippoBeanIterator beans = result.getHippoBeans();
            int pageSize = getPageSize(request);
            int currentPage = getCurrentPage(request);

            PageableCollection<HippoBean> results = new PageableCollection<HippoBean>(beans, pageSize, currentPage);
            if (results != null && results.getItems() != null && results.getItems().size() > 0) {
            	HippoBean firstBean = results.getItems().get(0);
            	request.setAttribute("firstBean", firstBean);
            }
            
            PageableCollection<HippoBean> resultsTotal = new PageableCollection<HippoBean>(beans, totalSize, 1);
            request.setAttribute("resultsTotal", resultsTotal);
            request.setAttribute("searchResult", results);
            request.setAttribute("scope", scope);
            request.setAttribute("scopeForResellers", getITRInitData(request).getSiteContentBaseBeanForReseller(request));
            
            String format = getPublicRequestParameter(request, "format");
            if (format != null && format.equals("json") && results != null && results.getItems() != null) {
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
            		log.error("JSON Exception",e);
            	}
            	request.setAttribute("jsonResult",jsonArray.toString());
            }
        } catch (QueryException e) {
            if(log.isDebugEnabled()) {
                log.warn("Error during search: ", e);
            } else {
                log.warn("Error during search: ", e.getMessage());
            }
        }
    }

    protected boolean showFacetedDocuments(HstRequest request) {
    	  String screenHead = request.getRequestContext().getResolvedSiteMapItem().getParameter("screen.head");
          String screenSubHead = request.getRequestContext().getResolvedSiteMapItem().getParameter("screen.subHead");
          if (screenHead != null) request.setAttribute("screenHead",screenHead);
          if (screenSubHead != null) request.setAttribute("screenSubHead",screenSubHead);
          
          String showContent = request.getRequestContext().getResolvedSiteMapItem().getParameter("showContent");
          if (showContent != null) request.setAttribute("showContent",showContent);
          
        HippoBean bean = null; //getContentBean(request);
        HippoBean scope = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
        
        String scopeRelativePath = request.getRequestContext().getResolvedSiteMapItem().getParameter("scopeRelativePath");
        if (scopeRelativePath != null) {
        	scope =  scope.getBean(scopeRelativePath);
        }
        String pathToContentBean = request.getRequestContext().getResolvedSiteMapItem().getLocalParameter("pathToContentBean");
        if (pathToContentBean != null) {
        	bean = scope.getBean(pathToContentBean);
        }
        if (bean == null) {
        	bean =  getContentBean(request);
        }
        if (bean instanceof HippoFacetChildNavigationBean) {
            String query = SearchInputParsingUtils.parse(getQuery(request), false);
            HippoFacetNavigationBean facetBean = BeanUtils.getFacetNavigationBean(request, query, objectConverter);
            if (scopeRelativePath != null) {
            	//String theRelativePath =  (scope.getCanonicalPath() + "/" + scopeRelativePath).substring(getSiteContentBaseBean(request).getCanonicalPath().length()-1);
            	//String resolvedContentPath = scopeRelativePath + "/searchfacets";
            	
            	//facetBean = BeanUtils.getFacetNavigationBean(request, "resellers/" + getITRInitData(request).getResellerId() + "/" + scopeRelativePath  + "/" + pathToContentBean, query, objectConverter);
            }
            
            HippoDocumentIterator<HippoBean> facetIt = facetBean.getResultSet().getDocumentIterator(HippoBean.class);
            int facetCount = facetBean.getCount().intValue();
            int pageSize = getPageSize(request);
            int currentPage = getCurrentPage(request);
            PageableCollection<HippoBean> results = new PageableCollection<HippoBean>(facetIt, facetCount,
                    pageSize, currentPage);
            request.setAttribute("searchResult", results);
            request.setAttribute("query", StringEscapeUtils.escapeHtml(query));
            return true;
        } else {
            return false;
        }
    }

}
