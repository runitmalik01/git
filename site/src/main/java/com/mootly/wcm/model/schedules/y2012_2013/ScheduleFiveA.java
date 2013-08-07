package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule5A;

import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ScheduleFiveA {
	ScheduleFiveADocument objScheduleFiveADocument=null;
	
	public ScheduleFiveA (ScheduleFiveADocument schedule5a){
		this.objScheduleFiveADocument=schedule5a;
		
	}
	public Schedule5A scheduleFiveA(ITR itr){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Schedule5A schedule5A = new Schedule5A();
		schedule5A.setNameOfSpouse(objScheduleFiveADocument.getName_Spouse());
		schedule5A.setPANOfSpouse(objScheduleFiveADocument.getPan_Spouse());
		schedule5A.setHPHeadIncome(indianCurrencyHelper.longRound(objScheduleFiveADocument.getHouse_Property()));
		schedule5A.setCapGainHeadIncome(indianCurrencyHelper.longRound(objScheduleFiveADocument.getCapital_Gains()));
		schedule5A.setOtherSourcesHeadIncome(indianCurrencyHelper.longRound(objScheduleFiveADocument.getOther_Sources()));
		schedule5A.setTotalHeadIncome(indianCurrencyHelper.longRound(objScheduleFiveADocument.getTotal()));
		return schedule5A;
		
		
	
	}
    
}
