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
	
	exclude-result-prefixes="ITR1FORM ITR2FORM ITRETURN ITRForm ITR3FORM ITR4FORM ns5 ns7 hippogallery wfdropbox hst mix tcmp hippohtmlcleaner editor nt relateddocs fn_old mootlywcmgallery hippotaxonomy sv hippofacnav selection poll rep hippostdpubwf hippolog hipposched hippostd hippo hstconfigedit hippogoogleanalytics hippogallerypicker ef fn hipposys frontend xs hippotranslation brokenlinks jcr hipporeport mootlywcm hipposysedit reporting">

	<xsl:output method="xml"></xsl:output>
	
	<xsl:template name="partB">
		<xsl:variable name="theITRForm" select="//memberpersonalinformation/@flex_string_ITRForm"/>
		<xsl:choose>
			<xsl:when test="$theITRForm = 'ITR1'">
			 	<xsl:call-template name="partB-ITR1"/>
			</xsl:when>
			<xsl:when test="$theITRForm = 'ITR3'">
			 	<xsl:call-template name="partB-ITR3"/>
			</xsl:when>
			<xsl:when test="$theITRForm = 'ITR4S'">
			 	<xsl:call-template name="partB-ITR4S"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:call-template name="partB-generic"/>
			</xsl:otherwise>
		</xsl:choose>						
	</xsl:template>
	
	<xsl:template name="partB-ITR1">
		<div class="sectionhead"><b class="boldsch">PART B -</b> GROSS TOTAL INCOME </div>
		<div class="row">
			<div class="col-xs-1">
				<strong>B1</strong>
			</div>
			<div class="col-xs-7 normallabel">Income from Salary/Pension</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ITR1_IncomeDeductions/ITRForm:IncomeFromSal"/></div>
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
				<span class="normaltext decimal pull-right"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//houseproperty/mootlywcm:houseincomedetail/@mootlywcm:Income_hproperty)"/></span>
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
		       <div class="row">
			<div class="col-xs-1">
				<strong>B4</strong>
			</div>
			<div class="col-xs-7">
				<span class="normallabel">Gross Total Income(B1+B2+B3)</span>
			</div>
			<div class="col-xs-4">
				<span class="normaltext">
				 <span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ITR1_IncomeDeductions/ITRForm:GrossTotIncome"/></span>
				</span>	
			</div>						
		 </div>
		       			
	</xsl:template>
	
	<xsl:template name="partB-generic">
		<div class="sectionhead">PART B - GROSS TOTAL INCOME</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>B1</strong>
			</div>
			<div class="col-xs-7 normallabel">Income from Salary/Pension</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="4" grouping-separator=","  value="//ITRForm:ITR1_IncomeDeductions/ITRForm:IncomeFromSal"/></div>
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
				<span class="normaltext decimal pull-right"><xsl:number grouping-size="4" grouping-separator=","  value="sum(//houseproperty/mootlywcm:houseincomedetail/@mootlywcm:Income_hproperty)"/></span>
			</div>
		</div>		
		<div class="row">
			<div class="col-xs-1">
				<strong>B3</strong>
			</div>
			<div class="col-xs-7">
				<span class="normallabel">Income from other sources </span>
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
		<div class="row">
			<div class="col-xs-1">
				<strong>B4</strong>
			</div>
			<div class="col-xs-7">
				<span class="normallabel">Gross Total Income(B1+B2+B3)</span>
			</div>
			 <div class="col-xs-4">
				<span class="normaltext">
					  <span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ITR1_IncomeDeductions/ITRForm:GrossTotIncome"/></span>
	</span>
			  </div>						
		  </div>
	</xsl:template>
	
	
	
      <xsl:template name="partB-ITR3">
		<div class="sectionhead"><b class="boldsch">Part B - TI -</b> Computation of total income</div>
		<hr class="redline"/>
		<div class="row">
			<div class="col-xs-1">
				<strong></strong>
			</div>
			<div class="col-xs-7 normallabel">(1).&#160;&#160;Salaries (7 of Schedule S)</div>
			<div class="col-xs-4 normaltext decimal">
			  <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:Salaries"/>
			</div>
		</div>
		<div class="row">
		<hr class="redline"/>
			<div class="col-xs-1">
				<strong></strong>
			</div>
			<div class="col-xs-7">
				<span class="normallabel">(2).&#160;&#160;Income from house property (3c of Schedule HP) (enter nil if loss)</span>
			</div>
			<div class="col-xs-4 normaltext decimal">
			 <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:IncomeFromHP"/>
			</div>
		</div>		
		
		
		<div class="row">
		<hr class="redline"/>
		<div class="col-xs-1">
				<strong></strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(3).&#160;&#160;Capital Gain:-<br/></span></div>
       </div>
       </div>
       <div class="row">
       <div class="col-xs-1">
				<strong></strong>
			</div>
    <div class="col-xs-7" ><span class="normaltext">
    <b class="bold">(a).&#160;&#160;Short Term</b><br/>
    <b class="bold">(i).&#160;&#160; Short-term (u/s 111A) (A1a+A 2e of Schedule CG)&#160;&#160;3ai&#160;&#160;</b><br/>
     <b class="bold">(ii).&#160;&#160; Short-term (others) ((A5 – A1a-A 2e) of Schedule CG)&#160;&#160;3aii&#160;&#160;</b><br/>
        <b class="bold">(iii).&#160;&#160; Total short-term (3ai + 3aii) (A5 of Schedule CG)&#160;&#160;3aiii&#160;&#160;</b><br/>
    </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right"><br/>
        <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:CapGain/ITRForm:ShortTerm/ITRForm:ShortTermUs111A"/><br/>
       <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:CapGain/ITRForm:ShortTerm/ITRForm:ShortTermOther"/><br/>
       <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:CapGain/ITRForm:ShortTerm/ITRForm:TotalShortTerm"/><br/>
      
     </span>
   </div>
    	</div>
    	<div class="row">
       <div class="col-xs-1">
				<strong></strong>
			</div>
    <div class="col-xs-7" ><span class="normaltext">
    <b class="bold">(b).&#160;&#160;Long Term</b><br/>
    <b class="bold">(i).&#160;&#160; Long-term (B6 - B3e – B4 of Schedule CG)&#160;&#160;3bi&#160;&#160;</b><br/>
     <b class="bold">(ii).&#160;&#160; Long-term without indexation (B3e + B4 of Schedule CG)&#160;&#160;3bii&#160;&#160;</b><br/>
        <b class="bold">(iii).&#160;&#160; Total Long-term (3bi +3bii) (enter nil if loss and take the figure to
schedule CFL)&#160;&#160;3biii&#160;&#160;</b><br/>
    </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right"><br/>
        <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:CapGain/ITRForm:LongTerm/ITRForm:LongTermIndexation"/><br/>
       <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:CapGain/ITRForm:LongTerm/ITRForm:LongTermWOIndexation"/><br/>
       <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:CapGain/ITRForm:LongTerm/ITRForm:TotalLongTerm"/><br/>
      
     </span>
   </div>
    	</div>
    	<div class="row">
       <div class="col-xs-1">
				<strong></strong>
			</div>
    <div class="col-xs-7" ><span class="normaltext">
    <b class="bold">(c).&#160;&#160;Total capital gains (3aiii + 3biii) (take the figure adjusted to Schedule CYLA)(In case of negative figure
enter nil and take the figure under respective head to schedule CFL)</b><br/>
    
    </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right"><br/>
        <xsl:value-of select="//ITRForm:PartB-TI/ITRForm:CapGain/ITRForm:TotalCapGains"/><br/>
        </span>
   </div>
    	</div>
    	
    	<div class="row">
    	 
  		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(4).&#160;&#160;Income from other sources<br/></span></div>
       </div>
       </div>
    	 <div class="row">
       <div class="col-xs-1">
				<strong></strong>
			</div>
    <div class="col-xs-7" ><span class="normaltext">
     
    <b class="bold">(a).&#160;&#160; from sources other than from owning race horses and winnings from Lottery etc. (1g of
Schedule OS)&#160;&#160;</b><br/>
     <b class="bold">(b).&#160;&#160; winnings from lotteries, crossword puzzles, races, games, gambling, betting etc. (2 of
Schedule OS)</b><br/>
        <b class="bold">(c).&#160;&#160;from owning and maintaining race horses (4c of Schedule OS) (enter nil if loss)</b><br/>
     <b class="bold">(d).&#160;&#160;Total (4a + 4b + 4c) (enter nil if 4d is a loss)</b><br/>
 
    </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right"><br/>
       <xsl:value-of select="//ITRForm:IncFromOS/ITRForm:OtherSrcThanOwnRaceHorse"/><br/><br/>
    	 <xsl:value-of select="//ITRForm:IncFromOS/ITRForm:WinLotteriesRacesGambling"/><br/><br/>
    	  <xsl:choose>
    <xsl:when test="//ITRForm:IncFromOS/ITRForm:FromOwnRaceHorse >'-1'">
    <xsl:value-of select="//ITRForm:IncFromOS/ITRForm:FromOwnRaceHorse"/><br/>
     	  </xsl:when>
		  <xsl:otherwise>
      <b class="bold" >0<br/></b>
   </xsl:otherwise>
    </xsl:choose>
     <xsl:choose>
    <xsl:when test="//ITRForm:IncFromOS/ITRForm:TotIncFromOS >'-1'">
    <xsl:value-of select="//ITRForm:IncFromOS/ITRForm:TotIncFromOS"/>
     	  </xsl:when>
		  <xsl:otherwise>
      <b class="bold" >0<br/><br/></b>
   </xsl:otherwise>
    </xsl:choose>
      
     </span>
   </div>
    	</div>
    	<div class="row">
    	<hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(5).&#160;&#160;Total (1+2+3c +4d)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:TotalTI"/></span></div>
       </div>
       </div>
     
    	<div class="row">
    	<hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(6).&#160;&#160;Losses of current year set off against 5 (total of 2vii and 3vii of Schedule CYLA)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:CurrentYearLoss"/></span></div>
       </div>
       </div>
     
    	<div class="row">
    	<hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(7).&#160;&#160;Balance after set off current year losses (5-6) (also total of column 4 of Schedule CYLA +4b)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:BalanceAfterSetoffLosses"/></span></div>
       </div>
       </div>
       <div class="row">
       <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(8).&#160;&#160;Brought forward losses set off against 7 (2vii of Schedule BFLA)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:BroughtFwdLossesSetoff"/></span></div>
       </div>
       </div>
        <div class="row">
        <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(9).&#160;&#160;Gross Total income (7-8)(also 3viii of Schedule BFLA +4b )</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:GrossTotalIncome"/></span></div>
       </div>
       </div>
       
       <div class="row">
       <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(10).&#160;&#160;Income chargeable to tax at special rate under section 111A, 112 etc. included in 9</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:IncChargeableTaxSplRates"/></span></div>
       </div>
       </div>
        
       <div class="row">
       <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(11).&#160;&#160;Deductions under Chapter VI-A [q of Schedule VIA and limited to (9-10)]</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:DeductionsUnderScheduleVIA"/></span></div>
       </div>
       </div>
       
        <div class="row">
        <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(12).&#160;&#160;Total income (9-11)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:TotalIncome"/></span></div>
       </div>
       </div>
    	 
    	 <div class="row">
    	  <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(13).&#160;&#160;Income which is included in 12 and chargeable to tax at special rates (total of (i) of schedule SI)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:IncChargeTaxSplRate111A112"/></span></div>
       </div>
       </div>
        <div class="row">
         <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(14).&#160;&#160;Net agricultural income/ any other income for rate purpose (4 of Schedule EI)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:NetAgricultureIncomeOrOtherIncomeForRate"/></span></div>
       </div>
       </div>
         <div class="row">
          <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(15).&#160;&#160;Aggregate income (12-13+14) [applicable if (12-13) exceeds maximum amount not chargeable to tax]</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:AggregateIncome"/></span></div>
       </div>
       </div>
          <div class="row">
           <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(16).&#160;&#160;Losses of current year to be carried forward (total of row xi of Schedule CFL)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:LossesOfCurrentYearCarriedFwd"/></span></div>
       </div>
       </div>
         <hr class="redline"/>
       <!-- PART B-TI END HERE -->
       
        <!-- PART B-TTI START HERE -->
		 		 
		 		 		<div class="sectionhead"><b class="boldsch">Part B - TTI</b> - Computation of tax liability on total income</div>
 
    	<div class="row">
    	 <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(1).&#160;&#160;Tax payable on total income<br/></span></div>
       </div>
       </div>
    	 <div class="row">
       <div class="col-xs-1">
				<strong></strong>
			</div>
    <div class="col-xs-7" ><span class="normaltext">
     
    <b class="bold">(a).&#160;&#160; Tax at normal rates &#160;&#160;</b><br/>
     <b class="bold">(b).&#160;&#160; Tax at special rates (total of (ii) of Schedule SI)</b><br/>
     <b class="bold">(c).&#160;&#160;Tax Payable on Total Income (1a + 1b)</b><br/>
 
    </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right">
       <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:TaxPayableOnTI/ITRForm:TaxAtNormalRatesOnAggrInc"/><br/>
    	 <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:TaxPayableOnTI/ITRForm:TaxAtSpecialRates"/><br/>
      <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:TaxPayableOnTI/ITRForm:TaxPayableOnTotInc"/><br/>
    	   
      
     </span>
   </div>
    	</div>
    	<div class="row">
    	<hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(2).&#160;&#160;Education cess, including secondary and higher education cess, on 1c<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:EducationCess"/></span></div>
       </div>
       </div>
     
    	<div class="row">
    	<hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(3).&#160;&#160;Gross tax liability (1c+ 2)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:GrossTaxLiability"/></span></div>
       </div>
       </div>
     
    	<div class="row">
    	<hr class="redline"/>
    	  <div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
	      <div class="col-xs-7">
         <div>
    <span class="normallabel">
   (4).&#160;&#160; Tax relief <br/></span>
     </div>
       </div>
       </div>
        <div class="row">
       <div class="col-xs-1">
				<strong></strong>
			</div>
    <div class="col-xs-7" ><span class="normaltext">
     
    <b class="bold">(a).&#160;&#160;Section 89&#160;&#160;</b><br/>
     <b class="bold">(b).&#160;&#160;Section 90/90A ( 3 of Schedule TR)</b><br/>
        <b class="bold">(c).&#160;&#160;Section 91( 4 of Schedule TR)</b><br/>
     <b class="bold">(d).&#160;&#160;Total (4a + 4b + 4c)</b><br/>
 
    </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right">
       <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:TaxRelief/ITRForm:Section89"/><br/>
    	 <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:TaxRelief/ITRForm:Section90"/><br/>
    	  
    <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:TaxRelief/ITRForm:Section91"/><br/>
      <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:TaxRelief/ITRForm:TotTaxRelief"/><br/>
    	   
      
     </span>
   </div>
    	</div>
       <div class="row">
       
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(5).&#160;&#160;Net tax liability (3 – 4d)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:NetTaxLiability"/></span></div>
       </div>
       </div>
       
       <div class="row">
       <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(6).&#160;&#160;Interest payable<br/></span></div>
       </div>
       </div>
           	 <div class="row">
       <div class="col-xs-1">
				<strong></strong>
			</div>
    <div class="col-xs-7" ><span class="normaltext">
     
    <b class="bold">(a).&#160;&#160;For default in furnishing the return (section 234A)&#160;&#160;</b><br/>
     <b class="bold">(b).&#160;&#160;For default in payment of advance tax (section 234B)</b><br/>
        <b class="bold">(c).&#160;&#160;For deferment of advance tax (section 234C)</b><br/>
     <b class="bold">(d).&#160;&#160;Total Interest Payable (6a+6b+6c)</b><br/>
 
    </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right">
       <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:IntrstPay/ITRForm:IntrstPayUs234A"/><br/>
    	 <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:IntrstPay/ITRForm:IntrstPayUs234B"/><br/>
    	  
    <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:IntrstPay/ITRForm:IntrstPayUs234C"/><br/>
      <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:IntrstPay/ITRForm:TotalIntrstPay"/><br/>
    	   
      
     </span>
   </div>
    	</div>
        <div class="row">
        <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(7).&#160;&#160;Aggregate liability (5 + 6d)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:ComputationOfTaxLiability/ITRForm:AggregateTaxInterestLiability"/></span></div>
       </div>
       </div>
       
        <div class="row">
        <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(8).&#160;&#160;Taxes Paid<br/></span></div>
       </div>
       </div>
           	 <div class="row">
       <div class="col-xs-1">
				<strong></strong>
			</div>
    <div class="col-xs-7" ><span class="normaltext">
     
    <b class="bold">(a).&#160;&#160;Advance Tax (from Schedule-IT)&#160;&#160;</b><br/>
     <b class="bold">(b).&#160;&#160;TDS (total of column 5 of Schedule-TDS1 and column 7
of Schedule-TDS2)</b><br/>
        <b class="bold">(c).&#160;&#160;Self-Assessment Tax(from Schedule-IT)</b><br/>
     <b class="bold">(d).&#160;&#160;Total Taxes Paid (8a+8b+8c)</b><br/>
 
    </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right">
       <xsl:value-of select="//ITRForm:TaxPaid/ITRForm:TaxesPaid/ITRForm:AdvanceTax"/><br/>
    	 <xsl:value-of select="//ITRForm:TaxPaid/ITRForm:TaxesPaid/ITRForm:TDS"/><br/><br/>
    	  
    <xsl:value-of select="//ITRForm:TaxPaid/ITRForm:TaxesPaid/ITRForm:SelfAssessmentTax"/><br/>
      <xsl:value-of select="//ITRForm:TaxPaid/ITRForm:TaxesPaid/ITRForm:TotalTaxesPaid"/> 
    	   
      
     </span>
   </div>
    	</div>
        
       <div class="row">
       <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(9).&#160;&#160;Amount payable (Enter if 7 is greater than 8d, else enter 0)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:TaxPaid/ITRForm:BalTaxPayable"/></span></div>
       </div>
       </div>
       
        <div class="row">
        <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(10).&#160;&#160;Refund (If 8d is greater than 7)</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:value-of select="//ITRForm:Refund/ITRForm:RefundDue"/></span></div>
       </div>
       </div>
    	 
    	 <div class="row">
    	 <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(11).&#160;&#160;Enter your bank account number (mandatory and for direct
deposit of refund into bank, the number should be 11 digits or more</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
   <span> <xsl:value-of select="//ITRForm:Refund/ITRForm:BankAccountNumber"/></span> </span></div>
       </div>
       </div>
        <div class="row">
        <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			 
			<div class="col-xs-7">
    <div><span class="normallabel">(12).&#160;&#160;Do you want your refund by</span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
    <xsl:choose>
    <xsl:when test="//ITRForm:Refund/ITRForm:EcsRequired= 'Y'">
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>cheque,&#160;&#160; or 
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>deposited directly into your bank account? (tick as applicable  )
    </xsl:when>
    <xsl:otherwise>
       <img width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>cheque,&#160;&#160; or 
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>deposited directly into your bank account? (tick as applicable  )
    </xsl:otherwise>
    </xsl:choose>
   </span>
     </div>
       </div>
       </div>
        
         <div class="row">
          <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">(13).&#160;&#160;Give additional details of your bank account</span></div>
       </div></div>
       <div class="row">
		<div class="col-xs-1">
				<strong>&#160;</strong>
			  </div> 
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-left"><b class="bold">IFSCCode</b>&#160;&#160;
    <xsl:value-of select="//ITRForm:Refund/ITRForm:DepositToBankAccount/ITRForm:IFSCCode"/>
      </span>
      <span class="normaltext decimal pull-right">&#160;&#160;&#160;&#160;&#160;&#160;<b class="bold">Type of Account (tick as applicable )</b>&#160;&#160;
     </span></div></div>
      
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right">  
    <xsl:choose>
    <xsl:when test="//ITRForm:Refund/ITRForm:DepositToBankAccount/ITRForm:BankAccountType= 'SAV'">
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>Savings,&#160;&#160;  
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>Current
    </xsl:when>
    <xsl:otherwise>
       <img width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>Savings,&#160;&#160; 
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>Current
    </xsl:otherwise>
    </xsl:choose>
      </span>
      </div>
   </div>
       </div>
        
          <div class="row">
          <hr class="redline"/>
		<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-7">
    <div><span class="normallabel">14&#160;&#160;Do you have,-</span></div> 
    <div><span class="normaltext"><b class="bold">(i)&#160;&#160;any asset (including financial interest in any entity) located outside India or</b><br/></span></div>
        <div><span class="normaltext"><b class="bold">(ii)&#160;&#160;signing authority in any account located outside India?</b><br/></span></div>
       </div>
       
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"><br/><br/>
   <xsl:choose>
    <xsl:when test="//ITRForm:AssetOutIndiaFlag= 'YES'">
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>Yes,&#160;&#160;  
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>No
    </xsl:when>
    <xsl:otherwise>
       <img width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>Yes,&#160;&#160; 
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>No
    </xsl:otherwise>
    </xsl:choose>
   </span></div>
       </div>
       </div>
		 
		 <div class="row">
		  <hr class="redline"/>
		 	<div class="col-xs-1">
				<strong>&#160;</strong>
			</div>
			<div class="col-xs-4">
				<strong>&#160;</strong>
			</div>
		<div class="col-xs-7">
		<b class="boldsch">VERIFICATION</b>
			</div>
			</div>
		 
			<div class="row">
			   <div >
    <span class="normallabel">I,</span>
    <span class="normaltext"><xsl:value-of select="//ITRForm:AssesseeVerName"/> </span>
    <span class="normallabel">son/daughter of</span>
    <span class="normaltext"><xsl:value-of select="//ITRForm:FatherName"/> </span>
           <span class="normallabel">
           holding permanent account number&#160;&#160;</span> <span class="normaltext">
           <xsl:value-of select="//ITRForm:Verification/ITRForm:Declaration/ITRForm:AssesseeVerPAN"/>
           </span> <span class="normallabel">
           solemnly declare that to the best of my knowledge
        and belief,the information given in the return is corrected and complete and that the amount of total income and other particulars
         show therein are truly stated and are in accordance with the provisions of the income-tax Act 1961, in respect of income chargeable to Income-tax for the 
         previous year relevent to the Assessment year 2013-14. </span></div>
            </div>
            
            <div class="row">
		  <span class="normaltext"></span>
		 	<div class="col-xs-3">
				<span>Date</span>
			</div>
			<div class="col-xs-4">
				  <span class="normaltext"><xsl:value-of select="//ITRForm:Verification/ITRForm:Date"/> </span>
			</div></div>
			<div class="row">
		  
		 	<div class="col-xs-3">
				<span>Place </span>
			</div>
			<div class="col-xs-4">
			 <span class="normaltext"><xsl:value-of select="//ITRForm:Verification/ITRForm:Place"/> </span>
			</div>
			<div class="col-xs-4">
			 &#160; 
			</div>
			<div class="col-xs-4">
			<span class="normaltext pull-right">  
				 Sign Here 
				</span>
			</div>
			</div>
			 <hr class="redline"/>
			  <div class="sectionhead"><b class="boldsch">Schedule S - </b>Details of Income from Salary</div>
 <hr class="redline"/>
      <hr class="redline"/>
      <xsl:for-each select="//ITRForm:ScheduleS/ITRForm:Salaries">
     <div class="row">
     <div class="col-xs-6">
    <div><span class="normaltext decimal pull-left"><b class="bold">Name of Employer &#160;&#160;&#160;</b>
    <xsl:value-of select="ITRForm:NameOfEmployer"/>
      </span>
      </div></div>
       <div class="col-xs-9">
    <div><span class="normaltext decimal pull-left"><b class="bold">PAN of Employer (optional)&#160;&#160;&#160;</b>
   <xsl:value-of select="ITRForm:PANofEmployer"/>
      </span>
      </div>
      </div>
       </div>
      <hr class="redline"/>
     <div class="row">
       <div class="col-xs-6">
    <div><span class="normaltext decimal pull-left"><b class="bold">Address of employer</b> </span>
      </div>
      <div><span class="normaltext decimal pull-left">  <xsl:value-of select="ITRForm:AddressDetail/ITRForm:AddrDetail"/>
      </span>
      </div>
      </div>
       <div class="col-xs-9">
    <div><span class="normaltext decimal pull-left"><b class="bold">Town/City&#160;&#160;&#160;</b> </span>
      </div>
      <div><span class="normaltext decimal pull-left"> <xsl:value-of select="ITRForm:AddressDetail/ITRForm:CityOrTownOrDistrict"/>
       </span>
      </div>
    
      </div>
      
       </div>
   
     
        <hr class="redline"/>
     <div class="row">
   
       <div class="col-xs-6">
    <div><span class="normaltext decimal pull-left"><b class="bold">State</b> </span>
      </div>
      <div><span class="normaltext decimal pull-left">  <xsl:value-of select="ITRForm:AddressDetail/ITRForm:StateCode"/>
      </span>
      </div>
      </div>
       <div class="col-xs-9">
    <div><span class="normaltext decimal pull-left"><b class="bold">Pin code&#160;&#160;&#160;</b> </span>
      </div>
      <div><span class="normaltext decimal pull-left"> <xsl:value-of select="ITRForm:AddressDetail/ITRForm:PinCode"/>
       </span>
      </div>
    
      </div>
      
       </div>       
    
   <div class="row">
     <hr class="redline"/>
  
   <div class="col-xs-7">
    <div><span class="normallabel">(1).&#160;&#160; Salary (Excluding all exempt/ non-exempt allowances, perquisites)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Salarys/ITRForm:Salary"/></span></div>
       </div>
       </div>
       <div class="row">
     <hr class="redline"/>
  
   <div class="col-xs-7">
    <div><span class="normallabel">(2).&#160;&#160;Allowances exempt under section 10 (Not to be included in 7 below)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Salarys/ITRForm:AllowancesExemptUSection10"/></span></div>
       </div>
       </div>
          <div class="row">
     <hr class="redline"/>
  
   <div class="col-xs-7">
    <div><span class="normallabel">(3).&#160;&#160;Allowances not exempt (refer Form 16 from employer)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Salarys/ITRForm:AllowancesNotExempt"/></span></div>
       </div>
       </div>
        <div class="row">
     <hr class="redline"/>
  
   <div class="col-xs-7">
    <div><span class="normallabel">(4).&#160;&#160;Value of perquisites (refer Form 16 from employer)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Salarys/ITRForm:ValueOfPerquisites"/></span></div>
       </div>
       </div>
       
         <div class="row">
     <hr class="redline"/>
  
   <div class="col-xs-7">
    <div><span class="normallabel">(5).&#160;&#160;Profits in lieu of salary (refer Form 16 from employer)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Salarys/ITRForm:ProfitsinLieuOfSalary"/></span></div>
       </div>
       </div>
        <div class="row">
     <hr class="redline"/>
  
   <div class="col-xs-7">
    <div><span class="normallabel">(6).&#160;&#160;Deduction u/s 16 (Entertainment allowance by Government and tax on employment)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Salarys/ITRForm:ProfitsinLieuOfSalary"/></span></div>
       </div>
       </div>
       <hr class="redline"/>
       </xsl:for-each>
        <div class="row">
   <div class="col-xs-7">
    <div><span class="normallabel">(7).&#160;&#160;Income chargeable under the Head ‘Salaries’ (1+3+4+5-6)<Br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:TotIncUnderHeadSalaries"/></span></div>
       </div>
       </div>
       
         <!-- HERE SCHEDULE HP START -->
       <hr class="redline"/>
       			<div class="sectionhead"><b class="boldsch">Schedule HP - </b> Details of Income from Salary</div>
	<hr class="redline"/>
			   <hr class="redline"/>
			   <xsl:for-each select="//ITRForm:ScheduleHP/ITRForm:PropertyDetails">
			  <div class="row">
		   <div class="col-xs-6">
    <div><span class="normaltext decimal pull-left"><b class="bold">Address of property  &#160;&#160;&#160; <xsl:value-of select="ITRForm:HPSNo"/></b></span>
      </div>
      <div><span class="normaltext decimal pull-left"> <xsl:value-of select="ITRForm:AddressDetail/ITRForm:AddrDetail"/></span></div>
      </div>
       <div class="col-xs-9">
    <div><span class="normaltext decimal pull-left"><b class="bold">Town/City&#160;&#160;&#160;</b></span>
      </div>
      <div><span class="normaltext decimal pull-left"> <xsl:value-of select="ITRForm:AddressDetail/ITRForm:CityOrTownOrDistrict"/></span></div>
      </div>
       </div>
			
	 <hr class="redline"/>
			  <div class="row">
		 
       <div class="col-xs-6">
    <div><span class="normaltext decimal pull-left"><b class="bold">State</b> </span>
      </div>
      <div><span class="normaltext decimal pull-left">  <xsl:value-of select="ITRForm:AddressDetail/ITRForm:StateCode"/>
      </span>
      </div>
      </div>
       <div class="col-xs-9">
    <div><span class="normaltext decimal pull-left"><b class="bold">Pin code&#160;&#160;&#160;</b> </span>
      </div>
      <div><span class="normaltext decimal pull-left"> <xsl:value-of select="ITRForm:AddressDetail/ITRForm:PinCode"/>
       </span>
      </div>
    
      </div>
      
       </div>  		   
			 
			<div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-6">
    <div><span class="normallabel">&#160;&#160;Is the property co-owned?<br/></span></div>
       </div>
       <div class="col-xs-9">
    <div><span class="normaltext decimal pull-right"> 
    <xsl:choose>
    <xsl:when test="ITRForm:PropCoOwnedFlg = 'YES'">
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>Yes 
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>No
    </xsl:when>
    <xsl:otherwise>
       <img width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>Yes
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>No
    </xsl:otherwise>
    </xsl:choose>
    </span></div>
       </div>
       </div>
       <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-6">
    <div><span class="normallabel">&#160;&#160;Your percentage of share in the property.<br/></span></div>
       </div>
       <div class="col-xs-9">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:AsseseeShareProperty"/></span></div>
       </div>
       </div>
       <hr class="redline"/>
       <!-- NAME OF CO-OWNER START HERE -->
       
           
              <div class="row"> 
            <div class="col-xs-4 ">
				<div><span class="normallabel">Name of Co-owner(s)</span></div>
				 <xsl:for-each select="ITRForm:CoOwners">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:CoOwnersSNo"/>&#160;&#160;&#160;
				<xsl:value-of select="ITRForm:NameCoOwner"/> </span>
				</div>
			 </xsl:for-each>
			</div>
			 <div class="col-xs-6 ">
				<div><span class="normallabel">PAN of Co-owner (s) (optional )</span></div>
				 <xsl:for-each select="ITRForm:CoOwners">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:PAN_CoOwner"/></span></div>
				 </xsl:for-each>
			</div>
			 <div class="col-xs-9 ">
				<div><span class="normallabel">Percentage Share in Property</span></div>
				 <xsl:for-each select="ITRForm:CoOwners">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:PercentShareProperty"/></span></div>
				 </xsl:for-each>
			</div>
			
                </div>    
         <hr class="redline"/>
            <div class="row"> 
            <div class="col-xs-4 ">
				<div><span class="normallabel">(Tick) ? if let out</span></div>
				<div><span class="normaltext">
				 <xsl:choose>
    <xsl:when test="ITRForm:ifLetOut = 'Y'">
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>Yes 
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>No
    </xsl:when>
    <xsl:otherwise>
       <img width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>Yes
       <img  width="9px" height="9px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>No
    </xsl:otherwise>
    </xsl:choose>
				</span></div>
			 
			</div>
			 <div class="col-xs-6 ">
				<div><span class="normallabel">Name of Tenant</span></div>
				 
				<div><span class="normaltext"><xsl:value-of select="ITRForm:NameofTenant"/></span></div>
				 
			</div>
			 <div class="col-xs-9 ">
				<div><span class="normallabel">Percentage Share in Property</span></div>
				 
				<div><span class="normaltext"><xsl:value-of select="ITRForm:PANofTenant"/></span></div>
				 
			</div>
			
                </div>
       
       
       
        <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(a).&#160;&#160;Annual letable value or rent received or receivable (higher of the two, if let out for whole of
the year, lower of the two, if let out for part of the year)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:AnnualLetableValue"/></span></div>
       </div>
       </div>
       
         <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(b).&#160;&#160;The amount of rent which cannot be realized<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:RentNotRealized"/></span></div>
       </div>
       </div>
        <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(c).&#160;&#160;Tax paid to local authorities<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:LocalTaxes"/></span></div>
       </div>
       </div>
       
        <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(d).&#160;&#160;Total (2b + 2c)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:TotalUnrealizedAndTax"/></span></div>
       </div>
       </div>
       
       <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(e).&#160;&#160;Annual value (2a – 2d)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:BalanceALV"/></span></div>
       </div>
       </div><div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(f).&#160;&#160;30% of 2e<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:ThirtyPercentOfBalance"/></span></div>
       </div>
       </div><div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(g).&#160;&#160;Interest payable on borrowed capital<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:IntOnBorwCap"/></span></div>
       </div>
       </div><div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(h).&#160;&#160;Total (2f + 2g)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:TotalDeduct"/></span></div>
       </div>
       </div><div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(i).&#160;&#160;Income from house property 2 (2e – 2h)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="ITRForm:Rentdetails/ITRForm:IncomeOfHP"/></span></div>
       </div>
       </div>
       <hr class="redline"/>
        </xsl:for-each>
       <div class="row">
    	  <div class="col-xs-7">
         <div>
    <span class="normallabel">
   Income under the head “Income from house property<br/></span>
     </div>
       </div>
       </div>
        <div class="row">
       
    <div class="col-xs-7" ><span class="normaltext">
     
    <b class="bold">(a).&#160;&#160;Rent of earlier years realized under section 25A/AA&#160;&#160;</b><br/>
     <b class="bold">(b).&#160;&#160;Arrears of rent received during the year U/S 25B after deducting 30%</b><br/>
        <b class="bold">(c).&#160;&#160;Total (3a + 3b + 1i + 2i)</b> 
   </span>
    </div>
    <div class="col-xs-4">
				<span class="normaltext decimal pull-right">
       <xsl:value-of select="//ITRForm:RentOfEarlierYrSec25AandAA"/><br/>
    	 <xsl:value-of select="//ITRForm:RentArearsSec25BAfter30pcDeduct"/><br/>
    	  
    <xsl:value-of select="//ITRForm:TotalIncomeChargeableUnHP"/><br/>
      
     </span>
   </div>
    	</div>
    	
    	
    	<!-- ITR3 field start...... -->
    	
			   <div class="row">
    	<hr class="redline"/>
    	 <div class="sectionhead"><b class="boldsch">Schedule IF - </b>  Information regarding partnership firms in which you are partner</div>
             </div>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">Name of the Firm </span></div>
			<xsl:for-each select="//ITRForm:ScheduleIF/ITRForm:PartnerFirmDetails">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:FirmName"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-3 ">
			 <div><span class="smalllabel">PAN of the firm </span></div>
			 <xsl:for-each select="//ITRForm:ScheduleIF/ITRForm:PartnerFirmDetails">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:FirmPAN"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-3">
				<div><span class="smalllabel">Percentage Share in the profit of the firm</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleIF/ITRForm:PartnerFirmDetails">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:ProfitSharePercent"/></span></div>
			</xsl:for-each>
			</div>	
			 <div class="col-xs-5 ">
				    <div><span class="smalllabel">Amount of share in the profit </span></div>
				    <xsl:for-each select="//ITRForm:ScheduleIF/ITRForm:PartnerFirmDetails">
			        <div><span class="normaltext"><xsl:value-of select="ITRForm:ProfitShareAmt"/></span></div>
			   </xsl:for-each>
			    </div>
               <div class="col-xs-7 ">
				 <div><span class="smalllabel">Capital balance on 31st March in the firm</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleIF/ITRForm:PartnerFirmDetails">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:FirmCapBalOn31Mar"/></span></div>
				 </xsl:for-each>
			 </div> 
            </div>     
       
        <div class="row">
    	<hr class="redline"/>
    	 <div class="sectionhead"> <b class="boldsch">Schedule BP - </b> Details of Income from Firms of which partner</div>
             </div>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">Firm PAN (From Schedule-IF)i </span></div>
			<xsl:for-each select="//ITRForm:ScheduleBPA/ITRForm:PartnerFirmIncomes">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:FirmPAN"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-4 ">
			 <div><span class="smalllabel">Salary, bonus,commission or remuneration received from the firm ii </span></div>
			 <xsl:for-each select="//ITRForm:ScheduleBPA/ITRForm:PartnerFirmIncomes">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:FirmSalBonComRen"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-3">
				<div><span class="smalllabel">Interest received from the firm on the capital iii</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleBPA/ITRForm:PartnerFirmIncomes">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:IntFirmCap"/></span></div>
			</xsl:for-each>
			</div>	
			 <div class="col-xs-3 ">
				    <div><span class="smalllabel">Total ii + iii(iv) </span></div>
				    <xsl:for-each select="//ITRForm:ScheduleBPA/ITRForm:PartnerFirmIncomes">
			        <div><span class="normaltext"><xsl:value-of select="ITRForm:TotalIncome"/></span></div>
			   </xsl:for-each>
			    </div>
               <div class="col-xs-5 ">
				 <div><span class="smalllabel">Expenses in relation to iv(v)</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleBPA/ITRForm:PartnerFirmIncomes">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:Expenses"/></span></div>
				 </xsl:for-each>
			 </div>
			   <div class="col-xs-7 ">
				 <div><span class="smalllabel">Net Income iv - v(vi)</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleBPA/ITRForm:PartnerFirmIncomes">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:NetIncome"/></span></div>
				 </xsl:for-each>
			 </div>  
            </div> 
            <!-- ITR3 field end -->
             <div class="row">
            <hr class="redline"/>
            </div>
            <div class="sectionhead"><b class="boldsch">Schedule VIA - </b> Deductions under Chapter VI-A (Section)</div>
            <div class="row">
			<div class="col-xs-4">
			 <span class="normaltext"><strong>a &#160;</strong></span>
				<span class="normallabel">80C &#160;</span>
				<span class="normaltext">	
					<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80C"/>
				</span>
			</div>
			<div class="col-xs-4">
			<span class="normaltext"><strong>b &#160;</strong></span>
				<span class="normallabel">80CCC &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80CCC"/></span>
			</div>
				
			<div class="col-xs-5">
			<span class="normaltext"><strong>c &#160;</strong></span>
				<span class="normallabel">80CCD(1) &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80CCDEmployeeOrSE"/></span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>d &#160;</strong></span>
				<span class="normallabel">80CCD(2) &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80CCDEmployer"/></span>
			</div>
			<div class="col-xs-4">
			<span class="normaltext"><strong>e &#160;</strong></span>
				<span class="normallabel">80CCG &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80CCG"/></span>
			</div>
			<div class="col-xs-4">
			<span class="normaltext"><strong>f &#160;</strong></span>
				<span class="normallabel">80D &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80D"/></span>
			</div>
		</div>				
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>g &#160;</strong></span>
				<span class="normallabel">80DD &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80DD"/></span>
			</div>
			<div class="col-xs-4">
			<span class="normaltext"><strong>h &#160;</strong></span>
				<span class="normallabel">80DDB &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80DDB"/></span>
			</div>
			<div class="col-xs-4">
			<span class="normaltext"><strong>i &#160;</strong></span>
				<span class="normallabel">80E &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80E"/></span>
			</div>
		</div>		
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>j &#160;</strong></span>
				<span class="normallabel">80G &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80G"/></span>
			</div>
			<div class="col-xs-4">
			<span class="normaltext"><strong>k &#160;</strong></span>
				<span class="normallabel">80GG &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80GG"/></span>
			</div>
			<div class="col-xs-4">
			<span class="normaltext"><strong>l &#160;</strong></span>
				<span class="normallabel">80GGA &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:Section80GGA"/></span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>m &#160;</strong></span>
				<span class="normallabel">80GGC &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80ggc']/@mootlywcm:investment)"/></span>
			</div>
			<div class="col-xs-4">
			<span class="normaltext"><strong>n &#160;</strong></span>
				<span class="normallabel">80RRB &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80rrb']/@mootlywcm:investment)"/></span>
			</div>
			<div class="col-xs-5">
			<span class="normaltext"><strong>o &#160;</strong></span>
				<span class="normallabel">80QQB &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80qqb']/@mootlywcm:investment)"/></span>
			</div>
		</div>	
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>p &#160;</strong></span>
				<span class="normallabel">80TTA &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80dd']/@mootlywcm:investment)"/></span>
			</div>
			<div class="col-xs-8 col-offset-4">
			<span class="normaltext"><strong>q &#160;</strong></span>
				<span class="normallabel">80U &#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//deductiondocument/mootlywcm:deductiondocumentdetail[@mootlywcm:Section='80u']/@mootlywcm:investment)"/></span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-5">
			<span class="normaltext"><strong>r &#160;</strong></span>
				<span class="normallabel">Total Deductions (Add item a to q) &#160;&#160;&#160;&#160;&#160;</span>
				<span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:DeductUndChapVIA/ITRForm:TotalChapVIADeductions"/></span>
			</div>
			</div>
            
              <hr class="redline"/> 
            <div class="sectionhead"><b class="boldsch">Schedule 80G - </b>Details of donations entitled for deduction under section 80G</div>
          <hr class="redline"/>
         <xsl:choose> 
           <xsl:when test="//mootlywcm:deductiondocumentdetail/@mootlywcm:head ='NoAppr100'">
           <div>
            <span class="normaltext"><b class="boldsch">(A)</b> &#160;</span> 
			<span class="normalhead">Donations entitled for 100% deduction without qualifying limit</span>
			</div>
            <div class="row">
               
               <div class="col-xs-3 ">
				<div><span class="normallabel">Name and address of donee</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100Percent">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DoneeWithPanName"/></span></div>
                </xsl:for-each>
			  </div>
			 <div class="col-xs-3 ">
				<div><span class="normallabel">PAN of Donee</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100Percent">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DoneePAN "/></span></div>
				</xsl:for-each>
				</div>
			 <div class="col-xs-5 ">
				<div><span class="normallabel">Amount of donation</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100Percent">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DonationAmt"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-8 ">
				<div><span class="normallabel">Eligible Amount of donation</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100Percent">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:EligibleDonationAmt"/></span></div>
		        </xsl:for-each>
             </div>
             </div>
             <div class="row">
             <div class="col-xs-6 ">
             <span class="normallabel">Total&#160;&#160;&#160;&#160;</span>
             <xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100Percent">
             <span class="normaltext"><xsl:value-of select="ITRForm:TotDon100Percent"/></span>
             </xsl:for-each>
             </div>
             </div>
             </xsl:when> 
             </xsl:choose> 
             <xsl:choose>
          <xsl:when test="//mootlywcm:deductiondocumentdetail/@mootlywcm:head ='NoAppr50'">
           <div>
            <span class="normaltext"><b class="boldsch">(B)</b> &#160;</span> 
			<span class="normalhead">Donations entitled for 50% deduction without qualifying limit</span>
			</div>
            <div class="row">
               
               <div class="col-xs-3 ">
				<div><span class="normallabel">Name and address of donee</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentNoApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DoneeWithPanName"/></span></div>
                </xsl:for-each>
			  </div>
			 <div class="col-xs-3 ">
				<div><span class="normallabel">PAN of Donee</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentNoApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DoneePAN "/></span></div>
				</xsl:for-each>
				</div>
			 <div class="col-xs-5 ">
				<div><span class="normallabel">Amount of donation</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentNoApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DonationAmt"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-8 ">
				<div><span class="normallabel">Eligible Amount of donation</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentNoApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:EligibleDonationAmt"/></span></div>
		        </xsl:for-each>
             </div>
             </div>
             <div class="row">
             <div class="col-xs-6 ">
             <span class="normallabel">Total&#160;&#160;&#160;&#160;</span>
             <xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentNoApprReqd">
             <span class="normaltext"><xsl:value-of select="ITRForm:TotDon50PercentNoApprReqd"/></span>
             </xsl:for-each>
             </div>
             </div> 
            </xsl:when>
             </xsl:choose>
            <xsl:choose>
           <xsl:when test="//mootlywcm:deductiondocumentdetail/@mootlywcm:head ='Appr100'">
           <div>
            <span class="normaltext"><b class="boldsch">(C)</b> &#160;</span> 
			<span class="normalhead">Donations entitled for 100% deduction subject to qualifying limit</span>
			</div>
            <div class="row">
               
               <div class="col-xs-3 ">
				<div><span class="normallabel">Name and address of donee</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100PercentApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DoneeWithPanName"/></span></div>
                </xsl:for-each>
			  </div>
			 <div class="col-xs-3 ">
				<div><span class="normallabel">PAN of Donee</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100PercentApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DoneePAN "/></span></div>
				</xsl:for-each>
				</div>
			 <div class="col-xs-5 ">
				<div><span class="normallabel">Amount of donation</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100PercentApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DonationAmt"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-8 ">
				<div><span class="normallabel">Eligible Amount of donation</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100PercentApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:EligibleDonationAmt"/></span></div>
		        </xsl:for-each>
             </div>
             </div>
             <div class="row">
             <div class="col-xs-6 ">
             <span class="normallabel">Total&#160;&#160;&#160;&#160;</span>
             <xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don100PercentApprReqd">
             <span class="normaltext"><xsl:value-of select="ITRForm:TotDon100PercentApprReqd"/></span>
             </xsl:for-each>
             </div>
             </div> 
            </xsl:when>
            </xsl:choose>
             <xsl:choose> 
             <xsl:when test="//mootlywcm:deductiondocumentdetail/@mootlywcm:head ='Appr50'">
             <div>
            <span class="normaltext"><b class="boldsch">(D)</b> &#160;</span> 
			<span class="normalhead">Donations entitled for 50% deduction subject to qualifying limit</span>
			</div>
            <div class="row">
               
               <div class="col-xs-3 ">
				<div><span class="normallabel">Name and address of donee</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DoneeWithPanName"/></span></div>
                </xsl:for-each>
			  </div>
			 <div class="col-xs-3 ">
				<div><span class="normallabel">PAN of Donee</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DoneePAN "/></span></div>
				</xsl:for-each>
				</div>
			 <div class="col-xs-5 ">
				<div><span class="normallabel">Amount of donation</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:DonationAmt"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-8 ">
				<div><span class="normallabel">Eligible Amount of donation</span></div>
				<xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentApprReqd">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DoneeWithPan/ITRForm:EligibleDonationAmt"/></span></div>
		        </xsl:for-each>
             </div>
             </div>
             <div class="row">
             <div class="col-xs-6 ">
             <span class="normallabel">Total&#160;&#160;&#160;&#160;</span>
             <xsl:for-each select="//ITRForm:Schedule80G/ITRForm:Don50PercentApprReqd">
             <span class="normaltext"><xsl:value-of select="ITRForm:TotDon50PercentApprReqd"/></span>
             </xsl:for-each>
             </div>
             </div>
             </xsl:when>
            </xsl:choose> 
              <div class="row">
             <div class="col-xs-6 ">
             <span class="normalhead">Total donations(A+B+C+D)&#160;&#160;&#160;&#160;</span>
             <xsl:for-each select="//ITRForm:Schedule80G">
             <span class="normaltext"><xsl:value-of select="ITRForm:TotalDonationsUs80G"/></span>
             </xsl:for-each>
             </div>
             </div>  
             <div class="row">
    	<hr class="redline"/>
    	 <div class="sectionhead"><b class="boldsch">Schedule SPI - </b>Income of specified persons(spouse, minor child etc) includable in income of the assessee</div>
             </div>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">Name of person</span></div>
			<xsl:for-each select="//ITRForm:ScheduleSPI/ITRForm:SpecifiedPerson">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:SpecifiedPersonName"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-3 ">
			 <div><span class="smalllabel">PAN of person (optional) </span></div>
			 <xsl:for-each select="//ITRForm:ScheduleSPI/ITRForm:SpecifiedPerson">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:PANofSpecPerson"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-3">
				<div><span class="smalllabel">Relationship</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleSPI/ITRForm:SpecifiedPerson">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:ReltnShip"/></span></div>
			</xsl:for-each>
			</div>	
			 <div class="col-xs-6 ">
				    <div><span class="smalllabel">Nature of Income </span></div>
				    <xsl:for-each select="//ITRForm:ScheduleSPI/ITRForm:SpecifiedPerson">
			        <div><span class="normaltext"><xsl:value-of select="ITRForm:NatureOfInc"/></span></div>
			   </xsl:for-each>
			    </div>
               <div class="col-xs-6 ">
				 <div><span class="smalllabel">Amount (Rs)</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleSPI/ITRForm:SpecifiedPerson">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:AmtIncluded"/></span></div>
				 </xsl:for-each>
			 </div> 
            </div> 
             <hr class="redline"/>
			<div class="sectionhead"><b class="boldsch">Schedule EI - </b>&#160;&#160;Details of Exempt Income (Income not to be included in Total Income)</div>
            <div class="row">
    	<hr class="redline"/>
			<div class="col-xs-7">
    <div><span class="normallabel">(1).&#160;&#160;Interest income <br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:ScheduleEI/ITRForm:InterestInc"/></span></div>
       </div>
       </div>
       <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(2).&#160;&#160;Dividend income<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:ScheduleEI/ITRForm:DividendInc"/></span></div>
       </div>
       </div>
          <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(3)&#160;&#160;Long-term capital gains on which Securities Transaction Tax is paid<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:ScheduleEI/ITRForm:LTCGWhereSTTPaid"/></span></div>
       </div>
       </div>
        <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(4)&#160;&#160;Net Agriculture income /any other income for rate purpose<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:ScheduleEI/ITRForm:NetAgriIncOrOthrIncRule7"/></span></div>
       </div>
       </div>
       
         <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(5)&#160;&#160;Share in the profit of firm/AOP etc.<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:ScheduleEI/ITRForm:ShareOfProfitFirmAOP"/></span></div>
       </div>
       </div>
        <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(6).&#160;&#160;Others<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:ScheduleEI/ITRForm:Others"/></span></div>
       </div>
       </div>
            <div class="row">
    	<hr class="redline"/>
		
			<div class="col-xs-7">
    <div><span class="normallabel">(7).&#160;&#160;Total (1+2+3+4+5+6)<br/></span></div>
       </div>
       <div class="col-xs-7">
    <div><span class="normaltext decimal pull-right"> 
     <xsl:value-of select="//ITRForm:ScheduleEI/ITRForm:TotalExemptInc"/></span></div>
       </div>
       </div>
             <hr class="redline"/> 
            <div class="sectionhead"><b class="boldsch">Schedule IT - </b> Details of Advance Tax and Self Assessment Tax Payments of Income-tax</div> 
             <div class="row"> 
            <div class="col-xs-4 ">
				<div><span class="normallabel">BSR CODE</span></div>
				<xsl:for-each select="//ITRForm:ScheduleIT/ITRForm:TaxPayment">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:BSRCode"/></span></div>
                </xsl:for-each>
			  </div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">DATE OF DEPOSIT</span></div>
				<xsl:for-each select="//ITRForm:ScheduleIT/ITRForm:TaxPayment">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DateDep "/></span></div>
				</xsl:for-each>
				</div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">CHALLAN NO</span></div>
				<xsl:for-each select="//ITRForm:ScheduleIT/ITRForm:TaxPayment">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:SrlNoOfChaln"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-5 ">
				<div><span class="normallabel">TAX PAID</span></div>
				<xsl:for-each select="//ITRForm:ScheduleIT/ITRForm:TaxPayment">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:Amt"/></span></div>
		        </xsl:for-each>
             </div>
             </div>
             <div class="row">
             <hr class="redline"/> 
            <div class="sectionhead"><b class="boldsch">Schedule TDS1 - </b>  Details of Tax Deducted at Source from Salary [As per Form 16 issued by Employer(s)]</div> 
             </div>    
              <div class="row"> 
            <div class="col-xs-4 ">
				<div><span class="normallabel">TAN</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleTDS1/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:TAN"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">NAME OF THE EMPLOYER</span></div>
				<xsl:for-each select="//ITRForm:ScheduleTDS1/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:EmployerOrDeductorOrCollecterName"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-7 ">
				<div><span class="normallabel">INCOME UNDER SALARY</span></div>
				<xsl:for-each select="//ITRForm:ScheduleTDS1/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:IncChrgSal"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-9 ">
				<div><span class="normallabel">TAX DEDUCTED</span></div>
				<xsl:for-each select="//ITRForm:ScheduleTDS1/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:TotalTDSSal"/></span></div>
				</xsl:for-each>
			   </div>
                </div> 
                <div class="row">
               <span class="normaltext">&#160;&#160;&#160;&#160;</span>
               </div>
                <div class="row">
               <span class="normaltext">&#160;&#160;&#160;&#160;</span>
               </div>
                <div class="row">
               <span class="normaltext">&#160;&#160;&#160;&#160;</span>
               </div>
             <div class="row">
             <hr class="redline"/> 
            <div class="sectionhead"><b class="boldsch">Schedule TDS2 - </b>Details of Tax Deducted at Source on Income [As per Form 16 A issued by Deductor(s)]</div>
             </div>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">TAN </span></div>
			<xsl:for-each select="//ITRForm:ScheduleTDS2/ITRForm:TDSonOthThanSal">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:TAN"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-3 ">
			 <div><span class="smalllabel">Name of the Deductor </span></div>
			 <xsl:for-each select="//ITRForm:ScheduleTDS2/ITRForm:TDSonOthThanSal">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:EmployerOrDeductorOrCollecterName"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-3">
				<div><span class="smalllabel">Unique TDS Certificate Number </span></div>
				<div><span class="normaltext"><xsl:value-of select="//tdsfromothersdocument/mootlywcm:tdsothersdetail/@mootlywcm:tdscertificate"/></span></div>
			</div>	
			 <div class="col-xs-3 ">
				    <div><span class="smalllabel">Deducted Year </span></div>
			        <div><span class="normaltext"><xsl:value-of select="//tdsfromothersdocument/mootlywcm:tdsothersdetail/@mootlywcm:financialyear"/></span></div>
			    </div>
               <div class="col-xs-4 ">
				 <div><span class="smalllabel">Total Tax Deducted </span></div>
				 <xsl:for-each select="//ITRForm:ScheduleTDS2/ITRForm:TDSonOthThanSal">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:TotTDSOnAmtPaid"/></span></div>
				 </xsl:for-each>
				</div> 
              <div class="col-xs-10">
				<div><span class="smalllabel">Amount out of claimed This Year </span></div>
				<xsl:for-each select="//ITRForm:ScheduleTDS2/ITRForm:TDSonOthThanSal">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:ClaimOutOfTotTDSOnAmtPaid"/></span></div>
				 </xsl:for-each>
             </div>
         </div>  
         
           <div class="row">
           <hr class="redline"/> 
            <div class="sectionhead"><b class="boldsch">Schedule TR - </b> Details of Tax Relief claimed under section 90 or section 90A or section 91</div>
             </div>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">Country Name</span></div>
			<xsl:for-each select="//ITRForm:ScheduleTR1/ITRForm:ScheduleTR">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:CountryName"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-3 ">
			 <div><span class="smalllabel">Country Code </span></div>
			 <xsl:for-each select="//ITRForm:ScheduleTR1/ITRForm:ScheduleTR">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:CountryCode"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-4">
				<div><span class="smalllabel">Tax Identification number of the tax payer in respective country</span></div>
				<div><span class="normaltext"><xsl:value-of select="//ITRForm:ScheduleTR1/ITRForm:ScheduleTR/ITRForm:TaxIdentificationNo"/></span></div>
			</div>	
			 <div class="col-xs-3 ">
				    <div><span class="smalllabel">Income (in rupees) </span></div>
			        <div><span class="normaltext"><xsl:value-of select="//ITRForm:ScheduleTR1/ITRForm:ScheduleTR/ITRForm:RelavantArticleDTAA"/></span></div>
			    </div>
               <div class="col-xs-4 ">
				 <div><span class="smalllabel">Tax Paid (in rupees) </span></div>
				 <xsl:for-each select="//ITRForm:ScheduleTR1/ITRForm:ScheduleTR">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:TotalTaxpaid"/></span></div>
				 </xsl:for-each>
				</div> 
              <div class="col-xs-8">
				<div><span class="smalllabel">Total Tax Relief Claimed (in rupees) </span></div>
				<xsl:for-each select="//ITRForm:ScheduleTR1/ITRForm:ScheduleTR/ITRForm:TotTaxreliefClaimed">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:ReliefClaimed90Or90A"/></span></div>
				 </xsl:for-each>
             </div>
         </div>
          <div class="row">
    	<hr class="redline"/>
    	 <div class="sectionhead"><b class="boldsch">Schedule FA - </b>Details of Foreign Assets</div>
             </div>
              <div>
              <hr class="redline"/>
            <span class="normaltext"><b class="boldsch">(A)</b> &#160;</span> 
			<span class="normallabel">Details of Foreign Bank Accounts</span>
			</div>
			<hr class="redline"/>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">Country Name</span></div>
			<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsForiegnBank">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:CountryName"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-2 ">
			 <div><span class="smalllabel">Country Code </span></div>
			 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsForiegnBank">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:CountryCode"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-4">
				<div><span class="smalllabel">Name and Address of the Bank</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsForiegnBank">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:Bankname"/><xsl:value-of select="ITRForm:AddressOfBank"/></span></div>
			</xsl:for-each>
			</div>	
			 <div class="col-xs-6 ">
				    <div><span class="smalllabel">Name mentioned in the account </span></div>
				    <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsForiegnBank">
			        <div><span class="normaltext"><xsl:value-of select="ITRForm:NameAsInAccount" /></span></div>
			   </xsl:for-each>
			    </div>
               <div class="col-xs-8 ">
				 <div><span class="smalllabel">Peak Balance During the Year(in rupees)</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsForiegnBank">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:PeakBalanceDuringYear"/></span></div>
				 </xsl:for-each>
			 </div> 
            </div> 
          <div>
              <hr class="redline"/>
            <span class="normaltext"><b class="boldsch">(B)</b> &#160;</span> 
			<span class="normallabel">Details of Financial Interest in any Entity</span>
			</div>
			<hr class="redline"/>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">Country Name</span></div>
			<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsFinancialInterest">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:CountryName"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-2 ">
			 <div><span class="smalllabel">Country Code </span></div>
			 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsFinancialInterest">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:CountryCode"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-4">
				<div><span class="smalllabel">Nature of entity</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsFinancialInterest">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:NatureOfEntity"/></span></div>
			</xsl:for-each>
			</div>	
			 <div class="col-xs-6 ">
				    <div><span class="smalllabel">Name and Address of the Entity </span></div>
				    <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsFinancialInterest">
			        <div><span class="normaltext"><xsl:value-of select="ITRForm:NameOfEntity" /><xsl:value-of select="ITRForm:AddressOfEntity" /></span></div>
			   </xsl:for-each>
			    </div>
               <div class="col-xs-8 ">
				 <div><span class="smalllabel">Total Investment (at cost) (in rupees)</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsFinancialInterest">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:TotalInvestment"/></span></div>
				 </xsl:for-each>
			 </div> 
            </div>
             <div>
              <hr class="redline"/>
            <span class="normaltext"><b class="boldsch">(C)</b> &#160;</span> 
			<span class="normallabel">Details of Immovable Property</span>
			</div> 
			<hr class="redline"/>
			 <div class="row"> 
            <div class="col-xs-3 ">
				<div><span class="normallabel">Country Name</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsImmovableProperty">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:CountryName"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-3 ">
				<div><span class="normallabel">Country Code</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsImmovableProperty">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:CountryCode"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-6 ">
				<div><span class="normallabel">Address of the Property</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsImmovableProperty">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:AddressOfProperty"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-9 ">
				<div><span class="normallabel">Total Investment (at cost) (in rupees)</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsImmovableProperty">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:TotalInvestment"/></span></div>
				</xsl:for-each>
			   </div>
                </div>
             <div>    
             <hr class="redline"/>
            <span class="normaltext"><b class="boldsch">(D)</b> &#160;</span> 
			<span class="normallabel">Details of any other Asset</span>
			</div> 
			<hr class="redline"/>
			 <div class="row"> 
            <div class="col-xs-3 ">
				<div><span class="normallabel">Country Name</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsOthAssets">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:CountryName"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-3 ">
				<div><span class="normallabel">Country Code</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsOthAssets">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:CountryCode"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">Nature of Asset</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsOthAssets">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:NatureOfAsset"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-9 ">
				<div><span class="normallabel">Total Investment (at cost) (in rupees)</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsOthAssets">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:TotalInvestment"/></span></div>
				</xsl:for-each>
			   </div>
                </div>  
                   <div>    
             <hr class="redline"/>
            <span class="normaltext"><b class="boldsch">(E) </b>&#160;</span> 
			<span class="normallabel">Details of account(s) in which you have signing authority and which has not been included in A to D above.</span>
			</div> 
			<hr class="redline"/>
			 <div class="row"> 
            <div class="col-xs-4 ">
				<div><span class="normallabel">Name of the Institution in which the account is held</span></div>
				 <xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsOfAccntsHvngSigningAuth">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:NameOfInstitution"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-3 ">
				<div><span class="normallabel">Address of the Institution</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsOfAccntsHvngSigningAuth">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:AddressOfInstitution"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">Name mentioned in the account</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsOfAccntsHvngSigningAuth">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:NameMentionedInAccnt"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-9 ">
				<div><span class="normallabel">Peak Balance/Investment during the year (in rupees)</span></div>
				<xsl:for-each select="//ITRForm:ScheduleFA/ITRForm:DetailsOfAccntsHvngSigningAuth">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:PeakBalanceOrInvestment"/></span></div>
				</xsl:for-each>
			   </div>
                </div>                             
		</xsl:template>
		<!-- ITR4S START HERE -->
		<xsl:template name="partB-ITR4S">
		<div class="sectionhead"><b class="boldsch">PART B -</b> GROSS TOTAL INCOME </div>
		<div class="row">
			<div class="col-xs-1">
				<strong>B1</strong>
			</div>
			<div class="col-xs-7 normallabel">Income from Business</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ITR4S_IncomeDeductions/ITRForm:IncomeFromBusinessProf"/></div>
		</div>
		<div class="row">
		<div class="col-xs-1">
				<strong>B2</strong>
			</div>
			<div class="col-xs-7 normallabel">Income from Salary/Pension</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ITR4S_IncomeDeductions/ITRForm:IncomeFromSal"/></div>
		</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>B3</strong>
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
				<span class="normaltext decimal pull-right"><xsl:number grouping-size="3" grouping-separator=","  value="sum(//houseproperty/mootlywcm:houseincomedetail/@mootlywcm:Income_hproperty)"/></span>
			</div>
		</div>		
		<div class="row">
			<div class="col-xs-1">
				<strong>B4</strong>
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
		       <div class="row">
			<div class="col-xs-1">
				<strong>B5</strong>
			</div>
			<div class="col-xs-7">
				<span class="normallabel">Gross Total Income(B1+B2+B3+B4)</span>
			</div>
			<div class="col-xs-4">
				<span class="normaltext">
				 <span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ITR4S_IncomeDeductions/ITRForm:GrossTotIncome"/></span>
				</span>	
			</div>						
		 </div>
		
		</xsl:template>
		<!-- ITR4S end here -->
</xsl:stylesheet>