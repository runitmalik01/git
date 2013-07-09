<?xml version="1.0" encoding="UTF-8" standalone="yes"?>

<xsl:stylesheet version="1.0"

	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	ns7:schemaLocation="http://incometaxindiaefiling.gov.in/main ITRMain13.xsd" 
	xmlns:ITR1FORM="http://incometaxindiaefiling.gov.in/ITR1" 
	xmlns:ITR2FORM="http://incometaxindiaefiling.gov.in/ITR2" 
	xmlns:ITRETURN="http://incometaxindiaefiling.gov.in/main" 
	xmlns:ITRForm="http://incometaxindiaefiling.gov.in/master" 
	xmlns:ITR3FORM="http://incometaxindiaefiling.gov.in/ITR3" 
	xmlns:ns5="http://incometaxindiaefiling.gov.in/ITR4S" 
	xmlns:ns7="http://www.w3.org/2001/XMLSchema-instance"
	exclude-result-prefixes="ITR1FORM ITR2FORM ITRETURN ITRForm ITR3FORM ns5 ns7">

	<xsl:output method="xml"></xsl:output>
	<xsl:template match="/ITRETURN:ITR">
		<html>
			<body>
				<img width="226px" height="49px"
					src="http://localhosITRForm:8080/site/binaries/content/gallery/logos/w4ilogo.png"></img>
				<h1>
					<xsl:value-of select="//ITRForm:FormName" />
				</h1>
				<h2>
					<xsl:value-of select="//ITRForm:Description" />
				</h2>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
        <xsl:template match="ITR1FORM:ITR1">
             <xsl:apply-templates />
       </xsl:template>

	<xsl:template match="ITRForm:PersonalInfo">
		Assessment Year:-
		<span style="color:#ff0000">
			<xsl:value-of select="//ITRForm:AssessmentYear" />
		</span>
		<br />
		Employee Category:-
		<span style="color:#ff0000">
			<xsl:value-of select="ITRForm:EmployerCategory" />
		</span>
		<br />

		Assessee Name:-
		<span style="color:#ff0000">
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="ITRForm:AssesseeName" />
		</span>
		<br />
		PAN:-
		<span style="color:#ff0000">
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="ITRForm:PAN" />
		</span>
		<br />
		Address:-
		<span style="color:#ff0000">
			<xsl:value-of select="ITRForm:Address/ITRForm:ResidenceNo" />
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="ITRForm:Address/ITRForm:RoadOrStreet" />
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="ITRForm:Address/ITRForm:LocalityOrArea" />
			<xsl:text> &#x9;</xsl:text>
			<xsl:value-of select="ITRForm:Address/ITRForm:CityOrTownOrDistrict" />
			<xsl:text> &#x9;</xsl:text>
			<xsl:value-of select="ITRForm:Address/ITRForm:PinCode" />
		</span>
		<br />
		Mobile:-
		<span style="color:#ff0000">
		<xsl:text> &#10;</xsl:text>
			<xsl:value-of select="ITRForm:Address/ITRForm:MobileNo" />
		</span>
		<br />

		DOB:-
		<span style="color:#ff0000">
		<xsl:text> &#10;</xsl:text>
			<xsl:value-of select="ITRForm:DOB" />
		</span>
		<br />
		Gender:-
		<span style="color:#ff0000">

			<xsl:value-of select="ITRForm:Gender" />
		</span>
		<br />

		Email Address:-
		<span style="color:#ff0000">
			<xsl:value-of select="ITRForm:Address/ITRForm:EmailAddress" />
		</span>
		<br />
	</xsl:template>
	<xsl:template match="ITRForm:ITR1_IncomeDeductions">
		<table width="100%" border="1" class="odd"
			style="background-color: #d5e9d7;">
			<tr>
				<th colspan="3">Income Information</th>
			</tr>
			<tr>
				<td>A</td>
				<td>Income from Salary</td>
				<td align="right">
					<xsl:value-of select="ITRForm:IncomeFromSal" />
				</td>
			</tr>
			<tr>
				<td>B</td>
				<td>Income from House Property</td>
				<td align="right">
					<xsl:value-of select="ITRForm:TotalIncomeOfHP" />
				</td>
			</tr>
			<tr>
				<td>C</td>
				<td>Income from Other Sources</td>
				<td align="right">
					<xsl:value-of select="ITRForm:IncomeOthSrc" />
				</td>
			</tr>
			<tr>
				<td>D</td>
				<td> Gross Total Income</td>
				<td align="right">
					<xsl:value-of select="ITRForm:GrossTotIncome" />
				</td>
			</tr>
			<tr>
				<td>E</td>
				<td>Section 89</td>
				<td align="right">
					<xsl:value-of select="ITRForm:itr1TaxComputation/ITRForm:Section89" />
				</td>
			</tr>
			<tr>
				<td>F</td>
				<td>Taxable Income</td>
				<td align="right">
					<xsl:value-of select="ITRForm:TotalIncome" />
				</td>
			</tr>
		</table>
		<xsl:apply-templates select="ITRForm:DeductUndChapVIA" />
	</xsl:template>
	<xsl:template match="ITRForm:ITR1_TaxComputation">
		<table width="100%" border="1" class="odd"
			style="background-color: #d5e9d7;">
			<tr>
				<th colspan="2">Tax Information</th>
			</tr>
			<tr>
				<td>TotalTaxPayable</td>
				<td align="right">
					<xsl:value-of select="ITRForm:TotalTaxPayable" />
				</td>
			</tr>
			<tr>
				<td>EducationCess</td>
				<td align="right">
					<xsl:value-of select="ITRForm:EducationCess" />
				</td>
			</tr>
			<tr>
				<td>GrossTaxLiability</td>
				<td align="right">
					<xsl:value-of select="ITRForm:GrossTaxLiability" />
				</td>
			</tr>
			<tr>
				<td>Total Interest Pay</td>
				<td align="right">
					<xsl:value-of select="ITRForm:TotalIntrstPay" />
				</td>
			</tr>
			<tr>
				<td>Total Tax and Interest Pay</td>
				<td align="right">
					<xsl:value-of select="ITRForm:TotTaxPlusIntrstPay" />
				</td>
			</tr>
		</table>
	</xsl:template>
	<!-- this is a common template called by apply-templates -->
	<xsl:template match="ITRForm:FilingStatus">
		<xsl:for-each select="./*">
				<xsl:variable name="myName" select="name(.)" />
				<xsl:value-of select="name(.)" />:-
			<span style="color:#ff0000">
				<xsl:value-of select="." />
			</span>
			<br />

		</xsl:for-each>

	</xsl:template>
	<xsl:template match="ITRForm:DeductUndChapVIA">

		<table width="100%" border="1" class="odd"
			style="background-color: #d5e9d7;">
			<tr>
				<th colspan="3">Deductions under Chapter VI</th>
			</tr>
			<tr>
				<th>Section</th>
				<th align="right">Eligible</th>
				<th align="right">Total</th>
			</tr>
			<xsl:for-each select="./*">
				<tr>
					<xsl:variable name="myName" select="name(.)" />
					<td>
						<xsl:value-of select="name(.)" />
					</td>
					<td align="right">
						<xsl:value-of select="." />
					</td>
					<td align="right">
						<xsl:value-of select="../../ITRForm:UsrDeductUndChapVIA/*[name()=$myName]" />
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>

	<xsl:template match="ITRForm:Verification">

	</xsl:template>

	<xsl:template match="ITRForm:* | xsi:* | *">

	</xsl:template>



</xsl:stylesheet>