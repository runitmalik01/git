package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.DepreciationDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Rate100;
import in.gov.incometaxindiaefiling.y2012_2013.Rate15;
import in.gov.incometaxindiaefiling.y2012_2013.Rate30;
import in.gov.incometaxindiaefiling.y2012_2013.Rate40;
import in.gov.incometaxindiaefiling.y2012_2013.Rate50;
import in.gov.incometaxindiaefiling.y2012_2013.Rate60;
import in.gov.incometaxindiaefiling.y2012_2013.Rate80;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleDPM;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleDPM.PlantMachinery;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.compound.ScheduleDPMDetails;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR_ScheduleDPM {

	ScheduleDPMDocument scheduleDPMDocument = null;

	public ITR_ScheduleDPM(ScheduleDPMDocument scheduleDPMDocument){
		this.scheduleDPMDocument = scheduleDPMDocument;
	}

	public ScheduleDPM getScheduleDPM(ITR itr){

		ScheduleDPMDetails scheduleDPMDetailDummy = new ScheduleDPMDetails();
		DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(scheduleDPMDetailDummy);
		Field[] fields =  ScheduleDPMDetails.class.getDeclaredFields();
		for(Field field : fields){
			if(field.getType().getSimpleName().equals(Double.class.getSimpleName())){
				directFieldAccessor.setPropertyValue(field.getName(), 0d);
			}
		}
		ScheduleDPM scheduleDPM = new ScheduleDPM();
		PlantMachinery plantMachinery = new PlantMachinery();
		DepreciationDetail depreciationDetail = invokeScheduleDPMDetails(scheduleDPMDetailDummy);
		Rate15 rate15 = new Rate15();
		rate15.setDepreciationDetail(depreciationDetail);
		plantMachinery.setRate15(rate15);
		Rate30 rate30= new Rate30();
		rate30.setDepreciationDetail(depreciationDetail);
		plantMachinery.setRate30(rate30);
		Rate40 rate40 = new Rate40();
		rate40.setDepreciationDetail(depreciationDetail);
		plantMachinery.setRate40(rate40);
		Rate50 rate50 = new Rate50();
		rate50.setDepreciationDetail(depreciationDetail);
		plantMachinery.setRate50(rate50);
		Rate60 rate60 = new Rate60();
		rate60.setDepreciationDetail(depreciationDetail);
		plantMachinery.setRate60(rate60);
		Rate80 rate80 = new Rate80();
		rate80.setDepreciationDetail(depreciationDetail);
		plantMachinery.setRate80(rate80);
		Rate100 rate100 = new Rate100();
		rate100.setDepreciationDetail(depreciationDetail);
		plantMachinery.setRate100(rate100);


		if(scheduleDPMDocument != null){
			List<ScheduleDPMDetails> scheduleDPMDetails = scheduleDPMDocument.getScheduleDPMDetailList();
			if ( scheduleDPMDetails != null && scheduleDPMDetails.size() > 0 ){
				for(ScheduleDPMDetails scheduleDPMDetail:scheduleDPMDetails){
					String rate = scheduleDPMDetail.getRates();
					if(rate.equals("100")){
						rate100.setDepreciationDetail(invokeScheduleDPMDetails(scheduleDPMDetail));
						plantMachinery.setRate100(rate100);
					}
					if(rate.equals("80")){
						rate80.setDepreciationDetail(invokeScheduleDPMDetails(scheduleDPMDetail));
						plantMachinery.setRate80(rate80);
					}
					if(rate.equals("60")){
						rate60.setDepreciationDetail(invokeScheduleDPMDetails(scheduleDPMDetail));
						plantMachinery.setRate60(rate60);
					}
					if(rate.equals("50")){
						rate50.setDepreciationDetail(invokeScheduleDPMDetails(scheduleDPMDetail));
						plantMachinery.setRate50(rate50);
					}
					if(rate.equals("40")){
						rate40.setDepreciationDetail(invokeScheduleDPMDetails(scheduleDPMDetail));
						plantMachinery.setRate40(rate40);
					}
					if(rate.equals("30")){
						rate30.setDepreciationDetail(invokeScheduleDPMDetails(scheduleDPMDetail));
						plantMachinery.setRate30(rate30);
					}
					if(rate.equals("15")){
						rate15.setDepreciationDetail(invokeScheduleDPMDetails(scheduleDPMDetail));
						plantMachinery.setRate15(rate15);
					}
				}
			}
		}
		scheduleDPM.setPlantMachinery(plantMachinery);
		return scheduleDPM;
	}

	public DepreciationDetail invokeScheduleDPMDetails(ScheduleDPMDetails scheduleDPMDetail){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		DepreciationDetail depreciationDetail = new DepreciationDetail();

		depreciationDetail.setWDVFirstDay(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getValFirstDayPrevYr()));
		depreciationDetail.setAdditionsGrThan180Days(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getPeriodMore180Day()));
		depreciationDetail.setRealizationTotalPeriod(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getPrevYrConsider()));
		depreciationDetail.setFullRateDeprAmt(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getAmtDepreciationFullRate()));
		depreciationDetail.setAdditionsLessThan180Days(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getPeriodLess180Day()));
		depreciationDetail.setRealizationPeriodLessThan180Days(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getConsiderOrRealDuringYr()));
		depreciationDetail.setHalfRateDeprAmt(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getAmtDepreciationHalfRate()));
		depreciationDetail.setDepreciationAtFullRate(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getDepreciationFullRate()));
		depreciationDetail.setDepreciationAtHalfRate(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getDepreciationHalfRate()));
		depreciationDetail.setAddlnDeprOnGT180DayAdditions(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getAddDepreciatMore180Day()));
		depreciationDetail.setAddlnDeprOnLessThan180DayAdditions(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getAddDepreciatLess180Day()));
		depreciationDetail.setTotalDepreciation(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getTotalDepreciation()));
		depreciationDetail.setExpdrOnTrforSaleAsset(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getExpense_TransferAsset()));
		depreciationDetail.setCapGainUs50(scheduleDPMDetail.getCapitalGain_LossSec50().longValue());
		depreciationDetail.setWDVLastDay(indianCurrencyHelper.bigIntegerRound(scheduleDPMDetail.getValLastDayPrevYr()));

		return depreciationDetail;
	}
}
