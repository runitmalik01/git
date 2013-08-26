package com.mootly.wcm.member;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.InvalidNavigationException;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;
import com.mootly.wcm.services.ditws.model.Twenty26ASTDSOtherThanSalary;
import com.mootly.wcm.services.ditws.model.Twenty26ASTaxPayment;

@RequiredBeans (requiredBeans={MemberPersonalInformation.class})  //this bean must be present before we do any thing
@FormFields(fieldNames={})
public class SyncTDSFromDIT extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(SyncTDSFromDIT.class);
	private static final String SUCCESS = "success";
	@Override

	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		String message = request.getParameter("Success");
		if(null != message){
			request.setAttribute("message", message);
		}
		Retrieve26ASInformation retrieve26asInformation = getRetrieve26ASService();
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if (memberPersonalInformation == null) {
			log.warn("Personal Information is NULL for the following path " + request.getPathInfo());
			return;
		}
		try {
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(memberPersonalInformation.getPAN(), memberPersonalInformation.getDOB() , getFinancialYear().getAssessmentYearForDITSOAPCall());
			request.setAttribute("twenty26asResponse", twenty26asResponse);

		} catch (MissingInformationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("Missing Information",e);
		} catch (DataMismatchException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("DataMismatchException",e);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			log.error("InvalidFormatException",e);
			e.printStackTrace();
		}

	}

	@SuppressWarnings("null")
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		Session persistableSession = null;
		Retrieve26ASInformation retrieve26asInformation = getRetrieve26ASService();
		try {
			if(log.isInfoEnabled()){
				log.info("inside try");
			}
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(memberPersonalInformation.getPAN(), memberPersonalInformation.getDOB() , getFinancialYear().getAssessmentYearForDITSOAPCall());
			request.setAttribute("twenty26asResponse", twenty26asResponse);
			@SuppressWarnings("unchecked")
			List list = Collections.synchronizedList(new ArrayList());
			try {
				persistableSession=getPersistableSession(request);
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String pathSelfAssesment = getAbsoluteBasePathToReturnDocuments()+"/"+SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase();
			String pathTdsfromOthers = getAbsoluteBasePathToReturnDocuments()+"/"+TdsFromothersDocument.class.getSimpleName().toLowerCase();
			SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument)wpm.getObject(pathSelfAssesment);
			TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) wpm.getObject(pathTdsfromOthers);
			//update or add doc for selfassess
			updateOrAddSelfAssessmentDocument(selfAssesmetTaxDocument, list, wpm ,twenty26asResponse);
			//update or add doc for tdsfrom others
			updateOrAddTdsOthersDocument(tdsFromothersDocument, list, wpm ,twenty26asResponse);
			response.setRenderParameter("Success", "Success");


		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while get Object at specified path",e);
		} catch (InvalidNavigationException e) {
			// TODO Auto-generated catch block
			log.error("Error while create base path to get document",e);
		} catch (MissingInformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	/**
	 * This method is used to update & add  {@link SelfAssesmetTaxDocument}
	 * @param parentBean {@link HippoBean} Bean document of {@link SelfAssesmetTaxDocument}
	 * @throws ObjectBeanManagerException 
	 * @throws InvalidNavigationException 
	 * 
	 * */
	public void updateOrAddSelfAssessmentDocument( SelfAssesmetTaxDocument selfAssesmetTaxDocument,List list, WorkflowPersistenceManager wpm, Twenty26ASResponse twenty26asResponse) throws ObjectBeanManagerException, InvalidNavigationException{
		log.info("inside finding child");
		if(null==selfAssesmetTaxDocument){
			if(log.isInfoEnabled()){
				log.warn("we have no doc");
			}
			String createdDocPath = wpm.createAndReturn(getAbsoluteBasePathToReturnDocuments(), SelfAssesmetTaxDocument.NAMESPACE, SelfAssesmetTaxDocument.NODE_NAME, true);
			selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) wpm.getObject(createdDocPath);
		}
		Twenty26ASTaxPayment item = twenty26asResponse.getTwenty26asTaxPayments().get(getTotalChildren());
		String sectionChildUUIDforself = finduuidofChildnodefrself(selfAssesmetTaxDocument);
		if(StringUtils.isNotBlank(sectionChildUUIDforself)){
			list.addAll(twenty26asResponse.getTwenty26asTaxPayments());
			log.info(""+list.size());
			SelfAssesmentTaxDetail siDetailUp = (SelfAssesmentTaxDetail) wpm.getObjectByUuid(sectionChildUUIDforself);
			siDetailUp.setP_BSR(item.getBSRCode());
			siDetailUp.setP_Serial(item.getSrlNoOfChaln());
			double amt = Double.parseDouble(item.getAmt());
			siDetailUp.setP_Amount(amt);
			String date = item.getDateDep();
			GregorianCalendar newDate= ConvDateStringToCalendar(date);
			siDetailUp.setP_Date(newDate);
			selfAssesmetTaxDocument.update(siDetailUp);
			try {
				wpm.update(selfAssesmetTaxDocument);
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			SelfAssesmentTaxDetail siDetailUp= new SelfAssesmentTaxDetail();
			siDetailUp.setP_BSR(item.getBSRCode());
			siDetailUp.setP_Serial(item.getSrlNoOfChaln());
			double amt = Double.parseDouble(item.getAmt());
			siDetailUp.setP_Amount(amt);
			String date = item.getDateDep();
			GregorianCalendar newDate= ConvDateStringToCalendar(date);
			siDetailUp.setP_Date(newDate);
			selfAssesmetTaxDocument.add(siDetailUp);
			try {
				wpm.update(selfAssesmetTaxDocument);
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}


	/**
	 * This method is used to update & add  {@link TdsFromothersDocument}
	 * @param parentBean {@link HippoBean} Bean document of {@link TdsFromothersDocument}
	 * @throws ObjectBeanManagerException 
	 * @throws InvalidNavigationException 
	 * 
	 * */
	public void updateOrAddTdsOthersDocument( TdsFromothersDocument tdsFromothersDocument,List list, WorkflowPersistenceManager wpm, Twenty26ASResponse twenty26asResponse) throws ObjectBeanManagerException, InvalidNavigationException{
		log.info("inside finding child");
		if(null == tdsFromothersDocument){
			log.info("we have no doc1");
			String createdDocPath = wpm.createAndReturn(getAbsoluteBasePathToReturnDocuments(), TdsFromothersDocument.NAMESPACE, TdsFromothersDocument.NODE_NAME, true);
			tdsFromothersDocument = (TdsFromothersDocument) wpm.getObject(createdDocPath);
		} 
		Twenty26ASTDSOtherThanSalary listTwenty26astdsOtherThanSalaries = twenty26asResponse.getTwenty26astdsOtherThanSalaries().get(getTotalChildren());
		String sectionChildUUID = finduuidofChildnode(tdsFromothersDocument);
		log.info("hereeeeeeeeee"+sectionChildUUID);
		if(StringUtils.isNotBlank(sectionChildUUID)){
			log.info("object is"+sectionChildUUID);
			list.addAll(twenty26asResponse.getTwenty26astdsOtherThanSalaries());
			log.info(""+list.size());
			TdsOthersDetail tdsOthersDetail = (TdsOthersDetail) wpm.getObjectByUuid(sectionChildUUID);
			tdsOthersDetail.setFinancial_Year(listTwenty26astdsOtherThanSalaries.getDeductedYr());
			double amt = Double.parseDouble(listTwenty26astdsOtherThanSalaries.getClaimOutOfTotTDSOnAmtPaid());
			tdsOthersDetail.setP_Amount(amt);
			tdsOthersDetail.setName_Deductor(listTwenty26astdsOtherThanSalaries.getEmployerOrDeductorOrCollecterName());
			tdsOthersDetail.setTan_Deductor(listTwenty26astdsOtherThanSalaries.getTAN());
			tdsOthersDetail.setTds_Certificate(listTwenty26astdsOtherThanSalaries.getUniqueTDSCerNo());
			tdsOthersDetail.setTotal_TaxDeductor(amt);
			tdsFromothersDocument.update(tdsOthersDetail);
			wpm.update(tdsFromothersDocument);
		}else{
			TdsOthersDetail childDoc = new TdsOthersDetail();
			childDoc.setFinancial_Year(listTwenty26astdsOtherThanSalaries.getDeductedYr());
			double amt = Double.parseDouble(listTwenty26astdsOtherThanSalaries.getClaimOutOfTotTDSOnAmtPaid());
			childDoc.setName_Deductor(listTwenty26astdsOtherThanSalaries.getEmployerOrDeductorOrCollecterName());
			childDoc.setP_Amount(amt);
			childDoc.setTan_Deductor(listTwenty26astdsOtherThanSalaries.getTAN());
			childDoc.setTds_Certificate(listTwenty26astdsOtherThanSalaries.getUniqueTDSCerNo());
			childDoc.setTotal_TaxDeductor(amt);
			tdsFromothersDocument.add(childDoc);
			try {
				wpm.update(tdsFromothersDocument);
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}


	/**
	 * This method is used to find child of {@link SelfAssesmetTaxDocument} by their uuid.
	 * 
	 * @param parentBean {@link HippoBean} Bean document of {@link SelfAssesmetTaxDocument}
	 * @return {@link String} return UUID of child Doc to update.
	 * 
	 * */
	public static String finduuidofChildnodefrself(HippoBean parentBean){
		log.info("inside finding child");
		SelfAssesmetTaxDocument siDocument = (SelfAssesmetTaxDocument) parentBean;
		if(!siDocument.getSelfAssesmentDetailList().isEmpty()){
			for(SelfAssesmentTaxDetail siDetail:siDocument.getSelfAssesmentDetailList()){
				log.info("very near to child id for selfases");
				return siDetail.getCanonicalUUID();
			}
		}

		return null;
	}
	/**
	 * This method is used to find child of {@link TdsFromothersDocument} by their uuid.
	 * 
	 * @param parentBean {@link HippoBean} Bean document of {@link TdsFromothersDocument}
	 * @return {@link String} return UUID of child Doc to update.
	 * 
	 * */
	public static String finduuidofChildnode(HippoBean parentBean){
		log.info("inside finding child");
		TdsFromothersDocument siDocument = (TdsFromothersDocument) parentBean;
		if(!siDocument.getTdsSalaryDetailList().isEmpty()){
			for(TdsOthersDetail siDetail:siDocument.getTdsSalaryDetailList()){
				log.info("very near to child id");
				return siDetail.getCanonicalUUID();
			}
		}

		return null;
	}


	public static final SimpleDateFormat getIndianDateFormatter() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}

	/**
	 * This method is used to convert date from string to calendar
	 * 
	 * @param string 
	 * @return Calendar date
	 * 
	 * */
	public GregorianCalendar ConvDateStringToCalendar(String strDate){
		Date date = null ;
		DateFormat formatter = getIndianDateFormatter();
		GregorianCalendar cal=null;
		if(StringUtils.isNotEmpty(strDate)){
			cal=(GregorianCalendar) GregorianCalendar.getInstance();
			try{ 
				date = (Date)formatter.parse(strDate);
				cal.setTime(date);
			}
			catch(Exception e){
				log.error("calendar error"+e);
			}
			return cal;
		}else return null;

	}



	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}




