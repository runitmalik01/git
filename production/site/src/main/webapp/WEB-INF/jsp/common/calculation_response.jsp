<%@ page contentType="application/json; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix='hst' uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ga" uri="http://www.onehippo.org/jsp/google-analytics" %>
<%@ taglib prefix="hippo-gogreen" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="w4india" tagdir="/WEB-INF/tags/w4india" %>
<%@ taglib prefix="res" tagdir="/WEB-INF/tags/responsive" %>

<c:if test="${not empty resultSet}">
	<c:out value="${jsonObject}" escapeXml="false"/>
</c:if>
