package com.mootly.wcm.member;


import java.io.IOException;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.TdsFromSalaryInformation;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */

public class TdsFromSalary extends BaseComponent {
	
	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	private static final String TOTALVALUE = "totalvalue";
	/* the entire code written in dobefore render is to create object of bean take data and construct json format*/
	
   
    
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		request.setAttribute( TOTALVALUE, request.getParameterValues( TOTALVALUE));
		log.info("before try ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
		
		try{
			String[] fetchTan;
			String[] fetchName;
			String[] fetchIncome;
			String[] fetchTotalTax;
			Member member=(Member)request.getSession().getAttribute("user");
			  String username=member.getUserName().trim();
			  String modusername=username.replaceAll("@", "-at-").trim();
			   String pan=(String) request.getSession().getAttribute("pan");
			   String filing_year=(String) request.getSession().getAttribute("filing_year");
			   if(pan==null || filing_year==null){
				   pan="abcde1234g";
			   }
		String path=ContentStructure.getTdsSalaryDocPath(pan,filing_year, modusername);
		TdsFromSalaryInformation objTdsSalary =(TdsFromSalaryInformation)getObjectBeanManager(request).getObject(path);
		request.setAttribute("objTdsSalary", objTdsSalary);
		if(objTdsSalary != null){
			log.info("total value is ::"+objTdsSalary.getTotal_Value());
			log.info("tds object is QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ"+objTdsSalary);
			log.info("tds object is"+objTdsSalary.getTotal_Value());
				fetchTan = objTdsSalary.getTan_Employer();
				log.info("value is ::"+fetchTan[0]);
				fetchName= objTdsSalary.getName_Employer();
				log.info("value is fetch tan ::"+fetchName[0]);
				fetchIncome=objTdsSalary.getIncome_Chargeable();
				log.info("value is fetch name ::"+fetchIncome[0]);
				fetchTotalTax=objTdsSalary.getTotal_TaxDeducted();
			 
				log.info("size of loop"+ fetchTotalTax.length);
				JSONObject objFetchValue = null;
			
				JSONArray objArray = new JSONArray();
			 
				for(int p=0;p<fetchTotalTax.length;p++){
					objFetchValue = new JSONObject();
					objFetchValue.put("TAN",fetchTan[p]);
					objFetchValue.put("employer",fetchName[p]);
					objFetchValue.put("Incomechargeable",fetchIncome[p]);
					objFetchValue.put("taxdeducted",fetchTotalTax[p]);
					log.info(objFetchValue.toString());
			        objArray.put(p, objFetchValue);
			        log.info("the new json tds salary object is"+objFetchValue);
			        log.info("final object:"+objArray.toString());
				
				request.setAttribute("objArray", objArray);
				request.setAttribute("objFetchValue", objFetchValue);
				}
		} }
			catch (JSONException jsonEx){
				log.warn("jsonEx:::"+jsonEx);
		}
	catch (ObjectBeanManagerException objBeanMgrExc){
	log.warn("objBeanMgrExc:::"+objBeanMgrExc);
	}



   
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		 String tanEmployer;  // declaration of variables
		 String nameEmployer;
		 String incomeChargeable;
		 String totalTaxdeducted;
		 
		 String totalValue=GoGreenUtil.getEscapedParameter(request, TOTALVALUE);
		 log.info("total value::"+totalValue);
			response.setRenderParameter(TOTALVALUE, totalValue);
			String sDataTable = getPublicRequestParameter(request, "hidDataTable"); // to get values from hidden variable 
				
		try{
		
		JSONArray objJsonDT = new JSONArray(sDataTable.trim());
		int index=objJsonDT.length();            
		 String ArrayTANEmployer[]=new String[index];  //  Declaration of array
		 String ArrayNAMEEMPLOYER[]=new String[index];
		 String ArrayINCOMECHARGEABLE[]=new String[index];
		 String ArrayTAXDEDUCTED[]=new String[index];
		
		    log.info("objJsonDT:-"+objJsonDT);
		for(int n = 0; n < objJsonDT.length(); n++)
		{
			
		
			JSONObject jsonelements = objJsonDT.getJSONObject(n);        // fetching json object from json array
	   
		    // to take the separate values of variables from 
			tanEmployer =  jsonelements.getJSONObject("_oData").getString("TAN");
	         log.info("value of bsr"+ tanEmployer);
	         nameEmployer =  jsonelements.getJSONObject("_oData").getString("employer");
	         log.info("values of serial no is:--"+nameEmployer);
	         incomeChargeable = jsonelements.getJSONObject("_oData").getString("Incomechargeable");
		     
	         totalTaxdeducted = jsonelements.getJSONObject("_oData").getString("taxdeducted");
	         log.info("serial no of challan"+ totalTaxdeducted);
		    
	  
		     	ArrayTANEmployer[n]=tanEmployer;       // putting values in arrays
	        	ArrayNAMEEMPLOYER[n]=nameEmployer;
	        	ArrayINCOMECHARGEABLE[n]=incomeChargeable;
	        	ArrayTAXDEDUCTED[n]=totalTaxdeducted;
	        	log.info("in the array"+ArrayNAMEEMPLOYER[n]);
	 		
	 		 
	    //        }
	 		  log.info("after the array.");
	       		}
		// here creating an object td which is used to set values in creating form
		 TdsFromSalaryInformation tdsSalary = new TdsFromSalaryInformation();                
		 tdsSalary.setTan_Employer(ArrayTANEmployer);
		 tdsSalary.setName_Employer( ArrayNAMEEMPLOYER);
		 tdsSalary.setIncome_Chargeable(ArrayINCOMECHARGEABLE);
		 tdsSalary.setTotal_TaxDeducted(ArrayTAXDEDUCTED);
		 tdsSalary.setTotal_Value(totalValue);
		
		 	createtdsForm(request,tdsSalary);
		 	try {
		 		response.sendRedirect(UrlUtility.TdsfromOthers);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				 log.info("can't redirect");
			}
		
		}catch(JSONException jsonEx){
			log.warn("Json exception"+jsonEx);
		}	  
	}
	private TdsFromSalaryInformation createtdsForm(HstRequest request, TdsFromSalaryInformation tdsSalary) {
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
			  String filing_year=(String) request.getSession().getAttribute("filing_year");
			   if(pan==null || filing_year==null){
				   pan="abcde1234g";
			   }
			final String memberFolderPath = ContentStructure.getMemberOriginalFilingPath(request,pan,filing_year, modusername);
			String updatetdssalary=ContentStructure.getTdsSalaryDocPath(pan,filing_year, modusername);
			TdsFromSalaryInformation updateTdsSalary = (TdsFromSalaryInformation) wpm.getObject(updatetdssalary);
			if(updateTdsSalary==null){

			final String itReturnPath = wpm.createAndReturn(memberFolderPath, TdsFromSalaryInformation.NAMESPACE ,  TdsFromSalaryInformation.NODE_NAME, true);
			/*
			HippoFolder hippoFolder = (HippoFolder) wpm.getObject(itReturnFolderPath);
			List<HippoTranslation> hippoTranslations = hippoFolder.getChildBeansByName("hippo:translation");
			if (hippoTranslations != null && hippoTranslations.size() > 0) {
				for (HippoTranslation translation:hippoTranslations) {
					if (translation.getProperty("locale","").equals("en")) {
					}
				}
			}
			*/
			TdsFromSalaryInformation tdsdocument = (TdsFromSalaryInformation) wpm.getObject(itReturnPath);
			// update content properties
			if (tdsdocument != null) {
				tdsdocument.setTan_Employer(tdsSalary.getTan_Employer());
				tdsdocument.setName_Employer(tdsSalary.getName_Employer());
				tdsdocument.setIncome_Chargeable(tdsSalary.getIncome_Chargeable());
				tdsdocument.setTotal_TaxDeducted(tdsSalary.getTotal_TaxDeducted());
				tdsdocument.setTotal_Value(tdsSalary.getTotal_Value());
				
				wpm.update(tdsdocument);
				
				
				
				return tdsdocument;
			
			} else {
				 log.info("Failed to add membership document for '{}': could not retrieve Review bean for node '{}'.", TdsFromSalaryInformation.NODE_NAME, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return tdsdocument;
			}
			} else {
				updateTdsSalary.setTan_Employer(tdsSalary.getTan_Employer());
				updateTdsSalary.setName_Employer(tdsSalary.getName_Employer());
				updateTdsSalary.setIncome_Chargeable(tdsSalary.getIncome_Chargeable());
				updateTdsSalary.setTotal_TaxDeducted(tdsSalary.getTotal_TaxDeducted());
				updateTdsSalary.setTotal_Value(tdsSalary.getTotal_Value());
				wpm.update(updateTdsSalary);
			}
				return updateTdsSalary;
			
			
		} catch (Exception e) {
			log.warn("Failed to signup member ", e);
			return null;
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}
			

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
