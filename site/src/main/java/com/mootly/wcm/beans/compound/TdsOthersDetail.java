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
import static com.mootly.wcm.utils.Constants.amount;
import static com.mootly.wcm.utils.Constants.financial_Year;
import static com.mootly.wcm.utils.Constants.name_deductor;
import static com.mootly.wcm.utils.Constants.tan_deductor;
import static com.mootly.wcm.utils.Constants.tds_Certificate;
import static com.mootly.wcm.utils.Constants.total_taxdeducted;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.standard.FlexibleDocument;



// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:tdsothersdetail")
public class TdsOthersDetail extends FlexibleDocument implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:tdsothersdetail";   
	static final public String NODE_NAME = TdsOthersDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(TdsOthersDetail.class); 

	private String tan_Deductor ;

	private Double total_TaxDeductor ;
	private Double val_amount;
	private String name_Deductor;
	private String tds_certificate;
	private String financial_year;
	private String personalInfoUuid;
	private boolean markedForDeletion;

	private Boolean isImportedFromDIT;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	public String getTan_Deductor() {
		if (tan_Deductor == null) tan_Deductor = getProperty(tan_deductor);
		return tan_Deductor;
	}

	public Double getTotal_TaxDeductor() {
		if (total_TaxDeductor == null) total_TaxDeductor = getProperty(total_taxdeducted);
		return total_TaxDeductor;
	}

	public Double getP_Amount() {
		if (val_amount == null) val_amount = getProperty(amount);
		return val_amount;
	}

	public String getName_Deductor() {
		if (name_Deductor == null) name_Deductor = getProperty(name_deductor);
		return name_Deductor;
	}
	public String getTds_Certificate() {
		if (tds_certificate == null) tds_certificate = getProperty(tds_Certificate);
		return tds_certificate;
	}
	public String getFinancial_Year() {
		if (financial_year == null) financial_year = getProperty(financial_Year);
		return financial_year;
	}

	public final Boolean isImportedFromDIT() {
		if ( isImportedFromDIT == null) isImportedFromDIT = getProperty("mootlywcm:isImportedFromDIT");
		return isImportedFromDIT;
	}


	public final void setTan_Deductor(String tan_Deductor) {
		this.tan_Deductor = tan_Deductor;
	}
	public final void setTotal_TaxDeductor(Double total_TaxDeductor) {
		this.total_TaxDeductor = total_TaxDeductor;
	}
	public final void setName_Deductor(String name_Deductor) {
		this.name_Deductor = name_Deductor;
	}


	public final void setP_Amount(Double val_amount) {
		this.val_amount = val_amount;
	}
	public final void setTds_Certificate(String tds_certificate) {
		this.tds_certificate = tds_certificate;
	}
	public final void setFinancial_Year(String financial_year) {
		this.financial_year = financial_year;
	}

	public final String getPersonalInfoUuid() {
		return personalInfoUuid;
	}
	public final void setPersonalInfoUuid(String personalInfoUuid) {
		this.personalInfoUuid = personalInfoUuid;
	}

	public PersonalInformation getPersonalInformation() {
		HippoBean bean = getBean(NT_PERSONAL_INFO_LINK);
		if (!(bean instanceof HippoMirror)) {
			return null;
		}

		PersonalInformation prdBean = (PersonalInformation) ((HippoMirror) bean).getReferencedBean();

		if (prdBean == null) {
			return null;
		}
		return prdBean;
	}

	public final void setImportedFromDIT(boolean isImportedFromDIT) {
		this.isImportedFromDIT = isImportedFromDIT;
	}


	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {

			super.bindToNode(node);
			node.setProperty(tan_deductor, getTan_Deductor());
			node.setProperty(total_taxdeducted,getTotal_TaxDeductor());
			node.setProperty(name_deductor,getName_Deductor());
			node.setProperty(amount,getP_Amount());
			node.setProperty(tds_Certificate,getTds_Certificate());
			node.setProperty(financial_Year,getFinancial_Year());

			if (isImportedFromDIT() != null) node.setProperty("mootlywcm:isImportedFromDIT", isImportedFromDIT());
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
		super.fill(formMap);

		if ( formMap.getField("tan_deductortdsoth") != null) {
			setTan_Deductor(formMap.getField("tan_deductortdsoth").getValue());
		}
		if ( formMap.getField("name_deductortdsoth") != null) {
			setName_Deductor(formMap.getField("name_deductortdsoth").getValue());
		}
		if ( formMap.getField("tds_certificatetdsoth") != null) {
			setTds_Certificate(formMap.getField("tds_certificatetdsoth").getValue());
		}
		if ( formMap.getField("total_taxdeductedtdsoth") != null) {
			String strTaxdeducted=formMap.getField("total_taxdeductedtdsoth").getValue();
			double TaxDeducted=Double.parseDouble(strTaxdeducted);
			setTotal_TaxDeductor(TaxDeducted);
		}
		if ( formMap.getField("amounttdsoth") != null) {
			String strAmt=formMap.getField("amounttdsoth").getValue();
			double amt=Double.parseDouble(strAmt);
			setP_Amount(amt);
		}

		if ( formMap.getField("financial_yeartdsoth") != null) {
			setFinancial_Year(formMap.getField("financial_yeartdsoth").getValue());
		}

		if ( formMap.getField("isImportedFromDIT") != null) {
			String isImportedFromDIT=formMap.getField("isImportedFromDIT").getValue();			
			setImportedFromDIT(Boolean.valueOf(isImportedFromDIT));
		}

	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		TdsOthersDetail objTdsfromothers = (TdsOthersDetail) sourceBean;
		super.cloneBean(sourceBean);
		setTan_Deductor(objTdsfromothers.getTan_Deductor());
		setName_Deductor(objTdsfromothers.getName_Deductor());
		setTotal_TaxDeductor(objTdsfromothers.getTotal_TaxDeductor());
		setP_Amount(objTdsfromothers.getP_Amount());
		setTds_Certificate(objTdsfromothers.getTds_Certificate());
		setFinancial_Year(objTdsfromothers.getFinancial_Year());

		setImportedFromDIT(objTdsfromothers.isImportedFromDIT());
	}
}
