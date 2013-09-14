package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.ScheduleAMTCDocument;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=ScheduleAMTCDocument.class)
@FormFields(fieldNames={"taxUndSec115JC","taxUnderOtherProv","taxAgainstCredit","amtCreditGross","amtCreditSetOff","amtCreditBrghtFwrd","amtCreditUnlisted",
		"amtCreditCarriedFwrd","liabAvailCredit","unlistCreditUndSec115JD"})
public class ITRScheduleAMTC extends ITReturnComponent{

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
