/*
 * In this class we are creating a document for storing value of Deduction details of user
 * according to form 16.
 * @author 
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.component.support.forms.FormMap;
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
@FormFields(fieldNames={"member_file","description","protected","additionalnotes"})
public class MemberDrive extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(MemberDrive.class);
	private static final String MEMBER_DRIVE_FOLDER_NAME="members";
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		String subDriveName = request.getRequestContext().getResolvedSiteMapItem().getParameter("subDriveName");
		request.setAttribute("subDriveName", subDriveName);
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
		String baseRelPathToMemberFiles = MEMBER_DRIVE_FOLDER_NAME+"/"+getUserNameNormalized()+"/drive";
		List<HippoDocumentBean> listOfAllMemberFiles = loadAllBeansUnderTheFolder(request, response, baseRelPathToMemberFiles, null, null);
		request.setAttribute("listOfAllMemberFiles", listOfAllMemberFiles);
		HippoBean memberDriveHippoBean = getSiteContentBaseBeanForReseller(request).getBean(baseRelPathToMemberFiles);
		
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
		FormFields formFields = this.getClass().getAnnotation(FormFields.class);		
		FormMap formMap = new FormMap(request, formFields.fieldNames());
		WorkflowPersistenceManager wpm = null;
		Session persistableSession = null; 
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			MemberDriveHandler memberDriveHandler = new MemberDriveHandler(request, formMap);
			Boolean isFileSave = memberDriveHandler.SaveFileInMemberDrive(null, subDriveName, wpm, isLoggedIn());
			if(isFileSave){
				response.setRenderParameter("FileUpload", "Success");
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
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
		builder.append(getSiteContentBaseBeanForReseller(request).getCanonicalPath());
		builder.append('/');
		builder.append(MEMBER_DRIVE_FOLDER_NAME).append("/").append(getUserNameNormalized()).append("/").append("drive");
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
		String baseRelPathToMemberFiles = MEMBER_DRIVE_FOLDER_NAME+"/"+getUserNameNormalized()+"/drive";
		List<HippoDocumentBean> listOfAllMemberFiles = loadAllBeansUnderTheFolder(request, response, baseRelPathToMemberFiles, null, null);
		try {
			persistableSession=getPersistableSession(request);
			persistableSession.save();
			wpm=getWorkflowPersistenceManager(persistableSession);
			//wpm.setWorkflowCallbackHandler(new FullDeleteWorkflowCallbackHandler());
			for(HippoDocumentBean o:listOfAllMemberFiles){
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