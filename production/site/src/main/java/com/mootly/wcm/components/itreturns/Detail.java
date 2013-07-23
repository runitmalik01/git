/**
 * Copyright (C) 2011 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.components.itreturns;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;

@ParametersInfo(type = ProductDetailParamInfo.class)
public class Detail extends BaseComponent {

    private static final Logger log = LoggerFactory.getLogger(Detail.class);

    private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss.SSS";
    private static final String NAME = "name";
    private static final String COMMENT = "comment";
    private static final String EMAIL = "email";
    private static final String SUCCESS = "success";
    private static final String ERRORS = "errors";

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {

       super.doBeforeRender(request, response);
       request.setAttribute("cmd", "showAvailableYears");
    }

    @Override
    public void doBeforeServeResource(HstRequest request, HstResponse response) throws HstComponentException {
        super.doBeforeServeResource(request, response);
    }

    private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
        public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
            wf.requestPublication();
        }
    }
}
