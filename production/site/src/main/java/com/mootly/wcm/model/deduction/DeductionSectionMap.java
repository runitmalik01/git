package com.mootly.wcm.model.deduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DeductionSectionMap {
	String name;
	String label;
	Map<String,String> additionalProperties = new HashMap<String, String>();
	List<DeductionHead> listOfDeductionHead = new ArrayList<DeductionHead>();
	public DeductionSectionMap() {
		
	}
	public DeductionSectionMap(String name,String label) {
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
		return label;
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
