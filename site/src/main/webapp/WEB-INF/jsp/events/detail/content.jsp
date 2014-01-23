
<%--@elvariable id="document" type="com.mootly.wcm.beans.EventDocument"--%>
<%@include file="../../includes/tags.jspf"%>
<%@page import=" java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page
	import="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>

<%@page import="java.util.Calendar"%>
<!-- NOTE: Switch on the following variable if you want to eanble Inline Editing feature in this page. -->
<c:set var="inlineEditingEnabled" value="false" />

<c:if test="${preview}">
	<c:if test="${inlineEditingEnabled}">
		<jsp:include page="../../inc/inline-editing-head-contributions.jsp" />
	</c:if>
</c:if>

<hippo-gogreen:title title="${document.title}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<ol class="breadcrumb">
	<li><fmt:message key="events.overview.location.label" />${deletelink}</li>
	<li><hst:link var="home" siteMapItemRefId="home" /><a
		href="${home}"><fmt:message key="events.overview.location.home" />
	</a> &gt;</li>
	<li><hst:link var="events" siteMapItemRefId="events" /> <a
		href="${events}"><fmt:message key="events.overview.title" /> </a>
		&gt;</li>
</ol>
<c:choose>
	<c:when test="${not empty editlink }">
		<form id="events" action="${actionUrl}" name="events" method="post">
			<fieldset>
				<legend>Edit Your own Events</legend>
				<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="title">Title Of Events </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="title" name="title"
								value="${document.title}" />
						</div>
					</div>
				</div>
				<%-- <div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="date"> End Date </label>
						</div>
						<div class="rowlabel">
							<input type="date" id="date" name="date"
								value ="<fmt:formatDate
						value="${document.endDate.time}" pattern="MMM dd, yyyy" />"/>
						</div>
					</div>
				</div> --%>
				<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="newstartdate"> Start Date </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="newstartdate" name="newstartdate"
								value="${document.newStartDate}" />
						</div>
					</div>
				</div>


				<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="newenddate"> End Date </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="newenddate" name="newenddate"
								value="${document.newEndDate}" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="summary">Summary </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="summary" name="summary"
								value="${document.summary}" />
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="description">Description </label>
						</div>
						<div class="rowlabel">
							<textarea name="description" id="description" rows="20"
								value="<c:if test="${preview}">editable</c:if> inline"
								id="mootlywcm:description">
							<c:out value="${document.description.content}" escapeXml="false" />
								<%-- <hst:html
								hippohtml="${document.description}"/> --%>
							</textarea>
							<w4india:ckeditor_inline textAreaId="description" />
						</div>
					</div>
				</div>
				<input type="submit" class="btn btn-default btn-success"
					value="Save">
			</fieldset>
		</form>
	</c:when>
	<c:when test="${not empty deletelink}">
		<form id="events" action="${actionUrl}" name="events" method="post">
			<fieldset>
				<legend>Edit Your own Events</legend>
				<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="title">Title Of Event </label>
						</div>
						<div class="rowlabel">
							<c:out value="${document.title}" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="deleteevent">Are you sure want to delete ?</label>
						</div>
						<div class="rowlabel">
							<select id="deleteevent" name="deleteevent">
								<option value="select">-Select-</option>
								<option value="yes">Yes</option>
								<option value="no">No</option>
							</select>
						</div>
					</div>
				</div>
				<input type="submit" class="btn btn-default btn-success"
					value="Save">
			</fieldset>
		</form>
	</c:when>
	<c:otherwise>
		<div id="content"
			class="yui-b left-and-right <c:if test="${preview}"> editable</c:if>">
			<h2 class="title">
				<c:out value="${document.title}" />
			</h2>

			<div id="article" class="event">
				<hst:cmseditlink hippobean="${document}" var="editLink" />
				<c:if test="${fn:length(document.images) > 0}">
					<hippo-gogreen:image-gallery />
					<hippo-gogreen:imagecopyright image="${document.images[0]}" />
				</c:if>

				<%--
            <c:set var="image" value="${document.firstImage}"/>
            <c:if test="${image != null}">
                <hst:link var="src" hippobean="${image.largeThumbnail}"/>
                <img class="image" src="${src}" alt="${fn:escapeXml(image.alt)}"/>
                <hippo-gogreen:imagecopyright image="${image}"/>
            </c:if>
             --%>


				<%-- <div class="calendar">
					<span class="month"><fmt:formatDate
							value="${document.date.time}" pattern="MMM" /> </span> <span
						class="day"><fmt:formatDate value="${document.date.time}"
							pattern="dd" /> </span>
				</div> --%>
				<div class="date">
					<c:out value="${document.newStartDate}" />
					&nbsp;-&nbsp;
					<c:out value="${document.newEndDate}" />
				</div>

				<div id="editable_cont" class="inline-editor-editable-container">
					<span class="<c:if test="${preview}">editable</c:if>"
						id="mootlywcm:summary"><c:out value="${document.summary}" />
					</span>
					<div></div>
					<div class="yui-cssbase body">
						<span class="<c:if test="${preview}">editable</c:if> inline"
							id="mootlywcm:description"><hst:html
								hippohtml="${document.description}" /> </span>
						<hippo-gogreen:copyright document="${document}" />
					</div>
				</div>

				<ul id="document-actions">
					<li><a class="comment" href="#comment"><fmt:message
								key="events.overview.comment" /> </a></li>
				</ul>
			</div>
			<c:if test="${not empty document.location}">
				<input id="address" type="hidden"
					value="${document.location.street}&nbsp;${document.location.number},&nbsp;${document.location.city}&nbsp;
					${document.location.postalCode}&nbsp;${document.location.province}" />
			</c:if>
			<hst:include ref="comments" />

		</div>
	</c:otherwise>
</c:choose>

<res:client-validation formId="events"
	screenConfigurationDocumentName="newevents" />

<c:if test="${preview && inlineEditingEnabled}">
	<jsp:include page="../../inc/inline-editing-editor-form.jsp" />
</c:if>
