package com.mootly.wcm.components.accounting;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
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
import com.mootly.wcm.services.citruspay.PaymentService.BANK_ISSUER;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.utils.MootlyITReturnUtil;
import com.opus.epg.sfa.java.PGResponse;

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
	
	@Override
	protected boolean additionalValidation(HstRequest request, HstResponse response, FormMap formMap) {
		// TODO Auto-generated method stub
		String returnUrl = getRedirectURLForSiteMapItem(request, response, null, "memberinvoice", getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		String notifyUrl = getRedirectURLForSiteMapItem(request, response, null,"memberinvoice", getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		PaymentType paymentType = null;
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}		
		String email =  getITRInitData(request).getFormMap().getField("email").getValue();
		String lastName = getITRInitData(request).getFormMap().getField("lastName").getValue();
		String firstName = getITRInitData(request).getFormMap().getField("firstName").getValue();
		String bilingAddress = getITRInitData(request).getFormMap().getField("bilingAddress").getValue();
		String pi_townCity = getITRInitData(request).getFormMap().getField("pi_townCity").getValue();
		String pi_state = getITRInitData(request).getFormMap().getField("pi_state").getValue();
		String pi_pinCode = getITRInitData(request).getFormMap().getField("pi_pinCode").getValue();
		String pi_mobile = getITRInitData(request).getFormMap().getField("pi_mobile").getValue();
		InvoiceDocument invDoc = (InvoiceDocument) getITRInitData(request).getParentBean(); 
		//String returnUrl = "http://www.wealth4india/site/blah";
		//FinancialYear fy = FinancialYear.getByDisplayName(personalInformation.getFinancialYear());
		if(paymentType.equals(PaymentType.NET_BANKING)){
			BANK_ISSUER bankIssuer = null;
			
			String issuerCodeStr = null;
			if ( getITRInitData(request).getFormMap() != null && getITRInitData(request).getFormMap().getField("issuerCode") != null && getITRInitData(request).getFormMap().getField("issuerCode").getValue() != null) {
				issuerCodeStr = getITRInitData(request).getFormMap().getField("issuerCode").getValue();
				try {
					bankIssuer = BANK_ISSUER.valueOf(issuerCodeStr);
				}catch (IllegalArgumentException e) {
					log.warn("Error converting issuer code to enum, check what's going on the value passed was " + issuerCodeStr,e);
				}
			}
			if (bankIssuer != null && bankIssuer.isAppliesToMotoAPI()) {
				String strTransactionId = ((InvoicePaymentDetailBeanHandler) getChildBeanLifeCycleHandler(request)).getStrPaymentTransactionId();
				if (log.isInfoEnabled()) {
					log.info("The transaction Id for this transaction is :" + strTransactionId);
				}
				Map<String, Object> output = getTransaction().acceptITRPaymentByNetBanking(
						strTransactionId,
						 getITRInitData(request).getUserName(), getITRInitData(request).getFinancialYear(), getITRInitData(request).getPAN(), 
						returnUrl, notifyUrl, bankIssuer, invDoc.getAmountDue().toString(), email, firstName, lastName,
						pi_mobile, bilingAddress, pi_townCity, pi_state, pi_pinCode);			
				if (output != null && output.containsKey(Transaction.RETURN_URL_KEY)) {
						String paymentRedirectURL = (String) output.get(Transaction.RETURN_URL_KEY);
				}else {
					getITRInitData(request).getFormMap().addMessage("error.gateway.connection", "true");
				}
			}
		}
		if(paymentType.equals(PaymentType.CREDIT_CARD) || paymentType.equals(PaymentType.DEBIT_CARD)){
			String cardHolderName = getITRInitData(request).getFormMap().getField("cardHolderName").getValue();
			String expiryMonth = getITRInitData(request).getFormMap().getField("expiryMonth").getValue();
			String expiryYear = getITRInitData(request).getFormMap().getField("expiryYear").getValue();
			String cvvNumber = getITRInitData(request).getFormMap().getField("cvvNumber").getValue();
			String cardNumber = getITRInitData(request).getFormMap().getField("cardNumber").getValue();
			String cardType = getITRInitData(request).getFormMap().getField("cardType").getValue();
			
			com.opus.epg.sfa.java.BillToAddress oBTA 	= new com.opus.epg.sfa.java.BillToAddress();
			com.opus.epg.sfa.java.ShipToAddress oSTA 	= new com.opus.epg.sfa.java.ShipToAddress();
			com.opus.epg.sfa.java.Merchant oMerchant 	= new com.opus.epg.sfa.java.Merchant();
			com.opus.epg.sfa.java.MPIData oMPI 		= new com.opus.epg.sfa.java.MPIData();
			com.opus.epg.sfa.java.CardInfo oCI 		= new com.opus.epg.sfa.java.CardInfo();
			com.opus.epg.sfa.java.PostLib oPostLib = null;
			try {
				oPostLib	= new com.opus.epg.sfa.java.PostLib();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			com.opus.epg.sfa.java.PGReserveData oPGReserveData	= new com.opus.epg.sfa.java.PGReserveData();
			
			com.opus.epg.sfa.java.CustomerDetails oCustomer = new com.opus.epg.sfa.java.CustomerDetails ();
			com.opus.epg.sfa.java.MerchanDise oMerchanDise = new com.opus.epg.sfa.java.MerchanDise();
			com.opus.epg.sfa.java.SessionDetail oSessionDetail = new com.opus.epg.sfa.java.SessionDetail();
			com.opus.epg.sfa.java.Address oHomeAddress =new com.opus.epg.sfa.java.Address();
			com.opus.epg.sfa.java.Address oOfficeAddress =new com.opus.epg.sfa.java.Address();
			com.opus.epg.sfa.java.AirLineTransaction oAirLineTrans= new com.opus.epg.sfa.java.AirLineTransaction();
			
			oMerchant.setMerchantDetails(
					"00001203"
					,"00001203"
					,"00001203"
					,"10.10.10.167"
					, System.currentTimeMillis()+""
					,"ORD123"
					//, "http://10.10.10.6/RailwayTicketing/PGResponse.asp"
					, "http://10.10.10.167:8080/TestPages/SFAResponse.jsp"
					, "POST"
					,"INR"
					,"INV123"
					
					,"req.Sale"
					, "350.50"
					,"GMT+05:30"
					, "JAVA"
					, "true"
					, "JAVA"
					, "JAVA"
					, "JAVA"
					);



	oBTA.setAddressDetails(
			"CID"
			,"CustName"
			,"AddrLine1"
			,"AddrLine2"
			,"AddrLine3"
			,"city"
			,"state"
			,"523466"
			,"IND"
			, "test@test.com"
			);


	oSTA.setAddressDetails(
			"2 Mitali"
			,"Orion Comp"
			,"Aundh Road"
			,"city"
			,"state"
			,"4385435873"
			,"IND"
			,"test@test.com"
			);

	oMPI.setMPIRequestDetails("1245"
				,"$12.45"
				,"418",
				"2"
				,"2 shirts"
				,"12"
				,"20011212"
				,"12"
				,"0"
				,""
				,"image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/vnd.ms-powerpoint, application/vnd.ms-excel, application/msword, application/x-shockwave-flash, */*"
				,"Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)"
				); 

		oHomeAddress.setAddressDetails(
					"2,Sandeep"
					,"Uttam Corner"
					,"Chinchwad"
					,"Pune"
					,"state"
					,"4385435873"
					,"IND"
					, "test@test.com"
					);
					
		oOfficeAddress.setAddressDetails(
						"2,Opus"
						,"MayFairTowers"
						,"Wakdewadi"
						,"Pune"
						,"state"
						,"4385435873"
						,"IND"
						, "test@test.com"
					);
								  
		oCustomer.setCustomerDetails(
		                             "Sandeep", // first name 
					     "patil", //last name
					     oOfficeAddress,
					     oHomeAddress,
					     "9423203297",//mobile number
					     "13-06-2007", // Reg Date
					     "Y" // Billing and shipping address match
					);
		
		oSessionDetail.setSessionDetails(request.getRemoteAddr(), //This Customer ip,merchant need to send it.
							  getSecureCookie(request),  //cookie string
							  request.getLocale().getCountry(),
							  request.getLocale().getLanguage(), 
							  request.getLocale().getVariant() ,
							  request.getHeader ("user-agent")
					  );

		
		oMerchanDise.setMerchanDiseDetails("Computer",
							   "2",
							   "Intel",
							   "P4",
							   "Sandeep Patil", //buyers name
							   "Y" //Buyername and Card name match.
							   );
					   
						   
		
		oAirLineTrans.setAirLineTransactionDetails( "10-06-2007", //booking Date				   
					   	   "22-06-2007", //Flight Date
					   	   "13:20", //Flight Time
					   	   "119",  //Flight number
					   	   "Sandeep", //Passenger Name
					   	   "1", //Number if Tickets
					   	   "Y",// PassebgerName and Card name match
					   	   "25c",//PBR
					   	   "Pune", // Sector From
					   	   "Mumbai"//Sector To
					   	   );

		System.out.println("before calling postssl ");

		
		//PGResponse oPGResponse = oPostLib.postSSL(oBTA,oSTA,oMerchant,oMPI,response,oPGReserveData,null,null,null,null);
		PGResponse oPGResponse = oPostLib.postSSL(oBTA,oSTA,oMerchant,oMPI,response,oPGReserveData,oCustomer,oSessionDetail,oAirLineTrans,null);
		if(oPGResponse.getRedirectionUrl() != null) {
			String strRedirectionURL = oPGResponse.getRedirectionUrl();
			try {
				response.sendRedirect(strRedirectionURL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Error encountered. Error Code : " +oPGResponse.getRespCode() + " . Message " +  oPGResponse.getRespMessage());
		}
		System.out.println("before PGResponse");
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
				getITRInitData(request).getFormMap().addMessage("error.gateway.connection", "true");
			}
			*/
		}	
		
		return true;
	}
	
	
	protected String getSecureCookie(HstRequest request) {
        String secureCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) { 
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("vsc")) {
                    secureCookie = cookies[i].getValue().trim();
                    break; 
                }
            }
        }
        return secureCookie;
    }
}
