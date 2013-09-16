/*
 * 
 * 
 * @author :Pankaj
 * 
 *
 *
 */

package com.mootly.wcm.member;

import java.util.List;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.compound.ScheduleDOADetails;
import com.mootly.wcm.beans.compound.ScheduleDPMDetails;
import com.mootly.wcm.components.ITReturnComponent;
@PrimaryBean(primaryBeanClass=ScheduleDOADocument.class)
@ChildBean(childBeanClass=ScheduleDOADetails.class)
@FormFields(fieldNames={"rates","valFirstDayPrevYr","periodMore180Day","prevYrConsider","amtDepreciationFullRate","periodLess180Day","considerOrRealDuringYr",
		"halfRateDepreciation","considerOrRealDuringYr","amtDepreciationHalfRate","depreciationFullRate","depreciationHalfRate","addDepreciatMore180Day","addDepreciatLess180Day",
		"totalDepreciation","expense_TransferAsset","capitalGain_LossSec50","valLastDayPrevYr"})

public class SchedDOA extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(SchedDOA.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		if(log.isInfoEnabled()){
			log.info("this is do before of schedule DOA");
		}
		request.setAttribute("stopPuttingSameRate", request.getParameter("stopPuttingSameRate"));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do action of schedule DOA");
		}
		
	}
	@Override
	public boolean validate(HstRequest request, HstResponse response,
			FormMap formMap) {
		if(super.validate(request, response, formMap)){
			ScheduleDOADocument objScheduleDOADocument = (ScheduleDOADocument) getParentBean();
			List<ScheduleDOADetails> listScheduleDOADetails = objScheduleDOADocument.getScheduleDOADetailList();
			if((objScheduleDOADocument != null) && (objScheduleDOADocument.getScheduleDOADetailList().size() > 0)){
				for(ScheduleDOADetails scheduleDOADetails :listScheduleDOADetails ){
				String existingRate = scheduleDOADetails.getRates();
				String newArrivingRate = formMap.getField("rates").getValue();
				if(existingRate.equals(newArrivingRate)){
					formMap.addMessage("rates", "error.not.samerate.itr4.dpm");
					response.setRenderParameter("stopPuttingSameRate", "error.not.samerate.itr4.dpm");
					return false;
				}
					
				}
				
			}
			
		}
		return super.validate(request, response, formMap);
	}


}