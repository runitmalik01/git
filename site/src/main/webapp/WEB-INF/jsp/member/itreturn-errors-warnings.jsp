<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>

<fmt:setBundle basename="beanToEditorMapping" var="beanToEditorMapping"/>
<c:set var="ditsynctitle">
	<fmt:message key="member.ditsyn.title" />
</c:set>
<w4india:itrmenu />
<hippo-gogreen:title title="${ditsynctitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
		<h1>Errors &amp; Warnings</h1>
		<c:choose>
			<c:when test="${empty hippoBeanValidationResponse && hippoBeanValidationResponse.totalErrors == 0 &&  hippoBeanValidationResponse.totalWarnings == 0}">
				No information found.
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>Screen</th>
						<th>Message</th>
						<th>Action</th>  
					</tr>
					<c:forEach items="${hippoBeanValidationResponse.errors}" var="error">
						<tr>
							<td>
								<c:set var="undefined_screenhead" value="???${error.screenHead}???"/>
								<fmt:message key="${error.screenHead}" var="label_screenhead"/>
								<c:choose>
	                                <c:when test="${label_screenhead == 'undefined'}">
	                                	<c:out value="${error.screenHead}"/>
	                                </c:when>
	                                <c:otherwise>
	                                	<c:out value="${label_screenhead}"/>
	                                </c:otherwise>
	                             </c:choose>
							</td>
							<td>
								<c:set var="undefined_message" value="???${error.message}???"/>
								<fmt:message key="${error.message}" var="label_message"/>
								<c:choose>
	                                <c:when test="${label_message == 'undefined'}">
	                                	<c:out value="${error.message}"/>
	                                </c:when>
	                                <c:otherwise>
	                                	<c:out value="${label_message}"/>
	                                </c:otherwise>
	                             </c:choose>
							</td>
							<td>
								<c:if test="${not empty error.hippoDocumentClass}">
									<c:set var="undefined" value="???${error.hippoDocumentClass.simpleName}.${memberpersonalinformation.selectedITRForm}???"/>
	                              	<fmt:message bundle="${beanToEditorMapping}" key="${error.hippoDocumentClass.simpleName}.${memberpersonalinformation.selectedITRForm}" var="label"/>
	                              	<c:choose>
		                                <c:when test="${label == undefined}"></c:when>
		                                <c:otherwise>
		                                	<a href="${scriptName}/../${fn:replace(label,'_uuid_',error.uuid)}">Fix</a>
		                                </c:otherwise>
	                              	</c:choose>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</div>

