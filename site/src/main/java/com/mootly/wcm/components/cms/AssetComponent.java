/*
 * In this class we are creating a document for storing value of Deduction details of user
 * according to form 16.
 * @author 
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.components.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
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

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.beans.cms.AssetDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;

@FormFields(fieldNames={"member_file","description"})
public class AssetComponent extends BaseComponent {

	private static final Logger log = LoggerFactory.getLogger(AssetComponent.class);
	private static final String RESELLER_FOLDER_NAME="resellers";
	private static final long MEMBER_FILE_SIZE= 1024 * 1024;
	private static final String FILE_DATA="fileData";
	private static final String CONTENT_TYPE="ContentType";
	private static final String FILE_NAME="fileName";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		String fileuuid=getPublicRequestParameter(request, "delete");
		if(DeleteAssetDriveFile(request, response, fileuuid)){
			request.setAttribute("delete", "Success");
		}
		if(getAssetDriveFileResource(request, response)!=null){
			request.setAttribute("memberFiles", getAssetDriveFileResource(request, response));
		}
		request.setAttribute("msg", request.getParameter("FileUpload"));
		/*List<ValueListDocument> uploadDocumentList=new ArrayList<ValueListDocument>();
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
				List<AssetDocument> smapleDocList=valuelistFolder.getDocuments(AssetDocument.class);
				request.setAttribute("sampleDocList", smapleDocList);
			}
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);//
		FormFields formFields=this.getClass().getAnnotation(FormFields.class);		
		FormMap formMap=new FormMap(request, formFields.fieldNames());
		Map<String, byte[]> files = new HashMap<String, byte[]>();
		Map<String,String> fileDetails= new HashMap<String, String>();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			try {
				ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
				String str_max_size = request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize");
				if(str_max_size!=null){
					long maxsize=Long.parseLong(request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize"));
					fileUpload.setSizeMax(MEMBER_FILE_SIZE * maxsize);
				}
				List<FileItem> items = fileUpload.parseRequest(request);
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
		AssetDocument assetDrive=new AssetDocument();
		assetDrive.setMemberFile(new ByteArrayInputStream(files.get(FILE_DATA)));
		assetDrive.setContentType(fileDetails.get(CONTENT_TYPE));
		assetDrive.setDescription(formMap.getField("description").getValue());
		//assetDrive.setDocPassword(formMap.getField("protected").getValue());
		//assetDrive.setDocAdditionalNotes(formMap.getField("additionalnotes").getValue());
		AssetDocument returnMemberDriveDoc=createMemberDrive(request, response, assetDrive, fileDetails.get(FILE_NAME));
		if(returnMemberDriveDoc!=null){
			response.setRenderParameter("FileUpload", "Success");
		}
	}
	/**
	 * This Method is used to Create the MemberDrive Document and Return that Document Object
	 * 
	 * @param HstRequest
	 * @param HstResponse
	 * @param MemberAssetDocument Object
	 * 
	 * @exception {@link ObjectBeanManagerException},{@link RepositoryException}
	 * 
	 * @return {@link AssetDocument} Created in Repository
	 * 
	 * **/
	public AssetDocument createMemberDrive(HstRequest request,HstResponse response,AssetDocument assetDrive,String fileName){
		WorkflowPersistenceManager wpm = null;
		Session persistableSession = null;
		String assetDocPath = null; 
		try{
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String primaryPath = getAssetDriveDocPath(request);
			assetDocPath = wpm.createAndReturn(primaryPath, AssetDocument.NAMESPACE, fileName, true);
			AssetDocument assetDoc = (AssetDocument) wpm.getObject(assetDocPath);
			if(assetDoc != null){
				assetDoc.setMemberFile(assetDrive.getMemberFile());
				assetDoc.setContentType(assetDrive.getContentType());
				assetDoc.setDescription(assetDrive.getDescription());
				//assetDoc.setDocPassword(assetDrive.getDocPassword());
				//assetDoc.setDocAdditionalNotes(assetDrive.getDocAdditionalNotes());
				wpm.update(assetDoc);
				return assetDoc;
			}
			return null;
		}catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error to get the PersistableSession From JCR Repository!!");
			return null;
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error to Save MemberDrive Doc at " +assetDocPath + " path!!"+e);
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
	public static String getAssetDriveDocPath(HstRequest request) {
		ITReturnComponentHelper componentHelper = new ITReturnComponentHelper();
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/').append(RESELLER_FOLDER_NAME).append('/').append(componentHelper.getResellerId(request));
		builder.append("/cms/assets");
		if(log.isInfoEnabled()){
			log.info("Lets check Path For save of assets Document::"+builder.toString());
		}
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
	 * @return List<AssetDocument> type {@link AssetDocument}
	 * */
	public List<AssetDocument> getAssetDriveFileResource(HstRequest request,HstResponse response){
		List<AssetDocument> memberFiles=new ArrayList<AssetDocument>();
		try {
			HippoFolder hippofolder=(HippoFolder) getObjectBeanManager(request).getObject(getAssetDriveDocPath(request).toLowerCase());
			if(hippofolder!=null){
				memberFiles=hippofolder.getDocuments(AssetDocument.class);				
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
	public boolean DeleteAssetDriveFile(HstRequest request,HstResponse response,String fileuuid){
		WorkflowPersistenceManager wpm = null;
		Session persistableSession = null;
		boolean delete = false;
		if(StringUtils.isNotBlank(fileuuid)) {
			try {
				persistableSession = getPersistableSession(request);
				persistableSession.save();
				wpm = getWorkflowPersistenceManager(persistableSession);
				//wpm.setWorkflowCallbackHandler(new FullDeleteWorkflowCallbackHandler());
				for(AssetDocument o:getAssetDriveFileResource(request, response)){
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
		}
		return delete;
	}
	public static class FullDeleteWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.delete();
		}
	}
}