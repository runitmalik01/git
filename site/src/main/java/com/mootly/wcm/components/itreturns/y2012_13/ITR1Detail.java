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

package com.mootly.wcm.components.itreturns.y2012_13;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.json.JSONException;
import org.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ITR1;
import com.mootly.wcm.beans.compound.PersonalInformation;
import com.mootly.wcm.beans.compound.TdsSalary;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.GoGreenUtil;

@ParametersInfo(type=ITR1DetailParamInfo.class)
public class ITR1Detail extends BaseComponent {

	private static final Logger log = LoggerFactory.getLogger(ITR1Detail.class);

	private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss.SSS";
	private static final String NAME = "name";
	private static final String COMMENT = "comment";
	private static final String EMAIL = "email";
	private static final String SUCCESS = "success";
	private static final String ERRORS = "errors";

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		log.warn("doBeforeRender is called");
		super.doBeforeRender(request, response);
		ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
		String formName = resolvedSiteMapItem.getParameter("formName");
		if (formName == null) formName = "itr1_original";
		String filingYear = resolvedSiteMapItem.getParameter("filing_year");
		request.setAttribute("filing_year", filingYear);
		request.setAttribute("formName", formName);
		
		//now get parameters from the request
		String currentPageParam = getPublicRequestParameter(request, Constants.PAGE);
		if (currentPageParam == null) {
			currentPageParam = "1";
		}
		request.setAttribute(Constants.PAGE, currentPageParam);
		
		log.warn("FORM NAME IS :" + formName);
		log.info("Into do before Serve Resource FORM NAME:" + formName );
		log.info("Lets make sure an empty form exists for this user");
		log.error("resolvedSiteMapItem.getRelativeContentPath():" + resolvedSiteMapItem.getRelativeContentPath());
		log.error("resolvedSiteMapItem.getRelativeContentPath():" + resolvedSiteMapItem.getHstSiteMapItem().getRelativeContentPath());
		//Fetch the ITR1 filled by this user
		ITR1 itr1 = (ITR1) getContentBean(request);
		
		if (itr1 == null) {
			request.setAttribute(Constants.PAGE, "0");
			//form doesn't exist so create one for this user 
			return;
		}			
		
		StringWriter sw = new StringWriter();
		try {
		JSONWriter jsonWriter = new JSONWriter(sw);
		jsonWriter.object().key("tdsSalaries").array();
		for (TdsSalary tdsSalary : itr1.getTdsSalaryList()) {
			jsonWriter.object().key("empTan").value(tdsSalary.getEmployerTan()).key("empName").value(tdsSalary.getEmployerName()).key("empSalaries").value(tdsSalary.getEmployerSalaries()).key("totalTaxDeducted").value(tdsSalary.getTotalTaxDeducted()).endObject();
		}
		jsonWriter.endArray();
		jsonWriter.endObject();
		request.setAttribute("tdsSalariesJSON", sw.toString());
		}catch (JSONException jse) {
			log.error("JSON Error in creating JSON Response for TDS Salary",jse);
		}
		request.setAttribute("itr1", itr1);
	}
 
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		log.warn("doAction is called");
		ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
		String formName = resolvedSiteMapItem.getParameter("formName");
		if (formName == null) formName = "itr1_original";
		ITR1 itr1 = (ITR1) getContentBean(request);
		if (itr1 == null) {
			itr1 = createEmptyITRForm(request, formName);
		}
		else {
			updateReturnForm(request,response);
		}
	}
	
	private ITR1 createEmptyITRForm(HstRequest request,String formName) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//ADVANCED
			//wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());

			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());

			//final String reviewFolderPath = createReviewFolderPath(request, product);
			//final String reviewNodeName = createReviewNodeName();

			final String itReturnFolderPath = createITReturnsPath(request);
			final String itReturnNodeName = formName;

			final String itReturnPath = wpm.createAndReturn(itReturnFolderPath, Constants.NT_ITR_1, itReturnNodeName, true);

			ITR1 itr1 = (ITR1) wpm.getObject(itReturnPath);
			// update content properties
			if (itr1 != null) {
				itr1.setTitle("This is a FORM");
				itr1.setDescriptionContent("ASDASDSAD");
				PersonalInformation pi = new PersonalInformation();
				pi.setFirstName("Amit");
				pi.setLastName("Patkar");
				pi.setMiddleName("Amit");
				pi.setPAN("2030123");
				pi.setFlatDoorBuilding("test");
				pi.setFilingStatus("test");
				pi.setRoadStreet("test");
				pi.setAreaLocality("test");
				pi.setDOB(GregorianCalendar.getInstance());
				pi.setTownCityDistrict("New Delhi");
				pi.setState("Delhi");
				pi.setPinCode("110010");
				pi.setSex("M");
				pi.setEmail("amit@mail.mootly.com");
				pi.setMobile("9198000078");
				pi.setStdCode("0751");
				pi.setPhone("00900000");
				pi.setEmployerCategory("I");
				itr1.setPersonalInformation(pi);
				
				List<TdsSalary> tdsSalaryList = new ArrayList<TdsSalary>();
				TdsSalary tdsSalary1 = new TdsSalary();
				tdsSalary1.setEmployerName("Mootly");
				tdsSalary1.setEmployerSalaries(1000D);
				tdsSalary1.setEmployerTan("1000");
				tdsSalary1.setTotalTaxDeducted(100D);
				
				TdsSalary tdsSalary2 = new TdsSalary();
				tdsSalary2.setEmployerName("IBM");
				tdsSalary2.setEmployerSalaries(2D);
				tdsSalary2.setEmployerTan("2000");
				tdsSalary2.setTotalTaxDeducted(200D);
				
				TdsSalary tdsSalary3 = new TdsSalary();
				tdsSalary3.setEmployerName("Apple");
				tdsSalary3.setEmployerSalaries(3D);
				tdsSalary3.setEmployerTan("3000");
				tdsSalary3.setTotalTaxDeducted(300D);
				
				tdsSalaryList.add(tdsSalary1);
				tdsSalaryList.add(tdsSalary2);
				tdsSalaryList.add(tdsSalary3);
				
				itr1.setTdsSalaryList(tdsSalaryList);
				
				// update now           `
				wpm.update(itr1);
				return itr1;
			} else {
				log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", itReturnNodeName, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return itr1;
			}
		} catch (Exception e) {
			log.warn("Failed to create a review for product '" + "----- IT RETURN ------" + "'", e);
			return null;
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}
	
	private String createITReturnsPath(HstRequest request) {
		StringBuilder builder = new StringBuilder();

		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append("itreturns/20122013");
		builder.append('/').append("itr1").append('/');
		builder.append(request.getUserPrincipal().getName());

		return builder.toString();
	}

	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response) throws HstComponentException {
		super.doBeforeServeResource(request, response);
		log.warn("doBeforeServeResource is called");
		//now get parameters from the request
	}

	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
	
	public void updateReturnForm(HstRequest request, HstResponse response) throws HstComponentException {
        boolean succeeded = true;
        String errorMessage = "";
        
        String firstName = request.getParameter("pi_first_name");
        log.error("FIRST NAME:" + firstName);
        String workflowAction = request.getParameter("workflowAction");

        String field = request.getParameter("field");

        final boolean requestPublication = true; //"requestPublication".equals(workflowAction);
        final boolean saveDocument = true;// ("save".equals(workflowAction) || requestPublication);

        if (saveDocument || requestPublication) {
            String documentPath = getContentBean(request).getPath();
            Session persistableSession = null;
            WorkflowPersistenceManager cpm = null;

            try {
                //NOTE: Don't need to use writable session here; use subject based session instead.
                persistableSession = getPersistableSession(request);
                //persistableSession = request.getRequestContext().getSession();
                
                cpm = getWorkflowPersistenceManager(persistableSession);
                cpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {
                    public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
                        if (requestPublication) {
                            FullReviewedActionsWorkflow fraw = (FullReviewedActionsWorkflow) wf;
                            fraw.publish(new GregorianCalendar().getTime());
                        }
                    }
                });

                ITR1 document = (ITR1) cpm.getObject(documentPath);

                if (saveDocument) {
                    document.getPersonalInformation().setFirstName(firstName);
                }
                // update now
                cpm.update(document);
                cpm.save();
                ITR1 itr1 = (ITR1) getContentBean(request);
                request.setAttribute("itr1",itr1);
            } catch (Exception e) {
                log.warn("Failed to create a comment: ", e);

                if (cpm != null) {
                    try {
                        cpm.refresh();
                    } catch (ObjectBeanPersistenceException e1) {
                        log.warn("Failed to refresh: ", e);
                    }
                }
            }
            // NOTE: no need to close the persistable session here because subject based session was retrieved from rc.
        }
        request.setAttribute("payload", "{\"success\": " + succeeded + ", \"message\": \"" + errorMessage + "\"}");
    }

}
