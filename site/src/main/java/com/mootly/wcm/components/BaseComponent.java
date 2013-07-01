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
import java.util.Map;

import javax.jcr.Session;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.api.Workflow;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.EmailMessage;
import com.mootly.wcm.beans.EmailTemplate;
import com.mootly.wcm.components.ITReturnComponent.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.utils.ContentStructure;

public class BaseComponent extends BaseHstComponent {
	private static final Logger log = LoggerFactory.getLogger(BaseComponent.class);
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
    }
    
    protected void redirectToNotFoundPage(HstResponse response) {
        try {
            response.forward("/404");
        } catch (IOException e) {
            throw new HstComponentException(e);
        }
    }
    
    public String getNormalizedUserName(HstRequest request) {
    	if (request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null) {
    		return request.getUserPrincipal().getName().replaceAll("@", "-at-");
    	}
    	else {
    		return null;
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
    	protected void sendEmail(HstRequest request, String[] to,String attachmentList,String defaultMessage,String templateKey,Map<String,String> velocityContext) {
    	try {
    		
    		//here we do the VEOCITY MAGIC
    		//todo - megha
    		//if (subject == null) return;
    		if (templateKey == null) return;
    		Session persistableSession = null;
    		WorkflowPersistenceManager wpm;
    		String basePathToSiteContentBean =  request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath();
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
    		final String pathToParentBean = wpm.createAndReturn(pathToEmail,"mootlywcm:emailmessage",templateKey, true);
    		EmailMessage emailMessage = (EmailMessage) wpm.getObject(pathToParentBean);
    		emailMessage.setTo(to);
    		/*if (cc != null) emailMessage.setCc(cc);
    		if (bcc != null) emailMessage.setBcc(bcc);*/
    		emailMessage.setCc(emailTemplate.getCc());
    		emailMessage.setBcc(emailTemplate.getBcc());
    		emailMessage.setSubject(emailTemplate.getSubject());
    		emailMessage.setAttachmentList(attachmentList);
    		emailMessage.setTemplateKey(templateKey);
    		emailMessage.setHtmlBody(emailTemplate.getHtmlBody());
			wpm.update(emailMessage);
    	}
    	catch (Exception ex) {
    		log.error("Error in sending email",ex);
    	}
    }

}
