package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

public enum ITRScheduleCFLYear {

	PrevYrToAY(1),
	Prev2ndYearFromAY(2),
	Prev3rdYearFromAY(3),
	Prev4thYearFromAY(4),
	Prev5thYearFromAY(5),
	Prev6thYearFromAY(6),
	Prev7thYearFromAY(7),
	Prev8thYearFromAY(8),
	UNKNOWN;

	int diffToFy;

	ITRScheduleCFLYear(){

	}

	ITRScheduleCFLYear(int diffToFy){
		this.diffToFy = diffToFy;
	}

	public String getAssessmentYears(FinancialYear financialYear){

		String year = financialYear.getDisplayName();

		return year;

	}

	public int getDiffToFy() {
		return diffToFy;
	}

	public List<String> getListOfITRScheduleCFLYear(FinancialYear financialYear){
		List<String> listOfITRScheduleCFLYear = new ArrayList<String>();
		for(ITRScheduleCFLYear iTRScheduleCFLYear : ITRScheduleCFLYear.values()){
			if(iTRScheduleCFLYear != iTRScheduleCFLYear.UNKNOWN){
			int startYear = financialYear.getStartAssessmentYear();
			int endYear = financialYear.getEndAssessmentYear();
			String scheduleCFLYear = (startYear - iTRScheduleCFLYear.diffToFy)+"-"+(endYear - iTRScheduleCFLYear.diffToFy);
			listOfITRScheduleCFLYear.add(scheduleCFLYear);
			}
		}
		return listOfITRScheduleCFLYear;
	}

	public String getITRScheduleCFLYear(FinancialYear financialYear, ITRScheduleCFLYear iTRScheduleCFLYear){
		for(ITRScheduleCFLYear itrScheduleCFLYear : ITRScheduleCFLYear.values()){
			if(iTRScheduleCFLYear != iTRScheduleCFLYear.UNKNOWN && itrScheduleCFLYear.equals(iTRScheduleCFLYear)){
			int startYear = financialYear.getStartAssessmentYear();
			int endYear = financialYear.getEndAssessmentYear();
			String scheduleCFLYear = (startYear - iTRScheduleCFLYear.diffToFy)+"-"+(endYear - iTRScheduleCFLYear.diffToFy);
			return scheduleCFLYear;
			}
		}
		return null;
	}

	public static List<String> getListOfITRScheduleCFLYear(FinancialYear financialYear, ITRScheduleCFLYear[] iTRScheduleCFLYear){
		List<String> listOfITRScheduleCFLYear = new ArrayList<String>();
		for(ITRScheduleCFLYear itrScheduleCFLYear : iTRScheduleCFLYear){
			if(itrScheduleCFLYear != ITRScheduleCFLYear.UNKNOWN){
			int startYear = financialYear.getStartAssessmentYear();
			int endYear = financialYear.getEndAssessmentYear();
			String scheduleCFLYear = (startYear - itrScheduleCFLYear.diffToFy)+"-"+(endYear - itrScheduleCFLYear.diffToFy);
			listOfITRScheduleCFLYear.add(scheduleCFLYear);
			}
		}
		return listOfITRScheduleCFLYear;
	}

}
