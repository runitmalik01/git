
//var aysfall = $('#aytaxd').val()-$('#aytaxp').val();
var aysfall = aytaxd-aytaxp;
/*
if(aysfall<0){
	aysfall = 0;
}
if(ddate==7 && aytaxmp>7){  // Due date is 31 july after that interest will be calculated for Section 234A
	var dateA = aytaxmp-7;   //For salary earners and other non corporate assessees whose accounts are not required to be audited
}else
	if(ddate==9 && aytaxmp>9){ // Due Date is 31 September for non corporate assessees whose accounts are required to be audited
		var dateA = aytaxmp-9;
	}else
		if(ddate==10 && aytaxmp>10){  //added new condition for uttarakhand
			var dateA = aytaxmp-10;   //(Due Date is 31oct after that interest will be calculated for section 234A)
		}
		else {
			var dateA = 0;
		}

var dateB = aytaxmp-3;
if( dateB<0){
	dateB = 0 ;
}
*/
var dateA = dueDateFor234A;
out_intA = Math.round(aysfall * dateA/100);
/*
if(aytaxd>=10000){    // Added on 31/07/2013 for interest Section234B
	out_intB = Math.round(aysfall * dateB/100);
}else
	out_intB = 0;
	*/
out_intB = resultIntB;

var atdq2 = Math.round(aytaxd*30/100);
var atsfq2 = atdq2-atlq2-atpq2;
if(atsfq2 < 0){
	atsfq2 = 0;
}
if(aytaxd>=10000){
	var atiq2 = Math.round(atsfq2*3/100);
}else{
	var atiq2 = 0;
}
var atdq3 = Math.round(aytaxd*60/100);
var atsfq3 = atdq3-atlq3-atpq3;
if(atsfq3<0){
	atsfq3 = 0;
}
if(aytaxd>=10000){
	var atiq3 = Math.round(atsfq3*3/100);
}else{
	var atiq3 = 0;
}
atdq4 = Math.round(aytaxd);
var atsfq4 = atdq4-atlq4-atpq4;
if(atsfq4 < 0){
	atsfq4 = 0;
}
if(aytaxd>=10000){
	var atiq4 = Math.round(atsfq4/100);
}else{
	var atiq4 = 0;
}
out_ic = atiq2+atiq3+atiq4;
out_intt = out_ic+out_intA+out_intB;
