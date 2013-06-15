/*
 * In this class we are creating a document for storing value of Deduction details of user
 * according to form 16.
 * @author 
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.beans.MemberDriveDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.GoGreenUtil;

@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class})
@DataTypeValidationFields(fieldNames={"investment"},dataTypes={DataTypeValidationType.DECIMAL})
public class MemberDrive extends BaseComponent {

	private static final Logger log = LoggerFactory.getLogger(MemberDrive.class);
	private static final String MEMBER_DRIVE_FOLDER_NAME="MemberDrive";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("This is member Drive page");
		}
		/*String strcmd=getPublicRequestParameter(request, "command");
		String reqFormJson=getPublicRequestParameter(request, "data");
		if(strcmd!=null&&strcmd.equals("upload")&&reqFormJson!=null){
			try {
				JSONObject formJson=new JSONObject(reqFormJson);
				String memberfile=formJson.getString("member_file").toString();
				File upldFile=new File(memberfile);
				MemberDriveDocument memberDrive=new MemberDriveDocument();
				memberDrive.setMemberFileResource(upldFile);
				MemberDriveDocument returnMemberDriveDoc=createMemberDrive(request, response, memberDrive);
				if(returnMemberDriveDoc!=null){
					response.setHeader("myfileheader", upldFile.getName());
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		/*List<String> fileNames=new ArrayList<String>();
		try {
			Node node=(Node) getObjectBeanManager(request).getObject(getMemberDriveDocPath(request).toLowerCase());
			NodeIterator itrnode=node.getNodes();
			while(itrnode.hasNext()){
				fileNames.add(itrnode.nextNode().getName());
				itrnode.remove();
			}
			if(fileNames.size()!=0){
				request.setAttribute("fileNames", "fileNames");
			}
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		String memberfile=GoGreenUtil.getEscapedParameter(request, "member_file");
		File upldFile=new File(memberfile);
		MemberDriveDocument memberDrive=new MemberDriveDocument();
		memberDrive.setMemberFile(upldFile);
		MemberDriveDocument returnMemberDriveDoc=createMemberDrive(request, response, memberDrive);
		if(returnMemberDriveDoc!=null){
			response.setRenderParameter("myfilename", upldFile.getName());
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
	public MemberDriveDocument createMemberDrive(HstRequest request,HstResponse response,MemberDriveDocument memberDrive){
		WorkflowPersistenceManager wpm=null;
		Session persistableSession=null;
		String memberDriveDocPath=null; 
		try{
			persistableSession=getPersistableSession(request,new SimpleCredentials("admin", "admin".toCharArray()));
			wpm=getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String primaryPath=getMemberDriveDocPath(request);
			memberDriveDocPath=wpm.createAndReturn(primaryPath, MemberDriveDocument.NAMESPACE, memberDrive.getMemberFile().getName(), true);
			MemberDriveDocument memberDriveDoc=(MemberDriveDocument) wpm.getObject(memberDriveDocPath);
			if(memberDriveDoc!=null){
				memberDriveDoc.setMemberFile(memberDrive.getMemberFile());
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
		builder.append(MEMBER_DRIVE_FOLDER_NAME).append("/").append(request.getUserPrincipal().getName()).append("/").append("Documents");
		return builder.toString();
	}
	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}