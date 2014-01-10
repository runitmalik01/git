/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.itreturns.AbstractITReturnHomePage;
import com.mootly.wcm.services.StartApplicationValidationService;
import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;

public class ITReturnHomePage extends AbstractITReturnHomePage {
	private static final Logger log = LoggerFactory.getLogger(ITReturnHomePage.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		/*
		//AJAX validation Service start here
		String reqFormJson = getPublicRequestParameter(request, "data");
		String validation = getPublicRequestParameter(request, "validation");
		RetrievePANResponse retrievePANResponse = null;
		if(shouldValidatePANWithDIT() && reqFormJson!=null){	
			try {
				JSONObject formJson=new JSONObject(reqFormJson);
				RetrievePANInformation retrievePANInformation = getRetrievePANInformationService();
				retrievePANResponse = retrievePANInformation.retrievePANInformation(formJson.getString("pan"));
			} catch (MissingInformationException e) {
				// TODO Auto-generated catch block
				log.error("Error while Calling Dit Mock Service due to lack of Information",e);
			} catch (DataMismatchException e) {
				// TODO Auto-generated catch block
				log.error("Error while Mocking Dit Service for Pan Information due to Data Missed",e);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				log.error("Error while Mocking Dit Service for Pan Information due to Invalid Format of Inputs",e);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		StartApplicationValidationService applicationValidationService = new StartApplicationValidationService();
		Map<String, String> resultResponseMap = applicationValidationService.handleAjaxValidationForStartApp(reqFormJson, validation, retrievePANResponse);
		if(!resultResponseMap.isEmpty()){
			for(String respKey:resultResponseMap.keySet()){
				response.setHeader(respKey, resultResponseMap.get(respKey));
			}
		}
		*/
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		super.doAction(request, response);
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public HippoBean getScope(HstRequest request) {
		// TODO Auto-generated method stub
		return getPanFolder();
	}
	
}
