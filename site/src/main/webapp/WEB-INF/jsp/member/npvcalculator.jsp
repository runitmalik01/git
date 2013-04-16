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
<div class="memberlogin page type-page">
	<h3>NPV Calculator</h3>
	<form id="frmTaxCalc" action="${actionUrl}" method="post" name="tax">
          <p>
          	  <label for="R"><fmt:message key="npv_amount"/></label>
	          <input  required type="text" name="amount_received" onChange="fill()" class="numberinput" id="R" title="Please fill this field"/>
				<c:if test="${not empty errors}">
                	<c:forEach items="${errors}" var="error">
                  		<c:if test="${error eq 'invalid_amount_received_label'}">
                   			<span class="form-error"><fmt:message key="npv_amount_recevied_error"/></span>
                  		</c:if>
              		</c:forEach>
            	</c:if>
          </p>
          <p>
	      	<label for="N"><fmt:message key="npv_year"/></label>
	        <input required type="text"name="no_of_year" id="N" onChange="fill()" class="numberinput" title="Please fill this field" />
	        <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'invalid_no_of_year_label'}">
                   <span class="form-error"><fmt:message key="npv_no_of_year_error"/></span>
                  </c:if>
              </c:forEach>
            </c:if>
          </p>
          <p>
           	<label for="I"><fmt:message key="npv_rate"/></label>
	        <input required type="text" name="present_rate_of_return" id="I" onChange="fill()"  class="numberinput" title="Please fill this field" />
	       <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'invalid_present_rate_of_return_label'}">
                   <span class="form-error"><fmt:message key="npv_present_rate_of_return_error"/></span>
                  </c:if>
              </c:forEach>
            </c:if>
          </p>
		  <p>
			<label for="C"><fmt:message key="npv_initialinvestment"/></label>
	       	<input required type="text" name="initial_investment" id="C" onChange="fill()"  class="numberinput" title="Please fill this field" />
	       <c:if test="${not empty errors}">
              <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'invalid_present_rate_of_return_label'}">
                   <span class="form-error"><fmt:message key="npv_present_rate_of_return_error"/></span>
                  </c:if>
              </c:forEach>
            </c:if>
          </p>
    	  <p>
    	  	<label for="D"><fmt:message key="npv_calculation"></fmt:message></label>
    	  	<input type="text" name="npv_calculation" id="D" readonly/>
    	 	<input type="submit"  value="Calculate"/><input type="reset"  value="Reset"/>
		</p>
 </form>
  <%-- For Even cash flows --%>
   <script>   
    function fill() {
        var R = document.getElementById("R").value-0;
        var N = document.getElementById("N").value-0;
 		var I= document.getElementById("I").value-0;
 		var C= document.getElementById("C").value-0;
	 	if(R>0 && N>0 && I>0 && C>0){
	 		var id1 = I/1200;
			var id2 = 1 + id1;
	 		var id3 = Math.pow((id2),N);
	  		var id4= 1 / id3;
	 		var id5= 1 - id4;
	 		var id6= id5 / id1;
			var id7= R * id6;
			var id8=Math.round((id7 - C) * 100) / 100;
			document.getElementById("D").value = (id8) ;		
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


   
