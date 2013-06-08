/*
 * In this class we are creating XML
 * @author Dhananjay
 * 07/05/2013
 */


package com.mootly.wcm.member;


import in.gov.incometaxindiaefiling.y2012_2013.itr1.ITR1;
import in.gov.incometaxindiaefiling.y2012_2013.itr1.ObjectFactory;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address.Phone;
import in.gov.incometaxindiaefiling.y2012_2013.master.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.master.AssesseeName;
import in.gov.incometaxindiaefiling.y2012_2013.master.CreationInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2012_2013.master.DoneeWithPan;
import in.gov.incometaxindiaefiling.y2012_2013.master.Schedule80G;
import in.gov.incometaxindiaefiling.y2012_2013.master.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2012_2013.master.FilingStatus;
import in.gov.incometaxindiaefiling.y2012_2013.master.ITR1IncomeDeductions;
import in.gov.incometaxindiaefiling.y2012_2013.master.ITR1TaxComputation;
import in.gov.incometaxindiaefiling.y2012_2013.master.PersonalInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.Refund;
import in.gov.incometaxindiaefiling.y2012_2013.master.Refund.DepositToBankAccount;
import in.gov.incometaxindiaefiling.y2012_2013.master.Schedule80G.Don100Percent;
import in.gov.incometaxindiaefiling.y2012_2013.master.Schedule80G.Don100PercentApprReqd;
import in.gov.incometaxindiaefiling.y2012_2013.master.Schedule80G.Don50PercentApprReqd;
import in.gov.incometaxindiaefiling.y2012_2013.master.Schedule80G.Don50PercentNoApprReqd;
import in.gov.incometaxindiaefiling.y2012_2013.master.TDSonOthThanSal;
import in.gov.incometaxindiaefiling.y2012_2013.master.TDSonOthThanSals;
import in.gov.incometaxindiaefiling.y2012_2013.master.TDSonSalaries;
import in.gov.incometaxindiaefiling.y2012_2013.master.TDSonSalary;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxPaid;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxPayment;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxPayments;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxesPaid;
import in.gov.incometaxindiaefiling.y2012_2013.master.Verification;
import in.gov.incometaxindiaefiling.y2012_2013.master.Verification.Declaration;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.ValueListBeans;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.deduction.DeductionHead;
import com.mootly.wcm.model.deduction.DeductionSection;
import com.mootly.wcm.services.DeductionListService;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.utils.XmlCalculation;

@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class,
		HouseIncomeDetail.class,HouseProperty.class,OtherSourcesDocument.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class,TdsFromSalaryDocument.class,
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class,SelfAssesmentTaxDetail.class,SalaryIncomeDetail.class,DeductionDocument.class,
		DeductionDocumentDetail.class,InterestDoc.class,FormSixteenDocument.class,FormSixteenDetail.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@ValueListBeans(paths={"deduction-sections-${financialYear}","deduction-section-heads-${financialYear}","deduction-section-maxallowed-${financialYear}"},
accessKey={"deduction_sections","deduction_section_heads","deduction_section_maxallowed"})
public class XmlGenerator extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(XmlGenerator.class);
	//DecimalFormat decimalFormat=new DecimalFormat("#.#");
	@Override

	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		if (getPublicRequestParameter(request, "show") != null) request.setAttribute("show",getPublicRequestParameter(request, "show"));

		//simple test
		ITRForm whichITRForm = ITRForm.getEnumByDisplayName(getLocalParameter("formName", request));
		if (whichITRForm.equals(ITRForm.UNKNOWN)) {
			whichITRForm = ITRForm.ITR1;
		}

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

		ITR1 itr1 = new ObjectFactory().createITR1();
		CreationInfo creationInfo = new CreationInfo();
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

		itr1.setCreationInfo(creationInfo);

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
		//TDSonSalaries tdsonSalaries = new TDSonSalaries();
		//TDSonSalary tdsonSalary = new TDSonSalary();
		//EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
		//TDSonOthThanSals tdsonOthThanSals = new TDSonOthThanSals();
		//TDSonOthThanSal tdsonOthThanSal = new TDSonOthThanSal();
		//TaxPayments taxPayments = new TaxPayments();
		//TaxPayment taxPayment = new TaxPayment();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Schedule80G schedule80G = new Schedule80G();

		//personal information
		assesseeName.setFirstName(memberPersonalInformation.getFirstName());
		assesseeName.setSurNameOrOrgName(memberPersonalInformation.getLastName());
		assesseeName.setMiddleName(memberPersonalInformation.getMiddleName());
		personalInfo.setAssesseeName(assesseeName);
		personalInfo.setPAN(memberPersonalInformation.getPAN());
		address.setResidenceNo(memberPersonalInformation.getFlatDoorBuilding());
		address.setRoadOrStreet(memberPersonalInformation.getRoadStreet());
		address.setLocalityOrArea(memberPersonalInformation.getAreaLocality());
		address.setCityOrTownOrDistrict(memberPersonalInformation.getTownCityDistrict());
		address.setStateCode(memberPersonalInformation.getState());
		address.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getPinCode()));
		Phone phone = new Phone();
		phone.setSTDcode(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getStdCode()));
		phone.setPhoneNo(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getPhone()));
		address.setPhone(phone);
		address.setMobileNo(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getMobile()));
		address.setEmailAddress(memberPersonalInformation.getEmail());
		personalInfo.setAddress(address);
		personalInfo.setDOB(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getDOB()));
		if(memberPersonalInformation.getEmploye_category()!=null){
			personalInfo.setEmployerCategory(memberPersonalInformation.getEmploye_category());
		}

		personalInfo.setGender(memberPersonalInformation.getSex());
		personalInfo.setStatus(memberPersonalInformation.getFilingStatus());

		itr1.setPersonalInfo(personalInfo);

		//Filing Status
		if(memberPersonalInformation.getWard_circle()!=null){
			filingstatus.setDesigOfficerWardorCircle(memberPersonalInformation.getWard_circle());
		}
		filingstatus.setReturnFileSec(memberPersonalInformation.getReturnFileSection());
		filingstatus.setReturnType(memberPersonalInformation.getReturnType());
		filingstatus.setResidentialStatus(memberPersonalInformation.getResidentCategory());
		filingstatus.setTaxStatus(memberPersonalInformation.getTaxStatus());

		if (memberPersonalInformation.getReturnType().equals("R")) {
			filingstatus.setAckNoOriginalReturn(memberPersonalInformation.getOriginalAckNo());
			filingstatus.setOrigRetFiledDate(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getOriginalAckDate()));

			if(memberPersonalInformation.getDefective().equals("Y")){
				filingstatus.setNoticeNo(memberPersonalInformation.getNoticeNo());
				filingstatus.setNoticeDate(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getNoticeDate()));
				filingstatus.setReceiptNo(memberPersonalInformation.getReceiptNo());
			}
		}

		itr1.setFilingStatus(filingstatus);

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
		incomeDeductions.setIncomeFromSal(TotalSalaryIncome);

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
		incomeDeductions.setTotalIncomeOfHP(houseIncomeTotal);

		if(otherSourcesDocument!=null)
			incomeDeductions.setIncomeOthSrc(indianCurrencyHelper.longRound(otherSourcesDocument.getTaxable_income()));

		long grsstotal = xmlCalculation.grossTotal(request, response);

		incomeDeductions.setGrossTotIncome(grsstotal);	// calculation needed(incomefromsalary+house income+othersrcincome)
		//added deduction with null values (incomplete)
		Map<String,Object> totalMapForJSDe = new HashMap<String, Object>();
		DeductionListService deductionListService=new DeductionListService();
		Map<String,DeductionSection> deductionSectionMap=deductionListService.getDeductionSectionMap().get(getFinancialYear());
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
		totalMapForJSDe.put("isSeniorCitizen",getFinancialYear().isSeniorCitizen(memberPersonalInformation.getDOB().getTime()));
		totalMapForJSDe.put("salarypension",incomeDeductions.getIncomeFromSal());
		totalMapForJSDe.put("othersources",incomeDeductions.getIncomeOthSrc());
		totalMapForJSDe.put("houseproperty",incomeDeductions.getTotalIncomeOfHP());
		Map<String,Object> resultMapDe = ScreenCalculatorService.getScreenCalculations("Chapter6Calc.js", request.getParameterMap(), totalMapForJSDe);
		Double totaleligiblededuction=0D;
		if(resultMapDe.containsKey("total_eligiblededuction"))
			totaleligiblededuction=Double.parseDouble(resultMapDe.get("total_eligiblededuction").toString());
		try {
			Class[] partypes = new Class[]{BigInteger.class};
			for(String keySection:deductionSectionMap.keySet()){
				String methodname="setSection"+keySection.toUpperCase();
				if(keySection.contains("ccd_1"))
					methodname="setSection80CCDEmployeeOrSE";
				if(keySection.contains("ccd_2"))
					methodname="setSection80CCDEmployer";
				String eligbleSection="total_"+keySection.replaceAll("-", "_");
				if(resultMapDe.containsKey(eligbleSection)){
					Method meth = DeductUndChapVIA.class.getMethod(methodname, partypes);
					Object[] args = new Object[]{new BigInteger(String.valueOf(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapDe.get(eligbleSection).toString()))))};
					meth.invoke(deductUndChapVIA, args);
				}
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deductUndChapVIA.setTotalChapVIADeductions(indianCurrencyHelper.bigIntegerRound(totaleligiblededuction));
		incomeDeductions.setDeductUndChapVIA(deductUndChapVIA);
		incomeDeductions.setTotalIncome(grsstotal-indianCurrencyHelper.longRound(totaleligiblededuction)); //calculation needed(GrossTotIncome-TotalChapVIADeductions(HARDCODDED 0))

		itr1.setITR1IncomeDeductions(incomeDeductions);

		Map<String,Object> totalMapForJS = new HashMap<String, Object>();
		totalMapForJS.put("cbassyear",getAssessmentYear());
		totalMapForJS.put("cbasstype", memberPersonalInformation.getFilingStatus());
		//totalMapForJS.put("cbasstype", "I");
		totalMapForJS.put("cbresistatus",memberPersonalInformation.getResidentCategory());
		totalMapForJS.put("txtNetIncome",incomeDeductions.getTotalIncome());
		boolean isSeniorCitizen = getFinancialYear().isSeniorCitizen(memberPersonalInformation.getDOB().getTime());
		if(isSeniorCitizen){
			boolean isSuperSeniorCitizen = getFinancialYear().isSuperSeniorCitizen(memberPersonalInformation.getDOB().getTime());
			if(isSuperSeniorCitizen){
				totalMapForJS.put("cbasscategory","Super Senior Citizen");
			}else
				totalMapForJS.put("cbasscategory","Senior Citizen");
		}
		else
			totalMapForJS.put("cbasscategory",memberPersonalInformation.getSex());

		Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", request.getParameterMap(), totalMapForJS);
		//ITR1 Tax Computation (without calculation) with null values
		itr1TaxComputation.setTotalTaxPayable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtTax").toString())));
		log.info("total tax payable"+indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtTax").toString())));
		itr1TaxComputation.setSurchargeOnTaxPayable(resultMap.get("txtsurcharge"));
		BigInteger EduCess = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtEduCess").toString()));
		BigInteger HigherEduCess =indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtHEduCess").toString()));
		BigInteger TotalEduCess = EduCess.add(HigherEduCess);
		itr1TaxComputation.setEducationCess(TotalEduCess);
		itr1TaxComputation.setGrossTaxLiability(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txttotaltax").toString())));
		log.info("gross tax liability"+indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txttotaltax").toString())));

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

		itr1TaxComputation.setSection89(Relief89Total);
		itr1TaxComputation.setSection90And91(new BigInteger("0"));
		BigInteger rebate =new BigInteger ("0");
		rebate=Relief89Total.add(itr1TaxComputation.getSection90And91());
		itr1TaxComputation.setNetTaxLiability(itr1TaxComputation.getGrossTaxLiability().subtract(rebate));
		BigInteger TaxLiability= new BigInteger("0");
		TaxLiability = itr1TaxComputation.getGrossTaxLiability().subtract(rebate);
		request.getSession().setAttribute("TaxLiability", TaxLiability);
		BigInteger TotalInterest = new BigInteger("0");
		if(interestDoc!=null){
			TotalInterest = indianCurrencyHelper.bigIntegerRound(interestDoc.getSection234ABC());
		}
		itr1TaxComputation.setTotalIntrstPay(TotalInterest);
		itr1TaxComputation.setTotTaxPlusIntrstPay(itr1TaxComputation.getNetTaxLiability().add(itr1TaxComputation.getTotalIntrstPay()));

		itr1.setITR1TaxComputation(itr1TaxComputation);

		BigInteger advancetax =new BigInteger ("0");
		//TaxPaid and TaxesPaid
		if(advanceTaxDocument!=null){
			advancetax=indianCurrencyHelper.bigIntegerRound(advanceTaxDocument.getTotal_Amount());
			taxesPaid.setAdvanceTax(advancetax);
		}

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
			taxesPaid.setSelfAssessmentTax(selfassessmenttax);
		}
		//calculation needed (advancetax+tds+selfassessmenttax)

		taxesPaid.setTotalTaxesPaid(bigTotalTds.add(advancetax).add(selfassessmenttax));
		taxPaid.setTaxesPaid(taxesPaid);
		BigInteger BalTaxPayable = new BigInteger("0");
		BalTaxPayable = itr1TaxComputation.getTotTaxPlusIntrstPay().subtract(taxesPaid.getTotalTaxesPaid());
		request.setAttribute("BalTaxPayable",BalTaxPayable);
		if (BalTaxPayable.compareTo(BigInteger.ZERO) > 0){
			taxPaid.setBalTaxPayable(BalTaxPayable); // calculation needed (totaltaxintrstpay-totaltaxpaid)
		}else{
			taxPaid.setBalTaxPayable(new BigInteger("0"));
		}
		itr1.setTaxPaid(taxPaid);
		//refund
		if (BalTaxPayable.compareTo(BigInteger.ZERO) < 0){
			refund.setRefundDue(BalTaxPayable.multiply(new BigInteger("-1")));// need to be calculated
		}else{
			refund.setRefundDue(new BigInteger("0"));
		}
		refund.setBankAccountNumber(memberPersonalInformation.getBD_ACC_NUMBER());
		refund.setEcsRequired(memberPersonalInformation.getBD_ECS());
		DepositToBankAccount depositToBankAccount = new DepositToBankAccount();
		depositToBankAccount.setMICRCode(memberPersonalInformation.getBD_MICR_CODE());
		depositToBankAccount.setBankAccountType(memberPersonalInformation.getBD_TYPE_ACC());
		refund.setDepositToBankAccount(depositToBankAccount);
		itr1.setRefund(refund);

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
							doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName());
							doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN());
							addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality());
							addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict());
							addressDetail.setStateCode(doneewithPan.getDoneeState());
							addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
							doneeWithPan.setAddressDetail(addressDetail);
							don100Percent.getDoneeWithPan().add(doneeWithPan);
							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total100NoAppr = Total100NoAppr.add(Investment);
							don100Percent.setTotDon100Percent(Total100NoAppr);
							don100Percent.setTotEligibleDon100Percent(Total100NoAppr);
							schedule80G.setDon100Percent(don100Percent);
						}
						if(deductionDocumentDetail.getHead()!=null && deductionDocumentDetail.getHead().equals("Appr100")){
							doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName());
							doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN());
							addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality());
							addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict());
							addressDetail.setStateCode(doneewithPan.getDoneeState());
							addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
							doneeWithPan.setAddressDetail(addressDetail);
							don100PercentApprReqd.getDoneeWithPan().add(doneeWithPan);
							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total100Appr = Total100Appr.add(Investment);
							don100PercentApprReqd.setTotDon100PercentApprReqd(Total100Appr);
							don100PercentApprReqd.setTotEligibleDon100PercentApprReqd(Total100Appr);
							schedule80G.setDon100PercentApprReqd(don100PercentApprReqd);
						}
						if(deductionDocumentDetail.getHead()!=null && deductionDocumentDetail.getHead().equals("NoAppr50")){
							doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName());
							doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN());
							addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality());
							addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict());
							addressDetail.setStateCode(doneewithPan.getDoneeState());
							addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
							doneeWithPan.setAddressDetail(addressDetail);
							don50PercentNoApprReqd.getDoneeWithPan().add(doneeWithPan);
							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total50NoAppr = Total50NoAppr.add(Investment);
							don50PercentNoApprReqd.setTotDon50PercentNoApprReqd(Total50NoAppr);
							don50PercentNoApprReqd.setTotEligibleDon50Percent(Total50NoAppr.divide(new BigInteger("2")));
							schedule80G.setDon50PercentNoApprReqd(don50PercentNoApprReqd);
						}
						if(deductionDocumentDetail.getHead()!=null && deductionDocumentDetail.getHead().equals("Appr50")){
							doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName());
							doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN());
							addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality());
							addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict());
							addressDetail.setStateCode(doneewithPan.getDoneeState());
							addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
							doneeWithPan.setAddressDetail(addressDetail);
							don50PercentApprReqd.getDoneeWithPan().add(doneeWithPan);
							BigInteger Investment = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
							Total50Appr = Total50Appr.add(Investment);
							don50PercentApprReqd.setTotDon50PercentApprReqd(Total50Appr);
							don50PercentApprReqd.setTotEligibleDon50PercentApprReqd(Total50Appr.divide(new BigInteger("2")));
							schedule80G.setDon50PercentApprReqd(don50PercentApprReqd);
						}
						schedule80G.setTotalDonationsUs80G(Total100NoAppr.add(Total100Appr).add(Total50NoAppr).add(Total50Appr));
						schedule80G.setTotalEligibleDonationsUs80G(incomeDeductions.getDeductUndChapVIA().getSection80G());
					}
				}
				itr1.setSchedule80G(schedule80G);
			}
		}

		//TDSonSalaries
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList();
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				TDSonSalaries tdsonSalaries = new TDSonSalaries();
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					TDSonSalary tdsonSalary = new TDSonSalary();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					if(formSixteenDetail.getTan_deductor()!=null){
						employerOrDeductorOrCollectDetl.setTAN(formSixteenDetail.getTan_deductor());
					}
					if(formSixteenDetail.getEmployer()!=null){
						employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(formSixteenDetail.getEmployer());
					}
					tdsonSalary.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
					if(formSixteenDetail.getIncome_chargable_tax()!=null){
						tdsonSalary.setIncChrgSal(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax()));
					}
					if(formSixteenDetail.getDed_ent_4()!=null){
						tdsonSalary.setTotalTDSSal(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getDed_ent_4()));
					}
					tdsonSalaries.getTDSonSalary().add(tdsonSalary);
				}
				itr1.setTDSonSalaries(tdsonSalaries);
			}
		}

		/**

		if(tdsFromSalaryDocument!=null){
			List<TdsFromSalaryDetail> listOfTdsSalaryDetail = tdsFromSalaryDocument.getTdsSalaryDetailList();
			if (listOfTdsSalaryDetail != null && listOfTdsSalaryDetail.size() > 0 ){
				TDSonSalaries tdsonSalaries = new TDSonSalaries();
				if (log.isDebugEnabled()) {
					log.info("inside if loop");
				}
				for(TdsFromSalaryDetail tdsFromSalaryDetail:listOfTdsSalaryDetail){
					TDSonSalary tdsonSalary = new TDSonSalary();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					if (log.isDebugEnabled()) {
						log.info("inside for loop");
					}
					employerOrDeductorOrCollectDetl.setTAN(tdsFromSalaryDetail.getTan_Employer());
					if (log.isDebugEnabled()) {
						log.info("tan employer"+tdsFromSalaryDetail.getTan_Employer());
					}
					employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(tdsFromSalaryDetail.getName_Employer());
					tdsonSalary.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
					tdsonSalary.setIncChrgSal(indianCurrencyHelper.bigIntegerRound(tdsFromSalaryDetail.getIncome_Chargeable()));
					tdsonSalary.setTotalTDSSal(indianCurrencyHelper.bigIntegerRound(tdsFromSalaryDetail.getTotal_TaxDeducted()));
					tdsonSalaries.getTDSonSalary().add(tdsonSalary);
				}
				itr1.setTDSonSalaries(tdsonSalaries);
				if (log.isDebugEnabled()) {
					log.debug("Now lets do a final check on what's being assigned in XML versus what's in my object??");
				}
			}
		}
		 **/

		//TDSonOthThanSals
		if(tdsFromothersDocument!=null){
			List<TdsOthersDetail> listOfTdsFromOthers = tdsFromothersDocument.getTdsSalaryDetailList();
			if (listOfTdsFromOthers != null && listOfTdsFromOthers.size() > 0 ){
				TDSonOthThanSals tdsonOthThanSals = new TDSonOthThanSals();
				for(TdsOthersDetail tdsOthersDetail:listOfTdsFromOthers){
					TDSonOthThanSal tdsonOthThanSal = new TDSonOthThanSal();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					employerOrDeductorOrCollectDetl.setTAN(tdsOthersDetail.getTan_Deductor());
					employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(tdsOthersDetail.getName_Deductor());
					tdsonOthThanSal.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
					tdsonOthThanSal.setTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.getTotal_TaxDeductor()));
					tdsonOthThanSal.setClaimOutOfTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.getP_Amount()));
					tdsonOthThanSals.getTDSonOthThanSal().add(tdsonOthThanSal);
				}
				itr1.setTDSonOthThanSals(tdsonOthThanSals);
			}
		}

		//TaxPayments (advance tax and self assessment tax)
		TaxPayments taxPayments = new TaxPayments();
		if(advanceTaxDocument!=null){
			List<AdvanceTaxDetail> listOfAdvanceTaxDetail = advanceTaxDocument.getAdvanceTaxDetailList() ;
			if (listOfAdvanceTaxDetail != null && listOfAdvanceTaxDetail.size() > 0 ){
				for(AdvanceTaxDetail advanceTaxDetail:listOfAdvanceTaxDetail){
					TaxPayment taxPayment = new TaxPayment();
					taxPayment.setBSRCode(advanceTaxDetail.getP_BSR());
					taxPayment.setDateDep(indianCurrencyHelper.gregorianCalendar(advanceTaxDetail.getP_Date()));
					taxPayment.setSrlNoOfChaln(indianCurrencyHelper.bigIntegerRoundStr(advanceTaxDetail.getP_Serial()));
					taxPayment.setAmt(indianCurrencyHelper.bigIntegerRound(advanceTaxDetail.getP_Amount()));
					taxPayments.getTaxPayment().add(taxPayment);
				}
			}
		}

		if( selfAssesmetTaxDocument!=null){
			List<SelfAssesmentTaxDetail> listOfSelfAssesmentTaxDetail = selfAssesmetTaxDocument.getSelfAssesmentDetailList() ;
			if (listOfSelfAssesmentTaxDetail != null && listOfSelfAssesmentTaxDetail.size() > 0 ){
				for(SelfAssesmentTaxDetail selfAssesmentTaxDetail:listOfSelfAssesmentTaxDetail){
					TaxPayment taxPayment = new TaxPayment();
					taxPayment.setBSRCode(selfAssesmentTaxDetail.getP_BSR());
					taxPayment.setDateDep(indianCurrencyHelper.gregorianCalendar(selfAssesmentTaxDetail.getP_Date()));
					taxPayment.setSrlNoOfChaln(indianCurrencyHelper.bigIntegerRoundStr(selfAssesmentTaxDetail.getP_Serial()));
					taxPayment.setAmt(indianCurrencyHelper.bigIntegerRound(selfAssesmentTaxDetail.getP_Amount()));
					taxPayments.getTaxPayment().add(taxPayment);
				}
			}
		}
		if (taxPayments != null && taxPayments.getTaxPayment() != null && taxPayments.getTaxPayment().size() > 0 ) {
			itr1.setTaxPayments(taxPayments);
		}
		//TaxExmpIntInc

		//Verification
		Declaration declaration = new Declaration();
		declaration.setAssesseeVerName(memberPersonalInformation.getFirstName()+" "+memberPersonalInformation.getLastName());
		declaration.setFatherName(memberPersonalInformation.getFatherName());
		declaration.setAssesseeVerPAN(memberPersonalInformation.getPAN());
		verification.setDeclaration(declaration);
		verification.setPlace(memberPersonalInformation.getTownCityDistrict());
		try {
			DatatypeFactory df = DatatypeFactory.newInstance();
			GregorianCalendar gc = new GregorianCalendar();
			XMLGregorianCalendar xmlGC =   DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH)+1,gc.get(Calendar.DAY_OF_MONTH),DatatypeConstants.FIELD_UNDEFINED);
			verification.setDate(xmlGC);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		itr1.setVerification(verification);

		request.setAttribute("theForm", itr1);
		/* This is where we generate XML */
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ITR1.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(itr1, sw);
			request.setAttribute("xml",sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}
