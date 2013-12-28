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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ScreenCalculatorService {
	private static final Logger log = LoggerFactory.getLogger(ScreenCalculatorService.class);
	private static String calculatorScript=null;
	public static final Map<String,Object> getScreenCalculations(String scriptName,Map<String,String[]> requestParameterMap,Map<String,Object> additionalBindings) {
		if(scriptName.contains(".js")){	
			calculatorScript = loadScript(scriptName);
		}else{
			calculatorScript=scriptName.trim().replaceAll("<.*?>", "");
		}
		//log.info("this is enough script"+calculatorScript);
		StringBuilder theJavaScript = new StringBuilder();
		theJavaScript.append(Calculator.JS_IMPORTS).append(Calculator.NEW_LINE);
		theJavaScript.append(Calculator.JS_PREFIX).append(Calculator.NEW_LINE);
		theJavaScript.append(calculatorScript).append(Calculator.NEW_LINE);
		theJavaScript.append(Calculator.JS_SUFFIX).append(Calculator.NEW_LINE);
		
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        
        // print global variable "x"
        try {
        	Bindings engineScope = engine.getBindings(ScriptContext.ENGINE_SCOPE);
        	//engineScope.
        	for (String fieldName:requestParameterMap.keySet()) {;
        		String fieldValue = requestParameterMap.get(fieldName)[0];
        		engineScope.put(fieldName,fieldValue);
        	}
        	if (additionalBindings != null) engineScope.putAll(additionalBindings);
        	engine.eval(theJavaScript.toString());
        	Map<String,Object> resultset = new HashMap<String, Object>();
        	for (String aKey: engineScope.keySet()) {
        		if (aKey.startsWith("out_")) {
        			//log.info("get the key of fields"+aKey);
        			//log.info("get the engine scope"+engineScope.get(aKey).toString());
        			resultset.put(aKey.substring(4), engineScope.get(aKey));
        		}        		
        	}
        	return resultset;
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
	
	public static String loadScript(String scriptName) {
		String newLine = System.getProperty("line.separator");
		//String thePath = ScreenCalculatorService.class.getClassLoader().getResource("").getPath();	
		InputStream is = null;
		/*
		try {
			is = new FileInputStream(thePath + "/scripts/"+scriptName);
			//File f = new File
			//System.out.println(theFile.)
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		is = TestScripting.class.getClassLoader().getResourceAsStream("scripts/"+scriptName);
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
