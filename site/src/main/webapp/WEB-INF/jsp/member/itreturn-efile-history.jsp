<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="ditsynctitle">
	<fmt:message key="member.ditsyn.title" />
</c:set>
<w4india:itrmenu />
<hippo-gogreen:title title="${ditsynctitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
		<h1>E File History</h1>
		<c:choose>
			<c:when test="${empty ditresponsedocument}">
				No information found.
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>Date/Time</th>
						<th>Submission Status</th>
						<th>Ack #</th>
						<th>Token #</th>  
					</tr>
					<c:forEach items="${ditresponsedocument.efileHistory}" var="eFileHistoryItem">
						<tr>
							<td>${eFileHistoryItem.eFileDateTime}</td>
							<td>${eFileHistoryItem.ditSubmissionStatus}</td>
							<td>${eFileHistoryItem.ackResponse}</td>
							<td>${eFileHistoryItem.result}</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</div>

