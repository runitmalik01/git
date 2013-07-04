/**

 * @author:Megha Agarwal
 * Date: 3/6/2013
 * Description: This take data from the form of houseincome and put it into bean
 *
 */
package com.mootly.wcm.member;

import java.util.Map;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.ScreenCalculation;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.services.ScreenCalculatorService;

@PrimaryBean(primaryBeanClass=HouseProperty.class)
@ChildBean(childBeanClass=HouseIncomeDetail.class)
@FormFields(fieldNames={"Address","Tenant_pan","Pin","Tenant_name","share1","coownerpan1","coownername1","share2","coownerpan2",
		"coownername2","share3","coownerpan3","coownername3","share4","coownerpan4","coownername4","share5","coownerpan5","coownername5",
		"City","states","Coowned","letout","Letable_value","Unrealised_rent","Local_tax","Total","Balance","Interest_borrowed","Income_hproperty","Property_share"})
//@RequiredFields(fieldNames={"Gross_Annual_Income","Unrealised_Rent","Local_Taxes","Interest_Borrowed2","Interest_Borrowed1"})
@RequiredFields(fieldNames={"Pin","Address","City","states","letout"})
@DataTypeValidationFields(fieldNames={
		  "Letable_value",
		  "Unrealised_rent",
		  "Local_tax",
		  "Total",
		  
		  "Tenant_pan"
	},
dataTypes= {
		  DataTypeValidationType.DECIMAL, 
		  DataTypeValidationType.DECIMAL,
		  DataTypeValidationType.DECIMAL,
		  DataTypeValidationType.DECIMAL,
		  
		  DataTypeValidationType.PAN
	 }
)
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


