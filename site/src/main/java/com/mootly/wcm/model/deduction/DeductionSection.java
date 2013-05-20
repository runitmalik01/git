package com.mootly.wcm.model.deduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DeductionSection {
	String name;
	String label;
	Integer displayOrder = null;
	Map<String,String> additionalProperties = new HashMap<String, String>();
	List<DeductionHead> listOfDeductionHead = new ArrayList<DeductionHead>();
	public DeductionSection() {
		
	}
	public DeductionSection(String name,String label) {
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
	
	public Integer getDisplayOrder() {
		if (displayOrder == null) {
			if (getAdditionalProperties().containsKey("displayOrder")) {
				try {
					displayOrder = Integer.valueOf(getAdditionalProperties().get("displayOrder"));
				}catch (NumberFormatException nfe) {
					displayOrder = 0;
				}		
			}
			else {
				displayOrder = 0;
			}
		}	
		
		return displayOrder;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Map<String, String> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, String> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	public List<DeductionHead> getListOfDeductionHead() {
		return listOfDeductionHead;
	}
	public void setListOfDeductionHead(List<DeductionHead> listOfDeductionHead) {
		this.listOfDeductionHead = listOfDeductionHead;
	}
	
}
