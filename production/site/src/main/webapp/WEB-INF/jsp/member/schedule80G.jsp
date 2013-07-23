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
  - Date:
  -Description: It contains the code for the yui grid to take the details for self Assessment Tax and Advance Tax payments. 
  --%>

<%@include file="../includes/commonincludes.jspf" %>

<div>
	<fmt:message key="schedule80G" />
</div>
<br>
<fmt:message key="schedule80G.statment1" />
<br>
<div id="buttons">
	<span id="addrowsbsr" class="yui-button yui-push-button"> <span
		class="first-child">
			<button type="button">Add Donation Detail</button>
	</span>
	</span> <span id="deleterows" class="yui-button yui-push-button"> <span
		class="first-child">
			<button type="button" id="deletebuttn">Delete Donation
				Detail</button>
	</span>
	</span>

</div>

<%-- Here code start for yui grid which take data in it --%>
<div id="cell"></div>
<hst:actionURL var="actionUrl" />
<form method="post" action="${actionUrl}">
	<input type="hidden" name="hidDataTable" id="hidDataTable" value=" " />

	<%-- starting of script for datatable --%>
	<script type="text/javascript">
function test(mydata,i) {
	var len = myDataTable.getRecordSet().getLength();
	var precord = YAHOO.widget.DataTable._cloneObject(mydata);
	precord.row = i;
	
	myDataTable.addRow(precord);
};
var deleteRadio=false;
var sr=1;
var oRecord = 0;
var objFetchValue =<%=request.getAttribute("objArray")%>;    	
var data = {NameA:"",AddressA:"",CityA:"",StateCodeA:"",PINCodeA:"",DoAmountA:"",LimitA:"",DeAmountA:"",radio:""};
	<%--start of code for defining the formatter of currency --%>

	var fmtNegCurrency = function(elCell, oRec, oCol, oData) {
 	var num_prefix='';
	if ( oData < 0.0 ) {
      		num_prefix = alert("Please enter a positive number");
			elCell.innerHTML = num_prefix+"0" ;
       		elCell.innerHTML ="0";
    				}
	else{
			var fmtCurrency = {   
       		prefix : ' ', 
	 		negativeFormat : null,   
       		thousandsSeparator: ',',
       		decimalSeparator: '.',    
       		decimalPlaces: 2                                       
   		    };
 	var num_fmt = YAHOO.util.Number.format( oData, fmtCurrency );
	elCell.innerHTML =  num_fmt;
	
if(num_fmt!="0.00"){
	
      myDataTable.updateCell(oRec,"DeAmountA",num_fmt,true);
      var totalA=0;
      for(var m=0;m<myDataTable.getRecordSet().getLength();m++){
    	  var upRecord = myDataTable.getRecord(m);
    	  totalA=parseInt(totalA)+parseInt(upRecord.getData("DoAmountA"));
      }
      if(isNaN(totalA)){
          totalA="0";
                 }
	      document.getElementById("totalA").value=totalA;             
                }
		}
	};
	<%--end of code for defining the formatter of currency --%>

	<%--end of code for defining the formatter of date --%>

	<%--start of code for defining column keys of datatable --%>						
	var myColumnDefs = [
	              			{key:"rows",resizeable:false,sortable:true,hidden:true},
							{key:"radio", formatter:"radio"},  
				  			{key:"NameA",label:"Name",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
				  			{key:"AddressA",label:"Address",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})}, 
	             			{key:"CityA",label:"City",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"StateCodeA",label:"StateCode",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"PINCodeA",label:"PINCode",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"DoAmountA",label:"Amount of <br/> Donation(Rs.)",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true,validator:YAHOO.widget.DataTable.validateNumber},{disableBtns:true}),formatter:fmtNegCurrency},
	             			{key:"LimitA",label:"Limit",resizeable:false, editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:["Yes","No"],disableBtns:true})},
	             			{key:"DeAmountA",label:"Deduction <br/>Amount(Rs.)",resizeable:false}
	             
	         	 ];
			<%--end of code for defining column keys of datatable --%>
	         
			<%-- code for defining datasource of datatable --%>
	          var myDataSource = new YAHOO.util.DataSource([]);
	          myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
	          myDataSource.responseSchema = {
	              			fields: ["NameA","radio" ,"AddressA","CityA","StateCodeA","PINCodeA","DoAmountA","LimitA","DeAmountA"]
	         								 };
	    		
	    		<%--creating object of datatable --%>
	        var myDataTable = new YAHOO.widget.DataTable("cell",        
	               										myColumnDefs, myDataSource, {});	        	       
	         // Set up editing flow
        	var highlightEditableCell = function(oArgs) {
			
            var elCell = oArgs.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
		 };
		 <%--subscribing various events to occur with datatble --%>
        myDataTable.subscribe("cellMouseoverEvent", highlightEditableCell);
        myDataTable.subscribe("cellMouseoutEvent", myDataTable.onEventUnhighlightCell);
        myDataTable.subscribe("cellClickEvent", myDataTable.onEventShowCellEditor);
/* Start of change by Satyam to allow for keyboard navigation */

			myDataTable.subscribe("editorKeydownEvent",function(oArgs) {
				var self = this,
					ed = this._oCellEditor,  // Should be: oArgs.editor, see: http://yuilibrary.com/projects/yui2/ticket/2513909
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
                  var showTimer,hideTimer;
                var tt = new YAHOO.widget.Tooltip("myTooltip");
			
			myDataTable.on('cellMouseoverEvent', function (oArgs) {
				if (showTimer) {
					window.clearTimeout(showTimer);
					showTimer = 0;
				}

				var target = oArgs.target;
				var column = this.getColumn(target);
				if (column.key == 'CityA') {
					var record = this.getRecord(target);
					var description = 'Please Enter Name of City';
					var xy = [parseInt(oArgs.event.clientX,10)+2 ,parseInt(oArgs.event.clientY,10)+2];

					showTimer = window.setTimeout(function() {
						tt.setBody(description);
						tt.cfg.setProperty('xy',xy);
						tt.show();
						hideTimer = window.setTimeout(function() {
							tt.hide();
						},5000);
					},500);
				}
			});
                 myDataTable.on('cellMouseoutEvent', function (oArgs) {
				if (showTimer) {
					window.clearTimeout(showTimer);
					showTimer = 0;
				}
				if (hideTimer) {
					window.clearTimeout(hideTimer);
					hideTimer = 0;
				}
				tt.hide();
			});
        <%-- this event is used to get the value of a selected rows by clicking a radio button so that we can delete it.--%>
        myDataTable.subscribe("radioClickEvent", function(oArgs){ 
		
                if(lastSelectedRadioRecord) {
                   		lastSelectedRadioRecord.setData("radio",false);
                							}
            var elRadio = oArgs.target;
            var oRecord = this.getRecord(elRadio);
                oRecord.setData("radio",true);
				deleteRadio=true;
                lastSelectedRadioRecord = oRecord;
	       
			});
			var i=1,
	            bReverseSorted = false;

	        // Track when Column is reverse-sorted, since new data will come in out of order
	        var trackReverseSorts = function(oArg) {
	            bReverseSorted = (oArg.dir === YAHOO.widget.DataTable.CLASS_DESC);
	          
	        };
	        myDataTable.subscribe("columnSortEvent", trackReverseSorts);
	          <%-- Add one rows to the bottom  --%> 
	       	var btnAddRw = new YAHOO.widget.Button("addrowsbsr"); 
			
	        	btnAddRw.on("click", function() { 
					
<%--start of code for validation that if all the fields of a row are filled --%>

			var len = myDataTable.getRecordSet().getLength(); 
				if(len>0){
				deleteFlag=true;
						}
				if(len>0)
		{           oRecord = myDataTable.getRecord(len-1);
					var nameA=oRecord.getData("NameA");
					var addressA=oRecord.getData("AddressA");
					var cityA=oRecord.getData("CityA");
					var statecodeA=oRecord.getData("StateCodeA");
					var pincodeA=oRecord.getData("PINCodeA");
					var doamountA=oRecord.getData("DoAmountA");
					var limitA=oRecord.getData("LimitA");
					var deamountA=oRecord.getData("DeAmountA");

				<%--add row if it is not first row and all previous row are filled --%>
			if(!(nameA == null|| nameA == " "&& addressA ==null ||addressA==" "&& cityA==null || cityA==" " && pincodeA==null || pincodeA==" " &&statecodeA==null||statecodeA==" "&& doamountA==0 ||doamountA==null&&deamountA==0||deamountA==null))
			{
				record = YAHOO.widget.DataTable._cloneObject(data);			
				record.rows = i++; 
				this.myDataTable.addRow(record);
			}
			else
			{
				alert("Can't Add Row.Please Enter All Info");
			}
	 }	else
				{
		<%--add row if it is first row --%>
					oRecord = myDataTable.getRecord(0);
					records = YAHOO.widget.DataTable._cloneObject(data);
					records.rows = i++; 
					records.SNo = sr++;
					this.myDataTable.addRow(records);	

				}
		},this,true); 

    	</script>

	<%--Following script is used for confirm deletion of a row --%>
	<script>
		YAHOO.namespace("example.container");
		var lastSelectedRadioRecord = null;  
		function initbsr() 
			{
	
				// Define various event handlers for Dialog
					var handleYes = function() 
						{
						<%--start of code for updating the serial number after delete a row --%>
								var rowsIndex= lastSelectedRadioRecord.getData("rows"); 								
								if(rowsIndex>=0)
									{
                                    var delamount1= lastSelectedRadioRecord.getData("DeAmountA");					
									var delamount2=document.getElementById("totalA").value;
									document.getElementById("totalA").value=parseInt(delamount2)-parseInt(delamount1);
									var totalvalue=document.getElementById("totalvalue").value;
									document.getElementById("totalvalue").value=parseInt(totalvalue)-parseInt(delamount1);
								    myDataTable.deleteRow(lastSelectedRadioRecord);                     
									}
							lastSelectedRadioRecord=null;
							deleteRadio==false;
							this.hide();
					}; // end update row
				//rowsIndex=null;
				var handleNo = function() {
				this.hide();
				};
				function check(){
				
				len = myDataTable.getRecordSet().getLength(); 
				if(len>0 && deleteRadio==true )
					{
							// Instantiate the Dialog
							YAHOO.example.container.simpledialog1 = new YAHOO.widget.SimpleDialog("simpledialog1", 
																			 						{ width: "300px",
																			   							fixedcenter: true,
																			   							visible: false,
																			   							draggable: false,
																			   							close: true,
																			   							text: "Do you want to Delete?",
																			   							icon: YAHOO.widget.SimpleDialog.ICON_HELP,
																			   							constraintoviewport: true,
																			   							buttons: [ { text:"Yes", handler:handleYes, isDefault:true },
																						  				{ text:"No",  handler:handleNo } ]
																			 						} );
							YAHOO.example.container.simpledialog1.setHeader("Are you sure?");
	
							// Render the Dialog
							YAHOO.example.container.simpledialog1.render("deleterows");
							
							YAHOO.example.container.simpledialog1.show();
					}
					}
				<%--this listener will open the above dialog  --%>
				YAHOO.util.Event.addListener("deletebuttn", "click", check);
			}

		YAHOO.util.Event.addListener(window, "load", initbsr);
		</script>
	<br>
	<div></div>
	<c:if test="${empty documentg}">
		<input type="text" readonly="readonly" name="totalA" id="totalA"
			value="0" />
	</c:if>
	<c:if test="${not empty documentg }">
		<input type="text" readonly="readonly" name="totalA" id="totalA"
			value="${documentg.totalA }" />
	</c:if>
	<br>
	<fmt:message key="schedule80G.statment2" />
	<br>
	<div id="buttons">
		<span id="add" class="yui-button yui-push-button"> <span
			class="first-child">
				<button type="button">Add Donation Detail</button>
		</span>
		</span> <span id="deleterow" class="yui-button yui-push-button"> <span
			class="first-child">
				<button type="button" id="deletebutton">Delete Donation
					Detail</button>
		</span>
		</span>

	</div>

	<%-- Here code start for yui grid which take data in it --%>
	<div id="celledit"></div>

	<input type="hidden" name="hidDataTable1" id="hidDataTable1" value=" " />

	<%-- starting of script for datatable --%>
	<script type="text/javascript">
	function testB(mydataB,j) {
		var len = DTable.getRecordSet().getLength();
		var precordB = YAHOO.widget.DataTable._cloneObject(mydataB);
		precordB.row = j;
		
		DTable.addRow(precordB);
	};
	var deleteRadio1=false;
	var s=1;
	var oRec = 0;
	var objFetchValueB =<%=request.getAttribute("objArrayB")%>;
	var datas = {NameB:"",AddressB:"",CityB:"",StateCodeB:"",PINCodeB:"",DoAmountB:"",LimitB:"",DeAmountB:"",radio:""};
	<%--start of code for defining the formatter of currency --%>
	var fmtNegCurrency = function(elCell, oRec, oCol, oData) {
 	var num_prefix='';
	if ( oData < 0.0 ) {
      		num_prefix = alert("Please enter a positive number");
			elCell.innerHTML = num_prefix+"0" ;
       		elCell.innerHTML ="0";
    				}
	else{
			var fmtCurrency = {   
       		prefix : ' ', 
	 		negativeFormat : null,   
       		thousandsSeparator: ',',
       		decimalSeparator: '.',    
       		decimalPlaces: 2                                       
   		     };
 	var num_fmt = YAHOO.util.Number.format( oData, fmtCurrency );
 	elCell.innerHTML =  num_fmt;
 	if(num_fmt!="0.00"){
   
 	var deamt=YAHOO.util.Number.format(Math.round(parseInt(num_fmt.replace(",",""))/2), fmtCurrency );
 	      DTable.updateCell(oRec,"DeAmountB",deamt,true);
 	      var totalB="0";
 	      for(var m=0;m<DTable.getRecordSet().getLength();m++){
 	    	  var upRecord = DTable.getRecord(m);

 	    	  totalB=parseInt(totalB)+Math.round(parseInt(upRecord.getData("DoAmountB"))/2);
 	      }
 	      if(isNaN(totalB)){
 	          totalB="0";
 	                 }
 		      document.getElementById("totalB").value=totalB;             
 	                }
		}
	};
	<%--end of code for defining the formatter of currency --%>
	
	<%--end of code for defining the formatter of date --%>

	<%--start of code for defining column keys of datatable --%>						
	var ColumnDefs = [
	              			{key:"rows",resizeable:false,sortable:true,hidden:true},
							{key:"radio", formatter:"radio"},  
				  			{key:"NameB",label:"Name",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
				  			{key:"AddressB",label:"Address",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})}, 
	             			{key:"CityB",label:"City",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"StateCodeB",label:"StateCode",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"PINCodeB",label:"PINCode",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"DoAmountB",label:"Amount of<br/>Donation(Rs.)",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true,validator:YAHOO.widget.DataTable.validateNumber},{disableBtns:true}),formatter:fmtNegCurrency},
	             			{key:"LimitB",label:"Limit",resizeable:false, editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:["Yes","No"],disableBtns:true})},
	             			{key:"DeAmountB",label:"Deduction<br/>Amount(Rs.)",resizeable:false}
	             
	         	 ];
			<%--end of code for defining column keys of datatable --%>
	         
			<%-- code for defining datasource of datatable --%>
	          var DataSource = new YAHOO.util.DataSource([]);
	          DataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
	          DataSource.responseSchema = {
	              			fields: ["NameB","radio","AddressB","CityB","StateCodeB","PINCodeB","DoAmountB","LimitB","DeAmountB"]
	         								 };
	    		
	    		<%--creating object of datatable --%>
	        var DTable = new YAHOO.widget.DataTable("celledit",        
	               										ColumnDefs, DataSource, {});
	        
	        

	         // Set up editing flow
        	var highlightEditableCell1 = function(oArgs1) {
			
            var elCell = oArgs1.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
		 };
		 <%--subscribing various events to occur with datatble --%>
        DTable.subscribe("cellMouseoverEvent", highlightEditableCell1);
        DTable.subscribe("cellMouseoutEvent", DTable.onEventUnhighlightCell);
        DTable.subscribe("cellClickEvent", DTable.onEventShowCellEditor);
/* Start of change by Satyam to allow for keyboard navigation */

			DTable.subscribe("editorKeydownEvent",function(oArgs1) {
				var self = this,
					ed = this._oCellEditor,  // Should be: oArgs.editor, see: http://yuilibrary.com/projects/yui2/ticket/2513909
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
        <%-- this event is used to get the value of a selected rows by clicking a radio button so that we can delete it.--%>
        DTable.subscribe("radioClickEvent", function(oArgs1){ 
		
                if(lastSelectRadio) {
                   		lastSelectRadio.setData("radio1",false);
                							}
            var elRadio1 = oArgs1.target;
            var oRec = this.getRecord(elRadio1);
                oRec.setData("radio1",true);
				deleteRadio1=true;
                lastSelectRadio = oRec;
	       
			});
			var k=0,
	            bReverseSorted = false;

	        // Track when Column is reverse-sorted, since new data will come in out of order
	        var trackReverseSorts = function(oArg) {
	            bReverseSorted = (oArg.dir === YAHOO.widget.DataTable.CLASS_DESC);
	          
	        };
	        DTable.subscribe("columnSortEvent", trackReverseSorts);
	          <%-- Add one rows to the bottom  --%> 
	       	var btnAddRw = new YAHOO.widget.Button("add"); 
			
	        	btnAddRw.on("click", function() { 					
			var len = DTable.getRecordSet().getLength(); 
				if(len>0){
				deleteFlag=true;
						}
				if(len>0)
		   {
				oRec = DTable.getRecord(len-1);
				var nameB=oRec.getData("NameB");
				var addressB=oRec.getData("AddressB");
				var cityB=oRec.getData("CityB");
				var statecodeB=oRec.getData("StateCodeB");
				var pincodeB=oRec.getData("PINCodeB");
				var doamountB=oRec.getData("DoAmountB");
				var limitB=oRec.getData("LimitB");
				var deamountB=oRec.getData("DeAmountB");
	
				
				<%--add row if it is not first row and all previous row are filled --%>
			if(!(nameB == null|| nameB == " "&& addressB ==null ||addressB==" "&& cityB==null || cityB==" " && pincodeB==null || pincodeB==" " &&statecodeB==null||statecodeB==" "&& doamountB==0 ||doamountB==null&&deamountB==0||deamountB==null))
			{
				rec = YAHOO.widget.DataTable._cloneObject(datas);
			
				rec.row =k++; 
				
				rec.SN = s++;
				
				this.DTable.addRow(rec);
			}
			else
			{
				alert("Can't Add Row.Please Enter All Info");
			}
	}	else
				{
		<%--add row if it is first row --%>
					oRec = DTable.getRecord(0);
					rec = YAHOO.widget.DataTable._cloneObject(datas);
					rec.row = k++; 												
					this.DTable.addRow(rec);	

				}
		},this,true); 

    	</script>

	<%--Following script is used for confirm deletion of a row --%>
	<script>
		YAHOO.namespace("example.container");
		var lastSelectRadio = null;  
		function init() 
			{
				
				// Define various event handlers for Dialog
					var handleYes = function() 
						{
			<%--start of code for updating the serial number after delete a row --%>
								var rowsInd= lastSelectRadio.getData("row"); 					  							
								if(rowsInd>=0)
									{
									var delamount1= lastSelectRadio.getData("DeAmountB");
									var delamount2=document.getElementById("totalB").value;
									document.getElementById("totalB").value=parseInt(delamount2)-parseInt(delamount1);
									var totalvalue=document.getElementById("totalvalue").value;
									document.getElementById("totalvalue").value=parseInt(totalvalue)-parseInt(delamount1);
									DTable.deleteRow(lastSelectRadio);                     
									}
								var size = DTable.getRecordSet().getLength();
							lastSelectRadio=null;
							deleteRadio1==false;
							this.hide();
					}; // end update row
				rowsInd=null;
				var handleNo = function() {
				this.hide();
				};
				function check1(){
				
				len = DTable.getRecordSet().getLength(); 
				if(len>0 && deleteRadio1==true )
					{
							// Instantiate the Dialog
							YAHOO.example.container.simpledialog1 = new YAHOO.widget.SimpleDialog("simpledialog1", 
																			 						{ width: "300px",
																			   							fixedcenter: true,
																			   							visible: false,
																			   							draggable: false,
																			   							close: true,
																			   							text: "Do you want to Delete?",
																			   							icon: YAHOO.widget.SimpleDialog.ICON_HELP,
																			   							constraintoviewport: true,
																			   							buttons: [ { text:"Yes", handler:handleYes, isDefault:true },
																						  				{ text:"No",  handler:handleNo } ]
																			 						} );
							YAHOO.example.container.simpledialog1.setHeader("Are you sure?");
	
							// Render the Dialog
							YAHOO.example.container.simpledialog1.render("deleterow");
							
							YAHOO.example.container.simpledialog1.show();
					}
				}
				<%--this listener will open the above dialog  --%>
				YAHOO.util.Event.addListener("deletebutton", "click", check1);
		}

	YAHOO.util.Event.addListener(window, "load", init);
	</script>
	<br>
	<c:if test="${empty documentg}">
		<input type="text" readonly="readonly" name="totalB" id="totalB"
			value="0" />
	</c:if>
	<c:if test="${not empty documentg }">
		<input type="text" readonly="readonly" name="totalB" id="totalB"
			value="${documentg.totalB }" />
	</c:if>
	<br>
	<fmt:message key="schedule80G.statment3" />
	<br>
	<div id="buttons">
		<span id="addC" class="yui-button yui-push-button"> <span
			class="first-child">
				<button type="button">Add Donation Detail</button>
		</span>
		</span> <span id="deleterowC" class="yui-button yui-push-button"> <span
			class="first-child">
				<button type="button" id="deletebuttonC">Delete Donation
					Detail</button>
		</span>
		</span>

	</div>

	<%-- Here code start for yui grid which take data in it --%>
	<div id="celleditC"></div>

	<input type="hidden" name="hidDataTable2" id="hidDataTable2" value=" " />

	<%-- starting of script for datatable --%>
	<script type="text/javascript">
	function testC(mydataC,k) {
		var len = DTableC.getRecordSet().getLength();
		var precordC = YAHOO.widget.DataTable._cloneObject(mydataC);
		precordC.row = k;
		
		DTableC.addRow(precordC);
	};
	var deleteRadioC=false;
	var s=1;
	var oRecC = 0;
	var objFetchValueC =<%=request.getAttribute("objArrayC")%>;
	var datasC = {NameC:"",AddressC:"",CityC:"",StateCodeC:"",PINCodeC:"",DoAmountC:"",LimitC:"",DeAmountC:"",radio:""};
	<%--start of code for defining the formatter of currency --%>
	var fmtNegCurrency = function(elCell, oRecC, oCol, oData) {
 	var num_prefix='';
	if ( oData < 0.0 ) {
      		num_prefix = alert("Please enter a positive number");
			elCell.innerHTML = num_prefix+"0" ;
       		elCell.innerHTML ="0";
    				}
	else{
			var fmtCurrency = {   
       		prefix : ' ', 
	 		negativeFormat : null,   
       		thousandsSeparator: ',',
       		decimalSeparator: '.',    
       		decimalPlaces: 2                                       
   		   };
 	var num_fmt = YAHOO.util.Number.format( oData, fmtCurrency );
	elCell.innerHTML =  num_fmt;  
	
		if (num_fmt != "0.00") {
                                   var deamt=YAHOO.util.Number.format(Math.round(parseInt(num_fmt.replace(",",""))/2), fmtCurrency );
					DTableC.updateCell(oRecC, "DeAmountC", deamt, true);
					var totalC = "0";
					for ( var m = 0; m < DTableC.getRecordSet().getLength(); m++) {
						var upRecord = DTableC.getRecord(m);
						totalC = parseInt(totalC)+ Math.round(parseInt(upRecord.getData("DoAmountC"))/2);
					}

					if (isNaN(totalC)) {
						totalC = "0";
					}
					document.getElementById("totalC").value = totalC;
				}
			}
		};
	<%--end of code for defining the formatter of currency --%>
	
	<%--end of code for defining the formatter of date --%>

	<%--start of code for defining column keys of datatable --%>						
	var ColumnDefs = [
	              			{key:"rows",resizeable:false,sortable:true,hidden:true},
							{key:"radio", formatter:"radio"},  
				  			{key:"NameC",label:"Name",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
				  			{key:"AddressC",label:"Address",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})}, 
	             			{key:"CityC",label:"City",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"StateCodeC",label:"StateCode",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"PINCodeC",label:"PINCode",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
	             			{key:"DoAmountC",label:"Amount of<br/>Donation(Rs.)",resizeable:false,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true,validator:YAHOO.widget.DataTable.validateNumber},{disableBtns:true}),formatter:fmtNegCurrency},
	             			{key:"LimitC",label:"Limit",resizeable:false, editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:["Yes","No"],disableBtns:true})},
	             			{key:"DeAmountC",label:"Deduction<br/>Amount(Rs.)",resizeable:false}
	             
	         	 ];
			<%--end of code for defining column keys of datatable --%>
	         
			<%-- code for defining datasource of datatable --%>
	          var DataSource = new YAHOO.util.DataSource([]);
	          DataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
	          DataSource.responseSchema = {
	              			fields: ["NameC","radio","AddressC","CityC","StateCodeC","PINCodeC","DoAmountC","LimitC","DeAmountC"]
	         								 };
	    		
	    		<%--creating object of datatable --%>
	        var DTableC = new YAHOO.widget.DataTable("celleditC",        
	               										ColumnDefs, DataSource, {});
	        
	        

	         // Set up editing flow
        	var highlightEditableCell1 = function(oArgs1C) {
			
            var elCell = oArgs1C.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
		 };
		 <%--subscribing various events to occur with datatble --%>
        DTableC.subscribe("cellMouseoverEvent", highlightEditableCell1);
        DTableC.subscribe("cellMouseoutEvent", DTableC.onEventUnhighlightCell);
        DTableC.subscribe("cellClickEvent", DTableC.onEventShowCellEditor);
/* Start of change by Satyam to allow for keyboard navigation */

			DTableC.subscribe("editorKeydownEvent",function(oArgs1C) {
				var self = this,
					ed = this._oCellEditor,  // Should be: oArgs.editor, see: http://yuilibrary.com/projects/yui2/ticket/2513909
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
        <%-- this event is used to get the value of a selected rows by clicking a radio button so that we can delete it.--%>
        DTableC.subscribe("radioClickEvent", function(oArgs1C){ 
		
                if(lastSelectRadioC) {
                   		lastSelectRadioC.setData("radio1C",false);
                							}
            var elRadio1C = oArgs1C.target;
            var oRecC = this.getRecord(elRadio1C);
                oRecC.setData("radio1C",true);
				deleteRadioC=true;
                lastSelectRadioC = oRecC;
	       
			});
			var k=0,
	            bReverseSorted = false;

	        // Track when Column is reverse-sorted, since new data will come in out of order
	        var trackReverseSorts = function(oArg) {
	            bReverseSorted = (oArg.dir === YAHOO.widget.DataTable.CLASS_DESC);
	          
	        };
	        DTableC.subscribe("columnSortEvent", trackReverseSorts);
	          <%-- Add one rows to the bottom  --%> 
	       	var btnAddRwC = new YAHOO.widget.Button("addC"); 
			
	        	btnAddRwC.on("click", function() { 					
			var lenC = DTableC.getRecordSet().getLength(); 
				if(lenC>0){
				deleteFlag=true;
						}
				if(lenC>0)
		   {
				oRecC = DTableC.getRecord(lenC-1);
				var nameC=oRecC.getData("NameC");
				var addressC=oRecC.getData("AddressC");
				var cityC=oRecC.getData("CityC");
				var statecodeC=oRecC.getData("StateCodeC");
				var pincodeC=oRecC.getData("PINCodeC");
				var doamountC=oRecC.getData("DoAmountC");
				var limitC=oRecC.getData("LimitC");
				var deamountC=oRecC.getData("DeAmountC");
	
				
				<%--add row if it is not first row and all previous row are filled --%>
			if(!(nameC == null|| nameC == " "&& addressC ==null ||addressC==" "&& cityC==null || cityC==" " && pincodeC==null || pincodeC==" " &&statecodeC==null||statecodeC==" "&& doamountC==0 ||doamountC==null&&deamountC==0||deamountC==null))
			{
				recC = YAHOO.widget.DataTable._cloneObject(datasC);
			
				recC.row =k++; 
				
				recC.SN = s++;
				
				this.DTableC.addRow(recC);
			}
			else
			{
				alert("Can't Add Row.Please Enter All Info");
			}
	}	else
				{
		<%--add row if it is first row --%>
					oRecC = DTableC.getRecord(0);
					recC = YAHOO.widget.DataTable._cloneObject(datasC);
					recC.row = k++; 												
					this.DTableC.addRow(recC);	

				}
		},this,true); 
    	</script>

	<%--Following script is used for confirm deletion of a row --%>
	<script>
		YAHOO.namespace("example.container");
		var lastSelectRadioC = null;  
		function initC() 
			{
				
				// Define various event handlers for Dialog
					var handleYes = function() 
						{
			<%--start of code for updating the serial number after delete a row --%>
								var rowsIndC= lastSelectRadioC.getData("row"); 					  
								
								if(rowsIndC>=0)
									{
									var delamount1= lastSelectRadioC.getData("DeAmountC");
									var delamount2=document.getElementById("totalC").value;
									document.getElementById("totalC").value=parseInt(delamount2)-parseInt(delamount1);
									var totalvalue=document.getElementById("totalvalue").value;
									document.getElementById("totalvalue").value=parseInt(totalvalue)-parseInt(delamount1);
								     DTableC.deleteRow(lastSelectRadioC);                     
									}
							lastSelectRadioC=null;
							deleteRadioC==false;
							this.hide();
					}; // end update row
				rowsIndC=null;
				var handleNo = function() {
				this.hide();
				};
				function check1C(){
				
				lenC = DTableC.getRecordSet().getLength(); 
				if(lenC>0 && deleteRadioC==true )
					{
							// Instantiate the Dialog
							YAHOO.example.container.simpledialog2C = new YAHOO.widget.SimpleDialog("simpledialog1", 
																			 						{ width: "300px",
																			   							fixedcenter: true,
																			   							visible: false,
																			   							draggable: false,
																			   							close: true,
																			   							text: "Do you want to Delete?",
																			   							icon: YAHOO.widget.SimpleDialog.ICON_HELP,
																			   							constraintoviewport: true,
																			   							buttons: [ { text:"Yes", handler:handleYes, isDefault:true },
																						  				{ text:"No",  handler:handleNo } ]
																			 						} );
							YAHOO.example.container.simpledialog2C.setHeader("Are you sure?");
	
							// Render the Dialog
							YAHOO.example.container.simpledialog2C.render("deleterowC");
							
							YAHOO.example.container.simpledialog2C.show();
					}
				}
				<%--this listener will open the above dialog  --%>
				YAHOO.util.Event.addListener("deletebuttonC", "click", check1C);
		}

	YAHOO.util.Event.addListener(window, "load", initC);
	</script>

	<br>
	<c:if test="${empty documentg}">
		<input type="text" readonly="readonly" name="totalC" id="totalC"
			value="0" />
	</c:if>
	<c:if test="${not empty documentg }">
		<input type="text" readonly="readonly" name="totalC" id="totalC"
			value="${documentg.totalC }" />
	</c:if>

	<br />

	<div>
		<table id="calculation">
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td width="200">&nbsp;</td>
				<td width="200" align="center">
					<div>
						<input type="button" name="calcvalue"
							value="    click to calculate     " id="calcvalue"
							onclick="calcamount()" width="30" height="40">
					</div>
				</td>
				<td><fmt:message key="schedule80G.statment4" /> <c:if
						test="${empty documentg }">
						<input type="text" name="totalvalue" value="0" id="totalvalue"
							readonly>
					</c:if> <c:if test="${not empty documentg }">
						<input type="text" name="totalvalue" value="${documentg.total }"
							id="totalvalue" readonly>
					</c:if></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr height="40px" align="center">
				<td class="submit fright" colspan="3" align="center"><input
					type="submit" value=" Submit " height="38px" width="90px"
					onclick="return checkDTSize()" /></td>
			</tr>
		</table>
	</div>
</form>

<script type="text/javascript">
		function calcamount(){
			var total=parseInt(document.getElementById("totalA").value)+parseInt(document.getElementById("totalB").value)+parseInt(document.getElementById("totalC").value);
			document.getElementById("totalvalue").value=total;
		};
		
	
			function checkDTSize() {
				var l = myDataTable.getRecordSet().getLength();
				var allowsubmit = document.getElementById("totalvalue").value;
				if (l > 0) {
					if (allowsubmit > 0) {
						stringify();
					} else {

						alert("Please click on calculate Deduction button");
					}
				} else {
					return true;
				}

			};
			function stringify() {
				var objDT = myDataTable.getRecordSet().getRecords(); // put the entire object in the variable
				var sJSONDT = JSON.stringify(objDT); // stringify object
				document.getElementById('hidDataTable').value = sJSONDT; // put the value in the hidden variable 
				var objDT1 = DTable.getRecordSet().getRecords();
				var sJSONDT1 = JSON.stringify(objDT1);
				document.getElementById('hidDataTable1').value = sJSONDT1;
				var objDT2 = DTableC.getRecordSet().getRecords();
				var sJSONDT2 = JSON.stringify(objDT2);
				document.getElementById('hidDataTable2').value = sJSONDT2;
			};
		</script>
		
<script type="text/javascript">
		if (typeof(objFetchValue) != 'undefined' && objFetchValue != null && objFetchValue.length > 0) {
			for (var i=0;i<objFetchValue.length;i++) {
				
				test(objFetchValue[i],i);				
			}
		}	
		if (typeof(objFetchValueB) != 'undefined' && objFetchValueB != null && objFetchValueB.length > 0) {
			for (var j=0;j<objFetchValueB.length;j++) {
				
				testB(objFetchValueB[j],j);				
			}
		}
		if (typeof(objFetchValueC) != 'undefined' && objFetchValueC != null && objFetchValueC.length > 0) {
			for (var k=0;k<objFetchValueC.length;k++) {
				
				testC(objFetchValueC[k],k);				
			}
		}
	</script>
