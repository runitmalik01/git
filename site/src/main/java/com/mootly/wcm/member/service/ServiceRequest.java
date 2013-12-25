package com.mootly.wcm.member.service;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.onehippo.forge.easyforms.beans.FormBean;
import org.onehippo.forge.easyforms.hst.EasyFormComponent;
import org.onehippo.forge.easyforms.model.ErrorMessage;
import org.onehippo.forge.easyforms.model.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mootly.wcm.beans.EmailMessage;
import com.mootly.wcm.beans.EmailTemplate;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.beans.ServiceRequestDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.member.MemberDriveHandler;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.SequenceGeneratorImpl;
import com.mootly.wcm.services.ds.DigitalSignatureService;
import com.mootly.wcm.services.efile.EFileService;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.VelocityUtils;


public class ServiceRequest extends EasyFormComponent {
	private static final Logger log = LoggerFactory.getLogger(ServiceRequest.class);
	private static final String DOC_SCREEN_REF_ID = "docattach";

	ITReturnComponentHelper itReturnComponentHelper = null;
	SequenceGenerator sequenceGenerator = null;
	DigitalSignatureService digitalSignatureService = null;
	EFileService eFileService = null;

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
		request.setAttribute("ReqSuccess", request.getParameter("Success"));
		request.getRequestContext().setAttribute("Success", request.getParameter("Success"));
		request.setAttribute("srdocument", request.getRequestContext().getAttribute("document"));
		Service service = (Service) request.getRequestContext().getAttribute("document");
		request.setAttribute("documentRequired", service.getDocumentRequired());
		ServiceRequestManager requestManager = new ServiceRequestManager(request, getSiteContentBaseBeanForReseller(request));
		if(log.isInfoEnabled()){
			log.info("Lets see service can be fullfill in lead time::"+requestManager.CanServiceRequestFullfill());
		}
		request.setAttribute("canServiceRequestFullfill", requestManager.CanServiceRequestFullfill());
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		Long serviceRequestNumber = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_SERVICE_REQUEST);
		FormBean bean = getFormBean(request);
		if (bean == null) {
			return;
		}
		final Form form = parse(bean);
		final FormMap formMap = new FormMap(request, form.getFieldNames());		
		try {
			Session persistableSession = getPersistableSession(request);
			WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewWorkflowCallbackHandler());
			if(formMap!=null){
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				if(!isMultipart){
					ServiceRequestDocument resServicedocument = createServiceRequestDocument(request, wpm, formMap, serviceRequestNumber);
					if(resServicedocument!=null){
						response.setRenderParameter("Success", "Success");
						response.setRenderParameter("serviceRequestNumber", String.valueOf(serviceRequestNumber));
					}
				} else {
					ServiceRequestManager requestManager = new ServiceRequestManager(request, getSiteContentBaseBeanForReseller(request));
					String srRequestNumber = GoGreenUtil.getEscapedParameter(request, "serviceRequestNumber");
					Service resServicedocument = requestManager.getServiceForServiceRequest(srRequestNumber);
					String subDriveName = StringUtils.deleteWhitespace(resServicedocument.getName()).toLowerCase();
					if(log.isInfoEnabled()){
						log.info("Have the name of subdrive to be Create::" + subDriveName);
					}
					MemberDriveHandler driveHandler = new MemberDriveHandler(request, formMap);
					boolean isFileSave = driveHandler.SaveFileInMemberDrive(null, subDriveName, wpm, false);
					if(isFileSave){
						requestManager.UdateTheServiceRequestWithMemberDrive(wpm, subDriveName, srRequestNumber);	
					}
				}
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while getting Repository session",e);
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
	public ServiceRequestDocument createServiceRequestDocument(HstRequest request, WorkflowPersistenceManager wpm, FormMap formMap, Long serviceRequestNumber){
		ServiceRequestDocument publishedSignUpDocument = null;
		try{
			final String serviceRequsetpath = getServiceRequestPath(request);
			//format of serviceNode as "Service"+ ServiceCode + Mobile Number
			String serviceNodeName = "ServiceRequest_"+serviceRequestNumber;
			String objectpath = wpm.createAndReturn(serviceRequsetpath+"servicerequest", ServiceRequestDocument.NAMESPACE, serviceNodeName, true);
			ServiceRequestDocument serviceRequestDocument = (ServiceRequestDocument) wpm.getObject(objectpath);
			if(serviceRequestDocument!=null){	
				if(log.isInfoEnabled()){
					log.info("Service Request Number :::"+serviceRequestNumber);
				}
				serviceRequestDocument.setServiceRequestNumber(serviceRequestNumber);
				serviceRequestDocument.fill(formMap);
				wpm.update(serviceRequestDocument);
				publishedSignUpDocument = (ServiceRequestDocument) wpm.getObject(objectpath); 
				if (publishedSignUpDocument == null) return null;//major screwup
				//persistableSession = getPersistableSession(request);
				//wpm = getWorkflowPersistenceManager(persistableSession);
				//also queue up the message for welcome
				//first find the template membership_signup, this template is under emailtemplates folder
				//SIMPLE WORKFLOW
				Map<String,Object> contextMap = new HashMap<String, Object>();
				contextMap.put("serviceDoc", publishedSignUpDocument);
				contextMap.put("serviceName", publishedSignUpDocument.getServiceCode());
				String pathToNewNode = wpm.createAndReturn(serviceRequsetpath +"emails", EmailMessage.NAMESPACE, "service_request", true);
				EmailMessage emailMessage = (EmailMessage) wpm.getObject(pathToNewNode);
				// here we are creating template for email.			
				EmailTemplate emailTemplate = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/service_request");
				wpm.update(createEmailService(request, emailMessage, emailTemplate, contextMap, "sr@wealth4india.com"));
				String pathToNewNodeAck = wpm.createAndReturn(serviceRequsetpath +"emails", EmailMessage.NAMESPACE, "service_request_ack", true);
				EmailMessage emailMessageAck = (EmailMessage) wpm.getObject(pathToNewNodeAck);
				// here we are creating template for email.	
				EmailTemplate emailTemplateAck = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/service_request_ack");
				wpm.update(createEmailService(request, emailMessageAck, emailTemplateAck, contextMap, publishedSignUpDocument.getEmail()));
			}
			return publishedSignUpDocument;
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while getting the Object from Repository",e);
			return null;
		}
	}
	/**
	 * This method is used to create the Email Message Document.
	 * 
	 * @param request HstRequest
	 * @param emailTemplate this Object of EmailTemplate 
	 * @param emailMessage this Object of EmailMessage Document
	 * @param contextMap this is a Map<String,Object>
	 * @param To this is String type
	 * 
	 * @return EmailMessage  
	 * 
	 * */
	public EmailMessage createEmailService(HstRequest request,EmailMessage emailMessage,EmailTemplate emailTemplate,Map<String,Object> contextMap,String To){
		emailMessage.setTo(new String[]{To});		
		// here we are creating template for email.			
		if (emailTemplate != null) {
			log.error("Email template HTML BODY" + emailTemplate.getHtmlBody());
			String htmlBody = VelocityUtils.parseVelocity(emailTemplate.getHtmlBody(), contextMap);
			String plainBody = VelocityUtils.parseVelocity(emailTemplate.getPlainBody(), contextMap);
			String subject = VelocityUtils.parseVelocity(emailTemplate.getSubject(), contextMap);
			emailMessage.setTemplateKey(emailTemplate.getTemplateKey());
			emailMessage.setSubject(subject);
			emailMessage.setHtmlBody(htmlBody);
			emailMessage.setPlainBody(plainBody);
			return emailMessage;
		}
		else {
			emailMessage.setSubject("This is TEST, Welcome to MOOTLY");
			emailMessage.setHtmlBody("<B>COOL</B>");
			return emailMessage;
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
}
