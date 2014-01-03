
package com.mootly.wcm.reseller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.component.support.forms.StoreFormResult;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;

public class ResellerSignup extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ResellerSignup.class);

	//private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss.SSS";
	private static final String RESELLERID = "resellerID";
	private static final String PHONECUSTOMERSERVICE = "phoneCustomerService";
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
				else if (anError.startsWith("signup.resellerID.")) request.setAttribute("resellerIDError",anError);
				else if (anError.startsWith("signup.phoneCustomerService.")) request.setAttribute("phoneCustomerServiceError",anError);
			}
		}

		request.setAttribute(EMAIL, request.getParameter(EMAIL));
		request.setAttribute(SUCCESS, request.getParameter(SUCCESS));

		try {
			HippoBean siteContentBaseBean = getSiteContentBaseBeanForReseller(request);
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
		String resellerID = GoGreenUtil.getEscapedParameter(request, RESELLERID);
		String phoneCustomerService = GoGreenUtil.getEscapedParameter(request, PHONECUSTOMERSERVICE);
		//String passwordReminder = GoGreenUtil.getEscapedParameter(request, "passwordReminder");

		List<String> errors = new ArrayList<String>();

		if (StringUtils.isEmpty(email) || email.indexOf("@")==-1) {
			errors.add("signup.email.error.required");
		}

		if (StringUtils.isEmpty(resellerID)) {
			errors.add("signup.resellerID.error.required");
		}

		if (StringUtils.isEmpty(phoneCustomerService)) {
			errors.add("signup.phoneCustomerService.error.required");
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
		else {
			email = email.toLowerCase();
			confirmEmail = confirmEmail.toLowerCase();
		}
		// this method fetch username from repository and check whether exist or not

		try {
			HippoBean siteContentBaseBean = getSiteContentBaseBean(request);
			if (siteContentBaseBean != null) request.setAttribute("siteContentBaseBean", siteContentBaseBean);
			if (siteContentBaseBean != null) {
				HippoBean resellersBean = siteContentBaseBean.getBean("resellers");
				if (resellersBean != null) {
					if(resellersBean instanceof HippoFolder){
						if(resellersBean.getBean(resellerID)!=null){
							errors.add("signup.resellerID.error.alreadyRegistered");
						}
					}
				}
			}
		}catch (Exception ex) {
			log.info("Error",ex);
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

		FormMap map = new FormMap(request,new String[]{"resellerID","phoneCustomerService","email","confirmEmail","password","confirmPassword","signupTerms"});
		StoreFormResult sfr = new StoreFormResult();				
		FormUtils.persistFormMap(request, response, map, sfr);
		HstLink link = request.getRequestContext().getHstLinkCreator().createByRefId("reseller-details", request.getRequestContext().getResolvedMount().getMount());
		String urlToRedirect = link.toUrlForm(request.getRequestContext(), true)+"?uuid=" +  sfr.getUuid();
		if (log.isInfoEnabled()) {
			log.info("URL to redirect ::"+urlToRedirect);
		}
		try {
			response.sendRedirect(urlToRedirect);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
