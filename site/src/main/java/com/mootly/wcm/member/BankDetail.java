/*
 * In this class we are creating a document for storing value of Bank details of user
 * according to form 16.
 * @author Priyank
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=MemberContactInformation.class)
@FormFields(fieldNames={"bd_bank_name","bd_micr_code","bd_Branch_name","bd_account_type","bd_account_no","bd_ecs"})
@RequiredFields(fieldNames={"bd_bank_name","bd_micr_code","bd_Branch_name","bd_account_type","bd_account_no","bd_ecs"})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
public class BankDetail extends ITReturnComponent {
	
private static final Logger log = LoggerFactory.getLogger(BankDetail.class);
    
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
}
/*public void doBeforeRenderOld1(HstRequest request, HstResponse response) {
	// TODO Auto-generated method stub
	super.doBeforeRender(request, response);
	log.info("This is Bank Detail Page");
	String pan=(String)request.getSession().getAttribute("start_pan");
	String filing_year=(String)request.getSession().getAttribute("filing_year");
	Member member=(Member)request.getSession().getAttribute("user");
	String username=member.getUserName().trim();
	String modusername=username.replaceAll("@", "-at-").trim();
	try {
		String start_pan=(String)request.getSession().getAttribute("start_pan");
		if(start_pan!=null){
			List<CompBankDetail> listcompbank=new ArrayList<CompBankDetail>();
			String path=ContentStructure.getBankDetailDocumentPath(start_pan,filing_year,modusername);
			MemberBankDetail objdocument=(MemberBankDetail)getObjectBeanManager(request).getObject(path);
			if(objdocument != null){
				listcompbank=objdocument.getBankDetailList();
				if(listcompbank!=null){
				    int size=listcompbank.size();
					String[] fetchaccnumber=new String[size];
					String[] fetchbrchname=new String[size];
					String[] fetchbaname=new String[size];
					String[] fetchecs=new String[size];
					String[] fetchmicr=new String[size];
					String[] fetchtypacc=new String[size];
					for(int i=0;i<listcompbank.size();i++){
						CompBankDetail objcmpbank=(CompBankDetail)listcompbank.get(i);
						fetchaccnumber[i]=objcmpbank.getBD_ACC_NUMBER();
						fetchbaname[i]=objcmpbank.getBD_BANK_NAME();
						fetchbrchname[i]=objcmpbank.getBD_ADD_BANK_BRANCH();
						fetchecs[i]=objcmpbank.getBD_ECS();
						fetchmicr[i]=objcmpbank.getBD_MICR_CODE();
						fetchtypacc[i]=objcmpbank.getBD_TYPE_ACC();
					}			
					JSONObject objFetchValue = null;			
					JSONArray objArray = new JSONArray();				 
					for(int p=0;p<fetchaccnumber.length;p++){
						objFetchValue = new JSONObject();
						objFetchValue.put("BankName",fetchbaname[p]);
						objFetchValue.put("MICR_code",fetchmicr[p]);
						objFetchValue.put("Address",fetchbrchname[p]);
						if(fetchtypacc[p].matches("SAV")){
							fetchtypacc[p]="Saving";
						}else{
							fetchtypacc[p]="Current";
						}
						objFetchValue.put("TypeAccount",fetchtypacc[p]);
						objFetchValue.put("AccountNO",fetchaccnumber[p]);
						if(fetchecs[p].matches("Y")){
							fetchecs[p]="YES";
						}else{
							fetchecs[p]="NO";
						}
						objFetchValue.put("ECS",fetchecs[p]);
						log.info(objFetchValue.toString());
						objArray.put(p, objFetchValue);
						log.info("the new json object is"+objFetchValue);
						log.info("final:"+objArray.toString());
						request.setAttribute("objArray", objArray);
						request.setAttribute("objFetchValue", objFetchValue);
					}
				}
			}
		}
	}catch (JSONException jsonEx){
		log.warn("jsonEx:::"+jsonEx);
	}
	catch (ObjectBeanManagerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
*/

/*public void doActionOld(HstRequest request, HstResponse response)
		throws HstComponentException {
	// TODO Auto-generated method stub
	super.doAction(request, response);
	String pan=getPublicRequestParameter(request,"pan");
	if(pan!=null){
		String uuid=getPublicRequestParameter(request,"uuid");
		String val_BankName;  // declaration of variables
		String val_MICR_code;
		String val_TypeAccount;
		String val_Address;
		String val_AccountNO;
		String val_ecs;
		String sDataTable = getPublicRequestParameter(request, "hidDataTable");// to get values from hidden variable
		log.info(sDataTable);
		try{
			JSONArray objJsonDT = new JSONArray(sDataTable.trim());
			int index=objJsonDT.length();            
			//  Declaration of array
			log.warn("objJsonDT:-"+objJsonDT);
			List<CompBankDetail> listcompbank=new ArrayList<CompBankDetail>();
			for(int n = 0; n < objJsonDT.length(); n++)
			{
				CompBankDetail compDetail=new CompBankDetail();
				JSONObject jsonelements = objJsonDT.getJSONObject(n);        // fetching json object from json array   
				// to take the separate values of variables from 
				val_BankName =  jsonelements.getJSONObject("_oData").getString("BankName");
				val_MICR_code = jsonelements.getJSONObject("_oData").getString("MICR_code");
				val_Address = jsonelements.getJSONObject("_oData").getString("Address");
				val_TypeAccount = jsonelements.getJSONObject("_oData").getString("TypeAccount");
				if(val_TypeAccount.matches("Saving")){
					val_TypeAccount="SAV";
				}else{
					val_TypeAccount="CUR";
				}
				val_AccountNO = jsonelements.getJSONObject("_oData").getString("AccountNO");
				val_ecs = jsonelements.getJSONObject("_oData").getString("ECS");
				if(val_ecs.matches("YES")){
					val_ecs="Y";
				}else{
					val_ecs="N";
				}
                 compDetail.setBD_ACC_NUMBER(val_AccountNO);
                 compDetail.setBD_ADD_BANK_BRANCH(val_Address);
                 compDetail.setBD_BANK_NAME(val_BankName);
                 compDetail.setBD_ECS(val_ecs);
                 compDetail.setBD_MICR_CODE(val_MICR_code);
                 compDetail.setBD_TYPE_ACC(val_TypeAccount);
                 listcompbank.add(compDetail);
			}
			// here creating an object td which is used to set values in creating form
			MemberBankDetail td = new MemberBankDetail();                
			td.setBankDetailList(listcompbank);
			createMemberBankDetailForm(request,td,pan);
			try {
				response.sendRedirect(UrlUtility.MemberfrontPage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(JSONException jsonEx){
			log.warn("Exception thrown by Json Object",jsonEx);
		}	  
	}
}
/**
 * Method to Create & Update the Member Bank Detail Document
 * @param HstRequest
 * @param String
 * @return String returns the form to create method.
 * @throws 
 * @author Priyank
 */
/*private MemberBankDetail createMemberBankDetailForm(HstRequest request, MemberBankDetail td,String pan) {
	// TODO Auto-generated method stub
	Session persistableSession = null;
	WorkflowPersistenceManager wpm;
	try {
		persistableSession = getPersistableSession(request);
		wpm = getWorkflowPersistenceManager(persistableSession);
		//SIMPLE WORKFLOW
		wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
		/*Create the path to Save Document in the Repository
		 * */
	/*	Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		String filing_year=(String)request.getSession().getAttribute("filing_year");
		final String memberFolderPath =ContentStructure.getMemberOriginalFilingPath(request, pan,filing_year,username);
		final String updatememberFolderPath =ContentStructure.getBankDetailDocumentPath(pan,filing_year,modusername);
		log.warn(updatememberFolderPath);
		log.warn(memberFolderPath);
		/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
		 * NAMESPACE determine the Type of Node with Document Template
		 * Also return the path of that Document
		 * */
		/*MemberBankDetail updatememberBankDetaildocument = (MemberBankDetail) wpm.getObject(updatememberFolderPath);
		if(updatememberBankDetaildocument==null){
		final String itReturnPath = wpm.createAndReturn(memberFolderPath, MemberBankDetail.NAMESPACE ,  MemberBankDetail.NODE_NAME, true);
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
		/*
		 * MemberBankDetail
		 *getObject method get the object at passed path in Repository.
		 * */
	/*	MemberBankDetail memberBankDetaildocument = (MemberBankDetail) wpm.getObject(itReturnPath);
		// update content properties
		if (memberBankDetaildocument != null) {
			memberBankDetaildocument.setBankDetailList(td.getBankDetailList());
			wpm.update(memberBankDetaildocument);
			return memberBankDetaildocument;
		} else {
			log.warn("Failed to add membership document for '{}': could not retrieve Review bean for node '{}'.", MemberBankDetail.NODE_NAME, itReturnPath);
			GoGreenUtil.refreshWorkflowManager(wpm);
			return memberBankDetaildocument;
		}
	}else{
		updatememberBankDetaildocument.setBankDetailList(td.getBankDetailList());
        wpm.update(updatememberBankDetaildocument);
        return updatememberBankDetaildocument;
	}
	}catch (ObjectBeanPersistenceException e) {
		log.warn("Failed to create a review for Bank detail '" + "----- IT RETURN ------" + "'", e);
		return null;
	} catch (ObjectBeanManagerException e) {
		log.warn("Failed to create a review for Bank detail'" + "----- IT RETURN ------" + "'", e);
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
	*/
}
