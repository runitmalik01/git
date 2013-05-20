//This script will be calculating the Chapter6Deductions
//The input values for this script will be total of each section which will extracted from a hashmap the format of it will be
// sectionname == total
//should we touch any of total_80c, total_80ccc, total_80ccd_ee??
//lets loop 4 times and then see when a negative comes in
//{total_80c=51200.0, total_80ccd_ee=20000.0, total_80ccc=45000.0}

/** - Configuration */
var maxAllowed_80C=100000;
var maxAllowed_80CCF=20000;
/** - END Configuration */

//--- This starts 80c,80ccc,80D Employee's Contribution
var doubleArray = java.lang.reflect.Array.newInstance(java.lang.Double, 3);
doubleArray[0]=total_80c;
doubleArray[1]=total_80ccc;
doubleArray[2]=total_80ccd_ee;
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
out_total_80ccd_ee=doubleArray[2].doubleValue();
//--- This concludes 80c,80ccc,80D Employee's Contribution

//-- This is specially for total_80ccd_er (employer's this is dependent on total of salary income, houseincome and other sources)


//--this one is 80CCF this upper limit it 20000
if (total_80ccf > maxAllowed_80CCF) out_total_80ccf = maxAllowed_80CCF;

//Donations 100%
if (total_80g_50 > 0) total_80g_50 = total_80g_50 * 0.5;