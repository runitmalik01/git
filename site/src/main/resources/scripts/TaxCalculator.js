//Define Helper Classes
//var indianCurrencyHelper = new com.mootly.wcm.services.IndianCurrencyHelper();
var A = 0;
var B = 0;
var C = 0;
var D = 0;
var E = 0;

var condition_1=(cbasscategory == "Male" && cbasstype == "p" && (cbresistatus == "Resident"|| cbresistatus == "Not Ordinary Resident")) ? true : false;
var condition_2=(cbasscategory == "Female" && cbasstype == "p" && (cbresistatus == "Resident"|| cbresistatus == "Not Ordinary Resident")) ? true :false;
var condition_3=(cbasscategory == "Senior Citizen" && cbasstype == "p" && (cbresistatus == "Resident" || cbresistatus == "Not Ordinary Resident")) ? true :false;
var condition_4=(cbasscategory == "Super Senior Citizen" && cbasstype == "p" && (cbresistatus == "Resident" || cbresistatus == "Not Ordinary Resident")) ? true :false;
var condition_5=(cbasstype == "h") ? true :false;
var condition_6=(cbasstype == "c") ? true :false;
var condition_7=(cbasstype == "f" || cbasstype == "l") ? true :false;

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
	}// Male & Female
	else if(condition_3){
		if (txtNetIncome <= 250000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome >= 250001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 250000) * 0.1;
		}
		else if (txtNetIncome >= 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 25000;
		}
		else if (txtNetIncome > 1000000) {
			((txtNetIncome - 1000000) * 0.3) + 125000;		
		} 
	}// Senior Citizen as Resident
	else if(condition_4){
		if (txtNetIncome <= 500000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2);
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 100000;
		}
	}// Super Senior Citizen as Resident
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
	}// HUF 
	else if (condition_6) {
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.05;
		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
		}
	}// Company 
	else if (condition_7) {
		if (txtNetIncome != 0) {
			A = txtNetIncome * 0.3;
		}
	}// Firms and Local Authority
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
	}//2012-2013-- Male
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
	}// 2012-2013 --Female 
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
	}// 2012-2013 --Senior Citizen as Resident
	else if(condition_4){
		if (txtNetIncome <= 500000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2);
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 60000;
		}
	}// 2012-2013 --Super Senior Citizen as Resident
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
	}// 2012-2013 --HUF
	else if(condition_6){
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
		} 
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.05;
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2) + 32000;
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 92000;
		}
	}// 2012-2013 --Company
	else if(condition_5){
		if (txtNetIncome != 0) {
			A = txtNetIncome * 0.3;
		}
	}// 2012-2013 --Firms and Local Authority
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
			A = ((txtNetIncome - 800000) * 0.3) + 86000;
		} 
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
	}//2011-2012-- Senior Citizen and Super Senior Citizen
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
	}//2011-2012--Company
	else if(condition_7){
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.075;
		}
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


