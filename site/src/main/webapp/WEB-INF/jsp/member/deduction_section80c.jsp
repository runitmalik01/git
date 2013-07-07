<%@page import="java.util.ArrayList"%>
<%@page import="java.util.SortedSet"%>
<%@page import="com.mootly.wcm.utils.ValueListServiceImpl"%>
<%@page import="com.mootly.wcm.utils.ValueListService"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@include file="../includes/tags.jspf" %>
<%
ValueListService objValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapstates = objValueListService.getStates();
request.setAttribute("objHashMapstates", objHashMapstates);
%>
<fieldset id="80cadditional">
	<legend>Description</legend>
	<div class="row-fluid show-grid">
	      <div class="span8">
	      	<div class="rowlabel"><label for="flex_string_doneeName"><small></small></label></div>
	      	<div class="rowlabel"><textarea id="flex_string_doneeName" name="flex_string_doneeName" placeholder="Description" rows="5" cols="120">${doneeWithPAN.doneeName}</textarea></div>
	      </div>
	</div>
</fieldset>