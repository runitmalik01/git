package com.mootly.wcm.services;

import in.gov.incometaxindiaefiling.y2012_2013.Address;
import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.AssesseeName;
import in.gov.incometaxindiaefiling.y2012_2013.CreationInfo;
import in.gov.incometaxindiaefiling.y2012_2013.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2012_2013.DoneeWithPan;
import in.gov.incometaxindiaefiling.y2012_2013.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2012_2013.FilingStatus;
import in.gov.incometaxindiaefiling.y2012_2013.FormITR1;
import in.gov.incometaxindiaefiling.y2012_2013.FormITR2;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1IncomeDeductions;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1TaxComputation;
import in.gov.incometaxindiaefiling.y2012_2013.ITR2;
import in.gov.incometaxindiaefiling.y2012_2013.IntrstPay;
import in.gov.incometaxindiaefiling.y2012_2013.ObjectFactory;
import in.gov.incometaxindiaefiling.y2012_2013.PartAGEN1;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTTI;
import in.gov.incometaxindiaefiling.y2012_2013.PersonalInfo;
import in.gov.incometaxindiaefiling.y2012_2013.Refund;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80G;
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

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	public static void generateITR2(HstRequest request,HstResponse response) throws Exception {
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

		ITR2 itr2 = new ObjectFactory().createITR2();
		CreationInfo creationInfo = new CreationInfo();
		creationInfo.setSWVersionNo(null);
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
			JAXBContext jaxbContext = JAXBContext.newInstance(ITR2.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(itr2, sw);
			request.setAttribute("xml",sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
