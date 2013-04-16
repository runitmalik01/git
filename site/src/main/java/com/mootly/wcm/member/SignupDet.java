package com.mootly.wcm.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.mootly.wcm.beans.EmailMessage;
import com.mootly.wcm.beans.EmailTemplate;
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.VelocityUtils;

public class SignupDet extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(SignupDet.class);
	
	//private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss.SSS";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "confirm_password";
    private static final String EMAIL = "userName";
    
    private static final String SUCCESS = "success";
    private static final String ERRORS = "errors";
    
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
        request.setAttribute(USER_NAME, request.getParameter(USER_NAME));
        request.setAttribute(PASSWORD, request.getParameter(PASSWORD));
        request.setAttribute(CONFIRM_PASSWORD, request.getParameter(CONFIRM_PASSWORD));
        request.setAttribute(EMAIL, request.getParameter(USER_NAME));
       
        request.setAttribute(SUCCESS, request.getParameter(SUCCESS));
      
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		
		String userName = GoGreenUtil.getEscapedParameter(request, "userName");
		String password = GoGreenUtil.getEscapedParameter(request, "password");
		String confirm_password = GoGreenUtil.getEscapedParameter(request, "confirm_password");
		//String email = GoGreenUtil.getEscapedParameter(request, "userName");
		// Create suName to check userName validation
		//String suName ="(?=.*[a-zA-Z])[a-zA-Z0-9_]{1}[_a-zA-Z0-9\\s]{6,24}";
		
		
		//String passwordReminder = GoGreenUtil.getEscapedParameter(request, "passwordReminder");
		
		List<String> errors = new ArrayList<String>();
		
		if (StringUtils.isEmpty(userName) || userName.indexOf("@")==-1) {
		
			errors.add("signup.userName.error.required");
		}
		//if (userName.matches(suName)){
		//}
		//else{
		//	errors.add("signup.userName.error.invalidFormat");
		//}
		
		if (StringUtils.isEmpty(password)) {
			errors.add("signup.password.error.required");
		}
		if (StringUtils.isEmpty(confirm_password)) {
			errors.add("signup.confirm_password.error.required");
		}
		
		
		if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(confirm_password)){
			if (!password.equals(confirm_password)){
				errors.add("signup.confirm_password.error.mismatch");
			}
			
		}
		
		Member member = MemberService.getMember(request, userName);
		if (member != null) {
			errors.add("signup.userName.error.alreadyTaken");
		}		
		if (errors != null && errors.size() > 0 ){
	            response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
	            response.setRenderParameter(USER_NAME, userName);
	            response.setRenderParameter(PASSWORD, password);
	            response.setRenderParameter(CONFIRM_PASSWORD, confirm_password);
	            response.setRenderParameter(EMAIL, userName);
	    
	            for (String error:errors) {
	            	log.warn(error);
	            }
	            return;
		}
		
		if (errors == null || errors.size() == 0) {
			MemberSignupDocument ms = new MemberSignupDocument();
			ms.setUserName(userName);
			ms.setPassword(password);
			ms.setEmail(userName);
			
			
			createMemberSignupForm(request,ms);
		}		
		response.setRenderParameter(SUCCESS, SUCCESS);
		try {
			response.sendRedirect("/site/message");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.warn("can't redirect");
		}
	}
	
	private MemberSignupDocument createMemberSignupForm(HstRequest request,MemberSignupDocument signupDocument) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
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
				membershipSignupDocument.setUserName(signupDocument.getUserName());
				membershipSignupDocument.setPassword(signupDocument.getPassword());
				membershipSignupDocument.setEmail(signupDocument.getEmail());
				membershipSignupDocument.setFirstName(signupDocument.getFirstName());
				membershipSignupDocument.setLastName(signupDocument.getLastName());
				membershipSignupDocument.setRoles(new String[]{"unverifiedmember"});
				membershipSignupDocument.setActivationCode(UUID.randomUUID().toString());
				membershipSignupDocument.setIsActive(false);
				
				// update now           `
				wpm.update(membershipSignupDocument);
				
				//persistableSession = getPersistableSession(request);
				//wpm = getWorkflowPersistenceManager(persistableSession);
				//also queue up the message for welcome
				//first find the template membership_signup, this template is under emailtemplates folder
				Map<String,Object> contextMap = new HashMap<String, Object>();
				contextMap.put("membershipSignupDocument", membershipSignupDocument);
				
				String pathToNewNode = wpm.createAndReturn(memberFolderPath +"/emails", EmailMessage.NAMESPACE, "activation_link", true);
				EmailMessage emailMessage = (EmailMessage) wpm.getObject(pathToNewNode);
				emailMessage.setTo(new String[]{membershipSignupDocument.getEmail()});
				emailMessage.setTemplateKey("member_signup");
				
				EmailTemplate emailTemplate = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/member_signup");
				if (emailTemplate != null) {
					log.error("Email template found");
					log.error("Email template HTML BODY" + emailTemplate.getHtmlBody());
					String htmlBody = VelocityUtils.parseVelocity(emailTemplate.getHtmlBody(), contextMap);
					String plainBody = VelocityUtils.parseVelocity(emailTemplate.getPlainBody(), contextMap);
					String subject = VelocityUtils.parseVelocity(emailTemplate.getSubject(), contextMap);
					emailMessage.setSubject(subject);
					emailMessage.setHtmlBody(htmlBody);
					emailMessage.setPlainBody(plainBody);
				}
				else {
					emailMessage.setSubject("This is TEST, Welcome to MOOTLY");
					emailMessage.setHtmlBody("<B>COOL</B>");
				}
				wpm.update(emailMessage);
				
				return membershipSignupDocument;
			} else {
				log.warn("Failed to add membership document for '{}': could not retrieve Review bean for node '{}'.", MemberSignupDocument.NODE_NAME, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return membershipSignupDocument;
			}
		} catch (Exception e) {
			log.warn("Failed to signup member ", e);
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
	
	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
	
}
