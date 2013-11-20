package com.mootly.wcm.components.accounting;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;

import org.hippoecm.hst.configuration.sitemap.HstSiteMapItem;
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
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.citruspay.PaymentService.BANK_ISSUER;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.Transaction.CARD_TYPE;

@PrimaryBean(primaryBeanClass=InvoiceDocument.class)
@ChildBean(childBeanClass=InvoicePaymentDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class,InvoiceDocument.class})
@FormFields(fieldNames={"paymentMemo","paymentAmount","authCode","preAuthCode","checkNo","checkDate","checkBank","checkBranch","checkLocation","cashAddress","cashContactNumber","cashBestTime","rtgsTransNumber","rtgsDate","rtgsAmount","rtgsTime","issuerCode"},
fieldNamesVendorOnly={"paymentVerificationStatus"})
//@RequiredFields(fieldNames={"paymentType"})
@DataTypeValidationFields(fieldNames={"rtgsDate"},dataTypes={DataTypeValidationType.INDIANDATE})
public class InvoicePayment extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(InvoicePayment.class);
	String theTransactionId = "";
	PaymentType paymentType = null;
	Transaction transaction = null;
	String returnSiteMapRefID = "payment-success-";
	InvoicePaymentDetailBeanHandler  invoicePaymentDetailBeanHandler = null;
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
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);		
		super.doBeforeRender(request, response);
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		String urlPaymentType = getPublicRequestParameter(request, "paymentType");
		if(urlPaymentType!=null){
			for(PaymentType payType:PaymentType.values()){
				if(payType.equals(PaymentType.valueOf(urlPaymentType))){
					paymentType = PaymentType.valueOf(urlPaymentType);
				}
			}
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
		return false;
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);	
		if (paymentType != null) {
			if ( getChannelInfoWrapper().availablePaymentTypes() == null || getChannelInfoWrapper().availablePaymentTypes().contains(paymentType) ) {
				response.setRenderPath("jsp/accounting/invalid_paymentype.jsp");
				return;
			}
		}
		//this is where we create the handler first
		invoicePaymentDetailBeanHandler = new InvoicePaymentDetailBeanHandler(paymentType,request,getSequenceGenerator());
		super.doAction(request, response);
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		String urlPaymentType = getPublicRequestParameter(request, "paymentType");
		if(urlPaymentType!=null){
			for(PaymentType payType:PaymentType.values()){
				if(payType.equals(PaymentType.valueOf(urlPaymentType))){
					paymentType = PaymentType.valueOf(urlPaymentType);
				}
			}
		}
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		MemberPersonalInformation personalInformation = (MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		InvoiceDocument invDoc = (InvoiceDocument) getParentBean(); 
		returnSiteMapRefID = returnSiteMapRefID + paymentType.name();
		String address = personalInformation.getFlatDoorBuilding()+","+personalInformation.getRoadStreet()+","+personalInformation.getAreaLocality();
		address = address.replaceAll(",,", ",");
		String memberLoginName = getUserName().toLowerCase();
		String email = getUserName().toLowerCase();
		String amount = String.valueOf(invDoc.getAmountDue());
		ITReturnComponent itReturnComponent = new ITReturnComponent();
		
		String rq = request.getRequestURI();
		if (log.isInfoEnabled()) {
			log.info(rq);
		}
		
	 	//HstSiteMapItem returnURL = request.getRequestContext().getResolvedSiteMapItem().getHstSiteMapItem().get
	 	//HstSiteMapItem notifyURL = request.getRequestContext().getResolvedSiteMapItem().getHstSiteMapItem().getChild("notifyURL");
		String returnUrl = itReturnComponent.getRedirectURLForSiteMapItem(request, response, null, "memberinvoice", getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		String notifyUrl = itReturnComponent.getRedirectURLForSiteMapItem(request, response, null,"memberinvoice", getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
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
		
		//String returnUrl = "http://www.wealth4india/site/blah";
		//FinancialYear fy = FinancialYear.getByDisplayName(personalInformation.getFinancialYear());
		if(paymentType.equals(PaymentType.NET_BANKING) && bankIssuer != null && bankIssuer.isAppliesToMotoAPI()){
			String strTransactionId = invoicePaymentDetailBeanHandler.getStrPaymentTransactionId();
			if (log.isInfoEnabled()) {
				log.info("The transaction Id for this transaction is :" + strTransactionId);
			}
			Map<String, Object> output = getTransaction().acceptITRPaymentByNetBanking(
					strTransactionId,
					memberLoginName, getFinancialYear(), getPAN(), 
					returnUrl, notifyUrl, bankIssuer, amount, email, personalInformation.getFirstName(), personalInformation.getLastName(),
					personalInformation.getMobile(), address, personalInformation.getTownCityDistrict(), personalInformation.getState(), personalInformation.getPinCode());			
			if (output != null && output.containsKey(Transaction.RETURN_URL_KEY)) {
				try {
					response.sendRedirect((String) output.get(Transaction.RETURN_URL_KEY));
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error("There was an error redirecting user to ",e);
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
			Map<String, Object> output = transaction.acceptITRPaymentByDebitOrCreditCard(
					//memberLoginName, financialYear, PAN, 
					// returnURL, notifyURL, paymentNode, 
					// cardHolderName, cardNumber, cardType, cvvNumber, expiryMonth, expiryYear, 
					// amount, email, firstName, lastName, mobile) (
					memberLoginName, getFinancialYear(), getPAN(), 
					returnUrl,notifyUrl,PaymentType.valueOf(paymentType.toString()),
					cardHolderName,cardNumber, CARD_TYPE.valueOf(cardType),cvvNumber,expiryMonth,expiryYear,
					amount,email,personalInformation.getFirstName(),personalInformation.getLastName(),personalInformation.getMobile(),
					address, personalInformation.getTownCityDistrict(), personalInformation.getState(), personalInformation.getPinCode());					
		}
	}

	@Override
	protected BeanLifecycle<HippoBean> getChildBeanLifeCycleHandler() {
		// TODO Auto-generated method stub
		return invoicePaymentDetailBeanHandler;
	}
}
