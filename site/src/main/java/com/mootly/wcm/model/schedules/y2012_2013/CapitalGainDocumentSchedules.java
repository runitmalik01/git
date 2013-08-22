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
import in.gov.incometaxindiaefiling.y2012_2013.OtherAsset111AApplicable.DeductSec48;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAssetNoProviso112;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAssetProviso112;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCGFor23;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCGFor4;
import in.gov.incometaxindiaefiling.y2012_2013.ShortTermCapGainFor23;

import java.util.List;

import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
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
		ScheduleCGFor23 scheduleCGFor23 =new ScheduleCGFor23();

		if(capitalAssetDocument != null){
			List<CapitalAssetDetail> capitalAssetDetails = capitalAssetDocument.getCapitalAssetDetailList();
			if ( capitalAssetDetails != null && capitalAssetDetails.size() > 0 ){
				for (CapitalAssetDetail capitalAssetDetail : capitalAssetDetails)  {
					if(capitalAssetDetail.getCapitalGainTaxST() != null){
						ShortTermCapGainFor23 shortTermCapGainFor23 = new ShortTermCapGainFor23();

						NRIAssetSec48Dtl nRIAssetSec48Dtl = new NRIAssetSec48Dtl();
						nRIAssetSec48Dtl.setNRI111AApplicable(capitalAssetDetail.getAsset_111().longValue());
						nRIAssetSec48Dtl.setNRI111ANotApplicable(capitalAssetDetail.getAssetnt111().longValue());
						shortTermCapGainFor23.setNRIAssetSec48Dtl(nRIAssetSec48Dtl);

						OtherAsset111AApplicable otherAsset111AApplicable = new OtherAsset111AApplicable();
						otherAsset111AApplicable.setFullConsideration(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
						DeductSec48 deductSec48 = new DeductSec48();
						deductSec48.setAquisitCost(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
						deductSec48.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostTransfer()));
						deductSec48.setImproveCost(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostImprovement()));
						deductSec48.setTotalDedn(deductSec48.getAquisitCost().add(deductSec48.getExpOnTrans()).add(deductSec48.getImproveCost()));
						otherAsset111AApplicable.setDeductSec48(deductSec48);
						otherAsset111AApplicable.setBalanceCG(capitalAssetDetail.getBalance().longValue());
						otherAsset111AApplicable.setLossSec94Of7Or94Of8(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getLoss_sec94()));
						otherAsset111AApplicable.setBalCG(otherAsset111AApplicable.getBalanceCG() + otherAsset111AApplicable.getLossSec94Of7Or94Of8().longValue());
						shortTermCapGainFor23.setOtherAsset111AApplicable(otherAsset111AApplicable);

						OtherAsset otherAsset = new OtherAsset();
						otherAsset.setFullConsideration(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
						OtherAsset.DeductSec48 deductSec48OtherAsset = new OtherAsset.DeductSec48();
						deductSec48OtherAsset.setAquisitCost(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
						deductSec48OtherAsset.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostTransfer()));
						deductSec48OtherAsset.setImproveCost(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostImprovement()));
						deductSec48OtherAsset.setTotalDedn(deductSec48OtherAsset.getAquisitCost().add(deductSec48OtherAsset.getExpOnTrans()).add(deductSec48OtherAsset.getImproveCost()));
						otherAsset.setDeductSec48(deductSec48OtherAsset);
						otherAsset.setBalanceCG(capitalAssetDetail.getBalance().longValue());
						otherAsset.setLossSec94Of7Or94Of8(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getLoss_sec94()));
						otherAsset.setExemptionOrDednUs54S(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getDed_sec54()));
						otherAsset.setBalCG(otherAsset.getBalanceCG() + otherAsset.getLossSec94Of7Or94Of8().longValue() - otherAsset.getExemptionOrDednUs54S().longValue());
						shortTermCapGainFor23.setOtherAsset(otherAsset);

						shortTermCapGainFor23.setAmtDeemedCGSec54(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getAmtdeemed()));
						shortTermCapGainFor23.setTotalSTCG(capitalAssetDetail.getCapitalGainTaxST().longValue());
						scheduleCGFor23.setShortTermCapGainFor23(shortTermCapGainFor23);
					}

					if(capitalAssetDetail.getCapitalGainTaxLT() != null){
						LongTermCapGain23 longTermCapGain23 = new LongTermCapGain23();
						longTermCapGain23.setNRIAssetSec48(capitalAssetDetail.getSection48().longValue());

						OtherAssetNoProviso112 otherAssetNoProviso112 = new OtherAssetNoProviso112();
						otherAssetNoProviso112.setFullConsideration(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
						OtherAssetNoProviso112.DeductSec48 deductSec48ForNoProviso = new OtherAssetNoProviso112.DeductSec48();
						deductSec48ForNoProviso.setAquisitCostIndexed(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
						deductSec48ForNoProviso.setImproveCostIndexed(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostImprovement()));
						deductSec48ForNoProviso.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostTransfer()));
						deductSec48ForNoProviso.setTotalDedn(deductSec48ForNoProviso.getAquisitCostIndexed().add(deductSec48ForNoProviso.getExpOnTrans()).add(deductSec48ForNoProviso.getImproveCostIndexed()));
						otherAssetNoProviso112.setDeductSec48(deductSec48ForNoProviso);
						otherAssetNoProviso112.setBalanceCG(capitalAssetDetail.getBalance().longValue());
						otherAssetNoProviso112.setExemptionOrDednUs54S(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getDed_sec54()));
						otherAssetNoProviso112.setBalLTCGNo112(otherAssetNoProviso112.getBalanceCG() - otherAssetNoProviso112.getExemptionOrDednUs54S().longValue());
						longTermCapGain23.setOtherAssetNoProviso112(otherAssetNoProviso112);

						OtherAssetProviso112 otherAssetProviso112 = new OtherAssetProviso112();
						otherAssetProviso112.setFullConsideration(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
						OtherAssetProviso112.DeductSec48 deductSec48ForProviso = new OtherAssetProviso112.DeductSec48();
						deductSec48ForProviso.setAquisitCostNoIndex(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
						deductSec48ForProviso.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostTransfer()));
						deductSec48ForProviso.setImproveCostNoIndex(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostImprovement()));
						deductSec48ForProviso.setTotalDedn(deductSec48ForProviso.getAquisitCostNoIndex().add(deductSec48ForProviso.getExpOnTrans()).add(deductSec48ForProviso.getImproveCostNoIndex()));
						otherAssetProviso112.setDeductSec48(deductSec48ForProviso);
						otherAssetProviso112.setBalanceCG(capitalAssetDetail.getBalance().longValue());
						otherAssetProviso112.setExemptionOrDednUs54S(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getDed_sec54()));
						otherAssetProviso112.setBalLTCG112(otherAssetProviso112.getBalanceCG() - otherAssetProviso112.getExemptionOrDednUs54S().longValue());

						longTermCapGain23.setUnlistedSecurities(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getUnlstdSecurity()));
						longTermCapGain23.setAmtDeemedCGSec54(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getAmtdeemed()));
						longTermCapGain23.setTotalLTCG(capitalAssetDetail.getCapitalGainTaxLT().longValue());
						longTermCapGain23.setOtherAssetProviso112(otherAssetProviso112);
						if(!(capitalAssetDetail.getPan().isEmpty()))
							longTermCapGain23.setPANIfDeduction54GB(capitalAssetDetail.getPan());
						scheduleCGFor23.setLongTermCapGain23(longTermCapGain23);

						//scheduleCGFor23.setTotScheduleCGFor23(value);


					}
				}
			}
		}

		return scheduleCGFor23;
	}
}



