package com.mootly.wcm.components.accounting;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.hippoecm.hst.component.support.forms.FormMap;
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
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.beans.events.InvoicePaymentDetailBeanHandler;
import com.mootly.wcm.channels.ChannelInfoWrapper;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.services.SequenceGenerator;

@PrimaryBean(primaryBeanClass=InvoiceDocument.class)
@ChildBean(childBeanClass=InvoicePaymentDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class,InvoiceDocument.class})
@FormFields(fieldNames={"paymentMemo","paymentAmount","authCode","preAuthCode","checkAmount","checkNo","checkDate","checkBank","checkBranch","checkLocation","cashAddress","cashContactNumber","cashBestTime","cashAmount","rtgsTransNumber","rtgsDate","rtgsAmount","rtgsTime","issuerCode","lastName","firstName","email","bilingAddress","pi_townCity","pi_state","pi_pinCode","pi_mobile"},
fieldNamesVendorOnly={"paymentVerificationStatusStr","vendor_txnAmount"})
//@RequiredFields(fieldNames={"paymentType"})
@DataTypeValidationFields(fieldNames={"rtgsDate"},dataTypes={DataTypeValidationType.INDIANDATE})
public class InvoicePayment extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(InvoicePayment.class);

	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		/*ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		transaction =	context.getBean(Transaction.class);*/
	}
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		PaymentType paymentType = null;
		getITRInitData(request);
		boolean isGatewayForm = false;
		// TODO Auto-generated method stub
		String gatewayForm = getParameter("gatewayForm", request);
		if (gatewayForm != null && "true".equals(gatewayForm)) {
			isGatewayForm = true;		
		}
		if (isGatewayForm) {
			//formFields.put("orderAmount", value)
			if (request.getParameter("strTransactionId") != null) {
				//validate the transaction Id -- this will involve fetching the data back from the bean and
				String strTransactionId = request.getParameter("strTransactionId");
				String returnUrl = getRedirectURLForSiteMapItem(request, response, null, (getITRInitData(request).isOnVendorPortal() ? "vendor-memberinvoice" : "memberinvoice"), getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
				InvoiceDocument invoiceDocument = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
				MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
				if (invoiceDocument != null) {
					for (InvoicePaymentDetail invoicePaymentDetail : invoiceDocument.getInvoicePaymentDetailList()) {
						if (invoicePaymentDetail.getPaymentTransactionId() != null && strTransactionId.equals(invoicePaymentDetail.getPaymentTransactionId())) {
							request.setAttribute("invoicePaymentDetail", invoicePaymentDetail);
							request.setAttribute( "orderAmount", invoicePaymentDetail.getPaymentAmount() );
							request.setAttribute( "merchantAccessKey", getTransaction().getAccessKey() );
							request.setAttribute( "checkoutURL", getTransaction().getCheckoutURL() );
							request.setAttribute( "currency", getTransaction().getCurrency() );
							request.setAttribute( "secSignature", getTransaction().getHMACSignatureSSL(invoicePaymentDetail.getPaymentTransactionId(), invoicePaymentDetail.getPaymentAmount().toString()));
							request.setAttribute( "returnUrl", returnUrl);

							if (memberPersonalInformation != null) {
								if (memberPersonalInformation.getEmail() != null) {
									if ( memberPersonalInformation.getEmail() != null ) request.setAttribute("email", memberPersonalInformation.getEmail());
									if ( memberPersonalInformation.getFirstName() != null ) request.setAttribute("firstName", memberPersonalInformation.getFirstName());
									if ( memberPersonalInformation.getLastName() != null ) request.setAttribute("lastName", memberPersonalInformation.getLastName());

									if ( memberPersonalInformation.getRoadStreet() != null ) request.setAttribute("addressStreet1", memberPersonalInformation.getRoadStreet());
									if ( memberPersonalInformation.getRoadStreet() != null ) request.setAttribute("addressCity", memberPersonalInformation.getTownCityDistrict());
									if ( memberPersonalInformation.getPhone() != null ) request.setAttribute("phoneNumber", memberPersonalInformation.getMobile());
									if ( memberPersonalInformation.getPinCode() != null ) request.setAttribute("addressZip", memberPersonalInformation.getPinCode());
									if ( memberPersonalInformation.getState() != null ) request.setAttribute("addressState", memberPersonalInformation.getState());
								}
							}

							break;
						}
					}
				}
			}
			response.setRenderPath("jsp/accounting/paymentgateway_form.jsp");
		}		
		else {
			String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
			if (paymentTypeStr != null) {
				paymentType = PaymentType.valueOf(paymentTypeStr);
				if (paymentType == null ||  !getITRInitData(request).getChannelInfoWrapper().availablePaymentTypes().contains(paymentType)) {
					try {
						response.sendError(HttpServletResponse.SC_FORBIDDEN);
						return;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}else {
					if (PaymentType.requiresGateway(paymentType)) { //this means that 
						//we are using the SSL Integration for all gateway transactions 
						request.setAttribute("requiresGateway","true");
					}
				}
			}		
			request.setAttribute("type", "payment");
			request.setAttribute("paymentType", paymentType);		
			if (getITRInitData(request).getPageAction() != null && getITRInitData(request).getPageAction() != PAGE_ACTION.EDIT && getITRInitData(request).getPageAction() != PAGE_ACTION.EDIT_CHILD && getITRInitData(request).getPageAction() != PAGE_ACTION.DELETE && getITRInitData(request).getPageAction() != PAGE_ACTION.DELETE_CHILD ) {
				if (request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase()) != null) {
					InvoiceDocument invoiceDocument = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
					if (invoiceDocument != null && invoiceDocument.getAmountDue() == 0D) {
						response.setRenderPath("jsp/accounting/invoice-payment-already-paid.jsp");
					}			
				}
			}
		}
	}

	
	@Override
	protected boolean shouldRedirectAfterSuccess(HstRequest request) {
		boolean isGatewayForm = false;
		String gatewayForm = getParameter("gatewayForm", request);
		if (gatewayForm != null && "true".equals(gatewayForm)) {
			isGatewayForm = true;		
		}
		// TODO Auto-generated method stub
		if (!isGatewayForm) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		String theTransactionId = "";
		PaymentType paymentType = null;
		InvoicePaymentDetailBeanHandler  invoicePaymentDetailBeanHandler = null;

		getITRInitData(request);

		boolean isGatewayForm = false;

		String gatewayForm = getParameter("gatewayForm", request);
		if (gatewayForm != null && "true".equals(gatewayForm)) {
			isGatewayForm = true;
		}
		
		
		InvoiceDocument invoiceDocument  = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
		theTransactionId = invoiceDocument.getInvoiceNumber() + "-" + getSequenceGenerator().getNextId(SequenceGenerator.SEQUENCE_PAYMENT);
		//we want to 

		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (isGatewayForm && paymentTypeStr == null) {
			paymentTypeStr = getPublicRequestParameter(request,"paymentType");
		}
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}

		if (paymentType != null) {
			WebsiteInfo webSiteInfo = request.getRequestContext().getResolvedMount().getMount().getChannelInfo();
			ChannelInfoWrapper channelInfoWrapper = new ChannelInfoWrapper(webSiteInfo);
			if ( channelInfoWrapper.availablePaymentTypes() == null || !channelInfoWrapper.availablePaymentTypes().contains(paymentType) ) {
				response.setRenderPath("jsp/accounting/invalid_paymentype.jsp");
				return;
			}
		}
		else {
			return;
		}
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		//this is where we create the handler first
		boolean isSavedByVendor = false;
		if (getITRInitData(request).isVendor(request) && getITRInitData(request).isOnVendorPortal()) {
			isSavedByVendor = true;
		}
		invoicePaymentDetailBeanHandler = new InvoicePaymentDetailBeanHandler(paymentType,request, theTransactionId,isSavedByVendor,isGatewayForm);	
		request.setAttribute("invoicePaymentDetailBeanHandler", invoicePaymentDetailBeanHandler);
		super.doAction(request, response);			
		response.setRenderParameter("strTransactionId", theTransactionId);
	}

	@Override
	protected BeanLifecycle<HippoBean> getChildBeanLifeCycleHandler(HstRequest request) {
		// TODO Auto-generated method stub
		return (InvoicePaymentDetailBeanHandler) request.getAttribute("invoicePaymentDetailBeanHandler");
	}

	@Override
	protected String[] getRequiredFields(HstRequest request) {
		// TODO Auto-generated method stub
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		PaymentType paymentType = null;
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		if (paymentType != null) {
			switch(paymentType) {
			case NET_BANKING:
				return new String[] {"issuerCode","lastName","firstName","email","bilingAddress","pi_townCity","pi_state","pi_pinCode","pi_mobile"};			
			default:
				return null;
			}
		}
		return null;
	}
	@Override
	protected String urlToRedirectAfterSuccess(HstRequest request,
			HstResponse response, FormMap formMap) {
		// TODO Auto-generated method stub
		return null;
		/*
		if (paymentRedirectURL != null ) {
			return paymentRedirectURL;
		}
		else {
			return null;
		}
		*/
	}
}
