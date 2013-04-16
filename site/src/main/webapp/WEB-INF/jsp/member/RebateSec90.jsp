<%@include file="../includes/tags.jspf" %>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />

<hst:actionURL var="actionUrl"/>
<div align="center" class="signupform">
<form id="frmrebate" action="${actionUrl}" method="post">
<div id="demo"class="yui3-module"align="center">
<div class="yui3-hd">
<b>LESS: REBATE</b>
	</div><br/><br/>
	<div class="yui3-bd" align="center" >
    <table>
	
	       <tr height="30px">
	<td class="label"><fmt:message key="rebate.section90.required"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	       <td class="input"><input type="text" name="Section_90" value="${relief}" maxlength="14" class="numberinput" readonly/>
	       <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'rebate.section90.error.required'}">
                   <span class="form-error"><fmt:message key="rebate.section90.error.required"/></span><br/>
                  </c:if>
              </c:forEach>
            </c:if>
	       </td></tr>
	       <tr height="30px">
	<td class="label"><fmt:message key="rebate.section91.required"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	       <td class="input"><input type="text" name="Section_91" value="" maxlength="14" class="numberinput" readonly/>
	       <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
              <c:if test="${error eq 'rebate.section91.error.required'}">
                   <span class="form-error"><fmt:message key="rebate.section91.error.required"/></span><br/>
                  </c:if>
              </c:forEach>
            </c:if>
	       </td></tr>
	       <tr height="30px">
	
	       
	<tr height="40px"> 
    <td  colspan="3" align="center"><input type="submit"  value="<fmt:message key="member.start.save.label"/>" class="yui3-button" /> 
</td></tr> 
</table><br />
</div>
</div>
</form>
</div>
<hst:headContribution keyHint="tablecss">
<link type="text/css" rel="stylesheet" href='<hst:link path="/css/Newstyle.css"/>'/>
</hst:headContribution>

<hst:headContribution keyHint="tablecss">
<link type="text/css" rel="stylesheet" href='<hst:link path="/css/adornment.css"/>'/>
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
