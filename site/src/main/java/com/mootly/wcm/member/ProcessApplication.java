package com.mootly.wcm.member;


import javax.jcr.Session;

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

import com.mootly.wcm.beans.tds;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;



public class ProcessApplication extends BaseComponent {
	
	private static final Logger log = LoggerFactory.getLogger(ProcessApplication.class);
	
   
    
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		
   
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		 String val_BSR;  // declaration of variables
		 String val_Date;
		 String val_serial;
		 String val_amount;
		 String  val_SNo;
		    
		
	
		
		String sDataTable = getPublicRequestParameter(request, "hidDataTable"); // to get values from hidden variable 
				
		try{
		
		JSONArray objJsonDT = new JSONArray(sDataTable.trim());
	
		
		
		
		int index=objJsonDT.length();            
		 String ArrayDATE[]=new String[index];  //  Declaration of array
		    String ArrayBSR[]=new String[index];
		    String ArrayAMOUNT[]=new String[index];
		    String ArraySERAIL[]=new String[index];
		
		System.out.println("objJsonDT:-"+objJsonDT);
		for(int n = 0; n < objJsonDT.length(); n++)
		{
			
		
			JSONObject jsonelements = objJsonDT.getJSONObject(n);        // fetching json object from json array
	
		    
		    // to take the separate values of variables from 
	         val_BSR =  jsonelements.getJSONObject("_oData").getString("BSR_code");
	         System.out.println("value of bsr"+ val_BSR);
	         val_SNo =  jsonelements.getJSONObject("_oData").getString("SNo");
	         System.out.println("values of serial no is:--"+val_SNo);
		     val_Date = jsonelements.getJSONObject("_oData").getString("dateofcredit");
		     
		     val_serial = jsonelements.getJSONObject("_oData").getString("Serial_No_of_Challan");
		     System.out.println("serial no of challan"+ val_serial);
		    val_amount = jsonelements.getJSONObject("_oData").getString("Amount");
	 
	        	 ArrayBSR[n]=val_BSR;                       // putting values in arrays
	        	 ArrayDATE[n]=val_Date;
	        	 ArraySERAIL[n]=val_serial;
	 		     ArrayAMOUNT[n]=val_amount;
	 		   System.out.println("in the array"+ArrayBSR[n]);
	 		
	 		 
	    //        }
	        System.out.println("after the array.");
	       
	        
	        }
		// here creating an object td which is used to set values in creating form
		 tds td = new tds();                
			td.setP_BSR(ArrayBSR);
			td.setP_Date(ArrayDATE);
			td.setP_Serial(ArraySERAIL);
			td.setP_Amount( ArrayAMOUNT);
			
			
			createtdsForm(request,td);
		
		}catch(JSONException jsonEx){
			System.out.println(jsonEx);
		
		}	  
	
	}
	
	private String getParameters(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getParameter(HstRequest request, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private tds createtdsForm(HstRequest request, tds td) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			final String memberFolderPath = ContentStructure.getMemberTdsFolder(request);

			final String itReturnPath = wpm.createAndReturn(memberFolderPath, tds.NAMESPACE ,  tds.NODE_NAME, true);
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
			tds tdsdocument = (tds) wpm.getObject(itReturnPath);
			// update content properties
			if (tdsdocument != null) {
				tdsdocument.setP_BSR(td.getP_BSR());
				tdsdocument.setP_Date(td.getP_Date());
				tdsdocument.setP_Serial(td.getP_Serial());
				tdsdocument.setP_Amount(td.getP_Amount());
				
				wpm.update(tdsdocument);
				
				
				
				return tdsdocument;
			} else {
				log.warn("Failed to add membership document for '{}': could not retrieve Review bean for node '{}'.", tds.NODE_NAME, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return tdsdocument;
			}
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
