//Define Helper Classes 
var A = 0;
var B = 0;
var C = 0;
var D = 0;
var E = 0;
var S_2= 0;
var S_1= 0;
var allowAmount = 0;
var minAmount= 0;
var eligAmount= 0;
out_rebate87 = 0;
out_taxBfrRebate = 0;

/*var condition_1=(cbasscategory == "M" && cbasstype == "I" && ((cbresistatus == "RES") || (cbresistatus == "NRI")|| (cbresistatus == "NOR"))) ? true : false;
var condition_2=(cbasscategory == "F" && cbasstype == "I" && ((cbresistatus == "RES")|| (cbresistatus == "NRI") || (cbresistatus == "NOR"))) ? true :false;*/
var condition_1=(cbasscategory == "M" && cbasstype == "I" && ((cbresistatus == "RES")|| (cbresistatus == "NOR"))) ? true : false;
var condition_2=(cbasscategory == "F" && cbasstype == "I" && ((cbresistatus == "RES")|| (cbresistatus == "NOR"))) ? true :false;
var condition_3=(cbasscategory == "Senior Citizen" && cbasstype == "I" && ((cbresistatus == "RES") || (cbresistatus == "NOR"))) ? true :false;
var condition_4=(cbasscategory == "Super Senior Citizen" && cbasstype == "I" && ((cbresistatus == "RES") || (cbresistatus == "NOR"))) ? true :false;
var condition_5=(cbasstype == "H") ? true :false;
var condition_6=(cbasstype == "C") ? true :false;
var condition_7=(cbasstype == "F" || cbasstype == "L") ? true :false;
var condition_8=(cbasstype == "A" || cbasstype == "B") ? true :false;
var condition_9=(cbasscategory == "Senior Citizen") && cbasstype == "I" && ((cbresistatus == "NRI")) ? true :false;
var condition_10=(cbasscategory == "Super Senior Citizen" && cbasstype == "I" && ((cbresistatus == "NRI"))) ? true :false;
var condition_11=(cbasscategory == "M" && cbasstype == "I" && ((cbresistatus == "NRI"))) ? true : false;
var condition_12=(cbasscategory == "F" && cbasstype == "I" && ((cbresistatus == "NRI"))) ? true :false;

//Variable 'cbassyear' shows value of Assessment Year.
if (cbassyear == "2014-2015") {
	if((condition_1 || condition_2)){
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			out_rebate87 = 2000;
			out_taxBfrRebate = ((txtNetIncome - 200000) * 0.1);
			A = ((txtNetIncome - 200000) * 0.1 - out_rebate87);
		}
		else if (txtNetIncome >= 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 1000001 && txtNetIncome <=10000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
		} 
		else if (txtNetIncome > 10000000) { 
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
			S_1 = (A * 0.1); // 28,60,000 * 0.1 = 2,86,000
			S_2 = (S_1 + A); // 2,86,000 + 1,01,00,000 = 31,46,000
			minAmount = (txtNetIncome - 10000000); // 1,01,00,000 - 1,00,00,000 = 1,00,000
			allowAmount = (minAmount + 2830000); // 1,00,000 + 28,30,000 = 29,30,000
			if (S_2 > allowAmount){ // 31,46,000 > 29,30,000
				eligAmount = (S_2 - allowAmount);//  31,46,000 - 29,30,000 = 2,16,000
				E = (S_1 - eligAmount); // 2,86,000 - 2,16,000 = 70,000
			}
			else {
				E = (S_1);
			} // 2,86,000
		}
		out_slabRate = 200000;
	}// FY 2013-2014-- Male & Female as Resident, Non-Ordinary Resident
	else if(condition_11 || condition_12){
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome >= 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 1000001 && txtNetIncome <=10000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;		
			out_taxBfrRebate = A;
		} 
		else if (txtNetIncome > 10000000) { 
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
			S_1 = (A * 0.1);
			S_2 = (S_1 + A); 
			minAmount = (txtNetIncome - 10000000); 
			allowAmount = (minAmount + 2830000); 
			if (S_2 > allowAmount){ 
				eligAmount = (S_2 - allowAmount);
				E = (S_1 - eligAmount);
			} else {
				E = (S_1);
			}
		}
		out_slabRate = 200000;
	}//FY 2013-2014-- Male & Female as Non-Resident
	else if(condition_3){
		if (txtNetIncome <= 250000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 250001 && txtNetIncome <= 500000) {
			out_rebate87 = 2000;
			out_taxBfrRebate = ((txtNetIncome - 250000) * 0.1);
			A = ((txtNetIncome - 250000) * 0.1 - out_rebate87);
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 25000;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 1000001 && txtNetIncome <=10000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 125000;
			out_taxBfrRebate = A;
		} 
		else if (txtNetIncome > 10000000) { 
			A = ((txtNetIncome - 1000000) * 0.3) + 125000;	
			out_taxBfrRebate = A;
			S_1 = (A * 0.1); 
			S_2 = (S_1 + A); 
			minAmount = (txtNetIncome - 10000000);
			allowAmount = (minAmount + 2825000); 
			if (S_2 > allowAmount){ 
				eligAmount = (S_2 - allowAmount);
				E = (S_1 - eligAmount); 
			} else {
				E = (S_1);
			}
		}
		out_slabRate = 250000;
	}//FY 2013-2014-- Senior Citizen as Resident and Non-Ordinary Resident
	else if(condition_9){
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome >= 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 1000001 && txtNetIncome <=10000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
		} 
		else if (txtNetIncome > 10000000) { 
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
			S_1 = (A * 0.1);
			S_2 = (S_1 + A); 
			minAmount = (txtNetIncome - 10000000); 
			allowAmount = (minAmount + 2830000); 
			if (S_2 > allowAmount){ 
				eligAmount = (S_2 - allowAmount);
				E = (S_1 - eligAmount);
			}
			else{
				E = (S_1);
				}
		}
		out_slabRate = 200000;
	}//FY 2013-2014 -- Senior Citizen as Non-Resident
	else if(condition_4){
		if (txtNetIncome <= 500000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2);
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 1000001 && txtNetIncome <=10000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 100000;
			out_taxBfrRebate = A;
		}		
		else if (txtNetIncome > 10000000) { 
			A = ((txtNetIncome - 1000000) * 0.3) + 100000;	
			out_taxBfrRebate = A;
			S_1 = (A * 0.1);
			S_2 = (S_1 + A); 
			minAmount = (txtNetIncome - 10000000); 
			allowAmount = (minAmount + 2800000); 
			if (S_2 > allowAmount){ 
				eligAmount = (S_2 - allowAmount);
				E = (S_1 - eligAmount);
			}
			else{
				E = (S_1);
			}
		}
		out_slabRate = 500000;
	}//FY 2013-2014 --  Super Senior Citizen as Resident and Non-Ordinary Resident
	else if(condition_10){
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			out_rebate87 = 2000;
			out_taxBfrRebate = ((txtNetIncome - 200000) * 0.1);
			A = ((txtNetIncome - 200000) * 0.1- out_rebate87);
		}
		else if (txtNetIncome >= 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 1000001 && txtNetIncome <=10000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;		
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 10000000) { 
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
			S_1 = (A * 0.1); 
			S_2 = (S_1 + A); 
			minAmount = (txtNetIncome - 10000000); 
			allowAmount = (minAmount + 2830000); 
			if (S_2 > allowAmount){ 
				eligAmount = (S_2 - allowAmount);
				E = (S_1 - eligAmount);
			}
			else{
				E = (S_1);
			} 
		}
		out_slabRate = 200000;
	} // FY 2013-2014 -- Super Senior Citizen as Non-Resident
	else if (condition_5) {
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 1000001 && txtNetIncome <=10000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
		} 
		else if (txtNetIncome > 10000000) { 
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
			S_1 = (A * 0.1);
			S_2 = (S_1 + A);
			minAmount = (txtNetIncome - 10000000);
			allowAmount = (minAmount + 2830000); 
			if (S_2 > allowAmount){ 
				eligAmount = (S_2 - allowAmount);
				E = (S_1 - eligAmount);
			}
			else{
				E = (S_1);
			}
		}
		out_slabRate = 200000;
	}// FY 2013-2014 -- HUF 
	else if (condition_6) {
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
			out_taxBfrRebate = A;

		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			out_taxBfrRebate = A;
			E = A * 0.05;
		}
		out_slabRate = 1;
	}// FY 2013-2014 -- Company 
	else if (condition_7) {
		if (txtNetIncome != 0) {
			A = txtNetIncome * 0.3;
			out_taxBfrRebate = A;
		}
		out_slabRate = 1;
	}// FY 2013-2014 -- Firms and Local Authority
	else if (condition_8) {
		if (txtNetIncome <= 200000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
			A = (txtNetIncome - 200000) * 0.1;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2) + 30000;
			out_taxBfrRebate = A;
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 130000;	
			out_taxBfrRebate = A;
		} 
		out_slabRate = 200000;
	}// Association of Persons (AOP) and Body of Individuals (BOI)
}// AY- 2014-2015
if (cbassyear == "2013-2014") {
	if(condition_1 || condition_2 || condition_11 || condition_12 ){
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
		out_slabRate = 200000;
	}// FY 2012-2013 --  Male & Female as Resident,Non-Resident and Non-Ordinary Resident
	else if(condition_3){
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
		out_slabRate = 250000;
	}//FY 2012-2013 -- Senior Citizen as Resident and Non-Ordinary Resident
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
		out_slabRate = 200000;
	}// FY 2012-2013 --Senior Citizen as Non-Resident
	else if(condition_4){
		if (txtNetIncome <= 500000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
			A = ((txtNetIncome - 500000) * 0.2);
		}
		else if (txtNetIncome > 1000000) {
			A = ((txtNetIncome - 1000000) * 0.3) + 100000;
		}
		out_slabRate = 500000;
	}//FY 2012-2013 -- Super Senior Citizen as Resident and Non-Ordinary Resident
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
		out_slabRate = 200000;
	} // FY 2012-2013 -- Super Senior Citizen as Non-Resident
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
		out_slabRate = 200000;
	}// FY 2012-2013 --HUF 
	else if (condition_6) {
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;

		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.05;
		}
		out_slabRate = 1;
	}// FY 2012-2013 --Company 
	else if (condition_7) {
		if (txtNetIncome != 0) {
			A = txtNetIncome * 0.3;
		}
		out_slabRate = 1;
	}// FY 2012-2013 --Firms and Local Authority
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
		out_slabRate = 200000;
	}// FY 2012-2013 --Association of Persons (AOP) and Body of Individuals (BOI)
}// FY 2012-2013	
else if (cbassyear == "2012-2013") {
	if(condition_1 || condition_11){
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
		out_slabRate = 180000;
	}//FY 2011-2012 -- Male as Resident, Non-Resident and Non-Ordinary Resident
	else if(condition_2 || condition_12){
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
		out_slabRate = 190000;
	}//FY 2011-2012 --Female as Resident, Non-Resident and Non-Ordinary Resident
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
		out_slabRate = 250000;
	}//FY 2011-2012 -- Senior Citizen as Resident and Non-Ordinary Resident
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
		out_slabRate = 180000;
	}// FY 2011-2012 --Senior Citizen as Non-Resident
	else if(condition_4){
		if (txtNetIncome <= 500000 && txtNetIncome != 0) {
		}
		else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
			A = ((txtNetIncome - 500000) * 0.2);
		}
		else if (txtNetIncome > 800000) {
			A = ((txtNetIncome - 800000) * 0.3) + 60000;
		}
		out_slabRate = 500000;
	}//  FY 2011-2012 -- Super Senior Citizen as Resident and Non-Ordinary Resident
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
		out_slabRate = 180000;
	}//FY 2011-2012 -- Super Senior Citizen as Non-Resident
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
		out_slabRate = 180000;
	}//FY 2011-2012 -- HUF
	else if(condition_6){
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
		} 
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.05;
		}
		out_slabRate = 1;
	}//  FY 2011-2012 -- Company
	else if(condition_7){
		if (txtNetIncome != 0) {
			A = txtNetIncome * 0.3;
		}
	}//FY 2011-2012 -- Firms and Local Authority
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
		out_slabRate = 1;
	}// Association of Persons (AOP) and Body of Individuals (BOI)
}// 2012-2013
else if (cbassyear == "2011-2012") {
	if(condition_1 || condition_11){
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
		out_slabRate = 160000;
	}//2011-2012-- Male as Resident and Non-Ordinary Resident
	else if(condition_2 || condition_12){
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
		out_slabRate = 190000;
	}//2011-2012-- Female as Resident and Non-Ordinary Resident
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
		out_slabRate = 240000;
	}//FY 2011-2012 -- Senior Citizen and Super Senior Citizen as Resident and Non-Ordinary Resident
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
		out_slabRate = 160000;
	}//FY 2011-2012 -- Senior Citizen and Super Senior Citizen as Non-Resident
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
		out_slabRate = 160000;
	}//FY 2011-2012 -- HUF
	else if(condition_6){
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.075;
		}
		out_slabRate = 1;
	}//FY 2011-2012 -- Company
	else if(condition_7){
		if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
			A = txtNetIncome * 0.3;
		}
		else if (txtNetIncome > 10000000) {
			A = txtNetIncome * 0.3;
			E = A * 0.075;
		}
		out_slabRate = 1;
	}//FY 2011-2012 --Firms	
}//FY 2011-2012 

B = (A + E) * 0.02;
C = (A + E) * 0.01;
D = Math.round((A + B + C + E)) ;
out_txtTax = Math.round ( A ) ;
out_txtEduCess = Math.round (B) ;
out_txtHEduCess = Math.round (C) ;
out_txttotaltax = Math.round (D) ;
out_txtsurcharge = Math.round (E); 
out_rebate87 = Math.round (out_rebate87);
out_taxBfrRebate = Math.round (out_taxBfrRebate);

