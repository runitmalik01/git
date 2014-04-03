package com.mootly.wcm.components.otp;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.OTPResponseDocument;
import com.mootly.wcm.beans.compound.OTPResponseDocumentDetail;
import com.mootly.wcm.components.ITReturnComponent;

/**
 * OTPSecurity will intercept all Components secured by OTP
 * @author Amit
 *
 */
@PrimaryBean(primaryBeanClass=OTPResponseDocument.class)
@ChildBean(childBeanClass=OTPResponseDocumentDetail.class)
public class OTPSecurity extends ITReturnComponent {
	
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
