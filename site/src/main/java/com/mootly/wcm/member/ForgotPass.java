package com.mootly.wcm.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.mootly.wcm.beans.compound.SecurityQuestionAnswerValueList;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.services.SecureHashGeneration;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;
import com.mootly.wcm.utils.VelocityUtils;

public class ForgotPass extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ForgotPass.class);

	public static final String SUCCESS= "success";
	public static final String ERRORS="errors";
	public static final String EMAIL_ERROR="email_error";
	public static final String TARGET_REF_ID="memberchangepass";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);		
		if(request.getUserPrincipal() != null){//If User logged in then this screen should not be accessible to user
			response.setRenderPath("jsp/security/invalidoperation.jsp");
			return;
		}
		String enableSecurityQuestion = request.getRequestContext().getResolvedSiteMapItem().getParameter("enableSecurityQuestion");
		request.setAttribute("enableSecurityQuestion", enableSecurityQuestion); //important parameter decide that Security question will enable or not
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(EMAIL_ERROR, request.getParameterValues(EMAIL_ERROR));
		String securityQues=request.getParameter("securityQuestion");
		String email=request.getParameter("email_ur");
		if(securityQues!=null&& email!=null){
			if(securityQues.equals("true")){
				String pathToMemberSignupDocument = "members/" + email.replaceAll("@", "-at-") + "/membersignupdocument";
				MemberSignupDocument memberSignupDocument =  getSiteContentBaseBeanForReseller(request).getBean(pathToMemberSignupDocument);
				if(memberSignupDocument!=null){
					request.setAttribute("memberSignup", memberSignupDocument);
				}
			}
		}
		request.setAttribute("chError", request.getParameterValues("chError"));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//Any submission will go here
		String pageAction=GoGreenUtil.getEscapedParameter(request, "pageAction");
		if(pageAction.equals("forgotPassHandle")){
			pageActionForgotPasswordHandle(request, response);
		}
		if(pageAction.equals("changePassHandle")){
			pageActionChangePasswordHandle(request, response);	
		}
	}

	/**
	 * This method is used to derived Page Action of User according to Request for Access to Password.
	 * 
	 * @param request {@link HstRequest}
	 * @param response {@link HstResponse}
	 * 
	 * @return {@link Void}
	 * 
	 * */
	public void pageActionForgotPasswordHandle(HstRequest request,HstResponse response){
		String email = GoGreenUtil.getEscapedParameter(request, "email");
		String recoverType=GoGreenUtil.getEscapedParameter(request, "recoverType");
		//check for validation
		List<String> errors=new ArrayList<String>();
		if(StringUtils.isBlank(email)){
			errors.add("signup.email.error.required");
		}
		if(StringUtils.isBlank(recoverType)){
			errors.add("recovery.option.required");
		}
		if(errors.size()!=0){
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			return;
		}
		//Get ForgotPass is used to check whether the user is registered 
		String pathToMemberSignupDocument = "members/" + email.replaceAll("@", "-at-") + "/membersignupdocument";
		MemberSignupDocument memberSignupDocument =  getSiteContentBaseBeanForReseller(request).getBean(pathToMemberSignupDocument);

		if(memberSignupDocument!= null){
			if((memberSignupDocument.getEmail().toString()).equalsIgnoreCase(email)){
				log.info("have security Qyestions for member/request for email "+memberSignupDocument.getSecurityQuestions());
				if(recoverType.equals("via-question") && memberSignupDocument.getSecurityQuestions() && memberSignupDocument.getSecurityQuestionAnswerValueListList().size() > 0
						&& memberSignupDocument.getSecurityQuestionAnswerValueListList() != null){
					response.setRenderParameter("email_ur", email);
					response.setRenderParameter("securityQuestion","true");
					return;
				}else {					
					EmailMessage msg = new EmailMessage();
					msg.setTo(new String[] {email});
					createEmail(request, msg, memberSignupDocument);
					try{
						response.sendRedirect(UrlUtility.MemberLogin+"?SUCCESS=EMAIL");
					} catch(IOException e) {
						log.warn("Error in response Send Url",e);
					}
				}
			}
			else{
				log.info("Email is not found");
				response.setRenderParameter(EMAIL_ERROR, "Your Email is not registered.");
			}
		}
		else{
			log.info("Can not able to get the node");
			response.setRenderParameter(EMAIL_ERROR, "Your Email is not registered.");
		}
	}

	/**
	 * @author Megha
	 * 
	 * This coding is done to send an email to the user's mail id using email template if in case user has forgotten his/her password   
	 * 
	 * 
	 * 
	 */	

	public EmailMessage createEmail(HstRequest request,EmailMessage msg,MemberSignupDocument member){
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try{
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);//SIMPLE WORKFLOW			
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			Map<String,Object> contextMap = new HashMap<String, Object>();//Member object is being used to fetch firstname and password from repository.			
			contextMap.put("member", member);
			StringBuffer sbHostName = new StringBuffer();
			   sbHostName.append(request.getScheme() + "://" +  request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath());
			   if (isReseller() && getResellerId() != null) {
			    sbHostName.append("/r/").append(getResellerId());
			   }
			contextMap.put("memberHostName", sbHostName.toString());
			contextMap.put("encyptUserName", SecureHashGeneration.simpleBase64Encrption(member.getUserName()));
			contextMap.put("emailSignature", "Thank You<br/>Wealth4India Team");// to putting signature in email template
			//It will create a path "content/docunments/mootlywcm/members/forgotpass"
			final String memberpath=ContentStructure.getMemberForgotpass(request,member.getUserName());
			//A node is created at above path with name emailmessage
			final String itReturnPath = wpm.createAndReturn(memberpath, EmailMessage.NAMESPACE , EmailMessage.NODE_NAME, true);
			//It get created object of EmailMessage type
			EmailMessage emailMessage = (EmailMessage) wpm.getObject(itReturnPath);
			emailMessage.setTemplateKey("forgotpass");
			//It will return an object of EmailTemplate at path "content/docunments/mootlywcm/emailtemplate"
			EmailTemplate emailTemplate = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/forgotpass");
			if (emailMessage != null) {
				String htmlBody = VelocityUtils.parseVelocity(emailTemplate.getHtmlBody(), contextMap);
				String plainBody = VelocityUtils.parseVelocity(emailTemplate.getPlainBody(), contextMap);
				String subject = VelocityUtils.parseVelocity(emailTemplate.getSubject(), contextMap);
				emailMessage.setSubject(subject);
				emailMessage.setHtmlBody(htmlBody);
				emailMessage.setPlainBody(plainBody);
				emailMessage.setTo(msg.getTo());
			}
			wpm.update(emailMessage);
			return emailMessage;
		}catch(Exception e){
			log.warn("this is error for email",e);
			return null;
		}
		finally {
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
	/**
	 * This method is used to handle Change Password action of page.
	 * 
	 * @param request {@link HstRequest}
	 * @param response {@link HstResponse}
	 * 
	 * 
	 * */
	public void pageActionChangePasswordHandle(HstRequest request,HstResponse response){
		String secQues=GoGreenUtil.getEscapedParameter(request, "slquestion");
		String secAns=GoGreenUtil.getEscapedParameter(request, "slanswer");
		String userName=GoGreenUtil.getEscapedParameter(request, "userName");
		boolean isRightAnswerOfSlQues = false;
		List<String> errorList =new ArrayList<String>();
		if(StringUtils.isBlank(secAns)){
			errorList.add("answer.required");
		}
		if(StringUtils.isBlank(secQues)){
			errorList.add("question.required");
		}
		if(errorList.size()!=0){
			response.setRenderParameter("email_ur", userName);
			response.setRenderParameter("securityQuestion", "true");
			response.setRenderParameter("chError", errorList.toArray(new String[errorList.size()]));
			return;
		}
		String pathToMemberSignupDocument = "members/" + userName.replaceAll("@", "-at-") + "/" +MemberSignupDocument.NODE_NAME;
		MemberSignupDocument memberSignupDocument =  getSiteContentBaseBeanForReseller(request).getBean(pathToMemberSignupDocument);
		if(memberSignupDocument!=null){
			for(SecurityQuestionAnswerValueList sqValueListDoc:memberSignupDocument.getSecurityQuestionAnswerValueListList()){
				if(sqValueListDoc.getQuestion().equalsIgnoreCase(secQues) && sqValueListDoc.getAnswer().equalsIgnoreCase(secAns)){
					isRightAnswerOfSlQues = true;
				}	
			}
			if(isRightAnswerOfSlQues){
				try {
					String baseTargetPath=MemberSecurity.getTargerPath(request, TARGET_REF_ID);
					String encryptName=SecureHashGeneration.simpleBase64Encrption(userName);
					String chCode=memberSignupDocument.getActivationCode();
					String targetPath=baseTargetPath+"?ch="+chCode+"&member="+encryptName;
					response.sendRedirect(targetPath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error("Error while encrpting the userName or redirection to targetpath",e);
				}
			}else{
				errorList.clear();
				errorList.add("answer.wrong");
				response.setRenderParameter("email_ur", userName);
				response.setRenderParameter("securityQuestion", "true");
				response.setRenderParameter("chError", errorList.toArray(new String[errorList.size()]));
				return;
			}
		}
	}
}
