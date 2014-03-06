package com.mootly.wcm.components;

import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.jcr.ItemNotFoundException;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.ObjectBeanManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryManager;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.ValueListBeans;
import com.mootly.wcm.beans.DITResponseDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.channels.ChannelInfoWrapper;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITReturnPackage;
import com.mootly.wcm.model.ITReturnType;
import com.mootly.wcm.model.SORT_DIRECTION;
import com.mootly.wcm.services.MasterConfigService;
import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.RetrievePANInformation.VALIDATION_RESULT;
import com.mootly.wcm.utils.GoGreenUtil;


/**
 * The major issue with using class level variables, we must remove all class level variables and ensure instance of this class is used
 * @author Amit
 *
 */
public class ITReturnInitData implements Serializable, ITReturnScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5284958102723888791L;
	//local variables
	//boolean hasInitComplete = false;
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
	//Document Specific
	HippoBean hippoBeanBaseITReturnDocuments;
	Class<? extends HippoBean> parentBeanClass = null;
	Class<? extends HippoBean> childBeanClass = null;
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
	String fileName;
	Map<String,HippoBean> mapOfAllBeans = new HashMap<String, HippoBean>();
	MemberPersonalInformation memberPersonalInformation;
	DITResponseDocument ditResponseDocument;
	boolean shouldRetrievePANInformation = false;
	boolean shouldValidatePANWithDIT = false;
	boolean ditInvalidPanContnue = false; 
	RetrievePANInformation.VALIDATION_RESULT retrievePANInformationValidationResult = VALIDATION_RESULT.NOT_INITIATED;
	String strIsOnVendorPortal;
	String strIsOnSystemAdminPortal;
	boolean isVendor;
	String memberhandleuuid;
	String memberFolderPath;
	boolean isReseller = false; //itReturnComponentHelper.isReSeller(request);
	String resellerId = null; //itReturnComponentHelper.getResellerId(request);

	String cmsApplicationUrl = null;
	ChannelInfoWrapper channelInfoWrapper = null;
	WebsiteInfo webSiteInfo = null;

	final ITReturnComponentHelper itReturnComponentHelper;
	final HippoBean siteContentBaseBean;
	final ObjectBeanManager objectBeanManager;
	final HstQueryManager queryManager;
	final String canonicalBasePathForWrite;
	final ComponentConfiguration componentConfig;
	final Class<? extends BaseComponent> componentClass;

	Logger log = LoggerFactory.getLogger(ITReturnInitData.class);


	public ITReturnInitData (final HstRequest request,final ITReturnComponentHelper itReturnComponentHelper,final HippoBean siteContentBaseBean,final ObjectBeanManager objectBeanManager,final HstQueryManager queryManager,final String canonicalBasePathForWrite,final ComponentConfiguration componentConfig, Class<? extends BaseComponent> componentClass) {
		this.itReturnComponentHelper = itReturnComponentHelper;
		this.siteContentBaseBean = siteContentBaseBean;
		this.objectBeanManager = objectBeanManager;
		this.queryManager = queryManager;
		this.canonicalBasePathForWrite = canonicalBasePathForWrite;
		this.componentConfig = componentConfig;
		this.componentClass = componentClass;
		
		initComponent2(request);
		initComponent(request);
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

	protected String getStrIsOnVendorPortal() {
		return strIsOnVendorPortal;
	}

	protected void setStrIsOnVendorPortal(String strIsOnVendorPortal) {
		this.strIsOnVendorPortal = strIsOnVendorPortal;
	}

	protected String getMemberFolderPath() {
		return memberFolderPath;
	}

	protected void setMemberFolderPath(String memberFolderPath) {
		this.memberFolderPath = memberFolderPath;
	}

	protected void setRequestAttributes(HstRequest request) {
		if (getParentBean() != null) {
			request.setAttribute("parentBean", getParentBean());
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
			request.setAttribute("scriptName",scriptName);
		}
		if (fileName != null) {
			request.setAttribute("fileName",fileName);
		}

		if (redirectURLToSamePage != null) request.setAttribute("redirectURLToSamePage", redirectURLToSamePage);
		//set attributes in request for RetrievePanInformation Dit Service
		request.setAttribute("shouldRetrievePANInformation", shouldRetrievePANInformation());
		request.setAttribute("shouldValidatePANWithDIT", shouldValidatePANWithDIT());
		request.setAttribute("ditInvalidPanContnue", ditInvalidPanContnue);
		
		request.setAttribute("channelInfoWrapper", channelInfoWrapper);

		request.setAttribute("cmsApplicationUrl", cmsApplicationUrl);

		request.setAttribute("loggedin", request.getUserPrincipal() != null);

		if (strIsOnVendorPortal != null) request.setAttribute("strIsOnVendorPortal", strIsOnVendorPortal);
		if (strIsOnSystemAdminPortal != null) request.setAttribute("strIsOnSystemAdminPortal", strIsOnSystemAdminPortal);

		request.setAttribute("isVendor", isVendor);


		String isError = request.getParameter("isError");
		String errorKey = request.getParameter("error.key");
		//response.setRenderParameter("error", "true");
		//response.setRenderParameter("errorMessageKey", "error.paymentgateway.connection");
		if (isError != null && isError.equalsIgnoreCase("true")) {
			request.setAttribute("isError", "true");
		}
		if (errorKey != null) {
			request.setAttribute("error.key", getPublicRequestParameter(request, "error.key"));
		}  

		if(resellerId != null && resellerId.equals("etaxfilestation")){
			request.setAttribute("etaxfilestation", true);
		}else{
			request.setAttribute("etaxfilestation", false);
		}

		request.setAttribute("resellerId", resellerId);

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

	public Class<? extends HippoBean> getChildBeanClass() {
		// TODO Auto-generated method stub
		return childBeanClass;
	}


	@Override
	public String getParentBeanNodeName() {
		// TODO Auto-generated method stub
		PrimaryBean primaryBean = componentClass.getAnnotation(PrimaryBean.class);
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

	public final String getParentBeanAbsolutePath() {
		return parentBeanAbsolutePath;
	}


	@Override
	public String getAbsoluteBasePathToReturnDocuments()			 {
		// TODO Auto-generated method stub
		return baseAbsolutePathToReturnDocuments;
	}

	@Override
	public String getRelBasePathToReturnDocuments()			{
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
	
	 public String getParameter(String name, HstRequest request) {
	     return (String)componentConfig.getParameter(name, request.getRequestContext().getResolvedSiteMapItem());
	 }

	protected void initComponent(HstRequest request){		
		ResolvedSiteMapItem resolvedMapItem = request.getRequestContext().getResolvedSiteMapItem();

		webSiteInfo = request.getRequestContext().getResolvedMount().getMount().getChannelInfo();
		channelInfoWrapper = new ChannelInfoWrapper(webSiteInfo);

		//configuration details for RetrievePanInformation Dit Service.
		String retrievePANInfo = request.getRequestContext().getResolvedSiteMapItem().getParameter("shouldRetrievePANInformation");
		shouldRetrievePANInformation = StringUtils.isNotBlank(retrievePANInfo) && "true".equalsIgnoreCase(retrievePANInfo) ? true : false;
		String validPanWithDit = request.getRequestContext().getResolvedSiteMapItem().getParameter("shouldValidatePANWithDIT");
		shouldValidatePANWithDIT = StringUtils.isNotBlank(validPanWithDit) && "true".equalsIgnoreCase(validPanWithDit) ? true : false;
		MasterConfigService masterConfigService = MasterConfigService.getInstance();
		ditInvalidPanContnue = masterConfigService.shouldContinueWithInvalidPAN();

		member = itReturnComponentHelper.getMember(request);
		scriptName = itReturnComponentHelper.getScriptName(request, (String) request.getAttribute("selectedItrTab"), getPublicRequestParameter(request, "selectedItrTab"));
		//now determine the fileName which is the last part of the URL and will end with .html if it doesn't we don't bother and let fileName be empty
		if (scriptName != null && scriptName.endsWith(".html")) {
			String[] partsOfScriptName = scriptName.split("[/]");
			fileName = partsOfScriptName[partsOfScriptName.length - 1];
		}
		
		String strFinancialYear = itReturnComponentHelper.getStrFinancialYear(request);  //request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear");
		financialYear =  itReturnComponentHelper.getFinancialYear(strFinancialYear, request); //FinancialYear.getByDisplayName(strFinancialYear);
		assessmentYear = itReturnComponentHelper.getAssessmentYear(financialYear);
		theFolderContainingITRDocuments = itReturnComponentHelper.getTheFolderContainingITRDocuments(request); //request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType");
		itrFolderSuffix = itReturnComponentHelper.getITRFolderSuffix(theFolderContainingITRDocuments);
		pan = itReturnComponentHelper.getPANFromRequestContext(request);// request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); //original versus amend
		mainSiteMapItemRefId = itReturnComponentHelper.getParamValueFromRequestContext(request, "mainSiteMapItemRefId");// request.getRequestContext().getResolvedSiteMapItem().getParameter("");
		redirectURLToSamePage = getScriptName();// getRedirectURL(request,response,FormSaveResult.FAILURE);
		nextScreenSiteMapItemRefId = itReturnComponentHelper.getParamValueFromRequestContext(request, "nextScreen");// request.getRequestContext().getResolvedSiteMapItem().getParameter("nextScreen");
		//we must make sure itReturnType and PAN are not empty as well as they are valid

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
					if (aPageAction != null && aPageAction.contains(componentClass.getSimpleName().toLowerCase())) {
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

		String memberFolderName= getMemberFolderPath(request);
		hippoBeanMemberBase = siteContentBaseBean.getBean("members/" + memberFolderName);
		boolean isReseller = itReturnComponentHelper.isReSeller(request);
		String resellerId = itReturnComponentHelper.getResellerId(request);
		if (isReseller && resellerId != null) {
			hippoBeanMemberBase = getSiteContentBaseBeanForReseller(request).getBean("members/" + memberFolderName);
		}
		if (hippoBeanMemberBase != null) {
			memberRootFolderAbsolutePath = hippoBeanMemberBase.getPath();
			//we need to get into pans sub folder
			panFolder = hippoBeanMemberBase.getBean("pans", HippoFolder.class) ;// .getChildBeansByName("pans", HippoFolder.class);
		}
		else {
			panFolder = null;
		}

		baseRelPathToReturnDocuments = itReturnComponentHelper.getBaseRelPathToReturnDocuments(getMemberFolderPath(request), getPAN(), getFinancialYear(), theFolderContainingITRDocuments);  //"members/" + getMemberFolderPath(request) + "/pans/" + getPAN() + "/" + getFinancialYear() + "/" + theFolderContainingITRDocuments; // getITReturnType();
		hippoBeanBaseITReturnDocuments = siteContentBaseBean.getBean(baseRelPathToReturnDocuments);
		baseAbsolutePathToReturnDocuments =  canonicalBasePathForWrite + "/" + baseRelPathToReturnDocuments; //itReturnComponentHelper.getBaseAbsolutePathToReturnDocuments(request, baseRelPathToReturnDocuments); //request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + baseRelPathToReturnDocuments;

		//if (hippoBeanBaseITReturnDocuments != null) {
		//	baseAbsolutePathToReturnDocuments = hippoBeanBaseITReturnDocuments.getPath();
		//}
		if (componentClass.isAnnotationPresent(PrimaryBean.class)) {
			PrimaryBean primaryBean = componentClass.getAnnotation(PrimaryBean.class);
			parentBeanClass = primaryBean.primaryBeanClass();
			org.hippoecm.hst.content.beans.Node node = parentBeanClass.getAnnotation(org.hippoecm.hst.content.beans.Node.class);
			if (node != null) {
				parentBeanNameSpace	= node.jcrType();
			}
			parentBeanPath = baseRelPathToReturnDocuments + "/" + getParentBeanNodeName();
			parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + getParentBeanNodeName();
		}
		if (componentClass.isAnnotationPresent(ChildBean.class)) {
			ChildBean childBean = componentClass.getAnnotation(ChildBean.class);
			childBeanClass = childBean.childBeanClass();
		}
		screenMode = GoGreenUtil.getEscapedParameter(request, "screenMode");

		mapOfAllBeans = loadBeansAndSetRequestAttributes(request);		
		//time has come to reset the ITReturnType and other variables
		String keyToMemberPersonalInformation = MemberPersonalInformation.class.getSimpleName().toLowerCase();
		//if (mapOfAllBeans != null && mapOfAllBeans.containsKey(keyToMemberPersonalInformation)) {
		if (mapOfAllBeans != null && mapOfAllBeans.containsKey(keyToMemberPersonalInformation)) {
			memberPersonalInformation = (MemberPersonalInformation) mapOfAllBeans.get(keyToMemberPersonalInformation);
			itReturnType = ITReturnType.getByXmlStatus(memberPersonalInformation.getReturnType()); //this will determine original or revised
			ditResponseDocument = (DITResponseDocument) mapOfAllBeans.get(DITResponseDocument.class.getSimpleName().toLowerCase());			
		}

		//lets load ValueList Beans
		ValueListBeans valueListBeans = componentClass.getAnnotation(ValueListBeans.class);
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
				InputStream is = componentClass.getClassLoader().getResourceAsStream("com/mootly/wcm/components/" + replacedValueListBeanPath + ".properties");
				if (is == null) {
					is = componentClass.getResourceAsStream(replacedValueListBeanPath + ".properties");
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
						valueListDocument = (ValueListDocument) objectBeanManager.getObject(absPathToBean);
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

		if (pageAction != null && (pageAction.equals(ITReturnScreen.PAGE_ACTION.EDIT_CHILD) || pageAction.equals(ITReturnScreen.PAGE_ACTION.DELETE_CHILD)) && parentBean != null) {
			//find the object by uuid
			uuid = request.getRequestContext().getResolvedSiteMapItem().getParameter("uuid");
			if (uuid == null) {
				uuid = request.getParameter("uuid");
			}
			//if (uuid == null) {
			//	uuid = request.getpa
			//}
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

		//clientSideValidationJSON = ScreenConfigService.generateJSON(this.getClass());


	}

	protected void initComponent2(final HstRequest request){		
		isReseller = itReturnComponentHelper.isReSeller(request);
		resellerId = itReturnComponentHelper.getResellerId(request);

		cmsApplicationUrl = request.getRequestContext().getContainerConfiguration().getString("cms.location", "/cms/");
		

		/*
        Map<String, String> gridParams = new LinkedHashMap<String, String>(2);
        String spanOrder = getParameter("spanOrder", request);
        if (params != null && spanOrder != null) {
        	String[] spanOrderParts = spanOrder.split("[,]");
        	for (String aPart:spanOrderParts) {
        		String getPartParam = getParameter(aPart, request);
        		if (getPartParam != null) gridParams.put(aPart, getPartParam);
        	}
        	request.setAttribute("gridParams", gridParams);   
        }

        if (params != null) {
        	for (String aParam:params.keySet()) {
        		request.setAttribute(aParam, params.get(aParam));
        	}
        }
		 */

		ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
		strIsOnVendorPortal = resolvedSiteMapItem.getParameter("isOnVendorPortal");
		strIsOnSystemAdminPortal = resolvedSiteMapItem.getParameter("strIsOnSystemAdminPortal");
		isVendor = ( ( request.getUserPrincipal() != null && request.isUserInRole("ROLE_vendor") ) ? true : false);
		memberhandleuuid = resolvedSiteMapItem.getParameter("memberhandleuuid");
		if (memberhandleuuid != null && !"".equals(memberhandleuuid.trim())) {
			try {
				Node theMemberHandle = request.getRequestContext().getSession().getNodeByIdentifier(memberhandleuuid);
				if (theMemberHandle != null) memberFolderPath = theMemberHandle.getName();
			} catch (ItemNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}	        
		}

	}

	protected int getTotalChildren() {
		if (componentClass.isAnnotationPresent(ChildBean.class) && parentBean != null) {
			try {
				List<? extends HippoBean> listOfBeans = this.parentBean.getChildBeans(componentClass.getAnnotation(ChildBean.class).childBeanClass());
				return (listOfBeans != null ? listOfBeans.size() : 0 );
			}
			catch (Exception ex) {
				log.error("An error occurred",ex);
				return -1;
			}
		}
		return 0;
	}

	public WebsiteInfo getWebSiteInfo() {
		return webSiteInfo;
	}

	public ChannelInfoWrapper getChannelInfoWrapper() {
		return channelInfoWrapper;
	}


	protected void loadParentBean(HstRequest request) {
		//what we need to do is to get the object using the path
		if (log.isInfoEnabled()) {
			log.info("I will not attempt to fetch the primary bean using the following path:" + getParentBeanPath());
		}
		parentBean = getSiteContentBaseBeanForReseller(request).getBean(getParentBeanPath(),getParentBeanClass());
	}

	public HippoBean getSiteContentBaseBeanForReseller(HstRequest request) {
		// TODO Auto-generated method stub
		boolean isReseller = itReturnComponentHelper.isReSeller(request);
		String resellerId = itReturnComponentHelper.getResellerId(request);
		HippoBean hippoBeanForReseller = null;
		if (isReseller && resellerId != null) {
			hippoBeanForReseller = siteContentBaseBean.getBean("resellers/"+resellerId);
			if ( hippoBeanForReseller == null ) {
				return siteContentBaseBean;
			}
			else {
				return hippoBeanForReseller;
			}
		}
		return siteContentBaseBean;
	}

	public String getPublicRequestParameter(HstRequest request, String parameterName) {
		String contextNamespaceReference = request.getRequestContext().getContextNamespace();

		if (contextNamespaceReference == null) {
			contextNamespaceReference = "";
		}

		Map<String, String []> namespaceLessParameters = request.getParameterMap(contextNamespaceReference);
		String [] paramValues = namespaceLessParameters.get(parameterName);

		if (paramValues != null && paramValues.length > 0) {
			return paramValues[0];
		}

		return null;
	}

	public Map<String,HippoBean> loadBeansAndSetRequestAttributes(HstRequest request) {
		//loading Additional Beans
		Map<String,HippoBean> localMapOfAllBeans = new HashMap<String, HippoBean>();
		List<HippoDocumentBean> listOfBeans = loadAllBeansUnderTheFolder(request,getRelBasePathToReturnDocuments(),null,null);
		if (listOfBeans != null) {
			localMapOfAllBeans = new HashMap<String, HippoBean>();
			for (HippoBean theBean:listOfBeans) {
				localMapOfAllBeans.put(theBean.getClass().getSimpleName().toLowerCase(), theBean);
			}
		}
		// As mapOfAllBeans define globally (Member of Class) So for new Entry of pan it remain hold  
		// previous viewed or entered value for pan so we have to kill this as it depends upon result of loadAllBeansUnderTheFolder() function i.e listOfBeans
		//fill up request
		//if (mapOfAllBeans != null) {
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
	public List<HippoDocumentBean> loadAllBeansUnderTheFolder(HstRequest request,String baseRelPathToReturnDocuments,String sortByAttribute,SORT_DIRECTION sortDirection) {
		HippoBean theBean = getSiteContentBaseBeanForReseller(request);
		if (theBean == null) {
			return null;
		}
		HippoBean scopeForAllBeans =  theBean.getBean(baseRelPathToReturnDocuments);
		HstQuery hstQuery;
		List<HippoDocumentBean> theLocalBeansUnderMemberFolder = null;
		if (scopeForAllBeans == null)  return null;
		theLocalBeansUnderMemberFolder =  scopeForAllBeans.getChildBeans(HippoDocumentBean.class);
		try {
			theLocalBeansUnderMemberFolder = new ArrayList<HippoDocumentBean>();
			hstQuery = queryManager.createQuery( scopeForAllBeans );
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
				log.info("Now will look into all HippoDocuments under the same folder and make a copy of each " + theBean.getPath());
			}
			for (;itResults.hasNext();) {
				HippoBean hippoBean = itResults.next();
				if (hippoBean instanceof HippoDocumentBean) {
					theLocalBeansUnderMemberFolder.add( (HippoDocumentBean) hippoBean);
					//request.setAttribute(hippoBean.getClass().getSimpleName().toLowerCase(), hippoBean);
					//if (hippoBean instanceof MemberPersonalInformation) {
					//memberPersonalInformation = (MemberPersonalInformation) hippoBean;
					//}
				}
			}
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theLocalBeansUnderMemberFolder;
	}

	public String getMemberFolderPath(HstRequest request) {    	
		if (isOnVendorPortal() && isVendor(request)) {
			return memberFolderPath;
		}
		else {
			return getNormalizedUserName(request);
		}
	}

	public String getNormalizedUserName(HstRequest request) {
		return getNormalizedUserName(request, null);
	}

	public String getNormalizedUserName(HstRequest request,String emailAddress) {
		String whatToNormalize = emailAddress;
		if (whatToNormalize == null) {
			whatToNormalize = ( (request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null) ? request.getUserPrincipal().getName() : null); 
		}
		if ( whatToNormalize != null) {
			return whatToNormalize.replaceAll("@", "-at-");
		}
		else {
			return null;
		}
	}
	

	public boolean isLoggedIn(HstRequest request) {
		return ( request.getUserPrincipal() != null ? true : false);
	}

	public boolean isVendor(HstRequest request) {
		return ( ( request.getUserPrincipal() != null && request.isUserInRole("ROLE_vendor") ) ? true : false);
	}

	public boolean isSystemAdmin(HstRequest request) {
		return ( ( request.getUserPrincipal() != null && request.isUserInRole("ROLE_systemadmin") ) ? true : false);
	}


	public boolean isOnVendorPortal() {
		return ( (strIsOnVendorPortal == null || strIsOnVendorPortal.equals("false")) ? false :  true); 
	}

	public boolean isOnSystemAdminPortal() {
		return ( (strIsOnSystemAdminPortal == null || strIsOnSystemAdminPortal.equals("false")) ? false :  true); 
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

	@Override
	public PAGE_OUTPUT_FORMAT getPageOutputFormat() {
		// TODO Auto-generated method stub
		return pageOutputFormat;
	}

	protected MemberPersonalInformation getMemberPersonalInformation() {
		return memberPersonalInformation;
	}

	protected DITResponseDocument getDITResponseDocument() {
		return ditResponseDocument;
	}

	protected boolean shouldValidatePANWithDIT() {
		return shouldValidatePANWithDIT;
	}

	protected boolean shouldRetrievePANInformation() {
		return shouldRetrievePANInformation;
	}

	protected RetrievePANInformation.VALIDATION_RESULT getRetrievePANInformationValidationResult() {
		return retrievePANInformationValidationResult;
	}


	public String getMemberhandleuuid() {
		return memberhandleuuid;
	}

	public void setMemberhandleuuid(String memberhandleuuid) {
		this.memberhandleuuid = memberhandleuuid;
	}


	public final boolean isReseller() {
		return isReseller;
	}

	public final String getResellerId() {
		return resellerId;
	}

}
