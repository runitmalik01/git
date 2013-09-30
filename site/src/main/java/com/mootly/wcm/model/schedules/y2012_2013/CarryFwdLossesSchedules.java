package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.CarryFwdLossDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.LossSummaryDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.AdjTotBFLossInBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.CurrentAYloss;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.LossCFFromPrev2NdYearFromAY;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.LossCFFromPrev3RdYearFromAY;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.LossCFFromPrevYrToAY;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.TotalLossCFSummary;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.TotalOfBFLossesEarlierYrs;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlType;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctc.wstx.util.StringUtil;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

public class CarryFwdLossesSchedules extends XmlCalculation {
	private static Logger log = LoggerFactory.getLogger(DeductionVIASchedules .class);
	private static Class classToCFL =null;

	AdjustmentOfLossesDoc adjustmentOfLossesDoc = null;

	public CarryFwdLossesSchedules(AdjustmentOfLossesDoc adjustmentOfLossesDoc) {
		this.adjustmentOfLossesDoc = adjustmentOfLossesDoc;
	}


	/**
	 * 2012-2013 Financial Year,HstResponse,HstRequest
	 * @param itr
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */

	public ScheduleCFL getScheduleCFL(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans) {

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		String itrSelection =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Map<String,Object> resultMapLosses = lossesCalc(financialYear,inputBeans);

		ScheduleCFL scheduleCFL = new ScheduleCFL();
		if(adjustmentOfLossesDoc != null){
			List<AdjustmentOfLossesCom> lossesDetails = adjustmentOfLossesDoc.getAdjustmentOfLossesList();
			if ( lossesDetails != null && lossesDetails.size() > 0 ){
				Map<String,List<AdjustmentOfLossesCom>> resultChildMap = lossesCFLChilds(financialYear, inputBeans);
				for(String key : resultChildMap.keySet()){
					CarryFwdLossDetail carryFwdLossDetail = invokeCarryFwdLossDetail(resultChildMap.get(key),itrSelection);
					Class[] classesCFL = ScheduleCFL.class.getDeclaredClasses();
					XmlType xmlType = ScheduleCFL.class.getAnnotation(XmlType.class);
					String fields[] = xmlType.propOrder();
					Class[] partypes = new Class[]{CarryFwdLossDetail.class};
					try{
						for(String field:fields){
							if(field.equals("lossCFFromPrevYrToAY") && key.equals("1")){
								for(Class cl:classesCFL){
									if(cl.getSimpleName().equalsIgnoreCase(field)){
										classToCFL = cl;
									}
								}
								if(classToCFL==null){
									classToCFL = Class.forName(field.replaceFirst("l", "L"));
								}
								Object o = classToCFL.newInstance();
								Method meth = classToCFL.getMethod("setCarryFwdLossDetail", partypes);
								Object[] parm = new Object[]{carryFwdLossDetail};
								meth.invoke(o, parm);
								Class[] partypesCFL = new Class[]{classToCFL};
								Object[] parmCFL = new Object[]{o};
								Method finMeth = ScheduleCFL.class.getMethod("set"+classToCFL.getSimpleName(), partypesCFL);
								finMeth.invoke(scheduleCFL, parmCFL);
							}
							if(field.contains("lossCFFromPrev"+key)){
								for(Class cl:classesCFL){
									if(cl.getSimpleName().equalsIgnoreCase(field)){
										classToCFL = cl;
									}
								}
								if(classToCFL==null){
									classToCFL = Class.forName(field.replaceFirst("l", "L"));
								}
								Object o = classToCFL.newInstance();
								Method meth = classToCFL.getMethod("setCarryFwdLossDetail", partypes);
								Object[] parm = new Object[]{carryFwdLossDetail};
								meth.invoke(o, parm);
								Class[] partypesCFL = new Class[]{classToCFL};
								Object[] parmCFL = new Object[]{o};
								Method finMeth = ScheduleCFL.class.getMethod("set"+classToCFL.getSimpleName(), partypesCFL);
								finMeth.invoke(scheduleCFL, parmCFL);
							}
						}
					}
					catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		TotalOfBFLossesEarlierYrs totalOfBFLossesEarlierYrs = new TotalOfBFLossesEarlierYrs();
		LossSummaryDetail lossSummaryDetail = new LossSummaryDetail();
		lossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		lossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(totalHPLoss));
		lossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		lossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(totalLTCLoss));
		lossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(totalMaintainingRaceHorseLoss));
		lossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(totalSTCLoss));
		totalOfBFLossesEarlierYrs.setLossSummaryDetail(lossSummaryDetail);
		scheduleCFL.setTotalOfBFLossesEarlierYrs(totalOfBFLossesEarlierYrs);

		AdjTotBFLossInBFLA adjTotBFLossInBFLA = new AdjTotBFLossInBFLA();
		LossSummaryDetail adjlossSummaryDetail = new LossSummaryDetail();
		adjlossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		adjlossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseLoss").toString())));
		adjlossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		adjlossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedLTCLoss").toString())));
		adjlossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedRaceHorseLoss").toString())));
		adjlossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedSTCLoss").toString())));
		adjTotBFLossInBFLA.setLossSummaryDetail(adjlossSummaryDetail);
		scheduleCFL.setAdjTotBFLossInBFLA(adjTotBFLossInBFLA);

		CurrentAYloss currentAYloss = new CurrentAYloss();
		LossSummaryDetail currYrlossSummaryDetail = new LossSummaryDetail();
		currYrlossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		currYrlossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearHouseIncomeLoss").toString())));
		currYrlossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		currYrlossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearLTCLoss").toString())));
		currYrlossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearRaceHorseLoss").toString())));
		currYrlossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearSTCLoss").toString())));
		currentAYloss.setLossSummaryDetail(currYrlossSummaryDetail);
		scheduleCFL.setCurrentAYloss(currentAYloss);

		TotalLossCFSummary totalLossCFSummary = new TotalLossCFSummary();
		LossSummaryDetail toallossSummaryDetail = new LossSummaryDetail();

		toallossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdHouseIncomeLoss").toString())));
		toallossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		toallossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		toallossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdLTCLoss").toString())));
		toallossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdRaceHorseLoss").toString())));
		toallossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdSTCLoss").toString())));
		totalLossCFSummary.setLossSummaryDetail(toallossSummaryDetail);
		scheduleCFL.setTotalLossCFSummary(totalLossCFSummary);

		return scheduleCFL;
	}

	public CarryFwdLossDetail invokeCarryFwdLossDetail(List<AdjustmentOfLossesCom> childBean, String WhichITR){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		CarryFwdLossDetail carryFwdLossDetail = new CarryFwdLossDetail();

		carryFwdLossDetail.setHPLossCF(new BigInteger("0"));
		carryFwdLossDetail.setLTCGLossCF(new BigInteger("0"));
		carryFwdLossDetail.setSTCGLossCF(new BigInteger("0"));
		carryFwdLossDetail.setOthSrcLossRaceHorseCF(new BigInteger("0"));
		carryFwdLossDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		carryFwdLossDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		if(WhichITR.equals("ITR4")){
			carryFwdLossDetail.setLossFrmSpecifiedBusCF(new BigInteger("0"));
		}

		for(AdjustmentOfLossesCom adjustmentOfLossesCom:childBean){
			carryFwdLossDetail.setDateOfFiling(indianCurrencyHelper.gregorianCalendar(adjustmentOfLossesCom.getDateOfFilingYear()));
			if(adjustmentOfLossesCom.getNameOfHead().equals("House Property Loss")){
				carryFwdLossDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
			}
			if(adjustmentOfLossesCom.getNameOfHead().equals("Long Term Capital Loss")){
				carryFwdLossDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
			}
			if(adjustmentOfLossesCom.getNameOfHead().equals("Short Term Capital Loss")){
				carryFwdLossDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
			}
			if(adjustmentOfLossesCom.getNameOfHead().equals("Owning and Maintaining Race Horses")){
				carryFwdLossDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
			}
			if(WhichITR.equals("ITR4")){
				if(adjustmentOfLossesCom.getNameOfHead().equals("Non Speculation Business Loss")){
					carryFwdLossDetail.setBusLossOthThanSpecLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
				}
				if(adjustmentOfLossesCom.getNameOfHead().equals("Loss From Specified Business")){
					carryFwdLossDetail.setLossFrmSpecifiedBusCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
				}
				if(adjustmentOfLossesCom.getNameOfHead().equals("Speculation Business Loss")){
					carryFwdLossDetail.setLossFrmSpecBusCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
				}
			}
		}
		return carryFwdLossDetail;
	}
}
