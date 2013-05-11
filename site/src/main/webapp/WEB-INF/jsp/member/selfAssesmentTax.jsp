<%@include file="../includes/tags.jspf"%>

<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<c:set var="tds2">
	<fmt:message key="member.advancetax.title" />
</c:set>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hippo-gogreen:title title="${tds2}" />
<script type="text/javascript">
	function calculate() {
		var amt = document.getElementById("taxdeducted").value;
		document.getElementById("amount").value = amt;
	}
</script>
<hst:actionURL var="actionUrl" />
<hst:link var="mainSiteMapRefId" />
<hst:link var="mainSiteMapRefId"
	siteMapItemRefId="${mainSiteMapItemRefId}" />
<h4>
	<fmt:message key="member.tds.selfassesment.tax" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="selfassesment" action="${actionUrl}" method="post"
			name="selfassesment">
		
		<fieldset>
				<legend style="color: blue">Enter Details</legend>
					<div class="span4">
			            <div class="rowlabel"><label for="bsr_code"><small><fmt:message key="tds.bsr.code" /></small></label></div>
			          	<div class="rowlabel"><input id="bsr_code" name="bsr_code"  type="text" maxlength="7"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_BSR}"/></c:if>"/></div>
			          </div>
			        <div class="span4">
			            <div class="rowlabel"><label for="date_credit"><small><fmt:message key="tds.date.credit" /></small></label></div>
			          	<div class="rowlabel"><input id="date_credit" name="date_credit"  type="text" 
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateStr}"/></c:if>"/></div>
			          </div>
			              <div class="span4">
			            <div class="rowlabel"><label for="Serial_challan"><small><fmt:message key="tds.serial.challan" /></small></label></div>
			          	<div class="rowlabel"><input id="Serial_challan" name="Serial_challan"  type="text" maxlength="5"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>"/></div>
			          </div>
			               <div class="span4">
			            <div class="rowlabel"><label for="amount"><small><fmt:message key="tds.amount.selfassesment" /></small></label></div>
			          	<div class="rowlabel"><input id="amount" name="amount"  type="text" maxlength="14" class="decimal"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>"/></div>
			          </div>
			</fieldset>
				<div class="row-fluid show-grid">
					<div class="span4 offset7 decimal">
						<a href="${scriptName}" class="button olive">Cancel</a>&nbsp; <a
   					 href="javascript:void(0)" id="myModalHref" class="button orange">Save</a>

					</div>
				</div>
		</form>

	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="tds.bsr.code" /> </b>
				</th>
				<th><b><fmt:message key="tds.date.credit" /> </b>
				</th>
				<th><b><fmt:message key="tds.serial.challan" /> </b>
				</th>
				<th><b><fmt:message key="tds.amount.selfassesment" /> </b>
				</th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.selfAssesmentDetailList}"
					var="selfassesmentdetail">
					<tr>
						<td><c:out value="${selfassesmentdetail.p_BSR}" />
						</td>
						<td><c:out value="${selfassesmentdetail.dateStr}" />
						</td>
						<td><c:out value="${selfassesmentdetail.p_Serial}" />
						</td>
						<td><c:out value="${selfassesmentdetail.p_Amount}" />
						</td>
						<td><a
							href="${redirectURLToSamePage}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/selfassesmenttaxedit"><small>Edit</small>
						</a>&nbsp;&nbsp;<a
							href="${redirectURLToSamePage}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/selfassesmenttaxdelete"><small>Delete</small>
						</a>
						</td>
					</tr>

				</c:forEach>
				<tr>
					<td><fmt:message key="tds.amount.total" /></td>
					<td><input type="text" name="total_value" maxlength="14"
						readonly value="${parentBean.total_Amount}">
					</td>
			</c:if>
		</table>
		<a href="${redirectURLToSamePage}/selfassesmenttaxnew" class="button orange">Add
			New</a>
		
	</c:otherwise>
</c:choose>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
		
			    if (Modernizr.touch && Modernizr.inputtypes.date) {
			    	
			        document.getElementById('date_credit').type = 'date';
			        
			    } else {
			        $('#date_credit').datepicker({
			    
                    changeMonth: true,
                    changeYear: true,
                  
                   
                    yearRange: "2012:2013"
                    
                   });
                 
			    }
			    var filing=$('#filing').val();
			    if(filing!=null){
			        $('#status').val(filing);
			    };
			    $('#frmPersonalInfo input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmPersonalInfo').submit();
				    }
				});
				
				$('#hrefLogin').click(function() {
		 			$('#frmPersonalInfo').submit();
				});
				
				$("#pi_first_name").popover({'trigger':'focus'});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />

<res:client-validation formId="selfassesment"
	screenConfigurationDocumentName="selfassesment"
	formSubmitButtonId="myModalHref" />
