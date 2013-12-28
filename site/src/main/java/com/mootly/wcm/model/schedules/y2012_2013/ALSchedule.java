package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.MovableAsset;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleAL;

import java.lang.reflect.Field;

import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.beans.AssetAndLiabilityDocument;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ALSchedule {

	AssetAndLiabilityDocument assetAndLiabilityDocument = null;

	public ALSchedule(AssetAndLiabilityDocument assetAndLiabilityDocument){
		this.assetAndLiabilityDocument = assetAndLiabilityDocument;
	}

	public ScheduleAL getScheduleAL(ITR itr){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleAL scheduleAL = new ScheduleAL();

		//To set Dummy if Document is null
		if(assetAndLiabilityDocument == null){
			AssetAndLiabilityDocument assetAndLiabilityDocumentDummy = new AssetAndLiabilityDocument();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(assetAndLiabilityDocumentDummy);
			Field[] fields =  AssetAndLiabilityDocument.class.getDeclaredFields();
			for(Field field : fields){
				if(field.getType().getSimpleName().equals(Double.class.getSimpleName())){
					directFieldAccessor.setPropertyValue(field.getName(), 0d);
				}
			}
			this.assetAndLiabilityDocument = assetAndLiabilityDocumentDummy;
		}

		scheduleAL.setImmovableAssetLand(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getLand()));
		scheduleAL.setImmovableAssetBuilding(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getBuilding()));
		MovableAsset movableAsset = new MovableAsset();
		movableAsset.setDepositsInBank(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getDeposit_Bank()));
		movableAsset.setSharesAndSecurities(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getShares()));
		movableAsset.setInsurancePolicies(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getInsurance()));
		movableAsset.setLoansAndAdvancesGiven(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getLoans_Adv()));
		movableAsset.setCashInHand(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getCash()));
		movableAsset.setJewelleryBullionEtc(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getJewellery()));
		movableAsset.setArchCollDrawPaintSulpArt(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getDrawing()));
		movableAsset.setVehiclYachtsBoatsAircrafts(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getVehicles()));
		movableAsset.setTotalImmovablMovablAssets(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getTotal()));
		scheduleAL.setMovableAsset(movableAsset);
		scheduleAL.setLiabilityInRelatAssets(indianCurrencyHelper.bigIntegerRound(assetAndLiabilityDocument.getLiability()));

		return scheduleAL;
	}
}
