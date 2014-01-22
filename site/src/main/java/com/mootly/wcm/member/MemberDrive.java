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

import org.apache.commons.lang.StringUtils;
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
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.beans.compound.FormField;
import com.mootly.wcm.beans.events.MemberPersonalInfoUpdateHandler;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.member.service.ServiceRequestManager;
import com.mootly.wcm.services.ds.exception.InvalidDigitalSignatureException;
import com.mootly.wcm.services.ds.exception.MissingDigitalCertificateException;
import com.mootly.wcm.services.ds.exception.MissingPrivateKeyException;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;


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
		//set the name of drive in request so that we can show only subdrive documents
		String subDriveName = request.getRequestContext().getResolvedSiteMapItem().getParameter("subDriveName");
		request.setAttribute("subDriveName", subDriveName);
		
		//Handle Pending service requests in member.
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
		if(DeleteMemberDriveFile(request, response, fileuuid)){
			request.setAttribute("delete", "Success");
		}
		if(getMemberDriveFileResource(request, response)!=null){
			request.setAttribute("memberFiles", getMemberDriveFileResource(request, response));
		}
		request.setAttribute("msg", request.getParameter("FileUpload"));
		request.setAttribute("errorList", request.getParameter("errorList"));
		request.setAttribute("digiverified", request.getParameter("digiverified"));
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
		String baseRelPathToMemberFiles = MEMBER_DRIVE_FOLDER_NAME+"/"+ getITRInitData(request).getUserNameNormalized()+"/drive";
		List<HippoDocumentBean> listOfAllMemberFiles = getITRInitData(request).loadAllBeansUnderTheFolder(request, baseRelPathToMemberFiles, null, null);
		request.setAttribute("listOfAllMemberFiles", listOfAllMemberFiles);
		HippoBean memberDriveHippoBean = getITRInitData(request).getSiteContentBaseBeanForReseller(request).getBean(baseRelPathToMemberFiles);

		if(memberDriveHippoBean instanceof HippoFolderBean){
			HippoFolderBean memberDriveHippoFolderBean = (HippoFolderBean) memberDriveHippoBean;
			List<HippoFolderBean> folderBeans = memberDriveHippoFolderBean.getFolders();
			request.setAttribute("folderBeans", folderBeans);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);//
		String subDriveName = request.getRequestContext().getResolvedSiteMapItem().getParameter("subDriveName");
		String serviceRequestNumber = getPublicRequestParameter(request, "serviceRequest");
		FormFields formFields = this.getClass().getAnnotation(FormFields.class);		
		FormMap formMap = new FormMap(request, formFields.fieldNames());
		WorkflowPersistenceManager wpm = null;
		Session persistableSession = null; 
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			MemberDriveHandler memberDriveHandler = new MemberDriveHandler(request, formMap);
			Boolean isFileSave = memberDriveHandler.SaveFileInMemberDrive(null, subDriveName, wpm, getITRInitData(request).isLoggedIn());
			if(isFileSave){		
				if(serviceRequestNumber != null) {
					ServiceRequestManager requestManager = new ServiceRequestManager(request, getITRInitData(request).getSiteContentBaseBeanForReseller(request));
					requestManager.UdateTheServiceRequestWithMemberDrive(wpm, subDriveName, serviceRequestNumber);
				}
				if(subDriveName != null && "digitalsignature".equalsIgnoreCase(subDriveName)) {
					if(log.isInfoEnabled()){
						log.info("Lets validate digital signature and save in memberPersonalinformation:::");	
					}
					Object object = getDigitalSignatureHandleService(request, subDriveName, wpm, memberDriveHandler);
					if(object != null) {
						if(object instanceof Boolean){
							if(((Boolean) object).booleanValue()) {
								response.setRenderParameter("digiverified", "true");	
							}
						}
						if(object instanceof ArrayList){
							List<String> errorList = new ArrayList<String>();
							List<String> returnObjectOfList = (List<String>) object;
							for(String key:returnObjectOfList){
								errorList.add(key);
							}
							if(errorList.size() > 0) {
								if(log.isInfoEnabled()){
									log.info("Have error in digital Signature ::");	
								}
								response.setRenderParameter("errorList", errorList.toArray(new String[errorList.size()]));
								return;
							}
						}
					}
				}
				response.setRenderParameter("FileUpload", "Success");
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.warn("Error to get the PersistableSession From JCR Repository!!",e);
		} finally{
			if(persistableSession!=null){
				persistableSession.logout();
			}
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
		if(StringUtils.isNotBlank(fileuuid)) {
			String baseRelPathToMemberFiles = MEMBER_DRIVE_FOLDER_NAME+"/" + getITRInitData(request).getUserNameNormalized() +"/drive";
			List<HippoDocumentBean> listOfAllMemberFiles = getITRInitData(request).loadAllBeansUnderTheFolder(request, baseRelPathToMemberFiles, null, null);
			try {
				persistableSession=getPersistableSession(request);
				persistableSession.save();
				wpm=getWorkflowPersistenceManager(persistableSession);
				//wpm.setWorkflowCallbackHandler(new FullDeleteWorkflowCallbackHandler());
				if(listOfAllMemberFiles != null){
					for(HippoDocumentBean o:listOfAllMemberFiles){
						if(o.getCanonicalUUID().equals(fileuuid)){
							wpm.remove(o);
							wpm.save();
							delete=true;
							break;
						}
					}
				}
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				log.warn("Error to get the PersistableSession From JCR Repository!!"+e);
				return false;
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				log.warn("Error while to Delete the Object from Repo path"+e);
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

	public Object getDigitalSignatureHandleService(HstRequest request,String subDriveName,WorkflowPersistenceManager wpm,MemberDriveHandler memberDriveHandler){	
		boolean digitalSignatureStatus = false;
		MemberDriveDocument digiSigDriveDocument = null;
		String jcrPathToMemberDriveNode = null;
		MemberPersonalInformation information = null;
		String memberDriveHandleUUID = null;
		List<MemberDriveDocument> listOfAllMemberFiles = null;
		List<String> errorList = new ArrayList<String>();
		//String baseRelPathToMemberFiles = memberDriveHandler.getMemberDriveDocPathHandler(null, subDriveName);
		//String baseRelPathToMemberFiles = MEMBER_DRIVE_FOLDER_NAME+"/"+ getITRInitData(request).getUserNameNormalized()+"/drive";
		//HippoBean driveHippoBeanScope = getITRInitData(request).getSiteContentBaseBeanForReseller(request).getBean(baseRelPathToMemberFiles);
		try {
			Object object = wpm.getObject(memberDriveHandler.getMemberDriveDocPathHandler(null, subDriveName));
			if(object != null) {
				if(object instanceof HippoFolder) {
					HippoFolder digiSignHippoFolder = (HippoFolder) object;
					listOfAllMemberFiles = new ArrayList<MemberDriveDocument>();
					listOfAllMemberFiles = digiSignHippoFolder.getDocuments(MemberDriveDocument.class);
				}
			} else {
				if(log.isInfoEnabled()){
					log.info("Don't have any Subdrive with name: "+ subDriveName +" in drive of Member");	
				}
				return digitalSignatureStatus;
			}
			//List<HippoDocumentBean> listOfAllMemberFiles = getITRInitData(request).loadAllBeansUnderTheFolder(request, baseRelPathToMemberFiles, null, null);
			if(log.isInfoEnabled()){
				log.info("Lets validate digital signature and save in memberPersonalinformation:::"+listOfAllMemberFiles);	
			}
			if(listOfAllMemberFiles != null) {
				for(MemberDriveDocument documentBean:listOfAllMemberFiles) {
					if(StringUtils.contains(documentBean.getCanonicalPath(), subDriveName)) {
						digiSigDriveDocument = documentBean;
						memberDriveHandleUUID = digiSigDriveDocument.getCanonicalHandleUUID();
						break;
					}					
				}
				if(digiSigDriveDocument != null) {
					jcrPathToMemberDriveNode = digiSigDriveDocument.getCanonicalHandlePath();
					DigitalSignatureWrapper assessWrapper = getDigitalSignatureService().getDigitalSignatureFromRepository(jcrPathToMemberDriveNode, true);
					if(memberDriveHandleUUID != null) {
						information = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
						if(information != null) {
							if(log.isInfoEnabled()){
								log.info("Have PersonalInformaion Node to update with signature:::");	
							}
							Session persistableSession = getPersistableSession(request);
							String parentBeanNodeName = getItReturnComponentHelper().getParentBeanNodeName(MemberPersonalInformation.class);
							String parentBeanNameSpace = getItReturnComponentHelper().getParentBeanNamespace(MemberPersonalInformation.class);
							FormMap parenBeanFormMap = new FormMap(request, new String[]{"digitalSignatureHandleUUID"});
							parenBeanFormMap.getField("digitalSignatureHandleUUID").addValue(memberDriveHandleUUID);
							String baseAbsolutePathToReturnDocuments = getITRInitData(request).getAbsoluteBasePathToReturnDocuments();
							String parentBeanAbsolutePath = getItReturnComponentHelper().getParentBeanAbsolutePath(baseAbsolutePathToReturnDocuments, parentBeanNodeName);
							MemberPersonalInfoUpdateHandler parentBeanLifeCycleHandler = null;						
							getItReturnComponentHelper().saveSingleDocument(parenBeanFormMap, parentBeanLifeCycleHandler, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, persistableSession, wpm);
							digitalSignatureStatus = true;						    
						}
					}
				}
			}
		} catch (MissingPrivateKeyException e){
			HandleDigitalSignatureExceptiotn(errorList, wpm, digiSigDriveDocument, e);
			return errorList;
		} catch (InvalidDigitalSignatureException e){
			HandleDigitalSignatureExceptiotn(errorList, wpm, digiSigDriveDocument, e);
			return errorList;
		} catch(MissingDigitalCertificateException e) {
			HandleDigitalSignatureExceptiotn(errorList, wpm, digiSigDriveDocument, e);
			return errorList;
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectBeanPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return digitalSignatureStatus;
	}
	protected void HandleDigitalSignatureExceptiotn(List<String> errorList,WorkflowPersistenceManager wpm,MemberDriveDocument driveDocument ,Exception e){
		//Lets update the digital signature in drive of member as we have error in digital signature so we have to remove it and show an error message.
		errorList.add("error.digital.signature");
		try {
			wpm.remove(driveDocument);
			wpm.save();
		} catch (ObjectBeanPersistenceException e1) {
			// TODO Auto-generated catch block
			log.warn("Exception while update drive of Member(Assess)",e);
		}							
		e.printStackTrace();	
	}
}