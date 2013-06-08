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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
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
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;

import com.mootly.wcm.beans.ScreenCalculation;
import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRTab;
import com.mootly.wcm.model.ITReturnPackage;
import com.mootly.wcm.model.ITReturnType;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.services.ScreenConfigService;
import com.mootly.wcm.services.StartApplicationValidationService;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.XmlCalculation;

public class ITReturnComponent extends BaseComponent implements ITReturnScreen{
	private static final Logger log = LoggerFactory.getLogger(ITReturnComponent.class);

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

	//MemberPersonalInformation memberPersonalInformation = null;
	//Screen Specific
	PAGE_ACTION pageAction;
	String screenMode;
	String nextScreenSiteMapItemRefId;

	String mainSiteMapItemRefId = null;

	String clientSideValidationJSON;

	///Name of the HTML File and the depth its in
	String scriptName; 

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		if (!hasInitComplete) {
			try {
				initComponent(request,response);
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

		if (getClass().isAnnotationPresent(FormFields.class)) {
			FormFields formFields = this.getClass().getAnnotation(FormFields.class);
			FormMap formMap = new FormMap(request,formFields.fieldNames());
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
		formMap = new FormMap(request,formFields.fieldNames());

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
					String urlToRedirect = getScriptName(); // getRedirectURL(request,response,FormSaveResult.SUCCESS) ;
					//if the page passes a URL as a parameter take that into consideration
					if (request.getParameter("successURL") != null) {
						urlToRedirect  = request.getParameter("successURL");
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

	public String getAssessmentYear() {
		return assessmentYear;
	}

	public FinancialYear getFinancialYear() {
		return financialYear;
	}

	public ITReturnType getITReturnType () {
		return itReturnType;
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

	protected void findScriptName(HstRequest request) {
		String pathInfo = request.getRequestContext().getResolvedSiteMapItem().getPathInfo();
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
		if (request.getAttribute("selectedItrTab") == null && getPublicRequestParameter(request, "selectedItrTab") != null) {
			ITRTab itrTab = null;
			try {
				itrTab= ITRTab.valueOf(getPublicRequestParameter(request, "selectedItrTab"));
				request.setAttribute("selectedItrTab", itrTab);
			}catch (IllegalArgumentException ie) {

			}
		}
	}

	protected void initComponent(HstRequest request,HstResponse response) throws InvalidNavigationException,InvalidPANException{
		ResolvedSiteMapItem resolvedMapItem = request.getRequestContext().getResolvedSiteMapItem();
		if (request.getSession() != null && request.getSession().getAttribute("user") != null) {
			member = (Member)request.getSession().getAttribute("user");
		}
		findScriptName(request);
		//assessmentYear = request.getRequestContext().getResolvedSiteMapItem().getParameter("assessmentYear");
		String strFinancialYear = request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear");
		financialYear =  FinancialYear.getByDisplayName(strFinancialYear);
		if (financialYear != null && !financialYear.equals(FinancialYear.UNKNOWN)) {
			assessmentYear = financialYear.getDisplayAssessmentYear();
		}
		itReturnType = ITReturnType.getByDisplayName(request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType")); //original versus amend
		pan = request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); //original versus amend

		if (mainSiteMapItemRefId == null) mainSiteMapItemRefId = request.getRequestContext().getResolvedSiteMapItem().getParameter("mainSiteMapItemRefId");
		redirectURLToSamePage = getScriptName();// getRedirectURL(request,response,FormSaveResult.FAILURE);

		nextScreenSiteMapItemRefId = request.getRequestContext().getResolvedSiteMapItem().getParameter("nextScreen");

		//we must make sure itReturnType and PAN are not empty as well as they are valid
		if (!StringUtils.isEmpty(pan) && !DataTypeValidationHelper.isOfType(pan, DataTypeValidationType.PAN)) {
			throw new InvalidPANException("INVALID PAN NUMBER");
		}
		if (itReturnType != null && itReturnType.equals(ITReturnType.UNKNOWN)) {
			throw new InvalidNavigationException("INVALID ITRETURUN TYPE");
		}

		String strItReturnPackage = request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnPackage");
		if (strItReturnPackage == null)
			itReturnPackage = ITReturnPackage.basic;
		else {
			try {
				itReturnPackage = ITReturnPackage.valueOf(strItReturnPackage);
			}catch (IllegalArgumentException ie) {
				log.warn("Illegal Argument:" + strItReturnPackage);
				itReturnPackage = ITReturnPackage.basic;
			}
		}

		//NOW find 
		if (!StringUtils.isEmpty(pan)) {
			char filingStatusChar = pan.charAt(3);
			filingStatus = FilingStatus.getEnumByFourthChar(filingStatusChar);
		}

		//how to find the scriptName and the depth
		//one assumption that the scriptName is always .html file and nothing else
		String actionInSiteMap =  resolvedMapItem.getLocalParameter("action");
		String tabName = "";
		if (actionInSiteMap != null && actionInSiteMap.contains("_")) {
			tabName = actionInSiteMap.substring(0,actionInSiteMap.indexOf("_"));
		}

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
		hippoBeanMemberBase = siteContentBaseBean.getBean("members/" + getNormalizedMemberEmail());
		if (hippoBeanMemberBase != null) {
			memberRootFolderAbsolutePath = hippoBeanMemberBase.getPath();
			//we need to get into pans sub folder 
			panFolder = hippoBeanMemberBase.getBean("pans", HippoFolder.class) ;// .getChildBeansByName("pans", HippoFolder.class);
			//if (listOfFolders != null && listOfFolders.size() > 0 ){
			//	panFolder = listOfFolders.get(0);
			//}
		}

		baseRelPathToReturnDocuments = "members/" + getNormalizedMemberEmail() + "/pans/" + getPAN() + "/" + getFinancialYear() + "/" + getITReturnType();
		hippoBeanBaseITReturnDocuments = siteContentBaseBean.getBean(baseRelPathToReturnDocuments);
		baseAbsolutePathToReturnDocuments = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + baseRelPathToReturnDocuments;
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
		AdditionalBeans additionalBeans = this.getClass().getAnnotation(AdditionalBeans.class);
		if (additionalBeans != null && additionalBeans.additionalBeansToLoad() != null && additionalBeans.additionalBeansToLoad().length > 0 ) {
			for (Class<? extends HippoBean> additionalBean:additionalBeans.additionalBeansToLoad()) {
				String additionalBeanPathToLoad = baseAbsolutePathToReturnDocuments + "/" + additionalBean.getSimpleName().toLowerCase();
				if (log.isInfoEnabled()) {
					log.info("additionalBeanPathToLoad:" + additionalBeanPathToLoad);
				}
				try {
					Object o = getObjectBeanManager(request).getObject(additionalBeanPathToLoad);
					request.setAttribute(additionalBean.getSimpleName().toLowerCase(),o);
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
			}
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
					if (StringUtils.isEmpty( formMap.getField(aRequiredField).getValue() ) ) {
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
		StartApplicationValidationService startappvalidserv=new StartApplicationValidationService();
		startappvalidserv.validResidential(formMap, assessmentYear);

		if (formMap.getMessage() != null && formMap.getMessage().size() > 0) {
			FormUtils.persistFormMap(request, response, formMap, null);
			return false;
		}
		else {
			return true;
		}
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
		request.setAttribute("pan",getPAN());

		request.setAttribute("filingStatus",filingStatus);

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
	}

	protected void redirectToMemberHome(HstRequest hstRequest, HstResponse response) {
		try {
			response.setRenderParameter("error", "invalid.pan");
			hstRequest.setAttribute("error", "invalid.pan");
			String forwardTo = "/member/itreturn";
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
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,mainSiteMapItemRefId,getFinancialYear(), getITReturnType(), getPAN());
		}
		else if (formSaveResult.equals(FormSaveResult.SUCCESS) && nextScreenSiteMapItemRefId != null) {
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,nextScreenSiteMapItemRefId,getFinancialYear(), getITReturnType(), getPAN());
		}
		else {
			return getRedirectURLForSiteMapItem(request, response, formSaveResult,mainSiteMapItemRefId,getFinancialYear(),getITReturnType(), getPAN());
		}
	}

	public String getRedirectURLForSiteMapItem(HstRequest request,HstResponse response,FormSaveResult formSaveResult,String siteMapReferenceId,FinancialYear financialYear, ITReturnType itReturnType,String pan) {
		if (siteMapReferenceId == null) return null;
		if (financialYear == null || financialYear.equals(FinancialYear.UNKNOWN)) return null;
		if (itReturnType == null || itReturnType.equals(ITReturnType.UNKNOWN)) return null;
		HstLink link = request.getRequestContext().getHstLinkCreator().createByRefId(siteMapReferenceId, request.getRequestContext().getResolvedMount().getMount());
		if (link != null) {
			String strFirstRep = link.toUrlForm(request.getRequestContext(), true).replaceFirst("_default_", financialYear.toString());
			strFirstRep = strFirstRep.replaceFirst("_default_",itReturnType.toString());
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

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void afterSave() {
		// TODO Auto-generated method stub

	}

}
