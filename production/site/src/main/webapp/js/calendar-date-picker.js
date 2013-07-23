/*
 * This Script is used to create calendar to select date
 * 
 * Also Calendar is shown in Popup. 
 * 
 */

var curr_date=new Date();
var curr_year=curr_date.getFullYear(); 
var max_date="3/31/"+curr_year;       
var modal=null;
//script for to create calendar
calendar1 = new YAHOO.widget.Calendar("cal1", { 
	iframe:false,          // Turn iframe off, since container has iframe support. 
	hide_blank_weeks:true,  // Enable, to demonstrate how we handle changing height, using changeContent 
	maxdate:max_date,
	mindate:"",
	pagedate:"01/1990",
	navigator:true,
}); 
calendar1.render();
calendar1.selectEvent.subscribe(function() {
	if (calendar1.getSelectedDates().length > 0) {
		var selDate1 = calendar1.getSelectedDates()[0];
		// Pretty Date Output, using Calendar's Locale values: Friday, 8 February 2008
		var satdate=selDate1.getFullYear()+"-"+(selDate1.getMonth()+1)+"-"+selDate1.getDate();
		var dStr = selDate1.getDate();
		var mStr = calendar1.cfg.getProperty("MONTHS_SHORT")[selDate1.getMonth()];
		var yStr = selDate1.getFullYear();
		$('#shwdate').val(dStr + "-" + mStr + "-" + yStr);
                $('#fetchdate').val(dStr + "-" + mStr + "-" + yStr);
		$("#hiddate").val(satdate);
		modal.hide();
	} else {


	}

});
var fseldate = $('#fetchdate').val();
if(fseldate!=null){
	if (fseldate.length > 0) {
		// Set the pagedate to show the selected date if it exists
		var fetchDate=new Date(Date.parse(fseldate.replace(/-/g, " ")));
		var fpagedate=(fetchDate.getMonth()+1)+"/"+fetchDate.getFullYear();
		var fselectdate=(fetchDate.getMonth()+1)+"/"+fetchDate.getDate()+"/"+fetchDate.getFullYear();
		calendar1.cfg.setProperty("pagedate", fpagedate);
		calendar1.cfg.setProperty("selected", fselectdate);
		calendar1.render();
	}
}
var showdate=$('#shwdate').val();
if(showdate!=null){
	if (showdate.length > 0) {
		// Set the pagedate to show the selected date if it exists
		var fetchDate=new Date(Date.parse(showdate.replace(/-/g, " ")));
		var fpagedate=(fetchDate.getMonth()+1)+"/"+fetchDate.getFullYear();
		var fselectdate=(fetchDate.getMonth()+1)+"/"+fetchDate.getDate()+"/"+fetchDate.getFullYear();
		calendar1.cfg.setProperty("pagedate", fpagedate);
		calendar1.cfg.setProperty("selected", fselectdate);
		calendar1.render();
	}
}



YUI().use('yui2-container', 'yui2-dragdrop', 'event', function(Y) {

	var YAHOO = Y.YUI2;
	//script to create Pop up(Modal)        
	modal = new YAHOO.widget.Panel("content", {
		width: "195px",
		fixedcenter: true,
		close: true,
		draggable: false,
		zindex: 4,
		modal: true,
		visible: false
	});
	modal.render(document.body);


	Y.one('#show').on('click', function() {
		modal.show();
	});
	Y.one('#hide').on('click', function() {
		modal.hide();
	});

});