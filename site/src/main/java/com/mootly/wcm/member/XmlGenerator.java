/*
 * In this class we are creating XML
 * @author Dhananjay
 * 07/05/2013
 */


package com.mootly.wcm.member;


import java.io.StringWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import in.gov.incometaxindiaefiling.y2012_2013.itr1.ITR1;
import in.gov.incometaxindiaefiling.y2012_2013.itr1.ObjectFactory;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address.Phone;
import in.gov.incometaxindiaefiling.y2012_2013.master.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.master.AssesseeName;
import in.gov.incometaxindiaefiling.y2012_2013.master.CreationInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.DoneeWithPan;
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
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
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
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class,SalaryIncomeDetail.class,DeductionDocument.class,DeductionDocumentDetail.class,InterestDoc.class})
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
		BigInteger dedc=new BigInteger ("0");
		BigInteger dedctotal=new BigInteger ("0");
		BigInteger dedccc=new BigInteger ("0");
		BigInteger dedccctotal=new BigInteger ("0");
		BigInteger dedccd1=new BigInteger ("0");
		BigInteger dedccd1total=new BigInteger ("0");
		BigInteger dedccd2=new BigInteger ("0");
		BigInteger dedccd2total=new BigInteger ("0");
		BigInteger dedccf=new BigInteger ("0");
		BigInteger dedccftotal=new BigInteger ("0");
		BigInteger dedd=new BigInteger ("0");
		BigInteger deddtotal=new BigInteger ("0");
		BigInteger deddd=new BigInteger ("0");
		BigInteger dedddtotal=new BigInteger ("0");
		BigInteger dedddb=new BigInteger ("0");
		BigInteger dedddbtotal=new BigInteger ("0");
		BigInteger dede=new BigInteger ("0");
		BigInteger dedetotal=new BigInteger ("0");
		BigInteger dedg=new BigInteger ("0");
		BigInteger dedgtotal=new BigInteger ("0");
		BigInteger dedgg=new BigInteger ("0");
		BigInteger dedggtotal=new BigInteger ("0");
		BigInteger dedgga=new BigInteger ("0");
		BigInteger dedggatotal=new BigInteger ("0");
		BigInteger dedggc=new BigInteger ("0");
		BigInteger dedggctotal=new BigInteger ("0");
		BigInteger dedia=new BigInteger ("0");
		BigInteger dediatotal=new BigInteger ("0");
		BigInteger dediab=new BigInteger ("0");
		BigInteger dediabtotal=new BigInteger ("0");
		BigInteger dedib=new BigInteger ("0");
		BigInteger dedibtotal=new BigInteger ("0");
		BigInteger dedic=new BigInteger ("0");
		BigInteger dedictotal=new BigInteger ("0");
		BigInteger dedid=new BigInteger ("0");
		BigInteger dedidtotal=new BigInteger ("0");
		BigInteger dedjja=new BigInteger ("0");
		BigInteger dedjjatotal=new BigInteger ("0");
		BigInteger dedqqb=new BigInteger ("0");
		BigInteger dedqqbtotal=new BigInteger ("0");
		BigInteger dedrrb=new BigInteger ("0");
		BigInteger dedrrbtotal=new BigInteger ("0");
		BigInteger dedu=new BigInteger ("0");
		BigInteger dedutotal=new BigInteger ("0");
		BigInteger deductiontotal=new BigInteger ("0");

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
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper(); 
		DoneeWithPan doneeWithPan = new DoneeWithPan();
		Schedule80G schedule80G = new Schedule80G();
		AddressDetail addressDetail = new AddressDetail();

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

		if( salaryIncomeDocument!=null){
			if ( salaryIncomeDocument.getSalaryIncomeDetailList() != null && salaryIncomeDocument.getSalaryIncomeDetailList().size() > 0 ){
				for(SalaryIncomeDetail salaryIncomeDetail:salaryIncomeDocument.getSalaryIncomeDetailList()){
					personalInfo.setEmployerCategory(salaryIncomeDetail.getEmploye_category());
				}
			}
		}

		personalInfo.setGender(memberPersonalInformation.getSex());
		personalInfo.setStatus(memberPersonalInformation.getFilingStatus());

		itr1.setPersonalInfo(personalInfo);

		//Filing Status
		filingstatus.setDesigOfficerWardorCircle(memberPersonalInformation.getIncomeTaxWard());
		filingstatus.setReturnFileSec(memberPersonalInformation.getReturnFileSection());
		filingstatus.setReturnType(memberPersonalInformation.getReturnType());
		filingstatus.setResidentialStatus(memberPersonalInformation.getResidentCategory());
		filingstatus.setTaxStatus(memberPersonalInformation.getTaxStatus());

		if (memberPersonalInformation.getReturnType().equals("R")) {	
			filingstatus.setAckNoOriginalReturn(memberPersonalInformation.getOriginalAckNo());
			filingstatus.setOrigRetFiledDate(memberPersonalInformation.getGregorianOriginalAckDate());

			if(memberPersonalInformation.getDefective().equals("Y")){
				filingstatus.setNoticeNo(memberPersonalInformation.getNoticeNo());
				filingstatus.setNoticeDate(memberPersonalInformation.getGregorianNoticeDate());
				filingstatus.setReceiptNo(memberPersonalInformation.getReceiptNo());
			}
		}

		itr1.setFilingStatus(filingstatus);

		//Income Deductions
		if(salaryIncomeDocument!=null)
			incomeDeductions.setIncomeFromSal(indianCurrencyHelper.bigIntegerRound(salaryIncomeDocument.getTotal()));
		if(houseProperty!=null){
			if (houseProperty.getHouseIncomeDetailList() != null && houseProperty.getHouseIncomeDetailList().size() > 0 ){
				for(HouseIncomeDetail houseIncomeDetail: houseProperty.getHouseIncomeDetailList()){
					incomeDeductions.setTotalIncomeOfHP(indianCurrencyHelper.longRound(houseIncomeDetail.getIncome_hproperty()));
				}
			}
		}
		if(otherSourcesDocument!=null)
			incomeDeductions.setIncomeOthSrc(indianCurrencyHelper.longRound(otherSourcesDocument.getTaxable_income()));
		
		long grsstotal = xmlCalculation.grossTotal(request, response);
		incomeDeductions.setGrossTotIncome(grsstotal);	// calculation needed(incomefromsalary+house income+othersrcincome)
		//added deduction with null values (incomplete)
		Map<String,Object> totalMapForJSDe = new HashMap<String, Object>();
		Double sum=0D;
		DeductionListService deductionListService=new DeductionListService();
		Map<String,DeductionSection> deductionSectionMap=deductionListService.getDeductionSectionMap().get(getFinancialYear());
		if(deductionDocument!=null){
			if (deductionDocument.getDeductionDocumentDetailList() != null && deductionDocument.getDeductionDocumentDetailList().size() > 0 ){
				for(String key:deductionSectionMap.keySet()){
					DeductionSection deductionsec=deductionSectionMap.get(key);
					if(deductionsec.getListOfDeductionHead().size()!=0){
						for(DeductionHead head:deductionsec.getListOfDeductionHead()){
							for(DeductionDocumentDetail deductionDocumentDetail:deductionDocument.getDeductionDocumentDetailList()){
								if(deductionDocumentDetail.getHead().equals(head)){
									sum=sum+deductionDocumentDetail.getInvestment();
								}
							}
							String sanitizedKey="total_"+head.getName().replaceAll("-", "_");
							log.info("head kkey"+sanitizedKey);
							totalMapForJSDe.put(sanitizedKey, sum);
							log.info("sec sum"+sum);
							sum=0D;
						}
					}
					for(DeductionDocumentDetail deductionDocumentDetail:deductionDocument.getDeductionDocumentDetailList()){
						if(deductionDocumentDetail.getSection().equals(key)){
							sum=sum+deductionDocumentDetail.getInvestment();
						}
					}
					String sanitizedKey="total_"+key.replaceAll("-", "_");
					log.info("sec key"+sanitizedKey);
					totalMapForJSDe.put(sanitizedKey,sum);
					log.info("sec sum"+sum);
					sum=0D;
				}
			}
		}
		//totalMapForJSDe.put("ageInYears",ageInYears);
		totalMapForJSDe.put("isSeniorCitizen",getFinancialYear().isSeniorCitizen(memberPersonalInformation.getDOB().getTime()));
		totalMapForJSDe.put("salarypension",incomeDeductions.getIncomeFromSal());
		totalMapForJSDe.put("othersources",incomeDeductions.getIncomeOthSrc());
		totalMapForJSDe.put("housproperty",incomeDeductions.getTotalIncomeOfHP());
		log.info("get the list of all"+totalMapForJSDe.toString());
		Map<String,Object> resultMapDe = ScreenCalculatorService.getScreenCalculations("Chapter6Calc.js", request.getParameterMap(), totalMapForJSDe);
		/*if (resultMapDe != null && resultMapDe.size() > 0 ) {
			totalMapForJSDe.putAll(resultMapDe);
			//request.setAttribute("totalMapForJS", totalMapForJSDe);
			log.info(resultMapDe.toString()); //lets analyze the map
		}*/
		BigInteger finalDeduction=new BigInteger("0");
		Double sumdeduction=0D;
		for(String deductionsec:deductionSectionMap.keySet()){
			String sanitizedKey="total_"+deductionsec.replaceAll("-", "_");
			log.info("intila to amctch"+sanitizedKey);
			if(resultMapDe.containsKey(sanitizedKey)){
				log.info("Got a match"+sanitizedKey);
			sumdeduction=sumdeduction+Double.parseDouble(resultMapDe.get(sanitizedKey).toString());
			}
		}
		log.info("thank god it willl help toc cal"+sumdeduction);
		if(indianCurrencyHelper.longRound(sumdeduction)>grsstotal){
			sumdeduction=Double.parseDouble(String.valueOf(grsstotal));
		}
		if( deductionDocument!=null){
			if ( deductionDocument.getDeductionDocumentDetailList() != null && deductionDocument.getDeductionDocumentDetailList().size() > 0 ){
				for(DeductionDocumentDetail deductionDocumentDetail:deductionDocument.getDeductionDocumentDetailList()){
					if(deductionDocumentDetail.getSection().equals("80c")){
						dedc = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedctotal = dedctotal.add(dedc);
					}
					if(deductionDocumentDetail.getSection().equals("80ccc")){
						dedccc = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedccctotal = dedccctotal.add(dedccc);
					}
					if(deductionDocumentDetail.getSection().equals("80ccd_1")){
						dedccd1 = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedccd1total = dedccd1total.add(dedccd1);
					}
					if(deductionDocumentDetail.getSection().equals("80ccd_2")){
						dedccd2 = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedccd2total = dedccd2total.add(dedccd2);
					}
					if(deductionDocumentDetail.getSection().equals("80ccf")){
						dedccf = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedccftotal = dedccftotal.add(dedccf);
					}
					if(deductionDocumentDetail.getSection().equals("80d")){
						dedd = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						deddtotal = deddtotal.add(dedd);
					}
					if(deductionDocumentDetail.getSection().equals("80dd")){
						deddd = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedddtotal = dedddtotal.add(deddd);
					}
					if(deductionDocumentDetail.getSection().equals("80ddb")){
						dedddb = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedddbtotal = dedddbtotal.add(dedddb);
					}
					if(deductionDocumentDetail.getSection().equals("80e")){
						dede = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedetotal = dedetotal.add(dede);
					}
					if(deductionDocumentDetail.getSection().equals("80g")){
						dedg = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedgtotal = dedgtotal.add(dedg);
					}
					if(deductionDocumentDetail.getSection().equals("80gg")){
						dedgg = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedggtotal = dedggtotal.add(dedgg);
					}
					if(deductionDocumentDetail.getSection().equals("80gga")){
						dedgga = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedggatotal = dedggatotal.add(dedgga);
					}
					if(deductionDocumentDetail.getSection().equals("80ggc")){
						dedggc = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedggctotal = dedggctotal.add(dedggc);
					}
					if(deductionDocumentDetail.getSection().equals("80ia")){
						dedia = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dediatotal = dediatotal.add(dedia);
					}
					if(deductionDocumentDetail.getSection().equals("80iab")){
						dediab = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dediabtotal = dediabtotal.add(dediab);
					}
					if(deductionDocumentDetail.getSection().equals("80ib")){
						dedib = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedibtotal = dedibtotal.add(dedib);
					}
					if(deductionDocumentDetail.getSection().equals("80ic")){
						dedic = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedictotal = dedictotal.add(dedic);
					}
					if(deductionDocumentDetail.getSection().equals("80id")){
						dedid = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedidtotal = dedidtotal.add(dedid);
					}
					if(deductionDocumentDetail.getSection().equals("80jja")){
						dedjja = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedjjatotal = dedjjatotal.add(dedjja);
					}
					if(deductionDocumentDetail.getSection().equals("80qqb")){
						dedqqb = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedqqbtotal = dedqqbtotal.add(dedqqb);
					}
					if(deductionDocumentDetail.getSection().equals("80rrb")){
						dedrrb = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedrrbtotal = dedrrbtotal.add(dedrrb);
					}
					if(deductionDocumentDetail.getSection().equals("80u")){
						dedu = indianCurrencyHelper.bigIntegerRound(deductionDocumentDetail.getInvestment());
						dedutotal = dedutotal.add(dedu);
					}
				}		
			}
		}

		deductiontotal = deductiontotal.add(dedctotal).add(dedccctotal).add(dedccd1total).add(dedccd2total)
				.add(dedccftotal).add(deddtotal).add(dedddtotal).add(dedddbtotal).add(dedetotal).add(dedgtotal)
				.add(dedggtotal).add(dedggatotal).add(dedggctotal).add(dediatotal).add(dediabtotal).add(dedibtotal)
				.add(dedictotal).add(dedidtotal).add(dedjjatotal).add(dedqqbtotal).add(dedrrbtotal).add(dedutotal);

		deductUndChapVIA.setSection80C(dedctotal);
		deductUndChapVIA.setSection80CCC(dedccctotal);
		deductUndChapVIA.setSection80CCDEmployeeOrSE(dedccd1total);
		deductUndChapVIA.setSection80CCDEmployer(dedccd2total);
		deductUndChapVIA.setSection80CCF(dedccftotal);
		deductUndChapVIA.setSection80D(deddtotal);
		deductUndChapVIA.setSection80DD(dedddtotal);
		deductUndChapVIA.setSection80DDB(dedddbtotal);
		deductUndChapVIA.setSection80E(dedetotal);
		deductUndChapVIA.setSection80G(dedgtotal);
		deductUndChapVIA.setSection80GG(dedggtotal);
		deductUndChapVIA.setSection80GGA(dedggatotal);
		deductUndChapVIA.setSection80GGC(dedggctotal);
		deductUndChapVIA.setSection80IA(dediatotal);
		deductUndChapVIA.setSection80IAB(dediabtotal);
		deductUndChapVIA.setSection80IB(dedibtotal);
		deductUndChapVIA.setSection80IC(dedictotal);
		deductUndChapVIA.setSection80ID(dedidtotal);
		deductUndChapVIA.setSection80JJA(dedjjatotal);
		deductUndChapVIA.setSection80QQB(dedqqbtotal);
		deductUndChapVIA.setSection80RRB(dedrrbtotal);
		deductUndChapVIA.setSection80U(dedutotal);
		deductUndChapVIA.setTotalChapVIADeductions(indianCurrencyHelper.bigIntegerRound(sumdeduction));
		incomeDeductions.setDeductUndChapVIA(deductUndChapVIA);
		incomeDeductions.setTotalIncome(grsstotal-indianCurrencyHelper.longRound(sumdeduction)); //calculation needed(GrossTotIncome-TotalChapVIADeductions(HARDCODDED 0))

		itr1.setITR1IncomeDeductions(incomeDeductions);
		
		Map<String,Object> totalMapForJS = new HashMap<String, Object>();
		totalMapForJS.put("cbassyear",getAssessmentYear());
		totalMapForJS.put("cbasstype", memberPersonalInformation.getFilingStatus());
		totalMapForJS.put("cbresistatus",memberPersonalInformation.getResidentCategory());
		totalMapForJS.put("txtNetIncome",grsstotal);
		boolean isSeniorCitizen = getFinancialYear().isSeniorCitizen(memberPersonalInformation.getDOB().getTime());
		if(isSeniorCitizen)
			totalMapForJS.put("cbasscategory","Senior Citizen");
		else
			totalMapForJS.put("cbasscategory",memberPersonalInformation.getSex());
		Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", request.getParameterMap(), totalMapForJS);
		if (log.isInfoEnabled()){
			log.info(resultMap.toString()); 
		}
		//ITR1 Tax Computation (without calculation) with null values
		itr1TaxComputation.setTotalTaxPayable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtTax").toString())));
		itr1TaxComputation.setSurchargeOnTaxPayable(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtsurcharge").toString())));
		itr1TaxComputation.setEducationCess(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtHEduCess").toString())));
		itr1TaxComputation.setGrossTaxLiability(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txttotaltax").toString())));
		itr1TaxComputation.setSection89(new BigInteger("0"));
		itr1TaxComputation.setSection90And91(new BigInteger("0"));
		BigInteger rebate=itr1TaxComputation.getSection89().add(itr1TaxComputation.getSection90And91());
		itr1TaxComputation.setNetTaxLiability(itr1TaxComputation.getGrossTaxLiability().subtract(rebate));
		//itr1TaxComputation.setTotalIntrstPay(indianCurrencyHelper.bigIntegerRound(interestDoc.getSection234ABC()));
		itr1TaxComputation.setTotalIntrstPay(new BigInteger("0"));
		itr1TaxComputation.setTotTaxPlusIntrstPay(itr1TaxComputation.getNetTaxLiability().add(itr1TaxComputation.getTotalIntrstPay()));

		itr1.setITR1TaxComputation(itr1TaxComputation);

		BigInteger advancetax =new BigInteger ("0");
		//TaxPaid and TaxesPaid
		if(advanceTaxDocument!=null){
			advancetax=indianCurrencyHelper.bigIntegerRound(advanceTaxDocument.getTotal_Amount());
			taxesPaid.setAdvanceTax(advancetax);
		}
		if(tdsFromSalaryDocument!=null){	
			bigTotalTdsSalary= indianCurrencyHelper.bigIntegerRound(tdsFromSalaryDocument.getTotal_Amount());
		}
		request.setAttribute("bigTotalTdsSalary", bigTotalTdsSalary);
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
		taxPaid.setBalTaxPayable(itr1TaxComputation.getTotTaxPlusIntrstPay().subtract(taxesPaid.getTotalTaxesPaid())); // calculation needed (totaltaxintrstpay-totaltaxpaid)
		
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
		
		/**
		DeductionDocumentDetail dDetail = (DeductionDocumentDetail) getChildBean();
		com.mootly.wcm.model.DoneeWithPan doneewithPan = com.mootly.wcm.model.DoneeWithPan.getInstanceFromChildBean(dDetail);
		
		doneeWithPan.setDoneeWithPanName(doneewithPan.getDoneeName());
		doneeWithPan.setDoneePAN(doneewithPan.getDoneePAN());
		addressDetail.setAddrDetail(doneewithPan.getDoneeAreaLocality());
		addressDetail.setCityOrTownOrDistrict(doneewithPan.getDoneeCityTownDistrict());
		addressDetail.setStateCode(doneewithPan.getDoneeState());
		addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(doneewithPan.getDoneePostalCode()));
		doneeWithPan.setAddressDetail(addressDetail);
		Don100Percent don100Percent = new Don100Percent();
		don100Percent.getDoneeWithPan().add(doneeWithPan);
		don100Percent.setTotDon100Percent(dedgtotal);
		don100Percent.setTotEligibleDon100Percent(dedgtotal);
		schedule80G.setDon100Percent(don100Percent);
		schedule80G.setTotalDonationsUs80G(dedgtotal);
		schedule80G.setTotalEligibleDonationsUs80G(dedgtotal);
		itr1.setSchedule80G(schedule80G);
**/

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
					tdsonSalary.setIncChrgSal(indianCurrencyHelper.bigIntegerRound(tdsFromSalaryDetail.getIncome_Chargeable()));
					tdsonSalary.setTotalTDSSal(indianCurrencyHelper.bigIntegerRound(tdsFromSalaryDetail.getTotal_TaxDeducted()));			
					tdsonSalaries.getTDSonSalary().add(tdsonSalary);

				}		
			}		
			itr1.setTDSonSalaries(tdsonSalaries);
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
					tdsonOthThanSal.setTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.getTotal_TaxDeductor()));
					tdsonOthThanSal.setClaimOutOfTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.getP_Amount()));
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
					taxPayment.setSrlNoOfChaln(indianCurrencyHelper.bigIntegerRoundStr(advanceTaxDetail.getP_Serial()));
					taxPayment.setAmt(indianCurrencyHelper.bigIntegerRound(advanceTaxDetail.getP_Amount()));
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
