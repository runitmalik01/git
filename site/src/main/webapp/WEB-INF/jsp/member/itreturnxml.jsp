<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<w4india:itrmenu></w4india:itrmenu>
<c:choose>
	<c:when test="${not empty hasDIY && hasDIY == 'true'}">
		<label class="radio inline"> <input type="radio"
			name="optionsRadios" id="showSummary" value="summary"
			<c:if test="${empty show || show == 'summary'}">checked</c:if>>
			Show Summary </label>
		<label class="radio inline"> <input type="radio"
			name="optionsRadios" id="showXml" value="xml"
			<c:if test="${show == 'xml'}">checked</c:if>> Show XML </label>
		<c:choose>
			<c:when test="${empty show || show == 'summary'}">
				<c:if test="${ITR eq 'ITR1'}">
			         <jsp:include page="ITR1Summary.jsp"/>
                </c:if>
                <c:if test="${ITR eq 'ITR2'}">
			         <jsp:include page="ITR2Summary.jsp"/>
                </c:if>
			</c:when>
			<c:when test="${not empty show || show == 'xml'}">
				<script type="syntaxhighlighter" class="brush: xml">
<![CDATA[
  <c:out value="${xml}" escapeXml="false"/>
]]></script>
				<!-- <a role="button" class="btn orange">Download XML</a> -->
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>

		<%--
		<pre class="brush: xml">
		 	<c:out value="${xml}" escapeXml="true"/>
		</pre>
		--%>

		<hst:headContribution category="jsExternal">
			<script type="text/javascript" src="<hst:link path="/js/syntaxhighlighter_3.0.83/scripts/shCore.js"/>"></script>
		</hst:headContribution>

		<hst:headContribution category="jsExternal">
			<script type="text/javascript" src="<hst:link path="/js/syntaxhighlighter_3.0.83/scripts/shBrushXml.js"/>"></script>
		</hst:headContribution>

		<hst:headContribution category="css">
			<link rel="stylesheet" href='<hst:link path="/js/syntaxhighlighter_3.0.83/styles/shCore.css"/>' type="text/css" />
		</hst:headContribution>

		<hst:headContribution category="css">
			<link rel="stylesheet" href='<hst:link path="/js/syntaxhighlighter_3.0.83/styles/shThemeDefault.css"/>' type="text/css" />
		</hst:headContribution>

		<hst:element var="uiCustom" name="script">
			<hst:attribute name="type">text/javascript</hst:attribute>
				$(document).ready(function() {
					SyntaxHighlighter.all();
					$("#showSummary,#showXml").click(function(){
						window.location.href="${scriptName}?show=" + $(this).val() ;
					});
				});
		</hst:element>
		<hst:headContribution element="${uiCustom}" category="jsInternal" />
	</c:when>
	<c:otherwise>
		<h1>Welcome to eZ-Filing</h1>
		<h5>Please upload all your tax documents. A Tax consultant from wealth4india will shortly get in touch with you.</h5>
		<h6>Its always an Obligation Quote!!</h6>
	</c:otherwise>
</c:choose>