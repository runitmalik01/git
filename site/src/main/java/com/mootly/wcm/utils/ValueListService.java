
/**
* ValueListService.java
*
* 07 Mar,2013
*
* 
*/
package com.mootly.wcm.utils;

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
	 * This method fetches the information valueList_states.properties file	
	 * 
	 * @return TreeMap  object
	 */
	TreeMap getStates();
	/**
	 * This method fetches the information valueList_boolean.properties file	
	 * 
	 * @return TreeMap  object
	 */
	TreeMap getBoolean();
	/**
	 * This method fetches the information valueList_residentialStatus.properties file	
	 * 
	 * @return TreeMap  object
	 */
	TreeMap getResidentialStatus();
	/**
	 * 
	 * This method fetches the information valueList_yearinflation.properties file	
	 * @return TreeMap  object
	 */ 
	
	TreeMap getInflationIndex();

	/**
	 * 
	 * This method fetches the information valueList_schedule80C_dropdown.properties file	
	 * @return TreeMap  object
	 */
	TreeMap getSchedule80CDropdown();

	
	TreeMap getAssessmentYear();
	/**
	 * 
	 * This method fetches the information valueList_yearinflation.properties file	
	 * @return TreeMap  object
	 */ 
	TreeMap getNatureOfPayment();
	/**
	 * 
	 * This method fetches the information natureofpayments.properties file	
	 * @return TreeMap  object
	 */ 
	TreeMap getNameOfHead();
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
	TreeMap getNumbersDropdown();
	
	TreeMap getDeducterdYear();

	
}
