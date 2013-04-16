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




public class NPVcalculator extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(NPVcalculator.class);
    private static final String AMOUNTRECEIVED = "amount_received_per_year";
    private static final String YEAR = "no_of_year";
    private static final String RATE = "present_rate_of_return";
    private static final String NPVCALCULATION= "npv_calculation";
    private static final String ERRORS = "errors";
	
    
    
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
	log.warn("This is NPV Calculation page");
	request.setAttribute(AMOUNTRECEIVED, request.getParameterValues(AMOUNTRECEIVED));
	request.setAttribute(YEAR, request.getParameterValues(YEAR));
	request.setAttribute(RATE, request.getParameterValues(RATE));
	request.setAttribute(NPVCALCULATION, request.getParameterValues(NPVCALCULATION));
	request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.warn("test page at do action method");
		String amount_recevied_per_year= GoGreenUtil.getEscapedParameter(request, "amount_recevied_per_year");
		String no_of_year = GoGreenUtil.getEscapedParameter(request, "no_of_year");
		String present_rate_of_return = GoGreenUtil.getEscapedParameter(request, "present_rate_of_return");
		String npv_calculation = GoGreenUtil.getEscapedParameter(request, "npv_calculation");
		List<String> errors = new ArrayList<String>();
		if((amount_recevied_per_year).isEmpty()){
		    errors.add("amount_received_per_year-label");
		   }
			
		System.out.print("size"+errors.size());
		 if (errors.size()!=0){
			    response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			    response.setRenderParameter(AMOUNTRECEIVED, errors.toArray(new String[errors.size()]));
			    response.setRenderParameter(YEAR, errors.toArray(new String[errors.size()]));
			    response.setRenderParameter(RATE, errors.toArray(new String[errors.size()]));
			    response.setRenderParameter(NPVCALCULATION, errors.toArray(new String[errors.size()]));
			    log.warn("if loop");
			return;
		}else
		{
				try {
					
					response.sendRedirect("/site/npvcalculator");
				   } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
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
