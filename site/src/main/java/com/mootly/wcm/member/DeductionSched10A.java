package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.DeductionSchedTenADetail;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=DeductionSchedTenADocumemt.class)
@ChildBean(childBeanClass=DeductionSchedTenADetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"scheduleName","amount"})
@RequiredFields(fieldNames={"scheduleName","amount"})
public class DeductionSched10A extends ITReturnComponent{
	
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
