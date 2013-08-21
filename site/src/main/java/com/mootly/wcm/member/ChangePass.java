
package com.mootly.wcm.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
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
import com.mootly.wcm.services.SecureHashGeneration;
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
	private static final String OPASSWORD = "Old_Password";
	private static final String NPASSWORD = "New_Password";
	private static final String CONFIRM_PASSWORD = "confirm_password";
	public static final String PASSWORD_ERROR="password_error";
	public static final String USER_NAME = "userName";
	String userNameNormalized=null;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is changepass");
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(PASSWORD_ERROR, request.getParameterValues(PASSWORD_ERROR));
		request.setAttribute(OPASSWORD, request.getParameterValues(OPASSWORD));
		request.setAttribute(NPASSWORD, request.getParameterValues(NPASSWORD));
		request.setAttribute(CONFIRM_PASSWORD, request.getParameterValues(CONFIRM_PASSWORD));
		String change=getPublicRequestParameter(request, "ch");
		String member=getPublicRequestParameter(request, "member");
		if(change!=null&& member!=null){
			try {
				String userName=SecureHashGeneration.simpleBase64Decrytion(member);
				String memberPath=ContentStructure.getMemberFolder(request, userName.replaceAll("@", "-at-"));
				MemberSignupDocument memberFolder=(MemberSignupDocument) getObjectBeanManager(request).getObject(memberPath+"/"+MemberSignupDocument.NODE_NAME);
				if(memberFolder!=null){
					if(memberFolder.getActivationCode().equals(change)){
						request.setAttribute("changePass", "true");
						request.setAttribute("userName", userName);	
					}else{
						request.setAttribute("notify", "true");
					}
				}else{
					request.setAttribute("notify", "true");
				}	
			} catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				log.warn("Error while decrypt the data or get Object from repository",e);
			}
		}

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//Any submission will go here
		//String email = GoGreenUtil.getEscapedParameter(request, "email");
		String Old_Password = GoGreenUtil.getEscapedParameter(request, OPASSWORD);
		String New_Password = GoGreenUtil.getEscapedParameter(request, NPASSWORD);
		String confirm_password = GoGreenUtil.getEscapedParameter(request, CONFIRM_PASSWORD);
		String loggedOffuserName=GoGreenUtil.getEscapedParameter(request, USER_NAME);
		log.info("logged off userName"+loggedOffuserName);
		userNameNormalized = request.getUserPrincipal() != null ? request.getUserPrincipal().getName().replaceAll("@", "-at-") : loggedOffuserName.replaceAll("@", "-at-");
		if(userNameNormalized!=null){
			String pathToSignupDoc=request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath()+"/members/"+userNameNormalized+"/membersignupdocument";
			try {
				MemberSignupDocument objSignup=(MemberSignupDocument)getObjectBeanManager(request).getObject(pathToSignupDoc);
				if(objSignup!=null){
					//check for validation
					List<String> errors=new ArrayList<String>();
					
					if(loggedOffuserName == null){
						if (StringUtils.isEmpty(Old_Password)) {
							errors.add("signup.password.error.required");
						}else{							
                            // here we are matching the current password with the password in repository
							if(!objSignup.getPassword().toString().equals(SecureHashGeneration.passSHAdigest(Old_Password))){
								errors.add("signup.password.error.mismatch");
							}
						}
					}
					if (StringUtils.isEmpty(New_Password)) {
						errors.add("signup.new_password.error.required");
					}
					if (StringUtils.isEmpty(confirm_password)) {
						errors.add("signup.confirm_password.error.required");
					}else{						
						if (!New_Password.equals(confirm_password)){    //here new_password and confirm_password are being matched.
							errors.add("signup.confirm_password.error.mismatch");
						}
					}				
					if(errors.size()!=0){
						response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
						return;
					}else{
						ChangePasswordRequest cp = new ChangePasswordRequest();
						cp.setNewPassword(New_Password);
						cp.setOldPassword(Old_Password);
						cp.setUserName(userNameNormalized);
						ChangePasswordRequest resultChangePassDoc=createMemberSignupFormUpdatePass(request,cp);
						if(resultChangePassDoc!=null){
							Map<String, Object> velocityContext=new HashMap<String, Object>(); //look it need to be change the date according to new implementation							
							velocityContext.put("date", Calendar.getInstance().getTime());
							sendEmail(request,new String[]{userNameNormalized.replaceAll("-at-", "@")}, null, null, "changepass_ack", velocityContext);
						}
						response.sendRedirect(UrlUtility.MemberLogin+"?SUCCESS=CHANGE");
					}
				}
			}catch(IOException e){
				log.warn("Error in response Send Url",e);
			}catch (ObjectBeanManagerException e1) {
				// TODO Auto-generated catch block
				log.warn("Error while decrypt the data or get Object from repository",e1);
			}
		}
	}

	private ChangePasswordRequest createMemberSignupFormUpdatePass(HstRequest request,ChangePasswordRequest cp) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm = null;
		//String changPassword = null;
		//String enableSHASecurity = request.getRequestContext().getResolvedSiteMapItem().getParameter("enableSHASecurity");//important parameter that control save of SHA-Pass 
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession); //SIMPLE WORKFLOW			
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());			
			final String memberitrReturnPath = ContentStructure.getChangePasswordRequest(request, userNameNormalized);//Password gets change in the following path
			final String itrReturnpath = wpm.createAndReturn(memberitrReturnPath, ChangePasswordRequest.NAMESPACE, ChangePasswordRequest.NODE_NAME, true);
			ChangePasswordRequest changepassReqDoc = (ChangePasswordRequest) wpm.getObject(itrReturnpath);
			// update content properties
			final String memberPath = ContentStructure.getSignUpDocumentPath(userNameNormalized);
			if (changepassReqDoc != null) {					
				changepassReqDoc.setNewPassword(SecureHashGeneration.passSHAdigest(cp.getNewPassword().toString()));//SHA-256 encrypted form Password
				changepassReqDoc.setOldPassword(cp.getOldPassword());
				changepassReqDoc.setUserName(cp.getUserName());  
				MemberSignupDocument membershipSignupDocument = (MemberSignupDocument) wpm.getObject(memberPath);
				if (membershipSignupDocument != null) {    // update content properties
					membershipSignupDocument.setPassword(SecureHashGeneration.passSHAdigest(cp.getNewPassword().toString()));
					membershipSignupDocument.setActivationCode(UUID.randomUUID().toString());
					wpm.update(membershipSignupDocument);// update now  
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

	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}
