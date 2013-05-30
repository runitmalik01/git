/*
 * Java script for all calculators 
 * 
 * On Fly calculations Functions
 * 
 * */
 
  
 // EMI Calculator
function fill() {
    var A= document.getElementById("A").value-0;
    var B = document.getElementById("B").value-0;
		var C= document.getElementById("C").value-0;
		var  a = document.getElementById("D").value-0;
		a = a || 0;
		if(A>0 && B>0 && C>0){
		var id1= A*(B/1200);
		var id2= (B/1200)+1;
		var id3= Math.pow((id2), C);
		var id4= id3-1;
		var id5= id3/id4;
		var id6= Math.round((id1*id5)* 100) / 100;
    document.getElementById("D").value = (id6) ;
		}
}; // End Of function fill.id3=(1+(B/1200)




// NPV Calculator

	function call() {
		var a = document.getElementById("initial_invest").value-0;
		var rate = document.getElementById("rate").value-0;
		var a1 = document.getElementsByName("cashflow1");
		var s1 = 0;
		for (var caflow = 0; caflow <a1.length; caflow++) {
				s1 = s1 + ( a1.item(caflow).value / (Math.pow((1 + (rate/100)),caflow+1)));
			}
		s1=parseFloat(s1)-parseFloat(a);
		document.getElementById("calculate").value = Math.round((s1)* 100) / 100;			
	};// End Of function call
	
	function no_of_year() {
		var year = $("#no_of_year").val();
		if (year != null) {
			window.location.replace("http://mootlybuilds.zapto.org:8080/site/npvcalculator?year="+year);	
		}
	};// End Of function no_of_year.
	function back(){
		window.location.replace("http://mootlybuilds.zapto.org:8080/site/npvcalculator");	
		};// End Of function back.

//Tax Calculator
function display() {
	var tax_payer = $("#cbasstype").val();
	if ((tax_payer.match("h"))
			|| (tax_payer.match("f"))
			|| (tax_payer.match("c"))
			|| (tax_payer.match("a"))
			|| (tax_payer.match("b"))
			|| (tax_payer.match("l"))) {
		$("#resistatus").hide();
		$("#gender").hide();
		$("#resistatus").hide();
		$("#gender").hide();
		$("#cbresistatus").hide();
		$("#cbasscategory").hide();
	} else {
		$("#resistatus").show();
		$("#gender").show();
		$("#cbresistatus").show();
		$("#cbasscategory").show();

	}
}; // End of display function (to hide gender and residential status.

//For number inputs with decimal only.....
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode ;
   if (charCode != 46 && charCode > 31  && (charCode < 48 || charCode > 57)){
	   return false;   
   } 
   return true;
  
};





