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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.datanucleus.store.exceptions.DatastoreValidationException;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.component.support.forms.StoreFormResult;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.component.HstURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.FormSaveResult;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITReturnType;

@FormFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type","fy"})
@RequiredFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type","fy"})
public class ITReturnHomePage extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(ITReturnHomePage.class);

	@SuppressWarnings("deprecation")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);			
		if (getPanFolder()!= null) {
			//get all PANs for this member
			List<HippoFolderBean> pansForMember = getPanFolder().getFolders(); //.compareTo(hippoBean).getChildBeans(HippoFolder.class);
			if (pansForMember != null) request.setAttribute("pansForMember", pansForMember);			
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		//super.doAction(request, response);
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
		String returnURL = getRedirectURL(request, response, FormSaveResult.SUCCESS,"packageselector",financialYear,itReturnType,pan);
		returnURL +="?uuid=" + sfr.getUuid();
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
