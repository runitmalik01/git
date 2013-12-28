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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.compound.ValueListDocumentDetail;

@SuppressWarnings("unused")
@Node(jcrType = "selection:valuelist")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class ValueListDocument extends BaseDocument  {
	final String PROP_DETAIL_BEAN="selection:listitem";
	private final static Logger log = LoggerFactory.getLogger(ValueListDocument.class); 

	private List<ValueListDocumentDetail> valueListDocumentDetailList;
	private Map<String,String> valueListDocumentDetailMap;

	public final List<ValueListDocumentDetail> getValueListDocumentDetailList() {
		if (valueListDocumentDetailList == null) valueListDocumentDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return valueListDocumentDetailList;
	}

	public final Map<String,String> getValueListDocumentDetailMap() {
		if (valueListDocumentDetailList == null) valueListDocumentDetailList= getChildBeans(PROP_DETAIL_BEAN);
		if (valueListDocumentDetailMap == null && valueListDocumentDetailList != null) {
			valueListDocumentDetailMap = new HashMap<String, String>(valueListDocumentDetailList.size());
			for (ValueListDocumentDetail aDetail:valueListDocumentDetailList) {
				valueListDocumentDetailMap.put(aDetail.getKey(), aDetail.getLabel());
			}
		}
		
		return valueListDocumentDetailMap;
	}
	
	public final void setValueListDocumentDetailList(List<ValueListDocumentDetail> valueListDocumentDetailList) {
		this.valueListDocumentDetailList = valueListDocumentDetailList;
	}	
}
