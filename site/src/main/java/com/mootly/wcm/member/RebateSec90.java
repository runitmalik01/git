package com.mootly.wcm.member;


import java.math.BigDecimal;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;


public class RebateSec90 extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(RebateSec90.class);
	public static final String SECTION_89= "Section_89";
	public static final String SECTION_90="Section_90";
	public static final String SECTION_91 = "Section_91";
	public static final String ERRORS="errors";
	
	
    @Override
    /**
     * This method is used to calculate the rebate under section 90/91
     * on the basis of user select whether india has signed DTAA or not.
     * @author Pankaj Singh
     */
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.warn("This is RebateSec90 page");
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		// following data is hard codeded for calculation
		int IncomeOutside=1000000;
		int intIncomeIndia=500000;
		int Incometaxable=intIncomeIndia+IncomeOutside;
		int Tax = 402215;
		double Rateoftaxinindia1= Tax*100;
		double Rateoftaxinindia12= Rateoftaxinindia1/Incometaxable;
		float Rateoftaxinindia = (float) Math.round(Rateoftaxinindia12 * 100) / 100;
		log.info("Rateoftaxinindia QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ"+Rateoftaxinindia);
		
		double RateForiegnIncome1=IncomeOutside*100;
		double RateForiegnIncome12=RateForiegnIncome1/Incometaxable;
		log.info("RateForiegnIncome12"+RateForiegnIncome12);
		float  RateForiegnIncome = (float) Math.round(RateForiegnIncome12 * 100) / 100;
		log.info("RateForiegnIncome"+RateForiegnIncome);
		// for finding smallest among two rates to show on jsp page.
		if(Rateoftaxinindia<RateForiegnIncome){
			double relief1=Rateoftaxinindia*IncomeOutside;
			String relief=BigDecimal.valueOf(relief1).toPlainString();
			log.info("relief QQQQQQQQQQQQQQ "+relief);
			request.setAttribute("relief", relief);
			log.info("if indian rate is less ");
			
		}else{
			double reliefForiegn=RateForiegnIncome12*IncomeOutside;
			log.info("if indian rate is more ");
			request.setAttribute("reliefForiegn", reliefForiegn);
			log.info("reliefForiegn OOOOOOOOOOOOOO"+reliefForiegn);
		}
		
		
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.warn("test page at do action method");
		String Section90=GoGreenUtil.getEscapedParameter(request, "Section_90");
		String Section91=GoGreenUtil.getEscapedParameter(request, "Section_91");
		RebateSec90Document rb= new RebateSec90Document();
			rb.setSection90(Section90);
			rb.setSection91(Section91);
			createRebateUpdateform(request,rb);

			try{  
				response.sendRedirect(UrlUtility.AdvanceTax);
			
			}
			catch(Exception e)
			{
				log.warn("Error in response Send Url");
			}
		}
	

	@SuppressWarnings("null")
	private RebateSec90Document createRebateUpdateform(HstRequest request,RebateSec90Document rb) {
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
			  String updateRebateSec90Path=ContentStructure.getRebateSec90DocPath(pan,filing_year, modusername);
			  log.info("Path of existing document:::::::"+updateRebateSec90Path);
			  RebateSec90Document updateRebateSec90 = (RebateSec90Document) wpm.getObject(updateRebateSec90Path);
			  if(updateRebateSec90 ==null){
			final String itReturnPath = wpm.createAndReturn(memberFolderPath, RebateSec90Document.NAMESPACE ,  RebateSec90Document.NODE_NAME, true);
			RebateSec90Document rebatedocument= (RebateSec90Document) wpm.getObject(itReturnPath);
			// update content properties
			if (rebatedocument != null) {
				rebatedocument.setSection90(rb.getSection90());
				rebatedocument.setSection91(rb.getSection91());
				log.info("cerating the new document");
				
				// update now           `
				wpm.update(rebatedocument);
			} }else{
				log.info("updating the existing dicument");
				updateRebateSec90.setSection90(rb.getSection90());
				updateRebateSec90.setSection91(rb.getSection91());
				wpm.update(updateRebateSec90);
				
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

				
	
		
	
	
	