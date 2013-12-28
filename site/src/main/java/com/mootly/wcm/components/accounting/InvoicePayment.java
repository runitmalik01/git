package com.mootly.wcm.components.accounting;

import java.util.Map;

import javax.servlet.ServletContext;

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
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.InvalidNavigationException;
import com.mootly.wcm.components.InvalidPANException;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.citruspay.PaymentService.BANK_ISSUER;
import com.mootly.wcm.services.citruspay.Transaction;

@PrimaryBean(primaryBeanClass=InvoiceDocument.class)
@ChildBean(childBeanClass=InvoicePaymentDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class,InvoiceDocument.class})
@FormFields(fieldNames={"paymentMemo","paymentAmount","authCode","preAuthCode","checkAmount","checkNo","checkDate","checkBank","checkBranch","checkLocation","cashAddress","cashContactNumber","cashBestTime","cashAmount","rtgsTransNumber","rtgsDate","rtgsAmount","rtgsTime","issuerCode","lastName","firstName","email","bilingAddress","pi_townCity","pi_state","pi_pinCode","pi_mobile"},
fieldNamesVendorOnly={"paymentVerificationStatusStr","vendor_txnAmount"})
//@RequiredFields(fieldNames={"paymentType"})
@DataTypeValidationFields(fieldNames={"rtgsDate"},dataTypes={DataTypeValidationType.INDIANDATE})
public class InvoicePayment extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(InvoicePayment.class);
	String theTransactionId = "";
	PaymentType paymentType = null;
	Transaction transaction = null;
	String returnSiteMapRefID = "payment-success-";
	InvoicePaymentDetailBeanHandler  invoicePaymentDetailBeanHandler = null;
	
	String paymentRedirectURL = null;
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
		// TODO Auto-generated method stub
		
		super.doBeforeRender(request, response);
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}		
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);		
		if (getPageAction() != null && getPageAction() != PAGE_ACTION.EDIT && getPageAction() != PAGE_ACTION.EDIT_CHILD && getPageAction() != PAGE_ACTION.DELETE && getPageAction() != PAGE_ACTION.DELETE_CHILD ) {
			if (request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase()) != null) {
				InvoiceDocument invoiceDocument = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
				if (invoiceDocument != null && invoiceDocument.getAmountDue() == 0D) {
					response.setRenderPath("jsp/accounting/invoice-payment-already-paid.jsp");
				}			
			}
		}
	}
	
	@Override
	protected boolean shouldRedirectAfterSuccess() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		try {
			initComponent(request, response);
		} catch (InvalidNavigationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPANException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InvoiceDocument invoiceDocument  = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
		theTransactionId = invoiceDocument.getInvoiceNumber() + "-" + getSequenceGenerator().getNextId(SequenceGenerator.SEQUENCE_PAYMENT);
		//we want to 
		
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		if (paymentType != null) {
			if ( getChannelInfoWrapper().availablePaymentTypes() == null || !getChannelInfoWrapper().availablePaymentTypes().contains(paymentType) ) {
				response.setRenderPath("jsp/accounting/invalid_paymentype.jsp");
				return;
			}
		}
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		//this is where we create the handler first
		boolean isSavedByVendor = false;
		if (isVendor(request) && isOnVendorPortal()) {
			isSavedByVendor = true;
		}
		invoicePaymentDetailBeanHandler = new InvoicePaymentDetailBeanHandler(paymentType,request, theTransactionId,isSavedByVendor);		
		super.doAction(request, response);		
	}

	@Override
	protected BeanLifecycle<HippoBean> getChildBeanLifeCycleHandler() {
		// TODO Auto-generated method stub
		return invoicePaymentDetailBeanHandler;
	}
	
	@Override
	protected String[] getRequiredFields() {
		// TODO Auto-generated method stub
		switch(paymentType) {
		case NET_BANKING:
			return new String[] {"issuerCode","lastName","firstName","email","bilingAddress","pi_townCity","pi_state","pi_pinCode","pi_mobile"};			
		default:
			return null;
		}
	}
	
	@Override
	protected boolean additionalValidation(HstRequest request, HstResponse response, FormMap formMap) {
		// TODO Auto-generated method stub
		String returnUrl = getRedirectURLForSiteMapItem(request, response, null, "memberinvoice", getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		String notifyUrl = getRedirectURLForSiteMapItem(request, response, null,"memberinvoice", getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		
		String email = getFormMap().getField("email").getValue();
		String lastName = getFormMap().getField("lastName").getValue();
		String firstName = getFormMap().getField("firstName").getValue();
		String bilingAddress = getFormMap().getField("bilingAddress").getValue();
		String pi_townCity = getFormMap().getField("pi_townCity").getValue();
		String pi_state = getFormMap().getField("pi_state").getValue();
		String pi_pinCode = getFormMap().getField("pi_pinCode").getValue();
		String pi_mobile = getFormMap().getField("pi_mobile").getValue();
		InvoiceDocument invDoc = (InvoiceDocument) getParentBean(); 
		//String returnUrl = "http://www.wealth4india/site/blah";
		//FinancialYear fy = FinancialYear.getByDisplayName(personalInformation.getFinancialYear());
		if(paymentType.equals(PaymentType.NET_BANKING)){
			BANK_ISSUER bankIssuer = null;
			
			String issuerCodeStr = null;
			if (getFormMap() != null && getFormMap().getField("issuerCode") != null && getFormMap().getField("issuerCode").getValue() != null) {
				issuerCodeStr = getFormMap().getField("issuerCode").getValue();
				try {
					bankIssuer = BANK_ISSUER.valueOf(issuerCodeStr);
				}catch (IllegalArgumentException e) {
					log.warn("Error converting issuer code to enum, check what's going on the value passed was " + issuerCodeStr,e);
				}
			}
			if (bankIssuer != null && bankIssuer.isAppliesToMotoAPI()) {
				String strTransactionId = invoicePaymentDetailBeanHandler.getStrPaymentTransactionId();
				if (log.isInfoEnabled()) {
					log.info("The transaction Id for this transaction is :" + strTransactionId);
				}
				Map<String, Object> output = getTransaction().acceptITRPaymentByNetBanking(
						strTransactionId,
						getUserName(), getFinancialYear(), getPAN(), 
						returnUrl, notifyUrl, bankIssuer, invDoc.getAmountDue().toString(), email, firstName, lastName,
						pi_mobile, bilingAddress, pi_townCity, pi_state, pi_pinCode);			
				if (output != null && output.containsKey(Transaction.RETURN_URL_KEY)) {
						paymentRedirectURL = (String) output.get(Transaction.RETURN_URL_KEY);
				}else {
					getFormMap().addMessage("error.gateway.connection", "true");
				}
			}
		}
		if(paymentType.equals(PaymentType.CREDIT_CARD) || paymentType.equals(PaymentType.DEBIT_CARD)){
			String cardHolderName = getFormMap().getField("cardHolderName").getValue();
			String expiryMonth = getFormMap().getField("expiryMonth").getValue();
			String expiryYear = getFormMap().getField("expiryYear").getValue();
			String cvvNumber = getFormMap().getField("cvvNumber").getValue();
			String cardNumber = getFormMap().getField("cardNumber").getValue();
			String cardType = getFormMap().getField("cardType").getValue();
			/*
			 * 	Map<String, Object> output = transaction.acceptITRPaymentByDebitOrCreditCard(
					
					memberLoginName, getFinancialYear(), getPAN(), 
					returnUrl,notifyUrl,PaymentType.valueOf(paymentType.toString()),
					cardHolderName,cardNumber, CARD_TYPE.valueOf(cardType),cvvNumber,expiryMonth,expiryYear,
					amount,email,personalInformation.getFirstName(),personalInformation.getLastName(),personalInformation.getMobile(),
					address, personalInformation.getTownCityDistrict(), personalInformation.getState(), personalInformation.getPinCode());
					*/	
			/*
			if (output != null && output.containsKey(Transaction.RETURN_URL_KEY)) {
				paymentRedirectURL = (String) output.get(Transaction.RETURN_URL_KEY);
			}else {
				getFormMap().addMessage("error.gateway.connection", "true");
			}
			*/
		}	
		
		return true;
	}
	
	@Override
	protected String urlToRedirectAfterSuccess(HstRequest request,
			HstResponse response, FormMap formMap) {
		// TODO Auto-generated method stub
		if (paymentRedirectURL != null ) {
			return paymentRedirectURL;
		}
		else {
			return null;
		}
	}
}
