/*
 * In this class we are creating a document for storing value of adjustment of losses of user
 * according to form 16.
 * @author Dhananjay
 * 20/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

public class Tcs extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Tcs.class);
	private static final String NATUREPAYMENT = "naturepayment";
	private static final String TAN = "tan";
	private static final String NAME = "name";
	private static final String TAXCALCAMOUNT= "taxcalamount";
	private static final String TAXCOLLECTED = "taxcollected";
	private static final String AMOUNTCLAIMED = "amountclaimed";
	private static final String ERRORS = "errors";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		log.info("This is TCS Page");
		try {
			Member member=(Member)request.getSession().getAttribute("user");
			  String username=member.getUserName().trim();
			  String modusername=username.replaceAll("@", "-at-").trim();
			   String pan=(String) request.getSession().getAttribute("pan");
			   String filing_year=(String) request.getSession().getAttribute("filing_year");
			   if(pan==null || filing_year==null){
				   pan="abcde1234g";
			   }
			String path=ContentStructure.getTcsDocPath(pan,filing_year, modusername);
			log.warn(path);
			TcsDocument fetchtcs =(TcsDocument)getObjectBeanManager(request).getObject(path);
			
			request.setAttribute("fetchtcs", fetchtcs);
			if(fetchtcs!= null){
				log.warn("the values are coming from bean");
				log.warn("security object is"+fetchtcs.getName());
				
			}		
			   
		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        
		
		}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);		
		//get all parameter of form
		String Naturepayment=GoGreenUtil.getEscapedParameter(request,NATUREPAYMENT);
		log.info("Naturepayment"+Naturepayment);
		String Tan=GoGreenUtil.getEscapedParameter(request, TAN);
		String Name=GoGreenUtil.getEscapedParameter(request,NAME);
		log.info("Name"+Name);
		String TaxCalAmount=GoGreenUtil.getEscapedParameter(request,TAXCALCAMOUNT);
		String TaxCollected=GoGreenUtil.getEscapedParameter(request, TAXCOLLECTED);
		String AmountClaimed=GoGreenUtil.getEscapedParameter(request, AMOUNTCLAIMED);
		/**
		 * next line is for regular expression of Tan
		 */
		String reg_pan="^[A-Z]{4}\\d{5}[A-Z]$";
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(Tan) || !Tan.matches(reg_pan)){
			errors.add("Enter a valid Tan");
		}
		if(StringUtils.isEmpty(Naturepayment)){
			errors.add("invalid.naturepayment-label");
		}
		if(StringUtils.isEmpty(Name)){
			errors.add("invalid.name-label");
		}
		if(StringUtils.isEmpty(TaxCalAmount)){
			errors.add("invalid.taxcalculateAmount-label");
		}
		if(StringUtils.isEmpty(TaxCollected)){
			errors.add("invalid.taxcollected-label");
		}
		if(StringUtils.isEmpty(AmountClaimed)){
			errors.add("invalid.amountclaimed-label");
		}
		log.info("size"+errors.size());
		if (errors.size()!=0){
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			response.setRenderParameter(NATUREPAYMENT, Naturepayment);
			response.setRenderParameter(TAN , Tan );
			response.setRenderParameter(NAME, Name);
			response.setRenderParameter(TAXCALCAMOUNT,TaxCalAmount );
			response.setRenderParameter(TAXCOLLECTED,TaxCollected);
			response.setRenderParameter(AMOUNTCLAIMED, AmountClaimed);
			
			log.warn("i am at");
			return;
		}
		if (errors == null || errors.size() == 0) {
		
		        TcsDocument tcs = new TcsDocument();
		        tcs.setNaturepayment(Naturepayment);
		        tcs.setTan(Tan);
		        tcs.setName(Name);
		        tcs.setTaxCalcAmount(TaxCalAmount);
		        tcs.setTaxCollected(TaxCollected);
		        tcs.setAmountClaimed(AmountClaimed);
		        
				
				createtcsform(request, tcs);	
				try{
					response.sendRedirect(UrlUtility.Calculation);
				} catch(Exception e){
					
				}
		}
	}
			
	 //Method to Update the Member tcsdocument Document 
	 
	private TcsDocument createtcsform(HstRequest request,TcsDocument tcs) {
		// TODO Auto-generated method stub
		
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler()); Member member=(Member)request.getSession().getAttribute("user");
			  String username=member.getUserName().trim();
			  String modusername=username.replaceAll("@", "-at-").trim();
			   String pan=(String) request.getSession().getAttribute("pan");
			   if(pan==null){
				   pan="abcde1234g";
			   }
			   String filing_year=(String) request.getSession().getAttribute("filing_year");
			   log.warn("check value in session"+filing_year);
			
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request, pan, filing_year, modusername);
			String updateTcsPath=ContentStructure.getMemberSecurityDocPath(pan,filing_year, modusername);
			TcsDocument updateTcs = (TcsDocument) wpm.getObject(updateTcsPath);
			if(updateTcs==null){
			final String itReturnPath = wpm.createAndReturn(itReturnFolderPath,TcsDocument.NAMESPACE ,  TcsDocument.NODE_NAME, true);
			log.info("set values");
			TcsDocument tcsdoc = (TcsDocument) wpm.getObject(itReturnPath);
			if(tcsdoc!=null)
			{
						tcsdoc.setNaturepayment(tcs.getNaturepayment());
						tcsdoc.setTan(tcs.getTan());
						tcsdoc.setName(tcs.getName());
						tcsdoc.setTaxCalcAmount(tcs.getTaxCalcAmount());
						tcsdoc.setTaxCollected(tcs.getTaxCollected());
						tcsdoc.setAmountClaimed(tcs.getAmountClaimed());
						wpm.update(tcsdoc);
						return tcsdoc;
			}
			} 
				else{	
					updateTcs.setNaturepayment(tcs.getNaturepayment());
					updateTcs.setTan(tcs.getTan());
					updateTcs.setName(tcs.getName());
					updateTcs.setTaxCalcAmount(tcs.getTaxCalcAmount());
					updateTcs.setTaxCollected(tcs.getTaxCalcAmount());
					updateTcs.setAmountClaimed(tcs.getAmountClaimed());
					wpm.update(updateTcs);
					return updateTcs;
				}
				
			
		}
		catch (Exception e) {
			log.warn("Failed to create a review for product '" + "----- IT RETURN ------" + "'", e);
			return null;
		                    }
		      finally
		          {
			       
		        }
		return tcs;
		}
	
	// here we are open document in updatemode for updation in existing document
	

	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}
	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}
