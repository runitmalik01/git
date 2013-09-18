<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="DPM">
	<fmt:message key="DPM" />
</c:set>
<hippo-gogreen:title title="${DPM}" />
<hst:actionURL var="actionUrl" />

<div class="page type-page">
	<w4india:itrmenu/>
<hst:link var="mainSiteMapRefId" />
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<c:if test="${not empty stopPuttingSameRate}">
		<div class="alert alert-error">
			<fmt:message key="${stopPuttingSameRate}" />
		</div>
	</c:if>
	
<h4>
	<fmt:message key="schedule.DPM.itr4" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmScheduleDPM" action="${actionUrl}" method="post"
			name="frmScheduleDPM">
			<div class="row-fluid show-grid">
			<div class="span8">
					<div class="rowlabel">
						<label for="rates"><small><fmt:message
									key="rates.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
								<select id="rates" name="rates">
								<option value="">-Select-</option>
								<option value="15"<c:if test="${not empty childBean.rates && childBean.rates =='15'}">selected</c:if>>15</option>
								<option value="30"<c:if test="${not empty childBean.rates && childBean.rates =='30'}">selected</c:if>>30</option>
								<option value="40"<c:if test="${not empty childBean.rates && childBean.rates =='40'}">selected</c:if>>40</option>
								<option value="50"<c:if test="${not empty childBean.rates && childBean.rates =='50'}">selected</c:if>>50</option>
								<option value="60"<c:if test="${not empty childBean.rates && childBean.rates =='60'}">selected</c:if>>60</option>
								<option value="80"<c:if test="${not empty childBean.rates && childBean.rates =='80'}">selected</c:if>>80</option>
								<option value="100"<c:if test="${not empty childBean.rates && childBean.rates =='100'}">selected</c:if>>100</option>
								</select>
							</div>
				</div>
				</div>
			<div class="row-fluid show-grid">
			<div class="span8">
					<div class="rowlabel">
						<label for="valFirstDayPrevYr"><small><fmt:message
									key="valFirstDayPrevYr.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="valFirstDayPrevYr" name="valFirstDayPrevYr" class="uprcase" type="text"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.valFirstDayPrevYr}"/></c:if>">
						
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
			<div class="span8">
					<div class="rowlabel">
						<label for="periodMore180Day"><small><fmt:message
									key="periodMore180Day.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="periodMore180Day" name="periodMore180Day" maxlength="14"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.periodMore180Day}"/></c:if>">
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="prevYrConsider"><small><fmt:message
									key="prevYrConsider.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="prevYrConsider" name="prevYrConsider" maxlength="14"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.prevYrConsider}"/></c:if>">
					</div>
				</div></div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="amtDepreciationFullRate"><small><fmt:message
									key="amtDepreciationFullRate.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="amtDepreciationFullRate" name="amtDepreciationFullRate" maxlength="14"
							type="text" readonly="readonly"
							 class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.amtDepreciationFullRate}"/></c:if>">
					</div>
				</div></div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="periodLess180Day"><small><fmt:message
									key="periodLess180Day.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="periodLess180Day" name="periodLess180Day" type="text" maxlength="14"
							  
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.periodLess180Day}"/></c:if>">
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="considerOrRealDuringYr"><small><fmt:message
									key="considerOrRealDuringYr.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="considerOrRealDuringYr" name="considerOrRealDuringYr" type="text" 
							maxlength="14"   class="decimal" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.considerOrRealDuringYr}"/></c:if>">
					</div>
				</div></div>
			<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="amtDepreciationHalfRate"><small><fmt:message
									key="amtDepreciationHalfRate.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="amtDepreciationHalfRate" name="depreciationFullRate" type="text" 
							maxlength="14"   class="decimal" readonly="readonly"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.depreciationFullRate}"/></c:if>">
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="depreciationFullRate"><small><fmt:message
									key="DepreciationFullRate.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="depreciationFullRate" name="depreciationFullRate" type="text" 
							maxlength="14"   class="decimal" readonly="readonly"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.depreciationFullRate}"/></c:if>">
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="depreciationHalfRate"><small><fmt:message
									key="depreciationHalfRate.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="depreciationHalfRate" name="depreciationHalfRate" type="text" 
							maxlength="14"   class="decimal" readonly="readonly"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.depreciationHalfRate}"/></c:if>">
					</div>
				</div></div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="addDepreciatMore180Day"><small><fmt:message
									key="addDepreciatMore180Day.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="addDepreciatMore180Day" name="addDepreciatMore180Day" type="text" 
							maxlength="14"   class="decimal" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.addDepreciatMore180Day}"/></c:if>">
					</div>
				</div>
		</div>
		<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="addDepreciatLess180Day"><small><fmt:message
									key="addDepreciatLess180Day.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="addDepreciatLess180Day" name="addDepreciatLess180Day" type="text" 
							maxlength="14"   class="decimal" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.addDepreciatLess180Day}"/></c:if>">
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="totalDepreciation"><small><fmt:message
									key="totalDepreciation.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="totalDepreciation" name="totalDepreciation" type="text" 
							maxlength="14"   class="decimal" readonly="readonly"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.totalDepreciation}"/></c:if>">
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="expense_TransferAsset"><small><fmt:message
									key="expense_TransferAsset.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="expense_TransferAsset" name="expense_TransferAsset" type="text" 
							maxlength="14"   class="decimal" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.expense_TransferAsset}"/></c:if>">
					</div>
				</div>
		</div>
		<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="capitalGain_LossSec50"><small><fmt:message
									key="capitalGain_LossSec50.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="capitalGain_LossSec50" name="capitalGain_LossSec50" type="text" 
							maxlength="14"   class="decimal" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.capitalGain_LossSec50}"/></c:if>">
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="valLastDayPrevYr"><small><fmt:message
									key="valLastDayPrevYr.dpm.itr4" /> </small> </label>
					</div></div>
					<div class="span4">
					<div class="rowlabel">
						<input id="valLastDayPrevYr" name="valLastDayPrevYr" type="text" 
							maxlength="14"   class="decimal" readonly="readonly"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.valLastDayPrevYr}"/></c:if>">
					</div>
				</div>
		</div>
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="btn btn-danger">Cancel</a>&nbsp;
					<a id="myModalScheduleDPM" role="button" class="btn btn-success">Save</a>
				</div>  
			
			</div>
			
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="rates.dpm.itr4" /> </b>
				</th>
				<th><b><fmt:message key="valLastDayPrevYr.dpm.itr4" /> </b>
				</th>
				
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.scheduleDPMDetailList}"
					var="scheduleDPM">
					<tr>
						<td><c:out value="${scheduleDPM.rates}" />
						</td>
						<td><c:out value="${scheduleDPM.valLastDayPrevYr}" />
						</td>
						<td><a class="btn btn-danger" style="color: black"
							href="${scriptName}/<c:out value="${scheduleDPM.canonicalUUID}"/>/scheduleDPMedit"><small><i class="icon-pencil icon-white"></i>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a class="btn btn-primary" style="color:black" href="${scriptName}/<c:out value="${scheduleDPM.canonicalUUID}"/>/scheduleDPMdelete" data-confirm=""><small><i class="icon-trash icon-white"></i>Delete</small> </a>
							</td>
						</tr>
				</c:forEach>
			</c:if>
		</table>
		<a href="${scriptName}/scheduleDPMnew"
class="btn btn-info">Add New</a>
	</c:otherwise>
</c:choose>
</div>



<res:calc screenCalc="scheduledpm" formId="frmScheduleDPM"></res:calc>
<res:client-validation formId="frmScheduleDPM"
	screenConfigurationDocumentName="scheduledpm"
	formSubmitButtonId="myModalScheduleDPM" />