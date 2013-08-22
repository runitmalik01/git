package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ScheduleSI;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleSI.SplCodeRateTax;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

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

		List<SplCodeRateTax> finalSplCodeRateTax = new ArrayList<ScheduleSI.SplCodeRateTax>();

		//list of all section which are compulsory for Xml 
		List<ITRScheduleSISections> xmlSISectionsList = ITRScheduleSISections.createXmlActiveListOfSI();		
		for(ITRScheduleSISections siSection:xmlSISectionsList){
			//fetch all section from CapitalAssetsDocument
			if(siSection.getDisplayName().equals(CapitalAssetDocument.class.getSimpleName())){
				if(capitalAssetDocument != null){
					Map<String, Map<String,Object>> resultMap = capitalAssetDocument.getScheduleSIService(financialYear, inputBean);
					List<SplCodeRateTax> returnSplCodeRateTaxList = invokeITRAdditionScreenResults(resultMap);
					if(returnSplCodeRateTaxList !=null){
						for(SplCodeRateTax splCodeTax:returnSplCodeRateTaxList){
							finalSplCodeRateTax.add(splCodeTax);	
						}
					}
				}else{
					finalSplCodeRateTax.add(dummyInvokeScheduleSI(siSection));
				}
			}
			//fetch all section from OtherSourceDocument
			if(siSection.getDisplayName().equals(OtherSourcesDocument.class.getSimpleName())){
				if(otherSourcesDocument != null){
					Map<String, Map<String,Object>> resultMap = otherSourcesDocument.getScheduleSIService(financialYear, inputBean);
					List<SplCodeRateTax> returnSplCodeRateTaxList = invokeITRAdditionScreenResults(resultMap);
					if(returnSplCodeRateTaxList !=null){
						for(SplCodeRateTax splCodeTax:returnSplCodeRateTaxList){
							finalSplCodeRateTax.add(splCodeTax);	
						}
					}
				}else{
					finalSplCodeRateTax.add(dummyInvokeScheduleSI(siSection));
				}
			}
			//fetch all section from SchedulSIDocument
			if(siSection.getDisplayName().equals(ScheduleSIDocument.class.getSimpleName())){
				if(scheduleSIDocument !=null){
					if(scheduleSIDocument.getScheduleSiDetailList().size()!=0 && scheduleSIDocument.getScheduleSiDetailList() != null){
						for(ScheduleSIDocumentDetail siDetail:scheduleSIDocument.getScheduleSiDetailList()){
							if(siSection.getXmlCode().equals(siDetail.getSchedulesiSection())){
								finalSplCodeRateTax.add(invokeFromScheduleSIDetail(siDetail));
							}
						}
					}else{
						finalSplCodeRateTax.add(dummyInvokeScheduleSI(siSection));	
					}
				}else{
					finalSplCodeRateTax.add(dummyInvokeScheduleSI(siSection));
				}
			}
		}
		//create all list of those ScheduleSISections which are not compulsory for Xml generation
		List<ITRScheduleSISections> xmlreverseSISectionsList = new ArrayList<ITRScheduleSISections>();
		for(ITRScheduleSISections siSection:ITRScheduleSISections.values()){
			if(!siSection.isXmlActive()){
				xmlreverseSISectionsList.add(siSection);
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
		if(scheduleSIDocument !=null){
			scheduleSI.setTotSplRateIncTax(indianCurrencyHelper.bigIntegerRound(scheduleSIDocument.getTotalCalTaxOnInc()));
		}else{
			scheduleSI.setTotSplRateIncTax(new BigInteger("0"));
		}
		if(finalSplCodeRateTax !=null){
			for(SplCodeRateTax splCodeRateTax:finalSplCodeRateTax){
				scheduleSI.getSplCodeRateTax().add(splCodeRateTax);	
			}
		}
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
			splCodeRateTax.setSplRateInc(indianCurrencyHelper.bigIntegerRoundStr(resultMap.get(key).get("userAmount").toString()));
			splCodeRateTax.setSplRateIncTax(indianCurrencyHelper.bigIntegerRoundStr(resultMap.get(key).get("taxOnIncome").toString()));
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
		SplCodeRateTax splCodeRateTax = new SplCodeRateTax();
		splCodeRateTax.setSecCode(siSection.getXmlCode());
		splCodeRateTax.setSplRatePercent(siSection.getPercentRate()[siSection.getPercentRate().length-1]);
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