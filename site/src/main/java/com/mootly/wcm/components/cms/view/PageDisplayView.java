package com.mootly.wcm.components.cms.view;

import java.util.LinkedList;
import java.util.List;

public class PageDisplayView {
	
	String title;
	List<PageDisplayRow> displayRows;
	
	String keywords;
	String description;
	String robots;
	Boolean hideTitle;

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}
	
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRobots() {
		return robots;
	}

	public void setRobots(String robots) {
		this.robots = robots;
	}

	public Boolean getHideTitle() {
		return hideTitle;
	}

	public void setHideTitle(Boolean hideTitle) {
		this.hideTitle = hideTitle;
	}

	public final List<PageDisplayRow> getDisplayRows() {
		return displayRows;
	}

	public final void setDisplayRows(List<PageDisplayRow> displayRows) {
		this.displayRows = displayRows;
	}
	
	public void addRow(PageDisplayRow pageDisplayRow) {
		if (displayRows == null) displayRows = new LinkedList<PageDisplayRow>();
		displayRows.add(pageDisplayRow);
	}
}
