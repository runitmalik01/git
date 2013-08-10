
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<hst:actionURL var="actionUrl" />

<table><tr><td>
					
						<div class="rowlabel">
							<label for="rentSec25A"><small><fmt:message
										key="foreign.income.house.rentSec25A.itr2" /> </small> </label>
						</div></td>
						<td>
						<div class="rowlabel">
							<input id="rentSec25A" name="rentSec25A" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.rentSec25A}"/></c:if>" />
						</div></td>
					<tr><td>
					
						<div class="rowlabel">
							<label for="arrearRentSec25B"><small><fmt:message
										key="foreign.income.house.arrearRentSec25B" /> </small> </label>
						</div></td>
						<td>
						<div class="rowlabel">
							<input id="arrearRentSec25B" name="arrearRentSec25B" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.arrearRentSec25B}"/></c:if>" />
						</div></td></tr>
					<tr><td>
					
						<div class="rowlabel">
							<label for="total_houseIncome">Total </label>
						</div></td>
						<td>
						<div class="rowlabel">
							<input id="total_houseIncome" name="total_houseIncome" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.total_houseIncome}"/></c:if>" />
						</div></td></tr>
				
					
			</table>		