package com.mootly.wcm.member.service;


import java.util.Iterator;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.Service;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.member.MemberDriveHandler;
import com.mootly.wcm.utils.GoGreenUtil;


public class SRDocumentUpload extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(SRDocumentUpload.class);

	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
	}

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);				
		ServiceRequestManager requestManager = new ServiceRequestManager(request, getITRInitData(request).getSiteContentBaseBeanForReseller(request));
		request.setAttribute("ReqSuccess", request.getRequestContext().getAttribute("Success"));
		request.setAttribute("serviceRequestNumber", request.getRequestContext().getAttribute("serviceRequestNumber"));
		request.setAttribute("srdocument", request.getRequestContext().getAttribute("document"));
		Service service = (Service) request.getRequestContext().getAttribute("document");		
		request.setAttribute("documentRequired", service.getDocumentRequired());
		if(requestManager.getSRDocumentToUpdate(String.valueOf(request.getRequestContext().getAttribute("serviceRequestNumber"))) != null){
			boolean documentUploaded = requestManager.getSRDocumentToUpdate((String)request.getRequestContext().getAttribute("serviceRequestNumber")).getDocumentUploaded();
			request.setAttribute("documentUploaded", documentUploaded);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		//super.doAction(request, response);
		//Long serviceRequestNumber = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_SERVICE_REQUEST);
		try {
			Session persistableSession = getPersistableSession(request);
			WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewWorkflowCallbackHandler());
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(log.isInfoEnabled()){
				log.info("Lets analyse the request so that we can seprate::" + isMultipart);
			}
			ServiceRequestManager requestManager = new ServiceRequestManager(request, getITRInitData(request).getSiteContentBaseBeanForReseller(request));
			String srRequestNumber = GoGreenUtil.getEscapedParameter(request, "serviceRequestNumber");
			ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());					
			List<FileItem> items = fileUpload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					if(item.getFieldName().equalsIgnoreCase("serviceRequestNumber")) {
						srRequestNumber = item.getString();
					}
				} 
			}					
			Service resServicedocument = requestManager.getServiceForServiceRequest(srRequestNumber);
			String subDriveName = StringUtils.deleteWhitespace(resServicedocument.getName()).toLowerCase();
			if(log.isInfoEnabled()){
				log.info("Have the name of subdrive to be Create::" + subDriveName);
			}
			MemberDriveHandler driveHandler = new MemberDriveHandler(request);
			//boolean isFileSave = driveHandler.SaveFileInMemberDrive(null, subDriveName, items, wpm, false);
			//if(isFileSave){
			//	boolean isUpdated = requestManager.UdateTheServiceRequestWithMemberDrive(wpm, subDriveName, srRequestNumber);
			//	response.setRenderParameter("srDocumentUpdated", "true");
			//}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while getting Repository session",e);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static class FullReviewWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}
