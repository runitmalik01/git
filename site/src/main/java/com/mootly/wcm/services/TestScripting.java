package com.mootly.wcm.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestScripting {
	
	public static void main(String[] args) {
		String calculatorScript = loadScript("TaxCalculator.js");
		//System.out.println(calculatorScript);
		StringBuilder theJavaScript = new StringBuilder();
		theJavaScript.append(Calculator.JS_IMPORTS).append(Calculator.NEW_LINE);
		theJavaScript.append(Calculator.JS_PREFIX).append(Calculator.NEW_LINE);
		theJavaScript.append(calculatorScript).append(Calculator.NEW_LINE);
		theJavaScript.append(Calculator.JS_SUFFIX).append(Calculator.NEW_LINE);
		//now we are ready with the script
		//lets set the context ensure to send an empty resultMap
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String str1 = ""; //"100.90192102012";
		String str2 = "200";
		
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        
        // print global variable "x"
        try {
        	Bindings engineScope = engine.getBindings(ScriptContext.ENGINE_SCOPE);
        	engineScope.put("txtNetIncome", str1);
        	engineScope.put("str2", str2);
	        // Now, pass a different script context
	        //
	        //
	        // add new variable "x" to the new engineScope        
        	//engineScope.put("resultMap", resultMap);
	        //System.out.println(theJavaScript.toString());
        	//engine.put("str1",  "100");
        	//engine.put("str2", "200");
        	//engine.put("str3", str3);
        	
        	engine.eval(theJavaScript.toString());
        	Map<String,Object> resultset = new HashMap<String, Object>();
        	for (String aKey: engineScope.keySet()) {
        		if (aKey.startsWith("out_")) {
        			resultset.put(aKey.substring(4), engineScope.get(aKey));
        			System.out.println(aKey + ":" + engineScope.get(aKey));
        		}        		
        	}
        	//return resultset;
        	//we should now return all variables with out_ back to the callee
        	//engine.get
        	//System.out.println("THIS WHERE THE POWER IS:" + engine.get("out_d3"));
        	/*
        	Object calcObj = engine.get("calcObj");
        	Invocable inv = (Invocable) engine;
        	Calculator calculator = inv.getInterface(calcObj,Calculator.class); 
        	ScreenCalculator scr = new ScreenCalculator(calculator);
        	scr.calculate();
        	*/
	        //System.out.println("WAIT.." + object.toString());

	        // execute the same script - but this time pass a different script context
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // the above line prints "hello"

        // the above line prints "world"
	}
	
	public static String loadScript(String scriptName) {
		String newLine = System.getProperty("line.separator");
		InputStream is = TestScripting.class.getClassLoader().getResourceAsStream("scripts/"+scriptName);
		if (is == null) {
			return null;
		}
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		 
		String line;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line).append(newLine);
			}
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
