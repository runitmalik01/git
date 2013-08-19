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
 * @author  abhishek bhardwaj
 * @since 08/07/2013
 * Description: This is bean file which save data of capital asset form
 */
package com.mootly.wcm.beans.compound;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormMapFiller;



public abstract class CapitalAssetDetailA extends HippoItem implements FormMapFiller {
	static final public String NODE_NAME = CapitalAssetDetailA.class.getName().toLowerCase();

	private final static Logger log = LoggerFactory.getLogger(CapitalAssetDetailA.class); 

	private GregorianCalendar dateAcquisition;
	private String nameAsset;
	private String assetType;
	private String accural;
	private String index;
	private String pan;
	private String months;
	private Double costImprovement;
	private String sstCharge;
	private Double costAcquisition;
	private GregorianCalendar dateSale;
	private String costIndexAcquisition;
	private Double saleConsideration;
	private String costIndexConsideration;
	private Double capitalGain;
	private Double capitalGainTaxLT;
	private Double capitalGainTaxST;
	private Double indexedprice;
	private Double costTransfer;
	private Double asset_111;
	private Double assetnt111;
	private Double amtdeemed;
	private Double balance;
	private Double loss_sec94;
	private Double ded_sec54;
	private Double section48;
	private Double unlstdSecurity;
	private String personalInfoUuid;
	// new fields for accural
	private Double upto15St;
	private Double upto15Oth;
	private Double upto16St;
	private Double upto16Oth;
	private Double upto16decSt;
	private Double upto16DecOth;
	private Double upto31St;
	private Double upto31Oth;
	private Double upto15Lt;
	private Double upto15Np;
	private Double upto16Lt;
	private Double upto16Np;
	private Double upto16DecLt;
	private Double uptodecNp;
	private Double upto31Lt;
	private Double upto31Np;
	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	public GregorianCalendar getDateAcquisition() {
		if (dateAcquisition == null) dateAcquisition = getProperty("mootlywcm:year_acquisition");
		return dateAcquisition;
	}
	public String getDateAcquisitionStr() {
		if (dateAcquisition == null) dateAcquisition = getProperty("mootlywcm:year_acquisition");
		if (dateAcquisition != null) {

			String dateAcquisitionStr = getIndianDateFormatter().format(dateAcquisition.getTime());
			return dateAcquisitionStr;
		}
		return null;
	}
	public static final SimpleDateFormat getIndianDateFormatter() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}
	public String getAssetType() {
		if (assetType == null) assetType = getProperty("mootlywcm:assettype");
		return assetType;
	}
	public String getIndex() {
		if (index == null) index = getProperty("mootlywcm:index");
		return index;
	}
	public String getPan() {
		if (pan == null) pan = getProperty("mootlywcm:pan");
		return pan;
	}
	public String getAccural() {
		if (accural == null) accural = getProperty("mootlywcm:accural");
		return accural;
	}
	public String getMonths() {
		if (months == null) months = getProperty("mootlywcm:months");
		return months;
	}
	public String getSstCharge() {
		if (sstCharge == null) sstCharge = getProperty("mootlywcm:sstcharge");
		return sstCharge;
	}
	public Double getCostImprovement() {
		if (costImprovement == null) costImprovement = getProperty("mootlywcm:costimprove");
		return costImprovement;
	}
	public String getNameAsset() {
		if (nameAsset == null) nameAsset = getProperty("mootlywcm:nameasset");
		return nameAsset;
	}
	public Double getCostAcquisition() {
		if (costAcquisition == null) costAcquisition = getProperty("mootlywcm:cost_acquisition");
		return costAcquisition;
	}
	public Double getIndexedprice() {
		if (indexedprice == null) indexedprice = getProperty("mootlywcm:indexedprice");
		return indexedprice;
	}
	public GregorianCalendar getDateSale() {
		if (dateSale == null) dateSale = getProperty("mootlywcm:year_sale");
		return dateSale;
	}

	public String getDatesaleStr() {
		if (dateSale == null) dateSale = getProperty("mootlywcm:year_sale");
		if (dateSale != null) {
			String datesaleStr = getIndianDateFormatter().format(dateSale.getTime());
			return datesaleStr;
		}
		return null;
	}
	public Double getSaleConsideration() {
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
	public Double getCapitalGain() {
		if (capitalGain == null) capitalGain = getProperty("mootlywcm:capital_gain");
		return capitalGain;
	}

	public Double getCapitalGainTaxLT() {
		if (capitalGainTaxLT == null) capitalGainTaxLT = getProperty("mootlywcm:lgain");
		return capitalGainTaxLT;
	}
	public Double getAmtdeemed() {
		if (amtdeemed == null) amtdeemed = getProperty("mootlywcm:amtdeemed");
		return amtdeemed;
	}
	public Double getUnlstdSecurity() {
		if (unlstdSecurity == null) unlstdSecurity = getProperty("mootlywcm:unlstdsecutry");
		return unlstdSecurity;
	}
	public Double getBalance() {
		if (balance == null) balance = getProperty("mootlywcm:balance");
		return balance;
	}
	public Double getAsset_111() {
		if (asset_111 == null) asset_111 = getProperty("mootlywcm:asset111");
		return asset_111;
	}

	public Double getAssetnt111() {
		if (assetnt111 == null) assetnt111 = getProperty("mootlywcm:assetnt111");
		return assetnt111;
	}
	public Double getCapitalGainTaxST() {
		if (capitalGainTaxST == null) capitalGainTaxST = getProperty("mootlywcm:sgain");
		return capitalGainTaxST;
	}
	public Double getCostTransfer() {
		if (costTransfer == null) costTransfer = getProperty("mootlywcm:costTransfer");
		return costTransfer;
	}
	public Double getLoss_sec94() {
		if (loss_sec94 == null) loss_sec94 = getProperty("mootlywcm:losssec94");
		return loss_sec94;
	}
	public Double getDed_sec54() {
		if (ded_sec54 == null) ded_sec54 = getProperty("mootlywcm:dedsec54");
		return ded_sec54;
	}
	public Double getSection48() {
		if (section48 == null) section48 = getProperty("mootlywcm:section48");
		return section48;
	}
	// new fields for getting accural options


	public Double getUpto15St() {
		if (upto15St == null) upto15St = getProperty("mootlywcm:upto15St");
		return upto15St;
	}
	public Double getUpto15Oth() {
		if (upto15Oth == null) upto15Oth = getProperty("mootlywcm:upto15Oth");
		return upto15Oth;
	}

	public Double getUpto16St() {
		if (upto16St == null) upto16St = getProperty("mootlywcm:upto16St");
		return upto16St;
	}
	public Double getUpto16Oth() {
		if (upto16Oth == null) upto16Oth = getProperty("mootlywcm:upto16Oth");
		return upto16Oth;
	}
	public Double getUpto16decSt() {
		if (upto16decSt == null) upto16decSt = getProperty("mootlywcm:upto16decSt");
		return upto16decSt;
	}
	public Double getUpto16DecOth() {
		if (upto16DecOth == null) upto16DecOth = getProperty("mootlywcm:upto16DecOth");
		return upto16DecOth;
	}
	public Double getUpto31St() {
		if (upto31St == null) upto31St = getProperty("mootlywcm:upto31St");
		return upto31St;
	}
	public Double getUpto31Oth() {
		if (upto31Oth == null) upto31Oth = getProperty("mootlywcm:upto31Oth");
		return upto31Oth;
	}
	public Double getUpto15Lt() {
		if (upto15Lt == null) upto15Lt = getProperty("mootlywcm:upto15Lt");
		return upto15Lt;
	}
	public Double getUpto15Np() {
		if (upto15Np == null) upto15Np = getProperty("mootlywcm:upto15Np");
		return upto15Np;
	}
	public Double getUpto16Lt() {
		if (upto16Lt == null) upto16Lt = getProperty("mootlywcm:upto16Lt");
		return upto16Lt;
	}
	public Double getUpto16Np() {
		if (upto16Np == null) upto16Np = getProperty("mootlywcm:upto16Np");
		return upto16Np;
	}
	public Double getUpto16DecLt() {
		if (upto16DecLt == null) upto16DecLt = getProperty("mootlywcm:upto16DecLt");
		return upto16DecLt;
	}
	public Double getUptodecNp() {
		if (uptodecNp == null) uptodecNp = getProperty("mootlywcm:uptodecNp");
		return uptodecNp;
	}
	public Double getUpto31Lt() {
		if (upto31Lt == null) upto31Lt = getProperty("mootlywcm:upto31Lt");
		return upto31Lt;
	}
	public Double getUpto31Np() {
		if (upto31Np == null) upto31Np = getProperty("mootlywcm:upto31Np");
		return upto31Np;
	}
	public final String getPersonalInfoUuid() {
		return personalInfoUuid;
	}


	// here we are defining set methods

	public final void setDateAcquisition(GregorianCalendar dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}
	public final void setCostAcquisition(Double costAcquisition) {
		this.costAcquisition = costAcquisition;
	}
	public final void setDateSale(GregorianCalendar dateSale) {
		this.dateSale = dateSale;
	}
	public final void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public final void setIndex(String index) {
		this.index = index;
	}
	public final void setPan(String pan) {
		this.pan = pan;
	}
	public final void setAccural(String accural) {
		this.accural = accural;
	}
	public final void setMonths(String months) {
		this.months = months;
	}
	public final void setNameAsset(String nameAsset) {
		this.nameAsset = nameAsset;
	}
	public final void setSstCharge(String sstCharge) {
		this.sstCharge = sstCharge;
	}
	public final void setCostImprovement(Double costImprovement) {
		this.costImprovement = costImprovement;
	}
	public final void setSaleConsideration(Double saleconsideartion) {
		this.saleConsideration = saleconsideartion;
	}
	public final void setCostIndexAcquisition(String costIndexAcquisition) {
		this.costIndexAcquisition = costIndexAcquisition;
	}

	public final void setCostIndexConsideration(String costIndexConsideration) {
		this.costIndexConsideration = costIndexConsideration;
	}
	public final void setCapitalGain(Double capitalGain) {
		this.capitalGain = capitalGain;
	}
	public final void setIndexedprice(Double indexedprice) {
		this.indexedprice = indexedprice;
	}
	public final void setCapitalGainTaxLT(Double capitalGainTaxLT) {
		this.capitalGainTaxLT = capitalGainTaxLT;
	}
	public final void setCapitalGainTaxST(Double sgain) {
		this.capitalGainTaxST = sgain;
	}

	public final void setCostTranfer(Double costTransfer) {
		this.costTransfer = costTransfer;
	}
	public final void setAsset_111(Double asset_111) {
		this.asset_111 = asset_111;
	}
	public final void setAssetnt111(Double assetnt111) {
		this.assetnt111 = assetnt111;
	}
	public final void setBalance(Double balance) {
		this.balance = balance;
	}
	public final void setAmtdeemed(Double amtdeemed) {
		this.amtdeemed = amtdeemed;
	}
	public final void setUnlstdSecurity(Double unlstdSecurity) {
		this.unlstdSecurity = unlstdSecurity;
	}

	public final void setSection48(Double section48) {
		this.section48 = section48;
	}
	public final void setDed_sec54(Double ded_sec54) {
		this.ded_sec54 = ded_sec54;
	}
	public final void setLoss_sec94(Double loss_sec94) {
		this.loss_sec94 = loss_sec94;
	}

	// new fields for accural options


	public final void setUpto15St(Double upto15St) {
		this.upto15St = upto15St;
	}
	public final void setUpto15Oth(Double upto15Oth) {
		this.upto15Oth = upto15Oth;
	}
	public final void setUpto16St(Double upto16St) {
		this.upto16St = upto16St;
	}
	public final void setUpto16Oth(Double upto16Oth) {
		this.upto16Oth = upto16Oth;
	}
	public final void setUpto16decSt(Double upto16decSt) {
		this.upto16decSt = upto16decSt;
	}
	public final void setUpto16DecOth(Double upto16DecOth) {
		this.upto16DecOth = upto16DecOth;
	}
	public final void setUpto31St(Double upto31St) {
		this.upto31St = upto31St;
	}
	public final void setUpto31Oth(Double upto31Oth) {
		this.upto31Oth = upto31Oth;
	}
	public final void setUpto15Lt(Double upto15Lt) {
		this.upto15Lt = upto15Lt;
	}
	public final void setUpto15Np(Double upto15Np) {
		this.upto15Np = upto15Np;
	}
	public final void setUpto16Lt(Double upto16Lt) {
		this.upto16Lt = upto16Lt;
	}
	public final void setUpto16Np(Double upto16Np) {
		this.upto16Np = upto16Np;
	}

	public final void setUpto16DecLt(Double upto16DecLt) {
		this.upto16DecLt = upto16DecLt;
	}
	public final void setUptodecNp(Double uptodecNp) {
		this.uptodecNp = uptodecNp;
	}
	public final void setUpto31Lt(Double upto31Lt) {
		this.upto31Lt = upto31Lt;
	}

	public final void setUpto31Np(Double upto31Np) {
		this.upto31Np = upto31Np;
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


}


