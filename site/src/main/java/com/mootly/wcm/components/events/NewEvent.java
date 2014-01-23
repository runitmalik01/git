

package com.mootly.wcm.components.events;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.EventDocument;
import com.mootly.wcm.components.BaseComponent;

public class NewEvent extends BaseComponent {

	public static final Logger log = LoggerFactory.getLogger(NewEvent.class);
	private static final int PATH_DEPTH = 4;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {

		super.doBeforeRender(request, response);

		//HippoBean document = getContentBean(request);
		HippoBean document = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
		/*String Newlink=getPublicRequestParameter(request,"new");
		String editlink=getPublicRequestParameter(request,"edit");
		String deletelink=getPublicRequestParameter(request,"delete");
		request.setAttribute("editlink", editlink);
		request.setAttribute("deletelink", deletelink);*/
		request.setAttribute("document", document);
		request.getRequestContext().setAttribute("document", document);

	}



	@Override
	public void doAction(HstRequest request, HstResponse response) {
		log.info("inside do action");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String description = request.getParameter("description");		
		String newStartDate = request.getParameter("newstartdate");		
		String newEndDate = request.getParameter("newenddate");
		EventDocument edoc = new EventDocument();
		edoc.setTitle(title);
		edoc.setSummary(summary);
		edoc.setDescriptionContent(description);
		edoc.setNewStartDate(newStartDate);
		edoc.setNewEndDate(newEndDate);
		
		createNewEvents(request,edoc);
		//editNewEvents(request,edoc);
		/*if(delete!=null){
			log.info("inside delete");
			DeleteEvents(request,edoc);

		}else{
			createNewEvents(request,edoc);
		}*/
		try {
			response.sendRedirect("/site/r/"+getITRInitData(request).getResellerId()+"/events");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected  EventDocument createNewEvents(HstRequest request,EventDocument ed) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		String finalMembershipDocumentPath = null;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			//HippoFolder hippoFolder=(HippoFolder) getContentBean(request);
			//HippoBean document = (HippoBean) getContentBean(request);
			//String memberFolderPath= document.getCanonicalPath();
			String cPath = getCanonicalBasePathForWrite(request);
			final String memberFolderPathnew= cPath+"/cms/events";
			finalMembershipDocumentPath = wpm.createAndReturn(memberFolderPathnew, EventDocument.NAMESPACE, ed.getTitle(), true);
			EventDocument objEventDocument =  (EventDocument) wpm.getObject(finalMembershipDocumentPath);
			// update content properties
			if (objEventDocument != null) {
				log.info(""+objEventDocument);
				objEventDocument.setTitle(ed.getTitle());
				objEventDocument.setSummary(ed.getSummary());
				objEventDocument.setDescriptionContent(ed.getDescriptionContent());
				objEventDocument.setNewStartDate(ed.getNewStartDate());
				objEventDocument.setNewEndDate(ed.getNewEndDate());
				// update now  
				wpm.update(objEventDocument);

			}
			return null;
		} catch (Exception e) {
			log.warn("Failed to CREATE new event", e);
			return null;
		} finally {
			if (persistableSession != null) {

			}
		}
	}
	protected  EventDocument editNewEvents(HstRequest request,EventDocument ed) {
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

				log.info("path isssssss"+memberFolderPath);
			}
			EventDocument objEventDocument =  (EventDocument) wpm.getObject(memberFolderPath);
			// update content properties
			if (objEventDocument != null) {
				log.info(""+objEventDocument);
				objEventDocument.setTitle(ed.getTitle());
				objEventDocument.setSummary(ed.getSummary());
				objEventDocument.setDescriptionContent(ed.getDescriptionContent());
				objEventDocument.setNewStartDate(ed.getNewStartDate());
				objEventDocument.setNewEndDate(ed.getNewEndDate());
				// update now  
				wpm.update(objEventDocument);
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
	protected  void DeleteEvents(HstRequest request,EventDocument ed) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		//String finalMembershipDocumentPath = null;
		try {
			HippoBean document = (HippoBean) getContentBean(request);
			String memberFolderPath= document.getCanonicalPath();
			String path= document.getPath();
			log.info("path for delete"+path);
			log.info("path for delete"+memberFolderPath);
			persistableSession = request.getRequestContext().getSession();

			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {
				public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
					FullReviewedActionsWorkflow fraw = (FullReviewedActionsWorkflow) wf;
					fraw.delete();
				}
			});
			EventDocument objEventDocument =  (EventDocument) wpm.getObject(memberFolderPath);
			// update content properties
			if (objEventDocument != null) {
				log.warn("going to remove");
				wpm.remove(objEventDocument);

			}
		} catch (Exception e) {
			log.warn("Failed to remove Events  ", e);
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
