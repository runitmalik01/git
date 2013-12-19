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
<%--@elvariable id="document" type="com.mootly.wcm.beans.EventDocument"--%>
<%@include file="../../includes/tags.jspf"%>

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
		href="${events}"><fmt:message key="events.overview.title" />
	</a> &gt;</li>
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
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="date"> End Date </label>
						</div>
						<div class="rowlabel">
							<input type="date" id="date" name="date"
								value="${document.endDate.time}" />
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="description">Description </label>
						</div>
						<div class="rowlabel">
							<textarea class="field col-md-12" id="description"
								name="description"
								value="<span class="<c:if test="${preview}">editable</c:if> inline"
							id="mootlywcm:description"><hst:html
								hippohtml="${document.description}"/></span>"></textarea>

						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="rowlabel">
						<input type="submit" value="Save" style="color: blue;">
					</div>

				</div>
			</fieldset>
		</form>
	</c:when>
	<c:when test="${not empty deletelink}">
		<form id="events" action="${actionUrl}" name="events" method="post">
			<fieldset>
				<legend>Edit Your own Events</legend>

				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="deleteevent">Are you sure want to delete ?</label>
						</div>
						<div class="rowlabel">
							<select id="deleteevent" name="deleteevent">
								<option value="yes">Yes</option>
								<option value="no">NO</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="rowlabel">
						<input type="submit" value="Save" style="color: blue;">
					</div>

				</div>
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
				<span class="date"> <fmt:formatDate
						value="${document.date.time}" pattern="MMM dd, yyyy" />&nbsp;-&nbsp;
					<fmt:formatDate value="${document.endDate.time}"
						pattern="MMM dd, yyyy" /> </span>

				<div class="calendar">
					<span class="month"><fmt:formatDate
							value="${document.date.time}" pattern="MMM" /> </span> <span
						class="day"><fmt:formatDate value="${document.date.time}"
							pattern="dd" /> </span>
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


<c:if test="${preview && inlineEditingEnabled}">
	<jsp:include page="../../inc/inline-editing-editor-form.jsp" />
</c:if>
