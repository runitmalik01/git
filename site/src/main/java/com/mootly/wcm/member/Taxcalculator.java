package com.mootly.wcm.member;

import java.util.Map;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.services.ScreenCalculatorService;

public class Taxcalculator extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Taxcalculator.class);
    private static final String ERRORS = "errors";
    
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		String isCalc = getPublicRequestParameter(request,"command");
		if (isCalc != null && isCalc.equals("calc")) {
			//we must render it through a different JSP
			
			FormMap formMap = new FormMap(request,new String[]{"cbassyear","cbasstype","cbasscategory","cbresistatus","txtNetIncome"});
			Map<String,Object> resultSet = ScreenCalculatorService.getScreenCalculations("TaxCalculator.js", request.getParameterMap(""), null);
			if (resultSet != null) {
				request.setAttribute("resultSet", resultSet);
				JSONObject jsonObject  = new JSONObject(resultSet);
				request.setAttribute("jsonObject", jsonObject);
				//response.setContentType("application/json");
				response.setRenderPath("jsp/common/calculation_response.jsp");
			}
		}
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.warn("test page at do action method");
		
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
