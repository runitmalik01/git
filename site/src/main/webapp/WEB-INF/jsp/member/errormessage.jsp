

<%@include file="../includes/tags.jspf" %>
<c:set var="activationerrortitle"><fmt:message key="member.activationerror.title"/></c:set>
<hippo-gogreen:title title="${activationerrortitle}"/>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<div align="center" class="adornment">
<div id="demo"class="yui3-module"align="center">
 <div class="yui3-hd" align="left"> 
 &nbsp;&nbsp;
<fmt:message key="member.not.active"/>
</div>
<div class="yui3-bd" align="left"><br/>
<h2 style="color: red">&nbsp;&nbsp;<fmt:message key="member.not.active1"/></h2><br/><br/>
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
