<%--

    Copyright (C) 2010 Hippo B.V.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga" %>
<%@include file="../../includes/tags.jspf" %>
<%--
	Enumeration enm = request.getAttributeNames();
	while(enm.hasMoreElements()) {
		String element = (String) enm.nextElement();
		Object elementFromCollection = request.getAttribute(element);
		out.println(element + ":" + elementFromCollection.getClass().getName()	);
	}
	System.out.println("template:"+ request.getAttribute("template"));
--%>
<c:choose>
	<c:when test="${not empty widgetsCssClass}">
			<div class="container">
				<div class="row">
					<div class="<c:out value="${contentCssClass}"/>">
		        		<hst:include ref="content"/>     			
		        	</div>
		        	<div class="<c:out value="${widgetsCssClass}"/>">
		        		<hst:include ref="sidebar"/>        			
		        	</div>
				</div>
			</div>
	</c:when>
	<c:otherwise>
		<div id="content" class="<c:out value="${contentCssClass}"/>">
			<c:choose>
				<c:when test="${not empty hasGrid && hasGrid == 'true'}">
					<div class="row show-grid">
						<c:forEach items="${gridParams}" var="par">
							<c:if test="${fn:startsWith(par.key,'span')}">
								<c:set value="class${par.key}" var="spanClass"/>
								<c:set var="extraClass" value="${requestScope[spanClass]}"/>
								<span class="<c:out value="${par.key} ${extraClass}"/>">
					        		<hst:include ref="${par.value}"/>		        			
					        	</span>
				        	</c:if>
						</c:forEach>
					</div>
				</c:when>
				<c:otherwise>
					<hst:include ref="content"/>
				</c:otherwise>
			</c:choose>	
		</div>
	</c:otherwise>
</c:choose>

