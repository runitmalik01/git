var $m=jQuery.noConflict(true);
hideAllDivs = function () {
	$m("#hourly").hide();
	$m("#submit").hide();
};

handleNewSelection = function () {

	hideAllDivs();

	switch ($m(this).val()) {
	case '1':
		$m("#hourly").show();
		$m("#submit").show();
		break;
	case '2':
		$m("#submit").show();
		break;
	}
};

$m(document).ready(function() {

	$m("#project_billing_code_id").change(handleNewSelection);

	// Run the event handler once now to ensure everything is as it should be
	handleNewSelection.apply($m("#project_billing_code_id"));

});
