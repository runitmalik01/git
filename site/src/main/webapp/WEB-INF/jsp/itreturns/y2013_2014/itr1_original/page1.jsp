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
<%@include file="../../../includes/tags.jspf" %>
<hst:actionURL var="actionUrl"/>	

<h2>Personal Information</h2>
<form id="frmRating" action="${actionUrl}" method="post">
	First Name:<input type="text" name="pi_first_name" value="<c:out value="${itr1.personalInformation.firstName}"/>"/>
	<c:forEach items="${itr1.tdsSalaryList}" var="tdsSalary">
		<c:out value="${tdsSalary.employerName}"/><br/>
	</c:forEach>
	<input type="submit" value="<fmt:message key="products.detail.submit.label"/>" id="comment-button" />
</form>

<h2>TDS (Salaries)</h2>
<div id="cellediting"></div>

<script type="text/javascript">
YAHOO.util.Event.addListener(window, "load", function() {
    YAHOO.example.InlineCellEditing = function() {
        // Custom formatter for "address" column to preserve line breaks
        var formatAddress = function(elCell, oRecord, oColumn, oData) {
            elCell.innerHTML = "<pre class=\"address\">" + YAHOO.lang.escapeHTML(oData) + "</pre>";
        };

        var myColumnDefs = [
            {key:"empTan","label":"Employer TAN", formatter:formatAddress, editor: new YAHOO.widget.TextareaCellEditor()},
            {key:"empName", "label":"Employer Name",formatter:"text", editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"empSalaries", "label":"Employer Salaries",editor: new YAHOO.widget.TextboxCellEditor({validator:YAHOO.widget.DataTable.validateNumber})},
            {key:"totalTaxDeducted", "label":"Total Tax Deducted",editor: new YAHOO.widget.TextboxCellEditor({validator:YAHOO.widget.DataTable.validateNumber})}
        ];

        var myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.tdsSalaries);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = {
            fields: ["empTan","empName","empSalaries","totalTaxDeducted"]
        };

        var myDataTable = new YAHOO.widget.DataTable("cellediting", myColumnDefs, myDataSource, {});

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
        
        return {
            oDS: myDataSource,
            oDT: myDataTable
        };
    }();
});
</script>
 <script>
 	YAHOO.example.Data = ${tdsSalariesJSON}
 </script>


