<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>

<w4india:itrmenu></w4india:itrmenu>

<c:set var="otherinformation">
	<fmt:message key="itr4.other.information" />
</c:set>
<hippo-gogreen:title title="${otherinformation}" />

<hst:actionURL var="actionUrl" />
<hst:link var="mainSiteMapRefId" />

<h4>
    <fmt:message key="itr4.other.information"/>
</h4>

<div class="page type-page">
     <form id="frmOtherInformation" action="${actionUrl}" method="post" name="frmOtherInformation">
		   <fieldset>
			<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="accounting_employed"><small>Method of accounting employed in the previous year</small></label>
							</div>
							<select id="accounting_employed" name="accounting_employed">
							<option value="">-SELECT-</option>
									<option value="MERC">MERCANTILE</option>
									<option value="CASH">CASH</option>
							</select>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for ="accounting_employed"><small>Method of accounting employed in the previous year</small></label>
							</div>
							<select id="accounting_employed" name="accounting_employed">
							<option value="">-SELECT-</option>
									<option value="Y">YES</option>
									<option value="N">NO</option>
							</select>
						</div>
					<div class="span4">
					      <div class="rowlabel"><label for="profit_deviation"><small>Effect on the profit because of deviation</small></label></div>
					      <div class="rowlabel"><input type="text" id="profit_deviation" name="profit_deviation" value=""/></div>
				    </div>
			</div>
			</fieldset>
		    <fieldset>
		    <legend>Method of valuation of closing stock employed in the previous year</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="raw_material"><abbr title="If at cost or market rate whichever is less write 1, if at cost write 2, if at market rate write 3"><small>Raw Material</small></abbr></label>
							</div>
							<select id="raw_material" name="raw_material">
							<option value="">-SELECT-</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
							</select>
						</div>
							<div class="span4">
							<div class="rowlabel">
								<label for ="finished_goods"><abbr title="If at cost or market rate whichever is less write 1, if at cost write 2, if at market rate write 3"><small>Finished goods</small></abbr></label>
						    </div>
							<select id="finished_goods" name="finished_goods">
							<option value="">-SELECT-</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
							</select>
						</div>
					    <div class="span4">
							<div class="rowlabel">
								<label for ="stock_valuation"><small>Is there any change in stock valuation method</small></label>
							</div>
							<select id="stock_valuation" name="stock_valuation">
							<option value="">-SELECT-</option>
									<option value="Y">YES</option>
									<option value="N">NO</option>
							</select>
						</div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					         <div class="rowlabel"><label for="loss_deviation"><small>Effect on the profit or loss because of deviation</small></label></div>
					         <div class="rowlabel"><input type="text" id="loss_deviation" name="loss_deviation" value=""/></div>
				        </div>
		           </div>
		</fieldset>
        <fieldset>
		    <legend>Amounts not credited to the profit and loss account, being</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="item_section28"><small>The items falling within the scope of section of 28</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="item_section28" name="item_section28" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="proforma_credits"><small>The proforma credits, drawbacks, refund of duty of customs or excise or service tax, or refund of sales tax or value added tax, where such credits, drawbacks, refunds are admitted as due by the authorities concerned</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="proforma_credits" name="proforma_credits" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="escalation_claims"><small>Escalation claims accepted during the previous year</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="escalation_claims" name="escalation_claims" value=""/></div>
					   </div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="other_income"><label for="loss_deviation"><small>Any other item of income</small></label></div>
					         <div class="rowlabel"><input type="text" id="other_income" name="other_income" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="capital_receipt"><label for="loss_deviation"><small>Capital receipt, if any</small></label></div>
					         <div class="rowlabel"><input type="text" id="capital_receipt" name="capital_receipt" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="total_amount"><label for="loss_deviation"><small>Total Amount</small></label></div>
					         <div class="rowlabel"><input type="text" id="total_amount" name="total_amount" value=""/></div>
				        </div>
		           </div>
		</fieldset>
		 <fieldset>
		    <legend>Amounts debited to the profit and loss account, to the extent disallowable u/s 36</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="premiumpaid_damage"><small>Premium paid for insurance against risk of damage or destruction of stocks or store</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="premiumpaid_damage" name="premiumpaid_damage" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="premiumpaid_health"><small>Premium paid for insurance on the health of employees</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="premiumpaid_health" name="premiumpaid_health" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="sumpaid_bonus"><small>Any sum paid to an employee as bonus or commission for services rendered, where such sum was otherwise payable to him as profits or dividend</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="sumpaid_bonus" name="sumpaid_bonus" value=""/></div>
					   </div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="interest_borrowed"><small>Any amount of interest paid in respect of borrowed capital</small></label></div>
					         <div class="rowlabel"><input type="text" id="interest_borrowed" name="interest_borrowed" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="discount_zerocoupon"><small>Amount of discount on a zero-coupon bond</small></label></div>
					         <div class="rowlabel"><input type="text" id="discount_zerocoupon" name="discount_zerocoupon" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="contributions_provident"><small>Amount of contributions to a recognised provident fund</small></label></div>
					         <div class="rowlabel"><input type="text" id="contributions_provident" name="contributions_provident" value=""/></div>
				        </div>
		           </div>
		           <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="contributions_superannuation"><small>Amount of contributions to an approved superannuation fund</small></label></div>
					         <div class="rowlabel"><input type="text" id="contributions_superannuation" name="contributions_superannuation" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="contributions_gratuity"><small>Amount of contributions to an approved gratuity</small></label></div>
					         <div class="rowlabel"><input type="text" id="contributions_gratuity" name="contributions_gratuity" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="contributions_other"><small>Amount of contributions to any other fund</small></label></div>
					         <div class="rowlabel"><input type="text" id="contributions_other" name="contributions_other" value=""/></div>
				        </div>
		           </div>
		           <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="amount_debts"><small>Amount of bad and doubtful debts</small></label></div>
					         <div class="rowlabel"><input type="text" id="amount_debts" name="amount_debts" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="provision_debts"><small>Provision for bad and doubtful debts</small></label></div>
					         <div class="rowlabel"><input type="text" id="provision_debts" name="provision_debts" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="amount_transferred"><small>Amount transferred to any special reserve</small></label></div>
					         <div class="rowlabel"><input type="text" id="amount_transferred" name="amount_transferred" value=""/></div>
				        </div>
		           </div>
		            <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="expenditure_promoting"><small>Expenditure for the purposes of promoting family planning amongst employees</small></label></div>
					         <div class="rowlabel"><input type="text" id="expenditure_promoting" name="expenditure_promoting" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="sum_received"><small>Any sum received from employees as contribution to any provident fund or superannuation fund or any fund set up under ESI Act or any other fund for the welfare of employees to the extent credited to the employees account on or before the due date</small></label></div>
					         <div class="rowlabel"><input type="text" id="sum_received" name="sum_received" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="other_disallowance"><small>Any other disallowance</small></label></div>
					         <div class="rowlabel"><input type="text" id="other_disallowance" name="other_disallowance" value=""/></div>
				        </div>
		           </div>
		           <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="totalamount_disallowable"><small>Total amount disallowable under section 36</small></label></div>
					        <div class="rowlabel"><input type="text" id="totalamount_disallowable" name="totalamount_disallowable" value=""/></div>
				        </div>
		           </div>
		</fieldset>
		<fieldset>
		    <legend>Amounts debited to the profit and loss account, to the extent disallowable under section 37</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="expenditure_personal"><small>Expenditure of personal nature</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="expenditure_personal" name="expenditure_personal" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="expenditure_advertisement"><small>Expenditure on advertisement in any souvenir, brochure, tract, pamphlet or the like, published by a political party</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="expenditure_advertisement" name="expenditure_advertisement" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="expenditure_penalty"><small>Expenditure by way of penalty or fine for violation of any law for the time being in force</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="expenditure_penalty" name="expenditure_penalty" value=""/></div>
					   </div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="other_penalty"><small>Any other penalty or fine</small></label></div>
					         <div class="rowlabel"><input type="text" id="other_penalty" name="other_penalty" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="expenditure_incurred"><small>Expenditure incurred for any purpose which is an offence or which is prohibited by law</small></label></div>
					         <div class="rowlabel"><input type="text" id="expenditure_incurred" name="expenditure_incurred" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="amount_liability"><small>Amount of any liability of a contingent nature</small></label></div>
					         <div class="rowlabel"><input type="text" id="amount_liability" name="amount_liability" value=""/></div>
				        </div>
		           </div>
		           <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="amount_expenditure"><small>Amount of expenditure in relation to income which does not form part of total income</small></label></div>
					         <div class="rowlabel"><input type="text" id="amount_expenditure" name="amount_expenditure" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="other_amountus37"><small>Any other amount not allowable under section 37</small></label></div>
					         <div class="rowlabel"><input type="text" id="other_amountus37" name="other_amountus37" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="totalamount_disallowableus37"><small>Total amount disallowable under section 37</small></label></div>
					         <div class="rowlabel"><input type="text" id="totalamount_disallowableus37" name="totalamount_disallowableus37" value=""/></div>
				        </div>
		           </div>
		</fieldset>
		<fieldset>
		    <legend>Amounts debited to the profit and loss account, to the extent disallowable under section 40</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="amountdisallowable_us40A"><small>Amount disallowable under section 40 (a)(i), 40(a)(ia) and 40(a)(iii) on account of non-compliance with the provisions of Chapter XVII-B</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="amountdisallowable_us40A" name="amountdisallowable_us40A" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="amount_ratelevied"><small>Amount of tax or rate levied or assessed on the basis of profits</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="amount_ratelevied" name="amount_ratelevied" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="amount_wealthtax"><small>Amount paid as wealth tax</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="amount_wealthtax" name="amount_wealthtax" value=""/></div>
					   </div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="amount_commission"><small>Amount of interest, salary, bonus, commission or remuneration paid to any partner or member</small></label></div>
					         <div class="rowlabel"><input type="text" id="amount_commission" name="amount_commission" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="other_disallowance"><small>Any other disallowance</small></label></div>
					         <div class="rowlabel"><input type="text" id="other_disallowance" name="other_disallowance" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="amount_disallowanceus40"><small>Total amount disallowable under section 40</small></label></div>
					         <div class="rowlabel"><input type="text" id="amount_disallowanceus40" name="amount_disallowanceus40" value=""/></div>
				        </div>
		           </div>
		</fieldset>
		<fieldset>
		    <legend>Any amount disallowed under section 40 in any preceding previous year but allowable during the previous year</legend>
			        <div class="row-fluid show-grid">
						<div class="span6">
							<div class="rowlabel">
								<label for ="amountdisallowable_us40B"><small>Any amount disallowed under section 40 in any preceding previous year but allowable during the previous year</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="amountdisallowable_us40B" name="amountdisallowable_us40B" value=""/></div>
					   </div>
				  </div>
		</fieldset>
		<fieldset>
		    <legend>Amounts debited to the profit and loss account, to the extent disallowable under section 40A</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="amount_persons"><small>Amounts paid to persons specified in section 40A(2)(b)</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="amount_persons" name="amount_persons" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="amount_excesstwth"><small>Amount in excess of twenty thousand rupees paid to a person in a day otherwise than by account payee cheque or account payee bank draft under section 40A(3) - 100% disallowable</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="amount_excesstwth" name="amount_excesstwth" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="provision_gratuity"><small>Provision for payment of gratuity</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="provision_gratuity" name="provision_gratuity" value=""/></div>
					   </div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="sumpaid_assessee"><small>Any sum paid by the assessee as an employer for setting up or as contribution to any fund, trust, company, AOP, or BOI or society or any other institution</small></label></div>
					         <div class="rowlabel"><input type="text" id="sumpaid_assessee" name="sumpaid_assessee" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="anyother_disallowance"><small>Any other disallowance</small></label></div>
					         <div class="rowlabel"><input type="text" id="anyother_disallowance" name="anyother_disallowance" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="totalamount_disallowanceus40"><small>Total amount disallowable under section 40A</small></label></div>
					         <div class="rowlabel"><input type="text" id="totalamount_disallowanceus40" name="totalamount_disallowanceus40" value=""/></div>
				        </div>
		           </div>
		</fieldset>
		<fieldset>
		    <legend>Any amount disallowed under section 43B in any preceding previous year but allowable during the previous year</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="sum_naturetax"><small>Any sum in the nature of tax, duty, cess or fee under any law</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="sum_naturetax" name="sum_naturetax" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="sumpayable_provident"><small>Any sum payable by way of contribution to any provident fund or superannuation fund or gratuity fund or any other fund for the welfare of employees</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="sumpayable_provident" name="sumpayable_provident" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="sumpayable_employee"><small>Any sum payable to an employee as bonus or commission for services rendered</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="sumpayable_employee" name="sumpayable_employee" value=""/></div>
					   </div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="sumpayable_institution"><small>Any sum payable as interest on any loan or borrowing from any public financial institution or a State financial corporation or a State Industrial investment corporation</small></label></div>
					         <div class="rowlabel"><input type="text" id="sumpayable_institution" name="sumpayable_institution" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="sumpayable_bank"><small>Any sum payable as interest on any loan or borrowing from any scheduled bank</small></label></div>
					         <div class="rowlabel"><input type="text" id="sumpayable_bank" name="sumpayable_bank" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="sumpayable_encashment"><small>Any sum payable towards leave encashment</small></label></div>
					         <div class="rowlabel"><input type="text" id="sumpayable_encashment" name="sumpayable_encashment" value=""/></div>
				        </div>
		           </div>
		            <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="totalamount_us43"><small>Total amount allowable under section 43B</small></label></div>
					         <div class="rowlabel"><input type="text" id="totalamount_us43" name="totalamount_us43" value=""/></div>
				        </div>
		           </div>
		</fieldset>
		<fieldset>
		    <legend>Any amount debited to profit and loss account of the previous year but disallowable under section 43B</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="sum_naturetax43b"><small>Any sum in the nature of tax, duty, cess or fee under any law</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="sum_naturetax43b" name="sum_naturetax43b" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="sumpayable_provident43b"><small>Any sum payable by way of contribution to any provident fund or superannuation fund or gratuity fund or any other fund for the welfare of employees</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="sumpayable_provident43b" name="sumpayable_provident43b" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="sumpayable_employee43b"><small>Any sum payable to an employee as bonus or commission for services rendered</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="sumpayable_employee43b" name="sumpayable_employee43b" value=""/></div>
					   </div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="sumpayable_institution43b"><small>Any sum payable as interest on any loan or borrowing from any public financial institution or a State financial corporation or a State Industrial investment corporation</small></label></div>
					         <div class="rowlabel"><input type="text" id="sumpayable_institution43b" name="sumpayable_institution43b" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="sumpayable_bank43b"><small>Any sum payable as interest on any loan or borrowing from any scheduled bank</small></label></div>
					         <div class="rowlabel"><input type="text" id="sumpayable_bank43b" name="sumpayable_bank43b" value=""/></div>
				        </div>
				        <div class="span4">
					         <div class="rowlabel"><label for="sumpayable_encashment43b"><small>Any sum payable towards leave encashment</small></label></div>
					         <div class="rowlabel"><input type="text" id="sumpayable_encashment43b" name="sumpayable_encashment43b" value=""/></div>
				        </div>
		           </div>
		            <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="totalamount_us43b"><small>Total amount allowable under section 43B</small></label></div>
					         <div class="rowlabel"><input type="text" id="totalamount_us43b" name="totalamount_us43b" value=""/></div>
				        </div>
		           </div>
		</fieldset>
		<fieldset>
		    <legend>Amount of credit outstanding in the accounts in respect of</legend>
			        <div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for ="union_excise"><small>Union Excise Duty</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="union_excise" name="union_excise" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="service_tax"><small>Service tax</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="service_tax" name="service_tax" value=""/></div>
					   </div>
					   <div class="span4">
							<div class="rowlabel">
								<label for ="vat_tax"><small>VAT/sales tax</small></label>
							</div>
							<div class="rowlabel"><input type="text" id="vat_tax" name="vat_tax" value=""/></div>
					   </div>
				   </div>
			       <div class="row-fluid show-grid">
						<div class="span4">
					        <div class="rowlabel"><label for="other_tax"><small>Any other tax</small></label></div>
					         <div class="rowlabel"><input type="text" id="other_tax" name="other_tax" value=""/></div>
				        </div>
				        <div class="span4">
					        <div class="rowlabel"><label for="totalamount_outstanding"><small>Total amount outstanding</small></label></div>
					         <div class="rowlabel"><input type="text" id="totalamount_outstanding" name="totalamount_outstanding" value=""/></div>
				        </div>
				   </div>
		</fieldset>
		<table>
		      <tr>
		          <td>
			          <div class="rowlabel">
				          <label for ="amount_deemed"><small>Amounts deemed to be profits and gains under section 33AB or 33ABA or 33AC</small></label>
			          </div>
			     </td>
			     <td>
			         <div class="rowlabel"><input type="text" id="amount_deemed" name="amount_deemed" value=""/></div>
		         </td>
		    </tr>
		    <tr>
		        <td>
			        <div class="rowlabel">
				        <label for ="amount_profit"><small>Any amount of profit chargeable to tax under section 41</small></label>
			       </div>
			   </td>
			   <td>
	               <div class="rowlabel"><input type="text" id="amount_profit" name="amount_profit" value=""/></div>
	           </td>
	      </tr>
	      <tr>
	          <td>
			      <div class="rowlabel">
			          <label for ="amount_income"><small>Amount of income or expenditure of prior period credited or debited to the profit and loss account (net)</small></label>
			     </div>
			 </td>
			 <td>
		         <div class="rowlabel"><input type="text" id="amount_income" name="amount_income" value=""/></div>
		     </td>
		 </tr>
  </table>
  </form>
</div>