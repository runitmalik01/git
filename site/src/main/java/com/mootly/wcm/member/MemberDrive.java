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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberDriveDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;

@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class})
public class MemberDrive extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(MemberDrive.class);
	private static final String MEMBER_DRIVE_FOLDER_NAME="Members";
	private static final long MEMBER_FILE_SIZE= 1024 * 1024;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("This is member Drive page");
		}
		if(getMemberDriveFileResource(request, response)!=null){
			request.setAttribute("memberFiles", getMemberDriveFileResource(request, response));
		}
		request.setAttribute("msg", request.getParameter("FileUpload"));
		String fileuuid=getPublicRequestParameter(request, "delete");
		if(DeleteMemberDriveFile(request, response, fileuuid)){
			request.setAttribute("delete", "Success");
		}
		String o=MemberPersonalInformation.class.getSimpleName().toLowerCase();
		request.setAttribute(o, request.getAttribute(o));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		FormMap formMap=new FormMap(request, new String[]{"member_file"});
		HashMap<String, byte[]> files = new HashMap<String, byte[]>();
		FileItemStream fileItemStream=null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			ServletFileUpload servletFileUpload = new ServletFileUpload();
			long maxsize=Long.parseLong(request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize"));
			servletFileUpload.setFileSizeMax(MEMBER_FILE_SIZE * maxsize);
			try {
				FileItemIterator iter = servletFileUpload.getItemIterator(request);
				try {
					while (iter.hasNext()) {
						fileItemStream = iter.next();
						if(formMap.getField(fileItemStream.getFieldName())!=null){
							FormField formField = formMap.getField(fileItemStream.getFieldName());
							if (formField != null) {
								InputStream inputStream = fileItemStream.openStream();
								/*if (fileItemStream.isFormField()) {
									StringWriter writer = new StringWriter();
									IOUtils.copy(fileItemStream.openStream(), writer, "UTF-8");
									formField.addValue(writer.toString());
								} else {*/
								byte[] data = IOUtils.toByteArray(inputStream);
								files.put(fileItemStream.getName(), data);
								//}
								inputStream.close();
							}
						}
					}
				} catch(FileUploadBase.FileUploadIOException e) {
					log.error("File size exceeded", e);
				}
			} catch(FileUploadException e) {
				log.error("A file upload error occurred", e);
			} catch (IOException e) {
				log.error("An error occurred while processing multipart form data", e);
			}
		}
		MemberDriveDocument memberDrive=new MemberDriveDocument();
		memberDrive.setMemberFile(new ByteArrayInputStream(files.get(fileItemStream.getName())));
		memberDrive.setContentType(fileItemStream.getContentType());
		MemberDriveDocument returnMemberDriveDoc=createMemberDrive(request, response, memberDrive, fileItemStream.getName());
		if(returnMemberDriveDoc!=null){
			response.setRenderParameter("FileUpload", "Success");
		}
	}
	/**
	 * This Method is used to Create the MemberDrive Document and Return that Document Object
	 * 
	 * @param HstRequest
	 * @param HstResponse
	 * @param MemberDriveDocument Object
	 * 
	 * @exception {@link ObjectBeanManagerException},{@link RepositoryException}
	 * 
	 * @return {@link MemberDriveDocument} Created in Repository
	 * 
	 * **/
	public MemberDriveDocument createMemberDrive(HstRequest request,HstResponse response,MemberDriveDocument memberDrive,String fileName){
		WorkflowPersistenceManager wpm=null;
		Session persistableSession=null;
		String memberDriveDocPath=null; 
		try{
			persistableSession=getPersistableSession(request,new SimpleCredentials("admin", "admin".toCharArray()));
			wpm=getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String primaryPath=getMemberDriveDocPath(request);
			memberDriveDocPath=wpm.createAndReturn(primaryPath, MemberDriveDocument.NAMESPACE, fileName, true);
			MemberDriveDocument memberDriveDoc=(MemberDriveDocument) wpm.getObject(memberDriveDocPath);
			if(memberDriveDoc!=null){
				memberDriveDoc.setMemberFile(memberDrive.getMemberFile());
				memberDriveDoc.setContentType(memberDrive.getContentType());
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
	public static String getMemberDriveDocPath(HstRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_DRIVE_FOLDER_NAME).append("/").append(request.getUserPrincipal().getName().replaceAll("@","-at-")).append("/").append("Drive");
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
			HippoFolder hippofolder=(HippoFolder) getObjectBeanManager(request).getObject(getMemberDriveDocPath(request).toLowerCase());
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
		try {
			persistableSession=getPersistableSession(request,new SimpleCredentials("admin", "admin".toCharArray()));
			wpm=getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullDeleteWorkflowCallbackHandler());
			for(MemberDriveDocument o:getMemberDriveFileResource(request, response)){
				if(o.getCanonicalUUID().equals(fileuuid)){
					wpm.update(o);
					delete=true;
					break;
				}
			}
			return delete;
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error to get the PersistableSession From JCR Repository!!"+e);
			return false;
		} catch (ObjectBeanPersistenceException e) {
			// TODO Auto-generated catch block
			log.error("Error while to Delete the Object from Repo path"+e);
			return false;
		} finally{
			if(persistableSession!=null){
				persistableSession.logout();
			}
		}
	}
	public static class FullDeleteWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.delete();
		}
	}
}