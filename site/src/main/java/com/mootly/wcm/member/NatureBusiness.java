package com.mootly.wcm.member;


import java.util.TreeMap;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.NatureBusinessDocument;
import com.mootly.wcm.beans.compound.NatureBusinessDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.ValueListService;
import com.mootly.wcm.utils.ValueListServiceImpl;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=NatureBusinessDocument.class)
@ChildBean(childBeanClass=NatureBusinessDetail.class)
@FormFields(fieldNames={"business_name","business_code","tradeName_Proprietorship","tradeName_ProprietorshipSec","tradeName_ProprietorshipLast"})

public class NatureBusiness extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of Nature of Business for ITR4");
		}
		ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
		TreeMap<String,String> objHashMapBusinessCode=ObjValueListService.getBusinessCode();

		TreeMap<String,TreeMap<String, String>> catBusinessCode = new TreeMap<String,TreeMap<String, String>>();
		TreeMap<String,String> manufacturingIndustry = new TreeMap<String,String>();
		TreeMap<String,String> trading = new TreeMap<String,String>();
		TreeMap<String,String> commissionAgents = new TreeMap<String,String>();
		TreeMap<String,String> builders = new TreeMap<String,String>();
		TreeMap<String,String> contractors = new TreeMap<String,String>();
		TreeMap<String,String> professionals = new TreeMap<String,String>();
		TreeMap<String,String> serviceSector = new TreeMap<String,String>();
		TreeMap<String,String> financialServiceSector = new TreeMap<String,String>();
		TreeMap<String,String> entertainmentIndustry = new TreeMap<String,String>();
		TreeMap<String,String> none = new TreeMap<String,String>();

		for(String code : objHashMapBusinessCode.keySet()){
			if(Integer.parseInt(code) >= 101 && Integer.parseInt(code) <= 124){
				manufacturingIndustry.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) >= 201 && Integer.parseInt(code) <= 204){
				trading.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) == 301){
				commissionAgents.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) >= 401 && Integer.parseInt(code) <= 404){
				builders.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) >= 501 && Integer.parseInt(code) <= 505){
				contractors.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) >= 601 && Integer.parseInt(code) <= 607){
				professionals.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) >= 701 && Integer.parseInt(code) <= 714){
				serviceSector.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) >= 801 && Integer.parseInt(code) <= 809){
				financialServiceSector.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) >= 901 && Integer.parseInt(code) <= 906){
				entertainmentIndustry.put(code, objHashMapBusinessCode.get(code));
			}
			if(Integer.parseInt(code) >= 1001 && Integer.parseInt(code) <= 1001){
				none.put(code, objHashMapBusinessCode.get(code));
			}
		}

		catBusinessCode.put("Manufacturing Industry", manufacturingIndustry);
		catBusinessCode.put("Trading", trading);
		catBusinessCode.put("Commission Agents", commissionAgents);
		catBusinessCode.put("Builders", builders);
		catBusinessCode.put("Contractors", contractors);
		catBusinessCode.put("Professionals", professionals);
		catBusinessCode.put("Service Sector", serviceSector);
		catBusinessCode.put("Financial Service Sector", financialServiceSector);
		catBusinessCode.put("Entertainment Industry", entertainmentIndustry);
		catBusinessCode.put("None", none);

		request.setAttribute("catBusinessCode", catBusinessCode);

	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of Nature of Business for ITR4");
		}

	} 
}