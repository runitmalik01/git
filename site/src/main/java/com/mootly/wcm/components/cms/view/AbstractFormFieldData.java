package com.mootly.wcm.components.cms.view;

public class AbstractFormFieldData {
	private String name;
	private String id;
	private String title;
	private String placeHolder;
	private String label;
	private Boolean isMultiple;

	public AbstractFormFieldData() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Boolean getIsMultiple() {
		return isMultiple;
	}
	
	public void setIsMultiple(Boolean isMultiple) {
		this.isMultiple = isMultiple;
	}
}