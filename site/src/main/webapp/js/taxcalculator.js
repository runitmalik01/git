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
		var a1 = document.getElementsByName("cashflow1").value-0;
		var s1 = 0;
		if(a>0 && rate>0){
			for (var caflow = 0; caflow <a1.length; caflow++) {
				s1 = s1 + ( a1.item(caflow).value / (Math.pow((1 + (rate/100)),caflow+1)));
			}
			s1=parseFloat(s1)-parseFloat(a);;
			document.getElementById("calculate").value = Math.round((s1)* 100) / 100;
		}//End of if (for checking input values should be greater then 0)	
	};// End Of function call
	
	function no_of_year() {
		var year = $("#no_of_year").val();
		if (year != null) {
			window.location.replace("http://localhost:8080/site/npvcalculator?year="+year);	
		}
	};// End Of function no_of_year.

	function back(){
		window.location.replace("http://localhost:8080/site/npvcalculator");	
		};// End Of function back.
		
		


  
 //Tax Calculator
function calculateTax() {
	var assyear = document.getElementById("cbassyear").value;
	var payer = document.getElementById("cbasstype").value;
	var status = document.getElementById("cbresistatus").value;
	var gender = document.getElementById("cbasscategory").value;
	var tax = document.getElementById("txtNetIncome").value;
	var pay = document.getElementById("txtTax").value;
	var sur = document.getElementById("txtsurcharge").value;
	if (assyear == "2013-14") {
		if (gender == "Male"
			|| gender == "Female"
				&& (payer == "Individual" && status == "Resident"
					|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 200000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is less then 200000.
			else if (tax > 200001 && tax <= 500000) {
				var A = (tax - 200000) * 0.1;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 200001 and less then 500000.
			else if (tax > 500001 && tax <= 1000000) {
				var A = ((tax - 500000) * 0.2) + 30000;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 500001 and less then 1000000.
			else if (tax > 1000000) {
				var A = ((tax - 1000000) * 0.3) + 130000;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 1000000.
		} //  Year 2013-2014..For Male and Female
		else if (gender == "Senior Citizen"
			&& (payer == "Individual" && status == "Resident"
				|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 250000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is less then 250000.
			else if (tax > 250001 && tax <= 500000) {
				var A = ((tax - 250000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 2500001 and less then 500000.
			else if (tax > 500001 && tax <= 1000000) {
				var A = ((tax - 500000) * 0.2) + 25000;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 500001 and less then 1000000.
			else if (tax > 1000000) {
				var A = ((tax - 1000000) * 0.3) + 125000;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 1000001.
		} // Year 2013-2014..Senior Citizen
		else if (gender == "Super Senior Citizen"
			&& (payer == "Individual" && status == "Resident"
				|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 500000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is less then 500000.
			else if (tax > 500001 && tax <= 1000000) {
				var A = ((tax - 500000) * 0.2);
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is  more then500001 and more then 1000001.
			else if (tax > 1000000) {
				var A = ((tax - 1000000) * 0.3) + 100000;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 1000001.
		} //Year 2013-2014..Super Senior Citizen
		else if (payer == "Co-operative Society") {
			if (tax <= 10000 && tax != 0) {
				var A = tax * 0.1;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = A + B + C;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			}
		}//Year..2013-2014 Co-operative Society Calculation

		else if (payer == "HUF") {
			if (tax <= 200000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is less then 200000.
			else if (tax > 200001 && tax <= 500000) {
				var A = (tax - 200000) * 0.1;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 200001 and less then 500000.
			else if (tax > 500001 && tax <= 1000000) {
				var A = ((tax - 500000) * 0.2) + 30000;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 500001 and less then 1000000.
			else if (tax > 1000000) {
				var A = ((tax - 1000000) * 0.3) + 130000;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = Math.round((A + B + C) * 100) / 100;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2013-2014..Tax is more then 1000000.
		} //Year 2013-2014..HUF
		else if (payer == "Domestic Company") {
			if (tax != 0 && tax <= 10000000) {
				var A = tax * 0.3;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			} else if (tax > 10000000) {
				var A = tax * 0.3;
				var E = A * 0.05;
				var B = (A + E) * 0.02;
				var C = (A + E) * 0.01;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			}
		}//Year 2013-2014..Domestic Company
		else if (payer == "Firms" || payer == "Local Authority") {
			if (tax != 0) {
				var A = tax * 0.3;
				var B = A * 0.02;
				var C = A * 0.01;
				var D = A + B + C;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}
		}// 2013-2014 Firms and Local Authority Calculation
	}// Assesssment Year 2013-2014 Calculation
	else if (assyear == "2012-13") {
		if (gender == "Male"
			&& (payer == "Individual" && status == "Resident"
				|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 180000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013..Tax is less then 180000.
			else if (tax > 180001 && tax <= 500000) {
				var A = ((tax - 180000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013..Tax is more then 180001 and less then 500000.
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2) + 32000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013..Tax is more then 500000 and less then 800000.
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 92000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013..Tax is more then 800000.
		}// Year 2012-2013.. Male Calculation
		else if (gender == "Female"
			&& (payer == "Individual" && status == "Resident"
				|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 190000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}// 2012-2013 Tax is less then 190000.
			else if (tax > 190001 && tax <= 500000) {
				var A = ((tax - 190000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is more then 190001 and less then 500000.
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2) + 31000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}// 2012-2013 Tax is more then 500001 and less then 800000.
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 91000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is more then 800000.
		}// Year 2012-2013.. Female Calculation
		else if (gender == "Senior Citizen"
			&& (payer == "Individual" && status == "Resident"
				|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 250000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is less then 250000.
			else if (tax > 250001 && tax <= 500000) {
				var A = ((tax - 250000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is more then 250001 and less then 500000.
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2) + 25000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is more then 500001 and less then 800000.
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 85000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is more then 800000.
		}// Year 2012-2013.. Senior Citizen Calculation
		else if (gender == "Super Senior Citizen"
			&& (payer == "Individual" && status == "Resident"
				|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 500000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is less then 500000.
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is less then 500001 and less then 800000.
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 60000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013 Tax is more then 800000.
		} // Year 2012-2013.. Super Senior Citizen Calculation 
		else if (payer == "Co-operative Society") {
			if (tax <= 10000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			} else if (tax > 10000 && tax <= 20000) {
				var A = (tax * 0.2) + 1000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			} else if (tax > 20000) {
				var A = (tax * 0.3) + 3000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}
		}//Year 2012-2013...Co-operative Society
		else if (payer == "HUF") {
			if (tax <= 180000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013..Tax is less then 180000.
			else if (tax > 180001 && tax <= 500000) {
				var A = ((tax - 180000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013..Tax is more then 180001 and less then 500000.
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2) + 32000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013..Tax is more then 500000 and less then 800000.
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 92000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2012-2013..Tax is more then 1000000.
		} //Year 2012-2013..HUF Calculation
		else if (payer == "Domestic Company") {
			if (tax != 0 && tax <= 10000000) {
				var A = tax * 0.3;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			} else if (tax > 10000000) {
				var A = tax * 0.3;
				var E = A * 0.05;
				var B = (A + E) * 0.02;
				var C = (A + E) * 0.01;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			}
		}//Year 2012-2013..Domestic Company
		else if (payer == "Firms" || payer == "Local Authority") {
			if (tax != 0) {
				var A = tax * 0.3;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}
		}// 2012-2013 Firms and Local Authority Calculation
	} // Assesssment Year 2012-2013 Calculation  

	else if (assyear == "2011-12") {
		if (gender == "Male"
			&& (payer == "Individual" && status == "Resident"
				|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 160000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is less then 160000.
			else if (tax > 160001 && tax <= 500000) {
				var A = ((tax - 190000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}// 2011-2012 Tax is more then 160001 and less then 500000.
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2) + 34000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is more then 500001 and less then 800000.
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 94000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is more then 800001.
		}// Year 2011-2012.. Male Calculation

		else if (gender == "Female"
			&& (payer == "Individual" && status == "Resident"
				|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 190000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is less then 190000.
			else if (tax > 190001 && tax <= 500000) {
				var A = ((tax - 190000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E ) * 100) / 100;
				
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is more then 190000 and less then 500000
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2) + 26000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is more then 500001 and less then 800000
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 86000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is more then 800000
		} // Year 2011-2012.. Female Calculation

		else if ((gender == "Senior Citizen" || gender == "Super Senior Citizen")
				&& (payer == "Individual" && status == "Resident"
					|| status == "Non-Resident" || status == "Not Ordinary Resident")) {
			if (tax <= 240000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is less then 240000
			else if (tax > 240001 && tax <= 500000) {
				var A = ((tax - 240000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is more then 240000 and less then 500000
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2) + 26000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is more then 500000 and less then 800000
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 86000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012 Tax is more then 800000
		}// Year 2011-2012... Senior Citizen 
		else if (payer == "Co-operative Society") {
			if (tax <= 10000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			} else if (tax > 10000 && tax <= 20000) {
				var A = (tax * 0.2) + 1000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			} else if (tax > 20000) {
				var A = (tax * 0.3) + 3000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}
		}//Year 2011-2012 	Co-operative Society  
		else if (payer == "HUF") {
			if (tax <= 160000 && tax != 0) {
				var A = 0;
				var B = 0;
				var C = 0;
				var D = 0;
				var E = 0;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012..HUF..Tax is less then 160000.
			else if (tax > 160001 && tax <= 500000) {
				var A = ((tax - 190000) * 0.1);
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}// 2011-2012..HUF.. Tax is more then 160001 and less then 500000.
			else if (tax > 500001 && tax <= 800000) {
				var A = ((tax - 500000) * 0.2) + 34000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012..HUF.. Tax is more then 500001 and less then 800000.
			else if (tax > 800000) {
				var A = ((tax - 800000) * 0.3) + 94000;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = Math.round((A + B + C + E) * 100) / 100;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;
			}//2011-2012..HUF.. Tax is more then 800001.
		}// Year 2011-2012..HUF Calculation
		else if (payer == "Domestic Company") {
			if (tax != 0 && tax <= 10000000) {
				var A = tax * 0.3;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			} else if (tax > 10000000) {
				var A = tax * 0.3;
				var E = A * 0.075;
				var B = (A + E) * 0.02;
				var C = (A + E) * 0.01;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			}
		}//Year 2011-2012..Domestic Company
		else if (payer == "Firms") {
			if (tax != 0) {
				var A = tax * 0.3;
				var B = A * 0.02;
				var C = A * 0.01;
				var E = 0;
				var D = A + B + C + E;
				document.getElementById("txtTax").value = A;
				document.getElementById("txtEduCess").value = B;
				document.getElementById("txtHEduCess").value = C;
				document.getElementById("txttotaltax").value = D;
				document.getElementById("txtsurcharge").value = E;

			}
		}//Year 2011-2012..Firms
	}//Assessment Year 2011-2012 Calculations	
};//End of function calculatetax

function display() {
	var tax_payer = $("#cbasstype").val();
	if ((tax_payer.match("Co-operative Society"))
			|| (tax_payer.match("Firms"))
			|| (tax_payer.match("HUF"))
			|| (tax_payer.match("Local Authority"))
			|| (tax_payer.match("Domestic Company"))) {
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





