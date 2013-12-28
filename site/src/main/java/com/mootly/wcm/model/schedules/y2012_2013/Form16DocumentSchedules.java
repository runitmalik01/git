package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries.Salarys;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleS;

import java.math.BigInteger;
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
		BigInteger totalSalary = new BigInteger("0");
		boolean hasAValidSalary = false;
		if(formSixteenDocument != null){
			List<FormSixteenDetail> formSixteenDetails = formSixteenDocument.getFormSixteenDetailList();
			if ( formSixteenDetails != null && formSixteenDetails.size() > 0 ){
				for (FormSixteenDetail formSixteenDetail:formSixteenDetails)  {
					Salaries salaries = new Salaries();

					AddressDetail addressDetail = new AddressDetail();
					addressDetail.setAddrDetail(formSixteenDetail.getAddressdetail());
					addressDetail.setCityOrTownOrDistrict(formSixteenDetail.getCity());
					addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(formSixteenDetail.getPin()));
					addressDetail.setStateCode(formSixteenDetail.getState());
					salaries.setAddressDetail(addressDetail);
					salaries.setNameOfEmployer(formSixteenDetail.getEmployer());
					if(!(formSixteenDetail.getPan_deductor().isEmpty()))
						salaries.setPANofEmployer(formSixteenDetail.getPan_deductor());
					Salarys salarys = new Salarys();
					salarys.setSalary(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getGross_a()).subtract(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getLess_total_2())));
					salarys.setAllowancesExemptUSection10(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getLess_total_2()));
					salarys.setValueOfPerquisites(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getGross_b()));
					salarys.setProfitsinLieuOfSalary(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getGross_c()));
					salarys.setDeductionUnderSection16(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getDeductions_total()));
					salarys.setAllowancesNotExempt( indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getAllowNotExempt()));
					salarys.setIncomeFromSalary((salarys.getSalary().add(salarys.getAllowancesNotExempt()).add(salarys.getProfitsinLieuOfSalary()).add(salarys.getValueOfPerquisites())).subtract(salarys.getDeductionUnderSection16()));
					totalSalary = totalSalary.add(salarys.getSalary().add(salarys.getAllowancesNotExempt()).add(salarys.getProfitsinLieuOfSalary()).add(salarys.getValueOfPerquisites())).subtract(salarys.getDeductionUnderSection16());
					salaries.setSalarys(salarys);
					scheduleS.getSalaries().add(salaries);
					scheduleS.setTotIncUnderHeadSalaries(totalSalary);
					if(!hasAValidSalary) hasAValidSalary = true;
				}
			}
		}

		/*
		 * this loop will take care of pension income
		 * and related address details
		 */
		if(salaryIncomeDocument != null){
			List<SalaryIncomeDetail> salaryIncomeDetails = salaryIncomeDocument.getSalaryIncomeDetailList();
			if ( salaryIncomeDetails != null && salaryIncomeDetails.size() > 0 ){
				for (SalaryIncomeDetail salaryIncomeDetail:salaryIncomeDetails)  {
					Salaries salaries = new Salaries();

					AddressDetail addressDetail = new AddressDetail();
					addressDetail.setAddrDetail(salaryIncomeDetail.getAddress());
					addressDetail.setCityOrTownOrDistrict(salaryIncomeDetail.getCity());
					addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(salaryIncomeDetail.getPin()));
					addressDetail.setStateCode(salaryIncomeDetail.getState());
					salaries.setAddressDetail(addressDetail);
					salaries.setNameOfEmployer(salaryIncomeDetail.getName_employer());
					if(!(salaryIncomeDetail.getPan_employer().isEmpty()))
						salaries.setPANofEmployer(salaryIncomeDetail.getPan_employer());
					Salarys salarys = new Salarys();
					salarys.setSalary(indianCurrencyHelper.bigIntegerRound(salaryIncomeDetail.getGross_salary()));
					salarys.setAllowancesExemptUSection10(new BigInteger("0"));
					salarys.setValueOfPerquisites(new BigInteger("0"));
					salarys.setProfitsinLieuOfSalary(new BigInteger("0"));
					salarys.setDeductionUnderSection16(new BigInteger("0"));
					salarys.setAllowancesNotExempt(new BigInteger("0"));
					salarys.setIncomeFromSalary((salarys.getSalary().add(salarys.getAllowancesNotExempt()).add(salarys.getProfitsinLieuOfSalary()).add(salarys.getValueOfPerquisites())).subtract(salarys.getDeductionUnderSection16()));
					totalSalary = totalSalary.add(salarys.getSalary().add(salarys.getAllowancesNotExempt()).add(salarys.getProfitsinLieuOfSalary()).add(salarys.getValueOfPerquisites())).subtract(salarys.getDeductionUnderSection16());
					salaries.setSalarys(salarys);
					scheduleS.getSalaries().add(salaries);
					scheduleS.setTotIncUnderHeadSalaries(totalSalary);
					if(!hasAValidSalary) hasAValidSalary = true;
				}
			}
		}
		if(hasAValidSalary){
			return scheduleS;
		}else
			return null;
	}
}
