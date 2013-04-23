

<%@include file="../includes/tags.jspf" %>
<c:set var="activationtitle"><fmt:message key="member.activation.title"/></c:set>
<hippo-gogreen:title title="${activationtitle}"/>
<fieldset>
<legend style="color: blue"><fmt:message key="member.message.active"/></legend>
<h3><fmt:message key="member.message.info1"/></h3><br/>
<h4 style="color:green"><fmt:message key="member.message.info2"/>(${ member.email}) </h4>
</fieldset>
