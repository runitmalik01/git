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

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		if(request.getParameter("emailRegistered") != null){
			request.setAttribute("emailRegistered", request.getParameter("emailRegistered"));
		}
		if(request.getParameter("emailError") != null){
			request.setAttribute("emailError", request.getParameter("emailError"));
		}
		if(request.getParameter("success") != null){
			request.setAttribute("success", request.getParameter("success"));	
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

		String email = GoGreenUtil.getEscapedParameter(request, "email");
		String pathToMemberSignupDocument = "members/" + email.replaceAll("@", "-at-") + "/membersignupdocument";

		MemberSignupDocument memberSignupDocument =  getITRInitData(request).getSiteContentBaseBeanForReseller(request).getBean(pathToMemberSignupDocument);
		if(memberSignupDocument!= null){
			if(!memberSignupDocument.getIsActive()){
				if((memberSignupDocument.getEmail().toString()).equalsIgnoreCase(email)){
					Map<String,Object> velocityContext = new HashMap<String, Object>();
					StringBuffer sbHostName = new StringBuffer();
					sbHostName.append(request.getServerName()).append(":").append(request.getServerPort());
					velocityContext.put("memberHostName", sbHostName.toString());
					velocityContext.put("membershipSignupDocument", memberSignupDocument);
					sendEmail(request, new String[] {email}, null, "", "member_resend_activationcode", velocityContext);
					response.setRenderParameter("success", "success");
				}
				else{
					if(log.isInfoEnabled()){
						log.info("Email not found");	
					}
					response.setRenderParameter("emailError", "email.not.registered");
				}	
			}else{
				if(log.isInfoEnabled()){
					log.info("Already Activated");	
				}
				response.setRenderParameter("emailRegistered", "email.registered");
			}
		}else{
			if(log.isInfoEnabled()){
				log.info("Node not Found");	
			}
			response.setRenderParameter("emailError", "email.not.registered");
		}
	}
}
