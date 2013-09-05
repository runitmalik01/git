package com.mootly.wcm.services.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR2;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4S;
import in.gov.incometaxindiaefiling.y2012_2013.ObjectFactory;

import java.io.StringWriter;
import java.math.BigInteger;
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
import com.mootly.wcm.beans.BusinessProfessionDocument;
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
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.NatureBusinessDocument;
import com.mootly.wcm.beans.NatureInvestmentDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SchFourtyFourAEDocument;
import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.SigningAuthorityAccountsDocument;
import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.schedules.y2012_2013.BroughtFwdLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.CapitalGainDocumentSchedules;
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
import com.mootly.wcm.model.schedules.y2012_2013.Form_ITR4S;
import com.mootly.wcm.model.schedules.y2012_2013.HouseIncomeDocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4S_IncomeDeductions;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4S_TaxComputation;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4S_TaxPaid;
import com.mootly.wcm.model.schedules.y2012_2013.ITRScheduleBPForITR4S;
import com.mootly.wcm.model.schedules.y2012_2013.ITRScheduleSI;
import com.mootly.wcm.model.schedules.y2012_2013.MemberVerification;
import com.mootly.wcm.model.schedules.y2012_2013.NatureOfBusiness;
import com.mootly.wcm.model.schedules.y2012_2013.OtherIncomeDocumentSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.PartA_Gen1;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TI;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TTI;
import com.mootly.wcm.model.schedules.y2012_2013.ScheduleFiveA;
import com.mootly.wcm.model.schedules.y2012_2013.TCSSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.TRDetailsSchedule;
import com.mootly.wcm.model.schedules.y2012_2013.TRP;
import com.mootly.wcm.model.schedules.y2012_2013.TaxesDocumentScheduleIT;
import com.mootly.wcm.model.schedules.y2012_2013.TdsOthersSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.TdsSalarySchedules;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class ITR4SXmlGeneratorService  {

	private static Logger log = LoggerFactory.getLogger(ITR4SXmlGeneratorService .class);

	/**
	 *
	 * @param financialYear
	 * @param inputBeans
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> generateITR4S(FinancialYear financialYear,Map<String,HippoBean> inputBeans) throws Exception {
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
		NatureBusinessDocument natureBusinessDocument = (NatureBusinessDocument) inputBeans.get(NatureBusinessDocument.class.getSimpleName().toLowerCase());
		TcsDocument tcsDocument = (TcsDocument) inputBeans.get(TcsDocument.class.getSimpleName().toLowerCase());
		BusinessProfessionDocument businessProfessionDocument = (BusinessProfessionDocument) inputBeans.get(BusinessProfessionDocument.class.getSimpleName().toLowerCase());
		SchFourtyFourAEDocument schFourtyFourAEDocument = (SchFourtyFourAEDocument) inputBeans.get(SchFourtyFourAEDocument.class.getSimpleName().toLowerCase());

		ITR4S itr4S = new ObjectFactory().createITR4S();
		ITR itr = new ITR();

		CreationInformation creationInformation = new CreationInformation();
		itr4S.setCreationInfo(creationInformation.getCreationInfo(itr));

		Form_ITR4S form_ITR4S = new Form_ITR4S();
		itr4S.setFormITR4S(form_ITR4S.getFormITR4S(itr));

		NatureOfBusiness natureOfBusiness = new NatureOfBusiness(natureBusinessDocument);
		itr4S.setNatOfBus(natureOfBusiness.getNatOfBus(itr));

		TaxesDocumentScheduleIT taxesDocumentScheduleIT = new TaxesDocumentScheduleIT(advanceTaxDocument, selfAssesmetTaxDocument);
		itr4S.setScheduleIT(taxesDocumentScheduleIT.getScheduleIT(itr));

		TdsSalarySchedules tdsSalarySchedules = new TdsSalarySchedules(formSixteenDocument, salaryIncomeDocument);
		itr4S.setTDSonSalaries(tdsSalarySchedules.getTDSonSalaries(itr));

		TdsOthersSchedules tdsOthersSchedules = new TdsOthersSchedules(tdsFromothersDocument);
		itr4S.setTDSonOthThanSals(tdsOthersSchedules.getTDSonOthThanSals(itr));

		TCSSchedule tCSSchedule = new TCSSchedule(tcsDocument);
		itr4S.setScheduleTCS(tCSSchedule.getScheduleTCS(itr));

		Donation80gSchedules donation80gSchedules = new Donation80gSchedules(deductionDocument,memberPersonalInformation,otherSourcesDocument);
		itr4S.setSchedule80G(donation80gSchedules.getSchedule80G(itr, financialYear, inputBeans));

		ITRScheduleBPForITR4S iTRScheduleBPForITR4S = new ITRScheduleBPForITR4S(businessProfessionDocument, schFourtyFourAEDocument);
		itr4S.setScheduleBPForITR4S(iTRScheduleBPForITR4S.getScheduleBPForITR4S(itr));

		ITR4S_IncomeDeductions iTR4S_IncomeDeductions = new ITR4S_IncomeDeductions(businessProfessionDocument, schFourtyFourAEDocument, houseProperty,
				deductionDocument, memberPersonalInformation, otherSourcesDocument);
		itr4S.setITR4SIncomeDeductions(iTR4S_IncomeDeductions.getITR4SIncomeDeductions(itr, financialYear, inputBeans));

		ITR4S_TaxComputation iTR4S_TaxComputation = new ITR4S_TaxComputation(businessProfessionDocument, schFourtyFourAEDocument, houseProperty,
				deductionDocument, memberPersonalInformation, otherSourcesDocument, formSixteenDocument);
		itr4S.setITR4STaxComputation(iTR4S_TaxComputation.getITR4STaxComputation(itr, financialYear, inputBeans));

		BigInteger tax= new BigInteger("0");
		tax = itr4S.getITR4STaxComputation().getTotTaxPlusIntrstPay();


		PartA_Gen1 partA_Gen1 = new PartA_Gen1(formSixteenDocument, salaryIncomeDocument, houseProperty, otherSourcesDocument,
				deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument, selfAssesmetTaxDocument,
				tdsFromothersDocument, scheduleSIDocument, capitalAssetDocument, immovablePropertyDocument,natureInvestmentDocument,
				signingAuthorityAccountsDocument,detailOfTrustDocument,foreignBankAccountDocument,financialInterestDocument, tcsDocument);
		itr4S.setPersonalInfo(partA_Gen1.getPersonalInfo(itr));

		PartB_TTI partB_TTI = new PartB_TTI(formSixteenDocument, salaryIncomeDocument, houseProperty,
				otherSourcesDocument, deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument,
				selfAssesmetTaxDocument, tdsFromothersDocument, scheduleSIDocument, capitalAssetDocument, immovablePropertyDocument,
				natureInvestmentDocument,signingAuthorityAccountsDocument,detailOfTrustDocument,foreignBankAccountDocument,financialInterestDocument,
				tcsDocument);
		itr4S.setTaxPaid(partB_TTI.getTaxPaid(itr, financialYear, inputBeans, tax));

		itr4S.setRefund(partB_TTI.getRefund(itr, financialYear, inputBeans, tax));

		BigInteger taxPayable = new BigInteger("0");
		BigInteger taxRefundable = new BigInteger("0");
		taxPayable = itr4S.getTaxPaid().getBalTaxPayable();
		taxRefundable = itr4S.getRefund().getRefundDue();

		itr4S.setFilingStatus(partA_Gen1.getFilingStatus(itr, taxPayable, taxRefundable));

		TRP tRP = new TRP(memberPersonalInformation);
		itr4S.setTaxReturnPreparer(tRP.getTaxReturnPreparer(itr));

		MemberVerification memberVerification = new MemberVerification(memberPersonalInformation);
		itr4S.setVerification(memberVerification.getVerification(itr));


		outputMap.put("theForm", itr4S);
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
			itReturn.getITR4S().add(itr4S);
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
	public static String generateITR4S(HstRequest request,HstResponse response) throws Exception {
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
		Map<String,Object> outputMap = generateITR4S(financialYear, inputBeans);
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

