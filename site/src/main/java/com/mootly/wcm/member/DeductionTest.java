/*
 * In this class we are creating a document for storing value of Deduction details of user
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

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberDeductionScheduleC;
import com.mootly.wcm.beans.MemberDeductionScheduleG;
import com.mootly.wcm.beans.MemberDeductionScheduleGG;
import com.mootly.wcm.beans.MemberDeductionScheduleIA;
import com.mootly.wcm.beans.MemberDeductionScheduleIB;
import com.mootly.wcm.beans.MemberDeductionScheduleIC;
import com.mootly.wcm.beans.MemberDeductionScheduleVIA;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

@PrimaryBean(primaryBeanClass=MemberDeductionScheduleVIA.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"head","investment"})
@RequiredFields(fieldNames={"Section80C","Section80GGC","Section80CCC","Section80QQB","Section80CCD"
		,"Section80RRB","Section80D","Section80U","Section80DD","Section80IA"
		,"Section80DDB","Section80IB","Section80E","Section80IC","Section80G"
		,"Section80JJA","Section80GG","Section80ID","Section80GGA"
		,"Section80IAB","Section80CCF","total"})
public class DeductionTest extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(DeductionTest.class);
	String deduction_section = null;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		String deduction_section = request.getRequestContext().getResolvedSiteMapItem().getParameter("deduction_section");
		if (deduction_section != null) {
			request.setAttribute("deduction_section", deduction_section);
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		//super.beforeSave(request);
		//we need to change the child bean in case of new child to ensure correct section is saved
		String deduction_section = request.getRequestContext().getResolvedSiteMapItem().getParameter("deduction_section");
		if (getITRInitData(request).getPageAction().equals(PAGE_ACTION.NEW_CHILD) && deduction_section != null) {
			if (getITRInitData(request).getChildBean() != null) {
				DeductionDocumentDetail dd = (DeductionDocumentDetail) getITRInitData(request).getChildBean();				
				dd.setSection(deduction_section);
			}
		}
		return true;
	}

	public void doBeforeRenderOld(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Deduction Page");
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
				log.info("document ia");
			}
			String path3=ContentStructure.getSchedule80IBDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleIB documentib=(MemberDeductionScheduleIB)getObjectBeanManager(request).getObject(path3);
			request.setAttribute("documentib", documentib);
			if(documentib!=null){
				log.info("document ib");
			}
			String path1=ContentStructure.getSchedule80GGDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleGG documentgg=(MemberDeductionScheduleGG)getObjectBeanManager(request).getObject(path1);
			request.setAttribute("documentgg", documentgg);
			if(documentgg!=null){
				log.info("document gg");
			}

			String path4=ContentStructure.getSchedule80ICDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleIC documentic=(MemberDeductionScheduleIC)getObjectBeanManager(request).getObject(path4);
			request.setAttribute("documentic", documentic);

			String path5=ContentStructure.getSchedule80CDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleC documentc=(MemberDeductionScheduleC)getObjectBeanManager(request).getObject(path5);
			request.setAttribute("documentc", documentc);
			if(documentc!=null){
				log.info("document c");
			}
			String path6=ContentStructure.getSchedule80GDocumentPath(pan, filing_year, modusername);
			MemberDeductionScheduleG documentg=(MemberDeductionScheduleG)getObjectBeanManager(request).getObject(path6);
			request.setAttribute("documentg", documentg);
			if(documentg!=null){
				log.info("document g");
			}
			String path7=ContentStructure.getScheduleVIADocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleVIA documentvia=(MemberDeductionScheduleVIA)getObjectBeanManager(request).getObject(path7);
			request.setAttribute("documentvia", documentvia);
			if(documentvia!=null){
				log.info("document via");
			}
		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doActionOld(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.info("This is Deduction Page:doAction");

		String next=GoGreenUtil.getEscapedParameter(request,"next");
		String basic80C=GoGreenUtil.getEscapedParameter(request, "basic80C");
		String basic80GG=GoGreenUtil.getEscapedParameter(request, "basic80GG");
		String basic80G=GoGreenUtil.getEscapedParameter(request, "basic80G");
		String basic80IA=GoGreenUtil.getEscapedParameter(request, "basic80IA");
		String basic80IB=GoGreenUtil.getEscapedParameter(request, "basic80IB");
		String basic80IC=GoGreenUtil.getEscapedParameter(request,"basic80IC");
		String uuid=getPublicRequestParameter(request,"uuid");
		log.info("basic80C"+basic80C);
		if(basic80C!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80C);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80GG"+basic80GG);
		if(basic80GG!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80GG);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80G"+basic80G);
		if(basic80G!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80G);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80IA"+basic80IA);
		if(basic80IA!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80IA);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80IB"+basic80IB);
		if(basic80IB!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80IB);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80IC"+basic80IC);
		if(basic80IC!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80IC);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("next"+next);
		if(next!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.RebateSection89);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
	}
	/**
	 * Method to Save all entries of Deduction page
	 * @param HstRequest
	 * @throws 
	 * @author Priyank
	 */
	public void callofDeduction(HstRequest request){
		String Section80C=GoGreenUtil.getEscapedParameter(request,"Section80C");
		String Section80GGC=GoGreenUtil.getEscapedParameter(request,"Section80GGC");
		String Section80CCC=GoGreenUtil.getEscapedParameter(request,"Section80CCC");
		String Section80QQB=GoGreenUtil.getEscapedParameter(request,"Section80QQB");
		String Section80CCD=GoGreenUtil.getEscapedParameter(request,"Section80CCD");
		String Section80RRB=GoGreenUtil.getEscapedParameter(request,"Section80RRB");
		String Section80D=GoGreenUtil.getEscapedParameter(request,"Section80D");
		String Section80U=GoGreenUtil.getEscapedParameter(request,"Section80U");
		String Section80DD=GoGreenUtil.getEscapedParameter(request,"Section80DD");
		String Section80IA=GoGreenUtil.getEscapedParameter(request,"Section80IA");
		String Section80DDB=GoGreenUtil.getEscapedParameter(request,"Section80DDB");
		String Section80IB=GoGreenUtil.getEscapedParameter(request,"Section80IB");
		String Section80E=GoGreenUtil.getEscapedParameter(request,"Section80E");
		String Section80IC=GoGreenUtil.getEscapedParameter(request,"Section80IC");
		String Section80G=GoGreenUtil.getEscapedParameter(request,"Section80G");
		String Section80JJA=GoGreenUtil.getEscapedParameter(request,"Section80JJA");
		String Section80GG=GoGreenUtil.getEscapedParameter(request,"Section80GG");
		String Section80ID=GoGreenUtil.getEscapedParameter(request,"Section80ID");
		String Section80GGA=GoGreenUtil.getEscapedParameter(request,"Section80GGA");
		String Section80IAB=GoGreenUtil.getEscapedParameter(request,"Section80IAB");
		String Section80CCF=GoGreenUtil.getEscapedParameter(request,"Section80CCF");
		String Total=GoGreenUtil.getEscapedParameter(request,"total");

		MemberDeductionScheduleVIA schvia=new MemberDeductionScheduleVIA();
		schvia.setScheduleC(Section80C);
		schvia.setScheduleGGC(Section80GGC);
		schvia.setScheduleCCC(Section80CCC);
		schvia.setScheduleQQB(Section80QQB);
		schvia.setScheduleCCD(Section80CCD);
		schvia.setScheduleRRB(Section80RRB);
		schvia.setScheduleD(Section80D);
		schvia.setScheduleU(Section80U);
		schvia.setScheduleDD(Section80DD);
		schvia.setScheduleIA(Section80IA);
		schvia.setScheduleDDB(Section80DDB);
		schvia.setScheduleIB(Section80IB);
		schvia.setScheduleE(Section80E);
		schvia.setScheduleIC(Section80IC);
		schvia.setScheduleG(Section80G);
		schvia.setScheduleJJA(Section80JJA);
		schvia.setScheduleGG(Section80GG);
		schvia.setScheduleID(Section80ID);
		schvia.setScheduleGGA(Section80GGA);
		schvia.setScheduleIAB(Section80IAB);
		schvia.setScheduleCCF(Section80CCF);
		schvia.setTotal(Total);
		createMemberDeductionScheduleVIA(request,schvia);
	}

	/**
	 * Method to Create & Update the Member Deduction ScheduleVIA Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Priyank
	 */
	public MemberDeductionScheduleVIA createMemberDeductionScheduleVIA(HstRequest request,MemberDeductionScheduleVIA schvia){

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
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request,pan,filing_year,username);
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */
			String updatePersonalReturnPath=ContentStructure.getScheduleVIADocumentPath(pan,filing_year,modusername);
			log.info("updatePersonalReturnPath"+updatePersonalReturnPath);
			MemberDeductionScheduleVIA updatepersonalInformation = (MemberDeductionScheduleVIA) wpm.getObject(updatePersonalReturnPath);
			if(updatepersonalInformation==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberDeductionScheduleVIA.NAMESPACE ,  MemberDeductionScheduleVIA.NODE_NAME, true);
				/*MemberDeductionScheduleVIA
				 *getObject method get the object at passed path in Repository.
				 * */
				MemberDeductionScheduleVIA personalInformation = (MemberDeductionScheduleVIA) wpm.getObject(personalReturnPath);

				// update content properties
				if (personalInformation != null) {
					log.info("PAN NUMBER");
					personalInformation.setScheduleC(schvia.getScheduleC());
					personalInformation.setScheduleGGC(schvia.getScheduleGGC());
					personalInformation.setScheduleCCC(schvia.getScheduleCCC());
					personalInformation.setScheduleQQB(schvia.getScheduleQQB());
					personalInformation.setScheduleCCD(schvia.getScheduleCCD());
					personalInformation.setScheduleRRB(schvia.getScheduleRRB());
					personalInformation.setScheduleD(schvia.getScheduleD());
					personalInformation.setScheduleU(schvia.getScheduleU());
					personalInformation.setScheduleDD(schvia.getScheduleDD());
					personalInformation.setScheduleIA(schvia.getScheduleIA());
					personalInformation.setScheduleDDB(schvia.getScheduleDDB());
					personalInformation.setScheduleIB(schvia.getScheduleIB());
					personalInformation.setScheduleE(schvia.getScheduleE());
					personalInformation.setScheduleIC(schvia.getScheduleIC());
					personalInformation.setScheduleG(schvia.getScheduleG());
					personalInformation.setScheduleJJA(schvia.getScheduleJJA());
					personalInformation.setScheduleGG(schvia.getScheduleGG());
					personalInformation.setScheduleID(schvia.getScheduleID());
					personalInformation.setScheduleGGA(schvia.getScheduleGGA());
					personalInformation.setScheduleIAB(schvia.getScheduleIAB());
					personalInformation.setScheduleCCF(schvia.getScheduleCCF());
					personalInformation.setTotal(schvia.getTotal());
					// update now  
					wpm.update(personalInformation);
					return personalInformation;
				} else {
					log.warn("Failed to add Deduction Document '{}': could not retrieve Deduction bean for node '{}'.", MemberDeductionScheduleVIA.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return personalInformation;
				}
			}else{
				log.info("update");
				updatepersonalInformation.setScheduleC(schvia.getScheduleC());
				updatepersonalInformation.setScheduleGGC(schvia.getScheduleGGC());
				updatepersonalInformation.setScheduleCCC(schvia.getScheduleCCC());
				updatepersonalInformation.setScheduleQQB(schvia.getScheduleQQB());
				updatepersonalInformation.setScheduleCCD(schvia.getScheduleCCD());
				updatepersonalInformation.setScheduleRRB(schvia.getScheduleRRB());
				updatepersonalInformation.setScheduleD(schvia.getScheduleD());
				updatepersonalInformation.setScheduleU(schvia.getScheduleU());
				updatepersonalInformation.setScheduleDD(schvia.getScheduleDD());
				updatepersonalInformation.setScheduleIA(schvia.getScheduleIA());
				updatepersonalInformation.setScheduleDDB(schvia.getScheduleDDB());
				updatepersonalInformation.setScheduleIB(schvia.getScheduleIB());
				updatepersonalInformation.setScheduleE(schvia.getScheduleE());
				updatepersonalInformation.setScheduleIC(schvia.getScheduleIC());
				updatepersonalInformation.setScheduleG(schvia.getScheduleG());
				updatepersonalInformation.setScheduleJJA(schvia.getScheduleJJA());
				updatepersonalInformation.setScheduleGG(schvia.getScheduleGG());
				updatepersonalInformation.setScheduleID(schvia.getScheduleID());
				updatepersonalInformation.setScheduleGGA(schvia.getScheduleGGA());
				updatepersonalInformation.setScheduleIAB(schvia.getScheduleIAB());
				updatepersonalInformation.setScheduleCCF(schvia.getScheduleCCF());
				updatepersonalInformation.setTotal(schvia.getTotal());
				wpm.update(updatepersonalInformation);
				return updatepersonalInformation;
			}
		} catch (ObjectBeanPersistenceException e) {
			log.warn("Failed to create a review for Deduction '" + "----- IT RETURN ------" + "'", e);
			return null;
		} catch (ObjectBeanManagerException e) {
			log.warn("Failed to create a review for Deduction'" + "----- IT RETURN ------" + "'", e);
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