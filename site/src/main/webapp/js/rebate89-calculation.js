
var $m=jQuery.noConflict(true);
$m(document).ready(function () {
	$m('input.numberinput').bind('keypress', function (e) {
		return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
	});
});
$m('#arrears').change(function() {
	var totalsalary=parseInt($m('#salaryincome').val())+parseInt($m('#otherincome').val());
	var sum=parseInt($m('#salaryincome').val())+parseInt($m('#otherincome').val())+parseInt($m('#arrears').val());
    $m('#totalincomearrears').val(sum);
     var taxsalaryincome=Math.round((totalsalary*10.3)/100);
    $m('#taxsalaryincome').val(taxsalaryincome);
    var taxarrears=Math.round((sum*10.3)/100);
    $m('#taxarrears').val(taxarrears);
    var diff=parseInt(taxarrears)-parseInt(taxsalaryincome);
    $m('#diff').val(diff);
});
function calculate(){
	
	var income1=$m('#income1').val();
	var income2=$m('#income2').val();
	var income3=$m('#income3').val();
	
	var arrears1=$m('#arrears1').val();
	var arrears2=$m('#arrears2').val();
	var arrears3=$m('#arrears3').val();
	
	var total1=parseInt(income1)+parseInt(arrears1);
	var total2=parseInt(income2)+parseInt(arrears2);
	var total3=parseInt(income3)+parseInt(arrears3);
	
	if(income1!=""){
		var taxincome=Math.round((income1*10.3)/100);
		$m('#taxincome1').val(taxincome);
	}
	if(income2!=""){
		var taxincome=Math.round((income2*10.3)/100);
		$m('#taxincome2').val(taxincome);
	}
	if(income3!=""){
		var taxincome=Math.round((income3*10.3)/100);
		$m('#taxincome3').val(taxincome);
	}
	
	
	if(income1!=""&&arrears1==""){
		$m('total1').val(income1);
		$m('#taxontotal1').val(Math.round((income1*10.3)/100));
		$m('#taxdiff1').val("0");
	}
	if(income2!=""&&arrears2==""){
		$m('total2').val(income1);
		$m('#taxontotal2').val(Math.round((income2*10.3)/100));
		$m('#taxdiff2').val("0");
	}
	if(income3!=""&&arrears3==""){
		$m('total3').val(income3);
		$m('#taxontotal3').val(Math.round((income3*10.3)/100));
		$m('#taxdiff3').val("0");
	}
	
	
	if(income1!=""&&arrears1!=""){
		$m('#total1').val(total1);
		var taxincome1=Math.round((income1*10.3)/100);
		var taxontotal1=Math.round((total1*10.3)/100);
		$m('#taxontotal1').val(taxontotal1);
		$m('#taxdiff1').val(parseInt(taxontotal1)-parseInt(taxincome1));
		var taxdiff1=$m('#taxdiff1').val();
		var prevtotaltax=$m('#computedtabletotal').val();
		$m('#computedtabletotal').val(parseInt(taxdiff1));
	}
	if(income2!=""&&arrears2!=""){
		$m('#total2').val(total2);
		var taxincome2=Math.round((income2*10.3)/100);
		var taxontotal2=Math.round((total2*10.3)/100);
		$m('#taxontotal2').val(taxontotal2);
		$m('#taxdiff2').val(parseInt(taxontotal2)-parseInt(taxincome2));
		var taxdiff2=$m('#taxdiff2').val();
		var prevtotaltax=$m('#computedtabletotal').val();
		$m('#computedtabletotal').val(parseInt(prevtotaltax)+parseInt(taxdiff2));
	}
	if(income3!=""&&arrears3!=""){
		$m('#total3').val(total3);
		var taxincome3=Math.round((income3*10.3)/100);
		var taxontotal3=Math.round((total3*10.3)/100);
		$m('#taxontotal3').val(taxontotal3);
		$m('#taxdiff3').val(parseInt(taxontotal3)-parseInt(taxincome3));
		var taxdiff3=$m('#taxdiff3').val();
		var prevtotaltax=$m('#computedtabletotal').val();
		$m('#computedtabletotal').val(parseInt(prevtotaltax)+parseInt(taxdiff3));
	}
	var diff=$m('#diff').val();
	if(diff!=""){
		var computedtabletotal=$m('#computedtabletotal').val();
		$m('#taxpaid').val(parseInt(diff)-parseInt(computedtabletotal));
	}
};