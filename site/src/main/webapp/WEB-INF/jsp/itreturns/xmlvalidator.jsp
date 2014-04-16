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
<%@page import="com.mootly.wcm.model.FinancialYear"%>
<%@include file="../includes/tags.jspf" %>
<hst:actionURL var="actionURL"></hst:actionURL>
<hippo-gogreen:seoheader title="Validate your Indian Income Tax Return" robots="NOINDEX, FOLLOW"/>

<div class="page">
	<h4>Validate your Indian Income Tax Return</h4>
	<h5>
		This utility can be used to validate your Indian Income Tax XML. The XML can contain multiple assessee. 
		This utility will test the XML against the Schema published by the Income Tax website.	
	</h5>
	<form method="post" action="${actionURL}" enctype="multipart/form-data">
		<input type="hidden" name="errors"/>
		<input type="hidden" name="isValid"/>	
		<fieldset id="ul_revised" class="revised_v original_h">
			<legend>Your Return</legend>
			<div class="row show-grid" id="ul_revised_input">
					<div class="col-md-12">
						<div class="rowlabel">
							<label for="financialYear"><small>Financial Year</small> </label>
						</div>
						<div class="rowlabel">
							<select id="financialYear" name="financialYear">
								<option <c:if test="${financialYear == '2011-2012'}">SELECTED</c:if> value="<%=FinancialYear.TwentyEleven%>"><%=FinancialYear.TwentyEleven.getDisplayName()%> (AY:<%=FinancialYear.TwentyEleven.getDisplayAssessmentYear()%>)</option>
								<option <c:if test="${financialYear == '2012-2013'}">SELECTED</c:if> value="<%=FinancialYear.TwentyTweleve%>"><%=FinancialYear.TwentyTweleve.getDisplayName()%> (AY:<%=FinancialYear.TwentyTweleve.getDisplayAssessmentYear()%>)</option>
							</select>
						</div>
					</div>
			</div>
			<div class="row show-grid">
					<div class="col-md-12">
						<div class="rowlabel">
							<label for="financialYear"><small>Return Type</small> </label>
						</div>
						<div class="rowlabel">
							<select id="isCorp" name="isCorp">
								<option <c:if test="${isCorp == 'FALSE'}">SELECTED</c:if> value="FALSE">Individual/HUF</option>
								<option <c:if test="${isCorp == 'TRUE'}">SELECTED</c:if> value="TRUE">Corporate</option>								
							</select>
						</div>
					</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-12">
						<div class="rowlabel">
							<label for="xml"><small>Option 1 (Upload your return)</small> </label>
						</div>
						<div class="rowlabel">
							<input type="file" name="itrxml"/>
						</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-12">
						<div class="rowlabel">
							<label for="xml"><small>Option 2 (Copy and Paste the XML here)</small> </label>
						</div>
						<div class="rowlabel">
							<textarea id="xml" name="xml" rows="10" cols="80" name="xml">${xml}</textarea>
						</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-2 col-md-offset-8">
					<input type="submit" value="Click to begin validation"/>	
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend>Validation Result </legend>
			<div class="row show-grid" id="ul_revised_input">
				<div class="col-md-2">
					<c:if test="${not empty isValid}">
						<c:choose>
							<c:when test="${isValid == 'true'}">
								<span class="label label-default label-success">Your XML is valid.</span>
							</c:when>
							<c:otherwise>
								<span class="label label-default label-warning">Your XML is not valid.</span>
							</c:otherwise>
						</c:choose>		
					</c:if>				
				</div>
				<div class="col-md-10" >
					<c:if test="${not empty errors}">
						<pre>
							<c:out value="${errors}" escapeXml="false"/>
						</pre>	
					</c:if>		
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend>ITR Computation Summary</legend>
			<div id="computationSumary">
				<c:out value="${theComputationSummary}" escapeXml="false"/>
			</div>
		</fieldset>
	</form>	
</div>

