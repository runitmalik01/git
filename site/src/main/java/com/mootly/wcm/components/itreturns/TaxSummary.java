package com.mootly.wcm.components.itreturns;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.components.BaseComponent;


public class TaxSummary extends BaseComponent{
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		
		//find all beans annotated with IncomeProvider
		//DeductionProvider
		//TaxCreditProvider
		//
		
	}
}
