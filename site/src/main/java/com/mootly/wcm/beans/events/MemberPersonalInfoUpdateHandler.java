package com.mootly.wcm.beans.events;

import java.util.List;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.DITResponseDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.CostModel;
import com.mootly.wcm.beans.compound.DITResponseDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TcsDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.channels.ChannelInfoWrapper;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.model.DITSOAPOperation;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.ITRServiceDelivery;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.ditws.AddClientDetails;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;

public class MemberPersonalInfoUpdateHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean>{
	Logger logger = LoggerFactory.getLogger(MemberPersonalInfoUpdateHandler.class);
	final List<HippoDocumentBean> itrServices;
	final ChannelInfoWrapper channelInfoWrapper;
	final SequenceGenerator sequenceGenerator;
	final AddClientDetails addClientDetails;
	final Retrieve26ASInformation retrieve26asInformation;
	final FinancialYear financialYear;
	
	String serviceName;
	String serviceQty;
	String serviceRate;
	String filingMode;
	
	
	
	public MemberPersonalInfoUpdateHandler( SequenceGenerator sequenceGenerator,List<HippoDocumentBean> itrServices,ChannelInfoWrapper channelInfoWrapper, AddClientDetails addClientDetails, Retrieve26ASInformation retrieve26asInformation,FinancialYear financialYear) {
		this.sequenceGenerator = sequenceGenerator;
		this.itrServices = itrServices;
		this.channelInfoWrapper = channelInfoWrapper;
		this.addClientDetails = addClientDetails;
		this.retrieve26asInformation = retrieve26asInformation;
		this.financialYear = financialYear;
	}
	
	@Override
	public boolean validateParentBean(HippoBean hippoBean, boolean isNew,
			List<String> errors, List<String> warnings) {
		// TODO Auto-generated method stub
		
		return true;
	}
	/**
	 * 
	 * Every time MEmber Personal Information is updated we want to add/update the invoice
	 * For legacy payment populate the payment section also 
	 */
	@Override
	public void afterUpdate(HippoBean beanBeforeUpdate,
			HippoBean beanAfterUpdate, WorkflowPersistenceManager wpm,String baseAbsolutePathToReturnDocuments,ITReturnComponentHelper itReturnComponentHelper) {
		// TODO Auto-generated method stub
		super.afterUpdate(beanBeforeUpdate, beanAfterUpdate, wpm,baseAbsolutePathToReturnDocuments,itReturnComponentHelper);
		try {
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) wpm.getObject(baseAbsolutePathToReturnDocuments + "/" + MemberPersonalInformation.class.getSimpleName().toLowerCase());
			if (memberPersonalInformation == null) {
				logger.warn("This is strange, we need to replicate this behavior");
				return;
			}
			//DITResponseDocument ditResponseDocument = (DITResponseDocument) wpm.getObject(baseAbsolutePathToReturnDocuments + "/" + DITResponseDocument.class.getSimpleName().toLowerCase());
			Service selectedService = null;
			CostModel theSelectedCostModel = null;
			ITRForm itrForm = memberPersonalInformation.getSelectedITRForm();
			ITRServiceDelivery itrServiceDelivery = memberPersonalInformation.getSelectedServiceDeliveryOption();
			for (HippoBean aBean:itrServices) {
				Service theService = (Service) aBean;
				if ( theService.getName().equalsIgnoreCase(itrForm.name())) {
					selectedService = theService;
					for (CostModel theCostModel:theService.getCostModel()) {
						if (theCostModel.getOfferingMode().equals(itrServiceDelivery.name())) {
							theSelectedCostModel = theCostModel;
							break;
						}
					}
				}
			}
 			HippoBean invoiceDocumentBean = (HippoBean) wpm.getObject(baseAbsolutePathToReturnDocuments + "/" + InvoiceDocument.class.getSimpleName().toLowerCase());
 			boolean createNew = false;
 			boolean updateExisting = false;
 			boolean didFindTheRecord = false;
 			String childBeanCanonicalUUID =  null;
 			if (invoiceDocumentBean == null) {
 				createNew = true;
 				updateExisting = false;
 			}
 			else {
 				InvoiceDocument invoiceDocument = (InvoiceDocument) invoiceDocumentBean;
				for (InvoiceDocumentDetail invoiceDocumentDetail:invoiceDocument.getInvoiceDocumentDetailList()) {
					if (invoiceDocumentDetail.getCreatedBySource() != null && MemberPersonalInformation.class.getSimpleName().toLowerCase().equals(invoiceDocumentDetail.getCreatedBySource())) {
						didFindTheRecord = true;
						if ( 	invoiceDocumentDetail.getServiceName() == null || !invoiceDocumentDetail.getServiceName().equals( selectedService.getName() ) ||
								//invoiceDocumentDetail.getServiceRate() == null || !invoiceDocumentDetail.getServiceRate().equals( theSelectedCostModel.getCost() ) ||  	
								invoiceDocumentDetail.getFilingMode() == null || !invoiceDocumentDetail.getFilingMode().equals( theSelectedCostModel.getOfferingMode() ) 
							) {
							updateExisting = true;
							childBeanCanonicalUUID = invoiceDocumentDetail.getCanonicalUUID();
							createNew = false;
							break;
						}
					}
				}				
 			}
 			if (!didFindTheRecord) {
 				createNew = true;
 			}
 			FormMap childBeanMap = new FormMap();
 			FormMap parentBeanMap = null;
 			if (createNew) {
 				parentBeanMap = new FormMap();
 				FormField invoiceNumberField = new FormField("invoiceNumber");
 				invoiceNumberField.addValue( channelInfoWrapper.getWebSiteInfo().getResellerId() + "-" + ((Long) sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_INVOICE)).toString() );
 				parentBeanMap.addFormField(invoiceNumberField);
 			}
			BeanLifecycle<HippoBean> childBeanLifeCycleHandler = null;
			BeanLifecycle<HippoBean> parentBeanLifeCycleHandler = null;
			String parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + InvoiceDocument.class.getSimpleName().toLowerCase();
			String parentBeanNameSpace = "mootlywcm:invoicedocument";
			String parentBeanNodeName = InvoiceDocument.class.getSimpleName().toLowerCase();
 			if (createNew || updateExisting) {
 				FormField serviceName = new FormField("serviceName");
				serviceName.addValue(selectedService.getName());
				
				FormField serviceQty = new FormField("serviceQty");
				serviceQty.addValue("1");
				
				FormField serviceRate = new FormField("serviceRate");
				serviceRate.addValue(theSelectedCostModel.getCost());
				
				FormField filingMode = new FormField("filingMode");
				filingMode.addValue(theSelectedCostModel.getOfferingMode());
				
				FormField createdBySource = new FormField("createdBySource");
				createdBySource.addValue(MemberPersonalInformation.class.getSimpleName().toLowerCase());
				
				childBeanMap.addFormField(serviceName);
				childBeanMap.addFormField(serviceQty);
				childBeanMap.addFormField(serviceRate);
				childBeanMap.addFormField(filingMode);
				childBeanMap.addFormField(createdBySource);
 			}
 			
			//check if invoice is present or not
			if (createNew) {
				//String baseAbsolutePathToReturnDocuments = beanAfterUpdate.getPath() + "/../"
				itReturnComponentHelper.saveAddNewChild(childBeanMap, parentBeanMap, childBeanLifeCycleHandler, parentBeanLifeCycleHandler, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, InvoiceDocumentDetail.class, wpm.getSession(), wpm);				
				//check for legacy memberpayment bean if it exists lets add it to the new invoice this way its consistent with the new payment				
			}
			else if (updateExisting) {
				//This means that we have the invoice and lets make sure any entries with memberpersonalinformation as source
				// is updated with the new pricing if any package detail has been changed.
				//String baseAbsolutePathToReturnDocuments = beanAfterUpdate.getPath() + "/../"
				itReturnComponentHelper.saveUpdateExistingChild(childBeanMap, parentBeanMap, childBeanLifeCycleHandler, parentBeanLifeCycleHandler, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, InvoiceDocumentDetail.class, wpm.getSession(), wpm, childBeanCanonicalUUID);
			}			
			//now before the page is redirected lets set a parameter so that the next page can do a proper display on what we have imported.
		}catch (Exception e) {
			logger.error("Error in afterUpdate ",e);
		}
	}
}
