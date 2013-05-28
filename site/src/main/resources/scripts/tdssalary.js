var sumTdsSalary=0;

if(tdssalary!=null){
	if (tdssalary.getTdsSalaryDetailList() != null &&  tdssalary.getTdsSalaryDetailList().size() > 0){ 	
		for(var i=0;i<tdssalary.getTdsSalaryDetailList().size();i++) 
			sumTdsSalary=(sumTdsSalary-0)+ (tdssalary.getTdsSalaryDetailList().get(i).getTotal_TaxDeducted()-0);			
	}
}

out_total_tdssalary=sumTdsSalary;