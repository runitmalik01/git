<?xml version="1.0" encoding="UTF-8" standalone="yes"?>

<xsl:stylesheet version="1.0"

	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:ns2="http://incometaxindiaefiling.gov.in/ITR1" xmlns:t="http://incometaxindiaefiling.gov.in/master"
	exclude-result-prefixes="t ns2">

	<xsl:output method="xml"></xsl:output>
	<xsl:template match="/ns2:ITR1">
		<html>
			<body>
				<img width="226px" height="49px"
					src="http://localhost:8080/site/binaries/content/gallery/logos/w4ilogo.png"></img>
				<h1>
					<xsl:value-of select="//t:FormName" />	
				</h1>
				<h2>
					<xsl:value-of select="//t:Description" />
				</h2>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>


	<xsl:template match="t:PersonalInfo">
		<table width="100%" border="1" class="odd"
			style="background-color: #d5e9d7;">
			<tr>
				<th colspan="2">Personal Information</th>
			</tr>
			<tr>
				<td>Assessment Year</td>
				<td>
					<xsl:value-of select="//t:AssessmentYear" />
				</td>
			</tr>
			<tr>
				<td>Employee Category</td>
				<td>
					<xsl:value-of select="t:EmployerCategory" />
				</td>
			</tr>
			<tr>
				<td>Assessee Name</td>
				<td>
					<xsl:value-of select="t:AssesseeName" />
				</td>
			</tr>
			<tr>
				<td>PAN</td>
				<td>

					<xsl:value-of select="t:PAN" />
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td >
					<xsl:value-of select="t:Address/t:ResidenceNo" />
					<xsl:text></xsl:text>
					<xsl:value-of select="t:Address/t:RoadOrStreet" />
					<xsl:text></xsl:text>
					<xsl:value-of select="t:Address/t:LocalityOrArea" />
					<xsl:text> </xsl:text>
					<xsl:value-of select="t:Address/t:CityOrTownOrDistrict" />
					<br />
					<xsl:value-of select="t:Address/t:PinCode" />
				</td>
			</tr>
			<tr>
				<td >Mobile</td>
				<td>
					<xsl:value-of select="t:Address/t:MobileNo" />
				</td>
			</tr>

			<tr>
				<td>DOB</td>
				<td>
					<xsl:value-of select="t:DOB" />
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<xsl:value-of select="t:Gender" />
				</td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td>
					<xsl:value-of select="t:Address/t:EmailAddress" />
				</td>
			</tr>
		</table>
	</xsl:template>
	<xsl:template match="t:ITR1_IncomeDeductions">
		<table width="100%" border="1" class="odd"
			style="background-color: #d5e9d7;">
			<tr>
				<th colspan="3">Income Information</th>
			</tr>
			<tr>
				<td>A</td>
				<td>Income from Salary</td>
				<td align="right">
					<xsl:value-of select="t:IncomeFromSal" />
				</td>
			</tr>
			<tr>
				<td>B</td>
				<td>Income from House Property</td>
				<td align="right">
					<xsl:value-of select="t:TotalIncomeOfHP" />
				</td>
			</tr>
			<tr>
				<td>C</td>
				<td>Income from Other Sources</td>
				<td align="right">
					<xsl:value-of select="t:IncomeOthSrc" />
				</td>
			</tr>
			<tr>
				<td>D</td>
				<td> Gross Total Income</td>
				<td align="right">
					<xsl:value-of select="t:GrossTotIncome" />
				</td>
			</tr>
			<tr>
				<td>E</td>
				<td>Section 89</td>
				<td align="right">
					<xsl:value-of select="t:Section89" />
				</td>
			</tr>
			<tr>
				<td>F</td>
				<td>Taxable Income</td>
				<td align="right">
					<xsl:value-of select="t:TotalIncome" />
				</td>
			</tr>
		</table>
		<xsl:apply-templates select="t:DeductUndChapVIA" />
	</xsl:template>
	<xsl:template match="t:ITR1_TaxComputation">
		<table width="100%" border="1" class="odd"
			style="background-color: #d5e9d7;">
			<tr>
				<th colspan="2">Tax Information</th>
			</tr>
			<tr>
				<td>TotalTaxPayable</td>
				<td align="right">
					<xsl:value-of select="t:TotalTaxPayable" />
				</td>
			</tr>
			<tr>
				<td>SurchargeOnTaxPayable</td>
				<td align="right">
					<xsl:value-of select="t:SurchargeOnTaxPayable" />
				</td>
			</tr>
			<tr>
				<td>EducationCess</td>
				<td align="right">
					<xsl:value-of select="t:EducationCess" />
				</td>
			</tr>
			<tr>
				<td>GrossTaxLiability</td>
				<td align="right">
					<xsl:value-of select="t:GrossTaxLiability" />
				</td>
			</tr>
			<tr>
				<td>Total Interest Pay</td>
				<td align="right">
					<xsl:value-of select="t:TotalIntrstPay" />
				</td>
			</tr>
			<tr>
				<td>Total Tax and Interest Pay</td>
				<td align="right">
					<xsl:value-of select="t:TotTaxPlusIntrstPay" />
				</td>
			</tr>
			<tr>
				<td>Total Taxes Paid</td>
				<td align="right">
					<xsl:value-of select="t:TotalTaxesPaid" />
				</td>
			</tr>
			<tr>
				<td>Advance Tax</td>
				<td align="right">
					<xsl:value-of select="t:AdvanceTax" />
				</td>
			</tr>
			<tr>
				<td>Self Assessment Tax</td>
				bigTotalTdsOther
				<td align="right">
					<xsl:value-of select="t:SelfAssessmentTax" />
				</td>
			</tr>
		</table>
	</xsl:template>


	<!-- this is a common template called by apply-templates -->
	<xsl:template match="t:FilingStatus">
		<table width="100%" border="1" class="odd"
			style="background-color: #d5e9d7;">
			<tr>
				<th colspan="2">Filing status</th>
			</tr>
			<xsl:for-each select="./*">
				<tr>
					<xsl:variable name="myName" select="name(.)" />
					<td>
						<xsl:value-of select="name(.)" />
					</td>
					<td>
						<xsl:value-of select="." />
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
	<xsl:template match="t:DeductUndChapVIA">

		<table width="100%" border="1" class="odd" style="background-color: #d5e9d7;">
			<tr >
				<th colspan="3">Deductions under Chapter VI</th>
			</tr>
			<tr>
				<th>Section</th>
				<th align="right">Total</th>
				<th align="right">Eligible</th>
			</tr>
			<xsl:for-each select="./*">
				<tr >
					<xsl:variable name="myName" select="name(.)" />
					<td>
						<xsl:value-of select="name(.)" />
					</td>
					<td align="right">
						<xsl:value-of select="." />
					</td>
					<td align="right">
						<xsl:value-of select="../../t:UsrDeductUndChapVIA/*[name()=$myName]" />
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>

	<xsl:template match="t:Verification">

	</xsl:template>

	<xsl:template match="t:* | xsi:* | *">

	</xsl:template>



</xsl:stylesheet>