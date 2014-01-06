package com.mootly.wcm.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.services.IndianCurrencyHelper;

public enum FinancialYear {
	TwentyEight(2008,false),
	TwentyNine(2009,false),
	TwentyTen(2010,false),
	TwentyEleven(2011,true),
	TwentyTweleve(2012,true),
	TwentyThirteen(2013,true),
	TwentyForteen(2014,false),
	TwentyFifteen(2015,false),
	UNKNOWN;

	int startYear;
	int endYear;
	String displayName;
	String displayAssessmentYear;
	String assessmentYearForDITSOAPCall;
	int startAssessmentYear;
	int endAssessmentYear;
	GregorianCalendar dateStartFinancialYear;
	GregorianCalendar dateEndFinancialYear;
	Integer assessmentYear;
	GregorianCalendar dueDate;
	String javaPackageName;

	boolean isActive = true;
	boolean isPastDue = false;

	TimeZone indianTimeZone = TimeZone.getTimeZone("UTC+5:30");

	FinancialYear() {
	}

	FinancialYear(int startYear,boolean isActive) {
		this.startYear = startYear;
		this.isActive = isActive;

		String controlFYStr = System.getProperty("controlFY");
		boolean controlFY = false;
		if (controlFYStr != null && Boolean.valueOf(controlFYStr)) {
			controlFY = true;
		}
		if (controlFY) {
			String fyStartYearEnabled = System.getProperty("FY."+startYear + ".enabled");
			if (fyStartYearEnabled != null) {
				this.isActive = Boolean.valueOf(fyStartYearEnabled);
			}
			else {
				this.isActive = false;
			}
		}

		this.endYear = startYear + 1;

		this.startAssessmentYear = startYear + 1;
		this.endAssessmentYear = startYear + 2;

		this.displayName = this.startYear + "-" + endYear;
		this.displayAssessmentYear = this.startAssessmentYear + "-" + this.endAssessmentYear;
		this.assessmentYearForDITSOAPCall = this.startAssessmentYear + "-" + String.valueOf(this.endAssessmentYear).substring(2); // t should be 2013-14 for SOAP Calls
		this.javaPackageName = "y" + displayName.replace("-", "_");

		this.dateStartFinancialYear = IndianGregorianCalendar.getIndianInstance();
		this.dateStartFinancialYear.set(startYear, 03, 01);

		this.dateEndFinancialYear = IndianGregorianCalendar.getIndianInstance();
		this.dateEndFinancialYear.set(endYear, 04, 30);

		this.assessmentYear = endYear;

	}

	public String toString() {
		return displayName;
	}


	public int getAgeInYears(Date dateOfBirth) {
		Calendar dob = IndianGregorianCalendar.getIndianInstance();

		dob.setTime(dateOfBirth);

		if (dob.after(dateEndFinancialYear))
		{
			throw new IllegalArgumentException("Can't be born in the future");
		}

		int age = dateEndFinancialYear.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

		if (dateEndFinancialYear.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
		{
			age--;
		}

		return age;
	}

	public boolean isSeniorCitizen(Date dateOfBirth) {
		Calendar dob = IndianGregorianCalendar.getIndianInstance();

		dob.setTime(dateOfBirth);

		if (dob.after(dateEndFinancialYear))
		{
			throw new IllegalArgumentException("Can't be born in the future");
		}

		int age = dateEndFinancialYear.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

		if (dateEndFinancialYear.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
		{
			age--;
		}

		return (age >=60 ? true : false);
	}

	public boolean isSuperSeniorCitizen(Date dateOfBirth) {
		Calendar dob = IndianGregorianCalendar.getIndianInstance();

		dob.setTime(dateOfBirth);

		if (dob.after(dateEndFinancialYear))
		{
			throw new IllegalArgumentException("Can't be born in the future");
		}

		int age = dateEndFinancialYear.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

		if (dateEndFinancialYear.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
		{
			age--;
		}

		return (age >=80 ? true : false);
	}

	public GregorianCalendar getDueDate(ITRForm itrForm,String stateCode) {
		GregorianCalendar gc = null;
		if (stateCode != null && !"".equals(stateCode.trim()) && stateCode.equals("34") ) {
			gc = IndianGregorianCalendar.getIndianInstance();
			gc.set(dateEndFinancialYear.get(GregorianCalendar.YEAR),9,31,23,59,59);				
		}
		else {
			gc = IndianGregorianCalendar.getIndianInstance();
			gc.set(dateEndFinancialYear.get(GregorianCalendar.YEAR),7,05,23,59,59);
		}
		return gc;
	}
	
	public boolean isDateAfter(String inDateStr,String inDateFormat) {
		Date date = null ;
		DateFormat formatter =  new SimpleDateFormat(inDateFormat); 
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		//String newFormattedDateStr = IndianGregorianCalendar.formatDateAsString(cal,IndianGregorianCalendar.indianLocalDateFormStr2);
		try {
			date = (Date)formatter.parse(inDateStr);
			cal.setTime(date);
			if ( cal.after(dateEndFinancialYear) ) {
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean isPastDue(ITRForm itrForm, GregorianCalendar filingDate,String stateCode) {
		GregorianCalendar dueDate = getDueDate(itrForm,stateCode);
		if (dueDate == null) return false;
		if (filingDate.after(dueDate)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPastDue(ITRForm itrForm,String stateCode) {
		GregorianCalendar currentDate = IndianGregorianCalendar.getIndianInstance();//new GregorianCalendar();
		return isPastDue(itrForm,currentDate,stateCode);
	}

	public boolean isIncomeTaxPastDue(ITRForm itrForm,String stateCode) {
		if (stateCode != null) {
			return isPastDue(itrForm, stateCode);
		}
		else {
			return false;
		}
	}

	//Added on 03-dec-2013 to get due date for Interest Section 234B
	public Date getDueDateFor234B(){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		String dueDatefor234Bstr = "31/03/"+getEndYear();
		Date dueDatefor234B = null;
		try {
			dueDatefor234B  = indianCurrencyHelper.parsedate(dueDatefor234Bstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dueDatefor234B;
	}

	//Added on 03-dec-2013 to get Fixed Due Date i.e 31-July for respective Financial Year
	public Date getFixDueDate(){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Date fixedDueDate = null;
		try {
			fixedDueDate = indianCurrencyHelper.parsedate("31/07/"+getEndYear());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fixedDueDate;
	}

	public boolean isIncomeTaxPastDue(MemberPersonalInformation memberPersonalInformation) {
		if (memberPersonalInformation != null && memberPersonalInformation.getState() != null) {
			String theStateCode = memberPersonalInformation.getState();
			return isPastDue(memberPersonalInformation.getSelectedITRForm(), theStateCode);
		}
		else {
			return false;
		}
	}


	public FilingSection getFilingSection (ITRForm itrForm,ITReturnType itReturnType,String stateCode) {
		GregorianCalendar dueDate = IndianGregorianCalendar.getIndianInstance();//new GregorianCalendar();
		boolean isPastDue = isPastDue(itrForm,dueDate,stateCode);
		if (itReturnType.equals(ITReturnType.ORIGINAL)) {
			if (!isPastDue) {
				return FilingSection.BeforeDueDate_139_1;
			}
			else if (isPastDue) {
				return FilingSection.AfterDueDate_139_4;
			}
		}
		return FilingSection.UNKNOWN;
	}

	public static FinancialYear getByDisplayName(String displayName) {
		if (displayName == null) return UNKNOWN;
		for (FinancialYear aYear:FinancialYear.values()) {
			if (displayName.equals(aYear.getDisplayName())) {
				return aYear;
			}
		}
		return UNKNOWN;
	}

	public static FinancialYear getByAssessmentYear(String displayAssessmentYear) {
		if (displayAssessmentYear == null) return UNKNOWN;
		for (FinancialYear aYear:FinancialYear.values()) {
			if (displayAssessmentYear.equals(aYear.getDisplayAssessmentYear())) {
				return aYear;
			}
		}
		return UNKNOWN;
	}

	public boolean getActive() {
		return isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDisplayAssessmentYear() {
		return displayAssessmentYear;
	}

	public String getAssessmentYearForDITSOAPCall() {
		return assessmentYearForDITSOAPCall;
	}

	public int getStartAssessmentYear() {
		return startAssessmentYear;
	}

	public int getEndAssessmentYear() {
		return endAssessmentYear;
	}

	/** 
	 * The convention is y2012_2013
	 * @return
	 */
	public String getJavaPackageName() {
		return javaPackageName;
	}

	public GregorianCalendar getDateStartFinancialYear() {
		return dateStartFinancialYear;
	}

	public GregorianCalendar getDateEndFinancialYear() {
		return dateEndFinancialYear;
	}

	public Integer getAssessmentYear() {
		return assessmentYear;
	}

}
