package com.mootly.wcm.services.y2011_2012;

import in.gov.incometaxindiaefiling.y2011_2012.ITR;
import in.gov.incometaxindiaefiling.y2011_2012.ITR2;
import in.gov.incometaxindiaefiling.y2011_2012.ObjectFactory;

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
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.schedules.y2011_2012.BroughtFwdLossesSchedules;
import com.mootly.wcm.model.schedules.y2011_2012.CarryFwdLossesSchedules;
import com.mootly.wcm.model.schedules.y2011_2012.CreationInformation;
import com.mootly.wcm.model.schedules.y2011_2012.CurrentYearLossesSchedules;
import com.mootly.wcm.model.schedules.y2011_2012.DeductionVIASchedules;
import com.mootly.wcm.model.schedules.y2011_2012.Donation80gSchedules;
import com.mootly.wcm.model.schedules.y2011_2012.Form16DocumentSchedules;
import com.mootly.wcm.model.schedules.y2011_2012.Form_ITR2;
import com.mootly.wcm.model.schedules.y2011_2012.HouseIncomeDocumentSchedules;
import com.mootly.wcm.model.schedules.y2011_2012.PartA_Gen1;
import com.mootly.wcm.model.schedules.y2011_2012.TaxesDocumentScheduleIT;
import com.mootly.wcm.model.schedules.y2011_2012.TdsOthersSchedules;
import com.mootly.wcm.model.schedules.y2011_2012.TdsSalarySchedules;
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

		ITR2 itr2 = new ObjectFactory().createITR2();
		ITR itr = new ITR();

		CreationInformation creationInformation = new CreationInformation();
		itr2.setCreationInfo(creationInformation.getCreationInfo(itr));

		Form_ITR2 form_ITR2 = new Form_ITR2();
		itr2.setFormITR2(form_ITR2.getFormITR2(itr));

		PartA_Gen1 partA_Gen1 = new PartA_Gen1(memberPersonalInformation);
		itr2.setPartAGEN1(partA_Gen1.getPartAGEN1(itr));

		Form16DocumentSchedules form16DocumentSchedules = new Form16DocumentSchedules(formSixteenDocument, salaryIncomeDocument);
		itr2.setScheduleS(form16DocumentSchedules.getScheduleS(itr));

		HouseIncomeDocumentSchedules houseIncomeDocumentSchedules = new HouseIncomeDocumentSchedules(houseProperty);
		itr2.setScheduleHP(houseIncomeDocumentSchedules.getScheduleHP(itr));

		DeductionVIASchedules deductionVIASchedules = new DeductionVIASchedules(deductionDocument,memberPersonalInformation,otherSourcesDocument);
		itr2.setScheduleVIA(deductionVIASchedules.getScheduleVIA(itr, financialYear, inputBeans));

		Donation80gSchedules donation80gSchedules = new Donation80gSchedules(deductionDocument,memberPersonalInformation);
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

