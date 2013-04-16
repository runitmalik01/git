

<%@include file="../includes/tags.jspf" %>
<c:set var="activationtitle"><fmt:message key="member.activation.title"/></c:set>
<hippo-gogreen:title title="${activationtitle}"/>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<div align="center" class="adornment">
<div id="demo"class="yui3-module"align="center">
 <div class="yui3-hd" align="left"> &nbsp;
<fmt:message key="member.message.active"/><br/>
</div>
<div class="yui3-bd" align="left"><br/>
<h1 style="color: red"> &nbsp;&nbsp;<fmt:message key="member.message.info1"/></h1><br/><br/>
<h2 style="color:green"> &nbsp;&nbsp;<fmt:message key="member.message.info2"/>(${ member.email}) </h2>
</div>
</div>
</div>
<hst:headContribution keyHint="tablecss">
<link type="text/css" rel="stylesheet" href='<hst:link path="/css/adornment.css"/>'/>
</hst:headContribution>
<hst:headContribution keyHint="tablecss">
<link type="text/css" rel="stylesheet" href='<hst:link path="/css/signupform/signupform.css"/>'/>
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
<link rel="stylesheet" href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>' type="text/css"/>
</hst:headContribution>
<hst:headContribution keyHint="formcss">
<link rel="stylesheet" href='<hst:link path="/css/animation/animation.css"/>' type="text/css"/>
</hst:headContribution>
<hst:headContribution keyHint="formcss">
<link type="text/css" rel="stylesheet" href='<hst:link path="/css/adornment.css"/>'/>
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
<link rel="stylesheet" href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>' type="text/css"/>
</hst:headContribution>
