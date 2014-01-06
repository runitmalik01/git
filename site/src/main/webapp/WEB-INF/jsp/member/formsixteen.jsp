<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@page import="com.mootly.wcm.member.FormSixteen"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="com.mootly.wcm.beans.compound.FormSixteenDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<c:set var="formsixteentitle">
	<fmt:message key="member.form16.title" />
</c:set>
<hippo-gogreen:title title="${formsixteentitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<w4india:itrmenu></w4india:itrmenu>
<h3 id="respond1">
	<c:choose>
		<c:when
			test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
			<c:out value="${screenConfigDocument.screenHeading}" />
		</c:when>
		<c:otherwise><h2 style="color: black;">Form 16</h2></c:otherwise>
	</c:choose>
</h3>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert_error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<c:if test="${finStatus != 'H'}">
<c:choose>
	<c:when
		test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
		<form id="frmdataFormSixteen" action="${actionUrl}" name="formsixteen"
			method="post">
			
			<p>Certificate under section 203 of the Income_tax Act, 1961 for
				tax deducted at source from income chargeable under the head
				"Salaries".</p>
			<fieldset>
				<legend style="font-style: italic;color: blue;">Employer Details</legend>
				<div class="row show-grid">
					<div class="col-md-3">
						<div class="rowlabel">
							<label for="Employe_category"><fmt:message
									key="member.employe.category" /> </label>
						</div>
						<select id="Employe_category" name="Employe_category">
							<option value="">-Select-</option>
							<option value="GOV"
								<c:if test="${not empty childBean.employe_category && childBean.employe_category =='GOV'}">selected</c:if>>GOVT.</option>
							<option value="PSU"
								<c:if test="${not empty childBean.employe_category && childBean.employe_category =='PSU'}">selected</c:if>>PSU</option>
							<option value="OTH"
								<c:if test="${not empty childBean.employe_category && childBean.employe_category =='OTH'}">selected</c:if>>OTHERS.</option>
						    <option value="NA"
								<c:if test="${not empty childBean.employe_category && childBean.employe_category =='NA'}">selected</c:if>>NA</option>

						</select>
					</div>
				</div>
				<br />
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="employer">Name of Employer</label>
						</div>
						<div class="rowlabel">
							<input type="text" name="employer" id="employer" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.employer}"/></c:if>"
								maxlength="60">
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="employee">Name of Employee</label>
						</div>
						<div class="rowlabel">
							<input type="text" name="employee" class="uprcase"
								value="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}"><c:out value="${memberpersonalinformation.name}"/>
								</c:when><c:otherwise><c:out value="${memberpersonalinformation.name}"/></c:otherwise></c:choose>"
								readonly="readonly" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="pan_deductor">PAN of Employer</label>
						</div>

						<div class="rowlabel">
							<input type="text" name="pan_deductor" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_deductor}"/></c:if>">
						</div>
					</div>

				</div>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="tan_deductor">TAN of Employer <small><w4india:knowyourtan companyNameId="employer"/></small></label>
						</div>
						<div class="rowlabel">
							<input type="text" id="tan_deductor" name="tan_deductor" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_deductor}"/></c:if>">
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label>PAN of Employee </label> <input type="text"
								name="pan_employee" class="uprcase"
								value="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}"><c:out value="${memberpersonalinformation.PAN}"/>
								</c:when><c:otherwise><c:out value="${memberpersonalinformation.PAN}"/></c:otherwise></c:choose>"
								readonly="readonly" />
						</div>
					</div>

					<div class="col-md-4 <c:if test="${not empty itr2}">hide</c:if>">
						<div class="rowlabel">
							<label class="">Address of Employer</label>
						</div>

						<div class="rowlabel">

							<input id="address" type="text" name="address" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address}"/></c:if>">
						</div>
					</div>
				</div>
			</fieldset>
			<c:if test="${not empty itr2}">
		<!-- 	<%@include file="../member/formsixteen_adv1.jsp" %> -->
			<jsp:include page="formsixteen_adv1.jsp"/>

			</c:if>





			<!--
				<legend style="color: black">
					Acknowledgement Nos. of all quarterly statements of TDS under
					sub_section (3) of section 200 as<br /> provided by TIN
					Facilitation Centre or NSDL web_site
				</legend>

				<table>
					<tr>
						<th><label>Quarter</label>
						</th>

						<th><label>Acknowledgement No.</label>
						</th>

						<th><label>From</label>
						</th>
						<th><label>To</label>
						</th>
						<th><label>Assessment Year</label>
						</th>
					</tr>

					<tr>
						<td><select id="quarter_1" name="quarter_1">
								<option value="">Select One</option>
								<c:forEach var="Quarter" items="${objHashMapquarter}">
									<option
										<c:if test="${pageAction == 'EDIT_CHILD' && childBean.quarter_1 == Quarter.key}">selected</c:if>
										value="${Quarter.key}">${Quarter.value}</option>
								</c:forEach>
						</select>
						</td>


						<td><input type="text" name="acknowledge_1" maxlength="15"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.acknowledge_1}"/></c:if>"
							placeholder="123456789"></td>

						<td><input id="from_1" name="from_1"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from_1}"/></c:if>" type="text"/>
						</td>

						<td><input id="to_1" name="to_1"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to_1}"/></c:if>" type="text"/>
						</td>

						<td><input type="text" name="year1"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.year1}"/></c:if>"
							placeholder="YYYY-YY">
						</td>
					</tr>


					<tr>
						<td><select id="quarter_2" name="quarter_2">
								<option value="">Select One</option>
								<c:forEach var="Quarter" items="${objHashMapquarter}">
									<option
										<c:if test="${pageAction == 'EDIT_CHILD' && childBean.quarter_2 == Quarter.key}">selected</c:if>
										value="${Quarter.key}">${Quarter.value}</option>
								</c:forEach>
						</select>
						</td>

						<td><input type="text" name="acknowledge_2" maxlength="15"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.acknowledge_2}"/></c:if>"
							placeholder="123456789"></td>

						<td><input id="from_2" name="from_2"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from_2}"/></c:if>" type="text"/>
						</td>

						<td><input id="to_2" name="to_2"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to_2}"/></c:if>" type="text"/>
						</td>

						<td><input type="text" name="year2"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.year2}"/></c:if>"
							placeholder="YYYY-YY">
						</td>

					</tr>
					<tr>
						<td><select id="quarter_3" name="quarter_3">
								<option value="">Select One</option>
								<c:forEach var="Quarter" items="${objHashMapquarter}">
									<option
										<c:if test="${pageAction == 'EDIT_CHILD' && childBean.quarter_3 == Quarter.key}">selected</c:if>
										value="${Quarter.key}">${Quarter.value}</option>
								</c:forEach>
						</select>
						</td>

						<td><input type="text" name="acknowledge_3" maxlength="15"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.acknowledge_3}"/></c:if>"
							placeholder="123456789"></td>

						<td><input id="from_3" name="from_3"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from_3}"/></c:if>" type="text"/>
						</td>

						<td><input id="to_3" name="to_3"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to_3}"/></c:if>" type="text"/>
						</td>
						<td><input type="text" name="year3"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.year3}"/></c:if>"
							placeholder="YYYY-YY">
						</td>
					<tr>
						<td><select id="quarter_4" name="quarter_4">
								<option value="">Select One</option>
								<c:forEach var="Quarter" items="${objHashMapquarter}">
									<option
										<c:if test="${pageAction == 'EDIT_CHILD' && childBean.quarter_4 == Quarter.key}">selected</c:if>
										value="${Quarter.key}">${Quarter.value}</option>
								</c:forEach>
						</select>
						</td>

						<td><input type="text" name="acknowledge_4" maxlength="15"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.acknowledge_4}"/></c:if>"
							placeholder="123456789">
						</td>
						<td><input id="from_4" name="from_4"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from_4}"/></c:if>" type="text"/>
						</td>

						<td><input id="to_4" name="to_4"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to_4}"/></c:if>" type="text"/>
						</td>

						<td><input type="text" name="year4"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.year4}"/></c:if>"
							placeholder="YYYY-YY">
						</td>
					</tr>
				</table>
  -->
			<fieldset>
				<legend style="font-style: italic;color: blue;"> Details of salary paid and
					any other income and tax deducted</legend>
				<label><strong>1.</strong> </label> <label> Gross salary</label>
				<table>
					<tr>
						<td>(a) Salary as per provisions contained in section 17(1)</td>
						<td><input id="gross_a" name="gross_a" class=" decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.gross_a}"/></c:if>"
							placeholder="Rs." type="text" maxlength="14" />
						</td>
					</tr>
					<tr>
						<td>(b) Value of perquisites u/s 17(2)</td>
						<td><input id="gross_b" name="gross_b" class=" decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.gross_b}"/></c:if>"
							placeholder="Rs." type="text" maxlength="14" />
						</td>
					</tr>
					<tr>
						<td>(c) Profits in lieu of salary under section 17(3)</td>
						<td><input id="gross_c" name="gross_c" class=" decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.gross_c}"/></c:if>"
							placeholder="Rs." type="text" maxlength="14" />
						</td>
					</tr>
					<tr>
						<td>Allowances not exempt </td>
						<td><input id="allowNotExempt" name="allowNotExempt" class=" decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.allowNotExempt}"/></c:if>"
							placeholder="Rs." type="text" maxlength="14" />
						</td>
					</tr>
					<tr>
						<td><label>TOTAL</label>
						</td>
						<td><input id="gross_total" name="gross_total"
							readonly="readonly" class=" decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.gross_total}"/></c:if>"
							placeholder="Rs." type="text" maxlength="14" />
						</td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<legend style="font-style: italic;color: blue;">
					<em>Less:</em> Allowance to the exempt under section 10
				</legend>

				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label><strong>2.</strong> Total Allowance </label>
						</div>
					</div>
					<!--
						<th><label>Rs. </label>
						</th>
						<th><label>Total</label>
						</th>

					</tr>

					<tr>
						<td><input id="less_allowance_1" name="less_allowance_1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_allowance_1}"/></c:if>"
							placeholder="Allowance" type="text"/>
						</td>

						<td><input id="less_rs_1" name="less_rs_1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_rs_1}"/></c:if>"
							placeholder="Rs." type="text"/>
						</td>

						<td><input id="less_total_1" name="less_total_1"
							class="numberinput decimal" readonly="readonly"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_total_1}"/></c:if>"
							placeholder="Rs." type="text"/>
						</td>
					</tr>

					<tr>
						<td><input id="less_allowance_2" name="less_allowance_2"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_allowance_2}"/></c:if>"
							placeholder="Allowance" type="text"/>
						</td>

						<td><input id="less_rs_2" name="less_rs_2"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_rs_2}"/></c:if>"
							placeholder="Rs." type="text"/>
						</td>
-->
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="less_total_2" name="less_total_2" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.less_total_2}"/></c:if>"
								placeholder="Rs." type="text" maxlength="14" />
						</div>
					</div>
				</div>
				<br />

				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label><strong>3.</strong> </label> <label> Balance(1-2)</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="balance" name="balance" class=" decimal"
								readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.balance}"/></c:if>"
								placeholder="Rs." type="text" maxlength="14" />
						</div>
					</div>
				</div>
			</fieldset>
			<fieldset id="deductions">
				<legend style="font-style: italic;color: blue;">Deductions U/S 16</legend>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel" id="ent">
							<strong>4(a)</strong> Entertainment allowance
						</div>
						<div class="rowlabel">
							<input id="deductions_entertainment"
								name="deductions_entertainment" class=" decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.deductions_entertainment}"/></c:if>"
								placeholder="Rs." type="text" maxlength="14" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel" id="tax">
							<strong>4(b)</strong> Tax on Employment/ Professional Tax
						</div>
						<div class="rowlabel">
							<input id="deductions_tax" name="deductions_tax" class=" decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.deductions_tax}"/></c:if>"
								placeholder="Rs." type="text" maxlength="14" />
						</div>
					</div>
				</div>
				<br />
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel" id="ent">
							<label><strong>5.</strong> </label><label>Aggregate of
								4(a) & (b) </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="deductions_total" name="deductions_total"
								class="decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.deductions_total}"/></c:if>"
								placeholder="Rs." type="text" maxlength="14" />
						</div>
					</div>
				</div>
			</fieldset>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						&nbsp;&nbsp;&nbsp;<label><strong>6.</strong>Income
							chargeable under the head."Salaries"(3-5) </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="income_chargable_total" name="income_chargable_total"
							class=" decimal" readonly="readonly"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.income_chargable_tax}"/></c:if>"
							placeholder="Rs." type="text" maxlength="14" />
					</div>
				</div>
			</div>

			<%-- 	<tr>
							<td><label><strong>7.</strong> </label> <label><em>Add</em>:
									Any other income reported by the employee </label></td>
							<td><label>Rs. </label></td>
						</tr>

						<tr>
							<td>(i)</td>
							<td><input id="additional_1" name="additional_1"
								class=" decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.additional_1}"/></c:if>"
								placeholder="Rs." type="text" /></td>
						</tr>
						<tr>
							<td>(ii)</td>
							<td><input id="additional_2" name="additional_2"
								class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.additional_2}"/></c:if>"
								placeholder="Rs." type="text" /></td>
						</tr>
						<tr>
							<td><label><strong>8.</strong> </label> <label>Gross
									total income (6 + 7)</label></td>
							<td><input id="gross_income_total" name="gross_income_total"
								class=" decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.gross_income_total}"/></c:if>"
								placeholder="Rs." type="text" /></td>
						</tr>--%>
			<!-- <table>
						<tr>
							<td><label><strong>9.</strong>Deductions under
									Chapter VI-A </label></td>
							<td class="btn btn-default" class="decimal">
								<button class="btn btn-default btn-sm dropdown-toggle"
									data-toggle="dropdown">
									Click to Add Deductions <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a
										href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.DEDUCTIONS%>">
											Add </a></li>
								</ul>
							</td>

						</tr>


							<tr>
								<td><label><strong>9.</strong> </label> <label>Deductions
										under Chapter VI-A </label>
								</td>

								<td></td>
								<td></td>
								<td><input type="text" class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ded_underchapter_6a}"/></c:if>"
								name="ded_underchapter_6a" placeholder="Rs.">
								</td>
							</tr>
							<tr>
								<th><label>(A) sections 80C, 80CCC and 80CCD </label>
								</th>
								<th></th>
								<th><label>Gross amount</label>
							</th>
								<th><label>Deductible amount</label>
							</th>
							</tr>
							<tr>
								<td><label>(a) section 80C </label>
								</td>
							<td></td>
							<td></td>
							<td></td>
							</tr>
							<tr>


								<td><label>(i) </label>
								<select id="State" name="State">
									<option value="">Select One</option>
									<c:forEach var="Deduction" items="${objHashMapDeduction}">
										<option value="${Deduction.key}">${Deduction.value}</option>
									</c:forEach>
								</select>
								</td>
								<td><input type="text" name="c_1"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_1}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
							</td>
								<td></td>

							</tr>
							<tr>
								<td><label>(ii)</label>
								<select id="State" name="State">
									<option value="">Select One</option>
									<c:forEach var="Deduction" items="${objHashMapDeduction}">
										<option value="${Deduction.key}">${Deduction.value}</option>
									</c:forEach>
								</select>
								</td>
								<td><input type="text" name="c_2"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_2}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
							</td>
								<td></td>
							</tr>
							<tr>
								<td><label>(iii) </label><select id="State" name="State">
									<option value="">Select One</option>
									<c:forEach var="Deduction" items="${objHashMapDeduction}">
										<option value="${Deduction.key}">${Deduction.value}</option>
									</c:forEach>
								</select>
							</td>
								<td><input type="text" name="c_3"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_3}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
							</td>
								<td></td>
							</tr>
							<tr>
								<td><label>(iv)</label><select id="State" name="State">
									<option value="">Select One</option>
									<c:forEach var="Deduction" items="${objHashMapDeduction}">
										<option value="${Deduction.key}">${Deduction.value}</option>
									</c:forEach>
								</select>
								</td>
								<td><input type="text" name="c_4"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_4}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
							</td>
								<td></td>
							</tr>
							<tr>
								<td><label>(v)</label><select id="State" name="State">
									<option value="">Select One</option>
									<c:forEach var="Deduction" items="${objHashMapDeduction}">
										<option value="${Deduction.key}">${Deduction.value}</option>
									</c:forEach>
								</select>
								</td>

								<td><input type="text" name="c_5"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_5}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
							</td>
								<td></td>
							</tr>

							<tr>
								<td><label>(vi)</label>
							</td>
								<td><input type="text" name="c_6a"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_6a}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
							</td>
								<td><input type="text" name="c_6b"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_6b}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
								</td>
								<td><input type="text" name="c_6c"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_6c}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
								</td>
							</tr>
							<tr>
								<td><label>(b) section 80CCC </label>
							</td>
								<td></td>
								<td><input type="text" name="ccc_1"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ccc_1}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
								</td>
								<td><input type="text" name="ccc_2"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ccc_2}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
								</td>
							</tr>
							<tr>
								<td><label>(c) section 80CCD </label>
								</td>
								<td></td>
								<td><input type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ccd_1}"/></c:if>"
								class="numberinput decimal" name="ccd_1" placeholder="Rs.">
								</td>

								<td><input type="text" name="ccd_2"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ccd_2}"/></c:if>"
								class="numberinput decimal" placeholder="Rs.">
								</td>
							</tr>
						</table>
					</fieldset>
					<label><strong>Notes:</strong> </label>

					<p>1. Aggregate amount deductible under section 80C shall not
						exceed one lakh rupees.</p>
					<p>2. Aggregate amount deductible under the three sections,
						i.e., 80C, 80CCC and 80CCD, shall not exceed one lakh rupees.</p>

					<table>
						<tr>
							<th><label>(B) other sections (e.g., 80E, 80G etc.)
									under Chapter VI-A</label>
							</th>
							<th><label>Gross amount </label>
							</th>
							<th><label>Qualifying amount </label>
							</th>
							<th><label>Deductible amount</label>
							</th>
						</tr>
						<tr>
							<td><label> (a) section <select id="a_section"
								name="a_section">
									<option value="">Select One</option>
									<c:forEach var="Deduction6a" items="${objHashMapDeduction6a}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.a_section == Deduction6a.value}">selected</c:if>
											value="${Deduction6a.key}">${Deduction6a.value}</option>
									</c:forEach>
								</select> </label>
							</td>
							<td><input type="text"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.a_section_1}"/></c:if>"
							name="a_section_1" class="numberinput decimal" placeholder="Rs.">
							</td>
							<td><input type="text"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.a_section_2}"/></c:if>"
							name="a_section_2" class="numberinput decimal" placeholder="Rs.">
							</td>
							<td><input type="text"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.a_section_3}"/></c:if>"
							name="a_section_3" class="numberinput decimal" placeholder="Rs.">
							</td>
						</tr>
						<tr>
							<td>

							 <label>(b) section
									<select id="b_section" name="b_section">
									<option value="">Select One</option>
									<c:forEach var="Deduction6a" items="${objHashMapDeduction6a}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.b_section == Deduction6a.value}">selected</c:if>
											value="${Deduction6a.key}">${Deduction6a.value}</option>
									</c:forEach>
								</select>
						</label>

							</td>
							<td><input type="text" name="b_section_1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.b_section_1}"/></c:if>"
							placeholder="Rs.">
							</td>
							<td><input type="text" name="b_section_2"
							class="numberinput decimal" placeholder="Rs."
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.b_section_2}"/></c:if>">
							</td>
							<td><input type="text" name="b_section_3"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.b_section_3}"/>
							</c:if>"
							placeholder="Rs.">
							</td>
						</tr>
						<tr>
							<td><label>(c) section <select id="c_section"
								name="c_section">
									<option value="">Select One</option>
									<c:forEach var="Deduction6a" items="${objHashMapDeduction6a}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.c_section == Deduction6a.value}">selected</c:if>
											value="${Deduction6a.key}">${Deduction6a.value}</option>
									</c:forEach>
								</select>  </label>
							</td>

							<td><input type="text" name="c_section_1"
							class="numberinput decimal" placeholder="Rs."
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_section_1}"/></c:if>">
							</td>
							<td><input type="text" name="c_section_2"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_section_2}"/></c:if>"
							class="numberinput decimal" placeholder="Rs.">
							</td>
							<td><input type="text" name="c_section_3"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_section_3}"/></c:if>"
							class="numberinput decimal" placeholder="Rs.">
							</td>
						</tr>
						<tr>
							<td><label>(d) section <select id="d_section"
								name="d_section">
									<option value="">Select One</option>
									<c:forEach var="Deduction6a" items="${objHashMapDeduction6a}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.d_section == Deduction6a.value}">selected</c:if>
											value="${Deduction6a.key}">${Deduction6a.value}</option>
									</c:forEach>
								</select>  </label>
							</td>

							<td><input type="text" name="d_section_1"
							class="numberinput decimal" placeholder="Rs."
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.d_section_1}"/></c:if>">
							</td>
							<td><input type="text" name="d_section_2"
							class="numberinput decimal" placeholder="Rs."
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.d_section_2}"/></c:if>">
							</td>
							<td><input type="text" name="d_section_3"
							class="numberinput decimal" placeholder="Rs."
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.d_section_3}"/></c:if>">
							</td>
						</tr>
						<tr>
							<td><label>(e) section <select id="e_section"
								name="e_section">
									<option value="">Select One</option>
									<c:forEach var="Deduction6a" items="${objHashMapDeduction6a}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.e_section == Deduction6a.value}">selected</c:if>
											value="${Deduction6a.key}">${Deduction6a.value}</option>
									</c:forEach>
								</select> </label>
							</td>
							<td><input type="text" name="e_section_1"
							class="numberinput decimal" placeholder="Rs."
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.e_section_1}"/></c:if>">
							</td>
							<td><input type="text" name="e_section_2"
							class="numberinput decimal" placeholder="Rs."
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.e_section_2}"/></c:if>">
							</td>
							<td><input type="text" name="e_section_3"
							class="numberinput decimal" placeholder="Rs."
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.e_section_3}"/></c:if>">
							</td>
						</tr>

					</table> -->
			<%-- 	<table>
						<tr>
							<td><label><strong>10.</strong> Aggregate of
									deductible amount under Chapter VI-A</label>
							<td></td>
							<td></td>
							<td><input id="aggregate" name="aggregate" class="decimal"
								readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${totalDeductions}"/></c:if>"
								placeholder="Rs." /></td>
						</tr>
						<tr>
							<td><label><strong>11.</strong> </label> <label>Total
									income (8-10) </label></td>
							<td>
								<!--  <input type="text" name="total_income_1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_income_1}"/></c:if>"
							placeholder="Rs.">--></td>
							<td></td>
							<td><input id="total_income_2" name="total_income_2"
								class="numberinput decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_income_2}"/></c:if>"
								placeholder="Rs."></td>
						</tr>
						<tr>
							<td><label><strong>12.</strong> </label> <label>Tax
									on total income </label></td>
							<td>
								<!-- <input type="text" name="tax_total_income_1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_total_income_1}"/></c:if>"
							placeholder="Rs.">--></td>
							<td></td>
							<td><input id="tax_total_income_2" name="tax_total_income_2"
								class="numberinput decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_total_income_2}"/></c:if>"
								placeholder="Rs."></td>
						</tr>
						<!--
					<tr>
						<td><label><strong>13.</strong> </label> <label>Surcharge
								(on tax computed at S. No. 12)</label>
						</td>

						<td>
							<input type="text" name="surcharge_1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.surcharge_1}"/></c:if>"
							placeholder="Rs.">
						</td>
						<td></td>

						<td><input id="surcharge_2" name="surcharge_2"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.surcharge_1}"/></c:if>"
							placeholder="Rs.">
						</td>
					</tr>-->

						<tr>
							<td><label> <strong>13.</strong>Education Cess @2%
									(on tax at S. No. 12 )</label></td>
							<td></td>
							<td></td>
							<td><input id="education_cess" name="education_cess"
								class=" decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.education_cess}"/></c:if>"
								placeholder="Rs."></td>
						</tr>

						<tr>
							<td><label><strong>14.</strong> </label> <label>Tax
									payable (12+13) </label></td>
							<td></td>
							<td></td>

							<td><input id="tax_payable" name="tax_payable"
								class="numberinput decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_payable}"/></c:if>"
								placeholder="Rs."></td>
						</tr>--%>
			<!--  <input type="text" name="relief_1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.relief_1}"/></c:if>"
							placeholder="Rs.">-->
			<fieldset>
				<legend style="font-style: italic;color: blue;">Tax Head</legend>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label><strong>7.</strong> </label> <label>Relief under
								section 89 </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="relief_2" name="relief_2" class="decimal" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
							<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.relief_2}"/></c:if>"
								placeholder="Rs.">
						</div>
					</div>
				</div>

				<%-- <tr>
							<td><label><strong>16.</strong> </label> <label>Tax
									payable (14-15)</label></td>

							<td>
								<!--  <input type="text" name="tax_payable1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_payable1}"/></c:if>"
							placeholder="Rs.">--></td>

							<td>
								<!-- <input type="text" name="tax_payable_1"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_payable_1}"/></c:if>"
							placeholder="Rs.">--></td>

							<td><input id="tax_payable_2" name="tax_payable_2"
								class=" decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"
            maxIntegerDigits="14" value="${childBean.tax_payable_2}"/></c:if>"
								placeholder="Rs."></td>
						</tr>--%>

				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label><strong>8.</strong> </label> <label> Less : </label>
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">&nbsp;&nbsp;&nbsp;&nbsp;(a) Tax
							Deducted at Source u/s 192(1)</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="ded_ent1" name="ded_ent1" class=" decimal"
								placeholder="Rs." maxlength="14" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.ded_ent_1}"/></c:if>">
						</div>
					</div>
				</div>
				<%-- <td><input id="ded_ent2" name="ded_ent2" class=" decimal"
								placeholder="Rs." readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ded_ent_2}"/></c:if>">
							</td>--%>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">&nbsp;&nbsp;&nbsp;&nbsp;(b) Tax paid
							by the employer on behalf of the employee u/s 192(1A) on
							perquisites u/s 8(2)</div>
					</div>

					<div class="col-md-4">
						<div class="rowlabel">
							<input id="ded_ent3" name="ded_ent3" class="numberinput decimal"
								placeholder="Rs." maxlength="14" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
					<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.ded_ent_3}"/></c:if>">

						</div>
					</div>
				</div>
				<%--<div class="row show-grid" style="display:none;">
					<div class="col-md-8">
						<div class="rowlabel">
							<label>9. Net income under the head Salary</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="ded_ent4" name="ded_ent4" class=" decimal"
								placeholder="Rs." readonly="readonly" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.ded_ent_4}"/></c:if>">
						</div>
					</div>
				</div>
			</fieldset>
			<%-- <tr>
							<td><label><strong>18.</strong> </label> <label>Tax
									payable/refundable (16-17)</label></td>
							<td></td>

							<td>
								<!-- <input type="text" name="relief_11"
							class="numberinput decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.relief_11}"/></c:if>"
							placeholder="Rs."> --></td>

							<td><input id="relief_12" name="relief_12" class="decimal"
								readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><w4india:inr value="${childBean.relief_12}"/></c:if>"
								placeholder="Rs."></td>
						</tr>--%>

			<div class="row show-grid">
				<div class="col-md-4 col-md-offset-8 decimal">
					<a href="${scriptName}?selectedItrTab=<%=ITRTab.FORM16_SINGLE%>"
						class="btn btn-info">Cancel</a>&nbsp; <a
						id="myModalHrefFormSixteen" role="button" class="btn btn-default btn-primary" style="color: black">Save</a>
				</div>
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<table class="table table-bordered">
			<tr align="center">
				<th><b>Employer Name</b>
				</th>
				<th><b>Employee Name</b>
				</th>
				<th><b>Actions</b>
				</th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.formSixteenDetailList}"
					var="salaryItemDetail">
					<tr align="center">
						<td><a
							href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/formsixteenedit"><c:out
									value="${salaryItemDetail.employer}" /> </a>
						</td>
						<td><c:out value="${salaryItemDetail.employee}" />
						</td>
						<td><a class="btn btn-default btn-primary"
							href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/formsixteenedit"><small><i
									class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small> </a>&nbsp;&nbsp;<a
							class="btn btn-default btn-danger"
							href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/formsixteendelete"
							data-confirm=""><small><i
									class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small> </a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<a href="${scriptName}/formsixteennew" class="btn btn-default btn-info" style="color: black">Add
			New</a>
	</c:otherwise>
</c:choose>
</c:if>
<br/><br/><br/>
<c:if test="${finStatus eq 'H' }">
	<h1 style="font-style: italic;color: red" align="center"><b>Sorry</b> This service is not applicable in case of 'HUF'</h1></c:if>

<%
	HstRequest hstRequest = (HstRequest) request;
	String formHTMLComplete = (String) hstRequest.getRequestContext()
			.getAttribute("formHTMLComplete");
	//request.setAttribute("formHTMLComplete, arg1)
%>
<%
	if (formHTMLComplete != null)
		out.println(formHTMLComplete);
%>
<res:calc screenCalc="formsixteen" formId="frmdataFormSixteen"></res:calc>
<res:client-validation formId="frmdataFormSixteen"
	screenConfigurationDocumentName="formsixteen"
	formSubmitButtonId="myModalHrefFormSixteen" />


<script type="text/javascript">
	<%--
	updateTANRules = function (isReq) {
		ded_ent1 = $("#ded_ent1").val().trim();
		ded_ent3 = $("#ded_ent3").val().trim();
		var ided_ent1 =0;
		var ided_ent3 =0;

		if (ded_ent1 != '' && !isNaN(ded_ent1) ) ided_ent1 = parseInt(ded_ent1);
		if (ded_ent3 != '' && !isNaN(ded_ent3) ) ided_ent3 = parseInt(ded_ent3);

		if ( (ided_ent1 + ided_ent3) > 0) {
			//ensure TAN is required and must
			$("#tan_deductor").rules("add",{
				'required':'true'
			});
		}
		else {
			//$("#tan_deductor").rules("remove","required");
		}
	};
	$("#frmdataFormSixteen").submit (function() {
		updateTANRules();
		return false;
	});

	--%>
	function hideded() {
		var d = document.getElementById("Employe_category");
		var valuePropCoOwned = d.options[d.selectedIndex].value;
		if (valuePropCoOwned == "GOV") {

			$("#deductions").show();
		} else {
			$("#deductions").hide();
		}
	}
</script>

