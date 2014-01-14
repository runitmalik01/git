

<%@include file="../includes/tags.jspf"%>
<jsp:useBean id="now" class="java.util.Date" />

<c:set var="overviewtitle">
	<fmt:message key="events.overview.title" />
</c:set>
<hippo-gogreen:title title="${overviewtitle}" />
<hst:link var="events" siteMapItemRefId="events" />

<!-- Events Overview -->
<div class="page" id="events">
	<ol class="breadcrumb">
		<li><fmt:message key="events.overview.location.label" /></li>
		<li><hst:link var="home" siteMapItemRefId="home" /> <a
			href="${home}"><fmt:message key="events.overview.location.home" />
		</a> &gt;</li>
	</ol>

	<div class="row show-grid">
		<span class="col-md-8">
			<li><fmt:message key="events.overview.title" />
				&nbsp;&nbsp;&nbsp; <hst:link var="linknew" hippobean="${document}" />
				<c:if test="${isVendor eq 'true' }">
					<a class="btn btn-default btn-primary" href="${events}/newEvent"><small><i
							class="glyphicon glyphicon-plus glyphicon glyphicon-white"></i>Create
							New</small></a>
				</c:if></li> <c:forEach var="document" items="${documents.items}">
				<ul class="event-item<c:if test="${preview}"> editable</c:if>">
					<hst:link var="link" hippobean="${document}" />
					<li class="title"><hst:cmseditlink hippobean="${document}"
							var="cmsEditLink" /><a href="${link}"><c:out
								value="${document.title}" /> </a></li>


					<li class="day"><fmt:formatDate value="${document.date.time}"
							pattern="dd" /></li>
					<li class="month"><fmt:formatDate
							value="${document.date.time}" pattern="MMM" /></li>
					<li class="text"><c:out value="${document.summary}" /></li>
					<c:if test="${isVendor eq 'true' }">
						<a class="btn btn-default btn-sm btn-success"
							href="${link}?edit=editEvent"><small><i
								class="glyphicon glyphicon-pencil"></i>Edit</small></a> &nbsp;&nbsp;&nbsp;<a
							class="btn btn-default btn-sm btn-danger"
							href="${link}?delete=deleteLink"><small><i
								class="glyphicon glyphicon-trash"></i>Delete</small></a>
					</c:if>
				</ul>
			</c:forEach> <hippo-gogreen:pagination pageableResult="${documents}" />
		</span> <span class="col-md-4"> <!-- right -->
			<div id="events">
				<h2>
					<fmt:message key="events.calendar.title" />
				</h2>
				<h3>
					<c:out value="${calendar.monthName}" />
					&nbsp;
					<c:out value="${calendar.year}" />
				</h3>
				<hst:renderURL var="prev">
					<hst:param name="month" value="${calendar.prevMonth}" />
					<hst:param name="year" value="${calendar.prevMonthYear}" />
				</hst:renderURL>
				<span class="nav prev"><a href="${prev}"><fmt:message
							key="events.calendar.previous" /> </a> </span>
				<hst:renderURL var="next">
					<hst:param name="month" value="${calendar.nextMonth}" />
					<hst:param name="year" value="${calendar.nextMonthYear}" />
				</hst:renderURL>
				<span class="nav next"><a href="${next}"><fmt:message
							key="events.calendar.next" /> </a> </span>
				<table id="calendar">
					<tr>
						<th><fmt:message key="events.calendar.monday" /></th>
						<th><fmt:message key="events.calendar.tuesday" /></th>
						<th><fmt:message key="events.calendar.wednesday" /></th>
						<th><fmt:message key="events.calendar.thursday" /></th>
						<th><fmt:message key="events.calendar.friday" /></th>
						<th><fmt:message key="events.calendar.saturday" /></th>
						<th><fmt:message key="events.calendar.sunday" /></th>
					</tr>
					<c:forEach var="week" items="${calendar.weeks}">
						<tr>
							<c:forEach var="day" items="${week.days}">
								<c:choose>
									<c:when test="${day.dummy}">
										<td class="disabled"></td>
									</c:when>
									<c:when test="${day.numberOfEvents > 0}">
										<td class="event box"><hst:link var="imgLink"
												path="/images/box-event-arrow.png" /> <img src="${imgLink}"
											class="arrow" /> <a href="#"><c:out
													value="${day.dayOfMonth}" /> </a> <c:if
												test="${day.numberOfEvents >1}">
												<span class="count"><c:out
														value="${day.numberOfEvents}" /> </span>
											</c:if>
											<ul class="info">
												<li class="top"></li>
												<li class="date-title"><c:out value="${day.dayOfMonth}" />&nbsp;<c:out
														value="${calendar.monthName}" />&nbsp;<c:out
														value="${calendar.year}" /></li>
												<c:forEach var="event" items="${day.events}" begin="0"
													end="1">
													<hst:link var="eventLink" hippobean="${event}" />
													<li class="title"><a href="${eventLink}"><c:out
																value="${event.title}" /> </a></li>
													<li class="text"><c:out value="${event.summary}" /></li>
												</c:forEach>
												<li class="bottom"></li>
											</ul></td>
									</c:when>
									<c:otherwise>
										<td><c:out value="${day.dayOfMonth}" /></td>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
			</div>
		</span>
	</div>
</div>
