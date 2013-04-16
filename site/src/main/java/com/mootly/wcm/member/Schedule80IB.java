/*
 * In this class we are creating a document for storing value of Schedule80IB details of user
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

import com.mootly.wcm.beans.MemberDeductionScheduleIB;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;



public class Schedule80IB extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Schedule80IB.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
			// TODO Auto-generated method stub
			super.doBeforeRender(request, response);
			log.info("This is Deduction Schedule80IB Page");
			String pan=(String)request.getSession().getAttribute("pan");
			String filing_year=(String)request.getSession().getAttribute("filing_year");
			Member member=(Member)request.getSession().getAttribute("user");
			String username=member.getUserName().trim();
			String modusername=username.replaceAll("@", "-at-").trim();
			try {
				log.info("hello in try");				
				String path3=ContentStructure.getSchedule80IBDocumentPath(pan,filing_year,modusername);
				MemberDeductionScheduleIB documentib=(MemberDeductionScheduleIB)getObjectBeanManager(request).getObject(path3);
				request.setAttribute("documentib", documentib);
				if(documentib!=null){
					log.info("hello ib");
					log.warn("hello ib");
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
		log.info("This is Deduction Schedule80IB Page:doAction");

		String id1ib=GoGreenUtil.getEscapedParameter(request,"id1ib");
		String id2ib=GoGreenUtil.getEscapedParameter(request,"id2ib");
		String id3ib=GoGreenUtil.getEscapedParameter(request,"id3ib");
		String id4ib=GoGreenUtil.getEscapedParameter(request,"id4ib");
		String id5ib=GoGreenUtil.getEscapedParameter(request,"id5ib");
		String id6ib=GoGreenUtil.getEscapedParameter(request,"id6ib");
		String id7ib=GoGreenUtil.getEscapedParameter(request,"id7ib");
		String id8ib=GoGreenUtil.getEscapedParameter(request,"id8ib");
		String id9ib=GoGreenUtil.getEscapedParameter(request,"id9ib");
		String id10ib=GoGreenUtil.getEscapedParameter(request,"id10ib");
		String id11ib=GoGreenUtil.getEscapedParameter(request,"id11ib");
		String id12ib=GoGreenUtil.getEscapedParameter(request,"id12ib");
		String id13ib=GoGreenUtil.getEscapedParameter(request,"id13ib");
		String id14ib=GoGreenUtil.getEscapedParameter(request,"id14ib");

		String next=GoGreenUtil.getEscapedParameter(request,"next");
		String uuid=getPublicRequestParameter(request,"uuid");

		MemberDeductionScheduleIB schib=new MemberDeductionScheduleIB();
		schib.setIndUndtk(id1ib);
		schib.setLocJammu(id2ib);
		schib.setLocIndBackState(id3ib);
		schib.setLocIndBackDisct(id4ib);
		schib.setMulTheater(id5ib);
		schib.setConvCenter(id6ib);
		schib.setScientRes(id7ib);
		schib.setEngProdOil(id8ib);
		schib.setDevHouseProject(id9ib);
		schib.setOpColdChain(id10ib);
		schib.setFruit(id11ib);
		schib.setFoodGrains(id12ib);
		schib.setRuralHos(id13ib);
		schib.setTotal(id14ib);
		createMemberDeductionSchedule80IB(request,schib);

		try{
			response.sendRedirect(UrlUtility.Deduction);
		}catch(IOException e){
			log.warn("this is error in Redirection",e);
		}

	}

	/**
	 * Method to Create & Update the Member Deduction Schedule80IB Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Kusum
	 */
	public MemberDeductionScheduleIB createMemberDeductionSchedule80IB(HstRequest request,MemberDeductionScheduleIB schib){

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
			String updatePersonalReturnPath=ContentStructure.getSchedule80IBDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleIB updatepersonalInformation = (MemberDeductionScheduleIB) wpm.getObject(updatePersonalReturnPath);
			if(updatepersonalInformation==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberDeductionScheduleIB.NAMESPACE ,  MemberDeductionScheduleIB.NODE_NAME, true);
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
				/*MemberDeductionScheduleIB
				 *getObject method get the object at passed path in Repository.
				 * */
				MemberDeductionScheduleIB personalInformation = (MemberDeductionScheduleIB) wpm.getObject(personalReturnPath);

				// update content properties
				if (personalInformation != null) {
					log.info("PAN NUKMBER");
					personalInformation.setIndUndtk(schib.getIndUndtk());
					personalInformation.setConvCenter(schib.getConvCenter());
					personalInformation.setDevHouseProject(schib.getDevHouseProject());
					personalInformation.setEngProdOil(schib.getEngProdOil());
					personalInformation.setFoodGrains(schib.getFoodGrains());
					personalInformation.setFruit(schib.getFruit());
					personalInformation.setIndUndtk(schib.getIndUndtk());
					personalInformation.setLocIndBackDisct(schib.getLocIndBackDisct());
					personalInformation.setLocIndBackState(schib.getLocIndBackState());
					personalInformation.setLocJammu(schib.getLocJammu());
					personalInformation.setMulTheater(schib.getMulTheater());
					personalInformation.setOpColdChain(schib.getOpColdChain());
					personalInformation.setRuralHos(schib.getRuralHos());
					personalInformation.setTotal(schib.getTotal());
					wpm.update(personalInformation);
					return personalInformation;
				} else {
					log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", MemberDeductionScheduleIB.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return personalInformation;
				}
			}else{
				updatepersonalInformation.setIndUndtk(schib.getIndUndtk());
				updatepersonalInformation.setConvCenter(schib.getConvCenter());
				updatepersonalInformation.setDevHouseProject(schib.getDevHouseProject());
				updatepersonalInformation.setEngProdOil(schib.getEngProdOil());
				updatepersonalInformation.setFoodGrains(schib.getFoodGrains());
				updatepersonalInformation.setFruit(schib.getFruit());
				updatepersonalInformation.setIndUndtk(schib.getIndUndtk());
				updatepersonalInformation.setLocIndBackDisct(schib.getLocIndBackDisct());
				updatepersonalInformation.setLocIndBackState(schib.getLocIndBackState());
				updatepersonalInformation.setLocJammu(schib.getLocJammu());
				updatepersonalInformation.setMulTheater(schib.getMulTheater());
				updatepersonalInformation.setOpColdChain(schib.getOpColdChain());
				updatepersonalInformation.setRuralHos(schib.getRuralHos());
				updatepersonalInformation.setTotal(schib.getTotal());
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
