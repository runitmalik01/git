package com.mootly.wcm.utils;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;

import com.mootly.wcm.beans.EmailMessage;

public final class EmailMessageService {
	
	public static void submitEmailMessageRequest(HstRequest request, EmailMessage emailMessage,String path) {
		
	}
	
	@SuppressWarnings("unused")
	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}
