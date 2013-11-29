package com.mootly.wcm.components.cms.view;

import java.util.LinkedList;
import java.util.List;

public class PageDisplayView {
	
	String title;
	List<PageDisplayRow> displayRows;

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
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
