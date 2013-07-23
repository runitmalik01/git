var calArchive = new CalendarPopup();
var calReview = new CalendarPopup();
var now = new Date();

function isValidDate(date){
	var format = "M/d/yy";
	return isDate(date,format);
}

function isFutureDate(checkdate){
	var format = "M/d/yy";	
	var check_time=getDateFromFormat(checkdate,format);
	var nowdate = formatDate(now, format);
	var now_time=getDateFromFormat(nowdate,format);	
	
	if(check_time > now_time || check_time == now_time)  return true;
	else return false;	
}

function validateFlagDates(archive, review){
	if ((archive == null || archive == "") && (review == null || review == "")){
		alert("both dates cannot be empty");
		return false;
	}

	if (archive != null && archive != ""){
		if (!isValidDate(archive)){
			alert("archive date must be in the mm/dd/yy format");
			return false;
		}

		if (!isFutureDate(archive)){
			alert("archive date must be today, or any day in the future");
			return false;
		}		
		
	}
	
	if (review != null && review != ""){
		if (!isValidDate(review)){
			alert("review date must be in the mm/dd/yy format");
			return false;
		}

		if (!isFutureDate(review)){
			alert("review date must be today, or any day in the future");
			return false;
		}		
	}
	return true;
}

function changeFlagDates(archive, review, actionquestion  ){
	if (!validateFlagDates(archive, review)){
		return;
	}else{
		performAction('flagdate', 'archive=' + encodeURI(archive) + '&review=' + encodeURI(review), actionquestion );
	}
}

	var isAddAction = true;
	var AddUMTypesArray = new Array();
	var RemoveUMTypesArray = new Array();

	function clearUMArrays() {
		AddUMTypesArray = new Array();
		RemoveUMTypesArray = new Array();
	}

	function showAddUMDialog() {
		isAddAction = true;
		showUMDialog(document.formUMDialog)
	}

	function showRemoveUMDialog() {
		isAddAction = false;
		showUMDialog(document.formUMDialog)
	}

	function getSelectedUMItems () {
		return evolveItemsFromTypes( isAddAction ? AddUMTypesArray : RemoveUMTypesArray);
	}
	function setSelUMResults(arrayUMItems) {
		if (arrayUMItems != null) {
			arrayUMTypes = evolveTypes(arrayUMItems);
			if( isAddAction ) {			     
				setSelUMResultOnPage(arrayUMTypes,document.getElementById( "universalMetadataAdd" ));
				AddUMTypesArray = arrayUMTypes;
			}
			else {
				setSelUMResultOnPage(arrayUMTypes,document.getElementById( "universalMetadataRemove"));
				RemoveUMTypesArray = arrayUMTypes;
			}			
			if (AddUMTypesArray.length != 0 || RemoveUMTypesArray.length != 0) {
				document.getElementById("btn_changeUnivMetaData").disabled=false;
			}
			else document.getElementById("btn_changeUnivMetaData").disabled=true;
		}
	}
	function setSelUMResultOnPage(arrayUMTypes, placeForUM) {
		if (arrayUMTypes != null&& arrayUMTypes.length > 0) {
			innerHTML = "";
			for (i=0; i < arrayUMTypes.length; ++i) {
				innerHTML +="<br/>";
				uMType = arrayUMTypes[i];
				innerHTML += uMType.toString();
			}
			placeForUM.innerHTML = innerHTML;
		} else {
			placeForUM.innerHTML = "";
		}
	}

	function performAction_ChangeUM( actionquestion ) {
		var params = "add=" + getItemIds( AddUMTypesArray ) + "&remove=" + getItemIds( RemoveUMTypesArray );
		performAction( "changeum", params, actionquestion)
	}

	function getItemIds( types ) {
		var ids = "";
		for( i = 0; i < types.length; i++ )
			for( j = 0; j < types[ i ].getItems.length; j++ )
				ids += types[ i ].getItems[ j ].id + ",";
		return ids;
	}