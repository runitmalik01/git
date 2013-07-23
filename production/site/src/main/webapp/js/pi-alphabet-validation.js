//Personal Information Validation

/*
 * Validate the fields First Name Last Name Middle Name Father Name
 * 
 * Not to Enter Any other than Alphabets in input Fields
 * 
 * 
 * */
function AllowAlphabets(){
	if(!pi.pi_first_name.value.match("^[a-zA-Z]+$") && pi.pi_first_name.value!=''){
	    var val=pi.pi_first_name.value;
        var len=pi.pi_first_name.value.length;
	    pi.pi_first_name.value=val.substring(0,len-1);
	    pi.pi_first_name.focus();
	}
	if(!pi.pi_last_name.value.match("^[a-zA-Z]+$") && pi.pi_last_name.value!=''){
	    var val=pi.pi_last_name.value;
        var len=pi.pi_last_name.value.length;
	    pi.pi_last_name.value=val.substring(0,len-1);
	    pi.pi_last_name.focus();
	}
	if(!pi.pi_middle_name.value.match("^[a-zA-Z]+$") && pi.pi_middle_name.value!=''){
	    var val=pi.pi_middle_name.value;
        var len=pi.pi_middle_name.value.length;
	    pi.pi_middle_name.value=val.substring(0,len-1);
	    pi.pi_middle_name.focus();
	}
	if(!pi.pi_father_name.value.match("^[a-zA-Z]+$") && pi.pi_father_name.value!=''){
	    var val=pi.pi_father_name.value;
        var len=pi.pi_father_name.value.length;
	    pi.pi_father_name.value=val.substring(0,len-1);
	    pi.pi_father_name.focus();
	}
}