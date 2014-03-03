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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.component.support.forms.StoreFormResult;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.util.ContentBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.Comment;
import com.mootly.wcm.beans.EventDocument;
import com.mootly.wcm.beans.NewsItem;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.member.MemberSecurity;
import com.mootly.wcm.utils.GoGreenUtil;

public class Detail extends BaseComponent {

	public static final Logger log = LoggerFactory.getLogger(Detail.class);
	private static final int PATH_DEPTH = 4;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		FormMap parentBeanMap = null;
		PAGE_ACTION pageAction = null;
		pageAction = init(request);
		
		super.doBeforeRender(request, response);
		HippoBean scope = getSiteContentBaseBeanForReseller(request);
		String relativeContentPath = request.getRequestContext().getResolvedSiteMapItem().getRelativeContentPath();
		relativeContentPath = sanitizeRelativeContentPath(request, relativeContentPath);
		HippoDocumentBean document = scope.getBean(relativeContentPath); //getContentBean(request);
		String baseAbsolutePathToContentBean = getSiteContentBaseBeanForReseller(request).getCanonicalPath();
		String baseAbsolutePathToReturnDocuments = baseAbsolutePathToContentBean;
		String parentBeanNameSpace = null;
		String RefID = "";
		
		if (document != null && (document instanceof NewsItem || document instanceof EventDocument)) {
			if (document instanceof NewsItem) {
				parentBeanNameSpace = "mootlywcm:newsitem";
				RefID = "news";
			}
			else if (document instanceof EventDocument) {
				baseAbsolutePathToReturnDocuments =  baseAbsolutePathToContentBean+ "/documents/events";
				parentBeanNameSpace = "mootlywcm:event";
				RefID = "events";
			}
			if(pageAction == PAGE_ACTION.DELETE){
				Session persistableSession = null;
				WorkflowPersistenceManager wpm;
				try {
					persistableSession = getPersistableSession(request);
					wpm = getWorkflowPersistenceManager(persistableSession);
					String parentBeanAbsolutePath = (document != null ?  document.getCanonicalHandlePath() : null);
					String title = GoGreenUtil.getEscapedParameter(request, "title");
					String parentBeanNodeName = (document != null ?  document.getName() : title); //TODO escape it for node name
						getItReturnComponentHelper().deleteSingleDocument(parentBeanMap, null, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, persistableSession, wpm);
					String targetPath= MemberSecurity.getTargerPath(request, RefID); 
					response.sendRedirect(targetPath);
				} catch (Exception e) {
					log.warn("Failed to create /update KB", e);
				} finally {
					if (persistableSession != null) {
						persistableSession.logout();
					}
				}
			}
		}
			
		if (document == null && pageAction != PAGE_ACTION.NEW) { 
			redirectToNotFoundPage(response);
			return;
		}
		request.setAttribute("document", document);
		request.getRequestContext().setAttribute("document", document);
		HippoFolder commentsFolder = null;
		int commentCount = 0;

		if (document != null && document instanceof NewsItem) {
			commentsFolder = getSiteContentBaseBeanForReseller(request).getBean("documents/news");

		} else if (document != null && document instanceof EventDocument) {
			commentsFolder = getSiteContentBaseBean(request).getBean("comments/events");
		}
		
		List<HippoBean> commentBeans = new ArrayList<HippoBean>();
		if (commentsFolder != null) {
			try {
				HstQuery incomingBeansQuery = ContentBeanUtils.createIncomingBeansQuery((HippoDocumentBean) document, commentsFolder, PATH_DEPTH, getObjectConverter(), Comment.class, false);
				commentCount = incomingBeansQuery.execute().getSize();

				if(commentCount > 0){
					final HstQueryResult result = incomingBeansQuery.execute();
					Iterator<HippoBean> itResults = result.getHippoBeans();
					for (;itResults.hasNext();) {
						HippoBean hippoBean = itResults.next();
						if (hippoBean instanceof HippoDocumentBean) {
							commentBeans.add(hippoBean);
						}
					}
				}
			} catch (QueryException e) {
				log.error(e.getMessage());
			}

		}
		request.setAttribute("commentBeans", commentBeans);
		request.setAttribute("commentCount", commentCount);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) {
		String RefID = "knowledgeportal"; 
		PAGE_ACTION pageAction = null;
		//String aa = hstSiteMapItem.getLocalParameter("node-name");
		pageAction = init(request);
		if (!(validate(request, response))) {
			return;
		}
		FormMap parentBeanMap = new FormMap(request, new String[]{"title","summary","description"});
		HippoBean scope = getSiteContentBaseBeanForReseller(request);
		String relativeContentPath = request.getRequestContext().getResolvedSiteMapItem().getRelativeContentPath();
		relativeContentPath = sanitizeRelativeContentPath(request, relativeContentPath);
		HippoDocumentBean document = scope.getBean(relativeContentPath); //getContentBean(request);
		
		if (document == null && pageAction !=  PAGE_ACTION.NEW) {
			redirectToNotFoundPage(response);
			return;
		}
		
		String baseAbsolutePathToContentBean = getSiteContentBaseBeanForReseller(request).getCanonicalPath();
		String baseAbsolutePathToReturnDocuments = baseAbsolutePathToContentBean;
		String parentBeanNameSpace = null;
		
		
		
		if ( (document != null && document instanceof NewsItem ) || (document == null && relativeContentPath.contains("news")) ) {
			baseAbsolutePathToReturnDocuments =  baseAbsolutePathToContentBean+ "/documents/news";
			parentBeanNameSpace = "mootlywcm:newsitem";
			RefID = "news";
		}
		else if ( (document != null && document instanceof EventDocument) || (document == null && relativeContentPath.contains("events"))) {
			baseAbsolutePathToReturnDocuments =  baseAbsolutePathToContentBean+ "/documents/events";
			parentBeanNameSpace = "mootlywcm:event";
			RefID = "events";
		}
		
		/*
		if (document != null && document instanceof FormMapFiller) {
			FormMapFiller formMapFiller = (FormMapFiller) document;
			formMapFiller.fill(parentBeanMap);
		}
		*/
		
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;

		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			
			String parentBeanAbsolutePath = (document != null ?  document.getCanonicalHandlePath() : null);
			String title = GoGreenUtil.getEscapedParameter(request, "title");
			String parentBeanNodeName = (document != null ?  document.getName() : title); //TODO escape it for node name
			if(pageAction == PAGE_ACTION.NEW || pageAction == PAGE_ACTION.EDIT){
				getItReturnComponentHelper().saveSingleDocument(parentBeanMap, null, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, persistableSession, wpm);
			}
			
			String targetPath= MemberSecurity.getTargerPath(request, RefID); 
			response.sendRedirect(targetPath);
		} catch (Exception e) {
			log.warn("Failed to create /update KB", e);
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}
	
	protected PAGE_ACTION init(HstRequest request) {
		String action = request.getRequestContext().getResolvedSiteMapItem().getParameter("action");
		PAGE_ACTION pageAction;
		if (action != null) {
			pageAction = PAGE_ACTION.valueOf(action);
			request.setAttribute("pageAction", pageAction);
		}else{
			pageAction = PAGE_ACTION.DEFAULT;
		}
		return pageAction;
	}
	
	protected boolean validate(HstRequest request, HstResponse response) {
		FormMap parentBeanMap = null;
		PAGE_ACTION pageAction = null;
		
		parentBeanMap = new FormMap(request, new String[]{"title","summary","description"});
		
		if ( pageAction != null ){
			switch (pageAction) {
			case EDIT:
				break;
			}
		}

		String title = GoGreenUtil.getEscapedParameter(request, "title");
		//String summary = GoGreenUtil.getEscapedParameter(request, "summary");

		List<String> errors = new ArrayList<String>();

		if (StringUtils.isEmpty(title)) {
			errors.add("invalid.name-label");
		}
		/*
		if (StringUtils.isEmpty(summary)) {
			errors.add("invalid.comment-label");
		}
		*/
		if (errors.size() > 0) {
			StoreFormResult sfr = new StoreFormResult();
			FormUtils.persistFormMap(request, response, parentBeanMap, sfr);
			response.setRenderParameter("uuid", sfr.getUuid());
			return false;
		}
		return true;
	}
	

}
