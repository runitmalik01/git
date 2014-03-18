<%@page autoFlush="true" contentType="text/xml; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="javax.jcr.Node"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix='hst' uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ga" uri="http://www.onehippo.org/jsp/google-analytics" %>
<%@ taglib prefix="hippo-gogreen" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="w4india" tagdir="/WEB-INF/tags/w4india" %>
<%@ taglib prefix="res" tagdir="/WEB-INF/tags/responsive" %>
<?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
<c:set var="totalPages" value="${searchResult.totalPages}"/>
<c:forEach begin="1" end="${totalPages}" step="1">
	<c:forEach items="${searchResult.items}" var="hit">
		<hst:link var="link" hippobean="${hit}" fullyQualified="true"/>
		<c:set var="hitClassName" value="${hit['class'].simpleName}"/>
		<c:choose>
	         <c:when test="${hitClassName eq 'Faq'}">
	         	<c:set var="title" value="${hit.question}"/>
	         </c:when>
			<c:when test="${hitClassName eq 'Service'}">
	           <c:set var="title" value="${hit.name}"/>
	         </c:when>	
	        <c:when test="${hitClassName eq 'KnowledgeArticle'}">		 
	        	<c:set var="title" value="${hit.title}"/>         
	         </c:when>
		</c:choose>
		<url>
			<loc>${fn:escapeXml(link)}</loc>
			<changefreq>daily</changefreq>
		</url>
	<c:set var="pageNumber" value="${searchResult.nextPage}"/>
	</c:forEach>
</c:forEach>
</urlset>