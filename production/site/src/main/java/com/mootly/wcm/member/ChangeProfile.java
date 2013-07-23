/*
  * 
  * 
  * Written by abhishek
  * 
  * This coding is done to change name,last name & emails.
  * 
  * 
  */ 
package com.mootly.wcm.member;

import java.io.IOException;
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

import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.GoGreenUtil;

public class ChangeProfile extends BaseComponent {
 private static final Logger log = LoggerFactory.getLogger(ChangePass.class);
 
 public static final String SUCCESS= "success";
 private static final String ERRORS = "errors";
 private static final String FIRST_NAME = "firstName";
 private static final String LAST_NAME = "lastName";
 @Override
 public void doBeforeRender(HstRequest request, HstResponse response) {
  // TODO Auto-generated method stub
  super.doBeforeRender(request, response);
  log.error("This is changepass");
  request.setAttribute("pageName", "Change Password");
  
  request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
 
  
  request.setAttribute(FIRST_NAME, request.getParameterValues(FIRST_NAME));
  request.setAttribute(LAST_NAME, request.getParameterValues(LAST_NAME));
  
 }
 
 @Override
 public void doAction(HstRequest request, HstResponse response)
   throws HstComponentException {
  // TODO Auto-generated method stub
  super.doAction(request, response);
  
  //Any submission will go here
  //String email = GoGreenUtil.getEscapedParameter(request, "email");
  
  String firstName = GoGreenUtil.getEscapedParameter(request, "firstName");
  String lastName = GoGreenUtil.getEscapedParameter(request, "lastName");
  Member member=(Member) request.getSession().getAttribute("user");
  
  if(member!=null)
  {
	  
  List<String> errors=new ArrayList<String>();
  if (StringUtils.isEmpty(firstName)) {
   errors.add("signup.firstName.error.required");
  }

  if (StringUtils.isEmpty(lastName)) {
   errors.add("signup.lastName.error.required");
  }
 
   //if(!mpassword.equals(member))
 log.warn("this is pass"+member.getPassword().toString());
   
  if(errors.size()!=0){
   response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
   
   return;
   }
  
     if (errors == null || errors.size() == 0)
      {
	 
  MemberSignupDocument ms = new MemberSignupDocument();
  ms.setUserName(member.getUserName());
  ms.setFirstName(firstName);
  ms.setLastName(lastName);
  ms.setIsActive(true);
  createMemberSignupFormUpdatePass(request,ms,member);
  
  try{
     response.sendRedirect("/site/memberLogin");
    }
    catch(Exception e)
    {
     log.warn("Error in response Send Url");
    }
   }
  }
  else{
	  try {
		response.sendRedirect("/site/memberLogin");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  }
	  
  }

 private MemberSignupDocument createMemberSignupFormUpdatePass(HstRequest request,MemberSignupDocument signupDocument,Member member) {
  // TODO Auto-generated method stub
  Session persistableSession = null;
  WorkflowPersistenceManager wpm;
  try {
   
   persistableSession = getPersistableSession(request);
   wpm = getWorkflowPersistenceManager(persistableSession);
   //SIMPLE WORKFLOW
   wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
   //final String memberFolderPath = ContentStructure.getMemberFolder(request,signupDocument.getUserName());

	//final String itReturnPath = wpm.createAndReturn(memberFolderPath, MemberSignupDocument.NAMESPACE ,  MemberSignupDocument.NODE_NAME, true);
   final String itReturnPath = "/content/documents/mootlywcm/members/" +member.getUserName()+ "/membersignupdocument/membersignupdocument";
 
   MemberSignupDocument membershipSignupDocument = (MemberSignupDocument) wpm.getObject(itReturnPath);
   // update content properties
   if (membershipSignupDocument != null) {
    
    membershipSignupDocument.setFirstName(signupDocument.getFirstName());
    membershipSignupDocument.setLastName(signupDocument.getLastName());
    membershipSignupDocument.setUserName(signupDocument.getUserName());
    membershipSignupDocument.setIsActive(signupDocument.getIsActive());
    
    // update now           `
    wpm.update(membershipSignupDocument);
    
    return membershipSignupDocument;
   } 
   else 
   {
    log.warn("Failed to add membership document for '{}': could not retrieve Review bean for node '{}'.", MemberSignupDocument.NODE_NAME, itReturnPath);
    GoGreenUtil.refreshWorkflowManager(wpm);
    return membershipSignupDocument;
   }
  }
  catch (Exception e) {
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