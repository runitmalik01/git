package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP.BusinessIncOthThanSpec;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP.BusinessIncOthThanSpec.DeductUs35AC;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP.BusinessIncOthThanSpec.DeductionUs10S;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP.BusinessIncOthThanSpec.DeemedProfitBusUs;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP.BusinessIncOthThanSpec.DepreciationAllowITAct32;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP.BusinessIncOthThanSpec.IncCredPL;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP.SpecBusinessInc;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleBP.SpecifiedBusinessInc;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAPL;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule10A;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule10AA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleDEP;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.IncBusinessProfessionVar;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherInformationVariables;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.ProfitAndLossVariables;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR4_ScheduleBP {

	IncBusinessProfessionDoc incBusinessProfessionDoc = null;
	ProfitAndLossDocument profitAndLossDocument = null;
	OtherInformationDocument otherInformationDocument = null;
	ScheduleDPMDocument scheduleDPMDocument = null;
	ScheduleDOADocument scheduleDOADocument = null;
	ScheduleESRDocument scheduleESRDocument = null;
	DeductionSchedTenADocumemt deductionSchedTenADocumemt = null;

	public ITR4_ScheduleBP(IncBusinessProfessionDoc incBusinessProfessionDoc, ProfitAndLossDocument profitAndLossDocument,
			OtherInformationDocument otherInformationDocument, ScheduleDPMDocument scheduleDPMDocument, ScheduleDOADocument scheduleDOADocument,
			ScheduleESRDocument scheduleESRDocument, DeductionSchedTenADocumemt deductionSchedTenADocumemt){
		this.incBusinessProfessionDoc = incBusinessProfessionDoc;
		this.profitAndLossDocument = profitAndLossDocument;
		this.otherInformationDocument = otherInformationDocument;
		this.scheduleDPMDocument = scheduleDPMDocument;
		this.scheduleDOADocument = scheduleDOADocument;
		this.scheduleESRDocument = scheduleESRDocument;
		this.deductionSchedTenADocumemt = deductionSchedTenADocumemt;
	}

	public ITR4ScheduleBP getITR4ScheduleBP(ITR itr, FinancialYear financialYear, Map<String,HippoBean> inputBeans){

		ITR4ScheduleBP iTR4ScheduleBP = new ITR4ScheduleBP();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		//get Schedule ESR
		ESRSchedule eSRSchedule = new ESRSchedule(scheduleESRDocument);
		ScheduleESR scheduleESR = eSRSchedule.getScheduleESR(itr);

		//get Schedule10A
		ITR_Schedule10A iTR_Schedule10A = new ITR_Schedule10A(deductionSchedTenADocumemt);
		Schedule10A schedule10a = iTR_Schedule10A.getITRSchedule10a(itr, financialYear, inputBeans);

		// get Schedule10AA
		ITR_Schedule10AA iTR_Schedule10AA = new ITR_Schedule10AA(deductionSchedTenADocumemt);
		Schedule10AA schedule10aa = iTR_Schedule10AA.getITRSchedule10aa(itr, financialYear, inputBeans);

		//To set Dummy if OtherInformationDocument is null
		if(otherInformationDocument == null){
			OtherInformationDocument otherInformationDocumentDummy = new OtherInformationDocument();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(otherInformationDocumentDummy);
			Field[] fields =  OtherInformationVariables.class.getDeclaredFields();
			for(Field field : fields){
				if(field.getType().getSimpleName().equals(Double.class.getSimpleName())){
					directFieldAccessor.setPropertyValue(field.getName(), 0d);
				}
				if(field.getType().getSimpleName().equals(String.class.getSimpleName())){
					if(field.getName().equals("accounting_employed")){
						directFieldAccessor.setPropertyValue(field.getName(), "MERC");
					}
					if(field.getName().equals("method_accounting")){
						directFieldAccessor.setPropertyValue(field.getName(), "N");
					}
					if(field.getName().equals("raw_material")){
						directFieldAccessor.setPropertyValue(field.getName(), "1");
					}
					if(field.getName().equals("finished_goods")){
						directFieldAccessor.setPropertyValue(field.getName(), "1");
					}
					if(field.getName().equals("stock_valuation")){
						directFieldAccessor.setPropertyValue(field.getName(), "N");
					}
				}
			}
			this.otherInformationDocument = otherInformationDocumentDummy;
		}

		//To set Dummy if ProfitLossDocument is null
		if(profitAndLossDocument == null){
			ProfitAndLossDocument profitAndLossDocumentDummy = new ProfitAndLossDocument();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(profitAndLossDocumentDummy);
			Field[] fields =  ProfitAndLossVariables.class.getDeclaredFields();
			for(Field field : fields){
				if(field.getType().getSimpleName().equals(Double.class.getSimpleName())){
					directFieldAccessor.setPropertyValue(field.getName(), 0d);
				}
				if(field.getType().getSimpleName().equals(String.class.getSimpleName())){
					if(field.getName().equals("isAccountMaintain")){
						directFieldAccessor.setPropertyValue(field.getName(), "Yes");
					}
				}
			}
			this.profitAndLossDocument = profitAndLossDocumentDummy;
		}

		//To set Dummy if incBusinessProfessionDoc is null
		if(incBusinessProfessionDoc == null){
			IncBusinessProfessionDoc IncBusinessProfessionDocDummy = new IncBusinessProfessionDoc();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(IncBusinessProfessionDocDummy);
			Field[] fields =  IncBusinessProfessionVar.class.getDeclaredFields();
			for(Field field : fields){
				if(field.getType().getSimpleName().equals(Double.class.getSimpleName())){
					directFieldAccessor.setPropertyValue(field.getName(), 0d);
				}
				this.incBusinessProfessionDoc = IncBusinessProfessionDocDummy;
			}
		}

		// Getting the values of Profit and Loss from ProfitLossSchedule instead of getting from its bean
		ProfitLossSchedule profitLossSchedule = new ProfitLossSchedule(profitAndLossDocument);
		PARTAPL pARTAPL = profitLossSchedule.getPARTAPL(itr);

		BusinessIncOthThanSpec businessIncOthThanSpec = new BusinessIncOthThanSpec();
		if(profitAndLossDocument.getIsAccountMaintain().equals("Yes")){
			businessIncOthThanSpec.setProfBfrTaxPL(pARTAPL.getDebitsToPL().getPBT());
		}
		if(profitAndLossDocument.getIsAccountMaintain().equals("No")){
			businessIncOthThanSpec.setProfBfrTaxPL(pARTAPL.getNoBooksOfAccPL().getNetProfit());
		}
		businessIncOthThanSpec.setNetPLFromSpecBus(incBusinessProfessionDoc.getProfitLoss_SpecualtiveBusiness().longValue());
		businessIncOthThanSpec.setNetPLFromSpecifiedBus(incBusinessProfessionDoc.getProfitLoss_SpecifiedBusiness().longValue());
		businessIncOthThanSpec.setIncRecCredPLOthHeads(incBusinessProfessionDoc.getIncomeCredited_ProfitLossAcc().longValue());
		businessIncOthThanSpec.setPLUs44SChapXIIG(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getProfitLoss_IncludeSchPL()));
		IncCredPL incCredPL = new IncCredPL();
		incCredPL.setFirmShareInc(incBusinessProfessionDoc.getShareIncome_Firms().longValue());
		incCredPL.setAOPBOISharInc(incBusinessProfessionDoc.getShareIncome_Firms_AOP().longValue());
		incCredPL.setOthExempInc(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getExemptIncome_AnyOther()));
		incCredPL.setTotExempIncPL(incCredPL.getFirmShareInc() + incCredPL.getAOPBOISharInc() + incCredPL.getOthExempInc().longValue());
		businessIncOthThanSpec.setIncCredPL(incCredPL);
		businessIncOthThanSpec.setBalancePLOthThanSpecBus(businessIncOthThanSpec.getProfBfrTaxPL() - businessIncOthThanSpec.getNetPLFromSpecBus() - businessIncOthThanSpec.getNetPLFromSpecifiedBus()
				- businessIncOthThanSpec.getIncRecCredPLOthHeads() - businessIncOthThanSpec.getPLUs44SChapXIIG().longValue() - incCredPL.getTotExempIncPL());
		businessIncOthThanSpec.setExpDebToPLOthHeads(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getExpenseDebit_HeadsInc()));
		businessIncOthThanSpec.setExpDebToPLExemptInc(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getExpenseDebit_ExemptInc()));
		businessIncOthThanSpec.setTotExpDebPL(businessIncOthThanSpec.getExpDebToPLOthHeads().add(businessIncOthThanSpec.getExpDebToPLExemptInc()));
		businessIncOthThanSpec.setAdjustedPLOthThanSpecBus(businessIncOthThanSpec.getBalancePLOthThanSpecBus() + businessIncOthThanSpec.getTotExpDebPL().longValue());
		businessIncOthThanSpec.setDepreciationDebPLCosAct(pARTAPL.getDebitsToPL().getDepreciationAmort());
		DepreciationAllowITAct32 depreciationAllowITAct32 = new DepreciationAllowITAct32();

		ITR_ScheduleDEP iTR_ScheduleDEP = new ITR_ScheduleDEP(scheduleDPMDocument, scheduleDOADocument);
		ScheduleDEP scheduleDEP = iTR_ScheduleDEP.getScheduleDEP(itr);

		depreciationAllowITAct32.setDepreciationAllowUs321Ii(scheduleDEP.getSummaryFromDeprSch().getTotalDepreciation());
		depreciationAllowITAct32.setDepreciationAllowUs321I(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getDepreAllow_us32_1_ii()));
		depreciationAllowITAct32.setTotDeprAllowITAct(depreciationAllowITAct32.getDepreciationAllowUs321Ii().add(depreciationAllowITAct32.getDepreciationAllowUs321I()));
		businessIncOthThanSpec.setDepreciationAllowITAct32(depreciationAllowITAct32);
		businessIncOthThanSpec.setAdjustPLAfterDeprOthSpecInc(businessIncOthThanSpec.getAdjustedPLOthThanSpecBus() + businessIncOthThanSpec.getDepreciationDebPLCosAct().longValue()
				- depreciationAllowITAct32.getTotDeprAllowITAct().longValue());
		businessIncOthThanSpec.setAmtDebPLDisallowUs36(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_disallowable()));
		businessIncOthThanSpec.setAmtDebPLDisallowUs37(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_disallowableus37()));
		businessIncOthThanSpec.setAmtDebPLDisallowUs40(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmount_disallowanceus40()));
		businessIncOthThanSpec.setAmtDebPLDisallowUs40A(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_disallowanceus40()));
		businessIncOthThanSpec.setAmtDebPLDisallowUs43B(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_us43b()));
		businessIncOthThanSpec.setInterestDisAllowUs23SMEAct(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getInterestDisallow_sec23()));
		businessIncOthThanSpec.setDeemIncUs41(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getDeemedIncome_Sec41()));
		businessIncOthThanSpec.setDeemIncUs3380HHD80IA(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getDeemedIncome_Sec33AB()));
		businessIncOthThanSpec.setOthItemDisallowUs28To44DA(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getAddItem_sec28to44DA()));
		businessIncOthThanSpec.setAnyOthIncNotInclInExpDisallowPL(incBusinessProfessionDoc.getAnyIncNotInclude_PLAcc().longValue());
		businessIncOthThanSpec.setTotAfterAddToPLDeprOthSpecInc(businessIncOthThanSpec.getAmtDebPLDisallowUs36().longValue()+businessIncOthThanSpec.getAmtDebPLDisallowUs37().longValue()+businessIncOthThanSpec.getAmtDebPLDisallowUs40().longValue()+
				businessIncOthThanSpec.getAmtDebPLDisallowUs40A().longValue()+businessIncOthThanSpec.getAmtDebPLDisallowUs43B().longValue()+businessIncOthThanSpec.getInterestDisAllowUs23SMEAct().longValue()+
				businessIncOthThanSpec.getDeemIncUs41().longValue()+businessIncOthThanSpec.getDeemIncUs3380HHD80IA().longValue()+businessIncOthThanSpec.getOthItemDisallowUs28To44DA().longValue()+businessIncOthThanSpec.getAnyOthIncNotInclInExpDisallowPL());
		businessIncOthThanSpec.setDeductUs321Iii(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getDeductionAllow_Sec32_1_iii()));
		businessIncOthThanSpec.setDebPLUs35ExcessAmt(scheduleESR.getDeductionUs35().getTotUs35().getDeductUs35().getExcessAmtOverDebPL());
		businessIncOthThanSpec.setAmtDisallUs40NowAllow(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getAmountdisallowable_us40B()));
		businessIncOthThanSpec.setAmtDisallUs43BNowAllow(indianCurrencyHelper.bigIntegerRound(otherInformationDocument.getTotalamount_us43()));
		DeductUs35AC deductUs35AC = new DeductUs35AC();
		deductUs35AC.setDebPL35ACAmt(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getAmountDebited_ToProfitLoss()));
		deductUs35AC.setAmtAllowUs35ACt(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getAmountAllow_Deduction()));
		if(deductUs35AC.getAmtAllowUs35ACt().subtract(deductUs35AC.getDebPL35ACAmt()).longValue() > 0){
			deductUs35AC.setExcessAmtDeduct35AC(deductUs35AC.getAmtAllowUs35ACt().subtract(deductUs35AC.getDebPL35ACAmt()));
		}else
			deductUs35AC.setExcessAmtDeduct35AC(new BigInteger("0"));
		businessIncOthThanSpec.setDeductUs35AC(deductUs35AC);
		businessIncOthThanSpec.setAnyOthAmtAllDeduct(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getAnyOtherAmountAllow_Deduction()));
		businessIncOthThanSpec.setTotDeductionAmts(businessIncOthThanSpec.getDeductUs321Iii().add(businessIncOthThanSpec.getDebPLUs35ExcessAmt()).add(businessIncOthThanSpec.getAmtDisallUs40NowAllow())
				.add(businessIncOthThanSpec.getAmtDisallUs43BNowAllow()).add(deductUs35AC.getExcessAmtDeduct35AC()).add(businessIncOthThanSpec.getAnyOthAmtAllDeduct()));
		businessIncOthThanSpec.setPLAftAdjDedBusOthThanSpec(businessIncOthThanSpec.getAdjustPLAfterDeprOthSpecInc()+businessIncOthThanSpec.getTotAfterAddToPLDeprOthSpecInc()-businessIncOthThanSpec.getTotDeductionAmts().longValue());
		DeemedProfitBusUs deemedProfitBusUs = new DeemedProfitBusUs();
		deemedProfitBusUs.setSection44AD(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getSection44AD()));
		deemedProfitBusUs.setSection44AE(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getSection44AE()));
		deemedProfitBusUs.setSection44AF(new BigInteger("0"));//It should be zero in ITR4 as per excel sheet
		deemedProfitBusUs.setSection44B(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getSection44B()));
		deemedProfitBusUs.setSection44BB(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getSection44BB()));
		deemedProfitBusUs.setSection44BBA(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getSection44BBA()));
		deemedProfitBusUs.setSection44BBB(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getSection44BBB()));
		deemedProfitBusUs.setSection44D(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getSection44D()));
		deemedProfitBusUs.setSection44DA(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getSection44DA()));
		deemedProfitBusUs.setChapterXIIG(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getChapter_XII_G()));
		deemedProfitBusUs.setFirstSchTAct(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getFirstSchedule_ITAct()));
		deemedProfitBusUs.setTotDeemedProfitBusUs(deemedProfitBusUs.getSection44AD().add(deemedProfitBusUs.getSection44AE()).add(deemedProfitBusUs.getSection44AF())
				.add(deemedProfitBusUs.getSection44B()).add(deemedProfitBusUs.getSection44BB()).add(deemedProfitBusUs.getSection44BBA()).add(deemedProfitBusUs.getSection44BBA())
				.add(deemedProfitBusUs.getSection44BBB()).add(deemedProfitBusUs.getSection44D()).add(deemedProfitBusUs.getSection44DA()).add(deemedProfitBusUs.getChapterXIIG())
				.add(deemedProfitBusUs.getFirstSchTAct()));
		businessIncOthThanSpec.setDeemedProfitBusUs(deemedProfitBusUs);
		businessIncOthThanSpec.setProfitLossBfrDeductUs10S(businessIncOthThanSpec.getPLAftAdjDedBusOthThanSpec() + deemedProfitBusUs.getTotDeemedProfitBusUs().longValue());
		DeductionUs10S deductionUs10s = new DeductionUs10S();
		if(schedule10a != null){
			deductionUs10s.setSection10A(schedule10a.getTotalDedUs10A());
		}else
			deductionUs10s.setSection10A(new BigInteger("0"));
		if(schedule10aa != null){
			deductionUs10s.setSection10AA(schedule10aa.getDeductSEZ().getDedUs10Detail().getTotalDedUs10Sub());
		}else
			deductionUs10s.setSection10AA(new BigInteger("0"));
		deductionUs10s.setTotDeductionUs10S(deductionUs10s.getSection10A().add(deductionUs10s.getSection10AA()));
		businessIncOthThanSpec.setDeductionUs10S(deductionUs10s);
		businessIncOthThanSpec.setNetPLAftAdjBusOthThanSpec(businessIncOthThanSpec.getProfitLossBfrDeductUs10S() - deductionUs10s.getTotDeductionUs10S().longValue());
		long netPL = incBusinessProfessionDoc.getNetPL_otherthanSpeculative_SpecifiedBuss1().longValue();
		if(businessIncOthThanSpec.getNetPLAftAdjBusOthThanSpec() > netPL){
			businessIncOthThanSpec.setNetPLBusOthThanSpec7A7B7C(businessIncOthThanSpec.getNetPLAftAdjBusOthThanSpec());
		}else
			businessIncOthThanSpec.setNetPLBusOthThanSpec7A7B7C(netPL);
		iTR4ScheduleBP.setBusinessIncOthThanSpec(businessIncOthThanSpec);

		SpecBusinessInc specBusinessInc = new SpecBusinessInc();
		specBusinessInc.setNetPLFrmSpecBus(businessIncOthThanSpec.getNetPLFromSpecBus());
		specBusinessInc.setAdditionUs28To44DA(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getAddAccordance_28to44DA()));
		specBusinessInc.setDeductUs28To44DA(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getDedAccordance_28to44DA()));
		specBusinessInc.setAdjustedPLFrmSpecuBus(specBusinessInc.getNetPLFrmSpecBus()+specBusinessInc.getAdditionUs28To44DA().longValue()
				- specBusinessInc.getDeductUs28To44DA().longValue());
		iTR4ScheduleBP.setSpecBusinessInc(specBusinessInc);

		SpecifiedBusinessInc specifiedBusinessInc = new SpecifiedBusinessInc();
		specifiedBusinessInc.setNetPLFrmSpecifiedBus(businessIncOthThanSpec.getNetPLFromSpecifiedBus());
		specifiedBusinessInc.setAddSec28To44DA(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getAdditionAcc28to44D()));
		specifiedBusinessInc.setDedSec28To44DAOTDedSec35AD(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getDedAcc28to44DEx35AD()));
		specifiedBusinessInc.setProfitLossSpecifiedBusiness(specifiedBusinessInc.getNetPLFrmSpecifiedBus()+specifiedBusinessInc.getAddSec28To44DA().longValue()
				-specifiedBusinessInc.getDedSec28To44DAOTDedSec35AD().longValue());
		specifiedBusinessInc.setDeductionUs35AD(indianCurrencyHelper.bigIntegerRound(incBusinessProfessionDoc.getDedAcc35AD()));
		specifiedBusinessInc.setPLFrmSpecifiedBus(specifiedBusinessInc.getProfitLossSpecifiedBusiness() - specifiedBusinessInc.getDeductionUs35AD().longValue());
		iTR4ScheduleBP.setSpecifiedBusinessInc(specifiedBusinessInc);

		iTR4ScheduleBP.setIncChrgUnHdProftGain(businessIncOthThanSpec.getNetPLBusOthThanSpec7A7B7C()+specBusinessInc.getAdjustedPLFrmSpecuBus()+specifiedBusinessInc.getPLFrmSpecifiedBus());

		return iTR4ScheduleBP;

	}
}
