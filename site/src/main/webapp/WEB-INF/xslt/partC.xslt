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
	ns7:schemaLocation="http://incometaxindiaefiling.gov.in/main ITRMain13.xsd" 
	xmlns:ITR1FORM="http://incometaxindiaefiling.gov.in/ITR1" 
	xmlns:ITR2FORM="http://incometaxindiaefiling.gov.in/ITR2" 
	xmlns:ITRETURN="http://incometaxindiaefiling.gov.in/main" 
	xmlns:ITRForm="http://incometaxindiaefiling.gov.in/master" 
	xmlns:ITR3FORM="http://incometaxindiaefiling.gov.in/ITR3" 
	xmlns:ns5="http://incometaxindiaefiling.gov.in/ITR4S" 
	xmlns:ns7="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:ITR4FORM="http://incometaxindiaefiling.gov.in/ITR4"
	exclude-result-prefixes="ITR1FORM ITR2FORM ITRETURN ITRForm ITR4FORM ITR3FORM ns5 ns7 hippogallery wfdropbox hst mix tcmp hippohtmlcleaner editor nt relateddocs fn_old mootlywcmgallery hippotaxonomy sv hippofacnav selection poll rep hippostdpubwf hippolog hipposched hippostd hippo hstconfigedit hippogoogleanalytics hippogallerypicker ef fn hipposys frontend xs hippotranslation brokenlinks jcr hipporeport mootlywcm hipposysedit reporting">

	<xsl:output method="xml"></xsl:output>
	
	<xsl:template name="partC">
		<xsl:variable name="theITRForm" select="//memberpersonalinformation/@flex_string_ITRForm"/>
		<!-- CHAPTER 6 FIRS -->
		<div class="sectionhead">PART C - DEDUCTIONS AND TAXABLE TOTAL INCOME</div>
		<!--  PART C -->
		<div class="container">
			<xsl:call-template name="partC-ChapterVI"/>														
		</div>									
	</xsl:template>
	
	<xsl:template name="partC-ChapterVI">
		<div class="row">
			<div class="col-xs-4">
				<span class="normallabel">80C</span>
				<span class="normaltext">	
					<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80C"/>
				</span>
			</div>
			<div class="col-xs-4">
				<span class="normallabel">80CCC</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80CCC"/></span>
			</div>
			<div class="col-xs-4">
				<span class="normallabel">80CCD(1)</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80CCDEmployeeOrSE"/></span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span class="normallabel">80CCD(2)</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80CCDEmployer"/></span>
			</div>
			<div class="col-xs-4">
				<span class="normallabel">80CCG</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80CCG"/></span>
			</div>
			<div class="col-xs-4">
				<span class="normallabel">80D</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80D"/></span>
			</div>
		</div>				
		<div class="row">
			<div class="col-xs-4">
				<span class="normallabel">80DD</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80DD"/></span>
			</div>
			<div class="col-xs-4">
				<span class="normallabel">80DDB</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80DDB"/></span>
			</div>
			<div class="col-xs-4">
				<span class="normallabel">80E</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80E"/></span>
			</div>
		</div>		
		<div class="row">
			<div class="col-xs-4">
				<span class="normallabel">80G</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80G"/></span>
			</div>
			<div class="col-xs-4">
				<span class="normallabel">80GG</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80GG"/></span>
			</div>
			<div class="col-xs-4">
				<span class="normallabel">80GGA</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80GGA"/></span>
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
	</xsl:template>
</xsl:stylesheet>