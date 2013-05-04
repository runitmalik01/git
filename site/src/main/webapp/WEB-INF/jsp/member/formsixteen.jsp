
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="breadcrumb_list" xmlns:v="http://rdf.data_vocabulary.org/#">
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title"
		href="">Home</a> </span> <span class="chevron">&#187;</span> <span
		typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">My
			Income Tax Returns</a> </span> <span class="chevron">&#187;</span> <span
		class="breadcrumb_current pan"><c:out value="${pan}" /> </span> <span
		class="chevron">&#187;</span>
</div>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert_error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<h1>Form 16</h1>
<p>Certificate under section 203 of the Income_tax Act, 1961 for tax
	deducted at source from income chargeable under the head "Salaries"</p>
<form id="frmdata" action="${actionUrl}" name="frm16" method="post">
	<fieldset>
		<legend style="color: green">Employer Details</legend>
		<table>
			<tr>
				<td><label>Name and address of the Employer</label></td>
				<td><input type="text" name="employer"
					value="${parentBean.employer}" maxlength="60"
					placeholder="employer name..."></td>
				<td><label>Name and designation of the Employee</label></td>
				<td><input type="text" name="employee"
					value="${parentBean.employee}" maxlength="60"
					placeholder="employee name..."></td>
			</tr>
		</table>

		<table>
			<tr>
				<td><label>PAN No. of the Deductor</label>
				</td>
				<td><input type="text" name="pan_deductor"
					value="${parentBean.pan_deductor}" placeholder="123456789">
				</td>

				<td><label>TAN No. of the Deductor</label> <input type="text"
					name="tan_deductor" value="${parentBean.tan_deductor}"
					placeholder="123456789">
				</td>
				<td><label>PAN No. of the Employee </label></td>
				<td><input type="text" name="pan_employee"
					value="${parentBean.pan_employee}" placeholder="123456789">
				</td>

			</tr>
		</table>
	</fieldset>

	<fieldset>

		<legend style="color: green">
			Acknowledgement Nos. of all quarterly statements of TDS under
			sub_section (3) of section 200 as<br /> provided by TIN Facilitation
			Centre or NSDL web_site
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
					value="${parentBean.quarter_1}" placeholder="Quarter"></td>


				<td><input type="text" name="acknowledge_1"
					value="${parentBean.acknowledge_1}" placeholder="123456789">
				</td>

				<td><input type="text" name="from_1"
					value="${parentBean.from_1}" placeholder="dd/mm"></td>

				<td><input type="text" name="to_1" value="${parentBean.to_1}"
					placeholder="dd/mm"></td>

				<td><input type="text" name="year1" value="${parentBean.year1}"
					placeholder="yyyy"></td>
			</tr>


			<tr>
				<td><input type="text" name="quarter_2"
					value="${parentBean.quarter_2}" placeholder="Quarter"></td>

				<td><input type="text" name="acknowledge_2"
					value="${parentBean.acknowledge_2}" placeholder="123456789">
				</td>

				<td><input type="text" name="from_2"
					value="${parentBean.from_2}" placeholder="dd/mm"></td>

				<td><input type="text" name="to_2" value="${parentBean.to_2}"
					placeholder="dd/mm"></td>

				<td><input type="text" name="year2" value="${parentBean.year2}"
					placeholder="yyyy"></td>

			</tr>
			<tr>
				<td><input type="text" name="quarter_3"
					value="${parentBean.quarter_3}" placeholder="Quarter"></td>

				<td><input type="text" name="acknowledge_3"
					value="${parentBean.acknowledge_3}" placeholder="123456789">
				</td>

				<td><input type="text" name="from_3"
					value="${parentBean.from_3}" placeholder="dd/mm"></td>

				<td><input type="text" name="to_3" value="${parentBean.to_3}"
					placeholder="dd/mm"></td>
				<td><input type="text" name="year3" value="${parentBean.year3}"
					placeholder="yyyy"></td>
			<tr>
				<td><input type="text" name="quarter_4"
					value="${parentBean.quarter_4}" placeholder="Quarter"></td>

				<td><input type="text" name="acknowledge_4"
					value="${parentBean.acknowledge_4}" placeholder="123456789">
				</td>
				<td><input type="text" name="from_4"
					value="${parentBean.from_4}" placeholder="dd/mm"></td>

				<td><input type="text" name="to_4" value="${parentBean.to_4}"
					placeholder="dd/mm"></td>

				<td><input type="text" name="year4" value="${parentBean.year4}"
					placeholder="yyyy"></td>
			</tr>
		</table>
		<fieldset>
			<legend style="color: green"> DETAILS OF SALARY PAID AND ANY
				OTHER INCOME AND TAX DEDUCTED</legend>
			<label><strong>1.</strong> </label> <label> Gross salary</label>
			<table>
				<tr>
					<td>(a) Salary as per provisions contained in
							section 17(1)
					</td>
					<td><input type="text" name="gross_a" class="numberinput"
						value="${parentBean.employer}" placeholder="Rs."></td>
				</tr>
				<tr>
					<td>(b) Value of perquisites u/s 17(2)</td>
					<td><input type="text" name="gross_b" class="numberinput"
						value="${parentBean.employer}" placeholder="Rs."></td>
				</tr>
				<tr>
					<td>(c) Profits in lieu of salary under section 17(3)</td>
					<td><input type="text" name="gross_c" class="numberinput"
						value="${parentBean.gross_c}" placeholder="Rs."></td>
				</tr>
				<tr>
					<td><label>TOTAL</label>
					</td>
					<td><input type="text" name="gross_total" class="numberinput"
						value="${parentBean.gross_total}" placeholder="Rs."></td>
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
					class="numberinput" value="${parentBean.less_allowance_1}"
					placeholder="allowance"></td>

				<td><input type="text" name="less_rs_1" class="numberinput"
					value="${parentBean.less_rs_1}" placeholder="Rs."></td>

				<td><input type="text" name="less_total_1" class="numberinput"
					value="${parentBean.less_total_1}" placeholder="Rs."></td>
			</tr>

			<tr>
				<td><input type="text" name="less_allowance_2"
					class="numberinput" value="${parentBean.less_allowance_2}"
					placeholder="allowance"></td>

				<td><input type="text" name="less_rs_2" class="numberinput"
					value="${parentBean.less_rs_2}" placeholder="Rs."></td>

				<td><input type="text" name="less_total_2" class="numberinput"
					value="${parentBean.less_total_2}" placeholder="Rs."></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><label><strong>3.</strong> </label> <label>
						Balance(1-2)</label>
				</td>
				<td><input type="text" name="deductions_entertainment"
					class="numberinput" value="${parentBean.employer}"
					placeholder="Rs."></td>
			</tr>
			<tr>
				<td><label><strong>4.</strong>
				</label> <label> Deductions : </label>
			</tr>
			<tr>
				<td><label> (a) Entertainment allowance</label>
				</td>
				<td><input type="text" name="deductions_entertainment"
					class="numberinput" value="${parentBean.deductions_entertainment}"
					placeholder="Rs.">
				</td>
			</tr>

			<tr>
				<td><label>(b) Tax on Employment</label>
				</td>
				<td><input type="text" name="deductions_tax"
					class="numberinput" value="${parentBean.deductions_tax}"
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
					class="numberinput" value="${parentBean.deductions_total}"
					placeholder="Rs."></td>
			</tr>
			<tr>
				<td><label><strong>6.</strong>
				</label> <label>Income chargeable under the head."Salaries"(3-5) </label>
				</td>
				<td><input type="text" name="income_chargable_total"
					class="numberinput" value="${parentBean.employer}"
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
				<td>i</td>
				<td><input type="text" name="additional_1" class="numberinput"
					value="${parentBean.additional_1}" placeholder="Rs.">
				</td>
			</tr>
			<tr>
				<td>ii</td>
				<td><input type="text" name="additional_2" class="numberinput"
					value="${parentBean.additional_2}" placeholder="Rs."></td>
			</tr>
			<tr>
				<td><label><strong>8.</strong>
				</label> <label>Gross total income (6 + 7)</label>
				</td>
				<td><input type="text" name="gross_income_total"
					class="numberinput" value="${parentBean.gross_income_total}"
					placeholder="Rs.">
				</td>
			</tr>
		</table>
		<fieldset>
			<legend style="color: green">Deductions</legend>
			<table>
				<tr>
					<td><label><strong>9.</strong> </label> <label>Deductions
							under Chapter VI_A </label>
					</td>
					<td></td>
					<td></td>
					<td><input type="text" class="numberinput"
						value="${parentBean.ded_underchapter_6a}"
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
					<td><label>(i) </label></td>
					<td><input type="text" name="c_1" value="${parentBean.c_1}"
						class="numberinput" placeholder="Rs.">
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>(ii)</label>
					</td>
					<td><input type="text" name="c_2" value="${parentBean.c_2}"
						class="numberinput" placeholder="Rs.">
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>(iii) </label></td>
					<td><input type="text" name="c_3" value="${parentBean.c_3}"
						class="numberinput" placeholder="Rs."></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>(iv)</label></td>
					<td><input type="text" name="c_4" value="${parentBean.c_4}"
						class="numberinput" placeholder="Rs.">
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>(v)</label></td>
					<td><input type="text" name="c_5" value="${parentBean.c_5}"
						class="numberinput" placeholder="Rs.">
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>(vi)</label></td>
					<td><input type="text" name="c_6a" value="${parentBean.c_6a}"
						class="numberinput" placeholder="Rs."></td>
					<td><input type="text" name="c_6b" value="${parentBean.c_6b}"
						class="numberinput" placeholder="Rs.">
					</td>
					<td><input type="text" name="c_6c" value="${parentBean.c_6c}"
						class="numberinput" placeholder="Rs.">
					</td>
				</tr>
				<tr>
					<td><label>(b) section 80CCC </label></td>
					<td></td>
					<td><input type="text" name="ccc_1"
						value="${parentBean.ccc_1}" class="numberinput" placeholder="Rs.">
					</td>
					<td><input type="text" name="ccc_2"
						value="${parentBean.ccc_2}" class="numberinput" placeholder="Rs.">
					</td>
				</tr>
				<tr>
					<td><label>(c) section 80CCD </label>
					</td>
					<td></td>
					<td><input type="text" value="${parentBean.ccd_1}"
						class="numberinput" name="ccd_1" placeholder="Rs.">
					</td>

					<td><input type="text" name="ccd_2"
						value="${parentBean.ccd_2}" class="numberinput" placeholder="Rs.">
					</td>
				</tr>
			</table>
		</fieldset>
		<label><strong>Notes:</strong> </label>

		<p>1. Aggregate amount deductible under section 80C shall not
			exceed one lakh rupees.</p>
		<p>2. Aggregate amount deductible under the three sections, i.e.,
			80C, 80CCC and 80CCD, shall not exceed one lakh rupees.</p>

		<table>
			<tr>
				<th><label>(B) other sections (e.g., 80E, 80G etc.)
						under Chapter VI_A</label>
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
						name="a_section" class="numberinput" placeholder="(a)section">
				</label>
				</td>
				<td><input type="text" class="numberinput" name="a_section_1"
					class="numberinput" placeholder="Rs.">
				</td>
				<td><input type="text" class="numberinput" name="a_section_2"
					class="numberinput" placeholder="Rs.">
				</td>
				<td><input type="text" class="numberinput" name="a_section_3"
					class="numberinput" placeholder="Rs.">
				</td>
			</tr>
			<tr>
				<td><label>(b) section <input type="text"
						name="b_section" placeholder="(b)section">
				</label>
				</td>
				<td><input type="text" name="b_section_1" class="numberinput"
					value="" placeholder="Rs.">
				</td>
				<td><input type="text" name="b_section_2" class="numberinput"
					placeholder="Rs.">
				</td>
				<td><input type="text" name="b_section_3" class="numberinput"
					value="" placeholder="Rs.">
				</td>
			</tr>
			<tr>
				<td><label>(c) section <input type="text"
						name="c_section" placeholder="(c)section">
				</label>
				</td>

				<td><input type="text" name="c_section_1" class="numberinput"
					placeholder="Rs.">
				</td>
				<td><input type="text" name="c_section_2" class="numberinput"
					placeholder="Rs.">
				</td>
				<td><input type="text" name="c_section_3" class="numberinput"
					placeholder="Rs.">
				</td>
			</tr>
			<tr>
				<td><label>(d) section <input type="text"
						name="d_section" placeholder="(d)section">
				</label>
				</td>

				<td><input type="text" name="d_section_1" class="numberinput"
					placeholder="Rs.">
				</td>
				<td><input type="text" name="d_section_2" class="numberinput"
					placeholder="Rs."></td>
				<td><input type="text" name="d_section_3" class="numberinput"
					placeholder="Rs.">
				</td>
			</tr>
			<tr>
				<td><label>(e) section <input type="text"
						name="e_section" placeholder="(e)section">
				</label>
				</td>
				<td><input type="text" name="e_section_1" class="numberinput"
					placeholder="Rs.">
				</td>
				<td><input type="text" name="e_section_2" class="numberinput"
					placeholder="Rs.">
				</td>
				<td><input type="text" name="e_section_3" class="numberinput"
					placeholder="Rs.">
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><label><strong>10.</strong> Aggregate of deductible
						amount under Chapter VI_A</label>
				<td></td>
				<td></td>
				<td><input type="text" name="aggregate" class="numberinput"
					value="${parentBean.aggregate}" placeholder="Rs.">
				</td>
			</tr>
			<tr>
				<td><label><strong>11.</strong> </label> <label>Total
						income (8-10) </label>
				</td>
				<td><input type="text" name="total_income_1"
					value="${parentBean.total_income_1}" placeholder="Rs.">
				</td>
				<td></td>
				<td><input type="text" name="total_income_2"
					value="${parentBean.total_income_2}" placeholder="Rs.">
				</td>
			</tr>
			<tr>
				<td><label><strong>12.</strong>
				</label> <label>Tax on total income </label>
				</td>
				<td><input type="text" name="tax_total_income_1"
					class="numberinput" value="${parentBean.tax_total_income_1}"
					placeholder="Rs.">
				</td>
				<td></td>
				<td><input type="text" name="tax_total_income_2"
					class="numberinput" value="${parentBean.tax_total_income_2}"
					placeholder="Rs.">
				</td>
			</tr>

			<tr>
				<td><label><strong>13.</strong> </label> <label>Surcharge
						(on tax computed at S. No. 12)</label>
				</td>

				<td><input type="text" name="surcharge_1" class="numberinput"
					value="${parentBean.surcharge_1}" placeholder="Rs.">
				</td>
				<td></td>

				<td><input type="text" name="surcharge_2" class="numberinput"
					value="${parentBean.surcharge_2}" placeholder="Rs.">
				</td>
			</tr>

			<tr>
				<td><label> <strong>14.</strong>Education Cess @2% (on
						tax at S. No. 12 plus surcharge at S. No. 13)</label>
				</td>
				<td></td>
				<td></td>
				<td><input type="text" name="education_cess"
					class="numberinput" value="${parentBean.education_cess}"
					placeholder="Rs.">
				</td>
			</tr>

			<tr>
				<td><label><strong>15.</strong> </label> <label>Tax
						payable (12+13+14) </label>
				</td>
				<td></td>
				<td></td>

				<td><input type="text" name="tax_payable" class="numberinput"
					value="${parentBean.tax_payable}" placeholder="Rs.">
				</td>
			</tr>

			<tr>
				<td><label><strong>16.</strong> </label> <label>Relief
						under section 89 (attach details) </label>
				</td>

				<td><input type="text" name="relief_1" class="numberinput"
					value="${parentBean.relief_1}" placeholder="Rs.">
				</td>
				<td></td>

				<td><input type="text" name="relief_2" class="numberinput"
					value="${parentBean.relief_2}" placeholder="Rs.">
				</td>
			</tr>

			<tr>
				<td><label><strong>17.</strong> </label> <label>Tax
						payable (15-16)</label>
				</td>

				<td><input type="text" name="tax_payable1" class="numberinput"
					value="${parentBean.tax_payable1}" placeholder="Rs.">
				</td>

				<td><input type="text" name="tax_payable_1" class="numberinput"
					value="${parentBean.tax_payable_1}" placeholder="Rs.">
				</td>

				<td><input type="text" name="tax_payable_2" class="numberinput"
					value="${parentBean.tax_payable_2}" placeholder="Rs.">
				</td>
			</tr>

			<tr>
				<td><label><strong>18.</strong> </label> <label> Less :
				</label>
				</td>
			</tr>

			<tr>
				<td><label> (a) Tax Deducted at Source u/s 192(1)</label>
				</td>
				<td></td>

				<td><input type="text" name="ded_ent1" class="numberinput"
					placeholder="Rs.">
				</td>

				<td><input type="text" name="ded_ent2" class="numberinput"
					placeholder="Rs.">
				</td>
			</tr>

			<tr>
				<td><label>(b) Tax paid by the employer on behalf of
						the employee u/s 192(1A) on perquisites u/s 17(2)</label>
				</td>
				<td></td>

				<td><input type="text" name="ded_ent3" class="numberinput"
					placeholder="Rs.">
				</td>

				<td><input type="text" name="ded_ent4" class="numberinput"
					placeholder="Rs.">
				</td>
			</tr>
			<tr>
				<td><label><strong>19.</strong> </label> <label>Tax
						payable/refundable (17-18)</label>
				</td>
				<td></td>

				<td><input type="text" name="relief_11" class="numberinput"
					value="${parentBean.relief_11}" placeholder="Rs.">
				</td>

				<td><input type="text" name="relief_12" class="numberinput"
					value="${parentBean.relief_12}" placeholder="Rs.">
				</td>
			</tr>
		</table>
		<input type="submit" value="save" style="color: orange">
	</fieldset>
</form>

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