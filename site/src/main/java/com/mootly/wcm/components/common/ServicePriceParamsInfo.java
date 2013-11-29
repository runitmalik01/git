package com.mootly.wcm.components.common;

import org.hippoecm.hst.core.parameters.Parameter;

public interface ServicePriceParamsInfo {
	
	String PRICING_PARAM = "pricingLocation";
	String DOC_TYPE = "mootlywcm:PricingPlan";
	String DEFAULT_VALUE = "mootlypricingplan";
	String EX_PRICING_Name = "excludePricingName";

    @Parameter(name = PRICING_PARAM, defaultValue = DEFAULT_VALUE, required = false, displayName = "Pricing Location")
    String getPricingPlanLocation();
    
    @Parameter(name = EX_PRICING_Name , defaultValue = "" , required = false , displayName = "Exclude Pricng Name",description = "Name the Document as")
    String getExcludePricings();

}
