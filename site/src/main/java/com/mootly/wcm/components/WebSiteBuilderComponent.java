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

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.jcr.SimpleCredentials;
import javax.servlet.ServletContext;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.CompoundChildUpdate;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.components.ITReturnComponent.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITReturnPackage;
import com.mootly.wcm.model.ITReturnType;
import com.mootly.wcm.model.SORT_DIRECTION;
import com.mootly.wcm.services.ScreenConfigService;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.SequenceGeneratorImpl;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.validation.impl.itr.ITRValidatorChain;

public class WebSiteBuilderComponent extends BaseComponent implements WebSiteBuilderScreen{
	private static final Logger log = LoggerFactory.getLogger(WebSiteBuilderComponent.class);
	String RESELLER_NODE = "reseller";
	ITRValidatorChain itrValidationChain = null;

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
	String cmsRootFolderAbsolutePath = null;
	Member member = null;
	HippoBean hippoBeanCmsBase;
	HippoFolder cmsFolder;
	String componentName = null;
	String componentUUID = null;
	String relativeComponentPath = null;
	String parentBeanUUID = null;
	String absoluteComponentName = null;

	//ITReturn Specific
	String baseRelPathToComponentDocuments;
	String baseAbsolutePathComponentDocuments;
	String assessmentYear;
	FinancialYear financialYear;
	ITReturnType itReturnType = ITReturnType.ORIGINAL;
	String theFolderContainingITRDocuments = null;
	String itrFolderSuffix = null;
	FormMap formMap = null;
	ITReturnPackage itReturnPackage = ITReturnPackage.basic;

	HippoBean siteContentBaseBean = null;
	//Document Specific
	HippoBean hippoBeanBaseComponentDocuments;
	Class<? extends HippoBean> parentBeanClass = null;
	Class<? extends HippoBean> childBeanClass = null;
	String parentBeanNameSpace;
	String parentBeanNodeName;
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

	List<HippoBean> listOfParentChildBeans = null;	
	List<HippoBean> listOfAllPagesComponet = null;
	List<HippoBean> listOfAllBlocksComponet = null;

	String BASE_PATH_TO_PAGES_DOCS = "cms/pages";
	String BASE_PATH_TO_BLOCKS_DOCS = "cms/blocks";

	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		sequenceGenerator = context.getBean(SequenceGeneratorImpl.class);
	}

	public ITReturnComponentHelper getITReturnComponentHelper() {
		return itReturnComponentHelper;
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
			} catch (InvalidNavigationException ine) {
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
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if (!hasInitComplete) {
			try {
				if(log.isInfoEnabled()){
					log.info("Lets Start New implementation::::");
				}
				initComponent(request,response);
			} catch (InvalidNavigationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				redirectToNotFoundPage(response);
				return;
			} catch (ObjectBeanManagerException e){
				log.error("Error while get the Object from repository",e);
			}
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
			log.info("Lets check result of validation:"+isValid);
			//this action is save
			return;
		}
		sanitize(request,response,formMap);
		if (pageAction.equals(PAGE_ACTION.EDIT)|| pageAction.equals(PAGE_ACTION.NEW) || pageAction.equals(PAGE_ACTION.EDIT_CHILD) || pageAction.equals(PAGE_ACTION.NEW_CHILD)) {
			if (log.isInfoEnabled()) {
				if (formMap != null) {
					for (String aFieldName:formFields.fieldNames()) {
						log.info("Field Name:" + aFieldName + " Value:" +  formMap.getField(aFieldName).getValue());
					}
				}
			}
			boolean saveResult = save(request,formMap);
			if (!saveResult) return;
			afterSave(request,formMap,pageAction);
			try {
				if (formMap.getMessage() != null && formMap.getMessage().size() > 0 ) {
					String urlToRedirect = getScriptName(); //getRedirectURL(request,response,FormSaveResult.FAILURE) ;
					if (log.isInfoEnabled()) {
						log.info("URLToRedirect:"+ urlToRedirect);
					}
					response.sendRedirect(urlToRedirect);
				}
				else {
					if (!shouldRedirectAfterSuccess()) return;
					String urlToRedirect = urlToRedirectAfterSuccess(request,response,formMap) ;
					if (urlToRedirect == null) {
						urlToRedirect = getRedirectURLForSiteMapItem(request, response, FormSaveResult.SUCCESS, mainSiteMapItemRefId);//getScriptName(request,response,FormSaveResult.SUCCESS); // getRedirectURL(request,response,FormSaveResult.SUCCESS) ;
						if (log.isInfoEnabled()) {
							log.info("URLToRedirect:::"+ urlToRedirect);
						}
					}
					response.sendRedirect(urlToRedirect);
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
		return this.cmsRootFolderAbsolutePath;
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

	public String getComponentUUID(){
		return componentUUID;
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
		//loadParentBean(request);
		setRequestAttributes(request);
	}

	public final HippoFolder getCmsFolder() {
		return cmsFolder;
	}

	public String getParentBeanUUID(){
		return parentBeanUUID;
	}

	@Override
	public Member getMember() {
		// TODO Auto-generated method stub
		return this.member;
	}

	public String getComponentName(){
		return this.componentName;
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

	public Class<? extends HippoBean> getChildBeanClass() {
		// TODO Auto-generated method stub
		return childBeanClass;
	}


	@Override
	public String getParentBeanNodeName() {
		// TODO Auto-generated method stub
		PrimaryBean primaryBean = this.getClass().getAnnotation(PrimaryBean.class);
		//return primaryBean.primaryBeanClass().getSimpleName().toLowerCase();
		if(parentBeanNodeName == null){
			parentBeanNodeName = primaryBean.primaryBeanClass().getSimpleName().toLowerCase()+UUID.randomUUID();
		}
		return parentBeanNodeName;
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

	public final String getParentBeanAbsolutePath() {
		return parentBeanAbsolutePath;
	}


	@Override
	public String getAbsoluteBasePathToReturnDocuments(){
		// TODO Auto-generated method stub
		return baseAbsolutePathComponentDocuments;
	}

	@Override
	public String getRelBasePathToComponentDocuments(){
		// TODO Auto-generated method stub
		return baseRelPathToComponentDocuments;
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
					//redirectURL = getRedirectURLForSiteMapItem(request,response,formSaveResult,"vendor-servicerequest-itr-summary",getFinancialYear(),getTheFolderContainingITRDocuments(), getPAN());
				}
				else {
					//redirectURL = getRedirectURLForSiteMapItem(request,response,formSaveResult,"servicerequest-itr-summary",getFinancialYear(),getTheFolderContainingITRDocuments(), getPAN());
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
		return hippoBeanCmsBase;
	}

	protected void initComponent(HstRequest request,HstResponse response) throws InvalidNavigationException, ObjectBeanManagerException{
		ResolvedSiteMapItem resolvedMapItem = request.getRequestContext().getResolvedSiteMapItem();

		member = itReturnComponentHelper.getMember(request);
		scriptName = itReturnComponentHelper.getScriptName(request, (String) request.getAttribute("selectedItrTab"), getPublicRequestParameter(request, "selectedItrTab"));
		itrFolderSuffix = itReturnComponentHelper.getITRFolderSuffix(theFolderContainingITRDocuments);

		componentName = itReturnComponentHelper.getParamValueFromRequestContext(request, "componentName");
		componentUUID = resolvedMapItem.getParameter("componentUUID");
		relativeComponentPath = resolvedMapItem.getParameter("relativeComponentPath");
		mainSiteMapItemRefId = itReturnComponentHelper.getParamValueFromRequestContext(request, "mainSiteMapItemRefId");// request.getRequestContext().getResolvedSiteMapItem().getParameter("");
		redirectURLToSamePage = getScriptName();// getRedirectURL(request,response,FormSaveResult.FAILURE);
		nextScreenSiteMapItemRefId = itReturnComponentHelper.getParamValueFromRequestContext(request, "nextScreen");// request.getRequestContext().getResolvedSiteMapItem().getParameter("nextScreen");
		//pageOutputFormat = itReturnComponentHelper.getPageOutputFormat(request);
		absoluteComponentName = resolvedMapItem.getParameter("absoluteComponentName");
		String strPageAction = request.getRequestContext().getResolvedSiteMapItem().getParameter("action");
		//this is tricky lets allow components to override the configuration by passing it themselves
		String strPageActionFromComponent = getParameter("action", request);
		if (strPageActionFromComponent != null) {
			if (log.isInfoEnabled()) {
				log.info("Found action parameter in the component. Will override " + strPageAction + " with the component action " + strPageActionFromComponent );
			}
			strPageAction = strPageActionFromComponent;
		}
		if (strPageAction == null) {
			pageAction = WebSiteBuilderScreen.PAGE_ACTION.DEFAULT;
		}
		else {
			String[] listOfPageActions = null;
			listOfPageActions = strPageAction.split("[,]");
			for (String aPageAction:listOfPageActions) {
				try {
					pageAction = WebSiteBuilderScreen.PAGE_ACTION.valueOf(aPageAction);
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
						pageAction = WebSiteBuilderScreen.PAGE_ACTION.valueOf(aPageAction);
						break;
					}
				}
			}
		}

		isLoggedIn = request.getUserPrincipal() != null ? true : false;
		userName = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : null;
		userNameNormalized = request.getUserPrincipal() != null ? request.getUserPrincipal().getName().replaceAll("@", "-at-") : null;

		siteContentBaseBean = getSiteContentBaseBean(request);
		//String memberFolderName= getMemberFolderPath(request);
		hippoBeanCmsBase = siteContentBaseBean.getBean("cms");
		boolean isReseller = itReturnComponentHelper.isReSeller(request);
		String resellerId = itReturnComponentHelper.getResellerId(request);
		if (isReseller && resellerId != null) {
			hippoBeanCmsBase = getSiteContentBaseBeanForReseller(request).getBean("cms");
		}
		if (hippoBeanCmsBase != null) {
			cmsRootFolderAbsolutePath = hippoBeanCmsBase.getPath();
			//we need to get into pans sub folder
			cmsFolder = hippoBeanCmsBase.getBean("cms", HippoFolder.class) ;// .getChildBeansByName("pans", HippoFolder.class);
		} else {
			cmsFolder = null;
		}

		//baseRelPathToComponentDocuments = itReturnComponentHelper.getBaseRelPathToReturnDocuments(getMemberFolderPath(request), getPAN(), getFinancialYear(), theFolderContainingITRDocuments);  //"members/" + getMemberFolderPath(request) + "/pans/" + getPAN() + "/" + getFinancialYear() + "/" + theFolderContainingITRDocuments; // getITReturnType();
		baseRelPathToComponentDocuments = "cms/"+relativeComponentPath;//itReturnComponentHelper.getBaseRelPathToReturnDocuments(getMemberFolderPath(request), getPAN(), getFinancialYear(), theFolderContainingITRDocuments);
		hippoBeanBaseComponentDocuments = siteContentBaseBean.getBean(baseRelPathToComponentDocuments);
		baseAbsolutePathComponentDocuments =  getCanonicalBasePathForWrite(request) + "/" + baseRelPathToComponentDocuments; //itReturnComponentHelper.getBaseAbsolutePathToReturnDocuments(request, baseRelPathToComponentDocuments); //request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + baseRelPathToComponentDocuments;

		if (this.getClass().isAnnotationPresent(PrimaryBean.class)) {
			PrimaryBean primaryBean = this.getClass().getAnnotation(PrimaryBean.class);
			parentBeanClass = primaryBean.primaryBeanClass();
			org.hippoecm.hst.content.beans.Node node = parentBeanClass.getAnnotation(org.hippoecm.hst.content.beans.Node.class);
			if (node != null) {
				parentBeanNameSpace	= node.jcrType();
			}
			parentBeanUUID = componentUUID;
			if(componentUUID!=null){
				HippoBean getBean = (HippoBean) getObjectBeanManager(request).getObjectByUuid(componentUUID);
				parentBean = getBean;
				parentBeanNodeName = getBean != null ? getBean.getName() : null;
			}else{
				parentBean = null; parentBeanNodeName = null; 
			}
			parentBeanPath = baseRelPathToComponentDocuments + "/" + getParentBeanNodeName();
			parentBeanAbsolutePath = baseAbsolutePathComponentDocuments + "/" + getParentBeanNodeName();
		}
		if (this.getClass().isAnnotationPresent(ChildBean.class)) {
			ChildBean childBean = this.getClass().getAnnotation(ChildBean.class);
			childBeanClass = childBean.childBeanClass();
		}
		screenMode = GoGreenUtil.getEscapedParameter(request, "screenMode");
		mapOfAllBeans = loadBeansAndSetRequestAttributes(request, response);		
		//time has come to reset the ITReturnType and other variables

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

		if (pageAction.equals(WebSiteBuilderScreen.PAGE_ACTION.EDIT_CHILD) || pageAction.equals(WebSiteBuilderScreen.PAGE_ACTION.DELETE_CHILD)) {
			//find the object by uuid
			uuid = request.getRequestContext().getResolvedSiteMapItem().getParameter("uuid");
			if (log.isInfoEnabled()) {
				log.info("We will now be editing the object with UUID:" + uuid);
			}
			if (parentBean != null) {
				List<HippoBean> listOfChildBeans = parentBean.getChildBeans(HippoBean.class);
				log.info("size of Child Bean list::"+listOfChildBeans);
				if (listOfChildBeans != null && listOfChildBeans.size() > 0) {
					for (HippoBean aBean:listOfChildBeans) {
						log.info("size of Child Bean UUID:::"+aBean.getCanonicalUUID());
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
		log.info("Lets get all blocks and pages Documents::");
		listOfAllPagesComponet = loadAllBeansUnderTheFolder(request, response, BASE_PATH_TO_PAGES_DOCS, null, SORT_DIRECTION.ASC);
		listOfAllBlocksComponet = loadAllBeansUnderTheFolder(request, response, BASE_PATH_TO_BLOCKS_DOCS, null, SORT_DIRECTION.ASC);

		onBeforeRender(request);

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
			String[] additionalFieldNames = getRequiredFields();
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
		//additionalv validation
		additionalValidation(request, response, formMap);

		if (formMap.getMessage() != null && formMap.getMessage().size() > 0) {
			log.info("size of message"+formMap.getMessage().size());
			FormUtils.persistFormMap(request, response, formMap, null);
			return false;
		}
		else {
			log.info("could not possible");
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
		parentBean = getSiteContentBaseBeanForReseller(request).getBean(getParentBeanPath(),getParentBeanClass());
	}

	protected void setRequestAttributes(HstRequest request) {
		if (this.getParentBean() != null) {
			request.setAttribute("parentBean", parentBean);
		}
		request.setAttribute("assessmentYear",getAssessmentYear());
		request.setAttribute("financialYear",getFinancialYear());
		request.setAttribute("itReturnType",getITReturnType());
		request.setAttribute("theFolderContainingITRDocuments",getTheFolderContainingITRDocuments());
		request.setAttribute("itrFolderSuffix",itrFolderSuffix);

		//TO DO we need to get this based on some parameter other wise it is causing issue
		try {
			//HippoBean siteContentBaseBean = getSiteContentBaseBean(request);
			if (siteContentBaseBean != null) request.setAttribute("siteContentBaseBean", siteContentBaseBean);
		}catch (Exception ex) {
			log.info("Error",ex);
		}
		request.setAttribute("listOfAllBlocksComponet", listOfAllBlocksComponet);
		request.setAttribute("listOfAllPagesComponet", listOfAllPagesComponet);
		request.setAttribute("pageAction",pageAction);
		request.setAttribute("mainSiteMapItemRefId", mainSiteMapItemRefId);
		request.setAttribute("componentName", componentName);
		request.setAttribute("componentUUID", componentUUID);
		request.setAttribute("absoluteComponentName", absoluteComponentName);
		request.setAttribute("hippoBeanCmsBase",hippoBeanCmsBase);
		request.setAttribute("cmsFolder",cmsFolder);

		if (clientSideValidationJSON!=null) {
			request.setAttribute("clientSideValidationJSON", clientSideValidationJSON);
		}

		if (scriptName != null) {
			request.setAttribute("scriptName", scriptName);
		}

		if (redirectURLToSamePage != null) request.setAttribute("redirectURLToSamePage", redirectURLToSamePage);


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

	public String getRedirectURLForSiteMapItem(HstRequest request,HstResponse response,FormSaveResult formSaveResult,String siteMapReferenceId) {
		if (siteMapReferenceId == null) return getScriptName();
		HstLink link = request.getRequestContext().getHstLinkCreator().createByRefId(siteMapReferenceId, request.getRequestContext().getResolvedMount().getMount());
		if (link != null) {
			String strFirstRep = link.toUrlForm(request.getRequestContext(), true);
			if(!strFirstRep.contains("_default_")){ 
				return strFirstRep;
			}
			else {
				strFirstRep.replaceFirst("_default_", getComponentUUID());
				return strFirstRep;
			}
		}
		else {
			return null;
		}
	}

	/*
	 * The ultimate goal here is to save the parent bean and if it didn't exist then it should have been created in the first place
	 * a child cannot exist without a parent
	 */
	protected boolean save(HstRequest request,FormMap formMap) {
		boolean savedSuccessfully = false;
		//what are we supposed to do??
		if (pageAction.equals(PAGE_ACTION.EDIT_CHILD) && uuid != null) {
			//we are updating a child node here
		}
		else if (pageAction.equals(PAGE_ACTION.DELETE_CHILD) && uuid != null) {
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
			if (pageAction.equals(PAGE_ACTION.EDIT_CHILD) && uuid != null) {
				itReturnComponentHelper.saveUpdateExistingChild(formMap, null, getChildBeanLifeCycleHandler(), getParentBeanLifeCycleHandler(), baseAbsolutePathComponentDocuments, parentBeanAbsolutePath, getParentBeanNameSpace(), getParentBeanNodeName(), getChildBeanClass(), persistableSession, wpm, uuid);
				savedSuccessfully = true;
			}
			else if (pageAction.equals(PAGE_ACTION.NEW_CHILD)) {
				ChildBean childBeanLocal = getClass().getAnnotation(ChildBean.class);
				itReturnComponentHelper.saveAddNewChild(formMap, null, getChildBeanLifeCycleHandler(), getParentBeanLifeCycleHandler(), baseAbsolutePathComponentDocuments, parentBeanAbsolutePath, getParentBeanNameSpace(), getParentBeanNodeName(),  childBeanLocal.childBeanClass(), persistableSession, wpm);
				savedSuccessfully = true;
			}
			else if (pageAction.equals(PAGE_ACTION.DELETE_CHILD) && uuid != null) {
				HippoBean childBeanInSession = (HippoBean) wpm.getObjectByUuid(uuid);
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
				HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
				HippoBean beanBeforeUpdate = parentBeanInSession;
				BeanLifecycle<HippoBean> parentBeanLifeCycleHandler = getParentBeanLifeCycleHandler();
				if (parentBeanInSession == null) {
					//gotta create this damn thing
					if (log.isInfoEnabled()) {
						log.info("Parent Bean is missing, we will need to recreate it");
					}
					final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathComponentDocuments,getParentBeanNameSpace(),getParentBeanNodeName(), true);
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
					wpm.update(parentBeanInSession);
					HippoBean beanAfterUpdate = parentBeanInSession;
					if (parentBeanLifeCycleHandler != null) {
						parentBeanLifeCycleHandler.afterUpdate(beanBeforeUpdate,beanAfterUpdate,wpm,getAbsoluteBasePathToReturnDocuments(), getITReturnComponentHelper());
					}
					savedSuccessfully = true;
				}			
			}else if(pageAction.equals(PAGE_ACTION.NEW)){
				//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
				boolean isNew = false;
				HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
				HippoBean beanBeforeUpdate = parentBeanInSession;
				BeanLifecycle<HippoBean> parentBeanLifeCycleHandler = getParentBeanLifeCycleHandler();
				if (parentBeanInSession == null) {
					//gotta create this damn thing
					if (log.isInfoEnabled()) {
						log.info("Parent Bean is missing, we will need to recreate it");
					}
					final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathComponentDocuments,getParentBeanNameSpace(),getParentBeanNodeName(), true);
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
					wpm.update(parentBeanInSession);
					HippoBean beanAfterUpdate = parentBeanInSession;
					if (parentBeanLifeCycleHandler != null) {
						parentBeanLifeCycleHandler.afterUpdate(beanBeforeUpdate,beanAfterUpdate,wpm,getAbsoluteBasePathToReturnDocuments(), getITReturnComponentHelper());
					}
					savedSuccessfully = true;
				}
			} else if(pageAction.equals(PAGE_ACTION.DELETE) && componentUUID != null){
				HippoBean parentBeanInSession = (HippoBean) wpm.getObjectByUuid(componentUUID);
				wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
				if (parentBeanInSession != null) {
					//wpm.update(childBeanInSession);
					if (!beforeSave(request)) return false; // don't save if this method returns false
					wpm.remove(parentBeanInSession);
					savedSuccessfully = true;						
				}
			}
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error in Save",e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			log.error("Error in Save",e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			log.error("Error in Save",e);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error in Save",e);
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

	public void afterSave(HstRequest request,FormMap map, PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub

	}


	protected Map<String,HippoBean> loadBeansAndSetRequestAttributes(HstRequest request,HstResponse response) {
		//loading Additional Beans
		Map<String,HippoBean> localMapOfAllBeans = new HashMap<String, HippoBean>();
		List<HippoBean> listOfBeans = loadAllBeansUnderTheFolder(request, response,baseRelPathToComponentDocuments,null,null);
		if (listOfBeans != null) {
			localMapOfAllBeans = new HashMap<String, HippoBean>();
			for (HippoBean theBean:listOfBeans) {
				localMapOfAllBeans.put(theBean.getClass().getSimpleName().toLowerCase(), theBean);
			}
		}
		if (localMapOfAllBeans != null && listOfBeans != null) {
			for (String theKey:localMapOfAllBeans.keySet()) {
				request.setAttribute(theKey, localMapOfAllBeans.get(theKey));		
			}			
		}		
		return localMapOfAllBeans;
	}
	/**
	 *
	 * @param request
	 * @param response
	 * @param pathToTheItReturn
	 */
	protected List<HippoBean> loadAllBeansUnderTheFolder(HstRequest request,HstResponse response,String baseRelPathToComponentDocuments,String sortByAttribute,SORT_DIRECTION sortDirection) {
		HippoBean theBean = getSiteContentBaseBeanForReseller(request);
		if (theBean == null) {
			return null;
		}
		HippoBean scopeForAllBeans =  theBean.getBean(baseRelPathToComponentDocuments);
		HstQuery hstQuery;
		List<HippoBean> theLocalBeansUnderMemberFolder = null;
		try {
			if (scopeForAllBeans == null)  return null;
			theLocalBeansUnderMemberFolder = new ArrayList<HippoBean>();
			hstQuery = getQueryManager(request).createQuery( scopeForAllBeans );
			if (sortDirection == null) sortDirection = SORT_DIRECTION.ASC;
			if (sortByAttribute != null) {
				switch (sortDirection) {
				case ASC:
					hstQuery.addOrderByAscending(sortByAttribute);
					break;
				case DESC:
					hstQuery.addOrderByAscending(sortByAttribute);
					break;
				}
			}
			final HstQueryResult result = hstQuery.execute();
			Iterator<HippoBean> itResults = result.getHippoBeans();
			if (log.isInfoEnabled()) {
				log.info("Now will look into all HippoDocuments under the same folder and make a copy of each"+result.getTotalSize());
			}
			for (;itResults.hasNext();) {
				HippoBean hippoBean = itResults.next();
				if (hippoBean instanceof HippoDocumentBean) {
					theLocalBeansUnderMemberFolder.add(hippoBean);
				}
			}
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theLocalBeansUnderMemberFolder;
	}

	protected boolean shouldRedirectAfterSuccess() {
		return true;
	}

	@Override
	public PAGE_OUTPUT_FORMAT getPageOutputFormat() {
		// TODO Auto-generated method stub
		return pageOutputFormat;
	}

	protected BeanLifecycle<HippoBean> getChildBeanLifeCycleHandler() {
		return null;
	}

	protected BeanLifecycle<HippoBean> getParentBeanLifeCycleHandler() {
		return null;
	}

	protected String[] getRequiredFields() {
		return null;
	}

	protected boolean additionalValidation(HstRequest request,HstResponse response,FormMap formMap) {
		return true;
	}

	protected String urlToRedirectAfterSuccess(HstRequest request,HstResponse response,FormMap formMap) {
		return null;
	}

	@Override
	public String getPAN() throws InvalidNavigationException {
		// TODO Auto-generated method stub
		return null;
	}

}
