package com.mootly.wcm.member;
import org.apache.commons.logging.Log;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.GoGreenUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;

/**

 * @author:Pankaj Singh
 * Date: 3/6/2013
 * Description: This take data from the form of capital asset and put it into bean
 *
 */
@PrimaryBean(primaryBeanClass=RebateSec90Document.class)
@FormFields(fieldNames= {"userCountry","taxPaidForeignCountry","incomeForeignCountry","txttotaltax","section91","section89"})
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,SalaryIncomeDocument.class,HouseProperty.class,OtherSourcesDocument.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})




public class RebateSec90 extends ITReturnComponent {
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		
		super.doBeforeRender(request, response);
		// to find eithr user lies in section 90 or 91
		//String isSection91=getParameter("isSection91", request);
		
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		
		
	}
	
}


