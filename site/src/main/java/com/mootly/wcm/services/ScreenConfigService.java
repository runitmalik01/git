package com.mootly.wcm.services;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RegExValidationFields;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.beans.compound.ScreenFieldConfig;
import com.mootly.wcm.components.BaseComponent;

public class ScreenConfigService {
	private static final Logger log = LoggerFactory.getLogger(ScreenConfigService.class); 
	private static Map<String,Properties> screenConfigurationList = new HashMap<String, Properties>();
	private static ScreenConfigService screenConfigService = null;
	private ScreenConfigService() {
		
	}
	
	public synchronized static ScreenConfigService getInstance() {
		if (screenConfigService == null) screenConfigService = new ScreenConfigService();
		return screenConfigService;
	}
	
	public synchronized static Properties getScreenConfiguration(Class<? extends BaseComponent>componentClass,String assessmentYear) {
		String key = componentClass.getSimpleName().toLowerCase() + "-" + assessmentYear;
		if (!screenConfigurationList.containsKey(assessmentYear)) {
			Properties p = new Properties();
			String resourceName = "screenconfig/" + key + ".properties";
			try {
				p.load(componentClass.getClassLoader().getResourceAsStream(resourceName));
				screenConfigurationList.put(key, p);
				//JSONObject jsonObject = new JSONObject(p);
				//Map<String,String> values = new HashMap<String, String>();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Error in loading properties " + key,e);
				e.printStackTrace();
			}
		}
		return screenConfigurationList.get(key);
	}
	
	public static String generateJSON(ScreenConfigDocument screenConfigDocument) {
		if (screenConfigDocument == null) return null;
		Map<String,ScreenFieldConfig> fieldConfigMap = screenConfigDocument.getFieldConfigMapByName();
		if (fieldConfigMap == null || fieldConfigMap.size() == 0) return null;
		JSONObject jsonObject = new JSONObject();
		for (String aKey:fieldConfigMap.keySet()) {
			try {
				jsonObject.put(aKey,fieldConfigMap.get(aKey).getMapForJSON());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				log.warn("Error in generating json",e);
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}
	public static String generateJSON(Class<? extends BaseComponent>componentClass) {
		StringWriter sw = new StringWriter();
		Map<String, FieldConfig> fieldConfigMap = new LinkedHashMap<String, FieldConfig>();		
		//this to serialze the validators and send it to the jsp pages if they want to builds things dynamically
		if (componentClass.isAnnotationPresent(FormFields.class)) {
			FormFields formFieldsAnnotations = componentClass.getAnnotation(FormFields.class);
			String[] fieldNames = formFieldsAnnotations.fieldNames();
			for (String fieldName:fieldNames) {
				if (!fieldConfigMap.containsKey(fieldName)) {
					FieldConfig fieldConfig = new FieldConfig();
					fieldConfigMap.put(fieldName,fieldConfig);
				}
			}
		}
		
		if (componentClass.isAnnotationPresent(RequiredFields.class)) {
			RequiredFields requiredFieldsAnnotations = componentClass.getAnnotation(RequiredFields.class);
			String[] fieldNames = requiredFieldsAnnotations.fieldNames();
			for (String fieldName:fieldNames) {
				if (fieldConfigMap.containsKey(fieldName)){
					fieldConfigMap.get(fieldName).setIsRequired(true);
				}
			}
		}
		/*
		if (componentClass.isAnnotationPresent(RegExValidationFields.class)) {
			RegExValidationFields regExFieldsAnnotations = componentClass.getAnnotation(RegExValidationFields.class);
			String[] fieldNames = regExFieldsAnnotations.fieldNames();
			String[] patterns = regExFieldsAnnotations.patterns();
			try {
				jsonForValidators.put("regExFields", fieldNames);
				jsonForValidators.put("regExPatterns", patterns);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				log.warn("Error converting Required Fields to JSON",e);
				e.printStackTrace();
			}
		}
		*/
		if (componentClass.isAnnotationPresent(DataTypeValidationFields.class)) {
			DataTypeValidationFields dataTypeValidationFieldsAnnotations = componentClass.getAnnotation(DataTypeValidationFields.class);
			String[] fieldNames = dataTypeValidationFieldsAnnotations.fieldNames();
			DataTypeValidationType[] dataTypes = dataTypeValidationFieldsAnnotations.dataTypes();
			if (fieldNames != null && fieldNames.length > 0) {
				for (int i=0;i<fieldNames.length;i++) {
					String fieldName = fieldNames[i];
					if (fieldConfigMap.containsKey(fieldName)){
						fieldConfigMap.get(fieldName).setDataType(dataTypes[i].name());
					}
				}
			}
		}
		
		if (fieldConfigMap != null && fieldConfigMap.size() > 0 ) {
				JSONObject jsonForValidators = new JSONObject();
				for (String key:fieldConfigMap.keySet()) {
					try {
						jsonForValidators.put(key, fieldConfigMap.get(key).getJSONObject());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return jsonForValidators.toString();
		}
		else {
			return null;
		}
	}	
}
class FieldConfig {
	public FieldConfig() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}
	
	
	public JSONObject getJSONObject() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("name",name);
			jsonObject.put("dataType",dataType);		
			jsonObject.put("isRequired",isRequired);
			return jsonObject;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	String name;
	String dataType;
	Boolean isRequired;	
	
}
