
package com.mootly.wcm.login;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1TaxComputation;
import in.gov.incometaxindiaefiling.y2012_2013.IntrstPay;
import in.gov.incometaxindiaefiling.y2012_2013.ObjectFactory;
import in.gov.incometaxindiaefiling.y2012_2013.Refund;
import in.gov.incometaxindiaefiling.y2012_2013.Refund.DepositToBankAccount;
import in.gov.incometaxindiaefiling.y2012_2013.TaxPaid;
import in.gov.incometaxindiaefiling.y2012_2013.TaxesPaid;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.ValueFactory;

import org.apache.jackrabbit.value.ValueFactoryImpl;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockServletContext;

import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.services.y2012_2013.ITR1XmlGeneratorService;
import com.mootly.wcm.services.y2012_2013.ITRXmlGeneratorService;

/** User has to pay tax =  Rs.2120.
 *
 */
public class TestITR1PayTax {

	private MockServletContext servletContext;
	private HstConcurrentLoginFilter filter;
	MemberPersonalInformation memberPersonalInformation = null;
	ValueFactory vf = ValueFactoryImpl.getInstance();
	Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
	@Before
	public void setUp() throws Exception {
		servletContext = new MockServletContext();
		filter = new HstConcurrentLoginFilter();        
	}


	//Member Personal Info
	public void initMemberInfo() {
		memberPersonalInformation = new MemberPersonalInformation(); 
		memberPersonalInformation.setFirstName("MANORAMA");
		memberPersonalInformation.setMiddleName("");
		memberPersonalInformation.setLastName("UPADHAYAY");
		String name = memberPersonalInformation.getLastName();
		char n = name.charAt(0);
		memberPersonalInformation.setPAN("ADIPU9202F");
		String result = memberPersonalInformation.getPAN();
		char s = result.charAt(4);
		assertSame(n,s);
		memberPersonalInformation.setReturnType("Original");
		//memberPersonalInformation.setFlexField("flex_string_ITRForm", vf.createValue("2012-2013"));
		GregorianCalendar gc = IndianGregorianCalendar.getIndianInstance();
		gc.set(1961, 12, 31, 12, 00);
		memberPersonalInformation.setDOB(gc);
		memberPersonalInformation.setReturnSection("11");
		memberPersonalInformation.setEmploye_category("OTHERS");
		memberPersonalInformation.setPortugesecivil("NO");
		memberPersonalInformation.setSex("F");
		memberPersonalInformation.setFatherName("DURGA PRASAD UPADHYAY");
		memberPersonalInformation.setFlatDoorBuilding("42-D, RLY OFFICERS COLONY");
		memberPersonalInformation.setRoadStreet("");
		memberPersonalInformation.setAreaLocality("S. P. MARG");
		memberPersonalInformation.setTownCityDistrict("NEW DELHI");
		memberPersonalInformation.setState("DELHI");
		memberPersonalInformation.setCountry("INDIA");
		memberPersonalInformation.setPinCode("110021");
		memberPersonalInformation.setStdCode("11111");
		memberPersonalInformation.setPhone("");
		memberPersonalInformation.setMobile("9717630802");
		memberPersonalInformation.setEmail("spu59591@gmail.com");
		memberPersonalInformation.setRsstatusQ("YES");
		memberPersonalInformation.setRsstatusQYes("YES");
		memberPersonalInformation.setRsstatusQYesYes("YES");
		memberPersonalInformation.setFlexField("flex_string_ITRForm",vf.createValue("Basic"));
		memberPersonalInformation.setFlexField("flex_string_ITRServiceDelivery", vf.createValue("eFile"));
		memberPersonalInformation.setDefective("N");
		memberPersonalInformation.setBD_BANK_NAME("STATE BANK OF INDIA");
		memberPersonalInformation.setBD_ADD_BANK_BRANCH("CANNAUGHT PLACE");
		memberPersonalInformation.setBD_ACC_NUMBER("10451933868");
		memberPersonalInformation.setFlexField("flex_string_IFSCCode",vf.createValue("SBIN0001537"));
		memberPersonalInformation.setBD_TYPE_ACC("SAVING");
		memberPersonalInformation.setBD_ECS("YES");	
		memberPersonalInformation.setFinancialYear("2012-2013");
		memberPersonalInformation.setFilingStatus("I");
		memberPersonalInformation.setResidentCategory("RES");
		System.out.println(memberPersonalInformation.getBD_ECS());
		assertNotNull(memberPersonalInformation);
		//	System.out.println("not null"+memberPersonalInformation);
	}



	@Test
	public void testTaxRefundSingleSalary () {
		try {
			initMemberInfo();
			IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();			
			ITR1TaxComputation itr1TaxComputation = new ITR1TaxComputation();
			TaxPaid taxPaid = new TaxPaid();
			Map<String,String[]> requestParameterMap = new HashMap<String, String[]>();	
			ITR1 itr1 = new ObjectFactory().createITR1();
			BigInteger expectedPayTax = new BigInteger("2140");		


			//FormSixteen 
			FormSixteenDocument formSixteenDocument = new FormSixteenDocument();
			assertNotNull(formSixteenDocument);			
			List<FormSixteenDetail> listOfFormSixteenDetail = new ArrayList<FormSixteenDetail>();
			FormSixteenDetail formSixteenDetail = new FormSixteenDetail();
			listOfFormSixteenDetail.add(formSixteenDetail);
			formSixteenDocument.setFormSixteenDetailList(listOfFormSixteenDetail);
			formSixteenDetail.setEmploye_category("");
			formSixteenDetail.setEmployer("");
			formSixteenDetail.setPan_deductor("");
			formSixteenDetail.setTan_deductor("");
			formSixteenDetail.setAddress(" ");
			formSixteenDetail.setGross_a(0D);
			formSixteenDetail.setGross_b(0D);
			formSixteenDetail.setGross_c(0D);
			formSixteenDetail.setGross_total(0D);
			formSixteenDetail.setLess_total_2(0D);
			formSixteenDetail.setBalance(0D);
			formSixteenDetail.setDeductions_entertainment(0D);
			formSixteenDetail.setDeductions_tax(0D);
			formSixteenDetail.setDeductions_total(0D);
			formSixteenDetail.setIncome_chargable_total(0D);
			BigInteger GrossIncome=new BigInteger("0");
			BigInteger GrossIncomeTotal=new BigInteger("0");
			GrossIncome=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax());
			GrossIncomeTotal=GrossIncomeTotal.add(GrossIncome);
			formSixteenDetail.setRelief_2(0D);
			formSixteenDetail.setDed_ent1(0D);
			Double tds1 = formSixteenDetail.getDed_ent_1();
			formSixteenDetail.setDed_ent3(0D);
			formSixteenDetail.setRelief_2(0D);
			Double tds2 = formSixteenDetail.getDed_ent_3();
			BigInteger bigTdsSalary=new BigInteger ("0");
			BigInteger bigTotalTdsSalary=new BigInteger ("0");
			Double TDSSalary = 0d;
			TDSSalary = tds1 + tds2;
			bigTdsSalary=indianCurrencyHelper.bigIntegerRound(TDSSalary);
			bigTotalTdsSalary= bigTotalTdsSalary.add(bigTdsSalary);
			System.out.println("bigTotalTdsSalary::"+bigTotalTdsSalary);
			mapOfBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),formSixteenDocument);			
			assertNotNull(mapOfBeans);

			//Pension Income
			SalaryIncomeDocument salaryIncomeDocument = new SalaryIncomeDocument();
			List<SalaryIncomeDetail> listSalaryIncomeDetail = new ArrayList<SalaryIncomeDetail>();
			SalaryIncomeDetail salaryIncomeDetail = new SalaryIncomeDetail();
			listSalaryIncomeDetail.add(salaryIncomeDetail);
			salaryIncomeDetail.setEmploye_category("");
			salaryIncomeDetail.setTdsPension(0D);
			salaryIncomeDetail.setGross_salary(0D);
			salaryIncomeDocument.setTotal(0D);
			BigInteger Penson=new BigInteger("0");
			Penson = indianCurrencyHelper.bigIntegerRound(salaryIncomeDocument.getTotal());
			System.out.println("Penson:::"+Penson);
			mapOfBeans.put(SalaryIncomeDocument.class.getSimpleName().toLowerCase(),salaryIncomeDocument); 

			// SalaryIncome + Pension Income
			BigInteger TotalSalaryIncome=new BigInteger("0");
			TotalSalaryIncome = GrossIncomeTotal.add(Penson);
			System.out.println("Total Salary + Pension::"+TotalSalaryIncome);
			BigInteger totalPensionTDS = new BigInteger("0");
			totalPensionTDS=indianCurrencyHelper.bigIntegerRound(salaryIncomeDetail.getTdsPension());
			BigInteger bigTotalTdsPension = new BigInteger("0");
			bigTotalTdsPension= bigTotalTdsPension.add(totalPensionTDS);


			//House Income
			HouseProperty houseProperty = new HouseProperty();
			List<HouseIncomeDetail> listOfHouseIncomeDetail = new ArrayList<HouseIncomeDetail>();
			HouseIncomeDetail houseIncomeDetail = new HouseIncomeDetail();  
			listOfHouseIncomeDetail.add(houseIncomeDetail);
			houseProperty.setHouseIncomeDetailList(listOfHouseIncomeDetail);
			houseIncomeDetail.setAddress("543 ATULYA APARTMENT");
			houseIncomeDetail.setCity("NEW DELHI");
			houseIncomeDetail.setStates("DELHI");
			houseIncomeDetail.setPin("110021");
			houseIncomeDetail.setLetOut("LET OUT");
			houseIncomeDetail.setCoowned("NO");
			houseIncomeDetail.setLetable_value(318000D);
			houseIncomeDetail.setUnrealised_rent(0D);
			houseIncomeDetail.setLocal_tax(3200D);
			houseIncomeDetail.setTotal(314800D);
			houseIncomeDetail.setBalance(94440D);
			houseIncomeDetail.setInterest_borrowed(0D);
			houseIncomeDetail.setIncome_hproperty(220360D);
			//houseProperty.setTotal_HouseIncome(220360D);
			mapOfBeans.put(HouseProperty.class.getSimpleName().toLowerCase(),houseProperty);

			//Other Income
			OtherSourcesDocument otherIncomeDocument = new OtherSourcesDocument();
			otherIncomeDocument.setBank_detail_saving(4000D);
			otherIncomeDocument.setTaxable_income(4000D);
			mapOfBeans.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(),otherIncomeDocument);			
			Double grossTotalIncome = formSixteenDetail.getIncome_chargable_tax() + salaryIncomeDetail.getGross_salary() + houseIncomeDetail.getIncome_hproperty() + otherIncomeDocument.getTaxable_income();
			BigInteger bigGrossTotalIncome= new BigInteger ("0");
			bigGrossTotalIncome=indianCurrencyHelper.bigIntegerRound(grossTotalIncome);
			System.out.println("SalaryIncome + Pension + HouseIncome + OtherIncome::"+bigGrossTotalIncome);

			//Deduction Under ChapterVIA
			DeductionDocument deductionDocument  =  new DeductionDocument();
			List<DeductionDocumentDetail> listOfDeductionDocumentDetail = new ArrayList<DeductionDocumentDetail>();
			DeductionDocumentDetail deductionDocumentDetail = new DeductionDocumentDetail();
			if (otherIncomeDocument != null
					&& otherIncomeDocument.getBank_detail_saving() != null
					&& otherIncomeDocument.getBank_detail_saving() > 0D) {
				DeductionDocumentDetail bankSavingDetail = new DeductionDocumentDetail();
				bankSavingDetail.setSection("80tta");
				bankSavingDetail.setHead("80tta");
				bankSavingDetail.setInvestment(otherIncomeDocument.getBank_detail_saving());
				listOfDeductionDocumentDetail.add(bankSavingDetail);
				deductionDocumentDetail.setInvestment((bankSavingDetail.getInvestment()));
				System.out.println("Deduction 80TTA::"+deductionDocumentDetail.getInvestment());
			}			
			Double deduction80C = deductionDocumentDetail.getInvestment();
			BigInteger bigDeduction= new BigInteger ("0");
			bigDeduction=indianCurrencyHelper.bigIntegerRound(deduction80C);
			listOfDeductionDocumentDetail.add(deductionDocumentDetail);	
			System.out.println("Deduction Chapter VIA::"+bigDeduction);
			mapOfBeans.put(DeductionDocument.class.getSimpleName().toLowerCase(),deductionDocument);

			//Summary Screen - Income Tax Field Value
			BigInteger taxableIncome = bigGrossTotalIncome.subtract(bigDeduction);
			System.out.println("Income on which user has to pay tax:::"+taxableIncome);

			//TDSotherThanSalary
			TdsFromothersDocument tdsFromothersDocument = new TdsFromothersDocument();
			assertNotNull(tdsFromothersDocument);
			List<TdsOthersDetail> listOfTdsFromOthers = new ArrayList<TdsOthersDetail>();
			assertNotNull(listOfTdsFromOthers);
			TdsOthersDetail tdsOthersDetail = new TdsOthersDetail();
			listOfTdsFromOthers.add(tdsOthersDetail);
			tdsOthersDetail.setName_Deductor("");
			tdsOthersDetail.setTan_Deductor("");
			tdsOthersDetail.setTds_Certificate("");
			tdsOthersDetail.setFinancial_Year("");
			tdsOthersDetail.setTotal_TaxDeductor(0D);
			tdsOthersDetail.setP_Amount(0D);
			tdsFromothersDocument.setTotal_Amount(0D);	
			System.out.println("TDS on Other Income::"+tdsFromothersDocument.getTotal_Amount());
			mapOfBeans.put(TdsFromothersDocument.class.getSimpleName().toLowerCase(),tdsFromothersDocument); 


			//create map to set values for calculating Income Tax according to slab rates
			Map<String,Object> totalMapForJS = new HashMap<String, Object>();
			totalMapForJS.put("cbassyear", "2013-2014");		
			totalMapForJS.put("cbasstype", memberPersonalInformation.getFilingStatus());
			totalMapForJS.put("cbasscategory",memberPersonalInformation.getSex());
			totalMapForJS.put("cbresistatus",memberPersonalInformation.getResidentCategory());
			totalMapForJS.put("txtNetIncome",taxableIncome);

			Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", requestParameterMap, totalMapForJS);
			itr1TaxComputation.setTotalTaxPayable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtTax").toString())));
			itr1TaxComputation.setSurchargeOnTaxPayable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtsurcharge").toString())));
			BigInteger EduCess = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtEduCess").toString()));
			BigInteger HigherEduCess =indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtHEduCess").toString()));
			BigInteger TotalEduCess = EduCess.add(HigherEduCess);
			itr1TaxComputation.setEducationCess(TotalEduCess);
			itr1TaxComputation.setGrossTaxLiability(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txttotaltax").toString())));
			System.out.println("Gross Tax Liability::"+itr1TaxComputation.getGrossTaxLiability());


			//Releif 89
			TaxesPaid taxesPaid = new TaxesPaid();
			BigInteger Relief89 =new BigInteger ("0");
			BigInteger Relief89Total =new BigInteger ("0");
			formSixteenDetail.setRelief_2(0D);
			Relief89=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getRelief_2());
			Relief89Total=Relief89Total.add(Relief89);
			itr1TaxComputation.setNetTaxLiability(itr1TaxComputation.getGrossTaxLiability().subtract(Relief89Total));
			System.out.println("Tax Liability = GrossTaxLiability + Releif89::"+itr1TaxComputation.getNetTaxLiability());

			//Advance Tax
			BigInteger advancetax =new BigInteger ("0");
			AdvanceTaxDocument advanceTaxDocument = new AdvanceTaxDocument();
			List<AdvanceTaxDetail> listAdvanceTaxDetail = new ArrayList<AdvanceTaxDetail>();
			AdvanceTaxDetail advanceTaxDetail = new AdvanceTaxDetail();
			listAdvanceTaxDetail.add(advanceTaxDetail);
			advanceTaxDetail.setP_Amount(0D);
			advanceTaxDocument.setTotal_Amount(0D);
			advancetax=indianCurrencyHelper.bigIntegerRound(advanceTaxDocument.getTotal_Amount());
			taxesPaid.setAdvanceTax(advancetax);		
			advanceTaxDocument.setTotal_Sum1(0D);
			advanceTaxDocument.setTotal_Sum2(0D);
			advanceTaxDocument.setTotal_Sum3(0D);
			advanceTaxDocument.setTotal_Sum4(0D);
			advanceTaxDocument.setTotal_Sum5(0D);
			mapOfBeans.put(AdvanceTaxDocument.class.getSimpleName().toLowerCase(),advanceTaxDocument);

			//Self Assessment Tax
			BigInteger selfassessmenttax = new BigInteger("0");
			SelfAssesmetTaxDocument selfAssesmetTaxDocument = new SelfAssesmetTaxDocument();
			List<SelfAssesmentTaxDetail> listSelfAssesmentTaxDetail = new ArrayList<SelfAssesmentTaxDetail>();
			SelfAssesmentTaxDetail selfAssesmentTaxDetail = new SelfAssesmentTaxDetail();
			listSelfAssesmentTaxDetail.add(selfAssesmentTaxDetail);
			selfAssesmentTaxDetail.setP_Amount(0D);
			selfAssesmetTaxDocument.setTotal_Amount(0D);
			selfassessmenttax = indianCurrencyHelper.bigIntegerRound(selfAssesmetTaxDocument.getTotal_Amount());
			taxesPaid.setSelfAssessmentTax(selfassessmenttax);
			mapOfBeans.put(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase(),selfAssesmetTaxDocument);


			//Total TDS (Salary + Pension + Income OnOthersSources)
			BigInteger bigTotalTdsOther=new BigInteger ("0");
			bigTotalTdsOther=indianCurrencyHelper.bigIntegerRound(tdsFromothersDocument.getTotal_Amount());
			BigInteger bigTotalTds=bigTotalTdsSalary.add(bigTotalTdsOther).add(Penson);
			taxesPaid.setTDS(bigTotalTds);
			taxesPaid.setTotalTaxesPaid(bigTotalTds.add(advancetax).add(selfassessmenttax));
			taxPaid.setTaxesPaid(taxesPaid);

			BigInteger TaxLiability= new BigInteger("0");
			TaxLiability = itr1TaxComputation.getNetTaxLiability().subtract(bigTotalTds);
			System.out.println("TaxLiability For Interest Calculation::"+TaxLiability);

			//Interest 234A
			InterestDoc interestDoc = new InterestDoc();
			Map<String,Object> totalMapForINTREST = new HashMap<String, Object>();
			totalMapForINTREST.put("aytaxmp","0");
			totalMapForINTREST.put("ddate", "0");
			totalMapForINTREST.put("aytaxd", TaxLiability);
			totalMapForINTREST.put("aytaxp", 0);
			totalMapForINTREST.put("atpq2", 0);
			totalMapForINTREST.put("atpq3", 0);
			totalMapForINTREST.put("atpq4", 0);
			totalMapForINTREST.put("atlq2", 0);
			totalMapForINTREST.put("atlq3", 0);
			totalMapForINTREST.put("atlq4", 0);
			Map<String,Object> resultMapINTEREST = ScreenCalculatorService.getScreenCalculations("interestCalculation.js", requestParameterMap, totalMapForINTREST);
			BigInteger Interest234A = new BigInteger("0");
			BigInteger Interest234B = new BigInteger("0");
			BigInteger Interest234C = new BigInteger("0");
			BigInteger TotalInterest = new BigInteger("0");
			Interest234A = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intA").toString()));
			System.out.println("Interest234A:::"+Interest234A);
			Interest234B = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intB").toString()));
			System.out.println("Interest234B:::"+Interest234B);
			Interest234C = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("ic").toString()));
			System.out.println("Interest234C:::"+Interest234C);
			TotalInterest = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intt").toString()));
			System.out.println("TotalInterest:::"+TotalInterest);
			IntrstPay intrstPay = new IntrstPay();
			intrstPay.setIntrstPayUs234A(Interest234A);
			System.out.println("TotalInterest1111:::"+intrstPay.getIntrstPayUs234A());
			intrstPay.setIntrstPayUs234B(Interest234B);
			intrstPay.setIntrstPayUs234C(Interest234C);
			intrstPay.setTotalIntrstPay(TotalInterest);
			itr1TaxComputation.setIntrstPay(intrstPay);
			itr1TaxComputation.setTotalIntrstPay(new BigInteger("0"));
			itr1TaxComputation.setTotTaxPlusIntrstPay(new BigInteger("0"));
			itr1.setITR1TaxComputation(itr1TaxComputation);
			mapOfBeans.put(InterestDoc.class.getSimpleName().toLowerCase(),interestDoc);


			//Rounding OFF final value of Income Tax
			BigInteger BalTaxPayable = new BigInteger("0");
			Long PayTax = (itr1TaxComputation.getTotTaxPlusIntrstPay().subtract(taxesPaid.getTotalTaxesPaid())).longValue();
			System.out.println("PayTax::"+PayTax);
			Long RoundedPayTax = indianCurrencyHelper.roundOffNearestTenth(PayTax);
			BalTaxPayable = BigInteger.valueOf(RoundedPayTax);

			Refund refund = new Refund();

			//Taxable Income (Positive Income)
			if (BalTaxPayable.compareTo(BigInteger.ZERO) > 0){
				System.out.println("To check BalTaxPayable is ZERO or not?");
				taxPaid.setBalTaxPayable(BalTaxPayable);
				System.out.println("BalTaxPayable is > ZERO::"+taxPaid.getBalTaxPayable());
			}else{
				taxPaid.setBalTaxPayable(new BigInteger("0"));
				System.out.println("BalTaxPayable is ZERO::"+taxPaid.getBalTaxPayable());
			}
			itr1.setTaxPaid(taxPaid);
			//Refundable Income (Negative Income)
			if (BalTaxPayable.compareTo(BigInteger.ZERO) < 0){
				refund.setRefundDue(BalTaxPayable.multiply(new BigInteger("-1")));
				System.out.println("BalTaxPayable (Refund) is Negative::"+refund.getRefundDue());
			}else{
				refund.setRefundDue(new BigInteger("0"));
				System.out.println("BalTaxPayable (Refund) is ZERO::"+refund.getRefundDue());
			}

			refund.setBankAccountNumber(memberPersonalInformation.getBD_ACC_NUMBER().toUpperCase());
			refund.setEcsRequired(memberPersonalInformation.getBD_ECS());
			DepositToBankAccount depositToBankAccount = new DepositToBankAccount();
			depositToBankAccount.setIFSCCode(memberPersonalInformation.getFlexField("flex_string_IFSCCode", "").toUpperCase());
			depositToBankAccount.setBankAccountType(memberPersonalInformation.getBD_TYPE_ACC().toUpperCase());
			refund.setDepositToBankAccount(depositToBankAccount);
			itr1.setRefund(refund);
			itr1.setRefund(refund);

			XmlGeneratorService xmlGeneratorService = new ITRXmlGeneratorService();
			assertNotNull(xmlGeneratorService);
			mapOfBeans.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(),memberPersonalInformation);
			Map<String,Object> returnMap = ITR1XmlGeneratorService.generateITR1(FinancialYear.TwentyTweleve, mapOfBeans);
			//get the value from the returnMap analyze the code and then you should be able to assert and check	
			BigInteger RefundSalary = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(returnMap.get("salaryincome").toString()));
			BigInteger RefundPension = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(returnMap.get("Penson").toString()));
			BigInteger RefundInterestA = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(returnMap.get("Interest234A").toString()));
			BigInteger RefundInterestB = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(returnMap.get("Interest234B").toString()));
			BigInteger RefundInterestC = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(returnMap.get("Interest234C").toString()));
			BigInteger RefundTDS = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(returnMap.get("bigTotalTdsOther").toString()));
			BigInteger RefundTDSonSalary = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(returnMap.get("bigTotalTdsSalary").toString()));
			BigInteger PayIncome = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(returnMap.get("BalTaxPayable").toString()));

			System.out.println("RefundSalary::"+RefundSalary);
			System.out.println("RefundPension::"+RefundPension);
			System.out.println("RefundInterestA::"+RefundInterestA);
			System.out.println("RefundInterestB::"+RefundInterestB);
			System.out.println("RefundInterestC::"+RefundInterestC);
			System.out.println("RefundTDS::"+RefundTDS);
			System.out.println("RefundTDSonSalary::"+RefundTDSonSalary);							
			System.out.println("RefundIncome(BalTaxPayable):::"+PayIncome);
			assertTrue("User has to pay tax of Rs.2140", (PayIncome.equals(new BigInteger("2140"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue("Exception " + e.getMessage(), e != null);
			throw new AssertionError(e);
		}
	} 
}
