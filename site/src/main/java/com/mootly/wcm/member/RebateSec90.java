package com.mootly.wcm.member;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberDeductionScheduleVIA;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourceIncome;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SecuritiesDoc;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.member.Calculations;

/**

 * @author:Pankaj Singh
 * Date: 3/6/2013
 * Description: This take data from the form of capital asset and put it into bean
 *
 */
@PrimaryBean(primaryBeanClass=RebateSec90Document.class)
@FormFields(fieldNames= {"userCountry","taxPaidForeignCountry","incomeForeignCountry"})
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,SalaryIncomeDocument.class,HouseProperty.class,OtherSourcesDocument.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})




public class RebateSec90 extends ITReturnComponent {
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		// to find eithr user lies in section 90 or 91
	System.out.println("this is do before render  of rebate sec 90/91");
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		System.out.println("this is do Action  of rebate sec 90/91");
	}
	
}


