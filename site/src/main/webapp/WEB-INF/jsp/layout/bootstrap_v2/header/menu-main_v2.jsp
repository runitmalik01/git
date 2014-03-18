
<%@page import="java.util.List"%>
<%@page import="org.hippoecm.hst.core.sitemenu.HstSiteMenuItem"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics"
	prefix="ga"%>
<%@include file="../../../includes/tags.jspf"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../../../includes/tags.jspf"%>

		<c:forEach var="item" items="${menu.siteMenuItems}">
			<c:set var="itemLink" value="${item.hstLink}" />
			<c:if test="${not empty itemLink}">
				<hst:link var="link" link="${itemLink}" />
				<%
					HstSiteMenuItem item = (HstSiteMenuItem) pageContext
									.getAttribute("item");
							List<HstSiteMenuItem> childMenuItems = item
									.getChildMenuItems();
							if (childMenuItems != null && childMenuItems.size() > 0) {
								pageContext.setAttribute("hasChildren", "1");
							} else {
								pageContext.setAttribute("hasChildren", "0");
							}
				%>
				<c:choose>
					<c:when test="${item.expanded}">
						<li><a href="${fn:escapeXml(link)}" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${item.name}" /></a></li>
						<!-- home link is done -->
						<c:if test="${hasChildren == '1'}">
							<ul class="dropdown-menu">
								<c:forEach items="${item.childMenuItems}" var="childItem">
									<c:set var="childItemLink" value="${childItem.hstLink}" />
									<hst:link var="childLink" link="${childItemLink}" />
									<li class="dropdown"><a href="${fn:escapeXml(childLink)}"><c:out
												value="${childItem.name}" /> </a>
										<ul class="dropdown-menu">
											<c:forEach items="${item.childMenuItems}" var="childItem2">
												<c:set var="childItemLink2" value="${childItem2.hstLink}" />
												<hst:link var="childLink2" link="${childItemLink2}" />
												<li class="dropdown"><a
													href="${fn:escapeXml(childLink2)}"><c:out
															value="${childItem2.name}" /> </a>
												</li>
											</c:forEach>
										</ul>
									</li>
								</c:forEach>
							</ul>
						</c:if>

					</c:when>
					<c:otherwise>
						<!-- calculators/service price/faq/income tax return link -->
						<li <c:if test="${hasChildren == '1'}"> class="dropdown"</c:if>><c:set var="totalChildren" value="${item.childMenuItems}" />
							<a href="${fn:escapeXml(link)}"
							<c:if test="${hasChildren == '1'}"> data-toggle="dropdown"
						data-target="#" class="dropdown-toggle"</c:if>>
								<c:out value="${item.name}" /> <c:if test="${hasChildren == '1'}"> <b class="caret"></b></c:if> </a>
								
							<!--sub-menu of Calculators-->
							<c:if test="${hasChildren == '1'}">
								<ul class="dropdown-menu">
									<c:forEach items="${item.childMenuItems}" var="childItem">
										<c:set var="childItemLink" value="${childItem.hstLink}" />
										<hst:link var="childLink" link="${childItemLink}" />
										<li><a href="${fn:escapeXml(childLink)}"><c:out
													value="${childItem.name}" /> </a></li>
									</c:forEach>
								</ul>
							</c:if></li>
					</c:otherwise>
				</c:choose>
			</c:if>
		</c:forEach>
<%--
 http://localhost:8080/site/r/w4india/vendor/websitebuilder/pages.html/bcdf2b5f-3c08-4a0f-a80e-d44f00518bc6/editpage
 --%>
<c:if test="${not empty isVendor && isVendor eq 'true'}">
	<li class="dropdown">
		 <a href="#" data-toggle="dropdown" data-target="#" class="dropdown-toggle">CMS<b class="caret"></b></a>
		 <ul class="dropdown-menu" id="submenucms">
		 	<c:if  test="${not empty pageDocument && (empty isCommonPage || isCommonPage eq 'false') }">
				<li><a href="<hst:link path="/vendor/websitebuilder/pages.html"/>/${pageDocument.canonicalUUID}/editpage">Edit Page</a> </li>
			</c:if>
			<li><c:out value="${pageDocument}"/><a href="<hst:link path="/vendor/websitebuilder/pages.html"/>">Create Own Page</a></li>
		</ul>
	</li>
</c:if>
<%-- 
<c:if test="${not empty isVendor && isVendor eq 'true'}">
	<c:choose>
		<c:when test="${not empty isCommonPage && isCommonPage eq 'false'}">
			<a class="btn btn-default btn-info" href="${websitebuilderlink}/pages.html/${pageDocument.canonicalUUID}/editpage"
				style="position: absolute; top: 10em; left: 70em;"><i
				class="glyphicon glyphicon-edit"></i>&nbsp;Edit Page</a>
		</c:when>
		<c:otherwise>
			<a class="btn btn-default btn-warning" href="${websitebuilderlink}/pages.html"
				style="position: absolute; top: 10em; left: 70em;"><i
				class="glyphicon glyphicon-plus"></i>&nbsp;Create Own Page</a>
		</c:otherwise>
	</c:choose>
</c:if>
--%>
