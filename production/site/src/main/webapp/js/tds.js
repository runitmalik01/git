
YAHOO.namespace("example.container");



YAHOO.util.Event.onDOMReady(function () {
	
	// Define various event handlers for Dialog
	var handleSubmit = function() {

		var objDT = myDataTable.getRecordSet().getRecords(); // put the entire object in the variable
		var sJSONDT = JSON.stringify(objDT);   // stringify object
		document.getElementById('hidDataTable').value = sJSONDT;   // put the value in the hidden variable 
			
		this.submit();  // submit form
	};
	var handleCancel = function() {
		this.cancel();       // cancel form
	};
	var handleSuccess = function(o) {
		var response = o.responseText;
		response = response.split("<!")[0];
		document.getElementById("resp").innerHTML = response;
	};
	var handleFailure = function(o) {
		alert("Submission failed: " + o.status);
	};

    // Remove progressively enhanced content class, just before creating the module
    YAHOO.util.Dom.removeClass("dialog1", "yui-pe-content");

	// Instantiate the Dialog
	YAHOO.example.container.dialog1 = new YAHOO.widget.Dialog("dialog1", 
							{ width : "45em",
							  fixedcenter : true,
							  visible : false, 
							  constraintoviewport : true,
							  buttons : [ { text:"Submit", handler:handleSubmit, isDefault:true },
								      { text:"Cancel", handler:handleCancel } ]
							});

	
	// Wire up the success and failure handlers
	YAHOO.example.container.dialog1.callback = { success: handleSuccess,
						     failure: handleFailure };
	
	// Render the Dialog
	YAHOO.example.container.dialog1.render();

	YAHOO.util.Event.addListener("showtds", "click", YAHOO.example.container.dialog1.show, YAHOO.example.container.dialog1, true);
	YAHOO.util.Event.addListener("hidetds", "click", YAHOO.example.container.dialog1.hide, YAHOO.example.container.dialog1, true);
});









