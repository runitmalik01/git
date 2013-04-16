<%--

    Copyright (C) 2010 Hippo B.V.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%-- 
  - Author:Pankaj Singh
  - Date:2/18/2013
  -Description: It contains the code for the yui grid to take the details for Tax Deducted on Income other than Salary. 
  --%>

<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>

<%@include file="../includes/tags.jspf"%>


<%--these are the yui depandancies that should be added to use YUI --%>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/fonts/fonts-min.css" />
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/button/assets/skins/sam/button.css" />
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/container/assets/skins/sam/container.css" />
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.6.0/build/datatable/assets/skins/sam/datatable.css" />
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/calendar/assets/skins/sam/calendar.css" />


<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/connection/connection-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/element/element-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/button/button-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/dragdrop/dragdrop-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/container/container-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/calendar/calendar-min.js"></script>


<script type="text/javascript"
	src="http://yui.yahooapis.com/2.6.0/build/element/element-beta-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.6.0/build/datasource/datasource-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.6.0/build/datatable/datatable-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/event-delegate/event-delegate-min.js"></script>

<script type="text/javascript"
	src="http://yui.yahooapis.com/2.6.0/build/yuiloader/yuiloader.js"></script>
<!-- to use json utilities -->
<script src="http://yui.yahooapis.com/2.9.0/build/yahoo/yahoo-min.js"></script>
<script src="http://yui.yahooapis.com/2.9.0/build/json/json-min.js"></script>
<script type="text/javascript"
	src="http://yui.yahooapis.com/combo?2.9.0/build/yahoo-dom-event/yahoo-dom-event.js&2.9.0/build/calendar/calendar-min.js"></script>



<div>
	<b><fmt:message key="member.tds.from.others" /><b> <br> <br>
			<br>
</div>

<div id="buttons">
	<span id="addrow" class="yui-button yui-push-button"> <span
		class="first-child">
			<button type="button">Add one row</button> </span> </span> <span id="deleterow"
		class="yui-button yui-push-button"> <span class="first-child">
			<button type="button" id="deletebutton">Delete a row</button> </span> </span>
</div>
<%-- Here code start for yui grid which take data in it --%>

<div id="paginated"></div>
<hst:actionURL var="actionUrl" />
<form method="post" action="${actionUrl}">
	<%-- form tag to put the datatable in it --%>
	<input type="hidden" name="hidDataTable" id="hidDataTable" value=" " />
	<%--declare  a hidden varaible to pass the json string to java --%>

	<%-- starting of script for datatable --%>
	<script type="text/javascript">
		function test(mydata, i) {
			var len = myDataTable.getRecordSet().getLength();
			var precord = YAHOO.widget.DataTable._cloneObject(mydata);
			precord.row = i;

			myDataTable.addRow(precord);
		}

		var deleteRadio = false;
		var si = 1;
		var total1=0;
	<%-- in the below statement json array(formed by taking values from repository in java) of objects is assigned to a variable   --%>
		var objFetchValue =
	<%=request.getAttribute("objArray")%>
		;
		var data = {
			TANDeductor : "",
			NameDeductor : "",
			TaxDeducted : "",
			Amountclaimed : "",
			radio : ""
		}

	<%-- assigning values fetched from repository to datatable in case of fetching --%>
		//var data = objFetchValue;
	<%--start of code for defining the formatter of currency --%>
		var formatCurrency = function(elCell, oRec, oCol, oData) {
			var num_prefix = '';
			if (oData < 0.0) {
				num_prefix = alert("Please enter a positive number");
				elCell.innerHTML = num_prefix + "0";
				elCell.innerHTML = "0";
			} else {
				var fmtCurrency = {
					prefix : ' ',
					negativeFormat : null,
					thousandsSeparator : '',
					decimalSeparator : '.',
					decimalPlaces : 2
				}
				var num_fmt = YAHOO.util.Number.format(oData, fmtCurrency);
				elCell.innerHTML = num_fmt;
				
				if (num_fmt != "0.00") {
    				 myDataTable.updateCell(oRec, "Amountclaimed", num_fmt, true);
    				 var total=0;
    				 for(var m=0;m<myDataTable.getRecordSet().getLength();m++){
    				       var upRecord = myDataTable.getRecord(m);
    				       total=parseInt(total)+parseInt(upRecord.getData("Amountclaimed"));
    				      }
    				 document.getElementById("totalvalue").value = total;
    		}

     
			}
		}
		var formatIncome = function(elCell, oRec, oCol, oData) {
			var num_prefix = '';
			if (oData < 0.0) {
				num_prefix = alert("Please enter a positive number");
				elCell.innerHTML = num_prefix + "0";
				elCell.innerHTML = "";
			} else {
				var fmtCurrency = {
					prefix : ' ',
					negativeFormat : null,
					thousandsSeparator : '',
					decimalSeparator : '.',
					decimalPlaces : 2
				}
				var num_fmt = YAHOO.util.Number.format(oData, fmtCurrency);
				elCell.innerHTML = num_fmt;

			}
		} // end format for currency

		var myColumnDefs = [ {
			key : "row",
			resizeable : true,
			sortable : true,
			hidden : true
		}, {
			key : "radio",
			formatter : "radio"
		},

		{
			key : "TANDeductor",
			label : "Tax Deduction<br> Account Number<br>(TAN) of Deductor",
			 Description:"Please Enter first four capital Alphabets next five digits and last alphabet",
			resizeable : true,
			editor : new YAHOO.widget.TextboxCellEditor({
				disableBtns : true
			}),
			formatter : function(el, oRecord, oColumn, oData) {
				el.innerHTML = oData;
				if (oData.length != 0) {
					if (/^[A-Z]{4}\d{5}[A-Z]$/.test(oData)) {
					} else {
						alert("Please enter a valid TAN");
						el.innerHTML = "";
					}
				}
			}
		}, {
			key : "NameDeductor",
			label : "Name of the<br> Deductor",
			Description:"Please enter name in not more than 125 characters",
			resizeable : true,
			editor : new YAHOO.widget.TextboxCellEditor({
				disableBtns : true
			}),

			formatter : function(el, oRecord, oColumn, oData) {
				el.innerHTML = oData;
				if (oData.length != 0) {
					if (/^(([a-zA-Z])*(\s)*([a-zA-z])*)*$/
							.test(oData)) {
						if (oData.length > 125) {
							alert("Can not Enter More than 125 Characters");
							el.innerHTML = "";
						}
					} else {
						alert("Please enter Alphabets Only");
						el.innerHTML = "";
					}
				}
			}
		},

		{
			key : "TaxDeducted",
			label : "Total tax<br> Deducted<br>(Rs.)",
			Description:"Please enter only Numeric Value",
			resizeable : true,
			editor : new YAHOO.widget.TextboxCellEditor({
				disableBtns : true,
				validator : YAHOO.widget.DataTable.validateNumber
			}),
			formatter : formatCurrency
		}, {
			key : "Amountclaimed",
			label : "Amount out<br> of claimed(3)<br> for this Year<br>(Rs.)",
			Description:"Please enter only Numeric Value",
			resizeable : true
			
		} ];

		var myDataSource = new YAHOO.util.LocalDataSource(data);
		myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
		myDataSource.responseSchema = {
			fields : [ "radio", "TANDeductor", "NameDeductor", "TaxDeducted",
					"Amountclaimed" ]

		};
	<%-- creating object of datatable  --%>
		var myDataTable = new YAHOO.widget.DataTable("paginated", myColumnDefs,
				myDataSource, {});

		// Set up editing flow                                    
		var highlightEditableCell = function(oArgs) {

			var elCell = oArgs.target;
			if (YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
				this.highlightCell(elCell);
			}

		};
	<%-- subscribing events for datatable --%>
		myDataTable.subscribe("cellMouseoverEvent", highlightEditableCell);
		myDataTable.subscribe("cellMouseoutEvent",
				myDataTable.onEventUnhighlightCell);
		myDataTable.subscribe("cellClickEvent",
				myDataTable.onEventShowCellEditor);
		
		
		<%--Start of code to make the grid keyboard friendly --%>
		
		myDataTable.subscribe("editorKeydownEvent",function(oArgs) {
			var self = this,
				ed = this._oCellEditor,  
				ev = oArgs.event,
				KEY = YAHOO.util.KeyListener.KEY,
				Textbox = YAHOO.widget.TextboxCellEditor,
				Textarea = YAHOO.widget.TextareaCellEditor,
				cell = ed.getTdEl(),
				col = ed.getColumn(),
				row,rec,
				
				editNext = function(cell) {
					cell = self.getNextTdEl(cell);
					while (cell && !self.getColumn(cell).editor) {
						cell = self.getNextTdEl(cell);
					}
					if (cell) {
						self.showCellEditor(cell);
					}
				},
				editPrevious = function(cell) {
					cell = self.getPreviousTdEl(cell);
					while (cell && !self.getColumn(cell).editor) {
						cell = self.getPreviousTdEl(cell);
					}
					if (cell) {
						self.showCellEditor(cell);
					}
				};
				
			switch (ev.keyCode) {
				case KEY.UP:
					if (ed instanceof Textarea) { return; }
					YAHOO.util.Event.stopEvent(ev);
					ed.save();
					row = this.getPreviousTrEl(cell);
					if (row) {
						rec = this.getRecord(row);
						this.showCellEditor({record:rec,column:col});
					}
					break;
				case KEY.DOWN:
					if (ed instanceof Textarea) { return; }
					YAHOO.util.Event.stopEvent(ev);
					ed.save();
					row = this.getNextTrEl(cell);
					if (row) {
						rec = this.getRecord(row);
						this.showCellEditor({record:rec,column:col});
					}
					break;
				case KEY.LEFT:
					if (ed instanceof Textbox || ed instanceof Textarea) { return; }
					YAHOO.util.Event.stopEvent(ev);
					ed.save();
					editPrevious(cell);
					break;
				case KEY.RIGHT:
					if (ed instanceof Textbox || ed instanceof Textarea) { return; }
					YAHOO.util.Event.stopEvent(ev);
					ed.save();
					editNext(cell);
					break;
				case KEY.TAB:
					YAHOO.util.Event.stopEvent(ev);
					ed.save();
					if (ev.shiftKey) {
						editPrevious(cell);
					} else {
						editNext(cell);
					}
					break;
			}
		});
		
		// End of key handling
		
		// The following code tries to keep the cell editor visible at all times.
		
		myDataTable.on('editorShowEvent', function (oArgs) {
			var Dom = YAHOO.util.Dom;
			var el = oArgs.editor.getContainerEl();
			var reg = Dom.getRegion(el);
			var topScreen = Dom.getDocumentScrollTop(),
				bottomScreen = topScreen + Dom.getViewportHeight();
			if (reg.top < topScreen) {
				el.scrollIntoView();
			}
			if (reg.bottom > bottomScreen) {
				el.scrollIntoView(false);
			}
		});
		
		<%--code ends here to make grid keyboard friendly --%>
	<%-- this event is used to get the value of a selected row by clicking a radio button so that we can delete it. --%>
		myDataTable.subscribe("radioClickEvent", function(oArgs) {
			if (lastSelectedRadioRecord) {
				lastSelectedRadioRecord.setData("radio", false);
			}

			var elRadio = oArgs.target;

			var oRecord = this.getRecord(elRadio);

			oRecord.setData("radio", true);
			deleteRadio = true;
			lastSelectedRadioRecord = oRecord;

		});
		var i = 1, bReverseSorted = false;
	<%--Track when Column is reverse-sorted, since new data will come in out of order --%>
		var trackReverseSorts = function(oArg) {
			bReverseSorted = (oArg.dir === YAHOO.widget.DataTable.CLASS_DESC);

		};
		myDataTable.subscribe("columnSortEvent", trackReverseSorts);
	<%--Add one row to the bottom --%>
		var btnAddRow = new YAHOO.widget.Button("addrow");
		btnAddRow
				.on(
						"click",
						function() {
	<%--in this function various flags are used to check and allow if previous row is filled --%>
		var len = myDataTable.getRecordSet().getLength();
	<%--Add row without any condition because it is first row --%>
		oRecord = myDataTable.getRecord(0);

							record = YAHOO.widget.DataTable._cloneObject(data);
							record.row = i++;
							this.myDataTable.addRow(record);

						}, this, true);

	</script>
	<%--This portion is used to show dialog to confirm deletion of a row  --%>
	<script>
		YAHOO.namespace("example.container");

		var lastSelectedRadioRecord = null;
		function init() {

			// Define various event handlers for Dialog
			var handleYes = function() {

				var rowIndex = lastSelectedRadioRecord.getData("row");
				if (rowIndex >= 0) {
	<%--Following 4 lines are used to edit total of last column if user delete one row --%>
		var delamount1 = lastSelectedRadioRecord
							.getData("TaxDeducted");
					var delamount2 = document.getElementById("totalvalue").value
					var delamount = delamount2 - delamount1;
					document.getElementById("totalvalue").value = delamount;
					myDataTable.deleteRow(lastSelectedRadioRecord);

				}
				lastSelectedRadioRecord = null;

				this.hide();
			};
			var handleNo = function() {
				this.hide();
			};
			function check1() {
				len = myDataTable.getRecordSet().getLength();
				if (len > 0 && deleteRadio == true) {
	<%--This is dialog body open when click on delete button --%>
		YAHOO.example.container.simpledialog1 = new YAHOO.widget.SimpleDialog(
							"simpledialog1", {
								width : "300px",
								fixedcenter : true,
								visible : false,
								draggable : false,
								close : true,
								text : "Do you want to continue?",
								icon : YAHOO.widget.SimpleDialog.ICON_HELP,
								constraintoviewport : true,
								buttons : [ {
									text : "Yes",
									handler : handleYes,
									isDefault : true
								}, {
									text : "No",
									handler : handleNo
								} ]
							});
					YAHOO.example.container.simpledialog1
							.setHeader("Are you sure?");

					// Render the Dialog
					YAHOO.example.container.simpledialog1.render("deleterow");
					YAHOO.example.container.simpledialog1.show();

				}
			}
			YAHOO.util.Event.addListener("deletebutton", "click", check1);
		}

		YAHOO.util.Event.addListener(window, "load", init);
	</script>

	<div>
		<table width="600">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><b>
				<fmt:message key="total.amount.claimed.tdsothers" />
					</b></td>
		
					

					</td>
			<td><c:if test="${not empty objfetchtdsfromothers}">
						<input type="text" name="totalvalue"
							value="${objfetchtdsfromothers.total_Value}" id="totalvalue" readonly>
					</c:if> <c:if test="${empty objfetchtdsfromothers}">
						<input type="text" name="totalvalue" value="" id="totalvalue"
							readonly>
					</c:if></td>
					
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr height="40px" align="center">
				
					<td align="right"><button onclick="stringify()">Save</a></button></td>
					<td align="left"> <button> <a href="/site/interest">Skip</a></button></td>
			</tr>
		</table>
	</div>
</form>

<script>
	// This function checks either entries are filled if filled then allow submit

<%--Following function is used send data of grid to server after stringify it using hidden variable --%>
	function stringify() {
		var objDT = myDataTable.getRecordSet().getRecords();
		var sJSONDT = JSON.stringify(objDT);
<%--put the value in the hidden variable  --%>
	document.getElementById('hidDataTable').value = sJSONDT;
	}
</script>

<hst:headContribution keyHint="seedFile" category="jsExternal">
	<script src="http://yui.yahooapis.com/3.8.0/build/yui/yui-min.js"
		type="text/javascript"></script>
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet" href='<hst:link path="/css/tdsfromothers.css"/>'
		type="text/css" />
</hst:headContribution>

<script>
	if (typeof (objFetchValue) != 'undefined' && objFetchValue != null
			&& objFetchValue.length > 0) {
		for ( var i = 0; i < objFetchValue.length; i++) {

			test(objFetchValue[i], i);
		}
	}
</script>



