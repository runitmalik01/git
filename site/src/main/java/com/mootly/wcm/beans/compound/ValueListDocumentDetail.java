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
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;

@SuppressWarnings("unused")
@Node(jcrType = "selection:listitem")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class ValueListDocumentDetail extends HippoItem  {
	private final static Logger log = LoggerFactory.getLogger(ValueListDocumentDetail.class); 
	private String key;
	private String label;
	
	private final String prop_key ="selection:key";
	private final String prop_label ="selection:label";
	
	private boolean markedForDeletion;
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	//for personal information
	public final String getKey() {
		if (key == null) key = getProperty(prop_key);
		return key;
	}
	public final String getLabel() {
		if (label == null) label = getProperty(prop_label);
		return label;
	}
	
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			node.setProperty(prop_key, getKey());
			node.setProperty(prop_label, getLabel());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	
}
