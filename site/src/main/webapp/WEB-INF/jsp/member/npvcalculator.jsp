<%--
This file is for NPV Calculator
--%>
<%@include file="../includes/commonincludes.jspf"%>
<c:set var="minYear" value="1"/> 
<c:set var="maxYear" value="50"/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="memberlogin page type-page"></div>
<h3>
	<fmt:message key="npv_calculator" />
</h3>


Net Present Value (NPV) of a time series of cash flows, both incoming and outgoing, is defined as the sum of the present values of the individual cash flows with rate.
Its a tool in discounted cash flow (DCF) analysis and is a standard method for using the time value of money to appraise long-term projects and for capital budgeting as if </br>
 NPV>0,  investment would add value to firm. </br>
 NPV<0,  investment would subtract value from firm. </br>
 NPV=0,  investment would neither gain nor lose value for the firm. </br>


<%
	if (request.getQueryString() != null) {
		pageContext.setAttribute("year", request.getQueryString()
				.substring(5, request.getQueryString().length()));
	}
%>

<c:choose>
	<c:when test="${empty isValid || isValid == 'false' || empty no_of_year}">
		<hst:actionURL var="actionURL"></hst:actionURL>
		<form action="${actionURL}" method="POST" id="frmNPV">
			<p>
				<label for="initial_invest"><fmt:message
						key="npv_initialinvestment" />
				</label> <input  type="text" name="initial_invest" id="initial_invest" onkeypress="return isNumberKey(event)" />
			</p>
			<p>
				<label for="rate"><fmt:message key="npv_rate" /></label> 
				<input type="text" name="rate" id="rate" onkeypress="return isNumberKey(event)" maxlength="2"/>
			</p>		
			<p>
				<label for="A"><fmt:message key="npv_year" />
				</label> 
				<select name="no_of_year" id="no_of_year" placeholder="In Years">
					<c:forEach begin="${minYear}" end="${maxYear}" var="ctr">
						<option value="${ctr}">${ctr}</option>
					</c:forEach>
				</select>
				<%--<input required type="text" name="no_of_year" id="no_of_year" value="" title="Please fill this field" placeholder="In Years" onkeypress="return isNumberKey(event)" /> --%>
			</p>
			<a id="nxt" role="button" class="btn orange"><fmt:message key="npv_button" /></a>
		</form>
	</c:when>
	<c:otherwise>
		<input  type="hidden" name="initial_invest" id="initial_invest" value="${initial_invest}" />
		<input type="hidden" name="rate" id="rate"  maxlength="2" value="${rate}"/>
		<div id="npv1">
			<hr/>
			<h4>Initial Investment: <w4india:inr value="${initial_invest}" /></h4>
			<h4>Discount Rate: ${rate}%</h4>	
			<h5> Please fill up Net CashFlow for each year and click on Calculate </h5>			
			<table>
				<tr>
					<th>Year</th>
					<th>Discount Rate</th>
					<th>Net Cash Inflow (Annual Return)</th>
				</tr>
				<c:forEach begin="1" var="y" end="${no_of_year}">
					<tr>
						<td align="right"><label for="cashflow">${y}</label></td>			
						<td align="right">${rate}%</td>					
						<td><input style="text-align: right;" type="text" name="cashflow1" id="cashflow" onkeypress="return isNumberKey(event)"/></td>
					</tr>
				</c:forEach>
			</table>
			<p>
				<label for="calculate"><fmt:message key="npv_calculation" />
				</label> <input type="text" name="calculate" id="calculate"
					readonly="readonly" />
			</p>
	
			<a href="javascript:call()" role="button" class="btn orange"><fmt:message key="tax_button" /></a>
	        &nbsp;&nbsp;&nbsp;
			<a id="rst" role="button" class="btn orange"><fmt:message key="npv1_button" /></a>
		</div>
	</c:otherwise>
</c:choose>


		<hst:element var="uiCustom" name="script">
			<hst:attribute name="type">text/javascript</hst:attribute>

					$("#nxt").click(function(){
						//window.location.href="${scriptName}?show=" + $("#no_of_year").val() ;
						$("#frmNPV").submit();
					});

					$("#rst").click(function(){
						window.location.href="${scriptName}?show=" ;
					});

		</hst:element>
		<hst:headContribution element="${uiCustom}" category="jsInternal" />
