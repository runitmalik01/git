<%@include file="../includes/tags.jspf" %>
<c:set value="Security Question" var="title"></c:set>
<hippo-gogreen:title title="${title}"></hippo-gogreen:title>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${securityQues eq true }">
<div class="alert alert-info">
<p><strong>Wealth4India cares about your security and we take all necessary measures to make sure your information is secured and safe.</strong></p>
<p>In order to ensure your safety we will need the following.Please answer these questions.</p>
</div>
<div class="well">
<fieldset>

<legend><strong><i class="icon-lock"></i>Security Questions</strong></legend>

<form name="securityQuestion" id="securityQuestion" action="${actionUrl}" method="post">
<c:forEach items="${questionsMap}" var="question" varStatus="stat">
	<div class="show-grid row-fluid">
			<div class="span6">
				<div class="rowlabel">
					<label for="securityQues${stat.count}"><small>Security Question${stat.count}</small></label>
				</div>
				<div class="rowlabel">
				     <c:if test="${stat.count==1}"><c:set value="${parentBean.question1}" var="que"></c:set></c:if>
				     <c:if test="${stat.count==2}"><c:set value="${parentBean.question2}" var="que"></c:set></c:if>
				     <c:if test="${stat.count==3}"><c:set value="${parentBean.question3}" var="que"></c:set></c:if>
                     <select id="securityQues${stat.count}" name="securityQues${stat.count}">
					        <option value="">-Select-</option>
						<c:forEach items="${question.value}" var="sques">
							<option value="${sques.value}" <c:if test="${sques.value==que}">selected</c:if>>${sques.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="answer${stat.count}"><small>Answer${stat.count}</small></label>
				</div>
				<div class="rowlabel">
				     <c:if test="${stat.count==1}"><c:set value="${parentBean.answer1}" var="qanswer"></c:set></c:if>
				     <c:if test="${stat.count==2}"><c:set value="${parentBean.answer2}" var="qanswer"></c:set></c:if>
				     <c:if test="${stat.count==3}"><c:set value="${parentBean.answer3}" var="qanswer"></c:set></c:if>
					<input id="answer${stat.count}" name="answer${stat.count}" value="${qanswer}" type="text"/>
				</div>
			</div>
		</div>
	</c:forEach>
	<br/>
	<div class="pull-right rowlabel span2 offset3">
	<button type="submit" class="btn btn-primary" value="Save">&nbsp;&nbsp;<i class="icon-lock icon-white"></i>Save&nbsp;&nbsp;</button>
	</div>
</form>
</fieldset>
</div>
</c:if>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
    $('document').load(function(){
    
    });
    $('document').ready(function(){
      $('.select-drop').on('change',function(){
	     if($(this).val()!=null){
		     $('#amount').show();
	     } 
      });
  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>