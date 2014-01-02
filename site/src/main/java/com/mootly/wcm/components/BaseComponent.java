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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.jcr.ItemNotFoundException;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.apache.commons.lang.ArrayUtils;
import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.configuration.hosting.Mount;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
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

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.beans.EmailMessage;
import com.mootly.wcm.beans.EmailTemplate;
import com.mootly.wcm.beans.compound.ImageSet;
import com.mootly.wcm.channels.ChannelInfoWrapper;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.SequenceGeneratorImpl;
import com.mootly.wcm.services.ds.DigitalSignatureService;
import com.mootly.wcm.services.efile.EFileService;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.VelocityUtils;

public class BaseComponent extends BaseHstComponent {
	private static final Logger log = LoggerFactory.getLogger(BaseComponent.class);
	
	String strIsOnVendorPortal;
	String strIsOnSystemAdminPortal;
	String memberhandleuuid;
	String memberFolderPath;
	
	ITReturnComponentHelper itReturnComponentHelper = null;
	SequenceGenerator sequenceGenerator = null;
	DigitalSignatureService digitalSignatureService = null;
	EFileService eFileService = null;
	
	ChannelInfoWrapper channelInfoWrapper = null;
	WebsiteInfo webSiteInfo = null;
	
	boolean isReseller = false; //itReturnComponentHelper.isReSeller(request);
	String resellerId = null; //itReturnComponentHelper.getResellerId(request);
	
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		itReturnComponentHelper = context.getBean( ITReturnComponentHelper.class );
		sequenceGenerator = context.getBean(SequenceGeneratorImpl.class);
		digitalSignatureService = context.getBean(DigitalSignatureService.class);
		eFileService = context.getBean(EFileService.class);
	}
	
    public final DigitalSignatureService getDigitalSignatureService() {
		return digitalSignatureService;
	}

	public final EFileService geteFileService() {
		return eFileService;
	}

	@Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        
        ComponentUtil.doRedirectionOnWrongLandingMount(request, response);
        
        isReseller = itReturnComponentHelper.isReSeller(request);
    	resellerId = itReturnComponentHelper.getResellerId(request);
        
        request.setAttribute("preview", isPreview(request));
        request.setAttribute("composermode", request.getRequestContext().getResolvedMount().getMount().isOfType("composermode"));
        
        String cmsApplicationUrl = request.getRequestContext().getContainerConfiguration().getString("cms.location", "/cms/");
        request.setAttribute("cmsApplicationUrl", cmsApplicationUrl);
        
        request.setAttribute("loggedin", request.getUserPrincipal() != null);
        
        String theme = getParameter("theme",request);
        String template = getParameter("template",request);
        String bodyCssClass = getParameter("bodyCssClass",request);
        String contentCssClass = getParameter("contentCssClass",request);
        String widgetsCssClass = getParameter("widgetsCssClass",request);
        String hasGrid = getParameter("hasGrid",request);
//        if (log.isInfoEnabled()) {
//        	log.info("theme:" + theme);
//        	log.info("template:" + template);
//        	log.info("bodyCssClass:" + bodyCssClass);
//        	log.info("contentCssClass:" + contentCssClass);
//        	log.info("widgetsCssClass:" + widgetsCssClass);
//        }
        if (theme != null) request.setAttribute("theme", theme);
        if (template != null) request.setAttribute("template", template);
        if (bodyCssClass != null) request.setAttribute("bodyCssClass", bodyCssClass);
        if (contentCssClass != null) request.setAttribute("contentCssClass", contentCssClass);
        if (widgetsCssClass != null) request.setAttribute("widgetsCssClass", widgetsCssClass);   
        if (hasGrid != null) request.setAttribute("hasGrid", hasGrid);   
        
        Map<String, String> params = getParameters(request);
        
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
        
        ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
        strIsOnVendorPortal = resolvedSiteMapItem.getParameter("isOnVendorPortal");
        strIsOnSystemAdminPortal = resolvedSiteMapItem.getParameter("strIsOnSystemAdminPortal");
        if (strIsOnVendorPortal != null) request.setAttribute("strIsOnVendorPortal", strIsOnVendorPortal);
        if (strIsOnSystemAdminPortal != null) request.setAttribute("strIsOnSystemAdminPortal", strIsOnSystemAdminPortal);
        
        boolean isVendor = ( ( request.getUserPrincipal() != null && request.isUserInRole("ROLE_vendor") ) ? true : false);
        request.setAttribute("isVendor", isVendor);
        
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
        
        webSiteInfo = request.getRequestContext().getResolvedMount().getMount().getChannelInfo();
        channelInfoWrapper = new ChannelInfoWrapper(webSiteInfo);
        
        request.setAttribute("channelInfoWrapper", channelInfoWrapper);
        
        setLogo(request, response);
        
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
        
        request.setAttribute("etaxfilestation", itReturnComponentHelper.getResellerId(request).equals("etaxfilestation"));
        request.setAttribute("etaxfilestationMembers", !itReturnComponentHelper.getResellerId(request).equals("etaxfilestation"));
        request.setAttribute("resellerId", resellerId);
   
		HstLink link = request.getRequestContext().getHstLinkCreator().createByRefId("reseller-package", request.getRequestContext().getResolvedMount().getMount());
		String urlToResellerPackage = link.toUrlForm(request.getRequestContext(), true);

		// Check for Trial period
	/*	if(isVendor && request.getUserPrincipal() != null && !(resellerId.equals("w4india"))){
			if(channelInfoWrapper.getResellerPackage().equals("trialPeriod")){
				request.setAttribute("isTrialPeriodActive", true);	
				request.setAttribute("daysLeft", channelInfoWrapper.getDiffOfStartEndDate());
				request.setAttribute("urlToResellerPackage", urlToResellerPackage);
			}   	
		}

		// Check for Reseller (If Reseller license expired)
		if(isVendor && request.getUserPrincipal() != null && !(resellerId.equals("w4india"))){
			if(channelInfoWrapper.getIsLicenseExpired() && request.getRequestURL().toString().contains("itreturn")){
				try {
					response.sendRedirect(urlToResellerPackage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}  
		//Check for Reseller Members (If Reseller license expired)
		if(!isVendor && request.getUserPrincipal() != null && !(resellerId.equals("w4india"))){
			if(channelInfoWrapper.getIsLicenseExpired() && request.getRequestURL().toString().contains("itreturn")){
				response.setRenderPath("jsp/reseller/licensenotvalid.jsp");	
			}	
		}  
		*/
    }
    
    @Override
    public void doAction(HstRequest request, HstResponse response)
    		throws HstComponentException {
    	// TODO Auto-generated method stub
    	super.doAction(request, response);
    	isReseller = itReturnComponentHelper.isReSeller(request);
    	resellerId = itReturnComponentHelper.getResellerId(request);
    	webSiteInfo = request.getRequestContext().getResolvedMount().getMount().getChannelInfo();
        channelInfoWrapper = new ChannelInfoWrapper(webSiteInfo);
        request.setAttribute("channelInfoWrapper", channelInfoWrapper);
    }
    
    public final boolean isReseller() {
		return isReseller;
	}

	public final String getResellerId() {
		return resellerId;
	}

	protected void redirectToNotFoundPage(HstResponse response) {
        try {
            response.forward("/404");
        } catch (IOException e) {
            throw new HstComponentException(e);
        }
    }
    
    public String getNormalizedUserName(HstRequest request) {
    	return getNormalizedUserName (request, null);
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
    
    public String getMemberhandleuuid() {
		return memberhandleuuid;
	}

	public void setMemberhandleuuid(String memberhandleuuid) {
		this.memberhandleuuid = memberhandleuuid;
	}

	public String getMemberFolderPath(HstRequest request) {    	
    	if (isOnVendorPortal() && isVendor(request)) {
			return memberFolderPath;
		}
    	else {
    		return getNormalizedUserName(request);
    	}
	}

	/**
     * 
     * @param request
     * @param to
     * @param cc
     * @param bcc
     * @param subject
     * @param attachmentList
     * @param defaultMessage Use it when templateKey parsing fails and/or is not available.
     * @param templateKey
     * @param velocityContext
     */
    //protected void sendEmail(HstRequest request, String[] to,String[] cc,String[] bcc,String subject,String attachmentList,String defaultMessage,String templateKey,Map<String,String> velocityContext) {
    protected void sendEmail(HstRequest request, String[] to,String attachmentList,String defaultMessage,String templateKey,Map<String,Object> velocityContext) {
    	try {
    		final Map<String,Object> finalVelocityContext = new HashMap<String, Object>();
    		if (velocityContext != null) {
    			finalVelocityContext.putAll(velocityContext);
    		}
    		
    		WebsiteInfo websiteInfo = request.getRequestContext().getResolvedMount().getMount().getChannelInfo();
    		if (websiteInfo.getEmailFrom() != null) {
    			finalVelocityContext.put("resellerName", websiteInfo.getPageTitlePrefix() );
    		}
    		if (websiteInfo.getEmailFrom() != null) {
    			finalVelocityContext.put("emailFrom", websiteInfo.getEmailFrom() );
    		}
    		if (websiteInfo.getEmailFromName() != null) {
    			finalVelocityContext.put("emailFromName", websiteInfo.getEmailFromName() );
    		}
    		if (websiteInfo.getEmailSignature() != null) {
    			finalVelocityContext.put("emailSignature", websiteInfo.getEmailSignature() );
    		}
    		if (websiteInfo.getEmailCustomerService() != null) {
    			finalVelocityContext.put("emailCustomerService", websiteInfo.getEmailCustomerService() );
    		}
    		//here we do the VEOCITY MAGIC
    		//todo - megha
    		//if (subject == null) return;
    		if (templateKey == null) return;
    		Session persistableSession = null;
    		WorkflowPersistenceManager wpm;
    		String basePathToSiteContentBean =  getCanonicalBasePathForWrite(request);
    		persistableSession = getPersistableSession(request);
    		wpm = getWorkflowPersistenceManager(persistableSession);
    		
    		wpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {

				@Override
				public void processWorkflow(FullReviewedActionsWorkflow workflow)
						throws Exception {
					// TODO Auto-generated method stub
					workflow.publish();
				}

			});
    		String pathToEmail = "";
    		if (getNormalizedUserName(request) == null) {
    			pathToEmail = basePathToSiteContentBean + "/members/emails";
    		}
    		else {
    			pathToEmail = basePathToSiteContentBean + "/members/" + getNormalizedUserName(request) + "/emails";
    		}
    		EmailTemplate emailTemplate = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/"+templateKey);
    		
    		if (to == null) {
    			to = emailTemplate.getTo();
    			if (to == null) to = new String[]{"info@wealth4india.com"}; //stupid logic what the hack
    		}	
    		final String pathToParentBean = wpm.createAndReturn(pathToEmail,"mootlywcm:emailmessage",templateKey, true);
    		EmailMessage emailMessage = (EmailMessage) wpm.getObject(pathToParentBean);
    		
    		for (int i=0;i < to.length;i++) {
    			String theParseTo = VelocityUtils.parseVelocity(to[i], finalVelocityContext);
    			to[i] = theParseTo;
    		}
    		
    		emailMessage.setTo(to);
    		/*if (cc != null) emailMessage.setCc(cc);
    		if (bcc != null) emailMessage.setBcc(bcc);*/
    		StringBuffer sbHostName = new StringBuffer();
			sbHostName.append(request.getScheme() + "://" +  request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath());
			
			if (isReseller() && getResellerId() != null) {
				sbHostName.append("/r/").append(getResellerId());
			}
			
			StringBuffer resellerHostName = new StringBuffer();
			resellerHostName.append(request.getScheme() + "://" +  request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath());
			if(velocityContext.get("resellerId") != null){
				resellerHostName.append("/r/").append(velocityContext.get("resellerId"));
			}
			//if (velocityContext == null) {
			//	velocityContext = new HashMap<String, Object>(1);
			//}
			finalVelocityContext.put("memberHostName", sbHostName.toString());
			finalVelocityContext.put("resellerHostName", resellerHostName.toString());
    		
    		String htmlBody = VelocityUtils.parseVelocity(emailTemplate.getHtmlBody(), finalVelocityContext);
			//String plainBody = VelocityUtils.parseVelocity(emailTemplate.getPlainBody(), velocityContext);
			String subject = VelocityUtils.parseVelocity(emailTemplate.getSubject(), finalVelocityContext);
			
    		if (emailTemplate.getCc() != null) emailMessage.setCc(emailTemplate.getCc());
    		if (emailTemplate.getBcc() != null) emailMessage.setBcc(emailTemplate.getBcc());
    		emailMessage.setSubject(subject);
    		emailMessage.setAttachmentList(attachmentList);
    		emailMessage.setTemplateKey(templateKey);
    		emailMessage.setHtmlBody(htmlBody);
			wpm.update(emailMessage);
    	}
    	catch (Exception ex) {
    		log.error("Error in sending email",ex);
    	}
    }
    	
    protected void setLogo(HstRequest request, HstResponse response) {
    	final Mount mount = request.getRequestContext().getResolvedMount().getMount();
        final WebsiteInfo info = mount.getChannelInfo();
        if (info == null) {
            log.warn("No channel info available for mount '{}'. No logo will be shown", mount.getMountPath());
            return;
        }

        final String logoPath = info.getLogoPath();
        try {
            Object logo = getObjectBeanManager(request).getObject(logoPath);
            if (logo instanceof ImageSet) {
                request.setAttribute("logo", logo);
            } else {
                log.warn("Mount '{}' has illegal logo path '{}' (not an image set). No logo will be shown.");
            }
        } catch (ObjectBeanManagerException e) {
            log.warn("Cannot retrieve logo at '" + logoPath + "'", e);
        }
    }
    
    public HippoBean getSiteContentBaseBeanForReseller(HstRequest request) {
    	// TODO Auto-generated method stub
    	boolean isReseller = itReturnComponentHelper.isReSeller(request);
    	String resellerId = itReturnComponentHelper.getResellerId(request);
    	HippoBean siteContentBaseBean = super.getSiteContentBaseBean(request);
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
    
    
    public String getCanonicalBasePathForWrite(HstRequest request) {
    	// TODO Auto-generated method stub
    	boolean isReseller = itReturnComponentHelper.isReSeller(request);
    	String resellerId = itReturnComponentHelper.getResellerId(request);
    	HippoBean siteContentBaseBean = super.getSiteContentBaseBean(request);
    	HippoBean hippoBeanForReseller = null;
    	if (isReseller && resellerId != null) {
    		hippoBeanForReseller = siteContentBaseBean.getBean("resellers/"+resellerId);
    		if ( hippoBeanForReseller == null ) {
    			return super.getMount(request).getCanonicalContentPath();
    		}
    		else {
    			return hippoBeanForReseller.getCanonicalPath();
    		}
    	}
    	return super.getMount(request).getCanonicalContentPath();
    }
    

	protected final ITReturnComponentHelper getItReturnComponentHelper() {
		return itReturnComponentHelper;
	}
	
	protected final SequenceGenerator getSequenceGenerator() {
		return sequenceGenerator;
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
	
	public WebsiteInfo getWebSiteInfo() {
		return webSiteInfo;
	}
	
	public ChannelInfoWrapper getChannelInfoWrapper() {
		return channelInfoWrapper;
	}
	
	protected PAGE_ACTION getPageAction(HstRequest request) {
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
			PAGE_ACTION pageAction = ITReturnScreen.PAGE_ACTION.DEFAULT;
			return pageAction;
		}
		try {
			PAGE_ACTION pageAction = PAGE_ACTION.valueOf(strPageAction);
			return pageAction;
		}catch (IllegalArgumentException e) {
			log.error("Error parsing action",e);
		}
		return null;
	}
	
	protected FormMap getFormMap(HstRequest request,String[] formMapFields) {
		FormMap formMap = null;
		if (getClass().isAnnotationPresent(FormFields.class) || ( formMapFields != null && formMapFields.length > 0) ) {
			FormFields formFields = this.getClass().getAnnotation(FormFields.class);
			String[] theFieldsArray = null;
			if (formFields != null) {
				String[] vendorFields = formFields.fieldNamesVendorOnly();
				theFieldsArray = formFields.fieldNames();
				if (isVendor(request) && vendorFields != null && vendorFields.length > 0){
					theFieldsArray = (String[]) ArrayUtils.addAll(theFieldsArray, vendorFields);
				}
			}
			if (formMapFields != null && formMapFields.length > 0) {
				theFieldsArray = (String[]) ArrayUtils.addAll(theFieldsArray, formMapFields);
			}
			formMap = new FormMap(request,theFieldsArray);
			FormUtils.populate(request, formMap);
		}
		return formMap;
	}
	
	public String getHippoRequestURL(HstRequest request,boolean includeHost, boolean includeContext) {
		StringBuffer sbHostName = new StringBuffer();
		if (includeHost) {
			sbHostName.append(request.getScheme() + "://" +  request.getServerName()).append(":").append(request.getServerPort());
		}
		if (includeContext) {
			sbHostName.append(request.getContextPath());
		}
		
		if (isReseller() && getResellerId() != null) {
			sbHostName.append("/r/").append(getResellerId());
		}
		
		return sbHostName.toString();
	}
	
	
	
}
