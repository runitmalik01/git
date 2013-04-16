/*
 * By abhishek
 * This code will work when user click on activation link
 * 30/01/2013
 * 
 */



package com.mootly.wcm.member;
import java.io.IOException;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.SignupDetail.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.utils.GoGreenUtil;

public class Activation extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Activation.class);
	
	public static final String SUCCESS= "success";

	private String Isactive;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		

		log.error("Activation Page");
		request.setAttribute("pageName", "Activation Page");
 	// to get url from activation code
		

		String url=request.getRequestURL().toString();
		
	
		// This method will get parameter from url what we give in arg. as here we are getting activationcode

		String uuid = getPublicRequestParameter(request, "activationcode");
		request.setAttribute("url", url);

		
		if(null != uuid){

			
			// i have use getupdate in place of getactive in memberservice file to update changes.
			
			Member member=MemberService.getActive(request,uuid);
		
			if(member!=null){
				
				log.warn("i have get the activation node");
				if(member.getIsActive().equals(false))
				    {
					log.info("User has been active");
					log.warn("User has been activated");
					
					//here we create an object of membersignupdocument to set is active true 
					
					MemberSignupDocument msd=new MemberSignupDocument();
					msd.setIsActive(true);
			        createMemberSignupUpdate(request,msd,member.getUserName());
			        request.setAttribute("member", member);
					log.warn("User has been activated");
				   }
				if(member.getIsActive().equals(true))
				{
					try {
						response.sendRedirect("/site/errormessage");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
			 }
			else{
				

				log.warn("can not find the activation code in repository");
			    }
		 }
		
	    }
		
	    
	
	//TODO update in the document for user registration
	
	public MemberSignupDocument createMemberSignupUpdate(HstRequest request,MemberSignupDocument msd,String userName){
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try{
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			// here we replace the name of document with this method by which it can identify the username in content folder
			
			final String itReturnPath = "/content/documents/mootlywcm/members/" + userName.replaceAll("@", "-at-") + "/membersignupdocument/membersignupdocument";
			MemberSignupDocument membershipSignupDocument = (MemberSignupDocument) wpm.getObject(itReturnPath);
			if (membershipSignupDocument != null) {
				membershipSignupDocument.setIsActive(msd.getIsActive());
				// update now           `
				wpm.update(membershipSignupDocument);
				return membershipSignupDocument;
			}
			else {
				log.warn("Failed to add membership document for '{}': could not retrieve Review bean for node '{}'.", MemberSignupDocument.NODE_NAME, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return membershipSignupDocument;
			}
		}
		catch(Exception e){
			log.warn("this is error you need to resolve",e);
		   return null;
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
