/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 *
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
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.components.ITReturnComponent;
@PrimaryBean(primaryBeanClass=SalaryIncomeDocument.class)
@ChildBean(childBeanClass=SalaryIncomeDetail.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@RequiredFields(fieldNames={"Name_employer","Employe_category","Pan_employee","Name_employee","Cityslry","Stateslry","Addressslry","Pinslry","Gross_salary"})
@FormFields(fieldNames={"Employe_category","Name_employer","Name_employee","Pan_employer","Tan_employer","Pan_employee","Addressslry",
		"Cityslry","Stateslry","Pinslry","From","To","Gross_salary","Allowance","Allowance1","Perquisite","profit","Taxable_earning","tdspension"})
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



public class SalaryIncome extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(SalaryIncome.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		//String date1= ContentStructure.getMemberAssetDocPath(, filing_year, getUserName());

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

	}

}
