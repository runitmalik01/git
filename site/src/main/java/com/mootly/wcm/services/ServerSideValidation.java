/**
 * This file is used to Validate the Screen
 */
package com.mootly.wcm.services;

import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.components.ITReturnComponent;

/**
 * @author BEN-10
 *
 */
public class ServerSideValidation extends ITReturnComponent  {

	private static final Logger log = LoggerFactory.getLogger(ServerSideValidation.class);

	public boolean Validation(HstRequest request,HstResponse response,ScreenConfigDocument screenConfigDocument,FormMap formMap){

		if(log.isInfoEnabled()){
			log.info("Server Side Validation Class");
		}
		try {
			String pathToScreenConfig ="configuration/screenconfigs/";
			if(log.isInfoEnabled()){
				log.info("this is path To screen config"+pathToScreenConfig);
			}

			if (screenConfigDocument != null) {
				if (log.isInfoEnabled()){
					log.info("screenConfigDocument:" + screenConfigDocument.toString());
				}			
				//request.setAttribute("screenConfigDocument",screenConfigDocument);
				String screenConfigDocumentJSON = ScreenConfigService.generateJSON(screenConfigDocument);
				if (screenConfigDocumentJSON != null) {
					if (log.isInfoEnabled()){
						log.info("screenConfigDocumentJSON:" + screenConfigDocumentJSON.toString());
					}
					//request.setAttribute("screenConfigDocumentJSON", screenConfigDocumentJSON);
					/*try {
					JSONArray objJsonDT = new JSONArray(screenConfigDocumentJSON.trim());
					for(int n = 0; n < objJsonDT.length(); n++){
						JSONObject jsonelements = objJsonDT.getJSONObject(n);
						JSONObject jsonField=jsonelements.getJSONObject(objJsonDT.getString(n));


					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

					JSONObject objJson=new JSONObject(screenConfigDocumentJSON);
					if(log.isInfoEnabled()){
						log.info("Json Object:"+objJson.toString());
					}
					for(String aValidField:formMap.getFieldNames()){
						if(!objJson.isNull(aValidField)){
							JSONObject validRul=objJson.getJSONObject(aValidField);
							//Field value for isRequired
							if((!validRul.isNull("isRequired")) && validRul.getString("isRequired").matches("true")){
								if (formMap.getField(aValidField) == null) {
									formMap.addMessage(aValidField, "err.required." + aValidField);
									continue;
								}
								if (StringUtils.isEmpty( formMap.getField(aValidField).getValue() ) ) {
									formMap.getField(aValidField).addMessage("err.required." + aValidField);
									continue;
								}
							}
							//Field Value in a format as Regular Expression
							if(!validRul.isNull("fieldFormat")){
								//get the Sets from regular_expression.properties 
								ResourceBundle rb = ResourceBundle.getBundle("regular_expression");
								for (String aKey: rb.keySet()){
									if(validRul.getString("fieldFormat").matches(aKey)){
										String whatToMatch = formMap.getField(aValidField).getValue();
										String pattern = rb.getString(aKey);
										if (log.isInfoEnabled()) {
											log.info("Will now try to match:" + whatToMatch + " with pattern:" + pattern);
										}
										if (whatToMatch != null && StringUtils.isNotEmpty(whatToMatch)) {
											//Pattern p = Pattern.compile(pattern);				
											//boolean isAMatch = p.matcher(whatToMatch).matches();
											boolean isAMatch=whatToMatch.matches(pattern);
											if (!isAMatch) {
												formMap.getField(aValidField).addMessage("err.pattern." + aValidField);
											}
										}
									}
								}
							}
							//Field Value Max & Min length
							if(!validRul.isNull("validators")){
								for(int i=0;i<validRul.getJSONArray("validators").length();i++){
									if(validRul.getJSONArray("validators").getString(i).matches("max")){
										if(log.isInfoEnabled()){
											log.info("Checking for max length of field");
										}
									}else{
										if(log.isInfoEnabled()){
											log.info("Checking for min length of field");
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (PatternSyntaxException pse) {
			log.warn("Pattern Syntax Exception",pse);
		}
		finally {

		}
		if (formMap.getMessage() != null && formMap.getMessage().size() > 0) {
			FormUtils.persistFormMap(request, response, formMap, null);
			return false;
		}
		else {
			return true;
		}
	}
}
