
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<fieldset>
		<legend>
			Income From Owning and Maintaining Race Horses
		</legend>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="Receipts ">Receipts</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Receipts" maxlength="14" class=" decimal"
					value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.receipts}"/>" id="Receipts"/>
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="dedus57 ">Deduction under section 57</label>                   
				</div>
				<div class="rowlabel">
					<input type="text" name="dedus57" maxlength="14"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dedus57}"/>" class=" decimal"
						id="dedus57" onchange="cal3()" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">               
			<label for="balance">Balance</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="balance" maxlength="14"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.balance}"/>" class=" decimal"
						id="balance" onchange="cal3()" />
				</div>
			</div>
		</div>
	</fieldset>
    <fieldset>
		<legend>
			Winnings from lotteries, crossword puzzles, races, games, gambling, betting etc
		</legend>
	        <div class="span5">
				<div class="rowlabel">
			<label for="LotteryOrhorse_income">Winnings from lotteries, crossword puzzles, races, games, gambling, betting etc</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="LotteryOrhorse_income" id="LotteryOrhorse_income"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.lotteryOrhorse_income}"/>" maxlength="14"
						class=""  />
				</div>
			</div>
	</fieldset>
	<fieldset>

	