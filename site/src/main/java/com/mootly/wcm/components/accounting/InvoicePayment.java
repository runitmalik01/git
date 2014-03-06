package com.mootly.wcm.components.accounting;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.WordUtils;
import org.hippoecm.hst.component.support.forms.FormField;
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
import com.mootly.wcm.components.ITReturnInitData;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.citruspay.PaymentService.BANK_ISSUER;
import com.mootly.wcm.services.citruspay.Transaction;
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
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr == null) {
			PAGE_ACTION pageAction  = getITRInitData(request).getPageAction();
			if (pageAction == PAGE_ACTION.EDIT_CHILD ) {
				HippoBean theChildBean = getITRInitData(request).getChildBean();
				if (theChildBean != null && theChildBean instanceof InvoicePaymentDetail) {
					InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) getITRInitData(request).getChildBean();
					PaymentType paymentType2 = invoicePaymentDetail.getPaymentType();
					paymentTypeStr = paymentType2.name();
				}
				if (log.isInfoEnabled()) {
					log.info("theChildBean is " + theChildBean);
				}
			}
		}
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
		if (isGatewayForm) {
			//formFields.put("orderAmount", value)
			response.setRenderPath("jsp/accounting/paymentgateway_form.jsp");
			/*
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
			else {
				response.setRenderPath("jsp/accounting/paymentgateway_form.jsp");
			}
			 */
		}		
		else {	
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
		return true;
		/*
		// TODO Auto-generated method stub
		if (!isGatewayForm) {
			return true;
		}
		else {
			return false;
		}
		 */
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



		paymentType = getPaymentType(request,isGatewayForm);
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
		

		InvoiceDocument invoiceDocument  = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
		theTransactionId = invoiceDocument.getInvoiceNumber() + "-" + getSequenceGenerator().getNextId(SequenceGenerator.SEQUENCE_PAYMENT);
		//we want to 
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
		String paymentRedirectURL = null;
		if (request.getAttribute("paymentRedirectURL") != null) {
			paymentRedirectURL = (String) request.getAttribute("paymentRedirectURL");
		}
		// TODO Auto-generated method stub
		if (paymentRedirectURL != null ) {
			InvoicePaymentDetailBeanHandler invoicePaymentDetailBeanHandler = (InvoicePaymentDetailBeanHandler) request.getAttribute("invoicePaymentDetailBeanHandler");
			if ( invoicePaymentDetailBeanHandler != null ){
				//the transaction id must BE a valid ID otherwise we should not transfer
			}
			return paymentRedirectURL;
		}
		else {
			return null;
		}
	}

	@Override
	protected boolean additionalValidation(HstRequest request, HstResponse response, FormMap formMap) {
		// TODO Auto-generated method stub
		String refIdToRedirect = "memberinvoice";
		if (getITRInitData(request).isOnVendorPortal() && getITRInitData(request).isVendor(request)) {
			refIdToRedirect="vendor-memberinvoice";
		}
		String returnUrl = getRedirectURLForSiteMapItem(request, response, null, refIdToRedirect, getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		String notifyUrl = getRedirectURLForSiteMapItem(request, response, null,refIdToRedirect, getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		PaymentType paymentType = getPaymentType(request,((InvoicePaymentDetailBeanHandler) getChildBeanLifeCycleHandler(request)).isGatewayForm());
		if (paymentType == null) return false;
		InvoiceDocument invDoc = (InvoiceDocument) getITRInitData(request).getParentBean(); 
		//String returnUrl = "http://www.wealth4india/site/blah";
		//FinancialYear fy = FinancialYear.getByDisplayName(personalInformation.getFinancialYear());
		if(paymentType.equals(PaymentType.NET_BANKING)){
			String email =  getITRInitData(request).getFormMap().getField("email").getValue();
			String lastName = getITRInitData(request).getFormMap().getField("lastName").getValue();
			String firstName = getITRInitData(request).getFormMap().getField("firstName").getValue();
			String bilingAddress = getITRInitData(request).getFormMap().getField("bilingAddress").getValue();
			String pi_townCity = getITRInitData(request).getFormMap().getField("pi_townCity").getValue();
			String pi_state = getITRInitData(request).getFormMap().getField("pi_state").getValue();
			String pi_pinCode = getITRInitData(request).getFormMap().getField("pi_pinCode").getValue();
			String pi_mobile = getITRInitData(request).getFormMap().getField("pi_mobile").getValue();
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
					request.setAttribute("paymentRedirectURL", paymentRedirectURL);
				}else {
					getITRInitData(request).getFormMap().addMessage("error.gateway.connection", "true");
				}
			}
		}
		if(paymentType.equals(PaymentType.CREDIT_CARD) || paymentType.equals(PaymentType.DEBIT_CARD)){
			//String cardHolderName = getITRInitData(request).getFormMap().getField("cardHolderName").getValue();
			//String expiryMonth = getITRInitData(request).getFormMap().getField("expiryMonth").getValue();
			//String expiryYear = getITRInitData(request).getFormMap().getField("expiryYear").getValue();
			//String cvvNumber = getITRInitData(request).getFormMap().getField("cvvNumber").getValue();
			//String cardNumber = getITRInitData(request).getFormMap().getField("cardNumber").getValue();
			//String cardType = getITRInitData(request).getFormMap().getField("cardType").getValue();
			String strTransactionId = ((InvoicePaymentDetailBeanHandler) getChildBeanLifeCycleHandler(request)).getStrPaymentTransactionId();
			//we need to ensure that it never comes HERE unless a record is created otherwise we are running into serious issues
			//this must exist in the InvoiceDocument as a valid PaymentID

			com.opus.epg.sfa.java.BillToAddress oBTA 	= new com.opus.epg.sfa.java.BillToAddress();
			com.opus.epg.sfa.java.ShipToAddress oSTA 	= new com.opus.epg.sfa.java.ShipToAddress();
			com.opus.epg.sfa.java.Merchant oMerchant 	= new com.opus.epg.sfa.java.Merchant();
			com.opus.epg.sfa.java.MPIData oMPI 		= new com.opus.epg.sfa.java.MPIData();
			com.opus.epg.sfa.java.CardInfo oCI 		= new com.opus.epg.sfa.java.CardInfo();

			com.opus.epg.sfa.java.PostLib oPostLib = null;
			try {
				oPostLib = new com.opus.epg.sfa.java.PostLib();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			com.opus.epg.sfa.java.PGReserveData oPGReserveData	= new com.opus.epg.sfa.java.PGReserveData();

			com.opus.epg.sfa.java.CustomerDetails oCustomer = new com.opus.epg.sfa.java.CustomerDetails ();
			com.opus.epg.sfa.java.MerchanDise oMerchanDise = new com.opus.epg.sfa.java.MerchanDise();
			com.opus.epg.sfa.java.SessionDetail oSessionDetail = new com.opus.epg.sfa.java.SessionDetail();
			com.opus.epg.sfa.java.Address oHomeAddress =new com.opus.epg.sfa.java.Address();
			com.opus.epg.sfa.java.Address oOfficeAddress =new com.opus.epg.sfa.java.Address();
			com.opus.epg.sfa.java.AirLineTransaction oAirLineTrans= new com.opus.epg.sfa.java.AirLineTransaction();
			
			ITReturnInitData itrInitData = getITRInitData(request);
			String reserve1 = itrInitData.getTheFolderContainingITRDocuments();
			String reserve2 = itrInitData.getUserName() + "-" + itrInitData.getPAN();
			String reserve3 = memberPersonalInformation.getSelectedITRForm().getDisplayName() + "-" + memberPersonalInformation.getReturnType() + "-" +  memberPersonalInformation.getReturnSection();
			
			oMerchant.setMerchantDetails(
					 getTransaction().getPaysealMerchantId()
					,getTransaction().getPaysealMerchantId()
					,getTransaction().getPaysealMerchantId()
					,request.getRemoteAddr()
					,strTransactionId
					,strTransactionId
					//, "http://10.10.10.6/RailwayTicketing/PGResponse.asp"
					,returnUrl
					, "POST"
					,"INR"
					,invDoc.getInvoiceNumber()						
					,"req.Sale"
					, invDoc.getAmountDue().toString()	
					, IndianGregorianCalendar.getCurrentDateInIndiaAsDate().getTimeZone().getID()
					, reserve1
					, reserve2
					, reserve3
					, reserve3
					, "JAVA"
					);


			/*
			oBTA.setAddressDetails(
					memberPersonalInformation.getCanonicalHandleUUID()
					,memberPersonalInformation.getName()
					,memberPersonalInformation.getFlatDoorBuilding()
					,memberPersonalInformation.getAreaLocality()
					,memberPersonalInformation.getRoadStreet()
					,memberPersonalInformation.getTownCityDistrict()
					,memberPersonalInformation.getState()
					,memberPersonalInformation.getPinCode()
					,"IND"
					,memberPersonalInformation.getEmail()
					);
			*/
			/*
			oSTA.setAddressDetails(
					memberPersonalInformation.getFlatDoorBuilding()
					,memberPersonalInformation.getAreaLocality()
					,memberPersonalInformation.getRoadStreet()
					,memberPersonalInformation.getTownCityDistrict()
					,memberPersonalInformation.getState()
					,memberPersonalInformation.getPinCode()
					,"IND"
					,memberPersonalInformation.getEmail()
					);
			*/
			
//			oMPI.setMPIRequestDetails(
//					invDoc.getAmountDue().toString()	 //mstrPurchaseAmount
//					,"INR" + invDoc.getAmountDue().toString()	//mstrDisplayAmount
//					,"1", //mstrCurrencyVal
//					"1" //mstrExponent
//					,"eFile ITReturn" //mstrOrderDesc
//					,"0" //mstrRecurFreq
//					,"0" //mstrRecurEnd
//					,"0" //mstrInstallment
//					,"0" //mstrDeviceCategory
//					,"" //mstrWhatIUse
//					,request.getHeader("accept") //,"image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/vnd.ms-powerpoint, application/vnd.ms-excel, application/msword, application/x-shockwave-flash, */*" //mstrAcceptHdr
//					,request.getHeader("user-agent") //"Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)" //mstrAgentHdr
//					); 
			/*
			oHomeAddress.setAddressDetails(
					memberPersonalInformation.getFlatDoorBuilding()
					,memberPersonalInformation.getAreaLocality()
					,memberPersonalInformation.getRoadStreet()
					,memberPersonalInformation.getTownCityDistrict()
					,memberPersonalInformation.getState()
					,memberPersonalInformation.getPinCode()
					,"IND"
					,memberPersonalInformation.getEmail()
					);

			oOfficeAddress.setAddressDetails(
					memberPersonalInformation.getFlatDoorBuilding()
					,memberPersonalInformation.getAreaLocality()
					,memberPersonalInformation.getRoadStreet()
					,memberPersonalInformation.getTownCityDistrict()
					,memberPersonalInformation.getState()
					,memberPersonalInformation.getPinCode()
					,"IND"
					,memberPersonalInformation.getEmail()
					);
			*/
			oCustomer.setCustomerDetails(
					memberPersonalInformation.getFirstName(), // first name 
					memberPersonalInformation.getLastName(), //last name
					oOfficeAddress,
					oHomeAddress,
					memberPersonalInformation.getMobile(),//mobile number
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


			oMerchanDise.setMerchanDiseDetails(
					memberPersonalInformation.getSelectedITRForm().name(),
					"1", //mstrQuantity
					getITRInitData(request).getResellerId(),
					"", //mstrModelNumber
					memberPersonalInformation.getName(), //buyers name
					"Y" //Buyername and Card name match.
					);


			/*
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
			 */

			//PGResponse oPGResponse = oPostLib.postSSL(oBTA,oSTA,oMerchant,oMPI,response,oPGReserveData,null,null,null,null);
			PGResponse oPGResponse = oPostLib.postSSL(oBTA,oSTA,oMerchant,oMPI,response,oPGReserveData,oCustomer,oSessionDetail,oAirLineTrans,null);
			if(oPGResponse.getRedirectionUrl() != null) {
				try {
					BeanInfo bi = Introspector.getBeanInfo(oPGResponse.getClass());
					if (formMap == null) formMap = new FormMap();
					for(PropertyDescriptor property : bi.getPropertyDescriptors()) {
						Method aReadMethod = property.getReadMethod();
						Object theValue =  aReadMethod.invoke(oPGResponse);
						if (theValue != null && theValue instanceof String) {
							String newFieldName = "str" + WordUtils.capitalize(property.getName()); // some how the stupid ICICI has done a crappy job of field names
							FormField formField  = new FormField( newFieldName ); 
							formField.addValue((String)theValue);
							formMap.addFormField(formField);
						}
						//Object theValue = directFieldAccessorSrc.getPropertyValue(property.getName());
						//directFieldAccessorDest.setPropertyValue(property.getName(), theValue);
					}	
				} catch (IntrospectionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String strRedirectionURL = oPGResponse.getRedirectionUrl();
				request.setAttribute("paymentRedirectURL", strRedirectionURL);
				/*
					try {
						response.sendRedirect(strRedirectionURL);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 */

			}
			else {
				System.out.println("Error encountered. Error Code : " +oPGResponse.getRespCode() + " . Message " +  oPGResponse.getRespMessage());
				getITRInitData(request).getFormMap().addMessage("error.gateway.connection", "true");
			}


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

	private PaymentType getPaymentType(HstRequest request,boolean isGatewayForm) {
		PaymentType paymentType = null;
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr == null) {
			PAGE_ACTION pageAction  = getITRInitData(request).getPageAction();
			if (pageAction == PAGE_ACTION.EDIT_CHILD ) {
				HippoBean theChildBean = getITRInitData(request).getChildBean();
				if (theChildBean != null && theChildBean instanceof InvoicePaymentDetail) {
					InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) getITRInitData(request).getChildBean();
					PaymentType paymentType2 = invoicePaymentDetail.getPaymentType();
					paymentTypeStr = paymentType2.name();
				}
				if (log.isInfoEnabled()) {
					log.info("theChildBean is " + theChildBean);
				}
			}
		}
		if (isGatewayForm && paymentTypeStr == null) {
			paymentTypeStr = getPublicRequestParameter(request,"paymentType");
		}
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		return paymentType;
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
