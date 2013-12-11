
package com.mootly.wcm.reseller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.beans.VendorSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.GoGreenUtil;

public class ReActivation extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ReActivation.class);

	public static final String SUCCESS= "success";
	public static final String ERRORS="errors";
	public static final String EMAIL_ERROR="email_error";
	public static final String RESELLER_ERROR="reseller_error";
	public static final String RESELLER_ACTIVATION="reseller_acvtivation";

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		String success=request.getParameter(SUCCESS);
		if (success != null && SUCCESS.equals(success)) {
			request.setAttribute(SUCCESS, request.getParameterValues(success));
		}
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(EMAIL_ERROR, request.getParameterValues(EMAIL_ERROR));
		request.setAttribute(RESELLER_ERROR, request.getParameterValues(RESELLER_ERROR));
		request.setAttribute(RESELLER_ACTIVATION, request.getParameterValues(RESELLER_ACTIVATION));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//Any submission will go here (we are getting email)

		//String email = GoGreenUtil.getEscapedParameter(request, "email");
		String resellerID = GoGreenUtil.getEscapedParameter(request, "resellerID");
		List<String> errors=new ArrayList<String>();

		//	if(StringUtils.isEmpty(email)){
		//	errors.add("Enter a valid email");
		//	}
		if(StringUtils.isEmpty(resellerID)){
			errors.add("Enter a valid Reseller ID");
		}
		if(errors.size()!=0)
		{
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			return;
		}

		//Get activecode is used to check whether the user is registered or not
		String pathToResellerSignupDocument = resellerID + "/admin/resellersignupdocument";
		HippoBean siteContentBaseBean = getSiteContentBaseBean(request);
		if (siteContentBaseBean != null) request.setAttribute("siteContentBaseBean", siteContentBaseBean);
		if (siteContentBaseBean != null) {
			HippoBean resellersBean = siteContentBaseBean.getBean("resellers");
			if (resellersBean != null) {
				if(resellersBean instanceof HippoFolder){
					if(resellersBean.getBean(resellerID)==null){
						response.setRenderParameter(RESELLER_ERROR, "Reseller ID is not registered.");
					}else if(resellersBean.getBean(resellerID)!=null){
						ResellerSignupDocument resellerSignupDocument = resellersBean.getBean(pathToResellerSignupDocument);
						if(resellerSignupDocument!= null)
						{
							if(!resellerSignupDocument.getIsActive()){
								Map<String,Object> velocityContext = new HashMap<String, Object>();
								StringBuffer sbHostName = new StringBuffer();
								sbHostName.append(request.getServerName()).append(":").append(request.getServerPort());
								velocityContext.put("memberHostName", sbHostName.toString());
								velocityContext.put("resellershipSignupDocument", resellerSignupDocument);
								sendEmail(request,new String[]{resellerSignupDocument.getEmail()}, null, "", "reseller_resend_activationcode", velocityContext);
								response.setRenderParameter(SUCCESS, SUCCESS);
							}else{
								response.setRenderParameter(RESELLER_ACTIVATION, "Reseller ID is already activated.");
							}
						}
						else
						{
							log.warn("Can not able to get the node");
							response.setRenderParameter(RESELLER_ERROR, "Reseller ID is not registered.");
						}
					}
				}
			}
		}
	}
}
