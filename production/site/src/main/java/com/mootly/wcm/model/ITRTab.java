package com.mootly.wcm.model;

public enum ITRTab {
	
	ITR1SUMMARY("calculation","income.tax.summary",new String[]{"itr1summary"}),
	//FORM16 ("formsixteenITR1","income.form.sixteen",new String[]{"formsixteennew","formsixteenedit","formsixteendelete"}),
	FORM16_SINGLE ("formsixteenITR1","income.form.sixteen",new String[]{"formsixteennew","formsixteenedit","formsixteendelete"}),
	INCOME_SALARY_PENSION ("salaryincomeITR1","income.salary.penson",new String[]{"salaryincomenew","salaryincomeedit","salaryincomedelete"}),
	INCOME_OTHER_SOURCE("otherincome","income.other.sources",new String[]{}),
	INCOME_HOUSE_PROPERTY_SINGLE("singlehouseincome","income.house.itr1",new String[]{"houseincomenew","houseincomeedit","houseincomedelete"}),
	//INCOME_HOUSE_PROPERTY("singlehouseincome","income.house.itr1",new String[]{"houseincomenew","houseincomeedit","houseincomedelete"}),
	TAX_ADVANCE ("advanceataxITR1","advance.tax.itr1",new String[]{"advancetaxnew","advancetaxedit","advancetaxdelete"}),
	TAX_SELF_ASSESSMENT ("selfassesmenttaxITR1","advance.selfassesmenttax.itr1",new String[]{"selfassesmenttaxnew","selfassesmenttaxedit","selfassesmenttaxdelete"}),
	//TAX_TDS_SALARY ("tdsfromsalaryITR1","advance.tdssalary.itr1",new String[]{"tdsfromsalarynew","tdsfromsalaryedit","tdsfromsalarydelete"}),
	TAX_TDS_OTHERS ("tdsfromothersITR1","advance.tdsothers.itr1",new String[] {"tdsfromothersnew","tdsfromothersedit","tdsfromothersdelete"}),
	DEDUCTIONS ("deductionITR1","deductions.itr1",new String[]{"newc6deduction","editc6deduction","deletec6deduction"});
	
	String componentName;
	String labelKey;
	String[] aka;
	
	ITRTab() {
	}
	
	ITRTab(String componentName,String labelKey,String[] aka) {
		this.aka = aka;
		this.labelKey=labelKey;
		this.componentName = componentName;
	}
	
	public String[] getAka() {
		return this.aka;
	}
	
	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public void setAka(String[] aka) {
		this.aka = aka;
	}
	
	public String getItrTabType () {
		return "single";
	}

	public static ITRTab getByAka(String[] aka) {
		for (ITRTab itrTab:ITRTab.values()) {
			if (itrTab.getAka() != null && itrTab.getAka().length > 0 && aka != null && aka.length > 0 ) {
				for (String anAka:itrTab.getAka()) {
					for (String outAka:aka) {
						if (anAka.equalsIgnoreCase(outAka)) {
							return itrTab;
						}
					}
				}
			}
		}
		return null;
	}
}
