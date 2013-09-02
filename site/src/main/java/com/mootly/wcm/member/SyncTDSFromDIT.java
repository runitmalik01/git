package com.mootly.wcm.member;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
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
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.components.InvalidNavigationException;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;
import com.mootly.wcm.services.ditws.model.Twenty26ASTDSOnSalary;
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
			MemberPersonalInformation mpi = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(mpi.getPAN(), mpi.getDOB() , getFinancialYear().getAssessmentYearForDITSOAPCall());
			request.setAttribute("twenty26asResponse", twenty26asResponse);
			//List list = Collections.synchronizedList(new ArrayList());
			try {
				persistableSession=getPersistableSession(request);
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
			
			saveElementsToRepository(twenty26asResponse.getTwenty26asTaxPayments(),SelfAssesmetTaxDocument.class,SelfAssesmentTaxDetail.class,persistableSession,wpm);
			saveElementsToRepository(twenty26asResponse.getTwenty26astdsOtherThanSalaries(),TdsFromothersDocument.class,TdsOthersDetail.class,persistableSession,wpm);
			saveElementsToRepository(twenty26asResponse.getTwenty26astdsOnSalaries(),FormSixteenDocument.class,FormSixteenDetail.class,persistableSession,wpm);
			//List<Twenty26ASTDSOtherThanSalary> listTDSOtherThanSalary = 
			/*
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			//String pathSelfAssesment = getAbsoluteBasePathToReturnDocuments()+"/"+SelfAssesmentTaxDocument.class.getSimpleName().toLowerCase();
			String pathSelfAssesment = getAbsoluteBasePathToReturnDocuments()+"/"+SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase();
			String pathTdsfromOthers = getAbsoluteBasePathToReturnDocuments()+"/"+TdsFromothersDocument.class.getSimpleName().toLowerCase();
			String pathFormSixteen = getAbsoluteBasePathToReturnDocuments()+"/"+FormSixteenDocument.class.getSimpleName().toLowerCase();
			String pathAdvanceTax = getAbsoluteBasePathToReturnDocuments()+"/"+AdvanceTaxDocument.class.getSimpleName().toLowerCase();
			// here getting path for bean
			SelfAssesmetTaxDocument selfAssesmentTaxDocument = (SelfAssesmetTaxDocument)wpm.getObject(pathSelfAssesment);
			TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) wpm.getObject(pathTdsfromOthers);
			FormSixteenDocument formSixteenDocument = (FormSixteenDocument)wpm.getObject(pathFormSixteen);
			AdvanceTaxDocument advanceTaxDocument  = (AdvanceTaxDocument)wpm.getObject(pathAdvanceTax);
			//update or add doc for selfassess
			updateOrAddSelfAssessmentDocument(selfAssesmentTaxDocument, wpm ,twenty26asResponse);
			//update or add doc for tdsfrom others
			updateOrAddTdsOthersDocument(tdsFromothersDocument,  wpm ,twenty26asResponse);
			//for auto create form sixteen from DIT Mock Services
			updateOrAddFormSixteenDocument(formSixteenDocument, wpm ,twenty26asResponse,mpi);
			//for auto create advanecTax from DIT Mock Services
			updateOrAddAdvanceTaxDocument(advanceTaxDocument, wpm ,twenty26asResponse);
			*/
			response.setRenderParameter("Success", "Success");

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
	
	protected void saveElementsToRepository(List<? extends Object> listOfObjects,Class<? extends HippoBean> parentBeanClass,Class<? extends HippoBean> childBeanClass,Session persistableSession, WorkflowPersistenceManager wpm) throws InvalidNavigationException {
		ITReturnComponentHelper itReturnComponentHelper = getITReturnComponentHelper();
		FormMapHelper formMapHelper = new FormMapHelper();
		if (listOfObjects != null && listOfObjects.size() > 0) {
			for (Object anObject:listOfObjects) {
				String baseAbsolutePathToReturnDocuments = getAbsoluteBasePathToReturnDocuments();
				String parentBeanNodeName = itReturnComponentHelper.getParentBeanNodeName(parentBeanClass);
				String parentBeanNameSpace = itReturnComponentHelper.getParentBeanNamespace(parentBeanClass);
				String parentBeanAbsolutePath = itReturnComponentHelper.getParentBeanAbsolutePath(baseAbsolutePathToReturnDocuments, parentBeanNodeName);
				//Class<? extends HippoBean> childBeanClass = SelfAssesmentTaxDetail.class;
				FormMap formMap = formMapHelper.convertToFormMap(anObject);
				itReturnComponentHelper.saveAddNewChild(formMap,null, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, childBeanClass, persistableSession, wpm);
			}
		}
	}

	/**
	 * This method is used to update & add  {@link SelfAssesmetTaxDocument}
	 * @param parentBean {@link HippoBean} Bean document of {@link SelfAssesmetTaxDocument}
	 * @throws ObjectBeanManagerException 
	 * @throws InvalidNavigationException 
	 * 
	 * */
	public void updateOrAddSelfAssessmentDocument( SelfAssesmetTaxDocument selfAssesmentTaxDocument, WorkflowPersistenceManager wpm, Twenty26ASResponse twenty26asResponse) throws ObjectBeanManagerException, InvalidNavigationException{
		log.info("inside finding child");
		if(null==selfAssesmentTaxDocument){
			if(log.isInfoEnabled()){
				log.warn("we have no doc");
			}
			String createdDocPath = wpm.createAndReturn(getAbsoluteBasePathToReturnDocuments(), SelfAssesmetTaxDocument.NAMESPACE, SelfAssesmetTaxDocument.NODE_NAME, true);
			selfAssesmentTaxDocument = (SelfAssesmetTaxDocument) wpm.getObject(createdDocPath);
		}
		//Twenty26ASTaxPayment item = twenty26asResponse.getTwenty26asTaxPayments().get(getTotalChildren()); no use
		ArrayList<Twenty26ASTaxPayment> abc = (ArrayList<Twenty26ASTaxPayment>) twenty26asResponse.getTwenty26asTaxPayments();
		String sectionChildUUIDforself = finduuidofChildnodefrself(selfAssesmentTaxDocument);
		if(StringUtils.isNotBlank(sectionChildUUIDforself)){
			for(Twenty26ASTaxPayment twenty26ASTaxPayment:abc){
				SelfAssesmentTaxDetail siDetailUp = new SelfAssesmentTaxDetail() ;
				siDetailUp.setP_BSR(twenty26ASTaxPayment.getBSRCode());
				siDetailUp.setP_Serial(twenty26ASTaxPayment.getSrlNoOfChaln());
				double amt = Double.parseDouble(twenty26ASTaxPayment.getAmt());
				siDetailUp.setP_Amount(amt);
				String date = twenty26ASTaxPayment.getDateDep();
				GregorianCalendar newDate= ConvDateStringToCalendar(date);
				siDetailUp.setP_Date(newDate);
				siDetailUp.setIsImported(true);
				selfAssesmentTaxDocument.add(siDetailUp);
			}
			try {
				wpm.update(selfAssesmentTaxDocument);
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			for(Twenty26ASTaxPayment twenty26ASTaxPayment:abc){
				SelfAssesmentTaxDetail siDetailUp= new SelfAssesmentTaxDetail();
				siDetailUp.setP_BSR(twenty26ASTaxPayment.getBSRCode());
				siDetailUp.setP_Serial(twenty26ASTaxPayment.getSrlNoOfChaln());
				double amt = Double.parseDouble(twenty26ASTaxPayment.getAmt());
				siDetailUp.setP_Amount(amt);
				String date = twenty26ASTaxPayment.getDateDep();
				GregorianCalendar newDate= ConvDateStringToCalendar(date);
				siDetailUp.setP_Date(newDate);
				siDetailUp.setIsImported(true);
				selfAssesmentTaxDocument.add(siDetailUp);
			}
			try {
				wpm.update(selfAssesmentTaxDocument);
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
	public void updateOrAddTdsOthersDocument( TdsFromothersDocument tdsFromothersDocument, WorkflowPersistenceManager wpm, Twenty26ASResponse twenty26asResponse) throws ObjectBeanManagerException, InvalidNavigationException{
		if(null == tdsFromothersDocument){
			log.info("we have no doc1");
			String createdDocPath = wpm.createAndReturn(getAbsoluteBasePathToReturnDocuments(), TdsFromothersDocument.NAMESPACE, TdsFromothersDocument.NODE_NAME, true);
			tdsFromothersDocument = (TdsFromothersDocument) wpm.getObject(createdDocPath);
		} 
		//Twenty26ASTDSOtherThanSalary listTwenty26astdsOtherThanSalaries = twenty26asResponse.getTwenty26astdsOtherThanSalaries().get(getTotalChildren());
		ArrayList<Twenty26ASTDSOtherThanSalary> abc = (ArrayList<Twenty26ASTDSOtherThanSalary>) twenty26asResponse.getTwenty26astdsOtherThanSalaries();
		String sectionChildUUID = finduuidofChildnode(tdsFromothersDocument);
		if(StringUtils.isNotBlank(sectionChildUUID)){
			log.info("object is"+sectionChildUUID);
			for( Twenty26ASTDSOtherThanSalary twenty26ASTDSOtherThanSalary : abc){

				//TdsOthersDetail tdsOthersDetail = (TdsOthersDetail) wpm.getObjectByUuid(sectionChildUUID); in case of updation on same node
				TdsOthersDetail tdsOthersDetail = new TdsOthersDetail();
				tdsOthersDetail.setFinancial_Year(twenty26ASTDSOtherThanSalary.getDeductedYr());
				double amt = Double.parseDouble(twenty26ASTDSOtherThanSalary.getClaimOutOfTotTDSOnAmtPaid());
				tdsOthersDetail.setP_Amount(amt);
				tdsOthersDetail.setName_Deductor(twenty26ASTDSOtherThanSalary.getEmployerOrDeductorOrCollecterName());
				tdsOthersDetail.setTan_Deductor(twenty26ASTDSOtherThanSalary.getTAN());
				tdsOthersDetail.setTds_Certificate(twenty26ASTDSOtherThanSalary.getUniqueTDSCerNo());
				tdsOthersDetail.setTotal_TaxDeductor(amt);
				tdsFromothersDocument.add(tdsOthersDetail);
			}
			wpm.update(tdsFromothersDocument);
		}else{
			for( Twenty26ASTDSOtherThanSalary twenty26ASTDSOtherThanSalary : abc){
				log.info("size of"+twenty26ASTDSOtherThanSalary);
				TdsOthersDetail childDoc = new TdsOthersDetail();
				childDoc.setFinancial_Year(twenty26ASTDSOtherThanSalary.getDeductedYr());
				double amt = Double.parseDouble(twenty26ASTDSOtherThanSalary.getClaimOutOfTotTDSOnAmtPaid());
				childDoc.setName_Deductor(twenty26ASTDSOtherThanSalary.getEmployerOrDeductorOrCollecterName());
				childDoc.setP_Amount(amt);
				childDoc.setTan_Deductor(twenty26ASTDSOtherThanSalary.getTAN());
				childDoc.setTds_Certificate(twenty26ASTDSOtherThanSalary.getUniqueTDSCerNo());
				childDoc.setTotal_TaxDeductor(amt);
				tdsFromothersDocument.add(childDoc);
			}
			try {
				wpm.update(tdsFromothersDocument);
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}


	/**
	 * This method is used to update & add  {@link FormSixteenDocument}
	 * @param parentBean {@link HippoBean} Bean document of {@link FormSixteenDocument}
	 * @throws ObjectBeanManagerException 
	 * @throws InvalidNavigationException 
	 * 
	 * */
	public void updateOrAddFormSixteenDocument( FormSixteenDocument formSixteenDocument, WorkflowPersistenceManager wpm,
			Twenty26ASResponse twenty26asResponse, MemberPersonalInformation mpi)
					throws ObjectBeanManagerException, InvalidNavigationException{
		if(null == formSixteenDocument){
			log.info("we have no doc1");
			String createdDocPath = wpm.createAndReturn(getAbsoluteBasePathToReturnDocuments(), FormSixteenDocument.NAMESPACE, FormSixteenDocument.NODE_NAME, true);
			formSixteenDocument = (FormSixteenDocument) wpm.getObject(createdDocPath);
		} 
		String sectionChildUUID = finduuidofChildnodetds(formSixteenDocument);
		ArrayList<Twenty26ASTDSOnSalary> abc = (ArrayList<Twenty26ASTDSOnSalary>) twenty26asResponse.getTwenty26astdsOnSalaries();
		if(StringUtils.isNotBlank(sectionChildUUID)){
			log.info("object is"+sectionChildUUID);
			for( Twenty26ASTDSOnSalary twenty26ASTDSOnSalary : abc){

				//TdsOthersDetail tdsOthersDetail = (TdsOthersDetail) wpm.getObjectByUuid(sectionChildUUID); in case of updation on same node
				FormSixteenDetail formSixteenDetail = new FormSixteenDetail();
				formSixteenDetail.setTan_deductor(twenty26ASTDSOnSalary.getTAN());
				double amt = Double.parseDouble(twenty26ASTDSOnSalary.getTotalTDSSal());
				formSixteenDetail.setDed_ent1(amt);
				formSixteenDetail.setEmployee(mpi.getName());
				formSixteenDetail.setEmployer(twenty26ASTDSOnSalary.getEmployerOrDeductorOrCollecterName());
				formSixteenDocument.add(formSixteenDetail);
			}
			wpm.update(formSixteenDocument);
		}else{

			for(  Twenty26ASTDSOnSalary twenty26ASTDSOnSalary : abc)
			{
				FormSixteenDetail formSixteenDetail = new FormSixteenDetail();
				formSixteenDetail.setTan_deductor(twenty26ASTDSOnSalary.getTAN());
				formSixteenDetail.setEmployer(twenty26ASTDSOnSalary.getEmployerOrDeductorOrCollecterName());
				double amt = Double.parseDouble(twenty26ASTDSOnSalary.getTotalTDSSal());
				formSixteenDetail.setDed_ent1(amt);

				formSixteenDocument.add(formSixteenDetail);
			}
			try {
				wpm.update(formSixteenDocument);
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}

	/**
	 * This method is used to update & add  {@link AdvancetaxDocument}
	 * @param parentBean {@link HippoBean} Bean document of {@link AdvancetaxDocument}
	 * @throws ObjectBeanManagerException 
	 * @throws InvalidNavigationException 
	 * 
	 * */
	public void updateOrAddAdvanceTaxDocument( AdvanceTaxDocument advanceTaxDocument, WorkflowPersistenceManager wpm, Twenty26ASResponse twenty26asResponse) throws ObjectBeanManagerException, InvalidNavigationException{
		log.info("inside finding child");
		if(null == advanceTaxDocument){
			log.info("we have no doc1");
			String createdDocPath = wpm.createAndReturn(getAbsoluteBasePathToReturnDocuments(), AdvanceTaxDocument.NAMESPACE, AdvanceTaxDocument.NODE_NAME, true);
			advanceTaxDocument = (AdvanceTaxDocument) wpm.getObject(createdDocPath);
		} 
		String sectionChildUUID = finduuidofChildnodeAdvanceTax(advanceTaxDocument);
		ArrayList<Twenty26ASTaxPayment> abc = (ArrayList<Twenty26ASTaxPayment>) twenty26asResponse.getTwenty26asTaxPayments();
		if(StringUtils.isNotBlank(sectionChildUUID)){
			log.info("object is"+sectionChildUUID);
			for( Twenty26ASTaxPayment twenty26ASTaxPayment : abc){

				//TdsOthersDetail tdsOthersDetail = (TdsOthersDetail) wpm.getObjectByUuid(sectionChildUUID); in case of updation on same node
				AdvanceTaxDetail advanceTaxDetail = new AdvanceTaxDetail();
				advanceTaxDetail.setP_BSR(twenty26ASTaxPayment.getBSRCode());
				double amt = Double.parseDouble(twenty26ASTaxPayment.getAmt());
				advanceTaxDetail.setP_Amount(amt);
				String date = twenty26ASTaxPayment.getDateDep();
				GregorianCalendar newDate= ConvDateStringToCalendar(date);
				advanceTaxDetail.setP_Date(newDate);
				advanceTaxDetail.setP_Serial(twenty26ASTaxPayment.getSrlNoOfChaln());
				advanceTaxDocument.add(advanceTaxDetail);
			}
			wpm.update(advanceTaxDocument);
		}else{

			for( Twenty26ASTaxPayment twenty26ASTaxPayment : abc){

				//TdsOthersDetail tdsOthersDetail = (TdsOthersDetail) wpm.getObjectByUuid(sectionChildUUID); in case of updation on same node
				AdvanceTaxDetail advanceTaxDetail = new AdvanceTaxDetail();
				advanceTaxDetail.setP_BSR(twenty26ASTaxPayment.getBSRCode());
				double amt = Double.parseDouble(twenty26ASTaxPayment.getAmt());
				advanceTaxDetail.setP_Amount(amt);
				String date = twenty26ASTaxPayment.getDateDep();
				GregorianCalendar newDate= ConvDateStringToCalendar(date);
				advanceTaxDetail.setP_Date(newDate);
				advanceTaxDetail.setP_Serial(twenty26ASTaxPayment.getSrlNoOfChaln());
				advanceTaxDocument.add(advanceTaxDetail);
			}
			try {
				wpm.update(advanceTaxDocument);
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
	/**
	 * This method is used to find child of {@link TdsFromothersDocument} by their uuid.
	 * 
	 * @param parentBean {@link HippoBean} Bean document of {@link TdsFromothersDocument}
	 * @return {@link String} return UUID of child Doc to update.
	 * 
	 * */
	public static String finduuidofChildnodetds(HippoBean parentBean){
		log.info("inside finding child");
		FormSixteenDocument siDocument = (FormSixteenDocument) parentBean;
		if(!siDocument.getFormSixteenDetailList().isEmpty()){
			for(FormSixteenDetail siDetail:siDocument.getFormSixteenDetailList()){
				log.info("very near to child id");
				return siDetail.getCanonicalUUID();
			}
		}

		return null;
	}
	/**
	 * This method is used to find child of {@link advanceatxdocument} by their uuid.
	 * 
	 * @param parentBean {@link HippoBean} Bean document of {@link advanceatxdocument}
	 * @return {@link String} return UUID of child Doc to update.
	 * 
	 * */
	public static String finduuidofChildnodeAdvanceTax(HippoBean parentBean){
		log.info("inside finding child");
		AdvanceTaxDocument siDocument = (AdvanceTaxDocument) parentBean;
		if(!siDocument.getAdvanceTaxDetailList().isEmpty()){
			for(AdvanceTaxDetail siDetail:siDocument.getAdvanceTaxDetailList()){
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




