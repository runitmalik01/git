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
		<div class="alert alert-danger">
			<fmt:message key="${itrForm}" />
		</div>
	</c:forEach>
</c:if>
<div class="page">
	<w4india:itrmenu />
	<c:choose>
		<c:when test="${pageAction == 'RETRIEVE_ITRV_STATUS'}">
			<h4>
				Your ITR-V Status		
			</h4>
			<c:out value="${itrvStatus}"/>
		</c:when>
		<c:when test="${pageAction == 'RETRIEVE_REFUND_STATUS'}">
			<h4>
				Retrieve Refund Status		
			</h4>
			<c:out value="${retrieveRefundResponse.result}"/>
		</c:when>
		<c:when test="${pageAction == 'RETRIEVE_RECTIFICATION_STATUS'}">
			<h4>
				Retrieve Rectification Status		
			</h4>
			<c:out value="${retrieveRectificationResponse.status}"/>
		</c:when>
	</c:choose>
</div>