/**
 * Copyright (C) 2010-2011 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.components;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.component.support.forms.StoreFormResult;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RegExValidationFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.annotations.SyncInvoiceWithCitrus;
import com.mootly.wcm.beans.CompoundChildUpdate;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScreenCalculation;
import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.beans.TwentySixASSecQuesDocument;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.components.ITReturnScreen.PAGE_OUTPUT_FORMAT;
import com.mootly.wcm.model.FilingSection;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.ValidationResponse;
import com.mootly.wcm.model.VerificationStatus;
import com.mootly.wcm.services.DownloadConfirmationRequiredException;
import com.mootly.wcm.services.ITRScreenXmlValidateServiceImpl;
import com.mootly.wcm.services.ITRXmlGeneratorServiceFactory;
import com.mootly.wcm.services.InvalidXMLException;
import com.mootly.wcm.services.PaymentRequiredException;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.services.ScreenConfigService;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.StartApplicationValidationService;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.services.citruspay.Enquiry;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.ditws.AddClientDetails;
import com.mootly.wcm.services.ditws.ITRVStatus;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.RetrieveRectificationStatus;
import com.mootly.wcm.services.ditws.RetrieveRefundStatus;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;
import com.mootly.wcm.services.ditws.model.RetrieveRectificationResponse;
import com.mootly.wcm.services.ditws.model.RetrieveRefundResponse;
import com.mootly.wcm.services.efile.EFileResponse;
import com.mootly.wcm.services.efile.exception.DigtalSignatureAssesseeFailure;
import com.mootly.wcm.services.efile.exception.DigtalSignatureERIUserFailure;
import com.mootly.wcm.services.efile.exception.EFileException;
import com.mootly.wcm.utils.MootlyFormUtils;
import com.mootly.wcm.utils.XmlCalculation;
import com.mootly.wcm.validation.HippoBeanValidationGeneric;
import com.mootly.wcm.validation.HippoBeanValidationGeneric.ACTION;
import com.mootly.wcm.validation.HippoBeanValidationGeneric.TYPE;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.RepositoryUpdateRequest;
import com.mootly.wcm.validation.impl.itr.ITRValidatorChain;
import com.mootly.wcm.view.PaymentUpdateResponse;

public class ITReturnComponent extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ITReturnComponent.class);
	ITRXmlGeneratorServiceFactory itrXmlGeneratorServiceFactory = null;
	ITRValidatorChain itrValidationChain = null;
	RetrieveITRV retrieveITRVService = null;
	Retrieve26ASInformation retrieve26ASService = null;
	RetrievePANInformation retrievePANInformation = null;
	AddClientDetails addClientDetailsService = null;
	RetrieveRectificationStatus retrieveRectificationStatus = null;
	RetrieveRefundStatus retrieveRefundStatus = null;
	String servletPath = null;
	String xsltPath = null;
	SequenceGenerator sequenceGenerator = null;
	RetrievePANResponse retrievePANResponse = null;
	Transaction transaction = null;
	Enquiry enquiry =	null;
	
	
	

	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		itrXmlGeneratorServiceFactory = context.getBean(com.mootly.wcm.services.ITRXmlGeneratorServiceFactory.class);
		
		xsltPath = servletContext.getRealPath("/xslt/ITRSummary.xsl");
		itrValidationChain =  context.getBean(ITRValidatorChain.class);
		retrievePANInformation = context.getBean(RetrievePANInformation.class);
		retrieveITRVService = context.getBean(RetrieveITRV.class);
		retrieve26ASService = context.getBean(Retrieve26ASInformation.class);
		transaction = context.getBean(Transaction.class);
		enquiry =	context.getBean(Enquiry.class);
		
		retrieveRectificationStatus = context.getBean(RetrieveRectificationStatus.class);
		retrieveRefundStatus = context.getBean(RetrieveRefundStatus.class);
		
		addClientDetailsService = context.getBean(AddClientDetails.class);
	}


	public final Retrieve26ASInformation getRetrieve26ASService() {
		return retrieve26ASService;
	}

	public RetrieveITRV getRetrieveITRVService() {
		return retrieveITRVService;
	}

	public ITReturnComponentHelper getITReturnComponentHelper() {
		return itReturnComponentHelper;
	}

	public RetrievePANInformation getRetrievePANInformationService() {
		return retrievePANInformation;
	}
	
	public ITRValidatorChain getItrValidationChain() {
		return itrValidationChain;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public Enquiry getEnquiry() {
		return enquiry;
	}
	
	public AddClientDetails getAddClientDetailsService() {
		return addClientDetailsService;
	}
	
	public RetrieveRefundStatus getRetrieveRefundStatus() {
		return retrieveRefundStatus;
	}
	
	public RetrieveRectificationStatus getRetrieveRectificationStatus() {
		return retrieveRectificationStatus;
	}

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		//Map<String, String> mapOfComponents  = HstServices.getComponentManager().getComponentsOfType(String.class);
		boolean isFrozen = false;
		
		String isCalc = getPublicRequestParameter (request,"command");
		//String screen=getPublicRequestParameter(request, "screen");
		if (isCalc == null) {
			//if (!hasInitComplete) {
			try {
				fillDueDate(request,response); //this will fill the due date
				HippoBeanValidationResponse hippoBeanValidationResponse = executeValidationChain(request,response);
				if (hippoBeanValidationResponse != null) {
					HippoBeanValidationGeneric freezeIncomeTaxAction = hippoBeanValidationResponse.getAction(ACTION.FREEZE_INCOMETAX_RETURN) ;
					if (hippoBeanValidationResponse != null && hippoBeanValidationResponse.getAction(ACTION.FREEZE_INCOMETAX_RETURN) != null) {
						isFrozen = true;
						request.setAttribute("freezeIncomeTaxAction", freezeIncomeTaxAction);
						request.setAttribute("freezeIncomeTaxActionReason", freezeIncomeTaxAction.getActionReason().name());
						request.setAttribute("isFrozen", isFrozen);
						request.setAttribute("ackResponse", hippoBeanValidationResponse.getMessageByKey("ackResponse", TYPE.INFORMATION) );
						request.setAttribute("tokenNumber", hippoBeanValidationResponse.getMessageByKey("tokenNumber", TYPE.INFORMATION) );
						request.setAttribute("eFileDateTime", hippoBeanValidationResponse.getMessageByKey("eFileDateTime", TYPE.INFORMATION) );
					}
					//check if this action is not restricted
					if (hippoBeanValidationResponse.getRestrictedActions() != null && getITRInitData(request).getPageAction() != null &&  hippoBeanValidationResponse.getRestrictedActions().contains(getITRInitData(request).getPageAction()) ) {
						response.setRenderPath("jsp/errorpages/restrictedaction.jsp");
						return;
					}
					if (hippoBeanValidationResponse.getRestrictedComponents() != null &&  hippoBeanValidationResponse.getRestrictedComponents().contains(getClass()) ) {
						response.setRenderPath("jsp/errorpages/restrictedaction.jsp");
						return;
					}
				}
			}			
			catch (Exception ex) {
				log.error("Error in initializing component. FATAL",ex);
				redirectToNotFoundPage(response);
				return;
			}
		}
		
		//what if memberpersonal information is not saved and user is trying to use any other URL, we should not allow except QA
		String redirectURL = null;
		boolean isDITVerified = false;
		String currentRefId = request.getRequestContext().getResolvedSiteMapItem().getHstSiteMapItem().getRefId();
		String memberService = request.getRequestContext().getResolvedSiteMapItem().getParameter("memberService");
		if ( memberService != null && "itreturn".equals(memberService) && (currentRefId != null && !currentRefId.equals("servicerequest-itr") ) && !getITRInitData(request).isOnVendorPortal()) {
			redirectURL = getRedirectURLForSiteMapItem(request,response,null,"servicerequest-itr",getITRInitData(request).getFinancialYear(),getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
			WebsiteInfo webSiteInfo = request.getRequestContext().getResolvedMount().getMount().getChannelInfo();
			if ( webSiteInfo != null && webSiteInfo.getAllowUnverifiedUsers() != null && "false".equals(webSiteInfo.getAllowUnverifiedUsers())) {
				MemberPersonalInformation  memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
				if (memberPersonalInformation != null && memberPersonalInformation.getDitVerificationStatus() != null && memberPersonalInformation.getDitVerificationStatus() == VerificationStatus.VERIFIED) {
					isDITVerified = true;
				}
				if ( memberPersonalInformation != null && !isDITVerified ) {
					//redirect user to 
					try {
						response.sendRedirect(redirectURL);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						log.error("Error in redirection",e);
					}
					return;
				}
			}
		}
	
		String redirectToAfterEFile = getRedirectURLForSiteMapItem(request, response, null, (  (getITRInitData(request).isVendor(request) && getITRInitData(request).isOnVendorPortal()) ? "vendor-efile-confirmation" : "efile-confirmation"), getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		if (isFrozen && getITRInitData(request).pageAction == PAGE_ACTION.EFILE) {
			try {
				response.sendRedirect(redirectToAfterEFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
	//	hasInitComplete = true;
	//}
		if (getITRInitData(request).getPAN() != null && (getITRInitData(request).filingStatus == null || getITRInitData(request).filingStatus.equals(FilingStatus.UNKNOWN))) {
			log.error("Unknown Filing status for PAN:" + getITRInitData(request).getPAN());
			response.setRenderPath("jsp/security/invalidpan.jsp");
			return;
		}

		if (getITRInitData(request).pageAction == PAGE_ACTION.NEW_CHILD && request.getAttribute("NEW_CHILD_DISABLED") != null) {
			log.error("User attempting to over ride the maxAllowedChildren parameter");
			response.setRenderPath("jsp/security/invalidoperation.jsp");
			return;
		}
		
		//lets try to load the SCreen Configuration Document for this component
		String pathToScreenConfig = "configuration/screenconfigs/" + this.getClass().getSimpleName().toLowerCase();
		ScreenConfigDocument screenConfigDocument = getITRInitData(request).siteContentBaseBean.getBean(pathToScreenConfig, ScreenConfigDocument.class);
		if (screenConfigDocument != null) {
			if (log.isInfoEnabled()){
				log.info("screenConfigDocument:" + screenConfigDocument.toString());
			}
			request.setAttribute("screenConfigDocument",screenConfigDocument);
			String screenConfigDocumentJSON = ScreenConfigService.generateJSON(screenConfigDocument);
			if (screenConfigDocumentJSON != null) {
				request.setAttribute("screenConfigDocumentJSON", screenConfigDocumentJSON);
			}
		}
		//Screen Calculation Configuration
		//String isCalc = getPublicRequestParameter (request,"command");
		String screen=getPublicRequestParameter(request, "screen");
		if (isCalc != null && isCalc.equals("calc") && screen!=null) {
			log.info("We are Requesting fot this "+screen+" Screen");
			String pathToScreenCalc = "configuration/screencalculation/" + screen.toLowerCase();
			ScreenCalculation screencalc= getSiteContentBaseBean(request).getBean(pathToScreenCalc, ScreenCalculation.class);
			// for screen calcualtions.......
			Map<String,Object> additionalParameters= new HashMap<String,Object>();
			MemberPersonalInformation objMemberInfo= (MemberPersonalInformation) request.getAttribute("memberpersonalinformation");
			if(objMemberInfo != null){
				additionalParameters.put("IsSeniorCitizen",getITRInitData(request).getFinancialYear().isSeniorCitizen(objMemberInfo.getDOB().getTime()));
				if(getITRInitData(request).getFinancialYear().isSeniorCitizen(objMemberInfo.getDOB().getTime())){
					additionalParameters.put("cbasscategory","Senior Citizen");
				}else{
					additionalParameters.put("cbasscategory",objMemberInfo.getSex());
				}
				additionalParameters.put("objMemberInfo",objMemberInfo);
				additionalParameters.put("cbresistatus",objMemberInfo.getResidentCategory());
				additionalParameters.put("cbassyear",getITRInitData(request).getAssessmentYear());
				additionalParameters.put("cbasstype",objMemberInfo.getFilingStatus());

				XmlCalculation objXmlCalc= new XmlCalculation ();
				additionalParameters.put("txtNetIndianIncome",objXmlCalc.grossTotal(request, response));
			}
			Map<String,Object> resultSet = ScreenCalculatorService.getScreenCalculations(screencalc.getScript(), request.getParameterMap(""), additionalParameters);
			if (resultSet != null) {
				request.setAttribute("resultSet", resultSet);
				JSONObject jsonObject  = new JSONObject(resultSet);
				request.setAttribute("jsonObject", jsonObject);
				//response.setContentType("application/json");
				response.setRenderPath("jsp/common/calculation_response.jsp");
			}
		}
		

		//check if invoice refresh is 
		boolean didGotUpdated = false;
		if (this.getClass().isAnnotationPresent(SyncInvoiceWithCitrus.class)) {
			didGotUpdated = updateInvoice(request);
			request.setAttribute("didInvoiceGotUpdated", didGotUpdated);
			if (didGotUpdated) {

			}
		}
		
		if (getClass().isAnnotationPresent(FormFields.class)) {
			FormFields formFields = this.getClass().getAnnotation(FormFields.class);
			String[] vendorFields = formFields.fieldNamesVendorOnly();
			String[] theFieldsArray = formFields.fieldNames();
			if (getITRInitData(request).isVendor(request) && vendorFields != null && vendorFields.length > 0){
				theFieldsArray = (String[]) ArrayUtils.addAll(theFieldsArray, vendorFields);
			}
			FormMap formMap = new FormMap(request,theFieldsArray);
			FormUtils.populate(request, formMap);
			FormField aPan = formMap.getField("pan");
			if (aPan != null) {
				log.info(aPan.getValue());
			}
			if (formMap != null && formMap.getMessage() != null && formMap.getMessage().size() > 0) {
				request.setAttribute("formMap", formMap);
				if (getITRInitData(request).pageAction.equals(PAGE_ACTION.NEW_CHILD) || getITRInitData(request).pageAction.equals(PAGE_ACTION.EDIT_CHILD)) {
					if (this.getClass().isAnnotationPresent(ChildBean.class)) {
						HippoBean childBean = null;
						try {
							childBean = this.getClass().getAnnotation(ChildBean.class).childBeanClass().newInstance();
							if (childBean instanceof FormMapFiller) {
								((FormMapFiller) childBean).fill(formMap);
								request.setAttribute("childBean", childBean);
							}
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else if (getITRInitData(request).pageAction.equals(PAGE_ACTION.EDIT) || getITRInitData(request).pageAction.equals(PAGE_ACTION.NEW)) {
					if (this.getClass().isAnnotationPresent(PrimaryBean.class)) {
						HippoBean childBean = null;
						try {
							getITRInitData(request).parentBean = this.getClass().getAnnotation(PrimaryBean.class).primaryBeanClass().newInstance();
							if (getITRInitData(request).parentBean instanceof FormMapFiller) {
								((FormMapFiller) getITRInitData(request).parentBean).fill(formMap);
								request.setAttribute("parentBean", getITRInitData(request).parentBean);
							}
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				request.setAttribute("error","true");
			}
			
			if (getITRInitData(request).pageAction.equals(PAGE_ACTION.DELETE) || getITRInitData(request).pageAction.equals(PAGE_ACTION.DELETE_CHILD)) {
				try {
					save(request,formMap);
				}catch (Exception e) {
					throw new HstComponentException(e);
				}
				//initComponent(request);
				try {
					String urlToRedirect = getITRInitData(request).getScriptName(); //getRedirectURL(request,response,FormSaveResult.SUCCESS);
					if (log.isInfoEnabled()) {
						log.info(urlToRedirect + ":" + urlToRedirect);
					}
					//if (request.getAttribute("selectedItrTab") != null) {
					//response.setRenderParameter("selectedItrTab", ((ITRTab)request.getAttribute("selectedItrTab")).name());
					//urlToRedirect += "?selectedItrTab=" +  ((ITRTab)request.getAttribute("selectedItrTab")).name();
					//	}
				
					response.sendRedirect( urlToRedirect );
					//response.sendRedirect(redirectURL);
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error("Error in redirection",e);
				}
			}
		}
		/** This check is required for all screens except for Personal Information Screen */
		RequiredBeans requiredBeans = this.getClass().getAnnotation(RequiredBeans.class);
		if (requiredBeans != null) {
			Class<? extends HippoBean>[] requiredBeansList = requiredBeans.requiredBeans();
			if (requiredBeansList!= null && requiredBeansList.length > 0) {
				for (Class<? extends HippoBean> aBean:requiredBeansList) {
					if (request.getAttribute(aBean.getSimpleName().toLowerCase()) == null) {
						redirectToNotFoundPage(response);
					}
				}
			}
		}
		/** Validate XML According to Compulsory Screen that need to be Filled Before download **/
		if (getITRInitData(request).pageAction != null && (getITRInitData(request).pageAction.equals(PAGE_ACTION.EFILE) || getITRInitData(request).pageAction.equals(PAGE_ACTION.DOWNLOAD_ITR_SUMMARY) || getITRInitData(request).pageAction.equals(PAGE_ACTION.DOWNLOAD_ITR_XML) || getITRInitData(request).pageAction.equals(PAGE_ACTION.EMAIL_ITR_XML_AND_SUMMARY)) ) {
			ITRScreenXmlValidateServiceImpl iTRScreenXmlValidateServiceImpl = new ITRScreenXmlValidateServiceImpl();
			iTRScreenXmlValidateServiceImpl.getValidateXmlBasedOnReqScreen(request, response);
		}
		String redirectToIfPaymentNotFound = getRedirectURLForSiteMapItem(request, response, null,(  (getITRInitData(request).isVendor(request) && getITRInitData(request).isOnVendorPortal()) ? "vendor-memberinvoice" : "memberinvoice"), getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		String redirectToIfConfirmationNotFound = getRedirectURLForSiteMapItem(request, response, null, (  (getITRInitData(request).isVendor(request) && getITRInitData(request).isOnVendorPortal()) ? "vendor-servicerequest-itr-tos-confirmation" : "servicerequest-itr-tos-confirmation"), getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		//String redirectToAfterEFile = getRedirectURLForSiteMapItem(request, response, null, (  (isVendor(request) && isOnVendorPortal()) ? "vendor-efile-confirmation" : "efile-confirmation"), getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		if (getITRInitData(request).pageAction != null && (getITRInitData(request).pageAction.equals(PAGE_ACTION.EFILE) || getITRInitData(request).pageAction.equals(PAGE_ACTION.SHOW_ITR_SUMMARY) || getITRInitData(request).pageAction.equals(PAGE_ACTION.DOWNLOAD_ITR_SUMMARY) || getITRInitData(request).pageAction.equals(PAGE_ACTION.DOWNLOAD_ITR_XML) || getITRInitData(request).pageAction.equals(PAGE_ACTION.EMAIL_ITR_XML_AND_SUMMARY)) ) {
			try {
				handleITRSummary(request,response);
			}catch (InvalidXMLException invalidXml) {
				FormMap formMap = new FormMap();//(request,new String[] {"xml","isValid","errors","financialYear"});
				FormField formFieldXml = new FormField("xml");
				FormField formFieldFinancialYear = new FormField("financialYear");

				FormField formFieldPan = new FormField("PAN");
				formFieldPan.addValue(getITRInitData(request).getPAN());
				FormField formFieldFilingStatus = new FormField("itReturnType");
				formFieldFilingStatus.addValue(getITRInitData(request).getITReturnType().name());

				FormField formFieldTheFolderContainingITRDocuments = new FormField("theFolderContainingITRDocuments");
				formFieldFilingStatus.addValue(getITRInitData(request).getTheFolderContainingITRDocuments());


				FormField formFieldReason = new FormField("reason");
				formFieldReason.addValue("Invalid Return");

				ValidationResponse validationResponse = invalidXml.getValidationResponse();
				formFieldXml.addValue(validationResponse.getXml());
				formFieldFinancialYear.addValue(getITRInitData(request).getFinancialYear().getDisplayName());

				formMap.addFormField(formFieldXml);
				formMap.addFormField(formFieldFinancialYear);
				formMap.addFormField(formFieldTheFolderContainingITRDocuments);

				//07/23/2013
				FormField formFieldIsValid = new FormField("isValid");
				formFieldIsValid.addValue(String.valueOf(validationResponse.isValid()));
				FormField formFieldErrors = new FormField("errors");
				formFieldErrors.addValue(String.valueOf(validationResponse.getErrors()));
				formMap.addFormField(formFieldIsValid);
				formMap.addFormField(formFieldErrors);
				//end changes

				StoreFormResult sfr = new StoreFormResult();
				FormUtils.persistFormMap(request, response, formMap, sfr);
				try {
					response.sendRedirect(request.getContextPath() + "/services/itr-validate-xml.html?uuid=" + sfr.getUuid());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error("Error in validating XML",e);
					e.printStackTrace();
				}
				return;
				//response.setRenderPath("jsp/member/invalidxml.jsp");
			} catch (PaymentRequiredException e) {
				// TODO Auto-generated catch block
				try {
					response.sendRedirect(redirectToIfPaymentNotFound);
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					log.error("Error in validating XML",ex);
					ex.printStackTrace();
				}
				return;
			} catch (DownloadConfirmationRequiredException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				String uuidOfSavedForm = e.getUuidOfSavedForm();
				try {
					response.sendRedirect(redirectToIfConfirmationNotFound + "?uuid=" + uuidOfSavedForm);
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					log.error("Error in validating XML",ex);
					ex.printStackTrace();
				}
				return;
			} catch (EFileException e) {
				log.error("Error in eFiling",e);
				//String uuidOfSavedForm = e.getUuidOfSavedForm();
				try {
					response.sendRedirect(redirectToAfterEFile);
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					log.error("Error in validating XML",ex);
					ex.printStackTrace();
				}
				return;
			} catch (DigtalSignatureAssesseeFailure e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Error in validating XML",e);
				try {
					response.sendRedirect(redirectToAfterEFile);
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					log.error("Error in validating XML",ex);
					ex.printStackTrace();
				}
				return;
			} catch (DigtalSignatureERIUserFailure e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Error in validating XML",e);
				try {
					response.sendRedirect(redirectToAfterEFile);
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					log.error("Error in validating XML",ex);
					ex.printStackTrace();
				}
				return;
			}
		}
		//new code for bulk
		if (getITRInitData(request).pageAction != null && getITRInitData(request).pageAction == PAGE_ACTION.EFILE) {
			//add and then redirect back to the page
			try {
				response.sendRedirect(redirectToAfterEFile);
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				log.error("Error in validating XML",ex);
				ex.printStackTrace();
			}
			return;
		}
		//new code for bulk
		if (getITRInitData(request).pageAction != null && getITRInitData(request).pageAction == PAGE_ACTION.DOWNLOAD_ITR_XML_BULK_ADD_TO_SESSION) {
			//add and then redirect back to the page
			HttpSession session = request.getSession(true);
			List<String> listOfPaths = (List<String>) session.getAttribute("bulk_download_xml_paths");
			if (listOfPaths == null) {
				listOfPaths = new ArrayList<String>();
			}
			listOfPaths.add(getITRInitData(request).baseRelPathToReturnDocuments);
			session.setAttribute("bulk_download_xml_paths", listOfPaths);
			String referer = request.getHeader("REFERER");
			if (referer != null) {
				try {
					response.sendRedirect(referer);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return;
		}
		if (getITRInitData(request).pageAction != null && getITRInitData(request).pageAction == PAGE_ACTION.DOWNLOAD_ITR_XML_BULK) {
			List<String> listOfPath = (List<String>) request.getSession().getAttribute("bulk_download_xml_paths");
			String[] theNewArray =listOfPath.toArray(new String[listOfPath.size()]);
			try {
				generateBulkXml(request, response, theNewArray);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().removeAttribute("bulk_download_xml_paths");
		}
		//new functionality test connectivity with DIT this one doesn't need username password
		if (getITRInitData(request).pageAction != null && getITRInitData(request).pageAction == PAGE_ACTION.RETRIEVE_ITRV_STATUS) {
			if (retrieveITRVService != null) {
				try {
					
					Session	persistableSession=getPersistableSession(request);
					WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
					ITRVStatus itrvStatus = retrieveITRVService.retrieveITRVStatus(getITRInitData(request).getPAN(), getITRInitData(request).getFinancialYear().getAssessmentYearForDITSOAPCall(),getITRInitData(request).getAbsoluteBasePathToReturnDocuments(),wpm);
					request.setAttribute("itrvStatus", itrvStatus);
				} catch (MissingInformationException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-MissingInformationException",e);
					request.setAttribute("isError", "true");
				} catch (DataMismatchException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-DataMismatchException",e);
					request.setAttribute("isError", "true");
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-InvalidFormatException",e);
					request.setAttribute("isError", "true");
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-InvalidFormatException",e);
					request.setAttribute("isError", "true");
				}
			}
			else {
				request.setAttribute("isError", "true");
			}
			if (getITRInitData(request).getPageOutputFormat() != null && getITRInitData(request).getPageOutputFormat() == PAGE_OUTPUT_FORMAT.JSON) {
				response.setRenderPath("jsp/common/json_output.jsp");
			}
		}
		else if (getITRInitData(request).pageAction != null && getITRInitData(request).pageAction == PAGE_ACTION.RETRIEVE_REFUND_STATUS) {
			if (retrieveRefundStatus != null) {
				try {
					Session persistableSession = getPersistableSession(request);
					WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
					RetrieveRefundResponse retrieveRefundResponse  = retrieveRefundStatus.retrieveRefundStatus(getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEriUserId(), getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEriPassword(), getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEmailSignature(),  getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEriCertChain(), getITRInitData(request).getPAN(), getITRInitData(request).getFinancialYear().getAssessmentYearForDITSOAPCall(),getITRInitData(request).getAbsoluteBasePathToReturnDocuments(),wpm);
					request.setAttribute("retrieveRefundResponse", retrieveRefundResponse);
				} catch (MissingInformationException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-MissingInformationException",e);
					request.setAttribute("isError", "true");
				} catch (DataMismatchException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-DataMismatchException",e);
					request.setAttribute("isError", "true");
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-InvalidFormatException",e);
					request.setAttribute("isError", "true");
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-InvalidFormatException",e);
					request.setAttribute("isError", "true");
				}
			}
			else {
				request.setAttribute("isError", "true");
			}
			if (getITRInitData(request).getPageOutputFormat() != null && getITRInitData(request).getPageOutputFormat() == PAGE_OUTPUT_FORMAT.JSON) {
				response.setRenderPath("jsp/common/json_output.jsp");
			}
		}
		else if (getITRInitData(request).pageAction != null && getITRInitData(request).pageAction == PAGE_ACTION.RETRIEVE_RECTIFICATION_STATUS) {
			if (retrieveITRVService != null) {
				try {
					Session persistableSession = getPersistableSession(request);
					WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
					RetrieveRectificationResponse retrieveRectificationResponse = retrieveRectificationStatus.retrieveRectificationStatus(getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEriUserId(), getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEriPassword(), getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEmailSignature(),  getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEriCertChain(), getITRInitData(request).getPAN(), getITRInitData(request).getFinancialYear().getAssessmentYearForDITSOAPCall(),getITRInitData(request).getAbsoluteBasePathToReturnDocuments(),wpm);
					request.setAttribute("retrieveRectificationResponse", retrieveRectificationResponse);
				} catch (MissingInformationException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-MissingInformationException",e);
					request.setAttribute("isError", "true");
				} catch (DataMismatchException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-DataMismatchException",e);
					request.setAttribute("isError", "true");
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					log.error("Error in RetrieveITRVStatus-InvalidFormatException",e);
					request.setAttribute("isError", "true");
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					log.error("RepositoryException",e);
				}
			}
			else {
				request.setAttribute("isError", "true");
			}
			if (getITRInitData(request).getPageOutputFormat() != null && getITRInitData(request).getPageOutputFormat() == PAGE_OUTPUT_FORMAT.JSON) {
				response.setRenderPath("jsp/common/json_output.jsp");
			}
		}
		if (getITRInitData(request).getIs26ASImportEnabled()) {
			request.setAttribute("is26ASImportEnabled", getITRInitData(request).getIs26ASImportEnabled());
		}
		//Check of 26AS security Question
		/*
		if (getITRInitData(request).pageAction != null && getITRInitData(request).pageAction == PAGE_ACTION.SYNC_TDS_FROM_DIT){
			TwentySixASSecQuesDocument twentySixASSecQuesDocument= (TwentySixASSecQuesDocument) request.getAttribute("twentysixassecquesdocument");
			if(twentySixASSecQuesDocument == null || (twentySixASSecQuesDocument != null && twentySixASSecQuesDocument.getSecurityCheck()==false)){
				String urlToSecQues = getRedirectURLForSiteMapItem(request, response, null, "servicerequest-itr-sync-tds-security", getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
				try {
					response.sendRedirect(urlToSecQues);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		boolean isFrozen = false;
		try {
			fillDueDate(request,response); //this will fill the due date
			executeValidationChain(request,response);
			HippoBeanValidationResponse hippoBeanValidationResponse = executeValidationChain(request,response);
			if (hippoBeanValidationResponse != null && hippoBeanValidationResponse.getAction(ACTION.FREEZE_INCOMETAX_RETURN) != null) {
				isFrozen = true;
				request.setAttribute("isFrozen", isFrozen);
			}
		}			
		catch (Exception ex) {
			log.error("Error in initializing component. FATAL",ex);
			redirectToNotFoundPage(response);
			return;
		}
		if (isFrozen) {
			log.warn("Attempted Post when the Income Tax was FROZEN");
			return ;
		}
		FormFields formFields = this.getClass().getAnnotation(FormFields.class);
		String[] vendorFields = formFields.fieldNamesVendorOnly();
		String[] theFieldsArray = formFields.fieldNames();
		if (getITRInitData(request).isVendor(request) && vendorFields != null && vendorFields.length > 0){
			theFieldsArray = (String[]) ArrayUtils.addAll(theFieldsArray, vendorFields);
		}
		//if the child class wish to modify the fieldsArray let it do it 
		theFieldsArray = modifiedFieldsArray(request,theFieldsArray);
		
		getITRInitData(request).formMap = new FormMap(request,theFieldsArray);

		boolean isValid = validate(request,response,getITRInitData(request).formMap);
		if (!isValid) {
			log.info("Lets check result of validation:"+isValid);
			//this action is save
			return;
		}
		sanitize(request,response,getITRInitData(request).formMap);
		if (getITRInitData(request).pageAction.equals(PAGE_ACTION.EDIT) || getITRInitData(request).pageAction.equals(PAGE_ACTION.EDIT_CHILD) || getITRInitData(request).pageAction.equals(PAGE_ACTION.NEW_CHILD)) {
			if (log.isInfoEnabled()) {
				//if (getITRInitData(request).formMap != null) {
				//	for (String aFieldName:formFields.fieldNames()) {
				//		log.info("Field Name:" + aFieldName + " Value:" +  getITRInitData(request).formMap.getField(aFieldName).getValue());
				//	}
				//}
			}
			boolean saveResult = false;
			try {
				saveResult = save(request,getITRInitData(request).formMap);
			}catch (Exception e) {
				log.error ("Error in save",e);
				throw new HstComponentException(e);
			}
			if (!saveResult) return;
			afterSave(request,response,getITRInitData(request).formMap,getITRInitData(request).pageAction);
			try {
				if (getITRInitData(request).formMap.getMessage() != null && getITRInitData(request).formMap.getMessage().size() > 0 ) {
					String urlToRedirect = getITRInitData(request).getScriptName(); //getRedirectURL(request,response,FormSaveResult.FAILURE) ;
					if (log.isInfoEnabled()) {
						log.info("URLToRedirect:"+ urlToRedirect);
					}
					//if (request.getAttribute("selectedItrTab") != null) {
					//	response.setRenderParameter("selectedItrTab", ((ITRTab)request.getAttribute("selectedItrTab")).name());
					//	urlToRedirect += "?selectedItrTab=" +  ((ITRTab)request.getAttribute("selectedItrTab")).name();
					//}
					response.sendRedirect( urlToRedirect );
				}
				else {
					if (!shouldRedirectAfterSuccess(request)) return;
					String urlToRedirect = urlToRedirectAfterSuccess(request,response,getITRInitData(request).formMap) ;
					if (urlToRedirect == null) {
						urlToRedirect = getScriptName(request,response,FormSaveResult.SUCCESS); // getRedirectURL(request,response,FormSaveResult.SUCCESS) ;
					}
					//if the page passes a URL as a parameter take that into consideration\
					/*
					if (request.getParameter("successURL") != null) {
						urlToRedirect  = request.getParameter("successURL");
					}
					if (urlToRedirect != null) {
						if (urlToRedirect.contains("?")) {
							urlToRedirect = urlToRedirect + "&success=true";
						}
						else {
							urlToRedirect = urlToRedirect + "?success=true";
						}

					}
					log.info("URLToRedirect:"+ urlToRedirect);
					*/
					//	if (request.getAttribute("selectedItrTab") != null){
					//		response.setRenderParameter("selectedItrTab", ((ITRTab)request.getAttribute("selectedItrTab")).name());
					//		urlToRedirect += "?selectedItrTab=" +  ((ITRTab)request.getAttribute("selectedItrTab")).name();
					//	}
					response.sendRedirect( urlToRedirect );
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Error in redirection",e);
			}
		}
	}

	

	public String getScriptName(HstRequest request,HstResponse response, FormSaveResult formSaveResult) {
		// TODO Auto-generated method stub
		//String strShouldPostToSelf = request.getRequestContext().getResolvedSiteMapItem().getParameter("shouldPostToSelf");
		String strShouldPostToSummary = request.getRequestContext().getResolvedSiteMapItem().getParameter("shouldPostToSummary");
		//if (strShouldPostToSelf != null && strShouldPostToSelf.equals("true")) {
		//	return getITRInitData(request).scriptName;
		//}
		//else {
			if (formSaveResult == null || formSaveResult != FormSaveResult.SUCCESS) {
				return getITRInitData(request).scriptName;
			}
			else if (strShouldPostToSummary != null && "true".equals(strShouldPostToSummary)) {
				String redirectURL = null;
				if (getITRInitData(request).isVendor(request) && getITRInitData(request).isOnVendorPortal()) {
					redirectURL = getRedirectURLForSiteMapItem(request,response,formSaveResult,"vendor-servicerequest-itr-summary",getITRInitData(request).getFinancialYear(),getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
				}
				else {
					redirectURL = getRedirectURLForSiteMapItem(request,response,formSaveResult,"servicerequest-itr-summary",getITRInitData(request).getFinancialYear(),getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
				}
				return redirectURL;
			}
			else {
				return getITRInitData(request).scriptName;
			}
		//}
	}
	
	protected void sanitize(HstRequest request,HstResponse response,FormMap formMap) {
		//lets add the username into form map
		FormField formFieldLoggedInUser = null;
		if (formMap != null && request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null) {
			formFieldLoggedInUser = formMap.getField("formFieldLoggedInUser");
			if (formFieldLoggedInUser ==null) {
				formFieldLoggedInUser = new FormField("formFieldLoggedInUser");
				formFieldLoggedInUser.setName("formFieldLoggedInUser");
				formFieldLoggedInUser.addValue(request.getUserPrincipal().getName());
			}
		}
	}
	
	protected String[] modifiedFieldsArray(HstRequest request,String[] fieldsArray) {
		//do nothing let the child class do if it wants to otherwise lets return the same array
		return fieldsArray;
	}
	
	protected boolean validate(HstRequest request,HstResponse response,FormMap formMap) {
		//validate required fields first
		if (this.getClass().isAnnotationPresent(RequiredFields.class)) {
			RequiredFields requiredFieldsAnnotations = this.getClass().getAnnotation(RequiredFields.class);
			String[] fieldNames = requiredFieldsAnnotations.fieldNames();
			String[] additionalFieldNames = getRequiredFields(request);
			if (additionalFieldNames != null) {
				 List<String> both = new ArrayList<String>(fieldNames.length + additionalFieldNames.length);
				 Collections.addAll(both, fieldNames);
				 Collections.addAll(both, additionalFieldNames);
				 fieldNames = both.toArray(new String[both.size()]);
			}
			
			if (fieldNames != null && fieldNames.length > 0 ) {
				for (String aRequiredField:fieldNames) {
					if (formMap.getField(aRequiredField) == null) {
						formMap.addMessage(aRequiredField, "err.required." + aRequiredField);
						continue;
					}
					if (StringUtils.isEmpty( formMap.getField(aRequiredField).getValue().trim() ) ) {
						formMap.getField(aRequiredField).addMessage("err.required." + aRequiredField);
						continue;
					}
				}
			}
		}

		if (this.getClass().isAnnotationPresent(RegExValidationFields.class)) {
			RegExValidationFields regExValidationFields = this.getClass().getAnnotation(RegExValidationFields.class);
			String[] fieldNames = regExValidationFields.fieldNames();
			String[] regExPattern = regExValidationFields.patterns();
			for (int i=0;i<fieldNames.length;i++) {
				String whatToMatch = formMap.getField(fieldNames[i]).getValue();
				String pattern = regExPattern[i];
				if (log.isInfoEnabled()) {
					log.info("Will now try to match:" + whatToMatch + " with pattern:" + pattern);
				}
				if (whatToMatch != null) {
					try {
						Pattern p = Pattern.compile(regExPattern[i]);
						boolean isAMatch = p.matcher(whatToMatch).matches();
						if (!isAMatch) {
							formMap.getField(fieldNames[i]).addMessage("err.pattern." + fieldNames[i]);
						}
					}
					catch (PatternSyntaxException pse) {
						log.warn("Pattern Syntax Exception",pse);
					}
					finally {

					}
				}
			}
		}

		//
		if (this.getClass().isAnnotationPresent(DataTypeValidationFields.class)) {
			DataTypeValidationFields dataTypeValidationFields = this.getClass().getAnnotation(DataTypeValidationFields.class);
			String[] fieldNames = dataTypeValidationFields.fieldNames();
			DataTypeValidationType[] dataTypes = dataTypeValidationFields.dataTypes();
			for (int i=0;i<fieldNames.length;i++) {
				if (formMap.getField(fieldNames[i]) == null) {
					log.warn("Empty field??Invalid Annotation",fieldNames[i]);
					continue;
				}
				String whatToMatch = formMap.getField(fieldNames[i]).getValue();
				if (StringUtils.isEmpty(whatToMatch)) {
					log.warn("Cannot check format for an empty field "+ fieldNames[i] + " was found empty");
					continue;
				}
				DataTypeValidationType dataType = dataTypes[i];
				if (log.isInfoEnabled()) {
					log.info("Will now try to match:" + whatToMatch + " with pattern:" + dataType);
				}
				if (whatToMatch != null) {
					try {
						boolean isValid = DataTypeValidationHelper.isOfType(whatToMatch, dataType);
						if (!isValid) {
							formMap.getField(fieldNames[i]).addMessage("err.datatype." + fieldNames[i]);
						}
					}
					catch (PatternSyntaxException pse) {
						log.warn("Pattern Syntax Exception",pse);
					}
					finally {

					}
				}
			}
		}
		if (getITRInitData(request).maxChildrenAllowed != null && getITRInitData(request).pageAction == PAGE_ACTION.NEW_CHILD) {
			int maxChildAllowed = Integer.valueOf(getITRInitData(request).maxChildrenAllowed);
			int totalChildren = getITRInitData(request).getTotalChildren();
			if (totalChildren >= maxChildAllowed) {
				formMap.addMessage("generic","An error has occurred");
			}
		}

		StartApplicationValidationService startappvalidserv=new StartApplicationValidationService();
		if(getITRInitData(request).filingStatus.getXmlCode()=="I"){
			startappvalidserv.validResidential(formMap, getITRInitData(request).assessmentYear);
		}
		//validate last name of Member with PAN 
		startappvalidserv.validLastName(formMap);
		
		//additionalv validation
		additionalValidation(request, response, formMap);
		
		if (getITRInitData(request).formMap.getMessage() != null && getITRInitData(request).formMap.getMessage().size() > 0) {
			log.info("size of message"+formMap.getMessage().size());
			FormUtils.persistFormMap(request, response, formMap, null);
			return false;
		}
		else {
			//log.info("could not possible");
			return true;
		}
	}


	

	protected void fillDueDate(HstRequest request,HstResponse response) {
		//
		try {
			String indianDateTimeAsString = IndianGregorianCalendar.getCurrentDateInIndiaAsLocalString();
			request.setAttribute("indianDateTimeAsString", indianDateTimeAsString);

			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			if (memberPersonalInformation != null) {
				String stateCode = memberPersonalInformation.getState();
				ITRForm itrForm = memberPersonalInformation.getSelectedITRForm();
				FinancialYear currentFinancialYear = getITRInitData(request).getFinancialYear();
				boolean isPastDue = currentFinancialYear.isIncomeTaxPastDue(itrForm, stateCode);
				Calendar theDueDate = currentFinancialYear.getDueDate(itrForm, stateCode);
				String thePastDueDateStr =  IndianGregorianCalendar.formatDateAsString(theDueDate, IndianGregorianCalendar.indianDateTimeFormStr);
				FilingSection filingSection =  memberPersonalInformation.getFilingSection();
				if (filingSection == FilingSection.BeforeDueDate_139_1 && isPastDue) {
					request.setAttribute("inCorrectSection",true);
				}
				else if (filingSection == FilingSection.AfterDueDate_139_4 && !isPastDue) {
					request.setAttribute("inCorrectSection",true);
				}
				request.setAttribute("isPastDue",isPastDue);
				request.setAttribute("thePastDueDateStr",thePastDueDateStr);
				request.setAttribute("theDueDate",theDueDate);
			}

		}catch (Exception ex) {
			log.warn("WARN",ex);
		}
	}

	protected HippoBeanValidationResponse executeValidationChain(HstRequest request,HstResponse response) {
		//
		if ( getITRInitData(request).getMemberPersonalInformation() == null) return null;
		
		Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
		@SuppressWarnings("unchecked")
		Enumeration<String> enmAttrNames = request.getAttributeNames();
		while (enmAttrNames.hasMoreElements()) {
			String attrName = enmAttrNames.nextElement();
			Object anObj = request.getAttribute(attrName);
			if (anObj instanceof HippoBean) {
				mapOfBeans.put(anObj.getClass().getSimpleName().toLowerCase(), (HippoBean) anObj);
			}
		}
		
		Map<String,Object> additionalData = new HashMap<String,Object>();
		additionalData.put("webSiteInfo", getITRInitData(request).getWebSiteInfo());
		HippoBeanValidationResponse hippoBeanValidationResponse = itrValidationChain.execute(getITRInitData(request).getFinancialYear(), getITRInitData(request).pageAction,  mapOfBeans, additionalData , getClass().getAnnotations());
		if (hippoBeanValidationResponse != null && hippoBeanValidationResponse.getRepositoryUpdateRequests() != null && hippoBeanValidationResponse.getRepositoryUpdateRequests().size()  > 0 ) {
			BeanLifecycle<HippoBean> childBeanLifeCycleHandler = null;
			BeanLifecycle<HippoBean> parentBeanLifeCycleHandler = null;
			for ( RepositoryUpdateRequest repositoryUpdateRequest : hippoBeanValidationResponse.getRepositoryUpdateRequests() ) {
				Session persistableSession = null;
				WorkflowPersistenceManager wpm = null;
				try {
					persistableSession = getPersistableSession(request);
					wpm = getWorkflowPersistenceManager(persistableSession);
					PAGE_ACTION pageAction = repositoryUpdateRequest.getPageAction();
					if (pageAction == PAGE_ACTION.EDIT_CHILD) {
						getITReturnComponentHelper().saveUpdateExistingChild(repositoryUpdateRequest.getChildFormMap(), repositoryUpdateRequest.getParentFormMap(), childBeanLifeCycleHandler, parentBeanLifeCycleHandler , getITRInitData(request).getAbsoluteBasePathToReturnDocuments() ,repositoryUpdateRequest.getParentBeanAbsolutePath(), repositoryUpdateRequest.getParentBeanNameSpace(), repositoryUpdateRequest.getParentBeanNodeName(), repositoryUpdateRequest.getChildBeanClass(), persistableSession, wpm, repositoryUpdateRequest.getChildUuid());
					}			
				}catch (Exception e){
					log.error("Error updating the Object",e);
				}
			}
		}
		
		if (hippoBeanValidationResponse != null) request.setAttribute("hippoBeanValidationResponse", hippoBeanValidationResponse);
		
		if ( hippoBeanValidationResponse != null) {
			if (hippoBeanValidationResponse.getTotalErrors() > 0 ) {
				request.setAttribute("hippoBeanValidationResponse_totalErrors", hippoBeanValidationResponse.getTotalErrors() );
			}
			if (hippoBeanValidationResponse.getTotalWarnings() > 0 ) {
				request.setAttribute("hippoBeanValidationResponse_totalWarnings", hippoBeanValidationResponse.getTotalWarnings() );
			}
		}
		
		return hippoBeanValidationResponse;
	}

	protected void redirectToMemberHome(HstRequest request, HstResponse response) {
		try {
			response.setRenderParameter("error", "invalid.pan");
			request.setAttribute("error", "invalid.pan");
			String forwardTo = "/member/itreturn";
			if (getITRInitData(request).isOnVendorPortal() && getITRInitData(request).isVendor(request)) forwardTo = "/vendor/itreturn";
			if (getITRInitData(request).getFinancialYear() != null) {
				forwardTo += "/" + getITRInitData(request).getFinancialYear();
			}
			response.forward(forwardTo);
		} catch (IOException e) {
			throw new HstComponentException(e);
		}
	}

	protected void redirectToNotFoundPage(HstResponse response) {
		try {
			response.forward("/404");
		} catch (IOException e) {
			throw new HstComponentException(e);
		}
	}

	protected String getRedirectURLForSiteMapItem(HstRequest request,HstResponse response,FormSaveResult formSaveResult) {
		if (formSaveResult.equals(FormSaveResult.FAILURE)) {
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,getITRInitData(request).mainSiteMapItemRefId,getITRInitData(request).getFinancialYear(),getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		}
		else if (formSaveResult.equals(FormSaveResult.SUCCESS) && getITRInitData(request).nextScreenSiteMapItemRefId != null) {
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,getITRInitData(request).nextScreenSiteMapItemRefId,getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		}
		else {
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,getITRInitData(request).mainSiteMapItemRefId,getITRInitData(request).getFinancialYear(),getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		}
	}

	public String getRedirectURLForSiteMapItem(HstRequest request,HstResponse response,FormSaveResult formSaveResult,String siteMapReferenceId,FinancialYear financialYear, String folderContainsITReturnDocuments , String pan) {
		if (siteMapReferenceId == null) return null;
		if (financialYear == null || financialYear.equals(FinancialYear.UNKNOWN)) return null;
		if (folderContainsITReturnDocuments == null) return null;
		HstLink link = request.getRequestContext().getHstLinkCreator().createByRefId(siteMapReferenceId, request.getRequestContext().getResolvedMount().getMount());
		if (link != null) {
			String strFirstRep = null;
			if (getITRInitData(request).isOnVendorPortal() && getITRInitData(request).isVendor(request)) {
				strFirstRep = link.toUrlForm(request.getRequestContext(), true).replaceFirst("_default_", getITRInitData(request).getMemberhandleuuid());
				strFirstRep = strFirstRep.replaceFirst("_default_", financialYear.toString());
			}
			else {
				strFirstRep = link.toUrlForm(request.getRequestContext(), true).replaceFirst("_default_", financialYear.toString());
			}
			//strFirstRep = strFirstRep.replaceFirst("_default_",itReturnType.toString());
			strFirstRep = strFirstRep.replaceFirst("_default_",folderContainsITReturnDocuments);
			strFirstRep = strFirstRep.replaceFirst("_default_",pan);
			return strFirstRep;
		}
		else {
			return null;
		}
	}

	/*
	 * The ultimate goal here is to save the parent bean and if it didn't exist then it should have been created in the first place
	 * a child cannot exist without a parent
	 */
	protected boolean save(HstRequest request,FormMap formMap) throws Exception {
		boolean savedSuccessfully = false;
		PAGE_ACTION pageAction = getITRInitData(request).getPageAction();
		HippoBean childBean = getITRInitData(request).getChildBean();
		
		//what are we supposed to do??
		if (pageAction.equals(PAGE_ACTION.EDIT_CHILD) && childBean != null) {
			//we are updating a child node here
		}
		else if (pageAction.equals(PAGE_ACTION.DELETE_CHILD) && childBean != null) {
			//we are deleting a child node here
		}
		else if (pageAction.equals(PAGE_ACTION.NEW_CHILD)){
			//this is fun, now we should ensure that parentBeanExists and if not create it
			//also a new childNode will be added to this parentBean
		}
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			if (pageAction.equals(PAGE_ACTION.EDIT_CHILD) && childBean != null) {
				itReturnComponentHelper.saveUpdateExistingChild(formMap, null, getChildBeanLifeCycleHandler(request), getParentBeanLifeCycleHandler(request),getITRInitData(request).baseAbsolutePathToReturnDocuments, getITRInitData(request).parentBeanAbsolutePath, getITRInitData(request).getParentBeanNameSpace(), getITRInitData(request).getParentBeanNodeName(), getITRInitData(request).getChildBeanClass(), persistableSession, wpm, getITRInitData(request).uuid);
				savedSuccessfully = true;
			}
			else if (pageAction.equals(PAGE_ACTION.NEW_CHILD)) {
				ChildBean childBeanLocal = getClass().getAnnotation(ChildBean.class);
				//temporary fix for deductions --- 14-Sept
				String deduction_section = request.getRequestContext().getResolvedSiteMapItem().getParameter("deduction_section");
				if (deduction_section != null) {
					FormField dedSectnFormField = new FormField("section");
					dedSectnFormField.addValue(deduction_section);
					formMap.addFormField(dedSectnFormField);
				}
				itReturnComponentHelper.saveAddNewChild(formMap, formMap, getChildBeanLifeCycleHandler(request), getParentBeanLifeCycleHandler(request), getITRInitData(request).baseAbsolutePathToReturnDocuments, getITRInitData(request).parentBeanAbsolutePath, getITRInitData(request).getParentBeanNameSpace(), getITRInitData(request).getParentBeanNodeName(),  childBeanLocal.childBeanClass(), persistableSession, wpm);
				savedSuccessfully = true;
			}
			else if (pageAction.equals(PAGE_ACTION.DELETE_CHILD) && childBean != null) {
				HippoBean childBeanInSession = (HippoBean) wpm.getObjectByUuid(getITRInitData(request).uuid);
				HippoBean parentBeanInSession = childBeanInSession.getParentBean();
				if (parentBeanInSession instanceof CompoundChildUpdate) {
					CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
					compoundChildUpdate.delete(childBeanInSession);
				}
				wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
				if (parentBeanInSession != null && childBean != null) {
					//wpm.update(childBeanInSession);
					if (!beforeSave(request)) return false; // don't save if this method returns false
					wpm.update(parentBeanInSession);
					savedSuccessfully = true;						
				}

			}
			else if (pageAction.equals(PAGE_ACTION.EDIT)) {
				//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
				boolean isNew = false;
				HippoBean parentBeanInSession = (HippoBean) wpm.getObject(getITRInitData(request).parentBeanAbsolutePath);
				HippoBean beanBeforeUpdate = parentBeanInSession;
				BeanLifecycle<HippoBean> parentBeanLifeCycleHandler = getParentBeanLifeCycleHandler(request);
				if (parentBeanInSession == null) {
					//gotta create this damn thing
					if (log.isInfoEnabled()) {
						log.info("Parent Bean is missing, we will need to recreate it");
					}
					final String pathToParentBean = wpm.createAndReturn(getITRInitData(request).baseAbsolutePathToReturnDocuments,getITRInitData(request).getParentBeanNameSpace(),getITRInitData(request).getParentBeanNodeName(), true);
					parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);
					isNew = true;
					//initParentBean(parentBeanInSession);
				}
				//now set the value we received from the form submission
				if (parentBeanInSession instanceof FormMapFiller) {
					FormMapFiller formMapFiller = (FormMapFiller) parentBeanInSession;
					formMapFiller.fill(formMap);
				}
				wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
				if (parentBeanInSession != null) {
					//wpm.update(childBeanInSession);
					if (!beforeSave(request)) return false; // don't save if this method returns false
					List<String> errors = new ArrayList<String>();
					List<String> warnings = new ArrayList<String>();
					if (parentBeanLifeCycleHandler != null) {
						boolean isValid = parentBeanLifeCycleHandler.validateParentBean(parentBeanInSession, isNew, errors, warnings);
						if (!isValid) {
							if (errors != null && errors.size() > 0 ){
								if (formMap == null) formMap = new FormMap();
								int errCtr = 0;
								for (String anError:errors) {
									formMap.addMessage("error_" + (errCtr++), anError);
								}
							}
							return isValid;
						}
					}
					wpm.update(parentBeanInSession);
					HippoBean beanAfterUpdate = parentBeanInSession;
					if (parentBeanLifeCycleHandler != null) {
						parentBeanLifeCycleHandler.afterUpdate(beanBeforeUpdate,beanAfterUpdate,wpm,getITRInitData(request).getAbsoluteBasePathToReturnDocuments(), getITReturnComponentHelper());
					}
					savedSuccessfully = true;
				}			
			}
		} 
		finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}			
		}
		return savedSuccessfully;
	}

	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}

	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return true;
	}

	public void afterSave(HstRequest request,HstResponse response, FormMap map, PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub

	}

	public String generateBulkXml(HstRequest request,HstResponse response, String[] pathToITR) throws Exception {
		// TODO Auto-generated method stub
		//for each path get all beans under that, then check memberpersonalinformation
		//based on memberpersonalinformation run the respective code
		try {
			Map<FinancialYear,List<Object>> listOfITRForms = new HashMap<FinancialYear, List<Object>>();
			for (String aPath:pathToITR) {
				@SuppressWarnings("unchecked")
				HippoBean hippoBean = getITRInitData(request).getSiteContentBaseBeanForReseller(request).getBean(aPath);
				HstQuery hstQuery = this.getQueryManager(request).createQuery(hippoBean);
				final HstQueryResult result = hstQuery.execute();
				Map<String,HippoBean> inputMap = new HashMap<String, HippoBean>();
				HippoBeanIterator resultIterator = result.getHippoBeans();
				MemberPersonalInformation memberPersonalInformation = null;
				for (;resultIterator.hasNext();) {
					HippoBean theBean = resultIterator.next();
					inputMap.put(theBean.getClass().getSimpleName().toLowerCase(),theBean);
					if (theBean instanceof MemberPersonalInformation) {
						memberPersonalInformation =  (MemberPersonalInformation) theBean;
					}
				}
				if (memberPersonalInformation == null) continue;
				FinancialYear financialYear = FinancialYear.getByDisplayName(memberPersonalInformation.getFinancialYear());
				XmlGeneratorService xmlGeneratorService = itrXmlGeneratorServiceFactory.getInstance(financialYear);
				if (itrXmlGeneratorServiceFactory != null) {
					if (xmlGeneratorService != null) {
						try {
							Map<String,Object> outputMap = xmlGeneratorService.generateXml(financialYear,inputMap);
							if (!listOfITRForms.containsKey(financialYear)) {
								listOfITRForms.put(financialYear, new ArrayList<Object>());
							}
							listOfITRForms.get(financialYear).add(outputMap.get("theForm"));
							if (log.isInfoEnabled()) {
								log.info("outputMap",outputMap);
							}
						}
						catch (Exception e) {
							// TODO Auto-generated catch block
							log.error("Error in generating XML",e);
							throw new InvalidXMLException(e);
						}
					}
				}
			}
			if (listOfITRForms != null && listOfITRForms.size() > 0) {
				for (FinancialYear aFinancialYear:listOfITRForms.keySet()) {
					List<Object> listOfForms = listOfITRForms.get(aFinancialYear);
					XmlGeneratorService xmlGeneratorService = itrXmlGeneratorServiceFactory.getInstance(aFinancialYear);
					String consolidatedXml = xmlGeneratorService.getConsolidateReturnsToBulk(listOfForms);
					log.info(consolidatedXml);
					request.setAttribute("xml", consolidatedXml);
					request.setAttribute("fileName", "consolidated-returns.xml");
					response.setRenderPath("jsp/member/downloadfile.jsp");
				}
			}
		} catch (Exception ex) {
			log.error("Error in search",ex);
		}
		return null;
	}


	//DecimalFormat decimalFormat=new DecimalFormat("#.#");
	public void handleITRSummary(HstRequest request, HstResponse response) throws InvalidXMLException, PaymentRequiredException, DownloadConfirmationRequiredException, EFileException, DigtalSignatureAssesseeFailure, DigtalSignatureERIUserFailure{

		String generatedXml = null;
		String generatedHtmlSummary = null;
		String generatedPathToPDF = null;
		String generatedPathToXML = null;

		String downloadBaseFileName = "return-"+  getITRInitData(request).getPAN() +"-AY-" + getITRInitData(request).getFinancialYear().getDisplayAssessmentYear() + "-" + getITRInitData(request).getITReturnType();
		String downloadPDFFileName = downloadBaseFileName  + ".pdf";
		String downloadXMLFileName = downloadBaseFileName  + ".xml";

		boolean isPaid = false;

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
	
		String ITR = memberPersonalInformation.getFlexField("flex_string_ITRForm", "");
		request.setAttribute("ITR", ITR);
		if (getPublicRequestParameter(request, "show") != null) request.setAttribute("show",getPublicRequestParameter(request, "show"));

		//time to hand over
		XmlGeneratorService xmlGeneratorService = itrXmlGeneratorServiceFactory.getInstance(getITRInitData(request).getFinancialYear());
		if (itrXmlGeneratorServiceFactory != null) {
			if (xmlGeneratorService != null) {
				try {
					generatedXml = xmlGeneratorService.generateXml(request, response);
					
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					log.error("Error in generating XML",e);
					throw new InvalidXMLException(e);
				}
			}
		}

		if (getITRInitData(request).getPageAction().equals(PAGE_ACTION.SHOW_ITR_SUMMARY)) return; //no need to go forward at all

		boolean isValidationRequired = false;
		if (! getITRInitData(request).getPageAction().equals(PAGE_ACTION.SHOW_ITR_SUMMARY)) isValidationRequired = true;
		if (log.isInfoEnabled()) {
			log.info("Validation of XML is required for this action");
		}
		if (isValidationRequired) {
			ValidationResponse validationResponse = null;
			try {
				validationResponse = xmlGeneratorService.validateXml(generatedXml);
				validationResponse.setXml(generatedXml);
				if (validationResponse == null || !validationResponse.isValid()) {
					throw new InvalidXMLException(validationResponse);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new InvalidXMLException(validationResponse);
			}
		}

		//we can generate the HTML Summary here
		generatedHtmlSummary = getReturnSummary(request,response,generatedXml);

		//Now the check if user accepted terms and conditions
		boolean doesASavedFormExists = false;
		FormMap savedValuesFormMap=null;
		String publicParameterUUID = getPublicRequestParameter(request, "uuid");
		if(publicParameterUUID==null){
			publicParameterUUID=(String)request.getSession().getAttribute("uuid");
		}
		if (publicParameterUUID != null) {
			try {
				FormUtils.validateId(publicParameterUUID);
				savedValuesFormMap = new FormMap(request,new String[]{"PAN","financialYear","itReturnType","userName"});

				/*
				savedValuesFormMap.getField("PAN").addValue(getPAN());
				savedValuesFormMap.getField("financialYear").addValue(getFinancialYear().name());
				savedValuesFormMap.getField("itReturnType").addValue(getITReturnType().name());
				savedValuesFormMap.getField("userName").addValue(getUserName());
				 */

				MootlyFormUtils.populate(request, publicParameterUUID, savedValuesFormMap);
				if (savedValuesFormMap != null) {
					boolean panMatched = ( (savedValuesFormMap.getField("PAN") != null && savedValuesFormMap.getField("PAN").getValue().equals(getITRInitData(request).getPAN())) ? true : false);
					boolean financialYearMatched = ( (savedValuesFormMap.getField("financialYear") != null && savedValuesFormMap.getField("financialYear").getValue().equals(getITRInitData(request).getFinancialYear().name())) ? true : false );
					boolean theFolderContainingITRDocumentsMatched = ( (savedValuesFormMap.getField("theFolderContainingITRDocuments") != null && savedValuesFormMap.getField("theFolderContainingITRDocuments").getValue().equals(getITRInitData(request).getTheFolderContainingITRDocuments())) ? true : false);
					boolean userNameMatched = ( (savedValuesFormMap.getField("userName") != null && savedValuesFormMap.getField("userName").getValue().equals(getITRInitData(request).getUserName())) ? true : false );

					if (panMatched && financialYearMatched && theFolderContainingITRDocumentsMatched && userNameMatched) {
						doesASavedFormExists = true;
					}
				}
			}catch (IllegalArgumentException ie) {
				publicParameterUUID = null;
				doesASavedFormExists = false;
			}
			catch (Exception ex) {
				doesASavedFormExists = false;
			}
		}

		if (!doesASavedFormExists) {
			FormMap toBeSavedValuesFormMap = new FormMap(request,new String[]{"redirectToOriginalPage","PAN","financialYear","itReturnType","userName","generatedHtmlSummary","originalPageAction","theFolderContainingITRDocuments"});


			toBeSavedValuesFormMap.getField("PAN").addValue(getITRInitData(request).getPAN());
			toBeSavedValuesFormMap.getField("financialYear").addValue(getITRInitData(request).getFinancialYear().name());
			toBeSavedValuesFormMap.getField("itReturnType").addValue(getITRInitData(request).getITReturnType().name());
			toBeSavedValuesFormMap.getField("theFolderContainingITRDocuments").addValue(getITRInitData(request).getTheFolderContainingITRDocuments());
			toBeSavedValuesFormMap.getField("userName").addValue(getITRInitData(request).getUserName());
			toBeSavedValuesFormMap.getField("generatedHtmlSummary").addValue(generatedHtmlSummary);
			toBeSavedValuesFormMap.getField("originalPageAction").addValue(getITRInitData(request).getPageAction().name());

			String refId = request.getRequestContext().getResolvedSiteMapItem().getHstSiteMapItem().getRefId();
			if (refId != null) {
				String redirectToOriginalPage = getRedirectURLForSiteMapItem(request, response, FormSaveResult.SUCCESS, refId, getITRInitData(request).getFinancialYear(), getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
				toBeSavedValuesFormMap.getField("redirectToOriginalPage").addValue(redirectToOriginalPage);
			}


			StoreFormResult sf = new StoreFormResult();
			FormUtils.persistFormMap(request, response, toBeSavedValuesFormMap,sf);

			DownloadConfirmationRequiredException dc = new DownloadConfirmationRequiredException();
			dc.setUuidOfSavedForm(sf.getUuid());
			dc.setHtmlSummary(generatedHtmlSummary);
			throw dc;
		}

		boolean isPaymentRequired = false;
		isPaid = false;
		if (! getITRInitData(request).getPageAction().equals(PAGE_ACTION.SHOW_ITR_SUMMARY)) isPaymentRequired = true;
		
		if (getITRInitData(request).isVendor(request) && (getITRInitData(request).getPageAction().equals(PAGE_ACTION.DOWNLOAD_ITR_XML) || getITRInitData(request).getPageAction().equals(PAGE_ACTION.DOWNLOAD_ITR_SUMMARY)) ) {
			isPaymentRequired = false; //TO-DO 
		}
		if (isPaymentRequired) {
			try {
				/*
				MemberPayment memberPayment = (MemberPayment) request.getAttribute("memberpayment");
				if (memberPayment != null && memberPayment.getPaymentVerificationStatus() != null &&  memberPayment.getPaymentVerificationStatus() == PaymentVerificationStatus.VERIFIED)
					isPaid = true;
				*/
				InvoiceDocument invoiceDocument = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());				
				if (invoiceDocument != null  && invoiceDocument.getAmountDue() != null && invoiceDocument.getAmountDue() == 0 && invoiceDocument.getInvoiceDocumentDetailList() != null && invoiceDocument.getInvoiceDocumentDetailList().size() > 0) {
					for (InvoiceDocumentDetail invoiceDocumentDetail : invoiceDocument.getInvoiceDocumentDetailList()) {
						
					}
					isPaid = true;
				}
			}catch (Exception ex) {
				throw new PaymentRequiredException(ex);
			}
		}
		//bug when ispayment required and not paid
		request.setAttribute("isPaymentRequired", isPaymentRequired);
		request.setAttribute("isPaid", isPaid);
		if (isPaymentRequired && !isPaid) {
			throw new PaymentRequiredException("Payment is required");
			/*
			if (isOnVendorPortal() && isVendor(request)) {
				if (log.isInfoEnabled()) {
					log.info("Vendor can skip the payment and get the XML right away");
				}
			}
			else { //normal user must pay

			}
			 */
		}



		if (getPublicRequestParameter(request, "show") != null) request.setAttribute("show",getPublicRequestParameter(request, "show"));

		if (generatedHtmlSummary != null &&( getITRInitData(request).getPageAction() == PAGE_ACTION.DOWNLOAD_ITR_SUMMARY ||  getITRInitData(request).getPageAction() == PAGE_ACTION.EMAIL_ITR_XML_AND_SUMMARY )) {
			//time to generate the PDF
			try {
				generatedPathToPDF = generatePDF(request, response, generatedHtmlSummary);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				generatedPathToPDF = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				generatedPathToPDF = null;
			}
		}

		if ( getITRInitData(request).getPageAction() == PAGE_ACTION.EMAIL_ITR_XML_AND_SUMMARY) { //time to save the XML in temporary path
			generatedPathToXML = saveXmlToTemporaryFile(request,generatedXml);
		}

		switch ( getITRInitData(request).getPageAction()) {
		case DOWNLOAD_ITR_XML:
			request.setAttribute("fileName", downloadXMLFileName);
			response.setRenderPath("jsp/member/downloadfile.jsp");
			break;
		case DOWNLOAD_ITR_SUMMARY:
			request.setAttribute("fileName", downloadPDFFileName);
			request.setAttribute("filePath", generatedPathToPDF);
			response.setRenderPath("jsp/member/downloadfile.jsp");
			break;
		case EMAIL_ITR_XML_AND_SUMMARY:
			if (generatedPathToXML != null && generatedPathToPDF != null) {
				String deliveryEmail = getPublicRequestParameter(request, "email");
				String[] to = null;
				if (deliveryEmail != null && !"".equals(deliveryEmail.trim())) {
					to = new String[]{  getITRInitData(request).getUserName(), deliveryEmail };
				}
				else {
					to = new String[]{  getITRInitData(request).getUserName()};
				}

				//sendEmail(request, to, null, new String[] {"info@wealth4india.com"}, "Your IT Return", temporaryPathToPDF + "," + temporaryPathToXML, "Your IT Return Summary", "itreturnSummaryAndXml", null);
				Map<String,Object> vC = new HashMap<String, Object>();
				vC.put("financialYearDisplay",  getITRInitData(request).getFinancialYear().getDisplayName());
				vC.put("financialYear",  getITRInitData(request).getFinancialYear());

				try {
					MemberPersonalInformation mi = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
					if (mi != null) {
						vC.put ("paymentAmount",mi.getPrice());
					}
				}catch (Exception ex) {

				}

				sendEmail(request, to, generatedPathToXML + "," + generatedPathToPDF,"Attached is your Income Tax Return for Financial Year " +  getITRInitData(request).getFinancialYear().getDisplayName(),"w4i_email",vC);
				request.setAttribute("emailMeStatus", "success");
			}
			else {
				request.setAttribute("emailMeStatus", "failure");
			}
			break;
		case EFILE:
				EFileResponse eFileResponse = eFileITR(request, getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEriUserId(), getITRInitData(request).getChannelInfoWrapper().getWebSiteInfo().getEriPassword(), generatedXml);
				request.setAttribute("eFileResponse",eFileResponse);
		}
	}

	/**
	 * This will save the XML to a temporary location
	 * @param xml
	 * @return
	 */
	protected String saveXmlToTemporaryFile(HstRequest request,String xml) {
		BufferedWriter writer = null;
		try
		{
			String tmpDir = System.getProperty("java.io.tmpdir");
			String uuid = UUID.randomUUID().toString();
			new File(tmpDir + "/" + uuid).mkdir();
			String filePath = tmpDir + "/" + uuid + "/" + "itreturn-AY-" + getITRInitData(request).getFinancialYear().getDisplayAssessmentYear() + ".xml";

			writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(xml);

			return filePath;
		}
		catch ( IOException e)
		{
			log.error("Error saving XML as temporary file",e);
			return null;
		}
		finally
		{
			try
			{
				if ( writer != null)
					writer.close( );
			}
			catch ( IOException e)
			{
			}
		}
	}

	/**
	 * This method will parse the XML using XSLT and get the output
	 * @param xml
	 * @param xslt
	 * @return
	 * @throws ParserConfigurationException
	 * @throws FactoryConfigurationError
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws IOException
	 */
	protected String getReturnSummary(HstRequest request,HstResponse response, String xml) {
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xml));
			org.w3c.dom.Document aDom = db.parse(is);
			FileInputStream fi = new FileInputStream(xsltPath);
			StreamSource stylesource = new StreamSource(fi);
			Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
			StringWriter sw = new StringWriter();
			StreamSource sSource = new StreamSource(new StringReader(xml));
			StreamResult sResult = new StreamResult(sw);
			transformer.transform(sSource,sResult);
			fi.close();
			String theHTML = sw.toString();
			if (log.isInfoEnabled()) {
				log.info(theHTML);
			}
			return theHTML;
		}catch (ParserConfigurationException pe) {
			return null;
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Return path to PDF file
	 * @param theHTML
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	protected String generatePDF(HstRequest request,HstResponse response, String theHTML) throws DocumentException, IOException {
		Document document = new Document();
		String tmpDir = System.getProperty("java.io.tmpdir");
		String uuid = UUID.randomUUID().toString();
		//create the dir
		new File(tmpDir + "/" + uuid).mkdir();
		String pdfFileName = "itreturnsummary-" + getITRInitData(request).getPAN() +"-AY-" + getITRInitData(request).getFinancialYear().getDisplayAssessmentYear() + ".pdf";
		String temporaryPathToPDF = tmpDir + "/" + uuid + "/" + pdfFileName;
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(temporaryPathToPDF));
		writer.setInitialLeading(12.5f);
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(theHTML));
		document.close();
		writer.close();

		return temporaryPathToPDF;
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @param temporaryPathToPDF
	 * @param temporaryPathToXML
	 * @return
	 */
	protected boolean emailSummaryAndReturn(HstRequest request,HstResponse response, String temporaryPathToPDF,String temporaryPathToXML) {
		if (temporaryPathToPDF != null && temporaryPathToXML != null) {
			String deliveryEmail = getPublicRequestParameter(request, "email");
			String[] to = null;
			if (deliveryEmail != null && !"".equals(deliveryEmail.trim())) {
				to = new String[]{ getITRInitData(request).getUserName(), deliveryEmail };
			}
			else {
				to = new String[]{ getITRInitData(request).getUserName()};
			}

			//sendEmail(request, to, null, new String[] {"info@wealth4india.com"}, "Your IT Return", temporaryPathToPDF + "," + temporaryPathToXML, "Your IT Return Summary", "itreturnSummaryAndXml", null);
			Map<String,Object> vC = new HashMap<String, Object>();
			vC.put("financialYearDisplay", getITRInitData(request).getFinancialYear().getDisplayName());
			vC.put("financialYear", getITRInitData(request).getFinancialYear());
			boolean ret = false;
			try {
				sendEmail(request, to, temporaryPathToPDF + "," + temporaryPathToXML,"Your Income Tax Return for Financial Year " + getITRInitData(request).getFinancialYear().getDisplayName(),"w4i_email",vC);
				ret = true;
			}catch (Exception ex) {
				ret = false;
			}
			return ret;
		}
		else {
			return false;
		}
	}

	

	/**
	 * 
	 * @param request
	 */
	protected boolean updateInvoice(HstRequest request) {
		Session persistableSession = null;
		boolean didGotUpdated = false;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			String pathToInvoiceDocument = getITRInitData(request).getAbsoluteBasePathToReturnDocuments() + "/" + InvoiceDocument.class.getSimpleName().toLowerCase();
			List<PaymentUpdateResponse> listOfPaymentUpdateResponse = getItReturnComponentHelper().syncInvoiceWithPaymentGateway(pathToInvoiceDocument, request, getEnquiry() , persistableSession, wpm);
			if (listOfPaymentUpdateResponse == null || listOfPaymentUpdateResponse.size() == 0) {
				didGotUpdated = false;
			}	
			else {
				didGotUpdated = true;
				request.setAttribute("listOfPaymentUpdateResponse", listOfPaymentUpdateResponse);
			}
			request.setAttribute("SyncInvoiceWithCitrus_STATUS", "success");
			return didGotUpdated;
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error in Save",e);
			request.setAttribute("SyncInvoiceWithCitrus_STATUS", "error");
		}catch (Exception e) {
			log.error("Error resyncing invoice",e);
			request.setAttribute("SyncInvoiceWithCitrus_STATUS", "error");
		}
		finally {
			try { persistableSession.logout(); }finally {}
		}
		return didGotUpdated;
	}

	protected EFileResponse eFileITR(HstRequest request,String userName, String password,String itrXML) throws EFileException, DigtalSignatureAssesseeFailure, DigtalSignatureERIUserFailure {
		///assuming all is WELL call another class so we can keep the Logic Seperated.
		//String xml,String resellerId,String pan,FinancialYear financialYear,String canonicalPathToMemberIncomeTaxFolder) throws EFileException;
		try {
			if (getITRInitData(request).getMemberPersonalInformation() != null) {
				Session persistableSession = getPersistableSession(request);
				WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
				String  canonicalPathToMemberIncomeTaxFolder = getITRInitData(request).getMemberPersonalInformation().getParentBean().getCanonicalPath();
				EFileResponse eFileResponse = geteFileService().eFile(userName,password, itrXML, getITRInitData(request).getResellerId(),getITRInitData(request).getPAN(), getITRInitData(request).getFinancialYear(), canonicalPathToMemberIncomeTaxFolder,getITRInitData(request).getAbsoluteBasePathToReturnDocuments(),wpm);
				return eFileResponse;
			}
			else {
				throw new EFileException("Problem with Member Personal Information");
			}
		}catch (EFileException e) {
			log.error("Error in eFile",e);
			throw e;
		}
		catch (Exception e) {
			throw new EFileException(e);
		}
	}
	
	protected HippoBean getSiteContentBaseBeanForReseller(HstRequest request) {
		// TODO Auto-generated method stub
		return getITRInitData(request).getSiteContentBaseBeanForReseller(request);
	}

	protected boolean shouldRedirectAfterSuccess(HstRequest request) {
		return true;
	}
	
	protected BeanLifecycle<HippoBean> getChildBeanLifeCycleHandler(HstRequest request) {
		return null;
	}

	protected BeanLifecycle<HippoBean> getParentBeanLifeCycleHandler(HstRequest request) {
		return null;
	}
	
	protected String[] getRequiredFields(HstRequest request) {
		return null;
	}
	
	protected boolean additionalValidation(HstRequest request,HstResponse response,FormMap formMap) {
		return true;
	}
	
	protected String urlToRedirectAfterSuccess(HstRequest request,HstResponse response,FormMap formMap) {
		return null;
	}
	
}
