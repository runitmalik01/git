<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@page import="java.util.List"%>
<%@page import="com.mootly.wcm.beans.cms.PageDocument"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoBeanIterator"%>
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
<c:forEach items="${resultsTotal.items}" var="hit">
		<hst:link var="link" hippobean="${hit}" fullyQualified="true"/>
		<c:set var="hitClassName" value="${hit['class'].simpleName}"/>
		<c:set var="changefreq" value="daily"/>
		<c:set var="priority" value="daily"/>
		<c:set var="show" value="true"/>
		<c:choose>
	         <c:when test="${hitClassName eq 'Faq'}">
	         	<c:set var="title" value="${hit.question}"/>
	         	<c:set var="changefreq" value="monthly"/>
	         	<c:set var="priority" value="0.8"/>
	         </c:when>
			<c:when test="${hitClassName eq 'Service'}">
	           <c:set var="title" value="${hit.name}"/>
	           <c:set var="changefreq" value="monthly"/>
	           <c:set var="priority" value="0.5"/>
	         </c:when>	
	        <c:when test="${hitClassName eq 'KnowledgeArticle'}">		 
	        	<c:set var="title" value="${hit.title}"/>       
	        	<c:set var="changefreq" value="monthly"/>  
	        	<c:set var="priority" value="0.9"/>
	         </c:when>
	         <c:when test="${hitClassName eq 'NewsItem'}">		 
	        	<c:set var="title" value="${hit.title}"/>       
	        	<c:set var="changefreq" value="monthly"/>  
	        	<c:set var="priority" value="0.5"/>
	         </c:when>
	         <c:when test="${hitClassName eq 'EventDocument'}">		 
	        	<c:set var="title" value="${hit.title}"/>       
	        	<c:set var="changefreq" value="never"/>  
	        	<c:set var="priority" value="0.2"/>
	         </c:when>
	         <c:otherwise>
	         	<c:set var="show" value="false"/>
	         </c:otherwise>	
		</c:choose>
		<c:if test="${show == 'true'}">
			<url>
				<loc>${fn:escapeXml(link)}</loc>
				<changefreq>${changefreq}</changefreq>
				<priority>${priority}</priority>
			</url>
		</c:if>
	<c:set var="pageNumber" value="${searchResult.nextPage}"/>
</c:forEach>
<c:if test="${not empty scopeForResellers}">
	<%
		HippoBean scopeBean = (HippoBean) request.getAttribute("scopeForResellers");
		HippoFolder theCMSPagesFolder = scopeBean.getBean("cms/pages");
		if (theCMSPagesFolder != null) {
			List<PageDocument> listOfPageDocuments = theCMSPagesFolder.getChildBeans(PageDocument.class);
			pageContext.setAttribute("listOfPageDocuments",listOfPageDocuments);
	%>
		<c:if test="${not empty listOfPageDocuments}">
			<c:forEach items="${listOfPageDocuments}" var="page">
				<url>
					<c:choose>
						<c:when test="${page.name == 'home'}">
							<loc><hst:link path="/" fullyQualified="true"/></loc>
							<changefreq>hourly</changefreq>
							<priority>1.0</priority>
						</c:when>
						<c:otherwise>
							<loc><hst:link path="/" fullyQualified="true"/>/${page.name}.cms</loc>
							<changefreq>monthly</changefreq>
							<priority>0.2</priority>
						</c:otherwise>
					</c:choose>
				</url>
			</c:forEach>
		</c:if>
	<% } %>
</c:if>
<%-- Tax Calculators --%>
	<url>
		<loc><hst:link path="/" fullyQualified="true"/>/taxcalculator</loc>
		<changefreq>yearly</changefreq>
		<priority>1.0</priority>
	</url>
	<url>
		<loc><hst:link path="/" fullyQualified="true"/>/npvcalculator</loc>
		<changefreq>yearly</changefreq>
		<priority>0.5</priority>
	</url>
	<url>
		<loc><hst:link path="/" fullyQualified="true"/>/hracalculator</loc>
		<changefreq>yearly</changefreq>
		<priority>0.5</priority>
	</url>
	<url>
		<loc><hst:link path="/" fullyQualified="true"/>/emicalculator</loc>
		<changefreq>yearly</changefreq>
		<priority>0.5</priority>
	</url>
</urlset>