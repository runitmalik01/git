//This script will be calculating the Chapter6Deductions
//The input values for this script will be total of each section which will extracted from a hashmap the format of it will be
//sectionname == total
//should we touch any of total_80c, total_80ccc, total_80ccd_ee??
//lets loop 4 times and then see when a negative comes in
//{total_80c=51200.0, total_80ccd_ee=20000.0, total_80ccc=45000.0}

/** - Configuration */
var maxAllowed_80C=100000;
var maxAllowed_80CCF=20000;
var maxAllowed_80D=35000;
var maxAllowed_80DD=100000;
var maxAllowed_80U=100000;
var maxAllowed_80qqb_80rrb=300000;
out_total_eligiblededuction=0;
//isSeniorCitizen=true;
/** - END Configuration */
//80E-It depends on gross total income
var grosstotal= salarypension + othersources + houseproperty;

//--- This starts 80c,80ccc,80D Employee's Contribution
var doubleArray = java.lang.reflect.Array.newInstance(java.lang.Double, 3);
doubleArray[0]=total_80c;
doubleArray[1]=total_80ccc;
doubleArray[2]=total_80ccd_2;
var maxAllowed=maxAllowed_80C;
var leftOver = maxAllowed_80C;
for (var i=0;i<3;i++){
	if (leftOver <=0) {
		doubleArray[i] =  0;
	} 
	else {
		leftOver = maxAllowed - doubleArray[i].doubleValue();
		if (leftOver < 0) {
			doubleArray[i] =  maxAllowed;		
		}
		maxAllowed = leftOver;
	}
}
out_total_80c=doubleArray[0].doubleValue();
out_total_80ccc=doubleArray[1].doubleValue();
out_total_80ccd_2=doubleArray[2].doubleValue();
//--- This concludes 80c,80ccc,80D Employee's Contribution

//-- This is specially for total_80ccd_er (employer's this is dependent on total of salary income, houseincome and other sources)

//exempt for Employee's Contribution to Pension Account i.e. 80ccd_1
var tenperSalincome=(salarypension *0.1);
if(total_80ccd_1 >= tenperSalincome)
	out_total_80ccd_1=tenperSalincome;
else out_total_80ccd_1=total_80ccd_1;
//--this one is 80CCF this upper limit it 20000
out_total_80ccf=0;
if (total_80ccf > maxAllowed_80CCF) out_total_80ccf = maxAllowed_80CCF;

//medical insurance premium
//self,spouse,spousesenior,parentsnonsenior,parentssenior
var maxMedicalPremiumAllowed = ((isSeniorCitizen || (total_spousesenior > 0) || (total_parentssenior > 0)) ? 20000 : 15000);
var maxMedicalPremium = (total_self + total_spouse + total_spousesenior + total_parentsnonsenior + total_parentssenior);
//if (maxMedicalPremium > maxMedicalPremiumAllowed) maxMedicalPremium = maxAllowed;
if (maxMedicalPremium > maxMedicalPremiumAllowed) maxMedicalPremium = maxAllowed_80D;
out_total_80d=maxMedicalPremium;

//80DD - Medical Treatment/Maintenance of Handicapped Dependents
//--exempt limit for NormalDisability
if(total_normaldisability>50000)
	total_normaldisability=50000;
//--exempt limit for Severe Disability
if(total_severedisability>maxAllowed_80DD)
	total_severedisability=maxAllowed_80DD;
//--Overall exempt limit
if((total_normaldisability+total_severedisability)>maxAllowed_80DD)
	out_total_80dd=maxAllowed_80DD;
else out_total_80dd= (total_normaldisability + total_severedisability);

//80DDB-Treatment of Specified diseases
var total_deases=total_neurological + total_parkinson + total_malignantcancer + total_aids + total_chronicrenalfailure + total_hemophilia + total_thallassaemia;
if(isSeniorCitizen){
	if(total_deases>=60000)
		out_total_80ddb=60000;
	else out_total_80ddb=total_deases;
}else{
	if(total_deases>=40000)
		out_total_80ddb=40000;
	else out_total_80ddb=total_deases;
}

//80U - Person suffering from specified disability
if(total_disability>50000)
	total_disability=50000;
if(total_sdisability>maxAllowed_80U)
	total_sdisability=maxAllowed_80U;
if((total_disability+total_sdisability)>maxAllowed_80U)
	out_total_80u=maxAllowed_80U;
else out_total_80u= (total_disability + total_sdisability);

//80RRB and 80QQB -exempt limit for 80RRB and 80QQB 
if(total_80rrb>maxAllowed_80qqb_80rrb)
	out_total_80rrb=maxAllowed_80qqb_80rrb;
else out_total_80rrb=total_80rrb;
if(total_80qqb>maxAllowed_80qqb_80rrb)
	out_total_80qqb=maxAllowed_80qqb_80rrb;
else out_total_80qqb=total_80qqb;

//Donations 100%
out_total_80g = (total_NoAppr50 * 0.5) + (total_Appr50 * 0.5) + (total_Appr100) + (total_Appr50); 
//100% deductions on 80E,80GGA,80GGC,80JJA,80ID,80IA

out_total_80e= (total_80e < grosstotal) ? total_80e:grosstotal;

out_total_80gga= (total_80gga < grosstotal) ? total_80gga:grosstotal;

out_total_80ggc= (total_80ggc < grosstotal) ? total_80ggc:grosstotal;

//out_total_80id= (total_80id < grosstotal) ? total_80id:grosstotal;

out_total_80jja= (total_80jja < grosstotal) ? total_80jja:grosstotal;

//out_total_80ia= (total_80ia < grosstotal) ? total_80ia:grosstotal;

out_total_eligiblededuction = out_total_80c + out_total_80ccc + out_total_80ccd_1 + out_total_80ccd_2 + out_total_80qqb + out_total_80rrb + out_total_80gga + out_total_80ggc + out_total_80g + out_total_80jja + out_total_80ddb + out_total_80u + out_total_80dd + out_total_80qqb + out_total_80e ;

//80G- Calculate AdjustedGrossTotal and Excess Rent Paid and 2000 per Month
out_total_80gg=0;
if(total_80gg>0){
	var adjuestedGrossTotal=grosstotal - out_total_eligiblededuction;
	var adjuestedGross10per=adjuestedGrossTotal * 0.1;
	var	adjuestedGross25per=adjuestedGrossTotal * 0.25;
	var excessRentPaid=total_80gg-adjuestedGross10per;
	var rent2000permnth=24000;
	out_total_80gg=Math.min(rent2000permnth,adjuestedGross25per,excessRentPaid);
	if(out_total_80gg<0)
		out_total_80gg=0;
	out_total_eligiblededuction=out_total_eligiblededuction+out_total_80gg;
}
if(out_total_eligiblededuction>grosstotal)
	out_total_eligiblededuction=grosstotal;
//print("hello word"+grosstotal);
//lets break the module into functions for easier maintenance
/*function calcEligibleMedicalPremium(inAmount,isSeniorCitizen) {
	if (inAmount > 15000 && !isSeniorCitizen) {
		return 15000;
	}
	else {
		return inAmount;
	}
	if (inAmount > 15000 && isSeniorCitizen) {
		if (inAmount > 20000) {
			return 20000;
		}
		else {
			return inAmount;
		}
	}
}*/