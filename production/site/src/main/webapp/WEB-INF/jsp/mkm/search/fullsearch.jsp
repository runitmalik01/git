


















<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html >
<head>
    <title>test - VMware KB - Search Results </title>
  <meta http-equiv="content-type" content="text/html;charset=utf-8">
     




<meta name="description" content="The VMware Knowledge Base provides support solutions, error messages, and troubleshooting guides" />
<meta name="keywords" content="" /> 
<meta name="robots" content="index,follow,noarchive" />
<meta name="copyright" content="VMware" />
<meta http-equiv="content-language" content="en" />
<meta name="author" content="VMware" />


<link rel="alternate" type="application/rss+xml" href="http://vmware.simplefeed.net/rss" />
<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" />

<link rel="stylesheet" href="http://www.vmware.com/files/templates/inc/kb_template.css" type="text/css" media="screen" charset="utf-8">
<link rel="stylesheet" href="http://www.vmware.com/files/templates/inc/kb.css" type="text/css" media="screen" charset="utf-8">
<link rel="stylesheet" href="http://www.vmware.com/files/templates/inc/kb_fce.css" type="text/css" media="screen" charset="utf-8">
<link rel="stylesheet" href="http://www.vmware.com/files/templates/inc/kb_print.css" type="text/css" media="print" charset="utf-8">
<script type="text/javascript" src="http://www.vmware.com/files/templates/inc/kb_library.js"></script>
     
     <link rel="stylesheet" type="text/css" href="../../../css/mkm/selfservice/yuilib/bubbling.library.v2.1/build/accordion/assets/accordion.css" />
     <link rel="stylesheet" type="text/css" href="../../../css/mkm/selfservice/yuilib/yui/build/assets/skins/sam/container.css" />
     <link rel="stylesheet" type="text/css" href="../../../css/mkm/selfservice/css/dec_rel.css" />
     <script src="../../../js/mkm/selfservice/yuilib/yui/build/utilities/utilities.js"></script>
     <script src="../../../js/mkm/selfservice/yuilib/bubbling.library.v2.1/build/bubbling/bubbling.js"></script>
     <script src="../../../js/mkm/selfservice/yuilib/bubbling.library.v2.1/build/accordion/accordion.js"></script>
     <script>
 	function setSortOrder(strSort){
 		document.sortForm.sort.value=strSort;
 		document.sortForm.submit();
 	}
     </script>
    <script src="../../../js/mkm/selfservice/jslib/searchentry.js"></script>
    <script type="text/javascript" src="../../../js/mkm/selfservice/jslib/mostpopdocs_extinterface.js"></script>
	<!-- Auto Suggest -->
    <link rel="stylesheet" type="text/css" href="../../../css/mkm/selfservice/autosuggest/css/jquery.autocomplete.css" />
	<script src="../../../js/mkm/selfservice/autosuggest/js/jquery-1.4.4.min.js"></script>  
	<script src="../../../js/mkm/selfservice/autosuggest/js/jquery.autocomplete.js"></script>  
	<style>
		input {
			font-size: 18px Arial, Helvetica, sans-serif;
			margin-left:-2px;
		}		
	</style>
	<script type="text/javascript">		
		j$(document).ready(function(){
			//wrap the words in the search breadcrumb. Otherwise if searched title is long UI distorts
			wrapBreadCrumbText();
			//Issue fix fr FF2
			if(j$.browser.mozilla && j$.browser.version.substr(0,3)<1.9)
			{
				if(truncateLengthyText())
					j$("form[id='id_searchForm'] input[name='searchString']").autocomplete('/selfservice/autosuggest/AutoSuggestServlet');	
			}
			//disable category filter in communities and product documentation tab
			var srchForm = document.getElementById("id_searchForm");
			if(srchForm.document.value != 'DT_KB_1_1')
			{
   				srchForm.category.selectedIndex=0;
				srchForm.category.disabled=true;
			}
		});
		
		//wrap the lengthy breadcrumb text
		function wrapBreadCrumbText()
		{
			j$("td[class='kbdocshead']") .attr('style', 'white-space: normal;'); 
		}
		
		//trucate all the lengthy text in the search results div
		function truncateLengthyText()
		{
			var maxLen = 70;
			var needJoin = false;
			var needRefresh = false;
			//get the synopsis contents
			var synopsis = j$("synopsis");
			for(var i=0; i<synopsis.length; i++)
			{
				var text = j$(synopsis[i]).html();
				needJoin = false;
				//if synopsis text contains URL then only perform splitting of the text
				if(text.indexOf("http") != -1)
				{
					var splitText = text.split(" ");
					for(var j=0; j<splitText.length; j++)
					{
						//if the length of the word is more than max length then introduce a space
						if(splitText[j].length > maxLen)
						{
							needJoin = true;
							var finalText = "";
							var textToSplit = splitText[j];
							var remainingLength = textToSplit.length;
							while(remainingLength > 0)
							{
								finalText += textToSplit.substring(0, maxLen) + " ";
								textToSplit = textToSplit.substring(maxLen, textToSplit.length);
								remainingLength = remainingLength - finalText.length;
							}
							splitText[j] = finalText;
						}
					}
					if(needJoin){
						j$(synopsis[i]).html(splitText.join(' '));
						needRefresh = true;
					}
				}
			}
			if(needRefresh){
				var divHTML = j$('#content').html();
				j$('#content').html(divHTML);
				return true;
			}
			return false;
		}
	</script>

</head>


	


	


<script>
var curDocType = "DT_KB_1_1";
	// find all forms
function changeDocType(input) {
	var srchForm = document.getElementById("id_searchForm");
	srchForm.document.value=input;
	
	if (input == 'DT_PRODUCTDOCUMENTATION_1_1' || input =='DT_COMMUNITIES_1_1') {				
		srchForm.product.selectedIndex=0;
		srchForm.product.disabled=true;
		srchForm.category.selectedIndex=0;
		srchForm.category.disabled=true;
		}
	else {
		
			srchForm.product.value= 'noselection';
		
		
			srchForm.category.value= 'noselection';
		
		srchForm.product.disabled=false;
		srchForm.category.disabled=false;
	}
	srchForm.submit();
	//performSearch(srchForm);	
}
	
</script>
<body class="js">
<!-- header -->
















	<div id="container">
	<div id="content-container" class="wide">
	<div id="content">	
	





	<h1 class="kbtitle noprint">Knowledge Base</h1>
	<div class="secondsection noprint">The VMware Knowledge Base provides support solutions, error messages and troubleshooting guides</div>

<div id="top-buttons" class="noprint">
	<a href="/selfservice"><img src="http://www.vmware.com/files/images/buttons/btn_kb-home.png" border="0"></a> &nbsp; 
	<a href="/kb/878"><img src="http://www.vmware.com/files/images/buttons/btn_knowledge-base-help.png" border="0"></a>
</div>

<!-- header -->
    







			<div id="vmsearchentrywidget">
	<div class="vmsearchentrytop noprint"></div>	
	<table class="vmsearchborder noprint" border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td style="padding: 5px 3px 0px 10px; *padding:0px 3px 0px 10px;" class="vmsearchentry">
				<table cellpadding="0" cellspacing="1" width="100%">
					<tr>
						<td width="78%"><span class="seheader">Search the VMware Knowledge Base (KB)</span></td>
						<td rowspan="2" class="sebar" width="1%">&nbsp;</td>
						<td><span class="seheader">View by Article ID</span></td>
					</tr>		
					<tr>
						<td>
							<form name="searchForm" id="id_searchForm" method="post" action="searchEntry.do" onsubmit="return validateForm(this)">
								<table width="100%" cellspacing="0" cellpadding="0" border="0">
									<tr>
										<td style="padding:5px;" colspan="2" align="left" valign="middle"><input name="searchString" value="test" maxLength="4000" class="control_searchString"></td>										
										<td align="left" valign="middle"><input name="btnSearchAll" class="btn-knova-search" value="" type="submit"></td>
										
									</tr>
									<tr>
																        	        	                                				    	  	    	  	    		    		                                     		            	            <td style="padding:5px;" align="left" valign="middle">
    <select name="product"  class="control_product"  >	
          						            <option value="noselection"  selected >Products --&gt;</option>
          						            <option value="SG_SERVER_DATACENTER_1_1" >Datacenter</option>
          				 				            <option value="SG_APACHEACTIVEMQ_1_2" >Apache Active MQ</option>
          						            <option value="SG_APACHEACTIVEMQ5_4_1_3" >--Apache Active MQ 5.4</option>
          				 				            <option value="SG_APACHEHTTPSERVER_1_2" >Apache HTTP Server</option>
          						            <option value="SG_APACHEHTTPSERVER2_0_1_3" >--Apache HTTP Server 2.0</option>
          						            <option value="SG_APACHEHTTPSERVER2_2_1_3" >--Apache HTTP Server 2.2</option>
          				 				            <option value="SG_APACHETOMCAT_1_2" >Apache Tomcat</option>
          						            <option value="SG_APACHETOMCAT5_5_1_3" >--Apache Tomcat 5.5</option>
          						            <option value="SG_APACHETOMCAT6_1_3" >--Apache Tomcat 6</option>
          						            <option value="SG_APACHETOMCAT7_1_3" >--Apache Tomcat 7</option>
          				 				            <option value="SG_ECLIPSEVIRGO_1_2" >Eclipse Virgo</option>
          						            <option value="SG_ECLIPSEVIRGO2_1_1_3" >--Eclipse Virgo 2.1</option>
          						            <option value="SG_ECLIPSEVIRGO3_1_3" >--Eclipse Virgo 3</option>
          				 				            <option value="SG_IT_SHAVLIK_COM_1_2" >IT.Shavlik.com</option>
          						            <option value="SG_IT_SHAVLIK_COM10_8_306_1_3" >--IT.Shavlik.com 10.8.306</option>
          						            <option value="SG_IT_SHAVLIK_COM10_8_308_1_3" >--IT.Shavlik.com 10.8.308</option>
          				 				            <option value="SG_SHAVLIKGOVERNMENTEDITION_1_2" >Shavlik Government Edition</option>
          				 				            <option value="SG_SHAVLIKNETCHKCONFIGURE_1_2" >Shavlik NetChk Configure</option>
          						            <option value="SG_SHAVLIKNETCHKCONFIGURE4_2_0_20_1_3" >--Shavlik NetChk Configure 4.2.0.20</option>
          				 				            <option value="SG_SHAVLIKNETCHKPROTECT_1_2" >Shavlik NetChk Protect</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_5_2716_1_3" >--Shavlik NetChk Protect 7.5.2716</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_5_2733_1_3" >--Shavlik NetChk Protect 7.5.2733</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_5_2779_1_3" >--Shavlik NetChk Protect 7.5.2779</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_6_1482_1_3" >--Shavlik NetChk Protect 7.6.1482</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_6_1483_1_3" >--Shavlik NetChk Protect 7.6.1483</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_6_1496_1_3" >--Shavlik NetChk Protect 7.6.1496</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_8_1340_1_3" >--Shavlik NetChk Protect 7.8.1340</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_8_1388_1_3" >--Shavlik NetChk Protect 7.8.1388</option>
          						            <option value="SG_SHAVLIKNETCHKPROTECT7_8_1392_1_3" >--Shavlik NetChk Protect 7.8.1392</option>
          				 				            <option value="SG_SHAVLIKNETCHKVPROTECT_1_2" >Shavlik NetChk vProtect</option>
          						            <option value="SG_SHAVLIKNETCHKVPROTECT7_8_1340_1_3" >--Shavlik NetChk vProtect 7.8.1340</option>
          						            <option value="SG_SHAVLIKNETCHKVPROTECT7_8_1388_1_3" >--Shavlik NetChk vProtect 7.8.1388</option>
          						            <option value="SG_SHAVLIKNETCHKVPROTECT7_8_1392_1_3" >--Shavlik NetChk vProtect 7.8.1392</option>
          				 				            <option value="SG_SHAVLIKSCUPDATES_1_2" >Shavlik SCUPdates</option>
          				 				            <option value="SG_SHAVLIKSECURITYADVISOR_1_2" >Shavlik Security Advisor</option>
          				 				            <option value="SG_SHAVLIKSECURITYINTELLIGENCE_1_2" >Shavlik Security Intelligence</option>
          						            <option value="SG_SHAVLIKSECURITYINTELLIGENCE1_0_1_3" >--Shavlik Security Intelligence 1.0</option>
          				 				            <option value="SG_SHAVLIKSECURITYSUITE_1_2" >Shavlik Security Suite</option>
          				 				            <option value="SG_SHAVLIKSIMPLEXITY_1_2" >Shavlik SimplexITy</option>
          				 				            <option value="SG_SOCIALCAST_1_2" >Socialcast</option>
          						            <option value="SG_SOCIALCASTDEDICATEDCLOUD_1_3" >--Socialcast Dedicated Cloud</option>
          						            <option value="SG_SOCIALCASTONPREMISEV1_1_3" >--Socialcast On Premise v1</option>
          						            <option value="SG_SOCIALCASTONPREMISEV2_1_3" >--Socialcast On Premise v2</option>
          						            <option value="SG_SOCIALCASTSAAS_1_3" >--Socialcast SaaS</option>
          				 				            <option value="SG_SUSELINUXENTERPRISESERVER_SLES_FORVMWARE_1_2" >SUSE Linux Enterprise Server (SLES) for VMware</option>
          						            <option value="SG_SUSELINUXENTERPRISESERVER_SLES_FORVMWARE1_X_1_3" >--SUSE Linux Enterprise Server (SLES) for VMware 1.x</option>
          				 				            <option value="SG_VMWAREALIVEENTERPRISE_1_2" >VMware Alive Enterprise</option>
          						            <option value="SG_VMWAREALIVEENTERPRISE7_2_X_1_3" >--VMware Alive Enterprise 7.2.x</option>
          				 				            <option value="SG_VMWARECAPACITYPLANNER_1_2" >VMware Capacity Planner</option>
          						            <option value="SG_VMWARECAPACITYPLANNER2_1_X_1_3" >--VMware Capacity Planner 2.1.x</option>
          						            <option value="SG_VMWARECAPACITYPLANNER2_5_X_1_3" >--VMware Capacity Planner 2.5.x</option>
          						            <option value="SG_VMWARECAPACITYPLANNER2_6_X_1_3" >--VMware Capacity Planner 2.6.x</option>
          						            <option value="SG_VMWARECAPACITYPLANNER2_7_X_1_3" >--VMware Capacity Planner 2.7.x</option>
          						            <option value="SG_VMWARECAPACITYPLANNER2_8_X_1_3" >--VMware Capacity Planner 2.8.x</option>
          				 				            <option value="SG_VMWARECONSOLIDATEDBACKUP_1_2" >VMware Consolidated Backup</option>
          						            <option value="SG_VMWARECONSOLIDATEDBACKUP1_0_X_1_3" >--VMware Consolidated Backup 1.0.x</option>
          						            <option value="SG_VMWARECONSOLIDATEDBACKUP1_1_X_1_3" >--VMware Consolidated Backup 1.1.x</option>
          						            <option value="SG_VMWARECONSOLIDATEDBACKUP1_5_X_1_3" >--VMware Consolidated Backup 1.5.x</option>
          				 				            <option value="SG_VMWARECONVERTER_1_2" >VMware Converter</option>
          						            <option value="SG_VMWARECONVERTER3_0_X_1_3" >--VMware Converter 3.0.x</option>
          				 				            <option value="SG_VMWAREDATARECOVERY_1_2" >VMware Data Recovery</option>
          						            <option value="SG_VMWAREDATARECOVERY1_X_1_3" >--VMware Data Recovery 1.x</option>
          						            <option value="SG_VMWAREDATARECOVERY2_X_1_3" >--VMware Data Recovery 2.x</option>
          				 				            <option value="SG_VMWAREESX_1_2" >VMware ESX</option>
          						            <option value="SG_VMWAREESX1_0_X_1_3" >--VMware ESX 1.0.x</option>
          						            <option value="SG_VMWAREESX1_5_X_1_3" >--VMware ESX 1.5.x</option>
          						            <option value="SG_VMWAREESX2_0_X_1_3" >--VMware ESX 2.0.x</option>
          						            <option value="SG_VMWAREESX2_1_X_1_3" >--VMware ESX 2.1.x</option>
          						            <option value="SG_VMWAREESX2_5_X_1_3" >--VMware ESX 2.5.x</option>
          						            <option value="SG_VMWAREESX3_0_X_1_3" >--VMware ESX 3.0.x</option>
          						            <option value="SG_VMWAREESX3_5_X_1_3" >--VMware ESX 3.5.x</option>
          						            <option value="SG_VMWAREESX4_0_X_1_3" >--VMware ESX 4.0.x</option>
          						            <option value="SG_VMWAREESX4_1_X_1_3" >--VMware ESX 4.1.x</option>
          				 				            <option value="SG_VMWAREESXI_1_2" >VMware ESXi</option>
          						            <option value="SG_VMWAREESXI3_5_XEMBEDDED_1_3" >--VMware ESXi 3.5.x Embedded</option>
          						            <option value="SG_VMWAREESXI3_5_XINSTALLABLE_1_3" >--VMware ESXi 3.5.x Installable</option>
          						            <option value="SG_VMWAREESXI4_0_XEMBEDDED_1_3" >--VMware ESXi 4.0.x Embedded</option>
          						            <option value="SG_VMWAREESXI4_0_XINSTALLABLE_1_3" >--VMware ESXi 4.0.x Installable</option>
          						            <option value="SG_VMWAREESXI4_1_XEMBEDDED_1_3" >--VMware ESXi 4.1.x Embedded</option>
          						            <option value="SG_VMWAREESXI4_1_XINSTALLABLE_1_3" >--VMware ESXi 4.1.x Installable</option>
          						            <option value="SG_VMWAREESXI5_0_X_1_3" >--VMware ESXi 5.0.x</option>
          				 				            <option value="SG_VMWAREGO_1_2" >VMware Go</option>
          						            <option value="SG_VMWAREGO1_0_X_1_3" >--VMware Go 1.0.x</option>
          						            <option value="SG_VMWAREGO2_1_101_1_3" >--VMware Go 2.1.101</option>
          				 				            <option value="SG_VMWAREGOPRO_1_2" >VMware Go Pro</option>
          						            <option value="SG_VMWAREGOPRO2_1_101_1_3" >--VMware Go Pro 2.1.101</option>
          				 				            <option value="SG_VMWAREGSXSERVER_1_2" >VMware GSX Server</option>
          						            <option value="SG_VMWAREGSXSERVER1_X_LINUX__1_3" >--VMware GSX Server 1.x (Linux)</option>
          						            <option value="SG_VMWAREGSXSERVER1_X_WINDOWS__1_3" >--VMware GSX Server 1.x (Windows)</option>
          						            <option value="SG_VMWAREGSXSERVER2_X_LINUX__1_3" >--VMware GSX Server 2.x (Linux)</option>
          						            <option value="SG_VMWAREGSXSERVER2_X_WINDOWS__1_3" >--VMware GSX Server 2.x (Windows)</option>
          						            <option value="SG_VMWAREGSXSERVER3_X_LINUX__1_3" >--VMware GSX Server 3.x (Linux)</option>
          						            <option value="SG_VMWAREGSXSERVER3_X_WINDOWS__1_3" >--VMware GSX Server 3.x (Windows)</option>
          				 				            <option value="SG_VMWAREINFRASTRUCTUREMANAGEMENTASSISTANT_1_2" >VMware Infrastructure Management Assistant</option>
          						            <option value="SG_VMWAREINFRASTRUCTUREMANAGEMENTASSISTANT1_0_1_3" >--VMware Infrastructure Management Assistant 1.0</option>
          				 				            <option value="SG_VMWAREINFRASTRUCTURESDK_1_2" >VMware Infrastructure SDK</option>
          						            <option value="SG_VMWAREINFRASTRUCTURESDK1_X_1_3" >--VMware Infrastructure SDK 1.x</option>
          						            <option value="SG_VMWAREINFRASTRUCTURESDK2_0_X_1_3" >--VMware Infrastructure SDK 2.0.x</option>
          				 				            <option value="SG_VMWAREP2VASSISSTANT_1_2" >VMware P2V Assistant</option>
          						            <option value="SG_VMWAREP2VASSISSTANT1_0_X_1_3" >--VMware P2V Assistant 1.0.x</option>
          						            <option value="SG_VMWAREP2VASSISSTANT2_0_X_1_3" >--VMware P2V Assistant 2.0.x</option>
          						            <option value="SG_VMWAREP2VASSISSTANT2_1_X_1_3" >--VMware P2V Assistant 2.1.x</option>
          				 				            <option value="SG_VMWARESERVER_1_2" >VMware Server</option>
          						            <option value="SG_VMWARESERVER1_0_X_LINUX__1_3" >--VMware Server 1.0.x (Linux)</option>
          						            <option value="SG_VMWARESERVER1_0_X_WINDOWS__1_3" >--VMware Server 1.0.x (Windows)</option>
          						            <option value="SG_VMWARESERVER2_0_X_LINUX__1_3" >--VMware Server 2.0.x (Linux)</option>
          						            <option value="SG_VMWARESERVER2_0_X_WINDOWS__1_3" >--VMware Server 2.0.x (Windows)</option>
          				 				            <option value="SG_VMWARESERVICEMANAGER_1_2" >VMware Service Manager</option>
          						            <option value="SG_VMWARESERVICEMANAGER7_X_1_3" >--VMware Service Manager 7.x</option>
          						            <option value="SG_VMWARESERVICEMANAGER8_X_1_3" >--VMware Service Manager 8.x</option>
          						            <option value="SG_VMWARESERVICEMANAGER9_X_1_3" >--VMware Service Manager 9.x</option>
          				 				            <option value="SG_VMWAREVCENTERAPPLICATIONDISCOVERYMANAGER_1_2" >VMware vCenter Application Discovery Manager</option>
          						            <option value="SG_VMWAREVCENTERAPPLICATIONDISCOVERYMANAGER5_X_1_3" >--VMware vCenter Application Discovery Manager 5.x</option>
          						            <option value="SG_VMWAREVCENTERAPPLICATIONDISCOVERYMANAGER6_X_1_3" >--VMware vCenter Application Discovery Manager 6.x</option>
          				 				            <option value="SG_VMWAREVCENTERAPPLICATIONSTACKMANAGER_1_2" >VMware vCenter Application Stack Manager</option>
          						            <option value="SG_VMWAREVCENTERAPPLICATIONSTACKMANAGER3_X_1_3" >--VMware vCenter Application Stack Manager 3.x</option>
          				 				            <option value="SG_VMWAREVCENTERAPPSPEED_1_2" >VMware vCenter AppSpeed</option>
          						            <option value="SG_VMWAREVCENTERAPPSPEED1_0_X_1_3" >--VMware vCenter AppSpeed 1.0.x</option>
          						            <option value="SG_VMWAREVCENTERAPPSPEED1_2_X_1_3" >--VMware vCenter AppSpeed 1.2.x</option>
          						            <option value="SG_VMWAREVCENTERAPPSPEED1_5_X_1_3" >--VMware vCenter AppSpeed 1.5.x</option>
          				 				            <option value="SG_VMWAREVCENTERCAPACITYIQ_1_2" >VMware vCenter CapacityIQ</option>
          						            <option value="SG_VMWAREVCENTERCAPACITYIQ1_0_X_1_3" >--VMware vCenter CapacityIQ 1.0.x</option>
          						            <option value="SG_VMWAREVCENTERCAPACITYIQ1_5_X_1_3" >--VMware vCenter CapacityIQ 1.5.x</option>
          				 				            <option value="SG_VMWAREVCENTERCHARGEBACK_1_2" >VMware vCenter Chargeback</option>
          						            <option value="SG_VMWAREVCENTERCHARGEBACK1_0_X_1_3" >--VMware vCenter Chargeback 1.0.x</option>
          						            <option value="SG_VMWAREVCENTERCHARGEBACK1_5_X_1_3" >--VMware vCenter Chargeback 1.5.x</option>
          						            <option value="SG_VMWAREVCENTERCHARGEBACK1_6_X_1_3" >--VMware vCenter Chargeback 1.6.x</option>
          				 				            <option value="SG_VMWAREVCENTERCHARGEBACKMANAGER_1_2" >VMware vCenter Chargeback Manager</option>
          						            <option value="SG_VMWAREVCENTERCHARGEBACKMANAGER2_0_X_1_3" >--VMware vCenter Chargeback Manager 2.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERCHARGEBACKMANAGERCONNECTORFORITBUSINESSMANAGEMENTSUITE_1_2" >VMware vCenter Chargeback Mgr Connector-ITBM</option>
          						            <option value="SG_VMWAREVCENTERCHARGEBACKMANAGERCONNECTORFORITBUSINESSMANAGEMENTSUITE7__2_3" >--VMware vCenter Chargeback Mgr Connector-ITBM 7.1.x</option>
          				 				            <option value="SG_VMWAREVCENTERCONFIGURATIONANALYTICSMANAGER_1_2" >VMware vCenter Configuration Analytics Manager</option>
          						            <option value="SG_VMWAREVCENTERCONFIGURATIONANALYTICSMANAGER3_X_1_3" >--VMware vCenter Configuration Analytics Manager 3.x</option>
          				 				            <option value="SG_VMWAREVCENTERCONFIGURATIONMANAGER_1_2" >VMware vCenter Configuration Manager</option>
          						            <option value="SG_VMWAREVCENTERCONFIGURATIONMANAGER4_X_1_3" >--VMware vCenter Configuration Manager 4.x</option>
          						            <option value="SG_VMWAREVCENTERCONFIGURATIONMANAGER5_X_1_3" >--VMware vCenter Configuration Manager 5.x</option>
          				 				            <option value="SG_VMWAREVCENTERCONVERTER_1_2" >VMware vCenter Converter</option>
          						            <option value="SG_VMWAREVCENTERCONVERTER4_0_X_1_3" >--VMware vCenter Converter 4.0.x</option>
          						            <option value="SG_VMWAREVCENTERCONVERTER4_1_X_1_3" >--VMware vCenter Converter 4.1.x</option>
          						            <option value="SG_VMWAREVCENTERCONVERTER4_2_X_1_3" >--VMware vCenter Converter 4.2.x</option>
          				 				            <option value="SG_VMWAREVCENTERCONVERTERSTANDALONE_1_2" >VMware vCenter Converter Standalone</option>
          						            <option value="SG_VMWAREVCENTERCONVERTERSTANDALONE4_0_X_1_3" >--VMware vCenter Converter Standalone 4.0.x</option>
          						            <option value="SG_VMWAREVCENTERCONVERTERSTANDALONE4_3_X_1_3" >--VMware vCenter Converter Standalone 4.3.x</option>
          						            <option value="SG_VMWAREVCENTERCONVERTERSTANDALONE5_0_X_1_3" >--VMware vCenter Converter Standalone 5.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERINFRASTRUCTURENAVIGATOR_1_2" >VMware vCenter Infrastructure Navigator</option>
          						            <option value="SG_VMWAREVCENTERINFRASTRUCTURENAVIGATOR1_0_X_1_3" >--VMware vCenter Infrastructure Navigator 1.0.x</option>
          						            <option value="SG_VMWAREVCENTERINFRASTRUCTURENAVIGATOR1_1_X_1_3" >--VMware vCenter Infrastructure Navigator 1.1.x</option>
          				 				            <option value="SG_VMWAREVCENTERLABMANAGER_1_2" >VMware vCenter Lab Manager</option>
          						            <option value="SG_VMWAREVCENTERLABMANAGER2_4_X_1_3" >--VMware vCenter Lab Manager 2.4.x</option>
          						            <option value="SG_VMWAREVCENTERLABMANAGER2_5_X_1_3" >--VMware vCenter Lab Manager 2.5.x</option>
          						            <option value="SG_VMWAREVCENTERLABMANAGER3_0_X_1_3" >--VMware vCenter Lab Manager 3.0.x</option>
          						            <option value="SG_VMWAREVCENTERLABMANAGER4_0_X_1_3" >--VMware vCenter Lab Manager 4.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERLIFECYCLEMANAGER_1_2" >VMware vCenter Lifecycle Manager</option>
          						            <option value="SG_VMWAREVCENTERLIFECYCLEMANAGER1_0_X_1_3" >--VMware vCenter Lifecycle Manager 1.0.x</option>
          						            <option value="SG_VMWAREVCENTERLIFECYCLEMANAGER1_1_X_1_3" >--VMware vCenter Lifecycle Manager 1.1.x</option>
          				 				            <option value="SG_VMWAREVCENTEROPERATIONSENTERPRISE_1_2" >VMware vCenter Operations Enterprise</option>
          						            <option value="SG_VMWAREVCENTEROPERATIONSENTERPRISE1_0_1_3" >--VMware vCenter Operations Enterprise 1.0.x</option>
          				 				            <option value="SG_VMWAREVCENTEROPERATIONSMANAGER_STANDALONE__1_2" >VMware vCenter Operations Manager (Standalone)</option>
          						            <option value="SG_VMWAREVCENTEROPERATIONSMANAGER_STANDALONE_5_X_1_3" >--VMware vCenter Operations Manager (Standalone) 5.x</option>
          				 				            <option value="SG_VMWAREVCENTEROPERATIONSMANAGER_VAPP__1_2" >VMware vCenter Operations Manager (vApp)</option>
          						            <option value="SG_VMWAREVCENTEROPERATIONSMANAGER_VAPP_5_X_1_3" >--VMware vCenter Operations Manager (vApp) 5.x</option>
          				 				            <option value="SG_VMWAREVCENTEROPERATIONSMANAGERFORVIEW_1_2" >VMware vCenter Operations Manager for View</option>
          						            <option value="SG_VMWAREVCENTEROPERATIONSMANAGERFORVIEW1_X_1_3" >--VMware vCenter Operations Manager for View 1.x</option>
          				 				            <option value="SG_VMWAREVCENTEROPERATIONSSTANDARD_1_2" >VMware vCenter Operations Standard</option>
          						            <option value="SG_VMWAREVCENTEROPERATIONSSTANDARD1_0_X_1_3" >--VMware vCenter Operations Standard 1.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERORCHESTRATOR_1_2" >VMware vCenter Orchestrator</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATOR4_0_X_1_3" >--VMware vCenter Orchestrator 4.0.x</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATOR4_1_X_1_3" >--VMware vCenter Orchestrator 4.1.x</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATOR4_2_X_1_3" >--VMware vCenter Orchestrator 4.2.x</option>
          				 				            <option value="SG_VMWAREVCENTERORCHESTRATORAPPLIANCE_1_2" >VMware vCenter Orchestrator Appliance</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATORAPPLIANCE4_2_X_1_3" >--VMware vCenter Orchestrator Appliance 4.2.x</option>
          				 				            <option value="SG_VMWAREVCENTERORCHESTRATORPLUGINFORVCLOUDDIRECTOR_1_2" >VMware vCenter Orchestrator Plugin for vCloud Director</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATORPLUGINFORVCLOUDDIRECTOR1_0_X_1_3" >--VMware vCenter Orchestrator Plugin for vCloud Director 1.0.x</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATORPLUGINFORVCLOUDDIRECTOR1_5_X_1_3" >--VMware vCenter Orchestrator Plugin for vCloud Director 1.5.x</option>
          				 				            <option value="SG_VMWAREVCENTERORCHESTRATORPLUGINFORVSHIELD_1_2" >VMware vCenter Orchestrator Plugin for vShield</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATORPLUGINFORVSHIELD5_X_1_3" >--VMware vCenter Orchestrator Plugin for vShield 5.x</option>
          				 				            <option value="SG_VMWAREVCENTERORCHESTRATORPLUGINFORVCENTERCHARGEBACKMANAGER_1_2" >VMware vCenter Orchestrator Plugin-Chargeback Mgr</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATORPLUGINFORVCENTERCHARGEBACKMANAGER2_0_X_1_3" >--VMware vCenter Orchestrator Plugin-Chargeback Mgr 2.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERPROTECTESSENTIALS_1_2" >VMware vCenter Protect Essentials</option>
          						            <option value="SG_VMWAREVCENTERPROTECTESSENTIALS8_0_X_1_3" >--VMware vCenter Protect Essentials 8.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERPROTECTESSENTIALSPLUS_1_2" >VMware vCenter Protect Essentials Plus</option>
          						            <option value="SG_VMWAREVCENTERPROTECTESSENTIALSPLUS8_0_X_1_3" >--VMware vCenter Protect Essentials Plus 8.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERPROTECTUPDATECATALOG_1_2" >VMware vCenter Protect Update Catalog</option>
          				 				            <option value="SG_VMWAREVCENTERSERVER_1_2" >VMware vCenter Server</option>
          						            <option value="SG_VMWAREVCENTERSERVER4_0_X_1_3" >--VMware vCenter Server 4.0.x</option>
          						            <option value="SG_VMWAREVCENTERSERVER4_1_X_1_3" >--VMware vCenter Server 4.1.x</option>
          						            <option value="SG_VMWAREVCENTERSERVER5_0_X_1_3" >--VMware vCenter Server 5.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERSERVERAPPLIANCE_1_2" >VMware vCenter Server Appliance</option>
          						            <option value="SG_VMWAREVCENTERSERVERAPPLIANCE5_0_1_3" >--VMware vCenter Server Appliance 5.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERSERVERHEARTBEAT_1_2" >VMware vCenter Server Heartbeat</option>
          						            <option value="SG_VMWAREVCENTERSERVERHEARTBEAT5_5_X_1_3" >--VMware vCenter Server Heartbeat 5.5.x</option>
          						            <option value="SG_VMWAREVCENTERSERVERHEARTBEAT6_3_X_1_3" >--VMware vCenter Server Heartbeat 6.3.x</option>
          						            <option value="SG_VMWAREVCENTERSERVERHEARTBEAT6_4_X_1_3" >--VMware vCenter Server Heartbeat 6.4.x</option>
          				 				            <option value="SG_VMWAREVCENTERSITERECOVERYMANAGER_1_2" >VMware vCenter Site Recovery Manager</option>
          						            <option value="SG_VMWAREVCENTERSITERECOVERYMANAGER1_0_X_1_3" >--VMware vCenter Site Recovery Manager 1.0.x</option>
          						            <option value="SG_VMWAREVCENTERSITERECOVERYMANAGER4_0_X_1_3" >--VMware vCenter Site Recovery Manager 4.0.x</option>
          						            <option value="SG_VMWAREVCENTERSITERECOVERYMANAGER4_1_X_1_3" >--VMware vCenter Site Recovery Manager 4.1.x</option>
          						            <option value="SG_VMWAREVCENTERSITERECOVERYMANAGER5_X_1_3" >--VMware vCenter Site Recovery Manager 5.x</option>
          				 				            <option value="SG_VMWAREVCENTERSTAGEMANAGER_1_2" >VMware vCenter Stage Manager</option>
          						            <option value="SG_VMWAREVCENTERSTAGEMANAGER1_0_X_1_3" >--VMware vCenter Stage Manager 1.0.x</option>
          				 				            <option value="SG_VMWAREVCENTERUPDATEMANAGER_1_2" >VMware vCenter Update Manager</option>
          						            <option value="SG_VMWAREVCENTERUPDATEMANAGER1_0_X_1_3" >--VMware vCenter Update Manager 1.0.x</option>
          						            <option value="SG_VMWAREVCENTERUPDATEMANAGER4_0_X_1_3" >--VMware vCenter Update Manager 4.0.x</option>
          						            <option value="SG_VMWAREVCENTERUPDATEMANAGER4_1_X_1_3" >--VMware vCenter Update Manager 4.1.x</option>
          						            <option value="SG_VMWAREVCENTERUPDATEMANAGER5_0_X_1_3" >--VMware vCenter Update Manager 5.0.x</option>
          				 				            <option value="SG_VMWAREVCLOUDCONNECTOR_1_2" >VMware vCloud Connector</option>
          						            <option value="SG_VMWAREVCLOUDCONNECTOR1_0_X_1_3" >--VMware vCloud Connector 1.0.x</option>
          						            <option value="SG_VMWAREVCLOUDCONNECTOR1_5_X_1_3" >--VMware vCloud Connector 1.5.x</option>
          				 				            <option value="SG_VMWAREVCLOUDDIRECTOR_1_2" >VMware vCloud Director</option>
          						            <option value="SG_VMWAREVCLOUDDIRECTOR1_0_X_1_3" >--VMware vCloud Director 1.0.x</option>
          						            <option value="SG_VMWAREVCLOUDDIRECTOR1_5_X_1_3" >--VMware vCloud Director 1.5.x</option>
          				 				            <option value="SG_VMWAREVCLOUDDIRECTORAPPLIANCE_1_2" >VMware vCloud Director Appliance</option>
          						            <option value="SG_VMWAREVCLOUDDIRECTORAPPLIANCE1_5_X_1_3" >--VMware vCloud Director Appliance 1.5.x</option>
          				 				            <option value="SG_VMWAREVCLOUDINTEGRATIONMANAGER_1_2" >VMware vCloud Integration Manager</option>
          						            <option value="SG_VMWAREVCLOUDINTEGRATIONMANAGER1_X_1_3" >--VMware vCloud Integration Manager 1.x</option>
          				 				            <option value="SG_VMWAREVCLOUDREQUESTMANAGER_1_2" >VMware vCloud Request Manager</option>
          						            <option value="SG_VMWAREVCLOUDREQUESTMANAGER1_0_X_1_3" >--VMware vCloud Request Manager 1.0.x</option>
          				 				            <option value="SG_VMWAREVCLOUDUSAGEMETER_1_2" >VMware vCloud Usage Meter</option>
          						            <option value="SG_VMWAREVCLOUDUSAGEMETER1_0_X_1_3" >--VMware vCloud Usage Meter 1.0.x</option>
          						            <option value="SG_VMWAREVCLOUDUSAGEMETER2_0_X_1_3" >--VMware vCloud Usage Meter 2.0.x</option>
          						            <option value="SG_VMWAREVCLOUDUSAGEMETER2_1_X_1_3" >--VMware vCloud Usage Meter 2.1.x</option>
          						            <option value="SG_VMWAREVCLOUDUSAGEMETER2_2_X_1_3" >--VMware vCloud Usage Meter 2.2.x</option>
          						            <option value="SG_VMWAREVCLOUDUSAGEMETER2_3_X_1_3" >--VMware vCloud Usage Meter 2.3.x</option>
          				 				            <option value="SG_VMWAREVFABRICADMINISTRATIONSERVER_1_2" >VMware vFabric Administration Server</option>
          						            <option value="SG_VMWAREVFABRICADMINISTRATIONSERVER1_0_1_3" >--VMware vFabric Administration Server 1.0</option>
          				 				            <option value="SG_VMWAREVFABRICAPPINSIGHT_1_2" >VMware vFabric AppInsight</option>
          						            <option value="SG_VMWAREVFABRICAPPINSIGHT1_0_1_3" >--VMware vFabric AppInsight 1.0</option>
          				 				            <option value="SG_VMWAREVFABRICAPPLICATIONDIRECTOR_1_2" >VMware vFabric Application Director</option>
          						            <option value="SG_VMWAREVFABRICAPPLICATIONDIRECTOR1_X_1_3" >--VMware vFabric Application Director 1.x</option>
          				 				            <option value="SG_VMWAREVFABRICDATADIRECTOR_1_2" >VMware vFabric Data Director</option>
          						            <option value="SG_VMWAREVFABRICDATADIRECTOR1_0_1_3" >--VMware vFabric Data Director 1.0</option>
          				 				            <option value="SG_VMWAREVFABRICENTERPRISEREADYSERVER_1_2" >VMware vFabric Enterprise Ready Server</option>
          						            <option value="SG_VMWAREVFABRICENTERPRISEREADYSERVER4_0_1_3" >--VMware vFabric Enterprise Ready Server 4.0</option>
          				 				            <option value="SG_VMWAREVFABRICGEMFIRE_1_2" >VMware vFabric GemFire</option>
          						            <option value="SG_VMWAREVFABRICGEMFIRE6_5_1_3" >--VMware vFabric GemFire 6.5</option>
          						            <option value="SG_VMWAREVFABRICGEMFIRE6_6_1_3" >--VMware vFabric GemFire 6.6</option>
          				 				            <option value="SG_VMWAREVFABRICHQAPI_1_2" >VMware vFabric Hqapi</option>
          						            <option value="SG_VMWAREVFABRICHQAPI2_X_1_3" >--VMware vFabric Hqapi 2.x</option>
          						            <option value="SG_VMWAREVFABRICHQAPI3_X_1_3" >--VMware vFabric Hqapi 3.x</option>
          						            <option value="SG_VMWAREVFABRICHQAPI4_X_1_3" >--VMware vFabric Hqapi 4.x</option>
          						            <option value="SG_VMWAREVFABRICHQAPI5_X_1_3" >--VMware vFabric Hqapi 5.x</option>
          				 				            <option value="SG_VMWAREVFABRICHYPERICAGENT_1_2" >VMware vFabric Hyperic Agent</option>
          						            <option value="SG_VMWAREVFABRICHYPERICAGENT4_2_X_1_3" >--VMware vFabric Hyperic Agent 4.2.x</option>
          						            <option value="SG_VMWAREVFABRICHYPERICAGENT4_3_X_1_3" >--VMware vFabric Hyperic Agent 4.3.x</option>
          						            <option value="SG_VMWAREVFABRICHYPERICAGENT4_4_X_1_3" >--VMware vFabric Hyperic Agent 4.4.x</option>
          						            <option value="SG_VMWAREVFABRICHYPERICAGENT4_5_X_1_3" >--VMware vFabric Hyperic Agent 4.5.x</option>
          						            <option value="SG_VMWAREVFABRICHYPERICAGENT4_6_X_1_3" >--VMware vFabric Hyperic Agent 4.6.x</option>
          				 				            <option value="SG_VMWAREVFABRICHYPERICSERVER_1_2" >VMware vFabric Hyperic Server</option>
          						            <option value="SG_VMWAREVFABRICHYPERICSERVER4_2_X_1_3" >--VMware vFabric Hyperic Server 4.2.x</option>
          						            <option value="SG_VMWAREVFABRICHYPERICSERVER4_3_X_1_3" >--VMware vFabric Hyperic Server 4.3.x</option>
          						            <option value="SG_VMWAREVFABRICHYPERICSERVER4_4_X_1_3" >--VMware vFabric Hyperic Server 4.4.x</option>
          						            <option value="SG_VMWAREVFABRICHYPERICSERVER4_5_X_1_3" >--VMware vFabric Hyperic Server 4.5.x</option>
          						            <option value="SG_VMWAREVFABRICHYPERICSERVER4_6_X_1_3" >--VMware vFabric Hyperic Server 4.6.x</option>
          				 				            <option value="SG_VMWAREVFABRICLICENSESERVER_1_2" >VMware vFabric License Server</option>
          						            <option value="SG_VMWAREVFABRICLICENSESERVER1_1_1_3" >--VMware vFabric License Server 1.1</option>
          				 				            <option value="SG_VMWAREVFABRICPOSTGRES_1_2" >VMware vFabric Postgres</option>
          						            <option value="SG_VMWAREVFABRICPOSTGRES9_0STANDARDEDITION_1_3" >--VMware vFabric Postgres Standard Edition 9.0</option>
          						            <option value="SG_VMWAREVFABRICPOSTGRESSTANDARDEDITION9_1_X_1_3" >--VMware vFabric Postgres Standard Edition 9.1.x</option>
          				 				            <option value="SG_VMWAREVFABRICRABBITMQ_1_2" >VMware vFabric RabbitMQ</option>
          						            <option value="SG_VMWAREVFABRICRABBITMQ1_1_3" >--VMware vFabric RabbitMQ 1</option>
          						            <option value="SG_VMWAREVFABRICRABBITMQ2_1_3" >--VMware vFabric RabbitMQ 2</option>
          				 				            <option value="SG_VMWAREVFABRICSQLFIRE_1_2" >VMware vFabric SQLFire</option>
          						            <option value="SG_VMWAREVFABRICSQLFIRE1_X_1_3" >--VMware vFabric SQLFire 1.x</option>
          				 				            <option value="SG_VMWAREVFABRICTCSERVER_1_2" >VMware vFabric tc Server</option>
          						            <option value="SG_VMWAREVFABRICTCSERVER2_0_1_3" >--VMware vFabric tc Server 2.0</option>
          						            <option value="SG_VMWAREVFABRICTCSERVER2_1_1_3" >--VMware vFabric tc Server 2.1</option>
          						            <option value="SG_VMWAREVFABRICTCSERVER2_5_1_3" >--VMware vFabric tc Server 2.5</option>
          						            <option value="SG_VMWAREVFABRICTCSERVER2_6_1_3" >--VMware vFabric tc Server 2.6</option>
          						            <option value="SG_VMWAREVFABRICTCSERVER2_7_1_3" >--VMware vFabric tc Server 2.7</option>
          				 				            <option value="SG_VMWAREVFABRICWEBSERVER_1_2" >VMware vFabric Web Server</option>
          						            <option value="SG_VMWAREVFABRICWEBSERVER5_0_1_3" >--VMware vFabric Web Server 5.0</option>
          						            <option value="SG_VMWAREVFABRICWEBSERVER5_1_1_3" >--VMware vFabric Web Server 5.1</option>
          				 				            <option value="SG_VMWAREVIRTUALCENTER_1_2" >VMware VirtualCenter</option>
          						            <option value="SG_VMWAREVIRTUALCENTER1_0_X_1_3" >--VMware VirtualCenter 1.0.x</option>
          						            <option value="SG_VMWAREVIRTUALCENTER1_1_X_1_3" >--VMware VirtualCenter 1.1.x</option>
          						            <option value="SG_VMWAREVIRTUALCENTER1_2_X_1_3" >--VMware VirtualCenter 1.2.x</option>
          						            <option value="SG_VMWAREVIRTUALCENTER1_3_X_1_3" >--VMware VirtualCenter 1.3.x</option>
          						            <option value="SG_VMWAREVIRTUALCENTER1_4_X_1_3" >--VMware VirtualCenter 1.4.x</option>
          						            <option value="SG_VMWAREVIRTUALCENTER2_0_X_1_3" >--VMware VirtualCenter 2.0.x</option>
          						            <option value="SG_VMWAREVIRTUALCENTER2_5_X_1_3" >--VMware VirtualCenter 2.5.x</option>
          				 				            <option value="SG_VMWAREVSHIELDMANAGER_1_2" >VMware vShield</option>
          						            <option value="SG_VMWAREVSHIELDMANAGER4_1_X_1_3" >--VMware vShield 4.1.x</option>
          						            <option value="SG_VMWAREVSHIELD5_0_X_1_3" >--VMware vShield 5.0.x</option>
          				 				            <option value="SG_VMWAREVSHIELDAPP_1_2" >VMware vShield App</option>
          						            <option value="SG_VMWAREVSHIELDAPP1_0_X_1_3" >--VMware vShield App 1.0.x</option>
          						            <option value="SG_VMWAREVSHIELDAPP5_0_X_1_3" >--VMware vShield App 5.0.x</option>
          				 				            <option value="SG_VMWAREVSHIELDAPPWITHDATASECURITY_1_2" >VMware vShield App with Data Security</option>
          						            <option value="SG_VMWAREVSHIELDAPPWITHDATASECURITY5_0_X_1_3" >--VMware vShield App with Data Security 5.0.x</option>
          				 				            <option value="SG_VMWAREVSHIELDEDGE_1_2" >VMware vShield Edge</option>
          						            <option value="SG_VMWAREVSHIELDEDGE1_0_X_1_3" >--VMware vShield Edge 1.0.x</option>
          						            <option value="SG_VMWAREVSHIELDEDGE5_0_X_1_3" >--VMware vShield Edge 5.0.x</option>
          				 				            <option value="SG_VMWAREVSHIELDENDPOINT_1_2" >VMware vShield Endpoint</option>
          						            <option value="SG_VMWAREVSHIELDENDPOINT1_0_X_1_3" >--VMware vShield Endpoint 1.0.x</option>
          						            <option value="SG_VMWAREVSHIELDENDPOINT5_0_X_1_3" >--VMware vShield Endpoint 5.0.x</option>
          				 				            <option value="SG_VMWAREVSHIELDZONES_1_2" >VMware vShield Zones</option>
          						            <option value="SG_VMWAREVSHIELDZONES1_0_X_1_3" >--VMware vShield Zones 1.0.x</option>
          						            <option value="SG_VMWAREVSHIELDZONES4_1_X_1_3" >--VMware vShield Zones 4.1.x</option>
          				 				            <option value="SG_VMWAREVSPHEREMANAGEMENTASSISTANT_1_2" >VMware vSphere Management Assistant</option>
          						            <option value="SG_VMWAREVSPHEREMANAGEMENTASSISTANT4_0_X_1_3" >--VMware vSphere Management Assistant 4.0</option>
          						            <option value="SG_VMWAREVSPHEREMANAGEMENTASSISTANT4_1_1_3" >--VMware vSphere Management Assistant 4.1</option>
          						            <option value="SG_VMWAREVSPHEREMANAGEMENTASSISTANT5_0_1_3" >--VMware vSphere Management Assistant 5.0</option>
          				 				            <option value="SG_VMWAREVSPHERESTORAGEAPPLIANCE_1_2" >VMware vSphere Storage Appliance</option>
          						            <option value="SG_VMWAREVSPHERESTORAGEAPPLIANCE1_0_1_3" >--VMware vSphere Storage Appliance 1.0.x</option>
          				 				            <option value="SG_VMWAREVSPHEREUPDATEMANAGER_1_2" >VMware vSphere Update Manager</option>
          						            <option value="SG_VMWAREVSPHEREUPDATEMANAGER5_0_X_1_3" >--VMware vSphere Update Manager 5.0.x</option>
          				 				            <option value="SG_VMWAREVSPHEREWEBACCESS_1_2" >VMware vSphere Web Access</option>
          						            <option value="SG_VMWAREVSPHEREWEBACCESS4_0_X_1_3" >--VMware vSphere Web Access 4.0.x</option>
          				 				            <option value="SG_VMWAREVSPHEREWEBCLIENT_1_2" >VMware vSphere Web Client</option>
          						            <option value="SG_VMWAREVSPHEREWEBCLIENT5_0_X_1_3" >--VMware vSphere Web Client 5.0.x</option>
          				 				            <option value="SG_VMWAREWORKBENCH_1_2" >VMware Workbench</option>
          						            <option value="SG_VMWAREWORKBENCH1_X_1_3" >--VMware Workbench 1.x</option>
          				 				            <option value="SG_ZIMBRACOLLABORATIONAPPLIANCE_1_2" >Zimbra Collaboration Appliance</option>
          						            <option value="SG_ZCAZIMBRAAPPLIANCE6_0_X_1_3" >--ZCA Zimbra Appliance 6.0.x</option>
          				 				            <option value="SG_ZIMBRACOLLABORATIONSERVER_1_2" >Zimbra Collaboration Server</option>
          						            <option value="SG_ZCSNETWORKEDITION6_0_X_1_3" >--ZCS Network Edition 6.0.x</option>
          						            <option value="SG_ZCSNETWORKEDITION7_0_X_1_3" >--ZCS Network Edition 7.0.x</option>
          						            <option value="SG_ZCSNETWORKEDITION7_1_X_1_3" >--ZCS Network Edition 7.1.x</option>
          						            <option value="SG_ZIMBRAZCSNETWORKEDITION7_2_X_1_3" >--ZCS Network Edition 7.2.x</option>
          						            <option value="SG_ZCSOPENSOURCEEDITION6_0_X_1_3" >--ZCS Open Source Edition 6.0.x</option>
          						            <option value="SG_ZCSOPENSOURCEEDITION7_0_X_1_3" >--ZCS Open Source Edition 7.0.x</option>
          						            <option value="SG_ZCSOPENSOURCEEDITION7_1_X_1_3" >--ZCS Open Source Edition 7.1.x</option>
          						            <option value="SG_ZCSOPENSOURCEEDITION7_2_X_1_3" >--ZCS Open Source Edition 7.2.x</option>
          				 				            <option value="SG_ZIMBRACONNECTORS_1_2" >Zimbra Connectors</option>
          						            <option value="SG_CONNECTORFORAPPLEISYNC_1_3" >--Connector for Apple iSync</option>
          						            <option value="SG_CONNECTORFORBES6_0_X_1_3" >--Connector for BES 6.0.x</option>
          						            <option value="SG_CONNECTORFORBES7_1_X_1_3" >--Connector for BES 7.1.x</option>
          						            <option value="SG_CONNECTORFOROUTLOOK6_0_X_1_3" >--Connector for Outlook 6.0.x</option>
          						            <option value="SG_CONNECTORFOROUTLOOK7_1_X_1_3" >--Connector for Outlook 7.1.x</option>
          				 				            <option value="SG_ZIMBRADESKTOP_1_2" >Zimbra Desktop</option>
          						            <option value="SG_ZIMBRADESKTOP7_0_X_1_3" >--Zimbra Desktop 7.0.x</option>
          						            <option value="SG_ZIMBRADESKTOP7_1_X_1_3" >--Zimbra Desktop 7.1.x</option>
          						            <option value="SG_DESKTOP_1_1" >Desktop</option>
          				 				            <option value="SG_VMWAREACE_1_2" >VMware ACE</option>
          						            <option value="SG_VMWAREACE1_0_X_1_3" >--VMware ACE 1.0.x</option>
          						            <option value="SG_VMWAREACE2_0_X_1_3" >--VMware ACE 2.0.x</option>
          						            <option value="SG_VMWAREACE2_5_X_1_3" >--VMware ACE 2.5.x</option>
          						            <option value="SG_VMWAREACE2_6_X_1_3" >--VMware ACE 2.6.x</option>
          						            <option value="SG_VMWAREACE2_7_X_1_3" >--VMware ACE 2.7.x</option>
          				 				            <option value="SG_VMWAREFUSION_1_2" >VMware Fusion</option>
          						            <option value="SG_VMWAREFUSION1_X_1_3" >--VMware Fusion 1.x</option>
          						            <option value="SG_VMWAREFUSION2_X_1_3" >--VMware Fusion 2.x</option>
          						            <option value="SG_VMWAREFUSION3_X_1_3" >--VMware Fusion 3.x</option>
          						            <option value="SG_VMWAREFUSION4_X_1_3" >--VMware Fusion 4.x</option>
          				 				            <option value="SG_VMWAREHORIZONAPPLICATIONMANAGER_1_2" >VMware Horizon Application Manager</option>
          						            <option value="SG_VMWAREHORIZONAPPLICATIONMANAGER1_0_1_3" >--VMware Horizon Application Manager (Hosted) 1.x</option>
          						            <option value="SG_VMWAREHORIZONAPPLICATIONMANAGER_VAPP_1_X_1_3" >--VMware Horizon Application Manager (vApp) 1.x</option>
          						            <option value="SG_VMWAREHORIZONAPPLICATIONMANAGERCONNECTOR1_0_1_3" >--VMware Horizon Connector 1.x</option>
          				 				            <option value="SG_VMWAREPLAYER_1_2" >VMware Player</option>
          						            <option value="SG_VMWAREPLAYER1_X_LINUX__1_3" >--VMware Player 1.x (Linux)</option>
          						            <option value="SG_VMWAREPLAYER1_X_WINDOWS__1_3" >--VMware Player 1.x (Windows)</option>
          						            <option value="SG_VMWAREPLAYER2_X_LINUX__1_3" >--VMware Player 2.x (Linux)</option>
          						            <option value="SG_VMWAREPLAYER2_X_WINDOWS__1_3" >--VMware Player 2.x (Windows)</option>
          						            <option value="SG_VMWAREPLAYER3_X_LINUX__1_3" >--VMware Player 3.x (Linux)</option>
          						            <option value="SG_VMWAREPLAYER3_X_WINDOWS__1_3" >--VMware Player 3.x (Windows )</option>
          						            <option value="SG_VMWAREPLAYER4_X_LINUX__1_3" >--VMware Player 4.x (Linux)</option>
          						            <option value="SG_VMWAREPLAYER4_X_WINDOWS__1_3" >--VMware Player 4.x (Windows)</option>
          				 				            <option value="SG_VMWARESTUDIO_1_2" >VMware Studio</option>
          						            <option value="SG_VMWARESTUDIO1_X_1_3" >--VMware Studio 1.x</option>
          						            <option value="SG_VMWARESTUDIO2_X_1_3" >--VMware Studio 2.x</option>
          				 				            <option value="SG_VMWARETHINAPP_1_2" >VMware ThinApp</option>
          						            <option value="SG_VMWARETHINAPP4_X_1_3" >--VMware ThinApp 4.x</option>
          				 				            <option value="SG_VMWARETHINSTALL_1_2" >VMware ThinStall</option>
          						            <option value="SG_VMWARETHINSTALL2_X_1_3" >--VMware ThinStall 2.x</option>
          						            <option value="SG_VMWARETHINSTALL3_X_1_3" >--VMware ThinStall 3.x</option>
          				 				            <option value="SG_VMWAREVIEWMANAGER_1_2" >VMware View Manager</option>
          						            <option value="SG_VMWAREVIEWMANAGER3_X_1_3" >--VMware View Manager 3.x</option>
          						            <option value="SG_VMWAREVIEWMANAGER4_0_X_1_3" >--VMware View Manager 4.0.x</option>
          						            <option value="SG_VMWAREVIEWMANAGER4_5_X_1_3" >--VMware View Manager 4.5.x</option>
          						            <option value="SG_VMWAREVIEWMANAGER4_6_X_1_3" >--VMware View Manager 4.6.x</option>
          						            <option value="SG_VMWAREVIEWMANAGER5_0_X_1_3" >--VMware View Manager 5.0.x</option>
          						            <option value="SG_VMWAREVIEWMANAGER5_1_X_1_3" >--VMware View Manager 5.1.x</option>
          				 				            <option value="SG_VMWAREVIRTUALDESKTOPMANAGER_1_2" >VMware Virtual Desktop Manager</option>
          						            <option value="SG_VMWAREVIRTUALDESKTOPMANAGER1_X_1_3" >--VMware Virtual Desktop Manager 1.x</option>
          						            <option value="SG_VMWAREVIRTUALDESKTOPMANAGER2_X_1_3" >--VMware Virtual Desktop Manager 2.x</option>
          				 				            <option value="SG_VMWAREWORKSTATION_1_2" >VMware Workstation</option>
          						            <option value="SG_VMWAREWORKSTATION3_X_LINUX__1_3" >--VMware Workstation 3.x (Linux)</option>
          						            <option value="SG_VMWAREWORKSTATION3_X_WINDOWS__1_3" >--VMware Workstation 3.x (Windows)</option>
          						            <option value="SG_VMWAREWORKSTATION4_X_LINUX__1_3" >--VMware Workstation 4.x (Linux)</option>
          						            <option value="SG_VMWAREWORKSTATION4_X_WINDOWS__1_3" >--VMware Workstation 4.x (Windows)</option>
          						            <option value="SG_VMWAREWORKSTATION5_X_LINUX__1_3" >--VMware Workstation 5.x (Linux)</option>
          						            <option value="SG_VMWAREWORKSTATION5_X_WINDOWS__1_3" >--VMware Workstation 5.x (Windows)</option>
          						            <option value="SG_VMWAREWORKSTATION6_X_LINUX__1_3" >--VMware Workstation 6.x (Linux)</option>
          						            <option value="SG_VMWAREWORKSTATION6_X_WINDOWS__1_3" >--VMware Workstation 6.x (Windows)</option>
          						            <option value="SG_VMWAREWORKSTATION7_X_LINUX__1_3" >--VMware Workstation 7.x (Linux)</option>
          						            <option value="SG_VMWAREWORKSTATION7_X_WINDOWS__1_3" >--VMware Workstation 7.x (Windows)</option>
          						            <option value="SG_VMWAREWORKSTATION8_X_LINUX__1_3" >--VMware Workstation 8.x (Linux)</option>
          						            <option value="SG_VMWAREWORKSTATION8_X_WINDOWS__1_3" >--VMware Workstation 8.x (Windows)</option>
          						            <option value="SG_DEVELOPERSUPPORT_1_1" >Developer Support</option>
          				 				            <option value="SG_GRAILS_1_2" >Grails</option>
          						            <option value="SG_GRAILS1_2_1_3" >--Grails 1.2</option>
          						            <option value="SG_GRAILS1_3_1_3" >--Grails 1.3</option>
          				 				            <option value="SG_GROOVY_1_2" >Groovy</option>
          						            <option value="SG_GROOVY1_6_1_3" >--Groovy 1.6</option>
          						            <option value="SG_GROOVY1_7_1_3" >--Groovy 1.7</option>
          				 				            <option value="SG_SPRINGBATCH_1_2" >Spring Batch</option>
          						            <option value="SG_SPRINGBATCH1_0_1_3" >--Spring Batch 1.0</option>
          						            <option value="SG_SPRINGBATCH2_0_1_3" >--Spring Batch 2.0</option>
          						            <option value="SG_SPRINGBATCH2_1_1_3" >--Spring Batch 2.1</option>
          				 				            <option value="SG_SPRINGFRAMEWORK_1_2" >Spring Framework</option>
          						            <option value="SG_SPRINGFRAMEWORK2_5_1_3" >--Spring Framework 2.5</option>
          						            <option value="SG_SPRINGFRAMEWORK3_0_1_3" >--Spring Framework 3.0</option>
          						            <option value="SG_SPRINGFRAMEWORK3_1_1_3" >--Spring Framework 3.1</option>
          				 				            <option value="SG_SPRINGINTEGRATION_1_2" >Spring Integration</option>
          						            <option value="SG_SPRINGINTEGRATION1_0_1_3" >--Spring Integration 1.0</option>
          						            <option value="SG_SPRINGINTEGRATION2_0_1_3" >--Spring Integration 2.0</option>
          				 				            <option value="SG_SPRINGROO_1_2" >Spring Roo</option>
          						            <option value="SG_SPRINGROO1_1_1_3" >--Spring Roo 1.1</option>
          				 				            <option value="SG_SPRINGSECURITY_1_2" >Spring Security</option>
          						            <option value="SG_SPRINGSECURITY2_0_1_3" >--Spring Security 2.0</option>
          						            <option value="SG_SPRINGSECURITY3_0_1_3" >--Spring Security 3.0</option>
          						            <option value="SG_SPRINGSECURITY3_1_1_3" >--Spring Security 3.1</option>
          				 				            <option value="SG_SPRINGWEBFLOW_1_2" >Spring Web Flow</option>
          						            <option value="SG_SPRINGWEBFLOW2_0_1_3" >--Spring Web Flow 2.0</option>
          						            <option value="SG_SPRINGWEBFLOW2_2_1_3" >--Spring Web Flow 2.2</option>
          						            <option value="SG_SPRINGWEBFLOW3_0_1_3" >--Spring Web Flow 3.0</option>
          				 				            <option value="SG_SPRINGWEBSERVICES_1_2" >Spring Web Services</option>
          						            <option value="SG_SPRINGWEBSERVICES1_5_1_3" >--Spring Web Services 1.5</option>
          						            <option value="SG_SPRINGWEBSERVICES2_0_1_3" >--Spring Web Services 2.0</option>
          				 				            <option value="SG_SPRINGSOURCEOTHER_1_2" >SpringSource Other</option>
          				 				            <option value="SG_SPRINGSOURCETOOLSUITE_1_2" >SpringSource Tool Suite</option>
          						            <option value="SG_SPRINGSOURCETOOLSUITE2_3_1_3" >--SpringSource Tool Suite 2.3</option>
          						            <option value="SG_SPRINGSOURCETOOLSUITE2_5_1_3" >--SpringSource Tool Suite 2.5</option>
          						            <option value="SG_SPRINGSOURCETOOLSUITE2_6_1_3" >--SpringSource Tool Suite 2.6</option>
          				 				            <option value="SG_VMWARECIMSDK_SMASH_SMI_S__1_2" >VMware CIM SDK (SMASH - SMI-S)</option>
          						            <option value="SG_VMWARECIMSDK4_0_1_3" >--VMware CIM SDK 4.0</option>
          						            <option value="SG_VMWARECIMSDK4_1_1_3" >--VMware CIM SDK 4.1</option>
          						            <option value="SG_VMWARECIMSDKFORESX3_0_1_3" >--VMware CIM SDK for ESX 3.0</option>
          				 				            <option value="SG_VMWAREVCENTERCHARGEBACKAPI_1_2" >VMware vCenter Chargeback API</option>
          						            <option value="SG_VMWAREVCENTERCHARGEBACKAPI1_5_1_3" >--VMware vCenter Chargeback API 1.5</option>
          						            <option value="SG_VMWAREVCENTERCHARGEBACKAPI2_0_1_3" >--VMware vCenter Chargeback API 2.0</option>
          				 				            <option value="SG_VMWAREVCENTERORCHESTRATORAPI_1_2" >VMware vCenter Orchestrator API</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATORAPI4_0_1_3" >--VMware vCenter Orchestrator API 4.0</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATORAPI4_1_1_3" >--VMware vCenter Orchestrator API 4.1</option>
          						            <option value="SG_VMWAREVCENTERORCHESTRATORAPI4_2_1_3" >--VMware vCenter Orchestrator API 4.2</option>
          				 				            <option value="SG_VMWAREVCLOUDAPI_1_2" >VMware vCloud API</option>
          						            <option value="SG_VMWAREVCLOUDAPI1_0_1_3" >--VMware vCloud API 1.0</option>
          						            <option value="SG_VMWAREVCLOUDAPI1_0_1_1_3" >--VMware vCloud API 1.0.1</option>
          						            <option value="SG_VMWAREVCLOUDAPI1_5_1_3" >--VMware vCloud API 1.5</option>
          				 				            <option value="SG_VMWAREVFABRICSPRINGENTERPRISE_1_2" >VMware vFabric Spring Enterprise</option>
          						            <option value="SG_VMWAREVFABRICSPRINGENTERPRISE2_5_1_3" >--VMware vFabric Spring Enterprise 2.5</option>
          						            <option value="SG_VMWAREVFABRICSPRINGENTERPRISE3_0_1_3" >--VMware vFabric Spring Enterprise 3.0</option>
          						            <option value="SG_VMWAREVFABRICSPRINGENTERPRISE3_1_1_3" >--VMware vFabric Spring Enterprise 3.1</option>
          				 				            <option value="SG_VMWAREVIRTUALDISKDEVELOPMENT_1_2" >VMware Virtual Disk Development</option>
          						            <option value="SG_VIRTUALDISKDEVELOPMENTKIT1_0_1_1_3" >--Virtual Disk Development Kit 1.0.1</option>
          						            <option value="SG_VIRTUALDISKDEVELOPMENTKIT1_1_0_1_3" >--Virtual Disk Development Kit 1.1.0</option>
          						            <option value="SG_VIRTUALDISKDEVELOPMENTKIT1_1_1_1_3" >--Virtual Disk Development Kit 1.1.1</option>
          						            <option value="SG_VMWAREVIRTUALDISKDEVELOPMENT1_2_1_3" >--Virtual Disk Development Kit 1.2</option>
          						            <option value="SG_VIRTUALDISKDEVELOPMENTKIT1_2_1_1_3" >--Virtual Disk Development Kit 1.2.1</option>
          						            <option value="SG_VIRTUALDISKDEVELOPMENTKIT5_0_1_3" >--Virtual Disk Development Kit 5.0</option>
          				 				            <option value="SG_VMWAREVIXAPI_1_2" >VMware VIX API</option>
          						            <option value="SG_VMWAREVIXAPI1_10_1_3" >--VMware VIX API 1.10</option>
          						            <option value="SG_VMWAREVIXAPI1_11_1_3" >--VMware VIX API 1.11</option>
          						            <option value="SG_VMWAREVIXAPI1_7_0_1_3" >--VMware VIX API 1.7.0</option>
          						            <option value="SG_VMWAREVIXAPI1_8_1_1_3" >--VMware VIX API 1.8.1</option>
          						            <option value="SG_VMWAREVIXAPI1_9_1_3" >--VMware VIX API 1.9</option>
          				 				            <option value="SG_VMWAREVSPHERECLI_1_2" >VMware vSphere CLI</option>
          						            <option value="SG_VMWAREVSPHERECLI4_0_1_3" >--VMware vSphere CLI 4.0</option>
          						            <option value="SG_VMWAREVSPHERECLI4_1_1_3" >--VMware vSphere CLI 4.1</option>
          						            <option value="SG_VMWAREVSPHERECLI5_0_1_3" >--VMware vSphere CLI 5.0</option>
          				 				            <option value="SG_VMWAREVSPHERECLIENTPLUG_INS_1_2" >VMware vSphere Client Plug-ins</option>
          						            <option value="SG_VMWAREVSPHERECLIENTPLUG_INS4_0_1_3" >--VMware vSphere Client Plug-ins 4.0</option>
          						            <option value="SG_VMWAREVSPHERECLIENTPLUG_INS4_1_1_3" >--VMware vSphere Client Plug-ins 4.1</option>
          						            <option value="SG_VMWAREVSPHERECLIENTPLUG_INS5_0_1_3" >--VMware vSphere Client Plug-ins 5.0</option>
          				 				            <option value="SG_VMWAREVSPHEREGUESTSDK_1_2" >VMware vSphere Guest SDK</option>
          						            <option value="SG_VMWAREVSPHEREGUESTSDK3_5_1_3" >--VMware vSphere Guest SDK 3.5</option>
          						            <option value="SG_VMWAREVSPHEREGUESTSDK4_0_1_3" >--VMware vSphere Guest SDK 4.0</option>
          				 				            <option value="SG_VMWAREVSPHEREPOWERCLI_1_2" >VMware vSphere PowerCLI</option>
          						            <option value="SG_VITOOLKIT_FORWINDOWS_1_0_1_3" >--VI Toolkit (for Windows) 1.0</option>
          						            <option value="SG_VITOOLKIT_FORWINDOWS_1_5_1_3" >--VI Toolkit (for Windows) 1.5</option>
          						            <option value="SG_VMWAREVSPHEREPOWERCLI4_0_1_3" >--VMware vSphere PowerCLI 4.0</option>
          						            <option value="SG_VMWAREVSPHEREPOWERCLI4_1_1_3" >--VMware vSphere PowerCLI 4.1</option>
          						            <option value="SG_VMWAREVSPHEREPOWERCLI5_0_1_3" >--VMware vSphere PowerCLI 5.0</option>
          						            <option value="SG_VMWAREVSPHEREPOWERCLI5_0_1_1_3" >--VMware vSphere PowerCLI 5.0.1</option>
          				 				            <option value="SG_VMWAREVSPHERESDKFORPERL_1_2" >VMware vSphere SDK for Perl</option>
          						            <option value="SG_VIPERLTOOLKIT1_0_1_3" >--VI Perl Toolkit 1.0</option>
          						            <option value="SG_VIPERLTOOLKIT1_5_1_3" >--VI Perl Toolkit 1.5</option>
          						            <option value="SG_VIPERLTOOLKIT1_6_1_3" >--VI Perl Toolkit 1.6</option>
          						            <option value="SG_VMWAREVSPHERESDKFORPERL4_0_1_3" >--VMware vSphere SDK for Perl 4.0</option>
          						            <option value="SG_VMWAREVSPHERESDKFORPERL4_1_1_3" >--VMware vSphere SDK for Perl 4.1</option>
          						            <option value="SG_VMWAREVSPHERESDKFORPERL5_0_1_3" >--VMware vSphere SDK for Perl 5.0</option>
          				 				            <option value="SG_VMWAREVSPHEREWEBSERVICESSDK_1_2" >VMware vSphere Web Services SDK</option>
          						            <option value="SG_VISDK2_0_1_3" >--VI SDK 2.0</option>
          						            <option value="SG_VISDK2_5_1_3" >--VI SDK 2.5</option>
          						            <option value="SG_VMWAREVSPHEREWEBSERVICESSDK4_0_1_3" >--VMware vSphere Web Services SDK 4.0</option>
          						            <option value="SG_VMWAREVSPHEREWEBSERVICESSDK4_1_1_3" >--VMware vSphere Web Services SDK 4.1</option>
          						            <option value="SG_VMWAREVSPHEREWEBSERVICESSDK5_0_1_3" >--VMware vSphere Web Services SDK 5.0</option>
          				 				            <option value="SG_WAVEMAKER_1_2" >WaveMaker</option>
          						            <option value="SG_WAVEMAKER6_2_1_3" >--WaveMaker 6.2</option>
          						            <option value="SG_WAVEMAKER6_3_1_3" >--WaveMaker 6.3</option>
          						            <option value="SG_MYVMWARE_1_1" >My VMware</option>
          						            <option value="SG_VOLUMEPURCHASINGPROGRAM_1_1" >Volume Purchasing Program</option>
              </select>
    </td>
    		        	 							        	        	                                				    	  	    	  	    		    		                                    		                <td style="padding:5px;" align="left" valign="middle">
    <select name="category"  class="control_category"  >	
          						            <option value="noselection"  selected >Category --&gt;</option>
          						            <option value="UMTG_BESTPRACTICES_1_1" >Best Practices</option>
          						            <option value="UMTG_HOWTO_1_1" >How to</option>
          						            <option value="UMTG_INFORMATIONAL_CATEGORY_1_1" >Informational</option>
          						            <option value="UMTG_LICENSING_1_1" >Licensing</option>
          						            <option value="UMTG_PATCH_1_1" >Patch</option>
          						            <option value="UMTG_TROUBLESHOOTING_1_1" >Troubleshooting</option>
          						            <option value="UMTG_VIDEO_CATEGORY_1_1" >Video</option>
              </select>
    </td>
    		        	 															        	        	                                				    	  	    	  	    		    		                            			    				<input type="hidden"  name="document" value="DT_KB_1_1" style="width:10">
    			                    	 												<td align="center" valign="middle" width="18%"></td>

									</tr>
								</table>
								<input type="hidden" name="searchMode" value="GuidedSearch">
																	<input type="hidden" name="rwTarget" value="/rfPlayerWidget.do">
																<input type="hidden" name="cmd" value="search" />
								<input type="hidden" name="productFamily" value="">
																	<textarea name="forum" style="display:none;visibility:hide"></textarea>
																																	<input type="hidden" name="accesslevels" value="SAL_Public">
																									<input type="hidden" name="locale" value="LA_eng_US">
																<input type="hidden" name="contextType" value="gs">
								<input type="hidden" name="showsplink" value="true">
								<input type="hidden" name="showSavedSearches" value="true">
								<input type="hidden" name="usemicrosite" value="true" />
								<input type="hidden" name="evaluateRF" value="true" />
								<input type="hidden" name="searchFor" value=""/>
							</form>
						</td>				
						<td valign="top" align="left">
							<form name="searchForm" id="id_searchForm2" method="post" action="searchEntry.do" onsubmit="return validateForm(this)">
								<table border="0" cellpadding="0" cellspacing="0" width="90%">
									<tr>
									<td style="padding: 5px;" align="center" valign="top" width="85%"><input name="searchString" width="5" maxlength="10" class="control_documentid"  value="" ></td>
									<td align="center" valign="top" width="15%"><input name="btnSearchAll" class="btn-knova-openbyid" value="" type="submit"></td>
									</tr>					
								</table>	
								<input type="hidden" name="searchMode" value="GuidedSearch">
																	<input type="hidden" name="rwTarget" value="/rfPlayerWidget.do">
																<input type="hidden" name="cmd" value="search" />
								<input type="hidden" name="productFamily" value="">
																	<textarea name="forum" style="display:none;visibility:hide"></textarea>
																<textarea name="document" style="display:none;visibility:hide">DT_KB_1_1</textarea>								
																	<input type="hidden" name="accesslevels" value="SAL_Public">
																									<input type="hidden" name="locale" value="LA_eng_US">
																<input type="hidden" name="contextType" value="gs">
								<input type="hidden" name="showsplink" value="true">
								<input type="hidden" name="showSavedSearches" value="true">
								<input type="hidden" name="usemicrosite" value="true" />
								<input type="hidden" name="evaluateRF" value="true" />
								<input type="hidden" name="product" value="" />
								<input type="hidden" name="searchFor" value="externalID" />
							</form>
						</td>			
					</tr>		
				</table>		
			</td>
		</tr>
	</table>	
	<div class="vmsearchentrybottom noprint">&nbsp;</div>
</div>


	

	<!-- /Search Entry-->
	
    <table cellpadding="0" cellspacing="0" width="100%" border="0">
    <tr>
	<td  valign=top  style="padding: 0px 0px 0px 0px">
		<!-- Search Results-->
			<!--a href="javascript:changeDocType('noselection')">All</a--> 
<div class="tabhead">
	<ul>
		<li><a href="javascript:changeDocType('DT_KB_1_1')" class="first active"><span>KB Articles</span></a></li>
		<li><a href="javascript:changeDocType('DT_PRODUCTDOCUMENTATION_1_1')" class=""><span>Product Documentation</span></a></li>
		<li><a href="javascript:changeDocType('DT_COMMUNITIES_1_1')" class="last "><span>Communities</span></a></li>
		
		<li><a href="javascript:changeDocType('DT_WIKI_1_1')" class="last "><span>Wiki</span></a></li>
		
	</ul>
</div>
        
		
			
			
					
	<script type="text/javascript" language="JavaScript">
    if (document.getElementById("savesearch_guided") != null){
	document.getElementById("savesearch_guided").style.visibility = 'visible';
    }
    if (document.getElementById("savesearch_adv") != null){
		document.getElementById("savesearch_adv").style.visibility = 'visible';
		document.getElementById("savesearch_adv").style.display = 'block';	
    }

	function strReplace(str1, str2, str3) {
	  while(str1.indexOf(str2) != -1) {
	   str1 = str1.replace(str2, str3);
	 }
	  return str1;
	}
	function fixUrl(url){
	 url= strReplace(url,"#","%23");
	 url= strReplace(url,"+","%2b");
	 return url;
	}
	function viewRFDoc(docType, kcId, sliceId, bbId)
	{
	  var fm = document.rwForm;

	  fm.docType.value = docType;
	  fm.kcId.value = kcId;
	  fm.sliceId.value = sliceId;
	  fm.bestBetId.value = bbId;

	  fm.RF_command.value = "fetch";
	  fm.NextStep.value = "false";
	  return fm.submit();
	}

	function openViewDoc(url, cpconceptid)
	{
			if( window.openViewDocOverloaded ) {
					window.openViewDocOverloaded( url, cpconceptid );
					return;
			}

	    var isRF = false;
			// You can implement this method to add any param into url
			if( window.getAdditionalViewDocParams ) {
			  var addParams = getAdditionalViewDocParams();
			  if( addParams )
					url += addParams;
			}
			var newWindow=false;
			var fullScreen = false;
			if( fullScreen ) newWindow = true;
	    url=fixUrl(url);
	    if(newWindow){
	    	var width= fullScreen ? screen.width : 800;
	    	var height = fullScreen ? screen.height : 600;
	      window.open(url+'&ispopup=1','viewDoc', 'toolbar=0,location=no,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width=' + width + ',height=' + height + ',top=0,left=0').focus();
	    }else if ( cpconceptid == null || cpconceptid.length == 0 ){
          window.location.replace(url,'viewDoc', 'toolbar=0,location=no,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width=800,height=600,top=0,left=0');
	    } else {
	      window.document.cpplayer.action=url;
	      window.document.cpplayer.method="POST";
	      window.document.cpplayer.submit();
	    }
	}

	function addResponseDoc(url,title)
	{
	    //called when "adding" a document to a bestbet or rf
	    //the opener window should have a javascript method addKBDoc( url )
	    //the url should open a window showing the actual document,
	    //it should also contain the following parameters:
	    //docID, docName, url, slicID
	    //it appears that posts are different from v5
	    //versions and don't include the above only a kcId parameter
	    //thus we are adding a title
	    title = title.replace(/<b>/g, '');
	    title = title.replace(/<\/b>/g, '');
		if (window.opener == null){
			if(window.addKBDoc) addKBDoc(url, title);
		}else{
			if(window.opener.addKBDoc) window.opener.addKBDoc(url, title);
		}
	}

	function fOnDragStart( url, title )
	{
	    //called in ie when dragging the document instead of clicking the "Add" link
	    obj = window.event.srcElement;
	    if (obj.href)
	    {
	        if (!window.event.dataTransfer)
	        {
	            alert("This version of IE doesn't support Drag n' Drop");
	            return
	        }
	        window.event.dataTransfer.setData("Text", url + "$$" + title);
	    }
	}

	function onSearch(){
	    //window.document.cpplayer.action="/selfservice/search.do";
	    //window.document.cpplayer.method="POST";
	    //window.document.cpplayer.submit();
  		document.getElementById('anresultdiv').style.display="none";
  		document.getElementById('searchresultdiv').style.display="block";
	}

	function onSearchAN(){
	    //window.document.cpplayer.action="/selfservice/search_AN.do";
	    //window.document.cpplayer.method="POST";
	    //window.document.cpplayer.submit();
  		document.getElementById('searchresultdiv').style.display="none";
  		document.getElementById('anresultdiv').style.display="block";
	}

	function openANEP( id, externalId, widgetName )
	{
	    if( !widgetName ) widgetName = "";
	    var submitForm =  document.forms[ "cpplayer" + widgetName ];
	    if( submitForm ){
	        submitForm.action = '/selfservice/cpplayer/search.do?cptid=' + id;
	        submitForm.method="POST";
	        submitForm.submit();
	    }
	}

	function submitResultsForm ( widgetName, logOpenHome) {
	    if( !widgetName ) widgetName = "";
	    var submitForm =  document.forms[ "resultsForm" + widgetName ];
	    if( submitForm ){
			var logOpenHomeInp = document.getElementById('logOpenHomePage');
			if(logOpenHomeInp != null) {
				logOpenHomeInp.value = logOpenHome;
			}
	        if(window.process && window.processReqChange){
	            var text=process("/selfservice/masschanges/masschanges.do?action=default", processReqChange, '', false);
	        }
	        submitForm.submit();
	    }
	}
	
	function checkReassign() {
		var indice = document.getElementById('reassigned_author').selectedIndex;
		
		if(document.getElementById('reassigned_author').options[indice].value=="opt_not_selected")
		{
			document.getElementById('reassign_btn').disabled=true;
		}
		else
		{ 
			document.getElementById('reassign_btn').disabled=false;
		}				
	 }

	function checkFlagData(){
		var archiveDate = document.getElementById('id_dateArchive');
		var reviewDate = document.getElementById('id_dateReview');
		var btn_changeFlag = document.getElementById('btn_changeFlag');
		
		if(archiveDate.value == "" && reviewDate.value == "") {
			btn_changeFlag.disabled=true;
			return;
		}
		else
		{ 
			btn_changeFlag.disabled=false;
		}
	 }
	 
	function checkReplaceText() {
		var findText = document.getElementById('id_MA_Find');
		var replaceText = document.getElementById('id_MA_Replace');
		var btn_replace = document.getElementById('btn_replace');
		
		if(findText.value == "" || replaceText.value == "") {
			btn_replace.disabled=true;
			return;
		}

		btn_replace.disabled=false;
	 }

	function isReplaceTextDiff() {
		var findText = document.getElementById('id_MA_Find');
		var replaceText = document.getElementById('id_MA_Replace');
		var btn_replace = document.getElementById('btn_replace');

		 if(findText.value==replaceText.value)
		 {
			alert('You cannot add and remove the same text. Specify different text to find and replace in the documents.');
		    return false;
		 }
		else
		{
            return true;
		}
	 }

	 
	 function checkAndPerformAction(text){
		findText = document.getElementById('id_MA_Find');
		replaceText = document.getElementById('id_MA_Replace');

		if (findText != '' && replaceText.value != ''){
			performAction('findreplace', 'find=' + encodeURIComponent(document.getElementById('id_MA_Find').value) + '&replace=' + encodeURIComponent(document.getElementById('id_MA_Replace').value), text );
		}	 
	 }
	 
	 function checkSelectAccessLevel() {
		
		var optRemove = document.getElementById('salstoremove');
		var optAdd = document.getElementById('salstoadd');
		var btn_change = document.getElementById('btn_change');

		for (var i=0; i < optRemove.options.length; i++) {
			if (optRemove.options[i].selected && i != 0) {
				 btn_change.disabled=false;                 				 
				 return;
		    }
			else {
				btn_change.disabled=true;
			}
		}

		for (var j=0; j < optAdd.options.length; j++) {
			if (optAdd.options[j].selected && j != 0) {
				 btn_change.disabled=false;                 				 
				 return;
		    }
			else {
				btn_change.disabled=true;
			}			
		}				
	 }

	 function submitSearchWithinResults( widgetName ){
	    if( !widgetName ) widgetName = "";
	    var submitForm =  document.forms[ "searchWithinResults" + widgetName ];
	    if( submitForm && verifySearchWithin ){
		    var ctrl=document.getElementById("tosearchwithingstr" + widgetName );
		    if(ctrl){
		        submitForm.elements["searchwithingstr" + widgetName ].value=ctrl.value;
		        if(verifySearchWithin(submitForm, widgetName ) ){
			        submitForm.submit();
		        }
		    }
	    }
	 }
	</script>


<div class="kbresultstab">














	<div id="searchresultdiv">
	
	<table cellpadding="0" cellspacing="0" width="100%" border="0">
	<tr valign="top">
                            <td style="padding-right: 5px;"><script language="JavaScript">
function answerLinksQuestion(theLinksForm, questionId, answerValue, widgetName )
{
    if( !widgetName ) widgetName = "";
    theLinksForm["id" + widgetName ] .value= questionId;
    theLinksForm["answerValue" + widgetName ].value=answerValue;
    return true;
}

function onQuestion( id, value, widgetName  ){
	if( value == "0" ) return;
    if( !widgetName ) widgetName = "";
    var submitForm = document.forms[ "linksForm" + widgetName ]
     if( submitForm ){
            if(answerLinksQuestion( submitForm, id, value, widgetName )) submitForm.submit();
     }
}
</script>
<div class="focuschoiceswidget">
<div id="gsnavigation">
<table border="0" cellpadding="0" cellspacing="0" width="100%">

      <!--tr>
      <td valign="middle" class="headerLtBlu">
                  Focus Your Results:
              </td>
    </tr>
    <tr>
      <td><img src="/selfservice/img/kss/sp.gif" width="1" height="2" /></td>
    </tr-->
<tr>
	<td colspan="3">
      		<h2 class="gsnavigationheader">Narrow Focus</h2>
    </td>
</tr>
<tr>
      <td colspan="3" width="100%" style="padding:0;border-left:1px solid #CCCCCC;border-right:1px solid #CCCCCC;margin:4px 0 0 2px;">
         <div id="followupquestions">
         	<table cellpadding="0" cellspacing="0" border="0" width="100%">
         	   <form name="mainForm" action="search.do" method="POST" onSubmit="CaptureState(document.all.invisibleDIV);">
         	   <tr><td>
               <input type="hidden" name="action" value="2">
               <input type="hidden" name="searchMode" value="GuidedSearch">
               <input type="hidden" name="stateID" value="1 0 376180232">
               <input type="hidden" name="locale" value="LA_eng_US">
               <input type="hidden" name="confirmNodes" value="">
               <input type="hidden" name="constraints" value="">
                 
  <table width="100%" cellpadding="0" cellspacing="0" border="0">
            					        <input type="hidden" name="idList" value="SG_SupportGoals">
   			<tr valign="middle" class="GS_header">
				    			<td width="99%" style="padding: 5px 10px;"><span class="body">Products</td>
	      					</tr>  
        	  <tr valign="top">
            	<td class="GS_bgcolor" width="100%">
	            					     	        <table border="0" cellpadding="0" cellspacing="0" style="margin-top:5px; margin-bottom: 5px">               
        		   	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('SG_SupportGoals', 'SG_VMWAREESX3_5_X_1_3', '' );" style="cursor:hand;" href="#">VMware ESX 3.5.x </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('SG_SupportGoals', 'SG_VMWAREESX4_1_X_1_3', '' );" style="cursor:hand;" href="#">VMware ESX 4.1.x </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('SG_SupportGoals', 'SG_VMWAREVCENTERSITERECOVERYMANAGER_1_2', '' );" style="cursor:hand;" href="#">VMware vCenter Site Recovery Manager </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('SG_SupportGoals', 'SG_VMWAREESX4_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware ESX 4.0.x </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('SG_SupportGoals', 'SG_VMWAREVCENTERSITERECOVERYMANAGER4_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Site Recovery Manager 4.0.x </a>&nbsp;</td>
	            	</tr>
		            	    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       				</table>
		       				<span class="more" id="more_SG_SupportGoals" onClick="document.getElementById('moreAnswers_SG_SupportGoals').style.display = 'block'; document.getElementById('more_SG_SupportGoals').style.display = 'none';">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>more...</i></span>			
	            <span style="display:none;" id="moreAnswers_SG_SupportGoals">		      		            	
	    	        <table border="0" cellpadding="0" cellspacing="0">               
    	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESXI4_0_XINSTALLABLE_1_3', '' );" style="cursor:hand;" href="#">VMware ESXi 4.0.x Installable </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSITERECOVERYMANAGER4_1_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Site Recovery Manager 4.1.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESXI3_5_XEMBEDDED_1_3', '' );" style="cursor:hand;" href="#">VMware ESXi 3.5.x Embedded </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESXI4_0_XEMBEDDED_1_3', '' );" style="cursor:hand;" href="#">VMware ESXi 4.0.x Embedded </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESXI3_5_XINSTALLABLE_1_3', '' );" style="cursor:hand;" href="#">VMware ESXi 3.5.x Installable </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSITERECOVERYMANAGER1_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Site Recovery Manager 1.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVIRTUALCENTER2_5_X_1_3', '' );" style="cursor:hand;" href="#">VMware VirtualCenter 2.5.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESX3_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware ESX 3.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESXI4_1_XINSTALLABLE_1_3', '' );" style="cursor:hand;" href="#">VMware ESXi 4.1.x Installable </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSITERECOVERYMANAGER5_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Site Recovery Manager 5.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESXI_1_2', '' );" style="cursor:hand;" href="#">VMware ESXi </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSERVERHEARTBEAT_1_2', '' );" style="cursor:hand;" href="#">VMware vCenter Server Heartbeat </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESXI5_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware ESXi 5.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSERVER4_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Server 4.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSERVERHEARTBEAT5_5_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Server Heartbeat 5.5.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREESXI4_1_XEMBEDDED_1_3', '' );" style="cursor:hand;" href="#">VMware ESXi 4.1.x Embedded </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREWORKBENCH_1_2', '' );" style="cursor:hand;" href="#">VMware Workbench </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREWORKBENCH1_X_1_3', '' );" style="cursor:hand;" href="#">VMware Workbench 1.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWARECAPACITYPLANNER2_6_X_1_3', '' );" style="cursor:hand;" href="#">VMware Capacity Planner 2.6.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSERVERHEARTBEAT6_3_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Server Heartbeat 6.3.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREACE_1_2', '' );" style="cursor:hand;" href="#">VMware ACE </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWARECAPACITYPLANNER2_5_X_1_3', '' );" style="cursor:hand;" href="#">VMware Capacity Planner 2.5.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSERVER_1_2', '' );" style="cursor:hand;" href="#">VMware vCenter Server </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREACE2_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware ACE 2.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSERVERHEARTBEAT6_4_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Server Heartbeat 6.4.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVIRTUALCENTER2_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware VirtualCenter 2.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSERVER4_1_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Server 4.1.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERCONVERTER4_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Converter 4.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERSERVER5_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Server 5.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERAPPLICATIONDISCOVERYMANAGER5_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Application Discovery Manager 5.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_SPRINGFRAMEWORK3_0_1_3', '' );" style="cursor:hand;" href="#">Spring Framework 3.0 </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWARESERVER_1_2', '' );" style="cursor:hand;" href="#">VMware Server </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCLOUDREQUESTMANAGER1_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCloud Request Manager 1.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWARECONVERTER_1_2', '' );" style="cursor:hand;" href="#">VMware Converter </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERCONVERTERSTANDALONE4_0_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Converter Standalone 4.0.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERCONVERTER_1_2', '' );" style="cursor:hand;" href="#">VMware vCenter Converter </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERCONVERTER4_1_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Converter 4.1.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERCONVERTER4_2_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Converter 4.2.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCLOUDREQUESTMANAGER_1_2', '' );" style="cursor:hand;" href="#">VMware vCloud Request Manager </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWARETHINAPP4_X_1_3', '' );" style="cursor:hand;" href="#">VMware ThinApp 4.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERCONVERTERSTANDALONE4_3_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Converter Standalone 4.3.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERAPPLICATIONDISCOVERYMANAGER6_X_1_3', '' );" style="cursor:hand;" href="#">VMware vCenter Application Discovery Manager 6.x </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_SPRINGFRAMEWORK_1_2', '' );" style="cursor:hand;" href="#">Spring Framework </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWARECAPACITYPLANNER_1_2', '' );" style="cursor:hand;" href="#">VMware Capacity Planner </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'SG_SupportGoals', 'SG_VMWAREVCENTERLABMANAGER_1_2', '' );" style="cursor:hand;" href="#">VMware vCenter Lab Manager </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	              					</table>
					<span class="more" onClick="document.getElementById('moreAnswers_SG_SupportGoals').style.display = 'none'; document.getElementById('more_SG_SupportGoals').style.display = 'block';"><img height="15" src="/selfservice/img/kss/sp.gif" width="4" border="0"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>hide choices...</i>
		            </span>				
                 </span>   
			             				</td>
		  </tr>
			  					        <input type="hidden" name="idList" value="NAVAREA_INTENSION_1_1">
   			<tr valign="middle" class="GS_header">
				    			<td width="99%" style="padding: 5px 10px;"><span class="body">Activities</td>
	      					</tr>  
        	  <tr valign="top">
            	<td class="GS_bgcolor" width="100%">
	            					    	        <table border="0" cellpadding="0" cellspacing="0" style="margin-top:5px; margin-bottom: 5px">               
        		   	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244656837578', '' );" style="cursor:hand;" href="#">Using Virtual Machine </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244656516265', '' );" style="cursor:hand;" href="#">System Management </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244657526125', '' );" style="cursor:hand;" href="#">Changing Virtual Machine Power States </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244049184825', '' );" style="cursor:hand;" href="#">Configuring Server </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244048619715', '' );" style="cursor:hand;" href="#">Installing vSphere or Installing VirtualCenter </a>&nbsp;</td>
	            	</tr>
		            	    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       				</table>
		       				<span class="more" id="more_NAVAREA_INTENSION_1_1" onClick="document.getElementById('moreAnswers_NAVAREA_INTENSION_1_1').style.display = 'block'; document.getElementById('more_NAVAREA_INTENSION_1_1').style.display = 'none';">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>more...</i></span>			
	            <span style="display:none;" id="moreAnswers_NAVAREA_INTENSION_1_1">		      		            	
	    	        <table border="0" cellpadding="0" cellspacing="0">               
    	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244575555062', '' );" style="cursor:hand;" href="#">Configuring Virtual Machine </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244493491531', '' );" style="cursor:hand;" href="#">Sharing Storage </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244493957328', '' );" style="cursor:hand;" href="#">Using ESX </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244493870718', '' );" style="cursor:hand;" href="#">Configuring ESX </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244493695843', '' );" style="cursor:hand;" href="#">Resource Management </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244517561968', '' );" style="cursor:hand;" href="#">Using Workstation </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244521889218', '' );" style="cursor:hand;" href="#">Installing vSphere </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244492908343', '' );" style="cursor:hand;" href="#">Installing Operating System </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244575369046', '' );" style="cursor:hand;" href="#">Sharing Virtual Machine </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244048819866', '' );" style="cursor:hand;" href="#">Moving Virtual Machine </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244492769359', '' );" style="cursor:hand;" href="#">Sharing Folder </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244492817921', '' );" style="cursor:hand;" href="#">Installing ESX </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_INTENSION_1_1', 'TSEC_TSE_1244575892140', '' );" style="cursor:hand;" href="#">Using Fusion </a>&nbsp;</td>
	        	    		</tr>
	                          	              					</table>
					<span class="more" onClick="document.getElementById('moreAnswers_NAVAREA_INTENSION_1_1').style.display = 'none'; document.getElementById('more_NAVAREA_INTENSION_1_1').style.display = 'block';"><img height="15" src="/selfservice/img/kss/sp.gif" width="4" border="0"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>hide choices...</i>
		            </span>				
                 </span>   
			             				</td>
		  </tr>
			  					        <input type="hidden" name="idList" value="NAVAREA_TASK_1_1">
   			<tr valign="middle" class="GS_header">
				    			<td width="99%" style="padding: 5px 10px;"><span class="body">Symptoms</td>
	      					</tr>  
        	  <tr valign="top">
            	<td class="GS_bgcolor" width="100%">
	            					    	        <table border="0" cellpadding="0" cellspacing="0" style="margin-top:5px; margin-bottom: 5px">               
        		   	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_TASK_1_1', 'TSEC_TSE_1245353984859', '' );" style="cursor:hand;" href="#">System Error </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_TASK_1_1', 'TSEC_TSE_1244657718578', '' );" style="cursor:hand;" href="#">System Timeouts </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_TASK_1_1', 'TSEC_TSE_1244517530187', '' );" style="cursor:hand;" href="#">Network Error </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_TASK_1_1', 'TSEC_TSE_1244517741390', '' );" style="cursor:hand;" href="#">Command Failed </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_TASK_1_1', 'TSEC_TSE_1244517686953', '' );" style="cursor:hand;" href="#">Login Failed </a>&nbsp;</td>
	            	</tr>
		            	    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       	            		    	       				</table>
		       				<span class="more" id="more_NAVAREA_TASK_1_1" onClick="document.getElementById('moreAnswers_NAVAREA_TASK_1_1').style.display = 'block'; document.getElementById('more_NAVAREA_TASK_1_1').style.display = 'none';">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>more...</i></span>			
	            <span style="display:none;" id="moreAnswers_NAVAREA_TASK_1_1">		      		            	
	    	        <table border="0" cellpadding="0" cellspacing="0">               
    	                      	                  	                      	                  	                      	                  	                      	                  	                      	                  	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_TASK_1_1', 'TSEC_TSE_1244494257656', '' );" style="cursor:hand;" href="#">Connection is Dropped </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_TASK_1_1', 'TSEC_TSE_1244492881609', '' );" style="cursor:hand;" href="#">Access Denied </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_TASK_1_1', 'TSEC_TSE_1244518028828', '' );" style="cursor:hand;" href="#">File or Folder Cannot Be Found </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_TASK_1_1', 'TSEC_TSE_1244049957712', '' );" style="cursor:hand;" href="#">Poor Performance </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_TASK_1_1', 'TSEC_TSE_1244493466796', '' );" style="cursor:hand;" href="#">OS Compatibility </a>&nbsp;</td>
	        	    		</tr>
	                          	                      	              				            <tr valign="top">
    				        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
							<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion( 'NAVAREA_TASK_1_1', 'TSEC_TSE_1244575993671', '' );" style="cursor:hand;" href="#">Licensing Errors and Issues </a>&nbsp;</td>
	        	    		</tr>
	                          	              					</table>
					<span class="more" onClick="document.getElementById('moreAnswers_NAVAREA_TASK_1_1').style.display = 'none'; document.getElementById('more_NAVAREA_TASK_1_1').style.display = 'block';"><img height="15" src="/selfservice/img/kss/sp.gif" width="4" border="0"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>hide choices...</i>
		            </span>				
                 </span>   
			             				</td>
		  </tr>
			  					        <input type="hidden" name="idList" value="NAVAREA_OUTCOME_1_1">
   			<tr valign="middle" class="GS_header">
				    			<td width="99%" style="padding: 5px 10px;"><span class="body">Objects</td>
	      					</tr>  
        	  <tr valign="top">
            	<td class="GS_bgcolor" width="100%">
	            					    	        <table border="0" cellpadding="0" cellspacing="0" style="margin-top:5px; margin-bottom: 5px">               
        		   	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_OUTCOME_1_1', 'TSEC_TSE_1244052090548', '' );" style="cursor:hand;" href="#">Network Driver </a>&nbsp;</td>
	            	</tr>
		            	    	       	            			            <tr valign="top">
    		        <td style="padding-right: 3px;" width="20">&nbsp;&nbsp;<img src="/selfservice/img/kss/bullet_gs-choices.gif" alt="" width="9" height="9" border="0"></td>
					<td class="body" style="padding-bottom: 3px"><a onClick="onQuestion('NAVAREA_OUTCOME_1_1', 'TSEC_TSE_1244050286328', '' );" style="cursor:hand;" href="#">User Account </a>&nbsp;</td>
	            	</tr>
		            	    	       				</table>
		                  				</td>
		  </tr>
			  	    </table>
				<TextArea name="product" style="display:none;visibility:hide">noselection</TextArea><TextArea name="productFamily" style="display:none;visibility:hide"></TextArea><TextArea name="evaluateRF" style="display:none;visibility:hide">true</TextArea><TextArea name="rwTarget" style="display:none;visibility:hide">/rfPlayerWidget.do</TextArea><TextArea name="showsplink" style="display:none;visibility:hide">true</TextArea><TextArea name="accesslevels" style="display:none;visibility:hide">SAL_Public</TextArea><TextArea name="category" style="display:none;visibility:hide">noselection</TextArea><TextArea name="forum" style="display:none;visibility:hide"></TextArea><TextArea name="cmd" style="display:none;visibility:hide">search</TextArea><TextArea name="searchString" style="display:none;visibility:hide">test</TextArea><TextArea name="showSavedSearches" style="display:none;visibility:hide">true</TextArea><TextArea name="btnSearchAll" style="display:none;visibility:hide"></TextArea><TextArea name="searchFor" style="display:none;visibility:hide"></TextArea><TextArea name="contextType" style="display:none;visibility:hide">gs</TextArea><TextArea name="document" style="display:none;visibility:hide">DT_KB_1_1</TextArea><TextArea name="usemicrosite" style="display:none;visibility:hide">true</TextArea>
								</td></tr>
         		</form>
         	</table>
         </div>
        </td>
</tr>
  
    
          


</table>
</div>
</div></td>
                        		<td>
            		<div class="vmsearchresults ">
            							<!--    this is from GSSResults_header.vm -->
<script language="JavaScript">

var arrSortByValues;
if( !arrSortByValues )  arrSortByValues = new Array();
arrSortByValues["CREATEDDATE"] = "-1";
arrSortByValues["rating"] = "1";
arrSortByValues["relevance"] = "1";
arrSortByValues["PUBLISHEDDATE"] = "-1";

function sortDocumentsBy( _sortBy, _sortOrder, widgetName )
{
    if( !widgetName ) widgetName = "";
    var submitForm = document.forms[ "sortByForm" + widgetName ]
     if( submitForm ){
        var sortByOverride = submitForm["sortByOverride"+ widgetName];
        var sortOrder = submitForm[ "sortOrder"+ widgetName ];
        sortByOverride.value= _sortBy;
        sortOrder.value = _sortOrder;
        submitForm.submit();
     }
}

function doSort( widgetName ){
  if( !widgetName ) widgetName = "";
  var strSortId = document.forms["searchWithinResults" + widgetName ].sortBy.value;
  sortDocumentsBy(strSortId, arrSortByValues[strSortId], widgetName );
}

function verifySearchWithin(f, widgetName ) {
    if( !widgetName ) widgetName = "";
    var searchString = f.elements["searchwithingstr" + widgetName ].value;
    if (isblank(searchString)) {
    	showMessageBox("Please enter your search within query in the text box",'OK',360,180,"/selfservice/common/");
    	return false;
    }
    return true;
}
function isblank(s) {
    if(s){
        for(var i=0; i<s.length; i++) {
            var c = s.charAt(i);
            if((c != ' ') && (c != '\n') && (c != '\t')) return false;
        }
	}
    return true;
}

</script>
<div>
<form action="search.do" name="searchWithinResults" method="post" onSubmit="return(verifySearchWithin(this, '' ))" style="margin: 0px">

<table cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td width="99%" style="background:url('/selfservice/img/top_blue_left.gif') no-repeat scroll left top #006699" valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="5">
			<tr>
			    <td rowspan="2" nowrap class="vmresultsheader">

											    <strong>Search Results:</strong>&nbsp;&nbsp;<span>
			    				  			      			      <b>1 - 25</b> of
			      300
			      			    			    </span>
			       			&nbsp;&nbsp;
				 				   				     <span class="prev_next">&lt;&nbsp;prev&nbsp;|</span>
				   				 				 				   <a href="javascript:void(submitResultsForm('', false))" onClick="document.resultsForm.startDocument.value = '26';" class="body11">next&nbsp;25&nbsp;&gt;</a>
				 			    								</td>

								<td align="right" nowrap class="vmresultsheader">
				 <strong>Sort By:&nbsp;</strong>
				 <select id="sortBy" class="vmdropdown" onchange="javascript:doSort('');">
				 				 				 <option value="CREATEDDATE"  >Create Date</option>
				 				 				 <option value="rating"  >Document Rating</option>
				 				 				 <option value="relevance"  selected   >Most Relevant</option>
				 				 				 <option value="PUBLISHEDDATE"  >Publication Date</option>
				 				 				 </select>
				 </td>
							</tr>
			</table>
		</td>
		<td valign="top" style="background: url('../../../images/top_blue_right.gif') no-repeat scroll right top rgb(0, 102, 153); width: 7px;">	</td>
	</tr>
</table>
</div>
    <input type="hidden" name="searchwithingstr" value=""/>
	<input type="hidden" name="action" value="5" />
    <input type="hidden" name="searchMode" value="GuidedSearch">
    <input type="hidden" name="title" value="$processRequest.getTitle()">
    <input type="hidden" name="searchFor" value="all">
    <input type="hidden" name="stateID" value="1 0 376180232">
    <input type="hidden" name="locale" value="LA_eng_US">
    <input type="hidden" name="confirmNodes" value="">
    <input type="hidden" name="constraints" value="">
    <TextArea name="product" style="display:none;visibility:hide">noselection</TextArea><TextArea name="productFamily" style="display:none;visibility:hide"></TextArea><TextArea name="evaluateRF" style="display:none;visibility:hide">true</TextArea><TextArea name="rwTarget" style="display:none;visibility:hide">/rfPlayerWidget.do</TextArea><TextArea name="showsplink" style="display:none;visibility:hide">true</TextArea><TextArea name="accesslevels" style="display:none;visibility:hide">SAL_Public</TextArea><TextArea name="category" style="display:none;visibility:hide">noselection</TextArea><TextArea name="forum" style="display:none;visibility:hide"></TextArea><TextArea name="cmd" style="display:none;visibility:hide">search</TextArea><TextArea name="searchString" style="display:none;visibility:hide">test</TextArea><TextArea name="showSavedSearches" style="display:none;visibility:hide">true</TextArea><TextArea name="btnSearchAll" style="display:none;visibility:hide"></TextArea><TextArea name="contextType" style="display:none;visibility:hide">gs</TextArea><TextArea name="document" style="display:none;visibility:hide">DT_KB_1_1</TextArea><TextArea name="usemicrosite" style="display:none;visibility:hide">true</TextArea>
</form>
    <form name="sortByForm" action="search.do" method="post">
        <input type="hidden" name="savedAction" value="0">
        <input type="hidden" name="action" value="11">
        <input type="hidden" name="sortRequest" value="%3cDialogRequest+DocTypes%3d%22DT_KB_1_1%22+Entitlements%3d%22SAL_Public%22+MS%3d%22MS_Customer%22+Published%3d%22KCP_Publish%2c-KCP_Threaded%2c-KCP_RWCase%2c-KCP_Feedback%22+Segments%3d%22UMCR_CUSTOMERMS_1_1%2cSG_DESKTOP_1_1%2cSG_SERVER_DATACENTER_1_1%2cSG_VMWAREACE_1_2%2cSG_VMWARECAPACITYPLANNER_1_2%2cSG_VMWARECONSOLIDATEDBACKUP_1_2%2cSG_VMWARECONVERTER_1_2%2cSG_VMWAREESX_1_2%2cSG_VMWAREESXI_1_2%2cSG_VMWAREFUSION_1_2%2cSG_VMWAREGSXSERVER_1_2%2cSG_VMWAREVCENTERLABMANAGER_1_2%2cSG_VMWAREP2VASSISSTANT_1_2%2cSG_VMWAREPLAYER_1_2%2cSG_VMWAREINFRASTRUCTURESDK_1_2%2cSG_VMWARESERVER_1_2%2cSG_VMWAREVCENTERUPDATEMANAGER_1_2%2cSG_VMWAREVIRTUALDESKTOPMANAGER_1_2%2cSG_VMWAREVIRTUALCENTER_1_2%2cSG_VMWAREWORKSTATION_1_2%2cSG_VMWAREVCENTERLIFECYCLEMANAGER_1_2%2cSG_VMWAREVCENTERSTAGEMANAGER_1_2%2cSG_VMWAREVCENTERSITERECOVERYMANAGER_1_2%2cSG_VMWARETHINAPP_1_2%2cSG_VMWARETHINSTALL_1_2%2cSG_VMWARESTUDIO_1_2%2cSG_DEVELOPERSUPPORT_1_1%2cSG_VOLUMEPURCHASINGPROGRAM_1_1%2cSG_MYVMWARE_1_1%2cSG_VMWAREVCENTERSERVER_1_2%2cDT_COMMUNITIES_1_1%2cDT_KB_1_1%2cDT_PRODUCTDOCUMENTATION_1_1%2cDT_WIKI_1_1%22+appContext%3d%22AC_KSS%22+application%3d%22KSS%22+documentSortField%3d%22%22+documentSortOrder%3d%221%22+minDocumentsForQuestions%3d%2210%22+numDocumentSet%3d%22%22+numDocuments%3d%2225%22+requestType%3d%22StartDialog%22+searchTSE%3d%22true%22+sessionID%3d%22672F57AEE70335A77B85459638B3C728%22+userID%3d%22guest%22%3e%3cLanguage%3e%3cDialog%3e%3cLocale+localeID%3d%22LA_eng_US%22%2f%3e%3c%2fDialog%3e%3cResult%3e%3cLocale+localeID%3d%22LA_eng_US%22%2f%3e%3c%2fResult%3e%3c%2fLanguage%3e%3cUserQuery%3etest%3c%2fUserQuery%3e%3cConstraints%2f%3e%3cFilter+ids%3d%22DT_KB_1_1%22+root%3d%22DT_Document%22+type%3d%22Standard%22%2f%3e%3cExtendedRequest%3e%3cProduct%3e%3c%2fProduct%3e%3cDebugLevel+level%3d%22-1%22%2f%3e%3c%2fExtendedRequest%3e%3c%2fDialogRequest%3e">
        <input type="hidden" name="sortByOverride" value="">
        <input type="hidden" name="sortOrder" value="">
        <input type="hidden" name="searchMode" value="GuidedSearch">
        <input type="hidden" name="title" value="$processRequest.getTitle()">
        <input type="hidden" name="stateID" value="1 0 376180232">
        <input type="hidden" name="dialogId" value="">
        <input type="hidden" name="confirmNodes" value="">
        <input type="hidden" name="constraints" value="">
        <input type="hidden" name="locale" value="LA_eng_US">
        <TextArea name="product" style="display:none;visibility:hide">noselection</TextArea><TextArea name="productFamily" style="display:none;visibility:hide"></TextArea><TextArea name="evaluateRF" style="display:none;visibility:hide">true</TextArea><TextArea name="rwTarget" style="display:none;visibility:hide">/rfPlayerWidget.do</TextArea><TextArea name="showsplink" style="display:none;visibility:hide">true</TextArea><TextArea name="accesslevels" style="display:none;visibility:hide">SAL_Public</TextArea><TextArea name="category" style="display:none;visibility:hide">noselection</TextArea><TextArea name="forum" style="display:none;visibility:hide"></TextArea><TextArea name="cmd" style="display:none;visibility:hide">search</TextArea><TextArea name="searchString" style="display:none;visibility:hide">test</TextArea><TextArea name="showSavedSearches" style="display:none;visibility:hide">true</TextArea><TextArea name="btnSearchAll" style="display:none;visibility:hide"></TextArea><TextArea name="searchFor" style="display:none;visibility:hide"></TextArea><TextArea name="contextType" style="display:none;visibility:hide">gs</TextArea><TextArea name="document" style="display:none;visibility:hide">DT_KB_1_1</TextArea><TextArea name="usemicrosite" style="display:none;visibility:hide">true</TextArea>
    </form>










											<script language="JavaScript">
function gotoBreadcrumb(iterationId, widgetName )
{
  if( !widgetName ) widgetName = "";
    var submitForm = document.forms[ "breadcrumbForm" + widgetName ]
    if( submitForm ){
        submitForm.elements["iterationID" + widgetName ].value = iterationId;
        submitForm.submit();
    }
}
</script>
<!-- GSBreadcrumbs.vm -->

<table cellpadding="0" cellspacing="0" border="0" class="tbbreadcrumb">
  <tr class="bodyGray10" valign="bottom">
    <td class="kbdocshead">
                        <span class="bodyGray10"><b>Current Focus:</b></span>
                            										<a href="#" onclick="javascript:gotoBreadcrumb('1', '' )"><span class="bodyGray10">"test"</span></a>,
			                                      <span class="bodyGray10">
            KB Article
          </span>
                  </td>
  </tr>
  <form name="breadcrumbForm" action="search.do" method="post">
    <input type="hidden" name="action" value="7">
    <input type="hidden" name="iterationID" value="">
    <input type="hidden" name="stateID" value="1 0 376180232">
    <TextArea name="product" style="display:none;visibility:hide">noselection</TextArea><TextArea name="productFamily" style="display:none;visibility:hide"></TextArea><TextArea name="evaluateRF" style="display:none;visibility:hide">true</TextArea><TextArea name="rwTarget" style="display:none;visibility:hide">/rfPlayerWidget.do</TextArea><TextArea name="searchMode" style="display:none;visibility:hide">GuidedSearch</TextArea><TextArea name="showsplink" style="display:none;visibility:hide">true</TextArea><TextArea name="accesslevels" style="display:none;visibility:hide">SAL_Public</TextArea><TextArea name="category" style="display:none;visibility:hide">noselection</TextArea><TextArea name="forum" style="display:none;visibility:hide"></TextArea><TextArea name="cmd" style="display:none;visibility:hide">search</TextArea><TextArea name="locale" style="display:none;visibility:hide">LA_eng_US</TextArea><TextArea name="searchString" style="display:none;visibility:hide">test</TextArea><TextArea name="showSavedSearches" style="display:none;visibility:hide">true</TextArea><TextArea name="btnSearchAll" style="display:none;visibility:hide"></TextArea><TextArea name="searchFor" style="display:none;visibility:hide"></TextArea><TextArea name="contextType" style="display:none;visibility:hide">gs</TextArea><TextArea name="document" style="display:none;visibility:hide">DT_KB_1_1</TextArea><TextArea name="usemicrosite" style="display:none;visibility:hide">true</TextArea>
  </form>
</table>











								    						    				    	    				    	        			            					        		

<div class="vmresults">


           
          

<SCRIPT type="text/javascript" SRC="../../../js/mkm/selfservice/jslib/CalendarPopup.js"></SCRIPT>
<SCRIPT type="text/javascript" SRC="../../../js/mkm/selfservice/jslib/masschanges.js"></SCRIPT>
<SCRIPT type="text/javascript" SRC="../../../js/mkm/selfservice/jslib/umhelper.js"></SCRIPT>
<SCRIPT type="text/javascript" SRC="../../../js/mkm/selfservice/jslib/common.js"></SCRIPT>



 		 		 		
<div id="masschangesdiv" style='display:none'></div>


					  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1020058&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Testing</b> a VMware Fault Tolerance Configuration     
													(1020058)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>Fault Tolerance failure <b>testing</b> provides inconsistent results  � Fault Tolerance <b>testing</b> only functions with a full host failure      For configuration and troubleshooting...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 3/30/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 3/31/10&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 3/30/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1008059&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Test</b> or real failover using Site Recovery Manager 1.0 Update 1 is slow     
													(1008059)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>1.0 Update 1, recovery of a virtual machine might take a long time.  The recovery time during a <b>test</b> or real recovery is longer when more virtual machines are involved.  The Change Network Settings task might time out...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 4/5/11&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 12/19/08&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 4/5/11&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=2002107&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Testing</b> CSV connector on Windows 2008 Server fails with error: <b>Test</b> failed. Please consult the server even log for more details. Specified CSV file does not exist.     
													(2002107)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>Attempting to <b>test</b> CSV Connector fails with error:      <b>Test</b> failed. Please consult the server even log for more details.     Specified CSV file does not exist.   � This failure occurs on a Windows 2008 Server R2...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 5/15/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 6/28/11&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 5/15/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1004072&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    Windows 2003 Server Enterprise Edition (64 Bit) ServicePack-1 Guest Operating System Fails to Operate while Running Microsoft Hardware Compatibility <b>Test</b> (HCT)     
													(1004072)
												</a>     </h3>
			

							<p class="docdesc"><Synopsis>Bit) ServicePack-1 Guest Operating system fails to operate while running the Microsoft Hardware Compatibility <b>Test</b> (HCT 12.1). The following system error logs are displayed:   Source: System Error Category: (102) Event...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 3/18/08&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 2/28/08&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 8/14/09&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1013454&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    A <b>Test</b> Failover operation in Site Recovery Manager fails with the SRA message: Failed to create LUN snapshot     
													(1013454)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>Site Recovery Manager(SRM) using EMC MirrorView SRA (Storage Replication Adapter), running an SRM <b>Test</b> Failover operation may fail during the preparing storage stage.   The logs from SRM (default location C:\Documents...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 1/31/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 8/19/09&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 1/31/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1009638&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    Failure to create LUN snapshots when performing a Site Recovery Manager <b>test</b> failover on a CLARiiON array     
													(1009638)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>EMC CLARiiON array and performing a Site Recovery Manager (SRM)  <b>test</b> failover:    � The Reconfiguring Storage stage does not get past 2%   � LUN snapshots are not created on the array   � The vmware-dr-#.log file...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 1/31/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 3/31/09&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 1/31/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1023410&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    Setting up a <b>test</b> Service Manager environment that is a replica or copy of a production environment     
													(1023410)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>This article provides information related to setting up a <b>test</b> Service Manager environment, including:    � Steps required to move a Service Manager system to another server.  � How to make a <b>test</b> Service Manager...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 2/18/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 6/25/10&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 2/18/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1030356&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    Site Recovery Manager 4.1 <b>test</b> failover fails with the error: Maximum number of access records for this volume reached     
													(1030356)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>When performing a <b>test</b> failover with VMware vCenter Site Recovery Manager (SRM) 4.1, you may experience these symptoms:  � <b>Test</b> failover fails to complete during the Preparing Storage phase  � You are unable to perform...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 2/8/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 11/5/10&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 2/8/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1018799&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    Using Telnet to <b>test</b> VMware Data Recovery Appliance connectivity     
													(1018799)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>valid for VMware Data Recovery 1.1 or earlier.      To use Telnet to <b>test</b> network connectivity:  1) Install Telnet:      a) Log into VDR as root using the console or an SSH...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 3/17/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 3/2/10&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 3/17/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1024029&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    VMware Site Recovery Manager 4.0.x <b>test</b> failover fails with the error: Failed to prepare shadow vm for recovery when using Compellent iSCSI storage     
													(1024029)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>When performing a <b>test</b> failover with VMware Site Recovery Manager (SRM) 4.0.x and Compellent iSCSI storage, you experience these symptoms:  � <b>Test</b> failover fails to complete  � Cannot perform <b>test</b> failover  � You see...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 10/13/11&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 7/9/10&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 10/13/11&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1039243&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    VMware vCenter Site Recovery Manager failover and <b>test</b> failover fail with the error: "Failed to prepare storage" or "Failed to create LUN snapshot"     
													(1039243)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>VMware Site Recovery Manager (SRM) <b>test</b> failover times out and fails  � An SRM failover times out and fails  � You see one of these errors:      � Failed to prepare storage      � Failed to create LUN snapshot...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 10/24/11&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 5/11/11&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 10/24/11&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1010395&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    Site Recovery Manager <b>Test</b> Failover operation fails with the error: execution exceeded timeout limit of '300' seconds     
													(1010395)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>When attempting to perform a <b>Test</b> Failover in VMware vCenter Site Recovery Manager (SRM) 1.0, you experience these symptoms:  � The <b>Test</b> Failover operation times out  � In the vmware-dr.log log file on the SRM server...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 6/6/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 4/29/09&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 6/6/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=2000162&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    SRM <b>Test</b> Failover on HP Lefthand 4000 array fails with the error: failed to create snapshot of replica devices SRA command <b>test</b> fail over start failed - unexpected error     
													(2000162)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>When attempting to perform a <b>Test</b> Failover operation on vCenter Site Recovery Manager (SRM) 5.0 with a HP Lefthand 4000 series iSCSI storage array, you experience these symptoms:  � The <b>Test</b> Failover operation fails...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 6/22/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 6/13/12&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 6/22/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1003728&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Testing</b> VMkernel network connectivity with the vmkping command     
													(1003728)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>troubleshooting purposes, it may be necessary to <b>test</b> VMkernel network connectivity between ESX hosts in your environment. This article provides you with the steps to perform a vmkping <b>test</b> between your ESX hosts...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 6/24/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 1/28/08&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 6/24/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1000208&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    Pocket ACE Performance <b>Test</b> Creates Inconsistent Results     
													(1000208)
												</a>     </h3>
			

							<p class="docdesc"><Synopsis>The Pocket ACE performance <b>test</b> creates inconsistent results. When you use a USB device that does not perform well, the following message appears:   The drive you have selected is not recommended for use with Pocket ACE...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 1/7/08&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 5/4/07&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 8/14/09&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1003487&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Testing</b> port connectivity with Telnet     
													(1003487)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>troubleshooting purposes, it may be necessary to <b>test</b> connectivity to the different ports on your servers.  This article provides you with the steps to use the Telnet utility to <b>test</b> connectivity to different ports...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 3/23/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 1/6/08&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 3/23/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=831&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Testing</b> the physical memory of the host or console hardware     
													(831)
												</a>     </h3>
			

							<p class="docdesc"><Synopsis>How do I troubleshoot or <b>test</b> for physical memory problems on the physical hosts that run VMware virtual machines?     If you suspect that you have faulty memory or you want to <b>test</b>...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 5/7/10&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 6/23/06&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 1/27/11&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1006821&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Testing</b> virtual machine storage I/O performance     
													(1006821)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>task takes a significant amount of time      This article provides steps to <b>test</b> the speed/throughput on ESX/ESXi and virtual machines as well steps to narrow down...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 1/27/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 8/20/08&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 1/27/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=2013143&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    SRM fails to power off a <b>test</b> virtual machine after a <b>test</b> recovery     
													(2013143)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>After a <b>test</b> recovery, if you run the cleanup operation with the  ignore_errors option set to true, SRM might fail to power off the <b>test</b> virtual machine. As a result, an actual failover or any attempts to rerun the <b>test</b>...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 3/20/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 2/3/12&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 3/20/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1009533&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Testing</b> the packet filter and NIC compatibility     
													(1009533)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>This article provides information about <b>testing</b> packet filter and NIC compatibility.     Due to the number of NICs in the market place, it may be necessary, from time...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 3/30/09&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 3/30/09&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 1/24/11&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1008283&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    VMware vCenter Server Site Recovery Manager <b>test</b> failover fails with the error: Unable to recover datastore     
													(1008283)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>Site Recovery Manager (SRM) <b>test</b> failover fails  � Cannot perform SRM <b>test</b> failover  � You see this error:      Error: Unable to recover datastore   � The vmware-dr.log file shows an error similar to this:      &lt;span...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 3/26/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 1/27/09&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 3/26/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=2017676&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    Best practices for implementing a Development to <b>Test</b> to Production environment with VMware Service Manager     
													(2017676)
												</a>        </h3>
			

							<p class="docdesc"><Synopsis>This article provides the best practices to successfully implement a Development to <b>Test</b>/QA to Production environment when using Service Manager with Configuration Portability...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 4/12/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 4/10/12&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 4/12/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=2008602&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    ESX/ESXi host displays warning message when <b>test</b> condition is false     
													(2008602)
												</a>     </h3>
			

							<p class="docdesc"><Synopsis>Host displays a warning in the Summary or Alarms tab, even though the     <b>test</b> condition is false, that is similar to:      Host &lt;hostname&gt; currently has no management network redundancy  � The above error message...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 6/18/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 10/26/11&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 6/18/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1007307&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					     <b>Testing</b> the Monitoring Virtual Machines functionality in vCenter Server     
													(1007307)
												</a>       </h3>
			

							<p class="docdesc"><Synopsis>5 Update 2 and later.   This article provides the procedure used to <b>test</b> the functionality of the Monitoring Virtual Machines process in VirtualCenter.      The Monitoring...</Synopsis>
				<br /><span class="metadata">
        		                            Rating:
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                  <img src="../../../images/icon_rating_star.gif" width="11" height="11" border="0" alt="" />
                                &nbsp;&nbsp;|&nbsp;&nbsp;
            							    		        Published: 7/10/12&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 10/15/08&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 7/10/12&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
								  		  		<div class="vmdoc">
																  			<h3 class="doctitle"><a target="_self" href="search.do?cmd=displayKC&docType=kc&externalId=1029974&sliceId=1&docTypeID=DT_KB_1_1&dialogID=376164559&stateId=1 0 376180232">
			 					    FT Finalization fails even though all the other <b>test</b> cases have passed     
													(1029974)
												</a>      </h3>
			

							<p class="docdesc"><Synopsis>After passing all automated and manual <b>test</b> cases, the finalization <b>test</b>     case reports this error:      Following <b>test</b>(s) did not run (not tried)   � It then lists some <b>test</b> cases which have previously passed...</Synopsis>
				<br /><span class="metadata">
        		            							    		        Published: 11/17/10&nbsp;&nbsp;|&nbsp;&nbsp;		    								Created Date: 10/28/10&nbsp;&nbsp;|&nbsp;&nbsp;								Last Modified Date: 11/17/10&nbsp;&nbsp;|&nbsp;&nbsp;			    
</span><img style="margin:0;height:15px;padding:0;" alt="KB Article" src="/selfservice/getUMBrowseImageById.do?objectId=DT_KB_1_1&imageType=0" width="15"  />
				</p>
								</div>
			    
    
                  <form name="resultsForm" action="search.do" method="post" style="margin:0px">
                    <input type="hidden" name="action" value="4" />
                    <input type="hidden" name="searchMode" value="GuidedSearch">
                    <input type="hidden" name="title" value="$processRequest.getTitle()">
                    <input type="hidden" name="stateID" value="1 0 376180232">
                    <input type="hidden" name="locale" value="LA_eng_US">
                    <input type="hidden" name="confirmNodes" value="">
                    <input type="hidden" name="constraints" value="">
                    <input type="hidden" name="startDocument" value="">
                    <input type="hidden" name="logOpenHomePage" value="false">
                    <TextArea name="product" style="display:none;visibility:hide">noselection</TextArea><TextArea name="productFamily" style="display:none;visibility:hide"></TextArea><TextArea name="evaluateRF" style="display:none;visibility:hide">true</TextArea><TextArea name="rwTarget" style="display:none;visibility:hide">/rfPlayerWidget.do</TextArea><TextArea name="showsplink" style="display:none;visibility:hide">true</TextArea><TextArea name="accesslevels" style="display:none;visibility:hide">SAL_Public</TextArea><TextArea name="category" style="display:none;visibility:hide">noselection</TextArea><TextArea name="forum" style="display:none;visibility:hide"></TextArea><TextArea name="cmd" style="display:none;visibility:hide">search</TextArea><TextArea name="searchString" style="display:none;visibility:hide">test</TextArea><TextArea name="showSavedSearches" style="display:none;visibility:hide">true</TextArea><TextArea name="btnSearchAll" style="display:none;visibility:hide"></TextArea><TextArea name="searchFor" style="display:none;visibility:hide"></TextArea><TextArea name="contextType" style="display:none;visibility:hide">gs</TextArea><TextArea name="document" style="display:none;visibility:hide">DT_KB_1_1</TextArea><TextArea name="usemicrosite" style="display:none;visibility:hide">true</TextArea>
              </form>
</div>	  
  


        		</div>
        		        		<div class="vmresultsfooter">				
			             <strong>Search Results:</strong>&nbsp;&nbsp;
			             <span>
				     	      				     	  	  				     	        				     	        <b>1 - 25</b> of
				     	        300
				     	        				     	      			    		</span>
			            
			             
			                			 
			                
			                			                    			                      <span class="prev_next">&lt;&nbsp;prev&nbsp;|</span>                  
			                    			                			                			                  <a href="javascript:void(submitResultsForm(''))" onClick="document.resultsForm.startDocument.value = '26';" class="body11">next&nbsp;25&nbsp;&gt;</a>
			                			                
			                
			               	
			                
				</div>	
			        		</td>
        	</tr>
        </table>
	</div>
</div>
		<div id="anresultdiv" style='display:none'>
	
	</div>
	
		<form name="linksForm" action="search.do" method="post">
  	<input type="hidden" name="action" value="3">
  	<input type="hidden" name="id">
  	<input type="hidden" name="answerValue">
  	<input type="hidden" name="stateID" value="1 0 376180232">
  	<input type="hidden" name="searchMode" value="GuidedSearch">
  	<input type="hidden" name="confirmNodes" value="">
  	<input type="hidden" name="constraints" value="">
  	<TextArea name="product" style="display:none;visibility:hide">noselection</TextArea><TextArea name="productFamily" style="display:none;visibility:hide"></TextArea><TextArea name="evaluateRF" style="display:none;visibility:hide">true</TextArea><TextArea name="rwTarget" style="display:none;visibility:hide">/rfPlayerWidget.do</TextArea><TextArea name="showsplink" style="display:none;visibility:hide">true</TextArea><TextArea name="accesslevels" style="display:none;visibility:hide">SAL_Public</TextArea><TextArea name="category" style="display:none;visibility:hide">noselection</TextArea><TextArea name="forum" style="display:none;visibility:hide"></TextArea><TextArea name="cmd" style="display:none;visibility:hide">search</TextArea><TextArea name="locale" style="display:none;visibility:hide">LA_eng_US</TextArea><TextArea name="searchString" style="display:none;visibility:hide">test</TextArea><TextArea name="showSavedSearches" style="display:none;visibility:hide">true</TextArea><TextArea name="btnSearchAll" style="display:none;visibility:hide"></TextArea><TextArea name="searchFor" style="display:none;visibility:hide"></TextArea><TextArea name="contextType" style="display:none;visibility:hide">gs</TextArea><TextArea name="document" style="display:none;visibility:hide">DT_KB_1_1</TextArea><TextArea name="usemicrosite" style="display:none;visibility:hide">true</TextArea>
  		</form>

	<form name="FavoriteSearch" method="post" action="search.do" target="saveThisDialog" >
	    <input type="hidden" name="stateID" value="1 0 376180232">
	    <input type="hidden" name="servicerequest" value="%3cDialogRequest+DocTypes%3d%22DT_KB_1_1%22+Entitlements%3d%22SAL_Public%22+MS%3d%22MS_Customer%22+Published%3d%22KCP_Publish%2c-KCP_Threaded%2c-KCP_RWCase%2c-KCP_Feedback%22+Segments%3d%22UMCR_CUSTOMERMS_1_1%2cSG_DESKTOP_1_1%2cSG_SERVER_DATACENTER_1_1%2cSG_VMWAREACE_1_2%2cSG_VMWARECAPACITYPLANNER_1_2%2cSG_VMWARECONSOLIDATEDBACKUP_1_2%2cSG_VMWARECONVERTER_1_2%2cSG_VMWAREESX_1_2%2cSG_VMWAREESXI_1_2%2cSG_VMWAREFUSION_1_2%2cSG_VMWAREGSXSERVER_1_2%2cSG_VMWAREVCENTERLABMANAGER_1_2%2cSG_VMWAREP2VASSISSTANT_1_2%2cSG_VMWAREPLAYER_1_2%2cSG_VMWAREINFRASTRUCTURESDK_1_2%2cSG_VMWARESERVER_1_2%2cSG_VMWAREVCENTERUPDATEMANAGER_1_2%2cSG_VMWAREVIRTUALDESKTOPMANAGER_1_2%2cSG_VMWAREVIRTUALCENTER_1_2%2cSG_VMWAREWORKSTATION_1_2%2cSG_VMWAREVCENTERLIFECYCLEMANAGER_1_2%2cSG_VMWAREVCENTERSTAGEMANAGER_1_2%2cSG_VMWAREVCENTERSITERECOVERYMANAGER_1_2%2cSG_VMWARETHINAPP_1_2%2cSG_VMWARETHINSTALL_1_2%2cSG_VMWARESTUDIO_1_2%2cSG_DEVELOPERSUPPORT_1_1%2cSG_VOLUMEPURCHASINGPROGRAM_1_1%2cSG_MYVMWARE_1_1%2cSG_VMWAREVCENTERSERVER_1_2%2cDT_COMMUNITIES_1_1%2cDT_KB_1_1%2cDT_PRODUCTDOCUMENTATION_1_1%2cDT_WIKI_1_1%22+appContext%3d%22AC_KSS%22+application%3d%22KSS%22+documentSortField%3d%22%22+documentSortOrder%3d%221%22+minDocumentsForQuestions%3d%2210%22+numDocumentSet%3d%22%22+numDocuments%3d%2225%22+requestType%3d%22StartDialog%22+searchTSE%3d%22true%22+sessionID%3d%22672F57AEE70335A77B85459638B3C728%22+userID%3d%22guest%22%3e%3cLanguage%3e%3cDialog%3e%3cLocale+localeID%3d%22LA_eng_US%22%2f%3e%3c%2fDialog%3e%3cResult%3e%3cLocale+localeID%3d%22LA_eng_US%22%2f%3e%3c%2fResult%3e%3c%2fLanguage%3e%3cUserQuery%3etest%3c%2fUserQuery%3e%3cConstraints%2f%3e%3cFilter+ids%3d%22DT_KB_1_1%22+root%3d%22DT_Document%22+type%3d%22Standard%22%2f%3e%3cExtendedRequest%3e%3cProduct%3e%3c%2fProduct%3e%3cDebugLevel+level%3d%22-1%22%2f%3e%3c%2fExtendedRequest%3e%3c%2fDialogRequest%3e" />
	    <input type="hidden" name="SearchName" value="test" />
	    <input type="hidden" name="cmd" value="saveSearch"/>
	    <input type="hidden" name="ItemType" value="SEARCH"/>
	    <input type="hidden" name="locale" value="LA_eng_US" />
	</form>

	<form name="cpplayer" method="post" action="" onsubmit='return false;'>
					<input type="hidden" name="product" value="noselection">
					<input type="hidden" name="category" value="noselection">
					<input type="hidden" name="datepublished" value="">
					<input type="hidden" name="document" value="DT_KB_1_1">
			    <input type="hidden" name="stateId" value="1 0 376180232">
		<textarea name="languages" style="display:none;visibility:hide"></textarea>
	    <input type="hidden" name="searchMode" value="GuidedSearch">
	    <input type="hidden" name="searchString" value="test">
		<textarea name="savedSearches" style="display:none;visibility:hide"></textarea>
		<textarea name="showSavedSearches" style="display:none;visibility:hide">true</textarea>
		<textarea name="showFocusChoices" style="display:none;visibility:hide"></textarea>
	    <input type="hidden" name="searchType" value="">
	</form>


			
				
		<!-- Recommendations-->	 
	 </td>   	
        <td valign="top" style="padding-top:30px;padding-left:15px;">
		<div width="220">
        	 
<div  id="cms-body" class="yui-skin-sam">
	<div class="myAccordion">
		<h2 class="f14">Additional Resources</h2>
		<div class="yui-cms-accordion fade fixIE">
			<ul id="accordion-navigation">	
				<li class="first">
					<div class="yui-cms-item yui-panel selected">
							<a ref="nofollow" href="#acc1" class="accordionToggleItem"><div class="hxd">Alerts</div></a>
							<div class="bd">
							  <div class="fixed">
									
 
							  </div>
							</div>

					</div>				
				</li>
				<li>
					<div class="yui-cms-item yui-panel">				
							<a href="#acc2" class="accordionToggleItem"><div class="hxd">Answer Wizards</div></a>
							<div class="bd">
							  <div class="fixed">						  	
																					<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?product=noselection&evaluateRF=true&BROWSE_Answerwisards.NodeType=leaf&TaxoName=RF_ResolutionFlows&showsplink=true&accesslevels=SAL_Public&forum=&locale=LA_eng_US&searchString=test&showSavedSearches=true&btnSearchAll=&contextType=gs&document=DT_KB_1_1&BROWSE_Answerwisards.NodeId=RF_ESXSERVERISDISCONNECTEDORNOTRESPONDING_1_1&productFamily=&WidgetName=BROWSE_Answerwisards&rwTarget=%2FrfPlayerWidget.do&searchMode=GuidedSearch&category=noselection&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&searchFor=&NodeType=leaf&NodeName=ESX+Server+is+Disconnected+or+Not+Responding&NodeId=RF_ESXSERVERISDISCONNECTEDORNOTRESPONDING_1_1&usemicrosite=true&rfAccessed=Browse&AppContext=null&sendEventForumBrowse=true">ESX Server is Disconnected or Not Responding</a></h5>
												<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?product=noselection&evaluateRF=true&BROWSE_Answerwisards.NodeType=leaf&TaxoName=RF_ResolutionFlows&showsplink=true&accesslevels=SAL_Public&forum=&locale=LA_eng_US&searchString=test&showSavedSearches=true&btnSearchAll=&contextType=gs&document=DT_KB_1_1&BROWSE_Answerwisards.NodeId=RF_VIRTUALMACHINGHASSTOPPEDRESPONDING_1_1&productFamily=&WidgetName=BROWSE_Answerwisards&rwTarget=%2FrfPlayerWidget.do&searchMode=GuidedSearch&category=noselection&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&searchFor=&NodeType=leaf&NodeName=Virtual+Machine+has+stopped+responding&NodeId=RF_VIRTUALMACHINGHASSTOPPEDRESPONDING_1_1&usemicrosite=true&rfAccessed=Browse&AppContext=null&sendEventForumBrowse=true">Virtual Machine has stopped responding</a></h5>
												<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?product=noselection&evaluateRF=true&BROWSE_Answerwisards.NodeType=leaf&TaxoName=RF_ResolutionFlows&showsplink=true&accesslevels=SAL_Public&forum=&locale=LA_eng_US&searchString=test&showSavedSearches=true&btnSearchAll=&contextType=gs&document=DT_KB_1_1&BROWSE_Answerwisards.NodeId=RF_IDENTIFYINGSHAREDSTORAGEISSUES_1_1&productFamily=&WidgetName=BROWSE_Answerwisards&rwTarget=%2FrfPlayerWidget.do&searchMode=GuidedSearch&category=noselection&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&searchFor=&NodeType=leaf&NodeName=Identifying+shared+storage+issues&NodeId=RF_IDENTIFYINGSHAREDSTORAGEISSUES_1_1&usemicrosite=true&rfAccessed=Browse&AppContext=null&sendEventForumBrowse=true">Identifying shared storage issues</a></h5>
												<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?product=noselection&evaluateRF=true&BROWSE_Answerwisards.NodeType=leaf&TaxoName=RF_ResolutionFlows&showsplink=true&accesslevels=SAL_Public&forum=&locale=LA_eng_US&searchString=test&showSavedSearches=true&btnSearchAll=&contextType=gs&document=DT_KB_1_1&BROWSE_Answerwisards.NodeId=RF_CANNOTPOWERONANESXVIRTUALMACHINEWHENNOTHINGCHANGED_1_1&productFamily=&WidgetName=BROWSE_Answerwisards&rwTarget=%2FrfPlayerWidget.do&searchMode=GuidedSearch&category=noselection&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&searchFor=&NodeType=leaf&NodeName=Cannot+power+on+an+ESX+virtual+machine+when+nothing+changed&NodeId=RF_CANNOTPOWERONANESXVIRTUALMACHINEWHENNOTHINGCHANGED_1_1&usemicrosite=true&rfAccessed=Browse&AppContext=null&sendEventForumBrowse=true">Cannot power on an ESX virtual machine when nothing changed</a></h5>
												<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?product=noselection&evaluateRF=true&BROWSE_Answerwisards.NodeType=leaf&TaxoName=RF_ResolutionFlows&showsplink=true&accesslevels=SAL_Public&forum=&locale=LA_eng_US&searchString=test&showSavedSearches=true&btnSearchAll=&contextType=gs&document=DT_KB_1_1&BROWSE_Answerwisards.NodeId=RF_TROUBLESHOOTINGTHEVMWAREVIRTUALCENTERSERVERSERVICEWHENITDOESNOTSTART_1_1&productFamily=&WidgetName=BROWSE_Answerwisards&rwTarget=%2FrfPlayerWidget.do&searchMode=GuidedSearch&category=noselection&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&searchFor=&NodeType=leaf&NodeName=Troubleshooting+the+VMware+VirtualCenter+Server+service+when+it+does+not+start&NodeId=RF_TROUBLESHOOTINGTHEVMWAREVIRTUALCENTERSERVERSERVICEWHENITDOESNOTSTART_1_1&usemicrosite=true&rfAccessed=Browse&AppContext=null&sendEventForumBrowse=true">Troubleshooting the VMware VirtualCenter Server service when it does not start</a></h5>
					 		
	
 
							  </div>
							</div>

					</div>		
				</li>		
				
					
					
						<li>
							<div class="yui-cms-item yui-panel">				
								<a href="#acc2" class="accordionToggleItem"><div class="hxd">Most Popular Documents</div></a>
								<div class="bd">
							  		<div class="fixed">
										
																			
																								
												<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=2006859&sliceId=2&docTypeID=DT_KB_1_1">
		 				Windows 8 operating system does not boot or install on ESXi or ESX  
											(2006859)
									</a></h5>
		  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=1003945&sliceId=1&docTypeID=DT_KB_1_1">
		 				Hardware and firmware requirements for 64-bit guest operating systems  
											(1003945)
									</a></h5>
		  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=1012245&sliceId=1&docTypeID=DT_KB_1_1">
		 				Downloading VMware products and troubleshooting issues with downloads  
											(1012245)
									</a></h5>
		  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=1030265&sliceId=2&docTypeID=DT_KB_1_1">
		 				vHBAs and other PCI devices may stop responding in ESX/ESXi 4.1 and ESXi 5.0 when using Interrupt Re...  
											(1030265)
									</a></h5>
		  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=1001805&sliceId=1&docTypeID=DT_KB_1_1">
		 				Choosing a network adapter for your virtual machine  
											(1001805)
									</a></h5>
											
										
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="yui-cms-item yui-panel">				
								<a href="#acc2" class="accordionToggleItem"><div class="hxd">Most Recent Documents</div></a>
								<div class="bd">
							  		<div class="fixed">
										    	  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=2031237&sliceId=1&docTypeID=DT_KB_1_1">
		 				Reopened calls do not contain Actions and Solutions text entered when 2 step closure is used  
											(2031237)
									</a></h5>
		  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=2031235&sliceId=1&docTypeID=DT_KB_1_1">
		 				Viewing the dependencies of a workflow from the task screen of a request fails with the error: The s...  
											(2031235)
									</a></h5>
		  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=2031101&sliceId=1&docTypeID=DT_KB_1_1">
		 				Filters disappear from the filter set in vCenter Configuration Manager  
											(2031101)
									</a></h5>
		  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=2031082&sliceId=1&docTypeID=DT_KB_1_1">
		 				Known issues when installing or upgrading to vCenter Server 5.x  
											(2031082)
									</a></h5>
		  		  		<h5 class="vmwidgetdoc"><a href="microsite.do?cmd=displayKC&docType=kc&externalId=2031001&sliceId=1&docTypeID=DT_KB_1_1">
		 				Configuring LDAP Integration for Socialcast On Premise  
											(2031001)
									</a></h5>
	




									</div>
								</div>
							</div>								
						</li>
					
				
			</ul>
		</div>
	</div>
</div>   
		</div>
        </td>

    </tr>
    </table>
    
<!-- We need useContextData="true" in order to enable ext mapped nodes - TW 33951 -->
	<!--widget:recommendation
		pageletid="MSRecommendationPagelet5"
		useContextData="true"
		useDataFromProfile="true"
		parameterQuery="searchString"
	/-->
	<!--widget:recommendation
		pageletid="MSRecommendationPagelet2"
		useContextData="true"
		useDataFromProfile="true"
		parameterQuery="searchString"
	/-->
<br/>
	





	</div>
	</div>

	<div id="top-of-page">
		<div id="iglobal-sites"></div>
		<div id="iprimary-navigation"></div>
		<div id="isite-tools"></div>
		<div id="ilanguage"></div>
		<div id="isearch-form"></div>
	</div>

	<div id="ifooter" class="noprint"></div>

</div>

<div id="custom-extras"></div>

<div id="jsScripts"></div>

<script type="text/javascript" src="http://www.vmware.com/app/template/?set=kb"></script>


<!-- SiteCatalyst code version: H.15.1. Copyright 1997-2008 Omniture, Inc. More info available at http://www.omniture.com -->
<script type="text/javascript" src="//www.vmware.com/files/templates/inc/s_code.js"></script>
<script language="JavaScript" type="text/javascript">
<!--
try {
/* Knova */

/* dedupe pages with multiple url's */
url.hier1=url.hier1.replace(/,microsites/,"");


/* patch for identifying search collection and keyword */
if (url.externalId) {
    url.file=url.externalId;
} else if (url.pathname.match("/selfservice/(microsites/)?search(Entry)?.do") || (url.pathname.match("/selfsupport/s3portal.portal") && url._pageLabel=="s3Portal_page_knova_search")) {
    if (document.forms[0].id.match(/searchForm/)) {
    url.prop6=document.forms[0].searchString.value || "";
    url.prop15="Knova_Search";
    } else if(frames[0].document && frames[0].document.forms[0].searchString.value != "") {
    url.prop6=frames[0].document.forms[0].searchString.value || "";
    url.prop15="Knova_Search";
    }
}


/* set s.prop1-5 */
url.hierarchy=new Array();
url.hierarchy=url.hier1.split(",");
for (var i=0; i<url.hierarchy.length; i++) {
   if (i <= 4)
       eval("url.prop"+(i+1)+"='"+url.hierarchy[i]+"';");
}

for (var i=url.hierarchy.length; i<5; i++)
    eval("url.prop"+(i+1)+"='"+url.hierarchy[url.hierarchy.length-1]+"';");

/* set page variables */
url.pagename=url.hier1.replace(/,/g," : ");
url.fullpagename=url.pagename+" : "+url.file;
url.channel=url.prop1;

/* You may give each page an identifying name, server, and channel on
 * the next lines. */
s.channel=url.channel
s.pageName=url.fullpagename
s.pageType=""
s.prop1=url.prop1
s.prop2=url.prop2
s.prop3=url.prop3
s.prop4=url.prop4
s.prop5=url.prop5
s.prop6=url.prop6
s.prop15=url.prop15
s.prop23="KB"
/* Conversion Variables */
s.campaign=""
s.events=""
/* Hierarchy Variables */
s.hier1=url.hier1
/************* DO NOT ALTER ANYTHING BELOW THIS LINE ! **************/
var s_code=s.t();if(s_code)document.write(s_code)

if(navigator.appVersion.indexOf('MSIE')>=0)document.write(unescape('%3C')+'\!-'+'-')
} catch(e) {}
//-->
</script>
<!--/DO NOT REMOVE/-->
<!-- End SiteCatalyst code version: H.15.1. -->

</body>
</html>

	
<!-- Auto Suggest -->
<script type="text/javascript">		
		j$("form[id='id_searchForm'] input[name='searchString']").autocomplete('/selfservice/autosuggest/AutoSuggestServlet');	
		if(j$("form[id='id_searchForm'] input[name='searchString']").val() != '')
			j$("form[id='id_searchForm'] input[name='searchString']").focus();
</script>
<!-- /AutoSuggest -->