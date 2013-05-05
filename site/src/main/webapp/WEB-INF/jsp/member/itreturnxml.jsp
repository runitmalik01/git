<%@include file="../includes/tags.jspf" %>

<script type="syntaxhighlighter" class="brush: xml">
<![CDATA[
  <c:out value="${xml}" escapeXml="false"/>
]]></script>
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
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>