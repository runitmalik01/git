/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author Abhishek
 * 01/09/2013
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
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.compound.TcsDetail;
import com.mootly.wcm.components.ITReturnComponent;
@PrimaryBean(primaryBeanClass=TcsDocument.class)
@ChildBean(childBeanClass=TcsDetail.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@RequiredFields(fieldNames={"tan","name","totaltax"})
@FormFields(fieldNames={"tan","name","totaltax","taxCredited","isImportedFromDIT"})
@DataTypeValidationFields(fieldNames={
		"tan",
		"totaltax","amtCredited"

},
dataTypes= {
		DataTypeValidationType.TAN, //Gross_salary
		DataTypeValidationType.DECIMAL,
		DataTypeValidationType.DECIMAL,

}
		)



public class Tcs extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(Tcs.class);

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
