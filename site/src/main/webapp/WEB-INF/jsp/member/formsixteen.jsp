<%@page import="com.mootly.wcm.member.FormSixteen"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="com.mootly.wcm.beans.compound.FormSixteenDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<hst:actionURL var="actionUrl"></hst:actionURL>


<div class="page type-page">
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</h3>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert_error">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<c:choose>
		<c:when
			test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') || pageAction == 'NEW_CHILD'}">
			<h3>Form 16</h3>
			<p>Certificate under section 203 of the Income_tax Act, 1961 for
				tax deducted at source from income chargeable under the head
				"Salaries".</p>
			<form id="frmdata" action="${actionUrl}" name="frm16" method="post">
				<fieldset>
					<legend style="color: green">Employer Details</legend>
					<div class="row-fluid show-grid">

						<div class="span4">
							<div class="rowlabel">
								<label>Name and address of Employer</label>
							</div>
							<div class="rowlabel">
								<input type="text" name="employer" id="employer"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.employer}"/></c:if>"
									maxlength="60" placeholder="Employer Name...">
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label>Name of Employee</label>
							</div>
							<div class="rowlabel">
								<input type="text" name="employee"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.employee}"/></c:if>"
									maxlength="60" placeholder="Employee Name...">
							</div>
						</div>

						<div class="span3">
							<div class="rowlabel">
								<label>PAN of Deductor</label>
							</div>

							<div class="rowlabel">
								<input type="text" name="pan_deductor"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_deductor}"/></c:if>"
									placeholder="123456789">
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label>TAN of Deductor</label>
							</div>
							<div class="rowlabel">
								<input type="text" name="tan_deductor"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_deductor}"/></c:if>"
									placeholder="123456789">
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label>PAN of Employee </label> <input type="text"
									name="pan_employee"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_employee}"/></c:if>"
									placeholder="123456789">

							</div>
						</div>
					</div>

				</fieldset>

				<fieldset>

					<legend style="color: green">
						Acknowledgement Nos. of all quarterly statements of TDS under
						sub_section (3) of section 200 as<br /> provided by TIN
						Facilitation Centre or NSDL web_site
					</legend>



					<table>
						<tr>
							<th><label>Quarter</label></th>

							<th><label>Acknowledgement No.</label></th>

							<th><label>From</label></th>
							<th><label>To</label></th>
							<th><label>Assessment Year</label></th>
						</tr>

						<tr>
							<td><input type="text" name="quarter_1"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.quarter_1}"/></c:if>"
								placeholder="Quarter"></td>


							<td><input type="text" name="acknowledge_1"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.acknowledge_1}"/></c:if>"
								placeholder="123456789">
							</td>

							<td><input type="text" name="from_1"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from_1}"/></c:if>"
								placeholder="dd/mm"></td>

							<td><input type="text" name="to_1"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to_1}"/></c:if>"
								placeholder="dd/mm"></td>

							<td><input type="text" name="year1"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.year1}"/></c:if>"
								placeholder="yyyy"></td>
						</tr>


						<tr>
							<td><input type="text" name="quarter_2"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.quarter_2}"/></c:if>"
								placeholder="Quarter"></td>

							<td><input type="text" name="acknowledge_2"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.acknowledge_2}"/></c:if>"
								placeholder="123456789">
							</td>

							<td><input type="text" name="from_2"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from_2}"/></c:if>"
								placeholder="dd/mm"></td>

							<td><input type="text" name="to_2"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to_2}"/></c:if>"
								placeholder="dd/mm"></td>

							<td><input type="text" name="year2"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.year2}"/></c:if>"
								placeholder="yyyy"></td>

						</tr>
						<tr>
							<td><input type="text" name="quarter_3"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.quarter_3}"/></c:if>"
								placeholder="Quarter"></td>

							<td><input type="text" name="acknowledge_3"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.acknowledge_3}"/></c:if>"
								placeholder="123456789">
							</td>

							<td><input type="text" name="from_3"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from_3}"/></c:if>"
								placeholder="dd/mm"></td>

							<td><input type="text" name="to_3"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to_3}"/></c:if>"
								placeholder="dd/mm"></td>
							<td><input type="text" name="year3"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.year3}"/></c:if>"
								placeholder="yyyy"></td>
						<tr>
							<td><input type="text" name="quarter_4"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.quarter_4}"/></c:if>"
								placeholder="Quarter"></td>

							<td><input type="text" name="acknowledge_4"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.acknowledge_4}"/></c:if>"
								placeholder="123456789">
							</td>
							<td><input type="text" name="from_4"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from_4}"/></c:if>"
								placeholder="dd/mm"></td>

							<td><input type="text" name="to_4"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to_4}"/></c:if>"
								placeholder="dd/mm"></td>

							<td><input type="text" name="year4"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.year4}"/></c:if>"
								placeholder="yyyy"></td>
						</tr>
					</table>
					<fieldset>
						<legend style="color: green"> DETAILS OF SALARY PAID AND
							ANY OTHER INCOME AND TAX DEDUCTED</legend>
						<label><strong>1.</strong> </label> <label> Gross salary</label>
						<table>
							<tr>
								<td>(a) Salary as per provisions contained in section 17(1)
								</td>
								<td><input type="text" name="gross_a"
									class="numberinput decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.gross_a}"/></c:if>"
									placeholder="Rs."></td>
							</tr>
							<tr>
								<td>(b) Value of perquisites u/s 17(2)</td>
								<td><input type="text" name="gross_b"
									class="numberinput decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.gross_b}"/></c:if>"
									placeholder="Rs."></td>
							</tr>
							<tr>
								<td>(c) Profits in lieu of salary under section 17(3)</td>
								<td><input type="text" name="gross_c"
									class="numberinput decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.gross_c}"/></c:if>"
									placeholder="Rs."></td>
							</tr>
							<tr>
								<td><label>TOTAL</label>
								</td>
								<td><input type="text" name="gross_total"
									class="numberinput decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.gross_total}"/></c:if>"
									placeholder="Rs."></td>
							</tr>
						</table>
					</fieldset>
					<label><strong>2.</strong> </label><label> <em>Less:</em>
						Allowance to the extent exempt under section 10</label>
					<table>
						<tr>

							<th><label> Allowance </label></th>

							<th><label>Rs. </label></th>
							<th></th>
						</tr>

						<tr>
							<td><input type="text" name="less_allowance_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_allowance_1}"/></c:if>"
								placeholder="Allowance"></td>

							<td><input type="text" name="less_rs_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_rs_1}"/></c:if>"
								placeholder="Rs."></td>

							<td><input type="text" name="less_total_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_total_1}"/></c:if>"
								placeholder="Rs."></td>
						</tr>

						<tr>
							<td><input type="text" name="less_allowance_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_allowance_2}"/></c:if>"
								placeholder="Allowance"></td>

							<td><input type="text" name="less_rs_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_rs_2}"/></c:if>"
								placeholder="Rs."></td>

							<td><input type="text" name="less_total_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.less_total_2}"/></c:if>"
								placeholder="Rs."></td>
						</tr>
					</table>
					<table>
						<tr>
							<td><label><strong>3.</strong> </label> <label>
									Balance(1-2)</label>
							</td>
							<td><input type="text" name="balance"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.balance}"/></c:if>"
								placeholder="Rs."></td>
						</tr>
						<tr>
							<td><label><strong>4.</strong> </label> <label>
									Deductions : </label>
						</tr>
						<tr>
							<td><label> (a) Entertainment allowance</label>
							</td>
							<td><input type="text" name="deductions_entertainment"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.deductions_entertainment}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>

						<tr>
							<td><label>(b) Tax on Employment</label>
							</td>
							<td><input type="text" name="deductions_tax"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.deductions_tax}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>
					</table>

					<table>
						<tr>
							<td><label><strong>5.</strong> </label> <label>Aggregate
									of 4(a) and (b) </label>
							</td>
							<td><input type="text" name="deductions_total"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.deductions_total}"/></c:if>"
								placeholder="Rs."></td>
						</tr>
						<tr>
							<td><label><strong>6.</strong> </label> <label>Income
									chargeable under the head."Salaries"(3-5) </label>
							</td>
							<td><input type="text" name="income_chargable_total"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.income_chargable_tax}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>
						<tr>
							<td><label><strong>7.</strong> </label> <label><em>Add</em>:
									Any other income reported by the employee </label></td>
							<td><label>Rs. </label>
							</td>
						</tr>

						<tr>
							<td>(i)</td>
							<td><input type="text" name="additional_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.additional_1}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>
						<tr>
							<td>(ii)</td>
							<td><input type="text" name="additional_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.additional_2}"/></c:if>"
								placeholder="Rs."></td>
						</tr>
						<tr>
							<td><label><strong>8.</strong> </label> <label>Gross
									total income (6 + 7)</label>
							</td>
							<td><input type="text" name="gross_income_total"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.gross_income_total}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>
					</table>
					<fieldset>
						<legend style="color: green">Deductions</legend>
						<table>
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
								<th><label>Gross amount</label></th>
								<th><label>Deductible amount</label></th>
							</tr>
							<tr>
								<td><label>(a) section 80C </label>
								</td>
							</tr>
							<tr>


								<td><label>(i) </label>
								</td>
								<td><input type="text" name="c_1"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_1}"/></c:if>"
									class="numberinput decimal" placeholder="Rs.">
								</td>
								<td></td>
								<td></td>

							</tr>
							<tr>
								<td><label>(ii)</label>
								</td>
								<td><input type="text" name="c_2"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_2}"/></c:if>"
									class="numberinput decimal" placeholder="Rs.">
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><label>(iii) </label></td>
								<td><input type="text" name="c_3"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_3}"/></c:if>"
									class="numberinput decimal" placeholder="Rs."></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><label>(iv)</label></td>
								<td><input type="text" name="c_4"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_4}"/></c:if>"
									class="numberinput decimal" placeholder="Rs.">
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><label>(v)</label></td>
								<td><input type="text" name="c_5"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_5}"/></c:if>"
									class="numberinput decimal" placeholder="Rs.">
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><label>(vi)</label></td>
								<td><input type="text" name="c_6a"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_6a}"/></c:if>"
									class="numberinput decimal" placeholder="Rs."></td>
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
								<td><label>(b) section 80CCC </label></td>
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
							<td><label> (a) section <input type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.a_section}"/></c:if>"
									name="a_section" placeholder="(a)section"> </label>
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
							<td><label>(b) section <input type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.b_section}"/></c:if>"
									name="b_section" placeholder="(b)section"> </label>
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
							<td><label>(c) section <input type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.c_section}"/></c:if>"
									name="c_section" placeholder="(c)section"> </label>
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
							<td><label>(d) section <input type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.d_section}"/></c:if>"
									name="d_section" placeholder="(d)section"> </label>
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
							<td><label>(e) section <input type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.e_section}"/></c:if>"
									name="e_section" placeholder="(e)section"> </label>
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
					</table>
					<table>
						<tr>
							<td><label><strong>10.</strong> Aggregate of
									deductible amount under Chapter VI-A</label>
							<td></td>
							<td></td>
							<td><input type="text" name="aggregate"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.aggregate}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>
						<tr>
							<td><label><strong>11.</strong> </label> <label>Total
									income (8-10) </label>
							</td>
							<td><input type="text" name="total_income_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_income_1}"/></c:if>"
								placeholder="Rs.">
							</td>
							<td></td>
							<td><input type="text" name="total_income_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_income_2}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>
						<tr>
							<td><label><strong>12.</strong> </label> <label>Tax
									on total income </label>
							</td>
							<td><input type="text" name="tax_total_income_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_total_income_1}"/></c:if>"
								placeholder="Rs.">
							</td>
							<td></td>
							<td><input type="text" name="tax_total_income_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_total_income_1}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>

						<tr>
							<td><label><strong>13.</strong> </label> <label>Surcharge
									(on tax computed at S. No. 12)</label>
							</td>

							<td><input type="text" name="surcharge_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.surcharge_1}"/></c:if>"
								placeholder="Rs.">
							</td>
							<td></td>

							<td><input type="text" name="surcharge_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.surcharge_1}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>

						<tr>
							<td><label> <strong>14.</strong>Education Cess @2%
									(on tax at S. No. 12 plus surcharge at S. No. 13)</label>
							</td>
							<td></td>
							<td></td>
							<td><input type="text" name="education_cess"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.education_cess}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>

						<tr>
							<td><label><strong>15.</strong> </label> <label>Tax
									payable (12+13+14) </label>
							</td>
							<td></td>
							<td></td>

							<td><input type="text" name="tax_payable"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_payable}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>

						<tr>
							<td><label><strong>16.</strong> </label> <label>Relief
									under section 89 (attach details) </label>
							</td>

							<td><input type="text" name="relief_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.relief_1}"/></c:if>"
								placeholder="Rs.">
							</td>
							<td></td>

							<td><input type="text" name="relief_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.relief_2}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>

						<tr>
							<td><label><strong>17.</strong> </label> <label>Tax
									payable (15-16)</label>
							</td>

							<td><input type="text" name="tax_payable1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_payable1}"/></c:if>"
								placeholder="Rs.">
							</td>

							<td><input type="text" name="tax_payable_1"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_payable_1}"/></c:if>"
								placeholder="Rs.">
							</td>

							<td><input type="text" name="tax_payable_2"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_payable_2}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>

						<tr>
							<td><label><strong>18.</strong> </label> <label>
									Less : </label>
							</td>
						</tr>

						<tr>
							<td><label> (a) Tax Deducted at Source u/s 192(1)</label>
							</td>
							<td></td>

							<td><input type="text" name="ded_ent1"
								class="numberinput decimal" placeholder="Rs."
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ded_ent_1}"/></c:if>">
							</td>

							<td><input type="text" name="ded_ent2"
								class="numberinput decimal" placeholder="Rs."
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ded_ent_2}"/></c:if>">
							</td>
						</tr>

						<tr>
							<td><label>(b) Tax paid by the employer on behalf of
									the employee u/s 192(1A) on perquisites u/s 17(2)</label>
							</td>
							<td></td>

							<td><input type="text" name="ded_ent3"
								class="numberinput decimal" placeholder="Rs."
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ded_ent_3}"/></c:if>">
							</td>

							<td><input type="text" name="ded_ent4"
								class="numberinput decimal" placeholder="Rs."
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ded_ent_4}"/></c:if>">
							</td>
						</tr>
						<tr>
							<td><label><strong>19.</strong> </label> <label>Tax
									payable/refundable (17-18)</label>
							</td>
							<td></td>

							<td><input type="text" name="relief_11"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.relief_11}"/></c:if>"
								placeholder="Rs.">
							</td>

							<td><input type="text" name="relief_12"
								class="numberinput decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.relief_12}"/></c:if>"
								placeholder="Rs.">
							</td>
						</tr>
					</table>
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;<input
						type="submit" value="save" style="color: orange">
				</fieldset>
			</form>
		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th><b>Employer Name</b>
					</th>
					<th><b>Employee Name</b>
					</th>
					<th><b>Tax Payable/Refundable</b>
					</th>
					<th><b>Actions</b>
					</th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.formSixteenDetailList}"
						var="salaryItemDetail">
						<tr>
							<td><a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomeedit"><c:out
										value="${salaryItemDetail.employer}" /> </a>
							</td>
							<td><c:out value="${salaryItemDetail.employee}" />
							</td>
							<td align="right"><c:out
									value="${salaryItemDetail.relief_11}" />
							</td>
							<td><a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/formsixteenedit"><small>Edit</small>
							</a>&nbsp;&nbsp;<a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/formsixteendelete"><small>Delete</small>
							</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<a href="${scriptName}/formsixteennew" class="button orange">Add
				New</a>
		</c:otherwise>
	</c:choose>
</div>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
		$('input.numberinput').bind('keypress', function (e) {
        return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
         });
                
				$('#hrefLogin').click(function() {
		 			$('#frmIncomeinfo').submit();
				});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<res:client-validation formId="frmdata"
	screenConfigurationDocumentName="formsixteen"
	formSubmitButtonId="myModalHref" />
