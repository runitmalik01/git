var indianCurrencyHelper = new com.mootly.wcm.services.IndianCurrencyHelper();

var period=0;
var total=0;
var bal=0;
var cpgain=0;
if(asset_type=='SHARES'){
	period= 365;
} else{
	period=365*3;
};
var month = (months-0);
if(month < period){
	var sale=(saleconsideration-0);
	total =(costacquisition-0)+(costimprovement-0)+(costtrnsfr-0);
	//bal= ( (sale -total) > 0 ) ? (sale -total) : 0; 
	bal= (sale - total); 
	var loss = (losssec94-0);
	cpgain= bal+loss+(asset111-0)+(assetnt111-0)+(amtdeemed-0)-(dedsec54-0);
}else{
	// long terms
	if(index=='N'){
		var sale=(saleconsideration-0);
		total =(costacquisition-0)+(costimprovement-0)+(costtrnsfr-0);
		//bal= ( (sale -total) > 0 ) ? (sale - total) : 0; 
		bal= (sale - total); 
		cpgain=bal+(amtdeemed-0)-(dedsec54-0)+(section48-0)+(unlstdsecurity-0);
	}else{
		var pur_data = date_acquisition;
		var arr = pur_data.split('/');
		var pur_year=arr[2];
		var pur_index =1;
		var sal_data = date_sale;
		var arr1 = sal_data.split('/');
		var sal_year=arr1[2];
		var sal_index =0;
			//pur_index = indianCurrencyHelper.getYearIndexValue(pur_year);
			//sal_index = indianCurrencyHelper.getYearIndexValue(sal_year);
		
		var cost_acq= indianCurrencyHelper.RoundTo2Decimals((costacquisition-0)*(sal_index/pur_index));
		var cost_imp= indianCurrencyHelper.RoundTo2Decimals((costimprovement-0)*(sal_index/pur_index));
		total= cost_acq+ (cost_imp-0)+ (costtrnsfr-0);
		bal= (saleconsideration-0)-total;
		cpgain = bal-(dedsec54-0)+( section48-0)+(unlstdsecurity-0)+(amtdeemed-0);

	};

};

out_capitalgain= cpgain;
out_balanc= bal;