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

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.GoGreenUtil;

public class ActivationCode extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ActivationCode.class);

	public static final String SUCCESS= "success";
	public static final String ERRORS="errors";
	public static final String EMAIL_ERROR="email_error";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
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
				Map<String,Object> velocityContext = new HashMap<String, Object>();
				StringBuffer sbHostName = new StringBuffer();
				sbHostName.append(request.getServerName()).append(":").append(request.getServerPort());
				velocityContext.put("memberHostName", sbHostName.toString());
				velocityContext.put("membershipSignupDocument", memberSignupDocument);
				sendEmail(request, new String[] {email}, null, "", "member_resend_activationcode", velocityContext);
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

}
