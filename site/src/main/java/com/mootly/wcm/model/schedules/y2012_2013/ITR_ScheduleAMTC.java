package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITRScheduleAMTC;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTTI;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleAMTC;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.BalanceSheetDocument;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.DetailOfTrustDocument;
import com.mootly.wcm.beans.FinancialInterestDocument;
import com.mootly.wcm.beans.ForeignBankAccountDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.ImmovablePropertyDocument;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.NatureInvestmentDocument;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleAMTCDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.SigningAuthorityAccountsDocument;
import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR_ScheduleAMTC {

	public ScheduleAMTCDocument scheduleAMTCDocument;

	public ITR_ScheduleAMTC(ScheduleAMTCDocument scheduleAMTCDocument) {
		// TODO Auto-generated constructor stub
		this.scheduleAMTCDocument = scheduleAMTCDocument;
	}

	public ITRScheduleAMTC getScheduleAMTC(ITR itr, FinancialYear financialYear, Map<String, HippoBean> inputBeans){

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) inputBeans.get(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) inputBeans.get(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) inputBeans.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) inputBeans.get(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) inputBeans.get(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) inputBeans.get(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());
		DeductionDocument deductionDocument = (DeductionDocument) inputBeans.get(DeductionDocument.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) inputBeans.get(FormSixteenDocument.class.getSimpleName().toLowerCase());
		TaxReliefDocument taxReliefDocument = (TaxReliefDocument) inputBeans.get(TaxReliefDocument.class.getSimpleName().toLowerCase());
		ImmovablePropertyDocument immovablePropertyDocument = (ImmovablePropertyDocument) inputBeans.get(ImmovablePropertyDocument.class.getSimpleName().toLowerCase());
		NatureInvestmentDocument natureInvestmentDocument = (NatureInvestmentDocument) inputBeans.get(NatureInvestmentDocument.class.getSimpleName().toLowerCase());
		SigningAuthorityAccountsDocument signingAuthorityAccountsDocument = (SigningAuthorityAccountsDocument) inputBeans.get(SigningAuthorityAccountsDocument.class.getSimpleName().toLowerCase());
		DetailOfTrustDocument detailOfTrustDocument = (DetailOfTrustDocument) inputBeans.get(DetailOfTrustDocument.class.getSimpleName().toLowerCase());
		ForeignBankAccountDocument foreignBankAccountDocument = (ForeignBankAccountDocument) inputBeans.get(ForeignBankAccountDocument.class.getSimpleName().toLowerCase());
		FinancialInterestDocument financialInterestDocument = (FinancialInterestDocument) inputBeans.get(FinancialInterestDocument.class.getSimpleName().toLowerCase());
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) inputBeans.get(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		ScheduleSIDocument scheduleSIDocument = (ScheduleSIDocument) inputBeans.get(ScheduleSIDocument.class.getSimpleName().toLowerCase());
		TcsDocument tcsDocument = (TcsDocument) inputBeans.get(TcsDocument.class.getSimpleName().toLowerCase());
		ScheduleDPMDocument scheduleDPMDocument = (ScheduleDPMDocument) inputBeans.get(ScheduleDPMDocument.class.getSimpleName().toLowerCase());
		ScheduleDOADocument scheduleDOADocument = (ScheduleDOADocument) inputBeans.get(ScheduleDOADocument.class.getSimpleName().toLowerCase());
		DeductionSchedTenADocumemt deductionSchedTenADocumemt = (DeductionSchedTenADocumemt) inputBeans.get(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase());
		OtherInformationDocument otherInformationDocument = (OtherInformationDocument) inputBeans.get(OtherInformationDocument.class.getSimpleName().toLowerCase());
		ProfitAndLossDocument profitAndLossDocument = (ProfitAndLossDocument) inputBeans.get(ProfitAndLossDocument.class.getSimpleName().toLowerCase());
		IncBusinessProfessionDoc incBusinessProfessionDoc = (IncBusinessProfessionDoc) inputBeans.get(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase());
		ScheduleESRDocument scheduleESRDocument = (ScheduleESRDocument) inputBeans.get(ScheduleESRDocument.class.getSimpleName().toLowerCase());

		PartB_TTI partB_TTI = new PartB_TTI(formSixteenDocument, salaryIncomeDocument, houseProperty,
				otherSourcesDocument, deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument,
				selfAssesmetTaxDocument, tdsFromothersDocument, scheduleSIDocument, capitalAssetDocument, immovablePropertyDocument,
				natureInvestmentDocument,signingAuthorityAccountsDocument,detailOfTrustDocument,foreignBankAccountDocument,financialInterestDocument,
				tcsDocument,incBusinessProfessionDoc,profitAndLossDocument,otherInformationDocument,scheduleDPMDocument,scheduleDOADocument,
				scheduleESRDocument,deductionSchedTenADocumemt,scheduleAMTCDocument);
		PartBTTI partBTTI = partB_TTI.getPartBTTI(itr, financialYear, inputBeans);

		IndianCurrencyHelper currencyHelper = new IndianCurrencyHelper();
		List<ScheduleAMTC> scheduleAMTCList = new ArrayList<ScheduleAMTC>();
		ITRScheduleAMTC itrScheduleAMTC = new ITRScheduleAMTC();
		ScheduleAMTC scheduleAMTC = new ScheduleAMTC();
		scheduleAMTC.setAssYr(financialYear.getDisplayAssessmentYear());
		if(scheduleAMTCDocument == null){
			ScheduleAMTCDocument dummyAmtcDocument = new ScheduleAMTCDocument();
			Field[] balSheetFields = ScheduleAMTCDocument.class.getDeclaredFields();
			for(Field balField:balSheetFields){
				if(balField.getType().getSimpleName().equalsIgnoreCase(Double.class.getSimpleName())){
					DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(dummyAmtcDocument);
					directFieldAccessor.setPropertyValue(balField.getName(), 0d);
				}
			}
			scheduleAMTCDocument = dummyAmtcDocument;
		}
		if(scheduleAMTCDocument!=null){
			scheduleAMTC.setAmtCreditFwd(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditGross()));
			scheduleAMTC.setAmtCreditUtilized(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditUnlisted()));
			scheduleAMTC.setAmtCreditSetOfEy(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditSetOff()));
			scheduleAMTC.setAmtCreditBalBroughtFwd(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditBrghtFwrd()));
		}
		scheduleAMTCList.add(scheduleAMTC);
		itrScheduleAMTC.getScheduleAMTC().addAll(scheduleAMTCList);
		itrScheduleAMTC.setTaxSection115JC(partBTTI.getComputationOfTaxLiability().getTaxPayableOnDeemedTI().getTotalTax());
		itrScheduleAMTC.setTaxOthProvisions(partBTTI.getComputationOfTaxLiability().getGrossTaxLiability());
		itrScheduleAMTC.setAmtTaxCreditAvailable(itrScheduleAMTC.getTaxOthProvisions().subtract(itrScheduleAMTC.getTaxSection115JC()).doubleValue() > 0 ? itrScheduleAMTC.getTaxOthProvisions().subtract(itrScheduleAMTC.getTaxSection115JC()) : new BigInteger("0"));
		itrScheduleAMTC.setTotAMTGross(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditGross()));
		itrScheduleAMTC.setTotSetOffEys(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditSetOff()));
		itrScheduleAMTC.setTotBalBF(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditBrghtFwrd()));
		itrScheduleAMTC.setTotAmtCreditUtilisedCY(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditUnlisted()));
		itrScheduleAMTC.setTotBalAMTCreditCF(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditCarriedFwrd()));
		itrScheduleAMTC.setTaxSection115JD(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditUnlisted()));
		itrScheduleAMTC.setAmtLiabilityAvailable(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditCarriedFwrd()));

		return itrScheduleAMTC;
	}
}
