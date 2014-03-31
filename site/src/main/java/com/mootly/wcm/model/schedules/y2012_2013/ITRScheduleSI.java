package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleSI;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleSI.SplCodeRateTax;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.compound.ScheduleSIDocumentDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRScheduleSISections;
import com.mootly.wcm.services.ITRAdditionalScheduleService;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITRScheduleSI {

	ScheduleSIDocument scheduleSIDocument = null;
	CapitalAssetDocument capitalAssetDocument = null;
	OtherSourcesDocument otherSourcesDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;
	FormSixteenDocument formSixteenDocument = null;
	SalaryIncomeDocument salaryIncomeDocument = null;
	HouseProperty housePropertyDocument = null;

	public static final Logger log = LoggerFactory.getLogger(ITRScheduleSI.class);

	public ITRScheduleSI(ScheduleSIDocument scheduleSIDocument, CapitalAssetDocument capitalAssetDocument, OtherSourcesDocument otherSourcesDocument,
			FormSixteenDocument formSixteenDocument, SalaryIncomeDocument salaryIncomeDocument, HouseProperty housePropertyDocument, MemberPersonalInformation memberPersonalInformation){
		this.scheduleSIDocument = scheduleSIDocument;
		this.capitalAssetDocument = capitalAssetDocument;
		this.otherSourcesDocument = otherSourcesDocument;
		this.memberPersonalInformation = memberPersonalInformation;
		this.formSixteenDocument = formSixteenDocument;
		this.salaryIncomeDocument = salaryIncomeDocument;
		this.housePropertyDocument = housePropertyDocument;

	}
	IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
	public ScheduleSI getScheduleSI(ITR itr, FinancialYear financialYear){

		Map<String, HippoBean> inputBean = new HashMap<String, HippoBean>();
		inputBean.put(ScheduleSIDocument.class.getSimpleName().toLowerCase(), scheduleSIDocument);
		inputBean.put(CapitalAssetDocument.class.getSimpleName().toLowerCase(), capitalAssetDocument);
		inputBean.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(), otherSourcesDocument);
		inputBean.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(), memberPersonalInformation);
		inputBean.put(FormSixteenDocument.class.getSimpleName().toLowerCase(), formSixteenDocument);
		inputBean.put(SalaryIncomeDocument.class.getSimpleName().toLowerCase(), salaryIncomeDocument);
		inputBean.put(HouseProperty.class.getSimpleName().toLowerCase(), housePropertyDocument);

		ScheduleSI scheduleSI = new ScheduleSI();

		List<SplCodeRateTax> finalSplCodeRateTax = new ArrayList<SplCodeRateTax>();
		Double totalCalTaxOnInc = 0d;
		//list of all section which are compulsory for Xml
		List<ITRScheduleSISections> xmlSISectionsList = ITRScheduleSISections.createXmlActiveListOfSI();
		if(capitalAssetDocument != null){
			Map<String, Map<String,Object>> resultMap = capitalAssetDocument.getScheduleSIService(financialYear, inputBean);
			List<SplCodeRateTax> returnSplCodeRateTaxList = invokeITRAdditionScreenResults(resultMap);
			if(returnSplCodeRateTaxList !=null){
				for(SplCodeRateTax splCodeTax:returnSplCodeRateTaxList){
					finalSplCodeRateTax.add(splCodeTax);
				}
			}
		}
		if(otherSourcesDocument != null){
			Map<String, Map<String,Object>> resultMap = otherSourcesDocument.getScheduleSIService(financialYear, inputBean);
			List<SplCodeRateTax> returnSplCodeRateTaxList = invokeITRAdditionScreenResults(resultMap);
			if(returnSplCodeRateTaxList !=null){
				for(SplCodeRateTax splCodeTax:returnSplCodeRateTaxList){
					finalSplCodeRateTax.add(splCodeTax);
				}
			}
		}
		for(ITRScheduleSISections siSection:xmlSISectionsList){
			//fetch all section from CapitalAssetsDocument
			if(siSection.getDocumentName().equals(CapitalAssetDocument.class.getSimpleName())){
				if(capitalAssetDocument == null){
					finalSplCodeRateTax.add(dummyInvokeScheduleSI(siSection));
				}
			}
			//fetch all section from OtherSourceDocument
			if(siSection.getDocumentName().equals(OtherSourcesDocument.class.getSimpleName())){
				if(otherSourcesDocument == null){
					finalSplCodeRateTax.add(dummyInvokeScheduleSI(siSection));
				}
			}
			//fetch all section from SchedulSIDocument
			if(siSection.getDocumentName().equals(ScheduleSIDocument.class.getSimpleName())){
				finalSplCodeRateTax.add(dummyInvokeScheduleSI(siSection));
			}
		}
		for(ITRScheduleSISections siSection:xmlSISectionsList){
			if(scheduleSIDocument !=null && siSection.getDocumentName().equals(ScheduleSIDocument.class.getSimpleName())){
				if(scheduleSIDocument.getScheduleSiDetailList().size()!=0 && scheduleSIDocument.getScheduleSiDetailList() != null){
					for(ScheduleSIDocumentDetail siDetail:scheduleSIDocument.getScheduleSiDetailList()){
						for(SplCodeRateTax codeRateTax:finalSplCodeRateTax){
							if(codeRateTax.getSecCode().equals(siSection.getXmlCode()) && siSection.getXmlCode().equals(siDetail.getSchedulesiSection())){
								codeRateTax.setSplRatePercent(siDetail.getSpecialRate());
								codeRateTax.setSplRateInc(indianCurrencyHelper.bigIntegerRound(siDetail.getAmount()));
								codeRateTax.setSplRateIncTax(indianCurrencyHelper.bigIntegerRound(siDetail.getCalcRateIncome()));
							}
						}
					}
				}
			}
		}
		//create all list of those ScheduleSISections which are not compulsory for Xml generation
		List<ITRScheduleSISections> xmlreverseSISectionsList = new ArrayList<ITRScheduleSISections>();
		for(ITRScheduleSISections siSection:ITRScheduleSISections.values()){
			if(siSection != ITRScheduleSISections.UNKNOWN){
				if(!siSection.isXmlActive()){
					xmlreverseSISectionsList.add(siSection);
				}
			}
		}
		for(ITRScheduleSISections xmlRevSiSection:xmlreverseSISectionsList){
			if(scheduleSIDocument != null){
				if(scheduleSIDocument.getScheduleSiDetailList() != null && scheduleSIDocument.getScheduleSiDetailList().size()!=0){
					for(ScheduleSIDocumentDetail siDetail:scheduleSIDocument.getScheduleSiDetailList()){
						if(xmlRevSiSection.getXmlCode().equals(siDetail.getSchedulesiSection())){
							finalSplCodeRateTax.add(invokeFromScheduleSIDetail(siDetail));
						}
					}
				}
			}
		}
		//System.out.println("finalSplCodeRateTax"+finalSplCodeRateTax.size());
		if(finalSplCodeRateTax !=null){
			for(SplCodeRateTax splCodeRateTax:finalSplCodeRateTax){
				scheduleSI.getSplCodeRateTax().add(splCodeRateTax);
			}
		}
		for(SplCodeRateTax splCodeRateTax:scheduleSI.getSplCodeRateTax()){
			totalCalTaxOnInc = totalCalTaxOnInc + splCodeRateTax.getSplRateIncTax().doubleValue();
		}
		if (log.isInfoEnabled()) {
			log.info("TOTAL TAX CALC ON INCOME:" + totalCalTaxOnInc);
		}
		//System.out.println("value ::"+totalCalTaxOnInc);
		scheduleSI.setTotSplRateIncTax(indianCurrencyHelper.bigIntegerRound(totalCalTaxOnInc));
		return scheduleSI;
	}
	/**
	 * This method is used to invoke method of {@link SplCodeRateTax} using {@link Map} of type Map<String, Map<String,Object>> from {@link ITRAdditionalScheduleService}
	 *
	 * @param resultMap {@link Map}
	 *
	 * @return {@link List} of type {@link SplCodeRateTax}
	 * */
	public List<SplCodeRateTax> invokeITRAdditionScreenResults(Map<String, Map<String,Object>> resultMap){
		List<SplCodeRateTax> splCodeRateTaxList = new ArrayList<ScheduleSI.SplCodeRateTax>();
		for(String key:resultMap.keySet()){
			SplCodeRateTax splCodeRateTax = new SplCodeRateTax();
			splCodeRateTax.setSecCode(key);
			splCodeRateTax.setSplRatePercent(ITRScheduleSISections.getScheduleSISection(key).getPercentRate()[ITRScheduleSISections.getScheduleSISection(key).getPercentRate().length-1]);
			splCodeRateTax.setSplRateInc(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get(key).get("userAmount").toString())));
			splCodeRateTax.setSplRateIncTax(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get(key).get("taxOnIncome").toString())));
			splCodeRateTaxList.add(splCodeRateTax);
		}
		return splCodeRateTaxList;
	}
	/**
	 * This method is used to invoke method of {@link SplCodeRateTax} if there is no documents.
	 *
	 * @param siSection Schedule SI Section
	 *
	 * @return {@link SplCodeRateTax}
	 *
	 * */
	public SplCodeRateTax dummyInvokeScheduleSI(ITRScheduleSISections siSection){
		double percentRate = 0d;
		SplCodeRateTax splCodeRateTax = new SplCodeRateTax();
		splCodeRateTax.setSecCode(siSection.getXmlCode());
		if(siSection.getXmlCode().equals("1")){
			percentRate = siSection.getPercentRate()[1];//default value of percantRate for Section code "1" will be 10 
		}
		else { 
			percentRate = siSection.getPercentRate()[siSection.getPercentRate().length-1];
		}
		splCodeRateTax.setSplRatePercent(percentRate);
		splCodeRateTax.setSplRateInc(new BigInteger("0"));
		splCodeRateTax.setSplRateIncTax(new BigInteger("0"));
		return splCodeRateTax;
	}
	/**
	 * This method is being used to invoke method of {@link SplCodeRateTax} from {@link ScheduleSIDocumentDetail}
	 *
	 * @param siDetail {@link ScheduleSIDocumentDetail}
	 *
	 * @return {@link SplCodeRateTax}
	 *
	 * */
	public SplCodeRateTax invokeFromScheduleSIDetail(ScheduleSIDocumentDetail siDetail){
		SplCodeRateTax splCodeRateTax = new SplCodeRateTax();
		splCodeRateTax.setSecCode(siDetail.getSchedulesiSection());
		splCodeRateTax.setSplRateInc(indianCurrencyHelper.bigIntegerRound(siDetail.getAmount()));
		splCodeRateTax.setSplRateIncTax(indianCurrencyHelper.bigIntegerRound(siDetail.getCalcRateIncome()));
		splCodeRateTax.setSplRatePercent(siDetail.getSpecialRate());
		return splCodeRateTax;
	}
}