package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.DeemedCapitalGainDocument;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Megha Agarwal
 * Date:
 * Description
 */
@PrimaryBean(primaryBeanClass=DeemedCapitalGainDocument.class)
@FormFields(fieldNames={"ratefifteen","ratethirty","rateforty","ratefifty","ratesixty","rateeighty",
		"ratehundred","total","ratefive","rateten","hundred","total1","furniture","intangible","ships","total2"
})


public class DeemedCapitalGain extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(DeemedCapitalGain.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of schedule DCG");
		}
		
	
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do action of schedule DCG");
		}
		
	} }
	
	
	

