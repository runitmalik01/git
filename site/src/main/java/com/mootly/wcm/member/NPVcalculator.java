package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.components.BaseComponent;

public class NPVcalculator extends BaseComponent {
	public final String FIELD_INITIAL_INVESTMENT = "initial_invest";
	public final String FIELD_DISCOUNT_RATE = "rate";
	private static final Logger log = LoggerFactory.getLogger(NPVcalculator.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-geneFIELD_DISCOUNT_RATEd method stub
		super.doBeforeRender(request, response);
		if (request.getParameter(FIELD_INITIAL_INVESTMENT) != null ) {
			request.setAttribute(FIELD_INITIAL_INVESTMENT, request.getParameter(FIELD_INITIAL_INVESTMENT));
		}
		if (request.getParameter(FIELD_DISCOUNT_RATE) != null ) {
			request.setAttribute(FIELD_DISCOUNT_RATE, request.getParameter(FIELD_DISCOUNT_RATE));
		}
		if (request.getParameter("isValid") != null ) {
			request.setAttribute("isValid", request.getParameter("isValid"));
		}
		if (request.getParameter("no_of_year") != null ) {
			request.setAttribute("no_of_year", request.getParameter("no_of_year"));
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-geneFIELD_DISCOUNT_RATEd method stub
		super.doAction(request, response);
		String initialInvestment = request.getParameter(FIELD_INITIAL_INVESTMENT);
		String discountFIELD_DISCOUNT_RATE = request.getParameter(FIELD_DISCOUNT_RATE);
		boolean isValid = true;
		response.setRenderParameter(FIELD_INITIAL_INVESTMENT,initialInvestment);
		response.setRenderParameter(FIELD_DISCOUNT_RATE,discountFIELD_DISCOUNT_RATE);
		if (!DataTypeValidationHelper.isOfType(initialInvestment, DataTypeValidationType.DECIMAL)) {
			isValid = false;
			response.setRenderParameter("errorMsg", "Invalid Initial Investment");
		}
		
		if (isValid) {			
			if (!DataTypeValidationHelper.isOfType(discountFIELD_DISCOUNT_RATE, DataTypeValidationType.PERCENTAGE)) {
				response.setRenderParameter("errorMsg", "Invalid Discount FIELD_DISCOUNT_RATE");
				isValid = false;
			}
		}
		response.setRenderParameter("no_of_year", request.getParameter("no_of_year"));
		response.setRenderParameter("isValid", String.valueOf(isValid));
	}
}

