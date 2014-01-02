/*
 * In this class we are creating a document for storing value of Personal Information details of user
 * according to form 16.
 * @author
 * 04/03/2013
 *
 *
 */
package com.mootly.wcm.member;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.beans.events.MemberPersonalInfoUpdateHandler;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.SORT_DIRECTION;
import com.mootly.wcm.model.VerificationStatus;
import com.mootly.wcm.services.StartApplicationValidationService;
import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.AddClientDetailsResponse;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;
import com.mootly.wcm.utils.MootlyFormUtils;

@PrimaryBean(primaryBeanClass=MemberPersonalInformation.class)
//update Amit Patkar 07/22/2013 duplicate instance of ReturnSection
@FormFields(fieldNames={"pi_return_type","ReturnSection","portugesecivil","fy","ack_no","ack_date","defective","notice_no","notice_date",
		"pan","pi_first_name","pi_middle_name","pi_last_name","gender","pi_dob","pi_filing_status","pi_father_name",
		"pi_road_street","pi_std_code","pi_phone","pi_flat_door_building","pi_area_locality","pi_town_city_district",
		"pi_pin_code","pi_state","pi_country","pi_mobile","pi_mobile1","pi_email","pi_premises_building",
		"rsstatus_q","rsstatus_q_yes","rsstatus_q_yes_yes","rsstatus_q_no","rsstatus_q_no_yes","rsstatus_q_no_yes_yes",
		"rsstatus_q_no_no","rsstatus_q_no_no_yes","rsstatus_q_no_no_yes_yes","rsstatus_q_no_yes_yes_yes",
		"bd_bank_name","bd_micr_code","bd_Branch_name","bd_account_type","bd_account_no","bd_ecs","flex_string_IFSCCode","flex_string_ITRForm","flex_string_ITRServiceDelivery","pi_return_type","fy","ack_no","ack_date","defective","notice_no","notice_date","ward_circle","Employe_category","returnTypeChoice","revisingWithNoticeSection","isRepresentative","name_Representative","pan_Representative",
		"address_Representative","isLiable_ManageAcc","isLiable_ForAudit","date_FurnishAuditReport","name_AuditorSign_Report","membershipNo_auditor","name_auditorFirm",
		"pan_Firm","date_AuditReport","isLiable_FurnishSec92E","trpname","trpnumber","trpreimbursement","isTaxPreparebyTRP"})
@RequiredFields(fieldNames={
		"pi_last_name","pi_dob","gender",
		"pi_flat_door_building","pi_email","pi_pin_code","pi_town_city_district","pi_state","pi_area_locality","pi_mobile",
		"rsstatus_q","bd_account_type","bd_account_no","bd_ecs"})
@DataTypeValidationFields(dataTypes={DataTypeValidationType.PAN},fieldNames={"pan"})
public class StartApplication extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(StartApplication.class);
	private static final String FNAME = "pi_first_name";
	private static final String LNAME = "pi_last_name";
	private static final String MNAME = "pi_middle_name";
	private static final String FA_NAME = "pi_father_name";
	private static final String PAN = "pi_pan";
	private static final String GENDER = "gender";
	private static final String STATUS = "status";
	private static final String SECTION= "ReturnSection";
	private static final String ERRORS = "errors";
	private static final String DOB = "pi_dob";

	FormMap savedValuesFormMap=null;
	String memberName = null;
	MemberPersonalInformation parentBean=null;
	MemberPersonalInfoUpdateHandler memberPersonalInfoUpdateHandler = null;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		//being member return of getMemberPersonalInformation() of ITReturnComponent it return previous entered and viewed value.
		parentBean =  (MemberPersonalInformation)request.getAttribute("parentBean"); //getMemberPersonalInformation();
		
		List<HippoDocumentBean> listOfITRServices = loadAllBeansUnderTheFolder(request, response, "services/documents/incometaxreturn", "mootlywcm:Name",SORT_DIRECTION.ASC);
		request.setAttribute("listOfITRServices", listOfITRServices);
		
		RetrievePANResponse retrievePANResponse = null;
		//Call to DIT Service then get the Response
		if(shouldRetrievePANInformation()||shouldRetrievePANInformation()){
			RetrievePANInformation retrievePANInformation = getRetrievePANInformationService();
			try {
				retrievePANResponse = retrievePANInformation.retrievePANInformation(getPAN());
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
		//validation for PAN/LastName of using DIT Service of with 
		String reqFormJson = getPublicRequestParameter(request, "data");
		String validation = getPublicRequestParameter(request, "validation");
		StartApplicationValidationService validationService = new StartApplicationValidationService();
		Map<String, String> resultResponseMap = validationService.handleAjaxValidationForStartApp(reqFormJson, validation, retrievePANResponse);
		if(!resultResponseMap.isEmpty()){
			for(String respKey:resultResponseMap.keySet()){
				response.setHeader(respKey, resultResponseMap.get(respKey));
			}
		}
		String publicParameterUUID = getPublicRequestParameter(request, "uuid");
		if (publicParameterUUID != null) {
			try {
				FormUtils.validateId(publicParameterUUID);
				savedValuesFormMap = new FormMap(request,new String[]{"pan","pi_last_name","pi_dob","pi_return_type","fy","ReturnSection","pi_mobile"});
				MootlyFormUtils.populate(request, publicParameterUUID, savedValuesFormMap);
				if (savedValuesFormMap != null) {
					request.setAttribute("savedValuesFormMap", savedValuesFormMap);
				}
			}catch (IllegalArgumentException ie) {
				publicParameterUUID = null;
			}
		}
		String assessmentYear = getAssessmentYear() == null ? "2012-2013"  : getAssessmentYear();
		ResourceBundle rb = ResourceBundle.getBundle("rstatus_"+assessmentYear);
		ResourceBundle rbNew = ResourceBundle.getBundle("rstatushuf_"+assessmentYear);
		log.info("object getting"+rbNew);

		List<String> keyList = new ArrayList<String>();
		for (String aKey: rb.keySet() ) {
			keyList.add(aKey);
		}
		// new list for huf by abhishek
		List<String> keyListHuf = new ArrayList<String>();
		for (String bKey: rbNew.keySet() ) {
			keyListHuf.add(bKey);
		}
		if(parentBean!=null){
			memberName=parentBean.getLastName();
		}else {
			if (savedValuesFormMap != null) {
				memberName=savedValuesFormMap.getField("pi_last_name").getValue();
			}
		}
		if(parentBean!=null){
			request.setAttribute("ifsccode", parentBean.getFlexField("flex_string_IFSCCode", ""));
		}
		if(StringUtils.isEmpty(memberName)||memberName==null){
			FilingStatus filstat=(FilingStatus)request.getAttribute("filingStatus");
			if(filstat!=null){
				memberName="the "+filstat.getName();
			}
		}
		Map<String, String> map = new LinkedHashMap<String, String>();
		Collections.sort(keyList, new SortyByDepth());
		for (String aKey:keyList) {
			if (memberName != null) {
				String ke = rb.getString(aKey);
				if (log.isInfoEnabled()) {
					log.info("Now attempting to apply format to " + ke);
				}
				map.put(aKey, MessageFormat.format(ke,memberName));
			}
			/*else {
					//map.put(aKey, rb.getString(aKey));
					String ke = rb.getString(aKey);
					if (log.isInfoEnabled()) {
						log.info("Now attempting to apply format to " + ke);
					}
					map.put(aKey, MessageFormat.format(ke,"the Individual"));
				}*/
		}
		// new map for huf, abhi 14/09/2013
		Map<String, String> maphuf = new LinkedHashMap<String, String>();
		Collections.sort(keyListHuf, new SortyByDepth());
		for (String bKey:keyListHuf) {
			if (memberName != null) {
				String key = rbNew.getString(bKey);
				if (log.isInfoEnabled()) {
					log.info("Now attempting to apply format to " + key);
				}
				maphuf.put(bKey, MessageFormat.format(key,memberName));
			}
			/*else {
					//map.put(aKey, rb.getString(aKey));
					String ke = rb.getString(aKey);
					if (log.isInfoEnabled()) {
						log.info("Now attempting to apply format to " + ke);
					}
					map.put(aKey, MessageFormat.format(ke,"the Individual"));
				}*/
		}
		Map<String, String> fetchmap = new LinkedHashMap<String, String>();
		if (getParentBean() != null) {
			MemberPersonalInformation memberresi = (MemberPersonalInformation) getParentBean();

			fetchmap.put("rsstatus_q",memberresi.getRsstatusQ());
			if(!(memberresi.getRsstatusQYes().matches("Select")))
				fetchmap.put("rsstatus_q_yes",memberresi.getRsstatusQYes());
			if(!(memberresi.getRsstatusQYesYes().matches("Select")))
				fetchmap.put("rsstatus_q_yes_yes",memberresi.getRsstatusQYesYes());
			if(!(memberresi.getRsstatusQNo().matches("Select")))
				fetchmap.put("rsstatus_q_no",memberresi.getRsstatusQNo());
			if(!(memberresi.getRsstatusQNoYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_yes",memberresi.getRsstatusQNoYes());
			if(!(memberresi.getRsstatusQNoYesYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_yes_yes",memberresi.getRsstatusQNoYesYes());
			if(!(memberresi.getRsstatusQNoNo().matches("Select")))
				fetchmap.put("rsstatus_q_no_no",memberresi.getRsstatusQNoNo());
			if(!(memberresi.getRsstatusQNoNoYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_no_yes",memberresi.getRsstatusQNoNoYes());
			if(!(memberresi.getRsstatusQNoNoYesYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_no_yes_yes",memberresi.getRsstatusQNoNoYesYes());
			if(!(memberresi.getRsstatusQNoYesYesYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_yes_yes_yes",memberresi.getRsstatusQNoYesYesYes());

			request.setAttribute("fetchmap", fetchmap);
		}
		JSONObject jsonObject = new JSONObject(map);
		JSONObject jsonObjecthuf = new JSONObject(maphuf);
		request.setAttribute("jsonObject", jsonObject);
		request.setAttribute("jsonObjecthuf", jsonObjecthuf);
		request.setAttribute("map", map);
		request.setAttribute("maphuf", maphuf);
		request.setAttribute("ITR1_FORM_SELECTION", request.getParameter("ITR1_FORM_SELECTION"));

		if(shouldRetrievePANInformation() && publicParameterUUID !=null){
			request.setAttribute("retrievePANResponse", retrievePANResponse);
		}
		String checkForDuplicate = request.getRequestContext().getResolvedSiteMapItem().getParameter("checkForDuplicate");
		if (checkForDuplicate != null && "true".equalsIgnoreCase(checkForDuplicate)) {  //check that Admin enable or disable the functionality
			if(publicParameterUUID !=null && getPanFolder() !=null){                   //duplicate will applicable for New PAN entry 
				List<HippoFolderBean> hippoFolderList = getPanFolder().getFolders();  //get list of all pans
				if(!hippoFolderList.isEmpty() && hippoFolderList.size() > 0){        //check that PAN Folder list should not be empty
					for(HippoFolderBean hipFoldBean:hippoFolderList){               //iterate PAN Folder List 
						if(hipFoldBean.getName().toLowerCase().contains(getPAN().toLowerCase())){   //Find the entered PAN in the List of PAN Folders
							if(hipFoldBean.getFolders().size() > 0){                               //Now get the List of Folder in Matched PAN Folder
								for(HippoFolderBean hipfyFolder:hipFoldBean.getFolders()){        //Iterate List of Financial Folder In Matched PAN Folder
									if(hipfyFolder.getName().equalsIgnoreCase(getFinancialYear().getDisplayName())){//find Match of FY Folder with Choose Financial Year
										for(HippoFolderBean hipPANFolder:hipfyFolder.getFolders()){                //iterate all Folders in Matched FY Folder
											if(hipPANFolder.getName().toLowerCase().contains(getPAN().toLowerCase())){ //Find that Folder contain Entered PAN in it
												request.setAttribute("duplicatePANFolder", hipPANFolder.getName());   //set the this PAN Folder(with Sequence Number) 
												request.setAttribute("isDuplicate", "true");                         //set Duplicate Parameter true
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void afterSave(HstRequest request, FormMap map,PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub
		//"flex_string_ITRForm","flex_string_ITRServiceDelivery",
		super.afterSave(request, map,pageAction);
		if (pageAction != null && ( pageAction == PAGE_ACTION.NEW || pageAction == PAGE_ACTION.EDIT ) ) {
			/*
			if (pageAction  == PAGE_ACTION.EDIT) {
				if (getParentBean() != null) {
					MemberPersonalInformation mi = (MemberPersonalInformation) getParentBean();
					if (mi != null && mi.getSelectedITRForm().equals(other) )
				}
			}
			 */
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
			}

			if (map != null) {
				FormFields formFields = this.getClass().getAnnotation(FormFields.class);
				for (String aFieldName : formFields.fieldNames()) {
					if (map.getField(aFieldName) != null) velocityContext.put(aFieldName, map.getField(aFieldName).getValue());
				}
			}
			sendEmail(request, null, null, null, "memberitrsrupdate", velocityContext);
		}
		// this is code which delete the document of schedule5adocument if portugese civil code is "No":- By Pankaj SIngh
		String IsPortuges= getFormMap().getField("portugesecivil").getValue();
		if(IsPortuges.equals("N")){
			Session persistableSession= null;
			WorkflowPersistenceManager objWorkflowPersistenceManager= null;
			try {
				persistableSession=getPersistableSession(request);
				objWorkflowPersistenceManager= getWorkflowPersistenceManager(persistableSession);
				objWorkflowPersistenceManager.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());

				String getPathSchedule5a=getAbsoluteBasePathToReturnDocuments()+"/"+ScheduleFiveADocument.class.getSimpleName().toLowerCase();
				ScheduleFiveADocument objScheduleFiveADocument= (ScheduleFiveADocument)objWorkflowPersistenceManager.getObject(getPathSchedule5a);
				if(objScheduleFiveADocument != null){
					objWorkflowPersistenceManager.remove(objScheduleFiveADocument);
				}
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// end code here
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		List<HippoDocumentBean> listOfITRServices = loadAllBeansUnderTheFolder(request, response, "services/documents/incometaxreturn", "mootlywcm:Name",SORT_DIRECTION.ASC);
		memberPersonalInfoUpdateHandler = new MemberPersonalInfoUpdateHandler(getSequenceGenerator(), listOfITRServices ,getChannelInfoWrapper(),getAddClientDetailsService(),getRetrieve26ASService(),getFinancialYear());
		super.doAction(request, response);
	}

	/**
	 * This will be used to ensure the page redirects properly
	 */
	/*
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
	 */

	class SortyByDepth implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			String[] leftArray = o1.split("[_]");
			String[] rightArray = o2.split("[_]");
			if (leftArray.length < rightArray.length){
				return -1;
			}
			else if (leftArray.length == rightArray.length) {
				return 0;
			}
			else
				return 1;
		}
	}

	/**
	 * Method to compare packages
	 * @param HstRequest, HstResponse, FormMap
	 * @return boolean
	 * @throws
	 * @author Dhananjay
	 */

	@Override
	public boolean validate(HstRequest request, HstResponse response,
			FormMap formMap) {
		// TODO Auto-generated method stub
		if(super.validate(request, response, formMap)){
			boolean hasAValidSelection = true;
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) getParentBean();
			if(memberPersonalInformation != null){
				ITRForm saveditrForm = memberPersonalInformation.getSelectedITRForm();
				int savedITRPriority = saveditrForm.getPriority();
				String selecteditrForm= formMap.getField("flex_string_ITRForm").getValue();
				ITRForm selectedITR = ITRForm.valueOf(selecteditrForm);
				int selectedITRPriority = selectedITR.getPriority();
				String MaxDocAllowedForPackageChange = request.getRequestContext().getResolvedSiteMapItem().getParameter("MaxDocAllowedForPackageChange");
	
				if(savedITRPriority > selectedITRPriority){
					HippoFolder hippoFolder = (HippoFolder) memberPersonalInformation.getParentBean();
					long size = hippoFolder.getDocumentSize();
					if(size > Integer.parseInt(MaxDocAllowedForPackageChange)){
						formMap.addMessage("flex_string_ITRForm", "error.itr.selection");
						response.setRenderParameter("ITR1_FORM_SELECTION", "error.itr.selection");
						hasAValidSelection = false;
						return hasAValidSelection;
					}
				}
			}
		}
		return super.validate(request, response, formMap);
	}

	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
	
	@Override
	protected BeanLifecycle<HippoBean> getParentBeanLifeCycleHandler() {
		// TODO Auto-generated method stub
		return memberPersonalInfoUpdateHandler;
	}
	
	@Override
	protected boolean additionalValidation(HstRequest request,
			HstResponse response, FormMap formMap) {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if (!getChannelInfoWrapper().getIsEriEnabled()) {
			log.warn("Will SKIP the validation for information");
		}
		if (formMap != null && getChannelInfoWrapper().getIsEriEnabled()) {
			try {				
				String PAN = formMap.getField("pan").getValue();	
				String dobStr = formMap.getField("pi_dob").getValue();	
				Date DOB = IndianGregorianCalendar.formatStringToDate(dobStr, IndianGregorianCalendar.indianLocalDateFormStr2);
				GregorianCalendar theGCalDOB = new GregorianCalendar();
				theGCalDOB.setTime(DOB);
				String email = formMap.getField("pi_email").getValue();
				if (log.isInfoEnabled()) {
					log.info("Will call DIT ");
					log.info("DIT getEriUserId:" + getChannelInfoWrapper().getWebSiteInfo().getEriUserId());
					log.info("DIT getEriPassword:" +  getChannelInfoWrapper().getWebSiteInfo().getEriPassword());
					log.info("DIT getEriCertChain:" +  getChannelInfoWrapper().getWebSiteInfo().getEriCertChain());
					log.info("DIT getEriSignature:" +  getChannelInfoWrapper().getWebSiteInfo().getEriSignature());
				}				
				AddClientDetailsResponse addClientDetailsResponse = getAddClientDetailsService().addClientDetails(getChannelInfoWrapper().getWebSiteInfo().getEriUserId(), getChannelInfoWrapper().getWebSiteInfo().getEriPassword(), null, null, PAN, theGCalDOB, email, null, null, null);
				if (addClientDetailsResponse == null || addClientDetailsResponse.getError() != null) {
					//formMap.addMessage("RAW_MESSAGE_1",addClientDetailsResponse.getError());
					isValid = false;
					addDitVerificationStatusFieldToFormMap(formMap,VerificationStatus.FAILED,addClientDetailsResponse.getError());
				}
				else {					
					isValid = true;
					addDitVerificationStatusFieldToFormMap(formMap,VerificationStatus.VERIFIED);
				}				
			} catch (MissingInformationException e) {
				// TODO Auto-generated catch block
				log.error("Error",e);
				//formMap.addMessage("error.dit.verification","error.dit.verification");
				//formMap.addMessage("error.dit.verification.action","error.dit.verification.action");
				addDitVerificationStatusFieldToFormMap(formMap,VerificationStatus.FAILED,e.getMessage());
			} catch (DataMismatchException e) {
				// TODO Auto-generated catch block
				log.error("Error",e);
				//formMap.addMessage("error.dit.verification","error.dit.verification");
				//formMap.addMessage("error.dit.verification.action","error.dit.verification.action");				
				addDitVerificationStatusFieldToFormMap(formMap,VerificationStatus.FAILED,e.getMessage());
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				log.error("Error",e);
				//formMap.addMessage("error.dit.verification","error.dit.verification");
				//formMap.addMessage("error.dit.verification.action","error.dit.verification.action");				
				addDitVerificationStatusFieldToFormMap(formMap,VerificationStatus.FAILED,e.getMessage());
			}		
			catch (SOAPFaultException e) {
				log.error("Error",e);
				if (e.getMessage() != null && e.getMessage().equals("This PAN is already added as a client.")) {
					log.warn("The user is already added in the client database");
					addDitVerificationStatusFieldToFormMap(formMap,VerificationStatus.VERIFIED,e.getMessage());
				}
				else {
					//formMap.addMessage("error.dit.verification","error.dit.verification");
					//formMap.addMessage("error.dit.verification.action","error.dit.verification.action");				
					addDitVerificationStatusFieldToFormMap(formMap,VerificationStatus.FAILED,e.getMessage());
				}
			}
			catch (Exception e) {
				log.error("Error",e);
				//formMap.addMessage("error.dit.verification","error.dit.verification");
				//formMap.addMessage("error.dit.verification.action","error.dit.verification.action");				
				addDitVerificationStatusFieldToFormMap(formMap,VerificationStatus.FAILED,e.getMessage());
			}
		}
		return isValid;
	}
	
	private void addDitVerificationStatusFieldToFormMap(FormMap formMap,VerificationStatus verificationStatus) {
		addDitVerificationStatusFieldToFormMap(formMap,verificationStatus,null);
	}
	
	private void addDitVerificationStatusFieldToFormMap(FormMap formMap,VerificationStatus verificationStatus,String verificationMessage) {
		FormField verStatus = new FormField("ditVerificationStatus");
		verStatus.addValue(verificationStatus.name());
		
		formMap.addFormField(verStatus);
		
		if (verificationMessage != null) {
			FormField verMsg = new FormField("ditVerificationMessage");
			verMsg.addValue(verificationMessage);
			formMap.addFormField(verMsg);
		}
	}
}
