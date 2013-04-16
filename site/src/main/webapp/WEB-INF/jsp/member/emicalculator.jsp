
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
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>
<%@include file="../includes/tags.jspf" %>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
<hst:actionURL var="actionUrl"></hst:actionURL>
<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label"/></li>
	<li>
	    <hst:link var="EMI" siteMapItemRefId="EMI" />
	    <a href="${EMI}"><fmt:message key="emi.calculator"/></a>;
	</li>
</ol>
<br/>
<form id="frmRating" action="${actionUrl}" method="post" name="emi">
<div id="demo" class="yui3-module">
 <div class="yui3-hd">
<div><h2>EMI Calculator</h2></div>
<div class="yui3-bd" align="center" >
   <div id="EMI_Calculator">
   <table>
      <tr>
         <td colspan="4">
           <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'invalid.select.choice'}">
                    <span class="form-error"><fmt:message key="emi_incomplete_fields"/></span><br/>
                  </c:if>
              </c:forEach>
            </c:if>
         </td>
      </tr>
        <table class="personal_info">
           <tr height="30px">
	         <td class="label"><fmt:message key="emi_loan_amount"/></td>
	          <td class="input"><input required type="text" pattern="^[0-9]+$"required type="text" class="numberinput" name="loan_amount" onChange="fill()" id="A" title="Please fill this field"/>
				<c:if test="${not empty errors}">
                	<c:forEach items="${errors}" var="error">
                  		<c:if test="${error eq 'invalid_loan_amount_label'}">
                   <span class="form-error"><fmt:message key="emi_loan_amount.error"/></span>
                  </c:if>
              </c:forEach>
            </c:if>
		</tr>
	       <tr height="30px">
	       <td class="label"><fmt:message key="emi_interest_rate"></fmt:message></td>
	       <td class="input"><input required type="text" name="interest_rate" id="B" onChange="fill()" class="numberinput" title="Please fill this field"/> % Per Annum</td>
	       <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'invalid_interest_rate_label'}">
                   <span class="form-error"><fmt:message key="emi_interest_rate.error"/></span>
                  </c:if>
              </c:forEach>
            </c:if>
           </tr>
	       <tr height="30px">
	       <td class="label"><fmt:message key="emi_loan_tenure"/></td>
	       <td class="input"><input required type="text" name="loan_tenure" id="C" onChange="fill()"  class="numberinput"  title="Please fill this field" />In Months </td>
	       <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'invalid_loan_tenure_label'}">
                   <span class="form-error"><fmt:message key="emi_loan_tenure.error"/></span>
                  </c:if>
              </c:forEach>
            </c:if>
          </tr>
          
    	  <tr><td><fmt:message key="emi_calculation"></fmt:message></td><td><input type="text" name="emi_calculation" id="D" readonly /></td></tr> 
    	 <td><br/></td><br/>
    <td colspan="2"><input type="reset"  value="Reset"/></td></tr>
     
 </table>
 </table>
 </div>
 </div>
 </div>
 </div>

 </form>
   	 

 <script>
    function fill() {
        var A= document.getElementById("A").value-0;
        var B = document.getElementById("B").value-0;
 		var C= document.getElementById("C").value-0;
 		if(A>0 && B>0 && C>0){
 		var id1= A*(B/1200);
 		var id2= (B/1200)+1;
 		var id3= Math.pow((1+(B/1200)), C);
 		var id4= id3-1;
 		var id5= id3/id4;
 		var id6= Math.round((id1*id5)* 100) / 100;
        document.getElementById("D").value = (id6) ;
 		}
    }
</script>
<script type="text/javascript">
var $m=jQuery.noConflict(true);
var jqueryFunction;
 $m(document).ready(function () {
     $m('input.numberinput').bind('keypress', function (e) {
         return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
     });
 });
 </script>

<hst:headContribution keyHint="buttonCss" category="css">
 <hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css" var="homeSliderCss"/>
 <link rel="stylesheet" media="screen" type="text/css" href="${homeSliderCss}"/>
</hst:headContribution> 
	       
<hst:headContribution keyHint="form-animation" category="jsInternal"> 
<script type="text/javascript" src='<hst:link path="/js/reverse_animation.js"/>'></script>
</hst:headContribution>

<hst:headContribution keyHint="formcss">
<link rel="stylesheet" href='<hst:link path="/css/animation/animation.css"/>' type="text/css"/>
</hst:headContribution>


 