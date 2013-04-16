
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
    YAHOO.util.Dom.removeClass("dialog12", "yui-pe-content");

	// Instantiate the Dialog
	YAHOO.example.container.dialog12 = new YAHOO.widget.Dialog("dialog12", 
							{ width : "50em",
							  fixedcenter : true,
							  visible : false, 
							  constraintoviewport : true,
							  buttons : [ { text:"Submit", handler:handleSubmit, isDefault:true },
								      { text:"Cancel", handler:handleCancel } ]
							});

	
	// Wire up the success and failure handlers
	YAHOO.example.container.dialog12.callback = { success: handleSuccess,
						     failure: handleFailure };
	
	// Render the Dialog
	YAHOO.example.container.dialog12.render();

	YAHOO.util.Event.addListener("show", "click", YAHOO.example.container.dialog12.show, YAHOO.example.container.dialog12, true);
	YAHOO.util.Event.addListener("hide", "click", YAHOO.example.container.dialog12.hide, YAHOO.example.container.dialog12, true);
});









