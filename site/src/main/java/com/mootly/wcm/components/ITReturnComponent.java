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
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
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
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RegExValidationFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.annotations.ValueListBeans;
import com.mootly.wcm.annotations.DataTypeValidationHelper.DataTypeValidationType;
import com.mootly.wcm.beans.CompoundChildUpdate;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SourceOfIncomeDocument;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.beans.compound.ValueListDocumentDetail;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.member.SignupDetail.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.utils.GoGreenUtil;

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
	String itReturnType = "original";
	String pan = null;
	
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
	
	String mainSiteMapItemRefId;

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
			}
			//hasInitComplete = true;
		}
		if (getClass().isAnnotationPresent(FormFields.class)) {
			FormFields formFields = this.getClass().getAnnotation(FormFields.class);
			FormMap formMap = new FormMap(request,formFields.fieldNames());
			FormUtils.populate(request, formMap);
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
					response.sendRedirect( getRedirectURL(request,response,FormSaveResult.SUCCESS));
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
			 log.info("requiredBeansList.length"+requiredBeansList.length);
			 if (requiredBeansList!= null && requiredBeansList.length > 0) {
				 for (Class<? extends HippoBean> aBean:requiredBeansList) {
					 if (request.getAttribute(aBean.getSimpleName().toLowerCase()) == null) {
						 log.info("it is bean name in lower case::"+aBean.getSimpleName().toLowerCase());
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
		FormMap formMap = new FormMap(request,formFields.fieldNames());
		
		boolean isValid = validate(request,response,formMap);
		if (!isValid) {
			//this action is save
			return;
		}
		if (pageAction.equals(PAGE_ACTION.EDIT) || pageAction.equals(PAGE_ACTION.EDIT_CHILD) || pageAction.equals(PAGE_ACTION.NEW_CHILD)) {
			//lets save the document
			//interesting how to get all the form data			
			if (log.isInfoEnabled()) {
				if (formMap != null) {
					for (String aFieldName:formFields.fieldNames()) {
						log.info("Field Name:" + aFieldName + " Value:" +  formMap.getField(aFieldName).getValue());
					}
				}
			}
			save(request,formMap);
			try {
				response.sendRedirect( getRedirectURL(request,response,FormSaveResult.SUCCESS) );
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

	public String getITReturnType () {
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
	
	
	
	@Override
	public PAGE_ACTION getPageAction() {
		// TODO Auto-generated method stub
		return pageAction;
	}
	
	public final HippoBean getHippoBeanMemberBase() {
		return hippoBeanMemberBase;
	}
	
	protected void initComponent(HstRequest request,HstResponse response) throws InvalidNavigationException,InvalidPANException{
		if (request.getSession() != null && request.getSession().getAttribute("user") != null) {
			member = (Member)request.getSession().getAttribute("user");
		}

		assessmentYear = request.getRequestContext().getResolvedSiteMapItem().getParameter("assessmentYear");
		itReturnType = request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType"); //original versus amend
		pan = request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); //original versus amend
		log.info("assessmentYear"+assessmentYear);
		log.info("itReturnType"+itReturnType);
		log.info("pan"+pan);
		
		//we must make sure itReturnType and PAN are not empty as well as they are valid
		if (!StringUtils.isEmpty(pan) && !DataTypeValidationHelper.isOfType(pan, DataTypeValidationType.PAN)) {
			throw new InvalidPANException("INVALID PAN NUMBER");
		}
		if (!StringUtils.isEmpty(itReturnType) && !DataTypeValidationHelper.isOfType(itReturnType, DataTypeValidationType.ITRETURNTYPE)) {
			throw new InvalidNavigationException("INVALID ITRETURUN TYPE");
		}
		
		String strPageAction = request.getRequestContext().getResolvedSiteMapItem().getParameter("action");
		if (strPageAction == null) {
			pageAction = ITReturnScreen.PAGE_ACTION.DEFAULT;
		}
		else {
			pageAction = ITReturnScreen.PAGE_ACTION.valueOf(strPageAction);
		}

		isLoggedIn = request.getUserPrincipal() != null ? true : false;
		userName = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : null;
		userNameNormalized = request.getUserPrincipal() != null ? request.getUserPrincipal().getName().replaceAll("@", "-at-") : null;
		
		HippoBean siteContentBase = getSiteContentBaseBean(request);
		hippoBeanMemberBase = siteContentBase.getBean("members/" + getNormalizedMemberEmail());
		if (hippoBeanMemberBase != null) {
			memberRootFolderAbsolutePath = hippoBeanMemberBase.getPath();
			//we need to get into pans sub folder 
			List<HippoFolder> listOfFolders = hippoBeanMemberBase.getChildBeansByName("pans", HippoFolder.class);
			if (listOfFolders != null && listOfFolders.size() > 0 ){
				panFolder = listOfFolders.get(0);
			}
		}
		
		baseRelPathToReturnDocuments = "members/" + getNormalizedMemberEmail() + "/pans/" + getPAN() + "/" + getAssessmentYear() + "/" + getITReturnType();
		log.info("baseRelPathToReturnDocuments"+baseRelPathToReturnDocuments);
		hippoBeanBaseITReturnDocuments = siteContentBase.getBean(baseRelPathToReturnDocuments);
		baseAbsolutePathToReturnDocuments = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + baseRelPathToReturnDocuments;
		log.info("baseAbsolutePathToReturnDocuments"+baseAbsolutePathToReturnDocuments);
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
				String quotedPattern = Pattern.quote("${assessmentYear}");
				String replacedValueListBeanPath = valueListBeanPath.replaceAll(quotedPattern, assessmentYear);
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
		
		
		
		mainSiteMapItemRefId = request.getRequestContext().getResolvedSiteMapItem().getParameter("mainSiteMapItemRefId");
		log.info("mainSiteMapItemRefId"+mainSiteMapItemRefId);
		redirectURLToSamePage = getRedirectURL(request,response,FormSaveResult.FAILURE);
		log.info("redirectURLToSamePage"+redirectURLToSamePage);
		onBeforeRender(request);
		
		
		if (pageAction.equals(ITReturnScreen.PAGE_ACTION.EDIT_CHILD) || pageAction.equals(ITReturnScreen.PAGE_ACTION.DELETE_CHILD) && parentBean != null) {
			//find the object by uuid
			uuid = request.getRequestContext().getResolvedSiteMapItem().getParameter("uuid");
			if (log.isInfoEnabled()) {
				log.info("We will now be editing the object with UUID:" + uuid);				
			}
			List<HippoBean> listOfChildBeans = parentBean.getChildBeans(HippoBean.class);
			if (listOfChildBeans != null && listOfChildBeans.size() > 0) {
				log.info("LIST OF CHILD BEans SIZE:::::"+listOfChildBeans.size());
				for (HippoBean aBean:listOfChildBeans) {
					log.info("FINDING TO MATCH THE UUID BEFORE FUNCTION"+aBean.getCanonicalUUID());
					if (aBean != null && aBean.getCanonicalUUID() != null && aBean.getCanonicalUUID().equals(uuid)) {
						//childBean = (HippoBean) getObjectBeanManager(request).getObjectByUuid(uuid);
						log.info("FINDING TO MATCH THE UUID INSIDE FUNCTION"+aBean.getCanonicalUUID());
						childBean = aBean;
						request.setAttribute("childBean", childBean);
						break;
					} 
				}
			}
			request.setAttribute("uuid", uuid);
		}
		
		
		JSONObject jsonForValidators = new JSONObject();
		//this to serialze the validators and send it to the jsp pages if they want to builds things dynamically
		if (this.getClass().isAnnotationPresent(RequiredFields.class)) {
			RequiredFields requiredFieldsAnnotations = this.getClass().getAnnotation(RequiredFields.class);
			String[] fieldNames = requiredFieldsAnnotations.fieldNames();
			try {
				jsonForValidators.put("requiredFields", fieldNames);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				log.warn("Error converting Required Fields to JSON",e);
				e.printStackTrace();
			}
		}
		
		if (this.getClass().isAnnotationPresent(RegExValidationFields.class)) {
			RegExValidationFields regExFieldsAnnotations = this.getClass().getAnnotation(RegExValidationFields.class);
			String[] fieldNames = regExFieldsAnnotations.fieldNames();
			String[] patterns = regExFieldsAnnotations.patterns();
			try {
				jsonForValidators.put("regExFields", fieldNames);
				jsonForValidators.put("regExPatterns", patterns);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				log.warn("Error converting Required Fields to JSON",e);
				e.printStackTrace();
			}
		}
		
		if (jsonForValidators != null) {
			StringWriter sw = new StringWriter();
			try {
				jsonForValidators.write(sw);
				request.setAttribute("jsonForValidators",sw.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			DataTypeValidationHelper.DataTypeValidationType[] dataTypes = dataTypeValidationFields.dataTypes();
			for (int i=0;i<fieldNames.length;i++) {
				String whatToMatch = formMap.getField(fieldNames[i]).getValue();
				DataTypeValidationHelper.DataTypeValidationType dataType = dataTypes[i];
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
		request.setAttribute("itReturnType",getITReturnType());
		request.setAttribute("pan",getPAN());
		
		request.setAttribute("pageAction",pageAction);
		request.setAttribute("mainSiteMapItemRefId", mainSiteMapItemRefId);
		
		request.setAttribute("hippoBeanMemberBase",hippoBeanMemberBase);
		request.setAttribute("panFolder",panFolder);
		
		if (redirectURLToSamePage != null) {
			request.setAttribute("redirectURLToSamePage", redirectURLToSamePage);
		
		}
	}
	
	protected void redirectToMemberHome(HstRequest hstRequest, HstResponse response) {
		try {
			response.setRenderParameter("error", "invalid.pan");
			hstRequest.setAttribute("error", "invalid.pan");
			String forwardTo = "/member/itreturn";
			if (getAssessmentYear() != null) {
				forwardTo += "/" + getAssessmentYear();
			}
			response.forward(forwardTo);
		} catch (IOException e) {
			throw new HstComponentException(e);
		}
	}
	
	protected void redirectToNotFoundPage(HstResponse response) {
		try {
			response.forward("/404");
			log.info("redirect this page to 404 page not found");
		} catch (IOException e) {
			throw new HstComponentException(e);
		}
	}
	
	protected String getRedirectURL(HstRequest request,HstResponse response,FormSaveResult formSaveResult) {
		HstLink link = request.getRequestContext().getHstLinkCreator().createByRefId(mainSiteMapItemRefId, request.getRequestContext().getResolvedMount().getMount());
		if (link != null) {
			String strFirstRep = link.toUrlForm(request.getRequestContext(), true).replaceFirst("_default_", getITReturnType());
			strFirstRep = strFirstRep.replaceAll("_default_", getPAN());
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
