package com.mootly.wcm.model;

import java.util.Date;
import java.util.GregorianCalendar;

public enum FinancialYear {
	TwentyEight(2008,false),
	TwentyNine(2009,false),
	TwentyTen(2010,false),
	TwentyEleven(2011,false),
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
	Date dateStartFinancialYear;
	Date dateEndFinancialYear;
	Date dateStartAssessmentYear;
	Date dateEndAssessmentYear;
	
	boolean isActive = true;
	
	
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
		
		this.dateStartFinancialYear = new GregorianCalendar(startYear, 03, 01).getTime();
		this.dateEndFinancialYear = new GregorianCalendar(endYear, 04, 30).getTime();
		
		this.dateStartAssessmentYear = new GregorianCalendar(this.startAssessmentYear, 03, 01).getTime();
		this.dateEndAssessmentYear = new GregorianCalendar(this.endAssessmentYear, 04, 30).getTime();
		
	}
	
	public String toString() {
		return displayName;
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

	public Date getDateStartFinancialYear() {
		return dateStartFinancialYear;
	}

	public Date getDateEndFinancialYear() {
		return dateEndFinancialYear;
	}

	public Date getDateStartAssessmentYear() {
		return dateStartAssessmentYear;
	}

	public Date getDateEndAssessmentYear() {
		return dateEndAssessmentYear;
	}

	
}
