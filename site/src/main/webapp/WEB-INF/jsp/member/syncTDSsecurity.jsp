<%@include file="../includes/tags.jspf" %>
<c:set value="Security Question" var="title"></c:set>
<hippo-gogreen:title title="${title}"></hippo-gogreen:title>
<hst:actionURL var="actionUrl"></hst:actionURL>
<hst:link var="itreturnhomepage" siteMapItemRefId="itreturnhome"/>
<w4india:itrmenu></w4india:itrmenu>

<c:choose>
  <c:when test="${not empty isInfoAvail && isInfoAvail == true}">
<form name="secQuesFrm" id="secQuesFrm" action="${actionUrl}" method="post">
    <div class="alert alert-info">
		<p>
			<strong><w4india:resellername/> cares about your security and we take all necessary measures to make sure your information is secured and safe.</strong>
		</p>
		<p>In order to import your 26AS details please answer the following questions.</p>
	</div>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${not empty error}">
		<div class="alert alert-danger alert-dismissable">
		 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			  Answer provided by you is mismatched with Income Tax Department. Please enter the correct information.
			</div>
	</c:if>
	<div class="well">
		<fieldset>		
			<legend>
				<strong><i class="glyphicon glyphicon-lock"></i>Security Questions Panel &nbsp;&nbsp;&nbsp;&nbsp;</strong>
				<c:if test="${not empty totAttemptsLeft}">
				<small><i class=" glyphicon glyphicon-warning-sign"></i><span style="color: maroon;"> You have <c:out value="${totAttemptsLeft}"></c:out> attempts now.</span></small>
				</c:if>
			</legend>
			<div class="show-grid row">
				<div class="col-md-6">
					<div class="rowlabel">
						<label for="securityQuestion"><small>Security Question</small></label>
					</div>
					<div class="rowlabel">
						<select id="securityQuestion" name="securityQuestion">
							<option value="">-Select-</option>
							<c:forEach items="${questionsMap}" var="question">
								<c:forEach items="${question.value}" var="sques">
									<option value="${sques.value}">${sques.value}</option>
								</c:forEach>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="securityAnswer"><small>Answer</small></label>
					</div>
					<div class="rowlabel">
						<input id="securityAnswer" name="securityAnswer" value="" type="text" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
			 <div class="col-md-4 col-md-offset-8 decimal">
				<a id="myModelSecQuesFrm" role="button" class="btn btn-default btn-success">Proceed</a>	
			</div>
		 </div>	
	   </fieldset>
	</div>
 </form>
 </c:when>
  <c:otherwise>
  <br>
  <div class="alert alert-info">
  <span style="color:#AC1700;">We are unable to find any information related to your 26AS from the Department of Income Tax.
    You can always update your Tax Deduction information using one of the following</span><br><br>
     <a href="formsixteen.html"><button type="button" class="btn btn-primary"> Form 16 (Salaried)</button></a>
      <a href="salaryincome.html"><button type="button" class="btn btn-primary"> Pension</button></a>
       <a href="advancetax.html"> <button type="button" class="btn btn-primary"> Advanced Tax</button></a>
        <a href="selfassesmenttax.html"> <button type="button" class="btn btn-primary"> Self Assessment</button></a>
        <a href="tdsfromothers.html"> <button type="button" class="btn btn-primary"> TDS Others</button></a><br><br>
       <span style="color:#AC1700;"> If you have questions feel free to contact us <strong><a href="mailto:<w4india:emailcustomerservice/>"><w4india:emailcustomerservice/></a>.
       </strong></span>	
  </div>	
  </c:otherwise>
</c:choose>		

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>

<res:client-validation formId="secQuesFrm" screenConfigurationDocumentName="twentysixsecquesconfig" formSubmitButtonId="myModelSecQuesFrm" />