
var upto15St = 0;
var upto15lt = 0;
var upto15np = 0;
var upto15oth = 0;
var upto16declt = 0;
var upto16decoth = 0;
var upto16decst = 0;
var upto16lt = 0;
var upto16np = 0;
var upto16oth = 0;
var upto16st = 0;
var upto31lt = 0;
var upto31np = 0;
var upto31oth = 0;
var upto31st = 0;
var uptodecnp = 0;

if(capitalGainDetails != null){
	for(var i=0 ; i<capitalGainDetails.size() ; i++){
		upto15St = upto15St + (capitalGainDetails.get(i).getUpto15St()-0);
		upto15lt = upto15lt + (capitalGainDetails.get(i).getUpto15Lt()-0);
		upto15np = upto15np + (capitalGainDetails.get(i).getUpto15Np()-0);
		upto15oth = upto15oth + (capitalGainDetails.get(i).getUpto15Oth()-0);
		upto16declt = upto16declt + (capitalGainDetails.get(i).getUpto16DecLt()-0);
		upto16decoth = upto16decoth + (capitalGainDetails.get(i).getUpto16DecOth()-0);
		upto16decst = upto16decst + (capitalGainDetails.get(i).getUpto16decSt()-0);
		upto16lt = upto16lt + (capitalGainDetails.get(i).getUpto16Lt()-0);
		upto16np = upto16np + (capitalGainDetails.get(i).getUpto16Np()-0);
		upto16oth = upto16oth + (capitalGainDetails.get(i).getUpto16Oth()-0);
		upto16st = upto16st + (capitalGainDetails.get(i).getUpto16St()-0);
		upto31lt = upto31lt + (capitalGainDetails.get(i).getUpto31Lt()-0);
		upto31np = upto31np + (capitalGainDetails.get(i).getUpto31Np()-0);
		upto31oth = upto31oth + (capitalGainDetails.get(i).getUpto31Oth()-0);
		upto31st = upto31st + (capitalGainDetails.get(i).getUpto31St()-0);
		uptodecnp = uptodecnp + (capitalGainDetails.get(i).getUptodecNp()-0);
	}
}
out_upto15St = upto15St;
out_upto15lt = upto15lt;
out_upto15np = upto15np;
out_upto15oth = upto15oth;
out_upto16declt = upto16declt;
out_upto16decoth = upto16decoth;
out_upto16decst = upto16decst;
out_upto16lt = upto16lt;
out_upto16np = upto16np;
out_upto16oth = upto16oth;
out_upto16st = upto16st;
out_upto31lt = upto31lt;
out_upto31np = upto31np;
out_upto31oth = upto31oth;
out_upto31st = upto31st;
out_uptodecnp = uptodecnp;