package com.mootly.wcm.member;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;

public class MemberLogin extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(MemberLogin.class);
	//private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss.SSS";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";

	private static final String SUCCESS = "SUCCESS";
	public static final String ERRORS="errors";
	public static final String LOGIN_ERROR="loginError";
	private static final String EMAIL = "EMAIL";
	private static final String CHANGE = "CHANGE";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(LOGIN_ERROR, request.getParameter(LOGIN_ERROR));
		String cpmsg=getPublicRequestParameter(request, "SUCCESS");
		if(cpmsg!=null){
			if (cpmsg.equals(EMAIL)){
				request.setAttribute("errormsg", "Wealth4India mail you at registered email id to recover password.");
			}
			if(cpmsg.equals(CHANGE)){
				request.setAttribute("errormsg", " Password has been changed successfully.");	
			}		
		}
		try {
			HippoBean siteContentBaseBean = getSiteContentBaseBean(request);
			if (siteContentBaseBean != null) request.setAttribute("siteContentBaseBean", siteContentBaseBean);
		}catch (Exception ex) {
			log.info("Error",ex);
		}
		
		//this is an important enhancement for multi tenant model
		if ( request.getRequestContext().getResolvedMount() != null && request.getRequestContext().getResolvedMount().getMount() != null) {
			String mountIdentifier =  request.getRequestContext().getResolvedMount().getMount().getIdentifier();
			request.setAttribute("mountIdentifier", mountIdentifier);
		}
	}
	
	// Not being used
	// j_security is used by spring security
	/*@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException{
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//Any submission will go here
		log.info("this is Member Login Class");
		String userName = GoGreenUtil.getEscapedParameter(request, "username");
		String password = GoGreenUtil.getEscapedParameter(request, "password");

		List<String> errors = new ArrayList<String>();

		if (StringUtils.isEmpty(userName)) {
			errors.add("signup.userName.error.required");
		}
		if (StringUtils.isEmpty(password)) {
			errors.add("signup.password.error.required");
		}
		if (errors != null && errors.size() > 0) {
			if ( !StringUtils.isEmpty(userName) ) response.setRenderParameter(userName,userName);
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			return;
		}

		Member member=MemberService.getMember(request, userName.toLowerCase());
		if(member==null){
			errors.add("signup.userName.error.exist");
		}
		if (errors != null && errors.size() > 0) {
			if ( !StringUtils.isEmpty(userName) ) response.setRenderParameter(userName,userName);
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			return;
		}
		else {
			if (log.isInfoEnabled()) {
				log.info("Will now convert username to lowercase");
				userName = userName.toLowerCase();
			}
		}
		if(member!=null){
			log.warn("member found at memberLogin");
			if(member.getPassword().toString().equals(password)){
				System.out.println(member.getIsActive());
				if(member.getIsActive().equals(true)){
					try{
						HttpSession session=request.getSession();
						session.setAttribute("user",member);
						ResolvedSiteMapItem siteMapItem = request.getRequestContext().getResolvedSiteMapItem();
						if (log.isInfoEnabled()) {
							log.info("Have got a resolved site item:" + siteMapItem.getPathInfo());
						}
						if (siteMapItem != null) {
							String forwardSuccess = siteMapItem.getLocalParameter("forwardSuccess");
							String forwardSuccessIsRedirect = siteMapItem.getLocalParameter("forwardSuccessIsRedirect");
							if (forwardSuccess != null) {
								boolean forwardSuccessIsRedirectBln = false;
								if (forwardSuccessIsRedirect != null) {
									forwardSuccessIsRedirectBln = Boolean.valueOf(forwardSuccessIsRedirect);
								}
								if (forwardSuccessIsRedirectBln) {
									response.sendRedirect(getResolvedMount(request).getMount().getAlias() + "/" + forwardSuccess);
								}
								else {
									request.getRequestDispatcher(forwardSuccess).forward(request, response);
								}
							}
						}				    
					}
					catch(Exception e){
						log.warn("Page has not been Redirect.",e);
					}
				}
				else{
					log.warn("User not been active.");
					//response.setRenderParameter(LOGIN_ERROR,"Username.or.Password.is.not.active");
				}
			}
			else{
				log.warn("Password has not been Matched.");
				response.setRenderParameter(LOGIN_ERROR,"Username.or.Password.is.not.matched");
			}
		}
		else {
			log.warn("User has not been Registered.");
			response.setRenderParameter(LOGIN_ERROR,"User.has.not.been.Registered");
		}
	}*/


	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}

}
