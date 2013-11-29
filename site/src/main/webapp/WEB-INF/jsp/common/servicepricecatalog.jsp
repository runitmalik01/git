<%@include file="../includes/tags.jspf"%>
<hst:link var="pricinglink" siteMapItemRefId="serviceprice" />
<div class="row-fluid show-grid">
	<c:if test="${not empty documents }">
		<c:set value="${12/fn:length(documents)}" var="spanVal" />
		<c:forEach var="pdocument" items="${documents }">
			<div class="grid span<fmt:parseNumber value="${spanVal}" integerOnly="true"/>">
				<div class="widget-wrapper">
					<div class="widget-title-home">
						<h3>
							<small><c:out value="${pdocument.title}"/></small>
						</h3>
					</div>
					<div class="textwidget">
						<div>
						    <fmt:message key="${whoCan[pdocument.title]}" var="whocanDetail"/>
							<c:out value="${fn:substring(whocanDetail,0,200)}" escapeXml="false" />
							<a href="${pricinglink}"> learn more..</a>
						</div>
						<%--<button type="button" class="btn btn-success">e-File (<w4india:inr minFractionDigits="0" value="499"></w4india:inr>)</button>--%>
						<button type="button" class="btnfiling btn btn-info">
							Pricing from (<w4india:inr minFractionDigits="0" value="${pdocument.efilePricing}"></w4india:inr>)
						</button>
					</div>
				</div>
				<!-- end of .widget-wrapper -->
			</div>
		</c:forEach>
	</c:if>
</div>
 <hst:headContribution  category="jsInternal">
   <script type="text/javascript">
      jQuery(function($){
      	$(window).load(function() {
      		$(".btnfiling").click(function() {
      			window.location.href="<hst:link siteMapItemRefId="itreturnhome"/>";
      		});
      		$(".btnpricing").click(function() {
      			window.location.href="serviceprice";
      		});
      		
      })
      });
   </script>
</hst:headContribution>