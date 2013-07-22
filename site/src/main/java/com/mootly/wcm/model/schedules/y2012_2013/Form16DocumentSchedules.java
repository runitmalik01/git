package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleS;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries.Salarys;

import java.util.List;

import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class Form16DocumentSchedules {
	
	FormSixteenDocument formSixteenDocument = null;
	SalaryIncomeDocument salaryIncomeDocument = null;
	
	public Form16DocumentSchedules(FormSixteenDocument formSixteenDocument,SalaryIncomeDocument salaryIncomeDocument) {
		this.formSixteenDocument = formSixteenDocument;
		this.salaryIncomeDocument = salaryIncomeDocument;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */
	public ScheduleS getScheduleS(ITR itr) {
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleS scheduleS = new ScheduleS();
		List<FormSixteenDetail> formSixteenDetails = formSixteenDocument.getFormSixteenDetailList();
		List<SalaryIncomeDetail> salaryIncomeDetails = salaryIncomeDocument.getSalaryIncomeDetailList();
		for (FormSixteenDetail formSixteenDetail:formSixteenDetails)  {
			Salaries salaries = new Salaries();
			
			AddressDetail addressDetail = new AddressDetail();
			addressDetail.setAddrDetail(formSixteenDetail.getAddress());
			addressDetail.setAddrDetail(formSixteenDetail.getEmploye_category());
			addressDetail.setAddrDetail(formSixteenDetail.getEmployee());
			salaries.setNameOfEmployer(formSixteenDetail.getEmployer());
			salaries.setPANofEmployer(formSixteenDetail.getPan_deductor());
			Salarys salarys = new Salarys();
			salarys.setSalary(indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getGross_a() ));
			salarys.setValueOfPerquisites(indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getGross_b()) );
			salarys.setProfitsinLieuOfSalary(indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getGross_c()) );
			salarys.setAllowancesNotExempt( indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getDeductions_total() ) );
			
			salarys.setSalary(indianCurrencyHelper.bigIntegerRound( formSixteenDetail.getIncome_chargable_tax()));
			
			scheduleS.getSalaries().add(salaries);
		}
		
		/*
		 * this loop will take care of pension income
		 * and related address details
		 */
		for (SalaryIncomeDetail salaryIncomeDetail:salaryIncomeDetails)  {
			Salaries salaries = new Salaries();
			
			AddressDetail addressDetail = new AddressDetail();
			addressDetail.setAddrDetail(salaryIncomeDetail.getAddress());
			addressDetail.setAddrDetail(salaryIncomeDetail.getEmploye_category());
			addressDetail.setAddrDetail(salaryIncomeDetail.getCity());
			addressDetail.setAddrDetail(salaryIncomeDetail.getState());
			addressDetail.setAddrDetail(salaryIncomeDetail.getPin());
			salaries.setNameOfEmployer(salaryIncomeDetail.getName_employer());
			salaries.setPANofEmployer(salaryIncomeDetail.getPan_employer());
			Salarys salarys = new Salarys();
			salarys.setSalary(indianCurrencyHelper.bigIntegerRound( salaryIncomeDetail.getGross_salary() ));
			salarys.setValueOfPerquisites(indianCurrencyHelper.bigIntegerRound( salaryIncomeDetail.getTdsPension()) );
			scheduleS.getSalaries().add(salaries);
		}
		return scheduleS;
	}
}
