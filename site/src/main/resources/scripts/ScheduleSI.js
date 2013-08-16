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

var condition_1=false;var condition_2 = false;var condition_3 = false;var condition_4 = false; var ltUnlisSecWIndex = 0;

if(scheduleSiDocument!=null){
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
}

if(CapDoc!="CapDoc"){
	if(CapDoc.getCapitalAssetDetailList() != null &&  CapDoc.getCapitalAssetDetailList().size() > 0 ){ 
		for(var i=0;i< CapDoc.getCapitalAssetDetailList().size();i++) {
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
	stGainSTTpaid = stBalnc + stSecA + stLoss;
	ltCapGainWtIndex = (ltBalnc > ltded) ? (ltBalnc - ltded) : 0;	
	ltGain = (ltCapGainWIndex > ltUnlisSecWIndex) ? (ltCapGainWIndex - ltUnlisSecWIndex) : 0;

	condition_1 = ((stGainSTTpaid > ltCapGainWtIndex) && (stGainSTTpaid > ltUnlisSec) && (stGainSTTpaid >ltGain )) ? true : false; 
	condition_2 = ((ltCapGainWtIndex > stGainSTTpaid) && (ltCapGainWtIndex > ltUnlisSec) && (ltCapGainWtIndex >ltGain )) ? true : false; 
	condition_3 = ((ltUnlisSec > ltCapGainWtIndex) && (ltUnlisSec > stGainSTTpaid) && (ltUnlisSec >ltGain )) ? true : false; 
	condition_4 = ((ltGain > ltCapGainWtIndex) && (ltGain > stGainSTTpaid) && (ltGain >ltUnlisSec )) ? true : false;

	if(xmlCode == '1A'){
		SISectionAmount = stGainSTTpaid; //capDoc		
	}
	if(xmlCode == '22'){
		SISectionAmount = ltCapGainWtIndex; //capDoc		
	}
	if(xmlCode == '21ciii'){
		SISectionAmount = ltUnlisSec; //capDoc
	}
	if(xmlCode == '21'){
		SISectionAmount = ltGain; //capDoc
	}
}
if(condition_1 ||condition_2 ||condition_3 ||condition_4){
	if(grossTotal < slabValue){
		minCharIncome = (SISectionAmount > slabValue) ? (SISectionAmount - slabValue) : 0;	
	}
}else{
	minCharIncome = SISectionAmount;
}

if(spRate!=null){
	cal = (minCharIncome * spRate)/100;
}
taxOnIncome = java.lang.Double.parseDouble(java.lang.String.valueOf(indianCurrencyHelper.roundOff(cal)));

out_taxOnIncome = taxOnIncome;
out_userAmount = SISectionAmount;
out_minChargIncome = minCharIncome;
