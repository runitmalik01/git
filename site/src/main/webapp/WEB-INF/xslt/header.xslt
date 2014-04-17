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
	<xsl:template name="header">
		<xsl:variable name="theITRForm" select="//memberpersonalinformation/@flex_string_ITRForm"/>
		<xsl:choose>
			<xsl:when test="$theITRForm = 'ITR1'">
			 	<xsl:call-template name="header1"/>
			</xsl:when>
			<xsl:when test="$theITRForm = 'ITR3'">
			<xsl:call-template name="header3"/>
			</xsl:when>
			<xsl:when test="$theITRForm = 'ITR4S'">
			<xsl:call-template name="header4S"/>
			</xsl:when>
		<xsl:otherwise>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="header1">
		<div class="container" style="background-color:red;width:100%">
			<div class="row">
				<div class="col-xs-2">
					<h4><b class="boldsch"><xsl:value-of select="//memberpersonalinformation/@flex_string_ITRForm"/></b></h4>
				</div>
				<div class="col-xs-8">
				<h5>SAHAJ INDIVIDUAL INCOME TAX RETURN</h5>
				</div>
				<div class="col-xs-11">
					<h4> <b class="boldsch">AY <xsl:value-of select="$displayAssessmentYear"/></b></h4>
				</div>
			</div>
		</div>
	</xsl:template>
	<xsl:template name="header3">
		<div class="container" style="background-color:red;width:100%">
			<div class="row">
				<div class="col-xs-3">
					<h4><b class="boldsch"><xsl:value-of select="//memberpersonalinformation/@flex_string_ITRForm"/></b></h4>
				</div>
				<div class="col-xs-8">
				<b class="boldsch">&#160;&#160;&#160;&#160;&#160;&#160;&#160;INDIAN INCOME TAX RETURN</b> 
			<div class="col-xs-15">	
			<div class="en">[For Individuals/HUFs being partners in firms and not carrying out business
               or profession under any proprietorship]</div>
			</div>
			</div>
				<div class="col-xs-12">
					<h4><b class="boldsch">AY <xsl:value-of select="$displayAssessmentYear"/></b></h4>
				</div>
			</div>
		</div>
	</xsl:template>
	<xsl:template name="header4S">
		<div class="container" style="background-color:red;width:100%">
			<div class="row">
				<div class="col-xs-2">
					<h4><b class="boldsch"><xsl:value-of select="//memberpersonalinformation/@flex_string_ITRForm"/></b></h4>
				</div>
				<div class="col-xs-9">
				<b class="boldsch">SUGAM </b> PRESUMPTIVE BUSINESS INCOME TAX RETURN 
				</div>
				<div class="col-xs-12">
					<h4> <b class="boldsch">AY <xsl:value-of select="$displayAssessmentYear"/> </b></h4>
				</div>
			</div>
		</div>
	</xsl:template>
</xsl:stylesheet>