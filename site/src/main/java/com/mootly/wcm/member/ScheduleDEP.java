/*
 * In this class we are creating a document for storing value of schedule ESR
 * according to form 16.
 * @author abhishek
 * 10/09/2013
 *
 *
 */

package com.mootly.wcm.member;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.compound.ScheduleDPMDetails;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.schedules.y2012_2013.ITR_ScheduleDEP;


@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={})
@AdditionalBeans(additionalBeansToLoad={ScheduleDPMDetails.class,ScheduleDOADocument.class})
public class ScheduleDEP extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ScheduleDEP.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		if(log.isInfoEnabled()){
			log.info("this is do before of schedule ESR");
		}
		
		ScheduleDOADocument scheduleDOADocument = (ScheduleDOADocument) request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase());
		ScheduleDPMDocument scheduleDPMDocument = (ScheduleDPMDocument) request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase());
		ITR_ScheduleDEP objITR_ScheduleDEP = new ITR_ScheduleDEP(scheduleDPMDocument, scheduleDOADocument);
		ITR itr = new ITR();
		// for asset type is building
		long build_5Per =  objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getBuildingSummary().getDeprBlockTot5Percent().longValue();
		long build_10Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getBuildingSummary().getDeprBlockTot10Percent().longValue();
		long buid_100Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getBuildingSummary().getDeprBlockTot100Percent().longValue();
		long build_TotalPer = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getBuildingSummary().getTotBuildng().longValue();
		request.setAttribute("build_5Per", build_5Per);
		request.setAttribute("build_10Per", build_10Per);
		request.setAttribute("buid_100Per", buid_100Per);
		request.setAttribute("build_TotalPer", build_TotalPer);
		// for asset type is plant and machinery
		long plantMach_15Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getPlantMachinerySummary().getDeprBlockTot15Percent().longValue();
		long plantMach_30Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getPlantMachinerySummary().getDeprBlockTot30Percent().longValue();
		long plantMach_40Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getPlantMachinerySummary().getDeprBlockTot40Percent().longValue();
		long plantMach_50Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getPlantMachinerySummary().getDeprBlockTot50Percent().longValue();
		long plantMach_60Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getPlantMachinerySummary().getDeprBlockTot60Percent().longValue();
		long plantMach_80Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getPlantMachinerySummary().getDeprBlockTot80Percent().longValue();
		long plantMach_100Per = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getPlantMachinerySummary().getDeprBlockTot100Percent().longValue();
		long plantMach_Total = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getPlantMachinerySummary().getTotPlntMach().longValue();
		request.setAttribute("plantMach_15Per", plantMach_15Per);
		request.setAttribute("plantMach_30Per", plantMach_30Per);
		request.setAttribute("plantMach_40Per", plantMach_40Per);
		request.setAttribute("plantMach_50Per", plantMach_50Per);
		request.setAttribute("plantMach_60Per", plantMach_60Per);
		request.setAttribute("plantMach_80Per", plantMach_80Per);
		request.setAttribute("plantMach_100Per", plantMach_100Per);
		request.setAttribute("plantMach_Total", plantMach_Total);
		// for the asset type furniture and fitting
		long furniture_Fitting = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getFurnitureSummary().longValue();
		request.setAttribute("furniture_Fitting", furniture_Fitting);
		// for the asset type Intangible 
		long intangible = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getIntangibleAssetSummary().longValue();
		request.setAttribute("intangible", intangible);
		long ships = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getShipsSummary().longValue();
		request.setAttribute("ships", ships);
		long total_CG = objITR_ScheduleDEP.getScheduleDEP(itr).getSummaryFromDeprSch().getTotalDepreciation().longValue();
		request.setAttribute("total_CG", total_CG);

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

	}

}
