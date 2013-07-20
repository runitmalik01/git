package com.mootly.wcm.model.schedules;

import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleS;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries.Salarys;

import java.util.List;

import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class Form16DocumentSchedules {
	
	FormSixteenDocument document = null;
	public Form16DocumentSchedules(FormSixteenDocument document) {
		this.document = document;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */
	public ScheduleS getScheduleS(ITR itr) {
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleS scheduleS = new ScheduleS();
		List<FormSixteenDetail> formSixteenDetails = document.getFormSixteenDetailList();
		for (FormSixteenDetail formSixteenDetail:formSixteenDetails)  {
			Salaries salaries = new Salaries();
			
			AddressDetail addressDetail = new AddressDetail();
			addressDetail.setAddrDetail(formSixteenDetail.getAddress());
			salaries.setNameOfEmployer(formSixteenDetail.getEmployer());
			Salarys salarys = new Salarys();
			salarys.setSalary(indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getGross_a() ));
			salarys.setValueOfPerquisites(indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getGross_b()) );
			salarys.setProfitsinLieuOfSalary(indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getGross_c()) );
			salarys.setAllowancesNotExempt( indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getDeductions_total() ) );
			
			salarys.setSalary(indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getIncome_chargable_tax()));
			
			scheduleS.getSalaries().add(salaries);
		}
		return scheduleS;
	}
}
