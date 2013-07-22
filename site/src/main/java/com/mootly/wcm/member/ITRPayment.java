
/*
 * In this class we are creating a document for storing value of Contact Information details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;


import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPayment;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.FormSaveResult;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=MemberPayment.class)
@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@FormFields(fieldNames={"paymentMemo","paymentType","authCode","preAuthCode","checkNo","checkDate","checkBank","checkBranch","checkLocation","cashAddress","cashContactNumber","cashBestTime","rtgsTransNumber","rtgsDate","rtgsAmount","rtgsTime","paymentDate"})
@RequiredFields(fieldNames={"paymentType"})

public class ITRPayment extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(ITRPayment.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//send email bad way we will create a EMAIL BUS		
	}
	
	@Override
	public void afterSave(HstRequest request,FormMap formMap,PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub
		//send an email 
		//send an email right here to our administrators and tell them about an availability
		//String[] to = new String[] {"info@wealth4india.com","amit@mootly.com"};
		super.afterSave(request,formMap,pageAction);
		Map<String,Object> velocityContext = new HashMap<String, Object>();
		velocityContext.put("userName",getUserName());
		velocityContext.put("userNameNormalized",getUserNameNormalized());
		//now lets put the document detail
		velocityContext.put("PAN",getPAN());
		velocityContext.put("financialYear",getFinancialYear().getDisplayName());
		velocityContext.put("itReturnType",getITReturnType().getDisplayName());
		
		if (request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase()) != null ) {
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			velocityContext.put("memberPersonalInformation",memberPersonalInformation);
			velocityContext.put("memberPersonalInformationString",memberPersonalInformation.toString());
		}
		
		if (formMap != null) {
			FormFields formFields = this.getClass().getAnnotation(FormFields.class);
			for (String aFieldName : formFields.fieldNames()) {
				if (formMap.getField(aFieldName) != null) velocityContext.put(aFieldName, formMap.getField(aFieldName).getValue());
			}
		}		
		sendEmail(request, null, null, null, "memberpaymentupdate", velocityContext);
	}
	
	@Override
	public boolean beforeSave(HstRequest request) {
		return true;
	}
	
	/**
	 * This will be used to ensure the page redirects properly 
	 */
	@Override
	public String getScriptName(HstRequest request,HstResponse response, FormSaveResult formSaveResult) {
		// TODO Auto-generated method stub
		if (formSaveResult == null || formSaveResult != FormSaveResult.SUCCESS) {
			return super.getScriptName();
		}
		else {
			String redirectURL = getRedirectURLForSiteMapItem(request,response,formSaveResult);
			if (log.isInfoEnabled()) {
				log.info("Will now redirect to:"+ redirectURL);
			}
			return getRedirectURLForSiteMapItem(request,response,formSaveResult);
		}
	}
}
