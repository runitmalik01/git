package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleAMTC;

import java.lang.reflect.Field;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.beans.BalanceSheetDocument;
import com.mootly.wcm.beans.ScheduleAMTCDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR_ScheduleAMTC {
	
	public ScheduleAMTCDocument scheduleAMTCDocument;

	public ITR_ScheduleAMTC(ScheduleAMTCDocument scheduleAMTCDocument) {
		// TODO Auto-generated constructor stub
		this.scheduleAMTCDocument = scheduleAMTCDocument;
	}
	
	public ScheduleAMTC getScheduleAMTC(ITR itr, FinancialYear financialYear, Map<String, HippoBean> inputBeans){
		IndianCurrencyHelper currencyHelper = new IndianCurrencyHelper();
		ScheduleAMTC scheduleAMTC = new ScheduleAMTC();
		scheduleAMTC.setAssYr(financialYear.getDisplayAssessmentYear());
		if(scheduleAMTCDocument == null){
			ScheduleAMTCDocument dummyAmtcDocument = new ScheduleAMTCDocument();
			Field[] balSheetFields = BalanceSheetDocument.class.getDeclaredFields();
			for(Field balField:balSheetFields){
				if(balField.getType().getSimpleName().equalsIgnoreCase(Double.class.getSimpleName())){
					DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(dummyAmtcDocument);
					directFieldAccessor.setPropertyValue(balField.getName(), 0d);
				}
			}
			scheduleAMTCDocument = dummyAmtcDocument;
		}
		if(scheduleAMTCDocument!=null){
			scheduleAMTC.setAmtCreditFwd(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditGross()));
			scheduleAMTC.setAmtCreditUtilized(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditUnlisted()));
			scheduleAMTC.setAmtCreditSetOfEy(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditSetOff()));
			scheduleAMTC.setAmtCreditBalBroughtFwd(currencyHelper.bigIntegerRound(scheduleAMTCDocument.getAmtCreditBrghtFwrd()));
		}
		
		return scheduleAMTC;
	} 
}
