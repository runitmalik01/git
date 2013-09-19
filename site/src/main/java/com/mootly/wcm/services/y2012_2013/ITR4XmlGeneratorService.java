package com.mootly.wcm.services.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR2;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4;
import in.gov.incometaxindiaefiling.y2012_2013.ObjectFactory;

import java.io.StringWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.mootly.wcm.beans.ForeignBankAccountDocument;
import com.mootly.wcm.beans.ForeignIncomeDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.ImmovablePropertyDocument;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
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
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.SigningAuthorityAccountsDocument;
import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.UnabsorbedDepreciationDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.schedules.y2012_2013.ALSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.BroughtFwdLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.CapitalGainDocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.CarryFwdLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.ClubbingOfIncome;
import com.mootly.wcm.model.schedules.y2012_2013.CreationInformation;
import com.mootly.wcm.model.schedules.y2012_2013.CurrentYearLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.DeductionVIASchedules;
import com.mootly.wcm.model.schedules.y2012_2013.Donation80gSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.ESRSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.ExemptIncomeSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.FADetailsSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.ForeignIncomeScheduleFSI;
import com.mootly.wcm.model.schedules.y2012_2013.Form16DocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.Form_ITR2;
import com.mootly.wcm.model.schedules.y2012_2013.Form_ITR4;
import com.mootly.wcm.model.schedules.y2012_2013.HouseIncomeDocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4_ScheduleBP;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4_ScheduleUD;
import com.mootly.wcm.model.schedules.y2012_2013.ITRScheduleSI;
import com.mootly.wcm.model.schedules.y2012_2013.ITR_Schedule10A;
import com.mootly.wcm.model.schedules.y2012_2013.ITR_Schedule10AA;
import com.mootly.wcm.model.schedules.y2012_2013.ITR_ScheduleAMT;
import com.mootly.wcm.model.schedules.y2012_2013.ITR_ScheduleAMTC;
import com.mootly.wcm.model.schedules.y2012_2013.MemberVerification;
import com.mootly.wcm.model.schedules.y2012_2013.OtherIncomeDocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.OtherInformationSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.PartA_BS;
import com.mootly.wcm.model.schedules.y2012_2013.PartA_Gen1;
import com.mootly.wcm.model.schedules.y2012_2013.PartA_Gen2;
import com.mootly.wcm.model.schedules.y2012_2013.PartA_QD;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TI;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TTI;
import com.mootly.wcm.model.schedules.y2012_2013.ProfitLossSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.Schedule80_IA;
import com.mootly.wcm.model.schedules.y2012_2013.Schedule80_IB;
import com.mootly.wcm.model.schedules.y2012_2013.Schedule80_IC;
import com.mootly.wcm.model.schedules.y2012_2013.ScheduleFiveA;
import com.mootly.wcm.model.schedules.y2012_2013.TCSSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.TRDetailsSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.TaxesDocumentScheduleIT;
import com.mootly.wcm.model.schedules.y2012_2013.TdsOthersSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.TdsSalarySchedules;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class ITR4XmlGeneratorService  {

	private static Logger log = LoggerFactory.getLogger(ITR4XmlGeneratorService .class);

	/**
	 *
	 * @param financialYear
	 * @param inputBeans
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> generateITR4(FinancialYear financialYear,Map<String,HippoBean> inputBeans) throws Exception {
		Map<String,Object> outputMap = new HashMap<String, Object>();

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) inputBeans.get(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) inputBeans.get(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) inputBeans.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) inputBeans.get(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) inputBeans.get(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) inputBeans.get(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());
		DeductionDocument deductionDocument = (DeductionDocument) inputBeans.get(DeductionDocument.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) inputBeans.get(FormSixteenDocument.class.getSimpleName().toLowerCase());
		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) inputBeans.get(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());
		ForeignIncomeDocument foreignIncomeDocument = (ForeignIncomeDocument) inputBeans.get(ForeignIncomeDocument.class.getSimpleName().toLowerCase());
		TaxReliefDocument taxReliefDocument = (TaxReliefDocument) inputBeans.get(TaxReliefDocument.class.getSimpleName().toLowerCase());
		ImmovablePropertyDocument immovablePropertyDocument = (ImmovablePropertyDocument) inputBeans.get(ImmovablePropertyDocument.class.getSimpleName().toLowerCase());
		NatureInvestmentDocument natureInvestmentDocument = (NatureInvestmentDocument) inputBeans.get(NatureInvestmentDocument.class.getSimpleName().toLowerCase());
		SigningAuthorityAccountsDocument signingAuthorityAccountsDocument = (SigningAuthorityAccountsDocument) inputBeans.get(SigningAuthorityAccountsDocument.class.getSimpleName().toLowerCase());
		DetailOfTrustDocument detailOfTrustDocument = (DetailOfTrustDocument) inputBeans.get(DetailOfTrustDocument.class.getSimpleName().toLowerCase());
		ForeignBankAccountDocument foreignBankAccountDocument = (ForeignBankAccountDocument) inputBeans.get(ForeignBankAccountDocument.class.getSimpleName().toLowerCase());
		FinancialInterestDocument financialInterestDocument = (FinancialInterestDocument) inputBeans.get(FinancialInterestDocument.class.getSimpleName().toLowerCase());
		ScheduleFiveADocument scheduleFiveADocument = (ScheduleFiveADocument) inputBeans.get(ScheduleFiveADocument.class.getSimpleName().toLowerCase());
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) inputBeans.get(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		ClubIncomeDocument clubIncomeDocument = (ClubIncomeDocument) inputBeans.get(ClubIncomeDocument.class.getSimpleName().toLowerCase());
		ScheduleSIDocument scheduleSIDocument = (ScheduleSIDocument) inputBeans.get(ScheduleSIDocument.class.getSimpleName().toLowerCase());
		TcsDocument tcsDocument = (TcsDocument) inputBeans.get(TcsDocument.class.getSimpleName().toLowerCase());
		NatureBusinessDocument natureBusinessDocument = (NatureBusinessDocument) inputBeans.get(NatureBusinessDocument.class.getSimpleName().toLowerCase());
		OtherInformationDocument otherInformationDocument = (OtherInformationDocument) inputBeans.get(OtherInformationDocument.class.getSimpleName().toLowerCase());
		ProfitAndLossDocument profitAndLossDocument = (ProfitAndLossDocument) inputBeans.get(ProfitAndLossDocument.class.getSimpleName().toLowerCase());
		ScheduleESRDocument scheduleESRDocument = (ScheduleESRDocument) inputBeans.get(ScheduleESRDocument.class.getSimpleName().toLowerCase());
		AssetAndLiabilityDocument assetAndLiabilityDocument = (AssetAndLiabilityDocument) inputBeans.get(AssetAndLiabilityDocument.class.getSimpleName().toLowerCase());
		QuantitativeUnitDocument quantitativeUnitDocument = (QuantitativeUnitDocument) inputBeans.get(QuantitativeUnitDocument.class.getSimpleName().toLowerCase());
		ManufactureRawMatDocument manufactureRawMatDocument = (ManufactureRawMatDocument) inputBeans.get(ManufactureRawMatDocument.class.getSimpleName().toLowerCase());
		ManufactureFinishedProductsDocument manufactureFinishedProductsDocument = (ManufactureFinishedProductsDocument) inputBeans.get(ManufactureFinishedProductsDocument.class.getSimpleName().toLowerCase());
		DeductionSchedTenADocumemt deductionSchedTenADocumemt = (DeductionSchedTenADocumemt) inputBeans.get(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase());
		ScheduleAMTCDocument scheduleAMTCDocument = (ScheduleAMTCDocument) inputBeans.get(ScheduleAMTCDocument.class.getSimpleName().toLowerCase());
		BalanceSheetDocument balanceSheetDocument = (BalanceSheetDocument) inputBeans.get(BalanceSheetDocument.class.getSimpleName().toLowerCase());
		IncBusinessProfessionDoc incBusinessProfessionDoc = (IncBusinessProfessionDoc) inputBeans.get(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase());
		UnabsorbedDepreciationDocument unabsorbedDepreciationDocument = (UnabsorbedDepreciationDocument) inputBeans.get(UnabsorbedDepreciationDocument.class.getSimpleName().toLowerCase());

		ITR4 itr4 = new ObjectFactory().createITR4();
		ITR itr = new ITR();

		CreationInformation creationInformation = new CreationInformation();
		itr4.setCreationInfo(creationInformation.getCreationInfo(itr));

		Form_ITR4 form_ITR4 = new Form_ITR4();
		itr4.setFormITR4(form_ITR4.getFormITR4(itr));

		Form16DocumentSchedules form16DocumentSchedules = new Form16DocumentSchedules(formSixteenDocument, salaryIncomeDocument);
		itr4.setScheduleS(form16DocumentSchedules.getScheduleS(itr));

		HouseIncomeDocumentSchedules houseIncomeDocumentSchedules = new HouseIncomeDocumentSchedules(houseProperty);
		itr4.setScheduleHP(houseIncomeDocumentSchedules.getScheduleHP(itr));

		OtherIncomeDocumentSchedules otherIncomeDocumentSchedules = new OtherIncomeDocumentSchedules(otherSourcesDocument);
		itr4.setScheduleOS(otherIncomeDocumentSchedules.getScheduleOS(itr));

		DeductionVIASchedules deductionVIASchedules = new DeductionVIASchedules(deductionDocument,memberPersonalInformation,otherSourcesDocument);
		itr4.setScheduleVIA(deductionVIASchedules.getScheduleVIA(itr, financialYear, inputBeans));

		Donation80gSchedules donation80gSchedules = new Donation80gSchedules(deductionDocument,memberPersonalInformation,otherSourcesDocument);
		itr4.setSchedule80G(donation80gSchedules.getSchedule80G(itr, financialYear, inputBeans));

		TaxesDocumentScheduleIT taxesDocumentScheduleIT = new TaxesDocumentScheduleIT(advanceTaxDocument, selfAssesmetTaxDocument);
		itr4.setScheduleIT(taxesDocumentScheduleIT.getScheduleIT(itr));

		TdsSalarySchedules tdsSalarySchedules = new TdsSalarySchedules(formSixteenDocument, salaryIncomeDocument);
		itr4.setScheduleTDS1(tdsSalarySchedules.getScheduleTDS1(itr));

		TdsOthersSchedules tdsOthersSchedules = new TdsOthersSchedules(tdsFromothersDocument);
		itr4.setScheduleTDS2(tdsOthersSchedules.getScheduleTDS2(itr));

		BroughtFwdLossesSchedules broughtFwdLossesSchedules = new BroughtFwdLossesSchedules();
		itr4.setScheduleBFLA(broughtFwdLossesSchedules.getScheduleBFLA(itr, financialYear, inputBeans));

		CurrentYearLossesSchedules currentYearLossesSchedules = new CurrentYearLossesSchedules();
		itr4.setScheduleCYLA(currentYearLossesSchedules.getScheduleCYLA(itr, financialYear, inputBeans));

		CarryFwdLossesSchedules carryFwdLossesSchedules = new CarryFwdLossesSchedules(adjustmentOfLossesDoc);
		itr4.setScheduleCFL(carryFwdLossesSchedules.getScheduleCFL(itr, financialYear, inputBeans));

		PartB_TI partB_TI = new PartB_TI(formSixteenDocument, salaryIncomeDocument, houseProperty, otherSourcesDocument,
				deductionDocument, memberPersonalInformation,scheduleSIDocument,capitalAssetDocument);
		itr4.setPartBTI(partB_TI.getPartBTI(itr, financialYear, inputBeans));

		ITR_ScheduleAMT iTR_ScheduleAMT = new ITR_ScheduleAMT(deductionDocument, deductionSchedTenADocumemt);
		itr4.setITRScheduleAMT(iTR_ScheduleAMT.getITItrScheduleAMT(itr, financialYear, inputBeans, itr4.getScheduleVIA(), itr4.getPartBTI()));

		ITR_ScheduleAMTC iTR_ScheduleAMTC = new ITR_ScheduleAMTC(scheduleAMTCDocument);
		itr4.setITRScheduleAMTC(iTR_ScheduleAMTC.getScheduleAMTC(itr, financialYear, inputBeans));

		PartB_TTI partB_TTI = new PartB_TTI(formSixteenDocument, salaryIncomeDocument, houseProperty,
				otherSourcesDocument, deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument,
				selfAssesmetTaxDocument, tdsFromothersDocument, scheduleSIDocument, capitalAssetDocument, immovablePropertyDocument,
				natureInvestmentDocument,signingAuthorityAccountsDocument,detailOfTrustDocument,foreignBankAccountDocument,financialInterestDocument,
				tcsDocument);
		itr4.setPartBTTI(partB_TTI.getPartBTTI(itr, financialYear, inputBeans));

		PartA_Gen1 partA_Gen1 = new PartA_Gen1(formSixteenDocument, salaryIncomeDocument, houseProperty, otherSourcesDocument,
				deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument, selfAssesmetTaxDocument,
				tdsFromothersDocument, scheduleSIDocument, capitalAssetDocument, immovablePropertyDocument,natureInvestmentDocument,
				signingAuthorityAccountsDocument,detailOfTrustDocument,foreignBankAccountDocument,financialInterestDocument, tcsDocument);
		itr4.setPartAGEN1(partA_Gen1.getPartAGEN1(itr, financialYear, inputBeans));

		PartA_Gen2 partA_Gen2 = new PartA_Gen2(memberPersonalInformation, natureBusinessDocument);
		itr4.setPartAGEN2(partA_Gen2.getPartAGen2(itr));

		//CapitalGainDocumentSchedules capitalGainDocumentSchedules = new CapitalGainDocumentSchedules(capitalAssetDocument);
		//itr4.setScheduleCGFor23(capitalGainDocumentSchedules.getSchedulecCgFor23(itr, financialYear, inputBeans));

		ITRScheduleSI iTRScheduleSI = new ITRScheduleSI(scheduleSIDocument, capitalAssetDocument, otherSourcesDocument,
				formSixteenDocument, salaryIncomeDocument, houseProperty, memberPersonalInformation);
		itr4.setScheduleSI(iTRScheduleSI.getScheduleSI(itr, financialYear));

		ForeignIncomeScheduleFSI foreignIncomeScheduleFSI = new ForeignIncomeScheduleFSI(foreignIncomeDocument);
		itr4.setITRScheduleFSI(foreignIncomeScheduleFSI.getITRScheduleFSI(itr));

		TRDetailsSchedule tRDetailsSchedule = new TRDetailsSchedule(taxReliefDocument);
		itr4.setScheduleTR1(tRDetailsSchedule.getScheduleTR1(itr));

		FADetailsSchedule fADetailsSchedule = new FADetailsSchedule(immovablePropertyDocument,natureInvestmentDocument,
				signingAuthorityAccountsDocument,detailOfTrustDocument,foreignBankAccountDocument,financialInterestDocument);
		itr4.setScheduleFA(fADetailsSchedule.getScheduleFA(itr));

		ScheduleFiveA scheduleFiveA = new ScheduleFiveA(scheduleFiveADocument);
		itr4.setSchedule5A(scheduleFiveA.getScheduleFiveA(itr));

		ExemptIncomeSchedule exemptIncomeSchedule = new ExemptIncomeSchedule(otherSourcesDocument, capitalAssetDocument);
		itr4.setScheduleEI(exemptIncomeSchedule.getScheduleEI(itr));

		ClubbingOfIncome clubbingOfIncome = new ClubbingOfIncome(clubIncomeDocument);
		itr4.setScheduleSPI(clubbingOfIncome.getScheduleSPI(itr));

		OtherInformationSchedule otherInformationSchedule = new OtherInformationSchedule(otherInformationDocument);
		itr4.setPARTAOI(otherInformationSchedule.getPARTAOI(itr));

		ESRSchedule eSRSchedule = new ESRSchedule(scheduleESRDocument);
		itr4.setScheduleESR(eSRSchedule.getScheduleESR(itr));

		ProfitLossSchedule profitLossSchedule = new ProfitLossSchedule(profitAndLossDocument);
		itr4.setPARTAPL(profitLossSchedule.getPARTAPL(itr));

		ALSchedule aLSchedule = new ALSchedule(assetAndLiabilityDocument);
		itr4.setScheduleAL(aLSchedule.getScheduleAL(itr));

		Schedule80_IA schedule80_IA = new Schedule80_IA(deductionDocument);
		itr4.setSchedule80IA(schedule80_IA.getSchedule80IA(itr));

		Schedule80_IB schedule80_IB = new Schedule80_IB(deductionDocument);
		itr4.setSchedule80IB(schedule80_IB.getSchedule80IB(itr));

		Schedule80_IC schedule80_IC = new Schedule80_IC(deductionDocument);
		itr4.setSchedule80IC(schedule80_IC.getSchedule80IC(itr));

		TCSSchedule tCSSchedule = new TCSSchedule(tcsDocument);
		itr4.setScheduleTCS(tCSSchedule.getScheduleTCS(itr));

		PartA_QD partA_QD = new PartA_QD(quantitativeUnitDocument, manufactureRawMatDocument, manufactureFinishedProductsDocument);
		itr4.setPARTAQD(partA_QD.getPARTAQD(itr));

		ITR_Schedule10A iTR_Schedule10A = new ITR_Schedule10A(deductionSchedTenADocumemt);
		itr4.setSchedule10A(iTR_Schedule10A.getITRSchedule10a(itr, financialYear, inputBeans));

		ITR_Schedule10AA iTR_Schedule10AA = new ITR_Schedule10AA(deductionSchedTenADocumemt);
		itr4.setSchedule10AA(iTR_Schedule10AA.getITRSchedule10aa(itr, financialYear, inputBeans));

		PartA_BS partA_BS = new PartA_BS(balanceSheetDocument);
		itr4.setPARTABS(partA_BS.getPartABalanceSheet(itr, financialYear));

		ITR4_ScheduleBP iTR4_ScheduleBP = new ITR4_ScheduleBP(incBusinessProfessionDoc, profitAndLossDocument, otherInformationDocument);
		itr4.setITR4ScheduleBP(iTR4_ScheduleBP.getITR4ScheduleBP(itr, itr4.getScheduleESR(), itr4.getSchedule10A(), itr4.getSchedule10AA()));

		ITR4_ScheduleUD iTR4_ScheduleUD = new ITR4_ScheduleUD(unabsorbedDepreciationDocument);
		itr4.setITR4ScheduleUD(iTR4_ScheduleUD.getITR4ScheduleUD(itr));

		MemberVerification memberVerification = new MemberVerification(memberPersonalInformation);
		itr4.setVerification(memberVerification.getVerification(itr));


		outputMap.put("theForm", itr4);
		/* This is where we generate XML */
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ITR.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			NamespacePrefixMapper prefixMapper = new ITRPrefixMapper();
			jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", prefixMapper);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://incometaxindiaefiling.gov.in/main ITRMain13.xsd");
			ITR itReturn = new ITR();
			itReturn.getITR4().add(itr4);
			jaxbMarshaller.marshal(itReturn, sw);
			//request.setAttribute("xml",sw.toString());
			outputMap.put("xml", sw.toString());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return outputMap;

	}
	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static String generateITR4(HstRequest request,HstResponse response) throws Exception {
		FinancialYear financialYear =  (FinancialYear) request.getAttribute("financialYear");
		Map<String,HippoBean> inputBeans = new HashMap<String, HippoBean>();
		Enumeration<String> enmAttrNames = request.getAttributeNames();
		while (enmAttrNames.hasMoreElements()) {
			String attrName = enmAttrNames.nextElement();
			Object anObj = request.getAttribute(attrName);
			if (anObj instanceof HippoBean) {
				inputBeans.put(anObj.getClass().getSimpleName().toLowerCase(), (HippoBean) anObj);
			}
		}
		Map<String,Object> outputMap = generateITR4(financialYear, inputBeans);
		String xml = null;
		if (outputMap != null) {
			for (String aKey:outputMap.keySet()) {
				Object anObj = outputMap.get(aKey);
				request.setAttribute(aKey, anObj);
				if (aKey.equals("xml")) {
					xml = (String) anObj;
				}
			}
		}
		return xml;
	}
}

