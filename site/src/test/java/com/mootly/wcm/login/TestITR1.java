
package com.mootly.wcm.login;


import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import in.gov.incometaxindiaefiling.y2011_2012.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2011_2012.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2011_2012.ITR1TaxComputation;
import in.gov.incometaxindiaefiling.y2011_2012.Refund;
import in.gov.incometaxindiaefiling.y2011_2012.TDSonOthThanSal;
import in.gov.incometaxindiaefiling.y2011_2012.TDSonOthThanSals;
import in.gov.incometaxindiaefiling.y2011_2012.TaxesPaid;
import in.gov.incometaxindiaefiling.y2012_2013.ITR1IncomeDeductions;

import com.mootly.wcm.services.DeductionListService;
import com.mootly.wcm.services.IndianCurrencyHelper;
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
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.deduction.DeductionSection;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.services.y2011_2012.ITR1XmlGeneratorService;
import com.mootly.wcm.services.y2012_2013.ITRXmlGeneratorService;

/**
 * Senior, Super Senior, YOUNG/KIDS
 * @author admin
 *
 */
public class TestITR1 {

	private MockServletContext servletContext;
	private HstConcurrentLoginFilter filter;
	MemberPersonalInformation memberPersonalInformation = null;
	//HouseProperty houseProperty = null;
	ValueFactory vf = ValueFactoryImpl.getInstance();
	@Before
	public void setUp() throws Exception {
		servletContext = new MockServletContext();
		filter = new HstConcurrentLoginFilter();        
	}


	//Member Personal Info
	public void initMemberInfo() {
		memberPersonalInformation = new MemberPersonalInformation();
		memberPersonalInformation.setFirstName("SOMA");
		memberPersonalInformation.setMiddleName("");
		memberPersonalInformation.setLastName("CHATTERJEE");
		String name = memberPersonalInformation.getLastName();
		char n = name.charAt(0);
		memberPersonalInformation.setPAN("AFYPC8931K");
		String result = memberPersonalInformation.getPAN();
		char s = result.charAt(4);
		assertSame(n,s);
		memberPersonalInformation.setReturnType("Original");
		//memberPersonalInformation.setFlexField("flex_string_ITRForm", vf.createValue("2012-2013"));
		GregorianCalendar gc = IndianGregorianCalendar.getIndianInstance();
		gc.set(1980, 01, 01, 12, 00);
		memberPersonalInformation.setDOB(gc);
		memberPersonalInformation.setReturnSection("11");
		memberPersonalInformation.setEmploye_category("OTHERS");
		memberPersonalInformation.setPortugesecivil("NO");
		memberPersonalInformation.setSex("FEMALE");
		memberPersonalInformation.setFatherName("SOUREN KUMAR");
		memberPersonalInformation.setFlatDoorBuilding("B-604");
		memberPersonalInformation.setRoadStreet("");
		memberPersonalInformation.setAreaLocality("IRWO WESTEN TOWERS, SECTOR-47");
		memberPersonalInformation.setTownCityDistrict("GURGAON");
		memberPersonalInformation.setState("HARYANA");
		memberPersonalInformation.setCountry("INDIA");
		memberPersonalInformation.setPinCode("122001");
		memberPersonalInformation.setStdCode("11111");
		memberPersonalInformation.setPhone("");
		memberPersonalInformation.setMobile("9899716164");
		memberPersonalInformation.setEmail("pratyush.chettejee@quatrro.com");
		memberPersonalInformation.setRsstatusQ("YES");
		memberPersonalInformation.setRsstatusQYes("YES");
		memberPersonalInformation.setRsstatusQYesYes("YES");
		memberPersonalInformation.setFlexField("flex_string_ITRForm",vf.createValue("Basic"));
		memberPersonalInformation.setFlexField("flex_string_ITRServiceDelivery", vf.createValue("eFile"));
		memberPersonalInformation.setDefective("N");
		memberPersonalInformation.setBD_BANK_NAME("YES BANK");
		memberPersonalInformation.setBD_ADD_BANK_BRANCH("GURGAON, FORTUNE GLOBAL ARCADE, SIKANDERPUR, MEHRAULI GURGAON ROAD, GURGAON HARYANA 122002");
		memberPersonalInformation.setBD_ACC_NUMBER("290200096520");
		memberPersonalInformation.setFlexField("flex_string_IFSCCode",vf.createValue("YESB0000002"));
		memberPersonalInformation.setBD_TYPE_ACC("CURRENT");
		memberPersonalInformation.setBD_ECS("NO");	
		System.out.println(memberPersonalInformation.getBD_ECS());
		assertNotNull(memberPersonalInformation);
		//	System.out.println("not null"+memberPersonalInformation);
	}



	@Test
	public void testTaxRefundSingleSalary () {
		try {
			initMemberInfo();
			IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
			BigInteger expectedRefund = new BigInteger("70");
			Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();	

			//FormSixteen 
			FormSixteenDocument formSixteenDocument = new FormSixteenDocument();
			assertNotNull(formSixteenDocument);			
			List<FormSixteenDetail> listOfFormSixteenDetail = new ArrayList<FormSixteenDetail>();
			FormSixteenDetail formSixteenDetail = new FormSixteenDetail();
			listOfFormSixteenDetail.add(formSixteenDetail);
			formSixteenDocument.setFormSixteenDetailList(listOfFormSixteenDetail);
			formSixteenDetail.setEmploye_category("PSU");
			System.out.println("Employer Category::"+formSixteenDetail.getEmploye_category());
			formSixteenDetail.setEmployer("GLOBAL HEALTH PRIVATE LIMITED");
			formSixteenDetail.setPan_deductor("AACCG2681C");
			formSixteenDetail.setTan_deductor("DELG07947C");
			formSixteenDetail.setAddress("E-18, DEFENCE COLONY, DELHI");
			formSixteenDetail.setGross_a(546156.44D);
			formSixteenDetail.setGross_b(0D);
			formSixteenDetail.setGross_c(0D);
			formSixteenDetail.setGross_total(546156.44D);
			formSixteenDetail.setLess_total_2(62685.59D);
			formSixteenDetail.setBalance(483470.85D);
			formSixteenDetail.setDeductions_entertainment(0D);
			formSixteenDetail.setDeductions_tax(0D);
			formSixteenDetail.setDeductions_total(0D);
			formSixteenDetail.setRelief_2(0D);
			formSixteenDetail.setDed_ent1(3447D);
			formSixteenDetail.setDed_ent3(0D);
			mapOfBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),formSixteenDocument);
			assertNotNull(mapOfBeans);

			//House Income
			HouseProperty houseProperty = new HouseProperty();
			List<HouseIncomeDetail> listOfHouseIncomeDetail = new ArrayList<HouseIncomeDetail>();
			HouseIncomeDetail houseIncomeDetail = new HouseIncomeDetail();  
			listOfHouseIncomeDetail.add(houseIncomeDetail);
			houseProperty.setHouseIncomeDetailList(listOfHouseIncomeDetail);
			houseIncomeDetail.setAddress("FLAT NO. 1108, MANTOVA TOWER, MAHAGUN MASCOT, NH 24,CROSSINGS REPUBLIC");
			houseIncomeDetail.setCity("GHAZIABAD");
			houseIncomeDetail.setStates("UTTAR PRADESH");
			houseIncomeDetail.setPin("201010");
			houseIncomeDetail.setLetOut("SELF OCCUPIED");
			houseIncomeDetail.setCoowned("NO");
			houseIncomeDetail.setInterest_borrowed(150000D);
			houseIncomeDetail.setIncome_hproperty(-150000D);
			mapOfBeans.put(HouseProperty.class.getSimpleName().toLowerCase(),houseProperty);

			//Other Income
			OtherSourcesDocument otherIncomeDocument = new OtherSourcesDocument();
			otherIncomeDocument.setIncome_rent_machine(14000D);
			otherIncomeDocument.setTotalOther_income(14000D);
			otherIncomeDocument.setFamilypension_deduction(0D);
			otherIncomeDocument.setOtherdeduction(32500D);
			otherIncomeDocument.setDepreciation(8100D);
			otherIncomeDocument.setTotalexpense(113500D);
			otherIncomeDocument.setTaxable_income(26500D);
			mapOfBeans.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(),otherIncomeDocument);

			

			XmlGeneratorService xmlGeneratorService = new ITRXmlGeneratorService();	
			assertNotNull(xmlGeneratorService);
			mapOfBeans.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(),memberPersonalInformation);
			Map<String,Object> returnMap = ITR1XmlGeneratorService.generateITR1(FinancialYear.TwentyTweleve, mapOfBeans);
			//get the value from the returnMap analyze the code and then you should be able to assert and check		
			/*ITR1IncomeDeductions incomeDeductions = new ITR1IncomeDeductions();	
			incomeDeductions.setIncomeFromSal(new BigInteger("483471"));
			incomeDeductions.setTotalIncomeOfHP(-150000);
			incomeDeductions.setIncomeOthSrc(new BigInteger("26500"));
			incomeDeductions.setGrossTotIncome(359971);
			DeductUndChapVIA deductUndChapVIA = new DeductUndChapVIA();
			deductUndChapVIA.setTotalChapVIADeductions(new BigInteger("100000"));
			incomeDeductions.setTotalIncome(359971);
			ITR1TaxComputation itr1TaxComputation = new ITR1TaxComputation();
			itr1TaxComputation.setTotalTaxPayable(new BigInteger("59971"));
			itr1TaxComputation.setSurchargeOnTaxPayable(0);
			itr1TaxComputation.setEducationCess(new BigInteger("180"));
			itr1TaxComputation.setGrossTaxLiability(new BigInteger("6177"));
			itr1TaxComputation.setSection89(new BigInteger("0"));
			itr1TaxComputation.setTotalIntrstPay(new BigInteger("0"));
			itr1TaxComputation.setTotTaxPlusIntrstPay(new BigInteger("6177"));
			TaxesPaid taxesPaid = new TaxesPaid();
			taxesPaid.setAdvanceTax(new BigInteger("0"));
			taxesPaid.setSelfAssessmentTax(new BigInteger("0"));
			taxesPaid.setTDS(new BigInteger("3447"));
			Refund refund = new Refund();
			refund.setRefundDue(new BigInteger("70"));
			System.out.println("result::"+ refund.getRefundDue()); */
			BigInteger RefundIncome = (BigInteger) returnMap.get("BalTaxPayable");			
			assertFalse("Failed Refund Income", (RefundIncome.equals(70)));
			assertNotSame(expectedRefund,RefundIncome);
		} catch (Exception e) {
			// TODO Auto-generated catch block (salaryIncome.equals(1000))
			e.printStackTrace();
			assertFalse("Exception " + e.getMessage(), e != null);
			throw new AssertionError(e);
		}
	} 

	//For Individual screen testing
	@Test	
	public void testHouseIncome(){
		//ITR1 -- House Income
		Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
		//House Income
		HouseProperty hp = new HouseProperty();
		if(hp!=null){
			//System.out.println("not null"+hp);
			HouseIncomeDetail houseIncomeDetail = new HouseIncomeDetail();   
			//System.out.println("listOfHouseIncomeDetail is not NULL"+houseIncomeDetail);
			houseIncomeDetail.setAddress("gurgaon");
			houseIncomeDetail.setLetOut("L");
			houseIncomeDetail.setBalance(34000D);
			mapOfBeans.put(HouseProperty.class.getSimpleName().toLowerCase(),hp); 
		}
	}

	@Test	
	public void testTaxSingleSalary(){
		BigInteger expectedRefund = new BigInteger("201100");
		Integer upcomingRefund = expectedRefund.intValue();
		Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
		FormSixteenDocument formSixteenDocument = new FormSixteenDocument();
		FormSixteenDetail formSixteenDetail = new FormSixteenDetail();
		assertNotNull("formSixteenDocument is not null"+formSixteenDetail);
		formSixteenDetail.setEmploye_category("PSU");
		formSixteenDetail.setEmployer("Mootly SOFTWARE");
		formSixteenDetail.setPan_deductor("AAAAA1111A");
		formSixteenDetail.setTan_deductor("AAAA11111A");
		formSixteenDetail.setAddress("GURGAON");
		formSixteenDetail.setGross_a(200000D);
		formSixteenDetail.setGross_b(1000D);
		formSixteenDetail.setGross_c(100D);
		formSixteenDetail.setGross_total(201100D);
		formSixteenDetail.setBalance(201100D);
		//PSU -- Toatl allowance maximum = 2500 but user Input is 5000 -- 
		formSixteenDetail.setDeductions_tax(5000D);
		formSixteenDetail.setDeductions_total(2500D);
		Double balanceSalary = formSixteenDetail.getBalance();
		Integer balSalary = balanceSalary.intValue();		
		formSixteenDetail.setIncome_chargable_total(198600D);
		Double totalIncome = formSixteenDetail.getIncome_chargable_tax();
		Double psuTax = formSixteenDetail.getDeductions_total();
		Integer psuTaxPay = psuTax.intValue();
		mapOfBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),formSixteenDocument);
		assertTrue(psuTaxPay.equals(2500));
		assertFalse(balSalary < upcomingRefund); 
		assertTrue(totalIncome.equals(198600D));	
	}

	//ITR1 -- Other Income
	@Test
	public void testOtherIncome(){
		BigInteger expectedOtherIncome = new BigInteger("20000");
		Integer expectedIncome = expectedOtherIncome.intValue();
		Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
		OtherSourcesDocument otherIncomeDocument = new OtherSourcesDocument();
		otherIncomeDocument.setGov_income(100D);
		otherIncomeDocument.setAgriculture_income(100D);
		otherIncomeDocument.setBalance(100D);
		otherIncomeDocument.setBank_detail_fdr(100D);
		otherIncomeDocument.setBank_detail_saving(100D);
		otherIncomeDocument.setDeduction_57(100D);
		Double otherIncome = otherIncomeDocument.getDeduction_57();
		//assertTrue(expectedOtherIncome,otherIncome);
		mapOfBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),otherIncomeDocument);

	}
	@Test
	public void testTDSFromOthers(){
		//TDS From Others	
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) mapOfBeans.get(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		if(tdsFromothersDocument!=null){
			List<TdsOthersDetail> listOfTdsFromOthers = tdsFromothersDocument.getTdsSalaryDetailList();
			if (listOfTdsFromOthers != null && listOfTdsFromOthers.size() > 0 ){
				TDSonOthThanSals tdsonOthThanSals = new TDSonOthThanSals();
				for(TdsOthersDetail tdsOthersDetail:listOfTdsFromOthers){
					TDSonOthThanSal tdsonOthThanSal = new TDSonOthThanSal();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					//employerOrDeductorOrCollectDetl.setTAN(tdsOthersDetail.setTan_Deductor("AAAA1111A"));
					//employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(tdsOthersDetail.setName_Deductor("QUATRRO GLOBAL SERVICES PRIVATE LIMITED"));
					tdsonOthThanSal.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);						
					//tdsonOthThanSal.setTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.setTotal_TaxDeductor(2800D)));
					//tdsonOthThanSal.setClaimOutOfTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.setP_Amount(2800D)));	
					Double tds1 = tdsOthersDetail.getP_Amount();
					System.out.println("hghghghfgffghfghffgfhhf"+tds1);
				}
			}
		}
		mapOfBeans.put(TdsFromothersDocument.class.getSimpleName().toLowerCase(),tdsFromothersDocument);

		//Self Assessment Tax
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) mapOfBeans.get(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());
		if( selfAssesmetTaxDocument!=null){
			List<SelfAssesmentTaxDetail> listOfSelfAssesmentTaxDetail = selfAssesmetTaxDocument.getSelfAssesmentDetailList() ;
			if (listOfSelfAssesmentTaxDetail != null && listOfSelfAssesmentTaxDetail.size() > 0 ){
				for(SelfAssesmentTaxDetail selfAssesmentTaxDetail:listOfSelfAssesmentTaxDetail){

				}
			}
		}

		//DeductionDocument deductionDocument = new DeductionDocument();
		//DeductionListService deductionListService=new DeductionListService();
		//Map<String,DeductionSection> deductionSectionMap = 
		//List<DeductionDocumentDetail> listOfDeductionDocumentDetail = new ArrayList<DeductionDocumentDetail>();
		//DeductionDocumentDetail deductionDocumentDetail = new DeductionDocumentDetail ();
		//listOfDeductionDocumentDetail.add(deductionDocumentDetail);			
		//deductionDocument.setDeductionDocumentDetailList(listOfDeductionDocumentDetail);
		//deductionDocumentDetail.setSection();
		//mapOfBeans.put(DeductionDocument.class.getSimpleName().toLowerCase(),deductionDocument); 
	}


	//ITR-2 -- FormSixteen (/formsixteenschedule.html)
	@Test
	public void testItr2Form (){
		BigInteger expectedRefund = new BigInteger("500000");
		Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
		FormSixteenDocument formSixteenDocument = new FormSixteenDocument();
		FormSixteenDetail formSixteenDetail = new FormSixteenDetail();
		formSixteenDetail.setEmploye_category("PSU");
		formSixteenDetail.setEmployer("Google");
		formSixteenDetail.setPan_deductor("AAAAA1111A");
		formSixteenDetail.setTan_deductor("AAAA11111A");
		formSixteenDetail.setAddressdetail("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSZZZZZZZZZZZZZZZZZZZZZZZZXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
		String lenAddress = formSixteenDetail.getAddressdetail();
		int lenStreet = lenAddress.length();
		System.out.println("length of adress:: "+lenStreet);
		assertFalse(lenAddress.equals(200));
		formSixteenDetail.setCity("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSZZZZZZZZZZZZZZZZZZZZZZZZXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
		String lenCity = formSixteenDetail.getCity();
		assertFalse(lenCity.equals(50));
		//int lenFormCity= lenCity.length();
		//System.out.println(lenFormCity);
		formSixteenDetail.setGross_a(500000D);
		formSixteenDetail.setGross_b(0D);
		formSixteenDetail.setGross_c(0D);
		formSixteenDetail.setGross_total(500000D);
		formSixteenDetail.setLess_total_2(0D);
		formSixteenDetail.setBalance(500000D);
		formSixteenDetail.setIncome_chargable_total(500000D);
		formSixteenDetail.setRelief_2(2000D);		
		//mapOfBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),formSixteenDocument);
		ITR1IncomeDeductions incomeDeductions = new ITR1IncomeDeductions();
		incomeDeductions.setIncomeFromSal(new BigInteger("500000"));
		BigInteger salaryIncome1 = incomeDeductions.getIncomeFromSal();
		//System.out.println(incomeDeductions.getIncomeFromSal());
		assertEquals(expectedRefund,salaryIncome1);
	}


	//ITR1 -- Pension Income
	@Test
	public void testPension(){
		BigInteger expectedPension = new BigInteger("20000");
		Integer expectedPensionIncome = expectedPension.intValue();
		Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();
		SalaryIncomeDocument salaryIncomeDocument = new SalaryIncomeDocument();
		SalaryIncomeDetail salaryIncomeDetail = new SalaryIncomeDetail();
		salaryIncomeDetail.setEmploye_category("GOVT.");
		salaryIncomeDetail.setGross_salary(20000D);
		Double pension = salaryIncomeDetail.getGross_salary();
		Integer pensionIncome = pension.intValue();
		mapOfBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),salaryIncomeDocument);
		assertTrue(pensionIncome.equals(20000));
		assertEquals(expectedPensionIncome,pensionIncome);
	}

	@Test
	public void testAssertions(){
		//test data
		String str1 =  new String ("abc");
		String str2 = new String ("abc");
		String str3 = null;
		String str4 = "abc";
		String str5 = "abc";
		int val1 = 5;
		int val2 = 10;
		//check that two objects are equal
		assertEquals(str1, str2);
		//check that condition is true
		assertTrue(val1<val2);
		//check that object isn't Null
		assertNotNull(str1);
		//check that object is NULL
		assertNull(str3);
		//check that if TWO objects references point to same object
		assertSame(str4,str5);
		//check if TWO object references not point to same object
		assertNotSame(str1,str3);

	} 
}
