
package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ChangePasswordRequest;
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;


/*
 * 
 * 

 * Written by Megha
 * This coding is done to change password
 * 
 * 
 */	
public class ChangePass extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ChangePass.class);
	//password defined here is denoting the password in repository
	// mpassword is the current password

	public static final String SUCCESS= "success";
	public static final String ERRORS="errors";
	private static final String PASSWORD = "Password";
	private static final String MPASSWORD = "Old_Password";
	private static final String NPASSWORD = "New_Password";
	private static final String CONFIRM_PASSWORD = "confirm_password";
	public static final String PASSWORD_ERROR="password_error";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is changepass");
		request.setAttribute("pageName", "Change Password");

		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(PASSWORD_ERROR, request.getParameterValues(PASSWORD_ERROR));
		request.setAttribute(MPASSWORD, request.getParameterValues(MPASSWORD));
		request.setAttribute(NPASSWORD, request.getParameterValues(NPASSWORD));
		request.setAttribute(CONFIRM_PASSWORD, request.getParameterValues(CONFIRM_PASSWORD));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

		//Any submission will go here
		//String email = GoGreenUtil.getEscapedParameter(request, "email");

		String Old_Password = GoGreenUtil.getEscapedParameter(request, "Old_Password");
		String New_Password = GoGreenUtil.getEscapedParameter(request, "New_Password");
		String confirm_password = GoGreenUtil.getEscapedParameter(request, "confirm_password");

		Member member=(Member)request.getSession().getAttribute("user");
		if(member!=null){
			//check for validation
			List<String> errors=new ArrayList<String>();

			if (StringUtils.isEmpty(Old_Password)) {
				errors.add("signup.password.error.required");
			}

			if (StringUtils.isEmpty(New_Password)) {
				errors.add("signup.password.error.required");
			}
			if (StringUtils.isEmpty(confirm_password)) {
				errors.add("signup.confirm_password.error.required");
			}
			//here new_password and confirm_password are being matched.
			if (!New_Password.equals(confirm_password)){
				errors.add("signup.confirm_password.error.mismatch");
			}
			// here we are matching the current password with the password in repository
			log.info("this is pass"+member.getPassword().toString());
			if(!member.getPassword().toString().equals(Old_Password)){
				errors.add("signup.password.error.mismatch");
			}
			if(errors.size()!=0){
				response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));

				return;
			}

			if (errors == null || errors.size() == 0)
			{
				ChangePasswordRequest cp = new ChangePasswordRequest();

				cp.setNewPassword(New_Password);
				cp.setOldPassword(Old_Password);
				cp.setUserName(member.getUserName().toString());
				createMemberSignupFormUpdatePass(request,cp,member.getUserName());

				try{  
					response.sendRedirect(UrlUtility.MemberLogin);
					request.getSession(false);
				}
				catch(Exception e)
				{
					log.warn("Error in response Send Url");
				}
			}

		}
		else{

			log.info("Error in response Send Url");
		}
	}

	private ChangePasswordRequest createMemberSignupFormUpdatePass(HstRequest request,ChangePasswordRequest cp,String username) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		//member.getUserName().toString()
		try {
			log.info("create method");
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			//Password gets change in the following path
			final String memberitrReturnPath = ContentStructure.getChangePasswordRequest(request,username);
			final String itrReturnpath = wpm.createAndReturn(memberitrReturnPath, ChangePasswordRequest.NAMESPACE, ChangePasswordRequest.NODE_NAME, true);
			ChangePasswordRequest changepassReqDoc = (ChangePasswordRequest) wpm.getObject(itrReturnpath);
			// update content properties
			log.info("i am going to update ");
			final String itReturnPath = "/content/documents/mootlywcm/members/"+username.replaceAll("@", "-at-")+ "/membersignupdocument/membersignupdocument";
			if (changepassReqDoc != null) {	
				changepassReqDoc.setNewPassword(cp.getNewPassword());
				changepassReqDoc.setOldPassword(cp.getOldPassword());
				changepassReqDoc.setUserName(cp.getUserName());
				// update now     
				MemberSignupDocument membershipSignupDocument = (MemberSignupDocument) wpm.getObject(itReturnPath);
				// update content properties
				if (membershipSignupDocument != null) {
					membershipSignupDocument.setPassword(cp.getNewPassword().toString());
					// update now           `
					wpm.update(membershipSignupDocument);
				} 
			} 
			wpm.update(changepassReqDoc);
			wpm.save();
			return changepassReqDoc;

		} catch (Exception e) {
			log.warn("Failed to change password ", e);
			return null;
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}    
	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}

	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}
