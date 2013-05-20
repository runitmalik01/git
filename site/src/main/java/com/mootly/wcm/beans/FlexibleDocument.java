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

package com.mootly.wcm.beans;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
@Node(jcrType = "mootlywcm:flexibledocument")
@SuppressWarnings("unused")
public class FlexibleDocument extends BaseDocument implements FormMapFiller {
	private final static Logger log = LoggerFactory.getLogger(FlexibleDocument.class); 
	
	private Map<String,List<String>> valueOfFlexFields = new HashMap<String, List<String>>();
	
	private final String prop_flex_string ="mootlywcm:flex_field_string";
	private final String prop_flex_long ="mootlywcm:flex_field_long";
	private final String prop_flex_date ="mootlywcm:flex_field_date";
	private final String prop_flex_boolean ="mootlywcm:flex_field_boolean";
	private final String prop_flex_double ="mootlywcm:flex_field_double";
	private final String prop_flex_docbase ="mootlywcm:flex_field_docbase";
	
	//flex_field_string
	//flex_field_long
	//flex_field_double
	//flex_field_date
	//flex_field_boolean
	//flex_field_docbase
	
	private boolean markedForDeletion;
	
	/**
	 * 
	 * @return
	 */
	public Map<String, List<String>> getValueOfFlexFields() {
		return valueOfFlexFields;
	}
	/**
	 * 
	 * @param valueOfFlexFields
	 */
	public void setValueOfFlexFields(Map<String, List<String>> valueOfFlexFields) {
		this.valueOfFlexFields = valueOfFlexFields;
	}
	/**
	 * Flex Fields will be used by this module to store variety of data including
	 * string,calendar,long,
	 * @param defaultValues
	 * @return
	 */
	public final <T> T[] getFlexFields(T[] defaultValues) {
		//the flex fields are defined as flex_field_string depending upon the class of the defaultValue
		String propField = "mootlywcm:flex_field_" + defaultValues[0].getClass().getSimpleName().toLowerCase();
		T[] propertyValues = getProperty(propField,defaultValues);
		return propertyValues;
	}
	
	public final <T> T getFlexField(int ord,T[] defaultValues) {
		//the flex fields are defined as flex_field_string depending upon the class of the defaultValue
		T[] propertyValues = getFlexFields(defaultValues);
		if (propertyValues != null && propertyValues.length > ord ) {
			return propertyValues[ord];
		}
		else {
			return null;
		}
	}
	
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			if (getValueOfFlexFields() != null) {
				for (String keyOfDataType:getValueOfFlexFields().keySet()) {
					String propName = "mootlywcm:flex_field_"+keyOfDataType;
					String[] arrayOfStringValues = getValueOfFlexFields().get(keyOfDataType).toArray(new String[getValueOfFlexFields().get(keyOfDataType).size()]);
					if (keyOfDataType.equals("string")) {
						node.setProperty(propName, arrayOfStringValues);
					}
				}
			}
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		
		Map<String,List<String>> valueOfFlexFields = new HashMap<String, List<String>>();
		for (String fieldName:formMap.getFieldNames()){
			if (log.isInfoEnabled()){
				log.info("Flex Field check:" + fieldName);
			}
			//the format of the fieldname must be flex_field_string_0 flex_field_string_1 
			if (!fieldName.startsWith("flex_field_")) continue;
			int ordOfTheField = fieldName.indexOf("flex_field_")+ "flex_field_".length(); 
			String dataTypeAndOrd = fieldName.substring(ordOfTheField);
			String[] splittingParts = dataTypeAndOrd.split("[_]");
			if (splittingParts.length !=  2) {
				log.warn(dataTypeAndOrd + " is not in the format of flex_field_string_0. Skipping..");
				continue;
			}
			String fieldDataType = splittingParts[0];
			String fieldOrd = splittingParts[1];
			List<String> listOfValues = null;
			if (!valueOfFlexFields.containsKey(fieldDataType)) {
				valueOfFlexFields.put(fieldDataType, new ArrayList<String>());
			}
			listOfValues = valueOfFlexFields.get(fieldDataType);
			String v = formMap.getField(fieldName).getValue();
			//if (listOfValues.get(Integer.valueOf(fieldOrd)) == null) listOfValues.add
			//listOfValues.add(Integer.valueOf(fieldOrd), v);
			int intFieldOrd =  Integer.valueOf(fieldOrd);
			if (listOfValues.size() <= intFieldOrd) {
				int loopMax = intFieldOrd - listOfValues.size();
				for (int i=0;i<loopMax;i++) listOfValues.add(null);
			}
			listOfValues.add(intFieldOrd,v);
			//String fieldValue = formMap.getField(fieldName).getValue();
		}
		//valueOfFlexFields
		setValueOfFlexFields(valueOfFlexFields);
	}
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		FlexibleDocument deductionDocumentDetail = (FlexibleDocument) sourceBean;		
		setValueOfFlexFields(deductionDocumentDetail.getValueOfFlexFields());
	}
}
