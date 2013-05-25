/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.component.support.forms.StoreFormResult;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITReturnHomePageView;
import com.mootly.wcm.model.ITReturnType;
//@PrimaryBean(primaryBeanClass=MemberPersonalInformation.class)
@FormFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type","fy"})
@RequiredFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type","fy"})
public class ITReturnHomePage extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ITReturnHomePage.class);

	@SuppressWarnings("unchecked")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);			
		if (getPanFolder()!= null) {
			//get all PANs for this member
			List<ITReturnHomePageView> listOfITReturnHomePageView = new ArrayList<ITReturnHomePageView>();
			List<HippoFolderBean> pansForMember = getPanFolder().getFolders(); //.compareTo(hippoBean).getChildBeans(HippoFolder.class);
			if (pansForMember != null) {
				for (HippoFolderBean hippoFolderBean:pansForMember) {
					ITReturnHomePageView itReturnHomePageView = new ITReturnHomePageView();
					itReturnHomePageView.setPan(hippoFolderBean.getName());
					List<HippoFolderBean> listOfFY = hippoFolderBean.getChildBeans(HippoFolderBean.class);
					for (HippoFolderBean aFYBean:listOfFY) {
						FinancialYear fy = FinancialYear.getByDisplayName(aFYBean.getName());
						itReturnHomePageView.setFinancialYear(fy);
						List<HippoFolderBean> listOfItReturnTypes = aFYBean.getChildBeans(HippoFolderBean.class);
						for (HippoFolderBean aItReturnType:listOfItReturnTypes){
							ITReturnType itReturnType = ITReturnType.getByDisplayName(aItReturnType.getName());
							itReturnHomePageView.setItReturnType(itReturnType);
							MemberPersonalInformation memberPersonalInformation = aItReturnType.getBean("memberpersonalinformation");
							if (memberPersonalInformation != null) {
								itReturnHomePageView.setLastOrOrgName(memberPersonalInformation.getLastName());
							}
						}
					}
					listOfITReturnHomePageView.add(itReturnHomePageView);
				}
				request.setAttribute("listOfITReturnHomePageView", listOfITReturnHomePageView);			
			}
		}
		String reqFormJson=getPublicRequestParameter(request, "data");
		String validation=getPublicRequestParameter(request, "validation");
		if(reqFormJson!=null&&validation!=null){
			try {
				JSONObject formJson=new JSONObject(reqFormJson);
					if(formJson.getString("pan").length()!=0&&formJson.getString("pi_last_name").length()!=0){
						char pan5thChar=formJson.getString("pan").toLowerCase().charAt(4);
						char lastName1stChar=formJson.getString("pi_last_name").toLowerCase().charAt(0);
						if(pan5thChar!=lastName1stChar){
							response.setHeader("myHeader", "error");
						}else{
							response.setHeader("myHeader", "success");
						}
					}
					/*char tanpanChar=' ';
					Iterator<String> itr= formJson.keys();
					List<String> fieldlist=new ArrayList<String>();
					while(itr.hasNext()) fieldlist.add(itr.next());
					if(fieldlist.size()==2){
						if(formJson.getString(fieldlist.get(0))!=null&&formJson.getString(fieldlist.get(1))!=null){
							if(validation.matches("pan")) tanpanChar =formJson.getString(fieldlist.get(0)).toLowerCase().charAt(4);
							else tanpanChar =formJson.getString(fieldlist.get(0)).toLowerCase().charAt(3);
							char name1stChar=formJson.getString(fieldlist.get(1)).toLowerCase().charAt(0);
							if(tanpanChar!=name1stChar){
								response.setHeader("myHeader", "error");
							}else{
								response.setHeader("myHeader","success");
							}
						}						
					}**/
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		//super.doAction(request, response);
		//FormMap map = new FormMap(request,new String[]{"pan","pi_last_name","pi_dob","pi_return_type","fy","ack_no","ack_date","defective","notice_no","notice_date"});
		FormMap map = new FormMap(request,new String[]{"pan","pi_last_name","pi_dob","pi_return_type","fy"});
		//FormUtils.persistFormMap(request, response, getFormMap(), null);
		//try {
		String pan =map.getField("pan").getValue().toLowerCase();
		String strItReturnType =  map.getField("pi_return_type").getValue();
		ITReturnType itReturnType = ITReturnType.getByDisplayName(strItReturnType);
		String strFinancialYear =  map.getField("fy").getValue();
		FinancialYear financialYear = FinancialYear.getByDisplayName(strFinancialYear);

		if (StringUtils.isEmpty(pan) || StringUtils.isEmpty(strItReturnType) || StringUtils.isEmpty(strFinancialYear)){
			return;
		}

		if (itReturnType == null || itReturnType.equals(ITReturnType.UNKNOWN) || financialYear == null || financialYear.equals(FinancialYear.UNKNOWN)){
			return;
		}
		if (!DataTypeValidationHelper.isOfType(pan, DataTypeValidationType.PAN)) {
			return;
		}

		StoreFormResult sfr = new StoreFormResult();				
		FormUtils.persistFormMap(request, response, map, sfr);
		//FormUtils.persistFormMap(request, response, getFormMap(), sfr);
		String returnURL =  request.getContextPath() +"/member/itreturn/" + financialYear.getDisplayName() + "/" + itReturnType.getDisplayName() + "/" + pan.toLowerCase() + "/servicerequest-itr.html?uuid=" +  sfr.getUuid(); //getRedirectURL(request, response, FormSaveResult.SUCCESS,"packageselector",financialYear,itReturnType,pan);
		//returnURL +="?uuid=" + 
		try {
			response.sendRedirect(returnURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//} catch (IOException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
