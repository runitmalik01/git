/*
 * In this class we are creating a document for storing value of Schedule80C details of user
 * according to form 16.
 * @author Priyank
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;


import java.io.IOException;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

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

import com.mootly.wcm.beans.MemberDeductionScheduleC;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;


public class Schedule80C extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Schedule80C.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Deduction Schedule80C Page");
		String pan=(String)request.getSession().getAttribute("pan");
		String filing_year=(String)request.getSession().getAttribute("filing_year");
		Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		try {
			log.info("hello in try");	    
			String path5=ContentStructure.getSchedule80CDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleC documentc=(MemberDeductionScheduleC)getObjectBeanManager(request).getObject(path5);
			request.setAttribute("documentc", documentc);
			if(documentc!=null){
				log.info("hello c");
				log.warn("hello c");
			}

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.info("This is Deduction Schedule80C Page:doAction");

		String schedule80C1=GoGreenUtil.getEscapedParameter(request,"schedule80C1");
		String schedule80C2=GoGreenUtil.getEscapedParameter(request,"schedule80C2");
		String schedule80C3=GoGreenUtil.getEscapedParameter(request,"schedule80C3");
		String schedule80C4=GoGreenUtil.getEscapedParameter(request,"schedule80C4");
		String schedule80C5=GoGreenUtil.getEscapedParameter(request,"schedule80C5");
		String schedule80C6=GoGreenUtil.getEscapedParameter(request,"schedule80C6");
		String schedule80C7=GoGreenUtil.getEscapedParameter(request,"schedule80C7");
		String schedule80C8=GoGreenUtil.getEscapedParameter(request,"schedule80C8");
		String schedule80C9=GoGreenUtil.getEscapedParameter(request,"schedule80C9");
		String schedule80C10=GoGreenUtil.getEscapedParameter(request,"schedule80C10");
		String dp1=GoGreenUtil.getEscapedParameter(request,"dp1");
		String dp2=GoGreenUtil.getEscapedParameter(request,"dp2");
		String dp3=GoGreenUtil.getEscapedParameter(request,"dp3");
		String dp4=GoGreenUtil.getEscapedParameter(request,"dp4");
		String dp5=GoGreenUtil.getEscapedParameter(request,"dp5");
		String dp6=GoGreenUtil.getEscapedParameter(request,"dp6");
		String dp7=GoGreenUtil.getEscapedParameter(request,"dp7");
		String dp8=GoGreenUtil.getEscapedParameter(request,"dp8");
		String dp9=GoGreenUtil.getEscapedParameter(request,"dp9");
		String dp10=GoGreenUtil.getEscapedParameter(request,"dp10");
		String total=GoGreenUtil.getEscapedParameter(request,"Total");

		String next=GoGreenUtil.getEscapedParameter(request,"next");
		String uuid=getPublicRequestParameter(request,"uuid");

		MemberDeductionScheduleC schdc=new MemberDeductionScheduleC();
		schdc.setDpone(dp1);
		schdc.setDptwo(dp2);
		schdc.setDpthree(dp3);
		schdc.setDpfour(dp4);
		schdc.setDpfive(dp5);
		schdc.setDpsix(dp6);
		schdc.setDpseven(dp7);
		schdc.setDpeight(dp8);
		schdc.setDpnine(dp9);
		schdc.setDpten(dp10);
		schdc.setScheduleCone(schedule80C1);
		schdc.setScheduleCtwo(schedule80C2);
		schdc.setScheduleCthree(schedule80C3);
		schdc.setScheduleCfour(schedule80C4);
		schdc.setScheduleCfive(schedule80C5);
		schdc.setScheduleCsix(schedule80C6);
		schdc.setScheduleCseven(schedule80C7);
		schdc.setScheduleCeight(schedule80C8);
		schdc.setScheduleCnine(schedule80C9);
		schdc.setScheduleCten(schedule80C10);
		schdc.setTotal(total);
		createMemberDeductionScheduleC(request,schdc);

		try{
			response.sendRedirect(UrlUtility.Deduction);
		}catch(IOException e){
			log.warn("this is error in Redirection",e);
		}

	}
	/**
	 * Method to Create & Update the Member Deduction Schedule80C Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Priyank
	 */
	public MemberDeductionScheduleC createMemberDeductionScheduleC(HstRequest request,MemberDeductionScheduleC schdc){

		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String pan=(String)request.getSession().getAttribute("pan");
			String filing_year=(String)request.getSession().getAttribute("filing_year");
			Member member=(Member)request.getSession().getAttribute("user");
			String username=member.getUserName().trim();
			String modusername=username.replaceAll("@", "-at-").trim();
			/*Create the path to Save Document in the Repository
			 * */
			log.warn("this is user"+username);
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request,pan,filing_year,modusername);
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */
			String updatePersonalReturnPath=ContentStructure.getSchedule80CDocumentPath(pan,filing_year,modusername);
			log.info("updatePersonalReturnPath"+updatePersonalReturnPath);
			MemberDeductionScheduleC updatepersonalInformation = (MemberDeductionScheduleC) wpm.getObject(updatePersonalReturnPath);
			if(updatepersonalInformation==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberDeductionScheduleC.NAMESPACE ,  MemberDeductionScheduleC.NODE_NAME, true);
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
				MemberDeductionScheduleC personalInformation = (MemberDeductionScheduleC) wpm.getObject(personalReturnPath);

				// update content properties
				if (personalInformation != null) {
					log.info("PAN NUKMBER");
					personalInformation.setDpone(schdc.getDpone());
					personalInformation.setDptwo(schdc.getDptwo());
					personalInformation.setDpthree(schdc.getDpthree());
					personalInformation.setDpfour(schdc.getDpfour());
					personalInformation.setDpfive(schdc.getDpfive());
					personalInformation.setDpsix(schdc.getDpsix());
					personalInformation.setDpseven(schdc.getDpseven());
					personalInformation.setDpeight(schdc.getDpeight());
					personalInformation.setDpnine(schdc.getDpnine());
					personalInformation.setDpten(schdc.getDpten());
					personalInformation.setScheduleCone(schdc.getScheduleCone());
					personalInformation.setScheduleCtwo(schdc.getScheduleCtwo());
					personalInformation.setScheduleCthree(schdc.getScheduleCthree());
					personalInformation.setScheduleCfour(schdc.getScheduleCfour());
					personalInformation.setScheduleCfive(schdc.getScheduleCfive());
					personalInformation.setScheduleCsix(schdc.getScheduleCsix());
					personalInformation.setScheduleCseven(schdc.getScheduleCseven());
					personalInformation.setScheduleCeight(schdc.getScheduleCeight());
					personalInformation.setScheduleCnine(schdc.getScheduleCnine());
					personalInformation.setScheduleCten(schdc.getScheduleCten());
					personalInformation.setTotal(schdc.getTotal());
					// update now  
					wpm.update(personalInformation);
					return personalInformation;
				} else {
					log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", MemberDeductionScheduleC.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return personalInformation;
				}
			}else{
				updatepersonalInformation.setDpone(schdc.getDpone());
				updatepersonalInformation.setDptwo(schdc.getDptwo());
				updatepersonalInformation.setDpthree(schdc.getDpthree());
				updatepersonalInformation.setDpfour(schdc.getDpfour());
				updatepersonalInformation.setDpfive(schdc.getDpfive());
				updatepersonalInformation.setDpsix(schdc.getDpsix());
				updatepersonalInformation.setDpseven(schdc.getDpseven());
				updatepersonalInformation.setDpeight(schdc.getDpeight());
				updatepersonalInformation.setDpnine(schdc.getDpnine());
				updatepersonalInformation.setDpten(schdc.getDpten());
				updatepersonalInformation.setScheduleCone(schdc.getScheduleCone());
				updatepersonalInformation.setScheduleCtwo(schdc.getScheduleCtwo());
				updatepersonalInformation.setScheduleCthree(schdc.getScheduleCthree());
				updatepersonalInformation.setScheduleCfour(schdc.getScheduleCfour());
				updatepersonalInformation.setScheduleCfive(schdc.getScheduleCfive());
				updatepersonalInformation.setScheduleCsix(schdc.getScheduleCsix());
				updatepersonalInformation.setScheduleCseven(schdc.getScheduleCseven());
				updatepersonalInformation.setScheduleCeight(schdc.getScheduleCeight());
				updatepersonalInformation.setScheduleCnine(schdc.getScheduleCnine());
				updatepersonalInformation.setScheduleCten(schdc.getScheduleCten());	
				updatepersonalInformation.setTotal(schdc.getTotal());
				wpm.update(updatepersonalInformation);
				return updatepersonalInformation;
			}
		} catch (ObjectBeanPersistenceException e) {
			log.warn("Failed to create a review for personal '" + "----- IT RETURN ------" + "'", e);
			return null;
		} catch (ObjectBeanManagerException e) {
			log.warn("Failed to create a review for personal'" + "----- IT RETURN ------" + "'", e);
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
	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}

}
