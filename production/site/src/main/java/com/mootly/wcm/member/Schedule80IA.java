/*
 * In this class we are creating a document for storing value of Schedule80IA details of user
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

import com.mootly.wcm.beans.MemberDeductionScheduleIA;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;



public class Schedule80IA extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Schedule80IA.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
			// TODO Auto-generated method stub
			super.doBeforeRender(request, response);
			log.info("This is Deduction Schedule80IA Page");
			String pan=(String)request.getSession().getAttribute("pan");
			String filing_year=(String)request.getSession().getAttribute("filing_year");
			Member member=(Member)request.getSession().getAttribute("user");
			String username=member.getUserName().trim();
			String modusername=username.replaceAll("@", "-at-").trim();
			try {
				log.info("hello in try");
				String path2=ContentStructure.getSchedule80IADocumentPath(pan,filing_year,modusername);
				MemberDeductionScheduleIA documentia=(MemberDeductionScheduleIA)getObjectBeanManager(request).getObject(path2);
				request.setAttribute("documentia", documentia);
				if(documentia!=null){
					log.info("hello ia");
					log.warn("hello ia");
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
		log.info("This is Deduction Schedule80IA Page:doAction");		
		String id1ia=GoGreenUtil.getEscapedParameter(request,"id1ia");
		String id2ia=GoGreenUtil.getEscapedParameter(request,"id2ia");
		String id3ia=GoGreenUtil.getEscapedParameter(request,"id3ia");
		String id4ia=GoGreenUtil.getEscapedParameter(request,"id4ia");
		String id5ia=GoGreenUtil.getEscapedParameter(request,"id5ia");
		String id6ia=GoGreenUtil.getEscapedParameter(request,"id6ia");
		String next=GoGreenUtil.getEscapedParameter(request,"next");
		String uuid=getPublicRequestParameter(request,"uuid");
	
		
		MemberDeductionScheduleIA schia=new MemberDeductionScheduleIA();
		schia.setInfraFac(id1ia);
		schia.setTeleFac(id2ia);
		schia.setIndsPark(id3ia);
		schia.setPowerGen(id4ia);
		schia.setEngPower(id5ia);
		schia.setTotal(id6ia);
		createMemberDeductionSchedule80IA(request,schia);		
			try{
				response.sendRedirect(UrlUtility.Deduction);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
	}

	/**
	 * Method to Create & Update the Member Deduction Schedule80IA Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Kusum
	 */
public final MemberDeductionScheduleIA createMemberDeductionSchedule80IA(HstRequest request,MemberDeductionScheduleIA schia){
		
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
					String updatePersonalReturnPath=ContentStructure.getSchedule80IADocumentPath(pan,filing_year,modusername);
					MemberDeductionScheduleIA updatepersonalInformation = (MemberDeductionScheduleIA) wpm.getObject(updatePersonalReturnPath);
					if(updatepersonalInformation==null){
					final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberDeductionScheduleIA.NAMESPACE ,  MemberDeductionScheduleIA.NODE_NAME, true);
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
					/*MemberDeductionScheduleIA
					 *getObject method get the object at passed path in Repository.
					 * */
					MemberDeductionScheduleIA personalInformation = (MemberDeductionScheduleIA) wpm.getObject(personalReturnPath);
					
					// update content properties
					if (personalInformation != null) {
						log.info("PAN NUKMBER");
						personalInformation.setInfraFac(schia.getInfraFac());
						personalInformation.setTeleFac(schia.getTeleFac());
						personalInformation.setEngPower(schia.getEngPower());
						personalInformation.setPowerGen(schia.getPowerGen());
						personalInformation.setIndsPark(schia.getIndsPark());
						personalInformation.setTotal(schia.getTotal());
						// update now  
						wpm.update(personalInformation);
						return personalInformation;
					} else {
						log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", MemberDeductionScheduleIA.NODE_NAME, personalReturnPath);
						GoGreenUtil.refreshWorkflowManager(wpm);
						return personalInformation;
					}
				  }else{
					    updatepersonalInformation.setInfraFac(schia.getInfraFac());
						updatepersonalInformation.setTeleFac(schia.getTeleFac());
						updatepersonalInformation.setEngPower(schia.getEngPower());
						updatepersonalInformation.setPowerGen(schia.getPowerGen());
						updatepersonalInformation.setIndsPark(schia.getIndsPark());
						updatepersonalInformation.setTotal(schia.getTotal());
						
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
