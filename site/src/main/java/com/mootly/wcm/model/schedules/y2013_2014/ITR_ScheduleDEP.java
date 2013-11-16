package com.mootly.wcm.model.schedules.y2013_2014;

import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;

import in.gov.incometaxindiaefiling.y2013_2014.BuildingSummary;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.PlantMachinerySummary;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleDEP;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleDOA;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleDPM;
import in.gov.incometaxindiaefiling.y2013_2014.SummaryFromDeprSch;

public class ITR_ScheduleDEP {

	ScheduleDPMDocument scheduleDPMDocument = null;
	ScheduleDOADocument scheduleDOADocument = null;

	public ITR_ScheduleDEP(ScheduleDPMDocument scheduleDPMDocument, ScheduleDOADocument scheduleDOADocument){
		this.scheduleDPMDocument = scheduleDPMDocument;
		this.scheduleDOADocument = scheduleDOADocument;
	}

	public ScheduleDEP getScheduleDEP(ITR itr){

		ScheduleDEP scheduleDEP = new ScheduleDEP();

		ITR_ScheduleDPM iTR_ScheduleDPM = new ITR_ScheduleDPM(scheduleDPMDocument);
		ScheduleDPM scheduleDPM = iTR_ScheduleDPM.getScheduleDPM(itr);

		ITR_ScheduleDOA iTR_ScheduleDOA = new ITR_ScheduleDOA(scheduleDOADocument);
		ScheduleDOA scheduleDOA = iTR_ScheduleDOA.getScheduleDOA(itr);

		SummaryFromDeprSch summaryFromDeprSch = new SummaryFromDeprSch();
		PlantMachinerySummary plantMachinerySummary = new PlantMachinerySummary();
		plantMachinerySummary.setDeprBlockTot15Percent(scheduleDPM.getPlantMachinery().getRate15().getDepreciationDetail().getTotalDepreciation());
		plantMachinerySummary.setDeprBlockTot30Percent(scheduleDPM.getPlantMachinery().getRate30().getDepreciationDetail().getTotalDepreciation());
		plantMachinerySummary.setDeprBlockTot40Percent(scheduleDPM.getPlantMachinery().getRate40().getDepreciationDetail().getTotalDepreciation());
		plantMachinerySummary.setDeprBlockTot50Percent(scheduleDPM.getPlantMachinery().getRate50().getDepreciationDetail().getTotalDepreciation());
		plantMachinerySummary.setDeprBlockTot60Percent(scheduleDPM.getPlantMachinery().getRate60().getDepreciationDetail().getTotalDepreciation());
		plantMachinerySummary.setDeprBlockTot80Percent(scheduleDPM.getPlantMachinery().getRate80().getDepreciationDetail().getTotalDepreciation());
		plantMachinerySummary.setDeprBlockTot100Percent(scheduleDPM.getPlantMachinery().getRate100().getDepreciationDetail().getTotalDepreciation());
		plantMachinerySummary.setTotPlntMach(plantMachinerySummary.getDeprBlockTot15Percent().add(plantMachinerySummary.getDeprBlockTot30Percent())
				.add(plantMachinerySummary.getDeprBlockTot40Percent()).add(plantMachinerySummary.getDeprBlockTot50Percent()).add(plantMachinerySummary.getDeprBlockTot60Percent())
				.add(plantMachinerySummary.getDeprBlockTot80Percent()).add(plantMachinerySummary.getDeprBlockTot100Percent()));
		summaryFromDeprSch.setPlantMachinerySummary(plantMachinerySummary);

		BuildingSummary buildingSummary = new BuildingSummary();
		buildingSummary.setDeprBlockTot5Percent(scheduleDOA.getBuilding().getRate5().getDepreciationDetail().getTotalDepreciation());
		buildingSummary.setDeprBlockTot10Percent(scheduleDOA.getBuilding().getRate10().getDepreciationDetail().getTotalDepreciation());
		buildingSummary.setDeprBlockTot100Percent(scheduleDOA.getBuilding().getRate100().getDepreciationDetail().getTotalDepreciation());
		buildingSummary.setTotBuildng(buildingSummary.getDeprBlockTot5Percent().add(buildingSummary.getDeprBlockTot10Percent()).add(buildingSummary.getDeprBlockTot100Percent()));
		summaryFromDeprSch.setBuildingSummary(buildingSummary);

		summaryFromDeprSch.setFurnitureSummary(scheduleDOA.getFurnitureFittings().getRate10().getDepreciationDetail().getTotalDepreciation());
		summaryFromDeprSch.setIntangibleAssetSummary(scheduleDOA.getIntangibleAssets().getRate25().getDepreciationDetail().getTotalDepreciation());
		summaryFromDeprSch.setShipsSummary(scheduleDOA.getShips().getRate20().getDepreciationDetail().getTotalDepreciation());
		summaryFromDeprSch.setTotalDepreciation(plantMachinerySummary.getTotPlntMach().add(buildingSummary.getTotBuildng())
				.add(summaryFromDeprSch.getFurnitureSummary()).add(summaryFromDeprSch.getIntangibleAssetSummary()).add(summaryFromDeprSch.getShipsSummary()));

		scheduleDEP.setSummaryFromDeprSch(summaryFromDeprSch);

		return scheduleDEP;
	}

}
