package com.mootly.wcm.model.schedules.y2013_2014;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.ITR4SIncomeDeductions;
import in.gov.incometaxindiaefiling.y2013_2014.ITR4STaxComputation;
import in.gov.incometaxindiaefiling.y2013_2014.IntrstPay;

import com.mootly.wcm.beans.BusinessProfessionDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SchFourtyFourAEDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.y2013_2014.XmlCalculation;

public class ITR4S_TaxComputation {


	BusinessProfessionDocument businessProfessionDocument = null;
	SchFourtyFourAEDocument schFourtyFourAEDocument = null;
	HouseProperty houseProperty = null;
	DeductionDocument deductionDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;
	OtherSourcesDocument otherSourcesDocument = null;
	FormSixteenDocument formSixteenDocument = null;

	public ITR4S_TaxComputation(BusinessProfessionDocument businessProfessionDocument, SchFourtyFourAEDocument schFourtyFourAEDocument, HouseProperty houseProperty,
			DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation, OtherSourcesDocument otherSourcesDocument,
			FormSixteenDocument formSixteenDocument){
		this.businessProfessionDocument = businessProfessionDocument;
		this.schFourtyFourAEDocument = schFourtyFourAEDocument;
		this.houseProperty = houseProperty;
		this.deductionDocument = deductionDocument;
		this.memberPersonalInformation = memberPersonalInformation;
		this.otherSourcesDocument = otherSourcesDocument;
		this.formSixteenDocument = formSixteenDocument;

	}

	public ITR4STaxComputation getITR4STaxComputation(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		ITR4STaxComputation iTR4STaxComputation = new ITR4STaxComputation();
		XmlCalculation xmlCalculation = new XmlCalculation();
		IndianCurrencyHelper indianCurrencyHelper= new IndianCurrencyHelper();

		ITR4S_IncomeDeductions iTR4S_IncomeDeductions = new ITR4S_IncomeDeductions(businessProfessionDocument, schFourtyFourAEDocument, houseProperty,
				deductionDocument, memberPersonalInformation, otherSourcesDocument);
		ITR4SIncomeDeductions iTR4SIncomeDeductions = iTR4S_IncomeDeductions.getITR4SIncomeDeductions(itr, financialYear, inputBeans);

		long totalIncome = iTR4SIncomeDeductions.getTotalIncome();
		if(totalIncome < 0)
			totalIncome = 0;
		Map<String,Object> resultMap = xmlCalculation.taxCalc(financialYear, inputBeans, totalIncome);

		iTR4STaxComputation.setTotalTaxPayable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtTax").toString())));
		BigInteger EduCess = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtEduCess").toString()));
		BigInteger HigherEduCess =indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtHEduCess").toString()));
		BigInteger TotalEduCess = EduCess.add(HigherEduCess);
		iTR4STaxComputation.setEducationCess(TotalEduCess);
		iTR4STaxComputation.setGrossTaxLiability(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txttotaltax").toString())));

		BigInteger relief89 =new BigInteger ("0");
		BigInteger relief89Total =new BigInteger ("0");
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList() ;
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					if(formSixteenDetail.getRelief_2()!=null){
						relief89=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getRelief_2());
						relief89Total=relief89Total.add(relief89);
					}
				}
			}
		}
		iTR4STaxComputation.setSection89(relief89Total);

		BigInteger netTaxLiability = iTR4STaxComputation.getGrossTaxLiability().subtract(iTR4STaxComputation.getSection89());
		if(netTaxLiability.compareTo(BigInteger.ZERO) > 0){
			iTR4STaxComputation.setNetTaxLiability(netTaxLiability);
		}else
			iTR4STaxComputation.setNetTaxLiability(new BigInteger("0"));

		Map<String,Object> resultMapINTEREST = xmlCalculation.interestCalc(financialYear, inputBeans, iTR4STaxComputation.getNetTaxLiability());

		iTR4STaxComputation.setTotalIntrstPay(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intt").toString())));
		IntrstPay intrstPay = new IntrstPay();
		intrstPay.setIntrstPayUs234A(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intA").toString())));
		intrstPay.setIntrstPayUs234B(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intB").toString())));
		intrstPay.setIntrstPayUs234C(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("ic").toString())));
		//intrstPay.setTotalIntrstPay(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intt").toString())));
		iTR4STaxComputation.setIntrstPay(intrstPay);

		iTR4STaxComputation.setTotTaxPlusIntrstPay(iTR4STaxComputation.getNetTaxLiability().add(iTR4STaxComputation.getTotalIntrstPay()));

		return iTR4STaxComputation;
	}
}
