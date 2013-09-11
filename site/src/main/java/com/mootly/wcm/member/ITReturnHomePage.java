/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.itreturns.AbstractITReturnHomePage;
import com.mootly.wcm.services.MasterConfigService;
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
		if(shouldValidatePANWithDIT()){
			MasterConfigService configService = MasterConfigService.getInstance();
			request.setAttribute("ditInvalidPanContnue", configService.shouldContinueWithInvalidPAN());
		}
		String reqFormJson=getPublicRequestParameter(request, "data");
		String validation=getPublicRequestParameter(request, "validation");
		Map<String, String> resultResponseMap = handleAjaxValidationForStartApp(reqFormJson, validation);
		if(!resultResponseMap.isEmpty()){
			for(String respKey:resultResponseMap.keySet()){
				response.setHeader(respKey, resultResponseMap.get(respKey));
			}
		}
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
	/**
	 * This method used to handle Ajax request from {@link ITReturnHomePage} and validate As they are.If "shouldValidatePANWithDIT" false then 
	 * <br/>it will not validate with DIT Service.<br/>Also it validate lastName's 1stChar  with pan's 5thChar
	 * 
	 * @param reqFormJson Request JSONString
	 * @param validation Type of validation requested
	 * 
	 * @return {@link Map}
	 * */
	public Map<String, String> handleAjaxValidationForStartApp(String reqFormJson, String validation){
		Map<String, String> resultResponseMap = new HashMap<String, String>();
		if(reqFormJson!=null&&validation!=null){
			try {
				JSONObject formJson=new JSONObject(reqFormJson);
				if( formJson.getString("pan").length()!=0 && formJson.getString("pi_last_name").length()!=0 ){		
					char pan5thChar=formJson.getString("pan").toLowerCase().charAt(4);
					char lastName1stChar=formJson.getString("pi_last_name").toLowerCase().charAt(0);
					if(pan5thChar!=lastName1stChar){
						resultResponseMap.put("myHeader", "error");
					}else{
						resultResponseMap.put("myHeader", "success");
					}
					if(shouldValidatePANWithDIT()){
						RetrievePANInformation retrievePANInformation =  getRetrievePANInformationService();
						try {
							RetrievePANResponse retrievePANResponse = retrievePANInformation.retrievePANInformation(formJson.getString("pan"));
							if(retrievePANResponse != null && StringUtils.isNotBlank(retrievePANResponse.getError())){
								resultResponseMap.put("panInvalid", "true");
								log.warn("Error while Match Pan with DIT"+retrievePANResponse.getError());
							}else{
								resultResponseMap.put("panInvalid", "false");
							}
						} catch (MissingInformationException e) {
							// TODO Auto-generated catch block
							log.error("Error while Calling Dit Mock Service due to lack of Information",e);
						} catch (DataMismatchException e) {
							// TODO Auto-generated catch block
							log.error("Error while Mocking Dit Service for Pan Information due to Data Missed",e);
						} catch (InvalidFormatException e) {
							// TODO Auto-generated catch block
							log.error("Error while Mocking Dit Service for Pan Information due to Invalid Format of Inputs",e);
						}
					}
				}
			}catch (JSONException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
			}
		}	
		return resultResponseMap;
	}
}
