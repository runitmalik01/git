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
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.jackrabbit.value.ValueFactoryImpl;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.hippoecm.hst.jaxrs.model.content.PropertyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.ITRScheduleSISections;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.Constants;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:deductionschedtenadetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class DeductionSchedTenADetail extends FlexibleDocument implements FormMapFiller {
	private final static Logger log = LoggerFactory.getLogger(DeductionSchedTenADetail.class);
	private Double amount;
	private String scheduleName;
	private Map<String,List<Value>> valueOfFlexFields = null; //new HashMap<String, List<Value>>();

	private final String prop_scheduleName ="mootlywcm:scheduleName";

	private final String prop_flex_string ="mootlywcm:flex_field_string";
	private final String prop_flex_long ="mootlywcm:flex_field_long";
	private final String prop_flex_date ="mootlywcm:flex_field_date";
	private final String prop_flex_boolean ="mootlywcm:flex_field_boolean";
	private final String prop_flex_double ="mootlywcm:flex_field_double";
	private final String prop_flex_docbase ="mootlywcm:flex_field_docbase";
	private final String prop_amount ="mootlywcm:amount";

	private final String prop_nt_ ="mootlywcm:maxallowed";

	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	//for personal information	

	public Double getAmount() {
		if (amount == null) amount = getProperty(prop_amount);
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			super.bindToNode(node);
			node.setProperty(prop_amount, getAmount());
			node.setProperty(prop_scheduleName, getScheduleName());
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
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		if ( formMap.getField("amount") != null) {
			log.info("this is uuid of form"+formMap.getField("amount").getValue());
			setAmount(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("amount").getValue()) ? formMap.getField("amount").getValue() : "0"));
		}
		if ( formMap.getField("scheduleName") != null) {
			log.info("this is uuid of form"+formMap.getField("scheduleName").getValue());
			setScheduleName(formMap.getField("scheduleName").getValue());
		}
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		super.cloneBean(sourceBean);
		DeductionSchedTenADetail scheduleTenADocumentDetail = (DeductionSchedTenADetail) sourceBean;
		setAmount(scheduleTenADocumentDetail.getAmount());
		setScheduleName(scheduleTenADocumentDetail.getScheduleName());
	}
	public String getScheduleName() {
		if(scheduleName == null) scheduleName = getProperty(prop_scheduleName);
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
}
