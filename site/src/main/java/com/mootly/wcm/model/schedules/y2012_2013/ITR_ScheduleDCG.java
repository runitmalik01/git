package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.BuildingSummaryCG;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PlantMachinerySummaryCG;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleDCG;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleDOA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleDPM;
import in.gov.incometaxindiaefiling.y2012_2013.SummaryFromDeprSchCG;

import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;

public class ITR_ScheduleDCG {

	ScheduleDPMDocument scheduleDPMDocument = null;
	ScheduleDOADocument scheduleDOADocument = null;

	public ITR_ScheduleDCG(ScheduleDPMDocument scheduleDPMDocument, ScheduleDOADocument scheduleDOADocument){
		this.scheduleDPMDocument = scheduleDPMDocument;
		this.scheduleDOADocument = scheduleDOADocument;
	}

	public ScheduleDCG getScheduleDCG(ITR itr){

		ScheduleDCG scheduleDCG = new ScheduleDCG();

		ITR_ScheduleDPM iTR_ScheduleDPM = new ITR_ScheduleDPM(scheduleDPMDocument);
		ScheduleDPM scheduleDPM = iTR_ScheduleDPM.getScheduleDPM(itr);

		ITR_ScheduleDOA iTR_ScheduleDOA = new ITR_ScheduleDOA(scheduleDOADocument);
		ScheduleDOA scheduleDOA = iTR_ScheduleDOA.getScheduleDOA(itr);

		SummaryFromDeprSchCG summaryFromDeprSchCG = new SummaryFromDeprSchCG();
		PlantMachinerySummaryCG plantMachinerySummaryCG = new PlantMachinerySummaryCG();
		plantMachinerySummaryCG.setDeprBlockTot15Percent(scheduleDPM.getPlantMachinery().getRate15().getDepreciationDetail().getCapGainUs50());
		plantMachinerySummaryCG.setDeprBlockTot30Percent(scheduleDPM.getPlantMachinery().getRate30().getDepreciationDetail().getCapGainUs50());
		plantMachinerySummaryCG.setDeprBlockTot40Percent(scheduleDPM.getPlantMachinery().getRate40().getDepreciationDetail().getCapGainUs50());
		plantMachinerySummaryCG.setDeprBlockTot50Percent(scheduleDPM.getPlantMachinery().getRate50().getDepreciationDetail().getCapGainUs50());
		plantMachinerySummaryCG.setDeprBlockTot60Percent(scheduleDPM.getPlantMachinery().getRate60().getDepreciationDetail().getCapGainUs50());
		plantMachinerySummaryCG.setDeprBlockTot80Percent(scheduleDPM.getPlantMachinery().getRate80().getDepreciationDetail().getCapGainUs50());
		plantMachinerySummaryCG.setDeprBlockTot100Percent(scheduleDPM.getPlantMachinery().getRate100().getDepreciationDetail().getCapGainUs50());
		plantMachinerySummaryCG.setTotPlntMach(plantMachinerySummaryCG.getDeprBlockTot15Percent()+plantMachinerySummaryCG.getDeprBlockTot30Percent()
				+plantMachinerySummaryCG.getDeprBlockTot40Percent()+plantMachinerySummaryCG.getDeprBlockTot50Percent()+plantMachinerySummaryCG.getDeprBlockTot60Percent()
				+plantMachinerySummaryCG.getDeprBlockTot80Percent()+plantMachinerySummaryCG.getDeprBlockTot100Percent());
		summaryFromDeprSchCG.setPlantMachinerySummaryCG(plantMachinerySummaryCG);

		BuildingSummaryCG buildingSummaryCG = new BuildingSummaryCG();
		buildingSummaryCG.setDeprBlockTot5Percent(scheduleDOA.getBuilding().getRate5().getDepreciationDetail().getCapGainUs50());
		buildingSummaryCG.setDeprBlockTot10Percent(scheduleDOA.getBuilding().getRate10().getDepreciationDetail().getCapGainUs50());
		buildingSummaryCG.setDeprBlockTot100Percent(scheduleDOA.getBuilding().getRate100().getDepreciationDetail().getCapGainUs50());
		buildingSummaryCG.setTotBuildng(buildingSummaryCG.getDeprBlockTot5Percent()+buildingSummaryCG.getDeprBlockTot10Percent()+buildingSummaryCG.getDeprBlockTot100Percent());
		summaryFromDeprSchCG.setBuildingSummaryCG(buildingSummaryCG);

		summaryFromDeprSchCG.setFurnitureSummary(scheduleDOA.getFurnitureFittings().getRate10().getDepreciationDetail().getCapGainUs50());
		summaryFromDeprSchCG.setIntangibleAssetSummary(scheduleDOA.getIntangibleAssets().getRate25().getDepreciationDetail().getCapGainUs50());
		summaryFromDeprSchCG.setShipsSummary(scheduleDOA.getShips().getRate20().getDepreciationDetail().getCapGainUs50());
		summaryFromDeprSchCG.setTotalDepreciation(plantMachinerySummaryCG.getTotPlntMach()+buildingSummaryCG.getTotBuildng()+summaryFromDeprSchCG.getFurnitureSummary()
				+summaryFromDeprSchCG.getIntangibleAssetSummary()+summaryFromDeprSchCG.getShipsSummary());

		scheduleDCG.setSummaryFromDeprSchCG(summaryFromDeprSchCG);

		return scheduleDCG;
	}
}
