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

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.util.ContentBeanUtils;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.Comment;
import com.mootly.wcm.beans.Document;
import com.mootly.wcm.beans.EventDocument;
import com.mootly.wcm.beans.NewsItem;

public class Detail extends BaseComponent {

	public static final Logger log = LoggerFactory.getLogger(Detail.class);
	private static final int PATH_DEPTH = 4;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {

		super.doBeforeRender(request, response);

		HippoBean document = getContentBean(request);
		String editlink=getPublicRequestParameter(request,"edit");
		String deletelink=getPublicRequestParameter(request,"delete");
		String newsEditlink=getPublicRequestParameter(request,"newsEdit");
		String newsDeletelink=getPublicRequestParameter(request,"newsDelete");
		if(null!=editlink){
			request.setAttribute("editlink", editlink);}
		if(null!=deletelink){
			request.setAttribute("deletelink", deletelink);}
		if(null!=newsEditlink){
			request.setAttribute("newsEditlink", newsEditlink);}
		if(null!=newsDeletelink){
			request.setAttribute("newsDeletelink", newsDeletelink);}
		
		if (document == null) { 
			redirectToNotFoundPage(response);
			return;
		}
		request.setAttribute("document", document);
		request.getRequestContext().setAttribute("document", document);
		HippoFolder commentsFolder = null;
		int commentCount = 0;

		if (document instanceof NewsItem) {
			commentsFolder = getSiteContentBaseBean(request).getBean("comments/news");

		} else if (document instanceof EventDocument) {
			commentsFolder = getSiteContentBaseBean(request).getBean("comments/events");
		}

		if (commentsFolder != null) {
			try {
				HstQuery incomingBeansQuery = ContentBeanUtils.createIncomingBeansQuery((HippoDocumentBean) document, commentsFolder, PATH_DEPTH, getObjectConverter(), Comment.class, false);
				commentCount = incomingBeansQuery.execute().getSize();
			} catch (QueryException e) {
				log.error(e.getMessage());
			}

		}
		request.setAttribute("commentCount", commentCount);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) {
		String edit=getPublicRequestParameter(request, "edit");
		String delete=getPublicRequestParameter(request, "delete");
		String newsEdit=getPublicRequestParameter(request, "newsEdit");
		String newsDelete=getPublicRequestParameter(request, "newsDelete");
		if(log.isInfoEnabled())
		{
			log.info("delete link"+delete);
		}
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String description = request.getParameter("description");
		String flag = request.getParameter("deleteevent");
		String newsflag = request.getParameter("deletenews");
		//String date = request.getParameter("date");
		EventDocument edoc = new EventDocument();	
		edoc.setTitle(title);
		edoc.setSummary(summary);
		edoc.setDescriptionContent(description);
		NewsItem ndoc = new NewsItem();
		ndoc.setTitle(title);
		ndoc.setSummary(summary);
		ndoc.setDescriptionContent(description);
		if(null!=edit){
			editNewEvents(request,edoc);
			try {
				response.sendRedirect("/site/r/"+ getITRInitData(request).getResellerId() +"/events");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(null!=newsEdit){
			editNewNews(request,ndoc);
			try {
				response.sendRedirect("/site/r/"+ getITRInitData(request).getResellerId()+"/news");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(flag != null && !flag.isEmpty() ){
			if(flag.equalsIgnoreCase("yes")){
				DeleteEvents(request,edoc);
			}	
			try {
				response.sendRedirect("/site/r/"+ getITRInitData(request).getResellerId()+"/events");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if(newsflag != null && !newsflag.isEmpty()){
			if(newsflag.equalsIgnoreCase("yes")){
				DeleteNews(request,ndoc);				
			}	
			try {
				response.sendRedirect("/site/r/"+getITRInitData(request).getResellerId()+"/news");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Edit Events
	protected  void editNewEvents(HstRequest request,EventDocument ed) {
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			HippoBean document = (HippoBean) getContentBean(request);
			String memberFolderPath= document.getCanonicalPath();
			EventDocument objEventDocument =  (EventDocument) wpm.getObject(memberFolderPath);
			// update content properties
			if (objEventDocument != null) {
				objEventDocument.setTitle(ed.getTitle());
				objEventDocument.setSummary(ed.getSummary());
				objEventDocument.setDescriptionContent(ed.getDescriptionContent()); 
				wpm.update(objEventDocument);
				wpm.save();
			}
		} catch (Exception e) {
			log.warn("Failed to EDIT eventsdocument ", e);
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}

	// Edit News
	protected  void editNewNews(HstRequest request,NewsItem nd){
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {		
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			HippoBean document = (HippoBean) getContentBean(request);
			String memberFolderPath= document.getCanonicalPath();		
			Object object =  wpm.getObject(memberFolderPath);
			// update content properties
			if (object != null) {
				if(object instanceof NewsItem){
					NewsItem objNewsItem = (NewsItem) object;
					objNewsItem.setTitle(nd.getTitle());
					objNewsItem.setSummary(nd.getSummary());
					objNewsItem.setDescriptionContent(nd.getDescriptionContent()); 
					wpm.update(objNewsItem);
					wpm.save();
				}
			}
		} catch (Exception e) {
			log.warn("Failed to EDIT newsdocument ", e);
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}

	//Delete Events
	protected  void DeleteEvents(HstRequest request,EventDocument ed) {
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			HippoBean document = (HippoBean) getContentBean(request);
			String memberFolderPath= document.getCanonicalPath();
			persistableSession = request.getRequestContext().getSession();
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {
				public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
					FullReviewedActionsWorkflow fraw = (FullReviewedActionsWorkflow) wf;
					fraw.delete();
				}
			});
			EventDocument objEventDocument =  (EventDocument) wpm.getObject(memberFolderPath);
			if (objEventDocument != null) {
				log.warn("Are you sure want to DELETE event?");
				wpm.remove(objEventDocument);
			}
		} catch (Exception e) {
			log.warn("Failed to DELETE event ", e);
		} finally {
			if (persistableSession != null) {
			}
		}
	}
	//Delete News
	protected  void DeleteNews(HstRequest request,NewsItem nd) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			HippoBean document = (HippoBean) getContentBean(request);
			String memberFolderPath= document.getCanonicalPath();
			persistableSession = request.getRequestContext().getSession();
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {
				public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
					FullReviewedActionsWorkflow fraw = (FullReviewedActionsWorkflow) wf;
					fraw.delete();
				}
			});
			NewsItem objNewsItemDocument =  (NewsItem) wpm.getObject(memberFolderPath);
			if (objNewsItemDocument != null) {
				log.warn("Are you sure want to DELETE news ?");
				wpm.remove(objNewsItemDocument);				
			}
		} catch (Exception e) {
			log.warn("Failed to DELETE news ", e);
		} finally {
			if (persistableSession != null) {
			}
		}
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

				Document document = (Document) cpm.getObject(documentPath);
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
			wf.publish();

		}
	}
}
