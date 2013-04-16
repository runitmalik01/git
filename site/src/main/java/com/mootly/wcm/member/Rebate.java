package com.mootly.wcm.member;


import javax.jcr.Session;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.RebateDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;



public class Rebate extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Rebate.class);
	public static final String SECTION_89= "Section_89";
	public static final String SECTION_90="Section_90";
	public static final String SECTION_91 = "Section_91";
	public static final String ERRORS="errors";
	
	
    @Override
   
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.warn("This is Rebate page");
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.warn("test page at do action method");
		
		String Section89=GoGreenUtil.getEscapedParameter(request, "Section_89");
		String Section90=GoGreenUtil.getEscapedParameter(request, "Section_90");
		String Section91=GoGreenUtil.getEscapedParameter(request, "Section_91");
		
		
		
			RebateDocument rb= new RebateDocument();

			rb.setSection89(Section89);
			rb.setSection90(Section90);
			rb.setSection91(Section91);
			
			createRebateUpdateform(request,rb);

			try{  
				
				request.getSession(false);
			}
			catch(Exception e)
			{
				log.warn("Error in response Send Url");
			}
		}
	

	private RebateDocument createRebateUpdateform(HstRequest request, RebateDocument rb) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			 Member member=(Member)request.getSession().getAttribute("user");
			    String username=member.getUserName().trim();
			    String modusername=username.replaceAll("@", "-at-").trim();
			     String pan=(String) request.getSession().getAttribute("pan");
			     if(pan==null){
			      pan="abcde1234g";
			     }
			     String filing_year=(String) request.getSession().getAttribute("filing_year");
			     log.info("check value in session"+filing_year);
			  final String memberFolderPath = ContentStructure.getMemberOriginalFilingPath(request, pan,filing_year, modusername);
			
			final String itReturnPath = wpm.createAndReturn(memberFolderPath, RebateDocument.NAMESPACE ,  RebateDocument.NODE_NAME, true);
			RebateDocument rebatedocument= (RebateDocument) wpm.getObject(itReturnPath);
			// update content properties
			if (rebatedocument != null) {
				rebatedocument.setSection89(rb.getSection89());
				rebatedocument.setSection90(rb.getSection90());
				rebatedocument.setSection91(rb.getSection91());
				
				
				// update now           `
				wpm.update(rebatedocument);
				return rebatedocument;
			}
		}
			catch (Exception e) {
				log.warn("Failed to signup member ", e);
				return null;
			} finally {
				if (persistableSession != null) {
					persistableSession.logout();
				}
			}
			return rb;
		}

@Override
public void doBeforeServeResource(HstRequest request, HstResponse response)
		throws HstComponentException {
	// TODO Auto-generated method stub
	super.doBeforeServeResource(request, response);
}
private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
	public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
		wf.publish();
	}
}
}

				
	
		
	
	
	