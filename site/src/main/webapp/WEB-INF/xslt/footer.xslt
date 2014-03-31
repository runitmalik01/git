<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:hippogallery="http://www.onehippo.org/jcr/hippogallery/nt/2.0" 
	xmlns:wfdropbox="http://www.onehippo.org/jcr/wfdropbox/nt/1.0" 
	xmlns:hst="http://www.hippoecm.org/hst/nt/2.1" 
	xmlns:mix="http://www.jcp.org/jcr/mix/1.0" 
	xmlns:tcmp="http://forge.onehippo.org/tcmp/1.0" 
	xmlns:hippohtmlcleaner="http://www.onehippo.org/jcr/htmlcleaner/nt/2.1" 
	xmlns:editor="http://www.hippoecm.org/editor/nt/1.0" 
	xmlns:nt="http://www.jcp.org/jcr/nt/1.0" 
	xmlns:relateddocs="http://forge.onehippo.org/relateddocs/nt/1.1" 
	xmlns:fn_old="http://www.w3.org/2004/10/xpath-functions" 
	xmlns:mootlywcmgallery="http://www.onehippo.org/jcr/mootlywcmgallery/2.0" 
	xmlns:hippotaxonomy="http://www.hippoecm.org/hippotaxonomy/nt/1.2" 
	xmlns:sv="http://www.jcp.org/jcr/sv/1.0" 
	xmlns:hippofacnav="http://www.onehippo.org/jcr/hippofacnav/nt/1.0.1" 
	xmlns:selection="http://forge.onehippo.org/selection/nt/1.0" 
	xmlns:poll="http://forge.onehippo.org/poll/nt/1.2" 
	xmlns:rep="internal" 
	xmlns:hippostdpubwf="http://www.onehippo.org/jcr/hippostdpubwf/nt/1.0" 
	xmlns:hippolog="http://www.onehippo.org/jcr/hippolog/nt/2.0" 
	xmlns:hipposched="http://www.hippoecm.org/hipposched/nt/1.3" 
	xmlns:hippostd="http://www.onehippo.org/jcr/hippostd/nt/2.0" 
	xmlns:hippo="http://www.onehippo.org/jcr/hippo/nt/2.0.4" 
	xmlns:hstconfigedit="http://www.hippoecm.org/hst/nt/hstconfigedit/1.0" 
	xmlns:hippogoogleanalytics="http://www.onehippo.org/jcr/hippogoogleanalytics/nt/1.0" 
	xmlns:hippogallerypicker="http://www.hippoecm.org/hippogallerypicker/nt/2.0" 
	xmlns:ef="http://forge.onehippo.org/ef/1.2" 
	xmlns:fn="http://www.w3.org/2005/xpath-functions" 
	xmlns:hipposys="http://www.onehippo.org/jcr/hipposys/nt/1.0" 
	xmlns:frontend="http://www.onehippo.org/jcr/frontend/nt/2.0" 
	xmlns:xs="http://www.w3.org/2001/XMLSchema" 
	xmlns:hippotranslation="http://www.onehippo.org/jcr/hippotranslation/nt/1.0" 
	xmlns:brokenlinks="http://www.onehippo.org/jcr/brokenlinks/nt/1.0" 
	xmlns:jcr="http://www.jcp.org/jcr/1.0" 
	xmlns:hipporeport="http://www.onehippo.com/jcr/hipporeport/nt/1.0"
	xmlns:mootlywcm="http://www.onehippo.org/jcr/mootlywcm/2.0"
	xmlns:hipposysedit="http://www.onehippo.org/jcr/hipposysedit/nt/1.2" 
	xmlns:reporting="http://www.onehippo.org/jcr/reporting/nt/2.0"
	exclude-result-prefixes="hippogallery wfdropbox hst mix tcmp hippohtmlcleaner editor nt relateddocs fn_old mootlywcmgallery hippotaxonomy sv hippofacnav selection poll rep hippostdpubwf hippolog hipposched hippostd hippo hstconfigedit hippogoogleanalytics hippogallerypicker ef fn hipposys frontend xs hippotranslation brokenlinks jcr hipporeport mootlywcm hipposysedit reporting">

	<xsl:output method="xml"></xsl:output>
	<xsl:param name="COUNTRY"></xsl:param>
	<xsl:param name="STATE"></xsl:param>
	<xsl:param name="displayAssessmentYear"></xsl:param>
	<xsl:template match="/">
		<html lang="en">
			<head>	
				<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>		
				<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"/>
				<style type="text/css">
					.normallabel {color:red; font-family:Tahoma; font-size:8px;font-weight:bold;}
					.normaltext {font-family:Tahoma; font-size:8px;}
					.redline {color:red;}
					.sectionhead {font-family:arial; font-size:14.5px}
					.leftrightborder{border-left:thin solid #ff0000;border-bottom:thin solid #ff0000;border-right:thin solid #ff0000;}
					.rightborder{border-left:none;border-bottom:thin solid red;border-right:thin solid red;}
					.decimal {text-align:right}
				</style>
			</head>
			<body>
				<div class="container" style="background-color:red;width:100%">
					<div class="row">
						<div class="col-xs-6">
							<h4><xsl:value-of select="//memberpersonalinformation/@flex_string_ITRForm"/></h4>
						</div>
						<div class="col-xs-6">
							<h4>AY <xsl:value-of select="$displayAssessmentYear"/></h4>
						</div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-xs-6 leftrightborder">
							<div><span class="normallabel">FIRST NAME</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:pi_first_name"/></span></div>
						</div>
						<div class="col-xs-6 rightborder">
							<div><span class="normallabel">MIDDLE NAME</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:pi_middle_name"/></span></div>
						</div>
					</div>
					<hr class="redline"/>
					<div class="row">
						<div class="col-xs-6">
							<div><span class="normallabel">LAST NAME</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:pi_last_name"/></span></div>
						</div>
						<div class="col-xs-6">
							<div><span class="normallabel">PERMANENT ACCOUNT NUMBER</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:pi_pan"/></span></div>
						</div>
					</div>
					<hr class="redline"/>
					<div class="row">
						<div class="col-xs-2">
							<div><span class="normallabel">SEX</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:pi_sex"/></span></div>
						</div>
						<div class="col-xs-3">
							<div><span class="normallabel">DATE OF BIRTH</span></div>
							<div><span class="normaltext"><xsl:value-of select="substring-before(//memberpersonalinformation/@mootlywcm:pi_dob,'T')"/></span></div>
						</div>
						<div class="col-xs-7">
							<div><span class="normallabel">INCOME TAX WARD/CIRCLE</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:incomeTaxWard"/></span></div>
						</div>
					</div>
					<hr class="redline"/>
					<div class="row">
						<div class="col-xs-6">
							<div><span class="normallabel">FLAT/DOOR/BUILDING</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:pi_flat_door_building"/></span></div>
						</div>
						<div class="col-xs-6">
							<div><span class="normallabel">ROAD/STREET</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:pi_road_street"/></span></div>
						</div>
					</div>
					<hr class="redline"/>
					<div class="row">
						<div class="col-xs-3">
							<div><span class="normallabel">STATE</span></div>
							<div><span class="normaltext"><xsl:value-of select="$STATE"/></span></div>
						</div>
						<div class="col-xs-4">
							<div><span class="normallabel">COUNTRY</span></div>
							<div><span class="normaltext"><xsl:value-of select="$COUNTRY"/></span></div>
						</div>
						<div class="col-xs-5">
							<div><span class="normallabel">PINCODE</span></div>
							<div><span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:pi_pin_code"/></span></div>
						</div>
					</div>
					<div class="sectionhead">PART B - GROSS TOTAL INCOME</div>
					<div class="row">
						<div class="col-xs-1">
							<strong>B1</strong>
						</div>
						<div class="col-xs-7 normallabel">Income from Salary/Pension</div>
						<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//formsixteendocument/mootlywcm:formsixteendetail/@mootlywcm:grossa)"/></div>
					</div>
					<div class="row">
						<div class="col-xs-1">
							<strong>B2</strong>
						</div>
						<div class="col-xs-7">
							<span class="normallabel">Income from One House Property 
								<xsl:choose>
									<xsl:when test="//houseproperty/mootlywcm:houseincomedetail/@mootlywcm:letout = 'S'">
										<img  width="16px" height="16px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/> Self Occupied 
										<img  width="16px" height="16px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/> Let out
									</xsl:when>
									<xsl:otherwise>
										<img width="16px" height="16px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/> Self Occupied 
										<img  width="16px" height="16px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/> Let out
									</xsl:otherwise>
								</xsl:choose>
							</span>
						</div>
						<div class="col-xs-4">
							<span class="normaltext decimal pull-right"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//houseproperty/mootlywcm:houseincomedetail/@mootlywcm:total_houseIncome)"/></span>
						</div>
					</div>		
					<div class="row">
						<div class="col-xs-1">
							<strong>B3</strong>
						</div>
						<div class="col-xs-7">
							<span class="normallabel">Income from other sources</span>
						</div>
						<div class="col-xs-4">
							<span class="normaltext decimal pull-right">
								<xsl:number grouping-size="3" grouping-separator=","  value="sum(//othersourcesdocument/@mootlywcm:Taxable_income)"/>
								<!-- 
								<xsl:number grouping-size="3" grouping-separator=","  value="sum(//othersourcesdocument/@*[starts-with(name(),'mootlywcm:')])"/>
								 -->
							</span>
						</div>						
					</div>									
				</div>
				<div class="sectionhead">PART C - DEDUCTIONS AND TAXABLE TOTAL INCOME</div>
				<!--  PART C -->
				<div class="container">
					<div class="row">
						<div class="col-xs-4">
							<span class="normallabel">80C</span>
							<span class="normaltext">	
								<xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80c']/@mootlywcm:investment)"/>
							</span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80CCC</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80ccc']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80CCD(1)</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80ccd_1']/@mootlywcm:investment)"/></span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-4">
							<span class="normallabel">80CCD(2)</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80ccd_2']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80CCG</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80ccg']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80D</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80d']/@mootlywcm:investment)"/></span>
						</div>
					</div>				
					<div class="row">
						<div class="col-xs-4">
							<span class="normallabel">80DD</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80dd']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80DDB</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80ddb']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80E</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80e']/@mootlywcm:investment)"/></span>
						</div>
					</div>		
					<div class="row">
						<div class="col-xs-4">
							<span class="normallabel">80G</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80dd']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80DDB</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80ddb']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80E</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80e']/@mootlywcm:investment)"/></span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-4">
							<span class="normallabel">80GGC</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80ggc']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80RRB</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80rrb']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-4">
							<span class="normallabel">80QQB</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80qqb']/@mootlywcm:investment)"/></span>
						</div>
					</div>	
					<div class="row">
						<div class="col-xs-4">
							<span class="normallabel">80TTA</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80dd']/@mootlywcm:investment)"/></span>
						</div>
						<div class="col-xs-8 col-offset-4">
							<span class="normallabel">80U</span>
							<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80u']/@mootlywcm:investment)"/></span>
						</div>
					</div>																				
				</div>			
			</body>
		</html>
	</xsl:template>
	
	
	<xsl:template name="getSectionTotal">
		<xsl:param name="section"></xsl:param>
		<xsl:for-each select="//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='$section']">	
			
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>