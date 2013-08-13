<%@page import="com.mootly.wcm.model.PaymentVerificationStatus"%>
<%@page import="com.mootly.wcm.model.ITRServiceDelivery"%>
<%@page import="com.mootly.wcm.model.ITRForm"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="com.mootly.wcm.model.PaymentType"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="itrpayment_title">
	<fmt:message key="member.itrpayment.title" />
</c:set>
<hippo-gogreen:title title="${itrpayment_title}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<%
	ITRForm itrForm;
	ITRServiceDelivery itrServiceDelivery;
	MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request
			.getAttribute(MemberPersonalInformation.class
					.getSimpleName().toLowerCase());
	if (memberPersonalInformation != null) {
		itrForm = memberPersonalInformation.getSelectedITRForm();
		itrServiceDelivery = memberPersonalInformation
				.getSelectedServiceDeliveryOption();
		pageContext.setAttribute("itrServiceDelivery",
				itrServiceDelivery);
	}
%>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${itrForm}" />
		</div>
	</c:forEach>
</c:if>
<div class="page">
	<w4india:itrmenu />
	<h4>
		Your ITR-V Status		
	</h4>
	<c:out value="${itrvStatus}"/>
	<c:if test="${empty isError}">
	</c:if>
</div>