/*
 * In this class we are creating a document for storing value of Schedule80GG details of user
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

import com.mootly.wcm.beans.MemberDeductionScheduleGG;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;



public class Schedule80GG extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Schedule80GG.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Deduction Schedule80GG Page");
		String pan=(String)request.getSession().getAttribute("pan");
		String filing_year=(String)request.getSession().getAttribute("filing_year");
		Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		try {
			log.info("hello in try");
			String path1=ContentStructure.getSchedule80GGDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleGG documentgg=(MemberDeductionScheduleGG)getObjectBeanManager(request).getObject(path1);
			request.setAttribute("documentgg", documentgg);
			if(documentgg!=null){
				log.info("hello gg");
				log.warn("hello gg");
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
		log.info("This is Deduction Schedule80GG Page:doAction");
		String id1=GoGreenUtil.getEscapedParameter(request,"id1");
		String grossincome=GoGreenUtil.getEscapedParameter(request,"80GG_grossincome");
		String rentpaid=GoGreenUtil.getEscapedParameter(request,"80GG_rent_paid");
		String minexemption=GoGreenUtil.getEscapedParameter(request,"80GG_min_exemption");
		String grosstotal=GoGreenUtil.getEscapedParameter(request,"80GG_gross_total");
		String rentpaidgross=GoGreenUtil.getEscapedParameter(request,"80GG_rent_paid_gross_income");
		String deductionallow=GoGreenUtil.getEscapedParameter(request,"deduction_allow");
		String next=GoGreenUtil.getEscapedParameter(request,"next");
		String uuid=getPublicRequestParameter(request,"uuid");

		MemberDeductionScheduleGG schgg=new MemberDeductionScheduleGG();
		schgg.setDrop(id1);
		schgg.setGrossIncome(grossincome);
		schgg.setGrossTotal(grosstotal);
		schgg.setDeductionAllow(deductionallow);
		schgg.setRentPaidGross(rentpaidgross);
		schgg.setRentPaid(rentpaid);
		schgg.setMinExemption(minexemption);
		createMemberDeductionSchedule80GG(request,schgg);

		try{
			response.sendRedirect(UrlUtility.Deduction);
		}catch(IOException e){
			log.warn("this is error in Redirection",e);
		}

	}

	/**
	 * Method to Create & Update the Member Deduction Schedule80GG Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Priyank
	 */
	public MemberDeductionScheduleGG createMemberDeductionSchedule80GG(HstRequest request,MemberDeductionScheduleGG schgg){

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
			String updatePersonalReturnPath=ContentStructure.getSchedule80GGDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleGG updatepersonalInformation = (MemberDeductionScheduleGG) wpm.getObject(updatePersonalReturnPath);
			if(updatepersonalInformation==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberDeductionScheduleGG.NAMESPACE ,  MemberDeductionScheduleGG.NODE_NAME, true);
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
				MemberDeductionScheduleGG personalInformation = (MemberDeductionScheduleGG) wpm.getObject(personalReturnPath);

				// update content properties
				if (personalInformation != null) {
					log.info("PAN NUKMBER");
					personalInformation.setDrop(schgg.getDrop());
					personalInformation.setDeductionAllow(schgg.getDeductionAllow());
					personalInformation.setGrossIncome(schgg.getGrossIncome());
					personalInformation.setGrossTotal(schgg.getGrossTotal());
					personalInformation.setRentPaid(schgg.getRentPaid());
					personalInformation.setRentPaidGross(schgg.getRentPaidGross());
					personalInformation.setMinExemption(schgg.getMinExemption());

					// update now  
					wpm.update(personalInformation);
					return personalInformation;
				} else {
					log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", MemberDeductionScheduleGG.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return personalInformation;
				}
			}else{
				updatepersonalInformation.setDrop(schgg.getDrop());
				updatepersonalInformation.setDeductionAllow(schgg.getDeductionAllow());
				updatepersonalInformation.setGrossIncome(schgg.getGrossIncome());
				updatepersonalInformation.setGrossTotal(schgg.getGrossTotal());
				updatepersonalInformation.setRentPaid(schgg.getRentPaid());
				updatepersonalInformation.setRentPaidGross(schgg.getRentPaidGross());
				updatepersonalInformation.setMinExemption(schgg.getMinExemption());
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
