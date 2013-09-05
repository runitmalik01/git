<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="summary">
	<fmt:message key="itr1.summary.xml" />
</c:set>
<hippo-gogreen:title title="${summary}" />
<hst:componentRenderingURL var="xmlGeneratorURL"/>
<c:set var="reqParamXmlGeneratorURL" value="${xmlGeneratorURL}" scope="request"/>
<w4india:itrmenu></w4india:itrmenu>
<c:if test="${not empty emailMe}">
	<c:choose>
		<c:when test="${emailMeStatus == 'success'}">
			<h5>Your Income Tax summary was successfully e-mailed to you.</h5>
		</c:when>
		<c:otherwise>
			<h5>There was an error e-mailing your documents. Please try again later.</h5>
		</c:otherwise>
	</c:choose>
</c:if>
<c:choose>
	<c:when test="${not empty isDIY && isDIY == 'true'}">
		<%-- hide the radio buttons but the feature is still available --%>
		<%--
		<label class="radio inline"> <input type="radio"
			name="optionsRadios" id="showSummary" value="summary"
			<c:if test="${empty show || show == 'summary'}">checked</c:if>>
			Show Summary </label>
		<label class="radio inline"> <input type="radio"
			name="optionsRadios" id="showXml" value="xml"
			<c:if test="${show == 'xml'}">checked</c:if>> Show XML </label>
		 --%>
		<c:choose>
			<c:when test="${empty show || show == 'summary'}">
				<c:if test="${ITR eq 'ITR1'}">
			         <jsp:include page="ITR1Summary.jsp"/>
                </c:if>
                <c:if test="${ITR eq 'ITR2'}">
			         <jsp:include page="ITR2Summary.jsp"/>
                </c:if>
                 <c:if test="${ITR eq 'ITR4S'}">
			         <jsp:include page="ITR4SSummary.jsp"/>
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
		<h4>eZ-Filing your Tax Return</h4>
		<h5>You have made the right choice. eZ-Filing your Tax Return is the guaranteed way to get the best out of your return.</h5>
			<form>
			<fieldset>
				<legend>What is eZ-Filing?</legend>
				<p>
					eZ-File (pronounced as <i>easy</i> Filing), lets you upload all your relevant tax documents.
					Wealth4India professionals will download your documents and work on your case.
					You will be notified via email/phone when your tax is ready.
				</p>
			</fieldset>
			<fieldset>
				<legend>When to pay?</legend>
				<p>
					Once you are done uploading your documents. You can click on Proceed button on the Upload Documents Screen.
				</p>
			</fieldset>
			<fieldset>
				<legend>I love it !! What's Next??</legend>
				<p>

					<hst:link var="memberDriveComp" siteMapItemRefId="docattach"></hst:link>
					Click on Upload Documents <a href="${fn:replace(scriptName,'servicerequest-itr-summary.html','attachdoc.html')}" class="btn btn-primary">Upload Documents</a> to get started.
				</p>
			</fieldset>
		</form>
	</c:otherwise>
</c:choose>