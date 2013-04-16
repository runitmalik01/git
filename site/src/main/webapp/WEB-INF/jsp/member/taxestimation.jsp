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
<ol id="breadcrumbs">
      <li><fmt:message key="member.location.label"/></li>
      <li>
          <hst:link var="memberhome" siteMapItemRefId="memberhome" />
          <a href="${memberhome}"><fmt:message key="member.location.home"/></a> &gt;
      </li>
      <li>
      <hst:link var="taxestimation" siteMapItemRefId="taxestimation"/>
      <a href="${taxestimation}"><fmt:message key="member.tax.estimation"/></a> 
      </li>
  </ol>

<hst:actionURL var="actionUrl"></hst:actionURL>

<div id="head">
<h2> Income-TAX Estimation</h2>
</div>
<div>
    <c:if test="${not empty tax}">
Your Estimated Income TAX :<%=(String)request.getAttribute("tax")%>

</c:if>
</div>
 <div id="taxform">
        <form id="estimation" action="${actionUrl}" method="post" >
           <table>
              <tr>
                <td id="label" >Gross Income</td>

                 <td id="input"><input type="text" name="salary"/></td>
                  <c:if test="${not empty errors}">
                        <c:forEach items="${errors}" var="error">
                             <c:if test="${error eq 'enter.gross.salary'}">
                            <span class="form-error"><fmt:message key="member.enter.gross.salary"/></span><br/>
                             </c:if>
                        </c:forEach>
                  </c:if>
              </tr>
              <tr>
               <td id="label">Savings</td>
               <td id="input"><input type="text" name="savings"/></td>
                  <c:if test="${not empty errors}">
                        <c:forEach items="${errors}" var="error">
                             <c:if test="${error eq 'enter.gross.savings'}">
                            <span class="form-error"><fmt:message key="member.enter.gross.savings"/></span><br/>
                             </c:if>
                        </c:forEach>
                  </c:if>
              </tr>
              <tr>
               <td id="label">Standard Deduction</td>
               <td id="input"><input type="text" disabled="disabled" contenteditable="false" value="1.8 Lac"/></td> 
              </tr>
              <tr>
              <td colspan="2" align="center" id="submit"><input type="submit" name="Estimate" value="Tax-Estimate"/></td>
              </tr>
          </table>
       </form>
</div>
