<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="ditsynctitle">
	<fmt:message key="member.ditsyn.title" />
</c:set>
<w4india:itrmenu />
<hippo-gogreen:title title="${ditsynctitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
<h3 id="respond1">
	<c:choose>
		<c:when
			test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
			<c:out value="${screenConfigDocument.screenHeading}" />
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</h3>
<c:if test="${not empty message}">
    <div class="alert alert-success">
		<c:out value="Your details has been successfully imported into your return"></c:out>
	</div>
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<c:if test="${not empty totalToBeImported && totalToBeImported == 0}">
	<div class="alert alert-info">
		Our records indicates that your income tax has all the latest 26AS information.
	</div>
</c:if>
<c:if test="${pageAction == 'SYNC_TDS_FROM_DIT'}">					
	<h4>26AS Information from Department of Income Tax</h4>
	    <c:set var="totalTDS" value="0"/>
	       <c:if test="${not empty itrSelection && itrSelection != 'ITR1' && itrSelection != 'ITR4S'}">
			  <c:set var="fromSixteenURL" value="formsixteenschedule.html"/>
		   </c:if>
		   <c:if test="${not empty itrSelection && (itrSelection == 'ITR1' || itrSelection == 'ITR4S')}">
			  <c:set var="fromSixteenURL" value="formsixteen.html"/>
	       </c:if>
		   <c:choose>
			  <c:when test="${not empty isInfoAvail && isInfoAvail == true}">
			  	<form id="tdsfromdit" action="${actionUrl}" method="post" name="tdsfromdit">
				    <table class="table table-striped">
						<tr>
							<th>Category</th>
							<th>TAN of Deductor/BSR Code</th>
							<th>Deductor Name/Sr No of Challan</th>
							<th>Date of Deposit</th>	
							<th>Salary as per Provisions contained in sec. 17(1)</th>
							<th>Total TDS/TCS</th>					
							<th>Already Imported?</th>
						</tr>
						<c:if test="${not empty  twenty26asResponse.twenty26astdsOnSalaries && fn:length(twenty26asResponse.twenty26astdsOnSalaries) > 0}">
							<c:forEach var="anItem"
								items="${twenty26asResponse.twenty26astdsOnSalaries}">
								<tr>
									<td>
										<c:choose>
											<c:when test="${empty anItem.hasAlreadyBeenImported || anItem.hasAlreadyBeenImported != 'true'}">
											<div class="rowlabel">
												<label for="category_${anItem.hashOfUniqueKeys}">Income From<span class="required" style="color:red">*</span></label>
											</div>
												<select class="required" name="category_${anItem.hashOfUniqueKeys}">
													<option value="">Select</option>
													<option value="salary">Salary</option>
													<option value="pension">Pension</option>
												</select>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${anItem.pension}">
														Pension
													</c:when>
													<c:otherwise>
														Salary
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</td>
									<td><c:out value="${anItem.TAN}" /></td>
									<td>
										<c:out value="${anItem.employerOrDeductorOrCollecterName}" />
										<c:if test="${(empty anItem.hasAlreadyBeenImported || anItem.hasAlreadyBeenImported != 'true') && (not empty itrSelection && itrSelection != 'ITR1' && itrSelection != 'ITR4S')}">
											<fieldset>
												<div class="row show-grid">
													<div class="col-md-6">
														<div class="rowlabel">
															<label for="addressdetail_${anItem.hashOfUniqueKeys}">Street<span class="required" style="color:red">*</span></label>
														</div>
														<div class="rowlabel">
															<input id="addressdetail_${anItem.hashOfUniqueKeys}" type="text" name="addressdetail_${anItem.hashOfUniqueKeys}" class="required uprcase" maxlength="200" value="" style="text-transform: uppercase;">
														</div>
													</div>
													<div class="col-md-6">
														<div class="rowlabel">
															<label for="city_${anItem.hashOfUniqueKeys}">City:<span class="required" style="color:red">*</span></label>
														</div>
														<div class="rowlabel">
															<input id="city_${anItem.hashOfUniqueKeys}" type="text" name="city_${anItem.hashOfUniqueKeys}" class="required uprcase" maxlength="50" value="" style="text-transform: uppercase;">
														</div>
													</div>
												</div>
												<div class="row show-grid">
													<div class="col-md-6">
														<div class="rowlabel">
															<label for="state_${anItem.hashOfUniqueKeys}">State<span class="required" style="color:red">*</span></label>
														</div>
														<select id="state_${anItem.hashOfUniqueKeys}" name="state_${anItem.hashOfUniqueKeys}" onchange="getautoState()" class="uprcase required states" style="text-transform: uppercase;">
																	<option value="">-Select-</option>
																	<option value="01">Andaman And Nicobar Islands</option>
																	<option value="02">Andhra Pradesh</option>
																	<option value="03">Arunachal Pradesh</option>
																	<option value="04">Assam</option>
																	<option value="05">Bihar</option>
																	<option value="06">Chandigarh</option>
																	<option value="33">Chhattisgarh</option>
																	<option value="07">Dadar And Nagar Haveli</option>
																	<option value="08">Daman And Diu</option>
																	<option value="09">Delhi</option>
																	<option value="99">Foreign</option>
																	<option value="10">Goa</option>
																	<option value="11">Gujrat</option>
																	<option value="12">Haryana</option>
																	<option value="13">Himachal Pradesh</option>
																	<option value="14">Jammu And Kashmir</option>
																	<option value="35">Jharkhand</option>
																	<option value="15">Karnataka</option>
																	<option value="16">Kerela</option>
																	<option value="17">Lakshadeep</option>
																	<option value="18">Madhya Pradesh</option>
																	<option value="19">Maharashtra</option>
																	<option value="20">Manipur</option>
																	<option value="21">Meghalaya</option>
																	<option value="22">Mizoram</option>
																	<option value="23">Nagaland</option>
																	<option value="24">Orissa</option>
																	<option value="25">Pondicherry</option>
																	<option value="26">Punjab</option>
																	<option value="27">Rajasthan</option>
																	<option value="28">Sikkim</option>
																	<option value="29">Tamil Nadu</option>
																	<option value="30">Tripura</option>
																	<option value="31">Uttar Pradesh</option>
																	<option value="34">Uttaranchal</option>
																	<option value="32">West Bengal</option>
																</select>
													</div>
													<div class="col-md-6">
														<div class="rowlabel">
															<label for="pin_${anItem.hashOfUniqueKeys}">PIN<span class="required" style="color:red">*</span></label>
														</div>
														<div class="rowlabel">
															<input id="pin_${anItem.hashOfUniqueKeys}" type="text" name="pin_${anItem.hashOfUniqueKeys}" maxlength="6" value="" class="required pin">
														</div>
													</div>
											
												</div>
											</fieldset>
										</c:if>
									</td>
									<td align="right">N/A</td>
									<td align="right">
										<c:if test="${empty anItem.hasAlreadyBeenImported || anItem.hasAlreadyBeenImported != 'true'}">
											<input class="decimal amount requiresPositiveAmount" type="text" name="incCrgSal_<c:out value="${anItem.hashOfUniqueKeys}" />" value=""/>
										</c:if>
									</td>
									<td align="right"><c:out value="${anItem.totalTDSSal}" /></td>
									<td>
										<c:if test="${anItem.hasAlreadyBeenImported == 'true'}">
										<span class="glyphicon glyphicon-ok"></span>
										  <c:choose>
										    <c:when test="${anItem.pension}">
										      <a href="${scriptName}../../salaryincome.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
										    </c:when>
										    <c:otherwise>
										      <a href="${scriptName}../../${fromSixteenURL}" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
										    </c:otherwise>
										  </c:choose>
										</c:if>
									
									</td>
								</tr>
								<c:set var="totalTDS" value="${totalTDS + anItem.totalTDSSal}"/>
							</c:forEach>
						</c:if>
						<%-- TDS Other Than Salaries --%>
						<%--
							String DeductedYr;
							String UniqueTDSCerNo;
							String EmployerOrDeductorOrCollecterName;
							String TotTDSOnAmtPaid;
							String TAN;
							String ClaimOutOfTotTDSOnAmtPaid;
					 --%>
					<c:if test="${not empty  twenty26asResponse.twenty26astdsOtherThanSalaries && fn:length(twenty26asResponse.twenty26astdsOtherThanSalaries) > 0}">
						<c:forEach var="anItem"
							items="${twenty26asResponse.twenty26astdsOtherThanSalaries}">
							<tr>
								<td>Other than Salaries</td>
								<td><c:out value="${anItem.TAN}" /></td>
								<td><c:out value="${anItem.employerOrDeductorOrCollecterName}" /></td>		
								<td align="right">N/A</td>
								<td align="right">N/A</td>			
								<%-- 
								<td><c:out value="${anItem.deductedYr}" /></td>
								<td><c:out value="${anItem.uniqueTDSCerNo}" /></td>
								 --%>
								<td align="right"><c:out value="${anItem.totTDSOnAmtPaid}" /></td>
								<%--<td align="right"><c:out value="${anItem.claimOutOfTotTDSOnAmtPaid}" /></td> --%>
								<td><c:if test="${anItem.hasAlreadyBeenImported == 'true'}"><span class="glyphicon glyphicon-ok"></span>
								<a href="${scriptName}../../tdsfromothers.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
								</c:if></td>
							</tr>
							<c:set var="totalTDS" value="${totalTDS + anItem.totTDSOnAmtPaid}"/>
						</c:forEach>
					</c:if>
					<!-- TCS -->
					<%--
					String AmtTCSClaimedThisYear;
					String EmployerOrDeductorOrCollecterName;
					String TAN;
					String TotalTCS;
		 			--%>
					<c:if test="${not empty  twenty26asResponse.twenty26astcs && fn:length(twenty26asResponse.twenty26astcs) > 0}">
						<c:forEach var="anItem"
							items="${twenty26asResponse.twenty26astcs}">
							<tr>
								<td>TCS</td>
								<td><c:out value="${anItem.TAN}" /></td>
								<td><c:out value="${anItem.employerOrDeductorOrCollecterName}" /></td>
								<td></td>
								<td align="right">N/A</td>
								<td align="right"><c:out value="${anItem.totalTCS}" /></td>
								<%--<td align="right"><c:out value="${anItem.amtTCSClaimedThisYear}" /></td> --%>
								<td><c:if test="${anItem.hasAlreadyBeenImported == 'true'}">
									<span class="glyphicon glyphicon-ok"></span>
									<a href="${scriptName}../../tcs.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
								</c:if></td>
							</tr>
							<c:set var="totalTDS" value="${totalTDS + anItem.totalTCS}"/>
						</c:forEach>
					</c:if>
					<!--  Tax Payments -->
					<%--
						String Amt;
						String SrlNoOfChaln;
						String BSRCode;
						String DateDep;
				 	--%>
			 		<%-- Advance Tax --%>
					<c:if test="${not empty  selfAssessmentList && fn:length(selfAssessmentList) > 0}">
						<c:forEach var="anItem"
							items="${selfAssessmentList}">
							<tr>
								<td>Self Assessment Tax</td>
								<td><c:out value="${anItem.BSRCode}" /></td>
								<td><c:out value="${anItem.srlNoOfChaln}" /></td>
								<td><c:out value="${anItem.dateDep}" /></td>
								<td align="right">N/A</td>
								<td align="right"><c:out value="${anItem.amt}" /></td>
								<%--<td align="right">N/A</td> --%>
								<td>
									<c:if test="${anItem.hasAlreadyBeenImported == 'true'}">
										<span class="glyphicon glyphicon-ok"></span>
										<a href="${scriptName}../../selfassesmenttax.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
									</c:if>
								</td>
							</tr>
							<c:set var="totalTDS" value="${totalTDS + anItem.amt}"/>
						</c:forEach>
					</c:if>
					<%-- Self Assessment Tax --%>
					<c:if test="${not empty  advTaxList && fn:length(advTaxList) > 0}">
						<c:forEach var="anItem"
							items="${advTaxList}">
							<tr>
								<td>Advance Tax</td>
								<td><c:out value="${anItem.BSRCode}" /></td>
								<td><c:out value="${anItem.srlNoOfChaln}" /></td>
								<td><c:out value="${anItem.dateDep}" /></td>
								<td align="right">N/A</td>
								<td align="right"><c:out value="${anItem.amt}" /></td>
								<%--<td align="right">N/A</td>--%>
								<td>
									<c:if test="${anItem.hasAlreadyBeenImported == 'true'}">
									<span class="glyphicon glyphicon-ok"></span>
									<a href="${scriptName}../../advancetax.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
									</c:if>
								</td>
							</tr>
							<c:set var="totalTDS" value="${totalTDS + anItem.amt}"/>
						</c:forEach>
					</c:if>
					<%-- final total --%>
					<c:if test="${totalTDS > 0}">
						<tr>
							<td align="right" colspan="5"><b>Total Tax Deducted</b></td>
							<td align="right"><c:out value="${totalTDS}"/></td>
							<td align="right"></td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<c:if test="${totalToBeImported > 0}">
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${redirectURLToSamePage}" class="btn btn-danger">Cancel</a>
						<button type="submit" class="btn btn-success">Import</button>
						<%--<input type="submit" value="Import" class="button default"> --%>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty totalToBeImported && totalToBeImported == 0}">
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="servicerequest-itr-summary.html" class="btn btn-default btn-success">Proceed</a>
					</div>
				</div>
			</c:if>
		</form>
  </c:when>
  <c:otherwise>
  <div class="alert alert-info">
  <span style="color:#AC1700;">We are unable to find any information related to your 26AS from the Department of Income Tax.
    You can always update your Tax Deduction information using one of the following</span><br><br>
     <a href="${fromSixteenURL}"><button type="button" class="btn btn-primary"> Form 16 (Salaried)</button></a>
      <a href="salaryincome.html"><button type="button" class="btn btn-primary"> Pension</button></a>
       <a href="advancetax.html"> <button type="button" class="btn btn-primary"> Advanced Tax</button></a>
        <a href="selfassesmenttax.html"> <button type="button" class="btn btn-primary"> Self Assessment</button></a>
        <a href="tdsfromothers.html"> <button type="button" class="btn btn-primary"> TDS Others</button></a>
        <c:if test="${not empty itrSelection && (itrSelection == 'ITR4' || itrSelection == 'ITR4S')}">
        <a href="tcsdetail.html"> <button type="button" class="btn btn-primary"> Tax Collected at Source</button></a>
        </c:if>
        <br><br>
       <span style="color:#AC1700;"> If you have questions feel free to contact us <strong><a href="mailto:<w4india:emailcustomerservice/>"><w4india:emailcustomerservice/></a>.
       </strong></span>	
  </div>	
  </c:otherwise>
</c:choose>		
</c:if>
</div>
</div>
<%--
<res:client-validation formId="tdsfromdit"
	screenConfigurationDocumentName="syncTDSFromDIT"
	formSubmitButtonId="myModalHreftdsfromdit" />
 --%>
<hst:element var="uiCustom" name="script">
		<hst:attribute name="type">text/javascript</hst:attribute>
		$().ready(function() {
		
			jQuery.validator.addClassRules({
			  required: {
			    required: true
			  },
			  requiresPositiveAmount: {
			    required: true,
			    digits: true,
			    minlength: 1
			  }
			});
			
			$("#tdsfromdit").validate();
		});
		
	<c:if test="${not empty  twenty26asResponse.twenty26astdsOnSalaries && fn:length(twenty26asResponse.twenty26astdsOnSalaries) > 0}">
	   <c:forEach var="anItem" items="${twenty26asResponse.twenty26astdsOnSalaries}">
	   		$('#state_${anItem.hashOfUniqueKeys}').change(function(){
			   if($('#state_${anItem.hashOfUniqueKeys}').val()=='99'){
			      $('#pin_${anItem.hashOfUniqueKeys}').val('999999');
			      $('#pin_${anItem.hashOfUniqueKeys}').attr('readonly','readonly');
			   }else{
                     $('#pin_${anItem.hashOfUniqueKeys}').val('');
                     $('#pin_${anItem.hashOfUniqueKeys}').removeAttr('readonly');
                    }
			});
	   </c:forEach>
	</c:if>
		
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>