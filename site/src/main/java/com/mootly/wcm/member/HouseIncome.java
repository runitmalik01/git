/**

 * @author:Megha Agarwal
 * Date: 3/6/2013
 * Description: This take data from the form of houseincome and put it into bean
 *
 */
package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=HouseProperty.class)

@ChildBean(childBeanClass=HouseIncomeDetail.class)
@FormFields(fieldNames={"Gross_Annual_Income","Unrealised_Rent","Local_Taxes","Interest_Borrowed2","Interest_Borrowed1","Income_Hproperty","Total_Income","Let_Out"})
//@RequiredFields(fieldNames={"Gross_Annual_Income","Unrealised_Rent","Local_Taxes","Interest_Borrowed2","Interest_Borrowed1"})
public class HouseIncome extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(HouseIncome.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}


