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
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.standard.FlexibleDocument;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:deductiondocumentdetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class DeductionDocumentDetail extends FlexibleDocument implements FormMapFiller {
	private final static Logger log = LoggerFactory.getLogger(DeductionDocumentDetail.class);
	private String form16uuid;
	private String section;
	private String head;
	private Double investment;
	private Double maxAllowed;
	private Map<String,List<Value>> valueOfFlexFields = null; //new HashMap<String, List<Value>>();

	private final String prop_section ="mootlywcm:Section";
	private final String prop_head ="mootlywcm:head";
	private final String prop_investment ="mootlywcm:investment";
	private final String prop_maxAllowed ="mootlywcm:maxallowed";

	private final String prop_flex_string ="mootlywcm:flex_field_string";
	private final String prop_flex_long ="mootlywcm:flex_field_long";
	private final String prop_flex_date ="mootlywcm:flex_field_date";
	private final String prop_flex_boolean ="mootlywcm:flex_field_boolean";
	private final String prop_flex_double ="mootlywcm:flex_field_double";
	private final String prop_flex_docbase ="mootlywcm:flex_field_docbase";
	private final String prop_form16_uuid ="mootlywcm:formsixteenuuid";

	private final String prop_nt_ ="mootlywcm:maxallowed";

	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	//for personal information
	public final String getSection() {
		if (section == null) section = getProperty(prop_section);
		return section;
	}
	public final String getHead() {
		if (head == null) head = getProperty(prop_head);
		return head;
	}
	public final Double getInvestment() {
		if (investment == null) investment = getProperty(prop_investment);
		if (investment == null) investment = 0D;
		return investment;
	}
	public final Double getMaxAllowed() {
		if (maxAllowed == null) maxAllowed = getProperty(prop_maxAllowed);
		if (maxAllowed == null) maxAllowed =0D;
		return maxAllowed;
	}
	
	public final void setSection(String section) {
		this.section = section;
	}

	public final void setHead(String head) {
		this.head = head;
	}

	public final void setInvestment(Double investment) {
		this.investment = investment;
	}

	public final void setMaxAllowed(Double maxAllowed) {
		this.maxAllowed = maxAllowed;
	}

	public String getForm16Uuid() {
		if (form16uuid == null) form16uuid = getProperty(prop_form16_uuid);
		return form16uuid;
	}

	public void setForm16Uuid(String form16uuid) {
		this.form16uuid = form16uuid;
	}

	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			super.bindToNode(node);
			node.setProperty(prop_section, getSection());
			node.setProperty(prop_head, getHead());
			node.setProperty(prop_investment, getInvestment());
			node.setProperty(prop_maxAllowed, getMaxAllowed());
			node.setProperty(prop_form16_uuid, getForm16Uuid());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		super.fill(formMap);
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		if ( formMap.getField("section") != null) {
			setSection(formMap.getField("section").getValue());
		}
		//else {
		//	setSection("Unknown");
		//}
		if ( formMap.getField("head") != null) {
			setHead(formMap.getField("head").getValue());
		}
		if ( formMap.getField("investment") != null) {
			try {
				setInvestment(Double.valueOf(formMap.getField("investment").getValue()).doubleValue());
				//setInvestment(Double.valueOf( formMap.getField("investment").getValue()) );
			}catch (NumberFormatException nmbe) {
				log.warn("Number format Exception",nmbe);
			}
		}
		if ( formMap.getField("maxAllowed") != null) {
			setMaxAllowed(Double.valueOf(formMap.getField("maxAllowed").getValue()).doubleValue());
		}
		else {
			setMaxAllowed(0D);
		}
		
		if ( formMap.getField("decuuidform16") != null) {
			log.info("this is uuid of form"+formMap.getField("decuuidform16").getValue());
			if(formMap.getField("decuuidform16").getValue()!=null)
				setForm16Uuid(formMap.getField("decuuidform16").getValue());
		}
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		super.cloneBean(sourceBean);
		DeductionDocumentDetail deductionDocumentDetail = (DeductionDocumentDetail) sourceBean;
		setSection(deductionDocumentDetail.getSection());
		setHead(deductionDocumentDetail.getHead());
		setInvestment(deductionDocumentDetail.getInvestment());
		setMaxAllowed(deductionDocumentDetail.getMaxAllowed());
		setForm16Uuid(deductionDocumentDetail.getForm16Uuid());
	}
}
