
package com.mootly.wcm.components.news;

import java.io.IOException;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.NewsItem;
import com.mootly.wcm.components.BaseComponent;

public class NewNews extends BaseComponent {

	public static final Logger log = LoggerFactory.getLogger(NewNews.class);
	private static final int PATH_DEPTH = 4;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);

		HippoBean newsitem = getSiteContentBaseBeanForReseller(request);
		request.setAttribute("newsitem", newsitem);
		request.getRequestContext().setAttribute("newsitem", newsitem);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) {
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String description = request.getParameter("description");
		//String date = request.getParameter("date");
		NewsItem ndoc = new NewsItem();
		ndoc.setTitle(title);
		ndoc.setSummary(summary);
		ndoc.setDescriptionContent(description);

		createNewNews(request,ndoc);
		try {
			response.sendRedirect("/site/r/"+getITRInitData(request).getResellerId()+"/news");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected  NewsItem createNewNews(HstRequest request,NewsItem nd) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		String finalMembershipDocumentPath = null;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());			
			String cPath = getCanonicalBasePathForWrite(request);
			final String memberFolderPathnew= cPath+"/cms/news";
			finalMembershipDocumentPath = wpm.createAndReturn(memberFolderPathnew, NewsItem.NAMESPACE, nd.getTitle(), true);
			NewsItem objNewsDocument =  (NewsItem) wpm.getObject(finalMembershipDocumentPath);
			// update content properties
			if (objNewsDocument != null) {
				objNewsDocument.setTitle(nd.getTitle());
				objNewsDocument.setSummary(nd.getSummary());
				objNewsDocument.setDescriptionContent(nd.getDescriptionContent());  
				wpm.update(objNewsDocument);
			}
			return null;
		} catch (Exception e) {
			log.warn("Failed to signup member ", e);
			return null;
		} finally {
			if (persistableSession != null) {

			}
		}
	}
	protected  NewsItem editNewNews(HstRequest request,NewsItem nd) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			HippoBean document = (HippoBean) getContentBean(request);
			String memberFolderPath= document.getCanonicalPath();
			if(log.isInfoEnabled()){
				log.info("Path Issue with Edited News"+memberFolderPath);
			}
			NewsItem objNewsDocument =  (NewsItem) wpm.getObject(memberFolderPath);
			// update content properties
			if (objNewsDocument != null) {
				objNewsDocument.setTitle(nd.getTitle());
				objNewsDocument.setSummary(nd.getSummary());
				objNewsDocument.setDescriptionContent(nd.getDescriptionContent());  
				wpm.update(objNewsDocument);
				wpm.save();
			}
			return null;
		} catch (Exception e) {
			log.warn("Failed to signup member ", e);
			return null;
		} finally {
			if (persistableSession != null) {

			}
		}
	}
	protected  void DeleteNews(HstRequest request,NewsItem nd) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		//String finalMembershipDocumentPath = null;
		try {
			HippoBean document = (HippoBean) getContentBean(request);
			String memberFolderPath= document.getCanonicalPath();
			String path= document.getPath();
			log.info(path);
			persistableSession = request.getRequestContext().getSession();

			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {
				public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
					FullReviewedActionsWorkflow fraw = (FullReviewedActionsWorkflow) wf;
					fraw.delete();
				}
			});
			NewsItem objNewsDocument =  (NewsItem) wpm.getObject(memberFolderPath);
			// update content properties
			if (objNewsDocument != null) {
				log.warn("Are you sure want to DELETE newNews??");
				wpm.remove(objNewsDocument);

			}
		} catch (Exception e) {
			log.warn("Failed to DELETE newNews ", e);
		} finally {
			if (persistableSession != null) {

			}
		}
	}

	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}

}
