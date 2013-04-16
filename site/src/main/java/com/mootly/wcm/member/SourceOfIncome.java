/*
 * We are creating a document for storing value of sources of income details of user
 * @author Kusumlata
 * 04/03/2013
 *  
 */
package com.mootly.wcm.member;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.SourceOfIncomeDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;


public class SourceOfIncome extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(SourceOfIncome.class);
	private static final String ERRORS = "errors";
	private static final String SALARYINCOME = "SALARYINCOME";
	private static final String HOUSEINCOME = "HOUSEINCOME";
	private static final String CAPITALASSET = "CAPITALASSET";
	private static final String OTHERINCOME = "OTHERINCOME";
	String sPAN = null;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		//get pan number from session
		String sPAN = getPublicRequestParameter(request, "pan");
		if(null == sPAN){
			sPAN = "ABCDB1234A";
		}
		log.info("SourceOfIncomeDocument-->createSourceOfIncomeForm-->sPAN:"+sPAN);
		request.getSession().setAttribute("pan",sPAN);
		SourceOfIncomeDocument objSourceOfIncomeDocument = fetchSourceOfIncomeDocument(request,response);
		log.info ("objSourceOfIncomeDocument"+objSourceOfIncomeDocument);
		request.setAttribute("objSourceOfIncomeDocument", objSourceOfIncomeDocument);
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.info("test page at do action method");		
		List<String> errors = new ArrayList<String>();
		//to get values from source of income from checkbox
		String[] selectedfield =request.getParameterValues("selected");
		//to get screen mode for update and create form
		String sScreenMode = getPublicRequestParameter(request, "screenMode");
		log.info ("SourceOfIncome-doAction-->sScreenMode:-"+sScreenMode);
		if(selectedfield==null)
			// if no checkbox is selected,it will show error message
		{    
			errors.add("member.select.option.error"); 
			if (errors.size() != 0) {
				response.setRenderParameter(ERRORS,errors.toArray(new String[errors.size()]));
				log.info("i am at source of income page.");
				return;
			} 
			//for
		}else{
			if(sScreenMode.equals("UPDATE")){
				log.info("SourceOfIncome-doAction-->Update mode");
				updateSourceOfIncome(request, selectedfield);
			}else{
				log.info("SourceOfIncome-doAction-->create mode");
				createSourceOfIncomeForm(request, selectedfield);
			}

			//to get the value of checkbox to redirect on next page
			for (String s : selectedfield)
			{
				log.info("For loop---> selectedfield"+s);
				try{
					response.sendRedirect(SourceOfIncome.getW4IRedirectPath().append(s).toString()); //redirect user on first selected check box.
					return;
				}catch (IOException e) {
					log.info("can't redirect");
				}

			}
		}
	}//else


	/**
	 * This method is used to create  Sources of Income  Document for new user
	 * 
	 * @param request HstRequest
	 * @retun new document objSourceOfIncomeDocument   
	 * @author Kusumlata
	 */
	private SourceOfIncomeDocument createSourceOfIncomeForm(HstRequest request,
			String [] selectedOptions) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		//setting flags for final checkbox values to be stored in document
		boolean salFlag = false;
		boolean hpFlag = false;
		boolean caFlag = false;
		boolean osFlag = false;
		try {
			log.info ("we are in create form");
			SourceOfIncomeDocument  objSourceOfIncomeDocument = new SourceOfIncomeDocument();
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			//Create the path to Save Document in the Repository
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 *
			 */
			Member member=(Member)request.getSession().getAttribute("user");
			String sUsername=member.getUserName().trim();
			log.info("SourceOfIncomeDocument-->createSourceOfIncomeForm"+sUsername);
			//String modusername=username.replaceAll("@", "-at-").trim();
			String sPAN=(String) request.getSession().getAttribute("pan");
			log.info("SourceOfIncomeDocument-->createSourceOfIncomeForm-->sPAN:"+sPAN);
			if(sPAN==null){
				sPAN="abcde1234g";
			}
			
			String sFilingYear=(String) request.getSession().getAttribute("filing_year");
			log.info("SourceOfIncomeDocument-->createSourceOfIncomeForm-->sFilingYear:"+sFilingYear);
			final String memberFolderPath = ContentStructure.getMemberOriginalFilingPath(request, sPAN,sFilingYear, sUsername);
			final String itReturnPath = wpm.createAndReturn(memberFolderPath,SourceOfIncomeDocument.NAMESPACE,SourceOfIncomeDocument.NODE_NAME, true);
			log.info("SourceOfIncomeDocument-->createSourceOfIncomeForm-->itReturnPath:"+itReturnPath);
			 objSourceOfIncomeDocument = (SourceOfIncomeDocument) wpm .getObject(itReturnPath);
			//stores boolean value for checkboxes
			
			for (String s : selectedOptions)
			{	
				if(s.trim().equals("salaryincome")){
					log.info("salary income is true in create method");
					salFlag = true;

				}
				if(s.trim().equals("houseincome")){
					log.info("house income is true in create method");
					hpFlag = true;

				}
				if(s.trim().equals("capitalasset")){
					log.info("capital income is true in create method");
					caFlag = true;

				}
				if(s.trim().equals("otherincome")){
					log.info("other income is true in create method");
					osFlag = true;

				}
			}

			log.info("SourceOfIncome-createSourceOfIncome salFlag:"+salFlag);
			log.info("SourceOfIncome-createSourceOfIncome shpFlag:"+hpFlag);
			log.info("SourceOfIncome-createSourceOfIncome caFlag:"+caFlag);
			log.info("SourceOfIncome-createSourceOfIncome osFlag:"+osFlag);
			objSourceOfIncomeDocument.setsalaryincome(salFlag);
			objSourceOfIncomeDocument.sethouseincome(hpFlag);
			objSourceOfIncomeDocument.setcapitalasset(caFlag);
			objSourceOfIncomeDocument.setotherincome(osFlag);
			// update now `
			wpm.update(objSourceOfIncomeDocument);
			setNavigationInSession(request,objSourceOfIncomeDocument);
			return objSourceOfIncomeDocument;

		} catch (Exception e) {
			log.info("Failed to signup member ", e);
			return null;
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}

	/**
	 * This method is used to update Sources of Income  Document from Repository for existing user
	 * 
	 * @param request HstRequest
	 * @retun path of document  objSourceOfIncomeDocument   
	 * @author Kusumlata
	 */

	private SourceOfIncomeDocument updateSourceOfIncome(HstRequest request,String [] selectedOptions) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			log.info(" we are in update form ");	
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			Member member=(Member)request.getSession().getAttribute("user");
			String sUsername=member.getUserName().trim();
			log.info("SourceOfIncomeDocument-->updateSourceOfIncome "+sUsername);
			// String modusername=username.replaceAll("@", "-at-").trim();
			String sPAN=(String) request.getSession().getAttribute("pan");
			log.info("SourceOfIncomeDocument-->updateSourceOfIncome "+sPAN);
			if(sPAN==null){
				sPAN="abcde1234g";
			}
			String sFilingYear=(String) request.getSession().getAttribute("filing_year");
			log.info("SourceOfIncomeDocument-->updateSourceOfIncome "+sFilingYear);
			final String memberFolderPath = ContentStructure.getMemberSourceIncomePath(sPAN,sFilingYear, sUsername);			
			SourceOfIncomeDocument objSourceOfIncomeDocument = (SourceOfIncomeDocument) wpm .getObject(memberFolderPath);
			if(objSourceOfIncomeDocument!=null){
				//setting flags for final checkbox values to be stored in document
				boolean salFlag = false;
				boolean hpFlag = false;
				boolean caFlag = false;
				boolean osFlag = false;
				log.info("SourceOfIncome-updateSourceOfIncome selectedOptions:"+selectedOptions.toString());
				int selectedOptionLength = selectedOptions.length;
				for(int i=0;i<selectedOptionLength;i++){
					if(selectedOptions[i].trim().equals("salaryincome")){
						log.info("SourceOfIncome-updateSourceOfIncome salaryIncome:true");
						salFlag = true;
					}

					if(selectedOptions[i].trim().equals("houseincome")){
						log.info("SourceOfIncome-updateSourceOfIncome houseincome:true");
						hpFlag = true;
					}

					if(selectedOptions[i].trim().equals("capitalasset")){
						log.info("SourceOfIncome-updateSourceOfIncome capitalasset:true");
						caFlag = true;
					}
					if(selectedOptions[i].trim().equals("otherincome")){
						log.info("SourceOfIncome-updateSourceOfIncome otherincome:true");
						osFlag = true;
					}

				}//end of for
				log.info("SourceOfIncome-updateSourceOfIncome salFlag:"+salFlag);
				log.info("SourceOfIncome-updateSourceOfIncome shpFlag:"+hpFlag);
				log.info("SourceOfIncome-updateSourceOfIncome caFlag:"+caFlag);
				log.info("SourceOfIncome-updateSourceOfIncome osFlag:"+osFlag);
				objSourceOfIncomeDocument.setsalaryincome(salFlag);
				objSourceOfIncomeDocument.sethouseincome(hpFlag);
				objSourceOfIncomeDocument.setcapitalasset(caFlag);
				objSourceOfIncomeDocument.setotherincome(osFlag);
				// update now `
				wpm.update(objSourceOfIncomeDocument);
				setNavigationInSession(request,objSourceOfIncomeDocument);
			}//end of if
			return objSourceOfIncomeDocument;

		} catch (Exception e) {
			log.info("Failed to signup member ", e);
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

	public static class FullReviewedWorkflowCallbackHandler implements
	WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf)
				throws Exception {
			wf.publish();
		}
	}



	/**
	 * This method is used to fetch Sources of Income  Document from Repository
	 * when page is loaded.
	 * 
	 * @param request HstRequest
	 * @retun  objSourceOfIncomeDocument   
	 * @author Kusumlata
	 */

	private SourceOfIncomeDocument fetchSourceOfIncomeDocument(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		SourceOfIncomeDocument objSourceOfIncomeDocument = null;
		WorkflowPersistenceManager wpm;
		log.info("inside fetchSalaryIncomeDocument--->before try:-");
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			Member member=(Member)request.getSession().getAttribute("user");
			log.info("inside fetchSalaryIncomeDocument--->member:-"+member);
			String sUsername=member.getUserName().trim();
			log.info("SourceOfIncomeDocument-->fetchSourceOfIncomeDocument:-"+sUsername);
			//String modusername=username.replaceAll("@", "-at-").trim();
			String sPAN=(String) request.getSession().getAttribute("pan");
			log.info("SourceOfIncomeDocument-->fetchSourceOfIncomeDocument-->sPAN:"+sPAN);
			if(sPAN==null){
				sPAN="abcde1234g";
			}
			String sFilingYear=(String) request.getSession().getAttribute("filing_year");
			log.info("SourceOfIncomeDocument-->fetchSourceOfIncomeDocument:-"+sFilingYear);
			if(member!=null){
				final String memberFolderPath = ContentStructure.getMemberSourceIncomePath(sPAN,sFilingYear, sUsername);
				log.info("inside fetchSalaryIncomeDocument---> memberFolderPath:-"+memberFolderPath);
				try {
					//creating object for fetching the data for SourceOfIncomeDocument 
					objSourceOfIncomeDocument=(SourceOfIncomeDocument) getObjectBeanManager(request).getObject(memberFolderPath);
					log.info("objSourceOfIncomeDocument-->inside fetchSalaryIncomeDocument--->try--> memberFolderPath:-"+memberFolderPath);
					if(null != objSourceOfIncomeDocument){
						log.info("SourceOfIncome-fetchSourceOfIncomeDocument objSourceOfIncomeDocument salary:"+objSourceOfIncomeDocument.getsalaryincome());
						log.info("SourceOfIncome-fetchSourceOfIncomeDocument objSourceOfIncomeDocument houseprop:"+objSourceOfIncomeDocument.gethouseincome());
						log.info("SourceOfIncome-fetchSourceOfIncomeDocument objSourceOfIncomeDocument capital asset:"+objSourceOfIncomeDocument.getcapitalasset());
						log.info("SourceOfIncome-fetchSourceOfIncomeDocument objSourceOfIncomeDocument other income:"+objSourceOfIncomeDocument.getotherincome());
	
						if(null == objSourceOfIncomeDocument.getsalaryincome()){
							objSourceOfIncomeDocument.setsalaryincome(false);
						}
						if(null == objSourceOfIncomeDocument.gethouseincome()){
							objSourceOfIncomeDocument.sethouseincome(false);
						}
						if(null == objSourceOfIncomeDocument.getcapitalasset()){
							objSourceOfIncomeDocument.setcapitalasset(false);
						}
						if(null == objSourceOfIncomeDocument.getotherincome()){
							objSourceOfIncomeDocument.setotherincome(false);
						}
					}
				}catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//}
				}
			}
			return objSourceOfIncomeDocument;
		} 
		catch (Exception e) {
			log.info("Failed to create a review for product '" + "----- IT RETURN ------" + "'", e);
			return null;
		}
		finally
		{
			if (persistableSession != null)
			{
				persistableSession.logout();
			}
		}
	}


	/**
	 * This method is used to set navigation info in session
	 * 
	 * @param request HstRequest 
	 * @author Kusumlata
	 * 
	 */
	public  void setNavigationInSession(HstRequest request,SourceOfIncomeDocument objSourceOfIncomeDocument) {
		// TODO Auto-generated method stub
		log.info("inside setNavigationInSession--->before try:-");
		HashMap hmSourcesOfIncome = new HashMap() ;
		hmSourcesOfIncome.put("SFlag", objSourceOfIncomeDocument.getsalaryincome().toString());
		hmSourcesOfIncome.put("HPFlag", objSourceOfIncomeDocument.gethouseincome().toString());
		hmSourcesOfIncome.put("CAFlag", objSourceOfIncomeDocument.getcapitalasset().toString());
		hmSourcesOfIncome.put("OSFlag", objSourceOfIncomeDocument.getotherincome().toString());
		log.info("hmSourcesOfIncomehmSourcesOfIncome"+hmSourcesOfIncome.toString());
		request.getSession().setAttribute("SourceOfIncomeNav",hmSourcesOfIncome);
		log.info("HashmapFlags"+request.getSession().getAttribute("SourceOfIncomeNav").toString());

	}
	
	
	
	public static StringBuilder getW4IRedirectPath(){

		StringBuilder sRedirectPath = new StringBuilder("/site/");
		return sRedirectPath; 	   
	}
}
