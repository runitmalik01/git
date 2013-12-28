package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleVIA;
import in.gov.incometaxindiaefiling.y2012_2013.UsrDeductUndChapVIA;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.BusinessProfessionDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.SchFourtyFourAEDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.deduction.DeductionHead;
import com.mootly.wcm.model.deduction.DeductionSection;
import com.mootly.wcm.services.DeductionListService;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.utils.XmlCalculation;

public class DeductionVIASchedules extends XmlCalculation {

	private static Logger log = LoggerFactory.getLogger(DeductionVIASchedules .class);

	DeductionDocument deductionDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;
	OtherSourcesDocument otherSourcesDocument = null;

	public DeductionVIASchedules(DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation, OtherSourcesDocument otherSourcesDocument) {
		this.deductionDocument = deductionDocument;
		this.memberPersonalInformation = memberPersonalInformation;
		this.otherSourcesDocument = otherSourcesDocument;
	}

	/**
	 * 2012-2013 Financial Year,HstResponse,HstRequest
	 * @param itr
	 * @return
	 */

	public ScheduleVIA getScheduleVIA(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>();//not being used anywhere
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleVIA scheduleVIA = new ScheduleVIA();
		DeductUndChapVIA deductUndChapVIA = new DeductUndChapVIA();
		UsrDeductUndChapVIA usrDeductUndChapVIA = new UsrDeductUndChapVIA();
		//FinancialYear financialYear =  (FinancialYear) request.getAttribute("financialYear");

		Double grossInvestment = 0D;
		Map<String,Object> totalMapForJSDe = new HashMap<String, Object>();
		DeductionListService deductionListService=new DeductionListService();
		Map<String,DeductionSection> deductionSectionMap=deductionListService.getDeductionSectionMap().get(financialYear);
		Map<String,DeductionSection> modDeductionSectionMap = new HashMap<String, DeductionSection>();
		modDeductionSectionMap.putAll(deductionSectionMap);
		
		//This is tricky deductionDocument can be null but othersource income could have section 80tta data?
		List<DeductionDocumentDetail> listOfDeductionDocumentDetail = getDeductionDocumentList(deductionDocument,otherSourcesDocument);

		if(listOfDeductionDocumentDetail!=null){
			if (listOfDeductionDocumentDetail!= null && listOfDeductionDocumentDetail.size() > 0 ){
				for(String key:deductionSectionMap.keySet()){
					Double sumSection=0D;
					DeductionSection deductionsec=deductionSectionMap.get(key);
					if(deductionsec.getListOfDeductionHead().size()!=0){
						for(DeductionHead head:deductionsec.getListOfDeductionHead()){
							Double sumHead=0D;
							for(DeductionDocumentDetail deductionDocumentDetail:listOfDeductionDocumentDetail){
								if(deductionDocumentDetail.getHead().equals(head.getName().replaceAll("-", "_"))){
									sumHead=sumHead+deductionDocumentDetail.getInvestment();
								}
							}
							String sanitizedKey="total_"+head.getName().replaceAll("-", "_");
							totalMapForJSDe.put(sanitizedKey, sumHead);
						}
					}
					for(DeductionDocumentDetail deductionDocumentDetail:listOfDeductionDocumentDetail){
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
		grossTotal(financialYear, inputBeans);
		totalMapForJSDe.put("isSeniorCitizen",financialYear.isSeniorCitizen(memberPersonalInformation.getDOB().getTime()));
		totalMapForJSDe.put("salarypension",longsalarytotal);
		totalMapForJSDe.put("businessIncome", getBusinessIncome(itr, financialYear, inputBeans));
		inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		totalMapForJSDe.put("businessIncomeITR4",getBusinessIncITR4S((MemberPersonalInformation)inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase()),(BusinessProfessionDocument)inputBeans.get(BusinessProfessionDocument.class.getSimpleName().toLowerCase()),(SchFourtyFourAEDocument)inputBeans.get(SchFourtyFourAEDocument.class.getSimpleName().toLowerCase())));
		totalMapForJSDe.put("othersources",otherincome);
		totalMapForJSDe.put("houseproperty",houseIncomeTotal);
		Map<String,Object> resultMapDe = ScreenCalculatorService.getScreenCalculations("Chapter6Calc.js", requestParameterMap, totalMapForJSDe);
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
			//modify List of Deduction on basis of Selected ITR Form
			if(deductionSectionMap.get(keySection).getAdditionalProperties().get("itrform").contains(memberPersonalInformation.getSelectedITRForm().name().toLowerCase())){
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
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						log.warn ("Exception while invoking the method of deductUndChapVIA or usrDeductUndChapVIA",e);

					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						log.warn ("Exception while accessing the method of deductUndChapVIA or usrDeductUndChapVIA",e);
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						log.warn ("TargetException while invoking the method of deductUndChapVIA or usrDeductUndChapVIA",e);
					}
				}
			}
		}
		deductUndChapVIA.setTotalChapVIADeductions(indianCurrencyHelper.bigIntegerRound(totaleligiblededuction));
		usrDeductUndChapVIA.setTotalChapVIADeductions(indianCurrencyHelper.bigIntegerRound(grossInvestment));
		scheduleVIA.setUsrDeductUndChapVIA(usrDeductUndChapVIA);
		scheduleVIA.setDeductUndChapVIA(deductUndChapVIA);

		return scheduleVIA;

	}
	/**
	 * New Helper function to deal with complications about 80tta
	 * @param deductionDocument
	 * @param otherSourcesDocument
	 * @return
	 */
	public static List<DeductionDocumentDetail> getDeductionDocumentList(DeductionDocument deductionDocument,OtherSourcesDocument otherSourcesDocument) {
		List<DeductionDocumentDetail> listOfDeductionDocumentDetail = null;
		if(deductionDocument!=null){
			if (deductionDocument.getDeductionDocumentDetailList() != null && deductionDocument.getDeductionDocumentDetailList().size() > 0 ){
				listOfDeductionDocumentDetail = new ArrayList<DeductionDocumentDetail>();
				listOfDeductionDocumentDetail.addAll(deductionDocument.getDeductionDocumentDetailList());
			}
		}
		if (otherSourcesDocument != null && otherSourcesDocument.getBank_detail_saving() != null && otherSourcesDocument.getBank_detail_saving() > 0D) {
			if (listOfDeductionDocumentDetail == null) listOfDeductionDocumentDetail = new ArrayList<DeductionDocumentDetail>();
			DeductionDocumentDetail bankSavingDetail = new DeductionDocumentDetail();
			bankSavingDetail.setSection("80tta");
			bankSavingDetail.setHead("80tta");
			bankSavingDetail.setInvestment(otherSourcesDocument.getBank_detail_saving());
			listOfDeductionDocumentDetail.add(bankSavingDetail);
		}
		return listOfDeductionDocumentDetail;
	}
	/**
	 * Calculate Business Income that also take part while calculating Deductions.
	 * 
	 * @param itr {@link ITR}
	 * @param financialYear {@link FinancialYear}
	 * @param inputBeans {@link HippoBean}
	 * 
	 * **/
	public Double getBusinessIncome(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){
		Double businessIncome = 0d;
		Long notSpecBuss = 0l;
		Long profitLossSpecBuss = 0l;
		Long specBusinessIncome = 0l;
		MemberPersonalInformation pi = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		
		ITRForm selectedITR = pi.getSelectedITRForm();
		if(selectedITR.equals(ITRForm.ITR4)){
			ITR4_ScheduleBP iTR4_ScheduleBP = new ITR4_ScheduleBP((IncBusinessProfessionDoc)inputBeans.get(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase()), (ProfitAndLossDocument)inputBeans.get(ProfitAndLossDocument.class.getSimpleName().toLowerCase()),
																(OtherInformationDocument)inputBeans.get(OtherInformationDocument.class.getSimpleName().toLowerCase()),
					                                            (ScheduleDPMDocument)inputBeans.get(ScheduleDPMDocument.class.getSimpleName().toLowerCase()), (ScheduleDOADocument)inputBeans.get(ScheduleDOADocument.class.getSimpleName().toLowerCase()), 
					                                            (ScheduleESRDocument)inputBeans.get(ScheduleESRDocument.class.getSimpleName().toLowerCase()), (DeductionSchedTenADocumemt)inputBeans.get(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase()));
			        ITR4ScheduleBP iTR4ScheduleBP = iTR4_ScheduleBP.getITR4ScheduleBP(itr, financialYear, inputBeans);
			        if(iTR4ScheduleBP != null){
			        	notSpecBuss = iTR4ScheduleBP.getBusinessIncOthThanSpec().getNetPLBusOthThanSpec7A7B7C();
						profitLossSpecBuss = iTR4ScheduleBP.getSpecifiedBusinessInc().getPLFrmSpecifiedBus();
						specBusinessIncome = iTR4ScheduleBP.getSpecBusinessInc().getAdjustedPLFrmSpecuBus();	
			        }
			        businessIncome = notSpecBuss.doubleValue()+ profitLossSpecBuss.doubleValue()+specBusinessIncome.doubleValue();
		}
		
		
		return businessIncome;
	}
	public Double getBusinessIncITR4S(MemberPersonalInformation memberPersonalInformation,BusinessProfessionDocument businessProfessionDocument,SchFourtyFourAEDocument schFourtyFourAEDocument){
		Double incChargUnderBusiness = 0d;
		if(memberPersonalInformation != null){
			ITRForm itrForm= memberPersonalInformation.getSelectedITRForm();
			if(itrForm.equals(ITRForm.ITR4S)){
				if(businessProfessionDocument != null){
					incChargUnderBusiness = incChargUnderBusiness + businessProfessionDocument.getGrossPresumptIncome();
				}
				if(schFourtyFourAEDocument != null){
					incChargUnderBusiness = incChargUnderBusiness + schFourtyFourAEDocument.getTotal_deemedIncome_Heavy()+schFourtyFourAEDocument.getTotal_deemedIncome_Light();
				}
			}
		} 
		return incChargUnderBusiness;
	}
}
