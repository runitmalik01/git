package com.mootly.wcm.member;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.http.HttpServletResponse;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.DITResponseDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.DITResponseDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TcsDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.beans.events.GenericLifeCycleHandler;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.components.InvalidNavigationException;
import com.mootly.wcm.model.DITSOAPOperation;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASAdvanceTaxPayment;
import com.mootly.wcm.services.ditws.model.Twenty26ASGenericRecord;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;
import com.mootly.wcm.services.ditws.model.Twenty26ASTDSOnSalary;
import com.mootly.wcm.services.ditws.model.Twenty26ASTDSOtherThanSalary;
import com.mootly.wcm.services.ditws.model.Twenty26ASTaxPayment;

/**
 * servicerequest-itr-sync-tds-from-dit.html
 * @author admin
 *
 */
@RequiredBeans (requiredBeans={MemberPersonalInformation.class})  //this bean must be present before we do any thing
@FormFields(fieldNames={})
public class SyncTDSFromDIT extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(SyncTDSFromDIT.class);
	private static final String SUCCESS = "success";
	
	/**
	 * If the date deposited is after the financial year end then its self assessment tax
	 * If the date deposited is within the financial year its advance tax
	 */
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		/**
		 * for checking isimport flag for preventing multiple import
		 * 
		 */
		//Twenty26ASTCS twenty26ASTCS = new Twenty26ASTCS();
		// String  valueImport = twenty26ASTCS.getIsImported();
		String enableImportData = getITRInitData(request).getWebSiteInfo().getEriEnable26ASImport();
		if (!getITRInitData(request).getChannelInfoWrapper().getIsEriEnabled() || enableImportData == null || enableImportData.equalsIgnoreCase("false")) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "Reseller is not authorized to run the import");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Integer totalGetTDSDetail = 0;
		DITResponseDocument ditResponseDocument = (DITResponseDocument) request.getAttribute(DITResponseDocument.class.getSimpleName().toLowerCase());
		if ( ditResponseDocument != null) {
			totalGetTDSDetail = ditResponseDocument.getTotalCountOfOperation("getTDSDetails");
		}
		request.setAttribute("totalGetTDSDetail", totalGetTDSDetail);
			
		String message = request.getParameter("success");
		if(null != message){
			request.setAttribute("message", message);
		}
		Retrieve26ASInformation retrieve26asInformation = getRetrieve26ASService();
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if (memberPersonalInformation == null) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "Reseller is not authorized to run the import");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(getITRInitData(request).getWebSiteInfo().getEriUserId(),getITRInitData(request).getWebSiteInfo().getEriPassword(),getITRInitData(request).getWebSiteInfo().getEriCertChain(),getITRInitData(request).getWebSiteInfo().getEriSignature(), memberPersonalInformation.getPAN(), memberPersonalInformation.getDOB() , getITRInitData(request).getFinancialYear().getAssessmentYearForDITSOAPCall(), null ,null);
			List<Twenty26ASTaxPayment> selfAssessmentList = new ArrayList<Twenty26ASTaxPayment>();
			List<Twenty26ASAdvanceTaxPayment> advTaxList = new ArrayList<Twenty26ASAdvanceTaxPayment>();
			splitTaxPayment(request,twenty26asResponse, selfAssessmentList, advTaxList);
			setIfIsAlreadyImported(request,twenty26asResponse,selfAssessmentList,advTaxList);
			int totalToBeImported = totalToBeImported(twenty26asResponse,selfAssessmentList,advTaxList);
			request.setAttribute("twenty26asResponse", twenty26asResponse);
			request.setAttribute("selfAssessmentList", selfAssessmentList);
			request.setAttribute("advTaxList", advTaxList);
			request.setAttribute("totalToBeImported", totalToBeImported);
		} catch (MissingInformationException e) {
			// TODO Auto-generated catch block
			log.error("Missing Information",e);
		} catch (DataMismatchException e) {
			// TODO Auto-generated catch block
			log.error("DataMismatchException",e);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			log.error("InvalidFormatException",e);
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		Session persistableSession = null;
		Retrieve26ASInformation retrieve26asInformation = getRetrieve26ASService();
		MemberPersonalInformation mpi = null;
		try {
			persistableSession=getPersistableSession(request);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("error in persistableSession",e);
			//e.printStackTrace();
		}
		WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
		
		try {
			mpi = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			if (mpi == null) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(getITRInitData(request).getWebSiteInfo().getEriUserId(),getITRInitData(request).getWebSiteInfo().getEriPassword(),getITRInitData(request).getWebSiteInfo().getEriCertChain(),getITRInitData(request).getWebSiteInfo().getEriSignature(), mpi.getPAN(), mpi.getDOB() , getITRInitData(request).getFinancialYear().getAssessmentYearForDITSOAPCall(),getITRInitData(request).getAbsoluteBasePathToReturnDocuments(),wpm);
			try {
				persistableSession=getPersistableSession(request);
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				log.error("error in persistableSession",e);
				//e.printStackTrace();
			}
			wpm = getWorkflowPersistenceManager(persistableSession);
			List<Twenty26ASTaxPayment> selfAssessmentList = new ArrayList<Twenty26ASTaxPayment>();
			List<Twenty26ASAdvanceTaxPayment> advTaxList = new ArrayList<Twenty26ASAdvanceTaxPayment>();
			splitTaxPayment(request,twenty26asResponse, selfAssessmentList, advTaxList);
			setIfIsAlreadyImported(request,twenty26asResponse,selfAssessmentList, advTaxList);
			int totalToBeImported = totalToBeImported(twenty26asResponse, selfAssessmentList, advTaxList);
			if (totalToBeImported > 0 ) {				
				//List list = Collections.synchronizedList(new ArrayList());
			
			
				if (selfAssessmentList != null && selfAssessmentList.size() > 0) {
					saveElementsToRepository(request,selfAssessmentList,SelfAssesmetTaxDocument.class,SelfAssesmentTaxDetail.class,persistableSession,wpm);
				}
				if (advTaxList != null && advTaxList.size() > 0) {
					saveElementsToRepository(request,advTaxList,AdvanceTaxDocument.class,AdvanceTaxDetail.class,persistableSession,wpm);
				}
				
				//lets set the category of form 16
				if (twenty26asResponse != null && twenty26asResponse.getTwenty26astdsOnSalaries() != null && twenty26asResponse.getTwenty26astdsOnSalaries().size() > 0 ) {
					for (Twenty26ASTDSOnSalary twenty26ASTDSOnSalary : twenty26asResponse.getTwenty26astdsOnSalaries()) {
						twenty26ASTDSOnSalary.setEmpCategory(mpi.getEmploye_category());
						twenty26ASTDSOnSalary.setPan_employee(mpi.getPAN());
						twenty26ASTDSOnSalary.setEmployee(mpi.getName());
						
						twenty26ASTDSOnSalary.setBalance(twenty26ASTDSOnSalary.getIncChrgSal());
						twenty26ASTDSOnSalary.setIncome_chargable_total(twenty26ASTDSOnSalary.getIncChrgSal());
						twenty26ASTDSOnSalary.setGross_total(twenty26ASTDSOnSalary.getIncChrgSal());
					}
				}
				
				saveElementsToRepository(request,twenty26asResponse.getTwenty26astdsOtherThanSalaries(),TdsFromothersDocument.class,TdsOthersDetail.class,persistableSession,wpm);
				saveElementsToRepository(request,twenty26asResponse.getTwenty26astdsOnSalaries(),FormSixteenDocument.class,FormSixteenDetail.class,persistableSession,wpm);
				saveElementsToRepository(request,twenty26asResponse.getTwenty26astcs(),TcsDocument.class,TcsDetail.class,persistableSession,wpm);
	
				//now save an import document
				FormMap theMapForSOAPResponse = new FormMap();
				
				FormField theSOAPOperation = new FormField("soapOperation");
				theSOAPOperation.addValue(DITSOAPOperation.getTDSDetails.name());
				theMapForSOAPResponse.addFormField(theSOAPOperation);
				
				BeanLifecycle<HippoBean> childBeanLifeCycleHandler = null;
				BeanLifecycle<HippoBean> parentBeanLifeCycleHandler = null;
				String parentBeanAbsolutePath = getITRInitData(request).getAbsoluteBasePathToReturnDocuments() + "/" + DITResponseDocument.class.getSimpleName().toLowerCase();
				String parentBeanNameSpace = "mootlywcm:ditResponseDocument";
				String parentBeanNodeName = DITResponseDocument.class.getSimpleName().toLowerCase();
				getItReturnComponentHelper().saveAddNewChild(theMapForSOAPResponse, null, null, null, getITRInitData(request).getAbsoluteBasePathToReturnDocuments(), parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, DITResponseDocumentDetail.class, wpm.getSession(), wpm);
				
				response.setRenderParameter("success", "success");
			}

		} catch (InvalidNavigationException e) {
			// TODO Auto-generated catch block
			log.error("Error while create base path to get document",e);
		} catch (MissingInformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error while create base path to get document",e);
		} catch (DataMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error while create base path to get document",e);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error while create base path to get document",e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error while create base path to get document",e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error while create base path to get document",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error while create base path to get document",e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error while create base path to get document",e);
		}
	}

	protected void saveElementsToRepository(HstRequest request, List<? extends Object> listOfObjects,Class<? extends HippoBean> parentBeanClass,Class<? extends HippoBean> childBeanClass,Session persistableSession, WorkflowPersistenceManager wpm) throws InvalidNavigationException, InstantiationException, IllegalAccessException, ObjectBeanManagerException {
		ITReturnComponentHelper itReturnComponentHelper = getITReturnComponentHelper();
		FormMapHelper formMapHelper = new FormMapHelper();
		ParentBeanLifeCycleHandler parentBeanLifeCycleHandler = new ParentBeanLifeCycleHandler();
		ChildBeanLifeCycleHandler childBeanLifeCycleHandler = new ChildBeanLifeCycleHandler();
		if (listOfObjects != null && listOfObjects.size() > 0) {
			for (Object anObject:listOfObjects) {
				if (anObject instanceof Twenty26ASGenericRecord) {
					Twenty26ASGenericRecord genericRecord = (Twenty26ASGenericRecord) anObject;
					if (genericRecord.getHasAlreadyBeenImported() != null && genericRecord.getHasAlreadyBeenImported()) {
						if (log.isInfoEnabled()) {
							log.info("Record already been imported, Skipping..");
						}
						continue;
					}
				}
				String baseAbsolutePathToReturnDocuments = getITRInitData(request).getAbsoluteBasePathToReturnDocuments();
				String parentBeanNodeName = itReturnComponentHelper.getParentBeanNodeName(parentBeanClass);
				String parentBeanNameSpace = itReturnComponentHelper.getParentBeanNamespace(parentBeanClass);
				String parentBeanAbsolutePath = itReturnComponentHelper.getParentBeanAbsolutePath(baseAbsolutePathToReturnDocuments, parentBeanNodeName);
				//Class<? extends HippoBean> childBeanClass = SelfAssesmentTaxDetail.class;
				FormMap formMap = formMapHelper.convertToFormMap(anObject);
				itReturnComponentHelper.saveAddNewChild(formMap,null, childBeanLifeCycleHandler, parentBeanLifeCycleHandler, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, childBeanClass, persistableSession, wpm);
			}
		}
	}

	class ParentBeanLifeCycleHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean> {

		
	}

	class ChildBeanLifeCycleHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean> {


	}
	
	/**
	 * Split the payments into advanced or self assessment based on date of deposit
	 * List<Twenty26ASTaxPayment> selfAssessmentList = new ArrayList<Twenty26ASTaxPayment>();
			List<Twenty26ASAdvanceTaxPayment> advTaxList = new ArrayList<Twenty26ASAdvanceTaxPayment>();
	 */
	protected void splitTaxPayment(HstRequest request, Twenty26ASResponse twenty26asResponse,List<Twenty26ASTaxPayment> selfAssessmentList,List<Twenty26ASAdvanceTaxPayment> advTaxList) {
		if (twenty26asResponse != null && twenty26asResponse.getTwenty26asTaxPayments() != null && twenty26asResponse.getTwenty26asTaxPayments().size() > 0 ) {
			for (Twenty26ASTaxPayment twenty26ASTaxPayment : twenty26asResponse.getTwenty26asTaxPayments()){
				String strDate = twenty26ASTaxPayment.getDateDep();
				Date date = null ;
				DateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd"); 
				GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
				try{
					date = (Date)formatter.parse(strDate);
					cal.setTime(date);
					String newFormattedDateStr = IndianGregorianCalendar.formatDateAsString(cal,IndianGregorianCalendar.indianLocalDateFormStr2);
					if ( cal.after( getITRInitData(request).getFinancialYear().getDateEndFinancialYear()) ) {
						twenty26ASTaxPayment.setDateDep(newFormattedDateStr);
						selfAssessmentList.add(twenty26ASTaxPayment);							
					}
					else {
						Twenty26ASAdvanceTaxPayment twenty26asAdvanceTaxPayment = new Twenty26ASAdvanceTaxPayment(twenty26ASTaxPayment.getAmt(),twenty26ASTaxPayment.getSrlNoOfChaln(),twenty26ASTaxPayment.getBSRCode(),twenty26ASTaxPayment.getDateDep());
						twenty26asAdvanceTaxPayment.setDateDep(newFormattedDateStr);
						advTaxList.add(twenty26asAdvanceTaxPayment);
					}
				}
				catch(Exception e){
					log.info("calendar error"+e);
				}
			}
		}
	}
	
	protected void setIfIsAlreadyImported(HstRequest request,Twenty26ASResponse twenty26asResponse,List<Twenty26ASTaxPayment> selfAssessmentList,List<Twenty26ASAdvanceTaxPayment> advTaxList) {
		int totalForImport = 0;
		//FORM 16
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());		
		if (formSixteenDocument != null && formSixteenDocument.getFormSixteenDetailList() != null) {
			for (FormSixteenDetail formSixteenDetail:formSixteenDocument.getFormSixteenDetailList()) {
				if (!formSixteenDetail.isImportedFromDIT() || formSixteenDetail.getEmploye_category() == null || formSixteenDetail.getGross_a() == null || formSixteenDetail.getDed_ent_1() == null) continue;
				for (Twenty26ASTDSOnSalary twenty26astdsOnSalary:twenty26asResponse.getTwenty26astdsOnSalaries()) {
					if (Double.valueOf(twenty26astdsOnSalary.getIncChrgSal()).equals(formSixteenDetail.getGross_a()) && Double.valueOf(twenty26astdsOnSalary.getTotalTDSSal()).equals(formSixteenDetail.getDed_ent_1()) ) {
						twenty26astdsOnSalary.setHasAlreadyBeenImported(true);
						break;
					}
				}
			}
		}		
		
		//TDS from Others
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) request.getAttribute(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		if (tdsFromothersDocument != null && tdsFromothersDocument.getTdsSalaryDetailList() != null) {
			for (TdsOthersDetail tdsOthersDetail:tdsFromothersDocument.getTdsSalaryDetailList()) {
				if (!tdsOthersDetail.isImportedFromDIT() || tdsOthersDetail.getTan_Deductor() == null || tdsOthersDetail.getP_Amount() == null) continue;
				for (Twenty26ASTDSOtherThanSalary twenty26astdsOtherThanSalary:twenty26asResponse.getTwenty26astdsOtherThanSalaries()) {
					if (twenty26astdsOtherThanSalary.getTAN().equals(tdsOthersDetail.getTan_Deductor()) && Double.valueOf(twenty26astdsOtherThanSalary.getTotTDSOnAmtPaid()).equals(tdsOthersDetail.getP_Amount()) ) {
						twenty26astdsOtherThanSalary.setHasAlreadyBeenImported(true);
						break;
					}
				}
			}
		}	
		// END //TDS from Others
		
		//Now for Advance Tax and Self Assessment Tax
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) request.getAttribute(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());		
		if (selfAssesmetTaxDocument != null && selfAssesmetTaxDocument.getSelfAssesmentDetailList() != null) {
			for (SelfAssesmentTaxDetail selfAssesmentTaxDetail:selfAssesmetTaxDocument.getSelfAssesmentDetailList()) {
				if (selfAssesmentTaxDetail.isImportedFromDIT() == null && !selfAssesmentTaxDetail.isImportedFromDIT() || selfAssesmentTaxDetail.getP_Amount() == null || selfAssesmentTaxDetail.getP_Date() == null) continue;
				for (Twenty26ASTaxPayment selfAssessmentPayment: selfAssessmentList) {
					//check if this is after the financial year thenits self ass before its adv		
					String strDateToCompare = IndianGregorianCalendar.formatDateAsString(selfAssesmentTaxDetail.getP_Date(), IndianGregorianCalendar.indianLocalDateFormStr2);
					if ( Double.valueOf(selfAssessmentPayment.getAmt()).equals(selfAssesmentTaxDetail.getP_Amount()) && selfAssessmentPayment.getDateDep().equals(strDateToCompare) ) {
						selfAssessmentPayment.setHasAlreadyBeenImported(true);
						break;
					}
				}	
			}
		}
		
		
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) request.getAttribute(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		if (advanceTaxDocument != null && advanceTaxDocument.getAdvanceTaxDetailList() != null) {
			for (AdvanceTaxDetail advanceTaxDetail:advanceTaxDocument.getAdvanceTaxDetailList()) {
				if (advanceTaxDetail.isImportedFromDIT() == null && !advanceTaxDetail.isImportedFromDIT() || advanceTaxDetail.getP_Amount() == null || advanceTaxDetail.getP_Date() == null) continue;
				for (Twenty26ASAdvanceTaxPayment advanceTaxPayment : advTaxList) {
					//check if this is after the financial year thenits self ass before its adv		
					String strDateToCompare = IndianGregorianCalendar.formatDateAsString(advanceTaxDetail.getP_Date(), IndianGregorianCalendar.indianLocalDateFormStr2);
					if ( Double.valueOf(advanceTaxPayment.getAmt()).equals(advanceTaxDetail.getP_Amount()) && advanceTaxPayment.getDateDep().equals(strDateToCompare) ) {
						advanceTaxPayment.setHasAlreadyBeenImported(true);
						break;
					}
				}	
			}
		}		
	}
	
	protected int totalToBeImported(Twenty26ASResponse twenty26asResponse,List<Twenty26ASTaxPayment> selfAssessmentList,List<Twenty26ASAdvanceTaxPayment> advTaxList) {
		int totalToBeImported = 0 ;
		if (twenty26asResponse == null) return 0;
		
		for (Twenty26ASGenericRecord tGenericRecord:twenty26asResponse.getTwenty26astdsOnSalaries()) {
			if (!tGenericRecord.getHasAlreadyBeenImported()) totalToBeImported++;
		}
		
		for (Twenty26ASGenericRecord tGenericRecord:twenty26asResponse.getTwenty26astdsOtherThanSalaries()) {
			if (!tGenericRecord.getHasAlreadyBeenImported()) totalToBeImported++;
		}
		
		for (Twenty26ASGenericRecord tGenericRecord: selfAssessmentList) {
			if (!tGenericRecord.getHasAlreadyBeenImported()) totalToBeImported++;
		}
		
		for (Twenty26ASGenericRecord tGenericRecord : advTaxList) {
			if (!tGenericRecord.getHasAlreadyBeenImported()) totalToBeImported++;
		}
		
		return totalToBeImported;
	}
}




