package com.mootly.wcm.member;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTTI;

import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.AssetAndLiabilityDocument;
import com.mootly.wcm.beans.BalanceSheetDocument;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.ClubIncomeDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.DetailOfTrustDocument;
import com.mootly.wcm.beans.FinancialInterestDocument;
import com.mootly.wcm.beans.FirmsPartnerDocument;
import com.mootly.wcm.beans.ForeignBankAccountDocument;
import com.mootly.wcm.beans.ForeignIncomeDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.ImmovablePropertyDocument;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.ManufactureFinishedProductsDocument;
import com.mootly.wcm.beans.ManufactureRawMatDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.NatureBusinessDocument;
import com.mootly.wcm.beans.NatureInvestmentDocument;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.QuantitativeUnitDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleAMTCDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.SigningAuthorityAccountsDocument;
import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.UnabsorbedDepreciationDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TTI;

@PrimaryBean(primaryBeanClass=ScheduleAMTCDocument.class)
@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@FormFields(fieldNames={"taxUndSec115JC","taxUnderOtherProv","taxAgainstCredit","amtCreditGross","amtCreditSetOff","amtCreditBrghtFwrd","amtCreditUnlisted",
		"amtCreditCarriedFwrd","liabAvailCredit","unlistCreditUndSec115JD"})
public class ITRScheduleAMTC extends ITReturnComponent{

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) request.getAttribute(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) request.getAttribute(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) request.getAttribute(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());
		DeductionDocument deductionDocument = (DeductionDocument) request.getAttribute(DeductionDocument.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());
		TaxReliefDocument taxReliefDocument = (TaxReliefDocument) request.getAttribute(TaxReliefDocument.class.getSimpleName().toLowerCase());
		ImmovablePropertyDocument immovablePropertyDocument = (ImmovablePropertyDocument) request.getAttribute(ImmovablePropertyDocument.class.getSimpleName().toLowerCase());
		NatureInvestmentDocument natureInvestmentDocument = (NatureInvestmentDocument) request.getAttribute(NatureInvestmentDocument.class.getSimpleName().toLowerCase());
		SigningAuthorityAccountsDocument signingAuthorityAccountsDocument = (SigningAuthorityAccountsDocument) request.getAttribute(SigningAuthorityAccountsDocument.class.getSimpleName().toLowerCase());
		DetailOfTrustDocument detailOfTrustDocument = (DetailOfTrustDocument) request.getAttribute(DetailOfTrustDocument.class.getSimpleName().toLowerCase());
		ForeignBankAccountDocument foreignBankAccountDocument = (ForeignBankAccountDocument) request.getAttribute(ForeignBankAccountDocument.class.getSimpleName().toLowerCase());
		FinancialInterestDocument financialInterestDocument = (FinancialInterestDocument) request.getAttribute(FinancialInterestDocument.class.getSimpleName().toLowerCase());
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) request.getAttribute(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		ScheduleSIDocument scheduleSIDocument = (ScheduleSIDocument) request.getAttribute(ScheduleSIDocument.class.getSimpleName().toLowerCase());
		TcsDocument tcsDocument = (TcsDocument) request.getAttribute(TcsDocument.class.getSimpleName().toLowerCase());
		ScheduleDPMDocument scheduleDPMDocument = (ScheduleDPMDocument) request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase());
		ScheduleDOADocument scheduleDOADocument = (ScheduleDOADocument) request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase());
		DeductionSchedTenADocumemt deductionSchedTenADocumemt = (DeductionSchedTenADocumemt) request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase());
		OtherInformationDocument otherInformationDocument = (OtherInformationDocument) request.getAttribute(OtherInformationDocument.class.getSimpleName().toLowerCase());
		ProfitAndLossDocument profitAndLossDocument = (ProfitAndLossDocument) request.getAttribute(ProfitAndLossDocument.class.getSimpleName().toLowerCase());
		IncBusinessProfessionDoc incBusinessProfessionDoc = (IncBusinessProfessionDoc) request.getAttribute(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase());
		ScheduleESRDocument scheduleESRDocument = (ScheduleESRDocument) request.getAttribute(ScheduleESRDocument.class.getSimpleName().toLowerCase());
		ScheduleAMTCDocument scheduleAMTCDocument = (ScheduleAMTCDocument) request.getAttribute(ScheduleAMTCDocument.class.getSimpleName().toLowerCase());
		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) request.getAttribute(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());
		ForeignIncomeDocument foreignIncomeDocument = (ForeignIncomeDocument) request.getAttribute(ForeignIncomeDocument.class.getSimpleName().toLowerCase());
		ScheduleFiveADocument scheduleFiveADocument = (ScheduleFiveADocument) request.getAttribute(ScheduleFiveADocument.class.getSimpleName().toLowerCase());
		ClubIncomeDocument clubIncomeDocument = (ClubIncomeDocument) request.getAttribute(ClubIncomeDocument.class.getSimpleName().toLowerCase());
		NatureBusinessDocument natureBusinessDocument = (NatureBusinessDocument) request.getAttribute(NatureBusinessDocument.class.getSimpleName().toLowerCase());
		AssetAndLiabilityDocument assetAndLiabilityDocument = (AssetAndLiabilityDocument) request.getAttribute(AssetAndLiabilityDocument.class.getSimpleName().toLowerCase());
		QuantitativeUnitDocument quantitativeUnitDocument = (QuantitativeUnitDocument) request.getAttribute(QuantitativeUnitDocument.class.getSimpleName().toLowerCase());
		ManufactureRawMatDocument manufactureRawMatDocument = (ManufactureRawMatDocument) request.getAttribute(ManufactureRawMatDocument.class.getSimpleName().toLowerCase());
		ManufactureFinishedProductsDocument manufactureFinishedProductsDocument = (ManufactureFinishedProductsDocument) request.getAttribute(ManufactureFinishedProductsDocument.class.getSimpleName().toLowerCase());
		BalanceSheetDocument balanceSheetDocument = (BalanceSheetDocument) request.getAttribute(BalanceSheetDocument.class.getSimpleName().toLowerCase());
		UnabsorbedDepreciationDocument unabsorbedDepreciationDocument = (UnabsorbedDepreciationDocument) request.getAttribute(UnabsorbedDepreciationDocument.class.getSimpleName().toLowerCase());
		FirmsPartnerDocument firmsPartnerDocument = (FirmsPartnerDocument) request.getAttribute(FirmsPartnerDocument.class.getSimpleName().toLowerCase());
		IncomeFromFirmsDocument incomeFromFirmsDocument = (IncomeFromFirmsDocument) request.getAttribute(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase());
		ITR itr = new ITR();
		Map<String, HippoBean> inputBeans = new HashMap<String, HippoBean>();
		inputBeans.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(),memberPersonalInformation);
		inputBeans.put(SalaryIncomeDocument.class.getSimpleName().toLowerCase(),salaryIncomeDocument);
		inputBeans.put(HouseProperty.class.getSimpleName().toLowerCase(),houseProperty);
		inputBeans.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(),otherSourcesDocument);
		inputBeans.put(AdvanceTaxDocument.class.getSimpleName().toLowerCase(),advanceTaxDocument);
		inputBeans.put(TdsFromothersDocument.class.getSimpleName().toLowerCase(),tdsFromothersDocument);
		inputBeans.put(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase(),selfAssesmetTaxDocument);
		inputBeans.put(DeductionDocument.class.getSimpleName().toLowerCase(),deductionDocument);
		inputBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),formSixteenDocument);
		inputBeans.put(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase(),adjustmentOfLossesDoc);
		inputBeans.put(ForeignIncomeDocument.class.getSimpleName().toLowerCase(),foreignIncomeDocument);
		inputBeans.put(TaxReliefDocument.class.getSimpleName().toLowerCase(),taxReliefDocument);
		inputBeans.put(ImmovablePropertyDocument.class.getSimpleName().toLowerCase(),immovablePropertyDocument);
		inputBeans.put(NatureInvestmentDocument.class.getSimpleName().toLowerCase(),natureInvestmentDocument);
		inputBeans.put(SigningAuthorityAccountsDocument.class.getSimpleName().toLowerCase(),signingAuthorityAccountsDocument);
		inputBeans.put(DetailOfTrustDocument.class.getSimpleName().toLowerCase(),detailOfTrustDocument);
		inputBeans.put(ForeignBankAccountDocument.class.getSimpleName().toLowerCase(),foreignBankAccountDocument);
		inputBeans.put(FinancialInterestDocument.class.getSimpleName().toLowerCase(),financialInterestDocument);
		inputBeans.put(ScheduleFiveADocument.class.getSimpleName().toLowerCase(),scheduleFiveADocument);
		inputBeans.put(CapitalAssetDocument.class.getSimpleName().toLowerCase(),capitalAssetDocument);
		inputBeans.put(ClubIncomeDocument.class.getSimpleName().toLowerCase(),clubIncomeDocument);
		inputBeans.put(ScheduleSIDocument.class.getSimpleName().toLowerCase(),scheduleSIDocument);
		inputBeans.put(TcsDocument.class.getSimpleName().toLowerCase(),tcsDocument);
		inputBeans.put(NatureBusinessDocument.class.getSimpleName().toLowerCase(),natureBusinessDocument);
		inputBeans.put(OtherInformationDocument.class.getSimpleName().toLowerCase(),otherInformationDocument);
		inputBeans.put(ProfitAndLossDocument.class.getSimpleName().toLowerCase(),profitAndLossDocument);
		inputBeans.put(ScheduleESRDocument.class.getSimpleName().toLowerCase(),scheduleESRDocument);
		inputBeans.put(AssetAndLiabilityDocument.class.getSimpleName().toLowerCase(),assetAndLiabilityDocument);
		inputBeans.put(QuantitativeUnitDocument.class.getSimpleName().toLowerCase(),quantitativeUnitDocument);
		inputBeans.put(ManufactureRawMatDocument.class.getSimpleName().toLowerCase(),manufactureRawMatDocument);
		inputBeans.put(ManufactureFinishedProductsDocument.class.getSimpleName().toLowerCase(),manufactureFinishedProductsDocument);
		inputBeans.put(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase(),deductionSchedTenADocumemt);
		inputBeans.put(ScheduleAMTCDocument.class.getSimpleName().toLowerCase(),scheduleAMTCDocument);
		inputBeans.put(BalanceSheetDocument.class.getSimpleName().toLowerCase(),balanceSheetDocument);
		inputBeans.put(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase(),incBusinessProfessionDoc);
		inputBeans.put(UnabsorbedDepreciationDocument.class.getSimpleName().toLowerCase(),unabsorbedDepreciationDocument);
		inputBeans.put(ScheduleDPMDocument.class.getSimpleName().toLowerCase(),scheduleDPMDocument);
		inputBeans.put(ScheduleDOADocument.class.getSimpleName().toLowerCase(),scheduleDOADocument);
		inputBeans.put(FirmsPartnerDocument.class.getSimpleName().toLowerCase(),firmsPartnerDocument);
		inputBeans.put(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase(),incomeFromFirmsDocument);

		PartB_TTI partB_TTI = new PartB_TTI(formSixteenDocument, salaryIncomeDocument, houseProperty,
				otherSourcesDocument, deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument,
				selfAssesmetTaxDocument, tdsFromothersDocument, scheduleSIDocument, capitalAssetDocument, immovablePropertyDocument,
				natureInvestmentDocument,signingAuthorityAccountsDocument,detailOfTrustDocument,foreignBankAccountDocument,financialInterestDocument,
				tcsDocument,incBusinessProfessionDoc,profitAndLossDocument, otherInformationDocument, scheduleDPMDocument, scheduleDOADocument,
				scheduleESRDocument, deductionSchedTenADocumemt,scheduleAMTCDocument, incomeFromFirmsDocument);
		PartBTTI btti = partB_TTI.getPartBTTI(itr, getFinancialYear(), inputBeans);
		Double taxAgainstCredit = 0d;
		request.setAttribute("taxUndSec115JC", btti.getComputationOfTaxLiability().getTaxPayableOnDeemedTI().getTotalTax());
		request.setAttribute("taxUnderOtherProv", btti.getComputationOfTaxLiability().getGrossTaxLiability());
		taxAgainstCredit = btti.getComputationOfTaxLiability().getGrossTaxLiability().doubleValue() - btti.getComputationOfTaxLiability().getTaxPayableOnDeemedTI().getTotalTax().doubleValue();
		taxAgainstCredit = taxAgainstCredit > 0 ? taxAgainstCredit : 0;
		request.setAttribute("taxAgainstCredit", taxAgainstCredit);

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
