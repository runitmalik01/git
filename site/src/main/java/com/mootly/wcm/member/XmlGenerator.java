/*
 * In this class we are creating XML
 * @author Dhananjay
 * 07/05/2013
 */
package com.mootly.wcm.member;


import java.io.StringWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import in.gov.incometaxindiaefiling.y2012_2013.itr1.ITR1;
import in.gov.incometaxindiaefiling.y2012_2013.itr1.ObjectFactory;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address.Phone;
import in.gov.incometaxindiaefiling.y2012_2013.master.AssesseeName;
import in.gov.incometaxindiaefiling.y2012_2013.master.CreationInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2012_2013.master.ITR1TaxComputation;
import in.gov.incometaxindiaefiling.y2012_2013.master.PersonalInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address;
import in.gov.incometaxindiaefiling.y2012_2013.master.FilingStatus;
import in.gov.incometaxindiaefiling.y2012_2013.master.ITR1IncomeDeductions;
import in.gov.incometaxindiaefiling.y2012_2013.master.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2012_2013.master.Refund;
import in.gov.incometaxindiaefiling.y2012_2013.master.Refund.DepositToBankAccount;
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

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.utils.XmlCalculation;

@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class,
		HouseIncomeDetail.class,HouseProperty.class,OtherSourcesDocument.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class,TdsFromSalaryDocument.class,
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
public class XmlGenerator extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(XmlGenerator.class);
	DecimalFormat decimalFormat=new DecimalFormat("#.#");
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

		BigInteger bigTotalTdsOther=new BigInteger ("0");
		BigInteger bigTotalTdsSalary=new BigInteger ("0");

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) request.getAttribute(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		TdsFromSalaryDocument tdsFromSalaryDocument = (TdsFromSalaryDocument) request.getAttribute(TdsFromSalaryDocument.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) request.getAttribute(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) request.getAttribute(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());

		ITR1 itr1 = new ObjectFactory().createITR1();
		CreationInfo creationInfo = new CreationInfo();
		creationInfo.setIntermediaryCity("Delhi");
		creationInfo.setSWCreatedBy("Wealth4India");
		creationInfo.setXMLCreatedBy("Wealth4India");
		try {
			DatatypeFactory df = DatatypeFactory.newInstance();
			GregorianCalendar gc = new GregorianCalendar();
			XMLGregorianCalendar xmlGC =  df.newXMLGregorianCalendar(gc);
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
		TDSonSalaries tdsonSalaries = new TDSonSalaries();
		TDSonSalary tdsonSalary = new TDSonSalary();
		EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
		TDSonOthThanSals tdsonOthThanSals = new TDSonOthThanSals();
		TDSonOthThanSal tdsonOthThanSal = new TDSonOthThanSal();
		TaxPayments taxPayments = new TaxPayments();
		TaxPayment taxPayment = new TaxPayment();

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
		address.setPinCode(memberPersonalInformation.getBigPinCode());
		Phone phone = new Phone();
		phone.setSTDcode(memberPersonalInformation.getBigStdCode());
		phone.setPhoneNo(memberPersonalInformation.getBigPhone());
		address.setMobileNo(memberPersonalInformation.getBigMobile());
		address.setEmailAddress(memberPersonalInformation.getEmail());
		personalInfo.setAddress(address);
		personalInfo.setDOB(memberPersonalInformation.getGregorianDOB());
		personalInfo.setEmployerCategory(memberPersonalInformation.getEmployerCategory());
		personalInfo.setGender(memberPersonalInformation.getSex());
		personalInfo.setStatus(memberPersonalInformation.getFilingStatus());

		itr1.setPersonalInfo(personalInfo);

		//Filing Status
		filingstatus.setDesigOfficerWardorCircle(memberPersonalInformation.getIncomeTaxWard());
		filingstatus.setReturnFileSec(memberPersonalInformation.getReturnFileSection());
		filingstatus.setReturnType(memberPersonalInformation.getReturnType());
		filingstatus.setResidentialStatus(memberPersonalInformation.getResidentCategory());
		filingstatus.setTaxStatus(memberPersonalInformation.getTaxStatus());
		filingstatus.setAckNoOriginalReturn(memberPersonalInformation.getOriginalAckNo());
		//filingstatus.setOrigRetFiledDate(memberPersonalInformation.getGregorianOriginalAckDate());
		filingstatus.setNoticeNo(memberPersonalInformation.getNoticeNo());
		//filingstatus.setNoticeDate(memberPersonalInformation.getGregorianNoticeDate());
		filingstatus.setReceiptNo(memberPersonalInformation.getReceiptNo());

		itr1.setFilingStatus(filingstatus);

		//Income Deductions
		if(salaryIncomeDocument!=null)
			incomeDeductions.setIncomeFromSal(salaryIncomeDocument.getBigTotal());
		if(houseProperty!=null){
			if (houseProperty.getHouseIncomeDetailList() != null && houseProperty.getHouseIncomeDetailList().size() > 0 ){
				for(HouseIncomeDetail houseIncomeDetail: houseProperty.getHouseIncomeDetailList()){
					incomeDeductions.setTotalIncomeOfHP(houseIncomeDetail.getIncome_hproperty().longValue());
				}
			}
		}
		if(otherSourcesDocument!=null)
			incomeDeductions.setIncomeOthSrc(otherSourcesDocument.getTaxable_income().longValue());
		long grsstotal = xmlCalculation.grossTotal(request, response);
		incomeDeductions.setGrossTotIncome(grsstotal);	// calculation needed(incomefromsalary+house income+othersrcincome)
		//added deduction with null values (incomplete)
		deductUndChapVIA.setSection80C(null);
		deductUndChapVIA.setSection80CCC(null);
		deductUndChapVIA.setSection80CCDEmployeeOrSE(null);
		deductUndChapVIA.setSection80CCDEmployer(null);
		deductUndChapVIA.setSection80CCF(null);
		deductUndChapVIA.setSection80D(null);
		deductUndChapVIA.setSection80DD(null);
		deductUndChapVIA.setSection80DDB(null);
		deductUndChapVIA.setSection80E(null);
		deductUndChapVIA.setSection80G(null);
		deductUndChapVIA.setSection80GG(null);
		deductUndChapVIA.setSection80GGA(null);
		deductUndChapVIA.setSection80GGC(null);
		deductUndChapVIA.setSection80U(null);
		deductUndChapVIA.setTotalChapVIADeductions(null);
		incomeDeductions.setDeductUndChapVIA(deductUndChapVIA);
		incomeDeductions.setTotalIncome(grsstotal-0); //calculation needed(GrossTotIncome-TotalChapVIADeductions(HARDCODDED 0))

		itr1.setITR1IncomeDeductions(incomeDeductions);

		//ITR1 Tax Computation (without calculation) with null values
		itr1TaxComputation.setTotalTaxPayable(null);
		itr1TaxComputation.setSurchargeOnTaxPayable(null);
		itr1TaxComputation.setEducationCess(null);
		itr1TaxComputation.setGrossTaxLiability(null);
		itr1TaxComputation.setSection89(null);
		itr1TaxComputation.setSection90And91(null);
		itr1TaxComputation.setNetTaxLiability(null);
		itr1TaxComputation.setTotalIntrstPay(null);
		itr1TaxComputation.setTotTaxPlusIntrstPay(null);

		itr1.setITR1TaxComputation(itr1TaxComputation);

		//TaxPaid and TaxesPaid
		if(advanceTaxDocument!=null)
			taxesPaid.setAdvanceTax(advanceTaxDocument.getBigTotal_Amount());
		if(tdsFromSalaryDocument!=null){	
			bigTotalTdsSalary= new BigInteger(decimalFormat.format(tdsFromSalaryDocument.getTotal_Amount()));

		}
		request.setAttribute("bigTotalTdsSalary", bigTotalTdsSalary);
		if(tdsFromothersDocument!=null){
			bigTotalTdsOther=new BigInteger(decimalFormat.format(tdsFromothersDocument.getTotal_Amount()));

		}
		request.setAttribute("bigTotalTdsOther", bigTotalTdsOther);
		BigInteger bigTotalTds=bigTotalTdsSalary.add(bigTotalTdsOther);
		taxesPaid.setTDS(bigTotalTds);
		if(selfAssesmetTaxDocument!=null)
			taxesPaid.setSelfAssessmentTax(selfAssesmetTaxDocument.getBigTotal_Amount());
		taxesPaid.setTotalTaxesPaid(null);//calculation needed (advancetax+tds+selfassessmenttax)
		taxPaid.setTaxesPaid(taxesPaid);
		taxPaid.setBalTaxPayable(null); // calculation needed (totaltaxintrstpay-totaltaxpaid)

		itr1.setTaxPaid(taxPaid);

		//refund
		refund.setRefundDue(null);// need to be calculated
		refund.setBankAccountNumber(memberPersonalInformation.getBD_ACC_NUMBER());
		refund.setEcsRequired(memberPersonalInformation.getBD_ECS());
		DepositToBankAccount depositToBankAccount = new DepositToBankAccount();
		depositToBankAccount.setMICRCode(memberPersonalInformation.getBD_MICR_CODE());
		depositToBankAccount.setBankAccountType(memberPersonalInformation.getBD_TYPE_ACC());
		refund.setDepositToBankAccount(depositToBankAccount);
		itr1.setRefund(refund);

		//Schedule80G is remaining 

		//TDSonSalaries
		if(tdsFromSalaryDocument!=null){
			if (tdsFromSalaryDocument.getTdsSalaryDetailList() != null && tdsFromSalaryDocument.getTdsSalaryDetailList().size() > 0 ){
				log.info("inside if loop");
				for(TdsFromSalaryDetail tdsFromSalaryDetail:tdsFromSalaryDocument.getTdsSalaryDetailList()){
					log.info("inside for loop");
					employerOrDeductorOrCollectDetl.setTAN(tdsFromSalaryDetail.getTan_Employer());
					log.info("tan employer"+tdsFromSalaryDetail.getTan_Employer());
					employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(tdsFromSalaryDetail.getName_Employer());
					tdsonSalary.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
					tdsonSalary.setIncChrgSal(tdsFromSalaryDetail.getBigIncome_Chargeable());
					tdsonSalary.setTotalTDSSal(tdsFromSalaryDetail.getBigTotal_TaxDeducted());			
					tdsonSalaries.getTDSonSalary().add(tdsonSalary);
					itr1.setTDSonSalaries(tdsonSalaries);
				}		
			}		
		}

		//TDSonOthThanSals
		if(tdsFromothersDocument!=null){
			if (tdsFromothersDocument.getTdsSalaryDetailList() != null && tdsFromothersDocument.getTdsSalaryDetailList().size() > 0 ){
				log.info("inside if loop");
				for(TdsOthersDetail tdsOthersDetail:tdsFromothersDocument.getTdsSalaryDetailList()){
					log.info("inside for loop");
					employerOrDeductorOrCollectDetl.setTAN(tdsOthersDetail.getTan_Deductor());
					employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(tdsOthersDetail.getName_Deductor());
					tdsonOthThanSal.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
					tdsonOthThanSal.setTotTDSOnAmtPaid(tdsOthersDetail.getBigTotal_TaxDeductor());
					tdsonOthThanSal.setClaimOutOfTotTDSOnAmtPaid(tdsOthersDetail.getBigP_Amount());
					tdsonOthThanSals.getTDSonOthThanSal().add(tdsonOthThanSal);
					itr1.setTDSonOthThanSals(tdsonOthThanSals);
				}
			}
		}


		//TaxPayments
		if(advanceTaxDocument!=null){
			if (advanceTaxDocument.getAdvanceTaxDetailList() != null && advanceTaxDocument.getAdvanceTaxDetailList().size() > 0 ){
				log.info("inside if loop");
				for(AdvanceTaxDetail advanceTaxDetail:advanceTaxDocument.getAdvanceTaxDetailList()){
					log.info("inside for loop");
					taxPayment.setBSRCode(advanceTaxDetail.getP_BSR());
					taxPayment.setDateDep(advanceTaxDetail.getGregorianP_Date());
					taxPayment.setSrlNoOfChaln(advanceTaxDetail.getBigP_Serial());
					taxPayment.setAmt(advanceTaxDetail.getBigP_Amount() );
					taxPayments.getTaxPayment().add(taxPayment);

				}

			}

		}

		itr1.setTaxPayments(taxPayments);
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
			XMLGregorianCalendar xmlGC =  df.newXMLGregorianCalendar(gc);
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
