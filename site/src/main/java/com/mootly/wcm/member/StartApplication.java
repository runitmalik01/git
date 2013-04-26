/*
 * In this class we are creating a document for storing value of Personal Information details of user
 * according to form 16.
 * @author Priyank
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

@PrimaryBean(primaryBeanClass=MemberPersonalInformation.class)
@FormFields(fieldNames={
			"pi_pan","pi_first_name","pi_middle_name","pi_last_name","pi_father_name","gender","status","pi_dob",
			"pi_road_street","pi_std_code","pi_phone","pi_flat_door_building","pi_area_locality","pi_town_city_district","pi_pin_code","pi_state","pi_mobile","pi_email","pi_premises_building"
		})
@RequiredFields(fieldNames={"pi_last_name","pi_dob","gender"
		//,"pi_flat_door_building","pi_email","pi_pin_code","pi_town_city_district","pi_state","pi_area_locality"
		})
public class StartApplication extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(StartApplication.class);
	private static final String FNAME = "pi_first_name";
	private static final String LNAME = "pi_last_name";
	private static final String MNAME = "pi_middle_name";
	private static final String FA_NAME = "pi_father_name";
	private static final String PAN = "pi_pan";
	private static final String GENDER = "gender";
	private static final String STATUS = "status";
	private static final String ERRORS = "errors";
	private static final String DOB = "pi_dob";
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);	
		if(log.isInfoEnabled()){
		log.info("Member personal Information page");
		}
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
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
		/*Next 6-7 lines
		 * to covert String date into Calendar object
		 * */
		log.info(dob);
		Date date = null ;
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal=Calendar.getInstance();
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
			if (errors.size()!=0){
				response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
				response.setRenderParameter(PAN, pan);
				response.setRenderParameter(FNAME, fname);    
				response.setRenderParameter(LNAME, lname);
				response.setRenderParameter(MNAME, mname);
				response.setRenderParameter(STATUS, status);
				response.setRenderParameter(FA_NAME, fathername);
				response.setRenderParameter(DOB, repDob);
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
					objpersonalInformation.setDOB(personal_info.getDOB());
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
				objupdateobjpersonalInformation.setDOB(personal_info.getDOB());
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
}
