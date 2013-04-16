/*
 * In this class we are creating a document for storing value of Schedule80IC details of user
 * according to form 16.
 * @author Kusum
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

import com.mootly.wcm.beans.MemberDeductionScheduleIC;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;



public class Schedule80IC extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Schedule80IC.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Deduction Schedule80IC Page");
		String pan=(String)request.getSession().getAttribute("pan");
		String filing_year=(String)request.getSession().getAttribute("filing_year");
		Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		try {
			log.info("hello in try");				
			String path4=ContentStructure.getSchedule80ICDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleIC documentic=(MemberDeductionScheduleIC)getObjectBeanManager(request).getObject(path4);
			request.setAttribute("documentic", documentic);
			if(documentic!=null){
				log.info("hello ic");
				log.warn("hello ic");
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
		log.info("This is Deduction Schedule80IC Page:doAction");

		String id1ic=GoGreenUtil.getEscapedParameter(request,"id1ic");
		String id2ic=GoGreenUtil.getEscapedParameter(request,"id2ic");
		String id3ic=GoGreenUtil.getEscapedParameter(request,"id3ic");
		String id4ic=GoGreenUtil.getEscapedParameter(request,"id4ic");
		String id5ic=GoGreenUtil.getEscapedParameter(request,"id5ic");
		String id6ic=GoGreenUtil.getEscapedParameter(request,"id6ic");
		String id7ic=GoGreenUtil.getEscapedParameter(request,"id7ic");
		String id8ic=GoGreenUtil.getEscapedParameter(request,"id8ic");
		String id9ic=GoGreenUtil.getEscapedParameter(request,"id9ic");
		String id10ic=GoGreenUtil.getEscapedParameter(request,"id10ic");
		String id11ic=GoGreenUtil.getEscapedParameter(request,"id11ic");
		String id12ic=GoGreenUtil.getEscapedParameter(request,"id12ic");
		String id13ic=GoGreenUtil.getEscapedParameter(request,"id13ic");

		String next=GoGreenUtil.getEscapedParameter(request,"next");
		String uuid=getPublicRequestParameter(request,"uuid");

		MemberDeductionScheduleIC schic=new MemberDeductionScheduleIC();
		schic.setLocSikkim(id1ic);
		schic.setLocHimachalPradesh(id2ic);
		schic.setLocUttaranchal(id3ic);
		schic.setNorestAssam(id5ic);
		schic.setNorestArunachal(id6ic);
		schic.setNorestManipur(id7ic);
		schic.setNorestMizoram(id8ic);
		schic.setNorestMeghalaya(id9ic);
		schic.setNorestTripura(id10ic);
		schic.setNorestNagaland(id11ic);
		schic.setTotalnorest(id12ic);
		schic.setTotal(id13ic);

		createMemberDeductionSchedule80IC(request,schic);

		try{
			response.sendRedirect(UrlUtility.Deduction);
		}catch(IOException e){
			log.warn("this is error in Redirection",e);
		}

	}

	/**
	 * Method to Create & Update the Member Deduction Schedule80IC Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Kusum
	 */
	public MemberDeductionScheduleIC createMemberDeductionSchedule80IC(HstRequest request,MemberDeductionScheduleIC schic){

		// TODO Auto-generated method stub
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
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request,pan,filing_year,member.getUserName());
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */
			String updatePersonalReturnPath=ContentStructure.getSchedule80ICDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleIC updatepersonalInformation = (MemberDeductionScheduleIC) wpm.getObject(updatePersonalReturnPath);
			if(updatepersonalInformation==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberDeductionScheduleIC.NAMESPACE ,  MemberDeductionScheduleIC.NODE_NAME, true);
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
				MemberDeductionScheduleIC personalInformation = (MemberDeductionScheduleIC) wpm.getObject(personalReturnPath);

				// update content properties
				if (personalInformation != null) {
					log.info("PAN NUKMBER");
					personalInformation.setLocHimachalPradesh(schic.getLocHimachalPradesh());
					personalInformation.setLocSikkim(schic.getLocSikkim());
					personalInformation.setLocUttaranchal(schic.getLocUttaranchal());
					personalInformation.setNorestArunachal(schic.getNorestArunachal());
					personalInformation.setNorestAssam(schic.getNorestAssam());
					personalInformation.setNorestManipur(schic.getNorestManipur());
					personalInformation.setNorestMeghalaya(schic.getNorestMeghalaya());
					personalInformation.setNorestMizoram(schic.getNorestMizoram());
					personalInformation.setNorestNagaland(schic.getNorestNagaland());
					personalInformation.setNorestTripura(schic.getNorestTripura());
					personalInformation.setTotalnorest(schic.getTotalnorest());
					personalInformation.setTotal(schic.getTotal());
					// update now  
					wpm.update(personalInformation);
					return personalInformation;
				} else {
					log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", MemberDeductionScheduleIC.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return personalInformation;
				}
			}else{
				updatepersonalInformation.setLocHimachalPradesh(schic.getLocHimachalPradesh());
				updatepersonalInformation.setLocSikkim(schic.getLocSikkim());
				updatepersonalInformation.setLocUttaranchal(schic.getLocUttaranchal());
				updatepersonalInformation.setNorestArunachal(schic.getNorestArunachal());
				updatepersonalInformation.setNorestAssam(schic.getNorestAssam());
				updatepersonalInformation.setNorestManipur(schic.getNorestManipur());
				updatepersonalInformation.setNorestMeghalaya(schic.getNorestMeghalaya());
				updatepersonalInformation.setNorestMizoram(schic.getNorestMizoram());
				updatepersonalInformation.setNorestNagaland(schic.getNorestNagaland());
				updatepersonalInformation.setNorestTripura(schic.getNorestTripura());
				updatepersonalInformation.setTotalnorest(schic.getTotalnorest());
				updatepersonalInformation.setTotal(schic.getTotal());
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
