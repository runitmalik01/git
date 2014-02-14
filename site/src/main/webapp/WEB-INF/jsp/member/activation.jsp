<%@include file="../includes/tags.jspf" %>
<c:set var="activationtitle"><fmt:message key="member.activation.title"/></c:set>
<hippo-gogreen:title title="${activationtitle}"/>
<hst:link var="home" path="/"/>

<c:choose>
	<c:when test="${not empty isError}">
		<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <div class="error-details">
                     <c:if test="${not empty isError}">
                     You have already activated your account. Please Signup with your given ID and Password.
                    </c:if>
                </div>
                <div class="error-actions">
                    <a href="${home}" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a><a href="mailto:<w4india:emailcustomerservice/>" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contact Support </a>
                </div>
            </div>
        </div>
    </div>
</div>
	</c:when>
	<c:when test="${not empty isEmpty}">
			<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <div class="error-details">
                     <c:if test="${not empty isEmpty}">
                     Activation link not found. Please contact <a href="mailto:<w4india:emailcustomerservice/>"><w4india:emailcustomerservice/></a>.
                    </c:if>
                </div>
                <div class="error-actions">
                    <a href="${home}" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a><a href="mailto:<w4india:emailcustomerservice/>" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contact Support </a>
                </div>
            </div>
        </div>
    </div>
</div>
	</c:when>
	<c:otherwise>
		<legend style="color: blue"><fmt:message key="member.message.active"/></legend>
		<h3><fmt:message key="member.message.info1"/></h3><br/>
		<h4 style="color:green"><fmt:message key="member.message.info2"/>(${userName}) </h4>
	</c:otherwise>
</c:choose>

<style>
.error-template {padding: 40px 15px;text-align: center;}
.error-actions {margin-top:15px;margin-bottom:15px;}
.error-actions .btn { margin-right:10px; }
</style>