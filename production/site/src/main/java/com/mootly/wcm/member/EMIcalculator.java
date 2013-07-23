package com.mootly.wcm.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.GoGreenUtil;




public class EMIcalculator extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(EMIcalculator.class);
    private static final String SUCCESS = "success";
    private static final String ERRORS = "errors";
    
    
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
	log.warn("This is EMI Calculation page");
	request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.warn("test page at do action method");
		String loan_amount = GoGreenUtil.getEscapedParameter(request, "loan_amount");
		System.out.println ("loan_error");
		String interest_rate = GoGreenUtil.getEscapedParameter(request, "interest_rate");
		String loan_tenure = GoGreenUtil.getEscapedParameter(request, "loan_tenure");
		List<String> errors = new ArrayList<String>();
		if(loan_amount.isEmpty() && interest_rate.isEmpty() && loan_tenure .isEmpty()){
			log.warn ("if loop");
			errors.add("invalid.data");
		}
		
		if (errors.size()!=0){
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			log.warn("i am at source of income page.");
			return;
		}else
		{
				try {
					
					response.sendRedirect("http://mootlybuilds.zapto.org:8080/site/emicalculator");
				   } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		/*if (errors == null || errors.size() == 0)
		{
			float d = Float.parseFloat(emi_calculation);
			System.out.println ("emi");
			float a=Float.parseFloat(loan_amount);
			System.out.println ("loan");
			float b=Float.parseFloat(interest_rate);
			float c=Float.parseFloat(loan_tenure);
			 d =  (float) ((a*b)*((Math.pow((1+b),c))/((Math.pow((1+b),c)-1))));
			response.setRenderParameter("emi_calculation", emi_calculation);
			
		} */
	}
	
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
