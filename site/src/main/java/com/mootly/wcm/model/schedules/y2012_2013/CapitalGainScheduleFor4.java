package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG;
import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG.LongTerm;
import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG.LongTerm1121Applicable;
import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG.ShortTerm;
import in.gov.incometaxindiaefiling.y2012_2013.AccruOrRecOfCG.ShortTermUnder111A;
import in.gov.incometaxindiaefiling.y2012_2013.CapGainSlumpSale;
import in.gov.incometaxindiaefiling.y2012_2013.DateRange;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.LongTermCapGain4;
import in.gov.incometaxindiaefiling.y2012_2013.NRIAssetSec48Dtl;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAsset;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAsset111AApplicable;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAsset111AApplicable.DeductSec48;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAssetNoProviso112;
import in.gov.incometaxindiaefiling.y2012_2013.OtherAssetProviso112;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCGFor4;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleDCG;
import in.gov.incometaxindiaefiling.y2012_2013.ShortTermCapGainFor4;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

public class CapitalGainScheduleFor4 {
	public Logger log = LoggerFactory.getLogger(CapitalGainScheduleFor4.class);
	CapitalAssetDocument capitalAssetDocument = null;
	ScheduleDPMDocument scheduleDPMDocument = null;
	ScheduleDOADocument scheduleDOADocument = null;

	public CapitalGainScheduleFor4(CapitalAssetDocument capitalAssetDocument, ScheduleDPMDocument scheduleDPMDocument, ScheduleDOADocument scheduleDOADocument) {
		this.capitalAssetDocument = capitalAssetDocument;
		this.scheduleDPMDocument = scheduleDPMDocument;
		this.scheduleDOADocument = scheduleDOADocument;

	}

	public ScheduleCGFor4 getScheduleCGFor4(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleCGFor4 scheduleCGFor4 = new ScheduleCGFor4();
		ShortTermCapGainFor4 shortTermCapGainFor4 = new ShortTermCapGainFor4();
		XmlCalculation xmlCalculation = new XmlCalculation();
		Map<String,Map<String, Object>> resultMap = xmlCalculation.capitalGainChilds(financialYear, inputBeans);

		BigInteger fullConsi = new BigInteger("0");
		BigInteger netWorth = new BigInteger("0");
		BigInteger cgSlumpSale = new BigInteger("0");
		BigInteger dedUs54S = new BigInteger("0");
		BigInteger netCGSlumpSale = new BigInteger("0");
		BigInteger fullConsiForLT = new BigInteger("0");
		BigInteger netWorthForLT = new BigInteger("0");
		BigInteger cgSlumpSaleForLT = new BigInteger("0");
		BigInteger dedUs54SForLT = new BigInteger("0");
		BigInteger netCGSlumpSaleForLT = new BigInteger("0");
		if(capitalAssetDocument != null){
			List<CapitalAssetDetail> capitalGainDetails = capitalAssetDocument.getCapitalAssetDetailList();
			if ( capitalGainDetails != null && capitalGainDetails.size() > 0 ){
				for(CapitalAssetDetail capitalAssetDetail:capitalGainDetails){
					if(capitalAssetDetail.getCapitalGainTaxST() != null && capitalAssetDetail.getAssetType().equals("SLUMP")){
						fullConsi = fullConsi.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
						netWorth = netWorth.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
						cgSlumpSale = cgSlumpSale.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCgSlump()));
						dedUs54S = dedUs54S.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getDed_sec54()));
						netCGSlumpSale = netCGSlumpSale.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getNetCGSlump()));
					}
					if(capitalAssetDetail.getCapitalGainTaxLT() != null && capitalAssetDetail.getAssetType().equals("SLUMP")){
						fullConsiForLT = fullConsiForLT.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getSaleConsideration()));
						netWorthForLT = netWorthForLT.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCostAcquisition()));
						cgSlumpSaleForLT = cgSlumpSaleForLT.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCgSlump()));
						dedUs54SForLT = dedUs54SForLT.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getDed_sec54()));
						netCGSlumpSaleForLT = netCGSlumpSaleForLT.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getNetCGSlump()));
					}
				}
			}
		}


		CapGainSlumpSale capGainSlumpSale = new CapGainSlumpSale();
		capGainSlumpSale.setFullConsideration(fullConsi);
		capGainSlumpSale.setNetWorthOfUTDivn(netWorth);
		capGainSlumpSale.setCGSlumpSale(cgSlumpSale.longValue());
		capGainSlumpSale.setDednUs54S(dedUs54S);
		capGainSlumpSale.setNetCGSlumpSale(netCGSlumpSale.longValue());
		shortTermCapGainFor4.setCapGainSlumpSale(capGainSlumpSale);

		NRIAssetSec48Dtl nRIAssetSec48Dtl = new NRIAssetSec48Dtl();
		nRIAssetSec48Dtl.setNRI111AApplicable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("nri111A").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("nri111A").toString())).longValue());
		nRIAssetSec48Dtl.setNRI111ANotApplicable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("nri111AN").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("nri111AN").toString())).longValue());
		shortTermCapGainFor4.setNRIAssetSec48Dtl(nRIAssetSec48Dtl);

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
		shortTermCapGainFor4.setOtherAsset111AApplicable(otherAsset111AApplicable);

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
		shortTermCapGainFor4.setOtherAsset(otherAsset);

		ITR_ScheduleDCG iTR_ScheduleDCG = new ITR_ScheduleDCG(scheduleDPMDocument, scheduleDOADocument);
		ScheduleDCG scheduleDCG = iTR_ScheduleDCG.getScheduleDCG(itr);
		shortTermCapGainFor4.setDeemedSTCGDeprAsset(scheduleDCG.getSummaryFromDeprSchCG().getTotalDepreciation());

		shortTermCapGainFor4.setAmtDeemedCGSec54(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("deemedAmt").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("deemedAmt").toString())));
		shortTermCapGainFor4.setTotalSTCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("STCGSST").get("totCG").toString()) + Double.parseDouble(resultMap.get("STCGNSST").get("totCG").toString())).longValue()
				+ shortTermCapGainFor4.getDeemedSTCGDeprAsset() + capGainSlumpSale.getNetCGSlumpSale());

		scheduleCGFor4.setShortTermCapGainFor4(shortTermCapGainFor4);

		LongTermCapGain4 longTermCapGain4 = new LongTermCapGain4();
		longTermCapGain4.setNRIAssetSec48(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGNINDEX").get("nri48A").toString()) + Double.parseDouble(resultMap.get("LTCGINDEX").get("nri48A").toString())).longValue());
		CapGainSlumpSale capGainSlumpSaleForLT = new CapGainSlumpSale();
		capGainSlumpSaleForLT.setFullConsideration(fullConsiForLT);
		capGainSlumpSaleForLT.setNetWorthOfUTDivn(netWorthForLT);
		capGainSlumpSaleForLT.setCGSlumpSale(cgSlumpSaleForLT.longValue());
		capGainSlumpSaleForLT.setDednUs54S(dedUs54SForLT);
		capGainSlumpSaleForLT.setNetCGSlumpSale(netCGSlumpSaleForLT.longValue());
		longTermCapGain4.setCapGainSlumpSale(capGainSlumpSaleForLT);

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
		longTermCapGain4.setOtherAssetNoProviso112(otherAssetNoProviso112);

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
		longTermCapGain4.setOtherAssetProviso112(otherAssetProviso112);

		if(capitalAssetDocument != null){
			List<CapitalAssetDetail> capitalAssetDetails = capitalAssetDocument.getCapitalAssetDetailList();
			if ( capitalAssetDetails != null && capitalAssetDetails.size() > 0 ){
				for (CapitalAssetDetail capitalAssetDetail : capitalAssetDetails)  {
					if(!(capitalAssetDetail.getPan().isEmpty()))
						longTermCapGain4.setPANIfDeduction54GB(capitalAssetDetail.getPan().toUpperCase());
				}
			}
		}

		longTermCapGain4.setUnlistedSecurities(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("unlstsec").toString()) + Double.parseDouble(resultMap.get("LTCGNINDEX").get("unlstsec").toString())).longValue());
		longTermCapGain4.setAmtDeemedCGSec54(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("deemedAmt").toString()) + Double.parseDouble(resultMap.get("LTCGNINDEX").get("deemedAmt").toString())));
		longTermCapGain4.setTotalLTCG(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("LTCGINDEX").get("totCG").toString()) + Double.parseDouble(resultMap.get("LTCGNINDEX").get("totCG").toString())).longValue()
				+ capGainSlumpSaleForLT.getNetCGSlumpSale());

		scheduleCGFor4.setLongTermCapGain4(longTermCapGain4);

		long shortTermGain = shortTermCapGainFor4.getTotalSTCG();
		long longTermGain = longTermCapGain4.getTotalLTCG();
		if(longTermGain < 0){
			longTermGain = 0;
		}
		scheduleCGFor4.setIncChargeableHeadCapGains(shortTermGain + longTermGain);

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

		scheduleCGFor4.setAccruOrRecOfCG(accruOrRecOfCG);

		return scheduleCGFor4;
	}

}
