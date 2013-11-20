package com.mootly.wcm.beans.events;

import java.util.ArrayList;
import java.util.List;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.beans.compound.CostModel;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.channels.ChannelInfoWrapper;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.ITRServiceDelivery;
import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;

public class MemberPersonalInfoUpdateHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean>{
	Logger logger = LoggerFactory.getLogger(MemberPersonalInfoUpdateHandler.class);
	final List<HippoBean> itrServices;
	final ChannelInfoWrapper channelInfoWrapper;
	final RetrievePANInformation retrievePANInformation;
	
	String serviceName;
	String serviceQty;
	String serviceRate;
	String filingMode;
	
	
	
	public MemberPersonalInfoUpdateHandler(List<HippoBean> itrServices,ChannelInfoWrapper channelInfoWrapper,RetrievePANInformation retrievePANInformation) {
		this.itrServices = itrServices;
		this.channelInfoWrapper = channelInfoWrapper;
		this.retrievePANInformation = retrievePANInformation;
	}
	
	@Override
	public boolean validateParentBean(HippoBean hippoBean, boolean isNew,
			List<String> errors, List<String> warnings) {
		// TODO Auto-generated method stub
		boolean isValid = true;
		/*
		if (errors == null) errors = new ArrayList<String>();
		//this can go into validator chain but for now lets do it right here
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) hippoBean;
		if (memberPersonalInformation != null) {
			try {				
				if (logger.isInfoEnabled()) {
					logger.info("Will call DIT ");
					logger.info("DIT getEriUserId:" + channelInfoWrapper.getWebSiteInfo().getEriUserId());
					logger.info("DIT getEriPassword:" + channelInfoWrapper.getWebSiteInfo().getEriPassword());
					logger.info("DIT getEriCertChain:" + channelInfoWrapper.getWebSiteInfo().getEriCertChain());
					logger.info("DIT getEriSignature:" + channelInfoWrapper.getWebSiteInfo().getEriSignature());
				}
				RetrievePANResponse retrievePANResponse = retrievePANInformation.retrievePANInformation(channelInfoWrapper.getWebSiteInfo().getEriUserId() , channelInfoWrapper.getWebSiteInfo().getEriPassword(), channelInfoWrapper.getWebSiteInfo().getEriCertChain(), channelInfoWrapper.getWebSiteInfo().getEriSignature() , memberPersonalInformation.getPAN());
				if (retrievePANResponse == null) {
					errors.add("error.dit");
					isValid = false;
				}
				else {
					if (logger.isInfoEnabled()) {
						logger.info("memberPersonalInformation.getDOBStr() :" + memberPersonalInformation.getDOBStr());
						logger.info("retrievePANResponse.getDOB():" + retrievePANResponse.getDOB());
					}
					isValid = true;
				}
				
			} catch (MissingInformationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("Error",e);
			} catch (DataMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("Error",e);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("Error",e);
			}			
			catch (Exception e) {
				logger.error("Error",e);
			}
		}
		*/
		return isValid;
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
								invoiceDocumentDetail.getServiceRate() == null || !invoiceDocumentDetail.getServiceRate().equals( theSelectedCostModel.getCost() ) ||  	
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
		}catch (Exception e) {
			logger.error("Error in afterUpdate ",e);
		}
	}
}
