/***
 * This File is being used to calculate Salary Income
 * 
 * 
 * **/
var sumSalary=0; 

if(salaryincome!=null){
	if (salaryincome.getSalaryIncomeDetailList() != null && salaryincome.getSalaryIncomeDetailList().size() > 0){ 
		for(var i=0;i<salaryincome.getSalaryIncomeDetailList().size();i++)       			
			sumSalary=sumSalary+salaryincome.getSalaryIncomeDetailList().get(i).getTaxable_earning();         					
	}	
}

out_total_salaryincome=sumSalary;

out_Taxable_earning=(Gross_salary-0)+(Allowance-0)+(Perquisite-0)+(profit-0);