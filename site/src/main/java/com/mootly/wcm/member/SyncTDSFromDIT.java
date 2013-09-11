package com.mootly.wcm.member;


import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TcsDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.components.InvalidNavigationException;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;

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
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(mpi.getPAN(), mpi.getDOB() , getFinancialYear().getAssessmentYearForDITSOAPCall());
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
			
			saveElementsToRepository(twenty26asResponse.getTwenty26asTaxPayments(),SelfAssesmetTaxDocument.class,SelfAssesmentTaxDetail.class,persistableSession,wpm);
			saveElementsToRepository(twenty26asResponse.getTwenty26astdsOtherThanSalaries(),TdsFromothersDocument.class,TdsOthersDetail.class,persistableSession,wpm);
			saveElementsToRepository(twenty26asResponse.getTwenty26astdsOnSalaries(),FormSixteenDocument.class,FormSixteenDetail.class,persistableSession,wpm);
			saveElementsToRepository(twenty26asResponse.getTwenty26astcs(),TcsDocument.class,TcsDetail.class,persistableSession,wpm);

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

	class ParentBeanLifeCycleHandler implements BeanLifecycle<HippoBean> {

		@Override
		public void beforeCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean beforeSaveNewBean(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterSaveNewBean(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean beforeUpdate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterUpdate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class ChildBeanLifeCycleHandler implements BeanLifecycle<HippoBean> {

		@Override
		public void beforeCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean beforeSaveNewBean(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterSaveNewBean(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean beforeUpdate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterUpdate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
}




