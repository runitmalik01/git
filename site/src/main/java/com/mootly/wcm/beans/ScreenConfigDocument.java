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
import java.util.List;
import java.util.Map;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;
import com.mootly.wcm.beans.compound.ScreenFieldConfig;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:screenconfig")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class ScreenConfigDocument extends BaseDocument {
	private final static Logger log = LoggerFactory.getLogger(ScreenConfigDocument.class); 
	final String PROP_DETAIL_BEAN = "mootlywcm:screenfieldconfig";
	private List<ScreenFieldConfig> screenFieldConfigList;
	
	private String screenHeading;
	private String screenSubHeading;
	private String screenHelp;
	private String onSubmitHandler;
	private String additionalScript;
	
	public String getScreenHeading() {
		if (screenHeading == null) screenHeading = getProperty("mootlywcm:screenHeading");
		return screenHeading;
	}
	
	public String getScreenSubHeading() {
		if (screenSubHeading == null) screenSubHeading = getProperty("mootlywcm:screenSubHeading");
		return screenSubHeading;
	}
	
	public String getScreenHelp() {
		if (screenHelp == null) screenHelp = getProperty("mootlywcm:screenHelp");
		return screenHelp;
	}
	
	public String getOnSubmitHandler() {
		if (onSubmitHandler == null) onSubmitHandler = getProperty("mootlywcm:onSubmitHandler");
		return onSubmitHandler;
	}
	
	public String getAdditionalScript() {
		if (additionalScript == null) additionalScript = getProperty("mootlywcm:additionalScript");
		return additionalScript;
	}

	public final List<ScreenFieldConfig> getScreenFieldConfigList() {
		if (screenFieldConfigList == null) screenFieldConfigList= getChildBeans(PROP_DETAIL_BEAN);
		return screenFieldConfigList;
	}
	
	public final Map<String, ScreenFieldConfig> getFieldConfigMapByName() {
		if (screenFieldConfigList == null) screenFieldConfigList= getChildBeans(PROP_DETAIL_BEAN);
		if (screenFieldConfigList != null && screenFieldConfigList.size() > 0) {
			Map<String,ScreenFieldConfig> fieldConfigMap = new HashMap<String, ScreenFieldConfig>(screenFieldConfigList.size());
			for (ScreenFieldConfig aFieldConfig:screenFieldConfigList) {
				fieldConfigMap.put(aFieldConfig.getFieldName(), aFieldConfig);
			}
			return fieldConfigMap;
		}
		return null;
	}

}
