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
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.sound.midi.MidiDevice.Info;


import org.apache.commons.lang.StringUtils;
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
import com.mootly.wcm.member.MonthCalculate;


/**
 * @author  abhishek bhardwaj
 * @since 08/07/2013
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
	private GregorianCalendar dateAcquisition;
	private String nameAsset;
	private String assetType;
	private String months;
	private Double costImprovement;
	private String sstCharge;
	private Double costAcquisition;
	private GregorianCalendar dateSale;
	private String costIndexAcquisition;
	private String saleConsideration;
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
	public final void setSaleConsideration(String saleconsideartion) {
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
			if(getDateAcquisition()!=null){
				node.setProperty("mootlywcm:year_acquisition", getDateAcquisition());
			}
			if(getNameAsset()!=null){
				node.setProperty("mootlywcm:nameasset", getNameAsset());
			}if(getSstCharge()!=null){
				node.setProperty("mootlywcm:sstcharge", getSstCharge());}
			if(getAssetType()!=null){


				node.setProperty("mootlywcm:assettype", getAssetType());}
			if(getMonths()!=null){


				node.setProperty("mootlywcm:months", getMonths());	}

			if(getCostAcquisition()!=null){
				node.setProperty("mootlywcm:cost_acquisition", getCostAcquisition());
			}
			if(getCostImprovement()!=null){
				node.setProperty("mootlywcm:costimprove", getCostImprovement());
			}
			if(getBalance()!=null){
				node.setProperty("mootlywcm:balance", getBalance());
			}
			if(getUnlstdSecurity()!=null){
				node.setProperty("mootlywcm:ulsecurty", getUnlstdSecurity());
			}
			if(getDed_sec54()!=null){
				node.setProperty("mootlywcm:dedsec54", getDed_sec54());
			}
			if(getAmtdeemed()!=null){
				node.setProperty("mootlywcm:amtdeemed", getAmtdeemed());
			}
			if(getSection48()!=null){
				node.setProperty("mootlywcm:section48", getSection48());
			}
			if(getAsset_111()!=null){
				node.setProperty("mootlywcm:asset111", getAsset_111());
			}
			if(getAssetnt111()!=null){
				node.setProperty("mootlywcm:assetnt111", getAssetnt111());
			}
			if(getLoss_sec94()!=null){
				node.setProperty("mootlywcm:losssec94", getLoss_sec94());
			}
			if(getCostTransfer()!=null){
				node.setProperty("mootlywcm:costTransfer", getCostTransfer());
			}
			if(getDateSale()!=null){
				node.setProperty("mootlywcm:year_sale", getDateSale());}
			if(getSaleConsideration()!=null){
				node.setProperty("mootlywcm:sale_consideration", getSaleConsideration());}
			if(getIndexedprice()!=null){
				node.setProperty("mootlywcm:indexedprice", getIndexedprice());
			}
			if(getCostIndexAcquisition()!=null){
				node.setProperty("mootlywcm:inflation_acquisition",getCostIndexAcquisition());
			}
			if(getCostIndexAcquisition()!=null){
				node.setProperty("mootlywcm:inflation_consideration",getCostIndexConsideration());
			}
			if(getCapitalGain()!=null)
			{
				if(getAssetType().equals("SHARES")){

					String mnths=getMonths();
					double d=Double.parseDouble(mnths);
					if(d>365){
						log.info("would b longterm gain ");
						Double ltgain=getCapitalGain();
						setCapitalGainTaxLT(ltgain);
						node.setProperty("mootlywcm:lgain",getCapitalGainTaxLT());
						//return ltgain;
					}else
					{
						log.info("would b shortterm gain ");
						Double sgain=getCapitalGain();
						setCapitalGainTaxST(sgain);
						node.setProperty("mootlywcm:sgain",getCapitalGainTaxST());
					}	
				}
				else{
					if(log.isInfoEnabled()){
						String mnths=getMonths();
						double d=Double.parseDouble(mnths);
						if(d>(365*3)){
							log.info("we ar in long tems gain"+d);
							Double ltgain=getCapitalGain();
							setCapitalGainTaxLT(ltgain);
							node.setProperty("mootlywcm:lgain",getCapitalGainTaxLT());
						}else{
							Double sgain=getCapitalGain();
							setCapitalGainTaxST(sgain);
							node.setProperty("mootlywcm:sgain",getCapitalGainTaxST());

						}

					}

				}

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
		if (formMap.getField("date_acquisition") != null){
			log.info("here date is"+ formMap.getField("date_acquisition").getValue());
			String strDate = formMap.getField("date_acquisition").getValue();
			setDateAcquisition(ConvDateStringToCalendar(strDate));}
		if (formMap.getField("months") != null)
			log.info("value of months is"+formMap.getField("months").getValue());
		setMonths(formMap.getField("months").getValue());
		if (formMap.getField("sst_charge") != null)
			setSstCharge(formMap.getField("sst_charge").getValue());
		log.info("value of months is"+formMap.getField("sst_charge").getValue());
		if (formMap.getField("nameasset") != null)
			log.info("value of months is"+formMap.getField("nameasset").getValue());
		setNameAsset(formMap.getField("nameasset").getValue());

		if (formMap.getField("asset_type") != null)
			log.info("value of months is"+formMap.getField("asset_type").getValue());
		setAssetType(formMap.getField("asset_type").getValue());

		if (formMap.getField("costacquisition") != null) {
			log.info("value of months is"+formMap.getField("costacquisition").getValue());
			Double strcostacquisition = Double.parseDouble(formMap.getField("costacquisition").getValue());
			setCostAcquisition(strcostacquisition);
		}
		if (formMap.getField("costimprovement") !=null) {
			log.info("value of imprve is"+formMap.getField("costimprovement").getValue());
			Double strcostimprovement = Double.parseDouble(formMap.getField("costimprovement").getValue());
			setCostImprovement(strcostimprovement);
		}
		if (formMap.getField("costtrnsfr") != null) {
			log.info("value trnsfr is"+formMap.getField("costtrnsfr").getValue());
			Double strcosttrnsfr = Double.parseDouble(formMap.getField("costtrnsfr").getValue());
			setCostTranfer(strcosttrnsfr);
		}
		/*if (formMap.getField("inflation_acquisition") != null) {
			setCostIndexAcquisition(formMap.getField("inflation_acquisition").getValue());

		}
		if (formMap.getField("inflation_consideration") != null) {
			setCostIndexConsideration(formMap.getField("inflation_consideration").getValue());

		}*/
		if (formMap.getField("date_sale") != null){
			log.info("date is"+formMap.getField("date_sale").getValue());
			String strdate = formMap.getField("date_sale").getValue();
			setDateSale(ConvDateStringToCalendar(strdate));
		}

		if (formMap.getField("saleconsideration") != null) {
			log.info("value of "+formMap.getField("saleconsideration").getValue());
			setSaleConsideration(formMap.getField("saleconsideration").getValue());
		}
		if (formMap.getField("capitalgain") != null) {
			log.info("value of  is"+formMap.getField("capitalgain").getValue());
			Double strdate = Double.parseDouble(formMap.getField("capitalgain").getValue());
			setCapitalGain(strdate);
		}
		/*if (formMap.getField("indexed_price") != null) {
			Double strindexedprice = Double.parseDouble(formMap.getField("indexed_price").getValue());
			setIndexedprice(strindexedprice);
		}*/
		if (formMap.getField("dedsec54") != null) {
			log.info("value of  is"+formMap.getField("dedsec54").getValue());
			Double strdate = Double.parseDouble(formMap.getField("dedsec54").getValue());
			setDed_sec54(strdate);
		}
		double amtA=0.0d;
		if (formMap.getField("asset111").getValue().isEmpty()) {
			setAsset_111(amtA);
		}else{
			Double strdate = Double.parseDouble(formMap.getField("asset111").getValue());
			setAsset_111(strdate);
		}
		if (formMap.getField("assetnt111").getValue().isEmpty()) {
			setAssetnt111(amtA);}
		else{
			Double strdate = Double.parseDouble(formMap.getField("assetnt111").getValue());
			setAssetnt111(strdate);
		}
		if (formMap.getField("losssec94").getValue().isEmpty()) {
			setLoss_sec94(amtA);}else{
				log.info("value of  is"+formMap.getField("losssec94").getValue());
				Double strdate = Double.parseDouble(formMap.getField("losssec94").getValue());
				setLoss_sec94(strdate);
			}
		if (formMap.getField("section48").getValue().isEmpty()) {
			setSection48(amtA);
		}else
		{
			log.info("value of  is"+formMap.getField("section48").getValue());
			Double strdate = Double.parseDouble(formMap.getField("section48").getValue());
			setSection48(strdate);
		}
		if (formMap.getField("balanc").getValue().isEmpty()) {
			setBalance(amtA);
		}else{
			log.info("value of  is"+formMap.getField("balanc").getValue());
			Double strdate = Double.parseDouble(formMap.getField("balanc").getValue());
			setBalance(strdate);	
		}
		if (formMap.getField("unlstdsecurity").getValue().isEmpty()) {
			setUnlstdSecurity(amtA);
		}else{
			log.info("value of  is"+formMap.getField("unlstdsecurity").getValue());
			Double strdate = Double.parseDouble(formMap.getField("balanc").getValue());
			setUnlstdSecurity(strdate);	
		}
		if (formMap.getField("amtdeemed") != null) {
			log.info("value of  is"+formMap.getField("amtdeemed").getValue());
			Double strdate = Double.parseDouble(formMap.getField("amtdeemed").getValue());
			setAmtdeemed(strdate);
		}
	}
	private GregorianCalendar ConvDateStringToCalendar(String strDate){
		Date date = null ;
		DateFormat formatter = getIndianDateFormatter();
		GregorianCalendar cal=null;
		if(StringUtils.isNotEmpty(strDate)){
			cal=(GregorianCalendar) GregorianCalendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate);
				cal.setTime(date);
			}
			catch(Exception e){
				log.error("calendar error"+e);
			}
			return cal;
		}else return null;

	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {

		// TODO Auto-generated method stub
		CapitalAssetDetail objCapitalAssetdetail = (CapitalAssetDetail) sourceBean;
		setDateAcquisition(objCapitalAssetdetail.getDateAcquisition());
		setCostAcquisition(objCapitalAssetdetail.getCostAcquisition());
		setDateSale(objCapitalAssetdetail.getDateSale());
		setSaleConsideration(objCapitalAssetdetail.getSaleConsideration());
		setCostIndexAcquisition(objCapitalAssetdetail.getCostIndexAcquisition());
		setCostIndexConsideration(objCapitalAssetdetail.getCostIndexConsideration());
		setCapitalGain(objCapitalAssetdetail.getCapitalGain());
		setIndexedprice(objCapitalAssetdetail.getIndexedprice());
		setCapitalGainTaxLT(objCapitalAssetdetail.getCapitalGainTaxLT());
		setCapitalGainTaxST(objCapitalAssetdetail.getCapitalGainTaxST());
		setAssetType(objCapitalAssetdetail.getAssetType());
		setNameAsset(objCapitalAssetdetail.getNameAsset());
		setCostImprovement(objCapitalAssetdetail.getCostImprovement());
		setCostTranfer(objCapitalAssetdetail.getCostTransfer());
		setSstCharge(objCapitalAssetdetail.getSstCharge());
		setDed_sec54(objCapitalAssetdetail.getDed_sec54());
		setSection48(objCapitalAssetdetail.getSection48());
		setAmtdeemed(objCapitalAssetdetail.getAmtdeemed());
		setAsset_111(objCapitalAssetdetail.getAsset_111());
		setAssetnt111(objCapitalAssetdetail.getAssetnt111());
		setBalance(objCapitalAssetdetail.getBalance());
		setUnlstdSecurity(objCapitalAssetdetail.getUnlstdSecurity());
		setLoss_sec94(objCapitalAssetdetail.getLoss_sec94());

	}
	public  void findGainType(){
		String gainType="";

		if(getAssetType().equals("SHARES")){
			String mnths=getMonths();
			double d=Double.parseDouble(mnths);
			if(d>365){
				log.info("would b longterm gain ");
				Double ltgain=getCapitalGain();
				setCapitalGainTaxLT(ltgain);
				//return ltgain;
			}else
			{
				log.info("would b shortterm gain ");
				Double sgain=getCapitalGain();
				setCapitalGainTaxST(sgain);

				log.info("value of lterm isssssss"+sgain);
			}	
		}
		else{
			if(log.isInfoEnabled()){
				log.info("we are working for it..........");
				String mnths=getMonths();
				double d=Double.parseDouble(mnths);
				//double d=Double.parseDouble(new DecimalFormat("##.#").format(val));

				if(d>(365*3)){
					log.info("we ar in long tems gain"+d);
					Double ltgain=getCapitalGain();
					setCapitalGainTaxLT(ltgain);


				}else{
					Double sgain=getCapitalGain();
					setCapitalGainTaxST(sgain);

				}

			}

		}

	}
}


