package com.mootly.wcm.member;


import in.gov.incometaxindiaefiling.y2012_2013.ITR;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.compound.ScheduleDPMDetails;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.schedules.y2012_2013.ITR_ScheduleDCG;

/*
 * Author:Megha Agarwal
 * Date:
 * Description
 */

@FormFields(fieldNames={"ratefifteen","ratethirty","rateforty","ratefifty","ratesixty","rateeighty",
		"ratehundred","total","ratefive","rateten","hundred","total1","furniture","intangible","ships","total2"
})
@AdditionalBeans(additionalBeansToLoad={ScheduleDPMDetails.class,ScheduleDOADocument.class})

public class DeemedCapitalGain extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(DeemedCapitalGain.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of schedule DCG");
		}
		ScheduleDOADocument scheduleDOADocument = (ScheduleDOADocument) request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase());
		ScheduleDPMDocument scheduleDPMDocument = (ScheduleDPMDocument) request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase());
		ITR_ScheduleDCG objITR_ScheduleDCG = new ITR_ScheduleDCG(scheduleDPMDocument, scheduleDOADocument);
		ITR itr = new ITR();
		// for asset type is building
		long build_5Per =  objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getBuildingSummaryCG().getDeprBlockTot5Percent();
		long build_10Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getBuildingSummaryCG().getDeprBlockTot10Percent();
		long buid_100Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getBuildingSummaryCG().getDeprBlockTot100Percent();
		long build_TotalPer = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getBuildingSummaryCG().getTotBuildng();
		request.setAttribute("build_5Per", build_5Per);
		request.setAttribute("build_10Per", build_10Per);
		request.setAttribute("buid_100Per", buid_100Per);
		request.setAttribute("build_TotalPer", build_TotalPer);
		// for asset type is plant and machinery
		long plantMach_15Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getPlantMachinerySummaryCG().getDeprBlockTot15Percent();
		long plantMach_30Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getPlantMachinerySummaryCG().getDeprBlockTot30Percent();
		long plantMach_40Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getPlantMachinerySummaryCG().getDeprBlockTot40Percent();
		long plantMach_50Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getPlantMachinerySummaryCG().getDeprBlockTot50Percent();
		long plantMach_60Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getPlantMachinerySummaryCG().getDeprBlockTot60Percent();
		long plantMach_80Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getPlantMachinerySummaryCG().getDeprBlockTot80Percent();
		long plantMach_100Per = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getPlantMachinerySummaryCG().getDeprBlockTot100Percent();
		long plantMach_Total = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getPlantMachinerySummaryCG().getTotPlntMach();
		request.setAttribute("plantMach_15Per", plantMach_15Per);
		request.setAttribute("plantMach_30Per", plantMach_30Per);
		request.setAttribute("plantMach_40Per", plantMach_40Per);
		request.setAttribute("plantMach_50Per", plantMach_50Per);
		request.setAttribute("plantMach_60Per", plantMach_60Per);
		request.setAttribute("plantMach_80Per", plantMach_80Per);
		request.setAttribute("plantMach_100Per", plantMach_100Per);
		request.setAttribute("plantMach_Total", plantMach_Total);
		// for the asset type furniture and fitting
		long furniture_Fitting = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getFurnitureSummary();
		request.setAttribute("furniture_Fitting", furniture_Fitting);
		// for the asset type Intangible 
		long intangible = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getIntangibleAssetSummary();
		request.setAttribute("intangible", intangible);
		long ships = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getShipsSummary();
		request.setAttribute("ships", ships);
		long total_CG = objITR_ScheduleDCG.getScheduleDCG(itr).getSummaryFromDeprSchCG().getTotalDepreciation();
		request.setAttribute("total_CG", total_CG);
		
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do action of schedule DCG");
		}
		
	} }
	
	
	

