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
import java.util.List;

import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.components.FormSaveResult;
import com.mootly.wcm.components.ITReturnComponent;

@FormFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type"})
@RequiredFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type"})

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
		super.doAction(request, response);
		FormUtils.persistFormMap(request, response, getFormMap(), null);
		try {
			String pan = getFormMap().getField("pan").getValue().toLowerCase();
			String itReturnType =  getFormMap().getField("pi_return_type").getValue();
			String returnURL = getRedirectURL(request, response, FormSaveResult.SUCCESS,"start-application-basic",itReturnType,pan);
			response.sendRedirect(returnURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
