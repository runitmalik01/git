package com.mootly.wcm.components.cms.view;

import java.util.LinkedList;
import java.util.List;

public class PageDisplayRow {

	final static Integer MAX_COLUMN = 12;
	List<PageDisplayColumn> columns;

	public final List<PageDisplayColumn> getColumns() {
		return columns;
	}

	public final void setColumns(List<PageDisplayColumn> columns) {
		this.columns = columns;
	}
	
	public void addColumn(PageDisplayColumn column) {
		if (columns == null) columns = new LinkedList<PageDisplayColumn>();
		columns.add(column);
	}
	
	public Integer getSingleColumnSpan(){
		if ( columns != null && columns.size() > 0 ) {
			return MAX_COLUMN / columns.size() ;
		}
		else {
			return null;
		}
	}
}
