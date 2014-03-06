package com.mootly.wcm.components;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.configuration.hosting.Mount;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.CompoundChildUpdate;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.compound.InvoiceRefundDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.ITReturnComponent.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.components.ITReturnScreen.PAGE_OUTPUT_FORMAT;
import com.mootly.wcm.components.accounting.InvoiceHelper;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRTab;
import com.mootly.wcm.model.ITReturnPackage;
import com.mootly.wcm.model.ITReturnType;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentUpdateType;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.services.citruspay.Enquiry;
import com.mootly.wcm.services.citruspay.Transaction.ENQUIRY_RESP_CODE;
import com.mootly.wcm.services.citruspay.model.enquiry.EnquiryResponse;
import com.mootly.wcm.services.citruspay.model.enquiry.TxnEnquiryResponse;
import com.mootly.wcm.view.PaymentUpdateResponse;

public final class ITReturnComponentHelper {
	private static final Logger log = LoggerFactory.getLogger(ITReturnComponentHelper.class);
	public Member getMember(HstRequest request) {
		Member member = null;
		if (request.getSession() != null && request.getSession().getAttribute("user") != null) {
			member = (Member)request.getSession().getAttribute("user");
		}
		return member;
	}

	public String getStrFinancialYear(HstRequest request) {
		String strFinancialYear = request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear"); 
		return strFinancialYear;
	}

	public FinancialYear getFinancialYear(String strFinancialYear,HstRequest request) {
		FinancialYear financialYear = FinancialYear.getByDisplayName(strFinancialYear);
		return financialYear;
	}

	public String getAssessmentYear(FinancialYear financialYear) {
		String assessmentYear = null;
		if (financialYear != null && !financialYear.equals(FinancialYear.UNKNOWN)) {
			assessmentYear = financialYear.getDisplayAssessmentYear();
		}
		return assessmentYear;
	}

	public String getTheFolderContainingITRDocuments(HstRequest request) {
		return request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType");
	}

	public String getITRFolderSuffix (String theFolderContainingITRDocuments) {
		String itrFolderSuffix = null;
		if ( theFolderContainingITRDocuments != null) {
			itrFolderSuffix = ITReturnType.getByFolderSuffix( theFolderContainingITRDocuments );
		}
		return itrFolderSuffix;
	}

	public String getPANFromRequestContext(HstRequest request) {
		String PAN = request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); 
		return PAN;
	}

	public ITReturnPackage getITReturnPackage(HstRequest request) {
		String strItReturnPackage = getParamValueFromRequestContext(request, "itReturnPackage");//request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnPackage");
		ITReturnPackage itReturnPackage = ITReturnPackage.basic;
		if (strItReturnPackage == null)
			itReturnPackage = ITReturnPackage.basic;
		else {
			try {
				itReturnPackage = ITReturnPackage.valueOf(strItReturnPackage);
			}catch (IllegalArgumentException ie) {
				itReturnPackage = ITReturnPackage.basic;
			}
		}
		return itReturnPackage;
	}

	public FilingStatus getFilingStatus(String PAN) {
		FilingStatus filingStatus = FilingStatus.UNKNOWN;
		if (!StringUtils.isEmpty(PAN)) {
			char filingStatusChar = PAN.charAt(3);
			filingStatus = FilingStatus.getEnumByFourthChar(filingStatusChar);
		}
		return filingStatus;
	}

	public PAGE_OUTPUT_FORMAT getPageOutputFormat(HstRequest request) {
		String strPageOutputFormat = getParamValueFromRequestContext(request, "outputFormat");
		PAGE_OUTPUT_FORMAT pageOutputFormat = PAGE_OUTPUT_FORMAT.HTML;
		if (strPageOutputFormat != null) {
			try {
				pageOutputFormat = PAGE_OUTPUT_FORMAT.valueOf(strPageOutputFormat);
			}catch(IllegalArgumentException ie) {
				pageOutputFormat = PAGE_OUTPUT_FORMAT.HTML;
			}
		}
		return pageOutputFormat;
	}
	
	/**
	 * baseRelPathToReturnDocuments = "members/" + getMemberFolderPath(request) + "/pans/" + getPAN() + "/" + getFinancialYear() + "/" + theFolderContainingITRDocuments; // getITReturnType();
		hippoBeanBaseITReturnDocuments = siteContentBaseBean.getBean(baseRelPathToReturnDocuments);
		baseAbsolutePathToReturnDocuments = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + baseRelPathToReturnDocuments;
	 */

	public String getBaseRelPathToReturnDocuments(String memberFolderPath,String PAN,FinancialYear financialYear,String theFolderContainingITRDocuments) {
		String retValue = "members/" + memberFolderPath + "/pans/" + PAN + "/" + financialYear + "/" + theFolderContainingITRDocuments;
		return retValue;
	}
	
	public String getBaseRelPathToCategory(String category,String memberFolderPath,String PAN,FinancialYear financialYear,String theFolderContainingITRDocuments) {
		String retValue = "members/" + memberFolderPath + "/"+ category + "/" + PAN + "/" + financialYear + "/" + theFolderContainingITRDocuments;
		return retValue;
	}

	public boolean isReSeller(HstRequest request) {
		final Mount mount = request.getRequestContext().getResolvedMount().getMount();
		final WebsiteInfo info = mount.getChannelInfo();
		if (info == null) {
			log.warn("No channel info available for mount '{}'. No logo will be shown", mount.getMountPath());
			return false;
		}
		String isReseller = info.isReseller();
		String resellerId = info.getResellerId();
		if (info.isReseller() != null && Boolean.valueOf(info.isReseller()) && info.getResellerId() != null && !"".equals(info.getResellerId()) ) {
			return true;
		}        
		return false;
	}

	public String getResellerId(HstRequest request) {
		final Mount mount = request.getRequestContext().getResolvedMount().getMount();
		final WebsiteInfo info = mount.getChannelInfo();
		boolean isReseller = isReSeller(request);
		if ( !isReseller ) return null;
		return info.getResellerId();
	}

	/**
	 * parentBeanPath = baseRelPathToReturnDocuments + "/" + getParentBeanNodeName();
			parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + getParentBeanNodeName();
	 * @param parentBeanClass
	 * @return
	 */
	public String getParentBeanNamespace(Class<? extends HippoBean> parentBeanClass) {
		org.hippoecm.hst.content.beans.Node node = parentBeanClass.getAnnotation(org.hippoecm.hst.content.beans.Node.class);
		if (node != null) {
			String parentBeanNameSpace	= node.jcrType();
			return parentBeanNameSpace;
		}
		return null;
	}

	public String getParentBeanPath(String baseRelPathToReturnDocuments,String parentNodeName) {
		String parentBeanPath =  baseRelPathToReturnDocuments + "/" + parentNodeName;
		return parentBeanPath;
	}

	/**
	 * parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + getParentBeanNodeName();
	 * @param request
	 * @param paramName
	 * @return
	 */
	public String getParentBeanAbsolutePath(String baseAbsolutePathToReturnDocuments, String parentBeanNodeName) {
		String parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + parentBeanNodeName;
		return parentBeanAbsolutePath;
	}

	public String getParentBeanNodeName(Class<? extends HippoBean> parentBeanClass) {
		// TODO Auto-generated method stub
		return parentBeanClass.getSimpleName().toLowerCase();
	}

	public String getParamValueFromRequestContext(HstRequest request,String paramName) {
		String theValue = request.getRequestContext().getResolvedSiteMapItem().getParameter(paramName);
		return theValue;
	}

	/**
	 * Did any thing get updated?
	 * @param pathToInvoiceDocument
	 * @param request
	 * @param enquiry
	 * @param persistableSession
	 * @param wpm
	 * @return
	 * @throws ObjectBeanManagerException
	 */

	public List<PaymentUpdateResponse> syncInvoiceWithPaymentGateway(String pathToInvoiceDocument, HstRequest request,Enquiry enquiry,Session persistableSession,WorkflowPersistenceManager wpm) throws ObjectBeanManagerException {
		/*
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error in Save",e);
		}
		wpm = getWorkflowPersistenceManager(persistableSession);
		 */
		boolean didGotUpdated = false;
		List<PaymentUpdateResponse> listOfPaymentUpdateResponse = new ArrayList<PaymentUpdateResponse>();
		InvoiceDocument invoiceDocumentInSession = (InvoiceDocument) wpm.getObject(pathToInvoiceDocument);
		if (invoiceDocumentInSession == null) return null;
		for (InvoicePaymentDetail invoicePaymentDetail:invoiceDocumentInSession.getInvoicePaymentDetailList()) {
			if ( invoicePaymentDetail.getPaymentType() != null &&  (invoicePaymentDetail.getPaymentType() == PaymentType.NET_BANKING || invoicePaymentDetail.getPaymentType() == PaymentType.CREDIT_CARD || invoicePaymentDetail.getPaymentType() == PaymentType.DEBIT_CARD)) {
				TxnEnquiryResponse theEnquiryOutput = null;
				if (invoicePaymentDetail.getPaymentType() == PaymentType.NET_BANKING) {
					theEnquiryOutput = enquiry.doEnquiry(invoicePaymentDetail.getPaymentTransactionId());
				} else if ( invoicePaymentDetail.getCanonicalHandleUUID() != null && (invoicePaymentDetail.getPaymentVerificationStatus() == null || invoicePaymentDetail.getPaymentVerificationStatus() != PaymentVerificationStatus.VERIFIED) ){
					try {
						theEnquiryOutput = enquiry.doEnquiryForCreditAndDebitCard(invoicePaymentDetail.getPaymentTransactionId());
					}catch (Exception e) {
						log.error("Error in enquiry",e);
					}
				}
				if (theEnquiryOutput != null) {
					if (log.isInfoEnabled()) {
						log.info("Transaction Id:" + invoicePaymentDetail.getPaymentTransactionId());
						log.info("Enquiry Output " + theEnquiryOutput.toString());
						log.info("The canonical UUID" + invoicePaymentDetail.getCanonicalUUID());
					}				
					if (theEnquiryOutput != null && theEnquiryOutput.getEnquiryResponse() != null && theEnquiryOutput.getEnquiryResponse().size() > 0 ) {
						for (EnquiryResponse enquiryResponse : theEnquiryOutput.getEnquiryResponse()) {									
							//update the record 
							if (enquiryResponse.getTxnType().equals("SALE") && invoicePaymentDetail.getCanonicalHandleUUID() != null && (invoicePaymentDetail.getPaymentVerificationStatus() == null || invoicePaymentDetail.getPaymentVerificationStatus() != PaymentVerificationStatus.VERIFIED) ) {
								invoicePaymentDetail.setRespCodeStr(enquiryResponse.getRespCode().name());
								invoicePaymentDetail.setRespMsg(enquiryResponse.getRespMsg());
								invoicePaymentDetail.setRespCode(enquiryResponse.getRespCode());
								if (enquiryResponse.getPgTxnId() != null) invoicePaymentDetail.setPgTxnId(enquiryResponse.getPgTxnId());
								if (invoicePaymentDetail.getPaymentType() == PaymentType.NET_BANKING) {
									invoicePaymentDetail.setTxnAmount(Double.valueOf(enquiryResponse.getAmount()));
								}
								else {
									invoicePaymentDetail.setTxnAmount(invoicePaymentDetail.getPaymentAmount()); //this is because the PAYSEAL is not sending the actual tRansaction amount
								}
								invoicePaymentDetail.setRrn(enquiryResponse.getRRN());
								invoicePaymentDetail.setAuthIdCode(enquiryResponse.getAuthIdCode());
								invoicePaymentDetail.setTxnDateTime(enquiryResponse.getTxnDateTime());
								//this has been verified
								invoicePaymentDetail.setPaymentVerificationStatusStr(PaymentVerificationStatus.VERIFIED.name());
								if ( enquiryResponse.getRespCode() != null && enquiryResponse.getRespCode() == ENQUIRY_RESP_CODE.SUCCESS) {
									listOfPaymentUpdateResponse.add(new PaymentUpdateResponse(PaymentUpdateType.PAYMENT, invoicePaymentDetail.getPaymentType(), enquiryResponse.getAmount(),true));
								}
								else {
									listOfPaymentUpdateResponse.add(new PaymentUpdateResponse(PaymentUpdateType.PAYMENT, invoicePaymentDetail.getPaymentType(), enquiryResponse.getAmount(), false));
								}
								didGotUpdated = true;
							}
							else if (enquiryResponse.getTxnType().equals("REFUND")) { 
								if (!InvoiceHelper.refundExists(request, invoicePaymentDetail.getPaymentType() , invoicePaymentDetail.getPaymentTransactionId() , enquiryResponse.getPgTxnId(), enquiryResponse.getAuthIdCode(), enquiryResponse.getRRN(),invoiceDocumentInSession)) {
									//check if this trans exist otherwise add it
									InvoiceRefundDetail invoiceRefundDetail = new InvoiceRefundDetail();												
									invoiceRefundDetail.setPaymentTransactionId(invoicePaymentDetail.getPaymentTransactionId());
									invoiceRefundDetail.setPaymentType(invoicePaymentDetail.getPaymentType());
									if (enquiryResponse.getRespMsg() != null) invoiceRefundDetail.setRespMsg(enquiryResponse.getRespMsg());
									//if (enquiryResponse.getRespCode() != null) invoiceRefundDetail.setRespCode(enquiryResponse.getRespCode());
									if (enquiryResponse.getAmount() != null) invoiceRefundDetail.setTxnAmount(Double.valueOf(enquiryResponse.getAmount()));
									if (enquiryResponse.getPgTxnId() != null) invoiceRefundDetail.setPgTxnId(enquiryResponse.getPgTxnId());
									if (enquiryResponse.getRRN() != null) invoiceRefundDetail.setRrn(enquiryResponse.getRRN());
									if (enquiryResponse.getAuthIdCode() != null) invoiceRefundDetail.setAuthIdCode(enquiryResponse.getAuthIdCode());
									invoiceRefundDetail.setTxnDateTime(enquiryResponse.getTxnDateTime());
									invoiceRefundDetail.setPaymentVerificationStatusStr(PaymentVerificationStatus.VERIFIED.name());	
									invoiceDocumentInSession.addInvoiceRefundDetail(invoiceRefundDetail);
									listOfPaymentUpdateResponse.add(new PaymentUpdateResponse(PaymentUpdateType.REFUND, invoicePaymentDetail.getPaymentType(), enquiryResponse.getAmount(),true));
									if (!didGotUpdated) didGotUpdated = true;
								}
							}									
						}
					}
				}
			}
		}
		if (didGotUpdated) {
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			wpm.update(invoiceDocumentInSession);
		}
		return ( listOfPaymentUpdateResponse == null || listOfPaymentUpdateResponse.size() == 0 ? null : listOfPaymentUpdateResponse) ;
		//finally{
		//	try { persistableSession.logout(); } finally {}
		//}
	}

	public String getScriptName(HstRequest request,String selectedItrTabAttr,String selectedItrTabParam) {
		String pathInfo = request.getRequestContext().getResolvedSiteMapItem().getPathInfo();
		boolean isReseller = isReSeller(request);
    	String resellerId = getResellerId(request);
    	pathInfo = "r/" + resellerId + "/" + pathInfo;
		String scriptName = null;
		if (pathInfo != null && pathInfo.contains(".html")) {
			String[] parts = pathInfo.split("[/]");
			StringBuilder sb = new StringBuilder(request.getContextPath()).append("/");
			int depth = 1;
			for (String aPart:parts) {
				if (aPart.endsWith(".html")) {
					scriptName= aPart;
					break;
				}
				else {
					sb.append(aPart).append("/");
				}
				depth++;
			}
			sb.append(scriptName);
			//int remainderOFDepth = parts.length - depth;
			//String basePath = "./";
			//for (int ctr =0;ctr<remainderOFDepth;ctr++) {
			//	basePath += "../";
			//}
			//scriptName = basePath + scriptName;
			scriptName = sb.toString();
			if (scriptName.endsWith("/")) scriptName = scriptName.substring(0, scriptName.length()-2);

			//one more loop just to capture the parts after the URL
			List<String> urlParts = new ArrayList<String>();
			boolean startCapturing = false;
			for (String aPart:parts) {
				if (startCapturing) {
					urlParts.add(aPart);
				}
				if (aPart.endsWith(".html")) {
					startCapturing = true;
				}

			}
			if (urlParts != null && urlParts.size() > 0) {
				String[] strParts = urlParts.toArray(new String[urlParts.size()]);
				ITRTab itrTab = ITRTab.getByAka(strParts);
				request.setAttribute("urlParts", urlParts);
				if (itrTab != null) request.setAttribute("selectedItrTab", itrTab);
			}
		}
		if (selectedItrTabAttr == null && selectedItrTabParam != null) {
			ITRTab itrTab = null;
			try {
				itrTab= ITRTab.valueOf(selectedItrTabParam);
				request.setAttribute("selectedItrTab", itrTab);
			}catch (IllegalArgumentException ie) {

			}
		}
		return scriptName;
		//Old Code
		/*
		if (request.getAttribute("selectedItrTab") == null && getPublicRequestParameter(request, "selectedItrTab") != null) {
			ITRTab itrTab = null;
			try {
				itrTab= ITRTab.valueOf(getPublicRequestParameter(request, "selectedItrTab"));
				request.setAttribute("selectedItrTab", itrTab);
			}catch (IllegalArgumentException ie) {

			}
		}
		 */
	}
	public <T extends BeanLifecycle<HippoBean>> void saveSingleDocument (FormMap parentBeanMap,T parentBeanLifeCycleHandler, String baseAbsolutePathToReturnDocuments, String parentBeanAbsolutePath, String parentBeanNameSpace,String parentBeanNodeName, Session persistableSession,WorkflowPersistenceManager wpm) throws ObjectBeanManagerException, InstantiationException, IllegalAccessException {
			//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
			boolean isNew = false;
			HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
			HippoBean beanBeforeUpdate = parentBeanInSession;
			if (parentBeanInSession == null) {
				//gotta create this damn thing
				if (log.isInfoEnabled()) {
					log.info("Parent Bean is missing, we will need to recreate it");
				}
				final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,parentBeanNameSpace,parentBeanNodeName, true);
				parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);
				isNew = true;
				//initParentBean(parentBeanInSession);
			}
			//now set the value we received from the form submission
			if (parentBeanInSession instanceof FormMapFiller) {
				FormMapFiller formMapFiller = (FormMapFiller) parentBeanInSession;
				if (parentBeanLifeCycleHandler != null) parentBeanLifeCycleHandler.beforeFillParentBeanMap(parentBeanInSession);
				if (parentBeanMap != null) formMapFiller.fill(parentBeanMap);
				if (parentBeanLifeCycleHandler != null) parentBeanLifeCycleHandler.afterFillParentBeanMap(parentBeanInSession);
			}
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			if (parentBeanInSession != null) {
				wpm.update(parentBeanInSession);
				//wpm.remove(parentBeanInSession);
				HippoBean beanAfterUpdate = parentBeanInSession;
				if (parentBeanLifeCycleHandler != null) {
					parentBeanLifeCycleHandler.afterUpdate(beanBeforeUpdate,beanAfterUpdate,wpm,parentBeanAbsolutePath,this);
				}
			}			
	}
	
	/*
	 * The written down method will delete a single document
	*/
	public <T extends BeanLifecycle<HippoBean>> void deleteSingleDocument (FormMap parentBeanMap,T parentBeanLifeCycleHandler, String baseAbsolutePathToReturnDocuments, String parentBeanAbsolutePath, String parentBeanNameSpace,String parentBeanNodeName, Session persistableSession,WorkflowPersistenceManager wpm) throws ObjectBeanManagerException, InstantiationException, IllegalAccessException {
		HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
		if (parentBeanInSession == null) {
			final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,parentBeanNameSpace,parentBeanNodeName, true);
			parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);
		}
		wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
		if (parentBeanInSession != null) {
			wpm.remove(parentBeanInSession);
		}			
}
	
	/**
	 * Action to Save Add New Child
	 * @param request
	 * @param formMap
	 * @param baseAbsolutePathToReturnDocuments
	 * @param parentBeanAbsolutePath
	 * @param parentBeanNameSpace
	 * @param parentBeanNodeName
	 * @param childBeanClass
	 * @param persistableSession
	 * @param wpm
	 * @throws ObjectBeanManagerException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public <T extends BeanLifecycle<HippoBean>> void saveAddNewChild (FormMap childBeanMap,FormMap parentBeanMap, T childBeanLifeCycleHandler,T parentBeanLifeCycleHandler, String baseAbsolutePathToReturnDocuments, String parentBeanAbsolutePath, String parentBeanNameSpace,String parentBeanNodeName,  Class<? extends HippoBean> childBeanClass,Session persistableSession,WorkflowPersistenceManager wpm) throws ObjectBeanManagerException, InstantiationException, IllegalAccessException {
			HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
			if (parentBeanInSession == null) {
				//gotta create this damn thing
				if (log.isInfoEnabled()) {
					log.info("Parent Bean is missing, we will need to recreate it");
				}
				//final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,getParentBeanNameSpace(),getParentBeanNodeName(), true);
				final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,parentBeanNameSpace,parentBeanNodeName, true);
				parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);

				//invoke the init method if there is any as a parent bean is created
				if (parentBeanLifeCycleHandler != null) {
					try {
						if (log.isInfoEnabled()) {
							log.info("Handler defined for parent bean creation invoke that handler now");
						}
						parentBeanLifeCycleHandler.afterCreate(parentBeanInSession);
					}catch (Exception  ex) {
						log.error("parentBeanCreatedHandler handler",ex);
					}
				}				
				if (parentBeanInSession instanceof FormMapFiller){
					FormMapFiller formMapFiller = (FormMapFiller) parentBeanInSession;
					if (parentBeanLifeCycleHandler != null) parentBeanLifeCycleHandler.beforeFillParentBeanMap(parentBeanInSession);
					if (parentBeanMap != null) formMapFiller.fill(parentBeanMap);
					if (parentBeanLifeCycleHandler != null) parentBeanLifeCycleHandler.afterFillParentBeanMap(parentBeanInSession);
				}
			}
			//now set the value we received from the form submission
			//ChildBean childBeanLocal = getClass().getAnnotation(ChildBean.class);
			//HippoBean newChildBeanInstance = null;
			if (childBeanClass != null) {
					HippoBean childBean = childBeanClass.newInstance();
					//invoke the init method if there is any as a parent bean is created
					if (childBeanLifeCycleHandler != null) {
						try {
							if (log.isInfoEnabled()) {
								log.info("Handler defined for child bean creation invoke that handler now");
							}
							childBeanLifeCycleHandler.afterCreate(childBean);
						}catch (Exception  ex) {
							log.error("parentBeanCreatedHandler handler",ex);
						}
					}
					if (childBean instanceof FormMapFiller) {
						if (childBeanLifeCycleHandler != null) childBeanLifeCycleHandler.beforeFillChildBeanMap(childBean);						
						FormMapFiller formMapFiller = (FormMapFiller) childBean;
						if (childBeanMap != null) formMapFiller.fill(childBeanMap);
						if (childBeanLifeCycleHandler != null)  childBeanLifeCycleHandler.afterFillChildBeanMap(childBean);
					}
					if (parentBeanInSession instanceof CompoundChildUpdate) {
						CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
						compoundChildUpdate.add(childBean);
					}
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					if (parentBeanInSession != null) {
							//if (!beforeSave(request)) return; // don't save if this method returns false
							wpm.update(parentBeanInSession);						
					}				
			}	
	}

	public <T extends BeanLifecycle<HippoBean>> void saveUpdateExistingChild (FormMap childBeanMap,FormMap parentBeanMap, T childBeanLifeCycleHandler,T parentBeanLifeCycleHandler, String baseAbsolutePathToReturnDocuments, String parentBeanAbsolutePath, String parentBeanNameSpace,String parentBeanNodeName,  Class<? extends HippoBean> childBeanClass,Session persistableSession,WorkflowPersistenceManager wpm,String childBeanCanonicalUUID) throws ObjectBeanManagerException {
			//now set the value we received from the form submission
			//ChildBean childBeanLocal = getClass().getAnnotation(ChildBean.class);
			//HippoBean newChildBeanInstance = null;
			HippoBean childBean = (HippoBean) wpm.getObjectByUuid(childBeanCanonicalUUID);
			HippoBean childBeanBeforeUpdate = childBean;
			if (childBeanClass != null && childBean != null) {
				//HippoBean childBean = childBeanClass.newInstance();
				HippoBean parentBeanInSession = childBean.getParentBean();
				HippoBean parentBeanBeforeUpdate = parentBeanInSession;
				//invoke the init method if there is any as a parent bean is created
				if (childBeanLifeCycleHandler != null) {
					try {
						if (log.isInfoEnabled()) {
							log.info("Handler defined for child bean creation invoke that handler now");
						}							
					}catch (Exception  ex) {
						log.error("parentBeanCreatedHandler handler",ex);
					}
				}
				if (childBean instanceof FormMapFiller) {
					FormMapFiller formMapFiller = (FormMapFiller) childBean;
					if (childBeanLifeCycleHandler != null) childBeanLifeCycleHandler.beforeFillChildBeanMap(childBean);
					if (childBeanMap != null) formMapFiller.fill(childBeanMap);
					if (childBeanLifeCycleHandler != null) childBeanLifeCycleHandler.afterFillChildBeanMap(childBean);
				}
				if (parentBeanInSession instanceof CompoundChildUpdate) {
					CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
					compoundChildUpdate.update(childBean);
				}
				wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
				if (parentBeanInSession != null) {
					try {
						//if (!beforeSave(request)) return; // don't save if this method returns false
						if (childBeanLifeCycleHandler != null) childBeanLifeCycleHandler.beforeUpdate(childBean);
						wpm.update(parentBeanInSession);
						HippoBean childBeanAfterUpdate = childBean;
						HippoBean parentBeanAfterUpdate = parentBeanInSession;
						if (childBeanLifeCycleHandler != null)  childBeanLifeCycleHandler.afterUpdateChild(parentBeanBeforeUpdate,parentBeanAfterUpdate,childBeanBeforeUpdate,childBeanAfterUpdate,wpm,this);
					} catch (ObjectBeanPersistenceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("Error in Save",e);
					}
				}
			}		
	}
	
	public void saveElementsToRepository(String baseAbsolutePathToReturnDocuments,List<? extends Object> listOfObjects,Class<? extends HippoBean> parentBeanClass,Class<? extends HippoBean> childBeanClass,Session persistableSession, WorkflowPersistenceManager wpm) throws InvalidNavigationException, InstantiationException, IllegalAccessException, ObjectBeanManagerException {
		FormMapHelper formMapHelper = new FormMapHelper();
		if (listOfObjects != null && listOfObjects.size() > 0) {
			for (Object anObject:listOfObjects) {
				String parentBeanNodeName = getParentBeanNodeName(parentBeanClass);
				String parentBeanNameSpace = getParentBeanNamespace(parentBeanClass);
				String parentBeanAbsolutePath = getParentBeanAbsolutePath(baseAbsolutePathToReturnDocuments, parentBeanNodeName);
				//Class<? extends HippoBean> childBeanClass = SelfAssesmentTaxDetail.class;
				FormMap formMap = formMapHelper.convertToFormMap(anObject);
				saveAddNewChild(formMap,null, null, null, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, childBeanClass, persistableSession, wpm);
			}
		}
	}

}
