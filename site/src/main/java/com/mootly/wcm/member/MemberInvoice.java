package com.mootly.wcm.member;


import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.annotations.SyncInvoiceWithCitrus;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.compound.InvoiceRefundDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.beans.events.InvoiceDocumentBeanHandler;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.accounting.InvoiceHelper;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.model.SORT_DIRECTION;
import com.mootly.wcm.services.citruspay.model.enquiry.EnquiryResponse;
import com.mootly.wcm.services.citruspay.model.enquiry.TxnEnquiryResponse;
/**
 * 
 * @author admin
 *
 */
@PrimaryBean(primaryBeanClass=InvoiceDocument.class)
@ChildBean(childBeanClass=InvoiceDocumentDetail.class)
@FormFields(fieldNames={"serviceName", "serviceDesc", "serviceQty", "serviceRate","filingMode"})
@RequiredFields(fieldNames={})
@DataTypeValidationFields(fieldNames={},dataTypes={})
@SyncInvoiceWithCitrus //this is to tell ITReturnComponent to call Citrus Gateway and if there is an error it will set a VARIABLE
public class MemberInvoice extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(MemberInvoice.class);

	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
	}

	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);		
		request.setAttribute("type", "invoice");
		List<HippoBean> serviceDocumentList = loadAllBeansUnderTheFolder(request,response,"services","mootlywcm:Name",SORT_DIRECTION.ASC);
		if (log.isInfoEnabled()) {
			if (serviceDocumentList != null && serviceDocumentList.size() > 0) {
				for (HippoBean theServiceBean:serviceDocumentList) {
					log.info("The Key:" + theServiceBean + " ---- class name :" + theServiceBean.getClass().getSimpleName());						
				}
			}
		}		
		if (serviceDocumentList != null && serviceDocumentList.size() > 0) {
			request.setAttribute("serviceDocumentList", serviceDocumentList);
		}
		request.setAttribute("availablePaymentTypes", getChannelInfoWrapper().availablePaymentTypes());
		if (request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase()) != null) {
			InvoiceDocument invoiceDocument = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
			System.out.println(invoiceDocument.getAmountDue());
			System.out.println(invoiceDocument.getTotalInvoiceAmount());
		}
		//this is COOL we call citrus for each transaction which was NET Banking, Credit Card, Debit Card and check for respCode
		// if there is no respCode we need to get it and update the record accordingly
		//if there is a respCode and its not success ignore it
		if (request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase()) != null) {
			InvoiceDocument invoiceDocument = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
			if (invoiceDocument != null && invoiceDocument.getInvoicePaymentDetailList() != null && invoiceDocument.getInvoicePaymentDetailList().size() > 0) {
								
			}			
		}
		//after all this lets reload the beans and reset the request attribute
		
	}
	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub		
		super.doAction(request, response);

	} 
	
	@Override
	protected BeanLifecycle<HippoBean> getParentBeanLifeCycleHandler() {
		// TODO Auto-generated method stub
		return new InvoiceDocumentBeanHandler(getSequenceGenerator());
	}
}




