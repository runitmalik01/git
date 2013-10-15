package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.MemberPersonalInformation;

public enum ITRScheduleCFLSections {

	HP_Loss("House Property Loss", ITRForm.values(), ITRScheduleCFLYear.values()),
	LT_Loss("Long Term Capital Loss", ITRForm.values(), ITRScheduleCFLYear.values()),
	ST_Loss("Short Term Cpital Loss", ITRForm.values(), ITRScheduleCFLYear.values()),
	//BP_Loss("Business or Profession Loss", new ITRForm[]{ITRForm.ITR3}, ITRScheduleCFLYear.values()),
	RH_Loss("Owning and Maintaining Race Horses", ITRForm.values(), new ITRScheduleCFLYear[]{ITRScheduleCFLYear.PrevYrToAY, ITRScheduleCFLYear.Prev2ndYearFromAY, ITRScheduleCFLYear.Prev3rdYearFromAY, ITRScheduleCFLYear.Prev4thYearFromAY}),
	N_Spec_Loss("Non Speculation Business Loss", new ITRForm[]{ITRForm.ITR4,ITRForm.ITR3}, ITRScheduleCFLYear.values()),
	Spec_Loss("Speculation Business Loss", new ITRForm[]{ITRForm.ITR4}, new ITRScheduleCFLYear[]{ITRScheduleCFLYear.PrevYrToAY, ITRScheduleCFLYear.Prev2ndYearFromAY, ITRScheduleCFLYear.Prev3rdYearFromAY, ITRScheduleCFLYear.Prev4thYearFromAY}),
	Speci_Buss_Loss("Loss From Specified Business", new ITRForm[]{ITRForm.ITR4}, new ITRScheduleCFLYear[]{ITRScheduleCFLYear.PrevYrToAY, ITRScheduleCFLYear.Prev2ndYearFromAY}),
	UNKNOWN;

	String displayName;
	ITRForm[] itrForm;
	ITRScheduleCFLYear[] itrScheduleCFLYear;

	ITRScheduleCFLSections(){

	}

    ITRScheduleCFLSections(String displayName, ITRForm[] itrForm, ITRScheduleCFLYear[] itrScheduleCFLYear){
		this.displayName = displayName;
		this.itrForm = itrForm;
		this.itrScheduleCFLYear = itrScheduleCFLYear;
	}

    public String getDisplayName(){
    	return displayName;
    }

    public ITRForm[] getITRForm(){
    	return itrForm;
    }

    public ITRScheduleCFLYear[] getItrScheduleCFLYear() {
		return itrScheduleCFLYear;
	}

    public static List<ITRScheduleCFLSections> getActiveHeads(ITRForm itrForm){
		List<ITRScheduleCFLSections> scheduleCFLList = new ArrayList<ITRScheduleCFLSections>();
		for(ITRScheduleCFLSections schCFLSection:ITRScheduleCFLSections.values()){
			if(schCFLSection != ITRScheduleCFLSections.UNKNOWN){
				for(ITRForm itr : schCFLSection.getITRForm()){
					if(itr.equals(itrForm)){
						scheduleCFLList.add(schCFLSection);
					}
				}
			}
		}
		return scheduleCFLList;
	}

    public static List<String> getScheduleCFLYearRelHead(FinancialYear financialYear, ITRScheduleCFLYear[] itrScheduleCFLYear){
    	return ITRScheduleCFLYear.getListOfITRScheduleCFLYear(financialYear, itrScheduleCFLYear);
    }

    public static Map<String, List<String>> getDetailListOfSections(FinancialYear financialYear, ITRForm itrForm){
    	List<ITRScheduleCFLSections> scheduleCFLList = getActiveHeads(itrForm);
    	Map<String, List<String>> resultMap = new TreeMap<String, List<String>>();
    	for(ITRScheduleCFLSections iTRScheduleCFLSections : scheduleCFLList){
    		resultMap.put(iTRScheduleCFLSections.getDisplayName(),getScheduleCFLYearRelHead(financialYear, iTRScheduleCFLSections.getItrScheduleCFLYear()));
    	}
    	return resultMap;
    }

}
