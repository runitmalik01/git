package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.ManufactureRawMatDocument;
import com.mootly.wcm.beans.compound.ManufactureRawMatDetail;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:
 */
@PrimaryBean(primaryBeanClass=ManufactureRawMatDocument.class)
@ChildBean(childBeanClass=ManufactureRawMatDetail.class)
@FormFields(fieldNames={"itemUnit_Code","itemUnit_Name","opening_Stock","purchage","consumption","sales","closing_Stock","yield_finishedProd","shortage_IfAny","percentage_Yield","item_Name"})



public class Manufacture_RawMaterials extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of manufacturing:raw materials");
		}

	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of  manufacturing:raw materials");
		}

	} }



