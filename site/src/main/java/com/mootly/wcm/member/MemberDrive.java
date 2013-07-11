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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
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
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberDriveDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.components.ITReturnComponent;


@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class})
@FormFields(fieldNames={"member_file","description","protected"})
public class MemberDrive extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(MemberDrive.class);
	private static final String MEMBER_DRIVE_FOLDER_NAME="Members";
	private static final long MEMBER_FILE_SIZE= 1024 * 1024;
	private static final String FILE_DATA="fileData";
	private static final String CONTENT_TYPE="ContentType";
	private static final String FILE_NAME="fileName";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		String fileuuid=getPublicRequestParameter(request, "delete");
		if(DeleteMemberDriveFile(request, response, fileuuid)){
			request.setAttribute("delete", "Success");
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
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		FormFields formFields=this.getClass().getAnnotation(FormFields.class);		
		FormMap formMap=new FormMap(request, formFields.fieldNames());
		Map<String, byte[]> files = new HashMap<String, byte[]>();
		Map<String,String> fileDetails= new HashMap<String, String>();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			try {
				ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
				String str_max_size=request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize");
				if(str_max_size!=null){
					long maxsize=Long.parseLong(request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize"));
					fileUpload.setSizeMax(MEMBER_FILE_SIZE * maxsize);
				}
				List<FileItem> items=fileUpload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						if(formMap.getField(item.getFieldName())!=null){
							formMap.getField(item.getFieldName()).addValue(item.getString());
						}
					} else {
						InputStream inputStream = item.getInputStream();							
						byte[] data = IOUtils.toByteArray(inputStream);
						files.put(FILE_DATA, data);
						fileDetails.put(FILE_NAME, item.getName());
						fileDetails.put(CONTENT_TYPE, item.getContentType());
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				log.error("Error while Parsing the request of MultiPart Type",e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Error while get input of File Item",e);
			}
		}
		MemberDriveDocument memberDrive=new MemberDriveDocument();
		memberDrive.setMemberFile(new ByteArrayInputStream(files.get(FILE_DATA)));
		memberDrive.setContentType(fileDetails.get(CONTENT_TYPE));
		memberDrive.setDescription(formMap.getField("description").getValue());
		memberDrive.setDocPassword(formMap.getField("protected").getValue());
		MemberDriveDocument returnMemberDriveDoc=createMemberDrive(request, response, memberDrive, fileDetails.get(FILE_NAME));
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
			persistableSession=getPersistableSession(request);
			wpm=getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String primaryPath=getMemberDriveDocPath(request);
			memberDriveDocPath=wpm.createAndReturn(primaryPath, MemberDriveDocument.NAMESPACE, fileName, true);
			MemberDriveDocument memberDriveDoc=(MemberDriveDocument) wpm.getObject(memberDriveDocPath);
			if(memberDriveDoc!=null){
				memberDriveDoc.setMemberFile(memberDrive.getMemberFile());
				memberDriveDoc.setContentType(memberDrive.getContentType());
				memberDriveDoc.setDescription(memberDrive.getDescription());
				memberDriveDoc.setDocPassword(memberDrive.getDocPassword());
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
		String returnType=request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType");
		String financialYear=request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear");
		String pan=request.getRequestContext().getResolvedSiteMapItem().getParameter("pan");
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_DRIVE_FOLDER_NAME).append("/").append(request.getUserPrincipal().getName().replaceAll("@","-at-")).append("/").append("Drive");
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
			persistableSession=getPersistableSession(request);
			persistableSession.save();
			wpm=getWorkflowPersistenceManager(persistableSession);
			//wpm.setWorkflowCallbackHandler(new FullDeleteWorkflowCallbackHandler());
			for(MemberDriveDocument o:getMemberDriveFileResource(request, response)){
				if(o.getCanonicalUUID().equals(fileuuid)){
					wpm.remove(o);
					wpm.save();
					delete=true;
					break;
				}
			}
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
		return delete;
	}
	public static class FullDeleteWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.delete();
		}
	}
}