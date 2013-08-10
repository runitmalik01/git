package com.mootly.wcm.services.ditws.helper;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


public final class SpringExpressionParser {
	
	static Logger logger = LoggerFactory.getLogger(SpringExpressionParser.class);
	
	public static String parseExpressionForString(Object contextRootObject,String springExpression,Map<String,Object> variables) {
		ExpressionParser parser = new SpelExpressionParser();	
		StandardEvaluationContext pdfContext = new StandardEvaluationContext();
		if (variables != null) {
			pdfContext.setVariables(variables);
		}		
		//pdfContext.setRootObject(contextRootObject);
		if (logger.isDebugEnabled()) {
			logger.debug("Now Parsing springExpression:" + springExpression);
		}
		String value = parser.parseExpression(springExpression).getValue(pdfContext,String.class);
		return value;
	}
	
	public static <T> T parseExpression(Object contextRootObject,String springExpression,Map<String,Object> variables, Class<T> returnType) {
		ExpressionParser parser = new SpelExpressionParser();	
		StandardEvaluationContext pdfContext = new StandardEvaluationContext();
		if (variables != null) {
			pdfContext.setVariables(variables);
		}		
		pdfContext.setRootObject(contextRootObject);
		T valueToMatch = parser.parseExpression(springExpression).getValue(pdfContext,returnType );
		return valueToMatch;
	}
	
	public static Map<String,String> parseStaticInputMap(Map<String,String> inMap,Map<String, Object> variables) {
		if (inMap != null && inMap.size() >0) {
			Map<String,String> newMap = new HashMap<String, String>();
			for (String key:inMap.keySet()) {
				String value = inMap.get(key);
				if (value != null && value.contains("#")) {
					//this means its a spring expression parse it with variables
					try {
						if (logger.isDebugEnabled()) {
							logger.debug("Parsing:"+ value);
						}
						String newValue = SpringExpressionParser.parseExpressionForString(value, value, variables);
						newMap.put(key, newValue);
					}catch (EvaluationException ex) {
						logger.warn("parseStaticInputMap Error parsing " + value,ex);
					}
				}else {
					newMap.put(key, value);
				}
			}
			return newMap;
		}
		return null;
	}
}
