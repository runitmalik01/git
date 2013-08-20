/**
  * @author  abhishek bhardwaj
 * @since 08/07/2013
 * Description: This is bean file which save data of capital asset form
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


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:capitalassetdetail") 

@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class CapitalAssetDetail extends CapitalAssetDetailA implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:capitalassetdetail";
	static final public String NODE_NAME = CapitalAssetDetail.class.getName().toLowerCase();

	private final static Logger log = LoggerFactory.getLogger(CapitalAssetDetail.class); 

	// in this class we are inherit the capitalssetdetailA class for setter and getter method

	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub

		try {
			if(log.isInfoEnabled()){
				log.warn("this is capitalasset bean");
			}

			// new fields for accural

			if(getUpto15St()!=null){
				node.setProperty("mootlywcm:upto15St", getUpto15St());
			}
			if(getUpto15Oth()!=null){
				node.setProperty("mootlywcm:upto15Oth", getUpto15Oth());
			}
			if(getUpto16St()!=null){
				node.setProperty("mootlywcm:upto16St", getUpto16St());
			}
			if(getUpto16Oth()!=null){
				node.setProperty("mootlywcm:upto16Oth", getUpto16Oth());
			}
			if(getUpto16decSt()!=null){
				node.setProperty("mootlywcm:upto16decSt", getUpto16decSt());
			}
			if(getUpto16DecOth()!=null){
				node.setProperty("mootlywcm:upto16DecOth", getUpto16DecOth());
			}
			if(getUpto31St()!=null){
				node.setProperty("mootlywcm:upto31St", getUpto31St());
			}
			if(getUpto31Oth()!=null){
				node.setProperty("mootlywcm:upto31Oth", getUpto31Oth());
			}
			if(getUpto15Lt()!=null){
				node.setProperty("mootlywcm:upto15Lt", getUpto15Lt());
			}
			if(getUpto15Np()!=null){
				node.setProperty("mootlywcm:upto15Np", getUpto15Np());
			}
			if(getUpto16Lt()!=null){
				node.setProperty("mootlywcm:upto16Lt", getUpto16Lt());
			}
			if(getUpto16Np()!=null){
				node.setProperty("mootlywcm:upto16Np", getUpto16Np());
			}
			if(getUpto16DecLt()!=null){
				node.setProperty("mootlywcm:upto16DecLt", getUpto16DecLt());
			}
			if(getUptodecNp()!=null){
				node.setProperty("mootlywcm:uptodecNp", getUptodecNp());
			}
			if(getUpto31Lt()!=null){
				node.setProperty("mootlywcm:upto31Lt", getUpto31Lt());
			}
			if(getUpto31Np()!=null){
				node.setProperty("mootlywcm:upto31Np", getUpto31Np());
			}

			// end property fields for accural

			if(getDateAcquisition()!=null){
				node.setProperty("mootlywcm:year_acquisition", getDateAcquisition());
			}
			if(getNameAsset()!=null){
				node.setProperty("mootlywcm:nameasset", getNameAsset());
			}
			if(getIndex()!=null){
				node.setProperty("mootlywcm:index", getIndex());
			}
			if(getPan()!=null){
				node.setProperty("mootlywcm:pan", getPan());
			}
			if(getAccural()!=null){
				node.setProperty("mootlywcm:accural", getAccural());
			}
			if(getSstCharge()!=null){
				node.setProperty("mootlywcm:sstcharge", getSstCharge());
			}
			if(getAssetType()!=null){
				node.setProperty("mootlywcm:assettype", getAssetType());
			}
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
				node.setProperty("mootlywcm:year_sale", getDateSale());
			}
			if(getSaleConsideration()!=null){
				node.setProperty("mootlywcm:sale_consideration", getSaleConsideration());
			}
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
						if(log.isInfoEnabled()){
							log.info("would b longterm gain ");
						}
						Double ltgain=getCapitalGain();
						setCapitalGainTaxLT(ltgain);
						node.setProperty("mootlywcm:lgain",getCapitalGainTaxLT());
					}
					else
					{
						if(log.isInfoEnabled()){
							log.info("would b shortterm gain ");
						}
						Double sgain=getCapitalGain();
						setCapitalGainTaxST(sgain);
						node.setProperty("mootlywcm:sgain",getCapitalGainTaxST());
					}	
				}
				else
				{
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
		double amtA=0.0d;

		if (formMap.getField("date_acquisition") != null)
		{
			String strDate = formMap.getField("date_acquisition").getValue();
			setDateAcquisition(ConvDateStringToCalendar(strDate));
		}
		if (formMap.getField("months") != null)
		{
			setMonths(formMap.getField("months").getValue());
		}
		if (formMap.getField("sst_charge") != null){
			setSstCharge(formMap.getField("sst_charge").getValue());
		}
		if (formMap.getField("nameasset") != null)
		{
			setNameAsset(formMap.getField("nameasset").getValue());
		}
		if (formMap.getField("asset_type") != null)
		{
			setAssetType(formMap.getField("asset_type").getValue());
		}
		if (formMap.getField("panifded") != null)
		{
			setPan(formMap.getField("panifded").getValue());
		}
		if (formMap.getField("costacquisition").getValue().isEmpty()) {
			setCostAcquisition(amtA);}
		else{

			Double strcostacquisition = Double.parseDouble(formMap.getField("costacquisition").getValue());
			setCostAcquisition(strcostacquisition);
		}
		if (formMap.getField("costimprovement").getValue().isEmpty()) {
			setCostImprovement(amtA);
		}
		else{
			Double strcostimprovement = Double.parseDouble(formMap.getField("costimprovement").getValue());
			setCostImprovement(strcostimprovement);
		}
		if (formMap.getField("costtrnsfr").getValue().isEmpty()) {
			setCostTranfer(amtA);
		}
		else{
			Double strcosttrnsfr = Double.parseDouble(formMap.getField("costtrnsfr").getValue());
			setCostTranfer(strcosttrnsfr);
		}
		if (formMap.getField("date_sale") != null){

			String strdate = formMap.getField("date_sale").getValue();
			setDateSale(ConvDateStringToCalendar(strdate));
		}

		if (formMap.getField("saleconsideration").getValue().isEmpty()) {
			setSaleConsideration(amtA);
		}else{
			Double strsaleconsideration = Double.parseDouble(formMap.getField("saleconsideration").getValue());
			setSaleConsideration(strsaleconsideration);
		}
		if (formMap.getField("capitalgain") != null) {
			Double strdate = Double.parseDouble(formMap.getField("capitalgain").getValue());
			setCapitalGain(strdate);
		}
		if (formMap.getField("index") != null) {
			setIndex(formMap.getField("index").getValue());
		}
		if (formMap.getField("accural_info") != null) {
			setIndex(formMap.getField("accural_info").getValue());
		}
		if (formMap.getField("dedsec54") != null) {
			Double strdate = Double.parseDouble(formMap.getField("dedsec54").getValue());
			setDed_sec54(strdate);
		}

		if (formMap.getField("asset111").getValue().isEmpty()) {
			setAsset_111(amtA);
		}else
		{
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
			setLoss_sec94(amtA);}
		else{
			Double strdate = Double.parseDouble(formMap.getField("losssec94").getValue());
			setLoss_sec94(strdate);
		}
		if (formMap.getField("section48").getValue().isEmpty()) {
			setSection48(amtA);
		}
		else
		{
			Double strdate = Double.parseDouble(formMap.getField("section48").getValue());
			setSection48(strdate);
		}
		if (formMap.getField("balanc").getValue().isEmpty()) {
			setBalance(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("balanc").getValue());
			setBalance(strdate);	
		}
		if (formMap.getField("unlstdsecurity").getValue().isEmpty()) {
			setUnlstdSecurity(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("unlstdsecurity").getValue());
			setUnlstdSecurity(strdate);	
		}
		if (formMap.getField("amtdeemed") .getValue().isEmpty()) {
			setAmtdeemed(amtA);}
		else{

			Double strdate = Double.parseDouble(formMap.getField("amtdeemed").getValue());
			setAmtdeemed(strdate);
		}

		// form map for accural fields

		if (formMap.getField("upto15st").getValue().isEmpty()) {
			setUpto15St(amtA);
		}else
		{

			Double strdate = Double.parseDouble(formMap.getField("upto15st").getValue());
			setUpto15St(strdate);
		}
		if (formMap.getField("upto15oth").getValue().isEmpty()) {
			setUpto15Oth(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto15oth").getValue());
			setUpto15Oth(strdate);	
		}
		if (formMap.getField("upto16st").getValue().isEmpty()) {
			setUpto16St(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto16st").getValue());
			setUpto16St(strdate);	
		}
		if (formMap.getField("upto16oth").getValue().isEmpty()) {
			setUpto16Oth(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto16oth").getValue());
			setUpto16Oth(strdate);
		}

		if (formMap.getField("upto16decst").getValue().isEmpty()) {
			setUpto16decSt(amtA);
		}else
		{

			Double strdate = Double.parseDouble(formMap.getField("upto16decst").getValue());
			setUpto16decSt(strdate);
		}
		if (formMap.getField("upto16decoth").getValue().isEmpty()) {
			setUpto16DecOth(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto16decoth").getValue());
			setUpto16DecOth(strdate);	
		}
		if (formMap.getField("upto31st").getValue().isEmpty()) {
			setUpto31St(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto31st").getValue());
			setUpto31St(strdate);	
		}
		if (formMap.getField("upto31oth").getValue().isEmpty()) {
			setUpto31Oth(amtA);
		}else{


			Double strdate = Double.parseDouble(formMap.getField("upto31oth").getValue());
			setUpto31Oth(strdate);
		}


		if (formMap.getField("upto15Lt").getValue().isEmpty()) {
			setUpto15Lt(amtA);
		}else
		{

			Double strdate = Double.parseDouble(formMap.getField("upto15Lt").getValue());
			setUpto15Lt(strdate);
		}
		if (formMap.getField("upto15np").getValue().isEmpty()) {
			setUpto15Np(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto15np").getValue());
			setUpto15Np(strdate);	
		}
		if (formMap.getField("upto16Lt").getValue().isEmpty()) {
			setUpto16Lt(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto16Lt").getValue());
			setUpto16Lt(strdate);	
		}
		if (formMap.getField("upto16np").getValue().isEmpty()) {
			setUpto16Np(amtA);
		}
		else{

			Double strdate = Double.parseDouble(formMap.getField("upto16np").getValue());
			setUpto16Np(strdate);
		}

		if (formMap.getField("upto16decLt").getValue().isEmpty()) {
			setUpto16DecLt(amtA);
		}else
		{

			Double strdate = Double.parseDouble(formMap.getField("upto16decLt").getValue());
			setUpto16DecLt(strdate);
		}
		if (formMap.getField("uptodecnp").getValue().isEmpty()) {
			setUptodecNp(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("uptodecnp").getValue());
			setUptodecNp(strdate);	
		}
		if (formMap.getField("upto31Lt").getValue().isEmpty()) {
			setUpto31Lt(amtA);
		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto31Lt").getValue());
			setUpto31Lt(strdate);	
		}
		if (formMap.getField("upto31np").getValue().isEmpty()) {
			setUpto31Np(amtA);

		}else{

			Double strdate = Double.parseDouble(formMap.getField("upto31np").getValue());
			setUpto31Np(strdate);
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
		setIndex(objCapitalAssetdetail.getIndex());
		setPan(objCapitalAssetdetail.getPan());
		setAccural(objCapitalAssetdetail.getAccural());
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
		// acrrual fields
		setUpto15Lt(objCapitalAssetdetail.getUpto15Lt());
		setUpto15Np(objCapitalAssetdetail.getUpto15Np());
		setUpto15Oth(objCapitalAssetdetail.getUpto15Oth());
		setUpto15St(objCapitalAssetdetail.getUpto15St());
		setUpto16DecLt(objCapitalAssetdetail.getUpto16DecLt());
		setUpto16DecOth(objCapitalAssetdetail.getUpto16DecOth());
		setUpto16decSt(objCapitalAssetdetail.getUpto16decSt());
		setUpto16Lt(objCapitalAssetdetail.getUpto16Lt());
		setUpto16Np(objCapitalAssetdetail.getUpto16Np());
		setUpto16Oth(objCapitalAssetdetail.getUpto16Oth());
		setUpto31Lt(objCapitalAssetdetail.getUpto31Lt());
		setUpto16St(objCapitalAssetdetail.getUpto16St());
		setUpto31Oth(objCapitalAssetdetail.getUpto31Oth());
		setUpto31St(objCapitalAssetdetail.getUpto31St());
		setUptodecNp(objCapitalAssetdetail.getUptodecNp());
		setUpto31Np(objCapitalAssetdetail.getUpto31Np());

	}
}


