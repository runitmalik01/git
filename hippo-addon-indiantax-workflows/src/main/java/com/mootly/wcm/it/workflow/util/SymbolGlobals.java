package com.mootly.wcm.it.workflow.util;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class SymbolGlobals {

	static ResourceBundle rb = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String getCharacterEncoding() {
		return "UTF-8";
	}
	
	public static Locale getLocale() {
		return Locale.ENGLISH;
	}
	
	public static TimeZone getTimeZone() {
		return TimeZone.getDefault();
	}
	
	/**
	 * Get propery values terminate by a comma
	 * @param propertyNames
	 * @return
	 */
	public static List<String> getSymbolProperties(String propertyNames) {
		return Arrays.asList( (String[]) getSymbolProperty(propertyNames,"").split("[,]") );
	}
	
	public static String getLocalProperty (String propertyName) {
		return getSymbolProperty(propertyName);
	}
	
	public static String getSymbolConfigProperty(String propertyName) {
		return getSymbolProperty(propertyName);		
	}
	
	public static String getSymbolProperty(String propertyName,String defaultValue){
		try {
			if (rb == null) rb = ResourceBundle.getBundle("EmailServiceConfiguration");
			return rb.getString(propertyName);
		}catch (Exception ex){
			return defaultValue;
		}
	}
	
	public static String getSymbolProperty(String propertyName){
		return getSymbolProperty(propertyName,null);
	}
}
