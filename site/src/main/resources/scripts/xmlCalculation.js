//Define Helper Classes
//var indianCurrencyHelper = new com.mootly.wcm.services.IndianCurrencyHelper();
var A = 0;
var B = 0;
var C = 0;
var D = 0;
var E = 0;

var condition_1=(cbasscategory == "M" && cbasstype == "I" && ((cbresistatus == "RES") || (cbresistatus == "NRI")|| (cbresistatus == "NOR"))) ? true : false;
var condition_2=(cbasscategory == "F" && cbasstype == "I" && ((cbresistatus == "RES")|| (cbresistatus == "NRI") || (cbresistatus == "NOR"))) ? true :false;
var condition_3=(cbasscategory == "Senior Citizen" && cbasstype == "I" && ((cbresistatus == "RES")|| (cbresistatus == "NOR"))) ? true :false;
var condition_4=(cbasscategory == "Super Senior Citizen" && cbasstype == "I" && ((cbresistatus == "RES")|| (cbresistatus == "NOR"))) ? true :false;
var condition_5=(cbasstype == "H") ? true :false;
var condition_6=(cbasstype == "C") ? true :false;
var condition_7=(cbasstype == "F" || cbasstype == "l") ? true :false;
var condition_8=(cbasstype == "A" || cbasstype == "B") ? true :false;
var condition_9=(cbasscategory == "Senior Citizen") && cbasstype == "I" && ((cbresistatus == "NRI")) ? true :false;
var condition_10=(cbasscategory == "Super Senior Citizen" && cbasstype == "I" && ((cbresistatus == "NRI"))) ? true :false;


if (cbassyear == "2013-2014") {
	if(condition_1 || condition_2){
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
		}
		else if (txtNetIncome >= 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;
		}
		out_slabRate=200000;
	}// 2013-2014-- Male & Female as Resident,Non-Resident,Non-ordinary Resident
	else if(condition_3){
		out_senior_citizen=condition_3;
		if (txtNetIncome <= 250000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 250001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 250000) * 0.1;
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 25000;
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 125000;
		}
		out_slabRate=250000;
	}// Senior Citizen as Resident,Non-Resident,Non-ordinary Resident
	else if(condition_9){
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
		}
		else if (txtNetIncome >= 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;
		}
		out_slabRate=200000;
	}// Senior Citizen as Non-Resident
	else if(condition_4){
		if (txtNetIncome <= 500000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2);
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 100000;
		}
		out_slabRate=500000;
	}// Super Senior Citizen as Resident,Non-Resident,Non-ordinary Resident
	else if(condition_10){
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
		}
		else if (txtNetIncome >= 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;
		}
		out_slabRate=200000;
	} // Super Senior Citizen as Non-Resident
	else if (condition_5) {
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;
		}
		out_slabRate=200000;
	}// HUF
	else if (condition_6) {
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;

		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.05;
		}
		out_slabRate=1;
	}// Company
	else if (condition_7) {
		if (txtNetIncome != 0) {
			A = txtNetIncome * 0.3;
		}
		out_slabRate=1;
	}// Firms and Local Authority
	else if (condition_8) {
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;
		}
		out_slabRate=200000;
	}// Association of Persons (AOP) and Body of Individuals (BOI)
}// 2013-2014
else if (cbassyear == "2012-2013") {
	if(condition_1){
		if (txtNetIncome <= 180000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 180001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 180000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 32000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 92000;
		}
		out_slabRate=180000;
	}//2012-2013-- Male as Resident
	else if(condition_2){
		if (txtNetIncome <= 190000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 190001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 190000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 31000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 91000;
		}
		out_slabRate=190000;
	}// 2012-2013 --Female as Resident
	else if(condition_3){
		if (txtNetIncome <= 250000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 250001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 250000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 25000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 85000;
		}
		out_slabRate=250000;
	}// 2012-2013 --Senior Citizen as Resident
	else if(condition_9){
		if (txtNetIncome <= 180000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 180001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 180000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 32000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 92000;
		}
		out_slabRate=180000;
	}// 2012-2013 --Senior Citizen as Non-Resident
	else if(condition_4){
		if (txtNetIncome <= 500000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2);
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 60000;
		}
		out_slabRate=500000;
	}// 2012-2013 --Super Senior Citizen as Resident
	else if(condition_10){
		if (txtNetIncome <= 180000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 180001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 180000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 32000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 92000;
		}
		out_slabRate=180000;
}// 2012-2013 --Super Senior Citizen as Non-Resident
	else if(condition_5){
		if (txtNetIncome <= 180000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 180001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 180000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 32000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 92000;
		}
		out_slabRate=180000;
	}// 2012-2013 --HUF
	else if(condition_6){
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.05;
		}
		out_slabRate=1;
	}// 2012-2013 --Company
	else if(condition_7){
		if (txtNetIncome != 0) {
			A = txtNetIncome * 0.3;
		}
		out_slabRate=1;
	}// 2012-2013 --Firms and Local Authority
	else if (condition_8) {
		if (txtNetIncome <= 180000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 180001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 180000) * 0.1;
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 32000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 92000;
		}
		out_slabRate=180000;
	}// Association of Persons (AOP) and Body of Individuals (BOI)
}// 2012-2013
else if (cbassyear == "2011-2012") {
	if(condition_1){
		if (txtNetIncome <= 160000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 160001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 160000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 34000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 94000;
		}
		out_slabRate=160000;
	}//2011-2012-- Male
	else if(condition_2){
		if (txtNetIncome <= 190000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 190001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 190000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 26000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 91000;
		}
		out_slabRate=190000;
	}//2011-2012-- Female
	else if(condition_3 || condition_4){
		if (txtNetIncome <= 240000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 240001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 240000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 26000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 86000;
		}
		out_slabRate=240000;
	}//2011-2012-- Senior Citizen and Super Senior Citizen
	else if(condition_9 || condition_10){
		if (txtNetIncome <= 160000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 160001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 160000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 34000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 94000;
		}
		out_slabRate=160000;
	}//2011-2012-- Senior Citizen and Super Senior Citizen as Non-Resident
	else if(condition_5){
		if (txtNetIncome <= 160000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 160001 && txtNetIncome <= 500000) {
			A = ((txtNetIncome - 190000) * 0.1);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 34000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 94000;
		}
	}//2011-2012--HUF
	else if(condition_6){
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.075;
		}
		out_slabRate=1;
	}//2011-2012--Company
	else if(condition_7){
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.075;
		}
		out_slabRate=1;
	}//2011-2012--Firms
}//2011-2012

B = (A + E) * 0.02;
C = (A + E) * 0.01;
D = Math.round((A + B + C + E)) ;
out_txtTax = Math.round ( A ) ;
out_txtEduCess = Math.round (B) ;
out_txtHEduCess = Math.round (C) ;
out_txttotaltax = Math.round (D) ;
out_txtsurcharge = Math.round (E);


