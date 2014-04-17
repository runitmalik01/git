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
	
	<xsl:template name="partD">
		<xsl:variable name="theITRForm" select="//memberpersonalinformation/@flex_string_ITRForm"/>
		<xsl:choose>
			<xsl:when test="$theITRForm = 'ITR1'">
			 	<xsl:call-template name="partD-TaxComputation"/>
			</xsl:when>
			<xsl:when test="$theITRForm = 'ITR4S'">
			 	<xsl:call-template name="partD-4STaxComputation"/>
			</xsl:when>
		<xsl:otherwise>
			</xsl:otherwise>
		</xsl:choose>
		
		<!-- CHAPTER 6 FIRS -->
		 <!--   <div class="container pbf"> -->
		<!--    <div class="sectionhead">PART D - TAX COMPUTATION AND TAX STATUS </div> -->
		<!--  PART D -->
		<!-- 	<xsl:call-template name="partD-TaxComputation"/>													
	      </div> -->							
	</xsl:template>
	
	<xsl:template name="partD-TaxComputation">
	<div class="sectionhead"><b class="boldsch">PART D - </b>TAX COMPUTATION AND TAX STATUS </div>
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>D1 </strong></span>
				<span class="normallabel">Tax Payable On Total Income</span>
				<div>
					<span class="normaltext">	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:TotalTaxPayable"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normaltext"><strong>D2</strong></span>
				<span class="normallabel">Secondary &amp; Higher Education Cess</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:EducationCess"/></span></div>
			</div>
			<div class="col-xs-8">
			<span class="normaltext"><strong>D3</strong></span>
				<span class="normallabel">TOTAL TAX AND CESS(D1+D2)</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:GrossTaxLiability"/></span></div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>D4</strong></span>
				<span class="normallabel">Relief u/s 89</span>
				<div>
					<span class="normaltext">	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:Section89"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normaltext"><strong>D5</strong></span>
				<span class="normallabel">Balance tax After Relief(D3-D4)</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:NetTaxLiability"/></span></div>
			</div>
			<div class="col-xs-8">
			<span class="normaltext"><strong>D6</strong></span>
				<span class="normallabel">Total Interest u/s 234A</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:IntrstPayUs234A"/></span></div>
			 </div>
		  </div>
		
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>D7</strong></span>
				<span class="normallabel">Total Interest u/s 234B</span>
				<div>
					<span class="normaltext">	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:IntrstPayUs234B"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normaltext"><strong>D8</strong></span>
				<span class="normallabel">Total Interest u/s 234C</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:IntrstPayUs234C"/></span></div>
			</div>
			<div class="col-xs-8">
			<span class="normaltext"><strong>D9</strong></span>
				<span class="normallabel">Total Tax And Interest(D5+D6+D7+D8)</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:TotTaxPlusIntrstPay"/></span></div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>D10</strong></span>
				<span class="normallabel">Total Advance Tax Paid</span>
				<div>
					<span class="normaltext">	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:AdvanceTax"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normaltext"><strong>D11</strong></span>
				<span class="normallabel">Total Self Assessment Tax Paid</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:SelfAssessmentTax"/></span></div>
			</div>
			<div class="col-xs-8">
			<span class="normaltext"><strong>D12</strong></span>
				<span class="normallabel">Total TDS claimed</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:TDS"/></span></div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-4">
			<span class="normaltext"><strong>D13</strong></span>
				<span class="normallabel">Total Prepaid Taxes(D10+D11+D12)</span>
				<div>
					<span class="normaltext">	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:TotalTaxesPaid"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normaltext"><strong>D14</strong></span>
				<span class="normallabel">total Payable(D9-D13,If D9>D13)</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:BalTaxPayable"/></span></div>
			</div>
			<div class="col-xs-8">
				<span class="normallabel">Refund(D13-D9,If D13>D9)</span>
				<div><span class="normaltext"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:RefundDue"/></span></div>
			</div>
		</div>
		<div class="row">
		<hr class="redline"/>
			<div class="col-xs-7">
				<span class="normallabel">Bank Account Details(Mandatory in all cases irrespective of refund due or not)</span>
		</div>
		</div>
		<div class="row">
			<div class="col-xs-6">
				<span class="normallabel">ACCOUNT NO</span>
				<span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:accNumber"/></span>
			</div>
			 <div class="col-xs-7">
            <span class="normallabel">Type of account</span>
            <span class="normaltext">
              <xsl:choose>
              <xsl:when test="//memberpersonalinformation/@mootlywcm:typeAcc = 'CUR'">
               <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>current 
              <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>saving
             </xsl:when>
               <xsl:when test="//memberpersonalinformation/@mootlywcm:typeAcc = 'SAV'">
              <img width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>current
               <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>saving
                </xsl:when>
             </xsl:choose>
            </span>
            </div>
           </div>
	
		<div class="row">
			<div class="col-xs-6">
				<span class="normallabel">IFSC CODE</span>
				<span class="normaltext"><xsl:value-of select="//ITRForm:IFSCCode"/> </span>
			</div>
			 <div class="col-xs-7">
            <span class="normallabel">Fill Only One:Refund by </span>
            <span class="normaltext">
              <xsl:choose>
              <xsl:when test="//ITRForm:EcsRequired = 'N'">
               <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>check 
              <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>deposited directly your bank account            
               </xsl:when>
               <xsl:otherwise>
              <img width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>check
               <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>deposited directly your bank account
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
            <div class="col-xs-4">
                <strong>&#160;</strong>
             </div>
		   <div class="col-xs-6">
			<b class="boldsch">	<span class="normallabel"><b class="boldsch">VERIFICATION </b></span></b>
           </div>
           </div>
           <div class="row">
			<div >
				<span class="normallabel">I,</span>
				<span class="normaltext"><xsl:value-of select="//ITRForm:AssesseeVerName"/> </span>
				<span class="normallabel">son/daughter of</span>
				<span class="normaltext"><xsl:value-of select="//ITRForm:FatherName"/> </span>
          	<span class="normallabel">solemnly declare that to the best of my knowledge
		      and belief,the information given in the return is corrected and complete and that the amount of total income and other particulars
		       show therein are truly stated and are in accordance with the provisions of the income-tax Act 1961, in respect of income chargeable to Income-tax for the 
		       previous year relevent to the Assessment year 2013-14. </span></div>
            </div> 
           <hr class="redline"/> 
            <div class="sectionhead"><b class="boldsch">Schedule IT - </b> DETAILS of ADVANCE TAX AND SELF ASSESSMENT TAX PAYMENTS</div> 
             <div class="row"> 
            <div class="col-xs-4 ">
				<div><span class="normallabel">BSR CODE</span></div>
				<xsl:for-each select="//ITRForm:TaxPayments/ITRForm:TaxPayment">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:BSRCode"/></span></div>
                </xsl:for-each>
			  </div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">DATE OF DEPOSIT</span></div>
				<xsl:for-each select="//ITRForm:TaxPayments/ITRForm:TaxPayment">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:DateDep "/></span></div>
				</xsl:for-each>
				</div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">CHALLAN NO</span></div>
				<xsl:for-each select="//ITRForm:TaxPayments/ITRForm:TaxPayment">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:SrlNoOfChaln"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-5 ">
				<div><span class="normallabel">TAX PAID</span></div>
				<xsl:for-each select="//ITRForm:TaxPayments/ITRForm:TaxPayment">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:Amt"/></span></div>
		        </xsl:for-each>
             </div>
             </div>
             <div class="row">
            <div class="sectionhead"><b class="boldsch">Schedule TDS1 - </b>  DETAILS of TAX DEDUCTED AT SOURCE FROM SALARY[As Per Form 16 issued by Employer]</div> 
             </div>    
              <div class="row"> 
            <div class="col-xs-4 ">
				<div><span class="normallabel">TAN</span></div>
				 <xsl:for-each select="//ITRForm:TDSonSalaries/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:TAN"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">NAME OF THE EMPLOYER</span></div>
				<xsl:for-each select="//ITRForm:TDSonSalaries/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:EmployerOrDeductorOrCollecterName"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-7 ">
				<div><span class="normallabel">INCOME UNDER SALARY</span></div>
				<xsl:for-each select="//ITRForm:TDSonSalaries/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:IncChrgSal"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-9 ">
				<div><span class="normallabel">TAX DEDUCTED</span></div>
				<xsl:for-each select="//ITRForm:TDSonSalaries/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:TotalTDSSal"/></span></div>
				</xsl:for-each>
			   </div>
                </div> 
             <div class="row">
            <div class="sectionhead"><b class="boldsch">Schedule TDS2 - </b>  DETAILS of TAX DEDUCTED AT SOURCE FROM INCOME OTHER THAN SALARY</div>
             </div>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">TAN </span></div>
			<xsl:for-each select="//ITRForm:TDSonOthThanSals/ITRForm:TDSonOthThanSal">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:TAN"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-3 ">
			 <div><span class="smalllabel">NAME OF THE DEDUCTOR </span></div>
			 <xsl:for-each select="//ITRForm:TDSonOthThanSals/ITRForm:TDSonOthThanSal">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:EmployerOrDeductorOrCollecterName"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-3">
				<div><span class="smalllabel">UNIQUE TDS CER.NO </span></div>
				<div><span class="normaltext"><xsl:value-of select="//tdsfromothersdocument/mootlywcm:tdsothersdetail/@mootlywcm:tdscertificate"/></span></div>
			</div>	
			 <div class="col-xs-3 ">
				    <div><span class="smalllabel">DEDUCTED YEAR </span></div>
			        <div><span class="normaltext"><xsl:value-of select="//tdsfromothersdocument/mootlywcm:tdsothersdetail/@mootlywcm:financialyear"/></span></div>
			    </div>
               <div class="col-xs-4 ">
				 <div><span class="smalllabel">TAX DEDUCTED </span></div>
				 <xsl:for-each select="//ITRForm:TDSonOthThanSals/ITRForm:TDSonOthThanSal">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:TotTDSOnAmtPaid"/></span></div>
				 </xsl:for-each>
				</div> 
              <div class="col-xs-10">
				<div><span class="smalllabel">AMT OUT OF CLAIMED THIS YR </span></div>
				<xsl:for-each select="//ITRForm:TDSonOthThanSals/ITRForm:TDSonOthThanSal">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:ClaimOutOfTotTDSOnAmtPaid"/></span></div>
				 </xsl:for-each>
             </div>
         </div>     
	  </xsl:template>
	  <xsl:template name="partD-4STaxComputation">
	  <div class="container pbf">
	    <div class="sectionhead"><b class="boldsch">PART D - </b> TAX COMPUTATION AND TAX STATUS </div>
		</div>
		<div class="row">
			<div class="col-xs-4">
			<span class="normallabel"><strong>(D1) </strong></span>
				<span class="normallabel">Tax Payable On Total Income</span>
				<div>
					<span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:TotalTaxPayable"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normallabel"><strong>(D2)</strong></span>
				<span class="normallabel">Secondary &amp; Higher Education Cess</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:EducationCess"/></span></div>
			</div>
			<div class="col-xs-8">
			<span class="normallabel"><strong>(D3)</strong></span>
				<span class="normallabel">TOTAL TAX AND CESS(D1+D2)</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:GrossTaxLiability"/></span></div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
			<span class="normallabel"><strong>(D4)</strong></span>
				<span class="normallabel">Relief u/s 89</span>
				<div>
					<span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:Section89"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normallabel"><strong>(D5)</strong></span>
				<span class="normallabel">Balance tax After Relief(D3-D4)</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:NetTaxLiability"/></span></div>
			</div>
			<div class="col-xs-8">
			<span class="normallabel"><strong>(D6)</strong></span>
				<span class="normallabel">Total Interest u/s 234A</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:IntrstPayUs234A"/></span></div>
			 </div>
		  </div>
		
		<div class="row">
			<div class="col-xs-4">
			<span class="normallabel"><strong>(D7)</strong></span>
				<span class="normallabel">Total Interest u/s 234B</span>
				<div>
					<span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:IntrstPayUs234B"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normallabel"><strong>(D8)</strong></span>
				<span class="normallabel">Total Interest u/s 234C</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:IntrstPayUs234C"/></span></div>
			</div>
			<div class="col-xs-8">
			<span class="normallabel"><strong>(D9)</strong></span>
				<span class="normallabel">Total Tax And Interest(D5+D6+D7+D8)</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:TotTaxPlusIntrstPay"/></span></div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-4">
			<span class="normallabel"><strong>(D10)</strong></span>
				<span class="normallabel">Total Advance Tax Paid</span>
				<div>
					<span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:AdvanceTax"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normallabel"><strong>(D11)</strong></span>
				<span class="normallabel">Total Self Assessment Tax Paid</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:SelfAssessmentTax"/></span></div>
			</div>
			<div class="col-xs-8">
			<span class="normallabel"><strong>(D12)</strong></span>
				<span class="normallabel">Total TDS claimed</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:TDS"/></span></div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-4">
			<span class="normallabel"><strong>(D13)</strong></span>
				<span class="normallabel">Total Prepaid Taxes(D10+D11+D12)</span>
				<div>
					<span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;	
						<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:TotalTaxesPaid"/>
					</span>
				</div>
			</div>
			<div class="col-xs-6">
			<span class="normallabel"><strong>(D14)</strong></span>
				<span class="normallabel">total Payable(D9-D13,If D9>D13)</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:BalTaxPayable"/></span></div>
			</div>
			<div class="col-xs-8">
				<span class="normallabel">Refund(D13-D9,If D13>D9)</span>
				<div><span class="normaltext">&#160;&#160;&#160;&#160;&#160;&#160;<xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:RefundDue"/></span></div>
			</div>
		</div>
		<div class="row">
		<hr class="redline"/>
			<div class="col-xs-7">
				<span class="normallabel">Bank Account Details(Mandatory in all cases irrespective of refund due or not)</span>
		</div>
		</div>
		<div class="row">
			<div class="col-xs-6">
				<span class="normallabel">ACCOUNT NO</span>
				<span class="normaltext"><xsl:value-of select="//memberpersonalinformation/@mootlywcm:accNumber"/></span>
			</div>
			 <div class="col-xs-7">
            <span class="normallabel">Type of account</span>
            <span class="normaltext">
              <xsl:choose>
              <xsl:when test="//memberpersonalinformation/@mootlywcm:typeAcc = 'CUR'">
               <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>current 
              <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>saving
             </xsl:when>
               <xsl:when test="//memberpersonalinformation/@mootlywcm:typeAcc = 'SAV'">
              <img width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>current
               <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>saving
                </xsl:when>
             </xsl:choose>
            </span>
            </div>
           </div>
	
		<div class="row">
			<div class="col-xs-6">
				<span class="normallabel">IFSC CODE</span>
				<span class="normaltext"><xsl:value-of select="//ITRForm:IFSCCode"/> </span>
			</div>
			 <div class="col-xs-7">
            <span class="normallabel">Fill Only One:Refund by </span>
            <span class="normaltext">
              <xsl:choose>
              <xsl:when test="//ITRForm:EcsRequired = 'N'">
               <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>check 
              <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>deposited directly your bank account            
               </xsl:when>
               <xsl:otherwise>
              <img width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-outline-16.gif" class="img-circle"/>check
               <img  width="11px" height="11px" src="http://www.iconsdb.com/icons/download/black/circle-16.gif" class="img-circle"/>deposited directly your bank account
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
            <div class="col-xs-4">
                <strong>&#160;</strong>
             </div>
			<div class="col-xs-6">
				<b class="boldsch">VERIFICATION</b>
           </div>
           </div>
           <div class="row">
			<div >
				<span class="normallabel">I,</span>
				<span class="normaltext"><xsl:value-of select="//ITRForm:AssesseeVerName"/> </span>
				<span class="normallabel">son/daughter of</span>
				<span class="normaltext"><xsl:value-of select="//ITRForm:FatherName"/> </span>
          	<span class="normallabel">solemnly declare that to the best of my knowledge
		      and belief,the information given in the return is corrected and complete and that the amount of total income and other particulars
		       show therein are truly stated and are in accordance with the provisions of the income-tax Act 1961, in respect of income chargeable to Income-tax for the 
		       previous year relevent to the Assessment year 2013-14. </span></div>
            </div> 
            <div>
             <hr class="redline"/>
             </div>
       <div class="sectionhead"><b class="boldsch">NATURE OF BUSINESS</b></div>
          <div class="row"> 
            <div class="col-xs-4 ">
         <div><span class="normallabel">Code</span></div>
           <xsl:for-each select="//ITRForm:NatOfBus/ITRForm:Business">
           <div><span class="normaltext"><xsl:value-of select="ITRForm:Code"/> 
            </span>
          </div>
        </xsl:for-each>
           </div>
          <div class="col-xs-6 ">
               <div><span class="normallabel">Name of the Business</span></div>
                <xsl:for-each select="//ITRForm:NatOfBus/ITRForm:Business/ITRForm:Trade">
     
              <div><span class="normaltext"><xsl:value-of select="."/>&#160; <b class="bold">/&#160;</b></span></div>
              </xsl:for-each>
            </div>
            </div>
            <div class ="row">
            <hr class="redline"/>
            <div class="sectionhead"><b class="boldsch">SCHEDULE BP</b>- DETAILS OF INCOME FROM BUSINESS</div>
            <div class="normalhead">&#160;&#160;COMPUTATION OF PRESUMPTIVE INCOME UNDER 44AD</div>
            </div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E1</strong>
			</div>
			<div class="col-xs-7 normallabel">Gross Turnover or Gross Receipts</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:PersumptiveInc44AD/ITRForm:GrsTrnOverOrReceipt"/></div>
		</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E2</strong>
			</div>
			<div class="col-xs-7 normallabel">Total Presumptive Income under 44AD(8% of E1)</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:PersumptiveInc44AD/ITRForm:TotPersumptiveInc44AD"/></div>
		</div>
		<div class="normalhead">&#160;&#160;COMPUTATION OF PRESUMPTIVE INCOME UNDER 44AE</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E3</strong>
			</div>
			<div class="col-xs-7 normallabel">Presumptive Income from Heavy Vehicles</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:PersumptiveInc44AE/ITRForm:PersumptiveIncHeavyVehicle"/></div>
		</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E4</strong>
			</div>
			<div class="col-xs-7 normallabel">Presumptive Income from Other Vehicles</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:PersumptiveInc44AE/ITRForm:PersumptiveIncOtherVehicle"/></div>
		</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E5</strong>
			</div>
			<div class="col-xs-7 normallabel">Total Presumptive Income under 44AE(E3+E4)</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:PersumptiveInc44AE/ITRForm:TotPersumInc44AE"/></div>
		</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E6</strong>
			</div>
			<div class="col-xs-7 normallabel">Income chargeable under Business (E2+E5)</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:IncChargeableUnderBus"/></div>
		</div>
		  <div class="normalhead">&#160;&#160;FINANCIAL PARTICULARS OF THE BUSINESS</div>
		  <div class="row">
			<div class="col-xs-1">
				<strong>E7</strong>
			</div>
			<div class="col-xs-7 normallabel">Amount of Total Sundry Debtors</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:NoBooksOfAccBS/ITRForm:TotSundryDbtAmt"/></div>
		</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E8</strong>
			</div>
			<div class="col-xs-7 normallabel">Amount of Total Sundry Creditors</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:NoBooksOfAccBS/ITRForm:TotSundryCrdAmt"/></div>
		</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E9</strong>
			</div>
			<div class="col-xs-7 normallabel">Amount of Total Stock-in-trade</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:NoBooksOfAccBS/ITRForm:TotStkInTradAmt"/></div>
		</div>
		<div class="row">
			<div class="col-xs-1">
				<strong>E10</strong>
			</div>
			<div class="col-xs-7 normallabel">Amount of the Cash Balance</div>
			<div class="col-xs-4 normaltext decimal"><xsl:number grouping-size="3" grouping-separator=","  value="//ITRForm:ScheduleBPForITR4S/ITRForm:NoBooksOfAccBS/ITRForm:CashBalAmt"/></div>
		</div>    
            
            <div> 
           <hr class="redline"/>
            <div class="sectionhead"><b class="boldsch">Schedule IT - </b> DETAILS of ADVANCE TAX AND SELF ASSESSMENT TAX PAYMENTS</div>
            </div> 
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
             
              <div> 
           <hr class="redline"/>
            <div class="sectionhead"><b class="boldsch">Schedule TCS - </b> DETAILS OF TAX COLLECTED AT SOURCE</div>
            </div> 
             <div class="row"> 
            <div class="col-xs-3">
				<div><span class="normallabel">TAX COLLECTION ACCOUNT</span></div>
				<xsl:for-each select="//ITRForm:ScheduleTCS/ITRForm:TCS/ITRForm:EmployerOrDeductorOrCollectDetl">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:TAN"/></span></div>
                </xsl:for-each>
			  </div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">NAME OF THE COLLECTOR</span></div>
				<xsl:for-each select="//ITRForm:ScheduleTCS/ITRForm:TCS/ITRForm:EmployerOrDeductorOrCollectDetl">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollecterName"/></span></div>
				</xsl:for-each>
				</div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">TAX COLLECTED</span></div>
				<xsl:for-each select="//ITRForm:ScheduleTCS/ITRForm:TCS">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:TotalTCS"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-7 ">
				<div><span class="normallabel">AMOUNT CLAIMED IN THIS YEAR</span></div>
				<xsl:for-each select="//ITRForm:ScheduleTCS/ITRForm:TCS">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:AmtTCSClaimedThisYear"/></span></div>
		        </xsl:for-each>
             </div>
             </div>
              <div class="row">
                <div class="">&#160;&#160;&#160;</div>
               </div>
               <div class="col-xs-1">
                <strong>&#160;</strong>
              </div>
             <div class="row">
             <hr class="redline"/>
            <div class="sectionhead"><b class="boldsch">Schedule TDS1 - </b>  DETAILS of TAX DEDUCTED AT SOURCE FROM SALARY[As Per Form 16 issued by Employer]</div> 
             </div>    
              <div class="row"> 
            <div class="col-xs-4 ">
				<div><span class="normallabel">TAN</span></div>
				 <xsl:for-each select="//ITRForm:TDSonSalaries/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:TAN"/></span></div>
			</xsl:for-each>
			</div>
			 <div class="col-xs-4 ">
				<div><span class="normallabel">NAME OF THE EMPLOYER</span></div>
				<xsl:for-each select="//ITRForm:TDSonSalaries/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:EmployerOrDeductorOrCollecterName"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-7 ">
				<div><span class="normallabel">INCOME UNDER SALARY</span></div>
				<xsl:for-each select="//ITRForm:TDSonSalaries/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:IncChrgSal"/></span></div>
				</xsl:for-each>
			</div>
			 <div class="col-xs-9 ">
				<div><span class="normallabel">TAX DEDUCTED</span></div>
				<xsl:for-each select="//ITRForm:TDSonSalaries/ITRForm:TDSonSalary">
				<div><span class="normaltext"><xsl:value-of select="ITRForm:TotalTDSSal"/></span></div>
				</xsl:for-each>
			   </div>
                </div> 
               <div>
                <div class="">&#160;&#160;&#160;</div>
               </div>
               
             <div class="row">
             <hr class="redline"/>
            <div class="sectionhead"><b class="boldsch">Schedule TDS2 - </b> DETAILS of TAX DEDUCTED AT SOURCE FROM INCOME OTHER THAN SALARY</div>
             </div>
          <div class="row"> 
             <div class="col-xs-2">
			<div><span class="smalllabel">TAN </span></div>
			<xsl:for-each select="//ITRForm:TDSonOthThanSals/ITRForm:TDSonOthThanSal">
			 <div><span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:TAN"/></span></div>
			 </xsl:for-each>
		  </div>	 
			 <div class="col-xs-3 ">
			 <div><span class="smalllabel">NAME OF THE DEDUCTOR </span></div>
			 <xsl:for-each select="//ITRForm:TDSonOthThanSals/ITRForm:TDSonOthThanSal">
			  <div> <span class="normaltext"><xsl:value-of select="ITRForm:EmployerOrDeductorOrCollectDetl/ITRForm:EmployerOrDeductorOrCollecterName"/></span></div>
			  </xsl:for-each>
			</div>
			  <div class="col-xs-3">
				<div><span class="smalllabel">UNIQUE TDS CER.NO </span></div>
				<div><span class="normaltext"><xsl:value-of select="//tdsfromothersdocument/mootlywcm:tdsothersdetail/@mootlywcm:tdscertificate"/></span></div>
			</div>	
			 <div class="col-xs-3 ">
				    <div><span class="smalllabel">DEDUCTED YEAR </span></div>
			        <div><span class="normaltext"><xsl:value-of select="//tdsfromothersdocument/mootlywcm:tdsothersdetail/@mootlywcm:financialyear"/></span></div>
			    </div>
               <div class="col-xs-4 ">
				 <div><span class="smalllabel">TAX DEDUCTED </span></div>
				 <xsl:for-each select="//ITRForm:TDSonOthThanSals/ITRForm:TDSonOthThanSal">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:TotTDSOnAmtPaid"/></span></div>
				 </xsl:for-each>
				</div> 
              <div class="col-xs-10">
				<div><span class="smalllabel">AMT OUT OF CLAIMED THIS YR </span></div>
				<xsl:for-each select="//ITRForm:TDSonOthThanSals/ITRForm:TDSonOthThanSal">
				 <div><span class="normaltext"><xsl:value-of select="ITRForm:ClaimOutOfTotTDSOnAmtPaid"/></span></div>
				 </xsl:for-each>
             </div>
         </div>
	  </xsl:template>
  </xsl:stylesheet>