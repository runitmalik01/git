/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 *
 *
 */

package com.mootly.wcm.member;

import java.rmi.RemoteException;
import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.util.NodeUtils;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPayment;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.services.SequenceGenerator;

@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
public class ITReturnCopyOrMove extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ITReturnCopyOrMove.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);	
		boolean isSuccess = false;
		PAGE_ACTION pageAction = getPageAction();
		if (log.isInfoEnabled()) {
			log.info("Page Action is:"+ getPageAction());
		}
		if (pageAction == PAGE_ACTION.COPY_ORIGINAL_TO_REVISED ) {
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			if (memberPersonalInformation == null) return;
			HippoFolder hippoFolder = (HippoFolder) memberPersonalInformation.getParentBean().getParentBean();
			long nextId = getSequenceGenerator().getNextId(SequenceGenerator.SEQUENCE_FOLDER_NAME);
			String newFolderName = "revised_f_" + nextId;
			request.setAttribute("newFolderName", newFolderName);
			String newFolderBasePath =  hippoFolder.getPath();
			String newFolderPath = hippoFolder.getPath() + "/" + newFolderName; 
			Session persistableSession = null;
			WorkflowPersistenceManager wpm;
			//https://groups.google.com/forum/#!topic/hippo-community/3yLedva3w50
			try {
				persistableSession = getPersistableSession(request);
				wpm = getWorkflowPersistenceManager(persistableSession);				
				final String pathToParentBean = wpm.createAndReturn(newFolderBasePath,"hippostd:folder",newFolderName,true);
				if (log.isInfoEnabled()) {
					log.info("New Folder was created and the pathToTheBean now is " + pathToParentBean);
				}
				//HippoFolder theNewFolder = (HippoFolder) wpm.getObject(pathToParentBean);
				HstQuery hstQuery = this.getQueryManager(request).createQuery( memberPersonalInformation.getParentBean() );
				final HstQueryResult result = hstQuery.execute();
				Iterator<HippoBean> itResults = result.getHippoBeans();
				HippoFolderBean folder = (HippoFolderBean) wpm.getObject(pathToParentBean);
				if (log.isInfoEnabled()) {
					log.info("Now will look into all HippoDocuments under the same folder and make a copy of each");
				}
				for (;itResults.hasNext();) {
					HippoBean hippoBean = itResults.next();
					if (hippoBean instanceof HippoDocumentBean) {
						//we cannot copy payment document
						if (hippoBean.getClass().getSimpleName().toLowerCase().equalsIgnoreCase(MemberPayment.class.getSimpleName())) {
							if (log.isInfoEnabled()) {
								log.info("Found payment document. Skipping..");
							}
							continue;
						}
						String pathToNode = NodeUtils.getCanonicalNode(hippoBean.getNode()).getPath();
						Node theNodeW = persistableSession.getNode(pathToNode);
						//HippoDocument theDocument = (HippoDocument) wpm.getObject(hippoBean.getPath());
						//Node theNodeToGetWorkflowOn = persistableSession.getNode(hippoBean.getPath());
						if (log.isInfoEnabled()) {
							log.info("Now will copy the following document " + hippoBean.getClass().getSimpleName().toLowerCase());
						}
						FullReviewedActionsWorkflow fullReviewedActionsWorkflow = (FullReviewedActionsWorkflow) wpm.getWorkflow("default",theNodeW);
						org.hippoecm.repository.api.Document document = new org.hippoecm.repository.api.Document(folder.getNode().getIdentifier());
						fullReviewedActionsWorkflow.copy(document,hippoBean.getClass().getSimpleName().toLowerCase());
						Object theNewObject = wpm.getObject(folder.getPath() + "/" + hippoBean.getClass().getSimpleName().toLowerCase() );
						//fullReviewedActionsWorkflow.publish();						
						wpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {
							@Override
							public void processWorkflow(FullReviewedActionsWorkflow workflow)
									throws Exception {
								// TODO Auto-generated method stub
								workflow.publish();
							}

						});
						wpm.update(theNewObject);
						if (log.isInfoEnabled()) {
							log.info("Successfully copied "+ hippoBean.getPath() + " to " + newFolderPath);
						}
					}
				}						
				response.setRenderParameter("newFolderName", newFolderName);
				isSuccess = true;
				//this means the path is now read lets start copying 
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				log.error("Repository Exception",e);
				isSuccess = false;
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				log.error("ObjectBeanPersistenceException",e);
				isSuccess = false;
			} catch (QueryException e) {
				// TODO Auto-generated catch block
				log.error("Query Exception",e);
				isSuccess = false;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				log.error("Remote Exception",e);
				isSuccess = false;
			} catch (WorkflowException e) {
				// TODO Auto-generated catch block
				log.error("Workflow Exception",e);
				isSuccess = false;
			} catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				log.error("ObjectBean Manager Exception",e);
				isSuccess = false;
			} finally {
				
			}
		}		
		request.setAttribute("isSuccess",isSuccess);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response); //do not give control to 

	}

}
