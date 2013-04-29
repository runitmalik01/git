package com.mootly.wcm.components.itreturns;

import java.io.IOException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.components.FormSaveResult;
import com.mootly.wcm.components.ITReturnComponent;

@FormFields(fieldNames={"pan"})
public class PackageSelector extends ITReturnComponent{
	private static final Logger log = LoggerFactory.getLogger(PackageSelector.class);
	String publicParameterUUID = null;
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		publicParameterUUID = getPublicRequestParameter(request, "uuid");
		if (publicParameterUUID != null) {
			try {
				FormUtils.validateId(publicParameterUUID);
				//response.setRenderParameter("uuid", publicPar
				//response.sendRedirect(request.getRequestURL().toString());
				//return;
			}catch (IllegalArgumentException ie) {
				publicParameterUUID = null;
			}
		}
		request.setAttribute("selectionUUID", publicParameterUUID);
		if (log.isDebugEnabled()) {
			log.debug("Entering Package Selector");
		}		
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if (log.isDebugEnabled()) {
			log.debug("Entering Package Selector");
		}		
		String publicUUID = getPublicRequestParameter(request, "selectionUUID");
		String returnURL = getRedirectURL(request, response, FormSaveResult.SUCCESS,"start-application",getFinancialYear(),getITReturnType(),getPAN());
		if (publicUUID != null) {
			try {
				FormUtils.validateId(publicUUID);
				returnURL +="?uuid=" +publicUUID;
			}catch (IllegalArgumentException ie) {
				
			}
		}
	    try {
			response.sendRedirect(returnURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
