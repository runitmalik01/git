<%@include file="../includes/tags.jspf" %>
<c:set var="activationtitle"><fmt:message key="member.activation.title"/></c:set>
<hippo-gogreen:title title="${activationtitle}"/>
<hst:link var="home" path="/"/>
<w4india:itrmenu></w4india:itrmenu>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>Oops!</h1>
                <div class="error-details">
              For security reason, you are required to furnish at least one information.<br>
              As you have tried all five attempts but information given by you is not correct so we can not import your form 26AS details.<br>
              You are requested to try after 1 hour by providing correct information.
                </div>
                <div class="error-actions">
                    <a href="${home}" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a><a href="mailto:<w4india:emailcustomerservice/>" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contact Support </a>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
.error-template {padding: 40px 15px;text-align: center;}
.error-actions {margin-top:15px;margin-bottom:15px;}
.error-actions .btn { margin-right:10px; }
</style>