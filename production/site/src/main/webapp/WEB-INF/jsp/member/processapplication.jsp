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

<%@include file="../includes/tags.jspf" %>
  <c:set var="advancetax"><fmt:message key="member.advancetax.title"/></c:set>
<hippo-gogreen:title title="${advancetax}"/>


<%--these are the yui depandancies that should be added to use YUI --%>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/fonts/fonts-min.css" />
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/button/assets/skins/sam/button.css" />
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/container/assets/skins/sam/container.css" />
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.6.0/build/datatable/assets/skins/sam/datatable.css" />
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/calendar/assets/skins/sam/calendar.css" />


<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/connection/connection-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/element/element-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/button/button-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/dragdrop/dragdrop-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/container/container-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/calendar/calendar-min.js"></script>


<script type="text/javascript" src="http://yui.yahooapis.com/2.6.0/build/element/element-beta-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.6.0/build/datasource/datasource-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.6.0/build/datatable/datatable-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/event-delegate/event-delegate-min.js"></script>

<script type="text/javascript" src="http://yui.yahooapis.com/2.6.0/build/yuiloader/yuiloader.js"></script>
<!-- to use json utilities -->
<script src="http://yui.yahooapis.com/2.9.0/build/yahoo/yahoo-min.js"></script>
<script src="http://yui.yahooapis.com/2.9.0/build/json/json-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/combo?2.9.0/build/yahoo-dom-event/yahoo-dom-event.js&2.9.0/build/calendar/calendar-min.js"></script> 




 <!--BEGIN SOURCE CODE FOR EXAMPLE =============================== -->

<div id="buttons">
    <span id="addrowsbsr" class="yui-button yui-push-button">
        <span class="first-child">
            <button type="button">Add one row</button>
        </span>
    </span>
    <span id="deleterows" class="yui-button yui-push-button">
        <span class="first-child">
            <button type="button" id="deletebuttn" >Delete one row</button>
        </span>
    </span>
 
</div>

<%-- Here code start for yui grid which take data in it --%>
<div id="cell"></div>
<hst:actionURL var="actionUrl"/>	
<form method="post" action="${actionUrl}" >                       
<input type="hidden" name="hidDataTable" id="hidDataTable" value=" "/>    

<%-- starting of script for datatable --%>
<script type="text/javascript">
var deleteRadio=false;
var sr=1;
var oRecord = 0;
	    	
var data = {SNo:"",BSR_code:"",Amount:" ",Serial_No_of_Challan:" ",Amount:" ",radio:""};
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
		var fmtserial =function(el, oRecord, oColumn, oData) {
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
							{key:"SNo",label:"Serial No.",resizeable:true},
				  			{key:"BSR_code",label:"BSR code",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true}),
								formatter:function(el, oRecord, oColumn, oData) {
							el.innerHTML = oData;
					
							if (/^[0-9]{0,7}$/.test(oData)) {
		
							
						} else {  
							alert("Please enter a valid BSR Code");
								el.innerHTML="";
						}}},
	             			{key:"Amount",label:"Amount(Rs.)",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({validator:YAHOO.widget.DataTable.validateNumber}),formatter:fmtserial  }, 
	             			{key:"Serial_No_of_Challan",label:"Serial No of <br> Challan",resizeable:true,	formatter:function(el, oRecord, oColumn, oData) {
											el.innerHTML = oData;
										if (/^[0-9]{0,7}$/.test(oData)) {
								
							
									} else {  
									alert("Please enter a valid Serial Number");
								el.innerHTML="";
						}},editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})
							},
	             			{key:"Amount",label:"Amount(Rs.)",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({validator:YAHOO.widget.DataTable.validateNumber},{disableBtns:true}),formatter:fmtNegCurrency , }
	             
	         	 ];
			<%--end of code for defining column keys of datatable --%>
	         
			<%-- code for defining datasource of datatable --%>
	          var myDataSource = new YAHOO.util.DataSource([]);
	          myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
	          myDataSource.responseSchema = {
	              			fields: ["SI No.","BSR_code","radio" ,"Serial_No_of_Challan","Amount",{key:"dateofcredit",parser:"date"}]
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
						if(flagchallan == true)
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
			if(flagamount == false)
			{
				record = YAHOO.widget.DataTable._cloneObject(data);
			
				record.rows = i++; 
				record.SNo = sr++;
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
										
											myDataTable.deleteRow(lastSelectedRadioRecord);                     
									}
								var totalsize = myDataTable.getRecordSet().getLength();
								var diff = totalsize-rowsIndex;
		
								if(diff>=0)
									{
											for(var d=0;d<diff;d++)
												{
													oRecord = myDataTable.getRecord(rowsIndex);
													var varRNum = oRecord.getData("rows");
													var bsr_code=oRecord.getData("BSR_code");
													var date_credit=oRecord.getData("dateofcredit");
													var challan_SNo=oRecord.getData("Serial_No_of_Challan");
													var amount=oRecord.getData("Amount");
													var serial=oRecord.getData("SNo");
													var getrow=oRecord.getData("rows");
													myDataTable.updateRow(oRecord,{rows:getrow-1, SNo:serial-1,BSR_code:bsr_code,dateofcredit:date_credit,
																			Serial_No_of_Challan:challan_SNo,Amount:amount});
													rowsIndex++;
													
												}//end of for loop
            						
                    					--i;
                   						sr--;
         						 		
									}
							lastSelectedRadioRecord=null;
							deleteRadio==false;
							this.hide();
					}; // end update row
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
	<input type="submit" value="Next" onclick="stringify()">
	</form>
	</div> 
	</div> 
	<div id="resp">Server response will be displayed in this area area </div>
	<script>
	function stringify(){
	alert("inside strigify");
	
		var objDT = myDataTable.getRecordSet().getRecords(); // put the entire object in the variable
		var sJSONDT = JSON.stringify(objDT);   // stringify object
		alert("sJSONDT"+sJSONDT);
		document.getElementById('hidDataTable').value = sJSONDT;   // put the value in the hidden variable 
		alert("inside::::"+document.getElementById('hidDataTable').value);
	}
	</script>

	<%-- Here the files are included which are working along with it  --%>

	<hst:headContribution keyHint="buttonCss" category="css">
    <hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css" var="homeSliderCss"/>
    <link rel="stylesheet" media="screen" type="text/css" href="${homeSliderCss}"/>
	</hst:headContribution>


	<hst:headContribution keyHint="seedFile" category="jsExternal"> 
	<script src="http://yui.yahooapis.com/3.8.0/build/yui/yui-min.js" type="text/javascript"></script>
	</hst:headContribution>


	

	<hst:headContribution keyHint="formcss">
	<link rel="stylesheet" href='<hst:link path="/css/advancetax.css"/>' type="text/css"/>
	</hst:headContribution>





 <!--Here code starts for second datatable -->
 <div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div id="buttons">
    <span id="addrowsbsr" class="yui-button yui-push-button">
        <span class="first-child">
            <button type="button">Add one row</button>
        </span>
    </span>
    <span id="deleterows" class="yui-button yui-push-button">
        <span class="first-child">
            <button type="button" id="deletebuttn" >Delete one row</button>
        </span>
    </span>
 
</div>

<%-- Here code start for yui grid which take data in it --%>
<div id="celledit"></div>
<hst:actionURL var="actionUrl"/>	
<form method="post" action="${actionUrl}" >                       
<input type="hidden" name="hidDataTable" id="hidDataTable" value=" "/>    

<%-- starting of script for datatable --%>
<script type="text/javascript">
var deleteRadio=false;
var sr=1;
var oRecord = 0;
	    	
var datas = {SNo:"",BSR_code:"",Amount:" ",Serial_No_of_Challan:" ",Amount:" ",radio:""};
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
		var fmtserial =function(el, oRecord, oColumn, oData) {
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
							{key:"SNo",label:"Serial No.",resizeable:true},
				  			{key:"BSR_code",label:"BSR code",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true}),
								formatter:function(el, oRecord, oColumn, oData) {
							el.innerHTML = oData;
					
							if (/^[0-9]{0,7}$/.test(oData)) {
		
							
						} else {  
							alert("Please enter a valid BSR Code");
								el.innerHTML="";
						}}},
	             			{key:"Amount",label:"Amount(Rs.)",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({validator:YAHOO.widget.DataTable.validateNumber}),formatter:fmtserial  }, 
	             			{key:"Serial_No_of_Challan",label:"Serial No of <br> Challan",resizeable:true,	formatter:function(el, oRecord, oColumn, oData) {
											el.innerHTML = oData;
										if (/^[0-9]{0,7}$/.test(oData)) {
								
							
									} else {  
									alert("Please enter a valid Serial Number");
								el.innerHTML="";
						}},editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})
							},
	             			{key:"Amount",label:"Amount(Rs.)",resizeable:true,editor: new YAHOO.widget.TextboxCellEditor({validator:YAHOO.widget.DataTable.validateNumber},{disableBtns:true}),formatter:fmtNegCurrency , }
	             
	         	 ];
			<%--end of code for defining column keys of datatable --%>
	         
			<%-- code for defining datasource of datatable --%>
	          var myDataSource = new YAHOO.util.DataSource([]);
	          myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
	          myDataSource.responseSchema = {
	              			fields: ["SI No.","BSR_code","radio" ,"Serial_No_of_Challan","Amount",{key:"dateofcredit",parser:"date"}]
	         								 };
	    		
	    		<%--creating object of datatable --%>
	        var myDataTable = new YAHOO.widget.DataTable("celledit",        
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
						if(flagchallan == true)
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
			if(flagamount == false)
			{
				record = YAHOO.widget.DataTable._cloneObject(data);
			
				record.rows = i++; 
				record.SNo = sr++;
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
					records = YAHOO.widget.DataTable._cloneObject(datas);
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
										
											myDataTable.deleteRow(lastSelectedRadioRecord);                     
									}
								var totalsize = myDataTable.getRecordSet().getLength();
								var diff = totalsize-rowsIndex;
		
								if(diff>=0)
									{
											for(var d=0;d<diff;d++)
												{
													oRecord = myDataTable.getRecord(rowsIndex);
													var varRNum = oRecord.getData("rows");
													var bsr_code=oRecord.getData("BSR_code");
													var date_credit=oRecord.getData("dateofcredit");
													var challan_SNo=oRecord.getData("Serial_No_of_Challan");
													var amount=oRecord.getData("Amount");
													var serial=oRecord.getData("SNo");
													var getrow=oRecord.getData("rows");
													myDataTable.updateRow(oRecord,{rows:getrow-1, SNo:serial-1,BSR_code:bsr_code,dateofcredit:date_credit,
																			Serial_No_of_Challan:challan_SNo,Amount:amount});
													rowsIndex++;
													
												}//end of for loop
            						
                    					--i;
                   						sr--;
         						 		
									}
							lastSelectedRadioRecord=null;
							deleteRadio==false;
							this.hide();
					}; // end update row
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
	<input type="submit" value="Next" onclick="stringify()">
	</form>
	</div> 
	</div> 
	<div id="resp">Server response will be displayed in this area area </div>
	<script>
	function stringify(){
	alert("inside strigify");
	
		var objDT = myDataTable.getRecordSet().getRecords(); // put the entire object in the variable
		var sJSONDT = JSON.stringify(objDT);   // stringify object
		alert("sJSONDT"+sJSONDT);
		document.getElementById('hidDataTable').value = sJSONDT;   // put the value in the hidden variable 
		alert("inside::::"+document.getElementById('hidDataTable').value);
	}
	</script>

	
</div>

 
