/**
 * 
 * before using this script please pass all Undeclared parameter Values or null to it 
 * list as ==== scheduleSiDocument  ,userAmount  , spRate , CapDoc , slabValue , grossTotal
 * 
 * 
 */

var indianCurrencyHelper = new com.mootly.wcm.services.IndianCurrencyHelper();

var minCharTaxIn = 0;var calTaxOnIncome = 0;var cal= 0; var taxOnIncome =0; var minCharIncome=0; var SISectionAmount = 0;var stGainSTTpaid = 0;var ltGain = 0;

var ltCapGainWIndex = 0;var ltUnlisSec = 0;var stSecA = 0;var stLoss = 0;var stBalnc = 0; var ltCapGainWtIndex = 0;var ltBalnc = 0;var ltded = 0;var totalIncome = 0;

var condition_1 = 0;var condition_2 = 0; var ltUnlisSecWIndex = 0;var remainSlab = 0;

if(scheduleSiDocument!=null){
	//Schedule SI document Calculation for Total of all Child.
	if(scheduleSiDocument.getScheduleSiDetailList() != null &&  scheduleSiDocument.getScheduleSiDetailList().size() > 0 ){         		
		for (var i=0;i<scheduleSiDocument.getScheduleSiDetailList().size();i++) {
			if(!scheduleSiDocument.getScheduleSiDetailList().get(i).isMarkedForDeletion()) {
				minCharTaxIn = minCharTaxIn + (scheduleSiDocument.getScheduleSiDetailList().get(i).getMinChargTaxIncome()-0);
				calTaxOnIncome = calTaxOnIncome + (scheduleSiDocument.getScheduleSiDetailList().get(i).getCalcRateIncome()-0);
				totalIncome = totalIncome + (scheduleSiDocument.getScheduleSiDetailList().get(i).getAmount()-0);
			}
		}
	}
	out_total_minCharTaxIn = minCharTaxIn; out_total_calTaxOnIncome = calTaxOnIncome;out_total_income = totalIncome;
}

if(userAmount!=null && spRate!=null){
	SISectionAmount = userAmount;
	minCharIncome = SISectionAmount;
}

if(CapDoc!="CapDoc"){
	//if you have capital gain document 
	if(CapDoc.getCapitalAssetDetailList() != null &&  CapDoc.getCapitalAssetDetailList().size() > 0 ){ 
		for(var i=0;i< CapDoc.getCapitalAssetDetailList().size();i++) {
			//Check for Exempt Capital Gain
			var checkForExemptIncome = false;
			if(CapDoc.getCapitalAssetDetailList().get(i).getCapitalGainTaxLT() != null &&
					java.lang.String.valueOf(CapDoc.getCapitalAssetDetailList().get(i).getSstCharge()) == 'Y' &&
					java.lang.String.valueOf(CapDoc.getCapitalAssetDetailList().get(i).getAssetType()) == 'SHARES'){       	 
				checkForExemptIncome = true;
			}
			if(!checkForExemptIncome){
				if(java.lang.String.valueOf(CapDoc.getCapitalAssetDetailList().get(i).getSstCharge()) == 'Y'){
					stBalnc = stBalnc + (CapDoc.getCapitalAssetDetailList().get(i).getBalance()-0);
					stLoss = stLoss + (CapDoc.getCapitalAssetDetailList().get(i).getLoss_sec94()-0);
					stSecA = stSecA + (CapDoc.getCapitalAssetDetailList().get(i).getAsset_111()-0);
				}
				if(java.lang.String.valueOf(CapDoc.getCapitalAssetDetailList().get(i).getIndex()) == 'N'){ //need to save value of indexation in capitalAssest doc
					ltBalnc = ltBalnc + (CapDoc.getCapitalAssetDetailList().get(i).getBalance()-0);
					ltded = ltded + (CapDoc.getCapitalAssetDetailList().get(i).getDed_sec54()-0);
				}

				ltUnlisSec = ltUnlisSec + (CapDoc.getCapitalAssetDetailList().get(i).getUnlstdSecurity()-0);

				if(java.lang.String.valueOf(CapDoc.getCapitalAssetDetailList().get(i).getIndex()) == 'Y'){ //need to save value of indexation in capitalAssest doc
					ltCapGainWIndex = ltCapGainWIndex + (CapDoc.getCapitalAssetDetailList().get(i).getCapitalGain()-0);
					ltUnlisSecWIndex = ltUnlisSecWIndex + (CapDoc.getCapitalAssetDetailList().get(i).getUnlstdSecurity()-0);
				}
			}
		}
	}
	//calculate the values on capital gain according to Schedule SI Sections.
	stGainSTTpaid = stBalnc + stSecA + stLoss;
	if(stGainSTTpaid < 0){
		stGainSTTpaid = 0;
	}
	ltCapGainWtIndex = (ltBalnc > ltded) ? (ltBalnc - ltded) : 0;	
	if(ltCapGainWtIndex < 0){
		ltCapGainWtIndex = 0;
	}
	ltGain = (ltCapGainWIndex > ltUnlisSecWIndex) ? (ltCapGainWIndex - ltUnlisSecWIndex) : 0;
	if(ltGain < 0){
		ltGain = 0;
	}
	if(ltUnlisSec < 0){
		ltUnlisSec = 0;
	}

	//adjustment of capital gain if user don't have any tax at source of income.
	remainSlab = (grossTotal < slabValue) ? (slabValue - grossTotal) : 0; //find remaining amount that can be adjust to capital gain

	condition_1 = (remainSlab > stGainSTTpaid) ? (remainSlab - stGainSTTpaid) :0; 
	condition_2 = (condition_1 > ltCapGainWtIndex) ? (condition_1 - ltCapGainWtIndex) :0; 

	if(xmlCode == '1A'){
		SISectionAmount = stGainSTTpaid; //capDoc	
		minCharIncome = (remainSlab > SISectionAmount) ? 0 : (SISectionAmount - remainSlab);
	}
	if(xmlCode == '22'){
		SISectionAmount = ltCapGainWtIndex; //capDoc
		minCharIncome = (condition_1 > SISectionAmount) ? 0 : (SISectionAmount - condition_1);
	}
	if(xmlCode == '21ciii'){
		SISectionAmount = ltUnlisSec; //capDoc
		minCharIncome = SISectionAmount; //this section is only for NRI 
	}
	if(xmlCode == '21'){
		SISectionAmount = ltGain; //capDoc
		minCharIncome = (condition_2 > SISectionAmount) ? 0 : (SISectionAmount - condition_2);
	}
}

if(spRate!=null){
	cal = (minCharIncome * spRate)/100;
}

taxOnIncome = java.lang.Double.parseDouble(java.lang.String.valueOf(indianCurrencyHelper.roundOff(cal)));

out_taxOnIncome = taxOnIncome;
out_userAmount = SISectionAmount;
out_minChargIncome = minCharIncome;
