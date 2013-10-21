<%@page import="com.mootly.wcm.services.citruspay.Transaction.CARD_TYPE"%>
<%@page import="com.mootly.wcm.model.IndianGregorianCalendar"%>
<%@include file="../../includes/tags.jspf"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.SortedSet"%>
<%@page import="com.mootly.wcm.utils.ValueListServiceImpl"%>
<%@page import="com.mootly.wcm.utils.ValueListService"%>
<%@page import="java.util.TreeMap"%>
<%
ValueListService objValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapstates = objValueListService.getStates();
request.setAttribute("objHashMapstates", objHashMapstates);
request.setAttribute("startYear", IndianGregorianCalendar.getCurrentDateInIndiaAsDate().get(Calendar.YEAR));
request.setAttribute("SavCardType", CARD_TYPE.values());
%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<c:choose>
<c:when test="${pageAction=='NEW_CHILD'}">
<div class="well">
  <form class="form-horizontal" id="payment_${fn:toLowerCase(paymentType)}" name="payment_${fn:toLowerCase(paymentType)}" method="post" action="${actionUrl}">
		<div align="justify">
		    <a href="#" title="Master Card"><img src="http://cdn.creditcardimagelogos.com/logos/mastercard_64.png" alt="Master Card"/></a>&nbsp;&nbsp;
		    <a href="#" title="Visa"><img src="http://cdn.creditcardimagelogos.com/logos/visa_64.png" alt="VISA-"/></a>&nbsp;&nbsp;
			<a href="#" title="Maestro Card"><img src="http://cdn.creditcardimagelogos.com/logos/maestro_64.png" alt="Maestro Card"/></a>
		</div>
		<fieldset>
			<legend class="">Payment</legend>
			<!-- Name -->
			<div class="row-fluid show-grid">
				<div class="span6">
					<div class="rowlabel">
						<label for="cardHolderName"><small>Card Holder's Name</small></label>
					</div>
					<div class="rowlabel">
						<input type="text" id="cardHolderName" name="cardHolderName" placeholder="" class="search-query">
					</div>
				</div>
				<div class="span6" align="center">
					<div class="rowlabel">
						<label for="paymentDate"><small>Payment Date</small></label>
					</div>
					<div class="rowlabel">
						<strong><%=IndianGregorianCalendar.getCurrentDateInIndiaAsString()%></strong>
					</div>
				</div>
			</div>
			<!-- Card Number -->
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="cardNumber"><small>Card Number</small></label>
					</div>
					<div class="rowlabel">
						<input type="text" id="cardNumber" name="cardNumber" placeholder="" class="search-query" maxlength="16"/>
					</div>
				</div>
				<div class="span2">
					<div class="rowlabel">
						<label for="cardType"><small>Card Type</small></label>
					</div>
					<div class="rowlabel">
						<select id="cardType" name="cardType" class="span10">
						  <option value="">-Select-</option>
						  <c:forEach items="${SavCardType}" var="crdTyp">
						    <option value="${crdTyp}">${crdTyp}</option>
						  </c:forEach>						  
						</select>
					</div>
				</div>
				<div class="span6" align="center">
					<div class="rowlabel">
						<label for="paymentAmount"><small>Payment Amount</small></label>
					</div>
					<div class="rowlabel">
						<strong><w4india:inr value="${parentBean.amountDue}"></w4india:inr></strong>
					</div>
				</div>
			</div>
			<!-- Expiry-->
			<div class="row-fluid show-grid">
				<div class="span3">
					<div class="rowlabel">
						<label for="expiryMonth"><small>Card Expiry Month</small></label>
					</div>
					<div class="rowlabel">
						<select class="span8" name="expiryMonth" id="expiryMonth">
							<option value="">-Select-</option>
							<option value="01">Jan (01)</option>
							<option value="02">Feb (02)</option>
							<option value="03">Mar (03)</option>
							<option value="04">Apr (04)</option>
							<option value="05">May (05)</option>
							<option value="06">June (06)</option>
							<option value="07">July (07)</option>
							<option value="08">Aug (08)</option>
							<option value="09">Sep (09)</option>
							<option value="10">Oct (10)</option>
							<option value="11">Nov (11)</option>
							<option value="12">Dec (12)</option>
						</select>
					</div>
				</div>
				<div class="span3">
					<div class="rowlabel">
						<label for="expiryYear"><small>Card Expiry Year</small></label>
					</div>
					<div class="rowlabel">
						 <select class="span8" name="expiryYear" id="expiryYear">
						    <option value="">-Select-</option>
							<c:forEach var="expYear" begin="${startYear}" end="${startYear + 20}">
							  <option value="${expYear}">${expYear}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="span6" align="center">
					<div class="rowlabel">
						<label for="paymentAmount"><small>Invoice Number</small></label>
					</div>
					<div class="rowlabel">
						<strong><w4india:inr value="${parentBean.invoiceNumber}"></w4india:inr></strong>
					</div>
				</div>
			</div>
			<!-- CVV -->
			<c:set var="helpText"><input type="image" src="<hst:link path="/images/CVVcodepic.jpg"/>" height="150" width="150"/></c:set>
			<div class="row-fluid show-grid">
				<div class="span2">
					<div class="rowlabel">
						<label for="cvvNumber"><small>Card CVV</small></label>
					</div>
					<div class="rowlabel">
						<div class="input-append">
							<input type="password" id="cvvNumber" name="cvvNumber" placeholder="" class="search-query" maxlength="3">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="label" id="helpOver"><i class="icon-question-sign iconwhite"></i></span>
						</div>
						<a href="http://www.cvvnumber.com/cvv.html" target="_blank" style="font-size: 11px">What is my CVV code?</a>
					</div>
				</div>
			</div>
			<div class="alert alert-info">Click on the
				Pay Now button. You will be redirected to a secure payment
				gateway for payment. After successful payment authorization, you
				will be redirected to Wealth4India's confirmation page.</div>
			<!-- Submit -->
			<div class="control-group">
				<div class="controls">
					<button class="btn btn-success" type="submit" id="payment_submit">Pay Now</button>
					<a class="btn btn-default"  href="${scriptName}" id="payment_submit"><strong>Cancel</strong></a>
				</div>
			</div>
		</fieldset>
	</form>
</div>
</c:when>
<c:otherwise>
<c:if test="${pageAction =='EDIT_CHILD'}">
			<div class="page well" align="justify">
			   <div class="alert alert-success"><strong>Successfully Amount paid Description for Invoice Number ${parentBean.invoiceNumber}</strong></div>
				<div class="row-fluid show-grid">
					<div class="span4">
						<div class="rowlabel">
							<label for="lastName"><small>Last Name</small></label>
						</div>
						<div class="rowlabel">${memberpersonalinformation.lastName}</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="firstName"><small>First Name</small></label>
						</div>
						<div class="rowlabel">${memberpersonalinformation.firstName}</div>
					</div>
					<div class="span4" align="center">
						<div class="rowlabel">
							<label for="paymentDate"><small>Payment Date</small></label>
						</div>
						<div class="rowlabel"><c:forEach items="${parentBean.invoicePaymentDetailList}" var="paymentdetail">
						   <c:if test="${uuid == paymentdetail.canonicalUUID}"><fmt:formatDate value="${paymentdetail.paymentDate.time}" pattern="dd-MMM-yyyy"/></c:if>
						</c:forEach></div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span8">
						<div class="rowlabel">
							<label for="email"><small>Billing E-Mail</small></label>
						</div>
						<div class="rowlabel"><%=request.getUserPrincipal().getName()%>
						</div>
					</div>
					<div class="span4" align="center">
						<div class="rowlabel">
							<label for="amount"><small>Amount Paid</small></label>
						</div>
						<div class="rowlabel"><c:forEach items="${parentBean.invoicePaymentDetailList}" var="paymentdetail">
						   <c:if test="${uuid == paymentdetail.canonicalUUID}"><strong><w4india:inr value="${paymentdetail.paymentAmount}"></w4india:inr></strong></c:if>
						</c:forEach>
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span6">
						<div class="rowlabel">
							<label for="bilingAddress"><small>Billing Address</small></label>
						</div>
						<div class="rowlabel">${memberpersonalinformation.flatDoorBuilding},${memberpersonalinformation.roadStreet},${memberpersonalinformation.areaLocality}</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span5">
						<div class="rowlabel">
							<label for="pi_townCity"><small>Address City</small></label>
						</div>
						<div class="rowlabel">${memberpersonalinformation.townCityDistrict}</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<label for="pi_state"><small>Address State</small></label>
						</div>
						<div class="rowlabel">
							<c:forEach var="booleanCombo" items="${objHashMapstates}">
								<c:if test="${memberpersonalinformation.state == booleanCombo.key}">${booleanCombo.value}</c:if>
							</c:forEach>
						</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<label for="pi_pinCode"><small>Pin/Zip Code</small></label>
						</div>
						<div class="rowlabel">${memberpersonalinformation.pinCode}</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span5">
						<div class="rowlabel">
							<label for="pi_mobile"><small>Mobile</small></label>
						</div>
						<div class="rowlabel">${memberpersonalinformation.mobile}</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span12">
						<div class="rowlabel" align="right">
							<a class="btn btn-primary" href="${scriptName}">Back</a>
						</div>
					</div>
				</div>
			</div>
		</c:if>
</c:otherwise>
</c:choose>
<res:client-validation screenConfigurationDocumentName="credit_card" formId="payment_${fn:toLowerCase(paymentType)}" formSubmitButtonId="payment_submit"></res:client-validation>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
     $(document).ready(function(){
        //alert("hey");
		  $('#helpOver').popover({
		    placement: 'right',
		    trigger: 'hover', 
		    title: '<strong>CVV Number of <c:out value="${fn:replace(paymentType,'_',' ') }"/></strong>',
		    content: '<c:out value="${helpText}" escapeXml="false"/>',
		    html: true
		  }); 
	  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />