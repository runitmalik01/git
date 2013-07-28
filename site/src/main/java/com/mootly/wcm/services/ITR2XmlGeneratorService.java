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
import com.mootly.wcm.services.DeductionListService;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.utils.XmlCalculation;

public class ITR2XmlGeneratorService  {

	private static Logger log = LoggerFactory.getLogger(ITR2XmlGeneratorService .class);

	public static Map<String,Object> generateITR2(FinancialYear financialYear,Map<String, HippoBean> inputBeans) throws Exception {
		return null;
	}
	public static String generateITR2(HstRequest request,HstResponse response) throws Exception {
		// TODO Auto-generated method stub

		FinancialYear financialYear =  (FinancialYear) request.getAttribute("financialYear");

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) request.getAttribute(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		TdsFromSalaryDocument tdsFromSalaryDocument = (TdsFromSalaryDocument) request.getAttribute(TdsFromSalaryDocument.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) request.getAttribute(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) request.getAttribute(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());
		DeductionDocument deductionDocument = (DeductionDocument) request.getAttribute(DeductionDocument.class.getSimpleName().toLowerCase());
		InterestDoc interestDoc = (InterestDoc) request.getAttribute(InterestDoc.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());
		RebateSec90Document rebateSec90Document = (RebateSec90Document) request.getAttribute(RebateSec90Document.class.getSimpleName().toLowerCase());
		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) request.getAttribute(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());

		ITR2 itr2 = new ObjectFactory().createITR2();
		CreationInfo creationInfo = new CreationInfo();
		creationInfo.setSWVersionNo("1.0");
		creationInfo.setIntermediaryCity("Delhi");
		creationInfo.setSWCreatedBy("Wealth4India");
		creationInfo.setXMLCreatedBy("Wealth4India");
		try {
			DatatypeFactory df = DatatypeFactory.newInstance();
			GregorianCalendar gc = new GregorianCalendar();
			XMLGregorianCalendar xmlGC =   DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH)+1,gc.get(Calendar.DAY_OF_MONTH),DatatypeConstants.FIELD_UNDEFINED);
			creationInfo.setXMLCreationDate(xmlGC);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		itr2.setCreationInfo(creationInfo);

		XmlCalculation xmlCalculation = new XmlCalculation();
		PersonalInfo personalInfo = new PersonalInfo();
		AssesseeName assesseeName = new AssesseeName();
		Address address= new Address();
		FilingStatus filingstatus = new FilingStatus();
		ITR1IncomeDeductions incomeDeductions = new ITR1IncomeDeductions();
		DeductUndChapVIA deductUndChapVIA = new DeductUndChapVIA();
		ITR1TaxComputation itr1TaxComputation = new ITR1TaxComputation();
		TaxPaid taxPaid = new TaxPaid();
		TaxesPaid taxesPaid = new TaxesPaid();
		Refund refund = new Refund();
		Verification verification = new Verification();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Schedule80G schedule80G = new Schedule80G();
		FormITR2 formITR2 = new FormITR2();
		UsrDeductUndChapVIA usrDeductUndChapVIA = new UsrDeductUndChapVIA();

		//Form_ITR1
		formITR2.setFormName("ITR-2");
		formITR2.setDescription("For Indls and HUFs not having Income from Business or Profession");
		formITR2.setAssessmentYear("2013");
		formITR2.setSchemaVer("Ver1.0");
		formITR2.setFormVer("Ver1.0");
		itr2.setFormITR2(formITR2);

		//personal information
		assesseeName.setFirstName(memberPersonalInformation.getFirstName().toUpperCase());
		assesseeName.setSurNameOrOrgName(memberPersonalInformation.getLastName().toUpperCase());
		assesseeName.setMiddleName(memberPersonalInformation.getMiddleName().toUpperCase());
		personalInfo.setAssesseeName(assesseeName);
		personalInfo.setPAN(memberPersonalInformation.getPAN().toUpperCase());
		address.setResidenceNo(memberPersonalInformation.getFlatDoorBuilding().toUpperCase());
		address.setRoadOrStreet(memberPersonalInformation.getRoadStreet().toUpperCase());
		address.setLocalityOrArea(memberPersonalInformation.getAreaLocality().toUpperCase());
		address.setCityOrTownOrDistrict(memberPersonalInformation.getTownCityDistrict().toUpperCase());
		address.setStateCode(memberPersonalInformation.getState().toUpperCase());
		address.setCountryCode(memberPersonalInformation.getCountry().toUpperCase());
		address.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getPinCode()));
		Phone phone = new Phone();
		phone.setSTDcode(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getStdCode()));
		phone.setPhoneNo(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getPhone()));
		address.setPhone(phone);
		address.setMobileNo(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getMobile()));
		address.setMobileNoSec(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getMobile1()));
		address.setEmailAddress(memberPersonalInformation.getEmail());
		personalInfo.setAddress(address);
		personalInfo.setDOB(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getDOB()));
		if(memberPersonalInformation.getEmploye_category()!=null){
			personalInfo.setEmployerCategory(memberPersonalInformation.getEmploye_category());
		}

		personalInfo.setGender(memberPersonalInformation.getSex());
		personalInfo.setStatus(memberPersonalInformation.getFilingStatus());

		PartAGEN1 partAGEN1 = new PartAGEN1();
		partAGEN1.setPersonalInfo(personalInfo);

		//Income Deductions
		BigInteger GrossIncome=new BigInteger("0");
		BigInteger GrossIncomeTotal=new BigInteger("0");
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList();
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					if(formSixteenDetail.getIncome_chargable_tax()!=null){
						GrossIncome=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax());
						GrossIncomeTotal=GrossIncomeTotal.add(GrossIncome);
					}
				}
			}
		}
		request.setAttribute("salaryincome", GrossIncomeTotal);
		BigInteger Penson=new BigInteger("0");
		if(salaryIncomeDocument!=null){
			Penson = indianCurrencyHelper.bigIntegerRound(salaryIncomeDocument.getTotal());
		}
		request.setAttribute("Penson", Penson);
		BigInteger TotalSalaryIncome=new BigInteger("0");
		TotalSalaryIncome = GrossIncomeTotal.add(Penson);

		long houseIncome=0;
		long houseIncomeTotal=0;
		if(houseProperty!=null){
			List<HouseIncomeDetail> listOfHouseIncomeDetail = houseProperty.getHouseIncomeDetailList() ;
			if (listOfHouseIncomeDetail!= null && listOfHouseIncomeDetail.size() > 0 ){
				for(HouseIncomeDetail houseIncomeDetail: listOfHouseIncomeDetail){
					houseIncome = indianCurrencyHelper.longRound(houseIncomeDetail.getIncome_hproperty());
					houseIncomeTotal = houseIncomeTotal+houseIncome;
				}
			}
		}

		BigInteger OtherIncome = new BigInteger("0");
		if(otherSourcesDocument!=null){
			OtherIncome = indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getTaxable_income());
		}

		long grsstotal = xmlCalculation.grossTotal(request, response);

		incomeDeductions.setGrossTotIncome(grsstotal);	// calculation needed(incomefromsalary+house income+othersrcincome)
		//added deduction with null values (incomplete)
		Double grossInvestment = 0D;
		Map<String,Object> totalMapForJSDe = new HashMap<String, Object>();
		DeductionListService deductionListService=new DeductionListService();
		Map<String,DeductionSection> deductionSectionMap=deductionListService.getDeductionSectionMap().get(financialYear);
		if(deductionDocument!=null){
			if (deductionDocument.getDeductionDocumentDetailList() != null && deductionDocument.getDeductionDocumentDetailList().size() > 0 ){
				for(String key:deductionSectionMap.keySet()){
					Double sumSection=0D;
					DeductionSection deductionsec=deductionSectionMap.get(key);
					if(deductionsec.getListOfDeductionHead().size()!=0){
						for(DeductionHead head:deductionsec.getListOfDeductionHead()){
							Double sumHead=0D;
							for(DeductionDocumentDetail deductionDocumentDetail:deductionDocument.getDeductionDocumentDetailList()){
								if(deductionDocumentDetail.getHead().equals(head.getName().replaceAll("-", "_"))){
									sumHead=sumHead+deductionDocumentDetail.getInvestment();
								}
							}
							String sanitizedKey="total_"+head.getName().replaceAll("-", "_");
							totalMapForJSDe.put(sanitizedKey, sumHead);
						}
					}
					for(DeductionDocumentDetail deductionDocumentDetail:deductionDocument.getDeductionDocumentDetailList()){
						if(deductionDocumentDetail.getSection().equals(key)){
							sumSection=sumSection+deductionDocumentDetail.getInvestment();
						}
					}
					grossInvestment = grossInvestment + sumSection;
					String sanitizedKey="total_"+key.replaceAll("-", "_");
					totalMapForJSDe.put(sanitizedKey,sumSection);
				}
			}
		}else{
			Double sumHead=0D;Double sumSection=0D;
			for(String key:deductionSectionMap.keySet()){

				DeductionSection deductionsec=deductionSectionMap.get(key);
				if(deductionsec.getListOfDeductionHead().size()!=0){
					for(DeductionHead head:deductionsec.getListOfDeductionHead()){
						String sanitizedKey="total_"+head.getName().replaceAll("-", "_");
						totalMapForJSDe.put(sanitizedKey, sumHead);
					}
				}
				String sanitizedKeysec="total_"+key.replaceAll("-", "_");
				totalMapForJSDe.put(sanitizedKeysec,sumSection);
			}
		}
		//totalMapForJSDe.put("ageInYears",ageInYears);
		totalMapForJSDe.put("isSeniorCitizen",financialYear.isSeniorCitizen(memberPersonalInformation.getDOB().getTime()));
		totalMapForJSDe.put("salarypension",TotalSalaryIncome);
		totalMapForJSDe.put("othersources",OtherIncome);
		totalMapForJSDe.put("houseproperty",houseIncomeTotal);
		Map<String,Object> resultMapDe = ScreenCalculatorService.getScreenCalculations("Chapter6Calc.js", request.getParameterMap(), totalMapForJSDe);
		Double totaleligiblededuction=0D;
		if(resultMapDe.containsKey("total_eligiblededuction")) {
			totaleligiblededuction=Double.parseDouble(resultMapDe.get("total_eligiblededuction").toString());
		}
		Class[] partypes = new Class[]{BigInteger.class};
		for(String keySection:deductionSectionMap.keySet()){
			String methodname="setSection"+keySection.toUpperCase();
			if(keySection.contains("ccd_1"))
				methodname="setSection80CCDEmployeeOrSE";
			if(keySection.contains("ccd_2"))
				methodname="setSection80CCDEmployer";
			String eligbleSection="total_"+keySection.replaceAll("-", "_");

			if(resultMapDe.containsKey(eligbleSection)){
				try {
					Method meth = DeductUndChapVIA.class.getMethod(methodname, partypes);
					Method methusr = UsrDeductUndChapVIA.class.getMethod(methodname, partypes);
					Object[] args = new Object[]{new BigInteger(String.valueOf(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapDe.get(eligbleSection).toString()))))};
					Object[] argsusr=new Object[]{new BigInteger(String.valueOf(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(totalMapForJSDe.get(eligbleSection).toString()))))};
					meth.invoke(deductUndChapVIA, args);
					methusr.invoke(usrDeductUndChapVIA, argsusr);
				}catch (NoSuchMethodException e) {
					log.warn ("The following method does not exist in this year's return " + methodname + " will continue with next method");
				}
			}
		}
		deductUndChapVIA.setTotalChapVIADeductions(indianCurrencyHelper.bigIntegerRound(totaleligiblededuction));
		usrDeductUndChapVIA.setTotalChapVIADeductions(indianCurrencyHelper.bigIntegerRound(grossInvestment));
		ScheduleVIA scheduleVIA = new ScheduleVIA();
		scheduleVIA.setUsrDeductUndChapVIA(usrDeductUndChapVIA);
		scheduleVIA.setDeductUndChapVIA(deductUndChapVIA);
		itr2.setScheduleVIA(scheduleVIA);
		long TotalIncome = grsstotal-indianCurrencyHelper.longRound(totaleligiblededuction);

		Map<String,Object> totalMapForJS = new HashMap<String, Object>();
		totalMapForJS.put("cbassyear",financialYear.getDisplayAssessmentYear());
		totalMapForJS.put("cbasstype", memberPersonalInformation.getFilingStatus());
		//totalMapForJS.put("cbasstype", "I");
		totalMapForJS.put("cbresistatus",memberPersonalInformation.getResidentCategory());
		totalMapForJS.put("txtNetIncome",TotalIncome);
		boolean isSeniorCitizen = financialYear.isSeniorCitizen(memberPersonalInformation.getDOB().getTime());
		if(isSeniorCitizen){
			boolean isSuperSeniorCitizen = financialYear.isSuperSeniorCitizen(memberPersonalInformation.getDOB().getTime());
			if(isSuperSeniorCitizen){
				totalMapForJS.put("cbasscategory","Super Senior Citizen");
			}else
				totalMapForJS.put("cbasscategory","Senior Citizen");
		}
		else
			totalMapForJS.put("cbasscategory",memberPersonalInformation.getSex());

		Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", request.getParameterMap(), totalMapForJS);
		BigInteger EduCess = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtEduCess").toString()));
		BigInteger HigherEduCess =indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtHEduCess").toString()));
		BigInteger TotalEduCess = EduCess.add(HigherEduCess);

		BigInteger Relief89 =new BigInteger ("0");
		BigInteger Relief89Total =new BigInteger ("0");
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList() ;
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					if(formSixteenDetail.getRelief_2()!=null){
						Relief89=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getRelief_2());
						Relief89Total=Relief89Total.add(Relief89);
					}
				}
			}
		}

		PartBTTI partBTTI =new PartBTTI();
		BigInteger advancetax =new BigInteger ("0");
		//TaxPaid and TaxesPaid
		if(advanceTaxDocument!=null){
			advancetax=indianCurrencyHelper.bigIntegerRound(advanceTaxDocument.getTotal_Amount());
		}
		taxesPaid.setAdvanceTax(advancetax);

		BigInteger bigTdsSalary=new BigInteger ("0");
		BigInteger bigTotalTdsSalary=new BigInteger ("0");
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList();
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					if(formSixteenDetail.getDed_ent_4()!=null){
						bigTdsSalary=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getDed_ent_4());
						bigTotalTdsSalary= bigTotalTdsSalary.add(bigTdsSalary);
					}
				}
			}
		}
		//if(tdsFromSalaryDocument!=null){
		//bigTotalTdsSalary= indianCurrencyHelper.bigIntegerRound(tdsFromSalaryDocument.getTotal_Amount());
		//}
		request.setAttribute("bigTotalTdsSalary", bigTotalTdsSalary);

		BigInteger bigTotalTdsOther=new BigInteger ("0");
		if(tdsFromothersDocument!=null){
			bigTotalTdsOther=indianCurrencyHelper.bigIntegerRound(tdsFromothersDocument.getTotal_Amount());
		}
		request.setAttribute("bigTotalTdsOther", bigTotalTdsOther);

		BigInteger bigTotalTds=bigTotalTdsSalary.add(bigTotalTdsOther);
		taxesPaid.setTDS(bigTotalTds);

		BigInteger selfassessmenttax = new BigInteger("0");
		if(selfAssesmetTaxDocument!=null){
			selfassessmenttax = indianCurrencyHelper.bigIntegerRound(selfAssesmetTaxDocument.getTotal_Amount());
		}
		taxesPaid.setSelfAssessmentTax(selfassessmenttax);
		//calculation needed (advancetax+tds+selfassessmenttax)

		taxesPaid.setTotalTaxesPaid(bigTotalTds.add(advancetax).add(selfassessmenttax));
		taxPaid.setTaxesPaid(taxesPaid);
		BigInteger BalTaxPayable = new BigInteger("0");
		//BalTaxPayable = itr1TaxComputation.getTotTaxPlusIntrstPay().subtract(taxesPaid.getTotalTaxesPaid());
		request.setAttribute("BalTaxPayable",BalTaxPayable);
		if (BalTaxPayable.compareTo(BigInteger.ZERO) > 0){
			taxPaid.setBalTaxPayable(BalTaxPayable); // calculation needed (totaltaxintrstpay-totaltaxpaid)
		}else{
			taxPaid.setBalTaxPayable(new BigInteger("0"));
		}
		partBTTI.setTaxPaid(taxPaid);
		itr2.setPartBTTI(partBTTI);
		//refund
		if (BalTaxPayable.compareTo(BigInteger.ZERO) < 0){
			refund.setRefundDue(BalTaxPayable.multiply(new BigInteger("-1")));// need to be calculated
		}else{
			refund.setRefundDue(new BigInteger("0"));
		}
		refund.setBankAccountNumber(memberPersonalInformation.getBD_ACC_NUMBER().toUpperCase());
		refund.setEcsRequired(memberPersonalInformation.getBD_ECS());
		DepositToBankAccount depositToBankAccount = new DepositToBankAccount();
		depositToBankAccount.setIFSCCode(memberPersonalInformation.getFlexField("flex_string_IFSCCode", "").toUpperCase());
		depositToBankAccount.setBankAccountType(memberPersonalInformation.getBD_TYPE_ACC().toUpperCase());
		refund.setDepositToBankAccount(depositToBankAccount);
		partBTTI.setRefund(refund);
		itr2.setPartBTTI(partBTTI);

		//Filing Status
		if(memberPersonalInformation.getWard_circle()!=null){
			filingstatus.setDesigOfficerWardorCircle(memberPersonalInformation.getWard_circle());
		}
		filingstatus.setReturnFileSec(Long.parseLong(memberPersonalInformation.getReturnSection()));
		filingstatus.setReturnType(memberPersonalInformation.getReturnType());
		filingstatus.setResidentialStatus(memberPersonalInformation.getResidentCategory());
		filingstatus.setPortugeseCC5A(memberPersonalInformation.getPortugesecivil());
		if (BalTaxPayable.compareTo(BigInteger.ZERO) > 0){
			filingstatus.setTaxStatus("TP");
		}else
			if (BalTaxPayable.compareTo(BigInteger.ZERO) < 0){
				filingstatus.setTaxStatus("TR");
			}else
				filingstatus.setTaxStatus("NT");

		//filingstatus.setPortugeseCC5A(memberPersonalInformation.getPortugesecivil());

		if (memberPersonalInformation.getReturnType().equals("R")) {
			filingstatus.setAckNoOriginalReturn(memberPersonalInformation.getOriginalAckNo());
			filingstatus.setOrigRetFiledDate(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getOriginalAckDate()));

			if(memberPersonalInformation.getDefective().equals("Y")){
				filingstatus.setNoticeNo(memberPersonalInformation.getNoticeNo());
				filingstatus.setNoticeDate(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getNoticeDate()));
				filingstatus.setReceiptNo(memberPersonalInformation.getReceiptNo());
			}
		}

		partAGEN1.setFilingStatus(filingstatus);
		itr2.setPartAGEN1(partAGEN1);

		//Schedule80G

		BigInteger Total100Appr = new BigInteger("0");
		BigInteger Total100NoAppr = new BigInteger("0");
		BigInteger Total50Appr = new BigInteger("0");
		BigInteger Total50NoAppr = new BigInteger("0");
		if(deductionDocument!=null){
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
							don100PercentApprReqd.getDoneeWithPan().add(doneeWithPan);
							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total100Appr = Total100Appr.add(Investment);
							long adjGrossTotal=grsstotal - totaleligiblededuction.longValue();
							long NetQualifyLmt=(long) (adjGrossTotal*0.1);
							if(Total100Appr.longValue()  > 0){
								if(NetQualifyLmt>Total100Appr.longValue()){
									don100PercentApprReqd.setTotEligibleDon100PercentApprReqd(Total100Appr);
								}else if(NetQualifyLmt<=Total100Appr.longValue() && NetQualifyLmt>0){
									don100PercentApprReqd.setTotEligibleDon100PercentApprReqd(indianCurrencyHelper.longToBigInteger(NetQualifyLmt));
								}else if(NetQualifyLmt<Total100Appr.longValue() && NetQualifyLmt<=0){
									don100PercentApprReqd.setTotEligibleDon100PercentApprReqd(new BigInteger("0"));
								}
							}
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
							don50PercentApprReqd.getDoneeWithPan().add(doneeWithPan);
							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total50Appr = Total50Appr.add(Investment);
							don50PercentApprReqd.setTotDon50PercentApprReqd(Total50Appr);
							long adjGrossTotal=grsstotal - totaleligiblededuction.longValue();
							long NetQualifyLmt=(long) (adjGrossTotal*0.1);
							if(Total50Appr.longValue()  > 0){
								if(NetQualifyLmt>Total50Appr.longValue()){
									don50PercentApprReqd.setTotEligibleDon50PercentApprReqd(Total50Appr.divide(new BigInteger("2")));
								}else if(NetQualifyLmt<=Total50Appr.longValue() && NetQualifyLmt>0){
									don50PercentApprReqd.setTotEligibleDon50PercentApprReqd(indianCurrencyHelper.longToBigInteger(NetQualifyLmt));
								}else if(NetQualifyLmt<Total100Appr.longValue() && NetQualifyLmt<=0){
									don50PercentApprReqd.setTotEligibleDon50PercentApprReqd(new BigInteger("0"));
								}
							}
							don50PercentApprReqd.setTotEligibleDon50PercentApprReqd(Total50Appr.divide(new BigInteger("2")));
							schedule80G.setDon50PercentApprReqd(don50PercentApprReqd);
						}
						schedule80G.setTotalDonationsUs80G(Total100NoAppr.add(Total100Appr).add(Total50NoAppr).add(Total50Appr));
						schedule80G.setTotalEligibleDonationsUs80G(scheduleVIA.getDeductUndChapVIA().getSection80G());
					}
				}
				itr2.setSchedule80G(schedule80G);
			}
		}

		//TDSonSalaries
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList();
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				ScheduleTDS1 scheduleTDS1 = new ScheduleTDS1();
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					TDSonSalary tdsonSalary = new TDSonSalary();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					if(formSixteenDetail.getDed_ent_4()!=null && formSixteenDetail.getDed_ent_4()!=0.0){
						if(formSixteenDetail.getTan_deductor()!=null){
							employerOrDeductorOrCollectDetl.setTAN(formSixteenDetail.getTan_deductor().toUpperCase());
						}
						if(formSixteenDetail.getEmployer()!=null){
							employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(formSixteenDetail.getEmployer().toUpperCase());
						}
						tdsonSalary.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
						if(formSixteenDetail.getIncome_chargable_tax()!=null){
							tdsonSalary.setIncChrgSal(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax()));
						}
						if(formSixteenDetail.getDed_ent_4()!=null){
							tdsonSalary.setTotalTDSSal(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getDed_ent_4()));
						}
						scheduleTDS1.getTDSonSalary().add(tdsonSalary);
						itr2.setScheduleTDS1(scheduleTDS1);
					}
				}
			}
		}

		//TDSonOthThanSals
		if(tdsFromothersDocument!=null){
			List<TdsOthersDetail> listOfTdsFromOthers = tdsFromothersDocument.getTdsSalaryDetailList();
			if (listOfTdsFromOthers != null && listOfTdsFromOthers.size() > 0 ){
				ScheduleTDS2 scheduleTDS2 = new ScheduleTDS2();
				for(TdsOthersDetail tdsOthersDetail:listOfTdsFromOthers){
					TDSonOthThanSal tdsonOthThanSal = new TDSonOthThanSal();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					employerOrDeductorOrCollectDetl.setTAN(tdsOthersDetail.getTan_Deductor().toUpperCase());
					employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(tdsOthersDetail.getName_Deductor().toUpperCase());
					tdsonOthThanSal.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
					tdsonOthThanSal.setTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.getTotal_TaxDeductor()));
					tdsonOthThanSal.setClaimOutOfTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.getP_Amount()));
					scheduleTDS2.getTDSonOthThanSal().add(tdsonOthThanSal);
				}
				itr2.setScheduleTDS2(scheduleTDS2);
			}
		}

		//Ajustment Of Losses begins (CYLA, BFLA, CFL)

		Double HPLoss = 0d;
		Double totalHPLoss = 0d;
		Double LTCLoss = 0d;
		Double totalLTCLoss = 0d;
		Double STCLoss = 0d;
		Double totalSTCLoss = 0d;
		Double MaintainingRaceHorseLoss = 0d;
		Double totalMaintainingRaceHorseLoss = 0d;

		if(adjustmentOfLossesDoc != null){
			List<AdjustmentOfLossesCom> listofAdjustmentOfLossesCom = adjustmentOfLossesDoc.getAdjustmentOfLossesList() ;
			if ( listofAdjustmentOfLossesCom != null && listofAdjustmentOfLossesCom.size() > 0 ){
				for(AdjustmentOfLossesCom adjustmentOfLossesCom:listofAdjustmentOfLossesCom){
					if(adjustmentOfLossesCom.getNameOfHead().equals("House Property Loss")){
						HPLoss = adjustmentOfLossesCom.getAmount();
						totalHPLoss = totalHPLoss + HPLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Long Term Capital Loss")){
						LTCLoss = adjustmentOfLossesCom.getAmount();
						totalLTCLoss = totalLTCLoss + LTCLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Short Term Capital Loss")){
						STCLoss = adjustmentOfLossesCom.getAmount();
						totalSTCLoss = totalSTCLoss + STCLoss;
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Owning and Maintaining Race Horses")){
						MaintainingRaceHorseLoss = adjustmentOfLossesCom.getAmount();
						totalMaintainingRaceHorseLoss = totalMaintainingRaceHorseLoss + MaintainingRaceHorseLoss;
					}
				}
			}
		}
		Map<String,Object> totalMapForLosses = new HashMap<String, Object>();
		totalMapForLosses.put("salaryIncome",TotalSalaryIncome);
		totalMapForLosses.put("houseIncome",houseIncomeTotal);
		totalMapForLosses.put("otherIncome",OtherIncome);
		totalMapForLosses.put("maintainingRaceHorseIncome",0);
		totalMapForLosses.put("LTCGain",0);
		totalMapForLosses.put("STCGain",0);
		totalMapForLosses.put("houseIncomeLoss", totalHPLoss);
		totalMapForLosses.put("LTCLoss", totalLTCLoss);
		totalMapForLosses.put("STCLoss", totalSTCLoss);
		totalMapForLosses.put("MaintainingRaceHorseLoss", totalMaintainingRaceHorseLoss);

		Map<String,Object> resultMapLosses = ScreenCalculatorService.getScreenCalculations("lossesCalculation.js", request.getParameterMap(), totalMapForLosses);

		//Schedule CYLA Begins

		ScheduleCYLA scheduleCYLA = new ScheduleCYLA();
		Salary salary = new Salary();
		IncCYLA incCYLA = new IncCYLA();
		incCYLA.setIncOfCurYrUnderThatHead(TotalSalaryIncome);
		incCYLA.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncome").toString())));
		incCYLA.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncome").toString())));
		incCYLA.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedSalaryIncome").toString())));
		salary.setIncCYLA(incCYLA);
		scheduleCYLA.setSalary(salary);

		HP hP = new HP();
		IncCYLA inCCYLA = new IncCYLA();
		if(houseIncomeTotal>0){
			inCCYLA.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(houseIncomeTotal));
		}else
			inCCYLA.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		inCCYLA.setBusLossSetoff(new BigInteger("0"));
		inCCYLA.setHPlossCurYrSetoff(new BigInteger("0"));
		inCCYLA.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncomeAftHI").toString())));
		inCCYLA.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedHouseIncome").toString())));
		hP.setIncCYLA(inCCYLA);
		scheduleCYLA.setHP(hP);

		BusProfExclSpecProf busProfExclSpecProf = new BusProfExclSpecProf();
		IncCYLA iNCCYLA = new IncCYLA();
		iNCCYLA.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		iNCCYLA.setBusLossSetoff(new BigInteger("0"));
		iNCCYLA.setHPlossCurYrSetoff(new BigInteger("0"));
		iNCCYLA.setOthSrcLossNoRaceHorseSetoff(new BigInteger("0"));
		iNCCYLA.setIncOfCurYrAfterSetOff(new BigInteger("0"));
		busProfExclSpecProf.setIncCYLA(iNCCYLA);
		scheduleCYLA.setBusProfExclSpecProf(busProfExclSpecProf);

		STCG sTCG = new STCG();
		IncCYLA incCYLAforSTCG = new IncCYLA();
		long STCGain = 0; //initialize Short Term Cpital Gain because Capital Gain screen is not completed
		if(STCGain>0){
			incCYLAforSTCG.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(STCGain));
		}else
			incCYLAforSTCG.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		incCYLAforSTCG.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncomeAftSTC").toString())));
		incCYLAforSTCG.setBusLossSetoff(new BigInteger("0"));
		incCYLAforSTCG.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncomeAftSTC").toString())));
		incCYLAforSTCG.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedSTCGain").toString())));
		sTCG.setIncCYLA(incCYLAforSTCG);
		scheduleCYLA.setSTCG(sTCG);

		LTCG lTCG = new LTCG();
		IncCYLA incCYLAforLTCG = new IncCYLA();
		long LTCGain = 0; //initialize Short Term Cpital Gain because Capital Gain screen is not completed
		if(LTCGain>0){
			incCYLAforLTCG.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(LTCGain));
		}else
			incCYLAforLTCG.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		incCYLAforLTCG.setBusLossSetoff(new BigInteger("0"));
		incCYLAforLTCG.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncomeAftLTC").toString())));
		incCYLAforLTCG.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncomeAftLTC").toString())));
		incCYLAforLTCG.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedLTCGain").toString())));
		lTCG.setIncCYLA(incCYLAforLTCG);
		scheduleCYLA.setLTCG(lTCG);

		OthSrcExclRaceHorse othSrcExclRaceHorse = new OthSrcExclRaceHorse();
		IncCYLA incCYLAforOtherRaceHorse = new IncCYLA();
		if(OtherIncome.longValue()>0){
			incCYLAforOtherRaceHorse.setIncOfCurYrUnderThatHead(OtherIncome);
		}else
			incCYLAforOtherRaceHorse.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		incCYLAforOtherRaceHorse.setBusLossSetoff(new BigInteger("0"));
		incCYLAforOtherRaceHorse.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncomeAftOI").toString())));
		incCYLAforOtherRaceHorse.setOthSrcLossNoRaceHorseSetoff(new BigInteger("0"));
		incCYLAforOtherRaceHorse.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedOtherIncome").toString())));
		othSrcExclRaceHorse.setIncCYLA(incCYLAforOtherRaceHorse);
		scheduleCYLA.setOthSrcExclRaceHorse(othSrcExclRaceHorse);

		OthSrcRaceHorse othSrcRaceHorse = new OthSrcRaceHorse();
		IncCYLA incCYLAforRaceHorse = new IncCYLA();
		long SrcRaceHorse = 0;//initialize Maintaining Race Horse Income because it is not included in other sources screen
		if(SrcRaceHorse>0){
			incCYLAforRaceHorse.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(SrcRaceHorse));
		}else
			incCYLAforRaceHorse.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		incCYLAforRaceHorse.setBusLossSetoff(new BigInteger("0"));
		incCYLAforRaceHorse.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncomeAftRH").toString())));
		incCYLAforRaceHorse.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncomeAftHR").toString())));
		incCYLAforRaceHorse.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedmaintainingRaceHorseIncome").toString())));
		othSrcRaceHorse.setIncCYLA(incCYLAforRaceHorse);
		scheduleCYLA.setOthSrcRaceHorse(othSrcRaceHorse);

		TotalCurYr totalCurYr = new TotalCurYr();
		if(houseIncomeTotal<0){
		totalCurYr.setTotHPlossCurYr(indianCurrencyHelper.longToBigInteger(houseIncomeTotal));
		}else
			totalCurYr.setTotHPlossCurYr(new BigInteger("0"));
		totalCurYr.setTotBusLoss(new BigInteger("0"));
		if(OtherIncome.longValue()<0){
			totalCurYr.setTotOthSrcLossNoRaceHorse(OtherIncome.multiply(new BigInteger("-1")));
		}else
			totalCurYr.setTotOthSrcLossNoRaceHorse(new BigInteger("0"));
		scheduleCYLA.setTotalCurYr(totalCurYr);

		TotalLossSetOff totalLossSetOff = new TotalLossSetOff();
		totalLossSetOff.setTotHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalHPLossSetoff").toString())));
		totalLossSetOff.setTotBusLossSetoff(new BigInteger("0"));
		totalLossSetOff.setTotOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalOILossSetoff").toString())));
		scheduleCYLA.setTotalLossSetOff(totalLossSetOff);

		LossRemAftSetOff lossRemAftSetOff = new LossRemAftSetOff();
		lossRemAftSetOff.setBalHPlossCurYrAftSetoff(totalCurYr.getTotHPlossCurYr().subtract(totalLossSetOff.getTotHPlossCurYrSetoff()));
		lossRemAftSetOff.setBalBusLossAftSetoff(new BigInteger("0"));
		lossRemAftSetOff.setBalOthSrcLossNoRaceHorseAftSetoff(totalCurYr.getTotOthSrcLossNoRaceHorse().subtract(totalLossSetOff.getTotOthSrcLossNoRaceHorseSetoff()));
		scheduleCYLA.setLossRemAftSetOff(lossRemAftSetOff);

		itr2.setScheduleCYLA(scheduleCYLA);

		//Schedule BFLA Begins

		ScheduleBFLA scheduleBFLA = new ScheduleBFLA();
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.HP hPBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.HP();
		IncBFLA incBFLA = new IncBFLA();
		incBFLA.setIncOfCurYrUndHeadFromCYLA(inCCYLA.getIncOfCurYrAfterSetOff());
		incBFLA.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseLoss").toString())));
		incBFLA.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLA.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLA.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("HouseIncomeAftBFLA").toString())));
		hPBFLA.setIncBFLA(incBFLA);
		scheduleBFLA.setHP(hPBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.BusProfExclSpecProf busProfExclSpecProfBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.BusProfExclSpecProf();
		IncBFLA incBFLAForBusiness = new IncBFLA();
		incBFLAForBusiness.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForBusiness.setBFlossPrevYrUndSameHeadSetoff(new BigInteger("0"));
		incBFLAForBusiness.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForBusiness.setIncOfCurYrAfterSetOffBFLosses(new BigInteger("0"));
		incBFLAForBusiness.setIncOfCurYrUndHeadFromCYLA(new BigInteger("0"));
		busProfExclSpecProfBFLA.setIncBFLA(incBFLAForBusiness);
		scheduleBFLA.setBusProfExclSpecProf(busProfExclSpecProfBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.STCG sTCGBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.STCG();
		IncBFLA incBFLAForSTCG = new IncBFLA();
		incBFLAForSTCG.setIncOfCurYrUndHeadFromCYLA(incCYLAforSTCG.getIncOfCurYrAfterSetOff());
		incBFLAForSTCG.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedSTCLoss").toString())));
		incBFLAForSTCG.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForSTCG.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForSTCG.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("STCGainAftBFLA").toString())));
		sTCGBFLA.setIncBFLA(incBFLAForSTCG);
		scheduleBFLA.setSTCG(sTCGBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.LTCG lTCGBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.LTCG();
		IncBFLA incBFLAForLTCG = new IncBFLA();
		incBFLAForLTCG.setIncOfCurYrUndHeadFromCYLA(incCYLAforLTCG.getIncOfCurYrAfterSetOff());
		incBFLAForLTCG.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedLTCLoss").toString())));
		incBFLAForLTCG.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForLTCG.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForLTCG.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("LTCGainAftBFLA").toString())));
		lTCGBFLA.setIncBFLA(incBFLAForLTCG);
		scheduleBFLA.setLTCG(lTCGBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcExclRaceHorse othSrcExclRaceHorseBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcExclRaceHorse();
		IncBFLA incBFLAForOthrSrc = new IncBFLA();
		incBFLAForOthrSrc.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForOthrSrc.setBFlossPrevYrUndSameHeadSetoff(new BigInteger("0"));
		incBFLAForOthrSrc.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForOthrSrc.setIncOfCurYrAfterSetOffBFLosses(incCYLAforOtherRaceHorse.getIncOfCurYrAfterSetOff());
		incBFLAForOthrSrc.setIncOfCurYrUndHeadFromCYLA(incCYLAforOtherRaceHorse.getIncOfCurYrAfterSetOff());
		othSrcExclRaceHorseBFLA.setIncBFLA(incBFLAForOthrSrc);
		scheduleBFLA.setOthSrcExclRaceHorse(othSrcExclRaceHorseBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcRaceHorse othSrcRaceHorseBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcRaceHorse();
		IncBFLA incBFLAForRaceHorse = new IncBFLA();
		incBFLAForRaceHorse.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForRaceHorse.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedRaceHorseLoss").toString())));
		incBFLAForRaceHorse.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForRaceHorse.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("RaceHorseIncomeAftBFLA").toString())));
		incBFLAForRaceHorse.setIncOfCurYrUndHeadFromCYLA(incCYLAforRaceHorse.getIncOfCurYrAfterSetOff());
		othSrcRaceHorseBFLA.setIncBFLA(incBFLAForRaceHorse);
		scheduleBFLA.setOthSrcRaceHorse(othSrcRaceHorseBFLA);

		TotalBFLossSetOff totalBFLossSetOff = new TotalBFLossSetOff();
		totalBFLossSetOff.setTotAllUs35Cl4Setoff(new BigInteger("0"));
		totalBFLossSetOff.setTotBFLossSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalBFLossSetOff").toString())));
		totalBFLossSetOff.setTotUnabsorbedDeprSetoff(new BigInteger("0"));
		scheduleBFLA.setTotalBFLossSetOff(totalBFLossSetOff);

		scheduleBFLA.setIncomeOfCurrYrAftCYLABFLA(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalIncomeAftBFLoss").toString())).add(incCYLA.getIncOfCurYrAfterSetOff()));
		itr2.setScheduleBFLA(scheduleBFLA);

		//Schedule CFL Begins

		ScheduleCFL scheduleCFL = new ScheduleCFL();

		if(adjustmentOfLossesDoc != null){
			List<AdjustmentOfLossesCom> listofAdjustmentOfLossesCom = adjustmentOfLossesDoc.getAdjustmentOfLossesList() ;
			if ( listofAdjustmentOfLossesCom != null && listofAdjustmentOfLossesCom.size() > 0 ){
				LossCFFromPrevYrToAY lossCFFromPrevYrToAY = new LossCFFromPrevYrToAY();
				LossCFFromPrev2NdYearFromAY lossCFFromPrev2NdYearFromAY = new LossCFFromPrev2NdYearFromAY();
				for(AdjustmentOfLossesCom adjustmentOfLossesCom:listofAdjustmentOfLossesCom){
					CarryFwdLossDetail carryFwdLossDetail = new CarryFwdLossDetail();
					carryFwdLossDetail.setDateOfFiling(indianCurrencyHelper.gregorianCalendar(adjustmentOfLossesCom.getDateOfFilingYear()));
					if(adjustmentOfLossesCom.getNameOfHead().equals("House Property Loss")){
						carryFwdLossDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
					}else
						carryFwdLossDetail.setHPLossCF(new BigInteger("0"));
					if(adjustmentOfLossesCom.getNameOfHead().equals("Long Term Capital Loss")){
						carryFwdLossDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
					}else
						carryFwdLossDetail.setLTCGLossCF(new BigInteger("0"));
					if(adjustmentOfLossesCom.getNameOfHead().equals("Short Term Capital Loss")){
						carryFwdLossDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
					}else
						carryFwdLossDetail.setSTCGLossCF(new BigInteger("0"));
					if(adjustmentOfLossesCom.getNameOfHead().equals("Owning and Maintaining Race Horses")){
						carryFwdLossDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
					}else
						carryFwdLossDetail.setOthSrcLossRaceHorseCF(new BigInteger("0"));
					carryFwdLossDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
					carryFwdLossDetail.setLossFrmSpecBusCF(new BigInteger("0"));
					int AssessmentYearDifference = indianCurrencyHelper.diffBtwAssessmentYear(request, adjustmentOfLossesCom.getAssessmentYear());
					if(AssessmentYearDifference==1){
						lossCFFromPrevYrToAY.setCarryFwdLossDetail(carryFwdLossDetail);
						scheduleCFL.setLossCFFromPrevYrToAY(lossCFFromPrevYrToAY);
					}
					if(AssessmentYearDifference==2){
						lossCFFromPrev2NdYearFromAY.setCarryFwdLossDetail(carryFwdLossDetail);
						scheduleCFL.setLossCFFromPrev2NdYearFromAY(lossCFFromPrev2NdYearFromAY);
					}
				}
			}
		}

		TotalOfBFLossesEarlierYrs totalOfBFLossesEarlierYrs = new TotalOfBFLossesEarlierYrs();
		LossSummaryDetail lossSummaryDetail = new LossSummaryDetail();
		lossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		lossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(totalHPLoss));
		lossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		lossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(totalLTCLoss));
		lossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(totalMaintainingRaceHorseLoss));
		lossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(totalSTCLoss));
		totalOfBFLossesEarlierYrs.setLossSummaryDetail(lossSummaryDetail);
		scheduleCFL.setTotalOfBFLossesEarlierYrs(totalOfBFLossesEarlierYrs);

		AdjTotBFLossInBFLA adjTotBFLossInBFLA = new AdjTotBFLossInBFLA();
		LossSummaryDetail adjlossSummaryDetail = new LossSummaryDetail();
		adjlossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		adjlossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseLoss").toString())));
		adjlossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		adjlossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedLTCLoss").toString())));
		adjlossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedRaceHorseLoss").toString())));
		adjlossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedSTCLoss").toString())));
		adjTotBFLossInBFLA.setLossSummaryDetail(adjlossSummaryDetail);
		scheduleCFL.setAdjTotBFLossInBFLA(adjTotBFLossInBFLA);

		CurrentAYloss currentAYloss = new CurrentAYloss();
		LossSummaryDetail currYrlossSummaryDetail = new LossSummaryDetail();
		currYrlossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		currYrlossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearHouseIncomeLoss").toString())));
		currYrlossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		currYrlossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearLTCLoss").toString())));
		currYrlossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearRaceHorseLoss").toString())));
		currYrlossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearSTCLoss").toString())));
		currentAYloss.setLossSummaryDetail(currYrlossSummaryDetail);
		scheduleCFL.setCurrentAYloss(currentAYloss);

		TotalLossCFSummary totalLossCFSummary = new TotalLossCFSummary();
		LossSummaryDetail toallossSummaryDetail = new LossSummaryDetail();

		toallossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdHouseIncomeLoss").toString())));
		toallossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		toallossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		toallossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdLTCLoss").toString())));
		toallossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdRaceHorseLoss").toString())));
		toallossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdSTCLoss").toString())));
		totalLossCFSummary.setLossSummaryDetail(toallossSummaryDetail);
		scheduleCFL.setTotalLossCFSummary(totalLossCFSummary);
		itr2.setScheduleCFL(scheduleCFL);

		//Verification
		Declaration declaration = new Declaration();
		declaration.setAssesseeVerName(memberPersonalInformation.getFirstName().toUpperCase()+" "+
				memberPersonalInformation.getMiddleName().toUpperCase()+" "+memberPersonalInformation.getLastName().toUpperCase());
		declaration.setFatherName(memberPersonalInformation.getFatherName().toUpperCase());
		declaration.setAssesseeVerPAN(memberPersonalInformation.getPAN().toUpperCase());
		verification.setDeclaration(declaration);
		verification.setPlace(memberPersonalInformation.getTownCityDistrict().toUpperCase());
		try {
			DatatypeFactory df = DatatypeFactory.newInstance();
			GregorianCalendar gc = new GregorianCalendar();
			XMLGregorianCalendar xmlGC =   DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH)+1,gc.get(Calendar.DAY_OF_MONTH),DatatypeConstants.FIELD_UNDEFINED);
			verification.setDate(xmlGC);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		itr2.setVerification(verification);

		request.setAttribute("theForm", itr2);
		/* This is where we generate XML */
		StringWriter sw = new StringWriter();
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(ITR.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://incometaxindiaefiling.gov.in/main ITRMain13.xsd");
			ITR itReturn = new ITR();
			itReturn.getITR2().add(itr2);
			jaxbMarshaller.marshal(itReturn, sw);
			request.setAttribute("xml",sw.toString());
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
