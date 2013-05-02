package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
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

public class SignupDetail extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(SignupDetail.class);
	
	//private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss.SSS";
    private static final String EMAIL = "email";
    private static final String CONFIRM_EMAIL = "confirmEmail";
    private static final String PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "confirmPassword";
    private static final String SIGNUP_TERMS = "signupTerms";
    
    private static final String SUCCESS = "success";
    private static final String ERRORS = "errors";
    
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		
		String success=request.getParameter(SUCCESS);
		if (success != null && SUCCESS.equals(success)) {
			response.setRenderPath("jsp/member/signup_success.jsp");
			return;
		}
		
		String[] errors = request.getParameterValues(ERRORS);
		if (errors != null) {
			for (String anError:errors) {
				if (anError.startsWith("signup.email.")) request.setAttribute("emailError",anError);
				else if (anError.startsWith("signup.confirmEmail.")) request.setAttribute("confirmEmailError",anError);
				else if (anError.startsWith("signup.password.")) request.setAttribute("passwordError",anError);
				else if (anError.startsWith("signup.confirm_password.")) request.setAttribute("confirmPasswordError",anError);
				else if (anError.startsWith("signup.terms.")) request.setAttribute("signupTermsError",anError);
			}
		}
		
		//request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
        request.setAttribute(EMAIL, request.getParameter(EMAIL));
        //request.setAttribute(PASSWORD, request.getParameter(PASSWORD));
        //request.setAttribute(CONFIRM_PASSWORD, request.getParameter(CONFIRM_PASSWORD));
       
        request.setAttribute(SUCCESS, request.getParameter(SUCCESS));
        
        try {
        	HippoBean siteContentBaseBean = getSiteContentBaseBean(request);
        	if (siteContentBaseBean != null) request.setAttribute("siteContentBaseBean", siteContentBaseBean);
        }catch (Exception ex) {
        	log.info("Error",ex);
        }
      
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		
		String email = GoGreenUtil.getEscapedParameter(request, EMAIL);
		String confirmEmail = GoGreenUtil.getEscapedParameter(request, CONFIRM_EMAIL);
		String password = GoGreenUtil.getEscapedParameter(request, PASSWORD);
		String confirmPassword = GoGreenUtil.getEscapedParameter(request, CONFIRM_PASSWORD);
		String signupTerms = GoGreenUtil.getEscapedParameter(request, SIGNUP_TERMS);
		//String passwordReminder = GoGreenUtil.getEscapedParameter(request, "passwordReminder");
		
		List<String> errors = new ArrayList<String>();
		
		if (StringUtils.isEmpty(email) || email.indexOf("@")==-1) {
			errors.add("signup.email.error.required");
		}
		
		if (StringUtils.isEmpty(confirmEmail) || confirmEmail.indexOf("@")==-1) {
			errors.add("signup.confirmEmail.error.required");
		}
		
		if (StringUtils.isEmpty(password)) {
			errors.add("signup.password.error.required");
		}
		
		if (StringUtils.isEmpty(signupTerms)) {
			errors.add("signup.terms.error.required");
		}
		
		
		if (StringUtils.isEmpty(confirmPassword)) {
			errors.add("signup.confirm_password.error.required");
		}
		else {
			if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(confirmPassword)){
				if (!password.equals(confirmPassword)){
					errors.add("signup.confirm_password.error.mismatch");
				}
			}
		}
		
		if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(confirmEmail)){
			if (!email.equals(confirmEmail)){
				errors.add("signup.confirmEmail.error.mismatch");
			}
		}
		
		
		if (errors != null && errors.size() > 0) {
			response.setRenderParameter(EMAIL, email);
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			return;
		}
		// this method fetch username from repository and check whether exist or not
		
		Member member = MemberService.getMember(request, email.toLowerCase());
		if (member != null) {
			errors.add("signup.email.error.alreadyRegistered");
		}		
		if (errors != null && errors.size() > 0 ){
	            response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
	            response.setRenderParameter(EMAIL, email);
	            //response.setRenderParameter(PASSWORD, password);
	            //response.setRenderParameter(CONFIRM_PASSWORD, confirm_password);
	            response.setRenderParameter(EMAIL, email);
	    
	            for (String error:errors) {
	            	log.warn(error);
	            }
	            return;
		}
		
		if (errors == null || errors.size() == 0) 
		{
			// here we are creating object of membersignupdocument  for craeting documents.
			MemberSignupDocument ms = new MemberSignupDocument();
			ms.setUserName(email.toLowerCase());
			ms.setPassword(password);
			ms.setEmail(email.toLowerCase());
			createMemberSignupForm(request,ms,member);
		}		
		response.setRenderParameter(SUCCESS, SUCCESS);
		/*
		try {
			
			// after signup it show a message to user about activate account
			response.sendRedirect("/site/message");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.warn("can't redirect");
		}
		*/
	}
	
	private MemberSignupDocument createMemberSignupForm(HstRequest request,MemberSignupDocument signupDocument,Member member) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		String finalMembershipDocumentPath = null;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			final String memberFolderPath = ContentStructure.getMemberFolder(request,signupDocument.getUserName());
			finalMembershipDocumentPath = wpm.createAndReturn(memberFolderPath, MemberSignupDocument.NAMESPACE ,  MemberSignupDocument.NODE_NAME, true);
			MemberSignupDocument membershipSignupDocument = (MemberSignupDocument) wpm.getObject(finalMembershipDocumentPath);
			// update content properties
			if (membershipSignupDocument != null) {
				membershipSignupDocument.setUserName(signupDocument.getUserName());
				membershipSignupDocument.setPassword(signupDocument.getPassword());
				membershipSignupDocument.setEmail(signupDocument.getEmail());
				membershipSignupDocument.setRoles(new String[]{"unverifiedmember"});
				membershipSignupDocument.setActivationCode(UUID.randomUUID().toString());
				membershipSignupDocument.setIsActive(false);
				// update now           `
				wpm.update(membershipSignupDocument);
				MemberSignupDocument publishedSignUpDocument = (MemberSignupDocument) wpm.getObject(finalMembershipDocumentPath); // getSiteContentBaseBean(request).getBean("member/" + signupDocument.getUserName().replaceAll("@","-at-") + "/membersignupdocument");
				if (publishedSignUpDocument == null) return null;//major screwup
				//persistableSession = getPersistableSession(request);
				//wpm = getWorkflowPersistenceManager(persistableSession);
				//also queue up the message for welcome
				//first find the template membership_signup, this template is under emailtemplates folder
				//SIMPLE WORKFLOW
				Map<String,Object> contextMap = new HashMap<String, Object>();
				contextMap.put("membershipSignupDocument", publishedSignUpDocument);
				contextMap.put("member", member);
				StringBuffer sbHostName = new StringBuffer();
				sbHostName.append(request.getServerName()).append(":").append(request.getServerPort());
				
				contextMap.put("memberHostName", sbHostName.toString());
				String pathToNewNode = wpm.createAndReturn(memberFolderPath +"/emails", EmailMessage.NAMESPACE, "activation_link", true);
				EmailMessage emailMessage = (EmailMessage) wpm.getObject(pathToNewNode);
				emailMessage.setTo(new String[]{membershipSignupDocument.getEmail()});
				emailMessage.setTemplateKey("member_signup");
				// here we are creating template for email.
				
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
			}
			return null;
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
