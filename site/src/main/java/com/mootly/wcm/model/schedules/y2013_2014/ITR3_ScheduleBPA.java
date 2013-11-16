package com.mootly.wcm.model.schedules.y2013_2014;

import java.util.List;

import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.compound.IncomeFromFirmsDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleBPA;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleBPA.PartnerFirmIncomes;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleBPA.Total;

public class ITR3_ScheduleBPA {

	IncomeFromFirmsDocument incomeFromFirmsDocument = null;

	public ITR3_ScheduleBPA(IncomeFromFirmsDocument incomeFromFirmsDocument){
		this.incomeFromFirmsDocument = incomeFromFirmsDocument;
	}

	public ScheduleBPA getScheduleBPA(ITR itr){
		ScheduleBPA scheduleBPA = new ScheduleBPA();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		boolean hasValidBP = false;

		if(incomeFromFirmsDocument != null){
			List<IncomeFromFirmsDetail> incomeFromFirmsDetails = incomeFromFirmsDocument.getIncFromFirmsDetailList();
			if ( incomeFromFirmsDetails != null && incomeFromFirmsDetails.size() > 0 ){
				for (IncomeFromFirmsDetail incomeFromFirmsDetail:incomeFromFirmsDetails)  {
					PartnerFirmIncomes partnerFirmIncomes = new PartnerFirmIncomes();
					partnerFirmIncomes.setFirmPAN(incomeFromFirmsDetail.getFirm_PAN());
					partnerFirmIncomes.setFirmSalBonComRen(indianCurrencyHelper.bigIntegerRound(incomeFromFirmsDetail.getSalary_BonusRcv()));
					partnerFirmIncomes.setIntFirmCap(incomeFromFirmsDetail.getInterest_Rcv().longValue());
					partnerFirmIncomes.setTotalIncome(incomeFromFirmsDetail.getTotal_SalaryAndInterest().longValue());
					partnerFirmIncomes.setExpenses(indianCurrencyHelper.bigIntegerRound(incomeFromFirmsDetail.getExpenses_RelTotal()));
					partnerFirmIncomes.setNetIncome(incomeFromFirmsDetail.getNetIncome().longValue());
					scheduleBPA.getPartnerFirmIncomes().add(partnerFirmIncomes);
				}
				Total total = new Total();
				total.setAggreFirmSalBonComRen(indianCurrencyHelper.bigIntegerRound(incomeFromFirmsDocument.getVal_Salary()));
				total.setAggreIntFirmCap(incomeFromFirmsDocument.getVal_InterestRcv().longValue());
				total.setAggreTotalIncome(incomeFromFirmsDocument.getVal_salaryAndIntrst().longValue());
				total.setAggreExpensesTotal(indianCurrencyHelper.bigIntegerRound(incomeFromFirmsDocument.getVal_Expense()));
				total.setAggreNetIncome(incomeFromFirmsDocument.getVal_NetIncome().longValue());
				scheduleBPA.setTotal(total);
				if(!hasValidBP) hasValidBP = true;
			}
		}
		if(hasValidBP){
			return scheduleBPA;
		}else
			return null;

	}
}
