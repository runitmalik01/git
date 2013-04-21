function int234(){var aytaxmp=$('aytaxmp').value;
$('aysfall').value=$('aytaxd').value*1-$('aytaxp').value*1;
if($('aysfall').value<0){$('aysfall').value=0;}
if($('ddate').value==7&&$('aytaxmp').value>7){$('dateA').value=aytaxmp*1-7*1;}
else if($('ddate').value==9&&$('aytaxmp').value>9){$('dateA').value=aytaxmp*1-9*1;}
else {$('dateA').value=0;}
$('dateB').value= $('aytaxmp').value*1-3*1;
if( $('dateB').value<0){$('dateB').value=0;}
$('intA').value=Math.round($('aysfall').value * $('dateA').value /100);
$('intB').value=Math.round($('aysfall').value * $('dateB').value /100);
$('atdq2').value=Math.round($('aytaxd').value*30/100);
$('atsfq2').value=$('atdq2').value*1-$('atlq2').value *1-$('atpq2').value*1;
if($('atsfq2').value<0){$('atsfq2').value=0;}
if($('aytaxd').value>=10000){
$('atiq2').value=Math.round($('atsfq2').value*3/100)}
else{$('atiq2').value=0}
$('atdq3').value=Math.round($('aytaxd').value*60/100);
$('atsfq3').value=$('atdq3').value*1-$('atlq3').value*1-$('atpq3').value*1;
if($('atsfq3').value<0){$('atsfq3').value=0;}
if($('aytaxd').value>=10000){$('atiq3').value=Math.round($('atsfq3').value*3/100);}
else{$('atiq3').value=0}
$('atdq4').value=Math.round($('aytaxd').value);
$('atsfq4').value=$('atdq4').value*1-$('atlq4').value*1-$('atpq4').value*1;
if($('atsfq4').value<0){$('atsfq4').value=0;}
if($('aytaxd').value>=10000){
$('atiq4').value=Math.round($('atsfq4').value/100);}
else{$('atiq4').value=0}
$('ic').value= $('atiq2').value*1+$('atiq3').value*1+$('atiq4').value*1;
$('intt').value=$('ic').value*1+$('intA').value*1+$('intB').value*1;}
