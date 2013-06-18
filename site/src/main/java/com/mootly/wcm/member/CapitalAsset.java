package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;

import com.mootly.wcm.components.ITReturnComponent;

/**

 * @author:Abhishek Bhardwaj
 * Date: 3/6/2013
 * Description: This take data from the form of capital asset and put it into bean
 *
 */
@PrimaryBean(primaryBeanClass=CapitalAssetDocument.class)
@ChildBean(childBeanClass=CapitalAssetDetail.class)
@FormFields(fieldNames={"date_acquisition","cost_acquisition","date_sale","sale_consideration",
		"inflation_acquisition","inflation_consideration","indexed_price","capital_gain","name_asset","cost_improvement","sst_charge","asset_type"})
public class CapitalAsset extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(CapitalAsset.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of capital asset");
		}
		System.out.println();
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		System.out.println("this is do Action capital asset");
	}
	
}


