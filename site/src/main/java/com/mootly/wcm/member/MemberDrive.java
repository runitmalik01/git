/*
 * In this class we are creating a document for storing value of Deduction details of user
 * according to form 16.
 * @author 
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.component.support.forms.StoreFormResult;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberDriveDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.member.service.ServiceRequestManager;
import com.mootly.wcm.services.ds.DigitalSignatureService;
import com.mootly.wcm.services.ds.exception.InvalidDigitalSignatureException;
import com.mootly.wcm.services.ds.exception.MissingPrivateKeyException;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;

@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class})
@FormFields(fieldNames={"member_file","description","protected","additionalnotes","certificateType","certificateIssuerDN","certificateSubjectDN","certificateGetNotBefore","certificateGetNotAfter"})
public class MemberDrive extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(MemberDrive.class);
	private static final String MEMBER_DRIVE_FOLDER_NAME="members";
	DigitalSignatureService digitalSignatureService = null;
	
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		digitalSignatureService =  context.getBean(DigitalSignatureService.class);
	}
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		String subDriveName = request.getRequestContext().getResolvedSiteMapItem().getParameter("subDriveName");
		request.setAttribute("subDriveName", subDriveName);
		
		String serviceRequestNumber = getPublicRequestParameter(request, "serviceRequest");
		if(StringUtils.isNotBlank(serviceRequestNumber)) {
			ServiceRequestManager requestManager = new ServiceRequestManager(request, getITRInitData(request).getSiteContentBaseBeanForReseller(request));
			Service serviceDocument = requestManager.getServiceForServiceRequest(serviceRequestNumber);
			if(serviceDocument != null){
				request.setAttribute("documentList", serviceDocument.getDocumentNames());
				request.setAttribute("srDocument", serviceDocument);
			}
		}
		
		String fileuuid=getPublicRequestParameter(request, "delete");
		if(fileuuid != null){
			if(DeleteMemberDriveFile(request, response, fileuuid)){
				request.setAttribute("delete", "Success");
				//return;
			}	
		}
		if(getMemberDriveFileResource(request, response)!=null){
			request.setAttribute("memberFiles", getMemberDriveFileResource(request, response));
		}
		request.setAttribute("msg", request.getParameter("FileUpload"));
		List<ValueListDocument> uploadDocumentList=new ArrayList<ValueListDocument>();
		try {
			String listPath=request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath()+"/uploaddocumentlist";
			HippoFolder valuelistFolder=(HippoFolder)getObjectBeanManager(request).getObject(listPath);
			if(valuelistFolder!=null){
				uploadDocumentList=valuelistFolder.getDocuments(ValueListDocument.class);
				MemberPersonalInformation memberinfo=(MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
				String itrForm=memberinfo.getFlexField("flex_string_ITRForm", "");
				ResourceBundle rsbundle=ResourceBundle.getBundle("messages");
				String packageName=rsbundle.getString(itrForm+".packageName");
				if(uploadDocumentList!=null){
					for(ValueListDocument valListDoc:uploadDocumentList){
						if(valListDoc.getName().toString().equalsIgnoreCase(packageName)){
							request.setAttribute("valueList", valListDoc);
						}else{
							if(valListDoc.getName().toString().equals("Basic")){
								request.setAttribute("valueList", valListDoc);
							}
						}
					}
				}
				List<MemberDriveDocument> smapleDocList=valuelistFolder.getDocuments(MemberDriveDocument.class);
				request.setAttribute("sampleDocList", smapleDocList);
			}
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String baseRelPathToMemberFiles = MEMBER_DRIVE_FOLDER_NAME+"/"+ getITRInitData(request).getUserNameNormalized()+"/drive";
		List<HippoDocumentBean> listOfAllMemberFiles = getITRInitData(request).loadAllBeansUnderTheFolder(request, getITRInitData(request).getRelBasePathToMemberDriveDocuments(), null, null);
		request.setAttribute("listOfAllMemberFiles", listOfAllMemberFiles);
		request.setAttribute("memberFiles", listOfAllMemberFiles);
		HippoBean memberDriveHippoBean = getITRInitData(request).getSiteContentBaseBeanForReseller(request).getBean(getITRInitData(request).getRelBasePathToMemberDriveDocuments());

		if(memberDriveHippoBean instanceof HippoFolderBean){
			HippoFolderBean memberDriveHippoFolderBean = (HippoFolderBean) memberDriveHippoBean;
			List<HippoFolderBean> folderBeans = memberDriveHippoFolderBean.getFolders();
			request.setAttribute("folderBeans", folderBeans);
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);//
		String subDriveName = request.getRequestContext().getResolvedSiteMapItem().getParameter("subDriveName");
		//lets validate the Digital Signature Right here before we even move on to next step
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		boolean isValid = false;
		String privateKeyPassword = null;
		byte[] data = null;
		String fileName = null;
		String contentType= null;
		if (isMultipart) {
			try {
				ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
				String str_max_size = request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize");
				if(str_max_size != null){
					long maxsize = Long.parseLong(request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize"));
					fileUpload.setSizeMax(MemberDriveHandler.MEMBER_FILE_SIZE * maxsize);
				}
				List<FileItem> items = fileUpload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();		
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						if(item.getFieldName()!=null && item.getFieldName().equals("protected")) {
							privateKeyPassword = item.getString();
							FormField frmFieldProtected = new FormField("protected");
							frmFieldProtected.addValue(item.getString());
							getITRInitData(request).getFormMap().addFormField(frmFieldProtected);
						}
						else if (item.getFieldName()!=null && item.getFieldName().equals("additionalnotes")) {
							FormField frmFieldAdditionalNotes = new FormField("additionalnotes");
							frmFieldAdditionalNotes.addValue(item.getString());
							getITRInitData(request).getFormMap().addFormField(frmFieldAdditionalNotes);
						}
						else if (item.getFieldName()!=null && item.getFieldName().equals("description")) {
							FormField frmFieldDescription = new FormField("description");
							frmFieldDescription.addValue(item.getString());
							getITRInitData(request).getFormMap().addFormField(frmFieldDescription);
						}
					} else {
						InputStream inputStream = item.getInputStream();							
						data = IOUtils.toByteArray(inputStream);
						fileName = item.getName();
						contentType = item.getContentType();
						
						FormField frmFieldFileName = new FormField("fileName");
						frmFieldFileName.addValue(fileName);
						getITRInitData(request).getFormMap().addFormField(frmFieldFileName);
						
						FormField frmFieldContentType = new FormField("contentType");
						frmFieldContentType.addValue(contentType);
						getITRInitData(request).getFormMap().addFormField(frmFieldContentType);
						
						FormField frmFieldSize = new FormField("size");
						frmFieldSize.addValue(String.valueOf( item.getSize() ));
						getITRInitData(request).getFormMap().addFormField(frmFieldSize);
					}
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Error while get input of File Item",e);
				getITRInitData(request).getFormMap().addMessage("err.invalid.ds", "err.invalid.ds");
			}catch (FileUploadException e) {
				// TODO Auto-generated catch block
				log.error("Error while get input of File Item",e);
				getITRInitData(request).getFormMap().addMessage("err.invalid.ds", "err.invalid.ds");
			}
		}
		if (subDriveName != null && subDriveName.equals("digitalsignature")) {
				if (privateKeyPassword != null && data != null) {
					DigitalSignatureWrapper digitalSignatureWrapper = new DigitalSignatureWrapper(data, privateKeyPassword);
					try {
						X509Certificate certificate = digitalSignatureService.validateAndGetCertificate(digitalSignatureWrapper);
						if (certificate != null) {
							
							FormField frmFieldCertificateType = new FormField("certificateType");
							frmFieldCertificateType.addValue(certificate.getType());
							
							FormField frmFieldCertificateIssuerDN = new FormField("certificateIssuerDN");
							frmFieldCertificateIssuerDN.addValue(certificate.getIssuerDN().getName());
							
							FormField frmFieldCertificateSubjectDN = new FormField("certificateSubjectDN");
							frmFieldCertificateSubjectDN.addValue(certificate.getSubjectDN().getName());
							
							FormField frmFieldCertificateGetNotBefore = new FormField("certificateGetNotBefore");
							frmFieldCertificateGetNotBefore.addValue(String.valueOf(certificate.getNotBefore().getTime()));
							
							FormField frmFieldCertificateGetNotAfter = new FormField("certificateGetNotAfter");
							frmFieldCertificateGetNotAfter.addValue(String.valueOf(certificate.getNotAfter().getTime()));
							
							getITRInitData(request).getFormMap().addFormField(frmFieldCertificateType);
							getITRInitData(request).getFormMap().addFormField(frmFieldCertificateIssuerDN);
							getITRInitData(request).getFormMap().addFormField(frmFieldCertificateSubjectDN);
							getITRInitData(request).getFormMap().addFormField(frmFieldCertificateGetNotBefore);
							getITRInitData(request).getFormMap().addFormField(frmFieldCertificateGetNotAfter);
						}
						String subjectDN = certificate.getSubjectX500Principal().getName();
						isValid = true;
					} catch (MissingPrivateKeyException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						getITRInitData(request).getFormMap().addMessage("err.invalid.ds", "err.invalid.ds.incorrectPassword");
					} catch (InvalidDigitalSignatureException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						getITRInitData(request).getFormMap().addMessage("err.invalid.ds", "err.invalid.ds");
					}
				}
				else {
					if ( getITRInitData(request).getFormMap() != null) {
						getITRInitData(request).getFormMap().addMessage("err.invalid.ds", "err.invalid.ds");
					}
				}
				if (!isValid) {
					log.error("Invalid Digital Signature can't proceed");
					StoreFormResult sfr = new StoreFormResult();
					FormUtils.persistFormMap(request, response, getITRInitData(request).getFormMap(), sfr);
					return;
				}
		}
		if (data == null || fileName == null || contentType == null) return;
		//Will deak with this later
		String serviceRequestNumber = getPublicRequestParameter(request, "serviceRequest");
		//FormFields formFields = this.getClass().getAnnotation(FormFields.class);		
		//FormMap formMap = new FormMap(request, formFields.fieldNames());
		WorkflowPersistenceManager wpm = null;
		Session persistableSession = null; 
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String saveFilePath = null;
			String documentName = fileName.replace(' ', '-');
			if (subDriveName != null && subDriveName.equals("digitalsignature")) {
				documentName = "digitalsignature";
				saveFilePath = getITRInitData(request).getAbsoluteBasePathToReturnDocuments();//+ "/digitalsignature";
				MemberDriveDocument existingDriveDocument = (MemberDriveDocument) wpm.getObject(saveFilePath + "/digitalsignature");
				if (existingDriveDocument != null) {
					getITRInitData(request).getFormMap().addMessage("err.invalid.ds", "err.invalid.ds.duplicate");
					StoreFormResult sfr = new StoreFormResult();
					FormUtils.persistFormMap(request, response, getITRInitData(request).getFormMap(), sfr);
					return;
				}
			}
			else {
				saveFilePath = getITRInitData(request).getAbsoluteBasePathToMemberDriveDocuments();
			}
			boolean isFileSave = false;
			String memberDriveDocPath = wpm.createAndReturn(saveFilePath, MemberDriveDocument.NAMESPACE, documentName , true);
			MemberDriveDocument memberDriveDoc = (MemberDriveDocument) wpm.getObject(memberDriveDocPath);
			if(memberDriveDoc != null){
				memberDriveDoc.setMemberFile(new ByteArrayInputStream(data));
				memberDriveDoc.setContentType(contentType);
				memberDriveDoc.setMemberFileName(fileName);
				memberDriveDoc.fill(getITRInitData(request).getFormMap());
				wpm.update(memberDriveDoc);
				//memberDriveDoc = (MemberDriveDocument) wpm.getObject(memberDriveDocPath);
				//MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) wpm.getObject(getITRInitData(request).getAbsoluteBasePathToReturnDocuments() + "/memberpersonalinformation");
				//memberPersonalInformation.setPathToDigitalSignature(memberDriveDoc.getCanonicalUUID());
				//wpm.update(memberDriveDoc);
			}
			if(isFileSave && serviceRequestNumber != null){				
				ServiceRequestManager requestManager = new ServiceRequestManager(request, getITRInitData(request).getSiteContentBaseBeanForReseller(request));
				requestManager.UdateTheServiceRequestWithMemberDrive(wpm, subDriveName, serviceRequestNumber);
				response.setRenderParameter("FileUpload", "Success");
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error to get the PersistableSession From JCR Repository!!",e);
		} catch (ObjectBeanPersistenceException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("Error to get the PersistableSession From JCR Repository!!",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("Error to get the PersistableSession From JCR Repository!!",e);
		}
	}
	/**
	 * This Method is used to Create the MemberDrive Document and Return that Document Object
	 * 
	 * @param HstRequest
	 * @param MemberDriveDocument Object
	 * 
	 * @exception {@link ObjectBeanManagerException},{@link RepositoryException}
	 * 
	 * @return {@link MemberDriveDocument} Created in Repository
	 * 
	 * **/
	public MemberDriveDocument SaveFileInMemberDrive(HstRequest request,MemberDriveDocument memberDrive,String fileName){

		WorkflowPersistenceManager wpm = null;
		Session persistableSession = null;
		String memberDriveDocPath = null; 
		try{
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String primaryPath = getMemberDriveDocPath(request);
			memberDriveDocPath = wpm.createAndReturn(primaryPath, MemberDriveDocument.NAMESPACE, fileName, true);
			MemberDriveDocument memberDriveDoc = (MemberDriveDocument) wpm.getObject(memberDriveDocPath);
			if(memberDriveDoc != null){
				memberDriveDoc.setMemberFile(memberDrive.getMemberFile());
				memberDriveDoc.setContentType(memberDrive.getContentType());
				memberDriveDoc.setDescription(memberDrive.getDescription());
				memberDriveDoc.setDocPassword(memberDrive.getDocPassword());
				memberDriveDoc.setDocAdditionalNotes(memberDrive.getDocAdditionalNotes());
				wpm.update(memberDriveDoc);
				return memberDriveDoc;
			}
			return null;
		}catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error to get the PersistableSession From JCR Repository!!");
			return null;
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error to Save MemberDrive Doc at " +memberDriveDocPath + " path!!"+e);
			return null;
		}finally{
			if(persistableSession!=null){
				persistableSession.logout();
			}
		}
	}
	/**
	 * This Method is used to Generate Path to Save Doc in Repository
	 * 
	 * @param HstRequest
	 * 
	 * @return String Path for Document
	 * */
	public String getMemberDriveDocPath(HstRequest request) {
		String returnType=request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType");
		String financialYear=request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear");
		String pan=request.getRequestContext().getResolvedSiteMapItem().getParameter("pan");
		StringBuilder builder = new StringBuilder();
		builder.append(getITRInitData(request).getSiteContentBaseBeanForReseller(request).getCanonicalPath());
		builder.append('/');
		builder.append(MEMBER_DRIVE_FOLDER_NAME).append("/").append(getITRInitData(request).getUserNameNormalized()).append("/").append("drive");
		builder.append("/").append(pan).append("/").append(financialYear).append("/").append(returnType);
		return builder.toString();
	}
	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
	/**
	 * This Method is used to Get all Files Saved in Member Drive 
	 * 
	 * @param HstRequest
	 * @param HstResponse
	 * 
	 * @return List<MemberDriveDocument> type {@link MemberDriveDocument}
	 * */
	public List<MemberDriveDocument> getMemberDriveFileResource(HstRequest request,HstResponse response){
		List<MemberDriveDocument> memberFiles=new ArrayList<MemberDriveDocument>();
		try {
			MemberDriveHandler driveHandler = new MemberDriveHandler(request, null);
			//HippoFolder hippofolder=(HippoFolder) getObjectBeanManager(request).getObject(getMemberDriveDocPath(request).toLowerCase());
			if(log.isInfoEnabled()){
				log.info("Path to fetch all member files Name::"+driveHandler.getMemberDriveDocPathHandler(null, null));
			}
			HippoFolder hippofolder=(HippoFolder) getObjectBeanManager(request).getObject(driveHandler.getMemberDriveDocPathHandler(null, null));
			if(hippofolder!=null){
				memberFiles=hippofolder.getDocuments(MemberDriveDocument.class);				
			}
			return memberFiles;
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while to get the Object from Repo path"+e);
			return null;
		}
	}
	/**
	 * This Method is used to Delete Files Saved in Member Drive 
	 * 
	 * @param HstRequest
	 * @param HstResponse
	 * @String fileuuid CanonicalUUID of document that to Be deleted
	 * 
	 * @return Boolean To confirm that File has been Deleted From Member Drive
	 * */
	public boolean DeleteMemberDriveFile(HstRequest request,HstResponse response,String fileuuid){
		WorkflowPersistenceManager wpm=null;
		Session persistableSession=null;
		boolean delete=false;
		String baseRelPathToMemberFiles = MEMBER_DRIVE_FOLDER_NAME+"/" + getITRInitData(request).getUserNameNormalized() +"/drive";
		List<HippoDocumentBean> listOfAllMemberFiles = getITRInitData(request).loadAllBeansUnderTheFolder(request, baseRelPathToMemberFiles, null, null);
		try {
			persistableSession=getPersistableSession(request);
			//persistableSession.save();
			wpm=getWorkflowPersistenceManager(persistableSession);
			MemberDriveDocument memberDriveDocument = (MemberDriveDocument) wpm.getObjectByUuid(fileuuid);
			if (memberDriveDocument != null) {
				wpm.remove(memberDriveDocument);
				wpm.save();
			}
			/*
			//wpm.setWorkflowCallbackHandler(new FullDeleteWorkflowCallbackHandler());
			for(HippoDocumentBean o:listOfAllMemberFiles){
				if(o.getCanonicalUUID().equals(fileuuid)){
					wpm.remove(o);
					wpm.save();
					delete=true;
					break;
				}
			}
			*/
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error to get the PersistableSession From JCR Repository!!"+e);
			return false;
		} catch (ObjectBeanPersistenceException e) {
			// TODO Auto-generated catch block
			log.error("Error while to Delete the Object from Repo path"+e);
			return false;
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(persistableSession!=null){
				persistableSession.logout();
			}
		}
		return delete;
	}
	
	
	public static class FullDeleteWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.delete();
		}
	}
}