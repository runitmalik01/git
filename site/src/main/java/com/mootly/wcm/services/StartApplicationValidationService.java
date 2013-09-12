/**
 * 
 */
package com.mootly.wcm.services;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
import com.mootly.wcm.member.ITReturnHomePage;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;

/**
 * @author BEN-10
 *
 */
public class StartApplicationValidationService {

	private static final Logger log = LoggerFactory.getLogger(StartApplicationValidationService.class);

	MasterConfigService masterConfigService = null;

	public StartApplicationValidationService() {
		// TODO Auto-generated constructor stub
		this.masterConfigService = MasterConfigService.getInstance();;
	}
	/***
	 * This Method is Used to Validate The Start Application Screen
	 * 
	 * @param request HstRequest
	 * @param response HstRespose
	 * @param screenConfigDocument Which need to be validate
	 * @param formMap formMap object of Validation screen having values and list of Fields
	 * @param assessmentYear of ITR-Form Filing
	 * 
	 * @return Boolean 
	 * 
	 * ***/

	protected Boolean validateITReturn(HstRequest request,HstResponse response,ScreenConfigDocument screenConfigDocument,FormMap formMap,String assessmentYear){
		if(log.isInfoEnabled()){
			log.info("Server Side Validation Class");
		}
		try {
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
							validResidential(formMap,assessmentYear);
							validLastName(formMap);
							validDateofBirth(formMap);
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
	/**
	 * This method is used to check that 
	 * 
	 * Residential Status of Member has been Decided yet or not.
	 * 
	 * @param formMap to get the value of Field
	 * @param assessmentYear of ITR-Form Filing
	 * 
	 * @return null 
	 * 
	 * */
	public void validResidential(FormMap formMap,String assessmentYear){
		String choice="";
		ResourceBundle rbstat=ResourceBundle.getBundle("rstatus_"+assessmentYear);
		if(formMap.getField("rsstatus_q")!=null){
			if(formMap.getField("rsstatus_q").getValue().matches("Select")){
				formMap.getField("rsstatus_q").addMessage("err.required.residential");
			}else{
				choice="rsstatus_q_"+formMap.getField("rsstatus_q").getValue();
				for(String fieldsName:formMap.getFieldNames()){
					if(fieldsName.startsWith("rsstatus_q_")){
						if(!formMap.getField(choice).getValue().matches("Select")){
							choice=choice+"_"+formMap.getField(choice).getValue();
							if(rbstat.getString(choice).startsWith("ans_")){
								break;
							}
						}
					}
				}
				if(!rbstat.containsKey(choice)){
					formMap.getField("rsstatus_q").addMessage("err.required.residential");
				}else{
					if(!rbstat.getString(choice).startsWith("ans_")){
						formMap.getField("rsstatus_q").addMessage("err.required.residential");
					}
				}
			}
		}
	}

	/**
	 * This Method is Used to Test last name of Member 
	 * 
	 * With 5thChar of PAN
	 * 
	 * @param formMap object to get the last name field value 
	 * 
	 * @return null
	 * */
	public void validLastName(FormMap formMap){
		Boolean check=masterConfigService.shouldValidate5thChar();
		if(check != null && check){
			if(formMap.getField("pi_last_name")!=null && formMap.getField("pan")!=null){
				char pan5thChar=formMap.getField("pan").getValue().toLowerCase().charAt(4);
				char lastName1stChar=formMap.getField("pi_last_name").getValue().toLowerCase().charAt(0);
				if(pan5thChar!=lastName1stChar){
					log.info("Not Found a match with LastName& PAN::");
					formMap.getField("pi_last_name").addMessage("err.valid.lastName.with.pan");
				}
			}
		}
	}
	/**
	 * This Method is Used to Test Date of Birth of Member 
	 * 
	 * According MasterConfigService i.e. before current Return Filing Date
	 * 
	 * Also validate the Age of Member above 18 Years
	 * 
	 * @param formMap object to get the DOB field Value
	 * 
	 * @throws ParseException while Parse String into Date
	 * @return null
	 * 
	 * */
	@SuppressWarnings("deprecation")
	protected void validDateofBirth(FormMap formMap){
		Boolean check=masterConfigService.shouldValidateDate();
		if(check != null && check){
			if(formMap.getField("pi_dob")!=null){
				Date date=new Date();
				String validDate="01/04/"+date.getYear();
				DateFormat dateformat=new SimpleDateFormat("dd/mm/yyyy");
				try {
					Date currDate=dateformat.parse(validDate);
					Date DOB=dateformat.parse(formMap.getField("pi_dob").getValue());
					if(DOB.after(currDate)){
						formMap.getField("pi_dob").addMessage(MessageFormat.format("Enter Date Before 01/04/{0}",date.getYear()));
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * This method is used to Validate Last Name with RetrievePanResponse if DIT Service for PAN is Enabled.
	 * 
	 * @param pan {@link FormMap}
	 * @param lastName {@link String} Member's Last Name that will validate with Call of DIT Service
	 * @param retrievePANResponse {@link RetrievePANResponse} This Response Return After Call of DIT Service for PAN
	 * 
	 * */
	public boolean validLastNameWithDIT(String pan,String lastName, RetrievePANResponse retrievePANResponse){
		if(retrievePANResponse!=null && StringUtils.isBlank(retrievePANResponse.getError())){
			if(StringUtils.isNotBlank(lastName) && StringUtils.isNotBlank(pan)){
				//String lastName = formMap.getField("pi_last_name").getValue();
				//Search last name in RetrievePanResponse's Full Name.
				String respDitLastName = retrievePANResponse.getFullName();
				//if Name contain Space character then Name will have LastName Otherwise it will already Last Name
				if(retrievePANResponse.getFullName().contains(" ")){
					respDitLastName = retrievePANResponse.getFullName().substring(retrievePANResponse.getFullName().lastIndexOf(" "));
				}
				if(!respDitLastName.trim().equalsIgnoreCase(lastName.trim())){
					return false;//invalid case
				}
			}
		}
		return true;
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
	public Map<String, String> handleAjaxValidationForStartApp(String reqFormJson, String validation,RetrievePANResponse retrievePANResponse){
		Map<String, String> resultResponseMap = new HashMap<String, String>();
		if(reqFormJson!=null&&validation!=null){
			try {
				JSONObject formJson=new JSONObject(reqFormJson);
				if(formJson.getString("pan").length()!=0 && formJson.getString("pi_last_name").length()!=0 ){		
					char pan5thChar=formJson.getString("pan").toLowerCase().charAt(4);
					char lastName1stChar=formJson.getString("pi_last_name").toLowerCase().charAt(0);
					if(pan5thChar!=lastName1stChar){
						resultResponseMap.put("myHeader", "error");
					}else{
						resultResponseMap.put("myHeader", "success");
					}
					if(retrievePANResponse != null && StringUtils.isNotBlank(retrievePANResponse.getError())){
						resultResponseMap.put("panInvalid", "true");
					}else{
						resultResponseMap.put("panInvalid", "false");
					}
					//validate LastName with DIT Service Call
					if(!validLastNameWithDIT(formJson.getString("pan"), formJson.getString("pi_last_name"), retrievePANResponse)){
						resultResponseMap.put("lastNameInvalid", "true");
					}else{
						resultResponseMap.put("lastNameInvalid", "false");
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