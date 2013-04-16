/*
 * In this class we are creating a document for storing value of Schedule80G details of user
 * according to form 16.
 * @author Priyank
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;


import java.io.IOException;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
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

import com.mootly.wcm.beans.MemberDeductionScheduleG;
import com.mootly.wcm.beans.MemberDeductionScheduleVIA;
import com.mootly.wcm.beans.compound.DeductionScheduleGTableA;
import com.mootly.wcm.beans.compound.DeductionScheduleGTableB;
import com.mootly.wcm.beans.compound.DeductionScheduleGTableC;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;



public class Schedule80G extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Schedule80G.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.warn("This is Deduction Page");
		String pan=(String)request.getSession().getAttribute("pan");
		String filing_year=(String)request.getSession().getAttribute("filing_year");
		Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		try {
			String path=ContentStructure.getSchedule80GDocumentPath(pan, filing_year, modusername);
			MemberDeductionScheduleG documentg=(MemberDeductionScheduleG)getObjectBeanManager(request).getObject(path);
			if(documentg!=null){
				DeductionScheduleGTableA objtableA=(DeductionScheduleGTableA)documentg.getDeductionScheduleGTableA();
				String[] fetchaddA=objtableA.getAddressA();
				String[] fetchdoamountA=objtableA.getAmountOfDonationA();
				String[] fetchcityA=objtableA.getCityA();
				String[] fetchstatecodeA=objtableA.getClickForStateCodeA();
				String[] fetchdeamountA=objtableA.getDeductionAmountA();
				String[] fetchtylimitA=objtableA.getLimitA();
				String[] fetchnameA=objtableA.getNameA();
				String[] fetchpincodeA=objtableA.getPinCodeA();
				if(objtableA != null){
					JSONObject objFetchValue = null;			
					JSONArray objArray = new JSONArray();				 
					for(int p=0;p<fetchnameA.length;p++){
						objFetchValue = new JSONObject();
						objFetchValue.put("AddressA",fetchaddA[p]);
						objFetchValue.put("DoAmountA",fetchdoamountA[p]);
						objFetchValue.put("CityA",fetchcityA[p]);
						objFetchValue.put("DeAmountA",fetchdeamountA[p]);
						objFetchValue.put("NameA",fetchnameA[p]);
						objFetchValue.put("PINCodeA",fetchpincodeA[p]);
						objFetchValue.put("StateCodeA",fetchstatecodeA[p]);
						objFetchValue.put("LimitA",fetchtylimitA[p]);
						log.info(objFetchValue.toString());
						objArray.put(p, objFetchValue);
						log.info("the new json object is"+objFetchValue);
						log.info("final:"+objArray.toString());
       					request.setAttribute("objArray", objArray);
						request.setAttribute("objFetchValue", objFetchValue);
					}
				}
				DeductionScheduleGTableB objtableB=(DeductionScheduleGTableB)documentg.getDeductionScheduleGTableB();
				String[] fetchaddB=objtableB.getAddressB();
				String[] fetchdoamountB=objtableB.getAmountOfDonationB();
				String[] fetchcityB=objtableB.getCityB();
				String[] fetchstatecodeB=objtableB.getClickForStateCodeB();
				String[] fetchdeamountB=objtableB.getDeductionAmountB();
				String[] fetchtylimitB=objtableB.getLimitB();
				String[] fetchnameB=objtableB.getNameB();
				String[] fetchpincodeB=objtableB.getPinCodeB();
				if(objtableB != null){
					JSONObject objFetchValueB = null;			
					JSONArray objArrayB = new JSONArray();				 
					for(int p=0;p<fetchnameB.length;p++){
						objFetchValueB = new JSONObject();
						objFetchValueB.put("AddressB",fetchaddB[p]);
						objFetchValueB.put("DoAmountB",fetchdoamountB[p]);
						objFetchValueB.put("CityB",fetchcityB[p]);
						objFetchValueB.put("DeAmountB",fetchdeamountB[p]);
						objFetchValueB.put("NameB",fetchnameB[p]);
						objFetchValueB.put("PINCodeB",fetchpincodeB[p]);
						objFetchValueB.put("StateCodeB",fetchstatecodeB[p]);
						objFetchValueB.put("LimitB",fetchtylimitB[p]);
						log.info(objFetchValueB.toString());
						objArrayB.put(p, objFetchValueB);
						log.info("the new json object is"+objFetchValueB);
						log.info("final:"+objArrayB.toString());
       					request.setAttribute("objArrayB", objArrayB);
						request.setAttribute("objFetchValueB", objFetchValueB);
					}
				}
				DeductionScheduleGTableC objtableC=(DeductionScheduleGTableC)documentg.getDeductionScheduleGTableC();
				String[] fetchaddC=objtableC.getAddressC();
				String[] fetchdoamountC=objtableC.getAmountOfDonationC();
				String[] fetchcityC=objtableC.getCityC();
				String[] fetchstatecodeC=objtableC.getClickForStateCodeC();
				String[] fetchdeamountC=objtableC.getDeductionAmountC();
				String[] fetchtylimitC=objtableC.getLimitC();
				String[] fetchnameC=objtableC.getNameC();
				String[] fetchpincodeC=objtableC.getPinCodeC();
				if(objtableC != null){
					JSONObject objFetchValueC = null;			
					JSONArray objArrayC = new JSONArray();				 
					for(int p=0;p<fetchnameC.length;p++){
						objFetchValueC = new JSONObject();
						objFetchValueC.put("AddressC",fetchaddC[p]);
						objFetchValueC.put("DoAmountC",fetchdoamountC[p]);
						objFetchValueC.put("CityC",fetchcityC[p]);
						objFetchValueC.put("DeAmountC",fetchdeamountC[p]);
						objFetchValueC.put("NameC",fetchnameC[p]);
						objFetchValueC.put("PINCodeC",fetchpincodeC[p]);
						objFetchValueC.put("StateCodeC",fetchstatecodeC[p]);
						objFetchValueC.put("LimitC",fetchtylimitC[p]);
						log.info(objFetchValueC.toString());
						objArrayC.put(p, objFetchValueC);
						log.info("the new json object is"+objFetchValueC);
						log.info("final:"+objArrayC.toString());
       					request.setAttribute("objArrayC", objArrayC);
						request.setAttribute("objFetchValueC", objFetchValueC);
					}
				}
				request.setAttribute("documentg", documentg);
			}
			String path6=ContentStructure.getScheduleVIADocumentPath("pan",filing_year,modusername);
			MemberDeductionScheduleVIA documentvia=(MemberDeductionScheduleVIA)getObjectBeanManager(request).getObject(path6);
			request.setAttribute("documentvia", documentvia);
			if(documentvia!=null){
				log.info("hello via");
				log.warn("hello via");
			}
		}catch (JSONException jsonEx){
			log.warn("jsonEx:::"+jsonEx);
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
		log.warn("This is Schedule80G Deduction Page:doAction");
		String next=GoGreenUtil.getEscapedParameter(request,"next");
		String uuid=getPublicRequestParameter(request,"uuid");
		String val_Name;  // declaration of variables
		String val_City;
		String val_StateCode;
		String val_Address;
		String val_PINCode;
		String val_Limit;
		String val_DoAmount;
		String val_DeAmount;
		String sDataTableA = getPublicRequestParameter(request, "hidDataTable"); // to get values from hidden variable
		String sDataTableB = getPublicRequestParameter(request, "hidDataTable1");
		String sDataTableC = getPublicRequestParameter(request, "hidDataTable2");
		String totalA=GoGreenUtil.getEscapedParameter(request, "totalA");
		String totalB=GoGreenUtil.getEscapedParameter(request, "totalB");
		String totalC=GoGreenUtil.getEscapedParameter(request, "totalC");
		String totalvalue=GoGreenUtil.getEscapedParameter(request, "totalvalue");
		if(sDataTableA!=null&&sDataTableB!=null&&sDataTableC!=null){
			try{
				JSONArray objJsonDT = new JSONArray(sDataTableA.trim());
				int index=objJsonDT.length();            
				//  Declaration of array
				String ArrayNameA[]=new String[index];
				String ArrayCityA[]=new String[index];
				String ArrayStateCodeA[]=new String[index];
				String ArrayAddressA[]=new String[index];
				String ArrayPINCodeA[]=new String[index];
				String ArrayLimitA[]=new String[index];
				String ArrayDoAmountA[]=new String[index];
				String ArrayDeAmountA[]=new String[index];
				log.warn("objJsonDT:-"+objJsonDT);
				for(int n = 0; n < objJsonDT.length(); n++)
				{
					JSONObject jsonelements = objJsonDT.getJSONObject(n);        // fetching json object from json array   
					// to take the separate values of variables from 
					val_Name =  jsonelements.getJSONObject("_oData").getString("NameA");
					val_City = jsonelements.getJSONObject("_oData").getString("CityA");
					val_Address = jsonelements.getJSONObject("_oData").getString("AddressA");
					val_StateCode = jsonelements.getJSONObject("_oData").getString("StateCodeA");
					val_PINCode = jsonelements.getJSONObject("_oData").getString("PINCodeA");
					val_Limit = jsonelements.getJSONObject("_oData").getString("LimitA");
					val_DeAmount = jsonelements.getJSONObject("_oData").getString("DeAmountA");
					val_DoAmount = jsonelements.getJSONObject("_oData").getString("DoAmountA");
					ArrayNameA[n]=val_Name;                       // putting values in arrays
					ArrayAddressA[n]=val_Address;
					ArrayCityA[n]=val_City;
					ArrayStateCodeA[n]=val_StateCode;
					ArrayPINCodeA[n]=val_PINCode;
					ArrayLimitA[n]=val_Limit;
					ArrayDeAmountA[n]=val_DeAmount;
					ArrayDoAmountA[n]=val_DoAmount;
				}
				JSONArray objJsonDTB = new JSONArray(sDataTableB.trim());
				int indexB=objJsonDTB.length();            
				//  Declaration of array
				String ArrayNameB[]=new String[indexB];
				String ArrayCityB[]=new String[indexB];
				String ArrayStateCodeB[]=new String[indexB];
				String ArrayAddressB[]=new String[indexB];
				String ArrayPINCodeB[]=new String[indexB];
				String ArrayLimitB[]=new String[indexB];
				String ArrayDoAmountB[]=new String[indexB];
				String ArrayDeAmountB[]=new String[indexB];
				log.warn("objJsonDT:-"+objJsonDTB);
				for(int n = 0; n < objJsonDTB.length(); n++)
				{
					JSONObject jsonelementsB = objJsonDTB.getJSONObject(n);        // fetching json object from json array   
					// to take the separate values of variables from 
					val_Name =  jsonelementsB.getJSONObject("_oData").getString("NameB");
					val_City = jsonelementsB.getJSONObject("_oData").getString("CityB");
					val_Address = jsonelementsB.getJSONObject("_oData").getString("AddressB");
					val_StateCode = jsonelementsB.getJSONObject("_oData").getString("StateCodeB");
					val_PINCode = jsonelementsB.getJSONObject("_oData").getString("PINCodeB");
					val_Limit = jsonelementsB.getJSONObject("_oData").getString("LimitB");
					val_DeAmount = jsonelementsB.getJSONObject("_oData").getString("DeAmountB");
					val_DoAmount = jsonelementsB.getJSONObject("_oData").getString("DoAmountB");
					ArrayNameB[n]=val_Name;                       // putting values in arrays
					ArrayAddressB[n]=val_Address;
					ArrayCityB[n]=val_City;
					ArrayStateCodeB[n]=val_StateCode;
					ArrayPINCodeB[n]=val_PINCode;
					ArrayLimitB[n]=val_Limit;
					ArrayDeAmountB[n]=val_DeAmount;
					ArrayDoAmountB[n]=val_DoAmount;
				}
				JSONArray objJsonDTC = new JSONArray(sDataTableC.trim());
				int indexC=objJsonDTC.length();            
				//  Declaration of array
				String ArrayNameC[]=new String[indexC];
				String ArrayCityC[]=new String[indexC];
				String ArrayStateCodeC[]=new String[indexC];
				String ArrayAddressC[]=new String[indexC];
				String ArrayPINCodeC[]=new String[indexC];
				String ArrayLimitC[]=new String[indexC];
				String ArrayDoAmountC[]=new String[indexC];
				String ArrayDeAmountC[]=new String[indexC];
				log.warn("objJsonDT:-"+objJsonDTC);
				for(int n = 0; n < objJsonDTC.length(); n++)
				{
					JSONObject jsonelementsC = objJsonDTC.getJSONObject(n);        // fetching json object from json array   
					// to take the separate values of variables from 
					val_Name =  jsonelementsC.getJSONObject("_oData").getString("NameC");
					val_City = jsonelementsC.getJSONObject("_oData").getString("CityC");
					val_Address = jsonelementsC.getJSONObject("_oData").getString("AddressC");
					val_StateCode = jsonelementsC.getJSONObject("_oData").getString("StateCodeC");
					val_PINCode = jsonelementsC.getJSONObject("_oData").getString("PINCodeC");
					val_Limit = jsonelementsC.getJSONObject("_oData").getString("LimitC");
					val_DeAmount = jsonelementsC.getJSONObject("_oData").getString("DeAmountC");
					val_DoAmount = jsonelementsC.getJSONObject("_oData").getString("DoAmountC");
					ArrayNameC[n]=val_Name;                       // putting values in arrays
					ArrayAddressC[n]=val_Address;
					ArrayCityC[n]=val_City;
					ArrayStateCodeC[n]=val_StateCode;
					ArrayPINCodeC[n]=val_PINCode;
					ArrayLimitC[n]=val_Limit;
					ArrayDeAmountC[n]=val_DeAmount;
					ArrayDoAmountC[n]=val_DoAmount;
				}
				DeductionScheduleGTableA tabA=new DeductionScheduleGTableA();
				tabA.setAddressA(ArrayAddressA);
				tabA.setAmountOfDonationA(ArrayDoAmountA);
				tabA.setCityA(ArrayCityA);
				tabA.setClickForStateCodeA(ArrayStateCodeA);
				tabA.setDeductionAmountA(ArrayDeAmountA);
				tabA.setLimitA(ArrayLimitA);
				tabA.setNameA(ArrayNameA);
				tabA.setPinCodeA(ArrayPINCodeA);
				DeductionScheduleGTableB tabB=new DeductionScheduleGTableB();
				tabB.setAddressB(ArrayAddressB);
				tabB.setAmountOfDonationB(ArrayDoAmountB);
				tabB.setCityB(ArrayCityB);
				tabB.setClickForStateCodeB(ArrayStateCodeB);
				tabB.setDeductionAmountB(ArrayDeAmountB);
				tabB.setLimitB(ArrayLimitB);
				tabB.setNameB(ArrayNameB);
				tabB.setPinCodeB(ArrayPINCodeB);
				DeductionScheduleGTableC tabC=new DeductionScheduleGTableC();
				tabC.setAddressC(ArrayAddressC);
				tabC.setAmountOfDonationC(ArrayDoAmountC);
				tabC.setCityC(ArrayCityC);
				tabC.setClickForStateCodeC(ArrayStateCodeC);
				tabC.setDeductionAmountC(ArrayDeAmountC);
				tabC.setLimitC(ArrayLimitC);
				tabC.setNameC(ArrayNameC);
				tabC.setPinCodeC(ArrayPINCodeC);
				MemberDeductionScheduleG schg=new MemberDeductionScheduleG();
				schg.setDeductionScheduleGTableA(tabA);
				schg.setDeductionScheduleGTableB(tabB);
				schg.setDeductionScheduleGTableC(tabC);
				schg.setTotal(totalvalue);
				schg.setTotalA(totalA);
				schg.setTotalB(totalB);
				schg.setTotalC(totalC);
				createMemberDeductionScheduleG(request,schg);
				response.sendRedirect(UrlUtility.Deduction);
			}catch(JSONException e){
				log.error("This is error by JSON Object",e);
			}
			catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}	
	}

	/**
	 * Method to Create & Update the Member Deduction Schedule80G Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Priyank
	 */
	public MemberDeductionScheduleG createMemberDeductionScheduleG(HstRequest request,MemberDeductionScheduleG schg){

		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String pan=(String)request.getSession().getAttribute("pan");
			String filing_year=(String)request.getSession().getAttribute("filing_year");
			Member member=(Member)request.getSession().getAttribute("user");
			String username=member.getUserName().trim();
			String modusername=username.replaceAll("@", "-at-").trim();
			/*Create the path to Save Document in the Repository
			 * */
			log.warn("this is user"+username);
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request,pan,filing_year,modusername);
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */
			String updatePersonalReturnPath=ContentStructure.getSchedule80GDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleG updatepersonalInformation = (MemberDeductionScheduleG) wpm.getObject(updatePersonalReturnPath);
			if(updatepersonalInformation==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberDeductionScheduleG.NAMESPACE ,  MemberDeductionScheduleG.NODE_NAME, true);
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
				/*MemberPersoanlInformation
				 *getObject method get the object at passed path in Repository.
				 * */
				MemberDeductionScheduleG personalInformation = (MemberDeductionScheduleG) wpm.getObject(personalReturnPath);

				// update content properties
				if (personalInformation != null) {
					log.info("PAN NUKMBER");
					personalInformation.setDeductionScheduleGTableA(schg.getDeductionScheduleGTableA());
					personalInformation.setDeductionScheduleGTableB(schg.getDeductionScheduleGTableB());
					personalInformation.setDeductionScheduleGTableC(schg.getDeductionScheduleGTableC());
					personalInformation.setTotal(schg.getTotal());
					personalInformation.setTotalA(schg.getTotalA());
					personalInformation.setTotalB(schg.getTotalB());
					personalInformation.setTotalC(schg.getTotalC());
					// update now  
					wpm.update(personalInformation);
					return personalInformation;
				} else {
					log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", MemberDeductionScheduleG.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return personalInformation;
				}
			}else{
				updatepersonalInformation.setDeductionScheduleGTableA(schg.getDeductionScheduleGTableA());
				updatepersonalInformation.setDeductionScheduleGTableB(schg.getDeductionScheduleGTableB());
				updatepersonalInformation.setDeductionScheduleGTableC(schg.getDeductionScheduleGTableC());
				updatepersonalInformation.setTotal(schg.getTotal());
				updatepersonalInformation.setTotalA(schg.getTotalA());
				updatepersonalInformation.setTotalB(schg.getTotalB());
				updatepersonalInformation.setTotalC(schg.getTotalC());
				wpm.update(updatepersonalInformation);
				return updatepersonalInformation;
			}
		} catch (ObjectBeanPersistenceException e) {
			log.warn("Failed to create a review for personal '" + "----- IT RETURN ------" + "'", e);
			return null;
		} catch (ObjectBeanManagerException e) {
			log.warn("Failed to create a review for personal'" + "----- IT RETURN ------" + "'", e);
			return null;
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}

	}

	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}

}
