var sumTdsOther=0;

if(tdsother!=null){
	if(tdsother.getTdsSalaryDetailList()!=null && tdsother.getTdsSalaryDetailList().size() >0){
		for(var i=0;i<tdsother.getTdsSalaryDetailList().size();i++)
			sumTdsOther=sumTdsOther+tdsother.getTdsSalaryDetailList.get(i).getP_Amount();		
	}
}

out_total_tdsother=sumTdsOther;