/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 * User: abhishek
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */

package com.mootly.wcm.beans.compound;
import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:screenfieldconfig")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class ScreenFieldConfig extends HippoItem  {
	private final static Logger log = LoggerFactory.getLogger(ScreenFieldConfig.class); 
	private String fieldId;
	private String fieldName;
	private String fieldTitle;
	private String fieldPopoverText;
	
	private Boolean isRequired;
	private String fieldFormat;
	private String[] validators;
	private String[] validatorArguments;
	private String formFieldType;
	private String inputFormFieldType;
	private String fieldLabel;
	private String fieldValue;
	private String fieldClass;
	private String rowLabel;
	private String fieldSpan;
	private String fieldMaxLength;
	private String href;
	private String dropDownListName;
	private Boolean readOnly;
	
	private final String Pop_mootlywcm_formFieldType="mootlywcm:formFieldType";
	private final String Pop_mootlywcm_inputFormFieldType="mootlywcm:inputFormFieldType";
	private final String Pop_mootlywcm_fieldLabel="mootlywcm:fieldLabel";
	private final String Pop_mootlywcm_fieldValue="mootlywcm:fieldValue";
	private final String Pop_mootlywcm_fieldClass="mootlywcm:fieldClass";
	private final String Pop_mootlywcm_fieldSpan="mootlywcm:fieldSpan";
	private final String Pop_mootlywcm_fieldMaxLength="mootlywcm:fieldMaxLength";
	private final String Pop_mootlywcm_href="mootlywcm:href";
	private final String Pop_mootlywcm_dropDownListName="mootlywcm:dropDownListName";
	private final String Pop_mootlywcm_readOnly="mootlywcm:readOnly";
	private final String Pop_mootlywcm_rowLabel="mootlywcm:rowLabel";
	private final String prop_mootlywcm_fieldId ="mootlywcm:fieldId";
	private final String prop_mootlywcm_fieldName ="mootlywcm:fieldName";
	private final String prop_mootlywcm_fieldTitle ="mootlywcm:fieldTitle";
	private final String prop_mootlywcm_fieldPopoverText ="mootlywcm:fieldPopoverText";
	
	private final String prop_mootlywcm_isRequired ="mootlywcm:isRequired";
	private final String prop_mootlywcm_fieldFormat ="mootlywcm:fieldFormat";
	private final String prop_mootlywcm_validators ="mootlywcm:validators";
	private final String prop_mootlywcm_validatorArguments ="mootlywcm:validatorArguments";
	
	
	public String getFieldId() {
		if (fieldId == null) fieldId = getProperty(prop_mootlywcm_fieldId);
		return fieldId;
	}
	public String getFieldName() {
		if (fieldName == null) fieldName = getProperty(prop_mootlywcm_fieldName);
		return fieldName;
	}
	public String getFieldTitle() {
		if (fieldTitle == null) fieldTitle = getProperty(prop_mootlywcm_fieldTitle);
		return fieldTitle;
	}
	public String getFieldPopoverText() {
		if (fieldPopoverText == null) fieldPopoverText = getProperty(prop_mootlywcm_fieldPopoverText);
		return fieldPopoverText;
	}
	public boolean isRequired() {
		if (isRequired == null) isRequired = getProperty(prop_mootlywcm_isRequired);
		return isRequired;
	}
	public String getFieldFormat() {
		if (fieldFormat == null) fieldFormat = getProperty(prop_mootlywcm_fieldFormat);
		return fieldFormat;
	}
	public String[] getValidators() {
		if (validators == null){
			Object prop = getProperty(prop_mootlywcm_validators);
			if (prop instanceof String) {
				String tmp= getProperty(prop_mootlywcm_validators);
				validators = new String[]{tmp};
			}
			else if (prop instanceof String[]) {
				validators =  getProperty(prop_mootlywcm_validators);
			}
		}
		return validators;
	}
	public String[] getValidatorArguments() {
		if (validatorArguments == null) {
			Object prop = getProperty(prop_mootlywcm_validatorArguments);
			if (prop instanceof String) {
				String tmp= getProperty(prop_mootlywcm_validatorArguments);
				validatorArguments = new String[]{tmp};
			}
			else if (prop instanceof String[]) {
				validatorArguments =  getProperty(prop_mootlywcm_validatorArguments);
			}
		}
		return validatorArguments;
	}
	
	
	public Map<String,Object> getMapForJSON() {
		Map<String,Object> mapForJSON = new HashMap<String, Object>();
		mapForJSON.put("fieldId",getFieldId());
		mapForJSON.put("fieldName",getFieldName());
		mapForJSON.put("fieldTitle",getFieldTitle());
		mapForJSON.put("fieldPopoverText",getFieldPopoverText());
		mapForJSON.put("isRequired",isRequired());
		mapForJSON.put("fieldFormat",getFieldFormat());
		mapForJSON.put("validators",getValidators());
		mapForJSON.put("validatorArguments",getValidatorArguments());
		
		return mapForJSON;
	}
	public String getFormFieldType() {
		if(formFieldType == null) formFieldType = getProperty(Pop_mootlywcm_formFieldType);
		return formFieldType;
	}

	public String getInputFormFieldType() {
		if(inputFormFieldType == null) inputFormFieldType = getProperty(Pop_mootlywcm_inputFormFieldType);
		return inputFormFieldType;
	}

	public String getFieldLabel() {
		if(fieldLabel == null) fieldLabel = getProperty(Pop_mootlywcm_fieldLabel);
		return fieldLabel;
	}

	public String getFieldValue() {
		if(fieldValue == null) fieldValue = getProperty(Pop_mootlywcm_fieldValue);
		return fieldValue;
	}

	public String getFieldClass() {
		if(fieldClass == null) fieldClass = getProperty(Pop_mootlywcm_fieldClass);
		return fieldClass;
	}

	public String getFieldSpan() {
		if(fieldSpan == null) fieldSpan = getProperty(Pop_mootlywcm_fieldSpan);
		return fieldSpan;
	}

	public String getFieldMaxLength() {
		if(fieldMaxLength == null) fieldMaxLength = getProperty(Pop_mootlywcm_fieldMaxLength);
		return fieldMaxLength;
	}

	public String getHref() {
		if(href == null) href = getProperty(Pop_mootlywcm_href);
		return href;
	}
	
	public String getRowLabel() {
		if(rowLabel == null) rowLabel = getProperty(Pop_mootlywcm_rowLabel);
		return rowLabel;
	}
	public String getDropDownListName() {
		if(dropDownListName == null) dropDownListName = getProperty(Pop_mootlywcm_dropDownListName);
		return dropDownListName;
	}

	public Boolean getReadOnly() {
		if(readOnly == null) readOnly = getProperty(Pop_mootlywcm_readOnly);
		return readOnly;
	}
	
	public Map<String,Object> getFormFieldMapJSON() {
		Map<String,Object> mapForJSON = new HashMap<String, Object>();
		mapForJSON.put("fieldId",getFieldId());
		mapForJSON.put("fieldName",getFieldName());
		mapForJSON.put("fieldLabel", getFieldLabel());
		mapForJSON.put("formFieldType", getFormFieldType());
		mapForJSON.put("inputFormFieldType", getInputFormFieldType());
		mapForJSON.put("fieldValue", getFieldValue());
		mapForJSON.put("fieldSpan", getFieldSpan());
		mapForJSON.put("fieldMaxLength", getFieldMaxLength());
		mapForJSON.put("rowLabel", getRowLabel());
		return mapForJSON;
	}


}
