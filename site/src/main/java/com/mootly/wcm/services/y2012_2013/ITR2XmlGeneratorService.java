package com.mootly.wcm.services.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR2;
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
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.ClubIncomeDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DetailOfTrustDocument;
import com.mootly.wcm.beans.FinancialInterestDocument;
import com.mootly.wcm.beans.ForeignBankAccountDocument;
import com.mootly.wcm.beans.ForeignIncomeDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.ImmovablePropertyDocument;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.NatureInvestmentDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.SigningAuthorityAccountsDocument;
import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.schedules.y2012_2013.BroughtFwdLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.CarryFwdLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.ClubbingOfIncome;
import com.mootly.wcm.model.schedules.y2012_2013.CreationInformation;
import com.mootly.wcm.model.schedules.y2012_2013.CurrentYearLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.DeductionVIASchedules;
import com.mootly.wcm.model.schedules.y2012_2013.Donation80gSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.ExemptIncomeSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.FADetailsSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.ForeignIncomeScheduleFSI;
import com.mootly.wcm.model.schedules.y2012_2013.Form16DocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.Form_ITR2;
import com.mootly.wcm.model.schedules.y2012_2013.HouseIncomeDocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.MemberVerification;
import com.mootly.wcm.model.schedules.y2012_2013.OtherIncomeDocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.PartA_Gen1;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TI;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TTI;
import com.mootly.wcm.model.schedules.y2012_2013.ScheduleFiveA;
import com.mootly.wcm.model.schedules.y2012_2013.TRDetailsSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.TaxesDocumentScheduleIT;
import com.mootly.wcm.model.schedules.y2012_2013.TdsOthersSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.TdsSalarySchedules;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class ITR2XmlGeneratorService  {

	private static Logger log = LoggerFactory.getLogger(ITR2XmlGeneratorService .class);

	/**
	 *
	 * @param financialYear
	 * @param inputBeans
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> generateITR2(FinancialYear financialYear,Map<String,HippoBean> inputBeans) throws Exception {
		Map<String,Object> outputMap = new HashMap<String, Object>();
		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>(); //not being used any where

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) inputBeans.get(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) inputBeans.get(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) inputBeans.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) inputBeans.get(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		TdsFromSalaryDocument tdsFromSalaryDocument = (TdsFromSalaryDocument) inputBeans.get(TdsFromSalaryDocument.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) inputBeans.get(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) inputBeans.get(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());
		DeductionDocument deductionDocument = (DeductionDocument) inputBeans.get(DeductionDocument.class.getSimpleName().toLowerCase());
		InterestDoc interestDoc = (InterestDoc) inputBeans.get(InterestDoc.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) inputBeans.get(FormSixteenDocument.class.getSimpleName().toLowerCase());
		RebateSec90Document rebateSec90Document = (RebateSec90Document) inputBeans.get(RebateSec90Document.class.getSimpleName().toLowerCase());
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

		ITR2 itr2 = new ObjectFactory().createITR2();
		ITR itr = new ITR();

		CreationInformation creationInformation = new CreationInformation();
		itr2.setCreationInfo(creationInformation.getCreationInfo(itr));

		Form_ITR2 form_ITR2 = new Form_ITR2();
		itr2.setFormITR2(form_ITR2.getFormITR2(itr));

		Form16DocumentSchedules form16DocumentSchedules = new Form16DocumentSchedules(formSixteenDocument, salaryIncomeDocument);
		itr2.setScheduleS(form16DocumentSchedules.getScheduleS(itr));

		HouseIncomeDocumentSchedules houseIncomeDocumentSchedules = new HouseIncomeDocumentSchedules(houseProperty);
		itr2.setScheduleHP(houseIncomeDocumentSchedules.getScheduleHP(itr));

		OtherIncomeDocumentSchedules otherIncomeDocumentSchedules = new OtherIncomeDocumentSchedules(otherSourcesDocument);
		itr2.setScheduleOS(otherIncomeDocumentSchedules.getScheduleOS(itr));

		DeductionVIASchedules deductionVIASchedules = new DeductionVIASchedules(deductionDocument,memberPersonalInformation,otherSourcesDocument);
		itr2.setScheduleVIA(deductionVIASchedules.getScheduleVIA(itr, financialYear, inputBeans));

		Donation80gSchedules donation80gSchedules = new Donation80gSchedules(deductionDocument,memberPersonalInformation,otherSourcesDocument);
		itr2.setSchedule80G(donation80gSchedules.getSchedule80G(itr, financialYear, inputBeans));

		TaxesDocumentScheduleIT taxesDocumentScheduleIT = new TaxesDocumentScheduleIT(advanceTaxDocument, selfAssesmetTaxDocument);
		itr2.setScheduleIT(taxesDocumentScheduleIT.getScheduleIT(itr));

		TdsSalarySchedules tdsSalarySchedules = new TdsSalarySchedules(formSixteenDocument, salaryIncomeDocument);
		itr2.setScheduleTDS1(tdsSalarySchedules.getScheduleTDS1(itr));

		TdsOthersSchedules tdsOthersSchedules = new TdsOthersSchedules(tdsFromothersDocument);
		itr2.setScheduleTDS2(tdsOthersSchedules.getScheduleTDS2(itr));

		BroughtFwdLossesSchedules broughtFwdLossesSchedules = new BroughtFwdLossesSchedules();
		itr2.setScheduleBFLA(broughtFwdLossesSchedules.getScheduleBFLA(itr, financialYear, inputBeans));

		CurrentYearLossesSchedules currentYearLossesSchedules = new CurrentYearLossesSchedules();
		itr2.setScheduleCYLA(currentYearLossesSchedules.getScheduleCYLA(itr, financialYear, inputBeans));

		CarryFwdLossesSchedules carryFwdLossesSchedules = new CarryFwdLossesSchedules(adjustmentOfLossesDoc);
		itr2.setScheduleCFL(carryFwdLossesSchedules.getScheduleCFL(itr, financialYear, inputBeans));

		PartB_TI partB_TI = new PartB_TI(formSixteenDocument, salaryIncomeDocument, houseProperty, otherSourcesDocument, deductionDocument, memberPersonalInformation,scheduleSIDocument);
		itr2.setPartBTI(partB_TI.getPartBTI(itr, financialYear, inputBeans));

		PartB_TTI partB_TTI = new PartB_TTI(formSixteenDocument, salaryIncomeDocument, houseProperty, otherSourcesDocument, deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument, selfAssesmetTaxDocument, tdsFromothersDocument, scheduleSIDocument );
		itr2.setPartBTTI(partB_TTI.getPartBTTI(itr, financialYear, inputBeans));

		PartA_Gen1 partA_Gen1 = new PartA_Gen1(formSixteenDocument, salaryIncomeDocument, houseProperty, otherSourcesDocument, deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument, selfAssesmetTaxDocument, tdsFromothersDocument, scheduleSIDocument );
		itr2.setPartAGEN1(partA_Gen1.getPartAGEN1(itr, financialYear, inputBeans));

		ForeignIncomeScheduleFSI foreignIncomeScheduleFSI = new ForeignIncomeScheduleFSI(foreignIncomeDocument);
		itr2.setITRScheduleFSI(foreignIncomeScheduleFSI.getITRScheduleFSI(itr));

		TRDetailsSchedule tRDetailsSchedule = new TRDetailsSchedule(taxReliefDocument);
		itr2.setScheduleTR1(tRDetailsSchedule.getScheduleTR1(itr));

		FADetailsSchedule fADetailsSchedule = new FADetailsSchedule(immovablePropertyDocument,natureInvestmentDocument,signingAuthorityAccountsDocument,detailOfTrustDocument,foreignBankAccountDocument,financialInterestDocument);
		itr2.setScheduleFA(fADetailsSchedule.getScheduleFA(itr));

		ScheduleFiveA scheduleFiveA = new ScheduleFiveA(scheduleFiveADocument);
		itr2.setSchedule5A(scheduleFiveA.getScheduleFiveA(itr));

		ExemptIncomeSchedule exemptIncomeSchedule = new ExemptIncomeSchedule(otherSourcesDocument, capitalAssetDocument);
		itr2.setScheduleEI(exemptIncomeSchedule.getScheduleEI(itr));

		ClubbingOfIncome clubbingOfIncome = new ClubbingOfIncome(clubIncomeDocument);
		itr2.setScheduleSPI(clubbingOfIncome.getScheduleSPI(itr));

		MemberVerification memberVerification = new MemberVerification(memberPersonalInformation);
		itr2.setVerification(memberVerification.getVerification(itr));


		outputMap.put("theForm", itr2);
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
			itReturn.getITR2().add(itr2);
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
	public static String generateITR2(HstRequest request,HstResponse response) throws Exception {
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
		Map<String,Object> outputMap = generateITR2(financialYear, inputBeans);
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
