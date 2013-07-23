
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.beans.*" %>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
	
<script type="text/javascript">
 
 function submitSourcesOfIncome(varScreenMode){
	 
	 document.getElementById('screenMode').value = varScreenMode;
	 
	 document.getElementById('sourceOfIncomeId').submit();
	 
	 
 }
</script>
	
	
<hst:actionURL var="actionUrl"></hst:actionURL>
<form action="${actionUrl}" method="get" class="form" id="sourceOfIncomeId" name="sourceOfIncomeId">
<input type="hidden" id="screenMode" name="screenMode"  />
	<a href="${source}"><fmt:message key="member.source.of.income." />
	</a>

	<div id="demo" class="yui3-module">
		<div class="yui3-bd" align="center">
			<div class="yui3-hd">
				<div>
					<h2>Source Of Income</h2>
				</div>
				<div class="yui3-bd" align="center">
					<div id="Source_Of_Income">
						<table>
							<tr>
								<td><c:if test="${not empty errors}">
										<c:forEach items="${errors}" var="error">
											<c:if test="${error eq 'member.select.option.error'}">
												<span class="form-error"><fmt:message key="member.select.option.error" />
												</span>
											</c:if>
										</c:forEach>
									</c:if></td>
							</tr>
							<%
							
							SourceOfIncomeDocument objSourceOfIncomeDocument = (SourceOfIncomeDocument)request.getAttribute("objSourceOfIncomeDocument");
							if (null != objSourceOfIncomeDocument) { 
									
							%>
										<tr height="30px">
											<td class="label">
										<tr>
											<td><fmt:message key="member.salary.income" />
											</td>
											<td>
							
											<% if(objSourceOfIncomeDocument.getsalaryincome() == false){ 
											 %>
											
											<input type="checkbox" name="selected" value="salaryincome"  />
											<%}else{
												%>
											<input type="checkbox" name="selected" value="salaryincome" checked/>
											<% } %>
											</td>
										</tr>
			
										<tr height="30px">
											<td class="label">
										<tr>
											<td><fmt:message key="member.house.property" />
											</td>
											<td>
											<% if(objSourceOfIncomeDocument.gethouseincome() == false){				
												 %>

											<input type="checkbox" name="selected" value="houseincome" />
											<% }else{
											%>
											<input type="checkbox" name="selected" value="houseincome" checked/>
											<% } %>
											</td>
										</tr>
			
										<tr height="30px">
											<td class="label">
										<tr>
											<td><fmt:message key="member.capital.gain" />
											</td>
											<% if (objSourceOfIncomeDocument.getcapitalasset() == false) { %>
											<td><input type="checkbox" name="selected" value="capitalasset"  />
											<% }else{ %>

											<td><input type="checkbox" name="selected" value="capitalasset"  checked />
												<% } %>
											</td>
										</tr>
			
										<tr height="30px">
											<td class="label">
										<tr>
											<td><fmt:message key="member.other.source" />
											</td>
											<% if (objSourceOfIncomeDocument.getotherincome() == false) { %>
											<td><input type="checkbox" name="selected" value="otherincome"  />
											<% }else{%>
											<td><input type="checkbox" name="selected" value="otherincome"  checked/>
											<% } %>
											</td>
										</tr>

										<tr>
											<td class="submit" colspan="3" align="center"><input type="submit" value="Next" height="38px" width="90px" id="E" onClick="submitSourcesOfIncome('UPDATE')">
											</td>
										</tr>
							<% }else{ %>

										<tr height="30px">
											<td class="label">
										<tr>
											<td><fmt:message key="member.salary.income" />
											</td>
											<td>
											<input type="checkbox" name="selected" value="salaryincome"  />
											</td>
										</tr>
			
										<tr height="30px">
											<td class="label">
										<tr>
											<td><fmt:message key="member.house.property" />
											</td>
											<td>
											<input type="checkbox" name="selected" value="houseincome" />
											</td>
										</tr>
			
										<tr height="30px">
											<td class="label">
										<tr>
											<td><fmt:message key="member.capital.gain" />
											</td>
											<td><input type="checkbox" name="selected" value="capitalasset"  />
											</td>
										</tr>
			
										<tr height="30px">
											<td class="label">
										<tr>
											<td><fmt:message key="member.other.source" />
											</td>
											<td><input type="checkbox" name="selected" value="otherincome"  />
											
											</td>
										</tr>

										<tr>
											<td class="submit" colspan="3" align="center"><input type="submit" value="Next" height="38px" width="90px" id="E" onClick="submitSourcesOfIncome('CREATE')">
											</td>
										</tr>
							
							<% } %>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<hst:headContribution keyHint="buttonCss" category="css">
	<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css" var="homeSliderCss" />
	<link rel="stylesheet" media="screen" type="text/css" href="${homeSliderCss}" />
</hst:headContribution>
<hst:headContribution keyHint="form-animation" category="jsInternal">
	<script type="text/javascript" src='<hst:link path="/js/reverse_animation.js"/>'></script>
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet" href='<hst:link path="/css/animation/animation.css"/>' type="text/css" />
</hst:headContribution>


