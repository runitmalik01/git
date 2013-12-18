/*
 * By Dhananjay
 * This code will work when user click on activation link
 * 10/12/2013
 * 
 */



package com.mootly.wcm.reseller;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.UUID;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.configuration.hosting.Mount;
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
import org.hippoecm.hst.tag.HstCmsEditLinkTag;
import org.hippoecm.hst.util.NodeUtils;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPayment;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.SignupDetail.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.SecureHashGeneration;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;

public class ResellerActivation extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ResellerActivation.class);

	private static final String EMAILCUSTOMERSERVICE = "emailCustomerService";
	private static final String EMAILFROM = "emailFrom";
	private static final String EMAILFROMNAME = "emailFromName";
	private static final String EMAILSIGNATURE = "emailSignature";
	private static final String ERIENABLE26ASIMPORT = "eriEnable26ASImport";
	private static final String ERIENABLED = "eriEnabled";
	private static final String ERIPASSWORD = "eriPassword";
	private static final String ERIUSERID = "eriUserId";
	private static final String ISRESELLER = "isReseller";
	private static final String PAGETITLEPREFIX = "pageTitlePrefix";
	private static final String PAYMENTAVAILABLETYPES = "paymentAvailableTypes";
	private static final String PAYMENTENABLED = "paymentEnabled";
	private static final String RESELLERNAME = "resellerName";

	public static final String SUCCESS= "success";

	private String Isactive;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		String success=request.getParameter(SUCCESS);
		if (success != null) {
			request.setAttribute(SUCCESS, success);
			return;
		}

		String activationCode = request.getRequestContext().getResolvedSiteMapItem().getParameter("activationCode");
		if (activationCode == null || activationCode.trim().equals("")) {
			request.setAttribute("isError", "true");
			request.setAttribute("errorCode", "error.activationcode.missing");
			return;
		}
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			ResellerSignupDocument resellerSignupDocument = (ResellerSignupDocument) wpm.getObjectByUuid(activationCode);
			if (resellerSignupDocument == null) {
				request.setAttribute("isError", "true");
				request.setAttribute("errorCode", "error.usernotfound");
			}else if (resellerSignupDocument != null && resellerSignupDocument.getIsActive()) {
				log.warn("User has already activated");
				request.setAttribute("isError", "true");
				request.setAttribute("errorCode", "error.alreadyactivated");
				request.setAttribute("userName", resellerSignupDocument.getEmail());
				return;
			}
		}catch (ObjectBeanManagerException e1) {
			// TODO Auto-generated catch block
			request.setAttribute("isError", "true");
			log.error("Activation Error",e1);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Activation Error",e);
		}
		finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);

		String emailCustomerService = GoGreenUtil.getEscapedParameter(request, EMAILCUSTOMERSERVICE);
		String emailFrom = GoGreenUtil.getEscapedParameter(request, EMAILFROM);
		String emailFromName = GoGreenUtil.getEscapedParameter(request, EMAILFROMNAME);
		String emailSignature = GoGreenUtil.getEscapedParameter(request, EMAILSIGNATURE);
		String eriEnable26ASImport = GoGreenUtil.getEscapedParameter(request, ERIENABLE26ASIMPORT);
		String eriEnabled = GoGreenUtil.getEscapedParameter(request, ERIENABLED);
		String eriPassword = GoGreenUtil.getEscapedParameter(request, ERIPASSWORD);
		String eriUserId = GoGreenUtil.getEscapedParameter(request, ERIUSERID);
		String isReseller = GoGreenUtil.getEscapedParameter(request, ISRESELLER);
		String pageTitlePrefix = GoGreenUtil.getEscapedParameter(request, PAGETITLEPREFIX);
		String[] paymentAvailableTypes = GoGreenUtil.getEscapedParameterValues(request, PAYMENTAVAILABLETYPES);
		String paymentEnabled = GoGreenUtil.getEscapedParameter(request, PAYMENTENABLED);
		String resellerName = GoGreenUtil.getEscapedParameter(request, RESELLERNAME);

		String startDate = ITRXmlGeneratorServiceCommon.getCurrentDateInIndiaAsString();
		String endDate = ITRXmlGeneratorServiceCommon.getEndDateForResellerTrailPeriod();

		String activationCode = request.getRequestContext().getResolvedSiteMapItem().getParameter("activationCode");

		String userName = null;
		//now get the membershipdocument right away with the uuid
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			ResellerSignupDocument resellerSignupDocument = (ResellerSignupDocument) wpm.getObjectByUuid(activationCode);
			//to copy services in reseller folder
			HippoBean pathToCommonBeans =  getSiteContentBaseBean(request).getBean("common");
			HippoBean pathToServiceBeans = pathToCommonBeans.getBean("services");
			if(pathToServiceBeans != null){
				HippoFolder hippoFolder = (HippoFolder) resellerSignupDocument.getParentBean().getParentBean();
				String newFolderName = "services";
				String newFolderBasePath = hippoFolder.getPath();
				String newFolderPath = hippoFolder.getPath()+"/"+newFolderName;

				final String pathToParentBean = wpm.createAndReturn(newFolderBasePath,"hippostd:folder",newFolderName,true);
				if (log.isInfoEnabled()) {
					log.info("New Folder was created and the pathToTheBean now is " + pathToParentBean);
				}
				HstQuery hstQuery = this.getQueryManager(request).createQuery(pathToServiceBeans);
				final HstQueryResult result = hstQuery.execute();
				Iterator<HippoBean> itResults = result.getHippoBeans();
				HippoFolderBean folder = (HippoFolderBean) wpm.getObject(pathToParentBean);
				if (log.isInfoEnabled()) {
					log.info("Now will look into all HippoDocuments under the same folder and make a copy of each");
				}
				for (;itResults.hasNext();) {
					HippoBean hippoBean = itResults.next();

					if (hippoBean instanceof HippoDocumentBean) {
						if(hippoBean.getParentBean().getName().equals(newFolderName)){
							folder = (HippoFolderBean) wpm.getObject(pathToParentBean);
						}else{
							String absoluteBeanPath = StringUtils.substringAfter(hippoBean.getCanonicalPath(), newFolderName);
							String modAbsoluteBeanPath = StringUtils.substringBeforeLast(absoluteBeanPath, "/");
							String finalAbsoluteBeanPath = StringUtils.substringBeforeLast(modAbsoluteBeanPath, "/");

							HippoFolderBean resellerFolder = (HippoFolderBean) wpm.getObject(pathToParentBean);
							String resellerFolderPath = resellerFolder.getCanonicalPath();
							String defaultFolderName = "";

							String[] newFolderNames = finalAbsoluteBeanPath.split("/");
							if(newFolderNames.length >0){
								String mypathToParentBean = pathToParentBean;
								for(String folderName:newFolderNames){			
									if(StringUtils.isNotBlank(folderName)){
										resellerFolderPath = resellerFolderPath+"/"+folderName;
										//String modresellerFolderPath = StringUtils.substringAfter(resellerFolderPath, newFolderName);
										folder = (HippoFolderBean) wpm.getObject(resellerFolderPath);
										defaultFolderName = folderName;					
									}
								}
								if(folder == null){
									String modpathToParentBean = wpm.createAndReturn(StringUtils.substringBeforeLast(resellerFolderPath, "/"),"hippostd:folder",defaultFolderName,true);
									folder = (HippoFolderBean) wpm.getObject(modpathToParentBean);
								}
							}
						}
						String pathToNode = NodeUtils.getCanonicalNode(hippoBean.getNode()).getPath();
						Node theNodeW = persistableSession.getNode(pathToNode);

						FullReviewedActionsWorkflow fullReviewedActionsWorkflow = (FullReviewedActionsWorkflow) wpm.getWorkflow("default",theNodeW);					
						org.hippoecm.repository.api.Document document = new org.hippoecm.repository.api.Document();
						document.setIdentity(folder.getNode().getUUID());
						fullReviewedActionsWorkflow.copy(document,hippoBean.getNode().getName());
						Object theNewObject = wpm.getObject(folder.getPath() + "/" + hippoBean.getNode().getName());
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
			}

			HippoFolder hippoFolder = (HippoFolder) resellerSignupDocument.getParentBean().getParentBean();
			String finalMembershipDocumentPath = null;
			String cPath = hippoFolder.getPath();
			final String memberFolderPath = cPath + "/" + ContentStructure.MEMBER_FOLDER_NAME + "/" + getNormalizedUserName(request, resellerSignupDocument.getUserName());//ContentStructure.getMemberFolder(request,signupDocument.getUserName());
			finalMembershipDocumentPath = wpm.createAndReturn(memberFolderPath, MemberSignupDocument.NAMESPACE ,  MemberSignupDocument.NODE_NAME, true);
			MemberSignupDocument membershipSignupDocument = (MemberSignupDocument) wpm.getObject(finalMembershipDocumentPath);
			// update content properties
			if (membershipSignupDocument != null) {
				membershipSignupDocument.setUserName(resellerSignupDocument.getUserName());
				membershipSignupDocument.setPassword(SecureHashGeneration.passSHAdigest(resellerSignupDocument.getPassword()));
				membershipSignupDocument.setEmail(resellerSignupDocument.getEmail());
				membershipSignupDocument.setRoles(new String[]{"VENDOR"});
				membershipSignupDocument.setActivationCode(UUID.randomUUID().toString());
				membershipSignupDocument.setIsActive(true);
				// update now           `
				wpm.update(membershipSignupDocument);
			}

			if(resellerSignupDocument != null && !(resellerSignupDocument.getIsActive())){
				resellerSignupDocument.setIsActive(true);
				resellerSignupDocument.setEmailCustomerService(emailCustomerService);
				resellerSignupDocument.setEmailFrom(emailFrom);
				resellerSignupDocument.setEmailFromName(emailFromName);
				resellerSignupDocument.setEmailSignature(emailSignature);
				resellerSignupDocument.setEriEnable26ASImport(Boolean.valueOf(eriEnable26ASImport));
				resellerSignupDocument.setEriEnabled(Boolean.valueOf(eriEnabled));
				resellerSignupDocument.setEriPassword(eriPassword);
				resellerSignupDocument.setEriUserId(eriUserId);
				resellerSignupDocument.setIsReseller(Boolean.valueOf(isReseller));
				resellerSignupDocument.setPageTitlePrefix(pageTitlePrefix);
				resellerSignupDocument.setPaymentAvailableTypes(paymentAvailableTypes);
				resellerSignupDocument.setPaymentEnabled(Boolean.valueOf(paymentEnabled));
				resellerSignupDocument.setResellerName(resellerName);
				resellerSignupDocument.setStartDate(startDate);
				resellerSignupDocument.setEndDate(endDate);

				request.setAttribute("userName", resellerSignupDocument.getResellerID());
				if(!(resellerSignupDocument.getResellerID().isEmpty())){
					request.setAttribute("userName", resellerSignupDocument.getResellerID());
					userName = resellerSignupDocument.getResellerID();
				}else
					userName = "User name not found";
			}

			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			wpm.update(resellerSignupDocument);

		} catch (ObjectBeanManagerException e1) {
			// TODO Auto-generated catch block
			request.setAttribute("isError", "true");
			log.error("Activation Error",e1);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Activation Error",e);
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			log.error("Query Exception",e);

		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			log.error("Remote Exception",e);

		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			log.error("Workflow Exception",e);

		} 
		finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
		response.setRenderParameter(SUCCESS, userName);
	}

	//Any submission will go here

	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}

	public String getIsactive() {
		return Isactive;
	}

	public void setIsactive(String isactive) {
		Isactive = isactive;
	}

}
