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

package com.mootly.wcm.beans.compound;

import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

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
import com.mootly.wcm.beans.FormMapFiller;

/**
 * @author abhishek Date: 01 Sep 2013
 * 
 */

// this bean is used for processapplication.jsp
@TagAsTaxDataProvider(type = TaxDataProviderType.INCOME)
@Node(jcrType = "mootlywcm:tcsdetail")
public class TcsDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:tcsdetail";
	static final public String NODE_NAME = TcsDetail.class.getName()
			.toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(TcsDetail.class);

	private String tan;
	private String name;
	private Double totaltax;
	private Double taxCredited;
	private String personalInfoUuid;
	private boolean markedForDeletion;

	private Boolean isImportedFromDIT;

	// for tcsDetail of losses

	public final String getTan() {
		if (tan == null)
			tan = getProperty("mootlywcm:tan");
		return tan;
	}

	public final String getName() {
		if (name == null)
			name = getProperty("mootlywcm:name");
		return name;
	}

	public final void setTan(String Tan) {
		this.tan = Tan;
	}

	public final void setName(String Name) {
		this.name = Name;
	}

	public Double getTaxCredited() {
		if (taxCredited == null)
			taxCredited = getProperty("mootlywcm:taxcredit");
		return taxCredited;
	}

	public void setTaxCredited(Double taxCredited) {
		this.taxCredited = taxCredited;
	}

	public Double getTotaltax() {
		if (totaltax == null)
			totaltax = getProperty("mootlywcm:totaltax");
		return totaltax;
	}

	public void setTotaltax(Double totaltax) {
		this.totaltax = totaltax;
	}

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}

	public final boolean isImportedFromDIT() {
		if (isImportedFromDIT == null)
			isImportedFromDIT = getProperty("mootlywcm:isImportedFromDIT");
		return isImportedFromDIT;
	}

	public final void setImportedFromDIT(boolean isImportedFromDIT) {
		this.isImportedFromDIT = isImportedFromDIT;
	}

	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}

	public PersonalInformation getPersonalInformation() {
		HippoBean bean = getBean(NT_PERSONAL_INFO_LINK);
		if (!(bean instanceof HippoMirror)) {
			return null;
		}

		PersonalInformation prdBean = (PersonalInformation) ((HippoMirror) bean)
				.getReferencedBean();

		if (prdBean == null) {
			return null;
		}
		return prdBean;
	}

	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {

			node.setProperty("mootlywcm:tan", getTan());
			node.setProperty("mootlywcm:name", getName());
			if (getTotaltax() != null) {
				node.setProperty("mootlywcm:totaltax", getTotaltax());
			}
			if (getTaxCredited() != null) {
				node.setProperty("mootlywcm:taxcredit", getTaxCredited());
			}

			if (isImportedFromDIT())
				node.setProperty("mootlywcm:isImportedFromDIT",
						isImportedFromDIT());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding", rex);
		}
		return true;
	}

	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");
		}
		double amt = 0.0d;
		if (formMap == null)
			return;

		if (formMap.getField("tan") != null) {
			setTan(formMap.getField("tan").getValue());
		}
		if (formMap.getField("name") != null) {
			setName(formMap.getField("name").getValue());
		}
		if (formMap.getField("totaltax").getValue().isEmpty()) {
			setTotaltax(amt);
		} else {
			String strtotaltax = formMap.getField("totaltax").getValue();
			double Income = Double.parseDouble(strtotaltax);
			setTotaltax(Income);
		}
		if (formMap.getField("taxCredited").getValue().isEmpty()) {
			setTaxCredited(amt);
		} else {
			String StrTax = formMap.getField("taxCredited").getValue();
			double taxdeducted = Double.parseDouble(StrTax);
			setTaxCredited(taxdeducted);
		}

		if (formMap.getField("isImportedFromDIT") != null) {
			String isImportedFromDIT = formMap.getField("isImportedFromDIT")
					.getValue();
			setImportedFromDIT(Boolean.valueOf(isImportedFromDIT));
		}
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		TcsDetail objTcsDetail = (TcsDetail) sourceBean;
		setTan(objTcsDetail.getTan());
		setName(objTcsDetail.getName());
		setTaxCredited(objTcsDetail.getTaxCredited());
		setTotaltax(objTcsDetail.getTotaltax());
		setImportedFromDIT(objTcsDetail.isImportedFromDIT());

	};
}
