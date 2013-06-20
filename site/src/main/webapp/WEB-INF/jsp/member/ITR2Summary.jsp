<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>

<div class="page">
			<table class="table table-hover table-bordered">
				<tr>
					<th><fmt:message key="income.head"/></th>
					<th><fmt:message key="total.amount"/></th>
				</tr>
				<!--  lets create a bookmark for each section -->
				<tr>
					<td colspan="1" >
					<a href="#">
					<fmt:message key="salary.income"/>
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
					<fmt:message key="income.salary.penson"/>
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
						<fmt:message key="income.house.itr1" />
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
					<fmt:message key="income.capital.gain" />
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
					<fmt:message key="income.other.sources" />
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
					<fmt:message key="income.adjustment.losses" />
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#" style="font-weight:bold;">
					<fmt:message key="gross.total.income"/></a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="chapterVIdeductions.html" style="font-weight:bold;">
					<fmt:message key="deduction.under.6a"/></a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="#" style="font-weight:bold;"><fmt:message key="taxable.income"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1"><a href="#"><fmt:message key="income.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
				<tr>
				<td colspan="1"><a href="#"><fmt:message key="normal.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<td colspan="1"><a href="#"><fmt:message key="special.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="#"><fmt:message key="surcharge.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1"><a href="#"><fmt:message key="education.cess"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="#" style="font-weight:bold;"><fmt:message key="tax.education.surcharge"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
                <tr>
					<td colspan="1"><a href="#"><fmt:message key="relief.section.89"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<c:set var="pageToInclude" value="../itreturns/${financialYear.javaPackageName}/itreturnxml-rebates.jsp"/>
				<jsp:include page="${pageToInclude}"></jsp:include>
				<tr>
					<td colspan="1"><a href="rebates.html">
					<fmt:message key="relief.section.90/91"/></a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
					<fmt:message key="interest.under.section.234abc"/></a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="#" style="font-weight:bold;"><fmt:message key="total.tax.interest.payable"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="#" style="font-weight:bold;"><fmt:message key="less.prepaid.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
					<fmt:message key="advance.tax.itr1" />
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
					<fmt:message key="advance.selfassesmenttax.itr1" />
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
			    <tr>
					<td colspan="1"><a href="#"><fmt:message key="advance.tdssalary.itr1" /></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="#">
					<fmt:message key="advance.tdsothers.itr1" />
					</a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<c:choose>
				<c:when test="${BalTaxPayable gt 0}">
				<tr class="success">
					<td colspan="1"><b>Tax Payable</b>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${BalTaxPayable}"/>
						</span>
					</td>
				</tr>
				</c:when>
				<c:when test="${BalTaxPayable eq 0}">
				<tr class="success">
					<td colspan="1"><b>Tax</b>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${BalTaxPayable}"/>
						</span>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<tr class="success">
					<td colspan="1"><b>Tax Refundable</b>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${BalTaxPayable}"/>
						</span>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>
			</table>
		</div>