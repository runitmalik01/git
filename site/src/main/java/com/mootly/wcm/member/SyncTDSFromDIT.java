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
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.DITResponseDocumentDetail.DITSOAPOperation;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TcsDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.beans.events.GenericLifeCycleHandler;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.components.InvalidNavigationException;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;
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
		String enableImportData = getWebSiteInfo().getEriEnable26ASImport();
		if (!getChannelInfoWrapper().getIsEriEnabled() || enableImportData == null || enableImportData.equalsIgnoreCase("false")) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "Reseller is not authorized to run the import");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Integer totalGetTDSDetail = 0;
		if ( getDITResponseDocument() != null) {
			totalGetTDSDetail = getDITResponseDocument().getTotalCountOfOperation(DITSOAPOperation.getTDSDetails);
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
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(getWebSiteInfo().getEriUserId(),getWebSiteInfo().getEriPassword(),getWebSiteInfo().getEriCertChain(),getWebSiteInfo().getEriSignature(), memberPersonalInformation.getPAN(), memberPersonalInformation.getDOB() , getFinancialYear().getAssessmentYearForDITSOAPCall());
			request.setAttribute("twenty26asResponse", twenty26asResponse);

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
		try {
			MemberPersonalInformation mpi = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(getWebSiteInfo().getEriUserId(),getWebSiteInfo().getEriPassword(),getWebSiteInfo().getEriCertChain(),getWebSiteInfo().getEriSignature(), mpi.getPAN(), mpi.getDOB() , getFinancialYear().getAssessmentYearForDITSOAPCall());
			request.setAttribute("twenty26asResponse", twenty26asResponse);
			//List list = Collections.synchronizedList(new ArrayList());
			try {
				persistableSession=getPersistableSession(request);
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				log.error("error in persistableSession",e);
				//e.printStackTrace();
			}
			WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
			
			/**
			 * If the date deposited is after the financial year end then its self assessment tax
			 * If the date deposited is within the financial year its advance tax
			 */
			List<Twenty26ASTaxPayment> selfAssessmentList = new ArrayList<Twenty26ASTaxPayment>();
			List<Twenty26ASTaxPayment> advTaxList = new ArrayList<Twenty26ASTaxPayment>();
			if (twenty26asResponse != null && twenty26asResponse.getTwenty26asTaxPayments() != null && twenty26asResponse.getTwenty26asTaxPayments().size() > 0 ) {
				for (Twenty26ASTaxPayment twenty26ASTaxPayment : twenty26asResponse.getTwenty26asTaxPayments()){
					String strDate = twenty26ASTaxPayment.getDateDep();
					Date date = null ;
					DateFormat formatter =  new SimpleDateFormat("dd/MM/yyyy"); 
					GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
					try{
						date = (Date)formatter.parse(strDate);
						cal.setTime(date);
						if ( cal.after(getFinancialYear().getDateEndFinancialYear()) ) {
							selfAssessmentList.add(twenty26ASTaxPayment);
						}
						else {
							advTaxList.add(twenty26ASTaxPayment);
						}
					}
					catch(Exception e){
						log.info("calendar error"+e);
					}
				}
			}
			if (selfAssessmentList != null && selfAssessmentList.size() > 0) {
				saveElementsToRepository(selfAssessmentList,SelfAssesmetTaxDocument.class,SelfAssesmentTaxDetail.class,persistableSession,wpm);
			}
			if (advTaxList != null && advTaxList.size() > 0) {
				saveElementsToRepository(advTaxList,AdvanceTaxDocument.class,AdvanceTaxDetail.class,persistableSession,wpm);
			}
			
			saveElementsToRepository(twenty26asResponse.getTwenty26astdsOtherThanSalaries(),TdsFromothersDocument.class,TdsOthersDetail.class,persistableSession,wpm);
			saveElementsToRepository(twenty26asResponse.getTwenty26astdsOnSalaries(),FormSixteenDocument.class,FormSixteenDetail.class,persistableSession,wpm);
			saveElementsToRepository(twenty26asResponse.getTwenty26astcs(),TcsDocument.class,TcsDetail.class,persistableSession,wpm);

			response.setRenderParameter("success", "success");

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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void saveElementsToRepository(List<? extends Object> listOfObjects,Class<? extends HippoBean> parentBeanClass,Class<? extends HippoBean> childBeanClass,Session persistableSession, WorkflowPersistenceManager wpm) throws InvalidNavigationException, InstantiationException, IllegalAccessException, ObjectBeanManagerException {
		ITReturnComponentHelper itReturnComponentHelper = getITReturnComponentHelper();
		FormMapHelper formMapHelper = new FormMapHelper();
		ParentBeanLifeCycleHandler parentBeanLifeCycleHandler = new ParentBeanLifeCycleHandler();
		ChildBeanLifeCycleHandler childBeanLifeCycleHandler = new ChildBeanLifeCycleHandler();
		if (listOfObjects != null && listOfObjects.size() > 0) {
			for (Object anObject:listOfObjects) {
				String baseAbsolutePathToReturnDocuments = getAbsoluteBasePathToReturnDocuments();
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


}




