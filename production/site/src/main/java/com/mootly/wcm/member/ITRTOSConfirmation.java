package com.mootly.wcm.member;


import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.MootlyFormUtils;


/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will take value from Tdsfromsalary.jsp and pass it to bean
 */
public class ITRTOSConfirmation extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(ITRTOSConfirmation.class);
	FormMap savedValuesFormMap=null;	
	
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		String publicParameterUUID = getPublicRequestParameter(request, "uuid");
		if(publicParameterUUID==null){
			publicParameterUUID=(String)request.getSession().getAttribute("uuid");
		}
		if (publicParameterUUID != null) {
			try {
				FormUtils.validateId(publicParameterUUID);
				savedValuesFormMap = new FormMap(request,new String[]{"PAN","financialYear","itReturnType","userName","generatedHtmlSummary","originalPageAction"});
				MootlyFormUtils.populate(request, publicParameterUUID, savedValuesFormMap);
				if (savedValuesFormMap != null) {
					request.setAttribute("savedValuesFormMap", savedValuesFormMap);
					if (savedValuesFormMap.getField("generatedHtmlSummary") != null) request.setAttribute("generatedHtmlSummary", savedValuesFormMap.getField("generatedHtmlSummary").getValue());
					if (savedValuesFormMap.getField("originalPageAction") != null) request.setAttribute("originalPageAction", savedValuesFormMap.getField("originalPageAction").getValue());
					//redirectToOriginalPage
					if (savedValuesFormMap.getField("redirectToOriginalPage") != null) request.setAttribute("redirectToOriginalPage", savedValuesFormMap.getField("redirectToOriginalPage").getValue());
					request.setAttribute("publicParameterUUID", publicParameterUUID);
				}
			}catch (IllegalArgumentException ie) {
				publicParameterUUID = null;
				response.setStatus(500);
			}
		}
		else {
			response.setStatus(500);
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		
	} 
}




