
<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionURL" />
<div class="page">
	<h4>
		Welcome to Income Tax Return Preparation for Financial Year:
		<c:out value="${financialYear.displayName}" />
	</h4>
	<p>
		List of available packages for Filing Status <b><c:out
				value="${filingStatus.name}" /> </b>
	</p>
	<small>Select the package which suits your need and then click
		on Start Filing the Taxes</small>
	<%
		String pan = (String) request.getAttribute("pan");
	%>
	<form id="frmdata" method="post" action="${actionURL}">
		<input type="hidden" name="selectionUUID" value="${selectionUUID}" />
		<input type="hidden" id="partNumber" name="partNumber" value="" /> <input
			type="hidden" id="pan" name="pan" value="${pan}" /> <input
			type="hidden" id="filingstatus" name="filingstatus"
			value="${filingStatus.name}" /> <input type="hidden"
			id="financialyear" name="financialyear"
			value="${financialYear.displayName}" />
			<input type="hidden" id="package" name="package"/>
		<div class="row-fluid show-grid rowlabel">
			<div class="span4"></div>
		</div>
		
		<c:if test="${(financialYear.displayName eq '2012-2013')}">
		<c:choose>
				<c:when test="${( filingStatus.name eq 'Individual')}">
				<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#doityourself" data-toggle="tab">Do
					It Yourself </a>
			</li>
			<li><a href="#assistedfiling" data-toggle="tab">Assisted
					Filing</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active " id="doityourself">
				<table class="table" width="100%">
					<thead class='header'>
						<tr>
							<th width="15%"><fmt:message key="service.price.title1" />
							</th>

							<c:forEach items="${documents}" var="document">
								<td width="5%"><c:out value="${document.title}" /></td>
							</c:forEach>
						</tr>
						<tr>
							<th width="15%"><fmt:message key="service.price.subtitle" />
							</th>
							<c:forEach items="${documents}" var="document">
								<td width="15%"><c:out value="${document.subTitle}" /></td>
							</c:forEach>
						</tr>
						<tr>
							<th width="15%"><fmt:message key="service.price.pricing" />
							</th>
							<c:forEach items="${documents}" var="document">
								<td width="5%"><c:if test="${!fn:contains(document.pricing,'Free')}">
										<c:choose>
											<c:when test="${document.title eq 'DELUXE'}">
												<img src="images/rupeeGreen.gif" />
											</c:when>
											<c:otherwise>
												<img src="images/rupeeBlue.gif" />
											</c:otherwise>
										</c:choose>
									</c:if> <c:out value="${document.pricing}" /><br/> 
									<a id="hrefSubmit<c:out value="${fn:toLowerCase(document.title)}"/>" class="btn orange">Start</a></td>
							</c:forEach>
						</tr>
					</thead>
					<tr>
						<th width="15%"><fmt:message key="service.price.description" />
						</th>
						<c:forEach items="${documents}" var="document">
							<td width="5%"><c:out value="${document.description}" /></td>
						</c:forEach>
					</tr>
					<tr>
						<th width="15%"><fmt:message key="service.price.features" />
						</th>
						<c:forEach items="${documents}" var="document">
							<td width="5%">
								<h5>
									<small> Recommended if you:</small>
								</h5> <c:forEach items="${document.features}" var="features">
									<c:out value="${features}" />
								</c:forEach>
								<br/>
								<a href='<hst:link path="/serviceprice"/>' target="_blank">Know More</a>	
								</td>
						</c:forEach>
					</tr>
				</table>
				</div>
		<%--	<div class="modal-footer">
					<a href='<hst:link path="/serviceprice"/>' target="_blank">Know More</a>
				</div> 
				 --%>
			<div class="tab-pane fade" id="assistedfiling">
				<div id="#assistedfiling">

					<b><i>File with assistance of Tax Professionals from
							anywhere!</i> </b><br />
					<div class="tabText">
						<span class="tab2SubHeading"><strong>1. Schedule
								an Appointment</strong> </span><br /> <span class="fontArial fontSize12 ">Schedule
							an appointment with a tax expert by paying a small fee.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>2. Share your
								tax document</strong> </span><br /> <span class="fontArial fontSize12 ">Upload
							your documents that will help the expert to prepare your return.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>3.
								Interaction</strong> </span><br /> <span class="fontArial fontSize12 ">Chat
							/ Talk to the expert to finalise your tax return.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>4. Review
								&amp; Approval</strong> </span><br /> <span class="fontArial fontSize12 ">Check
							your tax return and give approval to file.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>5. Payment</strong> </span><br />
						<span class="fontArial fontSize12 ">Pay your fee online or
							by cheque.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>6. Filing</strong> </span><br />
						<span class="fontArial fontSize12 ">Get your tax filed and
							hoards of other value additions.</span>
					</div>
					<br/> <a id="hrefSubmitassisted" class="btn orange">Start</a>
				</div>
			</div>		
		</div>
		</c:when>
				<c:otherwise>
				<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#assistedfiling" data-toggle="tab">Assisted
					Filing</a>
			</li>
		</ul>
				<div class="tab-pane fade in active " id="assistedfiling">
				<div id="#assistedfiling">

					<b><i>File with assistance of Tax Professionals from
							anywhere!</i> </b><br />
					<div class="tabText">
						<span class="tab2SubHeading"><strong>1. Schedule
								an Appointment</strong> </span><br /> <span class="fontArial fontSize12 ">Schedule
							an appointment with a tax expert by paying a small fee.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>2. Share your
								tax document</strong> </span><br /> <span class="fontArial fontSize12 ">Upload
							your documents that will help the expert to prepare your return.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>3.
								Interaction</strong> </span><br /> <span class="fontArial fontSize12 ">Chat
							/ Talk to the expert to finalise your tax return.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>4. Review
								&amp; Approval</strong> </span><br /> <span class="fontArial fontSize12 ">Check
							your tax return and give approval to file.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>5. Payment</strong> </span><br />
						<span class="fontArial fontSize12 ">Pay your fee online or
							by cheque.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>6. Filing</strong> </span><br />
						<span class="fontArial fontSize12 ">Get your tax filed and
							hoards of other value additions.</span>
					</div>
					<br/> <a id="hrefSubmitassisted" class="btn orange">Start</a>
				</div>
			</div>	
				</c:otherwise>
				</c:choose>
				</c:if>
		<c:if
			test="${(financialYear.displayName eq '2011-2012') || (financialYear.displayName eq '2010-2011')}">
				<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#assistedfiling" data-toggle="tab">Assisted
					Filing</a>
			</li>
		</ul>
		<div class="tab-pane fade in active " id="assistedfiling">
				<div id="#assistedfiling">
					<b><i>File with assistance of Tax Professionals from
							anywhere!</i> </b><br />
					<div class="tabText">
						<span class="tab2SubHeading"><strong>1. Schedule
								an Appointment</strong> </span><br /> <span class="fontArial fontSize12 ">Schedule
							an appointment with a tax expert by paying a small fee.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>2. Share your
								tax document</strong> </span><br /> <span class="fontArial fontSize12 ">Upload
							your documents that will help the expert to prepare your return.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>3.
								Interaction</strong> </span><br /> <span class="fontArial fontSize12 ">Chat
							/ Talk to the expert to finalise your tax return.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>4. Review
								&amp; Approval</strong> </span><br /> <span class="fontArial fontSize12 ">Check
							your tax return and give approval to file.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>5. Payment</strong> </span><br />
						<span class="fontArial fontSize12 ">Pay your fee online or
							by cheque.</span>
					</div>
					<div class="tabText1">
						<span class="tab2SubHeading"><strong>6. Filing</strong> </span><br />
						<span class="fontArial fontSize12 ">Get your tax filed and
							hoards of other value additions.</span>
					</div>
					<br/> <a id="hrefSubmitassisted" class="btn orange">Start</a>
				</div>
			</div>		
			</c:if>
	</form>
</div>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	$(document).ready(function() {
		$('#hrefSubmitbasic').click(function() {			 
			 $("#partNumber").val("<c:out value="${financialYear.displayName}" />_<c:out
		value="${filingStatus.fourthCharInPAN}" />_basic");
		$('#package').val('basic');
			 $('#frmdata').submit();
		});
		$('#hrefSubmitpremier').click(function() {
			 $("#partNumber").val("<c:out value="${financialYear.displayName}" />_<c:out
		value="${filingStatus.fourthCharInPAN}" />_premier");
		$('#package').val('premier');
			 $('#frmdata').submit();
		});
		$('#hrefSubmitassisted').click(function() {
			 $("#partNumber").val("<c:out value="${financialYear.displayName}" />_<c:out
		value="${filingStatus.fourthCharInPAN}" />_assisted");
		$('#package').val('assisted');
			 $('#frmdata').submit();			 
		});
			
	});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />






