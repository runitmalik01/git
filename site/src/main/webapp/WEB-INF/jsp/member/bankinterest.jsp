<script type="text/javascript">
	function tot(elem) {
		var d = document.getElementById("total").value;
		var total = Number(d);
	}
	var total = 0;

	function getValues() {
		var bankName = 0;
		var unit = 0;
		var obj = document.getElementsByTagName("input");

		for ( var i = 0; i < obj.length; i++) {

			if (obj[i].name == "bankAmount[]") {
				total += (obj[i].value * 1);
			}
		}
		document.getElementById("total").value = (total * 1).toFixed(2);
		total = 0;
	}
</script>

<script>
	function addRow(tableID) {
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);
		var colCount = table.rows[0].cells.length;
		for ( var i = 0; i < colCount; i++) {
			var newcell = row.insertCell(i);
			newcell.innerHTML = table.rows[0].cells[i].innerHTML;
			//alert(newcell.childNodes);
			switch (newcell.childNodes[0].type) {
			case "text":
				newcell.childNodes[0].value = "";
				break;
			case "checkbox":
				newcell.childNodes[0].checked = false;
				break;
			}
		}
	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			for ( var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					if (rowCount <= 1) {
						alert("Cannot delete all the rows.");
						break;
					}
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		} catch (e) {
			alert(e);
		}
		getValues();
	}
	
	function post_value(){
		opener.document.f1.Bank_detail.value = document.form1.total.value;
		alert("values are"+document.form1.total.value);
		self.close();
		}
</script>
<form id="form1" name="form1" method="post" action="">
	<table width="400" border="1">
		<tr>
			<td colspan="3" align="center"><h1>Bank Interest Details:</h1></td>
		</tr>
		<tr align="center">

			<td colspan="3"><INPUT type="button" value="Add Row"
				onclick="addRow('dataTable')" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT
				type="button" value="Delete Row" onclick="deleteRow('dataTable')" />
			</td>

		</tr>
		<tr align="center">
			<td width="21">&nbsp;</td>
			<td width="200"><h3>Bank Name</h3></td>
			<td width="100"><h3>Amount</h3></td>
		</tr>
	</table>

	<div>
		<table width="400" border="1" class="bankTableClass" id="dataTable">
			<tr>
				<td width="24" valign="top"><input name="chk[]" type="checkbox" />
				</td>

				<td width="300"><input type="text" name="bankName[]"
					id="bankName" size="35" /></td>
				<td width="100"><input type="text" name="bankAmount[]"
					id="bankAmount" onkeyup="getValues()" size="15" /></td>
			</tr>
		</table>
	</div>
	<div>
		<table width="400" border="0">
			<tr>
				<td width="200" colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td width="230" colspan="2" align="right"><b>Total:</b></td>
				<td width="100" align="center"><input type="text" name="total"
					id="total" value="" /></td>
				<td width="100" align="center"><input type="submit"
					name="total" id="total" value="submit" onclick="post_value();" /></td>
			</tr>
		</table>
	</div>
</form>