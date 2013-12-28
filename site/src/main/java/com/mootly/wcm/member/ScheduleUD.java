/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 *
 *
 */

package com.mootly.wcm.member;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.UnabsorbedDepreciationDocument;
import com.mootly.wcm.beans.compound.UnabsorbedDepreciationDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.schedules.y2012_2013.CurrentYearLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4_ScheduleUD;
@PrimaryBean(primaryBeanClass=UnabsorbedDepreciationDocument.class)
@ChildBean(childBeanClass=UnabsorbedDepreciationDetail.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"assessYear","amtUaDep"})

public class ScheduleUD extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ScheduleUD.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		// to take values from Schedule of UD
		Map<String, HippoBean> inputBeans = loadBeansAndSetRequestAttributes(request, response);
		
		UnabsorbedDepreciationDocument unabsorbedDepreciationDocument = (UnabsorbedDepreciationDocument) request.getAttribute(UnabsorbedDepreciationDocument.class.getSimpleName().toLowerCase());
		if(unabsorbedDepreciationDocument != null){
			ITR4_ScheduleUD iTR4_ScheduleUD = new ITR4_ScheduleUD(unabsorbedDepreciationDocument);	
			if(iTR4_ScheduleUD != null){
				ITR itr = new ITR();
				request.setAttribute("listofValuesDep", iTR4_ScheduleUD.getITR4ScheduleUD(itr, getFinancialYear(), inputBeans).getScheduleUD());
				request.setAttribute("totalCarryFwdAmt", iTR4_ScheduleUD.getITR4ScheduleUD(itr, getFinancialYear(), inputBeans).getTotalBalCFNY());
			}
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
	// getting the values form Schedule BFLA for setting off the value
	public Double getAttributeForDepreciation(HstRequest request, HstResponse response){
			Map<String, HippoBean> inputBeans= loadBeansAndSetRequestAttributes(request,response);
		// BroughtFwdLossesSchedules objBFL = new BroughtFwdLossesSchedules();
		ITR itr = new ITR();
		// ScheduleBFLA scheduleBFLA = objBFL.getScheduleBFLA(itr, getFinancialYear(), inputBeans);
		CurrentYearLossesSchedules currentYearLossesSchedules = new CurrentYearLossesSchedules();
		ScheduleCYLA scheduleCYLA = currentYearLossesSchedules.getScheduleCYLA(itr, getFinancialYear(), inputBeans);
		BigInteger maxAmountDepreciation =  scheduleCYLA.getHP().getIncCYLA().getIncOfCurYrAfterSetOff().add(scheduleCYLA.getBusProfExclSpecProf().getIncCYLA().getIncOfCurYrAfterSetOff()).add(scheduleCYLA.getSpeculativeInc().getIncCYLA().getIncOfCurYrAfterSetOff())
				.add(scheduleCYLA.getSpecifiedInc().getIncCYLA().getIncOfCurYrAfterSetOff()).add(scheduleCYLA.getSTCG().getIncCYLA().getIncOfCurYrAfterSetOff()).add(scheduleCYLA.getLTCG().getIncCYLA().getIncOfCurYrAfterSetOff()).
				add(scheduleCYLA.getOthSrcExclRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff()).add(scheduleCYLA.getOthSrcRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff());
		return maxAmountDepreciation.doubleValue();
	}

	// this method is getting the value of assesment yr and amount from repository
	public TreeMap<String, Double> DepreciationAmountAndYear(UnabsorbedDepreciationDocument unabsorbedDepreciationDocument){
		TreeMap<String, Double> mapAssYearandAmt = new TreeMap<String, Double>();	
		if(unabsorbedDepreciationDocument != null){
			if(unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList() != null && unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList().size()>0){
				for(UnabsorbedDepreciationDetail UDDetail:unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList()){
					mapAssYearandAmt.put(UDDetail.getAssessYear(), UDDetail.getAmtUADepreciation());
				}
			}
		}
		return mapAssYearandAmt;
	}
// this method is doing all set off 
	public Map<String, Map<String, Double>> AdjustDepreciation(Double maxAmountforDepreciation,Map<String,Double> mapOfclaimedAmountDepreciation){
		Map<String, Map<String, Double>> mapDepreciationAmounts = new TreeMap<String,Map<String, Double>>();
		
		Double offeredDepreciation = 0d;
		Double carryFwdAmount = 0d;
		//Double opearionalAmount = maxAmountforDepreciation;
		if(!mapOfclaimedAmountDepreciation.isEmpty()){
			for(String mapKey:mapOfclaimedAmountDepreciation.keySet()){
				Map<String, Double> mapValuesDep = new TreeMap<String, Double>();
				if(maxAmountforDepreciation - mapOfclaimedAmountDepreciation.get(mapKey) > 0){
					offeredDepreciation =  mapOfclaimedAmountDepreciation.get(mapKey);
					carryFwdAmount = offeredDepreciation - mapOfclaimedAmountDepreciation.get(mapKey);
					maxAmountforDepreciation = maxAmountforDepreciation - offeredDepreciation;
				} else {
					offeredDepreciation = maxAmountforDepreciation;
					carryFwdAmount = mapOfclaimedAmountDepreciation.get(mapKey) - maxAmountforDepreciation ;
					maxAmountforDepreciation = maxAmountforDepreciation - offeredDepreciation;
				}
				mapValuesDep.put("offeredDepreciation", offeredDepreciation);
				mapValuesDep.put("carryFwdAmount", carryFwdAmount);
				
				mapDepreciationAmounts.put(mapKey, mapValuesDep);
				
			}
		}
		return mapDepreciationAmounts;
}
	}
