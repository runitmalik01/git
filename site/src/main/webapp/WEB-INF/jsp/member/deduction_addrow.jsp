<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@include file="../includes/commonincludes.jspf" %>

<%
	List<String> listOfChoices = new ArrayList<String>();
%>
<c:forEach items="${deduction_section_heads}" var="item">
	<c:if test="${fn:startsWith(item.key,deduction_section)}">
			<c:set var="itemKey" value="${item.key}"/>
			<%
				listOfChoices.add((String) pageContext.getAttribute("itemKey"));
			%>
	</c:if>
</c:forEach>
<%
	if (listOfChoices != null && listOfChoices.size() >0 ) {
		pageContext.setAttribute("listOfChoices",listOfChoices);
	}
%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<table class="table table-striped">
	<%--<div class="span8"><c:out value="${deduction_sections[deduction_section]}"/></div> --%>
	<tr>
		<td>
			<c:choose>
				<c:when test="${not empty listOfChoices}">
					<select style="width:400px" name="head" width="100%">
						<c:forEach items="${listOfChoices}" var="aChoiceKey">	
							<c:if test="${fn:startsWith(aChoiceKey,deduction_section)}">					
								<option <c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') && childBean.head == aChoiceKey}">selected="selected"</c:if> value="<c:out value="${aChoiceKey}"/>"><c:out value="${deduction_section_heads[aChoiceKey]}"/></option>
							</c:if>
						</c:forEach>
					</select>
				</c:when>
				<c:otherwise>
					<span>Enter investment under <c:out value="${deduction_sections[deduction_section]}"/></span>
					<input type="hidden" name="head" value="<c:out value="${deduction_sections[deduction_section]}"/>"/>
				</c:otherwise>
			</c:choose>	
		</td>
		<td>
			<div class="input-prepend">
				<span class="add-on">&#8377;</span> <input name="investment" class="span2" id="prependedInput" type="text" placeholder="Gross Investment" value="<c:out value="${childBean.investment}"/>">
			</div>
		</td>
		<!-- 
		<td>
			<a id="$('#frmData').submit()">Save</a> &nbsp;&nbsp;<a href="${redirectURLToSamePage}">Cancel</a>
		</td>
		 -->
	</tr>
</table>
