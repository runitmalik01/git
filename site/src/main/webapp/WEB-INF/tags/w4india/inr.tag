<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ tag import="com.mootly.wcm.utils.*" %>
<%@ tag import="java.util.*" %>

<%@ attribute name="value" required="true" type="java.lang.String" %>
<%@ attribute name="currencySymbol" required="false" type="java.lang.String" %>
<%@ attribute name="minFractionDigits" required="false" type="java.lang.String" %>

<%
	if (currencySymbol == null)  currencySymbol = "&#8377;";
	request.setAttribute("currencySymbol",currencySymbol);
	if (minFractionDigits == null) {
		request.setAttribute("minFractionDigits","2");
	}
%>

<fmt:formatNumber value="${value}" type="CURRENCY" currencySymbol="${currencySymbol}" pattern="� #,##0.00;� -#,##0.00" maxFractionDigits="2" minFractionDigits="${minFractionDigits}" minIntegerDigits="1"></fmt:formatNumber>

