package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.GoGreenUtil;

public class TaxEstimation extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(TaxEstimation.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.error("This is Tax Estimation");
		request.setAttribute("pageName", "Forgot Password");
		request.setAttribute("message", "How can you forget your password!!!");
		request.setAttribute("errors", request.getParameterValues("errors"));
		request.setAttribute("tax",request.getParameterValues("tax"));
		
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		String salary=GoGreenUtil.getEscapedParameter(request, "salary");
		String saving=GoGreenUtil.getEscapedParameter(request, "savings");
		
		//do some magic here to retrieve the password and send it via email
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(salary)){
			errors.add("enter.gross.salary");
		}
		if(StringUtils.isEmpty(saving)){
			errors.add("enter.gross.savings");
		}
		response.setRenderParameter("errors",errors.toArray(new String[errors.size()]));
		if (errors == null || errors.size() == 0) {
			float a=Float.parseFloat(salary);
			float b=Float.parseFloat(saving);
			float c=180000;
			float e=(float)0.3;
			float estimation_tax=((a-b)-c)*e;
			String tax=Float.toString(estimation_tax);
			response.setRenderParameter("tax", tax);
			
		}
	}
		
	
	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}
	
}
