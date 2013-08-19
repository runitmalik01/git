package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG;
import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG.LongTerm;
import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG.LongTerm1121Applicable;
import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG.ShortTerm;
import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG.ShortTermUnder111A;
import in.gov.incometaxindiaefiling.y2012_2013.DateRange;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.LongTermCapGain23;
import in.gov.incometaxindiaefiling.y2012_2013.NRIAssetSec48Dtl;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAsset;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAsset111AApplicable;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAssetProviso112;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAssetProviso112.DeductSec48;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCGFor23;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCGFor4;
import in.gov.incometaxindiaefiling.y2012_2013.ShortTermCapGainFor23;

import java.util.List;

import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class CapitalGainDocumentSchedules {

	CapitalAssetDocument capitalAssetDocument = null;

	public CapitalGainDocumentSchedules(CapitalAssetDocument capitalAssetDocument) {
		this.capitalAssetDocument = capitalAssetDocument;

	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */
	public ScheduleCGFor23 getSchedulecCgFor23(ITR itr) {
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		List<CapitalAssetDetail> capitalAssetDetails = capitalAssetDocument.getCapitalAssetDetailList();
		ScheduleCGFor23 scheduleCG =new ScheduleCGFor23();
		ScheduleCGFor4 scheduleCG4 = new ScheduleCGFor4();

		for (CapitalAssetDetail capitalAssetDetail:capitalAssetDetails)  {

			OtherAssetProviso112 otherAssetProviso112 = new OtherAssetProviso112();
			DeductSec48  deductSec48 = new DeductSec48();
			LongTermCapGain23 longTermCapGain23 =new LongTermCapGain23();
			longTermCapGain23.setAmtDeemedCGSec54(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getAmtdeemed()));
			longTermCapGain23.setNRIAssetSec48(indianCurrencyHelper.longRound(capitalAssetDetail.getSection48()));
			longTermCapGain23.setOtherAssetProviso112(otherAssetProviso112);
			otherAssetProviso112.setBalanceCG(indianCurrencyHelper.longRound(capitalAssetDetail.getBalance()));
			otherAssetProviso112.setBalLTCG112(indianCurrencyHelper.longRound(capitalAssetDetail.getBalance()));
			otherAssetProviso112.setDeductSec48(deductSec48);
			if(capitalAssetDetail.getIndex().equals("N")){
				deductSec48.setAquisitCostNoIndex(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
				deductSec48.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostTransfer()));
				deductSec48.setImproveCostNoIndex(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostImprovement()));
				deductSec48.setTotalDedn (indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()+capitalAssetDetail.getCostTransfer()
						+capitalAssetDetail.getCostImprovement()));
			}
			otherAssetProviso112.setExemptionOrDednUs54S(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getDed_sec54()));
			otherAssetProviso112.setFullConsideration(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
			longTermCapGain23.setPANIfDeduction54GB(capitalAssetDetail.getPan());
			longTermCapGain23.setTotalLTCG(indianCurrencyHelper.longRound(capitalAssetDetail.getCapitalGainTaxLT()));
			longTermCapGain23.setUnlistedSecurities(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUnlstdSecurity()));
			scheduleCG.setLongTermCapGain23(longTermCapGain23);
			ShortTermCapGainFor23 shortTermCapGainFor23 = new ShortTermCapGainFor23();
			scheduleCG.setShortTermCapGainFor23(shortTermCapGainFor23);
			shortTermCapGainFor23.setAmtDeemedCGSec54(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getAmtdeemed()));
			NRIAssetSec48Dtl nRIAssetSec48Dtl = new NRIAssetSec48Dtl();
			shortTermCapGainFor23.setNRIAssetSec48Dtl(nRIAssetSec48Dtl);
			nRIAssetSec48Dtl.setNRI111AApplicable(indianCurrencyHelper.longRound((capitalAssetDetail.getAsset_111())));
			nRIAssetSec48Dtl.setNRI111ANotApplicable(indianCurrencyHelper.longRound(capitalAssetDetail.getAsset_111()));
			OtherAsset otherAsset = new OtherAsset();
			shortTermCapGainFor23.setOtherAsset(otherAsset);
			otherAsset.setBalanceCG(indianCurrencyHelper.longRound((capitalAssetDetail.getBalance())));
			otherAsset.setBalCG(indianCurrencyHelper.longRound((capitalAssetDetail.getBalance())));
			if(capitalAssetDetail.getAssetType().equals("OTH"))
			{
				OtherAsset.DeductSec48 othassetdeduct48 = new  OtherAsset.DeductSec48();
				otherAsset.setDeductSec48(othassetdeduct48);
				othassetdeduct48.setAquisitCost(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
				othassetdeduct48.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostTransfer()));
				othassetdeduct48.setImproveCost(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostImprovement()));
				othassetdeduct48.setTotalDedn(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()+
						capitalAssetDetail.getCostImprovement()+capitalAssetDetail.getCostTransfer()));
				otherAsset.setExemptionOrDednUs54S(indianCurrencyHelper.bigIntegerRound((capitalAssetDetail.getDed_sec54())));
				otherAsset.setFullConsideration(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
				otherAsset.setLossSec94Of7Or94Of8(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getLoss_sec94()));
			}
			OtherAsset111AApplicable otherAsset111AApplicable = new OtherAsset111AApplicable();
			shortTermCapGainFor23.setOtherAsset111AApplicable(otherAsset111AApplicable);
			otherAsset111AApplicable.setBalanceCG(indianCurrencyHelper.longRound(capitalAssetDetail.getBalance()));
			otherAsset111AApplicable.setBalCG(indianCurrencyHelper.longRound(capitalAssetDetail.getBalance()));
			OtherAsset111AApplicable.DeductSec48 otherassetdedcut48 = new OtherAsset111AApplicable.DeductSec48();
			otherAsset111AApplicable.setDeductSec48(otherassetdedcut48);
			otherassetdedcut48.setAquisitCost(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
			otherassetdedcut48.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostTransfer()));
			otherassetdedcut48.setImproveCost(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostImprovement()));
			otherassetdedcut48.setTotalDedn(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()+
					capitalAssetDetail.getCostImprovement()+capitalAssetDetail.getCostTransfer()));
			otherAsset111AApplicable.setFullConsideration(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
			otherAsset111AApplicable.setLossSec94Of7Or94Of8(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getLoss_sec94()));
			shortTermCapGainFor23.setTotalSTCG(indianCurrencyHelper.longRound(capitalAssetDetail.getCapitalGainTaxST()));
			scheduleCG.setTotScheduleCGFor23(indianCurrencyHelper.longRound(capitalAssetDetail.getCapitalGainTaxST()));
			AccruOrRecOfCG accruOrRecOfCG = new AccruOrRecOfCG();
			scheduleCG.setAccruOrRecOfCG(accruOrRecOfCG);
			LongTerm accrOfcgLT =  new LongTerm();
			accruOrRecOfCG.setLongTerm(accrOfcgLT);
			DateRange  dateRange = new DateRange();
			accrOfcgLT.setDateRange(dateRange);
			// these are special case for accrual income of the user for long term where 112 is not applicable
			dateRange.setUp16Of12To15Of3(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16DecOth()));
			dateRange.setUp16Of3To31Of3(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto31Oth()));
			dateRange.setUp16Of9To15Of12(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16Oth()));
			dateRange.setUpto15Of9(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto15Oth()));
			LongTerm1121Applicable longTerm1121Applicable = new LongTerm1121Applicable();
			accruOrRecOfCG.setLongTerm1121Applicable(longTerm1121Applicable);
			longTerm1121Applicable.setDateRange(dateRange);
			// these are special case for accrual income of the user for long term where 112 is applicable
			dateRange.setUp16Of12To15Of3(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16DecLt()));
			dateRange.setUp16Of3To31Of3(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto31Lt()));
			dateRange.setUp16Of9To15Of12(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16Lt()));
			dateRange.setUpto15Of9(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto15Lt()));
			ShortTerm  shortTerm = new ShortTerm();
			accruOrRecOfCG.setShortTerm(shortTerm);
			shortTerm.setDateRange(dateRange);
			// these are special case for accrual income of the user for short term where 111 is not applicable
			dateRange.setUp16Of12To15Of3(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16Oth()));
			dateRange.setUp16Of3To31Of3(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16DecOth()));
			dateRange.setUp16Of9To15Of12(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16DecOth()));
			dateRange.setUpto15Of9(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto15Oth()));
			ShortTermUnder111A shortTermUnder111A = new ShortTermUnder111A();
			accruOrRecOfCG.setShortTermUnder111A(shortTermUnder111A);
			shortTermUnder111A.setDateRange(dateRange);
			// these are special case for accrual income of the user for short term where 111 is not applicable
			dateRange.setUp16Of12To15Of3(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16decSt()));
			dateRange.setUp16Of3To31Of3(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto31St()));
			dateRange.setUp16Of9To15Of12(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto16St()));
			dateRange.setUpto15Of9(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUpto15St()));
		}return null;




	}
}



