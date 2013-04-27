/*
 * 
 * here we are resends the activation link to user
 *  by which he can activate his account
 *  @author abhishek
 *  12/03/2013
 *  
 */



package com.mootly.wcm.member;

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
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.VelocityUtils;

public class ActivationCode extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ActivationCode.class);

	public static final String SUCCESS= "success";
	public static final String ERRORS="errors";
	public static final String EMAIL_ERROR="email_error";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.error("This is activationcode page");
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(EMAIL_ERROR, request.getParameterValues(EMAIL_ERROR));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//Any submission will go here (we are getting email)

		String email = GoGreenUtil.getEscapedParameter(request, "email");
		List<String> errors=new ArrayList<String>();

		if(StringUtils.isEmpty(email)){
			errors.add("Enter a valid email");
		}
		if(errors.size()!=0)
		{
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));

			return;
		}

		//Get activecode is used to check whether the user is registered or not
		String pathToMemberSignupDocument = "members/" + email.replaceAll("@", "-at-") + "/membersignupdocument";
		MemberSignupDocument memberSignupDocument =  getSiteContentBaseBean(request).getBean(pathToMemberSignupDocument);

		if(memberSignupDocument!= null)
		{
			if((memberSignupDocument.getEmail().toString()).equalsIgnoreCase(email))
			{
				EmailMessage ms = new EmailMessage();
				ms.setTo(new String[] {email});
				createEmailform(request,ms,memberSignupDocument);
				response.setRenderParameter(SUCCESS, SUCCESS);
				try   
				{
					response.sendRedirect("/site/memberLogin?SUCCESS=SUCCESS");
				}
				catch(Exception e)
				{
					log.warn("Error in response Send Url");
				}
			}
			else{
				log.warn("Email is not found");
				response.setRenderParameter(EMAIL_ERROR, "Your Email is not registered.");
			}
		}
		else
		{
			log.warn("Can not able to get the node");
			response.setRenderParameter(EMAIL_ERROR, "Your Email is not registered.");
		}

	}




	public EmailMessage createEmailform(HstRequest request,EmailMessage msg,MemberSignupDocument member){

		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try{
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());

			Map<String,Object> contextMap = new HashMap<String, Object>();
			//Member object is being used to fetch firstname and password from repository.
			contextMap.put("member", member);
			StringBuffer sbHostName = new StringBuffer();
			sbHostName.append(request.getServerName()).append(":").append(request.getServerPort());
			contextMap.put("memberHostName", sbHostName.toString());

			//It will create a path "content/docunments/mootlywcm/members/activationcode"

			final String memberpath=ContentStructure.getMemberActivationCode(request) + "/activationCode";
			//A node is created at above path with name emailmessage

			final String itReturnPath = wpm.createAndReturn(memberpath, EmailMessage.NAMESPACE , EmailMessage.NODE_NAME, true);
			//It creates an object of EmailMessage type
			EmailMessage emailMessage = (EmailMessage) wpm.getObject(itReturnPath);
			emailMessage.setTemplateKey("activation_code");
			//It will return an object of EmailTemplate at path "content/docunments/mootlywcm/emailtemplate"

			EmailTemplate emailTemplate = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/activation_code");
			if (emailMessage != null) {
				log.error("Email template found");
				log.error("Email template HTML BODY" + emailTemplate.getHtmlBody());
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

		}
		catch(Exception e){
			log.warn("this is error for email",e);
			return null;
		}
		finally {
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
