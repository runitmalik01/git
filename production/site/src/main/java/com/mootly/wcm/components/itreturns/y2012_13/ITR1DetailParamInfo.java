package com.mootly.wcm.components.itreturns.y2012_13;

import org.hippoecm.hst.core.parameters.Parameter;

public interface ITR1DetailParamInfo {

    @Parameter(name = "page", required = false, defaultValue = "1", displayName = "Form Name")
    String getPage();
}
