/*
 * By Dhananjay
 * This code will work when user click on activation link
 * 10/12/2013
 * 
 */



package com.mootly.wcm.reseller;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.configuration.hosting.Mount;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.tag.HstCmsEditLinkTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.SignupDetail.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.utils.GoGreenUtil;

public class ResellerActivation extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ResellerActivation.class);

	private static final String EMAILCUSTOMERSERVICE = "emailCustomerService";
	private static final String EMAILFROM = "emailFrom";
	private static final String EMAILFROMNAME = "emailFromName";
	private static final String EMAILSIGNATURE = "emailSignature";
	private static final String ERIENABLE26ASIMPORT = "eriEnable26ASImport";
	private static final String ERIENABLED = "eriEnabled";
	private static final String ERIPASSWORD = "eriPassword";
	private static final String ERIUSERID = "eriUserId";
	private static final String ISRESELLER = "isReseller";
	private static final String PAGETITLEPREFIX = "pageTitlePrefix";
	private static final String PAYMENTAVAILABLETYPES = "paymentAvailableTypes";
	private static final String PAYMENTENABLED = "paymentEnabled";
	private static final String RESELLERNAME = "resellerName";

	public static final String SUCCESS= "success";

	private String Isactive;
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		String success=request.getParameter(SUCCESS);
		if (success != null) {
			request.setAttribute(SUCCESS, success);
			return;
		}
		
		String activationCode = request.getRequestContext().getResolvedSiteMapItem().getParameter("activationCode");
		if (activationCode == null || activationCode.trim().equals("")) {
			request.setAttribute("isError", "true");
			request.setAttribute("errorCode", "error.activationcode.missing");
			return;
		}
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			ResellerSignupDocument resellerSignupDocument = (ResellerSignupDocument) wpm.getObjectByUuid(activationCode);
			if (resellerSignupDocument == null) {
				request.setAttribute("isError", "true");
				request.setAttribute("errorCode", "error.usernotfound");
			}else if (resellerSignupDocument != null && resellerSignupDocument.getIsActive()) {
				log.warn("User has already activated");
				request.setAttribute("isError", "true");
				request.setAttribute("errorCode", "error.alreadyactivated");
				request.setAttribute("userName", resellerSignupDocument.getEmail());
				return;
			}
		}catch (ObjectBeanManagerException e1) {
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
		super.doAction(request, response);

		String emailCustomerService = GoGreenUtil.getEscapedParameter(request, EMAILCUSTOMERSERVICE);
		String emailFrom = GoGreenUtil.getEscapedParameter(request, EMAILFROM);
		String emailFromName = GoGreenUtil.getEscapedParameter(request, EMAILFROMNAME);
		String emailSignature = GoGreenUtil.getEscapedParameter(request, EMAILSIGNATURE);
		String eriEnable26ASImport = GoGreenUtil.getEscapedParameter(request, ERIENABLE26ASIMPORT);
		String eriEnabled = GoGreenUtil.getEscapedParameter(request, ERIENABLED);
		String eriPassword = GoGreenUtil.getEscapedParameter(request, ERIPASSWORD);
		String eriUserId = GoGreenUtil.getEscapedParameter(request, ERIUSERID);
		String isReseller = GoGreenUtil.getEscapedParameter(request, ISRESELLER);
		String pageTitlePrefix = GoGreenUtil.getEscapedParameter(request, PAGETITLEPREFIX);
		String[] paymentAvailableTypes = GoGreenUtil.getEscapedParameterValues(request, PAYMENTAVAILABLETYPES);
		String paymentEnabled = GoGreenUtil.getEscapedParameter(request, PAYMENTENABLED);
		String resellerName = GoGreenUtil.getEscapedParameter(request, RESELLERNAME);

		String activationCode = request.getRequestContext().getResolvedSiteMapItem().getParameter("activationCode");
		
		String userName = null;
		//now get the membershipdocument right away with the uuid
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			ResellerSignupDocument resellerSignupDocument = (ResellerSignupDocument) wpm.getObjectByUuid(activationCode);
			if(resellerSignupDocument != null && !(resellerSignupDocument.getIsActive())){
				resellerSignupDocument.setIsActive(true);
				resellerSignupDocument.setEmailCustomerService(emailCustomerService);
				resellerSignupDocument.setEmailFrom(emailFrom);
				resellerSignupDocument.setEmailFromName(emailFromName);
				resellerSignupDocument.setEmailSignature(emailSignature);
				resellerSignupDocument.setEriEnable26ASImport(Boolean.valueOf(eriEnable26ASImport));
				resellerSignupDocument.setEriEnabled(Boolean.valueOf(eriEnabled));
				resellerSignupDocument.setEriPassword(eriPassword);
				resellerSignupDocument.setEriUserId(eriUserId);
				resellerSignupDocument.setIsReseller(Boolean.valueOf(isReseller));
				resellerSignupDocument.setPageTitlePrefix(pageTitlePrefix);
				resellerSignupDocument.setPaymentAvailableTypes(paymentAvailableTypes);
				resellerSignupDocument.setPaymentEnabled(Boolean.valueOf(paymentEnabled));
				resellerSignupDocument.setResellerName(resellerName);
				
				request.setAttribute("userName", resellerSignupDocument.getResellerID());
				if(!(resellerSignupDocument.getResellerID().isEmpty())){
					request.setAttribute("userName", resellerSignupDocument.getResellerID());
					userName = resellerSignupDocument.getResellerID();
				}else
					userName = "User name not found";

			}
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


		  Mount mount = request.getRequestContext().getResolvedMount().getMount();
		  WebsiteInfo info = mount.getChannelInfo();
		response.setRenderParameter(SUCCESS, userName);
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
