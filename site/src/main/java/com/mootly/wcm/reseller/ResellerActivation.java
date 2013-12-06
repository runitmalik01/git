/*
 * By abhishek
 * This code will work when user click on activation link
 * 30/01/2013
 * 
 */



package com.mootly.wcm.reseller;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.SignupDetail.FullReviewedWorkflowCallbackHandler;

public class ResellerActivation extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ResellerActivation.class);

	public static final String SUCCESS= "success";

	private String Isactive;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		String activationCode = request.getRequestContext().getResolvedSiteMapItem().getParameter("activationCode");
		if (activationCode == null || activationCode.trim().equals("")) {
			log.warn("This is crazy. Activation code is null");
			request.setAttribute("isError", "true");
			request.setAttribute("errorCode", "error.activationcode.missing");
			return;
		}
		//now get the membershipdocument right away with the uuid
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			ResellerSignupDocument resellerSignupDocument = (ResellerSignupDocument) wpm.getObjectByUuid(activationCode);
			if (resellerSignupDocument == null) {
				request.setAttribute("isError", "true");
				request.setAttribute("errorCode", "error.usernotfound");
				return;
			}
			if (resellerSignupDocument != null && resellerSignupDocument.getIsActive()) {
				log.warn("User has already activated");
				request.setAttribute("isError", "true");
				request.setAttribute("errorCode", "error.alreadyactivated");
				request.setAttribute("userName", resellerSignupDocument.getEmail());
				return;
			}
			else if (resellerSignupDocument != null && resellerSignupDocument.getEmail() != null) {
				request.setAttribute("userName", resellerSignupDocument.getEmail());
			}
			resellerSignupDocument.setIsActive(true);


			//wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			// here we replace the name of document with this method by which it can identify the username in content folder
			wpm.update(resellerSignupDocument);

		} catch (ObjectBeanManagerException e1) {
			// TODO Auto-generated catch block
			request.setAttribute("isError", "true");
			log.error("Activation Error",e1);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Activation Error",e);
		}
		finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
	}

	//Any submission will go here


	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}

	public String getIsactive() {
		return Isactive;
	}

	public void setIsactive(String isactive) {
		Isactive = isactive;
	}

}
