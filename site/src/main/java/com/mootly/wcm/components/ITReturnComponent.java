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
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
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
import com.mootly.wcm.annotations.ValueListBeans;
import com.mootly.wcm.beans.CompoundChildUpdate;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.MemberPayment;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScreenCalculation;
import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.model.FilingSection;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.ITRTab;
import com.mootly.wcm.model.ITReturnPackage;
import com.mootly.wcm.model.ITReturnType;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.model.ValidationResponse;
import com.mootly.wcm.services.DownloadConfirmationRequiredException;
import com.mootly.wcm.services.ITRXmlGeneratorServiceFactory;
import com.mootly.wcm.services.InvalidXMLException;
import com.mootly.wcm.services.PaymentRequiredException;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.services.ScreenConfigService;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.SequenceGeneratorImpl;
import com.mootly.wcm.services.StartApplicationValidationService;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.services.ditws.ITRVStatus;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.RetrievePANInformation.VALIDATION_RESULT;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.MootlyFormUtils;
import com.mootly.wcm.utils.XmlCalculation;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.impl.itr.ITRValidatorChain;

public class ITReturnComponent extends BaseComponent implements ITReturnScreen{
	private static final Logger log = LoggerFactory.getLogger(ITReturnComponent.class);
	ITRXmlGeneratorServiceFactory itrXmlGeneratorServiceFactory = null;
	ITRValidatorChain itrValidationChain = null;
	RetrieveITRV retrieveITRVService = null;
	Retrieve26ASInformation retrieve26ASService = null;
	RetrievePANInformation retrievePANInformation = null;
	ITReturnComponentHelper itReturnComponentHelper = null;

	String servletPath = null;
	String xsltPath = null;

	//local variables
	boolean hasInitComplete = false;
	String redirectURLToSamePage=  null;

	//User/Member Parameters
	String userName;
	String userNameNormalized;
	boolean isLoggedIn = false;
	String memberRootFolderRelPath = null;
	String memberRootFolderAbsolutePath = null;
	Member member = null;
	HippoBean hippoBeanMemberBase;
	HippoFolder panFolder;

	//ITReturn Specific
	String baseRelPathToReturnDocuments;
	String baseAbsolutePathToReturnDocuments;
	String assessmentYear;
	FinancialYear financialYear;
	ITReturnType itReturnType = ITReturnType.ORIGINAL;
	String theFolderContainingITRDocuments = null;
	String itrFolderSuffix = null;
	String pan = null;
	FilingStatus filingStatus;
	FormMap formMap = null;
	ITReturnPackage itReturnPackage = ITReturnPackage.basic;

	HippoBean siteContentBaseBean = null;
	//Document Specific
	HippoBean hippoBeanBaseITReturnDocuments;
	Class<? extends HippoBean> parentBeanClass = null;
	String parentBeanNameSpace;
	String parentBeanPath;
	String parentBeanAbsolutePath;
	HippoBean parentBean;
	HippoBean childBean;

	String uuid;
	String maxChildrenAllowed = null;

	//MemberPersonalInformation memberPersonalInformation = null;
	//Screen Specific
	PAGE_OUTPUT_FORMAT pageOutputFormat;
	PAGE_ACTION pageAction;
	String screenMode;
	String nextScreenSiteMapItemRefId;

	String mainSiteMapItemRefId = null;

	String clientSideValidationJSON;

	///Name of the HTML File and the depth its in
	String scriptName;

	SequenceGenerator sequenceGenerator = null;

	Map<String,HippoBean> mapOfAllBeans = new HashMap<String, HippoBean>();


	MemberPersonalInformation memberPersonalInformation;
	boolean shouldRetrievePANInformation = false;
	boolean shouldValidatePANWithDIT = false;
	RetrievePANInformation.VALIDATION_RESULT retrievePANInformationValidationResult = VALIDATION_RESULT.NOT_INITIATED;
	RetrievePANResponse retrievePANResponse = null;

	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		itrXmlGeneratorServiceFactory = context.getBean(com.mootly.wcm.services.ITRXmlGeneratorServiceFactory.class);
		sequenceGenerator = context.getBean(SequenceGeneratorImpl.class);
		xsltPath = servletContext.getRealPath("/xslt/ITRSummary.xsl");
		itrValidationChain =  context.getBean(ITRValidatorChain.class);
		retrievePANInformation = context.getBean(RetrievePANInformation.class);
		retrieveITRVService = context.getBean(RetrieveITRV.class);
		retrieve26ASService = context.getBean(Retrieve26ASInformation.class);

		itReturnComponentHelper = context.getBean( ITReturnComponentHelper.class );
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

	public SequenceGenerator getSequenceGenerator() {
		return sequenceGenerator;
	}

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);

		if (!hasInitComplete) {
			try {
				initComponent(request,response);
				fillDueDate(request,response); //this will fill the due date
				executeValidationChain(request,response);
			}
			catch (InvalidPANException inpe) {
				redirectToMemberHome(request,response);
				return;
			}
			catch (InvalidNavigationException ine) {
				redirectToNotFoundPage(response);
				return;
			}
			catch (Exception ex) {
				log.error("Error in initializing component. FATAL",ex);
				redirectToNotFoundPage(response);
				return;
			}
			//hasInitComplete = true;
		}
		if (getPAN() != null && (filingStatus == null || filingStatus.equals(FilingStatus.UNKNOWN))) {
			log.error("Unknown Filing status for PAN:" + getPAN());
			response.setRenderPath("jsp/security/invalidpan.jsp");
			return;
		}

		if (pageAction == PAGE_ACTION.NEW_CHILD && request.getAttribute("NEW_CHILD_DISABLED") != null) {
			log.error("User attempting to over ride the maxAllowedChildren parameter");
			response.setRenderPath("jsp/security/invalidoperation.jsp");
			return;
		}

		if (getClass().isAnnotationPresent(FormFields.class)) {
			FormFields formFields = this.getClass().getAnnotation(FormFields.class);
			String[] vendorFields = formFields.fieldNamesVendorOnly();
			String[] theFieldsArray = formFields.fieldNames();
			if (isVendor(request) && vendorFields != null && vendorFields.length > 0){
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
				if (pageAction.equals(PAGE_ACTION.NEW_CHILD) || pageAction.equals(PAGE_ACTION.EDIT_CHILD)) {
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
				else if (pageAction.equals(PAGE_ACTION.EDIT) || pageAction.equals(PAGE_ACTION.NEW)) {
					if (this.getClass().isAnnotationPresent(PrimaryBean.class)) {
						HippoBean childBean = null;
						try {
							parentBean = this.getClass().getAnnotation(PrimaryBean.class).primaryBeanClass().newInstance();
							if (parentBean instanceof FormMapFiller) {
								((FormMapFiller) parentBean).fill(formMap);
								request.setAttribute("parentBean", parentBean);
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

			if (pageAction.equals(PAGE_ACTION.DELETE) || pageAction.equals(PAGE_ACTION.DELETE_CHILD)) {
				save(request,formMap);
				//initComponent(request);
				try {
					String urlToRedirect = getScriptName(); //getRedirectURL(request,response,FormSaveResult.SUCCESS);
					if (log.isInfoEnabled()) {
						log.info(urlToRedirect + ":" + urlToRedirect);
					}
					//if (request.getAttribute("selectedItrTab") != null) {
					//response.setRenderParameter("selectedItrTab", ((ITRTab)request.getAttribute("selectedItrTab")).name());
					//urlToRedirect += "?selectedItrTab=" +  ((ITRTab)request.getAttribute("selectedItrTab")).name();
					//	}
					//log.info("urlToRedirect EEEEEEEEEEEE"+urlToRedirect);
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

		String redirectToIfPaymentNotFound = getRedirectURLForSiteMapItem(request, response, null,(  (isVendor(request) && isOnVendorPortal()) ? "vendor-servicerequest-itr-payment" : "servicerequest-itr-payment"), getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		String redirectToIfConfirmationNotFound = getRedirectURLForSiteMapItem(request, response, null, (  (isVendor(request) && isOnVendorPortal()) ? "vendor-servicerequest-itr-tos-confirmation" : "servicerequest-itr-tos-confirmation"), getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		if (pageAction != null && (pageAction.equals(PAGE_ACTION.SHOW_ITR_SUMMARY) || pageAction.equals(PAGE_ACTION.DOWNLOAD_ITR_SUMMARY) || pageAction.equals(PAGE_ACTION.DOWNLOAD_ITR_XML) || pageAction.equals(PAGE_ACTION.EMAIL_ITR_XML_AND_SUMMARY)) ) {
			try {
				handleITRSummary(request,response);
			}catch (InvalidXMLException invalidXml) {
				FormMap formMap = new FormMap();//(request,new String[] {"xml","isValid","errors","financialYear"});
				FormField formFieldXml = new FormField("xml");
				FormField formFieldFinancialYear = new FormField("financialYear");

				FormField formFieldPan = new FormField("PAN");
				formFieldPan.addValue(getPAN());
				FormField formFieldFilingStatus = new FormField("itReturnType");
				formFieldFilingStatus.addValue(getITReturnType().name());

				FormField formFieldTheFolderContainingITRDocuments = new FormField("theFolderContainingITRDocuments");
				formFieldFilingStatus.addValue(getTheFolderContainingITRDocuments());


				FormField formFieldReason = new FormField("reason");
				formFieldReason.addValue("Invalid Return");

				ValidationResponse validationResponse = invalidXml.getValidationResponse();
				formFieldXml.addValue(validationResponse.getXml());
				formFieldFinancialYear.addValue(getFinancialYear().getDisplayName());

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
			}
		}
		//new code for bulk
		if (pageAction != null && pageAction == PAGE_ACTION.DOWNLOAD_ITR_XML_BULK_ADD_TO_SESSION) {
			//add and then redirect back to the page
			HttpSession session = request.getSession(true);
			List<String> listOfPaths = (List<String>) session.getAttribute("bulk_download_xml_paths");
			if (listOfPaths == null) {
				listOfPaths = new ArrayList<String>();
			}
			listOfPaths.add(baseRelPathToReturnDocuments);
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
		if (pageAction != null && pageAction == PAGE_ACTION.DOWNLOAD_ITR_XML_BULK) {
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
		if (pageAction != null && pageAction == PAGE_ACTION.RETRIEVE_ITRV_STATUS) {
			if (retrieveITRVService != null) {
				try {
					ITRVStatus itrvStatus = retrieveITRVService.retrieveITRVStatus(getPAN(), getFinancialYear().getAssessmentYearForDITSOAPCall());
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
				}
			}
			else {
				request.setAttribute("isError", "true");
			}
			if (getPageOutputFormat() != null && getPageOutputFormat() == PAGE_OUTPUT_FORMAT.JSON) {
				response.setRenderPath("jsp/common/json_output.jsp");
			}
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if (!hasInitComplete) {
			try {
				initComponent(request,response);
			}catch (InvalidPANException pse) {
				redirectToMemberHome(request,response);
			}
			catch (InvalidNavigationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				redirectToNotFoundPage(response);
				return;
			}
			//hasInitComplete = true;
		}
		FormFields formFields = this.getClass().getAnnotation(FormFields.class);
		String[] vendorFields = formFields.fieldNamesVendorOnly();
		String[] theFieldsArray = formFields.fieldNames();
		if (isVendor(request) && vendorFields != null && vendorFields.length > 0){
			theFieldsArray = (String[]) ArrayUtils.addAll(theFieldsArray, vendorFields);
		}
		formMap = new FormMap(request,theFieldsArray);

		boolean isValid = validate(request,response,formMap);
		if (!isValid) {
			//this action is save
			return;
		}
		sanitize(request,response,formMap);
		if (pageAction.equals(PAGE_ACTION.EDIT) || pageAction.equals(PAGE_ACTION.EDIT_CHILD) || pageAction.equals(PAGE_ACTION.NEW_CHILD)) {
			if (log.isInfoEnabled()) {
				if (formMap != null) {
					for (String aFieldName:formFields.fieldNames()) {
						log.info("Field Name:" + aFieldName + " Value:" +  formMap.getField(aFieldName).getValue());
					}
				}
			}
			save(request,formMap);
			afterSave(request,formMap,pageAction);
			try {
				if (formMap.getMessage() != null && formMap.getMessage().size() > 0 ) {
					String urlToRedirect = getScriptName(); //getRedirectURL(request,response,FormSaveResult.FAILURE) ;
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
					String urlToRedirect = getScriptName(request,response,FormSaveResult.SUCCESS); // getRedirectURL(request,response,FormSaveResult.SUCCESS) ;
					//if the page passes a URL as a parameter take that into consideration
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

	@Override
	public HippoBean getParentBean() {
		// TODO Auto-generated method stub
		return parentBean;
	}

	public final HippoBean getChildBean() {
		return childBean;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserNameNormalized() {
		return userNameNormalized;
	}

	public String getRootMemberFolderRelPath() {
		return this.memberRootFolderRelPath;
	}

	public String getRootMemberFolderAbsolutePath() {
		return this.memberRootFolderAbsolutePath;
	}

	public String getPAN() {
		return pan;
	}

	public String getItrFolderSuffix() {
		return itrFolderSuffix;
	}

	public String getAssessmentYear() {
		return assessmentYear;
	}

	public FinancialYear getFinancialYear() {
		return financialYear;
	}

	public ITReturnType getITReturnType () {
		return itReturnType;
	}

	public String getTheFolderContainingITRDocuments() {
		return theFolderContainingITRDocuments;
	}

	@Override
	public String getMemberUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public String getNormalizedMemberEmail() {
		// TODO Auto-generated method stub
		return userNameNormalized;
	}

	void onBeforeRender(HstRequest request) {
		loadParentBean(request);
		setRequestAttributes(request);
	}

	public final HippoFolder getPanFolder() {
		return panFolder;
	}

	@Override
	public Member getMember() {
		// TODO Auto-generated method stub
		return this.member;
	}



	@Override
	public void setPAN(HstRequest request, String pan) {
		// TODO Auto-generated method stub

	}


	@Override
	public Class<? extends HippoBean> getParentBeanClass() {
		// TODO Auto-generated method stub
		return parentBeanClass;
	}


	@Override
	public String getParentBeanNodeName() {
		// TODO Auto-generated method stub
		PrimaryBean primaryBean = this.getClass().getAnnotation(PrimaryBean.class);
		return primaryBean.primaryBeanClass().getSimpleName().toLowerCase();
	}

	@Override
	public String getParentBeanPath() {
		// TODO Auto-generated method stub
		return parentBeanPath;
	}

	@Override
	public String getParentBeanNameSpace() {
		// TODO Auto-generated method stub
		return parentBeanNameSpace;
	}

	@Override
	public String getNextScreenSiteMapItemRefId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNextScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLastScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ScreenAction getScreenAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrevScreenSiteMapItemRefId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAbsoluteBasePathToReturnDocuments()
			throws InvalidNavigationException {
		// TODO Auto-generated method stub
		return baseAbsolutePathToReturnDocuments;
	}

	@Override
	public String getRelBasePathToReturnDocuments()
			throws InvalidNavigationException {
		// TODO Auto-generated method stub
		return baseRelPathToReturnDocuments;
	}

	@Override
	public DateFormat getDateFormatter() {
		// TODO Auto-generated method stub
		return  new SimpleDateFormat("yyyy-MM-dd");
	}

	public FormMap getFormMap() {
		return formMap;
	}

	public String getScriptName(HstRequest request,HstResponse response, FormSaveResult formSaveResult) {
		// TODO Auto-generated method stub
		String strShouldPostToSelf = request.getRequestContext().getResolvedSiteMapItem().getParameter("shouldPostToSelf");
		if (strShouldPostToSelf != null && strShouldPostToSelf.equals("true")) {
			return scriptName;
		}
		else {
			if (formSaveResult == null || formSaveResult != FormSaveResult.SUCCESS) {
				return scriptName;
			}
			else {
				String redirectURL = null;
				if (isVendor(request) && isOnVendorPortal()) {
					redirectURL = getRedirectURLForSiteMapItem(request,response,formSaveResult,"vendor-servicerequest-itr-summary",getFinancialYear(),getTheFolderContainingITRDocuments(), getPAN());
				}
				else {
					redirectURL = getRedirectURLForSiteMapItem(request,response,formSaveResult,"servicerequest-itr-summary",getFinancialYear(),getTheFolderContainingITRDocuments(), getPAN());
				}
				return redirectURL;
			}
		}
	}


	public String getScriptName() {
		return scriptName;
	}


	public ITReturnPackage getItReturnPackage() {
		return itReturnPackage;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public PAGE_ACTION getPageAction() {
		// TODO Auto-generated method stub
		return pageAction;
	}

	public final HippoBean getHippoBeanMemberBase() {
		return hippoBeanMemberBase;
	}

	protected void initComponent(HstRequest request,HstResponse response) throws InvalidNavigationException,InvalidPANException{
		ResolvedSiteMapItem resolvedMapItem = request.getRequestContext().getResolvedSiteMapItem();
		
		//configuration details for RetrievePanInformation Dit Service.
		String retrievePANInfo = request.getRequestContext().getResolvedSiteMapItem().getParameter("shouldRetrievePANInformation");
		shouldRetrievePANInformation = StringUtils.isNotBlank(retrievePANInfo) && "true".equalsIgnoreCase(retrievePANInfo) ? true : false;
		String validPanWithDit = request.getRequestContext().getResolvedSiteMapItem().getParameter("shouldValidatePANWithDIT");
		shouldValidatePANWithDIT = StringUtils.isNotBlank(validPanWithDit) && "true".equalsIgnoreCase(validPanWithDit) ? true : false;
		
		member = itReturnComponentHelper.getMember(request);
		scriptName = itReturnComponentHelper.getScriptName(request, (String) request.getAttribute("selectedItrTab"), getPublicRequestParameter(request, "selectedItrTab"));
		String strFinancialYear = itReturnComponentHelper.getStrFinancialYear(request, response);  //request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear");
		financialYear =  itReturnComponentHelper.getFinancialYear(strFinancialYear, request, response); //FinancialYear.getByDisplayName(strFinancialYear);
		assessmentYear = itReturnComponentHelper.getAssessmentYear(financialYear);
		theFolderContainingITRDocuments = itReturnComponentHelper.getTheFolderContainingITRDocuments(request, response); //request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType");
		itrFolderSuffix = itReturnComponentHelper.getITRFolderSuffix(theFolderContainingITRDocuments);
		pan = itReturnComponentHelper.getPANFromRequestContext(request);// request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); //original versus amend
		mainSiteMapItemRefId = itReturnComponentHelper.getParamValueFromRequestContext(request, "mainSiteMapItemRefId");// request.getRequestContext().getResolvedSiteMapItem().getParameter("");
		redirectURLToSamePage = getScriptName();// getRedirectURL(request,response,FormSaveResult.FAILURE);
		nextScreenSiteMapItemRefId = itReturnComponentHelper.getParamValueFromRequestContext(request, "nextScreen");// request.getRequestContext().getResolvedSiteMapItem().getParameter("nextScreen");
		//we must make sure itReturnType and PAN are not empty as well as they are valid
		if (!StringUtils.isEmpty(pan) && !DataTypeValidationHelper.isOfType(pan, DataTypeValidationType.PAN)) {
			throw new InvalidPANException("INVALID PAN NUMBER");
		}
		itReturnPackage = itReturnComponentHelper.getITReturnPackage(request);
		filingStatus = itReturnComponentHelper.getFilingStatus(getPAN());
		//how to find the scriptName and the depth
		//one assumption that the scriptName is always .html file and nothing else
		pageOutputFormat = itReturnComponentHelper.getPageOutputFormat(request);


		String strPageAction = request.getRequestContext().getResolvedSiteMapItem().getParameter("action");
		//this is tricky lets allow components to override the configuration by passing it themselves
		//this is useful for form16 -- deductions scenario where a parent is hosting a child
		String strPageActionFromComponent = getParameter("action", request);
		if (strPageActionFromComponent != null) {
			if (log.isInfoEnabled()) {
				log.info("Found action parameter in the component. Will override " + strPageAction + " with the component action " + strPageActionFromComponent );
			}
			strPageAction = strPageActionFromComponent;
		}
		if (strPageAction == null) {
			pageAction = ITReturnScreen.PAGE_ACTION.DEFAULT;
		}
		else {
			String[] listOfPageActions = null;
			listOfPageActions = strPageAction.split("[,]");
			for (String aPageAction:listOfPageActions) {
				try {
					pageAction = ITReturnScreen.PAGE_ACTION.valueOf(aPageAction);
					break;
				}catch (IllegalArgumentException aie) {
					if (log.isInfoEnabled()) {
						log.info("We will now try to find if it contains the classname");
					}
					if (aPageAction != null && aPageAction.contains(this.getClass().getSimpleName().toLowerCase())) {
						int indexOfFirstUnderScore = aPageAction.indexOf("_");
						aPageAction = aPageAction.substring(indexOfFirstUnderScore+1);
						//now lets try the value of AGAIN
						if (log.isInfoEnabled()) {
							log.info("strPageAction after substring=" + aPageAction);
						}
						pageAction = ITReturnScreen.PAGE_ACTION.valueOf(aPageAction);
						break;
					}
				}
			}
		}

		isLoggedIn = request.getUserPrincipal() != null ? true : false;
		userName = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : null;
		userNameNormalized = request.getUserPrincipal() != null ? request.getUserPrincipal().getName().replaceAll("@", "-at-") : null;

		siteContentBaseBean = getSiteContentBaseBean(request);
		String memberFolderName= getMemberFolderPath(request);
		hippoBeanMemberBase = siteContentBaseBean.getBean("members/" + memberFolderName);
		if (hippoBeanMemberBase != null) {
			memberRootFolderAbsolutePath = hippoBeanMemberBase.getPath();
			//we need to get into pans sub folder
			panFolder = hippoBeanMemberBase.getBean("pans", HippoFolder.class) ;// .getChildBeansByName("pans", HippoFolder.class);
			//if (listOfFolders != null && listOfFolders.size() > 0 ){
			//	panFolder = listOfFolders.get(0);
			//}
		}

		baseRelPathToReturnDocuments = itReturnComponentHelper.getBaseRelPathToReturnDocuments(getMemberFolderPath(request), getPAN(), getFinancialYear(), theFolderContainingITRDocuments);  //"members/" + getMemberFolderPath(request) + "/pans/" + getPAN() + "/" + getFinancialYear() + "/" + theFolderContainingITRDocuments; // getITReturnType();
		hippoBeanBaseITReturnDocuments = siteContentBaseBean.getBean(baseRelPathToReturnDocuments);
		baseAbsolutePathToReturnDocuments = itReturnComponentHelper.getBaseAbsolutePathToReturnDocuments(request, baseRelPathToReturnDocuments); //request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + baseRelPathToReturnDocuments;
		//if (hippoBeanBaseITReturnDocuments != null) {
		//	baseAbsolutePathToReturnDocuments = hippoBeanBaseITReturnDocuments.getPath();
		//}
		if (this.getClass().isAnnotationPresent(PrimaryBean.class)) {
			PrimaryBean primaryBean = this.getClass().getAnnotation(PrimaryBean.class);
			parentBeanClass = primaryBean.primaryBeanClass();
			org.hippoecm.hst.content.beans.Node node = parentBeanClass.getAnnotation(org.hippoecm.hst.content.beans.Node.class);
			if (node != null) {
				parentBeanNameSpace	= node.jcrType();
			}
			parentBeanPath = baseRelPathToReturnDocuments + "/" + getParentBeanNodeName();
			parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + getParentBeanNodeName();
		}
		screenMode = GoGreenUtil.getEscapedParameter(request, "screenMode");

		//loading Additional Beans
		loadAllBeansUnderTheMemberPanFolder(request, response);
		//time has come to reset the ITReturnType and other variables
		String keyToMemberPersonalInformation = MemberPersonalInformation.class.getSimpleName().toLowerCase();
		if (mapOfAllBeans != null && mapOfAllBeans.containsKey(keyToMemberPersonalInformation)) {
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) mapOfAllBeans.get(keyToMemberPersonalInformation);
			itReturnType = ITReturnType.getByXmlStatus(memberPersonalInformation.getReturnType()); //this will determine original or revised
		}

		//lets load ValueList Beans
		ValueListBeans valueListBeans = this.getClass().getAnnotation(ValueListBeans.class);
		if (valueListBeans != null && valueListBeans.paths() != null && valueListBeans.paths().length > 0 ) {
			for (int i=0;i<valueListBeans.paths().length;i++) {
				String valueListBeanPath = valueListBeans.paths()[i];
				String accessKey =  valueListBeans.accessKey()[i];
				//attemp to get the list from properties file instead
				//I really don't know what is causing the behavior on zapto server
				//It could be a memory issue, for now the implementation can be changed to ensure the
				String quotedPattern = Pattern.quote("${financialYear}");
				String replacedValueListBeanPath = valueListBeanPath.replaceAll(quotedPattern, financialYear.getDisplayName());
				Properties properties = null;
				InputStream is = this.getClass().getClassLoader().getResourceAsStream("com/mootly/wcm/components/" + replacedValueListBeanPath + ".properties");
				if (is == null) {
					is = this.getClass().getResourceAsStream(replacedValueListBeanPath + ".properties");
				}
				if (is != null) {
					try {
						properties = new Properties();
						properties.load(is);
						log.info("VAlue List Bean's DEtail Item will now be stored as request attribute under :" + accessKey);
					}catch (Exception ex) {
						properties = null;
						log.warn("Error loading properties file from resource. Will attempt to load from CMS value list",ex);
					}
				}
				if (properties != null && properties.size() > 0 ) {
					request.setAttribute(accessKey,properties);
				}
				else {
					String relPath = "common/valuelists/" + replacedValueListBeanPath;
					if (log.isInfoEnabled()) {
						log.info("VAlue List Bean To Load :" + relPath);
					}
					String absPathToBean = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + relPath;
					if (log.isInfoEnabled()) {
						log.info("VAlue List Bean To Load :" + absPathToBean);
					}
					//ValueListDocument valueListDocument = siteContentBase.getBean(relPath,ValueListDocument.class);
					ValueListDocument valueListDocument;
					try {
						valueListDocument = (ValueListDocument) getObjectBeanManager(request).getObject(absPathToBean);
						if (valueListDocument != null && valueListDocument.getValueListDocumentDetailList().size() > 0 ) {
							if (log.isInfoEnabled()) {
								log.info("VAlue List Bean's DEtail Item will now be stored as request attribute under :" + accessKey);
								request.setAttribute(accessKey,valueListDocument.getValueListDocumentDetailMap());
							}
						}
					} catch (ObjectBeanManagerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("Error getting Bean :" + absPathToBean,e);
					}
				}
			}
		}

		onBeforeRender(request);

		if (pageAction.equals(ITReturnScreen.PAGE_ACTION.EDIT_CHILD) || pageAction.equals(ITReturnScreen.PAGE_ACTION.DELETE_CHILD) && parentBean != null) {
			//find the object by uuid
			uuid = request.getRequestContext().getResolvedSiteMapItem().getParameter("uuid");
			if (log.isInfoEnabled()) {
				log.info("We will now be editing the object with UUID:" + uuid);
			}
			if (parentBean != null) {
				List<HippoBean> listOfChildBeans = parentBean.getChildBeans(HippoBean.class);
				if (listOfChildBeans != null && listOfChildBeans.size() > 0) {
					for (HippoBean aBean:listOfChildBeans) {
						if (aBean != null && aBean.getCanonicalUUID() != null && aBean.getCanonicalUUID().equals(uuid)) {
							//childBean = (HippoBean) getObjectBeanManager(request).getObjectByUuid(uuid);
							childBean = aBean;
							request.setAttribute("childBean", childBean);
							break;
						}
					}
				}
			}
			request.setAttribute("uuid", uuid);
		}

		maxChildrenAllowed = request.getRequestContext().getResolvedSiteMapItem().getParameter("maxChildrenAllowed");
		if (maxChildrenAllowed != null) {
			int totalOfCurrentChildren = getTotalChildren();
			if (totalOfCurrentChildren > 0) {
				try {
					int intMaxAllow = Integer.valueOf(maxChildrenAllowed);
					if (totalOfCurrentChildren >= intMaxAllow) {
						request.setAttribute("NEW_CHILD_DISABLED", "true");
					}
				}catch (NumberFormatException nex) {

				}
			}
			if (log.isInfoEnabled()) {
				log.info("maxChildrenAllowed not null :" + maxChildrenAllowed);
			}
		}

		clientSideValidationJSON = ScreenConfigService.generateJSON(this.getClass());

		//lets try to load the SCreen Configuration Document for this component
		String pathToScreenConfig = "configuration/screenconfigs/" + this.getClass().getSimpleName().toLowerCase();
		ScreenConfigDocument screenConfigDocument = siteContentBaseBean.getBean(pathToScreenConfig, ScreenConfigDocument.class);
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
		String isCalc = getPublicRequestParameter(request,"command");
		String screen=getPublicRequestParameter(request, "screen");
		if (isCalc != null && isCalc.equals("calc") && screen!=null) {
			log.info("We are Requesting fot this "+screen+" Screen");
			String pathToScreenCalc = "configuration/screencalculation/" + screen.toLowerCase();
			ScreenCalculation screencalc=siteContentBaseBean.getBean(pathToScreenCalc, ScreenCalculation.class);
			// for screen calcualtions.......
			Map<String,Object> additionalParameters= new HashMap<String,Object>();
			MemberPersonalInformation objMemberInfo= (MemberPersonalInformation) request.getAttribute("memberpersonalinformation");
			if(objMemberInfo != null){
				additionalParameters.put("IsSeniorCitizen",getFinancialYear().isSeniorCitizen(objMemberInfo.getDOB().getTime()));
				if(getFinancialYear().isSeniorCitizen(objMemberInfo.getDOB().getTime())){
					additionalParameters.put("cbasscategory","Senior Citizen");
				}else{
					additionalParameters.put("cbasscategory",objMemberInfo.getSex());
				}
				additionalParameters.put("objMemberInfo",objMemberInfo);
				additionalParameters.put("cbresistatus",objMemberInfo.getResidentCategory());
				additionalParameters.put("cbassyear",getAssessmentYear());
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
	protected boolean validate(HstRequest request,HstResponse response,FormMap formMap) {
		//validate required fields first
		if (this.getClass().isAnnotationPresent(RequiredFields.class)) {
			RequiredFields requiredFieldsAnnotations = this.getClass().getAnnotation(RequiredFields.class);
			String[] fieldNames = requiredFieldsAnnotations.fieldNames();
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
		if (maxChildrenAllowed != null && pageAction == PAGE_ACTION.NEW_CHILD) {
			int maxChildAllowed = Integer.valueOf(maxChildrenAllowed);
			int totalChildren = getTotalChildren();
			if (totalChildren >= maxChildAllowed) {
				formMap.addMessage("generic","An error has occurred");
			}
		}

		StartApplicationValidationService startappvalidserv=new StartApplicationValidationService();
		if(filingStatus.getXmlCode()=="I"){
			startappvalidserv.validResidential(formMap, assessmentYear);
		}
		//validate last name of Member with PAN 
		startappvalidserv.validLastName(formMap);
		//validate last name of Member with Income Tax department by Call RetrievePanInformation Dit Service
		if(shouldValidatePANWithDIT() && shouldRetrievePANInformation()){
			if(formMap.getField("pan")!=null && formMap.getField("pi_last_name")!=null){
				try {
					String lastName = formMap.getField("pi_last_name").getValue();
					RetrievePANResponse retrievePANResponse = retrievePANInformation();
					if(retrievePANResponse!=null && StringUtils.isBlank(retrievePANResponse.getError())){
						//Search last name in RetrievePanResponse's Full Name.
						if(!retrievePANResponse.getFullName().trim().replaceAll(" ", "").toLowerCase().contains(lastName.toLowerCase())){
							formMap.getField("pi_last_name").addMessage("err.match.last.name.dit");
						}
					}
					//change if we don't want to Save Pan If found error In RetrievePanInformation DIT Service
					boolean validpan = false;
					if(retrievePANResponse!=null && StringUtils.isNotBlank(retrievePANResponse.getError()) && validpan){
						formMap.getField("pan").addMessage("err.match.pan.dit");
					}
				} catch (MissingInformationException e) {
					// TODO Auto-generated catch block
					log.error("Error while Calling Dit Mock Service due to lack of Information",e);
				} catch (DataMismatchException e) {
					// TODO Auto-generated catch block
					log.error("Error while Mocking Dit Service for Pan Information due to Data Missed",e);
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					log.error("Error while Mocking Dit Service for Pan Information due to Invalid Format of Inputs",e);
				}
			}
		}
		if (formMap.getMessage() != null && formMap.getMessage().size() > 0) {
			FormUtils.persistFormMap(request, response, formMap, null);
			return false;
		}
		else {
			return true;
		}
	}

	protected int getTotalChildren() {
		if (this.getClass().isAnnotationPresent(ChildBean.class) && parentBean != null) {
			try {
				List<? extends HippoBean> listOfBeans = this.parentBean.getChildBeans(this.getClass().getAnnotation(ChildBean.class).childBeanClass());
				return (listOfBeans != null ? listOfBeans.size() : 0 );
			}
			catch (Exception ex) {
				log.error("An error occurred",ex);
				return -1;
			}
		}
		return 0;
	}

	protected void loadParentBean(HstRequest request) {
		//what we need to do is to get the object using the path
		if (log.isInfoEnabled()) {
			log.info("I will not attempt to fetch the primary bean using the following path:" + getParentBeanPath());
		}
		parentBean = getSiteContentBaseBean(request).getBean(getParentBeanPath(),getParentBeanClass());
	}

	protected void setRequestAttributes(HstRequest request) {
		if (this.getParentBean() != null) {
			request.setAttribute("parentBean", parentBean);
		}
		request.setAttribute("assessmentYear",getAssessmentYear());
		request.setAttribute("financialYear",getFinancialYear());
		request.setAttribute("itReturnType",getITReturnType());
		request.setAttribute("theFolderContainingITRDocuments",getTheFolderContainingITRDocuments());
		request.setAttribute("pan",getPAN());

		request.setAttribute("filingStatus",filingStatus);
		request.setAttribute("itrFolderSuffix",itrFolderSuffix);

		//TO DO we need to get this based on some parameter other wise it is causing issue
		try {
			//HippoBean siteContentBaseBean = getSiteContentBaseBean(request);
			if (siteContentBaseBean != null) request.setAttribute("siteContentBaseBean", siteContentBaseBean);
		}catch (Exception ex) {
			log.info("Error",ex);
		}


		request.setAttribute("pageAction",pageAction);
		request.setAttribute("mainSiteMapItemRefId", mainSiteMapItemRefId);

		request.setAttribute("hippoBeanMemberBase",hippoBeanMemberBase);
		request.setAttribute("panFolder",panFolder);

		if (clientSideValidationJSON!=null) {
			request.setAttribute("clientSideValidationJSON", clientSideValidationJSON);
		}

		if (scriptName != null) {
			request.setAttribute("scriptName", scriptName);
		}

		if (redirectURLToSamePage != null) request.setAttribute("redirectURLToSamePage", redirectURLToSamePage);
		//set attributes in request for RetrievePanInformation Dit Service
		request.setAttribute("shouldRetrievePANInformation", shouldRetrievePANInformation());
		request.setAttribute("shouldValidatePANWithDIT", shouldValidatePANWithDIT());
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
				FinancialYear currentFinancialYear = getFinancialYear();
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

	protected void executeValidationChain(HstRequest request,HstResponse response) {
		//
		Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
		Enumeration<String> enmAttrNames = request.getAttributeNames();
		while (enmAttrNames.hasMoreElements()) {
			String attrName = enmAttrNames.nextElement();
			Object anObj = request.getAttribute(attrName);
			if (anObj instanceof HippoBean) {
				mapOfBeans.put(anObj.getClass().getSimpleName().toLowerCase(), (HippoBean) anObj);
			}
		}

		HippoBeanValidationResponse hippoBeanValidationResponse = itrValidationChain.execute(mapOfBeans);
		if (hippoBeanValidationResponse != null) request.setAttribute("hippoBeanValidationResponse", hippoBeanValidationResponse);

	}

	protected void redirectToMemberHome(HstRequest hstRequest, HstResponse response) {
		try {
			response.setRenderParameter("error", "invalid.pan");
			hstRequest.setAttribute("error", "invalid.pan");
			String forwardTo = "/member/itreturn";
			if (isOnVendorPortal() && isVendor(hstRequest)) forwardTo = "/vendor/itreturn";
			if (getFinancialYear() != null) {
				forwardTo += "/" + getFinancialYear();
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
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,mainSiteMapItemRefId,getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		}
		else if (formSaveResult.equals(FormSaveResult.SUCCESS) && nextScreenSiteMapItemRefId != null) {
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,nextScreenSiteMapItemRefId,getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		}
		else {
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,mainSiteMapItemRefId,getFinancialYear(),getTheFolderContainingITRDocuments(), getPAN());
		}
	}

	public String getRedirectURLForSiteMapItem(HstRequest request,HstResponse response,FormSaveResult formSaveResult,String siteMapReferenceId,FinancialYear financialYear, String folderContainsITReturnDocuments , String pan) {
		if (siteMapReferenceId == null) return null;
		if (financialYear == null || financialYear.equals(FinancialYear.UNKNOWN)) return null;
		if (folderContainsITReturnDocuments == null) return null;
		HstLink link = request.getRequestContext().getHstLinkCreator().createByRefId(siteMapReferenceId, request.getRequestContext().getResolvedMount().getMount());
		if (link != null) {
			String strFirstRep = null;
			if (isOnVendorPortal() && isVendor(request)) {
				strFirstRep = link.toUrlForm(request.getRequestContext(), true).replaceFirst("_default_", getMemberhandleuuid());
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
	protected void save(HstRequest request,FormMap formMap) {
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
			try {
				persistableSession = getPersistableSession(request);
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Error in Save",e);
			}
			wpm = getWorkflowPersistenceManager(persistableSession);
			if (pageAction.equals(PAGE_ACTION.EDIT_CHILD) && childBean != null) {
				try {
					//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
					HippoBean childBeanInSession = (HippoBean) wpm.getObjectByUuid(uuid);
					HippoBean parentBeanInSession = childBeanInSession.getParentBean();
					//now set the value we received from the form submission
					if (childBeanInSession instanceof FormMapFiller) {
						FormMapFiller formMapFiller = (FormMapFiller) childBeanInSession;
						formMapFiller.fill(formMap);
					}
					if (parentBeanInSession instanceof CompoundChildUpdate) {
						CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
						compoundChildUpdate.update(childBeanInSession);
					}
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					if (parentBean != null && childBean != null) {
						try {
							//wpm.update(childBeanInSession);
							if (!beforeSave(request)) return; // don't save if this method returns false
							wpm.update(parentBeanInSession);
						} catch (ObjectBeanPersistenceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							log.error("Error in Save",e);
						}
					}
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.error("Error saving document",e);
					e.printStackTrace();
				}
			}
			else if (pageAction.equals(PAGE_ACTION.NEW_CHILD)) {
				try {
					//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
					HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
					if (parentBeanInSession == null) {
						//gotta create this damn thing
						if (log.isInfoEnabled()) {
							log.info("Parent Bean is missing, we will need to recreate it");
						}
						final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,getParentBeanNameSpace(),getParentBeanNodeName(), true);
						parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);
					}
					//now set the value we received from the form submission
					ChildBean childBeanLocal = getClass().getAnnotation(ChildBean.class);
					//HippoBean newChildBeanInstance = null;
					try {
						childBean = childBeanLocal.childBeanClass().newInstance();
						if (childBean instanceof FormMapFiller) {
							FormMapFiller formMapFiller = (FormMapFiller) childBean;
							formMapFiller.fill(formMap);
						}
						if (parentBeanInSession instanceof CompoundChildUpdate) {
							CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
							compoundChildUpdate.add(childBean);
						}
						wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
						if (parentBeanInSession != null) {
							try {
								//wpm.update(childBeanInSession);
								if (!beforeSave(request)) return; // don't save if this method returns false
								wpm.update(parentBeanInSession);
							} catch (ObjectBeanPersistenceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								log.error("Error in Save",e);
							}
						}
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.error("Error saving document",e);
					e.printStackTrace();
				}
			}
			else if (pageAction.equals(PAGE_ACTION.DELETE_CHILD) && childBean != null) {
				try {
					HippoBean childBeanInSession = (HippoBean) wpm.getObjectByUuid(uuid);
					HippoBean parentBeanInSession = childBeanInSession.getParentBean();
					if (parentBeanInSession instanceof CompoundChildUpdate) {
						CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
						compoundChildUpdate.delete(childBeanInSession);
					}
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					if (parentBeanInSession != null && childBean != null) {
						try {
							//wpm.update(childBeanInSession);
							if (!beforeSave(request)) return; // don't save if this method returns false
							wpm.update(parentBeanInSession);
						} catch (ObjectBeanPersistenceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							log.error("Error in Save",e);
						}
					}

				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.error("Error saving document",e);
					e.printStackTrace();
				}
			}
			else if (pageAction.equals(PAGE_ACTION.EDIT)) {
				try {
					//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
					HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
					if (parentBeanInSession == null) {
						//gotta create this damn thing
						if (log.isInfoEnabled()) {
							log.info("Parent Bean is missing, we will need to recreate it");
						}
						final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,getParentBeanNameSpace(),getParentBeanNodeName(), true);
						parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);
					}
					//now set the value we received from the form submission
					if (parentBeanInSession instanceof FormMapFiller) {
						FormMapFiller formMapFiller = (FormMapFiller) parentBeanInSession;
						formMapFiller.fill(formMap);
					}
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					if (parentBeanInSession != null) {
						try {
							//wpm.update(childBeanInSession);
							if (!beforeSave(request)) return; // don't save if this method returns false
							wpm.update(parentBeanInSession);
						} catch (ObjectBeanPersistenceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							log.error("Error in Save",e);
						}
					}
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.error("Error saving document",e);
					e.printStackTrace();
				}
			}
		}
		finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
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

	public void afterSave(HstRequest request,FormMap map, PAGE_ACTION pageAction) {
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
				HippoBean hippoBean = getSiteContentBaseBean(request).getBean(aPath);
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
	public void handleITRSummary(HstRequest request, HstResponse response) throws InvalidXMLException, PaymentRequiredException, DownloadConfirmationRequiredException{

		String generatedXml = null;
		String generatedHtmlSummary = null;
		String generatedPathToPDF = null;
		String generatedPathToXML = null;

		String downloadBaseFileName = "return-"+ getPAN() +"-AY-" + getFinancialYear().getDisplayAssessmentYear() + "-" + getITReturnType();
		String downloadPDFFileName = downloadBaseFileName  + ".pdf";
		String downloadXMLFileName = downloadBaseFileName  + ".xml";

		boolean isPaid = false;

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		//log.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAFFFFFFFFFFFFFFFFFFFFFFFFFFF"+memberPersonalInformation);
		String ITR = memberPersonalInformation.getFlexField("flex_string_ITRForm", "");
		request.setAttribute("ITR", ITR);

		//time to hand over
		XmlGeneratorService xmlGeneratorService = itrXmlGeneratorServiceFactory.getInstance(getFinancialYear());
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

		if (pageAction.equals(PAGE_ACTION.SHOW_ITR_SUMMARY)) return; //no need to go forward at all

		boolean isValidationRequired = false;
		if (! pageAction.equals(PAGE_ACTION.SHOW_ITR_SUMMARY)) isValidationRequired = true;
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
					boolean panMatched = ( (savedValuesFormMap.getField("PAN") != null && savedValuesFormMap.getField("PAN").getValue().equals(getPAN())) ? true : false);
					boolean financialYearMatched = ( (savedValuesFormMap.getField("financialYear") != null && savedValuesFormMap.getField("financialYear").getValue().equals(getFinancialYear().name())) ? true : false );
					boolean theFolderContainingITRDocumentsMatched = ( (savedValuesFormMap.getField("theFolderContainingITRDocuments") != null && savedValuesFormMap.getField("theFolderContainingITRDocuments").getValue().equals(getTheFolderContainingITRDocuments())) ? true : false);
					boolean userNameMatched = ( (savedValuesFormMap.getField("userName") != null && savedValuesFormMap.getField("userName").getValue().equals(getUserName())) ? true : false );

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


			toBeSavedValuesFormMap.getField("PAN").addValue(getPAN());
			toBeSavedValuesFormMap.getField("financialYear").addValue(getFinancialYear().name());
			toBeSavedValuesFormMap.getField("itReturnType").addValue(getITReturnType().name());
			toBeSavedValuesFormMap.getField("theFolderContainingITRDocuments").addValue(getTheFolderContainingITRDocuments());
			toBeSavedValuesFormMap.getField("userName").addValue(getUserName());
			toBeSavedValuesFormMap.getField("generatedHtmlSummary").addValue(generatedHtmlSummary);
			toBeSavedValuesFormMap.getField("originalPageAction").addValue(pageAction.name());

			String refId = request.getRequestContext().getResolvedSiteMapItem().getHstSiteMapItem().getRefId();
			if (refId != null) {
				String redirectToOriginalPage = getRedirectURLForSiteMapItem(request, response, FormSaveResult.SUCCESS, refId, getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
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
		if (! pageAction.equals(PAGE_ACTION.SHOW_ITR_SUMMARY)) isPaymentRequired = true;
		if (isPaymentRequired && request.getAttribute("memberpayment") != null) {
			try {
				MemberPayment memberPayment = (MemberPayment) request.getAttribute("memberpayment");
				if (memberPayment != null && memberPayment.getPaymentVerificationStatus() != null &&  memberPayment.getPaymentVerificationStatus() == PaymentVerificationStatus.VERIFIED)
				isPaid = true;
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

		if (generatedHtmlSummary != null &&( pageAction == PAGE_ACTION.DOWNLOAD_ITR_SUMMARY || pageAction == PAGE_ACTION.EMAIL_ITR_XML_AND_SUMMARY )) {
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

		if (pageAction == PAGE_ACTION.EMAIL_ITR_XML_AND_SUMMARY) { //time to save the XML in temporary path
			generatedPathToXML = saveXmlToTemporaryFile(generatedXml);
		}

		switch (pageAction) {
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
						to = new String[]{ getUserName(), deliveryEmail };
					}
					else {
						to = new String[]{ getUserName()};
					}

					//sendEmail(request, to, null, new String[] {"info@wealth4india.com"}, "Your IT Return", temporaryPathToPDF + "," + temporaryPathToXML, "Your IT Return Summary", "itreturnSummaryAndXml", null);
					Map<String,Object> vC = new HashMap<String, Object>();
					vC.put("financialYearDisplay", getFinancialYear().getDisplayName());
					vC.put("financialYear", getFinancialYear());

					try {
						MemberPersonalInformation mi = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
						if (mi != null) {
							vC.put ("paymentAmount",mi.getPrice());
						}
					}catch (Exception ex) {

					}

					sendEmail(request, to, generatedPathToXML + "," + generatedPathToPDF,"Attached is your Income Tax Return for Financial Year " + getFinancialYear().getDisplayName(),"w4i_email",vC);
					request.setAttribute("emailMeStatus", "success");
				}
				else {
					request.setAttribute("emailMeStatus", "failure");
				}
		}
		//Object theForm = request.getAttribute("theForm");
	}

	/**
	 * This will save the XML to a temporary location
	 * @param xml
	 * @return
	 */
	protected String saveXmlToTemporaryFile(String xml) {
		BufferedWriter writer = null;
		try
		{
			String tmpDir = System.getProperty("java.io.tmpdir");
			String uuid = UUID.randomUUID().toString();
			new File(tmpDir + "/" + uuid).mkdir();
			String filePath = tmpDir + "/" + uuid + "/" + "itreturn-AY-" +getFinancialYear().getDisplayAssessmentYear() + ".xml";

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
		String pdfFileName = "itreturnsummary-" + getPAN() +"-AY-" + getFinancialYear().getDisplayAssessmentYear() + ".pdf";
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
				to = new String[]{ getUserName(), deliveryEmail };
			}
			else {
				to = new String[]{ getUserName()};
			}

			//sendEmail(request, to, null, new String[] {"info@wealth4india.com"}, "Your IT Return", temporaryPathToPDF + "," + temporaryPathToXML, "Your IT Return Summary", "itreturnSummaryAndXml", null);
			Map<String,Object> vC = new HashMap<String, Object>();
			vC.put("financialYearDisplay", getFinancialYear().getDisplayName());
			vC.put("financialYear", getFinancialYear());
			boolean ret = false;
			try {
				sendEmail(request, to, temporaryPathToPDF + "," + temporaryPathToXML,"Your Income Tax Return for Financial Year " + getFinancialYear().getDisplayName(),"w4i_email",vC);
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
	 * @param response
	 * @param pathToTheItReturn
	 */
	protected void loadAllBeansUnderTheMemberPanFolder(HstRequest request,HstResponse response) {
		HippoBean scopeForAllBeans =  getSiteContentBaseBean(request).getBean(baseRelPathToReturnDocuments);
		HstQuery hstQuery;
		try {
			if (scopeForAllBeans == null) return;
			hstQuery = getQueryManager(request).createQuery( scopeForAllBeans );
			final HstQueryResult result = hstQuery.execute();
			Iterator<HippoBean> itResults = result.getHippoBeans();
			if (log.isInfoEnabled()) {
				log.info("Now will look into all HippoDocuments under the same folder and make a copy of each");
			}
			for (;itResults.hasNext();) {
				HippoBean hippoBean = itResults.next();
				if (hippoBean instanceof HippoDocumentBean) {
					mapOfAllBeans.put(hippoBean.getClass().getSimpleName().toLowerCase(), hippoBean);
					request.setAttribute(hippoBean.getClass().getSimpleName().toLowerCase(), hippoBean);
					if (hippoBean instanceof MemberPersonalInformation) {
						memberPersonalInformation = (MemberPersonalInformation) hippoBean;
					}
				}
			}
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public PAGE_OUTPUT_FORMAT getPageOutputFormat() {
		// TODO Auto-generated method stub
		return pageOutputFormat;
	}

	protected MemberPersonalInformation getMemberPersonalInformation() {
		return memberPersonalInformation;
	}

	protected boolean shouldValidatePANWithDIT() {
		return shouldValidatePANWithDIT;
	}

	protected boolean shouldRetrievePANInformation() {
		return shouldRetrievePANInformation;
	}

	protected RetrievePANResponse retrievePANInformation() throws MissingInformationException, DataMismatchException, InvalidFormatException {
		return retrievePANInformation(getPAN());
	}

	protected RetrievePANResponse retrievePANInformation(String PAN) throws MissingInformationException, DataMismatchException, InvalidFormatException {
		if (retrievePANResponse == null) {
			String argument = PAN;
			if (PAN == null) {
				argument = getPAN();
			}
			retrievePANResponse = retrievePANInformation.retrievePANInformation(argument);
		}
		return retrievePANResponse;
	}

	protected RetrievePANInformation.VALIDATION_RESULT getRetrievePANInformationValidationResult() {
		return retrievePANInformationValidationResult;
	}

}
