/*
 * In this class we are creating a document for storing value of schedule ESR
 * according to form 16.
 * @author abhishek
 * 10/09/2013
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
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.components.ITReturnComponent;

@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={})

public class ScheduleDEP extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ScheduleDEP.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		if(log.isInfoEnabled()){
			log.info("this is do before of schedule ESR");
		}

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

	}

}
