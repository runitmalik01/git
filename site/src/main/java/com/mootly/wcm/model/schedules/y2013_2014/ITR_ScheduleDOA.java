package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.DepreciationDetail;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.Rate10;
import in.gov.incometaxindiaefiling.y2013_2014.Rate100;
import in.gov.incometaxindiaefiling.y2013_2014.Rate20;
import in.gov.incometaxindiaefiling.y2013_2014.Rate25;
import in.gov.incometaxindiaefiling.y2013_2014.Rate5;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleDOA;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleDOA.Building;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleDOA.FurnitureFittings;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleDOA.IntangibleAssets;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleDOA.Ships;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.compound.ScheduleDOADetails;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR_ScheduleDOA {

	ScheduleDOADocument scheduleDOADocument = null;

	public ITR_ScheduleDOA(ScheduleDOADocument scheduleDOADocument){
		this.scheduleDOADocument = scheduleDOADocument;
	}

	public ScheduleDOA getScheduleDOA(ITR itr){

		ScheduleDOADetails scheduleDOADetailsDummy = new ScheduleDOADetails();
		DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(scheduleDOADetailsDummy);
		Field[] fields =  ScheduleDOADetails.class.getDeclaredFields();
		for(Field field : fields){
			if(field.getType().getSimpleName().equals(Double.class.getSimpleName())){
				directFieldAccessor.setPropertyValue(field.getName(), 0d);
			}
		}
		ScheduleDOA scheduleDOA = new ScheduleDOA();
		Building building = new Building();
		FurnitureFittings furnitureFittings = new FurnitureFittings();
		IntangibleAssets intangibleAssets = new IntangibleAssets();
		Ships ships = new Ships();
		DepreciationDetail depreciationDetail = invokeScheduleDOADetails(scheduleDOADetailsDummy);
		Rate5 rate5 = new Rate5();
		rate5.setDepreciationDetail(depreciationDetail);
		building.setRate5(rate5);
		Rate10 rate10 = new Rate10();
		rate10.setDepreciationDetail(depreciationDetail);
		building.setRate10(rate10);
		Rate100 rate100 = new Rate100();
		rate100.setDepreciationDetail(depreciationDetail);
		building.setRate100(rate100);
		Rate10 rate10FF = new Rate10();
		rate10FF.setDepreciationDetail(depreciationDetail);
		furnitureFittings.setRate10(rate10FF);
		Rate25 rate25 = new Rate25();
		rate25.setDepreciationDetail(depreciationDetail);
		intangibleAssets.setRate25(rate25);
		Rate20 rate20 = new Rate20();
		rate20.setDepreciationDetail(depreciationDetail);
		ships.setRate20(rate20);


		if(scheduleDOADocument != null){
			List<ScheduleDOADetails> scheduleDOADetails = scheduleDOADocument.getScheduleDOADetailList();
			if ( scheduleDOADetails != null && scheduleDOADetails.size() > 0 ){
				for(ScheduleDOADetails scheduleDOADetail:scheduleDOADetails){
					String rate = scheduleDOADetail.getRates();
					String depriciationType = scheduleDOADetail.getType_Asset();
					if(depriciationType.equals("Building")){
						if(rate.equals("5")){
							Rate5 rate5B = new Rate5();
							rate5B.setDepreciationDetail(invokeScheduleDOADetails(scheduleDOADetail));
							building.setRate5(rate5B);
						}
						if(rate.equals("10")){
							Rate10 rate10B = new Rate10();
							rate10B.setDepreciationDetail(invokeScheduleDOADetails(scheduleDOADetail));
							building.setRate10(rate10B);
						}
						if(rate.equals("100")){
							Rate100 rate100B = new Rate100();
							rate100B.setDepreciationDetail(invokeScheduleDOADetails(scheduleDOADetail));
							building.setRate100(rate100B);
						}
					}
					if(depriciationType.equals("Furniture")){
						if(rate.equals("10")){
							Rate10 rate10F = new Rate10();
							rate10F.setDepreciationDetail(invokeScheduleDOADetails(scheduleDOADetail));
							furnitureFittings.setRate10(rate10F);
						}
					}
					if(depriciationType.equals("Intangible")){
						if(rate.equals("25")){
							Rate25 rate25I = new Rate25();
							rate25I.setDepreciationDetail(invokeScheduleDOADetails(scheduleDOADetail));
						intangibleAssets.setRate25(rate25I);
						}
					}
					if(depriciationType.equals("Ships")){
						if(rate.equals("20")){
							Rate20 rate20S = new Rate20();
							rate20S.setDepreciationDetail(invokeScheduleDOADetails(scheduleDOADetail));
							ships.setRate20(rate20S);
						}
					}
				}
			}
		}
		scheduleDOA.setBuilding(building);
		scheduleDOA.setFurnitureFittings(furnitureFittings);
		scheduleDOA.setIntangibleAssets(intangibleAssets);
		scheduleDOA.setShips(ships);

		return scheduleDOA;
	}

	public DepreciationDetail invokeScheduleDOADetails(ScheduleDOADetails scheduleDOADetails){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		DepreciationDetail depreciationDetail = new DepreciationDetail();

		depreciationDetail.setWDVFirstDay(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getValFirstDayPrevYr()));
		depreciationDetail.setAdditionsGrThan180Days(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getPeriodMore180Day()));
		depreciationDetail.setRealizationTotalPeriod(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getPrevYrConsider()));
		depreciationDetail.setFullRateDeprAmt(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getAmtDepreciationFullRate()));
		depreciationDetail.setAdditionsLessThan180Days(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getPeriodLess180Day()));
		depreciationDetail.setRealizationPeriodLessThan180Days(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getConsiderOrRealDuringYr()));
		depreciationDetail.setHalfRateDeprAmt(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getAmtDepreciationHalfRate()));
		depreciationDetail.setDepreciationAtFullRate(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getDepreciationFullRate()));
		depreciationDetail.setDepreciationAtHalfRate(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getDepreciationHalfRate()));
		depreciationDetail.setAddlnDeprOnGT180DayAdditions(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getAddDepreciatMore180Day()));
		depreciationDetail.setAddlnDeprOnLessThan180DayAdditions(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getAddDepreciatLess180Day()));
		depreciationDetail.setTotalDepreciation(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getTotalDepreciation()));
		depreciationDetail.setExpdrOnTrforSaleAsset(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getExpense_TransferAsset()));
		depreciationDetail.setCapGainUs50(scheduleDOADetails.getCapitalGain_LossSec50().longValue());
		depreciationDetail.setWDVLastDay(indianCurrencyHelper.bigIntegerRound(scheduleDOADetails.getValLastDayPrevYr()));

		return depreciationDetail;
	}
}
