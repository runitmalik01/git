 <%--@Author Priyank and Kusum
    28/02/2013
    
    With the help of this Jsp file we are showing users details 
    
--%>
<%@include file="../includes/commonincludes.jspf" %>
<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label"/></li>
	<li>
	    <hst:link var="home" siteMapItemRefId="home" />
	    <a href="${home}"><fmt:message key="products.detail.location.home"/></a>&gt;
	</li>
	<li>
	   <hst:link var="startapplication" siteMapItemRefId="startapplication"></hst:link>
	   <a href="${startapplication}"><fmt:message key="member.start.application"/></a>&gt;
	</li>
	<li>
	   <hst:link var="contactinformation" siteMapItemRefId="contactinformation"></hst:link>
	   <a href="${contactinformation}"><fmt:message key="member.contact.information"/></a>
	</li>
</ol>
<c:set var="deductionVI"><fmt:message key="deduction.VI-A"/></c:set>
<hippo-gogreen:title title="${deductionVI}"/>
<!-- code for personal information popup window -->
<hst:actionURL var="ActionUrl"></hst:actionURL>
<form action="${ActionUrl}" method="get">
	<div id='container'>
	<div id='content'>
		<div id='basic-modal'>
			<div><h2><fmt:message key="deduction.VI-A"/></h2></div>			
				<table>
					<tr>
						<td><fmt:message key="deduction.80C"/></td>
						<td><input name="Section80C" type="text" size="20" value="${documentc.total }" id="update" onblur="deduction()" readonly="readonly" maxlength="14" min="0"/>
                        <input type="submit" name='basic80C' value='80C'/></td>
						<td><fmt:message key="deduction.80GGC"/></td>
						<td><input name="Section80GGC" type="text" size="20" id="VIGGC" onblur="deduction()" value="${documentvia.scheduleGGC }"  maxlength="14" min="0"/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80CCC"/></td>
						<td><input name="Section80CCC" type="text" size="20" id="VICCC" onblur="deduction()" value="${documentvia.scheduleCCC }" maxlength="14" min="0"/></td>
						<td><fmt:message key="deduction.80QQB"/></td>
						<td><input name="Section80QQB" type="text" size="20" id="VIQQB" onblur="deduction()" value="${documentvia.scheduleQQB }" maxlength="14" min="0"/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80CCD"/></td>
						<td><input name="Section80CCD" type="text" size="20" id="VICCD" onblur="deduction()" value="${documentvia.scheduleCCD }" maxlength="14" min="0"/></td>
						<td><fmt:message key="deduction.80RRB"/></td>
						<td><input name="Section80RRB" type="text" size="20" id="VIRRB" onblur="deduction()" value="${documentvia.scheduleRRB }" maxlength="14" min="0"/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80D"/></td>
						<td><input name="Section80D" type="text" size="20"  id="VID" onblur="deduction()"  value="${documentvia.scheduleD }" maxlength="14" min="0"/></td>
						<td><fmt:message key="deduction.80U"/></td>
						<td><input name="Section80U" type="text" size="20" id="VIU" onblur="deduction()" value="${documentvia.scheduleU }" maxlength="14" min="0"/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80DD"/></td>
						<td><input name="Section80DD" type="text" size="20"  id="VIDD" onblur="deduction()" value="${documentvia.scheduleDD }" maxlength="14" min="0"/></td>
						<td><fmt:message key="deduction.80IA"/></td>
						<td><input name="Section80IA" type="text" size="20" value="${documentia.total }" id="update1"  onblur="deduction()" readonly="readonly" maxlength="14" min="0" />
						<input type="submit" name='basic80IA' value='80IA'/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80DDB"/></td>
						<td><input name="Section80DDB" type="text" size="20" id="VIDDB" onblur="deduction()" value="${documentvia.scheduleDDB }" maxlength="14" min="0"/></td>
						<td><fmt:message key="deduction.80IB"/></td>
						<td><input name="Section80IB" type="text" size="20" value="${documentib.total }" id="update2" onblur="deduction()" readonly="readonly" maxlength="14" min="0"/>
						<input type="submit" name='basic80IB' value='80IB'/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80E"/></td>
						<td><input name="Section80E" type="text" size="20" id="VIE" onblur="deduction()" value="${documentvia.scheduleE }" maxlength="14" min="0"/></td>
						<td><fmt:message key="deduction.80IC"/></td>
						<td><input name="Section80IC" type="text" size="20" value="${documentic.total }" id="update3"  onblur="deduction()" readonly="readonly" maxlength="14" min="0"/>
						<input type="submit" name='basic80IC' value='80IC' /></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80G"/></td>
						<td><input name="Section80G" type="text" size="20" id="update5"  onblur="deduction()" value="${documentg.total }" readonly="readonly" maxlength="14" min="0"/>
						<input type="submit" name="basic80G" id="80G" value="80G"/></td>
						<td><fmt:message key="deduction.80JJA"/></td>
						<td><input name="Section80JJA" type="text" size="20" id="VIJJA" onblur="deduction()" value="${documentvia.scheduleJJA }" maxlength="14" min="0"/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80GG"/></td>
						<td><input name="Section80GG" type="text" size="20" value="${documentgg.deductionAllow }"  id="update4" onblur="deduction()" readonly="readonly" />
						<input type="submit" name='basic80GG' value='80GG'/></td>
						<td><fmt:message key="deduction.80ID"/></td>
						<td><input name="Section80ID" type="text" size="20" id="VIID" onblur="deduction()" value="${documentvia.scheduleID }" maxlength="14" min="0"/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80GGA"/></td>
						<td><input name="Section80GGA" type="text" size="20" id="VIGGA" onblur="deduction()" value="${documentvia.scheduleGGA }" maxlength="14" min="0"/></td>
						<td><fmt:message key="deduction.80IAB"/></td>
						<td><input name="Section80IAB" type="text" size="20" id="VIIAB" onblur="deduction()" value="${documentvia.scheduleIAB }"  maxlength="14" min="0"/></td>
					</tr>
					<tr>
						<td><fmt:message key="deduction.80CCF"/></td>
						<td><input name="Section80CCF" type="text" size="20" id="VICCF" onblur="deduction()" value="${documentvia.scheduleCCF }" maxlength="14" min="0"/></td>
						<td><fmt:message key="deduction.80.total"/></td>
						<td><input name="total" type="text" size="20" id="VItotal" onblur="deduction()" readonly="readonly" value="${documentvia.total }" maxlength="14" min="0"/></td>
					</tr>
					<tr><td colspan="4" align="center"><input type="submit" name="next" value="Next" height="100px" width="90px" onsubmit="next()"/></td></tr>
				</table>		
	</div>
		
	</div>
</div>
       </form>