package com.mootly.wcm.components.itreturns;

import org.hippoecm.hst.core.parameters.Parameter;

public interface ConsolidatedViewSideBarParamInfo {

    @Parameter(name = "reviewsFolder", required = false, defaultValue = "reviews", displayName = "Reviews folder")
    String getReviewsFolder();
}
