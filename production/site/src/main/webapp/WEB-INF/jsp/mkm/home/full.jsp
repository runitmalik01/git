<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html >
<head>
    <title>VMware KB - Knowledge Base Articles for all VMware Products</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-store">
    <META HTTP-EQUIV="Expires" CONTENT="Now">
    <META HTTP-EQUIV="Expires" CONTENT="-1">

    




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
    
    <link rel="stylesheet" type="text/css" href="../../../../css/mkm/accordion.css" />
    <link rel="stylesheet" type="text/css" href="../../../../css/mkm/container.css" />
    <link rel="stylesheet" type="text/css" href="../../../../css/mkm/dec_rel.css" />
    <script src="../../../../js/mkm/selfservice/utilities.js"></script>
    <script src="../../../../js/mkm/selfservice/bubbling.js"></script>
    <script src="../../../../js/mkm/selfservice/accordion.js"></script>
    <script>
	function setSortOrder(strSort){
		document.sortForm.sort.value=strSort;
		document.sortForm.submit();
	}
    </script>
    <script src="../../../js/mkm/searchentry.js"></script>
	<!-- Auto Suggest -->
    <link rel="stylesheet" type="text/css" href="../../../css/mkm/jquery.autocomplete.css" />
	<script src="../../../../js/mkm/jquery-1.4.4.min.js"></script>  
	<script src="../../../../js/mkm/jquery.autocomplete.js"></script>  
	<style>
		input {
			font-size: 18px Arial, Helvetica, sans-serif;
			margin-left:-2px;
		}		
	</style>
</head>

<body class="js">
















	<div id="container">
	<div id="content-container" class="wide">
	<div id="content">	
	





	<h1 class="kbtitle noprint">Knowledge Base <a href="search">Search</a> </h1>
	<div class="secondsection noprint">The VMware Knowledge Base provides support solutions, error messages and troubleshooting guides</div>

<div id="top-buttons" class="noprint">
	<a href="/selfservice"><img src="http://www.vmware.com/files/site/images/buttons/btn_kb-home.png" border="0"></a> &nbsp; 
	<a href="/kb/878"><img src="http://www.vmware.com/files/site/images/buttons/btn_knowledge-base-help.png" border="0"></a>
</div>

	
    







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
										<td style="padding:5px;" colspan="2" align="left" valign="middle"><input name="searchString" value="" maxLength="4000" class="control_searchString"></td>										
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
    			              <tr><td align="center" valign="middle" width="18%"></td>

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


	
	

	
   
 

    

	<!-- /Main Body Table -->

    <table cellpadding="0" cellspacing="0" width="100%" border="0">
    <tr>
	<td valign=top width="200px">
	<div class="umbrowse">
	









<script language="javascript" src="../../../../js/mkm/UMBrowseController.js" type="text/javascript"></script>
<script language="JavaScript">



	function onSelectNodeMS_HOME_PAGELET(id) {
		onSelectUMBrowseSegment(id,"MS_HOME_PAGELET");
	}

</script>
<div id="productbrowse">
<div class="productbrowseheader">
<h2>Browse: Products</h2>
</div>
<div class="productbrowsecontainer">
	
			
			




<!--link rel='stylesheet' href='/selfservice/tree.css'-->

<script type='text/javascript' src='../../../../js/mkm/TreeDWRServer.js'></script>
<script type='text/javascript' src='../../../../js/mkm/engine.js'></script>

<script language="javascript" src="../../../../js/mkm/tree.js"></script>
<script language="javascript">



function getCurrentNodeId() {
	return tMS_HOME_PAGELET.getCurrentNodeId();
}

function setCurrent(nodeId) {
	tMS_HOME_PAGELET.setCurrent(nodeId);
}

function highlightNode(nodeId) {
	tMS_HOME_PAGELET.highlightNode(nodeId);
}

function expandNode(pathToNode, onFinishFunction) {
    tMS_HOME_PAGELET.expandNode(pathToNode, onFinishFunction);
}

function getParentNodeId(nodeId) {
	return tMS_HOME_PAGELET.getParentNodeId(nodeId);
}

function expandLoadedNode(nodeId, onFinishFunction) {
    tMS_HOME_PAGELET.expandLoadedNode(nodeId, onFinishFunction);
}

function refreshSubNodes(nodeId, onFinishFunction) {
    tMS_HOME_PAGELET.refreshSubNodes(nodeId, onFinishFunction);
}

function collapseNode(nodeId, childsCount) {
    tMS_HOME_PAGELET.collapseNode(nodeId, childsCount);
}

function getAboveNodeId(nodeId) {
	return tMS_HOME_PAGELET.getAboveNodeId(nodeId);
}

function getNextNodeId(nodeId) {
	return tMS_HOME_PAGELET.getNextNodeId(nodeId);
}

function getNodeName(nodeId) {
	return tMS_HOME_PAGELET.getNodeName(nodeId);
}

function getAllChildNodes(nodeId) {
	return tMS_HOME_PAGELET.getAllChildNodes(nodeId);
}

function onDrop(element1, element2) {
	element1.style.display="none";

	droppedId = element1.id;
	droppedOnId = element2.id;

	if (droppedId.indexOf("name")==0)
		droppedId = droppedId.substring(4);// remove "name" prefix

	if (droppedOnId.indexOf("name")==0)
		droppedOnId = droppedOnId.substring(4);

	parentId = getParentNodeId( droppedId );

	clearDNDValues(tMS_HOME_PAGELET);

	eval( ""+tMS_HOME_PAGELET.onDropHandler+"('"+parentId+"','"+droppedId+"','"+droppedOnId+"')" );
}

function dndFailture(e) {
	window.location.reload();
}


Tree.prototype.Toggle = function (item, childsCount) {
    var obj=getObjectById("tMS_HOME_PAGELET",  item );    
    visible=(obj.style.display == "block" || obj.style.display != "none")    
    if (!visible && childsCount && this.maxChildsCount>0 && childsCount>this.maxChildsCount) {
        eval(this.maxChildsCountOverflowHandler+"(item, childsCount)");
        return;
    }

    key=document.getElementById("x" + item);

    ibj_innerHTML = this.allTrim(obj.innerHTML);

    if ( !visible && ibj_innerHTML.length==0 ) {
        this.callLoadSubnodes( item,
				function(result) { tMS_HOME_PAGELET.addSubnodesHandler(result); }
		);
    }

    if (visible) {
        obj.style.display="none";
        key.innerHTML = this.toggleHtml('plus', item, childsCount);
        TreeDWRServer.collapseNode(this.currentTreeId, item);
    } else {
        obj.style.display="block";
        key.innerHTML = this.toggleHtml('minus', item, childsCount);
        TreeDWRServer.expandNode(this.currentTreeId, item);
    }
}



Tree.prototype.expandNode = function (pathToNode, onFinishFunction) {

    if (onFinishFunction)
        this.onFinishRefreshNandler = onFinishFunction;
    else
        this.onFinishRefreshNandler = null;

    for (q=0; q<pathToNode.length; q++) {
        tResult = this.tryNotOpened(pathToNode[q]);
        if (tResult) {
            pathToNode = pathToNode.slice(q,pathToNode.length);

            param_list = new Array();
            for (ww=0; ww<pathToNode.length; ww++)
                param_list[ww]=pathToNode[ww];

            TreeDWRServer.expandNodes(this.currentTreeId, param_list,
					function(result) { tMS_HOME_PAGELET.refreshSubNodesHandler(result); }
			);
            return;
        }
    }

	if( this.onFinishRefreshNandler ) {
		this.onFinishRefreshNandler();
		this.onFinishRefreshNandler = null;
	}
};

Tree.prototype.collapseNode = function (nodeId, childsCount ) {
    var obj=document.getElementById(nodeId);
    obj.style.display="none";
    key=document.getElementById("x" + nodeId);
    key.innerHTML = this.toggleHtml('plus', nodeId, childsCount);

    TreeDWRServer.collapseNode(this.currentTreeId, nodeId);
};

Tree.prototype.doMore = function (nodeId, treeId) {
	TreeDWRServer.moreNodes(treeId, nodeId, this.getNodeDeep(nodeId)+1,
			function(result) { tMS_HOME_PAGELET.refreshSubNodesHandler(result); }
	);
};

Tree.prototype.doLess = function (nodeId, treeId) {
	TreeDWRServer.lessNodes(treeId, nodeId, this.getNodeDeep(nodeId)+1,
			function(result) { tMS_HOME_PAGELET.refreshSubNodesHandler(result); }
	);
};

Tree.prototype.addSubnodesHandler = function (nodes) {
    if (nodes==null || nodes.length==0) return;

    this.nodeHasBeenLoaded(nodes[0].parentID);

    var span = getObjectById("tMS_HOME_PAGELET", nodes[0].parentID)
    if(!span) return;

    if ( nodes.length==1 && nodes[0].id == nodes[0].parentID ) {
        span.innerHTML = "";
        return;
    }

    var spanHTML = span.innerHTML;
    spanHTML += this.subnodesHtml(nodes);
    span.innerHTML = spanHTML;

    TreeDWRServer.getMenus( this.currentTreeId,
			function(result) { tMS_HOME_PAGELET.updateMenusHandler(result); }
	);

	this.updateDraggableParents(nodes);
};


Tree.prototype.refreshSubNodes = function (nodeId, onFinishFunction) {
    this.turnOffEvents = true;

	this.callLoadSubnodes( nodeId,
			function(result) { tMS_HOME_PAGELET.refreshSubNodesHandler(result); }
	);

	if (onFinishFunction)
        this.onFinishRefreshNandler = onFinishFunction;
    else
        this.onFinishRefreshNandler = null;
}

Tree.prototype.refreshSubNodesHandler = function (nodes) {
    if (nodes==null || nodes.length==0) return;

    var itemId = nodes[0].parentID;
	this.nodeHasBeenLoaded( itemId );

	var span = getObjectById("tMS_HOME_PAGELET", itemId);
    if(!span) return;

    if (nodes.length==1 && nodes[0].id==itemId) {
        span.innerHTML = "";
        key=document.getElementById("x" + itemId);
        if(key) key.innerHTML="";
        this.turnOffEvents = false;
		return;
    }
    //if ( this.maxChildsCount>0 && nodes.length>this.maxChildsCount ) {
        //obj=document.getElementById(itemId);
        //obj.style.display="none";
        //key.innerHTML = toggleHtml('plus', itemId, nodes.length);

        //TreeDWRServer.collapseNode(this.currentTreeId, itemId);
        ////this code leads to circularity sometimes
        ////this.refreshSubNodes("SM");
		////return;
    //}

    span.innerHTML = this.subnodesHtml(nodes);
    TreeDWRServer.getMenus( this.currentTreeId,
			function(result) { tMS_HOME_PAGELET.updateMenusHandler(result); }
	);

	this.setCurrent(this.currentNodeId);

	if (this.onFinishRefreshNandler!=null)
        this.onFinishRefreshNandler();

	this.updateDraggableParents(nodes);
	this.turnOffEvents = false;
};

	tMS_HOME_PAGELET = new Tree('tMS_HOME_PAGELET');

	tMS_HOME_PAGELET.currentTreeId = "MS_HOME_PAGELET";
    tMS_HOME_PAGELET.relPathToTreeDir = "../tree/";
    tMS_HOME_PAGELET.maxChildsCount = 2147483647;
    tMS_HOME_PAGELET.maxChildsCountOverflowHandler = "";
    tMS_HOME_PAGELET.onClickNodeHandler = "void";
    tMS_HOME_PAGELET.onDblClickNodeHandler = "void";
    tMS_HOME_PAGELET.makeNonSelectableGray = true;

</script>

<table border="0" cellpadding="0" cellspacing="0" onclick="tMS_HOME_PAGELET.hideCurrentMenu();" width="100%">
    <tr class="trtreeitem">
        <td valign="top" width="100%">
		<div id="tMS_HOME_PAGELET_ROOT_TREE_NODE" class="tree pointer">

                <table border=0 cellpadding="0" cellspacing="0" width="100%" class="tbl_treeroot tbl_SG_SERVER_DATACENTER_1_1 tbl_sg_parent">
                    <tr class="tr_product_parent tr_SG_SERVER_DATACENTER_1_1">

							<td class="treeicon">
                            	<div id="xSG_SERVER_DATACENTER_1_1">
                                	<a href="javascript:void(0)" onclick="javascript:tMS_HOME_PAGELET.Toggle('SG_SERVER_DATACENTER_1_1',102);"><img 
                                    	 src='../../../../site/images/mkm/plus.gif' hspace='0' vspace='0' border='0'></a>
                            	</div>
                        	</td>

                        	<td>
                            	<div class="productbrowsetree" onclick="javascript:tMS_HOME_PAGELET.setCurrentNode('SG_SERVER_DATACENTER_1_1','onSelectNodeMS_HOME_PAGELET');"
                                 	 onDblClick="void('true')"
                               		 oncontextmenu="return tMS_HOME_PAGELET.popupMenu(event, '0','SG_SERVER_DATACENTER_1_1','onSelectNodeMS_HOME_PAGELET');">
										   <div id="nameSG_SERVER_DATACENTER_1_1" class='treediv'>
											   <a href="#">Datacenter</a>
										   </div>
                            	</div>
                        	</td>

					</tr>
                </table>

					<div id="SG_SERVER_DATACENTER_1_1" style="display:none" class="treenode_none">
</div>
                <table border=0 cellpadding="0" cellspacing="0" width="100%" class="tbl_treeroot tbl_SG_DESKTOP_1_1 tbl_sg_parent">
                    <tr class="tr_product_parent tr_SG_DESKTOP_1_1">

							<td class="treeicon">
                            	<div id="xSG_DESKTOP_1_1">
                                	<a href="javascript:void(0)" onclick="javascript:tMS_HOME_PAGELET.Toggle('SG_DESKTOP_1_1',10);"><img 
                                    	 src='../../../../site/images/mkm/plus.gif' hspace='0' vspace='0' border='0'></a>
                            	</div>
                        	</td>

                        	<td>
                            	<div class="productbrowsetree" onclick="javascript:tMS_HOME_PAGELET.setCurrentNode('SG_DESKTOP_1_1','onSelectNodeMS_HOME_PAGELET');"
                                 	 onDblClick="void('true')"
                               		 oncontextmenu="return tMS_HOME_PAGELET.popupMenu(event, '0','SG_DESKTOP_1_1','onSelectNodeMS_HOME_PAGELET');">
										   <div id="nameSG_DESKTOP_1_1" class='treediv'>
											   <a href="#">Desktop</a>
										   </div>
                            	</div>
                        	</td>

					</tr>
                </table>

					<div id="SG_DESKTOP_1_1" style="display:none" class="treenode_none">
</div>
                <table border=0 cellpadding="0" cellspacing="0" width="100%" class="tbl_treeroot tbl_SG_DEVELOPERSUPPORT_1_1 tbl_sg_parent">
                    <tr class="tr_product_parent tr_SG_DEVELOPERSUPPORT_1_1">

							<td class="treeicon">
                            	<div id="xSG_DEVELOPERSUPPORT_1_1">
                                	<a href="javascript:void(0)" onclick="javascript:tMS_HOME_PAGELET.Toggle('SG_DEVELOPERSUPPORT_1_1',25);"><img 
                                    	 src='../../../../site/images/mkm/plus.gif' hspace='0' vspace='0' border='0'></a>
                            	</div>
                        	</td>

                        	<td>
                            	<div class="productbrowsetree" onclick="javascript:tMS_HOME_PAGELET.setCurrentNode('SG_DEVELOPERSUPPORT_1_1','onSelectNodeMS_HOME_PAGELET');"
                                 	 onDblClick="void('true')"
                               		 oncontextmenu="return tMS_HOME_PAGELET.popupMenu(event, '0','SG_DEVELOPERSUPPORT_1_1','onSelectNodeMS_HOME_PAGELET');">
										   <div id="nameSG_DEVELOPERSUPPORT_1_1" class='treediv'>
											   <a href="#">Developer Support</a>
										   </div>
                            	</div>
                        	</td>

					</tr>
                </table>

					<div id="SG_DEVELOPERSUPPORT_1_1" style="display:none" class="treenode_none">
</div>
                <table border=0 cellpadding="0" cellspacing="0" width="100%" class="tbl_treeroot tbl_SG_MYVMWARE_1_1 tbl_sg_parent">
                    <tr class="tr_product_parent tr_SG_MYVMWARE_1_1">
                      	<td class="treeicon">
                                <div id="xSG_MYVMWARE_1_1"></div>
                            </td>

                        	<td>
                            	<div class="productbrowsetree" onclick="javascript:tMS_HOME_PAGELET.setCurrentNode('SG_MYVMWARE_1_1','onSelectNodeMS_HOME_PAGELET');"
                                 	 onDblClick="void('true')"
                               		 oncontextmenu="return tMS_HOME_PAGELET.popupMenu(event, '0','SG_MYVMWARE_1_1','onSelectNodeMS_HOME_PAGELET');">
										   <div id="nameSG_MYVMWARE_1_1" class='treediv'>
											   <a href="#">My VMware</a>
										   </div>
                            	</div>
                        	</td>

					</tr>
                </table>

                        <div id="SG_MYVMWARE_1_1" style="display:block" class="treenode_block"></div>

                <table border=0 cellpadding="0" cellspacing="0" width="100%" class="tbl_treeroot tbl_SG_VOLUMEPURCHASINGPROGRAM_1_1 tbl_sg_parent">
                    <tr class="tr_product_parent tr_SG_VOLUMEPURCHASINGPROGRAM_1_1">
                      	<td class="treeicon">
                                <div id="xSG_VOLUMEPURCHASINGPROGRAM_1_1"></div>
                            </td>

                        	<td>
                            	<div class="productbrowsetree" onclick="javascript:tMS_HOME_PAGELET.setCurrentNode('SG_VOLUMEPURCHASINGPROGRAM_1_1','onSelectNodeMS_HOME_PAGELET');"
                                 	 onDblClick="void('true')"
                               		 oncontextmenu="return tMS_HOME_PAGELET.popupMenu(event, '0','SG_VOLUMEPURCHASINGPROGRAM_1_1','onSelectNodeMS_HOME_PAGELET');">
										   <div id="nameSG_VOLUMEPURCHASINGPROGRAM_1_1" class='treediv'>
											   <a href="#">Volume Purchasing Program</a>
										   </div>
                            	</div>
                        	</td>

					</tr>
                </table>

                        <div id="SG_VOLUMEPURCHASINGPROGRAM_1_1" style="display:block" class="treenode_block"></div>

		</div>
		</td>
    </tr>
</table>



<script language="JavaScript">

	DWREngine.setErrorHandler(handleDWRError);

    function handleDWRError(dwr_error) {
        top.location = "../login.do";
    }
</script>
</div>
</div>
</div>	
	</div>
	</td>

        <td width="520px" valign="top">  
        <form name="sortForm" id="sortForm" action="microsite.do" method="post">
	<div class="tabhead">
	
	<input type=hidden name="sort">
	<ul>
	
	<li><a href="#" onClick="javascript:setSortOrder('notnew')" class="active"><span>Most Popular Documents</span></a></li>
	<li><a href="#" onClick="javascript:setSortOrder('newest')" class="last"><span>Most Recent Documents</span></a></li>
	
	</ul>
	</div>
	</form>
	
                 <!-- hot topics -->
	<div class="kbtab kbthreecol">
	
	    			<table cellpadding="0" cellspacing="0" width="100%" border="0">
	<tr>
		<td class="kbdocshead">VMware KB Article Title</td>
		<td class="kbdocshead headmid">Type of Document</td>
		<td class="kbdocshead" width="80px" align="right">Last Modified</td>
	</tr>
						<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=2006859&sliceId=2&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=2006859&sliceId=2&docTypeID=DT_KB_1_1','Windows 8 operating system does not boot or install on ESXi or ESX')">
										 								<strong>Windows 8 operating system does not boot or install on ESXi or ESX
																	(2006859)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">6/14/12</td>
		</tr>
				<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=1003945&sliceId=1&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=1003945&sliceId=1&docTypeID=DT_KB_1_1','Hardware and firmware requirements for 64-bit guest operating systems')">
										 								<strong>Hardware and firmware requirements for 64-bit guest operating systems
																	(1003945)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">6/21/12</td>
		</tr>
				<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=1012245&sliceId=1&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=1012245&sliceId=1&docTypeID=DT_KB_1_1','Downloading VMware products and troubleshooting issues with downloads')">
										 								<strong>Downloading VMware products and troubleshooting issues with downloads
																	(1012245)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">5/24/12</td>
		</tr>
				<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=1030265&sliceId=2&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=1030265&sliceId=2&docTypeID=DT_KB_1_1','vHBAs and other PCI devices may stop responding in ESX/ESXi 4.1 and ESXi 5.0 when using Interrupt Re...')">
										 								<strong>vHBAs and other PCI devices may stop responding in ESX/ESXi 4.1 and ESXi 5.0 when using Interrupt Re...
																	(1030265)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">5/22/12</td>
		</tr>
				<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=1001805&sliceId=1&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=1001805&sliceId=1&docTypeID=DT_KB_1_1','Choosing a network adapter for your virtual machine')">
										 								<strong>Choosing a network adapter for your virtual machine
																	(1001805)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">4/13/12</td>
		</tr>
				<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=2003715&sliceId=1&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=2003715&sliceId=1&docTypeID=DT_KB_1_1','VMware Fusion 3 support for Mac OS X Lion (10.7)')">
										 								<strong>VMware Fusion 3 support for Mac OS X Lion (10.7)
																	(2003715)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">5/17/12</td>
		</tr>
				<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=1003212&sliceId=1&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=1003212&sliceId=1&docTypeID=DT_KB_1_1','Enhanced vMotion Compatibility (EVC) processor support')">
										 								<strong>Enhanced vMotion Compatibility (EVC) processor support
																	(1003212)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">6/13/12</td>
		</tr>
				<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=1012382&sliceId=1&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=1012382&sliceId=1&docTypeID=DT_KB_1_1','TCP and UDP Ports required to access vCenter Server, ESX hosts, and other network components')">
										 								<strong>TCP and UDP Ports required to access vCenter Server, ESX hosts, and other network components
																	(1012382)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">6/25/12</td>
		</tr>
				<tr valign="center" height="30"  class="hotdoctr" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=1006427&sliceId=1&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=1006427&sliceId=1&docTypeID=DT_KB_1_1','Timekeeping best practices for Linux guests')">
										 								<strong>Timekeeping best practices for Linux guests
																	(1006427)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">3/8/12</td>
		</tr>
				<tr valign="center" height="30" >
				<td class="kbdoc">
											 						<a ref="nofollow" style="cursor:hand" target="_self" href="microsite.do?cmd=displayKC&docType=kc&externalId=1006543&sliceId=1&docTypeID=DT_KB_1_1" onDragStart="fOnDragStart('microsite.do?cmd=displayKCPopup&docType=kc&externalId=1006543&sliceId=1&docTypeID=DT_KB_1_1','VMware ESX and ESXi 3.5 Comparison')">
										 								<strong>VMware ESX and ESXi 3.5 Comparison
																	(1006543)
																</strong>
									</td>
				<td class="body12" align='right' style="padding-right:2px;">KB Article</td>
				<td colspan="2" class="body12" align="right" style="padding-right:15px;">1/27/11</td>
		</tr>
		</table>


	
	
	</div>
	<!-- br/ -->
	<!-- widget:rwEntryWidget action="/rfPlayerWidget.do" / -->
	
        </td>
        <td valign="top" width="220">        	
         	
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
																					<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?WidgetName=BROWSE_Answerwisards&BROWSE_Answerwisards.NodeType=leaf&NodeType=leaf&NodeName=ESX+Server+is+Disconnected+or+Not+Responding&TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.NodeId=RF_ESXSERVERISDISCONNECTEDORNOTRESPONDING_1_1&NodeId=RF_ESXSERVERISDISCONNECTEDORNOTRESPONDING_1_1&rfAccessed=Browse&AppContext=AC_KSS&sendEventForumBrowse=true">ESX Server is Disconnected or Not Responding</a></h5>
												<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?WidgetName=BROWSE_Answerwisards&BROWSE_Answerwisards.NodeType=leaf&NodeType=leaf&NodeName=Virtual+Machine+has+stopped+responding&TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.NodeId=RF_VIRTUALMACHINGHASSTOPPEDRESPONDING_1_1&NodeId=RF_VIRTUALMACHINGHASSTOPPEDRESPONDING_1_1&rfAccessed=Browse&AppContext=AC_KSS&sendEventForumBrowse=true">Virtual Machine has stopped responding</a></h5>
												<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?WidgetName=BROWSE_Answerwisards&BROWSE_Answerwisards.NodeType=leaf&NodeType=leaf&NodeName=Identifying+shared+storage+issues&TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.NodeId=RF_IDENTIFYINGSHAREDSTORAGEISSUES_1_1&NodeId=RF_IDENTIFYINGSHAREDSTORAGEISSUES_1_1&rfAccessed=Browse&AppContext=AC_KSS&sendEventForumBrowse=true">Identifying shared storage issues</a></h5>
												<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?WidgetName=BROWSE_Answerwisards&BROWSE_Answerwisards.NodeType=leaf&NodeType=leaf&NodeName=Cannot+power+on+an+ESX+virtual+machine+when+nothing+changed&TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.NodeId=RF_CANNOTPOWERONANESXVIRTUALMACHINEWHENNOTHINGCHANGED_1_1&NodeId=RF_CANNOTPOWERONANESXVIRTUALMACHINEWHENNOTHINGCHANGED_1_1&rfAccessed=Browse&AppContext=AC_KSS&sendEventForumBrowse=true">Cannot power on an ESX virtual machine when nothing changed</a></h5>
												<h5 class="vmwidgetdoc"><a ref="nofollow" href="/selfservice/browse.do?WidgetName=BROWSE_Answerwisards&BROWSE_Answerwisards.NodeType=leaf&NodeType=leaf&NodeName=Troubleshooting+the+VMware+VirtualCenter+Server+service+when+it+does+not+start&TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.TaxoName=RF_ResolutionFlows&BROWSE_Answerwisards.thisPageUrl=%2Fcustomerservices%2Fservices.do&BROWSE_Answerwisards.NodeId=RF_TROUBLESHOOTINGTHEVMWAREVIRTUALCENTERSERVERSERVICEWHENITDOESNOTSTART_1_1&NodeId=RF_TROUBLESHOOTINGTHEVMWAREVIRTUALCENTERSERVERSERVICEWHENITDOESNOTSTART_1_1&rfAccessed=Browse&AppContext=AC_KSS&sendEventForumBrowse=true">Troubleshooting the VMware VirtualCenter Server service when it does not start</a></h5>
					 		
	
 
							  </div>
							</div>

					</div>		
				</li>		
				
					
						<li>
							<div class="yui-cms-item yui-panel">
								<a ref="nofollow" href="http://blogs.vmware.com/kbtv " target="_blank" class="accordionToggleItem accordionLink"><div class="hxd"><div class="fixed">KBTV</div></div></a>
							</div>				
						</li>
						<li>
							<div class="yui-cms-item yui-panel">
								<a ref="nofollow" href="http://blogs.vmware.com/kbdigest" target="_blank" class="accordionToggleItem accordionLink"><div class="hxd"><div class="fixed">Weekly KB Digest</div></div></a>

							</div>				
						</li>
						<li>
							<div class="yui-cms-item yui-panel">
								<a ref="nofollow" href="http://blogs.vmware.com/kb" target="_blank" class="accordionToggleItem accordionLink" ><div class="hxd"><div class="fixed">Support Insider Blog</div></div></a>
							</div>
						</li>
						<li>
							<div class="yui-cms-item yui-panel">
								<a ref="nofollow" href=" http://www.vmware.com/landing_pages/knowledgebase-content-request.html" target="_blank" class="accordionToggleItem accordionLink" ><div class="hxd"><div class="fixed">Request New Content</div></div></a>
							</div>
						</li>
					
					
				
			</ul>
		</div>
	</div>
</div>   
        </td>

    </tr>
    </table>
	<br />
	
   <!-- /Main Body Table -->


<form name="umbrowse" action="../microsites/msbrowse.do" method="post">
	<input type="hidden" name="UMBrowseSelection" value="">
</form>






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