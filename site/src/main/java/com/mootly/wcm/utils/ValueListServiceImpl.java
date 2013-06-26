
/**
 * ValueListServiceImpl.java
 *
 * 07 Mar,2013
 *
 * 
 */

package com.mootly.wcm.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This is a singleton class which helps in loading the properties 
 * files to populate combo boxes in jsp.
 * @author Komila
 *  
 * 
 */

public final class ValueListServiceImpl implements ValueListService{
	private ResourceBundle objValueListStatesBundle = null;
	private ResourceBundle objValueListCountriesBundle = null;
	private ResourceBundle objValueListQuarterBundle = null;
	private ResourceBundle objValueListDeductionBundle = null;
	private ResourceBundle objValueListDeduction6aBundle = null;
	private ResourceBundle objValueListBooleanBundle = null;
	private ResourceBundle objValueListResStatusBundle = null;
	private ResourceBundle objValueListYearInflationBundle = null;
	private ResourceBundle objValueListSchedule80CDropdownBundle = null;
	private ResourceBundle objValueListAssessmentYearBundle = null;
	private ResourceBundle objValueListNameOfHeadBundle = null;
	private ResourceBundle objValueListNaturePayment = null;
	private ResourceBundle objValueListNumbers = null;
	private ResourceBundle objValueListDeductedYear = null;
	private ResourceBundle objValueListDtaaCountries = null;
	private ResourceBundle objvalueListReturnFile=null;
	private ResourceBundle objvalueListRelationship=null;

	private static final ValueListServiceImpl objValueListServiceImpl = new ValueListServiceImpl(); 
	private static final Logger log = LoggerFactory.getLogger(ValueListServiceImpl.class);
	
	private Map<String,SortedSet<Map.Entry<String,String>>> mapOfValueList = new HashMap<String, SortedSet<Map.Entry<String,String>>>();
	
	/**
	 * Constructor of ValueListServiceImpl class
	 */
	private ValueListServiceImpl() 
	{
		objValueListCountriesBundle    = ResourceBundle.getBundle("valueList_Countries");
		objValueListStatesBundle    = ResourceBundle.getBundle("valueList_states");
		objValueListBooleanBundle   = ResourceBundle.getBundle("valueList_boolean");
		objValueListResStatusBundle = ResourceBundle.getBundle("valueList_residentialStatus");
		objValueListYearInflationBundle = ResourceBundle.getBundle("valueList_InflationIndex");
		objValueListSchedule80CDropdownBundle = ResourceBundle.getBundle("valueList_schedule80C_dropdown");
		objValueListAssessmentYearBundle = ResourceBundle.getBundle("valueList_assessmentyear");
		objValueListNameOfHeadBundle = ResourceBundle.getBundle("valueList_nameofhead");
		objValueListNaturePayment=ResourceBundle.getBundle("valueList_naturepayment");
		objValueListNumbers=ResourceBundle.getBundle("valueList_numbers");
		objValueListDeductedYear=ResourceBundle.getBundle("valueList_deductedyear");
		objValueListDtaaCountries=ResourceBundle.getBundle("valueList_dtaaCountries");
		objValueListDeductionBundle=ResourceBundle.getBundle("valueList_deduction");
		objValueListDeduction6aBundle=ResourceBundle.getBundle("valueList_deduction6a");
		objValueListQuarterBundle    = ResourceBundle.getBundle("valueList_quarter");
		objvalueListReturnFile = ResourceBundle.getBundle("valueList_returnFile");
		objvalueListRelationship= ResourceBundle.getBundle("valueList_relationship");
		
		//initialization
		initCountries();
		initStates();
	}

	/**
	 * This method gives a single way to get ValueListServiceImpl instance 		 	
	 * @param  
	 * @return ValueListServiceImpl  object
	 */

	public static ValueListServiceImpl getInstance() 
	{
		return objValueListServiceImpl;
	}
	
	
	protected void initCountries() {
		TreeMap<String, String> TreeMapCountry =new TreeMap<String, String>();
		//Map<String, String> TreeMapStates = new HashMap<String, String>();
		TreeMapCountry.put("93", objValueListCountriesBundle.getString("valueList.1"));
		TreeMapCountry.put("355", objValueListCountriesBundle.getString("valueList.2"));
		TreeMapCountry.put("213", objValueListCountriesBundle.getString("valueList.3"));
		TreeMapCountry.put("376", objValueListCountriesBundle.getString("valueList.4"));
		TreeMapCountry.put("244", objValueListCountriesBundle.getString("valueList.5"));
		TreeMapCountry.put("1268", objValueListCountriesBundle.getString("valueList.6"));
		TreeMapCountry.put("54", objValueListCountriesBundle.getString("valueList.7"));	
		TreeMapCountry.put("374", objValueListCountriesBundle.getString("valueList.8"));
		TreeMapCountry.put("61", objValueListCountriesBundle.getString("valueList.9"));
		TreeMapCountry.put("43", objValueListCountriesBundle.getString("valueList.10"));
		TreeMapCountry.put("994", objValueListCountriesBundle.getString("valueList.11"));
		TreeMapCountry.put("1242", objValueListCountriesBundle.getString("valueList.12"));
		TreeMapCountry.put("973", objValueListCountriesBundle.getString("valueList.13"));
		TreeMapCountry.put("880", objValueListCountriesBundle.getString("valueList.14"));
		TreeMapCountry.put("1246", objValueListCountriesBundle.getString("valueList.15"));
		TreeMapCountry.put("375", objValueListCountriesBundle.getString("valueList.16"));
		TreeMapCountry.put("32", objValueListCountriesBundle.getString("valueList.17"));
		TreeMapCountry.put("501", objValueListCountriesBundle.getString("valueList.18"));
		TreeMapCountry.put("229", objValueListCountriesBundle.getString("valueList.19"));
		TreeMapCountry.put("975", objValueListCountriesBundle.getString("valueList.20"));
		TreeMapCountry.put("591", objValueListCountriesBundle.getString("valueList.21"));
		TreeMapCountry.put("387", objValueListCountriesBundle.getString("valueList.22"));
		TreeMapCountry.put("267", objValueListCountriesBundle.getString("valueList.23"));
		TreeMapCountry.put("55", objValueListCountriesBundle.getString("valueList.24"));
		TreeMapCountry.put("673", objValueListCountriesBundle.getString("valueList.25"));
		TreeMapCountry.put("359", objValueListCountriesBundle.getString("valueList.26"));
		TreeMapCountry.put("226", objValueListCountriesBundle.getString("valueList.27"));		
		TreeMapCountry.put("257", objValueListCountriesBundle.getString("valueList.28"));
		TreeMapCountry.put("855", objValueListCountriesBundle.getString("valueList.29"));
		TreeMapCountry.put("237", objValueListCountriesBundle.getString("valueList.30"));
		TreeMapCountry.put("1", objValueListCountriesBundle.getString("valueList.31"));
		TreeMapCountry.put("238", objValueListCountriesBundle.getString("valueList.32"));
		TreeMapCountry.put("236", objValueListCountriesBundle.getString("valueList.33"));
		TreeMapCountry.put("235", objValueListCountriesBundle.getString("valueList.34"));
		TreeMapCountry.put("56", objValueListCountriesBundle.getString("valueList.35"));
		TreeMapCountry.put("86", objValueListCountriesBundle.getString("valueList.36"));
		TreeMapCountry.put("57", objValueListCountriesBundle.getString("valueList.37"));
		TreeMapCountry.put("270", objValueListCountriesBundle.getString("valueList.38"));
		TreeMapCountry.put("242", objValueListCountriesBundle.getString("valueList.39"));
		TreeMapCountry.put("506", objValueListCountriesBundle.getString("valueList.40"));
		TreeMapCountry.put("225", objValueListCountriesBundle.getString("valueList.41"));
		TreeMapCountry.put("385", objValueListCountriesBundle.getString("valueList.42"));
		TreeMapCountry.put("53", objValueListCountriesBundle.getString("valueList.43"));
		TreeMapCountry.put("357", objValueListCountriesBundle.getString("valueList.44"));
		TreeMapCountry.put("420", objValueListCountriesBundle.getString("valueList.45"));
		TreeMapCountry.put("850", objValueListCountriesBundle.getString("valueList.46"));
		TreeMapCountry.put("243", objValueListCountriesBundle.getString("valueList.47"));
		TreeMapCountry.put("45", objValueListCountriesBundle.getString("valueList.48"));
		TreeMapCountry.put("253", objValueListCountriesBundle.getString("valueList.49"));
		TreeMapCountry.put("1767", objValueListCountriesBundle.getString("valueList.50"));
		TreeMapCountry.put("1809", objValueListCountriesBundle.getString("valueList.51"));
		TreeMapCountry.put("593", objValueListCountriesBundle.getString("valueList.52"));
		TreeMapCountry.put("20", objValueListCountriesBundle.getString("valueList.53"));
		TreeMapCountry.put("503", objValueListCountriesBundle.getString("valueList.54"));
		TreeMapCountry.put("240", objValueListCountriesBundle.getString("valueList.55"));
		TreeMapCountry.put("291", objValueListCountriesBundle.getString("valueList.56"));
		TreeMapCountry.put("372", objValueListCountriesBundle.getString("valueList.57"));
		TreeMapCountry.put("251", objValueListCountriesBundle.getString("valueList.58"));
		TreeMapCountry.put("679", objValueListCountriesBundle.getString("valueList.59"));
		TreeMapCountry.put("358", objValueListCountriesBundle.getString("valueList.60"));
		TreeMapCountry.put("33", objValueListCountriesBundle.getString("valueList.61"));
		TreeMapCountry.put("241", objValueListCountriesBundle.getString("valueList.62"));
		TreeMapCountry.put("220", objValueListCountriesBundle.getString("valueList.63"));
		TreeMapCountry.put("995", objValueListCountriesBundle.getString("valueList.64"));
		TreeMapCountry.put("49", objValueListCountriesBundle.getString("valueList.65"));
		TreeMapCountry.put("233", objValueListCountriesBundle.getString("valueList.66"));
		TreeMapCountry.put("30", objValueListCountriesBundle.getString("valueList.67"));
		TreeMapCountry.put("1473", objValueListCountriesBundle.getString("valueList.68"));
		TreeMapCountry.put("502", objValueListCountriesBundle.getString("valueList.69"));
		TreeMapCountry.put("224", objValueListCountriesBundle.getString("valueList.70"));
		TreeMapCountry.put("245", objValueListCountriesBundle.getString("valueList.71"));
		TreeMapCountry.put("592", objValueListCountriesBundle.getString("valueList.72"));
		TreeMapCountry.put("509", objValueListCountriesBundle.getString("valueList.73"));
		TreeMapCountry.put("504", objValueListCountriesBundle.getString("valueList.74"));
		TreeMapCountry.put("36", objValueListCountriesBundle.getString("valueList.75"));
		TreeMapCountry.put("354", objValueListCountriesBundle.getString("valueList.76"));
		TreeMapCountry.put("91", objValueListCountriesBundle.getString("valueList.77"));
		TreeMapCountry.put("62", objValueListCountriesBundle.getString("valueList.78"));
		TreeMapCountry.put("98", objValueListCountriesBundle.getString("valueList.79"));
		TreeMapCountry.put("964", objValueListCountriesBundle.getString("valueList.80"));
		TreeMapCountry.put("353", objValueListCountriesBundle.getString("valueList.81"));
		TreeMapCountry.put("972", objValueListCountriesBundle.getString("valueList.82"));
		TreeMapCountry.put("5", objValueListCountriesBundle.getString("valueList.83"));
		TreeMapCountry.put("1876", objValueListCountriesBundle.getString("valueList.84"));
		TreeMapCountry.put("81", objValueListCountriesBundle.getString("valueList.85"));
		TreeMapCountry.put("962", objValueListCountriesBundle.getString("valueList.86"));
		TreeMapCountry.put("7", objValueListCountriesBundle.getString("valueList.87"));
		TreeMapCountry.put("254", objValueListCountriesBundle.getString("valueList.88"));
		TreeMapCountry.put("686", objValueListCountriesBundle.getString("valueList.89"));
		TreeMapCountry.put("965", objValueListCountriesBundle.getString("valueList.90"));
		TreeMapCountry.put("996", objValueListCountriesBundle.getString("valueList.91"));
		TreeMapCountry.put("856", objValueListCountriesBundle.getString("valueList.92"));
		TreeMapCountry.put("371", objValueListCountriesBundle.getString("valueList.93"));
		TreeMapCountry.put("961", objValueListCountriesBundle.getString("valueList.94"));
		TreeMapCountry.put("266", objValueListCountriesBundle.getString("valueList.95"));
		TreeMapCountry.put("231", objValueListCountriesBundle.getString("valueList.96"));
		TreeMapCountry.put("218", objValueListCountriesBundle.getString("valueList.97"));
		TreeMapCountry.put("423", objValueListCountriesBundle.getString("valueList.98"));
		TreeMapCountry.put("370", objValueListCountriesBundle.getString("valueList.99"));
		TreeMapCountry.put("352", objValueListCountriesBundle.getString("valueList.100"));
		TreeMapCountry.put("389", objValueListCountriesBundle.getString("valueList.101"));
		TreeMapCountry.put("261", objValueListCountriesBundle.getString("valueList.102"));
		TreeMapCountry.put("265", objValueListCountriesBundle.getString("valueList.103"));
		TreeMapCountry.put("60", objValueListCountriesBundle.getString("valueList.104"));
		TreeMapCountry.put("960", objValueListCountriesBundle.getString("valueList.105"));
		TreeMapCountry.put("223", objValueListCountriesBundle.getString("valueList.106"));
		TreeMapCountry.put("356", objValueListCountriesBundle.getString("valueList.107"));
		TreeMapCountry.put("692", objValueListCountriesBundle.getString("valueList.108"));
		TreeMapCountry.put("222", objValueListCountriesBundle.getString("valueList.109"));
		TreeMapCountry.put("230", objValueListCountriesBundle.getString("valueList.110"));
		TreeMapCountry.put("52", objValueListCountriesBundle.getString("valueList.111"));
		TreeMapCountry.put("691", objValueListCountriesBundle.getString("valueList.112"));
		TreeMapCountry.put("377", objValueListCountriesBundle.getString("valueList.113"));
		TreeMapCountry.put("976", objValueListCountriesBundle.getString("valueList.114"));
		TreeMapCountry.put("382", objValueListCountriesBundle.getString("valueList.115"));
		TreeMapCountry.put("212", objValueListCountriesBundle.getString("valueList.116"));
		TreeMapCountry.put("258", objValueListCountriesBundle.getString("valueList.117"));
		TreeMapCountry.put("95", objValueListCountriesBundle.getString("valueList.118"));
		TreeMapCountry.put("264", objValueListCountriesBundle.getString("valueList.119"));
		TreeMapCountry.put("674", objValueListCountriesBundle.getString("valueList.120"));
		TreeMapCountry.put("977", objValueListCountriesBundle.getString("valueList.121"));
		TreeMapCountry.put("31", objValueListCountriesBundle.getString("valueList.122"));
		TreeMapCountry.put("64", objValueListCountriesBundle.getString("valueList.123"));
		TreeMapCountry.put("505", objValueListCountriesBundle.getString("valueList.124"));
		TreeMapCountry.put("227", objValueListCountriesBundle.getString("valueList.125"));
		TreeMapCountry.put("234", objValueListCountriesBundle.getString("valueList.126"));
		TreeMapCountry.put("47", objValueListCountriesBundle.getString("valueList.127"));
		TreeMapCountry.put("968", objValueListCountriesBundle.getString("valueList.128"));
		TreeMapCountry.put("92", objValueListCountriesBundle.getString("valueList.129"));
		TreeMapCountry.put("680", objValueListCountriesBundle.getString("valueList.130"));
		TreeMapCountry.put("507", objValueListCountriesBundle.getString("valueList.131"));
		TreeMapCountry.put("675", objValueListCountriesBundle.getString("valueList.132"));
		TreeMapCountry.put("595", objValueListCountriesBundle.getString("valueList.133"));
		TreeMapCountry.put("51", objValueListCountriesBundle.getString("valueList.134"));
		TreeMapCountry.put("63", objValueListCountriesBundle.getString("valueList.135"));
		TreeMapCountry.put("48", objValueListCountriesBundle.getString("valueList.136"));
		TreeMapCountry.put("14", objValueListCountriesBundle.getString("valueList.137"));
		TreeMapCountry.put("974", objValueListCountriesBundle.getString("valueList.138"));
		TreeMapCountry.put("82", objValueListCountriesBundle.getString("valueList.139"));
		TreeMapCountry.put("373", objValueListCountriesBundle.getString("valueList.140"));
		TreeMapCountry.put("40", objValueListCountriesBundle.getString("valueList.141"));
		TreeMapCountry.put("8", objValueListCountriesBundle.getString("valueList.142"));
		TreeMapCountry.put("250", objValueListCountriesBundle.getString("valueList.143"));
		TreeMapCountry.put("1869", objValueListCountriesBundle.getString("valueList.144"));
		TreeMapCountry.put("1758", objValueListCountriesBundle.getString("valueList.145"));
		TreeMapCountry.put("1784", objValueListCountriesBundle.getString("valueList.146"));
		TreeMapCountry.put("685", objValueListCountriesBundle.getString("valueList.147"));
		TreeMapCountry.put("378", objValueListCountriesBundle.getString("valueList.148"));
		TreeMapCountry.put("239", objValueListCountriesBundle.getString("valueList.159"));
		TreeMapCountry.put("966", objValueListCountriesBundle.getString("valueList.150"));
		TreeMapCountry.put("221", objValueListCountriesBundle.getString("valueList.151"));
		TreeMapCountry.put("381", objValueListCountriesBundle.getString("valueList.152"));
		TreeMapCountry.put("248", objValueListCountriesBundle.getString("valueList.153"));
		TreeMapCountry.put("232", objValueListCountriesBundle.getString("valueList.154"));
		TreeMapCountry.put("65", objValueListCountriesBundle.getString("valueList.155"));
		TreeMapCountry.put("421", objValueListCountriesBundle.getString("valueList.156"));
		TreeMapCountry.put("386", objValueListCountriesBundle.getString("valueList.157"));
		TreeMapCountry.put("677", objValueListCountriesBundle.getString("valueList.158"));
		TreeMapCountry.put("252", objValueListCountriesBundle.getString("valueList.159"));
		TreeMapCountry.put("28", objValueListCountriesBundle.getString("valueList.160"));
		TreeMapCountry.put("211", objValueListCountriesBundle.getString("valueList.161"));
		TreeMapCountry.put("35", objValueListCountriesBundle.getString("valueList.162"));
		TreeMapCountry.put("94", objValueListCountriesBundle.getString("valueList.163"));
		TreeMapCountry.put("249", objValueListCountriesBundle.getString("valueList.164"));
		TreeMapCountry.put("597", objValueListCountriesBundle.getString("valueList.165"));
		TreeMapCountry.put("268", objValueListCountriesBundle.getString("valueList.166"));
		TreeMapCountry.put("46", objValueListCountriesBundle.getString("valueList.167"));
		TreeMapCountry.put("41", objValueListCountriesBundle.getString("valueList.168"));
		TreeMapCountry.put("963", objValueListCountriesBundle.getString("valueList.169"));
		TreeMapCountry.put("992", objValueListCountriesBundle.getString("valueList.170"));
		TreeMapCountry.put("66", objValueListCountriesBundle.getString("valueList.171"));
		TreeMapCountry.put("670", objValueListCountriesBundle.getString("valueList.172"));
		TreeMapCountry.put("228", objValueListCountriesBundle.getString("valueList.173"));
		TreeMapCountry.put("676", objValueListCountriesBundle.getString("valueList.174"));
		TreeMapCountry.put("1868", objValueListCountriesBundle.getString("valueList.175"));
		TreeMapCountry.put("216", objValueListCountriesBundle.getString("valueList.176"));
		TreeMapCountry.put("90", objValueListCountriesBundle.getString("valueList.177"));
		TreeMapCountry.put("993", objValueListCountriesBundle.getString("valueList.178"));
		TreeMapCountry.put("668", objValueListCountriesBundle.getString("valueList.179"));
		TreeMapCountry.put("256", objValueListCountriesBundle.getString("valueList.180"));
		TreeMapCountry.put("380", objValueListCountriesBundle.getString("valueList.181"));
		TreeMapCountry.put("971", objValueListCountriesBundle.getString("valueList.182"));
		TreeMapCountry.put("44", objValueListCountriesBundle.getString("valueList.183"));
		TreeMapCountry.put("255", objValueListCountriesBundle.getString("valueList.184"));
		TreeMapCountry.put("2", objValueListCountriesBundle.getString("valueList.185"));
		TreeMapCountry.put("598", objValueListCountriesBundle.getString("valueList.186"));
		TreeMapCountry.put("998", objValueListCountriesBundle.getString("valueList.187"));
		TreeMapCountry.put("678", objValueListCountriesBundle.getString("valueList.188"));
		TreeMapCountry.put("58", objValueListCountriesBundle.getString("valueList.189"));
		TreeMapCountry.put("84", objValueListCountriesBundle.getString("valueList.190"));
		TreeMapCountry.put("967", objValueListCountriesBundle.getString("valueList.191"));
		TreeMapCountry.put("260", objValueListCountriesBundle.getString("valueList.192"));
		TreeMapCountry.put("963", objValueListCountriesBundle.getString("valueList.193"));
		TreeMapCountry.put("9999", objValueListCountriesBundle.getString("valueList.194"));
		camelizeTreeMap(TreeMapCountry);
		mapOfValueList.put("countries",entriesSortedByValues(TreeMapCountry));
	}
	
	protected void initStates() {
		TreeMap<String, String> TreeMapStates =new TreeMap<String, String>();
		//Map<String, String> TreeMapStates = new HashMap<String, String>();
		TreeMapStates.put("02", objValueListStatesBundle.getString("valueList.andhraPradesh"));
		TreeMapStates.put("03", objValueListStatesBundle.getString("valueList.arunachalPradesh"));
		TreeMapStates.put("04", objValueListStatesBundle.getString("valueList.assam"));
		TreeMapStates.put("05", objValueListStatesBundle.getString("valueList.bihar"));
		TreeMapStates.put("10", objValueListStatesBundle.getString("valueList.goa"));
		TreeMapStates.put("11", objValueListStatesBundle.getString("valueList.gujarat"));
		TreeMapStates.put("12", objValueListStatesBundle.getString("valueList.haryana"));	
		TreeMapStates.put("13", objValueListStatesBundle.getString("valueList.himachalPradesh"));
		TreeMapStates.put("14", objValueListStatesBundle.getString("valueList.jammuAndKashmir"));
		TreeMapStates.put("15", objValueListStatesBundle.getString("valueList.karnataka"));
		TreeMapStates.put("16", objValueListStatesBundle.getString("valueList.kerala"));
		TreeMapStates.put("18", objValueListStatesBundle.getString("valueList.madhyaPradesh"));
		TreeMapStates.put("19", objValueListStatesBundle.getString("valueList.maharashtra"));
		TreeMapStates.put("20", objValueListStatesBundle.getString("valueList.manipur"));
		TreeMapStates.put("21", objValueListStatesBundle.getString("valueList.meghalaya"));
		TreeMapStates.put("22", objValueListStatesBundle.getString("valueList.mizoram"));
		TreeMapStates.put("23", objValueListStatesBundle.getString("valueList.nagaland"));
		TreeMapStates.put("24", objValueListStatesBundle.getString("valueList.orissa"));
		TreeMapStates.put("26", objValueListStatesBundle.getString("valueList.punjab"));
		TreeMapStates.put("27", objValueListStatesBundle.getString("valueList.rajasthan"));
		TreeMapStates.put("28", objValueListStatesBundle.getString("valueList.sikkim"));
		TreeMapStates.put("29", objValueListStatesBundle.getString("valueList.tamilNadu"));
		TreeMapStates.put("30", objValueListStatesBundle.getString("valueList.tripura"));
		TreeMapStates.put("31", objValueListStatesBundle.getString("valueList.uttarPradesh"));
		TreeMapStates.put("32", objValueListStatesBundle.getString("valueList.westBengal"));
		TreeMapStates.put("33", objValueListStatesBundle.getString("valueList.chhattisgarh"));
		TreeMapStates.put("34", objValueListStatesBundle.getString("valueList.uttaranchal"));		
		TreeMapStates.put("35", objValueListStatesBundle.getString("valueList.jharkhand"));
		
		TreeMapStates.put("01", objValueListStatesBundle.getString("valueList.andamanAndNicobarIslands"));
		TreeMapStates.put("06", objValueListStatesBundle.getString("valueList.chandigarh"));
		TreeMapStates.put("07", objValueListStatesBundle.getString("valueList.dadarAndNagarHaveli"));
		TreeMapStates.put("08", objValueListStatesBundle.getString("valueList.damanAndDiu"));
		TreeMapStates.put("09", objValueListStatesBundle.getString("valueList.delhi"));
		TreeMapStates.put("17", objValueListStatesBundle.getString("valueList.lakshadeep"));
		TreeMapStates.put("25", objValueListStatesBundle.getString("valueList.pondicherry"));
		
		camelizeTreeMap(TreeMapStates);
		//SortedMap<String, String> m = Collections.synchronizedSortedMap(TreeMapStates);
		mapOfValueList.put("states",entriesSortedByValues(TreeMapStates));
	}
	/**
	 * This method fetches the information valueList_states.properties file	
	 * 
	 * @return TreeMap  object
	 */

	public SortedSet<Map.Entry<String,String>> getStates() {
		return mapOfValueList.get("states");
	}
		
	public SortedSet<Map.Entry<String,String>>  getCountry()
	{
		return mapOfValueList.get("countries");
		//SortedMap<String, String> m = Collections.synchronizedSortedMap(TreeMapStates);
		//return TreeMapCountry;
	}



	public TreeMap<String, String> getDeduction()
	{
		TreeMap<String, String> TreeMapDeductionDropdown =new TreeMap<String, String>();
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_1"), objValueListDeductionBundle.getString("80c_1"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_2"), objValueListDeductionBundle.getString("80c_2"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_3"), objValueListDeductionBundle.getString("80c_3"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_4"), objValueListDeductionBundle.getString("80c_4"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_5"), objValueListDeductionBundle.getString("80c_5"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_6"), objValueListDeductionBundle.getString("80c_6"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_7"), objValueListDeductionBundle.getString("80c_7"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_8"), objValueListDeductionBundle.getString("80c_8"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80c_9"), objValueListDeductionBundle.getString("80c_9"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80d_1"), objValueListDeductionBundle.getString("80d_1"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80d_2"), objValueListDeductionBundle.getString("80d_2"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80d_3"), objValueListDeductionBundle.getString("80d_3"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80d_4"), objValueListDeductionBundle.getString("80d_4"));
		TreeMapDeductionDropdown.put(objValueListDeductionBundle.getString("80d_5"), objValueListDeductionBundle.getString("80d_5"));
		return TreeMapDeductionDropdown;
	}		 

	public TreeMap<String, String> getDeduction6a()
	{
		TreeMap<String, String> TreeMapDeductionaDropdown =new TreeMap<String, String>();
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80c"), objValueListDeduction6aBundle.getString("80c"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80ccc"), objValueListDeduction6aBundle.getString("80ccc"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80ccd"), objValueListDeduction6aBundle.getString("80ccd"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80ccf"), objValueListDeduction6aBundle.getString("80ccf"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80ccg"), objValueListDeduction6aBundle.getString("80ccg"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80d"), objValueListDeduction6aBundle.getString("80d"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80dd"), objValueListDeduction6aBundle.getString("80dd"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80ddb"), objValueListDeduction6aBundle.getString("80ddb"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80e"), objValueListDeduction6aBundle.getString("80e"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80g"), objValueListDeduction6aBundle.getString("80g"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80gg"), objValueListDeduction6aBundle.getString("80gg"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80u"), objValueListDeduction6aBundle.getString("80u"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80rrb"), objValueListDeduction6aBundle.getString("80rrb"));
		TreeMapDeductionaDropdown.put(objValueListDeduction6aBundle.getString("80tta"), objValueListDeduction6aBundle.getString("80tta"));

		return TreeMapDeductionaDropdown;
	}		 

	/**
	 * This method fetches the information valueList_boolean.properties file	
	 * 
	 * @return TreeMap  object
	 */

	public TreeMap<String, String> getBoolean()
	{
		TreeMap<String, String> TreeMapBoolean =new TreeMap<String, String>();
		TreeMapBoolean.put("1", objValueListBooleanBundle.getString("valueList.yes"));
		TreeMapBoolean.put("2", objValueListBooleanBundle.getString("valueList.no"));

		return TreeMapBoolean;
	}


	/**
	 * This method fetches the information valueList_residentialStatus.properties file	
	 * 
	 * @return TreeMap  object
	 */

	public TreeMap<String, String> getResidentialStatus()
	{
		TreeMap<String, String> TreeMapResStatus =new TreeMap<String, String>();
		TreeMapResStatus.put("1", objValueListResStatusBundle.getString("valueList.residentIndian"));
		TreeMapResStatus.put("2", objValueListResStatusBundle.getString("valueList.nonResidentIndian"));
		TreeMapResStatus.put("3", objValueListResStatusBundle.getString("valueList.notOrdinaryResident"));

		return TreeMapResStatus;
	}		 


	/**
	 * This method fetches the information valueList_quarter.properties file	
	 * 
	 * @return TreeMap  object
	 */

	public TreeMap<String, String> getQuarter()
	{
		TreeMap<String, String> TreeMapQuarter =new TreeMap<String, String>();
		TreeMapQuarter.put("1", objValueListQuarterBundle.getString("valueList.qtr1"));
		TreeMapQuarter.put("2", objValueListQuarterBundle.getString("valueList.qtr2"));
		TreeMapQuarter.put("3", objValueListQuarterBundle.getString("valueList.qtr3"));
		TreeMapQuarter.put("4", objValueListQuarterBundle.getString("valueList.qtr4"));

		return TreeMapQuarter;
	}		 

	public TreeMap<String, String> getInflationIndex(){
		TreeMap<String, String> TreeMapYearInflation=new TreeMap<String, String>();
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1981.cii"), objValueListYearInflationBundle.getString("valueList.1981"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1982.cii"), objValueListYearInflationBundle.getString("valueList.1982"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1983.cii"), objValueListYearInflationBundle.getString("valueList.1983"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1984.cii"), objValueListYearInflationBundle.getString("valueList.1984"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1985.cii"), objValueListYearInflationBundle.getString("valueList.1985"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1986.cii"), objValueListYearInflationBundle.getString("valueList.1986"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1987.cii"), objValueListYearInflationBundle.getString("valueList.1987"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1988.cii"), objValueListYearInflationBundle.getString("valueList.1988"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1989.cii"), objValueListYearInflationBundle.getString("valueList.1989"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1990.cii"), objValueListYearInflationBundle.getString("valueList.1990"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1991.cii"), objValueListYearInflationBundle.getString("valueList.1991"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1992.cii"), objValueListYearInflationBundle.getString("valueList.1992"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1993.cii"), objValueListYearInflationBundle.getString("valueList.1993"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1994.cii"), objValueListYearInflationBundle.getString("valueList.1994"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1995.cii"), objValueListYearInflationBundle.getString("valueList.1995"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1996.cii"), objValueListYearInflationBundle.getString("valueList.1996"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1997.cii"), objValueListYearInflationBundle.getString("valueList.1997"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1998.cii"), objValueListYearInflationBundle.getString("valueList.1998"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.1999.cii"), objValueListYearInflationBundle.getString("valueList.1999"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2000.cii"), objValueListYearInflationBundle.getString("valueList.2000"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2001.cii"), objValueListYearInflationBundle.getString("valueList.2001"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2002.cii"), objValueListYearInflationBundle.getString("valueList.2002"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2003.cii"), objValueListYearInflationBundle.getString("valueList.2003"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2004.cii"), objValueListYearInflationBundle.getString("valueList.2004"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2005.cii"), objValueListYearInflationBundle.getString("valueList.2005"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2006.cii"), objValueListYearInflationBundle.getString("valueList.2006"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2007.cii"), objValueListYearInflationBundle.getString("valueList.2007"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2008.cii"), objValueListYearInflationBundle.getString("valueList.2008"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2009.cii"), objValueListYearInflationBundle.getString("valueList.2009"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2010.cii"), objValueListYearInflationBundle.getString("valueList.2010"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2011.cii"), objValueListYearInflationBundle.getString("valueList.2011"));
		TreeMapYearInflation.put(objValueListYearInflationBundle.getString("valueList.2012.cii"), objValueListYearInflationBundle.getString("valueList.2012"));


		return TreeMapYearInflation;
	}

	/**
	 * This method fetches the information valueList_schedule80C_dropdown.properties file	
	 * 
	 * @return TreeMap  object
	 */
	public TreeMap<String, String> getSchedule80CDropdown()
	{
		TreeMap<String, String> TreeMapSchedule80CDropdown =new TreeMap<String, String>();
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.lic"), objValueListSchedule80CDropdownBundle.getString("valueList.lic"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.interest"), objValueListSchedule80CDropdownBundle.getString("valueList.interest"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.nsc"), objValueListSchedule80CDropdownBundle.getString("valueList.nsc"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.housing"), objValueListSchedule80CDropdownBundle.getString("valueList.housing"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.notification"), objValueListSchedule80CDropdownBundle.getString("valueList.notification"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.tuition"), objValueListSchedule80CDropdownBundle.getString("valueList.tuition"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.ppf"), objValueListSchedule80CDropdownBundle.getString("valueList.ppf"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.pf"), objValueListSchedule80CDropdownBundle.getString("valueList.pf"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.gpf"), objValueListSchedule80CDropdownBundle.getString("valueList.gpf"));
		TreeMapSchedule80CDropdown.put(objValueListSchedule80CDropdownBundle.getString("valueList.others"), objValueListSchedule80CDropdownBundle.getString("valueList.others"));

		return TreeMapSchedule80CDropdown;
	}		 
	@Override
	public TreeMap<String, String> getAssessmentYear() {
		// TODO Auto-generated method stub
		TreeMap<String, String> TreeMapAssessmentYear =new TreeMap<String, String>();
		TreeMapAssessmentYear.put(objValueListAssessmentYearBundle.getString("valueList.2013-2012"), objValueListAssessmentYearBundle.getString("valueList.2013-2012"));
		TreeMapAssessmentYear.put(objValueListAssessmentYearBundle.getString("valueList.2012-2011"), objValueListAssessmentYearBundle.getString("valueList.2012-2011"));
		TreeMapAssessmentYear.put(objValueListAssessmentYearBundle.getString("valueList.2011-2010"), objValueListAssessmentYearBundle.getString("valueList.2011-2010"));
		TreeMapAssessmentYear.put(objValueListAssessmentYearBundle.getString("valueList.2010-2009"), objValueListAssessmentYearBundle.getString("valueList.2010-2009"));
		TreeMapAssessmentYear.put(objValueListAssessmentYearBundle.getString("valueList.2009-2008"), objValueListAssessmentYearBundle.getString("valueList.2009-2008"));
		TreeMapAssessmentYear.put(objValueListAssessmentYearBundle.getString("valueList.2008-2007"), objValueListAssessmentYearBundle.getString("valueList.2008-2007"));		
		TreeMapAssessmentYear.put(objValueListAssessmentYearBundle.getString("valueList.2007-2006"), objValueListAssessmentYearBundle.getString("valueList.2007-2006"));
		TreeMapAssessmentYear.put(objValueListAssessmentYearBundle.getString("valueList.2006-2005"), objValueListAssessmentYearBundle.getString("valueList.2006-2005"));

		return TreeMapAssessmentYear;
	}
	public TreeMap<String, String> getNatureOfPayment() {
		// TODO Auto-generated method stub
		TreeMap<String, String> TreeMapNaturePayment =new TreeMap<String, String>();
		TreeMapNaturePayment.put("1", objValueListNaturePayment.getString("206CA"));
		TreeMapNaturePayment.put("2", objValueListNaturePayment.getString("206CB"));
		TreeMapNaturePayment.put("3", objValueListNaturePayment.getString("206CC"));
		TreeMapNaturePayment.put("4", objValueListNaturePayment.getString("206CD"));
		TreeMapNaturePayment.put("5", objValueListNaturePayment.getString("206CE"));
		TreeMapNaturePayment.put("6", objValueListNaturePayment.getString("206CF"));		
		TreeMapNaturePayment.put("7", objValueListNaturePayment.getString("206CG"));
		TreeMapNaturePayment.put("8", objValueListNaturePayment.getString("206CH"));
		TreeMapNaturePayment.put("9", objValueListNaturePayment.getString("206CI"));


		return TreeMapNaturePayment;
	}
	@Override
	public TreeMap<String, String> getNameOfHead() {
		// TODO Auto-generated method stub
		TreeMap<String, String> TreeMapNameOfHead =new TreeMap<String, String>();
		TreeMapNameOfHead.put("1", objValueListNameOfHeadBundle.getString("valueList.HousePropertyLoss"));
		TreeMapNameOfHead.put("2", objValueListNameOfHeadBundle.getString("valueList.LongTermCapitalLoss"));
		TreeMapNameOfHead.put("3", objValueListNameOfHeadBundle.getString("valueList.ShortTermCapitalLoss"));		
		TreeMapNameOfHead.put("4", objValueListNameOfHeadBundle.getString("valueList.UnabsorbedCapitalExpenditureonFamilyPlanning"));
		TreeMapNameOfHead.put("5", objValueListNameOfHeadBundle.getString("valueList.UnabsorbedCapitalExpenditureonScientificResearch"));
		TreeMapNameOfHead.put("6", objValueListNameOfHeadBundle.getString("valueList.UnabsorbedDepreciation"));
		TreeMapNameOfHead.put("7",objValueListNameOfHeadBundle.getString("valueList.OwningandMaintainingRaceHorses"));

		return TreeMapNameOfHead;
	}
	/**
	 * This method fetches the information valueList_numbers.properties file	
	 * 
	 * @return TreeMap  object
	 */
	public TreeMap<String, String> getNumbersDropdown()
	{
		TreeMap<String, String> TreeMapNumbersDropdown =new TreeMap<String, String>();
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.one"), objValueListNumbers.getString("valueList.one"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.two"), objValueListNumbers.getString("valueList.two"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.three"), objValueListNumbers.getString("valueList.three"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.four"), objValueListNumbers.getString("valueList.four"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.five"), objValueListNumbers.getString("valueList.five"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.six"), objValueListNumbers.getString("valueList.six"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.seven"), objValueListNumbers.getString("valueList.seven"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.eight"), objValueListNumbers.getString("valueList.eight"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.nine"), objValueListNumbers.getString("valueList.nine"));
		TreeMapNumbersDropdown.put(objValueListNumbers.getString("valueList.ten"), objValueListNumbers.getString("valueList.ten"));

		return TreeMapNumbersDropdown;
	}

	public TreeMap<String, String> getDeducterdYear() {
		// TODO Auto-generated method stub
		TreeMap<String, String> TreeDeducterdYear =new TreeMap<String, String>();
		TreeDeducterdYear.put("1", objValueListDeductedYear.getString("valueList.2010"));
		TreeDeducterdYear.put("2", objValueListDeductedYear.getString("valueList.2011"));
		TreeDeducterdYear.put("3", objValueListDeductedYear.getString("valueList.2012"));
		TreeDeducterdYear.put("4", objValueListDeductedYear.getString("valueList.2013"));
		TreeDeducterdYear.put("5", objValueListDeductedYear.getString("valueList.2014"));
		return  TreeDeducterdYear;
	}
	public TreeMap<String, String> getReturnFile() {
		// TODO Auto-generated method stub
		TreeMap<String, String> TreeReturnType =new TreeMap<String, String>();
		TreeReturnType.put("1", objvalueListReturnFile.getString("valueList.before.duedate"));
		TreeReturnType.put("2", objvalueListReturnFile.getString("valueList.after.duedate"));
		TreeReturnType.put("3", objvalueListReturnFile.getString("valueList.section.142"));
		TreeReturnType.put("4", objvalueListReturnFile.getString("valueList.section.148"));
		TreeReturnType.put("5", objvalueListReturnFile.getString("valueList.section.153"));
		TreeReturnType.put("6", objvalueListReturnFile.getString("valueList.section.153C"));
		TreeReturnType.put("7", objvalueListReturnFile.getString("valueList.section.139"));
		TreeReturnType.put("8", objvalueListReturnFile.getString("valueList.section.139(9)"));
		return  TreeReturnType;
	}
	
	public TreeMap<String, String> getRelationship() {
		// TODO Auto-generated method stub
		TreeMap<String, String> TreeReturnType =new TreeMap<String, String>();
		TreeReturnType.put("1", objvalueListRelationship.getString("valueList.Spouse"));
		TreeReturnType.put("2", objvalueListRelationship.getString("valueList.Minor"));
		TreeReturnType.put("3", objvalueListRelationship.getString("valueList.Son'sWife"));
		TreeReturnType.put("4", objvalueListRelationship.getString("valueList.MemberofHUF"));
		TreeReturnType.put("5", objvalueListRelationship.getString("valueList.Other"));
		
		
		return  TreeReturnType;
	}
	
	public TreeMap<String, String> getDtaaCountries(){
		TreeMap<String, String> TreeDtaaCountries = new TreeMap<String, String>();
		TreeDtaaCountries.put("1", objValueListDtaaCountries.getString("valueList.1"));
		TreeDtaaCountries.put("2", objValueListDtaaCountries.getString("valueList.2"));
		TreeDtaaCountries.put("3", objValueListDtaaCountries.getString("valueList.3"));

		TreeDtaaCountries.put("4", objValueListDtaaCountries.getString("valueList.4"));
		TreeDtaaCountries.put("5", objValueListDtaaCountries.getString("valueList.5"));
		TreeDtaaCountries.put("6", objValueListDtaaCountries.getString("valueList.6"));
		TreeDtaaCountries.put("7", objValueListDtaaCountries.getString("valueList.7"));
		TreeDtaaCountries.put("8", objValueListDtaaCountries.getString("valueList.8"));
		TreeDtaaCountries.put("9", objValueListDtaaCountries.getString("valueList.9"));
		TreeDtaaCountries.put("10", objValueListDtaaCountries.getString("valueList.10"));
		TreeDtaaCountries.put("11", objValueListDtaaCountries.getString("valueList.11"));
		TreeDtaaCountries.put("12", objValueListDtaaCountries.getString("valueList.12"));
		TreeDtaaCountries.put("13", objValueListDtaaCountries.getString("valueList.13"));
		TreeDtaaCountries.put("14", objValueListDtaaCountries.getString("valueList.14"));
		TreeDtaaCountries.put("15", objValueListDtaaCountries.getString("valueList.15"));
		TreeDtaaCountries.put("16", objValueListDtaaCountries.getString("valueList.16"));
		TreeDtaaCountries.put("17", objValueListDtaaCountries.getString("valueList.17"));
		TreeDtaaCountries.put("18", objValueListDtaaCountries.getString("valueList.18"));
		TreeDtaaCountries.put("19", objValueListDtaaCountries.getString("valueList.19"));
		TreeDtaaCountries.put("20", objValueListDtaaCountries.getString("valueList.20"));
		TreeDtaaCountries.put("21", objValueListDtaaCountries.getString("valueList.21"));
		TreeDtaaCountries.put("22", objValueListDtaaCountries.getString("valueList.22"));
		TreeDtaaCountries.put("23", objValueListDtaaCountries.getString("valueList.23"));
		TreeDtaaCountries.put("24", objValueListDtaaCountries.getString("valueList.24"));
		TreeDtaaCountries.put("25", objValueListDtaaCountries.getString("valueList.25"));
		TreeDtaaCountries.put("26", objValueListDtaaCountries.getString("valueList.26"));
		TreeDtaaCountries.put("27", objValueListDtaaCountries.getString("valueList.27"));
		TreeDtaaCountries.put("28", objValueListDtaaCountries.getString("valueList.28"));
		TreeDtaaCountries.put("29", objValueListDtaaCountries.getString("valueList.29"));
		TreeDtaaCountries.put("30", objValueListDtaaCountries.getString("valueList.30"));
		TreeDtaaCountries.put("31", objValueListDtaaCountries.getString("valueList.31"));
		TreeDtaaCountries.put("32", objValueListDtaaCountries.getString("valueList.32"));
		TreeDtaaCountries.put("33", objValueListDtaaCountries.getString("valueList.33"));
		TreeDtaaCountries.put("34", objValueListDtaaCountries.getString("valueList.34"));
		TreeDtaaCountries.put("35", objValueListDtaaCountries.getString("valueList.35"));
		TreeDtaaCountries.put("36", objValueListDtaaCountries.getString("valueList.36"));
		TreeDtaaCountries.put("37", objValueListDtaaCountries.getString("valueList.37"));
		TreeDtaaCountries.put("38", objValueListDtaaCountries.getString("valueList.38"));
		TreeDtaaCountries.put("39", objValueListDtaaCountries.getString("valueList.39"));
		TreeDtaaCountries.put("40", objValueListDtaaCountries.getString("valueList.40"));
		TreeDtaaCountries.put("41", objValueListDtaaCountries.getString("valueList.41"));
		TreeDtaaCountries.put("42", objValueListDtaaCountries.getString("valueList.42"));
		TreeDtaaCountries.put("43", objValueListDtaaCountries.getString("valueList.43"));
		TreeDtaaCountries.put("44", objValueListDtaaCountries.getString("valueList.44"));
		TreeDtaaCountries.put("45", objValueListDtaaCountries.getString("valueList.45"));
		TreeDtaaCountries.put("46", objValueListDtaaCountries.getString("valueList.46"));
		TreeDtaaCountries.put("47", objValueListDtaaCountries.getString("valueList.47"));
		TreeDtaaCountries.put("48", objValueListDtaaCountries.getString("valueList.48"));
		TreeDtaaCountries.put("49", objValueListDtaaCountries.getString("valueList.49"));
		TreeDtaaCountries.put("50", objValueListDtaaCountries.getString("valueList.50"));
		TreeDtaaCountries.put("51", objValueListDtaaCountries.getString("valueList.51"));
		TreeDtaaCountries.put("52", objValueListDtaaCountries.getString("valueList.52"));
		TreeDtaaCountries.put("53", objValueListDtaaCountries.getString("valueList.53"));
		TreeDtaaCountries.put("54", objValueListDtaaCountries.getString("valueList.54"));
		TreeDtaaCountries.put("55", objValueListDtaaCountries.getString("valueList.55"));
		TreeDtaaCountries.put("56", objValueListDtaaCountries.getString("valueList.56"));
		TreeDtaaCountries.put("57", objValueListDtaaCountries.getString("valueList.57"));
		TreeDtaaCountries.put("58", objValueListDtaaCountries.getString("valueList.58"));
		TreeDtaaCountries.put("59", objValueListDtaaCountries.getString("valueList.59"));
		TreeDtaaCountries.put("60", objValueListDtaaCountries.getString("valueList.60"));
		TreeDtaaCountries.put("61", objValueListDtaaCountries.getString("valueList.61"));
		TreeDtaaCountries.put("62", objValueListDtaaCountries.getString("valueList.62"));
		TreeDtaaCountries.put("63", objValueListDtaaCountries.getString("valueList.63"));
		TreeDtaaCountries.put("64", objValueListDtaaCountries.getString("valueList.64"));
		TreeDtaaCountries.put("65", objValueListDtaaCountries.getString("valueList.65"));
		TreeDtaaCountries.put("66", objValueListDtaaCountries.getString("valueList.66"));
		TreeDtaaCountries.put("67", objValueListDtaaCountries.getString("valueList.67"));
		TreeDtaaCountries.put("68", objValueListDtaaCountries.getString("valueList.68"));
		TreeDtaaCountries.put("69", objValueListDtaaCountries.getString("valueList.69"));
		TreeDtaaCountries.put("70", objValueListDtaaCountries.getString("valueList.70"));
		TreeDtaaCountries.put("71", objValueListDtaaCountries.getString("valueList.71"));
		TreeDtaaCountries.put("72", objValueListDtaaCountries.getString("valueList.72"));
		TreeDtaaCountries.put("73", objValueListDtaaCountries.getString("valueList.73"));
		TreeDtaaCountries.put("74", objValueListDtaaCountries.getString("valueList.74"));
		TreeDtaaCountries.put("75", objValueListDtaaCountries.getString("valueList.75"));
		TreeDtaaCountries.put("76", objValueListDtaaCountries.getString("valueList.76"));
		TreeDtaaCountries.put("77", objValueListDtaaCountries.getString("valueList.77"));
		TreeDtaaCountries.put("78", objValueListDtaaCountries.getString("valueList.78"));
		TreeDtaaCountries.put("79", objValueListDtaaCountries.getString("valueList.79"));
		TreeDtaaCountries.put("80", objValueListDtaaCountries.getString("valueList.80"));
		TreeDtaaCountries.put("81", objValueListDtaaCountries.getString("valueList.81"));
		TreeDtaaCountries.put("82", objValueListDtaaCountries.getString("valueList.82"));
		TreeDtaaCountries.put("83", objValueListDtaaCountries.getString("valueList.83"));
		return TreeDtaaCountries;

	}

	@Override
	public TreeMap<String, String> getUnionTerritory() {
		// TODO Auto-generated method stub
		TreeMap<String, String> UnionTerritory =new TreeMap<String, String>();
		/*
		UnionTerritory.put("01", objValueListStatesBundle.getString("valueList.andamanAndNicobarIslands"));
		UnionTerritory.put("06", objValueListStatesBundle.getString("valueList.chandigarh"));
		UnionTerritory.put("07", objValueListStatesBundle.getString("valueList.dadarAndNagarHaveli"));
		UnionTerritory.put("08", objValueListStatesBundle.getString("valueList.damanAndDiu"));
		UnionTerritory.put("09", objValueListStatesBundle.getString("valueList.delhi"));
		UnionTerritory.put("17", objValueListStatesBundle.getString("valueList.lakshadeep"));
		UnionTerritory.put("25", objValueListStatesBundle.getString("valueList.pondicherry"));
		*/
		return UnionTerritory;
	}

	@Override
	public TreeMap<String, String> getForeignState() {
		// TODO Auto-generated method stub
		TreeMap<String, String> TreeMapForiegnStates =new TreeMap<String, String>();
		TreeMapForiegnStates.put("99", objValueListStatesBundle.getString("valueList.foreign"));
		return TreeMapForiegnStates;
	}
	
	@Override
	public List<String> getStateKeySet(TreeMap<String,String> objTreeMap) {
		// TODO Auto-generated method stub
		List<String> keyList = new ArrayList<String>();	
		for (String aKey: objTreeMap.keySet() ) {
			keyList.add(aKey);			
		}
		Collections.sort(keyList);
		for(String key:keyList){
			if(log.isInfoEnabled()){
				log.info("this is key of new"+key);
			}
		}
		return keyList;
	}


	public ResourceBundle getObjValueListDeduction6aBundle() {
		return objValueListDeduction6aBundle;
	}

	public void setObjValueListDeduction6aBundle(
			ResourceBundle objValueListDeduction6aBundle) {
		this.objValueListDeduction6aBundle = objValueListDeduction6aBundle;
	}
	
	protected void camelizeTreeMap(Map<String, String> in) {
		for (String key:in.keySet()) {
			in.put(key, WordUtils.capitalizeFully(in.get(key)));
		}
	}
	
	static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                return e1.getValue().compareTo(e2.getValue());
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}

}

















