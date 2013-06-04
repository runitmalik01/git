package com.mootly.wcm.view;

import java.util.LinkedList;
import java.util.List;

import com.mootly.wcm.model.ITRTab;
import com.mootly.wcm.model.ITRTabGroup;

public class ITR1SummaryPage {
	
	List<Object> listOfITRTabs = new LinkedList<Object>();
	
	public ITR1SummaryPage() {
		listOfITRTabs.add(ITRTab.ITR1SUMMARY);
		listOfITRTabs.add(ITRTab.FORM16_SINGLE);
		
		
		List<ITRTab> listOfIncomeTabs = new LinkedList<ITRTab>();
		listOfIncomeTabs.add(ITRTab.INCOME_SALARY_PENSION);
		listOfIncomeTabs.add(ITRTab.INCOME_OTHER_SOURCE);
		listOfIncomeTabs.add(ITRTab.INCOME_HOUSE_PROPERTY_SINGLE);		
		ITRTabGroup itrTabGroupIncome = new ITRTabGroup(listOfIncomeTabs);
		itrTabGroupIncome.setLabelKey("income");
		listOfITRTabs.add(itrTabGroupIncome);
		
		List<ITRTab> listOfTaxTabs = new LinkedList<ITRTab>();
		listOfTaxTabs.add(ITRTab.TAX_ADVANCE);
		listOfTaxTabs.add(ITRTab.TAX_SELF_ASSESSMENT);
		//listOfTaxTabs.add(ITRTab.TAX_TDS_SALARY);
		listOfTaxTabs.add(ITRTab.TAX_TDS_OTHERS);
		ITRTabGroup itrTabGroupTax = new ITRTabGroup(listOfTaxTabs);
		itrTabGroupTax.setLabelKey("income.taxpaid.itr1");
		listOfITRTabs.add(itrTabGroupTax);
		
		listOfITRTabs.add(ITRTab.DEDUCTIONS);
	}

	public List<Object> getListOfITRTabs() {
		return listOfITRTabs;
	}

	public void setListOfITRTabs(List<Object> listOfITRTabs) {
		this.listOfITRTabs = listOfITRTabs;
	}
	
	
	
}
