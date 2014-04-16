package com.mootly.wcm.model;

import java.util.HashMap;
import java.util.Map;


public enum CostModelName {
	DIY("Quick File", "DIY"),
	SemiAssisted("Super", "SemiAssisted"),
	Assisted("Super-Duper", "Assisted");

	String displayName;
	String key;

	CostModelName(String displayName, String key){
		this.displayName = displayName;	
		this.key = key;
	}

    public String getDisplayName(){
    	return displayName;
    }
    
    public String getKey(){
    	return key;
    }
    
    public static Map<String, String> getDisplayNameWithKey(){
    	Map<String, String> resultMap = new HashMap<String, String>();
    	for(CostModelName costModel : CostModelName.values()){
    		resultMap.put(costModel.getKey(), costModel.getDisplayName());
    	}
    	return resultMap;
    }
	
}
