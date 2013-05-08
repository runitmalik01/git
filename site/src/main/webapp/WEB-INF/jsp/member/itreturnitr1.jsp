
<%--
@author Dhananjay Panwar
13/03/2013
 --%>

<%@page import="org.hippoecm.hst.core.request.ResolvedSiteMapItem"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../includes/commonincludes.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>

<!-- used to set title  -->
<%
HstRequest hstRequest = (HstRequest) request;
ResolvedSiteMapItem resolvedMapItem = hstRequest.getRequestContext().getResolvedSiteMapItem();
String actionInSiteMap =  resolvedMapItem.getLocalParameter("action");
String tabName = "";
if (actionInSiteMap != null && actionInSiteMap.contains("_")) {
 tabName = actionInSiteMap.substring(0,actionInSiteMap.indexOf("_"));
 System.out.println("tabName OOOOOOOOOOO)"+tabName);
}


	%>
<c:set var="itreturnitr1title">
      <fmt:message key="member.itreturnitr1.title" />
</c:set>
<hippo-gogreen:title title="${itreturnitr1title}" />

<hst:actionURL var="actionUrl"></hst:actionURL>

<div class="breadcrumb-list" xmlns:v="http://rdf.data-vocabulary.org/#">
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">Home</a></span> 
	<span class="chevron">&#187;</span> 
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">My Income Tax Returns</a></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current"><c:out value="${pan}"/></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current"><select style="width:120px"><option>ITReturn-ITR1</option><option>a</option><option>a</option></select></span>
</div>

<div class="page type-page">
	<h3 id="respond1">ITReturn-ITR1</h3>	
		<form id="frmIncomeinfo" action="${actionUrl}" name="oi" method="post">
			
			<ul id="myTab" class="nav nav-tabs">
              <li class="active1"><a href="#incometaxsummary" data-toggle="tab" >Income Tax Summary </a></li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Income - Salaries and Penson <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="#formsixteen" data-toggle="tab">Form16</a></li>
                  <li <%if (tabName != null && tabName.equals("advancetax")){%>class="active"<%}%>><a href="#incomesalaries" data-toggle="tab">Salary Penson</a></li>
                    <li ><a href="#incomeothersources" data-toggle="tab">Income - Other Sources</a></li>
             		 <li ><a href="#incomesinglehouse" data-toggle="tab" >Income - Single House</a></li>
                </ul>
              </li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Tax Paid <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="#advancetax" data-toggle="tab">Advance Tax</a></li>
                  <li><a href="#tdsfromsalary" data-toggle="tab">Tds From salary</a></li>
                    <li ><a href="#tdsfromothers" data-toggle="tab">Tds From others</a></li>
             		 
                </ul>
              </li>
              <li><a href="#deductions" data-toggle="tab">Deductions</a></li>
              
            </ul>
			 
			 <div id="myTabContent" class="tab-content" >
			 <div class="tab-pane fade in active1 " id="incometaxsummary">
            	 <hst:include ref="calculation"/>
              </div>
              <div class="tab-pane fade" id="formsixteen" >
           	 <hst:include ref="formsixteenITR1"/>
           	 
              </div> 
              <div class="tab-pane fade <%if (tabName != null && tabName.equals("salaryincome")){%>in active<%}%>" id="incomesalaries" >
           	 
           	 <hst:include ref="salaryincomeITR1"/>
              </div> 
              
              <div class="tab-pane fade" id="incomeothersources">
               <hst:include ref="otherincome"/>
              </div>
               <div class="tab-pane fade " id="incomesinglehouse">
                 <hst:include ref="singlehouseincome"/>
              </div>
              <div class="tab-pane fade <%if (tabName != null && tabName.equals("advancetax")){%>in active<%}%>  " id="advancetax">
                <hst:include ref="advanceataxITR1"/>
                </div>
              <div class="tab-pane fade" id="tdsfromothers">
                <hst:include ref="tdsfromothersITR1"/>
            	  </div>
            	  <div class="tab-pane fade" id="tdsfromsalary">
                <hst:include ref="tdsfromsalaryITR1"/>
            	  </div>
            	  <div class="tab-pane fade" id="deductions">
                <hst:include ref="deductionITR1"/>
            	  </div>
             </div>        
		</form>	
</div>

