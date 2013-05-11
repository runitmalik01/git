
<%--
@author Pankaj Singh
13/03/2013
 --%>

<%@page import="org.hippoecm.hst.core.request.ResolvedSiteMapItem"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../includes/commonincludes.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf" %>
<res:breadcrumb breadcrumType="IT Return-ITR1"/>	
<!-- used to set title  -->
<%
HstRequest hstRequest = (HstRequest) request;
ResolvedSiteMapItem resolvedMapItem = hstRequest.getRequestContext().getResolvedSiteMapItem();
String actionInSiteMap =  resolvedMapItem.getLocalParameter("action");
String tabName = "summary";
if (actionInSiteMap != null && actionInSiteMap.contains("_")) {
 tabName = actionInSiteMap.substring(0,actionInSiteMap.indexOf("_"));
}


	%>
<c:set var="itreturnitr1title">
      <fmt:message key="member.itreturnitr1.title" />
</c:set>
<hippo-gogreen:title title="${itreturnitr1title}" />

<hst:actionURL var="actionUrl"></hst:actionURL>


<div class="page type-page">
	<h3 id="respond1">ITReturn-ITR1</h3>	
		<form id="frmIncomeinfo" action="${actionUrl}" name="oi" method="post">
			
			<ul id="myTab" class="nav nav-tabs">
              <li <%if (tabName == "summary" ){%>class="active "<%}%>><a href="#incometaxsummary" data-toggle="tab" ><fmt:message key="income.tax.summary" /> </a></li>
              <li><a href="#formsixteen" data-toggle="tab"><fmt:message key="income.form.sixteen" /></a></li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="income" /> <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li <%if (tabName != null && tabName.equals("salaryincome")){%>class="active"<%}%>><a href="#incomesalaries" data-toggle="tab"><fmt:message key="income.salary.penson" /></a></li>
                    <li ><a href="#incomeothersources" data-toggle="tab"><fmt:message key="income.other.sources" /></a></li>
             		 <li <%if (tabName != null && tabName.equals("houseincome")){%>class="active"<%}%>><a href="#incomesinglehouse" data-toggle="tab" ><fmt:message key="income.house.itr1" /></a></li>
                </ul>
              </li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="income.taxpaid.itr1" /> <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li <%if (tabName != null && tabName.equals("advancetax")){%>class="active"<%}%>><a href="#advancetax" data-toggle="tab"><fmt:message key="advance.tax.itr1" /></a></li>
                  <li <%if (tabName != null && tabName.equals("tdsfromsalary")){%>class="active"<%}%>><a href="#tdsfromsalary" data-toggle="tab"><fmt:message key="advance.tdssalary.itr1" /></a></li>
                    <li <%if (tabName != null && tabName.equals("tdsfromothers")){%>class="active"<%}%> ><a href="#tdsfromothers" data-toggle="tab"><fmt:message key="advance.tdsothers.itr1" /></a></li>
             		 
                </ul>
              </li>
              <li><a href="#deductions" data-toggle="tab"><fmt:message key="deductions.itr1" /></a></li>
              
              
            </ul>
			 
			 <div id="myTabContent" class="tab-content" >
			 <div class="tab-pane fade <%if (tabName == "summary"){%>in active <%}%>" id="incometaxsummary">
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
               <div class="tab-pane fade <%if (tabName != null && tabName.equals("houseincome")){%>in active<%}%> " id="incomesinglehouse">
                 <hst:include ref="singlehouseincome"/>
              </div>
              <div class="tab-pane fade <%if (tabName != null && tabName.equals("advancetax")){%>in active<%}%>  " id="advancetax">
                <hst:include ref="advanceataxITR1"/>
                </div>
            <div class="tab-pane fade <%if (tabName != null && tabName.equals("tdsfromothers")){%>in active<%}%>  " id="tdsfromothers">
                <hst:include ref="tdsfromothersITR1"/>
            	  </div>
           	<div class="tab-pane fade <%if (tabName != null && tabName.equals("tdsfromsalary")){%>in active<%}%>  " id="tdsfromsalary">
            <hst:include ref="tdsfromsalaryITR1"/>
            	  </div>
            	  <div class="tab-pane fade" id="deductions">
                <hst:include ref="deductionITR1"/>
            	  </div>
             </div>        
		</form>	
</div>

