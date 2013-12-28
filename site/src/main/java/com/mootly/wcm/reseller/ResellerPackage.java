/*
 * By Dhananjay
 * This code will work when user click on activation link
 * 10/12/2013
 * 
 */



package com.mootly.wcm.reseller;
import java.util.List;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.model.PackageForReseller;

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
