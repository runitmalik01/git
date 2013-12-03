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

package com.mootly.wcm.beans.standard;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFactory;
import javax.jcr.ValueFormatException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.jackrabbit.value.ValueFactoryImpl;
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
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
//@Node(jcrType = "mootlywcm:flexibledocument")
@SuppressWarnings("unused")

@XmlAccessorType(XmlAccessType.NONE)
public class FlexibleDocument extends BaseDocument implements FormMapFiller {
	public final static Logger log = LoggerFactory.getLogger(FlexibleDocument.class); 
	
	@XmlTransient
	private Map<String,Value> valueOfFlexFields = null;//new HashMap<String, Value>();
	private final static String FLEX_FIELD_PRFIX="flex_";
	private final String prop_flex_string ="mootlywcm:flex_field_string";
	private final String prop_flex_long ="mootlywcm:flex_field_long";
	private final String prop_flex_date ="mootlywcm:flex_field_date";
	private final String prop_flex_boolean ="mootlywcm:flex_field_boolean";
	private final String prop_flex_double ="mootlywcm:flex_field_double";
	private final String prop_flex_docbase ="mootlywcm:flex_field_docbase";
	
	public static Value getValueFromFieldName(String fieldName,String fieldValue) throws ParseException {
		//the fieldName is of name flex_field_<<dataType>>_<<fieldName>>
		ValueFactory vf = ValueFactoryImpl.getInstance();
		String fieldDataType = getDataTypeFromFieldName(fieldName);
		Value theReturnValue = getValueFromDataType(fieldDataType,fieldValue);
		return theReturnValue;
	}
	
	public static String getDataTypeFromFieldName(String fieldName) throws ParseException {		
		if (!fieldName.startsWith(FLEX_FIELD_PRFIX)) return null;
		int ordOfTheField = fieldName.indexOf(FLEX_FIELD_PRFIX)+ FLEX_FIELD_PRFIX.length(); 
		String dataTypeAndOrd = fieldName.substring(ordOfTheField);
		String[] splittingParts = dataTypeAndOrd.split("[_]");
		if (splittingParts.length !=  2) {
			//log.warn(dataTypeAndOrd + " is not in the format of flex_field_string_0. Skipping..");
			//return null;
		}
		String fieldDataType = splittingParts[0].toLowerCase();
		return fieldDataType;
	}
	
	public static Value getValueFromDataType(String fieldDataType,String fieldValue) throws ParseException {		
		ValueFactory vf = ValueFactoryImpl.getInstance();
		Value theReturnValue = null;
		if (fieldDataType.equals("string")){
			theReturnValue = vf.createValue(fieldValue);
		}
		else if (fieldDataType.equals("double")) {
			theReturnValue = vf.createValue(Double.valueOf(fieldValue));
		}
		else if (fieldDataType.equals("long")) {
			theReturnValue = vf.createValue(Long.valueOf(fieldValue));
		}
		else if (fieldDataType.equals("int")) {
			theReturnValue = vf.createValue(Integer.valueOf(fieldValue));
		}
		else if (fieldDataType.equals("bool")) {
			theReturnValue = vf.createValue(Boolean.valueOf(fieldValue));
		}
		else if (fieldDataType.equals("decimal")) {
			theReturnValue = vf.createValue(BigDecimal.valueOf(Double.valueOf(fieldValue)));
		}
		else if (fieldDataType.equals("date")) {
			SimpleDateFormat sf = new SimpleDateFormat();
			Date dateValue = sf.parse(fieldValue);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateValue);
			theReturnValue = vf.createValue(cal);
		}
		return theReturnValue;
	}
	
	public static Value getValueFromDataType(Object fieldValue) throws ParseException {		
		ValueFactory vf = ValueFactoryImpl.getInstance();
		Value theReturnValue = null;
		if (fieldValue instanceof String){
			theReturnValue = vf.createValue( (String) fieldValue);
		}
		else if (fieldValue instanceof Double) {
			theReturnValue = vf.createValue((Double) fieldValue);
		}
		else if (fieldValue instanceof Long) {
			theReturnValue = vf.createValue((Long)fieldValue);
		}
		else if (fieldValue instanceof Integer) {
			theReturnValue = vf.createValue((Integer) fieldValue);
		}
		else if (fieldValue instanceof Boolean ) {
			theReturnValue = vf.createValue( (Boolean) fieldValue );
		}
		else if (fieldValue instanceof BigDecimal) {
			theReturnValue = vf.createValue(BigDecimal.valueOf( (Double)fieldValue));
		}
		else if ( fieldValue instanceof Calendar )  {
			theReturnValue = vf.createValue( (Calendar) fieldValue  );
		}
		return theReturnValue;
	}
	
	//public Map<String, Value> getValueOfFlexFields() {
	//	return getValueOfFlexFields(node);
	//}
	/**
	 * 
	 * @return
	 */
	@XmlTransient
	public Map<String, Value> getValueOfFlexFields() {
		if (valueOfFlexFields == null) {
			valueOfFlexFields = new HashMap<String, Value>();
			Map<String,Object> props = getProperty();
			//PropertyIterator propertyIterator = node.getProperties();
			for (String propertyName:props.keySet()) {
				if (propertyName.startsWith(FLEX_FIELD_PRFIX)) {		
					try {
						String fieldDataType = getDataTypeFromFieldName(propertyName);
						Value aValue = null;
						aValue = getValueFromDataType(fieldDataType, (String)props.get(propertyName));
						if (aValue != null) valueOfFlexFields.put(propertyName,aValue);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return valueOfFlexFields;
	}
	/**
	 * 
	 * @param valueOfFlexFields
	 */
	public void setValueOfFlexFields(Map<String, Value> valueOfFlexFields) {
		this.valueOfFlexFields = valueOfFlexFields;
	}
	
	public void setFlexField(String fieldName,Value fieldValue) {
		if (valueOfFlexFields == null) valueOfFlexFields = new HashMap<String, Value>();
		valueOfFlexFields.put(fieldName,fieldValue);
	}
	
	@SuppressWarnings("unchecked")
	public final <T> T getFlexField(String fieldName,T defaultValue) {
		T returnValue = null;
		try {
			//find the dataType
			if (!getValueOfFlexFields().containsKey(fieldName) && node != null) {
				if (node.hasProperty(fieldName)) getValueOfFlexFields().put(fieldName, node.getProperty(fieldName).getValue());				
			}
			if (getValueOfFlexFields().containsKey(fieldName)) {
				Value v = getValueOfFlexFields().get(fieldName);
				if (v == null) {
					return defaultValue;
				}
				else {
					String fieldDataType = getDataTypeFromFieldName(fieldName);
					if (fieldDataType.equals("string")){
						returnValue = (T) v.getString();
					}
					else if (fieldDataType.equals("double")) {
						returnValue = (T) new Double(v.getDouble());
					}
					else if (fieldDataType.equals("long")) {
						returnValue = (T) new Long( v.getLong() );
					}
					else if (fieldDataType.equals("int")) {
						returnValue = (T) new Integer( new Long( v.getLong() ).intValue() );
					}
					else if (fieldDataType.equals("bool")) {
						returnValue = (T) new Boolean( v.getBoolean() );
					}
					else if (fieldDataType.equals("date")) {
						returnValue = (T) v.getDate();					
					}
					else if (fieldDataType.equals("decimal")) {
						return (T) v.getDecimal();
					}
					else {
						returnValue = (T) v.getString();
					}
				} 
			}
		} catch (ValueFormatException e) {
			// TODO Auto-generated catch block
			log.error("Error fetching value",e);
			e.printStackTrace();
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error fetching value",e);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error fetching value",e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error fetching value",e);
		}	
		return returnValue;
	}
	
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		
		try {
			if (getValueOfFlexFields() != null) {
				for (String fieldName:getValueOfFlexFields().keySet()) {
					node.setProperty(fieldName, getValueOfFlexFields().get(fieldName));
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
		if (formMap == null) return;
		String[] fieldNames = formMap.getFieldNames();		
		if (fieldNames == null) {
			if ( formMap.getFormMap() != null && formMap.getFormMap().size() > 0 ) {
				fieldNames = formMap.getFormMap().keySet().toArray(new String[formMap.getFormMap().size()]);
			}
		}
		if ( fieldNames != null && fieldNames.length > 0 ) {
			for (String fieldName:fieldNames){
				if (log.isInfoEnabled()){
					log.info("Flex Field check:" + fieldName);
				}
				//the format of the fieldname must be flex_field_string_0 flex_field_string_1 
				if (!fieldName.startsWith(FLEX_FIELD_PRFIX)) continue;
				String fieldValue = formMap.getField(fieldName).getValue();
				try {
					Value v = getValueFromFieldName(fieldName, fieldValue);
					setFlexField(fieldName, v);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					log.error("Parsing Exception " + fieldName,e);
					//e.printStackTrace();
				}
			}
		}
	}
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		FlexibleDocument deductionDocumentDetail = (FlexibleDocument) sourceBean;		
		setValueOfFlexFields(deductionDocumentDetail.getValueOfFlexFields());
	}
}
