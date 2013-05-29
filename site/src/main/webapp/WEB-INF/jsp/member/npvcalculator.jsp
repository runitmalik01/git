<%--
This file is for NPV Calculator
--%>
<%@include file="../includes/tags.jspf" %>


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

<c:if test="${empty year }">
	<div id="no_year">
		<p>
			<label for="A"><fmt:message key="npv_year" />
			</label> <input required type="text" name="no_of_year" id="no_of_year"
				value="" title="Please fill this field" placeholder="In Years" onkeypress="return isNumberKey(event)" />
		</p>

		<button class="button orange" name="Submit" onclick="no_of_year()">
			<fmt:message key="npv_button" />
		</button>
	</div>
</c:if>


<c:if test="${not empty year}">
	<div id="npv1">

		<p>
			<label for="initial_invest"><fmt:message
					key="npv_initialinvestment" />
			</label> <input  type="text" name="initial_invest"
				id="initial_invest" onkeypress="return isNumberKey(event)" />
		</p>

		<p>
			<label for="rate"><fmt:message key="npv_rate" />
			</label> <input type="text" name="rate" id="rate" onkeypress="return isNumberKey(event)" />
		</p>
		<c:forEach begin="1" var="y" end="${year}">
			<p>
				<label for="cashflow"><fmt:message key="npv_cashflow" />${y}</label>
				<input type="text" name="cashflow1" id="cashflow" onkeypress="return isNumberKey(event)" />
			</p>
		</c:forEach>

		<p>
			<label for="calculate"><fmt:message key="npv_calculation" />
			</label> <input type="text" name="calculate" id="calculate"
				readonly="readonly" />
		</p>



		<a href="javascript:call()" class="button orange"><fmt:message
				key="tax_button" /> </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="javascript:back()" class="button orange"><fmt:message
				key="npv1_button" />
		</a>
	</div>
</c:if>

