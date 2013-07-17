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
<hippo-gogreen:title title="Validate your Indian Income Tax Return"/>
<div class="page">
	<h4>Validate your Indian Income Tax Return</h4>
	<form method="post" action="${actionURL}" enctype="multipart/form-data">
		<input type="hidden" name="errors"/>
		<input type="hidden" name="isValid"/>	
		<fieldset id="ul_revised" class="revised_v original_h">
			<legend>Your Return</legend>
			<div class="row-fluid show-grid" id="ul_revised_input">
					<div class="span12">
						<div class="rowlabel">
							<label for="financialYear"><small>Financial Year</small> </label>
						</div>
						<div class="rowlabel">
							<select id="financialYear" name="financialYear">
								<option value="<%=FinancialYear.TwentyTweleve%>"><%=FinancialYear.TwentyTweleve.getDisplayName()%> (AY:<%=FinancialYear.TwentyTweleve.getDisplayAssessmentYear()%>)</option>
							</select>
						</div>
					</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span12">
						<div class="rowlabel">
							<label for="xml"><small>Option 1 (Upload your return)</small> </label>
						</div>
						<div class="rowlabel">
							<input type="file" name="itrxml"/>
						</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span12">
						<div class="rowlabel">
							<label for="xml"><small>Option 2 (Copy and Paste the XML here)</small> </label>
						</div>
						<div class="rowlabel">
							<textarea id="xml" name="xml" rows="10" cols="80" name="xml">${xml}</textarea>
						</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span2 offset8">
					<input type="submit" value="Click to begin validation"/>	
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend>Validation Result </legend>
			<div class="row-fluid show-grid" id="ul_revised_input">
				<div class="span2">
					<c:if test="${not empty isValid}">
						<c:choose>
							<c:when test="${isValid == 'true'}">
								<span class="label label-success">Your XML is valid.</span>
							</c:when>
							<c:otherwise>
								<span class="label label-warning">Your XML is not valid.</span>
							</c:otherwise>
						</c:choose>		
					</c:if>				
				</div>
				<div class="span10" >
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

