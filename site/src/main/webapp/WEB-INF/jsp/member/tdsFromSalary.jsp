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
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="tdsfromothers" siteMapItemRefId="tdsfromothers"></hst:link>


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
	<b><fmt:message key="member.tds.from.salary" /><b> <br> <br>
			<br>
</div>






<!--BEGIN SOURCE CODE FOR EXAMPLE =============================== -->

<div id="buttons">
	<span id="addrowtdssalary" class="yui-button yui-push-button"> <span
		class="first-child">
			<button type="button">Add TDS Detail</button> </span> </span> <span id="deleterow"
		class="yui-button yui-push-button"> <span class="first-child">
			<button type="button" id="deletebutton">Delete TDS Detail</button> </span> </span>

</div>

<%-- This is the script used for ask to ensure delete row --%>
<div id="cellsalary"></div>
<hst:actionURL var="actionUrl" />
<form method="post" action="${actionUrl}">
	<%-- form tag to put the datatable in it --%>
	<input type="hidden" name="hidDataTable" id="hidDataTable" value=" " />
	<%--declare  a hidden varaible to pass the json string to java --%>

	<%-- starting of script for datatable --%>
	<script type="text/javascript">
function test(mydata,i) {
	var len = myDataTable.getRecordSet().getLength();
	var precord = YAHOO.widget.DataTable._cloneObject(mydata);
	precord.row = i;
	
	myDataTable.addRow(precord);
}

var deleteRadio=false;
var total1=0;
var field=0;
				var data = {radio:"",TAN:"",employer:"",Incomechargeable:"",taxdeducted:"0"};
					var objFetchValue =<%=request.getAttribute("objArray")%>;
				var formatCurrency = function(elCell, oRec, oCol, oData) {
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
       			thousandsSeparator: '',
       			decimalSeparator: '.',    
       			decimalPlaces: 2                                       
   					}
 	var num_fmt = YAHOO.util.Number.format( oData, fmtCurrency );
	elCell.innerHTML =  num_fmt;  
		}
	}



		var formatIncome = function(elCell, oRec, oCol, oData) {
 		var num_prefix='';
		if ( oData < 0.0 ) {
       // YAHOO.util.Dom.setStyle(elCell,'color','red');
       num_prefix = alert("Please enter a positive number");
		elCell.innerHTML = num_prefix+"0" ;
        elCell.innerHTML ="0";
    		}
		else{
		var fmtCurrency = {   
       				prefix : '', 
	 				negativeFormat : null,   
       				thousandsSeparator: '',
       				decimalSeparator: '.',    
       				decimalPlaces: 2                                       
   			}
 		var num_fmt = YAHOO.util.Number.format( oData, fmtCurrency );
		elCell.innerHTML =  num_fmt; 
		
			}
		}
		var formatIncome1 = function(elCell, oRec, oCol, oData) {
	 		var num_prefix='';
			if ( oData < 0.0 ) {
	       // YAHOO.util.Dom.setStyle(elCell,'color','red');
	       num_prefix = alert("Please enter a positive number");
			elCell.innerHTML = num_prefix+"0" ;
	        elCell.innerHTML ="0";
	    		}
			else{
			var fmtCurrency = {   
	       				prefix : '', 
		 				negativeFormat : null,   
	       				thousandsSeparator: '',
	       				decimalSeparator: '.',    
	       				decimalPlaces: 2                                       
	   			}
	 		var num_fmt = YAHOO.util.Number.format( oData, fmtCurrency );
			elCell.innerHTML =  num_fmt;
			var total=0;
			 for(var m=0;m<myDataTable.getRecordSet().getLength();m++){
			       var upRecord = myDataTable.getRecord(m);
			       total=parseInt(total)+parseInt(upRecord.getData("taxdeducted"));
			      }
			 
			
			 document.getElementById("totalvalue").value = total;
			
	               
	            

			}
				};
		
		var myColumnDefs = [
	             	 	{key:"row",resizeable:true,sortable:true,hidden:true},
			 			{key:"radio", formatter:"radio"},	
			 			{key:"TAN",label:"Tax Deduction<br> Account Number<br>(TAN) of Employer",formatter:function(el, oRecord, oColumn, oData) {
													el.innerHTML = oData;
													if(oData.length!=0){
									if (/^[A-Z]{4}\d{5}[A-Z]$/.test(oData)) {
									} else {  
									alert("Please enter a valid TAN");
									el.innerHTML="";
									}}
							},editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})
						},
	             		{key:"employer",label:"Name of the <br> Employer",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true}),formatter:function(el, oRecord, oColumn, oData) {
							el.innerHTML = oData;
							if(oData.length!=0){
								if (/^[A-Za-z\s]{0,25}$/.test(oData)) {
								} else {  
								alert("Please enter a valid Name");
								el.innerHTML="";
								}}
						}},
	             		{key:"Incomechargeable",label:"Income Chargeable<br> under the head<br> salaries",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true,validator:YAHOO.widget.DataTable.validateNumber}),formatter:formatIncome},
	             		{key:"taxdeducted",label:"Total tax<br> Deducted",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true,validator:YAHOO.widget.DataTable.validateNumber}),formatter:formatIncome1}
	             			];
	         
	         
	          var myDataSource = new YAHOO.util.DataSource([]);
	          myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
	          myDataSource.responseSchema = {
	              fields: ["radio" ,"TAN","employer","Incomechargeable","taxdeducted"]
	                   
	          };
	          
		
	        
	        var myDataTable = new YAHOO.widget.DataTable("cellsalary",        // creating object
	                myColumnDefs, myDataSource, {});
         // Set up editing flow
        	var highlightEditableCell = function(oArgs) {
			
            var elCell = oArgs.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
		 
        };
	
        myDataTable.subscribe("cellMouseoverEvent", highlightEditableCell);
        myDataTable.subscribe("cellMouseoutEvent", myDataTable.onEventUnhighlightCell);
        myDataTable.subscribe("cellClickEvent", myDataTable.onEventShowCellEditor);
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
        // this event is used to get the value of a selected row by clicking a radio button so that we can delete it.
        myDataTable.subscribe("radioClickEvent", function(oArgs){ 
	
                if(lastSelectRadioRecord) {
                   lastSelectRadioRecord.setData("radio",false);
                	}
				 var elRadio = oArgs.target;
				 var oRecord = this.getRecord(elRadio);
				oRecord.setData("radio",true);
                deleteRadio=true;
                lastSelectRadioRecord = oRecord;
				var name = oRecord.getData("taxdeducted");
		
            });

			 var i=1,
	            bReverseSorted = false;

	        // Track when Column is reverse-sorted, since new data will come in out of order
	        var trackReverseSorts = function(oArg) {
	            bReverseSorted = (oArg.dir === YAHOO.widget.DataTable.CLASS_DESC);
	          
	        };
	        myDataTable.subscribe("columnSortEvent", trackReverseSorts);
	        
	       
	         
	          // Add one row to the bottom 
	        	        var btnAddRow = new YAHOO.widget.Button("addrowtdssalary"); 
	        	        btnAddRow.on("click", function() { 
					
// these insructions are used for validation purpose which is still in progress 

var len = myDataTable.getRecordSet().getLength(); 


var oRecord = 0;
var flagtan=false;
var flagemployer=false;
var flagIncomechargeable=false;
var flagtaxdeducted=false;
var AddRowError=" "
if(len>0){
	
	oRecord = myDataTable.getRecord(len-1);
	
	var tan=oRecord.getData("TAN");
	var Employer=oRecord.getData("employer");
	var incomechargeable=oRecord.getData("Incomechargeable");
	
	var Taxdeducted=oRecord.getData("taxdeducted");

	if(!(tan == null || tan == 0 || tan == " "))
	{
		
		flagtan = false;
	}
	else
	{
		AddRowError ="TAN";
		flagtan = true;
		}

		if(!(Employer == null || Employer == " " || Employer == 0))
	{
	
		
		flagemployer = false;
		}
	else
	{
		if(flagtan == true){
		AddRowError=AddRowError+",Name of Employer";
	
		flagemployer = true;
		}
	else{
		
		AddRowError=AddRowError+"Name of Employer";
		
		flagemployer = true;
		
		
			}
		}
	if(!(incomechargeable == null || incomechargeable == 0 || incomechargeable == " ") )
		{
			
			flagIncomechargeable = false;
		}
		else
		{
			if(flagemployer == true){
			AddRowError=AddRowError+",Income Chargeable under the head salaries";
			
			flagIncomechargeable = true;
			}
		else{
			
			AddRowError=AddRowError+"Income Chargeable under the head salaries";
			
			flagIncomechargeable = true;
				}
			}

			if(!(Taxdeducted == null || Taxdeducted == 0 || Taxdeducted == " ") )
		{
			
			
			
			flagtaxdeducted = false;
		}
		else
		{
			if(flagIncomechargeable == true){
			AddRowError=AddRowError+",Taxdeducted";
			alert("Please enter "+AddRowError);
			flagtaxdeducted = true;
			}
		else{
		
			AddRowError=AddRowError+"Taxdeducted";
			alert(AddRowError);
			flagtaxdeducted = true;
			
			
		}
	
		
	}
		
		
	if(flagtaxdeducted == false && incomechargeable >0 && Taxdeducted>0 && Employer != null && tan!=null ){
	record = YAHOO.widget.DataTable._cloneObject(data);
	record.row = i++; 

	
	this.myDataTable.addRow(record);
	}else{
	alert("can't add row");
	}



}else
{
	oRecord = myDataTable.getRecord(0);
	
	record = YAHOO.widget.DataTable._cloneObject(data);
	record.row = i++; 
	
	this.myDataTable.addRow(record);	

}
	

					
      	        },this,true); 
       
</script>


	<script>
YAHOO.namespace("example.container");

var lastSelectRadioRecord = null;  
function init() {
	
	// Define various event handlers for Dialog
	var handleYes = function() {
		
	var rowIndex= lastSelectRadioRecord.getData("row");   
		
			if(rowIndex>=0){
		var delamount1=lastSelectRadioRecord.getData("taxdeducted");
		
		var delamount2=document.getElementById("totalvalue").value
		
		var delamount=delamount2-delamount1;
		delamount2=document.getElementById("totalvalue").value=delamount;
            	myDataTable.deleteRow(lastSelectRadioRecord);
	
		
		

		}
		lastSelectRadioRecord=null;
	
	
		this.hide();
	};
	var handleNo = function() {
		this.hide();
	};


		function askdelete(){
		
		 len = myDataTable.getRecordSet().getLength(); 
			
			if(len>0 && deleteRadio==true){

	// Instantiate the Dialog
	YAHOO.example.container.simpledialogdelete = new YAHOO.widget.SimpleDialog("simpledialogdelete", 
																			 { width: "300px",
																			   fixedcenter: true,
																			   visible: false,
																			   draggable: false,
																			   close: true,
																			   text: "Do you want to continue?",
																			   icon: YAHOO.widget.SimpleDialog.ICON_HELP,
																			   constraintoviewport: true,
																			   buttons: [ { text:"Yes", handler:handleYes, isDefault:true },
																						  { text:"No",  handler:handleNo } ]
																			 } );
	YAHOO.example.container.simpledialogdelete.setHeader("Are you sure?");
	
	// Render the Dialog
	YAHOO.example.container.simpledialogdelete.render("deleterow");

		
		
YAHOO.example.container.simpledialogdelete.show();

		}
		}

	YAHOO.util.Event.addListener("deletebutton", "click", askdelete);

}

YAHOO.util.Event.addListener(window, "load", init);


							

	
</script>

	<div>
		<table width="600">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><b><fmt:message key="total.amount.tdsfromsalary" />
						</b>
				</td>
		
			
		<td><c:if test="${not empty objTdsSalary}">
						<input type="text" name="totalvalue"
							value="${objTdsSalary.total_Value}" id="totalvalue" readonly>
					</c:if> <c:if test="${empty objTdsSalary}">
						<input type="text" name="totalvalue" value="" id="totalvalue"
							readonly>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr height="40px" align="right">

				<tr height="40px" align="center">
				
					<td align="right"><button onclick="stringify()">Save</a></button></td>
					<td align="left"> <button> <a href="/site/tdsfromothers">Skip</a></button></td>
				</tr>
				
			</tr>
		</table>
	</div>
</form>
<script>

	function stringify(){
		var objDT = myDataTable.getRecordSet().getRecords(); // put the entire object in the variable
		var sJSONDT = JSON.stringify(objDT);   // stringify object
		document.getElementById('hidDataTable').value = sJSONDT;   // put the value in the hidden variable 
		
	}
	</script>

<%-- These are the files included to run this functionality --%>


<hst:headContribution keyHint="buttonCss" category="css">
	<hst:link
		path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"
		var="homeSliderCss" />
	<link rel="stylesheet" media="screen" type="text/css"
		href="${homeSliderCss}" />
</hst:headContribution>


<hst:headContribution keyHint="seedFile" category="jsExternal">
	<script src="http://yui.yahooapis.com/3.8.0/build/yui/yui-min.js"
		type="text/javascript"></script>
</hst:headContribution>




<hst:headContribution keyHint="formcss">
	<link rel="stylesheet" href='<hst:link path="/css/tdsfromsalary.css"/>'
		type="text/css" />
</hst:headContribution>

<script>
		if (typeof(objFetchValue) != 'undefined' && objFetchValue != null && objFetchValue.length > 0) {
			for (var i=0;i<objFetchValue.length;i++) {
				test(objFetchValue[i],i);				
			}
		}	
	</script>