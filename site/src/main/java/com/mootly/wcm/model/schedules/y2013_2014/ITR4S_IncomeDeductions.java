package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.ITR4SIncomeDeductions;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleBPForITR4S;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleVIA;
import in.gov.incometaxindiaefiling.y2013_2014.UsrDeductUndChapVIA;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.BusinessProfessionDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SchFourtyFourAEDocument;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.y2013_2014.XmlCalculation;

public class ITR4S_IncomeDeductions extends XmlCalculation{

	private static Logger log = LoggerFactory.getLogger(ITR4S_IncomeDeductions.class);

	BusinessProfessionDocument businessProfessionDocument = null;
	SchFourtyFourAEDocument schFourtyFourAEDocument = null;
	HouseProperty houseProperty = null;
	DeductionDocument deductionDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;
	OtherSourcesDocument otherSourcesDocument = null;

	public ITR4S_IncomeDeductions(BusinessProfessionDocument businessProfessionDocument, SchFourtyFourAEDocument schFourtyFourAEDocument, HouseProperty houseProperty,
			DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation, OtherSourcesDocument otherSourcesDocument){
		this.businessProfessionDocument = businessProfessionDocument;
		this.schFourtyFourAEDocument = schFourtyFourAEDocument;
		this.houseProperty = houseProperty;
		this.deductionDocument = deductionDocument;
		this.memberPersonalInformation = memberPersonalInformation;
		this.otherSourcesDocument = otherSourcesDocument;
	}

	public ITR4SIncomeDeductions getITR4SIncomeDeductions(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		ITR4SIncomeDeductions iTR4SIncomeDeductions = new ITR4SIncomeDeductions();
		DeductionVIASchedules deductionVIASchedules = new DeductionVIASchedules(deductionDocument, memberPersonalInformation, otherSourcesDocument);
		ScheduleVIA scheduleVIA = deductionVIASchedules.getScheduleVIA(itr, financialYear, inputBeans);
		DeductUndChapVIA deductUndChapVIA = scheduleVIA.getDeductUndChapVIA();
		UsrDeductUndChapVIA usrDeductUndChapVIA = scheduleVIA.getUsrDeductUndChapVIA();

		grossTotal(financialYear, inputBeans);
		ITRScheduleBPForITR4S iTRScheduleBPForITR4S = new ITRScheduleBPForITR4S(businessProfessionDocument, schFourtyFourAEDocument);
		ScheduleBPForITR4S scheduleBPForITR4S = iTRScheduleBPForITR4S.getScheduleBPForITR4S(itr);
		iTR4SIncomeDeductions.setIncomeFromBusinessProf(BigInteger.valueOf(scheduleBPForITR4S.getIncChargeableUnderBus()));
		iTR4SIncomeDeductions.setIncomeFromSal(BigInteger.valueOf(longsalarytotal));
		if(houseProperty!=null){
			List<HouseIncomeDetail> listOfHouseIncomeDetail = houseProperty.getHouseIncomeDetailList() ;
			if (listOfHouseIncomeDetail!= null && listOfHouseIncomeDetail.size() > 0 ){
				for(HouseIncomeDetail houseIncomeDetail: listOfHouseIncomeDetail){
					if(houseIncomeDetail.getLetOut()!=null){
						iTR4SIncomeDeductions.setTypeOfHP(houseIncomeDetail.getLetOut());
					}
				}
			}
		}
		iTR4SIncomeDeductions.setTotalIncomeOfHP(houseIncomeTotal);
		iTR4SIncomeDeductions.setIncomeOthSrc(otherincome);
		iTR4SIncomeDeductions.setGrossTotIncome(iTR4SIncomeDeductions.getIncomeFromBusinessProf().longValue() + iTR4SIncomeDeductions.getIncomeFromSal().longValue()
				+ iTR4SIncomeDeductions.getTotalIncomeOfHP() + iTR4SIncomeDeductions.getIncomeOthSrc());

		iTR4SIncomeDeductions.setUsrDeductUndChapVIA(usrDeductUndChapVIA);
		iTR4SIncomeDeductions.setDeductUndChapVIA(deductUndChapVIA);

		iTR4SIncomeDeductions.setTotalIncome(iTR4SIncomeDeductions.getGrossTotIncome() - iTR4SIncomeDeductions.getDeductUndChapVIA().getTotalChapVIADeductions().longValue());

		return iTR4SIncomeDeductions;
	}

}
