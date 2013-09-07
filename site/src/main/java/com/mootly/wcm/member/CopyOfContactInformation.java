/*
 * In this class we are creating a document for storing value of Contact Information details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

public class CopyOfContactInformation extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(CopyOfContactInformation.class);

	private static final String PAN = "pi_pan";
	private static final String ERRORS = "errors";
	private static final String STREET_ROAD = "pi_road_street";
	private static final String STDCODE = "pi_std_code";
	private static final String PHONE = "pi_phone";
	private static final String FLAT = "pi_flat_door_building";
	private static final String LOCALITY = "pi_area_locality";
	private static final String DISTRICT = "pi_town_city_district";
	private static final String PIN= "pi_pin_code";
	private static final String STATE = "pi_state";
	private static final String MOBILE = "pi_mobile";
	private static final String EMAIL = "pi_email";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.warn("This is Contact Information Page");
		String filing_year=(String) request.getSession().getAttribute("filing_year");
		String pan=getPublicRequestParameter(request, "pan");	
		Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		try {
		if(pan!=null){		
			String path=ContentStructure.getContactDocumentPath(pan,filing_year,modusername);
			MemberContactInformation document=(MemberContactInformation)getObjectBeanManager(request).getObject(path);
			request.setAttribute("document", document);
		} else{
			String start_pan=(String)request.getSession().getAttribute("start_pan");
			if(start_pan!=null){
				String path=ContentStructure.getContactDocumentPath(start_pan,filing_year,modusername);
				MemberContactInformation document=(MemberContactInformation)getObjectBeanManager(request).getObject(path);
				request.setAttribute("document", document);
			}
		}
		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
        request.setAttribute(DISTRICT, request.getParameter(DISTRICT));
        request.setAttribute(EMAIL, request.getParameter(EMAIL));
        request.setAttribute(PAN , request.getParameter(PAN));
        request.setAttribute(STDCODE, request.getParameter(STDCODE));
        request.setAttribute(STREET_ROAD, request.getParameter(STREET_ROAD));
        request.setAttribute(MOBILE, request.getParameter(MOBILE));
        request.setAttribute(PIN, request.getParameter(PIN));
        request.setAttribute(LOCALITY, request.getParameter(LOCALITY));
        request.setAttribute(FLAT, request.getParameter(FLAT));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//get all parameter of form
		String pan=(String)request.getSession().getAttribute("start_pan");;
		String street=GoGreenUtil.getEscapedParameter(request, STREET_ROAD);
		String stdcode=GoGreenUtil.getEscapedParameter(request, STDCODE);
		String phone=GoGreenUtil.getEscapedParameter(request, PHONE);
		String mobile=GoGreenUtil.getEscapedParameter(request, MOBILE);
		String email=GoGreenUtil.getEscapedParameter(request, EMAIL);		
		String flat=GoGreenUtil.getEscapedParameter(request, FLAT);
		String locality=GoGreenUtil.getEscapedParameter(request, LOCALITY);
		String district=GoGreenUtil.getEscapedParameter(request, DISTRICT);
		String pin=GoGreenUtil.getEscapedParameter(request, PIN);
		String state=GoGreenUtil.getEscapedParameter(request, STATE);
		/*Next 4 lines
		 * Regular Expression to validate the PIN Code 
		 * Regular Expression to validate the Mobile Number  
		 * Regular Expression to validate the Email ID 
		 * */
		String reg_pin="^\\d{6}$";
		String reg_mob="^[1-9]{1}[0-9]{9}";
		String reg_email="^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		/*get the Member object
		 * To fetch the Login User details
		 * */ 
		Member member=(Member)request.getSession().getAttribute("user");
		if(member!=null){	
			//check for validation
			List<String> errors = new ArrayList<String>();
			
			if(StringUtils.isEmpty(locality)){
				errors.add("invalid.locality-label");
			}
			if(StringUtils.isEmpty(district)){
				errors.add("invalid.district-label");
			}
			if(state==null){
				errors.add("invalid.state-label");
			}
			if(StringUtils.isNotEmpty(mobile)){
				if(!mobile.matches(reg_mob)){
					errors.add("invalid.mobile-label");
				}
			}
			if (StringUtils.isEmpty(email)||!email.matches(reg_email)){
				errors.add("invalid.email-label");
			}
			if (StringUtils.isEmpty(pin)||!pin.matches(reg_pin)){
				errors.add("invalid.pin-label");
			}
			if (errors.size()!=0){
				response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
				response.setRenderParameter(DISTRICT, district);
				response.setRenderParameter(PIN, pin);
				response.setRenderParameter(STREET_ROAD, street);
				response.setRenderParameter(MOBILE, mobile);
				response.setRenderParameter(STDCODE, stdcode);
				response.setRenderParameter(FLAT, flat);
				response.setRenderParameter(LOCALITY, locality);
				response.setRenderParameter(PHONE, phone);
				response.setRenderParameter(STATE, state);
				response.setRenderParameter(EMAIL, email);
				return;
			}
			else{
				/*Create the MemberPersoanlInformation Document Object
				 * Set the Values get from Form
				 * */
				MemberContactInformation ci=new MemberContactInformation();
				    ci.setPAN(pan);
					ci.setEmail(email);
					ci.setMobile(mobile);
					ci.setAreaLocality(locality);
					ci.setPhone(phone);
					ci.setRoadStreet(street);
					ci.setStdCode(stdcode);
					ci.setState(state);
					ci.setPinCode(pin);
					ci.setTownCityDistrict(district);
					ci.setFlatDoorBuilding(flat);
				createMemberContactInformation(request,ci,pan);
				try{
					response.sendRedirect(UrlUtility.ResidentialStatus+"?pan="+pan);
				}
				catch(IOException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("status", "success");

			}
		}

	}
	/**
	 * Method to Create & Update the Member Contact Information Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Priyank
	 */
private void createMemberContactInformation(HstRequest request,MemberContactInformation contact_info,String pan) {
	// TODO Auto-generated method stub
	Session persistableSession = null;
	WorkflowPersistenceManager wpm;
	try {
		persistableSession = getPersistableSession(request);
		wpm = getWorkflowPersistenceManager(persistableSession);
		//SIMPLE WORKFLOW
		wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
		/*Create the path to Save Document in the Repository
		 * */
		Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		String filing_year=(String) request.getSession().getAttribute("filing_year");
		final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request,pan,filing_year,username);
		final String updateitReturnFolderPath = ContentStructure.getContactDocumentPath(pan,filing_year,modusername);
		MemberContactInformation updatecontactInformation = (MemberContactInformation) wpm.getObject(updateitReturnFolderPath);
		if(updatecontactInformation==null){
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */
			final String contactReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberContactInformation.NAMESPACE ,  MemberContactInformation.NODE_NAME, true);
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
			/*
			 * MemberContactlInformation
			 *getObject method get the object at passed path in Repository.
			 * */
			MemberContactInformation contactInformation = (MemberContactInformation) wpm.getObject(contactReturnPath);
			if(contactInformation !=null){				
				contactInformation.setPAN(contact_info.getPAN());
				contactInformation.setEmail(contact_info.getEmail());
				contactInformation.setAreaLocality(contact_info.getAreaLocality());
				contactInformation.setFlatDoorBuilding(contact_info.getFlatDoorBuilding());
				contactInformation.setMobile(contact_info.getMobile());
				contactInformation.setPhone(contact_info.getPhone());
				contactInformation.setPinCode(contact_info.getPinCode());
				contactInformation.setTownCityDistrict(contact_info.getTownCityDistrict());
				contactInformation.setStdCode(contact_info.getStdCode());
				contactInformation.setState(contact_info.getState());
				contactInformation.setRoadStreet(contact_info.getRoadStreet());
				wpm.update(contactInformation);

			}else {
				log.warn("Failed to add review for Contact '{}': could not retrieve Review bean for node '{}'.", MemberContactInformation.NODE_NAME, contactReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
			}
		}else{
			updatecontactInformation.setPAN(contact_info.getPAN());
			updatecontactInformation.setEmail(contact_info.getEmail());
			updatecontactInformation.setAreaLocality(contact_info.getAreaLocality());
			updatecontactInformation.setFlatDoorBuilding(contact_info.getFlatDoorBuilding());
			updatecontactInformation.setMobile(contact_info.getMobile());
			updatecontactInformation.setPhone(contact_info.getPhone());
			updatecontactInformation.setPinCode(contact_info.getPinCode());
			updatecontactInformation.setTownCityDistrict(contact_info.getTownCityDistrict());
			updatecontactInformation.setStdCode(contact_info.getStdCode());
			updatecontactInformation.setState(contact_info.getState());
			updatecontactInformation.setRoadStreet(contact_info.getRoadStreet());
			wpm.update(updatecontactInformation);
		}
	} catch (ObjectBeanPersistenceException e) {
		log.warn("Failed to create a review for Contact '" + "----- IT RETURN ------" + "'", e);
	} catch (ObjectBeanManagerException e) {
		log.warn("Failed to create a review for Contact '" + "----- IT RETURN ------" + "'", e);
	} catch (RepositoryException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
}
