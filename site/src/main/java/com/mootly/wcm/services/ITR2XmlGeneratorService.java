package com.mootly.wcm.services;

import in.gov.incometaxindiaefiling.y2012_2013.Address;
import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.AssesseeName;
import in.gov.incometaxindiaefiling.y2012_2013.CarryFwdLossDetail;
import in.gov.incometaxindiaefiling.y2012_2013.CreationInfo;
import in.gov.incometaxindiaefiling.y2012_2013.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2012_2013.DoneeWithPan;
import in.gov.incometaxindiaefiling.y2012_2013.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2012_2013.FilingStatus;
import in.gov.incometaxindiaefiling.y2012_2013.FormITR1;
import in.gov.incometaxindiaefiling.y2012_2013.FormITR2;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1IncomeDeductions;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1TaxComputation;
import in.gov.incometaxindiaefiling.y2012_2013.ITR2;
import in.gov.incometaxindiaefiling.y2012_2013.IncBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.IncCYLA;
import in.gov.incometaxindiaefiling.y2012_2013.IntrstPay;
import in.gov.incometaxindiaefiling.y2012_2013.LossSummaryDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ObjectFactory;
import in.gov.incometaxindiaefiling.y2012_2013.PartAGEN1;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTTI;
import in.gov.incometaxindiaefiling.y2012_2013.PersonalInfo;
import in.gov.incometaxindiaefiling.y2012_2013.Refund;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.TotalBFLossSetOff;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.AdjTotBFLossInBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.CurrentAYloss;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.LossCFFromPrev2NdYearFromAY;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.LossCFFromPrevYrToAY;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.TotalLossCFSummary;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.TotalOfBFLossesEarlierYrs;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.BusProfExclSpecProf;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.HP;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.LTCG;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.LossRemAftSetOff;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.OthSrcExclRaceHorse;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.OthSrcRaceHorse;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.STCG;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.Salary;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.TotalCurYr;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.TotalLossSetOff;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTDS1;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTDS2;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleVIA;
import in.gov.incometaxindiaefiling.y2012_2013.TDSonOthThanSal;
import in.gov.incometaxindiaefiling.y2012_2013.TDSonOthThanSals;
import in.gov.incometaxindiaefiling.y2012_2013.TDSonSalaries;
import in.gov.incometaxindiaefiling.y2012_2013.TDSonSalary;
import in.gov.incometaxindiaefiling.y2012_2013.TaxPaid;
import in.gov.incometaxindiaefiling.y2012_2013.TaxPayment;
import in.gov.incometaxindiaefiling.y2012_2013.TaxPayments;
import in.gov.incometaxindiaefiling.y2012_2013.TaxesPaid;
import in.gov.incometaxindiaefiling.y2012_2013.UsrDeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2012_2013.Verification;
import in.gov.incometaxindiaefiling.y2012_2013.Address.Phone;
import in.gov.incometaxindiaefiling.y2012_2013.Refund.DepositToBankAccount;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G.Don100Percent;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G.Don100PercentApprReqd;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G.Don50PercentApprReqd;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G.Don50PercentNoApprReqd;
import in.gov.incometaxindiaefiling.y2012_2013.Verification.Declaration;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.deduction.DeductionHead;
import com.mootly.wcm.model.deduction.DeductionSection;
import com.mootly.wcm.model.schedules.y2012_2013.CreationInformation;
import com.mootly.wcm.model.schedules.y2012_2013.Form_ITR2;
import com.mootly.wcm.model.schedules.y2012_2013.PartA_Gen1;
import com.mootly.wcm.services.DeductionListService;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.services.y2012_2013.ITRPrefixMapper;
import com.mootly.wcm.utils.XmlCalculation;
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

		ITR2 itr2 = new ObjectFactory().createITR2();
		ITR itr = new ITR();

		CreationInformation creationInformation = new CreationInformation();
		itr2.setCreationInfo(creationInformation.getCreationInfo(itr));

		Form_ITR2 form_ITR2 = new Form_ITR2();
		itr2.setFormITR2(form_ITR2.getFormITR2(itr));

		PartA_Gen1 partA_Gen1 = new PartA_Gen1(memberPersonalInformation);
		itr2.setPartAGEN1(partA_Gen1.getPartAGEN1(itr));




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

