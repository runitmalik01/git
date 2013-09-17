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

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.configuration.hosting.Mount;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mootly.wcm.beans.EmailMessage;
import com.mootly.wcm.beans.EmailTemplate;
import com.mootly.wcm.beans.compound.ImageSet;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.VelocityUtils;

public class BaseComponent extends BaseHstComponent {
	private static final Logger log = LoggerFactory.getLogger(BaseComponent.class);
	
	String strIsOnVendorPortal;
	String memberhandleuuid;
	String memberFolderPath;
	
	ITReturnComponentHelper itReturnComponentHelper = null;
	
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		itReturnComponentHelper = context.getBean( ITReturnComponentHelper.class );
	}
	
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        
        ComponentUtil.doRedirectionOnWrongLandingMount(request, response);
        
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
        if (strIsOnVendorPortal != null) request.setAttribute("strIsOnVendorPortal", strIsOnVendorPortal);
        
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
        
        setLogo(request, response);
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
   
    
    public boolean isOnVendorPortal() {
    	return ( (strIsOnVendorPortal == null || strIsOnVendorPortal.equals("false")) ? false :  true); 
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
    			String theParseTo = VelocityUtils.parseVelocity(to[i], velocityContext);
    			to[i] = theParseTo;
    		}
    		
    		emailMessage.setTo(to);
    		/*if (cc != null) emailMessage.setCc(cc);
    		if (bcc != null) emailMessage.setBcc(bcc);*/
    		StringBuffer sbHostName = new StringBuffer();
			sbHostName.append(request.getScheme() + "://" +  request.getServerName()).append(":").append(request.getServerPort());
			if (velocityContext == null) velocityContext = new HashMap<String, Object>(1);
			velocityContext.put("memberHostName", sbHostName.toString());
    		
    		String htmlBody = VelocityUtils.parseVelocity(emailTemplate.getHtmlBody(), velocityContext);
			//String plainBody = VelocityUtils.parseVelocity(emailTemplate.getPlainBody(), velocityContext);
			String subject = VelocityUtils.parseVelocity(emailTemplate.getSubject(), velocityContext);
			
    		emailMessage.setCc(emailTemplate.getCc());
    		emailMessage.setBcc(emailTemplate.getBcc());
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
    			return siteContentBaseBean.getCanonicalPath();
    		}
    		else {
    			return hippoBeanForReseller.getCanonicalPath();
    		}
    	}
    	return siteContentBaseBean.getCanonicalPath();
    }
    

	protected ITReturnComponentHelper getItReturnComponentHelper() {
		return itReturnComponentHelper;
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
}
