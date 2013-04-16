package com.mootly.wcm.utils;

import java.util.HashMap;

import org.apache.commons.lang.StringEscapeUtils;
import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility methods
 *
 * @version $Id: GoGreenUtil.java 29489 2011-08-12 09:04:49Z aschrijvers $
 */
public final class GoGreenUtil {
    
    private static Logger log = LoggerFactory.getLogger(GoGreenUtil.class);
    public static final String PARAM_SITE_MENU = "siteMenu";


    /**
     * Returns null if parameter is empty string or  null, it escapes HTML otherwise
     *
     * @param request       hst request
     * @param parameterName name of the parameter
     * @return html escaped value
     */
    public static String getEscapedParameter(final HstRequest request, final String parameterName) {
        String value = request.getParameter(parameterName);
        if (value == null || value.trim().length() == 0) {
            return null;
        }
        return StringEscapeUtils.escapeHtml(value);
    }


    public static int getIntConfigurationParameter(final HstRequest request, final String param, final int defaultValue) {
        String paramValue = request.getParameter(param);
        if (paramValue != null) {
            try {
                return Integer.parseInt(paramValue);
            } catch (NumberFormatException nfe) {
                log.error("Error in parsing " + paramValue + " to integer for param " + param, nfe);
            }
        }
        return defaultValue;
    }

    private GoGreenUtil() {
    }

    public static void refreshWorkflowManager(final WorkflowPersistenceManager wpm) {
        if (wpm != null) {
            try {
                wpm.refresh();
            } catch (ObjectBeanPersistenceException obpe) {
                log.warn("Failed to refresh: " + obpe.getMessage(), obpe);
            }
        }
    }

    public static String getSiteMenuName(BaseHstComponent component, HstRequest request) {
        String result = component.getParameter(PARAM_SITE_MENU, request);

        if (result == null || result.trim().isEmpty()) {
            throw new HstComponentException("Missing component parameter: " + PARAM_SITE_MENU);
        }

        return result;
    }
    
    
    
    /**
	 * This method is used to get next screen for sources of Income
	 * 
	 * @param HstRequest
	 * @param sCurrentScreen is user's current screen name
	 * @return String sNextScreen is user's next screen name
	 * @throws 
	 * @author Komila
	 */


   public static String getNextScreen(final HstRequest request,String sCurrentScreen){
	   
	   /*
	    * 
	    * SFlag (true) refers to Salary Income  -if user opts for it
	    * HPFlag (true) refers to House Property -if user opts for it
	    * CAlag (true) refers to Capital Asset  -if user opts for it
	    * OSlag (true) refers to Other Sources  -if user opts for it
	    * 
	    */
	   
	   /*
	   HashMap hmSourcesOfIncome = new HashMap() ;
	   hmSourcesOfIncome.put("SFlag", "false");
	   hmSourcesOfIncome.put("HPFlag", "true");
	   hmSourcesOfIncome.put("CAFlag", "true");
	   hmSourcesOfIncome.put("OSFlag", "false");
	   */
	   
	   HashMap hmSourcesOfIncome = (HashMap)request.getSession().getAttribute("SourceOfIncomeNav");
	   log.info("GOGreenUtil-getNextScreen()-->hmSourcesOfIncome:"+hmSourcesOfIncome);
	   
	   
	   //strings having next screens sitemaps
	   String sSalary = UrlUtility.SalaryIncome;
	   String sHouseProperty = UrlUtility.HouseIncome;
	   String sCapitalAsset = UrlUtility.CapitalAsset;
	   String sSecurity = UrlUtility.Securities;
	   String sOtherSources = UrlUtility.OtherIncome;
	   String sAdjustmentOfLosses = UrlUtility.Adjustmentoflosses; 
	   
	   String sNextScreen = sAdjustmentOfLosses;
	   
	   boolean boolNext = false;
	   log.info("GOGreenUtil-getNextScreen()-->sFlag:-"+Boolean.valueOf((String)hmSourcesOfIncome.get("SFlag")));
	   log.info("GOGreenUtil-getNextScreen()-->HPFlag:-"+Boolean.valueOf((String)hmSourcesOfIncome.get("HPFlag")));
	   log.info("GOGreenUtil-getNextScreen()-->CAFlag:-"+Boolean.valueOf((String)hmSourcesOfIncome.get("CAFlag")));
	   log.info("GOGreenUtil-getNextScreen()-->OSFlag:-"+Boolean.valueOf((String)hmSourcesOfIncome.get("OSFlag")));
	  
	   // next screen navigation logic
	   if(sCurrentScreen.equals(sSalary)){
		  
		   if(Boolean.valueOf((String)hmSourcesOfIncome.get("HPFlag")) == true){
			   sNextScreen = sHouseProperty;
			   return sNextScreen;
		   }
		   if(Boolean.valueOf((String)hmSourcesOfIncome.get("CAFlag")) == true){
			   sNextScreen = sCapitalAsset;
			   return sNextScreen;
		   }
		   if(Boolean.valueOf((String)hmSourcesOfIncome.get("OSFlag")) == true){
			   sNextScreen = sOtherSources;
			   return sNextScreen;
		   }
		   return sNextScreen;
		   
	   }
	   
	   if(sCurrentScreen.equals(sHouseProperty)){
		   
		   if(Boolean.valueOf((String)hmSourcesOfIncome.get("CAFlag")) == true){
			   sNextScreen = sCapitalAsset;
			   return sNextScreen;
		   }
		   if(Boolean.valueOf((String)hmSourcesOfIncome.get("OSFlag")) == true){
			   sNextScreen = sOtherSources;
			   return sNextScreen;
		   }
		   return sNextScreen;
		   
	   }
	   
	   if(sCurrentScreen.equals(sSecurity)){
		   
		   if(Boolean.valueOf((String)hmSourcesOfIncome.get("OSFlag")) == true){
			   sNextScreen = sOtherSources;
			   return sNextScreen;
		   }
		   return sNextScreen;
		   
	   }
	   
	   if(sCurrentScreen.equals(sOtherSources)){
		   
		      sNextScreen = sAdjustmentOfLosses;
			   return sNextScreen;
		   }
	   return sNextScreen;
		   
   }

}
