/**
 * 
 */
package com.mootly.wcm.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author admin
 *
 */
public final class IndianGregorianCalendar {
	/**
	 * 
	 */
	public static TimeZone indianTimeZone = TimeZone.getTimeZone("GMT+05:30");
	public static String indianDateFormStr="yyyy-MM-dd";
	public static String indianLocalDateFormStr="dd-MM-yyyy";
	public static String indianDateTimeFormStr="dd-MM-yyyy hh:mm a";
	
	public static GregorianCalendar getIndianInstance() {
		return new GregorianCalendar(indianTimeZone);
	}
	
	public static String formatDateAsString(Calendar date, String format) {
		String strDate = null;
		DateFormat formatter = new SimpleDateFormat(format);
		formatter.setTimeZone(indianTimeZone);
		strDate = formatter.format(date.getTime());
		return strDate;
	}
	
	public static String getCurrentDateTimeInIndiaAsStandardString() {
		Calendar currentdate = IndianGregorianCalendar.getIndianInstance();
		return formatDateAsString(currentdate, indianDateTimeFormStr);
	}

	public static String getCurrentDateInIndiaAsLocalString() {
		Calendar currentdate = Calendar.getInstance();
		String strDate = null;
		DateFormat formatter = new SimpleDateFormat(indianLocalDateFormStr);
		formatter.setTimeZone(indianTimeZone);
		strDate = formatter.format(currentdate.getTime());
		return strDate;
	}
	
	public static String getCurrentDateInIndiaAsString() {
		Calendar currentdate = Calendar.getInstance();
		String strdate = null;
		DateFormat formatter = new SimpleDateFormat(indianDateFormStr);
		formatter.setTimeZone(indianTimeZone);
		strdate = formatter.format(currentdate.getTime());
		System.out.println("strdate=>" + strdate);
		TimeZone obj = TimeZone.getTimeZone("GMT+5:30");

		formatter.setTimeZone(obj);
		String strDate = formatter.format(currentdate.getTime());
		return strDate;
	}

	public static GregorianCalendar getCurrentDateInIndiaAsDate() {
		return getIndianInstance();
	}
}
