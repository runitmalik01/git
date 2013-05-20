/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;

import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScreenCalculation;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.services.ScreenCalculatorService;
@PrimaryBean(primaryBeanClass=SalaryIncomeDocument.class)
@ChildBean(childBeanClass=SalaryIncomeDetail.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@RequiredFields(fieldNames={"Name_employer","Tan_employer","City","Gross_salary"})
@DataTypeValidationFields(fieldNames={
		"Gross_salary",
		"Allowance",
		"Allowance1",
		"Perquisite",
		"Profit",
		"Taxable_earning",
		"Tan_employer",
		"Pan_employer",
		"Pan_employee",
		"From",
		"To"
},
dataTypes= {
		DataTypeValidationType.DECIMAL, //Gross_salary
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.TAN,
		DataTypeValidationType.PAN,
		DataTypeValidationType.PAN,
		DataTypeValidationType.INDIANDATE,
		DataTypeValidationType.INDIANDATE
}
		)

@FormFields(fieldNames={"Employe_category","Name_employer","Name_employee","Pan_employer","Tan_employer","Pan_employee","Addressslry",
		"Cityslry","Stateslry","Pinslry","From","To","Gross_salary","Allowance","Perquisite","profit","Taxable_earning"})

public class SalaryIncome extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(SalaryIncome.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);	
		String isCalc = getPublicRequestParameter(request,"command");
		if (isCalc != null && isCalc.equals("calc")) {
			String pathToScreenCalc = "configuration/screencalculation/" + this.getClass().getSimpleName().toLowerCase();
			HippoBean siteContentBaseBean=(HippoBean)request.getAttribute("siteContentBaseBean");
			ScreenCalculation screencalc=siteContentBaseBean.getBean(pathToScreenCalc, ScreenCalculation.class);
			Map<String,Object> resultSet = ScreenCalculatorService.getScreenCalculations(screencalc.getScript(), request.getParameterMap(""), null);
			if (resultSet != null) {
				log.info("get the result");
				request.setAttribute("resultSet", resultSet);
				JSONObject jsonObject  = new JSONObject(resultSet);
				log.info("get the json object"+jsonObject.toString());
				request.setAttribute("jsonObject", jsonObject);
				//response.setContentType("application/json");
				response.setRenderPath("jsp/common/calculation_response.jsp");
			}
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
