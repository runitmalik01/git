/*
 * In this class we are getting values required for the calculation of interest
 * @author Dhananjay
 * 04/03/2013
 *
 *
 */

package com.mootly.wcm.member;


import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberContactInformation;
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
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.deduction.DeductionHead;
import com.mootly.wcm.model.deduction.DeductionSection;
import com.mootly.wcm.services.DeductionListService;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.utils.XmlCalculation;

@PrimaryBean(primaryBeanClass=InterestDoc.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class,
		HouseIncomeDetail.class,HouseProperty.class,OtherSourcesDocument.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class,TdsFromSalaryDocument.class,
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class,SelfAssesmentTaxDetail.class,SalaryIncomeDetail.class,DeductionDocument.class,
		DeductionDocumentDetail.class,InterestDoc.class,FormSixteenDocument.class,FormSixteenDetail.class,RebateSec90Document.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"intA","intB","ic","intt"})

public class Interest extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(Interest.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) request.getAttribute(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		DeductionDocument deductionDocument = (DeductionDocument) request.getAttribute(DeductionDocument.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());
		RebateSec90Document rebateSec90Document = (RebateSec90Document) request.getAttribute(RebateSec90Document.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) request.getAttribute(TdsFromothersDocument.class.getSimpleName().toLowerCase());


		XmlCalculation xmlCalculation = new XmlCalculation();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		//DeductUndChapVIA deductUndChapVIA = new DeductUndChapVIA();

		long grsstotal = xmlCalculation.grossTotal(request, response);

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

		long OtherIncome = 0;
		if(otherSourcesDocument!=null)
			OtherIncome = indianCurrencyHelper.longRound(otherSourcesDocument.getTaxable_income());

		Map<String,Object> totalMapForJSDe = new HashMap<String, Object>();
		DeductionListService deductionListService=new DeductionListService();
		Map<String,DeductionSection> deductionSectionMap=deductionListService.getDeductionSectionMap().get(getITRInitData(request).getFinancialYear());
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
		totalMapForJSDe.put("isSeniorCitizen",getITRInitData(request).getFinancialYear().isSeniorCitizen(memberPersonalInformation.getDOB().getTime()));
		totalMapForJSDe.put("salarypension",TotalSalaryIncome);
		totalMapForJSDe.put("othersources",OtherIncome);
		totalMapForJSDe.put("houseproperty",houseIncomeTotal);
		Map<String,Object> resultMapDe = ScreenCalculatorService.getScreenCalculations("Chapter6Calc.js", request.getParameterMap(), totalMapForJSDe);
		Double totaleligiblededuction=0D;
		if(resultMapDe.containsKey("total_eligiblededuction"))
			totaleligiblededuction=Double.parseDouble(resultMapDe.get("total_eligiblededuction").toString());
		/*try {
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
		}*/

        long TotalIncome = 0;
        TotalIncome = grsstotal - indianCurrencyHelper.longRound(totaleligiblededuction);

		Map<String,Object> totalMapForJS = new HashMap<String, Object>();
		totalMapForJS.put("cbassyear",getITRInitData(request).getAssessmentYear());
		totalMapForJS.put("cbasstype", memberPersonalInformation.getFilingStatus());
		//totalMapForJS.put("cbasstype", "I");
		totalMapForJS.put("cbresistatus",memberPersonalInformation.getResidentCategory());
		totalMapForJS.put("txtNetIncome",TotalIncome);
		boolean isSeniorCitizen = getITRInitData(request).getFinancialYear().isSeniorCitizen(memberPersonalInformation.getDOB().getTime());
		if(isSeniorCitizen){
			boolean isSuperSeniorCitizen = getITRInitData(request).getFinancialYear().isSuperSeniorCitizen(memberPersonalInformation.getDOB().getTime());
			if(isSuperSeniorCitizen){
				totalMapForJS.put("cbasscategory","Super Senior Citizen");
			}else
				totalMapForJS.put("cbasscategory","Senior Citizen");
		}
		else
			totalMapForJS.put("cbasscategory",memberPersonalInformation.getSex());

		Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", request.getParameterMap(), totalMapForJS);
		//ITR1 Tax Computation (without calculation) with null values
		BigInteger GrossTaxLiability = new BigInteger("0");
		GrossTaxLiability = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txttotaltax").toString()));

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

		BigInteger Rebate90 = new BigInteger("0");
		BigInteger Rebate91 = new BigInteger("0");
		if(rebateSec90Document!=null){
			Rebate90 = indianCurrencyHelper.bigIntegerRound(rebateSec90Document.getSection90());
			Rebate91 = indianCurrencyHelper.bigIntegerRound(rebateSec90Document.getSection91());
		}
		BigInteger rebate =new BigInteger ("0");
		rebate=Relief89Total.add(Rebate90).add(Rebate91);
		BigInteger NetTaxLiability = new BigInteger("0");
		NetTaxLiability = GrossTaxLiability.subtract(rebate);

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
		BigInteger bigTdsOther=new BigInteger ("0");
		if(tdsFromothersDocument!=null){
			bigTdsOther=indianCurrencyHelper.bigIntegerRound(tdsFromothersDocument.getTotal_Amount());
		}
        BigInteger TDS = new BigInteger("0");
        TDS = bigTotalTdsSalary.add(bigTdsOther);
		BigInteger TaxLiability= new BigInteger("0");
		TaxLiability = NetTaxLiability.subtract(TDS);
        request.setAttribute("bigTotalTdsSalary",0);
		request.setAttribute("TaxLiability", TaxLiability); //attribute used in interest.jsp

		//current date
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		final Date currentdate=cal.getTime();
		//conversion of date into string
		String strDate=new Date().toString();
		//current month
		@SuppressWarnings("deprecation")
		int year=currentdate.getYear()+1900-1;

		if(year==2012){
			int currentdatemonth =currentdate.getMonth()+1;
			request.setAttribute("intmonth", currentdatemonth);
		}else
		if(year==2013){
			int currentdatemonth =currentdate.getMonth()+1+12;
			request.setAttribute("intmonth", currentdatemonth);
		}
		//conversion of month into string
		String strmonth=strDate.substring(4,7);
		request.setAttribute("strmonth", strmonth);

		double dtotalamount=0.0d;
		double dsum1=0.0d;
		double dsum2=0.0d;
		double dsum3=0.0d;
		double dsum4=0.0d;
		double dsum5=0.0d;
		double dsum12=0.0d;

		if(advanceTaxDocument!= null){

			dtotalamount = advanceTaxDocument.getTotal_Amount();
			dsum1=advanceTaxDocument.getTotal_Sum1();
			dsum2=advanceTaxDocument.getTotal_Sum2();
			dsum3=advanceTaxDocument.getTotal_Sum3();
			dsum4=advanceTaxDocument.getTotal_Sum4();
			dsum5=advanceTaxDocument.getTotal_Sum5();
			dsum12=dsum1+dsum2;

			request.setAttribute("totaltax", dtotalamount);
			request.setAttribute("dsum12",dsum12);
			request.setAttribute("dsum3",dsum3+dsum12);
			request.setAttribute("dsum4",dsum4+dsum3+dsum12);
		}else{
			request.setAttribute("totaltax", "0");
			request.setAttribute("dsum12","0");
			request.setAttribute("dsum3","0");
			request.setAttribute("dsum4","0");
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
