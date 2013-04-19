package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.SecuritiesDoc;
import com.mootly.wcm.beans.compound.SecuritiesComp;
import com.mootly.wcm.components.ITReturnComponent;

/**

 * @author:Pankaj Singh
 * Date: 3/6/2013
 * Description: This take data from the form of capital asset and put it into bean
 *
 */
@PrimaryBean(primaryBeanClass=SecuritiesDoc.class)
@ChildBean(childBeanClass=SecuritiesComp.class)


@FormFields(fieldNames={"hidDateAcquisition","cost_acquisition","hidDateSale","sale_consideration","inflation_acquisition","inflation_consideration","capital_gain"})
@RequiredFields(fieldNames={"hidDateAcquisition","cost_acquisition","hidDateSale","sale_consideration","inflation_acquisition","inflation_consideration","capital_gain"})

public class Securities extends ITReturnComponent {
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		
		System.out.println("this is do before render of securities ");
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		System.out.println("this is do Action securities");
	}
	
}


