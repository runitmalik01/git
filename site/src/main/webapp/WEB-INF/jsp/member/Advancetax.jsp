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

<%@include file="../includes/tags.jspf"%>
<c:set var="advancetax">
	<fmt:message key="member.advancetax.title" />
</c:set>
<hippo-gogreen:title title="${advancetax}" />


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

<br>
<br>

<div>
	<br>

	<div>
		<fmt:message key="advance.tax" />
	</div>
	<br> <br> <br>
	<div id="buttons">
		<span id="addrowsbsr" class="yui-button yui-push-button"> <span
			class="first-child">
				<button type="button">Add Detail</button> </span> </span> <span id="deleterows"
			class="yui-button yui-push-button"> <span class="first-child">
				<button type="button" id="deletebuttn">Delete Detail</button> </span> </span>

	</div>

	<%-- Here code start for yui grid which take data in it --%>
	<div id="cell"></div>
	<hst:actionURL var="actionUrl" />
	<form method="post" action="${actionUrl}">
		<input type="hidden" name="hidDataTable" id="hidDataTable" value=" " />

		<%-- starting of script for datatable --%>
		<script type="text/javascript">

function test(mydata, i) {

	var len = myDataTable.getRecordSet().getLength();

	var oRecord = YAHOO.widget.DataTable._cloneObject(mydata);
	oRecord.row = i;

	myDataTable.addRow(oRecord );
}

var objFetchValue =
	<%=request.getAttribute("objArray")%>
var deleteRadio=false;

var oRecord = 0;
	    	
var data ={BSR_code:"",Amount:"",Serial_No_of_Challan:"",Amount:"",radio:""};
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
   		}
 	var num_fmt = YAHOO.util.Number.format( oData, fmtCurrency );
	elCell.innerHTML =  num_fmt;  
		}
	}
	<%--end of code for defining the formatter of currency --%>
	
	<%--start of code for defining the formatter for date --%>
	YAHOO.util.DateLocale["pt-BR"] = YAHOO.lang.merge(YAHOO.util.DateLocale, {
    								x:"%d/%m/%Y"
		});
		var fmtserial=function(el, oRecord, oColumn, oData) {
											el.innerHTML = oData;
										if (/^[0-9]{0,7}$/.test(oData)) {
								
							
									} else {  
									alert("Please enter a valid Serial Number");
								el.innerHTML="";
						}};

	<%--end of code for defining the formatter of date --%>

	<%--start of code for defining column keys of datatable --%>						
	var myColumnDefs = [
	              			{key:"rows",resizeable:true,sortable:true,hidden:true},
							{key:"radio", formatter:"radio"},  
						
				  			{key:"BSR_code",label:"BSR code",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true}),
								formatter:function(el, oRecord, oColumn, oData) {
							el.innerHTML = oData;
					
							if (/^[0-9]{0,7}$/.test(oData)) {
		
							
						} else {  
							alert("Please enter a valid BSR Code");
								el.innerHTML="";
						}}},
						{key:"dateofcredit",label:"Date of credit into Govt Account",resizeable:true,editor: new YAHOO.widget.DateCellEditor({disableBtns:true}),
							parser:"date",formatter:"date"}, 
	             			{key:"Serial_No_of_Challan",label:"Serial No of <br> Challan",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true}),formatter:fmtserial
							},
	             			{key:"Amount",label:"Amount(Rs.)",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true,validator:YAHOO.widget.DataTable.validateNumber},{disableBtns:true}),formatter:fmtNegCurrency , }
	             
	         	 ];
			<%--end of code for defining column keys of datatable --%>
	         
			<%-- code for defining datasource of datatable --%>
	          var myDataSource = new YAHOO.util.DataSource([]);
	          myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
	          myDataSource.responseSchema = {
	              			fields: ["BSR_code","radio" ,"Serial_No_of_Challan","Amount",{key:"dateofcredit",parser:"date"}]
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
			

			var flagbsr=false;
			var flagdate=false;
			var flagchallan=false;
			var flagamount=false;
			var AddRowError=" "
				if(len>0)
		{
					
			
				oRecord = myDataTable.getRecord(len-1);
				var bsr=oRecord.getData("BSR_code");
				var date=oRecord.getData("dateofcredit");
				var challanSNo=oRecord.getData("Serial_No_of_Challan");
				var amt=oRecord.getData("Amount");
	
				if(!(bsr == null || bsr == 0 || bsr == " "))
					{
							flagbsr = false;
					}
				else
					{
							AddRowError ="BSR Code";
							flagbsr = true;
					}
				if(!(date == null || date == " "))
					{
						flagdate = false;
					}
				else
					{
							if(flagbsr == true)
								{
									AddRowError=AddRowError+",Date of Credit into Govt. Account";
									
									flagdate = true;
								}
							else{
									AddRowError=AddRowError+"Date of Credit into Govt. Account";
									flagdate = true;
								}
					}
				if(!(challanSNo == null || challanSNo == 0 || challanSNo == " ") )
					{
						flagchallan = false;
					}
				else
					{
						if(flagdate == true)
						{
							AddRowError=AddRowError+",Serial No. of Challan";
				
							flagchallan = true;
						}
						else
						{
							AddRowError=AddRowError+"Serial No. of Challan";
						
							flagchallan = true;
						}
					}
				if(!(amt == null || amt == 0 || amt == " ") )
					{
						flagamount = false;
					}
				else
					{
						if(flagchallan == true   )
						{
							AddRowError=AddRowError+",Amount";
							alert("Please enter "+AddRowError);
							flagamount = true;
						}
						else
						{
						AddRowError=AddRowError+"Amount";
						alert("Please enter "+AddRowError);
						flagamount = true;
						}
					}
				<%--add row if it is not first row and all previous row are filled --%>
			if(flagamount == false && amt>0 && challanSNo>0 && bsr>0)
			{
				record = YAHOO.widget.DataTable._cloneObject(data);
			
				record.rows = i++; 
			
				this.myDataTable.addRow(record);
			}
			else
			{
				alert("can't add rows");
			}
	}	else
				{
		<%--add row if it is first row --%>
					oRecord = myDataTable.getRecord(0);
					records = YAHOO.widget.DataTable._cloneObject(data);
					records.rows = i++; 
					
					this.myDataTable.addRow(records);	

				}
		},this,true); 
				function calcamount(){
					var totalamt1=0;
	
					var l = myDataTable.getRecordSet().getLength(); 
					
					for(var n=0;n<l;n++){
					var Record = myDataTable.getRecord(n);
					
					var totalamt=Record.getData("Amount");
					
					totalamt1=parseInt(totalamt1)+parseInt(totalamt);
					
					
				}
				document.getElementById("totalvalue").value=totalamt1;
			
					
				}

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
								
								var test= lastSelectedRadioRecord.getData("row");
								
								
								//if(rowsIndex>=0)
									//{
									var delamount1= lastSelectedRadioRecord.getData("Amount");
									var delamount2=document.getElementById("totalvalue").value
									var totalDelamount=delamount2-delamount1;
									document.getElementById("totalvalue").value=totalDelamount;
										myDataTable.deleteRow(lastSelectedRadioRecord);                     
									//}
		
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
		<table width="600">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><b><fmt:message
							key="self.assesment.amount" /> </b>
				</td>
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
							onclick="calcamount()" width="30">
					</div>
				</td>


				<td><input type="text" name="totalvalue" value=""
					id="totalvalue" readonly></td>
			</tr>
		</table>
</div>
<br>
<br>
<br>
<br>
<div>
	<fmt:message key="self.assesment.tax" />
</div>
<br>
<br>
<br>
<div id="buttons">
	<span id="add" class="yui-button yui-push-button"> <span
		class="first-child">
			<button type="button">Add Detail</button> </span> </span> <span id="deleterow"
		class="yui-button yui-push-button"> <span class="first-child">
			<button type="button" id="deletebutton">Delete Detail</button> </span> </span>

</div>

<%-- Here code start for yui grid which take data in it --%>
<div id="celledit"></div>
<hst:actionURL var="actionUrl" />
<form method="post" action="${actionUrl}">
	<input type="hidden" name="hidDataTable1" id="hidDataTable1" value=" " />

	<%-- starting of script for datatable --%>
	<script type="text/javascript">
	
	function test1(mydata1, i) {
	var len =  DTable.getRecordSet().getLength();
		var precord = YAHOO.widget.DataTable._cloneObject(mydata1);
		precord.row = i;

		 DTable.addRow(precord);
	}
	var objFetchValue1 =
	<%=request.getAttribute("objArray1")%>
	
	var deleteRadio1=false;
	
	var oRec = 0;
	var datas = {BSR_code1:"",Dateofcredit1:"",Serial_No_of_Challan1:"",Amount1:"",radio1:""};
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
   		}
 	var num_fmt = YAHOO.util.Number.format( oData, fmtCurrency );
	elCell.innerHTML =  num_fmt;  
		}
	}
	<%--end of code for defining the formatter of currency --%>
	
	<%--start of code for defining the formatter for date --%>
	YAHOO.util.DateLocale["pt-BR"] = YAHOO.lang.merge(YAHOO.util.DateLocale, {
    								x:"%d/%m/%Y"
		});
	var fam=function(el, oRecord, oColumn, oData) {
											el.innerHTML = oData;
										if (/^[0-9]{0,7}$/.test(oData)) {
								
							
									} else {  
									alert("Please enter a valid Serial Number");
								el.innerHTML="";
						}};
	var formatbsr=function(el, oRecord, oColumn, oData) {
							el.innerHTML = oData;
					
							if (/^[0-9]{0,7}$/.test(oData)) {
		
							
						} else {  
							alert("Please enter a valid BSR Code");
								el.innerHTML="";
						}}
	<%--end of code for defining the formatter of date --%>

	<%--start of code for defining column keys of datatable --%>						
	var ColumnDefs = [
	              			{key:"row",resizeable:true,sortable:true,hidden:true},
							{key:"radio", formatter:"radio"},  
							
				  			{key:"BSR_code1",label:"BSR Code ",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true}),formatter:formatbsr
								},
	             			{key:"dateofcredit1",label:"Date of credit into Govt Account",resizeable:true,editor: new YAHOO.widget.DateCellEditor({disableBtns:true}),
											formatter:function(container, record, column, data) {
              								container.innerHTML = YAHOO.util.Date.format(data, {format:"%x"}, "pt-BR");
   						 	}}, 
	             			{key:"Serial_No_of_Challan1",label:"Serial No of <br> Challan",resizeable:true,	formatter:fam,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})
							},
	             			{key:"Amount1",label:"Amount(Rs.)",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true,validator:YAHOO.widget.DataTable.validateNumber}),formatter:fmtNegCurrency , }
	             
	         	 ];
			<%--end of code for defining column keys of datatable --%>
	         
			<%-- code for defining datasource of datatable --%>
	          var DataSource = new YAHOO.util.DataSource([]);
	          DataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
	          DataSource.responseSchema = {
	              			fields: ["SI No.","BSR_code1","radio1" ,"Serial_No_of_Challan1","Amount1",{key:"dateofcredit1",parser:"date"}]
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
			

			var flagbsr1=false;
			var flagdate1=false;
			var flagchallan1=false;
			var flagamount1=false;
			var AddRowError=" "
				if(len>0)
		{
					
			
				oRec = DTable.getRecord(len-1);
				var bsr=oRec.getData("BSR_code1");
				
				var date=oRec.getData("dateofcredit1");
				var challanSNo=oRec.getData("Serial_No_of_Challan1");
				var amt=oRec.getData("Amount1");
	
				if(!(bsr == null || bsr == 0 || bsr == " "))
					{
							flagbsr1 = false;
					}
				else
					{
							AddRowError ="BSR Code";
							flagbsr1 = true;
					}
				if(!(date == null || date == " "))
					{
						flagdate1 = false;
					}
				else
					{
							if(flagbsr1 == true)
								{
									AddRowError=AddRowError+",Date of Credit into Govt. Account";
									
									flagdate1 = true;
								}
							else{
									AddRowError=AddRowError+"Date of Credit into Govt. Account";
									flagdate1 = true;
								}
					}
				if(!(challanSNo == null || challanSNo == 0 || challanSNo == " ") )
					{
						flagchallan1 = false;
					}
				else
					{
						if(flagdate1 == true)
						{
							AddRowError=AddRowError+",Serial No. of Challan";
				
							flagchallan1 = true;
						}
						else
						{
							AddRowError=AddRowError+"Serial No. of Challan";
						
							flagchallan1 = true;
						}
					}
				if(!(amt == null || amt == 0 || amt == " ") )
					{
						flagamount1 = false;
					}
				else
					{
						if(flagchallan1 == true)
						{
							AddRowError=AddRowError+",Amount1";
							alert("Please enter "+AddRowError);
							flagamount1 = true;
						}
						else
						{
						AddRowError=AddRowError+"Amount1";
						alert("Please enter "+AddRowError);
						flagamount1 = true;
						}
					}
				<%--add row if it is not first row and all previous row are filled --%>
			if(flagamount1 == false && amt>0 && challanSNo>0 && bsr)
			{
				rec = YAHOO.widget.DataTable._cloneObject(datas);
			
				rec.row =k++; 
				
			
				
				this.DTable.addRow(rec);
			}
			else
			{
				alert("can't add row");
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
			function calcamount1(){
	var total1=0;

	var l1 = DTable.getRecordSet().getLength(); 
	
	for(var n=0;n<l1;n++){
	var Record1 = DTable.getRecord(n);
	
	var total=Record1.getData("Amount1");
	total1=parseInt(total1)+parseInt(total);

}
document.getElementById("totalvalue1").value=total1;
	
}

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
									var delamount1= lastSelectRadio.getData("Amount1");
									
									var delamount2=document.getElementById("totalvalue1").value
									var delamount1=delamount2-delamount1;
									document.getElementById("totalvalue1").value=delamount1;
										
											DTable.deleteRow(lastSelectRadio);                     
									}
						
																	

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
							YAHOO.example.container.simpledialog2 = new YAHOO.widget.SimpleDialog("simpledialog1", 
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
							YAHOO.example.container.simpledialog2.setHeader("Are you sure?");
	
							// Render the Dialog
							YAHOO.example.container.simpledialog2.render("deleterow");
							
							YAHOO.example.container.simpledialog2.show();
					}
				}
				<%--this listener will open the above dialog  --%>
				YAHOO.util.Event.addListener("deletebutton", "click", check1);
		}

	YAHOO.util.Event.addListener(window, "load", init);
	</script>

	<br> <br> <br> 
	<div>
		<table width="600">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><b><fmt:message
							key="self.assesment.amount" /> </b>
				</td>
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
							onclick="calcamount1()" width="30">
					</div>
				</td>


				<td><input type="text" name="totalvalue1" value=""
					id="totalvalue1" readonly></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr height="40px" align="right">
				<td class="submit fright" colspan="1" align="right"><input
					type="image" src="images/next-button-png-hi.png" height="38px"
					width="90px" onclick="return checkDTSize()" />
					<td align="left"> <button> <a href="/site/tdsfromsalary">Skip</a></button></td>
				
			</tr>
		</table>
	</div>

</form>




<script>
	function checkDTSize(){

		var l = myDataTable.getRecordSet().getLength();
	var allowsubmit1=document.getElementById("totalvalue1").value;
	var allowsubmit=document.getElementById("totalvalue").value;
	if(allowsubmit1 && allowsubmit > 0){
	stringify();
	}else { 
		if(l>0){
		alert("Please calculate Tax")
	}else{
	alert("Please enter Employer details and calculate Total Tax Deducted");
	}
	return false;
	}
	}
	function stringify(){
	var objDT = myDataTable.getRecordSet().getRecords(); // put the entire object in the variable
		
		var sJSONDT = JSON.stringify(objDT);   // stringify object
			
	document.getElementById('hidDataTable').value = sJSONDT;   // put the value in the hidden variable 
	
	var objDT1 = DTable.getRecordSet().getRecords();
		var sJSONDT1 = JSON.stringify(objDT1);
		document.getElementById('hidDataTable1').value = sJSONDT1;
	}
	</script>

<%-- Here the files are included which are working along with it  --%>

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


<hst:headContribution keyHint="form-validation" category="jsInternal">
	<script type="text/javascript" src='<hst:link path="/js/tds.js"/>'></script>
</hst:headContribution>

<script>
	if (typeof (objFetchValue) != 'undefined' && objFetchValue != null
			&& objFetchValue.length > 0) {
	
		for ( var i = 0; i < objFetchValue.length; i++) {

			test(objFetchValue[i], i);
		}
	}
</script>

<script>
	
	if (typeof (objFetchValue1) != 'undefined' && objFetchValue1 != null
			&& objFetchValue1.length > 0) {
		
		for ( var i = 0; i < objFetchValue1.length; i++) {
		
			test1(objFetchValue1[i], i);
		}
	}
	
</script>


