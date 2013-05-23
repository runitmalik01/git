/** 
 * 
 * This File is being used to calculate Other Income 
 * 
 **/ 
//Define Helper Classes

var indianCurrencyHelper = new com.mootly.wcm.services.IndianCurrencyHelper();


out_Totalint=(Gov_income-0)+(Kissan+Bank_detail_fdr-0)+(Bank_detail_saving-0)+(Indira-0)+(intnsc-0)+(Otherint-0);
		

out_TotalOther_income=(Family_pension-0)+(Dividends-0)+(Income_rent_machine-0)+(Income_maintain-0)+(Income_other-0)+(Deduction_57-0);


out_Total_taxfree_income=(Dividends_uti-0)+(Interest_income-0)+(Dividends_mutualfund-0)+(Agriculture_income-0)+(Dividends_indian_companies-0)+(Otherincome-0);


out_Familypension_deduction=indianCurrencyHelper.RoundTo2Decimals((Family_pension-0)*.333*100)/100;


out_totalexpense=(out_Familypension_deduction)+(Otherdeduction-0)+(depreciation-0);


out_Taxable_income=((out_Totalint)+(out_TotalOther_income))-out_totalexpense;
