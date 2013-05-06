<%@include file="../includes/tags.jspf" %>

<label class="radio inline">
  <input type="radio" name="optionsRadios" id="showSummary" value="summary" <c:if test="${empty show || show == 'summary'}">checked</c:if>>
  Show Summary
</label>
<label class="radio inline">
  <input type="radio" name="optionsRadios" id="showXml" value="xml" <c:if test="${show == 'xml'}">checked</c:if>>
  Show XML
</label>
<c:choose>
	<c:when test="${empty show || show == 'summary'}">
		<pre>
			<c:out value="${theForm.personalInfo.assesseeName.surNameOrOrgName}"/>
		</pre>
	</c:when>
	<c:when test="${not empty show || show == 'xml'}">
		<script type="syntaxhighlighter" class="brush: xml">
<![CDATA[
  <c:out value="${xml}" escapeXml="false"/>
]]></script>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>

<%--
<pre class="brush: xml">
 	<c:out value="${xml}" escapeXml="true"/>	
</pre>
--%>


<link href="http://alexgorbatchev.com/pub/sh/current/styles/shThemeDefault.css" rel="stylesheet" type="text/css" />
<script src="http://alexgorbatchev.com/pub/sh/current/scripts/shCore.js" type="text/javascript"></script>
<script src="http://alexgorbatchev.com/pub/sh/current/scripts/shAutoloader.js" type="text/javascript"></script>

<hst:element var="shThemeCore" name="link">
	<hst:attribute name="rel">stylesheet</hst:attribute>
	<hst:attribute name="type">text/css</hst:attribute>
	<hst:attribute name="href">http://alexgorbatchev.com/pub/sh/current/styles/shCore.css.css</hst:attribute>
</hst:element>

<hst:element var="shThemeDefault" name="link">
	<hst:attribute name="rel">stylesheet</hst:attribute>
	<hst:attribute name="type">text/css</hst:attribute>
	<hst:attribute name="href">http://alexgorbatchev.com/pub/sh/current/styles/shThemeDefault.css</hst:attribute>
</hst:element>

<hst:element var="shCore" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	<hst:attribute name="src">http://alexgorbatchev.com/pub/sh/current/scripts/shCore.js</hst:attribute>
</hst:element>

<hst:element var="shAutoLoader" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	<hst:attribute name="src">http://alexgorbatchev.com/pub/sh/current/scripts/shAutoloader.js</hst:attribute>
</hst:element>
<hst:element var="shBrushXml" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	<hst:attribute name="src">http://alexgorbatchev.com/pub/sh/current/scripts/shBrushXml.js</hst:attribute>
</hst:element>

<hst:headContribution element="${shCore}" category="css"/>
<hst:headContribution element="${shThemeDefault}" category="css"/>
<hst:headContribution element="${shCore}" category="jsInternal"/>
<hst:headContribution element="${shAutoLoader}" category="jsInternal"/>
<hst:headContribution element="${shBrushXml}" category="jsInternal"/>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			SyntaxHighlighter.all();
			$("#showSummary,#showXml").click(function(){
				window.location.href="${scriptName}?show=" + $(this).val() ;
			});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>