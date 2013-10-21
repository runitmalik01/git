/**
 * 
 */
package com.mootly.wcm.components.accounting;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.PaymentType;

/**
 * @author BEN-10
 *
 */
@RequiredBeans(requiredBeans={MemberPersonalInformation.class,InvoiceDocument.class})

public class InvoicePaymentSuccess extends ITReturnComponent{
	public static final Logger logger = LoggerFactory.getLogger(InvoicePaymentSuccess.class); 
	PaymentType paymentType = null;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		InvoiceDocument invoiceDocument = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		request.setAttribute("invoiceDocument", invoiceDocument);
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
