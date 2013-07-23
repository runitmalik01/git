package com.mootly.wcm.components.vendor;

import org.hippoecm.hst.core.parameters.Parameter;

public interface ITReturnHomePageParamInfo {

    @Parameter(name = "reviewsFolder", required = false, defaultValue = "reviews", displayName = "Reviews folder")
    String getReviewsFolder();

    @Parameter(name = "members", required = false, defaultValue = "members", displayName = "Members folder")
    String getMemberFolder();
}
