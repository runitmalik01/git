//This script will be calculating the Chapter6Deductions
//The input values for this script will be total of each section which will extracted from a hashmap the format of it will be
// sectionname == total
//should we touch any of total_80c, total_80ccc, total_80ccd_ee??
//lets loop 4 times and then see when a negative comes in
//{total_80c=51200.0, total_80ccd_ee=20000.0, total_80ccc=45000.0}

/** - Configuration */
var maxAllowed_80C=100000;
var maxAllowed_80CCF=20000;
out_total_eligiblededuction=0;
//isSeniorCitizen=true;
/** - END Configuration */

//--- This starts 80c,80ccc,80D Employee's Contribution
var doubleArray = java.lang.reflect.Array.newInstance(java.lang.Double, 3);
doubleArray[0]=total_80c;
doubleArray[1]=total_80ccc;
doubleArray[2]=total_80ccd_1;
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
out_total_80ccd_1=doubleArray[2].doubleValue();
//--- This concludes 80c,80ccc,80D Employee's Contribution

//-- This is specially for total_80ccd_er (employer's this is dependent on total of salary income, houseincome and other sources)


//--this one is 80CCF this upper limit it 20000
if (total_80ccf > maxAllowed_80CCF) out_total_80ccf = maxAllowed_80CCF;

//medical insurance premium
//self,spouse,spousesenior,parentsnonsenior,parentssenior
var maxMedicalPremiumAllowed = ((isSeniorCitizen || (total_spousesenior > 0) || (total_parentssenior > 0)) ? 20000 : 15000);
var maxMedicalPremium = (total_self + total_spouse + total_spousesenior + total_parentsnonsenior + total_parentssenior);
if (maxMedicalPremium > maxMedicalPremiumAllowed) maxMedicalPremium = maxAllowed;
out_total_80d=maxMedicalPremium;

//Donations 100%
out_total_80g = (total_NoAppr50 * 0.5) + (total_Appr50 * 0.5) + (total_Appr100) + (total_Appr50) 


out_total_eligiblededuction= out_total_80c + out_total_80ccc + out_total_80ccd_1 + total_80ccf + out_total_80g;


// lets break the module into functions for easier maintenance
function calcEligibleMedicalPremium(inAmount,isSenior) {
	if (inAmount > 15000 && !isSenior) {
		return 15000
	}
	else {
		return inAmount;
	}
	if (inAmount > 15000 && isSenior) {
		if (inAmount > 20000) {
			return 20000;
		}
		else {
			return inAmount;
		}
	}
}