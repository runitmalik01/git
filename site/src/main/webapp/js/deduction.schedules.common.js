/*
 * Java script for All deductions Schedules 
 * 
 * To apply on input fileds so accept Digits
 * 
 * On Fly calculations Functions
 * 
 * */


var $m=jQuery.noConflict(true);
var jqueryFunction;
$m(document).ready(function () {
	$m('input.numberinput').bind('keypress', function (e) {
		return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
	});
	onLoad=function(){
		var dpgg=$m("#fetchggdp").val();
		if(dpgg!=null){
			$m("#AGG").val(dpgg);
		}
		var dp1=$m('#fetchdp1').val();
		if(dp1!=null){
			$m('#schedule80C1').val(dp1);
		}
		var dp2=$m('#fetchdp2').val();
		if(dp2!=null){
			$m('#schedule80C2').val(dp2);
		}
		var dp3=$m('#fetchdp3').val();
		if(dp3!=null){
			$m('#schedule80C3').val(dp3);
		}
		var dp4=$m('#fetchdp4').val();
		if(dp4!=null){
			$m('#schedule80C4').val(dp4);
		}
		var dp5=$m('#fetchdp5').val();
		if(dp5!=null){
			$m('#schedule80C5').val(dp5);
		}
		var dp6=$m('#fetchdp6').val();
		if(dp6!=null){
			$m('#schedule80C6').val(dp6);
		}
		var dp7=$m('#fetchdp7').val();
		if(dp7!=null){
			$m('#schedule80C1').val(dp7);
		}
		var dp8=$m('#fetchdp8').val();
		if(dp8!=null){
			$m('#schedule80C8').val(dp8);
		}
		var dp9=$m('#fetchdp9').val();
		if(dp9!=null){
			$m('#schedule80C9').val(dp9);
		}
		var dp10=$m('#fetchdp10').val();
		if(dp10!=null){
			$m('#schedule80C10').val(dp10);
		}
	};
});

function deduction() {
    var VIGGC= document.getElementById("VIGGC").value-0;
    var VICCC = document.getElementById("VICCC").value-0;
		var VIQQB= document.getElementById("VIQQB").value-0;
		var VICCD= document.getElementById("VICCD").value-0;
		var VIRRB= document.getElementById("VIRRB").value-0;
		var VID= document.getElementById("VID").value-0;
		var VIU= document.getElementById("VIU").value-0;
		var VIDD= document.getElementById("VIDD").value-0;
		var VIDDB= document.getElementById("VIDDB").value-0;
		var VIE= document.getElementById("VIE").value-0;
		var VIJJA= document.getElementById("VIJJA").value-0;
		var VIID= document.getElementById("VIID").value-0;
		var VIGGA= document.getElementById("VIGGA").value-0;
		var VICCF= document.getElementById("VICCF").value-0;
		var VIIAB= document.getElementById("VIIAB").value-0;
		var update= document.getElementById("update").value-0;
		var update1= document.getElementById("update1").value-0;
		var update2= document.getElementById("update2").value-0;
		var update5= document.getElementById("update5").value-0;
		var update3= document.getElementById("update3").value-0;
		var update4= document.getElementById("update4").value-0;
		
		var id= Math.round((VIGGC + VICCC + VIQQB + VICCD + VIRRB + VID + VIU + VIDD +VIDDB + VIE + VIJJA + VIID + VIGGA + VICCF + VIIAB + update + update1 + update2 + update5 + update3 + update4)* 100) / 100;
    document.getElementById("VItotal").value = (id) ;
};	
function fillIA() {
	var AIA= document.getElementById("AIA").value-0;
	var BIA = document.getElementById("BIA").value-0;
	var CIA= document.getElementById("CIA").value-0;
	var DIA= document.getElementById("DIA").value-0;
	var EIA= document.getElementById("EIA").value-0;
	var id1= Math.round((AIA + BIA + CIA + DIA + EIA)* 100) / 100;
	document.getElementById("FIA").value = (id1) ;
};

function fillGG() {
	var AGG= document.getElementById("AGG").value-0;
	var BGG = document.getElementById("BGG").value-0;
	var CGG= document.getElementById("CGG").value-0;
	if(AGG>0 && BGG>0 && CGG>0){
		var id1= AGG * 2000;
		var id2 = BGG * 0.25;
		var id3= CGG -( BGG * 0.1);
		document.getElementById("DGG").value = (id1) ;
		document.getElementById("EGG").value = (id2) ;
		document.getElementById("FGG").value = Math.round(id3) ;
		document.getElementById("GGG").value = Math.round(id3) ;
	}
};


function fillIB() {
	var AIB= document.getElementById("AIB").value-0;
	var BIB = document.getElementById("BIB").value-0;
	var CIB= document.getElementById("CIB").value-0;
	var DIB= document.getElementById("DIB").value-0;
	var EIB= document.getElementById("EIB").value-0;
	var FIB= document.getElementById("FIB").value-0;
	var GIB= document.getElementById("GIB").value-0;
	var HIB= document.getElementById("HIB").value-0;
	var IIB= document.getElementById("IIB").value-0;
	var JIB= document.getElementById("JIB").value-0;
	var KIB= document.getElementById("KIB").value-0;
	var LIB= document.getElementById("LIB").value-0;
	var MIB= document.getElementById("MIB").value-0;
	var id1= Math.round((AIB + BIB + CIB + DIB + EIB + FIB + GIB + HIB + IIB + JIB + KIB + LIB + MIB)* 100) / 100;
	document.getElementById("NIB").value = (id1) ;

};
function fillC() {
	var A= document.getElementById("A").value-0;
	var B = document.getElementById("B").value-0;
	var C= document.getElementById("C").value-0;
	var D= document.getElementById("D").value-0;
	var E= document.getElementById("E").value-0;
	var F= document.getElementById("F").value-0;
	var G= document.getElementById("G").value-0;
	var H= document.getElementById("H").value-0;
	var I= document.getElementById("I").value-0;
	var J= document.getElementById("J").value-0;

	var id1= Math.round((A + B + C + D +E +F +G + H +I + J )* 100)/100;
	document.getElementById("K").value = (id1) ;

};
function fillIC() {
	var AIC= document.getElementById("AIC").value-0;
	var BIC= document.getElementById("BIC").value-0;
	var CIC= document.getElementById("CIC").value-0;
	var DIC= document.getElementById("DIC").value-0;
	var EIC= document.getElementById("EIC").value-0;
	var FIC= document.getElementById("FIC").value-0;
	var GIC= document.getElementById("GIC").value-0;
	var HIC= document.getElementById("HIC").value-0;
	var IIC= document.getElementById("IIC").value-0;
	var JIC= document.getElementById("JIC").value-0;

	var id1=(AIC + BIC + CIC);
	var id2=(DIC + EIC + FIC +GIC + HIC + IIC + JIC);
	var id3= Math.round((id1 + id2)* 100) / 100;
	document.getElementById("KIC").value = (id2) ;
	document.getElementById("LIC").value = (id3) ;

};