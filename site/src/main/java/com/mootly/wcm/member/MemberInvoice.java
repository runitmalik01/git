package com.mootly.wcm.member;


import java.util.List;

import javax.servlet.ServletContext;

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
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.SORT_DIRECTION;
import com.mootly.wcm.services.SequenceGenerator;

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
	}
	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

	} 
	
	@Override
	protected BeanLifecycle<HippoBean> getParentBeanLifeCycleHandler() {
		// TODO Auto-generated method stub
		return new InvoiceDocumentBeanHandler();
	}
/**
 * This class is responsible to inject the invoice number every time an invoice is created
 * @author admin
 *
 */
	class InvoiceDocumentBeanHandler implements BeanLifecycle<HippoBean> {
	
		@Override
		public void beforeCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			SequenceGenerator sequenceGenerator = getSequenceGenerator();
			Long invoiceNumber = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_INVOICE);
			if (hippoBean != null && hippoBean instanceof InvoiceDocument) {
				InvoiceDocument invoiceDocument = (InvoiceDocument) hippoBean;
				invoiceDocument.setInvoiceNumber(String.valueOf(invoiceNumber));
			}
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




