package com.mootly.wcm.components.accounting;

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
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.services.SequenceGenerator;

@PrimaryBean(primaryBeanClass=InvoiceDocument.class)
@ChildBean(childBeanClass=InvoicePaymentDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class,InvoiceDocument.class})
@FormFields(fieldNames={"paymentMemo","paymentAmount","authCode","preAuthCode","checkNo","checkDate","checkBank","checkBranch","checkLocation","cashAddress","cashContactNumber","cashBestTime","rtgsTransNumber","rtgsDate","rtgsAmount","rtgsTime"},
fieldNamesVendorOnly={"paymentVerificationStatus"})
//@RequiredFields(fieldNames={"paymentType"})
@DataTypeValidationFields(fieldNames={"rtgsDate"},dataTypes={DataTypeValidationType.INDIANDATE})
public class InvoicePayment extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(InvoicePayment.class);
	PaymentType paymentType = null;
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
	}
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		super.doBeforeRender(request, response);
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		super.doAction(request, response);
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
	}
	
	@Override
	protected BeanLifecycle<HippoBean> getChildBeanLifeCycleHandler() {
		// TODO Auto-generated method stub
		return new InvoicePaymentDetailBeanHandler(this.paymentType);
	}


	/**
	 * This class is responsible to inject the invoice number every time an invoice is created
	 * @author admin
	 *
	 */
	class InvoicePaymentDetailBeanHandler implements BeanLifecycle<HippoBean> {

		final PaymentType paymentType;
		
		public InvoicePaymentDetailBeanHandler(PaymentType paymentType) {
			this.paymentType = paymentType;
		}
		@Override
		public void beforeCreate(HippoBean hippoBean) {
			// TODO Auto-genera;ted method stub

		}

		@Override
		public void afterCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			SequenceGenerator sequenceGenerator = getSequenceGenerator();
			Long paymentTransactionId = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_PAYMENT);
			if (hippoBean != null && hippoBean instanceof InvoicePaymentDetail) {
				InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) hippoBean;
				invoicePaymentDetail.setPaymentTransactionId(String.valueOf(paymentTransactionId));
				invoicePaymentDetail.setPaymentType(paymentType);
				invoicePaymentDetail.setPaymentDate(IndianGregorianCalendar.getCurrentDateInIndiaAsDate());
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
