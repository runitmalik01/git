/**
*  Controller function for UMBrowse functionality
*
*  author Pavel Sukharuchanka
*/

function onSelectUMBrowseSegment(selectedNodeId) {
	transmitAndSubmit( getSelectionsWithoutItem(selectedNodeId) + selectedNodeId );
}

function onSelectUMBrowseDDL(selectedNodeId) {
	selections = getSelections();

	typePrefix = selectedNodeId.substring(0, selectedNodeId.indexOf("_"));

	result = "";
	for ( ind=0; ind<selections.length; ind++ ) {
		if ( selections[ind].length > 0 && selections[ind].indexOf(typePrefix) != 0 )
			result += selections[ind] + ",";
	}

	result += selectedNodeId;

	transmitAndSubmit( result );
}

function transmitAndSubmit( umBrowseSelection ) {
	submForm = getSearchForm(); 
	submForm.appendChild( createInput("UMBrowseSelection", umBrowseSelection) );
	submForm.action = "msbrowse.do";
	submForm.target = "";
	submForm.submit();
}

function getSearchForm(namePrefix) {
	formNamePrefix = "searchForm";
	if ( !getIsGuidedSearchActive() )
		formNamePrefix = "expertForm";

	submForm = null;

	for ( ind=0; ind < document.forms.length; ind++ )
		if ( document.forms[ind].name.indexOf(formNamePrefix)==0 ) {
			submForm = document.forms[ind];
			break;
		}

	return submForm;
}

function setUpUmBrowse( searchForm ) {
	umBrowseForm = document.forms["umbrowse"];
	selections = umBrowseForm["UMBrowseSelection"].value;

	searchForm.appendChild( createInput("UMBrowseSelection", selections) );
}

function clickBreadcrumb( itemId ) {
	selections = getSelections();

	resultSelection = "";
	buildSelection = true;
	for (ind=0; ind<selections.length; ind++) {
		if ( buildSelection )
			resultSelection += selections[ind] + ",";

		if ( selections[ind] == itemId || selections[ind] == '' ) {
			buildSelection = false;
			continue;
		}

		if ( !buildSelection )
			removeItemFromSEP( selections[ind] );
	}

	transmitAndSubmit( resultSelection );
}

function deleteBreadcrumb( itemId ) {
	removeItemFromSEP( itemId );
	transmitAndSubmit( getSelectionsWithoutItem( itemId ) );
}

function removeItemFromSEP(itemId) {
	submForm = getSearchForm();

	for (ind=0; ind<submForm.elements.length; ind++) {
		inputObject = submForm.elements[ind];

		if ( inputObject.multiple && inputObject.options ) { // it is a select object
			for (q=0; q<inputObject.options.length; q++ )
				if ( inputObject.options[q].value == itemId )
					inputObject.options[q].selected = false;
		} else {
			paramValue = inputObject.value;

			if ( paramValue.indexOf(itemId) >= 0 ) {
				while ((itemIndex = paramValue.indexOf(itemId)) >= 0) {
					paramValue = paramValue.substring(0, itemIndex)	+
								 paramValue.substring(itemIndex+itemId.length, paramValue.length);
				}

				inputObject.value = paramValue;
			}
		}
	}
}

function getSelections() {
	umBrowseForm = document.forms["umbrowse"];
	return umBrowseForm["UMBrowseSelection"].value.split(",");
}

function getSelectionsWithoutItem( itemId ) {
	selections = getSelections();

	result = "";
	for (ind=0; ind<selections.length; ind++) {
		if ( selections[ind].length > 0 && selections[ind] != itemId )
			result += selections[ind] + ",";
	}

	return result;
}

function createInput(name, value) {
	var obj = document.createElement("input");
	obj.name = name;
	obj.type = "hidden";
	obj.value = value;

	return obj;
}