package com.mootly.wcm.member;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import com.mootly.wcm.beans.ListAdvanceAndSelfAssesment;
import com.mootly.wcm.beans.compound.AdvanceTaxInfo;
import com.mootly.wcm.beans.compound.SelfAssesmentInfo;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

/**
 * 
 * @author: Pankaj Singh
 * Date:12/2/2013
 *Description: Take value from jsp page processapplication.jsp.
 */

public class AdvanceTax extends BaseComponent {
	
	private static final Logger log = LoggerFactory.getLogger(AdvanceTax.class);
	
	private static final String TOTALVALUE = "totalvalue";
	private static final String TOTALVALUE1 = "totalvalue1";
    
	@SuppressWarnings("null")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		try{
		request.setAttribute( TOTALVALUE, request.getParameterValues( TOTALVALUE));
		/*
		 * The below lines are used to fetch data from the repository and make it into json format to put
		 * into the datatable.
		 */
		
		List<AdvanceTaxInfo> listadvancetax=new ArrayList<AdvanceTaxInfo>();
		List<SelfAssesmentInfo> listselfAssesment=new ArrayList<SelfAssesmentInfo>();
		
		 Member member=(Member)request.getSession().getAttribute("user");
		  String username=member.getUserName().trim();
		  String modusername=username.replaceAll("@", "-at-").trim();
		   String pan=(String) request.getSession().getAttribute("pan");
		   if(pan==null){
			   pan="abcde1234g";
		   }
		   String filing_year=(String) request.getSession().getAttribute("filing_year");
		   log.warn("check value in session"+filing_year);

		String path=ContentStructure.getAdvanceAndSelfAssesmentDocPath(pan,filing_year, modusername);
		ListAdvanceAndSelfAssesment objAdvanceTaxDocument=(ListAdvanceAndSelfAssesment)getObjectBeanManager(request).getObject(path);
		

		if (null != objAdvanceTaxDocument) { 	
			listadvancetax=objAdvanceTaxDocument.getAdvanceTax();
			if(listadvancetax!=null){
				log.info("size"+listadvancetax.size());
			    int size=listadvancetax.size();
			    log.info("list object"+listadvancetax.get(0));
			    String[] arrFetchBsr = new String[size];
			    String[] arrFetchDate = new  String[size];
				String[] arrFetchSerial=new String[size];
				String[] arrFetchAmount=new String[size];
			// fetching data from repository
				for(int i=0;i<listadvancetax.size();i++){
					AdvanceTaxInfo objadvance=(AdvanceTaxInfo)listadvancetax.get(i);
					log.info("obj fetched"+objadvance);
					log.info("variable value"+objadvance.getP_Amount());
					String var=(String)objadvance.getP_Amount();
					log.info("var"+var);
					 arrFetchAmount[i]=var;
					log.info("value "+ arrFetchAmount[i]);
					log.info("value from bean"+objadvance.getP_Amount());
					arrFetchBsr[i]=objadvance.getP_BSR();
					Calendar FetchDate=objadvance.getP_Date();
					log.info("FetchDate"+FetchDate);
					Date date =FetchDate.getTime();
					DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
					arrFetchDate[i]=formatter.format(date);
					//arrFetchDate[i]=objadvance.getP_Date();
					log.info("arrFetchDate[i]"+arrFetchDate[i]);
					arrFetchSerial[i]=objadvance.getP_Serial();
					
				}
			// creating json document for first datatable
				JSONObject objFetchValue = null;
				JSONArray objArray = new JSONArray();
				for(int p=0;p<arrFetchAmount.length;p++){
					objFetchValue = new JSONObject();
					objFetchValue.put("BSR_code",arrFetchBsr[p]);
					objFetchValue.put("dateofcredit",arrFetchDate[p]);
					objFetchValue.put("Serial_No_of_Challan",arrFetchSerial[p]);
					objFetchValue.put("Amount",	arrFetchAmount[p]);
					log.info(objFetchValue.toString());
			        objArray.put(p, objFetchValue);
			        log.info("the new json tds salary object is"+objFetchValue);
			        log.info("final object:"+objArray.toString());
				
				request.setAttribute("objArray", objArray);
				request.setAttribute("objFetchValue", objFetchValue);
				}
			
			}
			
			listselfAssesment=objAdvanceTaxDocument.getSelfAssesment();
			if(listselfAssesment!=null){
				log.info("size"+listselfAssesment.size());
			    int size=listselfAssesment.size();
			    log.info("list object"+listselfAssesment.get(0));
			    String[] arrFetchBsr1 = new String[size];
			    String[] arrFetchDate1 = new String[size];
				String[] arrFetchSerial1=new String[size];
				String[] arrFetchAmount1=new String[size];
			//  fetching data for second document
				for(int i=0;i<listselfAssesment.size();i++){
					SelfAssesmentInfo objSelfAssesment=(SelfAssesmentInfo)listselfAssesment.get(i);
					log.info("obj fetched"+objSelfAssesment);
					log.info("variable value"+objSelfAssesment.getP_Amount1());
					String var=(String)objSelfAssesment.getP_Amount1();
					log.info("var"+var);
					 arrFetchAmount1[i]=var;
					log.info("value "+ arrFetchAmount1[i]);
					log.info("value from bean"+objSelfAssesment.getP_Amount1());
					arrFetchBsr1[i]=objSelfAssesment.getP_BSR1();
					Calendar FetchDate1=objSelfAssesment.getP_Date1();
					log.info("FetchDate1"+FetchDate1);
					Date date1 =FetchDate1.getTime();
					log.info("date1 OOOOO:::::"+date1);
					DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					arrFetchDate1[i]=formatter.format(date1);
					//arrFetchDate1[i]=objSelfAssesment.getP_Date1();
					log.info("arrFetchDate1[i]"+arrFetchDate1[i]);
					arrFetchSerial1[i]=objSelfAssesment.getP_Serial1();
					
				}
				// creating json document for second datatable
				JSONObject objFetchValue1= null;
				JSONArray objArray1 = new JSONArray();
				for(int p=0;p<arrFetchAmount1.length;p++){
					objFetchValue1 = new JSONObject();
					objFetchValue1.put("BSR_code1",arrFetchBsr1[p]);
					objFetchValue1.put("dateofcredit1",arrFetchDate1[p]);
					objFetchValue1.put("Serial_No_of_Challan1",arrFetchSerial1[p]);
					objFetchValue1.put("Amount1",	arrFetchAmount1[p]);
					log.info(objFetchValue1.toString());
			        objArray1.put(p, objFetchValue1);
			        log.info("the new json tds salary object is"+objFetchValue1);
			        log.info("final object:"+objArray1.toString());
				
				request.setAttribute("objArray1", objArray1);
				request.setAttribute("objFetchValue1", objFetchValue1);
				}
			
			}
	
		}}catch (JSONException jsonEx){
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
		 String val_BSR=null;  // declaration of variables
		 String val_Date=null;
		 String val_serial=null;
		 String val_amount=null;
		 
		    
		 String val_BSR1=null;  // declaration of variables
		 String val_Date1=null;
		 String val_serial1=null;
		 String val_amount1=null;
		
		// String totalValue=GoGreenUtil.getEscapedParameter(request, TOTALVALUE);
		// String totalValue1=GoGreenUtil.getEscapedParameter(request, TOTALVALUE1);
		// log.info("total value::"+totalValue);
		// log.info("total value1::"+totalValue1);
			//response.setRenderParameter(TOTALVALUE1, totalValue1);
		
		String sDataTable = getPublicRequestParameter(request, "hidDataTable"); // to get values from hidden variable 
		String sDataTable1 = getPublicRequestParameter(request, "hidDataTable1");	
		log.info("sDataTable1"+sDataTable1);
		log.info("sDataTable"+sDataTable);
		try{
		
		JSONArray objJsonDT = new JSONArray(sDataTable.trim());
		JSONArray objJsonDT1 = new JSONArray(sDataTable1.trim());
		
		
	/*
	 * the list below is used put data of two compound doc into one document doc
	 * */
		ListAdvanceAndSelfAssesment aas =new ListAdvanceAndSelfAssesment();
			    log.info("objJsonDT:-"+objJsonDT);
			    List<AdvanceTaxInfo> listadvancetax = new ArrayList<AdvanceTaxInfo>();
		for(int n = 0; n < objJsonDT.length(); n++)
		{
			
		
			JSONObject jsonelements = objJsonDT.getJSONObject(n);        // fetching json object from json array
	
		    
		    // to take the separate values of variables from 
	         val_BSR =  jsonelements.getJSONObject("_oData").getString("BSR_code");
	         log.info("value of bsr"+ val_BSR);
	        
		     val_Date = jsonelements.getJSONObject("_oData").getString("dateofcredit");
		     
		     val_serial = jsonelements.getJSONObject("_oData").getString("Serial_No_of_Challan");
		     log.info("serial no of challan"+ val_serial);
		    val_amount = jsonelements.getJSONObject("_oData").getString("Amount");
		    /*Next 6-7 lines
			 * to covert String date into Calendar object
			 * */
			Date date = null ;
			
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal=Calendar.getInstance();
			try{
				date = (Date)formatter.parse(val_Date); 
			
				cal.setTime(date);
			}
			catch(Exception e){
				log.info("calendar error"+e);
			}
		    
		    AdvanceTaxInfo td = new AdvanceTaxInfo();                
			td.setP_BSR(val_BSR);
			td.setP_Date(cal);
			td.setP_Serial(val_serial);
			td.setP_Amount( val_amount);
			listadvancetax.add(td);
			
			aas.setAdvanceTaxList(listadvancetax);
				}
		 List<SelfAssesmentInfo> listselfassesment = new ArrayList<SelfAssesmentInfo>();
		 for(int n = 0; n < objJsonDT1.length(); n++)
			{
		JSONObject jsonelements1 = objJsonDT1.getJSONObject(n);        // fetching json object from json array
	
		    
		    // to take the separate values of variables from 
	         val_BSR1 =  jsonelements1.getJSONObject("_oData").getString("BSR_code1");
	         log.info("value of bsr1"+ val_BSR1);
	         
		     val_Date1 = jsonelements1.getJSONObject("_oData").getString("dateofcredit1");
		     log.info("date1"+  val_Date1);
		     val_serial1 = jsonelements1.getJSONObject("_oData").getString("Serial_No_of_Challan1");
		     log.info("serial no of challan1"+ val_serial1);
		    val_amount1 = jsonelements1.getJSONObject("_oData").getString("Amount1");
		    
			Date date1 = null ;
			Date testdate1 =null;
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal1=Calendar.getInstance();
			try{
				date1 = (Date)formatter.parse(val_Date1); 
				testdate1=(Date) formatter.parse("2013-04-01");
				cal1.setTime(date1);
			}
			catch(Exception e){
				log.info("calendar error"+e);
			}
		    
		    SelfAssesmentInfo sa = new SelfAssesmentInfo();
			sa.setP_BSR1(val_BSR1);
			sa.setP_Date1(cal1);
			sa.setP_serial1(val_serial1);
			sa.setP_amount1( val_amount1);
			listselfassesment.add(sa);
	        }
		// here creating an object td which is used to set values in creating form
		
			//createtdsForm(request,td);
			
			
			aas.setSelfAssesmentList(listselfassesment);
	
			createtdsForm(request,aas);
			try {
				response.sendRedirect(UrlUtility.TdsfromSalary);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.warn("can't redirect");
			}
		
		}catch(JSONException jsonEx){
			log.warn("Json exception"+jsonEx);
		
		}	  
	
	}


	@SuppressWarnings("null")
	private  ListAdvanceAndSelfAssesment createtdsForm(HstRequest request, ListAdvanceAndSelfAssesment aas) {
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
			   log.warn("check value in session"+filing_year);
			final String memberFolderPath =  ContentStructure.getMemberOriginalFilingPath(request, pan,filing_year, modusername);
			String updateAdvanceReturnPath=ContentStructure.getAdvanceAndSelfAssesmentDocPath(pan,filing_year, modusername);
			log.info("Location of previous doc"+updateAdvanceReturnPath);
			ListAdvanceAndSelfAssesment updateadvance = (ListAdvanceAndSelfAssesment) wpm.getObject(updateAdvanceReturnPath);
			System.out.println("object which is coming for updation"+updateadvance);
		
			if(updateadvance == null){
			
			final String itReturnPath = wpm.createAndReturn(memberFolderPath,  ListAdvanceAndSelfAssesment.NAMESPACE ,   ListAdvanceAndSelfAssesment.NODE_NAME, true);
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
			 ListAdvanceAndSelfAssesment tdsdocument = ( ListAdvanceAndSelfAssesment) wpm.getObject(itReturnPath);
			// update content properties
			if (tdsdocument != null) {
				log.info("before set value to document type");
				tdsdocument.setSelfAssesmentList(aas.getSelfAssesment());
				tdsdocument.setAdvanceTaxList(aas.getAdvanceTax());
				log.info("after set value to document type");
				wpm.update(tdsdocument);
				log.info("after update  document type");
			} 
				//return tdsdocument;
			 else {
				log.info("Failed to add membership document for '{}': could not retrieve Review bean for node '{}'.",  ListAdvanceAndSelfAssesment.NODE_NAME, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return tdsdocument;
			}
		}
			else{
				updateadvance.setSelfAssesmentList(aas.getSelfAssesment());
				updateadvance.setAdvanceTaxList(aas.getAdvanceTax());
				wpm.update(updateadvance);
			}
			} catch (Exception e) {
			log.warn("Failed to create doc ", e);
			//return null;
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
		return aas;
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
	
	
	private ListAdvanceAndSelfAssesment  fetchAdvanceAndSelfAssesmentDocument(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		ArrayList<ListAdvanceAndSelfAssesment> arrlAdvancetax = null;
		WorkflowPersistenceManager wpm;
		ListAdvanceAndSelfAssesment objAdvanceTaxDocument = null;
		log.info("inside fetchAdvanceAndSelfAssesmentDocument--->before try:-");
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
			   log.warn("check value in session"+filing_year);

			//SalaryIncomeDocument sid1=(SalaryIncomeDocument)request.getSession().getAttribute("user");
			// SalaryIncomeDocument sid = new SalaryIncomeDocument();
			log.info("inside advancetax--->member:-"+member);
			if(member!=null){

				log.info("fetchhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
				
				final String itReturnFolderPath = ContentStructure.getAdvanceAndSelfAssesmentDocPath( pan,filing_year, modusername);
				log.info("inside advance and selfassesment---> itReturnFolderPath:-"+itReturnFolderPath);

			
				objAdvanceTaxDocument = (ListAdvanceAndSelfAssesment)getObjectBeanManager(request).getObject(itReturnFolderPath);
				log.info("ListAdvanceAndSelfAssesment->objAdvanceTaxDocument-objAdvanceTaxDocument:"+objAdvanceTaxDocument);


			} 
			return objAdvanceTaxDocument;
		} 
		catch (Exception e) {
			log.warn("Failed to create a review for product '" + "----- IT RETURN ------" + "'", e);
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
	
}
