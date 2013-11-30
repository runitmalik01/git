package com.mootly.wcm.components.cms.view;

import java.util.LinkedList;
import java.util.List;

public class PageDisplayRow {

	final static Integer MAX_COLUMN = 12;
	List<PageDisplayColumn> columns;
	Boolean notContainer;
	Boolean notColumn;
	Boolean notRow;

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

	public final Boolean getNotContainer() {
		return notContainer;
	}

	public final Boolean getNotColumn() {
		return notColumn;
	}

	public final Boolean getNotRow() {
		return notRow;
	}

	public final void setNotContainer(Boolean notContainer) {
		this.notContainer = notContainer;
	}

	public final void setNotColumn(Boolean notColumn) {
		this.notColumn = notColumn;
	}

	public final void setNotRow(Boolean notRow) {
		this.notRow = notRow;
	}

}
