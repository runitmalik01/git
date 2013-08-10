package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTDS1;
import in.gov.incometaxindiaefiling.y2012_2013.TDSonSalary;

import java.util.List;

import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class TdsSalarySchedules {
	FormSixteenDocument formSixteenDocument = null;
	SalaryIncomeDocument salaryIncomeDocument = null;

	public TdsSalarySchedules(FormSixteenDocument formSixteenDocument,SalaryIncomeDocument salaryIncomeDocument) {
		this.formSixteenDocument = formSixteenDocument;
		this.salaryIncomeDocument = salaryIncomeDocument;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */
	public ScheduleTDS1 getScheduleTDS1(ITR itr) {
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleTDS1 scheduleTDS1 = new ScheduleTDS1();
		boolean hasAValidTDS = false;
		/*
		 * this loop will take care of Form Sixteen Screen
		 * and related details
		 */
		if(formSixteenDocument!=null){
			List<FormSixteenDetail> formSixteenDetails = formSixteenDocument.getFormSixteenDetailList();
			if ( formSixteenDetails != null && formSixteenDetails.size() > 0 ){
				for (FormSixteenDetail formSixteenDetail:formSixteenDetails)  {
					TDSonSalary tdsonSalary = new TDSonSalary();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					Double tds1 = 0d;
					Double tds2 = 0d;
					Double TdsSalary = 0d;
					if(formSixteenDetail.getDed_ent_1()!=null)
						tds1 = formSixteenDetail.getDed_ent_1();
					if(formSixteenDetail.getDed_ent_3()!=null)
						tds2 = formSixteenDetail.getDed_ent_3();
					TdsSalary =tds1 + tds2;
					if(TdsSalary !=0 ){
						if(formSixteenDetail.getTan_deductor()!=null){
							employerOrDeductorOrCollectDetl.setTAN(formSixteenDetail.getTan_deductor().toUpperCase());
						}
						if(formSixteenDetail.getEmployer()!=null){
							employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(formSixteenDetail.getEmployer().toUpperCase());
						}
						tdsonSalary.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);

						if(formSixteenDetail.getIncome_chargable_tax()!=null){
							tdsonSalary.setIncChrgSal(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax()));
						}
						tdsonSalary.setTotalTDSSal(indianCurrencyHelper.bigIntegerRound(TdsSalary));
						scheduleTDS1.getTDSonSalary().add(tdsonSalary);
						if(!hasAValidTDS) hasAValidTDS = true;
					}
				}
			}
		}

		/*
		 * this loop will take care of pension income
		 * and related details
		 */
		if(salaryIncomeDocument!=null){
			List<SalaryIncomeDetail> salaryIncomeDetails = salaryIncomeDocument.getSalaryIncomeDetailList();
			if ( salaryIncomeDetails != null && salaryIncomeDetails.size() > 0 ){
				for (SalaryIncomeDetail salaryIncomeDetail:salaryIncomeDetails)  {
					TDSonSalary tdsonSalary = new TDSonSalary();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					if(salaryIncomeDetail.getTdsPension()!=null){
						if(salaryIncomeDetail.getTan_employer()!=null){
							employerOrDeductorOrCollectDetl.setTAN(salaryIncomeDetail.getTan_employer().toUpperCase());
						}
						if(salaryIncomeDetail.getName_employer()!=null){
							employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(salaryIncomeDetail.getName_employer().toUpperCase());
						}
						tdsonSalary.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
						if(salaryIncomeDetail.getGross_salary()!=null){
							tdsonSalary.setIncChrgSal(indianCurrencyHelper.bigIntegerRound(salaryIncomeDetail.getGross_salary()));
						}
						tdsonSalary.setTotalTDSSal(indianCurrencyHelper.bigIntegerRound(salaryIncomeDetail.getTdsPension()));
						scheduleTDS1.getTDSonSalary().add(tdsonSalary);
						if(!hasAValidTDS) hasAValidTDS = true;
					}
				}
			}
		}
		if(hasAValidTDS){
			return scheduleTDS1;
		}else
			return null;
	}
}
