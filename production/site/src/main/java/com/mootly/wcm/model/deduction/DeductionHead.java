package com.mootly.wcm.model.deduction;

import java.util.HashMap;
import java.util.Map;

public final class DeductionHead {
	String name;
	String label;
	String belongsTo;
	Map<String,String> additionalProperties = new HashMap<String, String>();
	
	public DeductionHead() {
		
	}
	public DeductionHead(String name,String label) {
		this.name = name;
		this.label = label;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		if (label == null) label = getAdditionalProperties().get("label");
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(String belongsTo) {
		this.belongsTo = belongsTo;
	}
	public Map<String, String> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, String> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}
