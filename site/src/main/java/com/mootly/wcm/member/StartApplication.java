/*
 * In this class we are creating a document for storing value of Personal Information details of user
 * according to form 16.
 * @author
 * 04/03/2013
 *
 *
 */
package com.mootly.wcm.member;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
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
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.beans.events.MemberPersonalInfoUpdateHandler;
import com.mootly.wcm.channels.ChannelInfoWrapper;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.InvalidNavigationException;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.SORT_DIRECTION;
import com.mootly.wcm.services.StartApplicationValidationService;
import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.MootlyFormUtils;
import com.mootly.wcm.utils.UrlUtility;

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
		memberPersonalInfoUpdateHandler = new MemberPersonalInfoUpdateHandler(loadAllBeansUnderTheFolder(request, response, "services/incometaxreturn", "mootlywcm:Name",SORT_DIRECTION.ASC),getChannelInfoWrapper(),getRetrievePANInformationService());
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
				if(savedITRPriority > selectedITRPriority){
					HippoFolder hippoFolder = (HippoFolder) memberPersonalInformation.getParentBean();
					long size = hippoFolder.getDocumentSize();
					if(size > 1){
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

	public void doBeforeRenderOld(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Start Application Page");
		String pan=getPublicRequestParameter(request, "pan");
		Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		String filing_year=(String)request.getSession().getAttribute("filing_year");
		String urlnew=getPublicRequestParameter(request, "new");
		if(urlnew==null){
			try {
				if(pan!=null){
					String path=ContentStructure.getPersonalDocumentPath(pan,filing_year,modusername);
					MemberPersonalInformation objdocument=(MemberPersonalInformation)getObjectBeanManager(request).getObject(path);
					Calendar dob=objdocument.getDOB();

					Date date =dob.getTime();
					DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
					DateFormat formatter2=new SimpleDateFormat("yyyy-mm-dd");
					String hiddob=formatter2.format(date);
					String fetchdob=formatter.format(date);
					request.setAttribute("dob", fetchdob);
					request.setAttribute("hiddate", hiddob);
					log.info("date of birth"+fetchdob);
					log.info("this is info"+fetchdob);
					request.setAttribute("document", objdocument);
				} else{
					String start_pan=(String)request.getSession().getAttribute("start_pan");
					if(start_pan!=null){
						String path=ContentStructure.getPersonalDocumentPath(start_pan,filing_year,modusername);
						MemberPersonalInformation objdocument=(MemberPersonalInformation)getObjectBeanManager(request).getObject(path);
						Calendar dob=objdocument.getDOB();
						Date date =dob.getTime();
						DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
						DateFormat formatter2=new SimpleDateFormat("yyyy-mm-dd");
						String hiddob=formatter2.format(date);
						String fetchdob=formatter.format(date);
						request.setAttribute("dob", fetchdob);
						request.setAttribute("hiddate", hiddob);
						log.info("date of birth"+fetchdob);
						log.info("this is info"+fetchdob);
						request.setAttribute("document", objdocument);
					}
				}
			}catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("pageName", "startApplication");
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(DOB, request.getParameter(DOB));
		request.setAttribute(PAN , request.getParameter(PAN));
		request.setAttribute(LNAME, request.getParameter(LNAME));
		request.setAttribute(MNAME, request.getParameter(MNAME));
		request.setAttribute(FNAME, request.getParameter(FNAME));
		request.setAttribute(FA_NAME, request.getParameter(FA_NAME));
		request.setAttribute(GENDER, request.getParameter(GENDER));
		request.setAttribute(STATUS, request.getParameter(STATUS));
		request.setAttribute(SECTION, request.getParameter(SECTION));

	}

	public void doActionOld(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//get all parameter of form
		String fname=GoGreenUtil.getEscapedParameter(request,FNAME);
		String pan=GoGreenUtil.getEscapedParameter(request, PAN).toUpperCase();
		String lname=GoGreenUtil.getEscapedParameter(request, LNAME);
		String mname=GoGreenUtil.getEscapedParameter(request, MNAME);
		String fathername=GoGreenUtil.getEscapedParameter(request, FA_NAME);
		String gender=GoGreenUtil.getEscapedParameter(request, GENDER);
		String status=GoGreenUtil.getEscapedParameter(request, STATUS);

		String dob=GoGreenUtil.getEscapedParameter(request, DOB);
		String repDob=dob;
		String section=GoGreenUtil.getEscapedParameter(request,SECTION);

		/*Next 6-7 lines
		 * to covert String date into Calendar object
		 * */
		log.info(dob);
		Date date = null ;
		DateFormat formatter ;
		formatter = new SimpleDateFormat("yyyy-mm-dd");
		GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
		try{
			date = (Date)formatter.parse(dob);
			log.info("date"+date);
			cal.setTime(date);
		}
		catch(Exception e){
			log.info("calendar error"+e);
		}
		/*
		 * If Filing Status will HUF then Gender will be "X"
		 */
		if(status.matches("H")){
			gender="X";
		}
		/*Next line
		 * Regular Expression to validate the PAN Number
		 * */
		String reg_pan="^[A-Z]{5}\\d{4}[A-Z]$";
		/*get the Member object
		 * To fetch the Login User details
		 * */
		Member member=(Member)request.getSession().getAttribute("user");
		if(member!=null){
			//check for validation
			List<String> errors = new ArrayList<String>();
			if(StringUtils.isEmpty(pan) || !pan.matches(reg_pan) || pan.toLowerCase().charAt(4)!=lname.toLowerCase().charAt(0)){
				errors.add("Enter a valid PAN");
			}
			if(StringUtils.isEmpty(lname)){
				errors.add("invalid.lname-label");
			}
			if(StringUtils.isEmpty(dob)){
				errors.add("invalid.dob-label");
			}
			//if(StringUtils.isEmpty(section)){
			//	errors.add("select.one.section");
			//}
			if (errors.size()!=0){
				response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
				response.setRenderParameter(PAN, pan);
				response.setRenderParameter(FNAME, fname);
				response.setRenderParameter(LNAME, lname);
				response.setRenderParameter(MNAME, mname);
				response.setRenderParameter(STATUS, status);
				response.setRenderParameter(FA_NAME, fathername);
				response.setRenderParameter(DOB, repDob);
				//response.setRenderParameter(SECTION, section);
				return;
			}
			else{
				/*Create the MemberPersoanlInformation Document Object
				 * Set the Values get from Form
				 * */
				MemberPersonalInformation objpi = new MemberPersonalInformation();
				objpi.setPAN(pan);
				objpi.setMiddleName(mname);
				objpi.setFirstName(fname);
				objpi.setLastName(lname);
				objpi.setSex(gender);
				objpi.setDOB(cal);
				objpi.setFilingStatus(status);
				objpi.setFatherName(fathername);
				createMemberPersoanlInformation(request, objpi);
				try{
					request.getSession().setAttribute("start_pan",pan);
					response.sendRedirect(UrlUtility.Contactinformation+"?pan="+pan);
				}
				catch(Exception e){
				}
			}
		}

	}
	/**
	 * Method to Create & Update the Member Personal Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws
	 * @author Priyank
	 */
	private MemberPersonalInformation createMemberPersoanlInformation(HstRequest request,MemberPersonalInformation personal_info) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			Member member=(Member)request.getSession().getAttribute("user");
			String username=member.getUserName().trim();
			String filing_year=(String)request.getSession().getAttribute("filing_year");
			String modusername=username.replaceAll("@", "-at-").trim();
			/*Create the path to Save Document in the Repository
			 * */
			log.info("this is user"+username);
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request,personal_info.getPAN(), filing_year, modusername);
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */
			String updatePersonalReturnPath=ContentStructure.getPersonalDocumentPath(personal_info.getPAN(),filing_year,modusername);
			MemberPersonalInformation objupdateobjpersonalInformation = (MemberPersonalInformation) wpm.getObject(updatePersonalReturnPath);
			if(objupdateobjpersonalInformation==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberPersonalInformation.NAMESPACE ,  MemberPersonalInformation.NODE_NAME, true);
				/*
			HippoFolder hippoFolder = (HippoFolder) wpm.getObject(itReturnFolderPath);
			List<HippoTranslation> hippoTranslations = hippoFolder.getChildBeansByName("hippo:translation");
			if (hippoTranslations != null && hippoTranslations.size() > 0) {
				for (HippoTranslation translation:hippoTranslations) {
					if (translation.getProperty("locale","").equals("en")) {
					}
				}
			}
				 */
				/*MemberPersoanlInformation
				 *getObject method get the object at passed path in Repository.
				 * */
				MemberPersonalInformation objpersonalInformation = (MemberPersonalInformation) wpm.getObject(personalReturnPath);

				// update content properties
				if (objpersonalInformation != null) {
					log.info("PAN NUKMBER"+personal_info.getPAN().toString());
					objpersonalInformation.setPAN(personal_info.getPAN());
					objpersonalInformation.setMiddleName(personal_info.getMiddleName());
					objpersonalInformation.setFirstName(personal_info.getFirstName());
					objpersonalInformation.setLastName(personal_info.getLastName());
					objpersonalInformation.setSex(personal_info.getSex());
					objpersonalInformation.setFatherName(personal_info.getFatherName());
					objpersonalInformation.setDOB((GregorianCalendar) personal_info.getDOB());
					objpersonalInformation.setFilingStatus(personal_info.getFilingStatus());
					objpersonalInformation.setFilingStatus(personal_info.getFilingStatus());
					// update now
					wpm.update(objpersonalInformation);
					//Member Signup Document
					String signUpPath=ContentStructure.getSignUpDocumentPath(modusername);
					MemberSignupDocument docupdate=(MemberSignupDocument) wpm.getObject(signUpPath);
					if(docupdate!=null){
						/*Next 4 lines
						 * get the Previous entries of PAN saved in doc
						 * add new entry
						 * convert Collection into a String Array
						 * then pass array and update the MemberSignupDocument
						 * */
						Collection<String> oldpan= member.getPAN();
						oldpan.add(personal_info.getPAN());
						String[] newpan=(String[])oldpan.toArray(new String[0]);
						docupdate.setPAN(newpan);
						wpm.update(docupdate);
					}
					return objpersonalInformation;
				} else {
					log.info("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", MemberPersonalInformation.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return objpersonalInformation;
				}
			}else{
				objupdateobjpersonalInformation.setPAN(personal_info.getPAN());
				objupdateobjpersonalInformation.setMiddleName(personal_info.getMiddleName());
				objupdateobjpersonalInformation.setFirstName(personal_info.getFirstName());
				objupdateobjpersonalInformation.setLastName(personal_info.getLastName());
				objupdateobjpersonalInformation.setSex(personal_info.getSex());
				objupdateobjpersonalInformation.setFatherName(personal_info.getFatherName());
				objupdateobjpersonalInformation.setDOB((GregorianCalendar)personal_info.getDOB());
				objupdateobjpersonalInformation.setFilingStatus(personal_info.getFilingStatus());
				wpm.update(objupdateobjpersonalInformation);
				String signUpPath=ContentStructure.getSignUpDocumentPath(modusername);
				MemberSignupDocument docupdate=(MemberSignupDocument) wpm.getObject(signUpPath);
				/*Next 4 lines
				 * get the Previous entries of PAN saved in doc
				 * add new entry
				 * convert Collection into a String Array
				 * then pass array and update the MemberSignupDocument
				 * */
				Collection<String> oldpan= member.getPAN();
				if(oldpan.contains(personal_info.getPAN())){
					log.info("have it");
				}else{
					if(docupdate!=null){
						log.info("updating");
						oldpan.add(personal_info.getPAN());
						String[] newpan=(String[])oldpan.toArray(new String[0]);
						docupdate.setPAN(newpan);
						wpm.update(docupdate);
					}
				}
				return objupdateobjpersonalInformation;
			}
		} catch (ObjectBeanPersistenceException e) {
			log.error("Failed to create a review for personal '" + "----- IT RETURN ------" + "'", e);
			return null;
		} catch (ObjectBeanManagerException e) {
			log.error("Failed to create a review for personal'" + "----- IT RETURN ------" + "'", e);
			return null;
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}
	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
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

}
