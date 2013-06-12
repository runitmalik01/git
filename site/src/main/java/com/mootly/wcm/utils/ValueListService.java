
/**
 * ValueListService.java
 *
 * 07 Mar,2013
 *
 * 
 */
package com.mootly.wcm.utils;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;



/**
 * This is a interface which helps in loading the properties 
 * files to populate combo boxes in jsp.
 * @author Komila
 *  
 * 
 */
public interface ValueListService {
	
	
	/**
	 * This method fetches the information valueList_boolean.properties file	
	 * 
	 * @return TreeMap  object
	 */
	SortedSet<Map.Entry<String,String>> getStates();
	/**
	 * This method fetches the information valueList_states.properties file	
	 * 
	 * @return TreeMap  object
	 */
	
	TreeMap<String,String> getUnionTerritory();
	/**
	 * This method fetches the information valueList_states.properties file	
	 * 
	 * @return TreeMap  object
	 */
	TreeMap<String,String> getForeignState();
	/**
	 * This method fetches the information valueList_boolean.properties file	
	 * 
	 * @return TreeMap  object
	 */
	SortedSet<Map.Entry<String,String>> getCountry();
	/**
	 * This method fetches the information valueList_countries.properties file	
	 * 
	 * @return TreeMap  object
	 */
	TreeMap<String,String> getBoolean();

	/**
	 * This method fetches the information valueList_residentialStatus.properties file	
	 * 
	 * @return TreeMap  object
	 */
	TreeMap<String,String> getResidentialStatus();
	/**
	 * 
	 * This method fetches the information valueList_yearinflation.properties file	
	 * @return TreeMap  object
	 */ 

	TreeMap<String,String> getInflationIndex();

	/**
	 * 
	 * This method fetches the information valueList_schedule80C_dropdown.properties file	
	 * @return TreeMap  object
	 */
	TreeMap<String,String> getSchedule80CDropdown();


	TreeMap<String,String> getAssessmentYear();
	/**
	 * 
	 * This method fetches the information valueList_yearinflation.properties file	
	 * @return TreeMap  object
	 */ 
	TreeMap<String,String> getNatureOfPayment();
	/**
	 * 
	 * This method fetches the information natureofpayments.properties file	
	 * @return TreeMap  object
	 */ 
	TreeMap<String,String> getNameOfHead();
	/**
	 * 
	 * This method fetches the information valueList_yearinflation.properties file	
	 * @return TreeMap  object
	 */ 

	/**
	 * 
	 * This method fetches the information valueList_numbers.properties file	
	 * @return TreeMap  object
	 */
	TreeMap<String,String> getNumbersDropdown();
	/**
	 * 
	 * This method fetches the information valueList_deduction.properties file	
	 * @return TreeMap  object
	 */
	TreeMap<String,String> getDeduction();
	/**
	 * 
	 * This method fetches the information valueList_deduction6a.properties file	
	 * @return TreeMap  object
	 */
	TreeMap<String,String> getDeduction6a();
	/**
	 * 
	 * This method fetches the information valueList_quarter.properties file	
	 * @return TreeMap  object
	 */
	TreeMap<String,String> getQuarter();
	

	TreeMap<String,String> getDeducterdYear();
	
	TreeMap<String,String> getReturnFile();


	TreeMap<String,String> getDtaaCountries();
	/**
	 * This Method is used to get the Key set of State in sorted order
	 * 
	 * @param TreeMap<String,String> this is TreeMap of State
	 * 
	 * @return List<String> list of State KeySet
	 * */
	List<String> getStateKeySet(TreeMap<String, String> treeMap);

}
