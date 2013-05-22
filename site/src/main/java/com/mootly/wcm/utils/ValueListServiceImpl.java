
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

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

	private static final ValueListServiceImpl objValueListServiceImpl = new ValueListServiceImpl(); 
	private static final Logger log = LoggerFactory.getLogger(ValueListServiceImpl.class);
	/**
	 * Constructor of ValueListServiceImpl class
	 */
	protected ValueListServiceImpl() 
	{

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


	/**
	 * This method fetches the information valueList_states.properties file	
	 * 
	 * @return TreeMap  object
	 */

	public TreeMap<String, String> getStates()
	{
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
		//SortedMap<String, String> m = Collections.synchronizedSortedMap(TreeMapStates);
		return TreeMapStates;
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
	public TreeMap<String, String> getDtaaCountries(){
		TreeMap<String, String> TreeDtaaCountries = new TreeMap<String, String>();
		TreeDtaaCountries.put("1", objValueListDtaaCountries.getString("valueList.1"));
		TreeDtaaCountries.put("2", objValueListDtaaCountries.getString("valueList.2"));
		TreeDtaaCountries.put("3", objValueListDtaaCountries.getString("valueList.3"));
		return TreeDtaaCountries;

	}

	@Override
	public TreeMap<String, String> getUnionTerritory() {
		// TODO Auto-generated method stub
		TreeMap<String, String> UnionTerritory =new TreeMap<String, String>();
		UnionTerritory.put("01", objValueListStatesBundle.getString("valueList.andamanAndNicobarIslands"));
		UnionTerritory.put("06", objValueListStatesBundle.getString("valueList.chandigarh"));
		UnionTerritory.put("07", objValueListStatesBundle.getString("valueList.dadarAndNagarHaveli"));
		UnionTerritory.put("08", objValueListStatesBundle.getString("valueList.damanAndDiu"));
		UnionTerritory.put("09", objValueListStatesBundle.getString("valueList.delhi"));
		UnionTerritory.put("17", objValueListStatesBundle.getString("valueList.lakshadeep"));
		UnionTerritory.put("25", objValueListStatesBundle.getString("valueList.pondicherry"));
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

}

















