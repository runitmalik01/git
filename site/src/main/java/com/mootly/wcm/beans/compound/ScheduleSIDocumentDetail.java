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
@Node(jcrType = "mootlywcm:schedulesidocumentdetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class ScheduleSIDocumentDetail extends FlexibleDocument implements FormMapFiller {
	private final static Logger log = LoggerFactory.getLogger(ScheduleSIDocumentDetail.class);
	private Double amount;
	private Double specialRate;
	private String schedulesiSection;
	private Double calcRateIncome;
	private Double minChargTaxIncome;
	private Map<String,List<Value>> valueOfFlexFields = null; //new HashMap<String, List<Value>>();

	private final String prop_specialRate ="mootlywcm:specialRate";
	private final String prop_schedulesiSection ="mootlywcm:schedulesiSection";
	private final String prop_calcRateIncome ="mootlywcm:calcRateIncome";
	private final String prop_minChargTaxIncome ="mootlywcm:minChargTaxIncome";

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
	public final Double getSpecialRate() {
		if (specialRate == null) specialRate = getProperty(prop_specialRate);
		return specialRate;
	}
	public final String getSchedulesiSection() {
		if (schedulesiSection == null) schedulesiSection = getProperty(prop_schedulesiSection);
		return schedulesiSection;
	}
	public final Double getCalcRateIncome() {
		if (calcRateIncome == null) calcRateIncome = getProperty(prop_calcRateIncome);
		if (calcRateIncome == null) calcRateIncome = 0D;
		return calcRateIncome;
	}
	public final Double getMinChargTaxIncome() {
		if (minChargTaxIncome == null) minChargTaxIncome = getProperty(prop_minChargTaxIncome);
		if (minChargTaxIncome == null) minChargTaxIncome =0D;
		return minChargTaxIncome;
	}

	public final void setSpecialRate(Double specialRate) {
		this.specialRate = specialRate;
	}

	public final void setSchedulesiSection(String schedulesiSection) {
		this.schedulesiSection = schedulesiSection;
	}

	public final void setCalcRateIncome(Double calcRateIncome) {
		this.calcRateIncome = calcRateIncome;
	}

	public final void setMinChargTaxIncome(Double minChargTaxIncome) {
		this.minChargTaxIncome = minChargTaxIncome;
	}

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
			node.setProperty(prop_specialRate, getSpecialRate());
			node.setProperty(prop_schedulesiSection, getSchedulesiSection());
			node.setProperty(prop_calcRateIncome, getCalcRateIncome());
			node.setProperty(prop_minChargTaxIncome, getMinChargTaxIncome());
			node.setProperty(prop_amount, getAmount());
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
			setAmount(Double.parseDouble(formMap.getField("amount").getValue()));
			setMinChargTaxIncome(Double.parseDouble(formMap.getField("amount").getValue()));
		}
		if (formMap.getField("schedulesiSection") != null) {
			setSchedulesiSection(formMap.getField("schedulesiSection").getValue());
			ITRScheduleSISections si=ITRScheduleSISections.getScheduleSISection(getSchedulesiSection());
			if(si.getPercentRate().length == 1){
				setSpecialRate(si.getPercentRate()[si.getPercentRate().length-1]);
				Double amount = Double.parseDouble(formMap.getField("amount").getValue());
				Double cal = (amount * si.getPercentRate()[si.getPercentRate().length-1])/100;
				setCalcRateIncome(Double.parseDouble(indianCurrencyHelper.roundOff(cal).toString()));
			}else{
				if(formMap.getField("specialRate") != null) {
					setSpecialRate(Double.parseDouble(formMap.getField("specialRate").getValue()));
					Double amount = Double.parseDouble(formMap.getField("amount").getValue());
					Double cal = (amount * Double.parseDouble(formMap.getField("specialRate").getValue()))/100;
					setCalcRateIncome(Double.parseDouble(indianCurrencyHelper.roundOff(cal).toString()));
				}
			}
		}
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		super.cloneBean(sourceBean);
		ScheduleSIDocumentDetail scheduleSIDocumentDetail = (ScheduleSIDocumentDetail) sourceBean;
		setSpecialRate(scheduleSIDocumentDetail.getSpecialRate());
		setSchedulesiSection(scheduleSIDocumentDetail.getSchedulesiSection());
		setCalcRateIncome(scheduleSIDocumentDetail.getCalcRateIncome());
		setMinChargTaxIncome(scheduleSIDocumentDetail.getMinChargTaxIncome());
		setAmount(scheduleSIDocumentDetail.getAmount());
	}
}
