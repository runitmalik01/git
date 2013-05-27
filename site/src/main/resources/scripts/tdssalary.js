var sumTdsSalary=0;

if(tdssalary!=null){
	if (tdssalary.getTdsSalaryDetailList() != null &&  tdssalary.getTdsSalaryDetailList().size() > 0){ 	
		for(var i=0;i<tdssalary.getTdsSalaryDetailList().size();i++) 
			sumTdsSalary=sumTdsSalary+ tdssalary.getTdsSalaryDetailList().get(i).getP_Amount();			
	}
}

out_total_tdssalary=sumTdsSalary;