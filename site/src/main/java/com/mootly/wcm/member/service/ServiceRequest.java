package com.mootly.wcm.member.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.onehippo.forge.easyforms.beans.FormBean;
import org.onehippo.forge.easyforms.hst.EasyFormComponent;
import org.onehippo.forge.easyforms.model.ErrorMessage;
import org.onehippo.forge.easyforms.model.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.EmailMessage;
import com.mootly.wcm.beans.EmailTemplate;
import com.mootly.wcm.beans.ServiceRequestDocument;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.VelocityUtils;


public class ServiceRequest extends EasyFormComponent {
	private static final Logger log = LoggerFactory.getLogger(ServiceRequest.class);

	@Override
	public void onValidationError(HstRequest request, HstResponse response,
			Form form, FormMap map, List<ErrorMessage> errors) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onValidationSuccess(HstRequest request,
			HstResponse response, Form form, FormMap map) {
		// TODO Auto-generated method stub
		return false;
	}
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response)
    		throws HstComponentException {
    	// TODO Auto-generated method stub
    	super.doBeforeRender(request, response);
    	request.setAttribute("Success", request.getParameter("Success"));
    }
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		FormBean bean = getFormBean(request);
		if (bean == null) {
			return;
		}
		final Form form = parse(bean);
		log.info("this form "+form.toString());
		final FormMap formMap = new FormMap(request, form.getFieldNames());
		if(formMap!=null){
			for(String fields:formMap.getFieldNames()){
				log.info("this is name of field"+fields);
			}
		}
		if(formMap!=null){
			ServiceRequestDocument serviceDoc=new ServiceRequestDocument();
			serviceDoc.setFirstName(formMap.getField("flex_field_string_0").getValue());
			serviceDoc.setMiddleName(formMap.getField("flex_field_string_1").getValue());
			serviceDoc.setLastName(formMap.getField("flex_field_string_2").getValue());
			serviceDoc.setAddress(formMap.getField("flex_field_string_3").getValue());
			serviceDoc.setEmail(formMap.getField("flex_field_string_4").getValue());
			serviceDoc.setMobile(formMap.getField("flex_field_string_5").getValue());
			ServiceRequestDocument  resServicedocument=createServiceRequestDocument(request, serviceDoc);
			if(resServicedocument!=null){
				response.setRenderParameter("Success", "Success");
			}
		}
	}
	/**
	 * This method is used to validate the service Request form
	 * 
	 * @param FormMap
	 * 
	 * @return boolean value will be return to check for Validated
	 * 
	 * */
	public boolean validate(FormMap formMap){
		return true;
	}
	public ServiceRequestDocument createServiceRequestDocument(HstRequest request,ServiceRequestDocument serviceDoc){
		Session persistableSession=null;
		WorkflowPersistenceManager wpm=null;
		try{
			persistableSession=getPersistableSession(request);
			wpm=getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewWorkflowCallbackHandler());
			final String serviceRequsetpath=getServiceRequestPath(request);
			String objectpath=wpm.createAndReturn(serviceRequsetpath+"serviceRequest", serviceDoc.NAMESPACE, "Service", true);
			ServiceRequestDocument serviceRequestDocument=(ServiceRequestDocument) wpm.getObject(objectpath);
			if(serviceRequestDocument!=null){
				serviceRequestDocument.setFirstName(serviceDoc.getFirstName());
				serviceRequestDocument.setMiddleName(serviceDoc.getMiddleName());
				serviceRequestDocument.setLastName(serviceDoc.getLastName());
				serviceRequestDocument.setAddress(serviceDoc.getAddress());
				serviceRequestDocument.setEmail(serviceDoc.getEmail());
				serviceRequestDocument.setMobile(serviceDoc.getMobile());
				wpm.update(serviceRequestDocument);
				ServiceRequestDocument publishedSignUpDocument = (ServiceRequestDocument) wpm.getObject(objectpath); 
				if (publishedSignUpDocument == null) return null;//major screwup
				//persistableSession = getPersistableSession(request);
				//wpm = getWorkflowPersistenceManager(persistableSession);
				//also queue up the message for welcome
				//first find the template membership_signup, this template is under emailtemplates folder
				//SIMPLE WORKFLOW
				Map<String,Object> contextMap = new HashMap<String, Object>();
				contextMap.put("serviceDoc", publishedSignUpDocument);				
				String pathToNewNode = wpm.createAndReturn(serviceRequsetpath +"emails", EmailMessage.NAMESPACE, "service_request", true);
				EmailMessage emailMessage = (EmailMessage) wpm.getObject(pathToNewNode);
				emailMessage.setTo(new String[]{"info@wealth4india.com"});
				emailMessage.setTemplateKey("serviceRequest");
				// here we are creating template for email.			
				EmailTemplate emailTemplate = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/service_request");
				if (emailTemplate != null) {
					log.error("Email template HTML BODY" + emailTemplate.getHtmlBody());
					String htmlBody = VelocityUtils.parseVelocity(emailTemplate.getHtmlBody(), contextMap);
					String plainBody = VelocityUtils.parseVelocity(emailTemplate.getPlainBody(), contextMap);
					String subject = VelocityUtils.parseVelocity(emailTemplate.getSubject(), contextMap);
					emailMessage.setSubject(subject);
					emailMessage.setHtmlBody(htmlBody);
					emailMessage.setPlainBody(plainBody);
				}
				else {
					emailMessage.setSubject("This is TEST, Welcome to MOOTLY");
					emailMessage.setHtmlBody("<B>COOL</B>");
				}
				wpm.update(emailMessage);
			}
			return serviceRequestDocument;
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while getting Repository session",e);
			return null;
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while getting the Object from Repository",e);
			return null;
		}
	}
	/**
	 * This Method is Used to Create the Repository Path for Service Request Document
	 * 
	 * @param request HstRequest
	 * 
	 * @return String
	 * 
	 * */
	public String getServiceRequestPath(HstRequest request){
		StringBuilder sb=new StringBuilder();
		String repoPath=request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath();
		sb.append(repoPath);
		if(request.getUserPrincipal()!=null){
			sb.append("/").append("members").append("/").append(request.getUserPrincipal().getName()).append("/");
		}else{
			sb.append("/");
		}
		return sb.toString();
	}
	public static class FullReviewWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
    @Override
    public FormBean getFormBean(HstRequest request) {
    	// TODO Auto-generated method stub
    	HippoBean document=getSiteContentBaseBean(request).getBean("srforms/specialized/specialized");
        if (document == null || !(document.isHippoDocumentBean()) || !(document instanceof FormBean)) {
            if (log.isDebugEnabled()) {
                log.warn("*** EASY_FORMS ***");
                log.warn("Form bean is either not defined or doesn't match Form bean type, [ef:form], returning null");
                log.warn("Here is how it comes: you've mapped something to the EasyFormComponent, however, your document either doesn't exist or it is not Form document type");
                log.warn("You can override [FormBean getFormBean(request)] method to fetch Form bean from some other location, e.g. through facet select");
                log.warn("*** EASY_FORMS ***");
            }
            return null;
        }
        return (FormBean) document;
    }
}
