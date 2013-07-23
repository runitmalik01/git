/*
  * 
  * 
  * Written by Abhishek Bhardwaj
  * 
  * This coding is done to change email
  * 11/02/2013
  * 
  * 
  */ 
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

import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;

public class ChangeEmail extends BaseComponent {
 private static final Logger log = LoggerFactory.getLogger(ChangeEmail.class);
 
 public static final String SUCCESS= "success";
 public static final String ERRORS="errors";
 private static final String EMAIL = "email";
 private static final String C_EMAIL = "c_email";
 private static final String NEW_EMAIL = "new_email";
 private static final String CON_EMAIL = "con_email";
 
 @Override
 public void doBeforeRender(HstRequest request, HstResponse response) {
  // TODO Auto-generated method stub
  super.doBeforeRender(request, response);
  log.error("This is abhishek.................");
  System.out.println("this is change email");
  request.setAttribute("pageName", "Change Password");
  request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
  request.setAttribute(EMAIL, request.getParameterValues(EMAIL));
  request.setAttribute(C_EMAIL, request.getParameterValues(C_EMAIL));
  request.setAttribute(NEW_EMAIL, request.getParameterValues(NEW_EMAIL));
  request.setAttribute( CON_EMAIL, request.getParameterValues(CON_EMAIL));
  
 }
 
 @Override
 public void doAction(HstRequest request, HstResponse response)
   throws HstComponentException {
  // TODO Auto-generated method stub
  super.doAction(request, response);
  System.out.println("this is change email forrrrrrrrrrrrrrrmmmmmmmmm");
  //Any submission will go here
  String email = GoGreenUtil.getEscapedParameter(request, "email");
  
  String c_email = GoGreenUtil.getEscapedParameter(request, "c_email");
  String new_email = GoGreenUtil.getEscapedParameter(request, "new_email");
  String con_email = GoGreenUtil.getEscapedParameter(request, "con_email");
  
  Member member= MemberService.getForgotPass(request, email);
  
  
  List<String> errors=new ArrayList<String>();
   
  if (StringUtils.isEmpty(c_email)) {
	   errors.add("signup.c_email.error.required");
	  }
  if (StringUtils.isEmpty(new_email)) {
   errors.add("signup.email.error.required");
  }
  if (StringUtils.isEmpty(con_email)) {
   errors.add("signup.email.error.required");
  }
  
    if (!new_email.equals(con_email)){
    errors.add("signup.confirm_email.error.mismatch");
   }

   //if(!mpassword.equals(member))
 log.warn("this is pass"+member.getEmail());
 System.out.println("this is"+member.getEmail());
  if(!member.getEmail().equals(c_email)){
	  System.out.println("this is inside member%%%%%%%%%%%$$$$$$$$$$$$............%%%%%%%%%%%%%");
    errors.add("signup.email.error.mismatch");
   }else
   {
	   System.out.println("this is else");
   }
  if(errors.size()!=0  && errors.size() > 0 )
  {
	  System.out.println("this is inside error%%%%%%%%%%%$$$$$$$$$$$$............%%%%%%%%%%%%%");
   response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
   
   response.setRenderParameter(C_EMAIL, c_email);
   response.setRenderParameter(NEW_EMAIL, new_email);
   response.setRenderParameter(CON_EMAIL, con_email);
   

   for (String error:errors) {
   	log.warn(error);
   }
   
   return;
   }
  
    if (errors == null || errors.size() == 0)
      {
    	System.out.println("this is creating document with object ms............%%%%%%%%%%%%%");
     MemberSignupDocument ms = new MemberSignupDocument();
  
      ms.setEmail(con_email);
      createMemberSignupFormUpdatePass(request,ms,member);
  
  try{
     response.sendRedirect("/site/changeprofile");
    }
    catch(Exception e)
    {
     log.warn("Error in response Send Url");
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
  
  // final String itReturnPath = "/content/documents/mootlywcm/members/" +member.getuserName()+ "/membersignupdocument/membersignupdocument";
   final String memberFolderPath = ContentStructure.getMemberFolder(request,signupDocument.getUserName());

	final String itReturnPath = wpm.createAndReturn(memberFolderPath, MemberSignupDocument.NAMESPACE ,  MemberSignupDocument.NODE_NAME, true);
	/*
	HippoFolder hippoFolder = (HippoFolder) wpm.getObject(itReturnFolderPath);
	List<HippoTranslation> hippoTranslations = hippoFolder.getChildBeansByName("hippo:translation");
	if (hippoTranslations != null && hippoTranslations.size() > 0) {
		for (HippoTranslation translation:hippoTranslations) {
			if (translation.getProperty("locale","").equals("en")) {
			}
		}
	}
	*/
   MemberSignupDocument membershipSignupDocument = (MemberSignupDocument) wpm.getObject(itReturnPath);
   // update content properties
   if (membershipSignupDocument != null) {
    
    membershipSignupDocument.setEmail(signupDocument.getEmail());
    
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