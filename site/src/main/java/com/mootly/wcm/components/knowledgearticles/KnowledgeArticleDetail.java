/**
 * Copyright (C) 2011 Hippo B.V.
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

package com.mootly.wcm.components.knowledgearticles;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.component.support.forms.StoreFormResult;
import org.hippoecm.hst.configuration.sitemap.HstSiteMapItem;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.KnowledgeArticle;
import com.mootly.wcm.beans.Review;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.member.MemberSecurity;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.GoGreenUtil;

@ParametersInfo(type = KnowledgeArticleDetailParamInfo.class)
public class KnowledgeArticleDetail extends BaseComponent {

	private static final Logger log = LoggerFactory.getLogger(KnowledgeArticleDetail.class);

	private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss.SSS";
	private static final String NAME = "name";
	private static final String COMMENT = "comment";
	private static final String EMAIL = "email";
	private static final String SUCCESS = "success";
	private static final String ERRORS = "errors";
	private static final String RefID = "knowledgeportal"; 
	
	FormMap parentBeanMap = null;
	PAGE_ACTION pageAction = null;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		init(request);
		HippoBean document = getContentBeanFromPath(request);
		if (document == null && pageAction !=  PAGE_ACTION.NEW) {
			redirectToNotFoundPage(response);
			return;
		}
		request.setAttribute("document", document);
		// Here i am writing logic to delete my document
		if(pageAction == PAGE_ACTION.DELETE){
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			String baseAbsolutePathToReturnDocuments = getSiteContentBaseBeanForReseller(request).getCanonicalPath() + "/documents/knowledgearticles";
			KnowledgeArticle knowledgeArticle = (KnowledgeArticle) document;
			String parentBeanAbsolutePath = (knowledgeArticle != null ?  knowledgeArticle.getCanonicalHandlePath() : null);
			String parentBeanNameSpace = "mootlywcm:knowledgearticle";
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

	@Override
	public void doAction(HstRequest request, HstResponse response) {
		//String aa = hstSiteMapItem.getLocalParameter("node-name");
		init(request);
		if (!(validate(request, response))) {
			return;
		}
		HippoBean document  = getContentBeanFromPath(request);
		
		if (document == null && pageAction !=  PAGE_ACTION.NEW) {
			redirectToNotFoundPage(response);
			return;
		}

		Session persistableSession = null;
		WorkflowPersistenceManager wpm;

		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			String baseAbsolutePathToReturnDocuments = getSiteContentBaseBeanForReseller(request).getCanonicalPath() + "/documents/knowledgearticles";
			KnowledgeArticle knowledgeArticle = (KnowledgeArticle) document;
			String parentBeanAbsolutePath = (knowledgeArticle != null ?  knowledgeArticle.getCanonicalHandlePath() : null);
			String parentBeanNameSpace = "mootlywcm:knowledgearticle";
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
	
	protected HippoBean getContentBeanFromPath(HstRequest request) {
		String nodeName = request.getRequestContext().getResolvedSiteMapItem().getParameter("node-name");
		String scopeRelativePath = request.getRequestContext().getResolvedSiteMapItem().getParameter("scopeRelativePath");
		
		HippoBean theScopeBean = getSiteContentBaseBeanForReseller(request).getBean(scopeRelativePath);
		if (theScopeBean != null) {
			request.setAttribute("theScopeBean", theScopeBean);
		}
		
		if (nodeName!= null) {
			request.setAttribute("nodeName", nodeName);
		}

		HippoBean siteContentBase = getSiteContentBaseBeanForReseller(request);
		if (log.isInfoEnabled()) {
			log.info(siteContentBase.getPath());
		}
		HippoBean theParentFolder = siteContentBase.getBean(scopeRelativePath);
		HippoBean document = null;
		if (theParentFolder != null){
			document = theParentFolder.getBean(nodeName);
		}
		return document;
	}
	
	
	protected void init(HstRequest request) {
		String action = request.getRequestContext().getResolvedSiteMapItem().getParameter("action");
		if (action != null) {
			pageAction = PAGE_ACTION.valueOf(action);
			request.setAttribute("pageAction", pageAction);
		}else{
			pageAction = PAGE_ACTION.DEFAULT;
		}
	}
	
	protected boolean validate(HstRequest request, HstResponse response) {
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


	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response) throws HstComponentException {

		super.doBeforeServeResource(request, response);

		boolean succeeded = true;
		String errorMessage = "";

		String workflowAction = request.getParameter("workflowAction");

		String field = request.getParameter("field");

		final boolean requestPublication = "requestPublication".equals(workflowAction);
		final boolean saveDocument = ("save".equals(workflowAction) || requestPublication);

		if (saveDocument || requestPublication) {
			String documentPath = getContentBean(request).getPath();
			Session persistableSession = null;
			WorkflowPersistenceManager cpm = null;

			try {
				//NOTE: Don't need to use writable session here; use subject based session instead.
				//persistableSession = getPersistableSession(request);
				persistableSession = request.getRequestContext().getSession();

				cpm = getWorkflowPersistenceManager(persistableSession);
				cpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {
					public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
						if (requestPublication) {
							FullReviewedActionsWorkflow fraw = (FullReviewedActionsWorkflow) wf;
							fraw.requestPublication();
						}
					}
				});

				KnowledgeArticle document = (KnowledgeArticle) cpm.getObject(documentPath);

				if (saveDocument) {
					String content = request.getParameter("editor");

					if ("mootlywcm:summary".equals(field)) {
						document.setSummary(content);
					} else if ("mootlywcm:description".equals(field)) {
						document.setDescriptionContent(content);
					}
				}

				// update now
				cpm.update(document);
				cpm.save();
			} catch (Exception e) {
				log.warn("Failed to create a comment: ", e);

				if (cpm != null) {
					try {
						cpm.refresh();
					} catch (ObjectBeanPersistenceException e1) {
						log.warn("Failed to refresh: ", e);
					}
				}
			}
			// NOTE: no need to close the persistable session here because subject based session was retrieved from rc.
		}

		request.setAttribute("payload", "{\"success\": " + succeeded + ", \"message\": \"" + errorMessage + "\"}");
	}

	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.requestPublication();
		}
	}
}
