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
	
	<xsl:template name="partA">
		<xsl:variable name="theITRForm" select="//memberpersonalinformation/@flex_string_ITRForm"/>
		<xsl:call-template name="partA-generic"/>					
	</xsl:template>
	
	<xsl:template name="partA-generic">
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
	</xsl:template>
</xsl:stylesheet>