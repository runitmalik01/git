package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.AssetAndLiabilityDocument;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Megha Agarwal
 * Date:
 * Description
 */
@PrimaryBean(primaryBeanClass=AssetAndLiabilityDocument.class)
@FormFields(fieldNames={"land","building","deposit_Bank","shares","insurance","loans_Adv",
		"cash","jewellery","drawing","vehicles","total","liability"
})

public class AssetAndLiability extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(AssetAndLiability.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of schedule AL");
		}
		
	
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do action of schedule AL");
		}
		
	} }
	
	
	

