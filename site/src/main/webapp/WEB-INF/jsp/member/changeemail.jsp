<%@include file="../includes/tags.jspf" %>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<ol id="breadcrumbs">
 <li><fmt:message key="member.location.label"/></li>
 <li>
     <hst:link var="home" siteMapItemRefId="home" />
     <a href="${home}"><fmt:message key="products.detail.location.home"/></a>&gt;
 </li>
 <li><hst:link var="changeprofile" siteMapItemRefId="changeprofile"></hst:link>
  <a href="${changeprofile}"><fmt:message key="member.start.changeprofile" />
 </a>&gt;</li>
 <li>
    <hst:link var="changeemail" siteMapItemRefId="changeemail"></hst:link>
    <a href="${changeemail}"><fmt:message key="member.start.changeemail"/></a>
 </li>
</ol>
<hst:actionURL var="actionUrl"/>
<div align="center" class="signupform">
<form id="frmchangeemail" action="${actionUrl}" method="post">
<div id="demo"class="yui3-module"align="center">
<div class="yui3-hd">
<b>CHANGE EMAIL!!</b>
 </div><br/><br/>
 <div class="yui3-bd" align="center" >
    <table>
   <tr height="30px">
 <td class="label label-default"><fmt:message key="signup.c_email.required"/><span class="star">*</span></td>
        <td class="input"><input required type="email" name="c_email" value="${fn:escapeXml(c_email)}"class="input_data"/>
        <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'signup.c_email.error.required'}">
                   <span class="form-error"><fmt:message key="signup.c_email.error.required"/></span><br/>
                  </c:if>
                  
              </c:forEach>
            </c:if>
        </td></tr>
  <tr height="30px">
 <td class="label label-default"><fmt:message key="signup.email.required"/><span class="star">*</span></td>
        <td class="input"><input required type="email" name="new_email" value="${fn:escapeXml(new_email)}"class="input_data"/>
        <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'signup.email.error.required'}">
                   <span class="form-error"><fmt:message key="signup.email.error.required"/></span><br/>
                  </c:if>
                  
              </c:forEach>
            </c:if>
        </td></tr>
        <tr height="30px">
 <td class="label label-default"><fmt:message key="signup.conemail.required"/><span class="star">*</span></td>
        <td class="input"><input required type="email" name="con_email" value="${fn:escapeXml(con_email)}" class="input_data"/>
        <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'signup.email.error.required'}">
                   <span class="form-error"><fmt:message key="signup.email.error.required"/></span><br/>
                  </c:if>
                  <c:if test="${error eq 'signup.con_email.error.mismatch'}">
                   <span class="form-error"><fmt:message key="signup.con_email.error.mismatch"/></span><br/>
                  </c:if>
              </c:forEach>
            </c:if>
        </td></tr>
        <tr height="30px">
 
        
 <tr height="40px"> 
    <td  colspan="3" align="center"><input type="submit"  value="<fmt:message key="member.start.cpsubmit.label"/>" class="yui3-button" /> 
</td></tr> 
</table><br />
</div>
</div>
</form>
</div>
<hst:headContribution keyHint="tablecss">
<link type="text/css" rel="stylesheet" href='<hst:link path="/css/mobile/Newstyle.css"/>'/>
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