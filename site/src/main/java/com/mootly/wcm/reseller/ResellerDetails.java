/*
 * By Dhananjay
 * This code will work when user click on activation link
 * 10/12/2013
 * 
 */



package com.mootly.wcm.reseller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.jcr.Session;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.SignupDetail.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.MootlyFormUtils;

public class ResellerDetails extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ResellerDetails.class);

	private static final String EMAILCUSTOMERSERVICE = "emailCustomerService";
	private static final String EMAILFROM = "emailFrom";
	private static final String EMAILFROMNAME = "emailFromName";
	private static final String EMAILSIGNATURE = "emailSignature";
	private static final String ERIENABLE26ASIMPORT = "eriEnable26ASImport";
	private static final String ERIENABLED = "eriEnabled";
	private static final String ERIPASSWORD = "eriPassword";
	private static final String ERIUSERID = "eriUserId";
	private static final String ISRESELLER = "isReseller";
	private static final String PAGETITLEPREFIX = "pageTitlePrefix";
	private static final String PAYMENTAVAILABLETYPES = "paymentAvailableTypes";
	private static final String PAYMENTENABLED = "paymentEnabled";
	private static final String RESELLERNAME = "resellerName";

	public static final String SUCCESS= "success";

	private String Isactive;
	private String resellerId;
	FormMap savedValuesFormMap=null;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		String success=request.getParameter(SUCCESS);
		if (success != null) {
			request.setAttribute(SUCCESS, success);
			return;
		}

		String publicParameterUUID = getPublicRequestParameter(request, "uuid");
		if(publicParameterUUID == null){
			request.setAttribute("isError", "true");
			request.setAttribute("errorCode", "error.uuid.missing");
			return;
		}

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);

		String emailCustomerService = GoGreenUtil.getEscapedParameter(request, EMAILCUSTOMERSERVICE);
		String emailFrom = GoGreenUtil.getEscapedParameter(request, EMAILFROM);
		String emailFromName = GoGreenUtil.getEscapedParameter(request, EMAILFROMNAME);
		String emailSignature = GoGreenUtil.getEscapedParameter(request, EMAILSIGNATURE);
		String eriEnable26ASImport = GoGreenUtil.getEscapedParameter(request, ERIENABLE26ASIMPORT);
		String eriEnabled = GoGreenUtil.getEscapedParameter(request, ERIENABLED);
		String eriPassword = GoGreenUtil.getEscapedParameter(request, ERIPASSWORD);
		String eriUserId = GoGreenUtil.getEscapedParameter(request, ERIUSERID);
		String isReseller = GoGreenUtil.getEscapedParameter(request, ISRESELLER);
		String pageTitlePrefix = GoGreenUtil.getEscapedParameter(request, PAGETITLEPREFIX);
		String[] paymentAvailableTypes = GoGreenUtil.getEscapedParameterValues(request, PAYMENTAVAILABLETYPES);
		String paymentEnabled = GoGreenUtil.getEscapedParameter(request, PAYMENTENABLED);
		String resellerName = GoGreenUtil.getEscapedParameter(request, RESELLERNAME);

		String publicParameterUUID = getPublicRequestParameter(request, "uuid");
		if (publicParameterUUID != null) {
			try {
				FormUtils.validateId(publicParameterUUID);
				savedValuesFormMap = new FormMap(request,new String[]{"resellerID","phoneCustomerService","email","confirmEmail","password","confirmPassword","signupTerms"});
				MootlyFormUtils.populate(request, publicParameterUUID, savedValuesFormMap);
				resellerId = savedValuesFormMap.getField("resellerID").getValue();
			}catch (IllegalArgumentException ie) {
				publicParameterUUID = null;
			}
		}

		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		String finalResellershipDocumentPath = null;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String cPath =request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath()+"/resellers/"+resellerId; //getCanonicalBasePathForWrite(request);
			final String memberFolderPath = cPath + "/" + ContentStructure.RESELLER_FOLDER_NAME;//ContentStructure.getMemberFolder(request,signupDocument.getUserName());
			finalResellershipDocumentPath = wpm.createAndReturn(memberFolderPath, ResellerSignupDocument.NAMESPACE ,  ResellerSignupDocument.NODE_NAME, true);
			ResellerSignupDocument resellershipSignupDocument = (ResellerSignupDocument) wpm.getObject(finalResellershipDocumentPath);
			// update content properties
			if (resellershipSignupDocument != null) {
				resellershipSignupDocument.setResellerID(resellerId);
				resellershipSignupDocument.setPhoneCustomerService(savedValuesFormMap.getField("phoneCustomerService").getValue());
				resellershipSignupDocument.setUserName(savedValuesFormMap.getField("email").getValue());
				resellershipSignupDocument.setPassword(savedValuesFormMap.getField("password").getValue());
				resellershipSignupDocument.setEmail(savedValuesFormMap.getField("email").getValue());
				resellershipSignupDocument.setEmailCustomerService(emailCustomerService);
				resellershipSignupDocument.setEmailFrom(emailFrom);
				resellershipSignupDocument.setEmailFromName(emailFromName);
				resellershipSignupDocument.setEmailSignature(emailSignature);
				resellershipSignupDocument.setEriEnable26ASImport(Boolean.valueOf(eriEnable26ASImport));
				resellershipSignupDocument.setEriEnabled(Boolean.valueOf(eriEnabled));
				resellershipSignupDocument.setEriPassword(eriPassword);
				resellershipSignupDocument.setEriUserId(eriUserId);
				resellershipSignupDocument.setIsReseller(Boolean.valueOf(true));
				resellershipSignupDocument.setPageTitlePrefix(pageTitlePrefix);
				resellershipSignupDocument.setPaymentAvailableTypes(paymentAvailableTypes);
				resellershipSignupDocument.setPaymentEnabled(Boolean.valueOf(paymentEnabled));
				resellershipSignupDocument.setResellerName(resellerName);
				resellershipSignupDocument.setResellerPackage("trialPeriod");
				resellershipSignupDocument.setNumberOfLicensedUsers("0");
				resellershipSignupDocument.setActivationCode(UUID.randomUUID().toString());
				resellershipSignupDocument.setIsActive(false);
				// update now           `
				wpm.update(resellershipSignupDocument);
				ResellerSignupDocument publishedSignUpDocument = (ResellerSignupDocument) wpm.getObject(finalResellershipDocumentPath); // getSiteContentBaseBean(request).getBean("member/" + signupDocument.getUserName().replaceAll("@","-at-") + "/membersignupdocument");

				Map<String,Object> contextMap = new HashMap<String, Object>();
				contextMap.put("resellerID", resellershipSignupDocument.getResellerID());
				contextMap.put("phoneCustomerService", resellershipSignupDocument.getPhoneCustomerService());
				contextMap.put("userName", resellershipSignupDocument.getUserName());
				contextMap.put("emailID", resellershipSignupDocument.getEmail());
				contextMap.put("resellershipSignupDocument", publishedSignUpDocument);
				sendEmail(request, null, null, "", "reseller_signup", contextMap);
			}
		} catch (Exception e) {
			log.warn("Failed to signup member ", e);
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}

		response.setRenderParameter(SUCCESS, "success");
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
