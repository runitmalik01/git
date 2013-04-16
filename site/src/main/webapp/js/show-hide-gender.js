var $m=jQuery.noConflict(true);
hideAllDivs = function () {
	$m("#gender").hide();
        $m("#gendertitle").hide();
};

handleNewSelection = function () {

	hideAllDivs();

	switch ($m(this).val()) {
	case 'I':
		$m("#gender").show();
                $m("#gendertitle").show();
		break;
	case 'H':
		$m("#gender").hide();
                $m("#gendertitle").hide();
		break;
	}
};

$m(document).ready(function() {

	$m("#status").change(handleNewSelection);

	// Run the event handler once now to ensure everything is as it should be
	handleNewSelection.apply($m("#status"));
     var filing=$("#filing").val();
   if(filing!=null){
    $m("#status").val(filing);
    if(filing=="H"){
   $m("#gender").hide();
   $m("#gendertitle").hide();
      }
    }

});
