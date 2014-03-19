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
	xmlns:ITR4FORM="http://incometaxindiaefiling.gov.in/ITR4"
	exclude-result-prefixes="ITR1FORM ITR2FORM ITRETURN ITRForm ITR4FORM ITR3FORM ns5 ns7">

	<xsl:output method="xml"></xsl:output>
	<xsl:param name="showLogo"></xsl:param>
	<xsl:param name="country"></xsl:param>
	<xsl:param name="displayAssessmentYear"></xsl:param>
	<xsl:template match="/ITRETURN:ITR">
		<html>
			<head>			
				<style type="text/css">
					#c6, #taxi, #taxc {
						font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
						font-size: 12px;
						background: #fff;
						width: 100%;
						border-collapse: collapse;
						text-align: left;					
					}				
					#c6 th, #taxi th, #taxc th {
						font-size: 14px;
						font-weight: normal;
						color: #039;
						border-bottom: 2px solid #6678b1;
						padding: 10px 8px;
					}					
					
					#c6 td, #taxi td, #taxc td {
						border-bottom: 1px solid #ccc;
						color: #669;
						padding: 6px 8px;
					}			
				</style>
			</head>
			<body>
				<xsl:if test="$showLogo = 'true'">
					<img width="226px" height="49px" src="http://localhosITRForm:8080/site/binaries/content/gallery/logos/w4ilogo.png"></img>
				</xsl:if>
				<span style="font-size:20.0pt;line-height:115%;font-family:Algerian">COMPUTATION OF TOTAL INCOME &amp; TAX THEREON</span>
				<!--
				<h1>
					<xsl:value-of select="//ITRForm:FormName" />
				</h1>
				<h2>
					<xsl:value-of select="//ITRForm:Description" />
				</h2>
				  -->
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
	
    <xsl:template match="ITR1FORM:ITR1 | ITR2FORM:ITR2 | ns5:ITR4S | ITR3FORM:ITR3 | ITR4FORM:ITR4">
             <xsl:apply-templates />
    </xsl:template>

	<xsl:template match="ITRForm:PersonalInfo">
	
	<table class="MsoTableLightShading" border="1" cellspacing="0" cellpadding="0" style="border-collapse:collapse;border:none;mso-border-top-alt:solid black 1.0pt;
	   mso-border-top-themecolor:text1;mso-border-bottom-alt:solid black 1.0pt;
	   mso-border-bottom-themecolor:text1;mso-yfti-tbllook:1184;mso-padding-alt:0in 5.4pt 0in 5.4pt">
	   <tbody>
	      <tr style="mso-yfti-irow:-1;mso-yfti-firstrow:yes;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border-top:solid black 1.0pt;
	            mso-border-top-themecolor:text1;border-left:none;border-bottom:solid black 1.0pt;
	            mso-border-bottom-themecolor:text1;border-right:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:5"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Name of the
	               Assessee<span style="mso-spacerun:yes"></span></span></b>
	            </p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border-top:solid black 1.0pt;
	            mso-border-top-themecolor:text1;border-left:none;border-bottom:solid black 1.0pt;
	            mso-border-bottom-themecolor:text1;border-right:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:1"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"><xsl:value-of select="ITRForm:AssesseeName" /></span></b></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:0;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:68"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Father’s Name</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:64"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"><xsl:value-of select="//ITRForm:FatherName" /></span></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:1;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:4"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Date of Birth</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"><xsl:value-of select="//ITRForm:DOB" /> </span></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:2;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:68"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Address</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:64"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">
	               <xsl:if test="//ITRForm:Address/ITRForm:ResidenceNo and normalize-space(//ITRForm:Address/ITRForm:ResidenceNo) != ''"><xsl:value-of select="//ITRForm:Address/ITRForm:ResidenceNo" /><br/></xsl:if>
	               <xsl:if test="//ITRForm:Address/ITRForm:ResidenceName and normalize-space(//ITRForm:Address/ITRForm:ResidenceName) != ''"><xsl:value-of select="//ITRForm:Address/ITRForm:ResidenceName" /><br/></xsl:if> 
	               <xsl:if test="//ITRForm:Address/ITRForm:LocalityOrArea and normalize-space(//ITRForm:Address/ITRForm:LocalityOrArea) != ''"><xsl:value-of select="//ITRForm:Address/ITRForm:LocalityOrArea" /> <br/></xsl:if>
	               <xsl:if test="//ITRForm:Address/ITRForm:CityOrTownOrDistrict and normalize-space(//ITRForm:Address/ITRForm:CityOrTownOrDistrict) != ''"><xsl:value-of select="//ITRForm:Address/ITRForm:CityOrTownOrDistrict" /> - <xsl:value-of select="//ITRForm:Address/ITRForm:PinCode" /> <br/></xsl:if>
	               <xsl:value-of select="$country" /> <!-- this is passed from the code --><br/>
	               </span></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:3;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:4"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"></span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"></span></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:4;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:68"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Phone No. (Landline no.
	               or Mobile No.)</span></b>
	            </p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:64"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"> <xsl:value-of select="//ITRForm:Address/ITRForm:MobileNo" /></span></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:5;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:4"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Male/Female</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"><xsl:value-of select="//ITRForm:Gender" /></span></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:6;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:68"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Residential Status</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:64"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"><xsl:value-of select="//ITRForm:ResidentialStatus" /></span></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:7;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:4"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Assessment Year</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"><xsl:value-of select="$displayAssessmentYear" /></span></p>
	         </td>
	      </tr>
	      <!-- 
	      <tr style="mso-yfti-irow:8;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:68"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Previous Year</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;background:silver;
	            mso-background-themecolor:text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:64"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"></span></p>
	         </td>
	      </tr>
	       -->
	      <tr style="mso-yfti-irow:9;height:13.25pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:4"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">PAN No.</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;padding:0in 5.4pt 0in 5.4pt;
	            height:13.25pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"><xsl:value-of select="//ITRForm:PAN" /></span></p>
	         </td>
	      </tr>
	      <tr style="mso-yfti-irow:10;mso-yfti-lastrow:yes;height:13.95pt">
	         <td width="324" valign="top" style="width:242.7pt;border:none;border-bottom:solid black 1.0pt;
	            mso-border-bottom-themecolor:text1;background:silver;mso-background-themecolor:
	            text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;height:13.95pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:68"><b><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191">Ward Circle</span></b></p>
	         </td>
	         <td width="324" valign="top" style="width:242.7pt;border:none;border-bottom:solid black 1.0pt;
	            mso-border-bottom-themecolor:text1;background:silver;mso-background-themecolor:
	            text1;mso-background-themetint:63;padding:0in 5.4pt 0in 5.4pt;height:13.95pt">
	            <p class="MsoNormal" style="margin-bottom:0in;margin-bottom:.0001pt;line-height:
	               normal;mso-yfti-cnfc:64"><span style="font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;
	               color:black;mso-themecolor:text1;mso-themeshade:191"><xsl:value-of select="//ITRForm:DesigOfficerWardorCircle" /></span></p>
	         </td>
	      </tr>
	   </tbody>
	</table>
	<!-- 
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
		 -->
	</xsl:template>
	<!-- for ITR1,ITR4S -->
	<xsl:template match="ITRForm:ITR1_IncomeDeductions | ITRForm:ITR4S_IncomeDeductions">
	<span style="font-size:16.0pt;line-height:115%;font-family:Algerian">Computation of Total taxable Income</span>
		<table width="100%" border="1" id="taxi">
			<tr>
				<th colspan="2">Taxable Income</th>
			</tr>
			<xsl:if test="ITRForm:IncomeFromBusinessProf/text() != '0'">
				<tr>
					<td>Income from Salary</td>
					<td align="right">
						<xsl:value-of select="ITRForm:IncomeFromBusinessProf" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:IncomeFromSal/text() != '0'">
				<tr>
					<td>Income from Salary</td>
					<td align="right">
						<xsl:value-of select="ITRForm:IncomeFromSal" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:TotalIncomeOfHP/text() != '0'">
				<tr>
					<td>Income from House Property
					<xsl:if test="ITRForm:TypeOfHP/text() = 'S'">
					(Self Occupid)
					</xsl:if>
					<xsl:if test="ITRForm:TypeOfHP/text() = 'L'">
					(Letout)
					</xsl:if>
					</td>
					<td align="right">
						<xsl:value-of select="ITRForm:TotalIncomeOfHP" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:IncomeOthSrc/text() != '' and ITRForm:IncomeOthSrc/text() != '0'">
				<tr>
					<td>Income from Other Sources</td>
					<td align="right">
						<xsl:value-of select="ITRForm:IncomeOthSrc" />
					</td>
				</tr>
			</xsl:if>
			<tr>
				<td> Gross Total Income</td>
				<td align="right">
					<xsl:value-of select="ITRForm:GrossTotIncome" />
				</td>
			</tr>
			<xsl:if test="ITRForm:IncomeOthSrc/text() != '' and ITRForm:IncomeOthSrc/text() != '0'">
				<tr>
					<td>Section 89</td>
					<td align="right">
						<xsl:value-of select="ITRForm:itr1TaxComputation/ITRForm:Section89" />
					</td>
				</tr>
			</xsl:if>
			<tr>
				<td>Taxable Income</td>
				<td align="right">
					<xsl:value-of select="ITRForm:TotalIncome" />
				</td>
			</tr>
		</table>
		<xsl:apply-templates select="ITRForm:DeductUndChapVIA" />
	</xsl:template>
	<!-- for ITR2,ITR3,ITR4  -->
	<xsl:template match="ITRForm:PartB-TI">
	<span style="font-size:16.0pt;line-height:115%;font-family:Algerian">Computation of Total taxable Income</span>
		<table width="100%" border="1" id="taxi">
			<tr>
				<th colspan="2">Taxable Income</th>
			</tr>
			<xsl:if test="ITRForm:Salaries/text() != '0'">
				<tr>
					<td>Income from Salary</td>
					<td align="right">
						<xsl:value-of select="ITRForm:Salaries" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:IncomeFromHP/text() != '0'">
				<tr>
					<td>Income from House Property</td>
					<td align="right">
						<xsl:value-of select="ITRForm:IncomeFromHP" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:ProfBusGain/ITRForm:TotProfBusGain/text() != '0'">
				<tr>
					<td>Income from Business or Profession</td>
					<td align="right">
						<xsl:value-of select="ITRForm:ProfBusGain/ITRForm:TotProfBusGain" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:CapGain/ITRForm:TotalCapGains/text() != '0'">
				<tr>
					<td>Capital Gains</td>
					<td align="right">
						<xsl:value-of select="ITRForm:CapGain/ITRForm:TotalCapGains" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:IncFromOS/ITRForm:TotIncFromOS/text() != '0'">
				<tr>
					<td>Income from Other Sources</td>
					<td align="right">
						<xsl:value-of select="ITRForm:IncFromOS/ITRForm:TotIncFromOS" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:CurrentYearLoss/text() != '0'">
				<tr>
					<td>Current Year Losses</td>
					<td align="right">
						<xsl:value-of select="ITRForm:CurrentYearLoss" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:BroughtFwdLossesSetoff/text() != '0'">
				<tr>
					<td>Brought Forward Losses</td>
					<td align="right">
						<xsl:value-of select="ITRForm:BroughtFwdLossesSetoff" />
					</td>
				</tr>
			</xsl:if>
			<tr>
				<td> Gross Total Income</td>
				<td align="right">
					<xsl:value-of select="ITRForm:GrossTotalIncome" />
				</td>
			</tr>
			<xsl:if test="ITRForm:IncChargeableTaxSplRates/text() != '0'">
				<tr>
					<td>Income Chargeable Tax at Special Rate</td>
					<td align="right">
						<xsl:value-of select="ITRForm:IncChargeableTaxSplRates" />
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="ITRForm:DeductionsUnderScheduleVIA/text() != '0'">
				<tr>
					<td>Deduction under Chapter VI-A</td>
					<td align="right">
						<xsl:value-of select="ITRForm:DeductionsUnderScheduleVIA" />
					</td>
				</tr>
			</xsl:if>
			<tr>
				<td>Taxable Income</td>
				<td align="right">
					<xsl:value-of select="ITRForm:AggregateIncome" />
				</td>
			</tr>
		</table>
		<xsl:apply-templates select="ITRForm:DeductUndChapVIA" />
	</xsl:template>
	<xsl:template match="ITRForm:ITR1_TaxComputation | ITRForm:ITR4S_TaxComputation">
		<table width="100%" border="1" id="taxc">
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
 			<tr>
                 <td>Total Tax Paid</td>                                                        
                 <td align="right">
                         <xsl:value-of select="ITRForm:TotalTaxesPaid" />                       
                 </td>
			</tr>
			<tr>
				<td>Tax Status (
					<xsl:choose>
						<xsl:when test="../ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'TR']"><b>Tax Refund</b></xsl:when>
						<xsl:when test="../ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'TP']"><b>Tax Payable</b></xsl:when>
						<xsl:when test="../ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'NT']"><b>No Tax </b></xsl:when>						
					</xsl:choose>
					)					
				</td>
				<td align="right">
					<xsl:choose>
						<xsl:when test="../ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'TR']"><xsl:value-of select="../ITRForm:Refund/ITRForm:RefundDue"/></xsl:when>
						<xsl:when test="../ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'TP']"><xsl:value-of select="../ITRForm:TaxPaid/ITRForm:BalTaxPayable"/></xsl:when>
						<xsl:when test="../ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'NT']"><b>0</b></xsl:when>						
					</xsl:choose>
				</td>
			</tr>
		</table>
	</xsl:template>
	<!-- For ITR2,ITR3,ITR4  -->
	<xsl:template match="ITRForm:ComputationOfTaxLiability">
		<table width="100%" border="1" id="taxc">
			<tr>
				<th colspan="2">Tax Information</th>
			</tr>
			<tr>
				<td>TotalTaxPayable</td>
				<td align="right">
					<xsl:value-of select="ITRForm:TaxPayableOnTI/ITRForm:TaxPayableOnTotInc" />
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
					<xsl:value-of select="ITRForm:IntrstPay/ITRForm:TotalIntrstPay" />
				</td>
			</tr>
			<tr>
				<td>Total Tax and Interest Pay</td>
				<td align="right">
					<xsl:value-of select="ITRForm:AggregateTaxInterestLiability" />
				</td>
			</tr>
 			<tr>
                 <td>Total Tax Paid</td>                                                        
                 <td align="right">
                         <xsl:value-of select="//ITRForm:TotalTaxesPaid" />                       
                 </td>
			</tr>
			<tr>
				<td>Tax Status (
					<xsl:choose>
						<xsl:when test="//ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'TR']"><b>Tax Refund</b></xsl:when>
						<xsl:when test="//ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'TP']"><b>Tax Payable</b></xsl:when>
						<xsl:when test="//ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'NT']"><b>No Tax </b></xsl:when>						
					</xsl:choose>
					)					
				</td>
				<td align="right">
					<xsl:choose>
						<xsl:when test="//ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'TR']"><xsl:value-of select="../ITRForm:Refund/ITRForm:RefundDue"/></xsl:when>
						<xsl:when test="//ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'TP']"><xsl:value-of select="../ITRForm:TaxPaid/ITRForm:BalTaxPayable"/></xsl:when>
						<xsl:when test="//ITRForm:FilingStatus/ITRForm:TaxStatus[text() = 'NT']"><b>0</b></xsl:when>						
					</xsl:choose>
				</td>
			</tr>
		</table>
	</xsl:template>
	<!-- this is a common template called by apply-templates -->
	
	<xsl:template match="ITRForm:FilingStatus">
		<!-- Commented out -->
		<!-- 
		<xsl:for-each select="./*">
				<xsl:variable name="myName" select="name(.)" />
				<xsl:value-of select="name(.)" />:-
			<span style="color:#ff0000">
				<xsl:value-of select="." />
			</span>
		</xsl:for-each>
		 -->
	</xsl:template>
	
	<xsl:template match="ITRForm:DeductUndChapVIA">		
		<table width="100%" border="1"  id="c6">
			<tr>
				<th colspan="3">Deductions under Chapter VI</th>
			</tr>
			<tr>
				<th>Section</th>
				<th align="right">Total</th>
				<th align="right">Eligible</th>
			</tr>
			<xsl:for-each select="./*[text() != '0']">
				<xsl:variable name="css-class">
				    <xsl:choose>
				      <xsl:when test="position() mod 2 = 0">even</xsl:when>
				      <xsl:otherwise>odd</xsl:otherwise>
				    </xsl:choose>
			 	   </xsl:variable>
					<tr>
						<xsl:attribute name="class"><xsl:value-of select="$css-class"/></xsl:attribute>
						<xsl:variable name="myName" select="name(.)" />
						<td>
							<xsl:choose>
								<xsl:when test="contains(name(.),':')">
									<xsl:value-of select="substring-after(name(),':')" />
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of select="name(.)" />
								</xsl:otherwise>
							</xsl:choose>
						</td>
						<td align="right">
							<xsl:value-of select="../../ITRForm:UsrDeductUndChapVIA/*[name()=$myName]" />
						</td>						
						<td align="right">
							<xsl:value-of select="." />
						</td>
					</tr>
			</xsl:for-each>
		</table>
	</xsl:template>

	<xsl:template match="ITRForm:Verification">

	</xsl:template>

	<xsl:template match="xsi:* | *">
		
	</xsl:template>

	<xsl:template match="ITRForm:*">
		<xsl:choose>
			<xsl:when test="starts-with(name(.),'ITRForm:Part') or starts-with(name(.),'ITRForm:Schedule')">
				<xsl:apply-templates/>
			</xsl:when>
		</xsl:choose>
	</xsl:template>


</xsl:stylesheet>