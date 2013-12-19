<%@page import="com.mootly.wcm.beans.compound.SalaryIncomeDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
 
<c:set var="salaryincometitle">
	<fmt:message key="member.salary.title" />
</c:set>
<hippo-gogreen:title title="${salaryincometitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="breadcrumb-list" xmlns:v="http://rdf.data-vocabulary.org/#">
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">Home</a></span> 
	<span class="chevron">&#187;</span> 
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">My Income Tax Returns</a></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current pan"><c:out value="${pan}"/></span>
	<span class="chevron">&#187;</span> 
</div>
<div class="page type-page">
	<h4 id="respond1">IncomeTaxFormSelection</h4>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger"><fmt:message key="${item.value}" /></div>
		</c:forEach>
	</c:if>
		<form id="frmdata" action="${actionUrl}" name="selectionfrm" method="post">
			<fieldset>
				<legend style="color: blue" align="left">ITR Form Selection</legend>
				<p>
					<label for="Form Selection"><fmt:message key="member.itrform.selection" /></label>
					<select id= form name="income_tax_form_selection">
					<option>-select-</option>
					<option>ITR1</option>
					<option>ITR2</option></select>
				</p>
			</fieldset>
			<input type="submit" value="next">
			</form>
			</div>