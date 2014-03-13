
<%@include file="../../../includes/tags.jspf" %>

<html>
<head>
<title>Remind Inactive Users</title>

</head>
<body>

<hst:actionURL var="actionUrl" />
<form action="${actionUrl}" method="post">

 <div class="row show-grid" id="ul_revised_input">
 <div class="col-md-8">
 
 <c:if test="${not empty reminder_Sent}">
 <fmt:message key="${reminder_Sent}"></fmt:message>
 </c:if>
 </div>
 </div>
 <div class="row show-grid" id="ul_revised_input">
 <div class="col-md-8">
<input type="hidden" value="send_Reminder" name="send_Reminder" />
<input class="btn btn-info" type="submit"  name ="Send Reminder" value="Send Reminder">
</div>
</div>

</form>
</body>
</html>