package com.mootly.wcm.services;

public interface Calculator {
	final public static String NEW_LINE = System.getProperty("line.separator");
	final public static String JS_IMPORTS="importPackage(com.mootly.wcm.services);";
	final public static String JS_PREFIX="calcObj = { calculate: function () { ";
	final public static String JS_SUFFIX="} };" + NEW_LINE +
			"var calculator = new com.mootly.wcm.services.Calculator(calcObj);" + NEW_LINE + "try { " + NEW_LINE +  
			"var screenCalculator = new com.mootly.wcm.services.ScreenCalculator(calculator);screenCalculator.calculate();" + NEW_LINE +
	"}catch(e){print(e);}";
	
	public Object calculate();
}
