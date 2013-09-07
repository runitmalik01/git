package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=TdsFromSalaryDocument.class)
@ChildBean(childBeanClass=TdsFromSalaryDetail.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"tan_employertds","name_employertds","income_chargeabletds","total_taxdeductedtds"})
@DataTypeValidationFields(fieldNames={"tan_employer"},dataTypes={DataTypeValidationType.TAN})
public class TdsFromSalary extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		System.out.println("this is do before render of tds from salary");
	
	String reqFormJson=getPublicRequestParameter(request, "data");
	String validation=getPublicRequestParameter(request, "validation");
	if(reqFormJson!=null&&validation!=null){
		try {
			JSONObject formJson=new JSONObject(reqFormJson);
				if(formJson.getString("tan_employertds").length()!=0&&formJson.getString("name_employertds").length()!=0){
					char pan5thChar=formJson.getString("tan_employertds").toLowerCase().charAt(3);
					char lastName1stChar=formJson.getString("name_employertds").toLowerCase().charAt(0);
					System.out.println("lastName1stChar"+lastName1stChar);
					System.out.println("pan5thChar"+pan5thChar);
					if(pan5thChar!=lastName1stChar){
						response.setHeader("myHeader", "error");
					}else{
						response.setHeader("myHeader", "success");
					}
				}}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		System.out.println("this is do Action of tds from salary");
	} }
	
	
	

