<%@page import="com.mootly.wcm.model.IndianGregorianCalendar"%>
<%@include file="../../includes/tags.jspf"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.SortedSet"%>
<%@page import="com.mootly.wcm.utils.ValueListServiceImpl"%>
<%@page import="com.mootly.wcm.utils.ValueListService"%>
<%@page import="java.util.TreeMap"%>
<%
ValueListService objValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapstates = objValueListService.getStates();
request.setAttribute("objHashMapstates", objHashMapstates);
%>
<c:set var="parentBeantitle">
	Payment(NetBanking)
</c:set>
<hippo-gogreen:title title="${parentBeantitle}"/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<hst:link var="home" siteMapItemRefId="itreturnhome"></hst:link>
<hst:link var="invoiceLink" siteMapItemRefId="memberinvoice"></hst:link>
<ul class="breadcrumb">
	<li><a href="${home}" class="btn btn-info"><i class="icon-home icon-white"></i><strong>Home</strong></a> <span class="divider">/</span></li>
	<li><a href="${scriptName}" class="btn btn-info"><i class="icon-file icon-white"></i><strong>Member Invoices</strong></a><span class="divider">/</span></li>
	<li class="active"><a href="" class="btn btn-info"><strong>Net Banking</strong></a></li>
</ul>
<c:choose>
<c:when test="${pageAction == 'NEW_CHILD'}">
<form name="payment_net_banking" id="payment_net_banking" method="post" action="${actionUrl}">
	<div class="page well" align="justify">
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="lastName"><small>Last Name</small></label>
				</div>
				<div class="rowlabel">
					<input name="lastName" type="text" value="${memberpersonalinformation.lastName}" id="lastName"/>
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="firstName"><small>First Name</small></label>
				</div>
				<div class="rowlabel">
					<input name="firstName" type="text" value="${memberpersonalinformation.firstName}" id="firstName"/>
				</div>
			</div>
			<div class="span4" align="center">
				<div class="rowlabel">
					<label for="paymentDate"><small>Payment Date</small></label>
				</div>
				<div class="rowlabel">
					<strong><%=IndianGregorianCalendar.getCurrentDateInIndiaAsString()%></strong>
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span8">
				<div class="rowlabel">
					<label for="email"><small>Billing E-Mail</small></label>
				</div>
				<div class="rowlabel">
					<input name="email" type="text" value="<%=request.getUserPrincipal().getName()%>" id="email"/><span
						class="help-inline"> Where should we send invoices?</span>
				</div>
			</div>
			<div class="span4" align="center">
				<div class="rowlabel">
					<label for="amount"><small>Amount</small></label>
				</div>
				<div class="rowlabel">
					<strong><w4india:inr value="${parentBean.amountDue}"></w4india:inr></strong>
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span6">
				<div class="rowlabel">
					<label for="bilingAddress"><small>Billing Address</small></label>
				</div>
				<div class="rowlabel">
					<textarea rows="3" cols="1"  name="bilingAddress" id="bilingAddress">${memberpersonalinformation.flatDoorBuilding},${memberpersonalinformation.roadStreet},${memberpersonalinformation.areaLocality}</textarea>			
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span5">
				<div class="rowlabel">
					<label for="pi_townCity"><small>Address City</small></label>
				</div>
				<div class="rowlabel">
					<input name="pi_townCity" type="text" value="${memberpersonalinformation.townCityDistrict}" id="pi_townCity"/>				
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="pi_state"><small>Address State</small></label>
				</div>
				<div class="rowlabel">
					<select id="pi_state" name="pi_state" class="uprcase span12">
						<option value="">-Select-</option>
						<c:forEach var="booleanCombo" items="${objHashMapstates}">
							<option <c:if test="${memberpersonalinformation.state == booleanCombo.key}">selected</c:if>
								value="${booleanCombo.key}">${booleanCombo.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="pi_pinCode"><small>Pin/Zip Code</small></label>
				</div>
				<div class="rowlabel">
					<input name="pi_pinCode" type="text" value="${memberpersonalinformation.pinCode}" id="pi_pinCode"/>				
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span5">
				<div class="rowlabel">
					<label for="pi_mobile"><small>Mobile</small></label>
				</div>
				<div class="rowlabel">
					<input name="pi_mobile" type="text" value="${memberpersonalinformation.mobile}" id="pi_mobile"/>				
				</div>
			</div>
		</div><br/>
		<div class="row-fluid show-grid">
			<div class="span12">
				<div class="rowlabel">
					<div class="alert alert-info">I son/daughter of P. P.
						GUPTA solemnly declare that to the best of my knowledge and
						belief, the information given in the return there to is correct
						and complete and that the amount of total income and other
						particulars shown therein are truly stated and are in accordance
						with provisions of Income-tax Act, 1961, in respect of income
						chargeable to Income-tax for the previous year relevant to the
						Assessment Year 2013-2014</div>
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span12">
				<div class="rowlabel" align="right">
				    <button type="submit" name="pay" class="btn btn-success"><i class=" icon-ok-sign icon-white"></i>Pay (Net Banking)</button>
				    <!-- <input type="submit" name="pay" class="btn orange" value="PayNetBanking"/>
					<a class="btn btn-success" href="#" id="payNetBanking"><i class=" icon-ok-sign icon-white"></i>Pay (Net Banking)</a> -->				
				</div>
			</div>
		</div>
	</div>
</form>
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
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
     $('#payNetBanking').on('click',function(){
        //alert("hey");
		  $('#payment_net_banking').submit(); 
	  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />