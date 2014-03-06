
<%@page import="com.mootly.wcm.beans.compound.InvoicePaymentDetail"%>
<%@page import="com.mootly.wcm.model.PaymentType"%>
<%@page import="com.mootly.wcm.model.IndianGregorianCalendar"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="java.util.*"%>
<%@page import="com.mootly.wcm.beans.compound.InvoiceDocumentDetail"%>
<%@page import="com.mootly.wcm.member.MemberInvoice"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<%
	pageContext.setAttribute("paymentTypeValues", PaymentType.values());
%>
<c:set var="parentBeantitle">
	<fmt:message key="member.invoice.title" />
</c:set>
<hippo-gogreen:title title="${parentBeantitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<w4india:itrmenu></w4india:itrmenu>

<div class="row">
	<w4india:itrsidebar></w4india:itrsidebar>
  	<div class="${sideBarMainClass}">
  		<div id="questionandanswerformdiv" style="display:none"></div>
  		<div class="row show-grid">
  			<div class="col-md-6"><h4><strong><w4india:resellername/> Invoice</strong> </h4></div>
  			<div class="col-md-5 col-md-offset-1">
  					<span class="pull-right"><strong>Invoice Number:</strong><c:out value="${parentBean.invoiceNumber}" /></span>
  			</div>
  		</div>	
		<c:if test="${not empty formMap}">
			<c:forEach items="${formMap.message}" var="item">
				<div class="alert alert-danger">
					<fmt:message key="${item.value}" />
				</div>
			</c:forEach>
		</c:if>
		<c:choose>
			<c:when
				test="${pageAction == 'NEW_CHILD' || pageAction == 'EDIT_CHILD'}">
				<c:choose>
					<c:when test="${type == 'invoice'}">
						<form id="frmdataInvoice" action="${actionUrl}" method="post"
							name="frmdataInvoice">
							<fieldset>
								<legend>Invoice Details</legend>
								<div class="row show-grid letout_L_v letout_S_h"
									style="dispaly: none;">
									<div class="col-md-8">
										<div class="rowlabel">
											<label for="services">Services</label>
										</div>
									</div>
									<div class="col-md-4">
										<div class="rowlabel">
											<select name="serviceName" id="services">
												<option value="">-Select-</option>
												<c:forEach var="serviceList" items="${serviceDocumentList}">
													<option value="${fn:trim(serviceList.name)}"
														<c:if test="${pageAction == 'EDIT_CHILD' && serviceList.name == childBean.serviceName}">selected</c:if>>
														<c:out value="${serviceList.name}" />
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="row show-grid letout_L_v letout_S_h"
									style="dispaly: none;">
									<div class="col-md-9">
										<div class="rowlabel">
											<label for="filingMode">Offering Mode </label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="rowlabel">
											<select name="filingMode" id="filingMode">
												<option value="">-Select-</option>
												<option value="DIY"
													<c:if test="${not empty childBean.filingMode && childBean.filingMode =='DIY'}">selected</c:if>>STANDARD</option>
												<option value="DISCOUNT"
													<c:if test="${not empty childBean.filingMode && childBean.filingMode =='DISCOUNT'}">selected</c:if>>DISCOUNT</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row show-grid letout_L_v letout_S_h"
									style="dispaly: none;">
									<div class="col-md-9">
										<div class="rowlabel">
											<label for="quantity">Rate</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="rowlabel">
											<input id="serviceRate" name="serviceRate" placeholder="Rate"
												type="text"
												value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.serviceRate}"/></c:if>" />
	
										</div>
									</div>
								</div>
								<div class="row show-grid letout_L_v letout_S_h"
									style="dispaly: none;">
									<div class="col-md-9">
										<div class="rowlabel">
											<label for="quantity">Quantity</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="rowlabel">
											<input id="quantity" name="serviceQty" placeholder="Quantity"
												type="text"
												value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.serviceQty}"/></c:if>" />
	
										</div>
									</div>
								</div>
	
								<div class="row show-grid letout_L_v letout_S_h"
									style="dispaly: none;">
									<div class="col-md-9">
										<div class="rowlabel">
											<label for="amount">Amount </label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="rowlabel">
											<input id="amount" name="amount" placeholder="Amount"
												type="text"
												value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.serviceAmount}"/></c:if>" />
										</div>
									</div>
								</div>
							</fieldset>
							<div class="row show-grid">
								<div class="col-md-3 col-md-offset-10">
									<a href="${redirectURLToSamePage}" class="btn btn-default btn-danger"
										style="color: black">Cancel</a> &nbsp; <a
										id="myModalHrefinvoice" role="button" class="btn btn-default btn-success"
										style="color: black">Save</a>
								</div>
							</div>
						</form>
					</c:when>
					<c:otherwise>
							PAYMENT EDIT OR ADD			
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<!--  show the table -->
				<table class="table table-bordered table-striped">
					<tr align="center">
						<th>Description</th>
						<th class="decimal">Quantity</th>
						<th class="decimal">Rate</th>
						<th class="decimal">Amount</th>
						<c:if
							test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
							<th><b>Actions</b></th>
						</c:if>
					</tr>
					<c:if test="${not empty parentBean}">
						<c:set var="total" value="0"/>
						<c:forEach items="${parentBean.invoiceDocumentDetailList}"
							var="invoicedetail">
							<c:set var="total" value="${total + invoicedetail.serviceAmount}"/>
							<tr align="center">
							<tr>
								<td><c:out value="${invoicedetail.serviceName}" /></td>
								<td class="decimal"><c:out value="${invoicedetail.serviceQty}" /></td>
								<td class="decimal"><c:out value="${invoicedetail.serviceRate}" /></td>
								<td class="decimal"><c:out value="${invoicedetail.serviceAmount}" /></td>
								<c:if
									test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
									<td><a class="btn btn-default btn-primary"
										href="${scriptName}/<c:out value="${invoicedetail.canonicalUUID}"/>/memberinvoiceedit"><small><i
												class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small> </a>&nbsp;&nbsp;<a
										class="btn btn-default btn-danger"
										href="${scriptName}/<c:out value="${invoicedetail.canonicalUUID}"/>/memberinvoicedelete"
										data-confirm=""><small><i
												class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small> </a>
									</td>
								</c:if>
							</tr>
						</c:forEach>
						<c:if test="${fn:length (parentBean.invoiceDocumentDetailList) > 0}">
							<tr class="info">
								<td colspan="3" align="right">Total</td>
								<td align="left" class="decimal"><strong><w4india:inr value="${parentBean.totalInvoiceAmount}"/></strong></td>
							</tr>	
						</c:if>
						<c:if test="${not empty parentBean.totalPaymentAmount}">
							<tr class="info">
								<td colspan="3" align="right"><i>Less Payments</i></td>
								<td align="left" class="decimal"><w4india:inr value="${parentBean.totalPaymentAmount}"/></td>
							</tr>	
						</c:if>
						<tr class="info">
								<td colspan="3" align="right"><strong>Balance Due</strong></td>
								<td align="left" class="decimal"><strong><w4india:inr value="${parentBean.amountDue}"/></strong></td>
						</tr>
						<c:if test="${parentBean.amountDue > 0}">
							<tr class="info">
								<td colspan="3" align="right"><strong>Pay By</strong></td>
								<td class="decimal">
									<div class="btn-group">
											<button class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown">Choose Payment Method<span class="caret"></span></button>
											<ul class="dropdown-menu">
								            	<c:forEach items="${availablePaymentTypes}" var="paymentType">
								            		<li>
														<a id="link_${paymentType}" class="<c:if test="${paymentType.requiresGateway && paymentType.requiresIntermediateFormPost}">classRequiresGateway</c:if>"
														href="<c:choose><c:when test="${paymentType.requiresGateway && paymentType.requiresIntermediateFormPost}">javascript:void(0)</c:when><c:otherwise>${scriptName}/payment/paymentadd/${paymentType}</c:otherwise></c:choose>"><small><fmt:message
														key="paymentType.${paymentType}.label" /></small></a>
													</li>
												</c:forEach>
											</ul>
									</div>
								
								</td>
							</tr>
						</c:if>
					</c:if>
				</table>
				<c:if
					test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
					<c:if test="${empty NEW_CHILD_DISABLED}">
						<a href="${scriptName}/memberinvoicenew" class="btn btn-default btn-info"
							style="color: black">Add New (Service)</a>
					</c:if>
				</c:if>
				<h4>Payments</h4>
				<table class="table table-bordered table-striped">
					<tr align="center">
						<th><b>Date</b></th>
						<th><b>Payment Method</b></th>
						<th><b>Amount</b></th>
						<th><b>Payment Id</b></th>
						<th><b>Status</b></th>
						<c:if
							test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
							<th><b>Actions</b></th>
						</c:if>
					</tr>
					<c:if test="${not empty parentBean}">
						<c:forEach items="${parentBean.invoicePaymentDetailList}"
							var="invoicepaymentdetail">
							<c:set var="paymentStatus" value="UNVERIFIED" />
							<c:if test="${invoicepaymentdetail.paymentVerificationStatus == 'VERIFIED'}"> 							
								<c:choose>
									<c:when
										test="${invoicepaymentdetail.paymentType.requiresGateway}">										
										<c:choose>
											<c:when test="${not empty invoicepaymentdetail.respCode &&  invoicepaymentdetail.respCode == 'SUCCESS'}">
												<c:set var="paymentStatus" value="VERIFIED" />
											</c:when>
											<c:otherwise>
												<c:set var="paymentStatus" value="UNVERIFIED" />
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:set var="paymentStatus" value="VERIFIED" />
									</c:otherwise>
								</c:choose>
							</c:if>
							<c:if test="${not invoicepaymentdetail.paymentType.requiresGateway || (invoicepaymentdetail.paymentType.requiresGateway && paymentStatus == 'VERIFIED')  || isVendor == 'true'}">
								<tr>
									<td><fmt:formatDate
											value="${invoicepaymentdetail.paymentDate.time}"
											timeZone="<%=IndianGregorianCalendar.indianTimeZone%>" /></td>
									<td><c:out
											value="${fn:replace(invoicepaymentdetail.paymentType,'_',' ')}" />
									</td>
									<td>
										<c:choose>
											<c:when test="${paymentStatus == 'VERIFIED'}">
												<c:out value="${invoicepaymentdetail.txnAmount}" />
											</c:when>
											<c:otherwise>
												<c:out value="${invoicepaymentdetail.paymentAmount}" />
											</c:otherwise>
										</c:choose>
									</td>
									<td><c:out value="${invoicepaymentdetail.paymentTransactionId}" /></td>
									<td>${paymentStatus}</td>
									<c:if
										test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
										<td><a class="btn btn-default btn-primary"
											href="${scriptName}<c:out value="/payment/${invoicepaymentdetail.canonicalUUID}"/>/paymentedit?paymentType=${invoicepaymentdetail.paymentType}"><small><i
													class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small> </a>&nbsp;&nbsp;<a
											class="btn btn-default btn-danger"
											href="${scriptName}<c:out value="/payment/${invoicepaymentdetail.canonicalUUID}"/>/paymentdelete?paymentType=${invoicepaymentdetail.paymentType}"
											data-confirm=""><small><i
													class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small> </a>
										</td>
									</c:if>
								</tr>
							</c:if> 
						</c:forEach>
					</c:if>
				</table>
				<%-- Refunds --%>
				<c:if
					test="${not empty parentBean && fn:length(parentBean.invoiceRefundDetailList) gt 0}">
					<h4>Refunds</h4>
					<table class="table table-bordered table-striped">
						<tr align="center">
							<th><b>Date</b></th>
							<th><b>Payment By</b></th>
							<th><b>Amount</b></th>
							<th><b>Status</b></th>
							<c:if
								test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
								<th><b>Actions</b></th>
							</c:if>
						</tr>
						<c:if test="${not empty parentBean}">
							<c:forEach items="${parentBean.invoiceRefundDetailList}"
								var="invoicerefunddetail">
								<c:if
									test="${invoicerefunddetail.paymentVerificationStatus == 'VERIFIED'}">
									<tr>
										<td><fmt:formatDate
												value="${invoicerefunddetail.paymentDate.time}"
												timeZone="<%=IndianGregorianCalendar.indianTimeZone%>" /></td>
										<td><c:out
												value="${fn:replace(invoicerefunddetail.paymentType,'_',' ')}" />
										</td>
										<td><c:out value="${invoicerefunddetail.txnAmount}" /></td>
										<td>VERIFIED</td>
										<c:if
											test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
											<td><a class="btn btn-default btn-primary"
												href="${scriptName}<c:out value="/payment/${invoicerefunddetail.canonicalUUID}"/>/paymentedit/${invoicerefunddetail.paymentType}"><small><i
														class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small> </a>&nbsp;&nbsp;<a
												class="btn btn-default btn-danger"
												href="${scriptName}<c:out value="/payment/${invoicerefunddetail.canonicalUUID}"/>/paymentdelete/${invoicerefunddetail.paymentType}"
												data-confirm=""><small><i
														class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small> </a>
											</td>
										</c:if>
									</tr>
								</c:if>
							</c:forEach>
						</c:if>
					</table>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	var lst= {
	<c:forEach items="${serviceDocumentList}" var="serviceList" varStatus="varStatus">
		'<c:out value="${fn:trim(serviceList.name)}" />': {
			<c:forEach items="${serviceList.costModel}" var="costModal" varStatus="costModelVarStatus">
		    	'<c:out value="${costModal.offeringMode}" />': '<c:out value="${costModal.cost}" />'<c:if test="${not costModelVarStatus.last}">,</c:if>      
		    </c:forEach>
		}
		<c:if test="${not varStatus.last}">,</c:if>
	</c:forEach> 
	};
     $('#services').change(function(){
		 	$("#serviceRate").val( lst[$(this).val()].DIY ) ;
	  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<hst:element var="metaCustom" name="meta">
	<hst:attribute name="http-equiv">Cache-Control</hst:attribute>
	<hst:attribute name="content">no-cache, no-store, must-revalidate</hst:attribute>
</hst:element>
<hst:element var="metaCustom2" name="meta">
	<hst:attribute name="http-equiv">Pragma</hst:attribute>
	<hst:attribute name="content">no-cache</hst:attribute>
</hst:element>
<hst:element var="metaCustom3" name="meta">
	<hst:attribute name="http-equiv">Expires</hst:attribute>
	<hst:attribute name="content">0</hst:attribute>
</hst:element>
<hst:headContribution element="${metaCustom}" category="meta" />
<hst:headContribution element="${metaCustom2}" category="meta" />
<hst:headContribution element="${metaCustom3}" category="meta" />

<c:if
	test="${not empty didInvoiceGotUpdated && didInvoiceGotUpdated == 'true'}">
	<hst:element var="metaCustom4" name="meta">
		<hst:attribute name="http-equiv">refresh</hst:attribute>
		<hst:attribute name="content">5</hst:attribute>
	</hst:element>
	<hst:headContribution element="${metaCustom4}" category="meta" />
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3>
						<c:out value="Please wait.." />
					</h3>
				</div>
				<div class="modal-body">
					<c:if test="${not empty listOfPaymentUpdateResponse}">
						<ul>
							<c:forEach items="${listOfPaymentUpdateResponse}"
								var="paymentUpdateResponse">
								<c:if test="${paymentUpdateResponse.success}">
									<li>Successful payment Type: <c:out
											value="${paymentUpdateResponse.paymentType}" /> Amount:<c:out
											value="${paymentUpdateResponse.txnAmount}" /></li>
								</c:if>
							</c:forEach>
						</ul>
					</c:if>
					Please wait for the page to refresh ..
				</div>
				<div class="modal-footer">
					<a href="${scriptName}" class="btn btn-default btn-inverse" id="addNewBtn"
						style="display: none">Refresh</a>
				</div>
			</div>
		</div>
	</div>

	<hst:element var="uiCustom" name="script">
		<hst:attribute name="type">text/javascript</hst:attribute>
	  	 $(document).ready ( function() {
   			$("#myModal").modal();	  
	   	});
	</hst:element>
	<hst:headContribution element="${uiCustom}" category="jsInternal" />

</c:if>

	<hst:include ref="invoicepayment"/>

	<res:client-validation formId="frmdataInvoice"
	screenConfigurationDocumentName="memberinvoice"
	formSubmitButtonId="myModalHrefinvoice" />
