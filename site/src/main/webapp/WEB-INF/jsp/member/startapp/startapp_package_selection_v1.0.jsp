<%@include file="../../includes/tags.jspf"%>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="income_sources" var="incsources"/>
<div class="row show-grid">
	<div class="col-md-5">
		<div class="rowlabel">
			<label for="flex_string_ITRForm"><small>Income Sources</small></label>
		</div>
	</div>
	<div class="col-md-4">
		<div class="rowlabel">
			<label for="whoCan"><small>Package</small></label>
		</div>
	</div>
	<div class="col-md-2 col-md-offset-1">
		<div class="rowlabel">
			<label for="filingMode"><a class="btn btn-warning btn-sm" id="hlpackageselection">High Level Selection</a></label>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-5">
		<fmt:message bundle="${incsources}" key="total.source.income" var="totalSource" />
		<fmt:parseNumber integerOnly="true" value="${totalSource}" var="end" />
		<c:forEach begin="1" end="${end}" var="indexValue">
			<fmt:message bundle="${incsources}"
				key="income.source.${indexValue}.name" var="name" />
			<fmt:message bundle="${incsources}"
				key="income.source.${indexValue}.value" var="value" />
			<fmt:message bundle="${incsources}"
				key="income.source.${indexValue}.label" var="label" />
			<div class="checkbox">
				<input type="checkbox" name="${name}" value="${value}" class="packageChoice" id="${name}" /> 
				<label for="${name}"><c:out value="${label}" escapeXml="false"/></label>
			</div>
		</c:forEach>
	</div>
	<c:forEach items="${filingStatus.possibleITRForms}" var="itrForm">
	 <fmt:message key="${itrForm}.packageName" var="packageName"></fmt:message>	
	 <div class="col-md-4 <c:out value="${fn:replace(packageName,'+','plus')}"/> hide">
		<div class="well">
				<c:choose>
					<c:when test="${not empty packageName}">
						<c:if test="${packageName eq 'Deluxe'}">
							<c:set value="text-warning" var="textClass" />
						</c:if>
						<c:if test="${packageName eq 'Platinum'}">
							<c:set value="text-success" var="textClass" />
						</c:if>
						<c:if test="${packageName eq 'Platinum+'}">
							<c:set value="text-info" var="textClass" />
						</c:if>
					</c:when>
					<c:otherwise>
						<c:set value="muted" var="textClass" />
					</c:otherwise>
				</c:choose>
				<h2 class="${textClass}"><c:out value="${packageName}"/></h2>
			<p>
				<span class="label label-info">POPULAR</span>
			</p>
			<fmt:message key="${itrForm}.whoCan" var="whocan"></fmt:message>
			<p>(a)<c:out value="${fn:substringAfter(whocan,'(a)') }" escapeXml="false"/></p>
			<hr>
			<h3>&nbsp;&nbsp;&#8377;&nbsp;<fmt:message key="${itrForm}.packageName.DIY.cost"></fmt:message>/-</h3>
			<hr>
			<p>
				<a class="btn btn-large btn-success" href="#"><i class="glyphicon glyphicon-ok"></i>&nbsp;Selected plan</a>
			</p>
		</div>
	</div>
	</c:forEach>
	<%-- <c:forEach items="${filingStatus.possibleITRForms}" var="itrForm">	
	<div class="col-xs-12 col-md-3 hide">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><fmt:message key="${itrForm}.packageName"></fmt:message></h3>
			</div>
			<div class="panel-body">
				<div class="the-price">
					<h1>
						&#8377;<fmt:message key="${itrForm}.packageName.DIY.cost"></fmt:message>
					</h1>
				</div>
				<fmt:message key="${itrForm}.whoCan" var="whocan"></fmt:message>
				<p><c:out value="${fn:substringAfter(whocan,'(a)') }" escapeXml="false"/></p>
			</div>
			<div class="panel-footer">
				<a href="#" class="btn btn-success"
					role="button">Selected Package</a>
			</div>
		</div>
	</div>
	</c:forEach> --%>
</div>
<script type="text/javascript">
 $(document).ready(function(){
	 var incomeMap = <c:out value="${jsonObjectIncomeSource}" escapeXml="false"/>; 
	 $('.packageChoice').change(function(){
		 var packageName = '';var packageKey = ''; 
		 $('.packageChoice').each( function(index,value) {
	          if(value.checked){
	        	  packageKey = packageKey + value.name + '.'; 	        	  
	          }
         });
		 packageName = incomeMap[packageKey.substring(0,packageKey.length-1)] ;
		 if(typeof packageName == "undefined") {
			 packageName = '';
		 }
		 $('.Basic').hide();
		 $('.Platinumplus').hide();
		 $('.Deluxe').hide();
		 $('.Premier').hide();
		 $('.Platinum').hide();
		 //Simple Rule If packageKey contain "propBusinessIncome" then definetly It will be Platinum i.e. ITR4
		 if(packageKey.indexOf('propBusinessIncome') != -1) {
			 $('.Platinumplus').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Platinumplus'); }); 
		 } else if(packageKey.indexOf('partnerFirmIncome') != -1 || packageKey.indexOf('moreExemptIncome') != -1) {
			 $('.Premier').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Premier'); });
		 } else if(packageKey.indexOf('moreHouseProperty') != -1 || packageKey.indexOf('capitalGain') != -1) {
			 $('.Deluxe').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Deluxe'); });
		 } else if(packageKey.indexOf('presumBusinessIncome') != -1) {
			 $('.Platinum').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Platinum'); });
		 } else if(packageKey.indexOf('salaryIncome') != -1 || packageKey.indexOf('otherSourceExLottHorse') != -1){
			 $('.Basic').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Basic'); });
		 } else if(packageKey.length == 0){
			 $('.Basic').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Basic'); });
		 }
		 		 
		 /*if(packageKey.indexOf('propBusinessIncome') != -1) {
			 $('.Platinum').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Platinum'); }); 
		 }else if(packageName != '') {
			 $('.'+packageName.replace('+','plus')).show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == packageName); });			 
		 }/* else {
			 $('.Basic').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Basic'); });
		 } */		 
	 });
 });
</script>
<hst:link var="packageprice" path="/css/package_price.css"/>
<link rel="stylesheet" media="screen" type="text/css" href="${packageprice}"/>