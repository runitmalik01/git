
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<fieldset>
		<legend class="header-color"><small>
			Income From Owning and Maintaining Race Horses</small>
		</legend>
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="Receipts ">Receipts</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Receipts" maxlength="14" class=" decimal"
					value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.receipts}"/>" id="Receipts"/>
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="dedus57 ">Deduction under section 57</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="dedus57" maxlength="14"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dedus57}"/>" class=" decimal"
						id="dedus57" onchange="cal3()" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
			<label for="balance">Balance</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="balance" maxlength="14" readonly="readonly"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.balance}"/>" class=" decimal"
						id="balance" onchange="cal3()" />
				</div>
			</div>
		</div>
	</fieldset>
    <fieldset>
		<legend class="header-color">
			<small>Winnings from lotteries, crossword puzzles, races, games, gambling, betting etc</small>
		</legend>
		<div class="row show-grid">
	        <div class="col-md-8">
				<div class="rowlabel">
			<label for="LotteryOrhorse_income">Winnings from lotteries, crossword puzzles, races, games, gambling, betting etc</label>
				</div></div>
				  <div class="col-md-4">
				<div class="rowlabel">
					<input type="text" name="LotteryOrhorse_income" id="LotteryOrhorse_income"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.lotteryOrhorse_income}"/>" maxlength="14"
						class=" decimal"  />
				</div>
			</div>
			</div>
	</fieldset>

