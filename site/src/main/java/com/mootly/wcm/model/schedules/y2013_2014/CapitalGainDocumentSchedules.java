package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.AccruOrRecOfCG;
import in.gov.incometaxindiaefiling.y2013_2014.AccruOrRecOfCG.LongTerm;
import in.gov.incometaxindiaefiling.y2013_2014.AccruOrRecOfCG.LongTerm1121Applicable;
import in.gov.incometaxindiaefiling.y2013_2014.AccruOrRecOfCG.ShortTerm;
import in.gov.incometaxindiaefiling.y2013_2014.AccruOrRecOfCG.ShortTermUnder111A;
import in.gov.incometaxindiaefiling.y2013_2014.DateRange;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.LongTermCapGain23;
import in.gov.incometaxindiaefiling.y2013_2014.NRIAssetSec48Dtl;
import in.gov.incometaxindiaefiling.y2013_2014.OtherAsset;
import in.gov.incometaxindiaefiling.y2013_2014.OtherAsset111AApplicable;
import in.gov.incometaxindiaefiling.y2013_2014.OtherAsset111AApplicable.DeductSec48;
import in.gov.incometaxindiaefiling.y2013_2014.OtherAssetNoProviso112;
import in.gov.incometaxindiaefiling.y2013_2014.OtherAssetProviso112;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleCGFor23;
import in.gov.incometaxindiaefiling.y2013_2014.ShortTermCapGainFor23;

import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.y2013_2014.XmlCalculation;

public class CapitalGainDocumentSchedules {

	public Logger log = LoggerFactory.getLogger(CapitalGainDocumentSchedules.class);
	CapitalAssetDocument capitalAssetDocument = null;

	public CapitalGainDocumentSchedules(CapitalAssetDocument capitalAssetDocument) {
		this.capitalAssetDocument = capitalAssetDocument;

	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */
	public ScheduleCGFor23 getSchedulecCgFor23(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans) {

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleCGFor23 scheduleCGFor23 =new ScheduleCGFor23();
		XmlCalculation xmlCalculation = new XmlCalculation();

		Map<String,Map<String, Object>> resultMap = xmlCalculation.capitalGainChilds(financialYear, inputBeans);

		ShortTermCapGainFor23 shortTermCapGainFor23 = new ShortTermCapGainFor23();

		NRIAssetSec48Dtl nRIAssetSec48Dtl = new NRIAssetSec48Dtl();
		nRIAssetSec48Dtl.setNRI111AApplicable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("nri111A").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("nri111A").toString())).longValue());
		nRIAssetSec48Dtl.setNRI111ANotApplicable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("nri111AN").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("nri111AN").toString())).longValue());
		shortTermCapGainFor23.setNRIAssetSec48Dtl(nRIAssetSec48Dtl);

		OtherAsset111AApplicable otherAsset111AApplicable = new OtherAsset111AApplicable();
		otherAsset111AApplicable.setFullConsideration(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("fullConsi").toString())));
		DeductSec48 deductSec48 = new DeductSec48();
		deductSec48.setAquisitCost(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("aquis").toString())));
		deductSec48.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("expend").toString())));
		deductSec48.setImproveCost(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("improv").toString())));
		deductSec48.setTotalDedn(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("total_dedn").toString())));
		otherAsset111AApplicable.setDeductSec48(deductSec48);
		otherAsset111AApplicable.setBalanceCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("balance").toString())).longValue());
		otherAsset111AApplicable.setLossSec94Of7Or94Of8(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("loss").toString())));
		otherAsset111AApplicable.setBalCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("balCG").toString())).longValue());
		shortTermCapGainFor23.setOtherAsset111AApplicable(otherAsset111AApplicable);

		OtherAsset otherAsset = new OtherAsset();
		otherAsset.setFullConsideration(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("fullConsi").toString())));
		OtherAsset.DeductSec48 deductSec48OtherAsset = new OtherAsset.DeductSec48();
		deductSec48OtherAsset.setAquisitCost(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("aquis").toString())));
		deductSec48OtherAsset.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("expend").toString())));
		deductSec48OtherAsset.setImproveCost(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("improv").toString())));
		deductSec48OtherAsset.setTotalDedn(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("total_dedn").toString())));
		otherAsset.setDeductSec48(deductSec48OtherAsset);
		otherAsset.setBalanceCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("balance").toString())).longValue());
		otherAsset.setLossSec94Of7Or94Of8(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("loss").toString())));
		otherAsset.setExemptionOrDednUs54S(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("dedn").toString())));
		otherAsset.setBalCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGNSST").get("balCG").toString())).longValue());
		shortTermCapGainFor23.setOtherAsset(otherAsset);

		shortTermCapGainFor23.setAmtDeemedCGSec54(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("deemedAmt").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("deemedAmt").toString())));
		shortTermCapGainFor23.setTotalSTCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("totCG").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("totCG").toString())).longValue());
		scheduleCGFor23.setShortTermCapGainFor23(shortTermCapGainFor23);


		LongTermCapGain23 longTermCapGain23 = new LongTermCapGain23();
		longTermCapGain23.setNRIAssetSec48(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("nri48A").toString()) + Double.parseDouble(resultMap.get("LTCGINDEX").get("nri48A").toString())).longValue());

		OtherAssetNoProviso112 otherAssetNoProviso112 = new OtherAssetNoProviso112();
		otherAssetNoProviso112.setFullConsideration(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("fullConsi").toString())));
		OtherAssetNoProviso112.DeductSec48 deductSec48ForNoProviso = new OtherAssetNoProviso112.DeductSec48();
		deductSec48ForNoProviso.setAquisitCostIndexed(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("aquis").toString())));
		deductSec48ForNoProviso.setImproveCostIndexed(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("improv").toString())));
		deductSec48ForNoProviso.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("expend").toString())));
		deductSec48ForNoProviso.setTotalDedn(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("total_dedn").toString())));
		otherAssetNoProviso112.setDeductSec48(deductSec48ForNoProviso);
		otherAssetNoProviso112.setBalanceCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("balance").toString())).longValue());
		otherAssetNoProviso112.setExemptionOrDednUs54S(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("dedn").toString())));
		otherAssetNoProviso112.setBalLTCGNo112(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("balCG").toString())).longValue());
		longTermCapGain23.setOtherAssetNoProviso112(otherAssetNoProviso112);

		OtherAssetProviso112 otherAssetProviso112 = new OtherAssetProviso112();
		otherAssetProviso112.setFullConsideration(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("fullConsi").toString())));
		OtherAssetProviso112.DeductSec48 deductSec48ForProviso = new OtherAssetProviso112.DeductSec48();
		deductSec48ForProviso.setAquisitCostNoIndex(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("aquis").toString())));
		deductSec48ForProviso.setExpOnTrans(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("expend").toString())));
		deductSec48ForProviso.setImproveCostNoIndex(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("improv").toString())));
		deductSec48ForProviso.setTotalDedn(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("total_dedn").toString())));
		otherAssetProviso112.setDeductSec48(deductSec48ForProviso);
		otherAssetProviso112.setBalanceCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("balance").toString())).longValue());
		otherAssetProviso112.setExemptionOrDednUs54S(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("dedn").toString())));
		otherAssetProviso112.setBalLTCG112(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("balCG").toString())).longValue());

		longTermCapGain23.setUnlistedSecurities(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("unlstsec").toString()) + Double.parseDouble(resultMap.get("LTCGNINDEX").get("unlstsec").toString())));
		longTermCapGain23.setAmtDeemedCGSec54(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("deemedAmt").toString()) + Double.parseDouble(resultMap.get("LTCGNINDEX").get("deemedAmt").toString())));
		longTermCapGain23.setTotalLTCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("totCG").toString()) + Double.parseDouble(resultMap.get("LTCGNINDEX").get("totCG").toString())).longValue());
		longTermCapGain23.setOtherAssetProviso112(otherAssetProviso112);

		if(capitalAssetDocument != null){
			List<CapitalAssetDetail> capitalAssetDetails = capitalAssetDocument.getCapitalAssetDetailList();
			if ( capitalAssetDetails != null && capitalAssetDetails.size() > 0 ){
				for (CapitalAssetDetail capitalAssetDetail : capitalAssetDetails)  {
					if(!(capitalAssetDetail.getPan().isEmpty()))
						longTermCapGain23.setPANIfDeduction54GB(capitalAssetDetail.getPan().toUpperCase());
				}
			}
		}
		scheduleCGFor23.setLongTermCapGain23(longTermCapGain23);
		long shortTermGain = shortTermCapGainFor23.getTotalSTCG();
		long longTermGain = longTermCapGain23.getTotalLTCG();
		if(longTermGain < 0){
			longTermGain = 0;
		}
		scheduleCGFor23.setTotScheduleCGFor23(shortTermGain + longTermGain);

		Map<String,Object> resultAccruralMap = xmlCalculation.getAccruralOfCG(financialYear, inputBeans);
		AccruOrRecOfCG accruOrRecOfCG = new AccruOrRecOfCG();

		LongTerm1121Applicable longTerm1121Applicable = new LongTerm1121Applicable();
		DateRange dateRangeLT1121A = new DateRange();
		dateRangeLT1121A.setUpto15Of9(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto15lt").toString())));
		dateRangeLT1121A.setUp16Of9To15Of12(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto16lt").toString())));
		dateRangeLT1121A.setUp16Of12To15Of3(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto16declt").toString())));
		dateRangeLT1121A.setUp16Of3To31Of3(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto31lt").toString())));
		longTerm1121Applicable.setDateRange(dateRangeLT1121A);
		accruOrRecOfCG.setLongTerm1121Applicable(longTerm1121Applicable);

		LongTerm longTerm = new LongTerm();
		DateRange dateRangeLT = new DateRange();
		dateRangeLT.setUpto15Of9(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto15np").toString())));
		dateRangeLT.setUp16Of9To15Of12(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto16np").toString())));
		dateRangeLT.setUp16Of12To15Of3(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("uptodecnp").toString())));
		dateRangeLT.setUp16Of3To31Of3(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto31np").toString())));
		longTerm.setDateRange(dateRangeLT);
		accruOrRecOfCG.setLongTerm(longTerm);

		ShortTermUnder111A shortTermUnder111A = new ShortTermUnder111A();
		DateRange dateRangeST111A = new DateRange();
		dateRangeST111A.setUpto15Of9(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto15St").toString())));
		dateRangeST111A.setUp16Of9To15Of12(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto16st").toString())));
		dateRangeST111A.setUp16Of12To15Of3(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto16decst").toString())));
		dateRangeST111A.setUp16Of3To31Of3(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto31st").toString())));
		shortTermUnder111A.setDateRange(dateRangeST111A);
		accruOrRecOfCG.setShortTermUnder111A(shortTermUnder111A);

		ShortTerm shortTerm = new ShortTerm();
		DateRange dateRangeST = new DateRange();
		dateRangeST.setUpto15Of9(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto15oth").toString())));
		dateRangeST.setUp16Of9To15Of12(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto16oth").toString())));
		dateRangeST.setUp16Of12To15Of3(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto16decoth").toString())));
		dateRangeST.setUp16Of3To31Of3(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultAccruralMap.get("upto31oth").toString())));
		shortTerm.setDateRange(dateRangeST);
		accruOrRecOfCG.setShortTerm(shortTerm);

		scheduleCGFor23.setAccruOrRecOfCG(accruOrRecOfCG);

		return scheduleCGFor23;
	}
}



