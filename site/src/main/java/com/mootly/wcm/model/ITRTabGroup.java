package com.mootly.wcm.model;

import java.util.List;

public class ITRTabGroup {
	List<ITRTab> tabList;
	
	String labelKey;
	
	public ITRTabGroup (List<ITRTab> tabList) {
		this.tabList = tabList;
	}

	public List<ITRTab> getTabList() {
		return tabList;
	}

	public void setTabList(List<ITRTab> tabList) {
		this.tabList = tabList;
	}
	
	public String getItrTabType () {
		return "group";
	}

	public String getLabelKey() {
		return labelKey;
	}
	
	public String getTabNames () {
		StringBuilder sb = new StringBuilder();
		for (ITRTab aTab:tabList) {
			sb.append(aTab.name()).append(" ");
		}
		return sb.toString();
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
	
}
