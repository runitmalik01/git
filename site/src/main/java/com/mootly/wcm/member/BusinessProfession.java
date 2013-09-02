package com.mootly.wcm.member;

import java.util.List;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.BusinessProfessionDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=BusinessProfessionDocument.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
//@AdditionalBeans(additionalBeansToLoad={SchFourtyFourAEDocument.class})
@FormFields(fieldNames={"grossTurnOver","grossPresumptIncome","incChargBusiness","grossSundryDebt","grossSundryCredit","grossStockTrade","grossCashBalance"})
@DataTypeValidationFields(dataTypes={DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL},
        fieldNames={"grossTurnOver","grossPresumptIncome","incChargBusiness","grossSundryDebt","grossSundryCredit","grossStockTrade","grossCashBalance"})
public class BusinessProfession extends ITReturnComponent {

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		//SchFourtyFourAEDocument schFourtyFourAEDocument = (SchFourtyFourAEDocument) request.getAttribute(SchFourtyFourAEDocument.class.getSimpleName().toLowerCase())
		//request.setAttribute("schFourtyFourAEDocument", schFourtyFourAEDocument);
	}


	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
