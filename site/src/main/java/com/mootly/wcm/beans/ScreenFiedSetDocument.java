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
import java.util.List;

import org.hippoecm.hst.content.beans.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.compound.ScreenFieldSetDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:ScreenFieldSetDocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class ScreenFiedSetDocument extends BaseDocument {
	private final static Logger log = LoggerFactory.getLogger(ScreenFiedSetDocument.class); 
	final String PROP_DETAIL_BEAN = "mootlywcm:screenfieldconfig";
	final String PROP_DETAIL_FIELD_SET_BEAN = "mootlywcm:ScreenFieldSet";

	private List<ScreenFieldSetDetail> screenFieldSetDocumentList;
		
	public final List<ScreenFieldSetDetail> getScreenFieldSetDocumentList() {
		if (screenFieldSetDocumentList == null) screenFieldSetDocumentList= getChildBeans(PROP_DETAIL_FIELD_SET_BEAN);
		return screenFieldSetDocumentList;
	}

}
