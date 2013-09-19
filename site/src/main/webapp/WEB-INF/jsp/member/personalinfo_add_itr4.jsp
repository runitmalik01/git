
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<hst:actionURL var="actionUrl" />
<fieldset id="fieldsfor_ITR4" class="<c:if test="${parentBean.selectedITRForm != 'ITR4'}"> hide </c:if>">
<legend>Audit Information</legend>
<div class="row-fluid show-grid">
		<div class="span9">
				<div class="rowlabel" >
					<label for="isLiable_FurnishSec92E"><small><fmt:message key="liable.toFurnish.us99E.itr4"/> </small> </label>
				</div></div>
			
			<div class="span2">
				<div class="rowlabel">
					<select id="isLiable_FurnishSec92E" name="isLiable_FurnishSec92E">
					<option value="">-SELECT-</option>
					<option	value="Y"<c:if test="${not empty parentBean.isLiable_FurnishSec92E && parentBean.isLiable_FurnishSec92E =='Y'}">selected</c:if>>YES</option>
					<option value="N"<c:if test="${not empty parentBean.isLiable_FurnishSec92E && parentBean.isLiable_FurnishSec92E =='N'}">selected</c:if>>NO</option>
					</select>
				</div>
		</div>
		</div>
<div class="row-fluid show-grid" id="firstField_itr4">
	<div class="span9" >
				<div class="rowlabel" >
					<label for="isLiable_ManageAcc"><small>	<fmt:message key="liable.tomaintain.acounts.itr4"></fmt:message>																								 </small> </label>
				</div>
			</div>
			<div class="span2">
				<div class="rowlabel">
					<select id="isLiable_ManageAcc" name="isLiable_ManageAcc">
					<option value="">-SELECT-</option>
					<option	value="Y"<c:if test="${not empty parentBean.isLiable_ManageAcc && parentBean.isLiable_ManageAcc =='Y'}">selected</c:if>>YES</option>
					<option value="N"<c:if test="${not empty parentBean.isLiable_ManageAcc && parentBean.isLiable_ManageAcc =='N'}">selected</c:if>>NO</option>
					</select>
				</div>
		</div></div>
		<div class="row-fluid show-grid" id="secondField_itr4">
	<div class="span9" >
				<div class="rowlabel" >
					<label for="isLiable_ForAudit"><small><fmt:message key="liable.toAudit.us44AA.itr4"/> </small> </label>
				</div></div>
			
			<div class="span2">
				<div class="rowlabel">
					<select id="isLiable_ForAudit" name="isLiable_ForAudit">
					<option value="">-SELECT-</option>
					<option	value="Y"<c:if test="${not empty parentBean.isLiable_ForAudit && parentBean.isLiable_ForAudit =='Y'}">selected</c:if>>YES</option></option>
					<option value="N"<c:if test="${not empty parentBean.isLiable_ForAudit && parentBean.isLiable_ForAudit =='N'}">selected</c:if>>NO</option></option>
					</select>
				</div>
		</div></div>
		
		<div class="row-fluid show-grid <c:if test="${(parentBean.isLiable_ForAudit == 'N') || (parentBean.isLiable_ForAudit == '') }"> hide </c:if>" id="date_name_membership">
			<div class="span4">
				<div class="rowlabel">
					<label for="date_FurnishAuditReport"><small><fmt:message
								key="date.furnish.audit.report.itr4" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="date_FurnishAuditReport" name="date_FurnishAuditReport" class="uprcase"
						type="text" value="${parentBean.date_FurnishAuditReportStr}" />
				</div>
			</div>

			<div class="span4" >
				<div class="rowlabel">
					<label for="name_AuditorSign_Report"><small><fmt:message
								key="name.Auditor.Sign_Report" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="name_AuditorSign_Report" name="name_AuditorSign_Report"  class="uprcase"
						type="text" value="${parentBean.name_AuditorSign_Report}" />
				</div>
			</div>

			<div class="span4">
				<div class="rowlabel">
					<label for="membershipNo_auditor"><small><fmt:message
								key="membershipNo.auditor.ITR4" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="membershipNo_auditor" name="membershipNo_auditor" class="uprcase strict"
						type="text" value="${parentBean.membershipNo_auditor}" />
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid <c:if test="${(parentBean.isLiable_ForAudit == 'N') || (parentBean.isLiable_ForAudit == '')}"> hide </c:if>" id="name_pan_dateofAudit">
		<div class="span4">
				<div class="rowlabel">
					<label for="name_auditorFirm"><small><fmt:message
								key="name.auditorFirm.itr4" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="name_auditorFirm" name="name_auditorFirm" class="uprcase"
						type="text" value="${parentBean.name_auditorFirm}" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="pan_Firm"><small><fmt:message
								key="pan.Firm.itr4" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="pan_Firm" name="pan_Firm" class="uprcase"
						type="text" value="${parentBean.pan_Firm}" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="date_AuditReport"><small><fmt:message
								key="date.AuditReport.itr4" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="date_AuditReport" name="date_AuditReport" class="uprcase"
						type="text" value="${parentBean.date_AuditReportStr}" />
				</div>
			</div>
		</div>
		
		
</fieldset>
