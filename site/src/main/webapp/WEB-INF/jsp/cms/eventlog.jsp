<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.mootly.wcm.beans.cms.compound.EventLogDetail"%>
<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionURL" />
<c:if test="${not empty eventLogDocument}">
	<c:forEach items="${eventLogDocument}" var="logDocument">
	   <c:set value="${logDocument.eventLogDetail}" var="detailloglist" scope="request"/>
	    <% List<EventLogDetail> eventlogList = (List<EventLogDetail>) request.getAttribute("detailloglist"); 
	       Collections.sort(eventlogList, new EventDetailComparator());
	       request.setAttribute("eventlogList", eventlogList);
	    %>
		<c:forEach items="${eventlogList}" var="eventlog">
			<a href="<hst:link path="${eventlog.eventLogUrl }"/>">
			<fmt:formatDate value="${eventlog.eventLogDate.time }" pattern="dd-MMM-YYYY" /><br/>
				Admin have ${eventlog.eventLogAction}&nbsp;${eventlog.eventLogDocument} </a><hr/>
		</c:forEach>
	</c:forEach>
</c:if>
<%!class EventDetailComparator implements Comparator<EventLogDetail> {
		public int compare(EventLogDetail o1, EventLogDetail o2) {
			Calendar o1Weight = o1.getEventLogDate();
			Calendar o2Weight = o2.getEventLogDate();
			if (o1Weight != null && o2Weight != null) {
				return o1Weight.compareTo(o2Weight);
			} else {
				return 0;
			}
		}
	}%>