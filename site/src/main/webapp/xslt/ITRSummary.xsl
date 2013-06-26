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
		<h4>Personal Information</h4>
		<table width="100%" border="1">
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
				<td>

					<xsl:value-of select="t:Address/t:ResidenceNo" />
					<xsl:value-of select="t:Address/t:RoadOrStreet" />
					<br />
					<xsl:value-of select="t:Address/t:LocalityOrArea" />
					<xsl:value-of select="t:Address/t:CityOrTownOrDistrict" />
					<br />
					<xsl:value-of select="t:Address/t:PinCode" />
				</td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td>
					<xsl:value-of select="t:Address/t:MobileNo" />
				</td>
			</tr>
			<tr>
				<td>EmailAddress</td>
				<td>
					<xsl:value-of select="t:Address/t:EmailAddress" />
				</td>
			</tr>
		</table>
	</xsl:template>

	<xsl:template match="t:ITR1_IncomeDeductions">
		<h4>Income Information</h4>
		<table width="100%" border="1">
			<tr>
				<td>Income from Salary</td>
				<td>
					<xsl:value-of select="t:IncomeFromSal" />
				</td>
			</tr>
			<tr>
				<td>Income from House Property</td>
				<td>
					<xsl:value-of select="t:TotalIncomeOfHP" />
				</td>
			</tr>
			<tr>
				<td>Income from Other Sources</td>
				<td>
					<xsl:value-of select="t:IncomeOthSrc" />
				</td>
			</tr>
			<tr>
				<td>Total Income</td>
				<td>
					<xsl:value-of select="t:GrossTotIncome" />
				</td>
			</tr>
			<tr>
				<td>Section 89</td>
				<td>
					<xsl:value-of select="t:Section89" />
				</td>
			</tr>
		</table>
		<br />
		<xsl:apply-templates select="t:DeductUndChapVIA" />
	</xsl:template>

	<xsl:template match="t:ITR1_TaxComputation">
		<h4>Tax Information</h4>
		<table width="100%" border="1">
			<tr>
				<td>TotalTaxPayable</td>
				<td>
					<xsl:value-of select="t:TotalTaxPayable" />
				</td>
			</tr>
			<tr>
				<td>SurchargeOnTaxPayable</td>
				<td>
					<xsl:value-of select="t:SurchargeOnTaxPayable" />
				</td>
			</tr>
			<tr>
				<td>EducationCess</td>
				<td>
					<xsl:value-of select="t:EducationCess" />
				</td>
			</tr>
			<tr>
				<td>GrossTaxLiability</td>
				<td>
					<xsl:value-of select="t:GrossTaxLiability" />
				</td>
			</tr>
		</table>
	</xsl:template>


	<!-- this is a common template called by apply-templates -->
	<xsl:template match="t:FilingStatus">
		<h4>Filing status</h4>
		<table width="100%" border="1">
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
		<h4>Deductions under Chapter VI</h4>

		<table width="100%" border="1">
			<tr>
				<td>Section</td>
				<td>Total</td>
				<td>Eligible</td>
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
					<td>
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