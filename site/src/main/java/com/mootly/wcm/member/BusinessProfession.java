package com.mootly.wcm.member;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.BusinessProfessionDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SchFourtyFourAEDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.services.IndianCurrencyHelper;

@PrimaryBean(primaryBeanClass=BusinessProfessionDocument.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@AdditionalBeans(additionalBeansToLoad={SchFourtyFourAEDocument.class})
@FormFields(fieldNames={"grossTurnOver","grossPresumptIncome","incChargBusiness","grossSundryDebt","grossSundryCredit","grossStockTrade","grossCashBalance"})
@DataTypeValidationFields(dataTypes={DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL,DataTypeValidationType.DECIMAL},
		fieldNames={"grossTurnOver","grossPresumptIncome","incChargBusiness","grossSundryDebt","grossSundryCredit","grossStockTrade","grossCashBalance"})
public class BusinessProfession extends ITReturnComponent {

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		request.setAttribute("exceedErrorGrossTurnOver", request.getParameter("exceedErrorGrossTurnOver"));
		SchFourtyFourAEDocument schFourtyFourAEDocument = (SchFourtyFourAEDocument) request.getAttribute(SchFourtyFourAEDocument.class.getSimpleName().toLowerCase());
		if(schFourtyFourAEDocument!=null){
			request.setAttribute("schFourtyFourAEDocument", schFourtyFourAEDocument);
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

	@Override
	protected boolean validate(HstRequest request, HstResponse response,
			FormMap formMap) {
		// TODO Auto-generated method stub
		if(super.validate(request, response, formMap)){
			Double grossTurnOver = Double.parseDouble(formMap.getField("grossTurnOver").getValue());
			Double grossPresumptIncome = Double.parseDouble(formMap.getField("grossPresumptIncome").getValue());
			IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
			Double eightPerCOfGrossTurnOver = indianCurrencyHelper.RoundTo2Decimals(grossTurnOver*0.08);
			if(grossPresumptIncome < eightPerCOfGrossTurnOver){
				formMap.getField("grossPresumptIncome").addMessage("busi.prof.exceed.grosturnover.itr4");
				response.setRenderParameter("exceedErrorGrossTurnOver", "busi.prof.exceed.grosturnover.itr4");
				return false;
			}
		}
		return super.validate(request, response, formMap);
	}
}
