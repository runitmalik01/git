/**
 * 
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

/**
 * @author BEN-10
 *
 */
public class StartApplicationValidationService {

	private static final Logger log = LoggerFactory.getLogger(StartApplicationValidationService.class);

	public Boolean validateITReturn(HstRequest request,HstResponse response,ScreenConfigDocument screenConfigDocument,FormMap formMap,String assessmentYear){
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
					JSONObject objJson=new JSONObject(screenConfigDocumentJSON);
					if(log.isInfoEnabled()){
						log.info("Json Object:"+objJson.toString());
					}
					for(String aValidField:formMap.getFieldNames()){
						if(!objJson.isNull(aValidField)){
							if(aValidField.matches("rsstatus_q")){
								validResidential(formMap,assessmentYear);
							}
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
	public void validResidential(FormMap formMap,String assessmentYear){
		String choice=null;
		if(formMap.getField("rsstatus_q").getValue().matches("Select")){
			formMap.getField("rsstatus_q").addMessage("Decide Your Residential Status");
		}else{
			choice=formMap.getField("rsstatus_q").getValue();
			ResourceBundle rbstat=ResourceBundle.getBundle("rstatus_"+assessmentYear);			
			for (String aKey: rbstat.keySet()) {
				if(!aKey.matches("rsstatus_q")){
					if(!rbstat.getString(aKey).startsWith("ans_")){
						if(!formMap.getField(aKey).getValue().matches("Select")){
							choice=choice+"_"+formMap.getField(aKey).getValue();
						}else{
							formMap.getField(aKey).addMessage("Decide Your Residential Status");
							break;
						}
					}
				}
			}	
			if(!rbstat.containsKey("rsstatus_q_"+choice)){
				formMap.getField("rsstatus_q").addMessage("Decide Your Residential Status");
			}else{
				if(rbstat.getString("rsstatus_q_"+choice).startsWith("_ans")){
					formMap.getField("rsstatus_q").addMessage("Decide Your Residential Status");
				}
			}
		}
	}
}