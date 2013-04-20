<%--
This file is for NPV Calculator
--%>
<%@include file="../includes/commonincludes.jspf"%>


<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="memberlogin page type-page"></div>
<h3>
	<fmt:message key="npv_calculator" />
</h3>


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

