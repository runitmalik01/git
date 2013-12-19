/*
 * By Dhananjay
 * This code will work when user click on activation link
 * 10/12/2013
 * 
 */



package com.mootly.wcm.reseller;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
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
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.hst.tag.HstCmsEditLinkTag;
import org.hippoecm.hst.util.NodeUtils;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPayment;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.SignupDetail.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.model.PackageForReseller;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.MootlyFormUtils;

public class ResellerPackage extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(ResellerPackage.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		
		List<PackageForReseller> resellerPackage = PackageForReseller.getResellerPackage();
		request.setAttribute("PackageForReseller", resellerPackage);
		

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);

	}

	//Any submission will go here

	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}

	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}

}
