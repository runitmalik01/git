package com.mootly.wcm.member;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import com.mootly.wcm.beans.ListTdsFromOthersInfo;
import com.mootly.wcm.beans.compound.CompTdsothers;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

/**
 * 
 * @author: Pankaj Singh
 * Date:12/2/2013
 *Description: Take value from jsp page tdsFromOthers.jsp.
 */

public class TdsFromOthers extends BaseComponent {
	
	private static final Logger log = LoggerFactory.getLogger(TdsFromOthers.class);
	
	private static final String TOTALVALUE = "totalvalue";
	
   
    
	@SuppressWarnings("null")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		try{
		String fetchTotalvalue;
		request.setAttribute( TOTALVALUE, request.getParameterValues( TOTALVALUE));
		List<CompTdsothers> comptdsothers=new ArrayList<CompTdsothers>();
		
		
		 Member member=(Member)request.getSession().getAttribute("user");
		  String username=member.getUserName().trim();
		  String modusername=username.replaceAll("@", "-at-").trim();
		   String pan=(String) request.getSession().getAttribute("pan");
		   if(pan==null){
			   pan="abcde1234g";
		   }
		   String filing_year=(String) request.getSession().getAttribute("filing_year");
		   log.warn("check value in session"+filing_year);

		String path=ContentStructure.getTdsOthersDocPath(pan,filing_year, modusername);
		log.info("path of existing document"+path);
		ListTdsFromOthersInfo objfetchtdsfromothers=(ListTdsFromOthersInfo)getObjectBeanManager(request).getObject(path);
		log.info("to check for object"+objfetchtdsfromothers);
		if (null != objfetchtdsfromothers) { 	
			fetchTotalvalue=objfetchtdsfromothers.getTotal_Value();
		
			log.info("fetchTotalvalue OOOOOOOOOOOOOO"+fetchTotalvalue);
			request.setAttribute("objfetchtdsfromothers", objfetchtdsfromothers);
			
			comptdsothers=objfetchtdsfromothers.getTestTdsOthers();
			if(comptdsothers!=null){
				log.info("size"+comptdsothers.size());
			    int size=comptdsothers.size();
			    log.info("list object"+comptdsothers.get(0));
			    String[] arrFetchTanDeductor = new String[size];
			    String[] arrNamedeductor = new  String[size];
				String[] arrFetchTaxDeducted=new String[size];
				String[] arrFetchAmount=new String[size];
			// fetching data from repository
				for(int i=0;i<comptdsothers.size();i++){
					CompTdsothers objcomptdsothers=(CompTdsothers)comptdsothers.get(i);
				
					String var=(String)objcomptdsothers.getP_Amount();
					log.info("var"+var);
					 arrFetchAmount[i]=var;
					log.info("value from bean"+objcomptdsothers.getTan_Deductor());
					 arrFetchTanDeductor[i]=objcomptdsothers.getTan_Deductor();
					 arrNamedeductor[i]=objcomptdsothers.getName_Deductor();
					log.info("arrNamedeductor[i]"+arrNamedeductor[i]);
					arrFetchTaxDeducted[i]=objcomptdsothers.getTotal_TaxDeductor();
					
				}
			// creating json document for first datatable
				JSONObject objFetchValue = null;
				JSONArray objArray = new JSONArray();
				for(int p=0;p<arrFetchAmount.length;p++){
					objFetchValue = new JSONObject();
					objFetchValue.put("TANDeductor",arrFetchTanDeductor[p]);
					objFetchValue.put("NameDeductor",arrNamedeductor[p]);
					objFetchValue.put("TaxDeducted",arrFetchTaxDeducted[p]);
					objFetchValue.put("Amountclaimed",	arrFetchAmount[p]);
					log.info(objFetchValue.toString());
			        objArray.put(p, objFetchValue);
			        log.info("the new json tds salary object is"+objFetchValue);
			        log.info("final object:"+objArray.toString());
				
				request.setAttribute("objArray", objArray);
				request.setAttribute("objFetchValue", objFetchValue);
				}
			
			}
		}

	}catch(JSONException jsonEx){
		log.warn("jsonEx:::"+jsonEx);
	} catch (ObjectBeanManagerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		 String tanDeductor=null;  // declaration of variables
		 String nameDeductor=null;
		
		 String Amount=null;
		 String  totalTaxdeducted=null;
		 String totalValue=GoGreenUtil.getEscapedParameter(request, TOTALVALUE);
		 log.info("total value::"+totalValue);
		String sDataTable = getPublicRequestParameter(request, "hidDataTable"); // to get values from hidden variable 
		try{
		
		JSONArray objJsonDT = new JSONArray(sDataTable.trim());
		int index=objJsonDT.length();            
		  
		    
		ListTdsFromOthersInfo tds =new ListTdsFromOthersInfo();
		    log.info("objJsonDT:-"+objJsonDT);
		    
			List<CompTdsothers> tdsothers = new ArrayList<CompTdsothers>();
		for(int n = 0; n < objJsonDT.length(); n++)
		{
		JSONObject jsonelements = objJsonDT.getJSONObject(n);        // fetching json object from json array
	    // to take the separate values of variables from 
			tanDeductor =  jsonelements.getJSONObject("_oData").getString("TANDeductor");
			log.info("value of tandeductor"+ tanDeductor);
	        nameDeductor = jsonelements.getJSONObject("_oData").getString("NameDeductor");
	        totalTaxdeducted = jsonelements.getJSONObject("_oData").getString("TaxDeducted");
	        log.info("TaxDeducted"+ totalTaxdeducted);
		    Amount = jsonelements.getJSONObject("_oData").getString("Amountclaimed");
	         
		// here creating an object td which is used to set values in creating form
	//	List<testTdsothers> td = (List<testTdsothers>) new testTdsothers(); 
		    CompTdsothers td= new CompTdsothers();
			 td.setTan_Deductor(tanDeductor);
			 td.setTotal_TaxDeductor(totalTaxdeducted);
			 td.setP_Amount( Amount);
			 td.setName_Deductor(nameDeductor);
			 
			 tdsothers.add(td);
			
			}
		tds.setTdsSalaryList(tdsothers);
		tds.setTotal_Value(totalValue);
		createtdsForm(request,tds);
		try {
			response.sendRedirect(UrlUtility.Interest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.warn("can't redirect");
		}
		}catch(JSONException jsonEx){
			log.warn("Json Excption "+jsonEx);
		
		}	  
	
	}
	
	

	private ListTdsFromOthersInfo createtdsForm(HstRequest request, ListTdsFromOthersInfo tds) {
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
			String updateTdsOtherPath=ContentStructure.getTdsOthersDocPath(pan,filing_year, modusername);
			log.info("Location of previous doc"+updateTdsOtherPath);
			ListTdsFromOthersInfo updateadvance = (	ListTdsFromOthersInfo) wpm.getObject(updateTdsOtherPath);
			System.out.println("object which is coming for updation"+updateadvance);
			if(updateadvance == null){
			final String itReturnPath = wpm.createAndReturn(memberFolderPath, ListTdsFromOthersInfo.NAMESPACE ,  ListTdsFromOthersInfo.NODE_NAME, true);
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
			ListTdsFromOthersInfo tdsdocument = (ListTdsFromOthersInfo) wpm.getObject(itReturnPath);
			// update content properties
			if (tdsdocument != null) {
				tdsdocument.setTdsSalaryList(tds.getTestTdsOthers());
				tdsdocument.setTotal_Value(tds.getTotal_Value());
				//tdsdocument.setTdsSalaryList(tds.getTestTdsOthers());
			
				
				wpm.update(tdsdocument);
				
				
				
				return tdsdocument;
			} else {
				log.info("Failed to add membership document for '{}': could not retrieve Review bean for node '{}'.", ListTdsFromOthersInfo.NODE_NAME, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return tdsdocument;
			}
			} else{	
				updateadvance.setTdsSalaryList(tds.getTestTdsOthers());
				updateadvance.setTotal_Value(tds.getTotal_Value());
			//tdsdocument.setTdsSalaryList(tds.getTestTdsOthers());
			wpm.update(updateadvance);
			return updateadvance;
				
			}
		} catch (Exception e){
			log.info("value of e is:::"+e);
		}
		return tds;
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
