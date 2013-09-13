/*
 * 
 * 
 * @author :Pankaj
 * 
 *
 *
 */

package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.compound.ScheduleDPMDetails;
import com.mootly.wcm.components.ITReturnComponent;
@PrimaryBean(primaryBeanClass=ScheduleDPMDocument.class)
@ChildBean(childBeanClass=ScheduleDPMDetails.class)
@FormFields(fieldNames={"rates","valFirstDayPrevYr","periodMore180Day","prevYrConsider","amtDepreciationFullRate","periodLess180Day","considerOrRealDuringYr",
		"halfRateDepreciation","considerOrRealDuringYr","amtDepreciationHalfRate","depreciationFullRate","depreciationHalfRate","addDepreciatMore180Day","addDepreciatLess180Day",
		"totalDepreciation","expense_TransferAsset","capitalGain_LossSec50","valLastDayPrevYr"})

public class SchedDPM extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(SchedDPM.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		if(log.isInfoEnabled()){
			log.info("this is do before of schedule DPM");
		}

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do action of schedule DPM");
		}

	}

}
