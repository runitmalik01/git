/**
 * This File is being used to calculate House Income
 * 
 * **/
//Define Helper Classes
var indianCurrencyHelper = new com.mootly.wcm.services.IndianCurrencyHelper();
var sumHouse=0;

if(hosueincome!=null){
	if (houseincome.getHouseIncomeDetailList() != null && houseincome.getHouseIncomeDetailList().size() > 0){ 
		for(var i=0;i<houseincome.getHouseIncomeDetailList().size();i++) 
			sumHouse=sumHouse+houseincome.getHouseIncomeDetailList().get(i).getIncome_hproperty();		
	}
}

if(letout=='Yes'){
	//if(Unrealised_rent!=0 && Local_tax!=0 && Letable_value!=0 && Interest_borrowed!=0){
		var total = Letable_value - Unrealised_rent - Local_tax;
		var balance=(0.3 * total);
		var hous_income = total - balance - Interest_borrowed;
		out_Total=total;
		out_Balance=indianCurrencyHelper.RoundTo2Decimals(balance*100)/100;
		out_Income_hproperty=indianCurrencyHelper.RoundTo2Decimals(hous_income*100)/100;
	//}
}else if(letout=='No'){
	 if(Interest_borrowed<=150000 && Interest_borrowed!=0){
		 out_Income_hproperty=-Interest_borrowed;
	 }else{
		 out_Income_hproperty=-150000;
	 }
}

out_total_houseincome=sumHouse;