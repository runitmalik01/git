package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.compound.TaxReliefDetail;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=TaxReliefDocument.class)
@ChildBean(childBeanClass=TaxReliefDetail.class)
@FormFields(fieldNames={"country_code","tax_ID","article_dtaa","totaltax_fsi","relief90_91","relief91","country_name","taxPaidDtaa","isDtaaCountry","dtaa_CountryTax","Nodtaa_CountryTax"})



public class TaxRelief extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of tax relief");
		}

	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of tax relief");
		}

	} }




