/**
 * 
 * 
 * 
 * 
 */

var indianCurrencyHelper = new com.mootly.wcm.services.IndianCurrencyHelper();

var minCharTaxIn = 0;var calTaxOnIncome = 0;var cal= 0; var taxOnIncome =0; var minCharIncome=0; var SISectionAmount = 0;
if(scheduleSiDocument!=null){
	if(scheduleSiDocument.getScheduleSiDetailList() != null &&  scheduleSiDocument.getScheduleSiDetailList().size() > 0 ){         		
		for (var i=0;i<scheduleSiDocument.getScheduleSiDetailList().size();i++) {
			minCharTaxIn = minCharTaxIn + (scheduleSiDocument.getScheduleSiDetailList().get(i).getMinChargTaxIncome()-0);
			calTaxOnIncome = calTaxOnIncome + (scheduleSiDocument.getScheduleSiDetailList().get(i).getCalcRateIncome()-0);
		}
	}
	out_total_minCharTaxIn = minCharTaxIn; out_total_calTaxOnIncome = calTaxOnIncome;
}
if(capDoc==null){
	if(userAmount!=null && spRate!=null){
		SISectionAmount = userAmount;
		cal = (userAmount * spRate)/100;
		taxOnIncome = indianCurrencyHelper.roundOff(cal);
	}
}else{
	if(xmlCode == '1A'){
		SISectionAmount = capDoc; 
		if(capDoc.getcapitalGain!=0){
			minCharIncome = SISectionAmount - slabValue;	
		}else{
			minCharIncome = SISectionAmount;
		}
	}
	if(xmlCode == '22'){
		SISectionAmount = capDoc;
		if(capDoc.getcapitalGain!=0){
			minCharIncome = SISectionAmount - slabValue;	
		}else{
			minCharIncome = SISectionAmount;
		}
	}
	if(xmlCode == '21ciii'){
		SISectionAmount = capDoc;
		minCharIncome = SISectionAmount;
	}
	if(xmlCode == '21'){
		SISectionAmount = capDoc;
		minCharIncome = SISectionAmount;
	}
	cal = (minCharIncome * spRate)/100;
	taxOnIncome = indianCurrencyHelper.roundOff(cal);
}
out_taxOnIncome = taxOnIncome;
out_userAmount = SISectionAmount;
out_minChargIncome = minCharIncome;