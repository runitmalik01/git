/**
 * 
 */
package com.mootly.wcm.member;

import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberDriveDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.utils.GoGreenUtil;

/**
 * @author admin
 *
 */
//@PrimaryBean(primaryBeanClass=MemberDriveDocument.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"accesspermission"})
public class DrivePermissionUpdate extends ITReturnComponent{

	public static final Logger log = LoggerFactory.getLogger(DrivePermissionUpdate.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		MemberDriveDocument  memberDriveDocument = (MemberDriveDocument)request.getRequestContext().getAttribute("memberDriveDocument");
		request.setAttribute("memberDriveDocument", memberDriveDocument);
		request.setAttribute("updatepermission", request.getParameter("updatepermission"));
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(getITRInitData(request).isVendor(request)){
			FormMap parentBeanMap = getFormMap(request, new String[]{"accesspermission"});
			String memberDriveCanonicalUUID = GoGreenUtil.getEscapedParameter(request, "memberDriveCanonicalUUID");
			if(StringUtils.isNotBlank(memberDriveCanonicalUUID)){
				try{
					Session persistableSession = getPersistableSession(request);
					WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					MemberDriveDocument driveDocument = (MemberDriveDocument) wpm.getObjectByUuid(memberDriveCanonicalUUID);
					if(driveDocument != null){
						if(log.isInfoEnabled()){
							log.info("Lets update the Action Permission for Member in Drive Document::");
						}
						String updateMessage = "Access permission of " + driveDocument.getName() + " updated.";
						String parentBeanNodeName = driveDocument.getName();
						String parentBeanNameSpace = getItReturnComponentHelper().getParentBeanNamespace(MemberDriveDocument.class);
						String parentBeanAbsolutePath = driveDocument.getCanonicalPath();
						//Can not create the new drive document if not found so send it as null
						String baseAbsolutePathToReturnDocuments = "";
						DrivePermissionUpdateLifeCycleHandle parentBeanLifeCycleHandler = null;
						getItReturnComponentHelper().saveSingleDocument(parentBeanMap, parentBeanLifeCycleHandler, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, persistableSession, wpm);
						response.setRenderParameter("updatepermission", updateMessage);
					}
				} catch(RepositoryException e){
					log.warn("Error while Updating the Permission on MemberDriveDocument ",e);
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.warn("Error while Updating the Permission on MemberDriveDocument ",e);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					log.warn("Error while Updating the Permission on MemberDriveDocument ",e);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					log.warn("Error while Updating the Permission on MemberDriveDocument ",e);
				}
			}
		}
	}

	public class DrivePermissionUpdateLifeCycleHandle implements BeanLifecycle<HippoBean>{

		@Override
		public void beforeCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}
		@Override
		public void afterCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean beforeSaveNewBean(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterSaveNewBean(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beforeFillParentBeanMap(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beforeFillChildBeanMap(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterFillParentBeanMap(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterFillChildBeanMap(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean validateChildBean(HippoBean hippoBean, boolean isNew,
				List<String> errors, List<String> warnings) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean validateParentBean(HippoBean hippoBean, boolean isNew,
				List<String> errors, List<String> warnings) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean beforeUpdate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterUpdate(HippoBean beanBeforeUpdate,
				HippoBean beanAfterUpdate, WorkflowPersistenceManager wpm,
				String baseAbsolutePathToReturnDocuments,
				ITReturnComponentHelper itReturnComponentHelper) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterUpdateChild(HippoBean parentBeanBeforeUpdate,
				HippoBean parentBeanAfterUpdate,
				HippoBean childBeanBeforeUpdate,
				HippoBean childBeanAfterUpdate, WorkflowPersistenceManager wpm,
				ITReturnComponentHelper itReturnComponentHelper) {
			// TODO Auto-generated method stub

		}	

	}
}
