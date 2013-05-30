package com.mootly.wcm.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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
	int startAssessmentYear;
	int endAssessmentYear;
	GregorianCalendar dateStartFinancialYear;
	GregorianCalendar dateEndFinancialYear;
	Integer assessmentYear;
	GregorianCalendar dueDate;
	
	boolean isActive = true;
	boolean isPastDue = false;
	
	
	FinancialYear() {
	}
	
	FinancialYear(int startYear,boolean isActive) {
		this.startYear = startYear;
		this.isActive = isActive;
		
		this.endYear = startYear + 1;
		
		this.startAssessmentYear = startYear + 1;
		this.endAssessmentYear = startYear + 2;
		
		this.displayName = this.startYear + "-" + endYear;
		this.displayAssessmentYear = this.startAssessmentYear + "-" + this.endAssessmentYear;
		
		this.dateStartFinancialYear = new GregorianCalendar(startYear, 03, 01);
		this.dateEndFinancialYear = new GregorianCalendar(endYear, 04, 30);
		
		this.assessmentYear = endYear;
		
	}
	
	public String toString() {
		return displayName;
	}
	
	
	public int getAgeInYears(Date dateOfBirth) {
	    Calendar dob = Calendar.getInstance();

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
	    Calendar dob = Calendar.getInstance();

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
	
	public GregorianCalendar getDueDate(ITRForm itrForm) {
		GregorianCalendar gc = null;
		switch (itrForm) {
			case ITR1: 
				gc = new GregorianCalendar(dateEndFinancialYear.get(GregorianCalendar.YEAR),07,31);
				break;
		}
		return gc;
	}
	
	public boolean isPastDue(ITRForm itrForm, GregorianCalendar filingDate) {
		GregorianCalendar dueDate = getDueDate(itrForm);
		if (dueDate == null) return false;
		if (filingDate.after(dueDate)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isPastDue(ITRForm itrForm) {
		GregorianCalendar dueDate = new GregorianCalendar();
		return isPastDue(itrForm,dueDate);
	}
	
	public FilingSection getFilingSection (ITRForm itrForm,ITReturnType itReturnType) {
		GregorianCalendar dueDate = new GregorianCalendar();
		boolean isPastDue = isPastDue(itrForm,dueDate);
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

	public int getStartAssessmentYear() {
		return startAssessmentYear;
	}

	public int getEndAssessmentYear() {
		return endAssessmentYear;
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
