
//var aysfall = $('#aytaxd').val()-$('#aytaxp').val();
var aysfall = aytaxd-aytaxp;
if(aysfall<0){
	aysfall = 0;
}
if(ddate==7 && aytaxmp>7){
	var dateA = aytaxmp*1-7*1;
}else
	if(ddate==9 && aytaxmp>9){
		var dateA = aytaxmp*1-9*1;
	}else {
		var dateA = 0;
	}
var dateB = aytaxmp*1-3*1 ;
if( dateB<0){
	dateB = 0 ;
}
out_intA = Math.round(aysfall * dateA/100);
out_intB = Math.round(aysfall * dateB/100);
var atdq2 = Math.round(aytaxd*30/100);
var atsfq2 = atdq2*1-atlq2*1-atpq2*1;
if(atsfq2 < 0){
	atsfq2 = 0;
}
if(aytaxd>=10000){
	var atiq2 = Math.round(atsfq2*3/100);
}else{
	var atiq2 = 0;
}
var atdq3 = Math.round(aytaxd*60/100);
var atsfq3 = atdq3*1-atlq3*1-atpq3*1;
if(atsfq3<0){
	atsfq3 = 0;
}
if(aytaxd>=10000){
	var atiq3 = Math.round(atsfq3*3/100);
}else{
	var atiq3 = 0;
}
atdq4 = Math.round(aytaxd);
var atsfq4 = atdq4*1-atlq4*1-atpq4*1;
if(atsfq4 < 0){
	atsfq4 = 0;
}
if(aytaxd>=10000){
	var atiq4 = Math.round(atsfq4/100);
}else{
	var atiq4 = 0;
}
out_ic = atiq2*1+atiq3*1+atiq4*1;
out_intt = out_ic*1+out_intA*1+out_intB*1;
