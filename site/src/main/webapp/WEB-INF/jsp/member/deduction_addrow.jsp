<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@include file="../includes/tags.jspf" %>
<hst:actionURL var="actionUrl"></hst:actionURL>
  <fieldset>
  	  <legend>Deduction Detail</legend>
	  <div class="row show-grid">
	       <div class="col-md-8">
	        	<div class="rowlabel"><label for="ack_no"><small>Deduction Head</small></label></div>
	        	<div class="rowlabel selectdropdown">
	        		<c:choose>
						<c:when test="${not empty deductionSection.listOfDeductionHead}">
							<select name="head" width="100%" class="head">
								<c:if test="${pageAction == 'NEW_CHILD'}">
									<option value="">Select category/Click on Save when done</option>
								</c:if>
								<c:forEach items="${deductionSection.listOfDeductionHead}" var="deductionHead">	
									<option <c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') && not empty editingSection && editingSection.head == deductionHead.name}">selected="selected"</c:if> value="<c:out value="${deductionHead.name}"/>"><c:out value="${deductionHead.label}"/></option>
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>
							<span>Enter investment under <c:out value="${deductionSection.label}"/></span>
							<c:choose>
								<c:when test="${pageAction == 'EDIT_CHILD'}">
									<input type="hidden" name="head" value="<c:out value="${childBean.section}"/>"/>
								</c:when>
								<c:otherwise>
									<input type="hidden" name="head" value="<c:out value="${deductionSection.name}"/>"/>
								</c:otherwise>
							</c:choose>							
						</c:otherwise>
					</c:choose>	
	        	</div>
	       </div>
	       <div class="col-md-4">
				<div class="rowlabel"><label for="investment"><small><abbr title="Enter the gross amount. We will calculate the eligible amount">Gross Amount</abbr></small></label></div>
	       		<div class="rowlabel"><input class="theamount" name="investment" type="text" placeholder="Gross Investment" value="<c:out value="${childBean.investment}"/>"></div>
	       </div>
		</div>	     
	</fieldset>     