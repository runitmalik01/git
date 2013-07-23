var $m=jQuery.noConflict(true);
hideAllDivs = function () {
	$m("#hourly").hide();
	$m("#per_diem").hide();
	$m("#d").hide();
	$m("#b").hide();
	$m("#c").hide();
	$m("#f").hide();
	$m("#nri").hide();
	$m("#nor").hide();
	$m("#res").hide();
	$m("#button").hide();
	$m("#e").hide();
};
hideScreenOne=function(){
	$m("#d").hide();
	$m("#b").hide();
	$m("#e").hide();
	$m("#f").hide();
	$m("#nri").hide();
	$m("#nor").hide();
	$m("#res").hide();
	$m("#button").hide();
};
hideScreenTwo=function(){
	$m("#nor").hide();
	$m("#e").hide();
	$m("#nri").hide();
	$m("#res").hide();
	$m("#button").hide();
};
hideScreenThree=function(){
	$m("#nor").hide();
	$m("#res").hide();
	$m("#nri").hide();
	$m("#button").hide();
};
hideScreenFour=function(){
	$m("#f").hide();
	$m("#c").hide();
	$m("#d").hide();
	$m("#e").hide();
	$m("#nor").hide();
	$m("#nri").hide();
	$m("#f").hide();
	$m("#res").hide();
	$m("#button").hide();
};
hideScreenFive=function(){
	$m("#nri").hide();
	$m("#d").hide();
	$m("#e").hide();
	$m("#res").hide();
	$m("#nor").hide();
};
hideScreenSix=function(){
	$m("#nri").hide();
	$m("#res").hide();
	$m("#nor").hide();
	$m("#d").hide();
};
hidefetchDivs=function(){
	$m("#changeresi").hide();
	$m("#fetch").hide();
	$m("#button").hide();
};
Confirmation=function(){
	var retVal = confirm("Do you want to continue ?");
	if( retVal == true ){
		$m("#changeresi").show();
		return true;
	}else{
		$m("#fetch").show();
		$m("#repofetch").val("1");
		return false;
	}
};
Check=function(){
	if($m("#residentstatus").is(":empty")){
		$m("#changeresi").show();
	}else{
		$m("#fetch").show();
		$m("#repofetch").val("1");
	}       
};
HandleRepoFetchSelection= function(){

	hidefetchDivs();

	switch($m(this).val()){
	case '1':
		Check();
		break;
	case '2':          
		Confirmation();
		break;
	}
};
handleNewSelection = function () {

	hideAllDivs();

	switch ($m(this).val()) {
	case '1':
		$m("#hourly").show();
		$m("#button").show();
		break;
	case '2':
		$m("#per_diem").show();
		$m("#screen_one").val("");
		break;
	}
};
HandleScreenOne = function () {

	hideScreenOne();

	switch ($m(this).val()) {
	case '1':
		$m("#d").show();
		$m("#screen_two").val("");
		break;
	case '2':
		$m("#b").show();
		$m("#screen_four").val("");
		break;
	}
};
HandleScreenTwo = function () {

	hideScreenTwo();

	switch ($m(this).val()) {
	case '1':
		$m("#e").show();
		$m("#screen_three").val("");
		break;
	case '2':
		$m("#nor").show();
		var get=document.getElementById("nor").innerHTML;         
		document.getElementById("hidresi").setAttribute("value",get);
		$m("#button").show();
		break;
	}
};
HandleScreenThree = function () {

	hideScreenThree();

	switch ($m(this).val()) {
	case '1':
		$m("#res").show();
		var get=document.getElementById("res").innerHTML;            
		document.getElementById("hidresi").setAttribute("value",get);
		$m("#button").show();
		break;
	case '2':
		$m("#nor").show();
		var get=document.getElementById("nor").innerHTML;           
		document.getElementById("hidresi").setAttribute("value",get);
		$m("#button").show();
		break;
	}
};
HandleScreenFour = function () {

	hideScreenFour();

	switch ($m(this).val()) {
	case '1':
		$m("#f").show();
		$m("#screen_six").val("");            
		break;
	case '2':
		$m("#c").show();
		$m("#screen_five").val("");
		break;
	}
};
HandleScreenFive = function () {

	hideScreenFive();

	switch ($m(this).val()) {
	case '1':
		$m("#d").show();
		$m("#screen_two").val("");
		break;
	case '2':
		$m("#nri").show();
		var get=document.getElementById("nri").innerHTML;
		document.getElementById("hidresi").setAttribute("value",get);
		$m("#button").show();
		break;
	}
};
HandleScreenSix = function () {

	hideScreenSix();

	switch ($m(this).val()) {
	case '1':
		$m("#d").show();
		$m("#screen_two").val("");
		break;
	case '2':
		$m("#nri").show();
		var get=document.getElementById("nri").innerHTML;
		document.getElementById("hidresi").setAttribute("value",get);
		$m("#button").show();
		break;
	}
};
$m(document).ready(function() {
	$m("#repofetch").change(HandleRepoFetchSelection);
	$m("#project_billing_code_id").change(handleNewSelection);
	$m("#screen_one").change(HandleScreenOne);
	$m("#screen_two").change(HandleScreenTwo);
	$m("#screen_three").change(HandleScreenThree);
	$m("#screen_four").change(HandleScreenFour);
	$m("#screen_five").change(HandleScreenFive);
	$m("#screen_six").change(HandleScreenSix);
	// Run the event handler once now to ensure everything is as it should be
	HandleRepoFetchSelection.apply($m("#repofetch"));
	handleNewSelection.apply($m("#project_billing_code_id"));
	HandleScreenOne.apply($m("#screen_one"));
	HandleScreenTwo.apply($m("#screen_two"));  
	HandleScreenThree.apply($m("#screen_three")); 
	HandleScreenFour.apply($m("#screen_four"));
	HandleScreenFive.apply($m("#screen_five"));
	HandleScreenSix.apply($m("#screen_six"));
});
