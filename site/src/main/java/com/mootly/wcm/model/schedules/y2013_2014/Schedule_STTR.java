package com.mootly.wcm.model.schedules.y2013_2014;

import java.math.BigInteger;

import com.mootly.wcm.services.IndianCurrencyHelper;

import in.gov.incometaxindiaefiling.y2013_2014.ScheduleSTTR;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleSTTR.IncChrgSTT;

public class Schedule_STTR {
	
	ScheduleSTTR scheduleSTTR = new ScheduleSTTR();
	IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
	IncChrgSTT incChrgSTT = new IncChrgSTT();

	public ScheduleSTTR getScheduleSTTR(){
		scheduleSTTR.setRebateUs88E(indianCurrencyHelper.bigIntegerRoundStr("0"));
		scheduleSTTR.setSTTPaid(indianCurrencyHelper.bigIntegerRoundStr("0"));
		scheduleSTTR.setTaxPaySTTAvgRate(indianCurrencyHelper.bigIntegerRoundStr("0"));
		IncChrgSTT incChrgSTT = new IncChrgSTT();
		incChrgSTT.setSTTNonSpecBus(indianCurrencyHelper.bigIntegerRoundStr("0"));
		incChrgSTT.setSTTSpecBus(new BigInteger("0"));
		incChrgSTT.setTotChrgAmtSTT(new BigInteger("0"));
		scheduleSTTR.setIncChrgSTT(incChrgSTT);
		return scheduleSTTR;
	}

}
