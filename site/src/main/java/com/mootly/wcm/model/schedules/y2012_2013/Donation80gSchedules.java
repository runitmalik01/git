package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.DoneeWithPan;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G.Don100Percent;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G.Don100PercentApprReqd;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G.Don50PercentApprReqd;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G.Don50PercentNoApprReqd;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.utils.XmlCalculation;

public class Donation80gSchedules extends XmlCalculation{

	DeductionDocument deductionDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;

	public Donation80gSchedules(DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation) {
		this.deductionDocument = deductionDocument;
		this.memberPersonalInformation = memberPersonalInformation;
	}

	/**
	 * 2012-2013 Financial Year,HstResponse,HstRequest
	 * @param itr
	 * @return
	 */

	public Schedule80G getSchedule80G(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>();//not being used anywhere
		Schedule80G schedule80G = new Schedule80G();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		//FinancialYear financialYear =  (FinancialYear) request.getAttribute("financialYear");

		Map<String,Object> totalMapForJSDe = new HashMap<String, Object>();

		//totalMapForJSDe.put("ageInYears",ageInYears);

		long grsstotal = grossTotal(financialYear,inputBeans);
		totalMapForJSDe.put("isSeniorCitizen",financialYear.isSeniorCitizen(memberPersonalInformation.getDOB().getTime()));
		totalMapForJSDe.put("salarypension",longsalarytotal);
		totalMapForJSDe.put("othersources",otherincome);
		totalMapForJSDe.put("houseproperty",houseIncomeTotal);

		Map<String,Object> resultMapDe = ScreenCalculatorService.getScreenCalculations("Chapter6Calc.js", requestParameterMap, totalMapForJSDe);
		Double totaleligiblededuction=0D;
		Double deduction80g = 0D;
		if(resultMapDe.containsKey("total_eligiblededuction")) {
			totaleligiblededuction=Double.parseDouble(resultMapDe.get("total_eligiblededuction").toString());
		}
		if(resultMapDe.containsKey("total_80g")) {
			deduction80g=Double.parseDouble(resultMapDe.get("total_80g").toString());
		}

		BigInteger Total100Appr = new BigInteger("0");
		BigInteger Total100NoAppr = new BigInteger("0");
		BigInteger Total50Appr = new BigInteger("0");
		BigInteger Total50NoAppr = new BigInteger("0");
		BigInteger DedExc80G = new BigInteger("0");
		DedExc80G = indianCurrencyHelper.bigIntegerRound(totaleligiblededuction).subtract(indianCurrencyHelper.bigIntegerRound(deduction80g));

		if(deductionDocument != null){
			List<DeductionDocumentDetail> listOfDeductionDocumentDetail = deductionDocument.getDeductionDocumentDetailList();
			if (listOfDeductionDocumentDetail!= null && listOfDeductionDocumentDetail.size() > 0 ){
				Don100Percent don100Percent = new Don100Percent();
				Don100PercentApprReqd don100PercentApprReqd = new Don100PercentApprReqd();
				Don50PercentNoApprReqd don50PercentNoApprReqd = new Don50PercentNoApprReqd();
				Don50PercentApprReqd don50PercentApprReqd = new Don50PercentApprReqd();
				for(DeductionDocumentDetail deductionDocumentDetail: listOfDeductionDocumentDetail){
					com.mootly.wcm.model.DoneeWithPan doneewithPan = new com.mootly.wcm.model.DoneeWithPan();
					doneewithPan = com.mootly.wcm.model.DoneeWithPan.getInstanceFromChildBean(deductionDocumentDetail);
					if(doneewithPan!=null){
						DoneeWithPan doneeWithPan = new DoneeWithPan();
						AddressDetail addressDetail = new AddressDetail();
						if(deductionDocumentDetail.getHead()!=null && deductionDocumentDetail.getHead().equals("NoAppr100")){
							doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName().toUpperCase());
							doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN().toUpperCase());
							addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality().toUpperCase());
							addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict().toUpperCase());
							addressDetail.setStateCode(doneewithPan.getDoneeState());
							addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
							doneeWithPan.setAddressDetail(addressDetail);
							doneeWithPan.setDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()));
							doneeWithPan.setEligibleDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()));
							don100Percent.getDoneeWithPan().add(doneeWithPan);
							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total100NoAppr = Total100NoAppr.add(Investment);
							don100Percent.setTotDon100Percent(Total100NoAppr);
							if(Total100NoAppr.longValue()<grsstotal){
								don100Percent.setTotEligibleDon100Percent(Total100NoAppr);
							}else if(Total100NoAppr.longValue()>=grsstotal && grsstotal>0){
								don100Percent.setTotEligibleDon100Percent(indianCurrencyHelper.longToBigInteger(grsstotal));
							}else if(Total100NoAppr.longValue()>=grsstotal && grsstotal==0){
								don100Percent.setTotEligibleDon100Percent(new BigInteger("0"));
							}
							schedule80G.setDon100Percent(don100Percent);
						}
						if(deductionDocumentDetail.getHead()!=null && deductionDocumentDetail.getHead().equals("Appr100")){
							doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName().toUpperCase());
							doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN().toUpperCase());
							addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality().toUpperCase());
							addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict().toUpperCase());
							addressDetail.setStateCode(doneewithPan.getDoneeState());
							addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
							doneeWithPan.setAddressDetail(addressDetail);
							doneeWithPan.setDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()));

							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total100Appr = Total100Appr.add(Investment);
							long adjGrossTotal=grsstotal - DedExc80G.longValue();
							long NetQualifyLmt=(long) (adjGrossTotal*0.1);
							//loop to show total eligible deduction amount
							if(Total100Appr.longValue()  > 0){
								if(NetQualifyLmt>Total100Appr.longValue()){
									don100PercentApprReqd.setTotEligibleDon100PercentApprReqd(Total100Appr);
								}else if(NetQualifyLmt<=Total100Appr.longValue() && NetQualifyLmt>0){
									don100PercentApprReqd.setTotEligibleDon100PercentApprReqd(indianCurrencyHelper.longToBigInteger(NetQualifyLmt));

								}else if(NetQualifyLmt<Total100Appr.longValue() && NetQualifyLmt<=0){
									don100PercentApprReqd.setTotEligibleDon100PercentApprReqd(new BigInteger("0"));

								}
							}
							//loop to show Eligible Donation amount for each entry
							if(deductionDocumentDetail.getInvestment().longValue()  > 0){
								if(NetQualifyLmt>deductionDocumentDetail.getInvestment().longValue()){
									doneeWithPan.setEligibleDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()));

								}else if(NetQualifyLmt<=deductionDocumentDetail.getInvestment().longValue() && NetQualifyLmt>0){
									doneeWithPan.setEligibleDonationAmt(indianCurrencyHelper.longToBigInteger(NetQualifyLmt));

								}else if(NetQualifyLmt<deductionDocumentDetail.getInvestment().longValue() && NetQualifyLmt<=0){
									doneeWithPan.setEligibleDonationAmt(new BigInteger("0"));
								}
							}
							don100PercentApprReqd.getDoneeWithPan().add(doneeWithPan);
							don100PercentApprReqd.setTotDon100PercentApprReqd(Total100Appr);
							schedule80G.setDon100PercentApprReqd(don100PercentApprReqd);
						}
						if(deductionDocumentDetail.getHead()!=null && deductionDocumentDetail.getHead().equals("NoAppr50")){
							doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName().toUpperCase());
							doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN().toUpperCase());
							addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality().toUpperCase());
							addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict().toUpperCase());
							addressDetail.setStateCode(doneewithPan.getDoneeState());
							addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
							doneeWithPan.setAddressDetail(addressDetail);
							doneeWithPan.setDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()));
							doneeWithPan.setEligibleDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()).divide(new BigInteger("2")));
							don50PercentNoApprReqd.getDoneeWithPan().add(doneeWithPan);
							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total50NoAppr = Total50NoAppr.add(Investment);
							don50PercentNoApprReqd.setTotDon50PercentNoApprReqd(Total50NoAppr);
							if(Total50NoAppr.divide(new BigInteger("2")).longValue()<grsstotal){
								don50PercentNoApprReqd.setTotEligibleDon50Percent(Total50NoAppr.divide(new BigInteger("2")));
							}else if(Total50NoAppr.divide(new BigInteger("2")).longValue()>=grsstotal && grsstotal>0){
								don50PercentNoApprReqd.setTotEligibleDon50Percent(indianCurrencyHelper.longToBigInteger(grsstotal));
							}else if(Total50NoAppr.divide(new BigInteger("2")).longValue()>=grsstotal && grsstotal==0){
								don50PercentNoApprReqd.setTotEligibleDon50Percent(new BigInteger("0"));
							}
							schedule80G.setDon50PercentNoApprReqd(don50PercentNoApprReqd);
						}
						if(deductionDocumentDetail.getHead()!=null && deductionDocumentDetail.getHead().equals("Appr50")){
							doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName().toUpperCase());
							doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN().toUpperCase());
							addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality().toUpperCase());
							addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict().toUpperCase());
							addressDetail.setStateCode(doneewithPan.getDoneeState());
							addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
							doneeWithPan.setAddressDetail(addressDetail);
							doneeWithPan.setDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()));

							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total50Appr = Total50Appr.add(Investment);
							don50PercentApprReqd.setTotDon50PercentApprReqd(Total50Appr);

							long adjGrossTotal=grsstotal - DedExc80G.longValue();
							long NetQualifyLmt=(long) (adjGrossTotal*0.1);
							// loop to show  total eligible deduction under this head
							if(Total50Appr.longValue()  > 0){
								if(NetQualifyLmt>Total50Appr.longValue()/2){
									don50PercentApprReqd.setTotEligibleDon50PercentApprReqd(Total50Appr.divide(new BigInteger("2")));
									doneeWithPan.setEligibleDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()).divide(new BigInteger("2")));
								}else if(NetQualifyLmt<=Total50Appr.longValue()/2 && NetQualifyLmt>0){
									don50PercentApprReqd.setTotEligibleDon50PercentApprReqd(indianCurrencyHelper.longToBigInteger(NetQualifyLmt));
									doneeWithPan.setEligibleDonationAmt(indianCurrencyHelper.longToBigInteger(NetQualifyLmt));
								}else if(NetQualifyLmt<Total100Appr.longValue()/2 && NetQualifyLmt<=0){
									don50PercentApprReqd.setTotEligibleDon50PercentApprReqd(new BigInteger("0"));
									doneeWithPan.setEligibleDonationAmt(new BigInteger("0"));
								}
							}
							// loop to show eligible donation amount for each entry
							if(deductionDocumentDetail.getInvestment().longValue()  > 0){
								if(NetQualifyLmt>deductionDocumentDetail.getInvestment().longValue()/2){
									doneeWithPan.setEligibleDonationAmt(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment()).divide(new BigInteger("2")));
								}else if(NetQualifyLmt<=deductionDocumentDetail.getInvestment().longValue()/2 && NetQualifyLmt>0){
									doneeWithPan.setEligibleDonationAmt(indianCurrencyHelper.longToBigInteger(NetQualifyLmt));
								}else if(NetQualifyLmt<deductionDocumentDetail.getInvestment().longValue()/2 && NetQualifyLmt<=0){
									doneeWithPan.setEligibleDonationAmt(new BigInteger("0"));
								}
							}
							don50PercentApprReqd.getDoneeWithPan().add(doneeWithPan);
							schedule80G.setDon50PercentApprReqd(don50PercentApprReqd);
						}
						schedule80G.setTotalDonationsUs80G(Total100NoAppr.add(Total100Appr).add(Total50NoAppr).add(Total50Appr));
						schedule80G.setTotalEligibleDonationsUs80G(indianCurrencyHelper.bigIntegerRound(deduction80g));
					}
				}
			}
			return schedule80G;
		}else
			return null;
	}
}
