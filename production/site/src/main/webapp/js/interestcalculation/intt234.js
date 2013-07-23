
function int234(){
	var aytaxmp=$('#aytaxmp').val();
	//var aysfall = $('#aytaxd').val()-$('#aytaxp').val();
	$('#aysfall').val($('#aytaxd').val()-$('#aytaxp').val());
	if($('#aysfall').val()<0){
		$('#aysfall').val(0);
	}
	if($('#ddate').val()==7&&$('#aytaxmp').val()>7){
		$('#dateA').val(aytaxmp*1-7*1);
	}else
		if($('#ddate').val()==9&&$('#aytaxmp').val()>9){
			$('#dateA').val(aytaxmp*1-9*1);
		}else {
			$('#dateA').val(0);
		}
	$('#dateB').val($('#aytaxmp').val()*1-3*1) ;
	if( $('#dateB').val()<0){
		$('#dateB').val(0);
	}
	$('#intA').val(Math.round($('#aysfall').val() * $('#dateA').val() /100));
	$('#intB').val(Math.round($('#aysfall').val() * $('#dateB').val() /100));
	$('#atdq2').val(Math.round($('#aytaxd').val()*30/100));
	$('#atsfq2').val($('#atdq2').val()*1-$('#atlq2').val() *1-$('#atpq2').val()*1);
	if($('#atsfq2').val()<0){
		$('#atsfq2').val(0);
	}
	if($('#aytaxd').val()>=10000){
		$('#atiq2').val(Math.round($('#atsfq2').val()*3/100));
	}else{
		$('#atiq2').val(0);
	}
	$('#atdq3').val(Math.round($('#aytaxd').val()*60/100));
	$('#atsfq3').val($('#atdq3').val()*1-$('#atlq3').val()*1-$('#atpq3').val()*1);
	if($('#atsfq3').val()<0){
		$('#atsfq3').val(0);
	}
	if($('#aytaxd').val()>=10000){
		$('#atiq3').val(Math.round($('#atsfq3').val()*3/100));
	}else{
		$('#atiq3').val(0);
	}
	$('#atdq4').val(Math.round($('#aytaxd').val()));
	$('#atsfq4').val($('#atdq4').val()*1-$('#atlq4').val()*1-$('#atpq4').val()*1);
	if($('#atsfq4').val()<0){
		$('#atsfq4').val(0);
	}
	if($('#aytaxd').val()>=10000){
		$('#atiq4').val(Math.round($('#atsfq4').val()/100));
	}else{
		$('#atiq4').val(0);
	}
	$('#ic').val($('#atiq2').val()*1+$('#atiq3').val()*1+$('#atiq4').val()*1);
	$('#intt').val($('#ic').val()*1+$('#intA').val()*1+$('#intB').val()*1);
}
window.onload=int234();