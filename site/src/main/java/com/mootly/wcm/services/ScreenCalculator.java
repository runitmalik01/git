package com.mootly.wcm.services;

import java.util.HashMap;
import java.util.Map;

public final class ScreenCalculator {
	Calculator calculator;
	Map<String, Object> resultMap = new HashMap<String, Object>();
	
	public ScreenCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void updateResultMap(String key,Object value){
		resultMap.put(key, value);
	}
	 
	public Object calculate() {
		// TODO Auto-generated method stub
		Object o = this.calculator.calculate();
		return o;
	}
}
