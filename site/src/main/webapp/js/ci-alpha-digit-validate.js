//Contact Information Validation

/*
 * Validate the fields STD code PIN code Mobile Phone District Area/Locality
 * 
 * Not to Enter Any other than Alphabets in input Fields
 * 
 * Not to Enter Any other than Digits in input Fields
 * 
 * */
function onlyDigit(){
	if(!ci.pi_std_code.value.match("^[0-9]+$") && ci.pi_std_code.value!=''){
	    var val=ci.pi_std_code.value;
        var len=ci.pi_std_code.value.length;
	    ci.pi_std_code.value=val.substring(0,len-1);
	    ci.pi_std_code.focus();
	}
	if(!ci.pi_phone.value.match("^[0-9]+$") && ci.pi_phone.value!=''){
	    var val=ci.pi_phone.value;
        var len=ci.pi_phone.value.length;
	    ci.pi_phone.value=val.substring(0,len-1);
	    ci.pi_phone.focus();
	}
	if(!ci.pi_pin_code.value.match("^[0-9]+$") && ci.pi_pin_code.value!=''){
	    var val=ci.pi_pin_code.value;
        var len=ci.pi_pin_code.value.length;
	    ci.pi_pin_code.value=val.substring(0,len-1);
	    ci.pi_pin_code.focus();
	}
	if(!ci.pi_mobile.value.match("^[0-9]+$") && ci.pi_mobile.value!=''){
	    var val=ci.pi_mobile.value;
        var len=ci.pi_mobile.value.length;
	    ci.pi_mobile.value=val.substring(0,len-1);
	    ci.pi_mobile.focus();
	}
   }

function Alphabet(){
		if(!ci.pi_town_city_district.value.match("^[a-zA-Z]+$") && ci.pi_town_city_district.value!=''){
		    var val=ci.pi_town_city_district.value;
	        var len=ci.pi_town_city_district.value.length;
		    ci.pi_town_city_district.value=val.substring(0,len-1);
		    ci.pi_town_city_district.focus();
		}
		if(!ci.pi_area_locality.value.match("^[a-zA-Z]+$") && ci.pi_area_locality.value!=''){
		    var val=ci.pi_area_locality.value;
	        var len=ci.pi_area_locality.value.length;
		    ci.pi_area_locality.value=val.substring(0,len-1);
		    ci.pi_area_locality.focus();
		}
}