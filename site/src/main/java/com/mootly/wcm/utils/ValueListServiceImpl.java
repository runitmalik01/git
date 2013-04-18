
/**
* ValueListServiceImpl.java
*
* 07 Mar,2013
*
* 
*/

package com.mootly.wcm.utils;

import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * This is a singleton class which helps in loading the properties 
 * files to populate combo boxes in jsp.
 * @author Komila
 *  
 * 
 */

public final class ValueListServiceImpl implements ValueListService{
	private ResourceBundle objValueListStatesBundle = null;
	private ResourceBundle objValueListBooleanBundle = null;
	private ResourceBundle objValueListResStatusBundle = null;
	private ResourceBundle objValueListYearInflationBundle = null;
	private ResourceBundle objValueListSchedule80CDropdownBundle = null;
	private ResourceBundle objValueListAssessmentYearBundle = null;
	private ResourceBundle objValueListNameOfHeadBundle = null;
	private ResourceBundle objValueListNaturePayment = null;
	private ResourceBundle objValueListNumbers = null;
	private ResourceBundle objValueListDeductedYear = null;

	private static final ValueListServiceImpl objValueListServiceImpl = new ValueListServiceImpl(); 

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

	 public TreeMap getStates()
	{
		TreeMap TreeMapStates =new TreeMap();
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.andhraPradesh"), objValueListStatesBundle.getString("valueList.andhraPradesh"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.arunachalPradesh"), objValueListStatesBundle.getString("valueList.arunachalPradesh"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.assam"), objValueListStatesBundle.getString("valueList.assam"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.bihar"), objValueListStatesBundle.getString("valueList.bihar"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.chhattisgarh"), objValueListStatesBundle.getString("valueList.chhattisgarh"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.delhi"), objValueListStatesBundle.getString("valueList.delhi"));		
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.goa"), objValueListStatesBundle.getString("valueList.goa"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.gujarat"), objValueListStatesBundle.getString("valueList.gujarat"));
		TreeMapStates.put( objValueListStatesBundle.getString("valueList.haryana"), objValueListStatesBundle.getString("valueList.haryana"));	
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.himachalPradesh"), objValueListStatesBundle.getString("valueList.himachalPradesh"));
		TreeMapStates.put( objValueListStatesBundle.getString("valueList.jammuAndKashmir"), objValueListStatesBundle.getString("valueList.jammuAndKashmir"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.jharkhand"), objValueListStatesBundle.getString("valueList.jharkhand"));
		TreeMapStates.put( objValueListStatesBundle.getString("valueList.karnataka"), objValueListStatesBundle.getString("valueList.karnataka"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.kerala"), objValueListStatesBundle.getString("valueList.kerala"));
		TreeMapStates.put( objValueListStatesBundle.getString("valueList.madhyaPradesh"), objValueListStatesBundle.getString("valueList.madhyaPradesh"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.maharashtra"), objValueListStatesBundle.getString("valueList.maharashtra"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.manipur"), objValueListStatesBundle.getString("valueList.manipur"));
		TreeMapStates.put( objValueListStatesBundle.getString("valueList.meghalaya"), objValueListStatesBundle.getString("valueList.meghalaya"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.mizoram"), objValueListStatesBundle.getString("valueList.mizoram"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.nagaland"), objValueListStatesBundle.getString("valueList.nagaland"));
		TreeMapStates.put( objValueListStatesBundle.getString("valueList.orissa"), objValueListStatesBundle.getString("valueList.orissa"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.punjab"), objValueListStatesBundle.getString("valueList.punjab"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.rajasthan"), objValueListStatesBundle.getString("valueList.rajasthan"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.sikkim"), objValueListStatesBundle.getString("valueList.sikkim"));
		TreeMapStates.put( objValueListStatesBundle.getString("valueList.tamilNadu"), objValueListStatesBundle.getString("valueList.tamilNadu"));
		TreeMapStates.put( objValueListStatesBundle.getString("valueList.tripura"), objValueListStatesBundle.getString("valueList.tripura"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.uttaranchal"), objValueListStatesBundle.getString("valueList.uttaranchal"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.uttarPradesh"), objValueListStatesBundle.getString("valueList.uttarPradesh"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.westBengal"), objValueListStatesBundle.getString("valueList.westBengal"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.andamanAndNicobarIslands"), objValueListStatesBundle.getString("valueList.andamanAndNicobarIslands"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.dadarAndNagarHaveli"), objValueListStatesBundle.getString("valueList.dadarAndNagarHaveli"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.damanAndDiu"), objValueListStatesBundle.getString("valueList.damanAndDiu"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.lakshadeep"), objValueListStatesBundle.getString("valueList.lakshadeep"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.pondicherry"), objValueListStatesBundle.getString("valueList.pondicherry"));
		TreeMapStates.put(objValueListStatesBundle.getString("valueList.chandigarh"), objValueListStatesBundle.getString("valueList.chandigarh"));
		return TreeMapStates;
	}
	 
	 
	 
	 	/**
		 * This method fetches the information valueList_boolean.properties file	
		 * 
		 * @return TreeMap  object
		 */

		 public TreeMap getBoolean()
		{
			TreeMap TreeMapBoolean =new TreeMap();
			TreeMapBoolean.put("1", objValueListBooleanBundle.getString("valueList.yes"));
			TreeMapBoolean.put("2", objValueListBooleanBundle.getString("valueList.no"));
			
			return TreeMapBoolean;
		}
		 
		 
		 	/**
			 * This method fetches the information valueList_residentialStatus.properties file	
			 * 
			 * @return TreeMap  object
			 */

			 public TreeMap getResidentialStatus()
			{
				TreeMap TreeMapResStatus =new TreeMap();
				TreeMapResStatus.put("1", objValueListResStatusBundle.getString("valueList.residentIndian"));
				TreeMapResStatus.put("2", objValueListResStatusBundle.getString("valueList.nonResidentIndian"));
				TreeMapResStatus.put("3", objValueListResStatusBundle.getString("valueList.notOrdinaryResident"));
				
				
				return TreeMapResStatus;
			}		 
			 
			 public TreeMap getInflationIndex(){
				 TreeMap TreeMapYearInflation=new TreeMap();
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
			 public TreeMap getSchedule80CDropdown()
				{
					TreeMap TreeMapSchedule80CDropdown =new TreeMap();
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
			public TreeMap getAssessmentYear() {
				// TODO Auto-generated method stub
				TreeMap TreeMapAssessmentYear =new TreeMap();
				TreeMapAssessmentYear.put("1", objValueListAssessmentYearBundle.getString("valueList.2013-2012"));
				TreeMapAssessmentYear.put("2", objValueListAssessmentYearBundle.getString("valueList.2012-2011"));
				TreeMapAssessmentYear.put("3", objValueListAssessmentYearBundle.getString("valueList.2011-2010"));
				TreeMapAssessmentYear.put("4", objValueListAssessmentYearBundle.getString("valueList.2010-2009"));
				TreeMapAssessmentYear.put("5", objValueListAssessmentYearBundle.getString("valueList.2009-2008"));
				TreeMapAssessmentYear.put("6", objValueListAssessmentYearBundle.getString("valueList.2008-2007"));		
				TreeMapAssessmentYear.put("7", objValueListAssessmentYearBundle.getString("valueList.2007-2006"));
				TreeMapAssessmentYear.put("8", objValueListAssessmentYearBundle.getString("valueList.2006-2005"));
				
				return TreeMapAssessmentYear;
			}
			public TreeMap getNatureOfPayment() {
				// TODO Auto-generated method stub
				TreeMap TreeMapNaturePayment =new TreeMap();
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
			public TreeMap getNameOfHead() {
				// TODO Auto-generated method stub
				TreeMap TreeMapNameOfHead =new TreeMap();
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
			public TreeMap getNumbersDropdown()
			{
				TreeMap TreeMapNumbersDropdown =new TreeMap();
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
			
			public TreeMap getDeducterdYear() {
				// TODO Auto-generated method stub
				TreeMap TreeDeducterdYear =new TreeMap();
				 TreeDeducterdYear.put("1", objValueListDeductedYear.getString("valueList.2010"));
				 TreeDeducterdYear.put("2", objValueListDeductedYear.getString("valueList.2011"));
				 TreeDeducterdYear.put("3", objValueListDeductedYear.getString("valueList.2012"));
				 TreeDeducterdYear.put("4", objValueListDeductedYear.getString("valueList.2013"));
				 TreeDeducterdYear.put("5", objValueListDeductedYear.getString("valueList.2014"));
				
				
				
				return  TreeDeducterdYear;
			}

	 }
	
	
	
	
	
	
	
	


