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

import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.jcr.Value;


import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
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
 * author: Pankaj Singh
 * Date:  6/3/2013
 * Description: This is bean file which save data of capital asset form
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:capitalassetdetail")

@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class CapitalAssetDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:capitalassetdetail";
	static final public String NODE_NAME = CapitalAssetDetail.class.getName().toLowerCase();

	private final static Logger log = LoggerFactory.getLogger(CapitalAssetDetail.class); 


	private String rbfilename="rstatus_";
	private String dateAcquisition;
	private String nameAsset;
	private String assetType;
	private String costImprovement;
	private String sstCharge;
	private String costAcquisition;
	private String dateSale;
	private String costIndexAcquisition;
	private String saleConsideration;
	private String costIndexConsideration;
	private String capitalGain;
	private String capitalGainTaxLT;
	private String indexedprice;

	private String personalInfoUuid;

	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	public String getDateAcquisition() {
		if (dateAcquisition == null) dateAcquisition = getProperty("mootlywcm:year_acquisition");
		return dateAcquisition;
	}
	public String getAssetType() {
		if (assetType == null) assetType = getProperty("mootlywcm:assettype");
		return assetType;
	}
	public String getSstCharge() {
		if (sstCharge == null) sstCharge = getProperty("mootlywcm:sstcharge");
		return sstCharge;
	}
	public String getCostImprovement() {
		if (costImprovement == null) costImprovement = getProperty("mootlywcm:costimprove");
		return costImprovement;
	}
	public String getNameAsset() {
		if (nameAsset == null) nameAsset = getProperty("mootlywcm:assetname");
		return nameAsset;
	}
	public String getCostAcquisition() {
		if (costAcquisition == null) costAcquisition = getProperty("mootlywcm:cost_acquisition");
		return costAcquisition;
	}
	public String getIndexedprice() {
		if (indexedprice == null) indexedprice = getProperty("mootlywcm:indexedprice");
		return indexedprice;
	}
	public String getDateSale() {
		if (dateSale == null) dateSale = getProperty("mootlywcm:year_sale");
		return dateSale;
	}
	public String getSaleConsideration() {
		if (saleConsideration == null) saleConsideration = getProperty("mootlywcm:sale_consideration");
		return saleConsideration;
	}
	public String getCostIndexAcquisition() {
		if (costIndexAcquisition == null) costIndexAcquisition = getProperty("mootlywcm:inflation_acquisition");
		return costIndexAcquisition;
	}
	public String getCostIndexConsideration() {
		if (costIndexConsideration == null) costIndexConsideration = getProperty("mootlywcm:inflation_consideration");
		return costIndexConsideration;
	}
	public String getCapitalGain() {
		if (capitalGain == null) capitalGain = getProperty("mootlywcm:capital_gain");
		return capitalGain;
	}

	public String getCapitalGainTaxLT() {
		if (capitalGainTaxLT == null) capitalGainTaxLT = getProperty("mootlywcm:capitalgaintaxLT");
		return capitalGainTaxLT;
	}


	public final void setDateAcquisition(String dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}
	public final void setCostAcquisition(String costAcquisition) {
		this.costAcquisition = costAcquisition;
	}
	public final void setDateSale(String dateSale) {
		this.dateSale = dateSale;
	}
	public final void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public final void setNameAsset(String nameAsset) {
		this.nameAsset = nameAsset;
	}
	public final void setSstCharge(String sstCharge) {
		this.sstCharge = sstCharge;
	}
	public final void setCostImprovement(String costImprovement) {
		this.costImprovement = costImprovement;
	}
	public final void setSaleConsideration(String saleconsideartion) {
		this.saleConsideration = saleconsideartion;
	}
	public final void setCostIndexAcquisition(String costIndexAcquisition) {
		this.costIndexAcquisition = costIndexAcquisition;
	}

	public final void setCostIndexConsideration(String costIndexConsideration) {
		this.costIndexConsideration = costIndexConsideration;
	}
	public final void setCapitalGain(String capitalGain) {
		this.capitalGain = capitalGain;
	}
	public final void setIndexedprice(String indexedprice) {
		this.indexedprice = indexedprice;
	}
	public final void setCapitalGainTaxLT(String capitalGainTaxLT) {
		this.capitalGainTaxLT = capitalGainTaxLT;
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



	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			if(log.isInfoEnabled()){
				log.warn("this is Contact bean");
			}

			node.setProperty("mootlywcm:year_acquisition", getDateAcquisition());
			node.setProperty("mootlywcm:nameasset", getNameAsset());
			node.setProperty("mootlywcm:sstcharge", getSstCharge());
			node.setProperty("mootlywcm:assettype", getAssetType());
			if(getCostAcquisition()!=null){
				node.setProperty("mootlywcm:cost_acquisition", getCostAcquisition());
			}
			if(getCostImprovement()!=null){
				node.setProperty("mootlywcm:costimprove", getCostImprovement());
			}

			node.setProperty("mootlywcm:year_sale", getDateSale());
			if(getSaleConsideration()!=null){
				node.setProperty("mootlywcm:sale_consideration", getSaleConsideration());}
			if(getIndexedprice()!=null){
				node.setProperty("mootlywcm:indexedprice", getIndexedprice());
			}
			if(getCostIndexAcquisition()!=null){
				node.setProperty("mootlywcm:inflation_acquisition",getCostIndexAcquisition());
			}
			if(getCostIndexAcquisition()!=null){
				node.setProperty("mootlywcm:inflation_consideration",getCostIndexConsideration());}
			if(getCapitalGain()!=null){
				node.setProperty("mootlywcm:capital_gain",getCapitalGain());
				//node.setProperty("mootlywcm:capitalgaintaxLT",getCapitalGainTaxLT());
			}


		}catch (RepositoryException re) {
			if(log.isInfoEnabled()){
				log.error("Binding Node Error",re);

			}
		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if(log.isInfoEnabled()){
			log.info("inside the function fill in the capital asset bean");
		}
		if (formMap == null) return;
		if (formMap.getField("date_acquisition") != null)
			setDateAcquisition(formMap.getField("date_acquisition").getValue());
		if (formMap.getField("sst_charge") != null)
			setSstCharge(formMap.getField("sst_charge").getValue());
		if (formMap.getField("nameasset") != null)
			setNameAsset(formMap.getField("nameasset").getValue());
		if (formMap.getField("asset_type") != null)
			setAssetType(formMap.getField("asset_type").getValue());
		if (formMap.getField("cost_acquisition") != null) {
			setCostAcquisition(formMap.getField("cost_acquisition").getValue());
		}
		if (formMap.getField("cost_improvement").getValue().isEmpty()) {

		}else{
			setCostImprovement(formMap.getField("cost_improvement").getValue());
		}
		if (formMap.getField("inflation_acquisition") != null) {
			setCostIndexAcquisition(formMap.getField("inflation_acquisition").getValue());

		}
		if (formMap.getField("inflation_consideration") != null) {
			setCostIndexConsideration(formMap.getField("inflation_consideration").getValue());

		}
		if (formMap.getField("date_sale") != null)
			setDateSale(formMap.getField("date_sale").getValue());
		if (formMap.getField("sale_consideration") != null) {
			setSaleConsideration(formMap.getField("sale_consideration").getValue());
		}
		if (formMap.getField("capital_gain") != null) {
			setCapitalGain(formMap.getField("capital_gain").getValue());
		}
		if (formMap.getField("indexed_price") != null) {
			setIndexedprice(formMap.getField("indexed_price").getValue());
			log.info("at  the end of the function fill in the capital asset bean"+formMap.getField("indexed_price").getValue());
		}
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {

		// TODO Auto-generated method stub
		CapitalAssetDetail objCapitalAssetdetail = (CapitalAssetDetail) sourceBean;
		setDateAcquisition(objCapitalAssetdetail.getDateAcquisition());
		setCostAcquisition(objCapitalAssetdetail.getCostAcquisition());
		setDateSale(objCapitalAssetdetail.getDateSale());
		setSaleConsideration(objCapitalAssetdetail.getSaleConsideration());
		setCostIndexAcquisition(objCapitalAssetdetail.getCostIndexConsideration());
		setCostIndexConsideration(objCapitalAssetdetail.getCostIndexConsideration());
		setCapitalGain(objCapitalAssetdetail.getCapitalGain());
		setIndexedprice(objCapitalAssetdetail.getIndexedprice());
		setCapitalGainTaxLT(objCapitalAssetdetail.getCapitalGainTaxLT());
		setAssetType(objCapitalAssetdetail.getAssetType());
		setNameAsset(objCapitalAssetdetail.getNameAsset());
		setCostImprovement(objCapitalAssetdetail.getCostImprovement());
		setSstCharge(objCapitalAssetdetail.getSstCharge());

	}

}
