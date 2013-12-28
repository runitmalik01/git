
/**
 * 
 * User: megha
 * Date: 
 * Time: 
 * 
 */


package com.mootly.wcm.beans;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:deemedcapitalgaindocument")
public class DeemedCapitalGainDocument extends BaseDocument implements ContentNodeBinder, FormMapFiller{
	static final public String NAMESPACE = "mootlywcm:deemedcapitalgaindocument";
	static final public String NODE_NAME = "deemedcapitalgaindocument";

	private Double ratefifteen;
	private Double ratethirty;
	private Double rateforty;
	private Double ratefifty;
	private Double ratesixty;
	private Double rateeighty;
	private Double ratehundred;
	private Double total;
	private Double ratefive;
	private Double rateten;
	private Double hundred;
	private Double total1;
	private Double furniture;
	private Double intangible;
	private Double ships;
	private Double total2;
	
	public  Double getRatefifteen() {
		if (ratefifteen == null) ratefifteen = getProperty("mootlywcm:ratefifteen");
		return ratefifteen;
	}
	public  Double getRatethirty() {
		if (ratethirty == null) ratethirty = getProperty("mootlywcm:ratethirty");
		return ratethirty;
	}
	
	public  Double getRateforty() {
		if (rateforty == null) rateforty = getProperty("mootlywcm:rateforty");
		return rateforty;
	}
	public  Double getRatefifty() {
		if (ratefifty == null) ratefifty = getProperty("mootlywcm:ratefifty");
		return ratefifty;
	}
	public  Double getRatesixty() {
		if (ratesixty == null) ratesixty = getProperty("mootlywcm:ratesixty");
		return ratesixty;
	}
	public  Double getRateeighty() {
		if (rateeighty == null) rateeighty = getProperty("mootlywcm:rateeighty");
		return rateeighty;
	}
	public  Double getRatehundred() {
		if (ratehundred == null) ratehundred = getProperty("mootlywcm:ratehundred");
		return ratehundred;
	}
	public Double getTotal() {
		if (total == null) total = getProperty("mootlywcm:total");
		return total;
	}
	public  Double getRatefive() {
		if (ratefive== null) ratefive = getProperty("mootlywcm:ratefive");
		return ratefive;
	}
	public  Double getRateten() {
		if (rateten== null) rateten = getProperty("mootlywcm:rateten");
		return rateten;
	}
	public  Double getHundred() {
		if (hundred== null) hundred = getProperty("mootlywcm:hundred");
		return hundred;
	}
	public  Double getTotal1() {
		if (total1== null) total1 = getProperty("mootlywcm:total1");
		return total1;
	}
	public  Double getFurniture() {
		if (furniture== null) furniture = getProperty("mootlywcm:furniture");
		return furniture;
	}
	public  Double getIntangible() {
		if (intangible== null) intangible = getProperty("mootlywcm:intangible");
		return intangible;
	}
	public  Double getTotal2() {
		if (total2== null) total2 = getProperty("mootlywcm:total2");
		return total2;
	}
	public  Double getShips() {
		if (ships== null) ships = getProperty("mootlywcm:ships");
		return ships;
	}
	
	//set
	
	public void setRatefifteen(Double ratefifteen) {
		this.ratefifteen = ratefifteen;
	}
	public void setRatethirty(Double ratethirty) {
		this.ratethirty = ratethirty;
	}
	public void setRateforty(Double rateforty) {
		this.rateforty = rateforty;
	}
	public void setRatefifty(Double ratefifty) {
		this.ratefifty = ratefifty;
	}
	public void setRatesixty(Double ratesixty) {
		this.ratesixty = ratesixty;
	}
	public void setRateeighty(Double rateeighty) {
		this.rateeighty = rateeighty;
	}
	public void setRatehundred(Double ratehundred) {
		this.ratehundred= ratehundred;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setRatefive(Double ratefive) {
		this.ratefive= ratefive;
	}
	public void setRateten(Double rateten) {
		this.rateten = rateten;
	}
	public void setHundred(Double hundred) {
		this.hundred = hundred;
	}
	public void setTotal1(Double total1) {
		this.total1 = total1;
	}
	public void setFurniture(Double furniture) {
		this.furniture = furniture;
	}
	public void setIntangible(Double intangible) {
		this.intangible = intangible;
	}
	public void setTotal2(Double total2) {
		this.total2 = total2;
	}
	public void setShips(Double ships) {
		this.ships = ships;
	}
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub   
		try{
			
		DeemedCapitalGainDocument objDeemedCapitalGainDocument= (DeemedCapitalGainDocument) content;
		
		node.setProperty("mootlywcm:ratefifteen",objDeemedCapitalGainDocument.getRatefifteen());
		node.setProperty("mootlywcm:ratethirty", objDeemedCapitalGainDocument.getRatethirty());
		node.setProperty("mootlywcm:rateforty", objDeemedCapitalGainDocument.getRateforty());
		node.setProperty("mootlywcm:ratefifty", objDeemedCapitalGainDocument.getRatefifty());
		node.setProperty("mootlywcm:ratesixty", objDeemedCapitalGainDocument.getRatesixty());
		node.setProperty("mootlywcm:rateeighty", objDeemedCapitalGainDocument.getRateeighty());
		node.setProperty("mootlywcm:ratehundred", objDeemedCapitalGainDocument.getRatehundred());
		node.setProperty("mootlywcm:total", objDeemedCapitalGainDocument.getTotal());
		node.setProperty("mootlywcm:ratefive", objDeemedCapitalGainDocument.getRatefive());
		node.setProperty("mootlywcm:rateten", objDeemedCapitalGainDocument.getRateten());
		node.setProperty("mootlywcm:hundred", objDeemedCapitalGainDocument.getHundred());
		node.setProperty("mootlywcm:total1", objDeemedCapitalGainDocument.getTotal1());
		node.setProperty("mootlywcm:furniture", objDeemedCapitalGainDocument.getFurniture());
		node.setProperty("mootlywcm:intangible", objDeemedCapitalGainDocument.getIntangible());
		node.setProperty("mootlywcm:ships", objDeemedCapitalGainDocument.getShips());
		node.setProperty("mootlywcm:total2", objDeemedCapitalGainDocument.getTotal2());
		
		
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}	
	
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		
		double val_ratefifteen=0.0d;
		if (formMap.getField("ratefifteen").getValue().isEmpty()) {
			setRatefifteen(val_ratefifteen);
		}
		else{
			String strRatefifteen=formMap.getField("ratefifteen").getValue();
			val_ratefifteen= Double.parseDouble(strRatefifteen);
			setRatefifteen(val_ratefifteen);
		}
		double val_ratethirty=0.0d;
		if (formMap.getField("ratethirty").getValue().isEmpty()) {
			setRatethirty(val_ratethirty);
		}
		else{
			String strRatethirty=formMap.getField("ratethirty").getValue();
			val_ratethirty= Double.parseDouble(strRatethirty);
			setRatethirty(val_ratethirty);
		}
         double val_rateforty=0.0d;
		if (formMap.getField("rateforty").getValue().isEmpty()){
			setRateforty(val_rateforty);
		}
		else{
			String strRateforty=formMap.getField("rateforty").getValue();
			val_rateforty= Double.parseDouble(strRateforty);
			setRateforty(val_rateforty);
		}
          double val_ratefifty=0.0d;
		if (formMap.getField("ratefifty").getValue().isEmpty()) {
			setRatefifty(val_ratefifty);
		}
		else{
			String strRatefifty=formMap.getField("ratefifty").getValue();
			val_ratefifty= Double.parseDouble(strRatefifty);
			setRatefifty(val_ratefifty);
		}
		double val_ratesixty=0.0d;
		if (formMap.getField("ratesixty").getValue().isEmpty()){
			setRatesixty(val_ratesixty);
		}
		else{
			String strRatesixty=formMap.getField("ratesixty").getValue();
			val_ratesixty= Double.parseDouble(strRatesixty);
			setRatesixty(val_ratesixty);
		}
		double val_rateeighty=0.0d;
		if (formMap.getField("rateeighty").getValue().isEmpty()){
			setRateeighty(val_rateeighty);
		}
		else{
			String strRateeighty=formMap.getField("rateeighty").getValue();
			val_rateeighty= Double.parseDouble(strRateeighty);
			setRateeighty(val_rateeighty);
		}
		double val_ratehundred=0.0d;
		if (formMap.getField("ratehundred").getValue().isEmpty()){
			setRatehundred(val_ratehundred);
		}
		else{
			String strRatehundred=formMap.getField("ratehundred").getValue();
			val_ratehundred= Double.parseDouble(strRatehundred);
			setRatehundred(val_ratehundred);
		}
		double val_total=0.0d;
		if (formMap.getField("total").getValue().isEmpty()){
			setTotal(val_total);
		}
		else{
			String strTotal=formMap.getField("total").getValue();
			val_total= Double.parseDouble(strTotal);
			setTotal(val_total);
		}
		double val_ratefive=0.0d;
		if (formMap.getField("ratefive").getValue().isEmpty()){
			setRatefive(val_ratefive);
		}
		else{
			String strRatefive=formMap.getField("ratefive").getValue();
			val_ratefive= Double.parseDouble(strRatefive);
			setRatefive(val_ratefive);
		}
		double val_rateten=0.0d;
		if (formMap.getField("rateten").getValue().isEmpty()){
			setRateten(val_rateten);
		}
		else{
			String StrRateten=formMap.getField("rateten").getValue();
			val_rateten= Double.parseDouble(StrRateten);
			setRateten(val_rateten);
		}
		double val_hundred=0.0d;
		if (formMap.getField("hundred").getValue().isEmpty()){
			setHundred(val_hundred);
		}
		else{
			String StrHundred=formMap.getField("hundred").getValue();
			val_hundred= Double.parseDouble(StrHundred);
			setHundred(val_hundred);
		}
		double val_total1=0.0d;
		if (formMap.getField("total1").getValue().isEmpty()){
			setTotal1(val_total1);
		}
		else{
			String StrTotal1=formMap.getField("total1").getValue();
			val_total1= Double.parseDouble(StrTotal1);
			setTotal1(val_total1);
		}
		double val_furniture=0.0d;
		if (formMap.getField("furniture").getValue().isEmpty()){
			setFurniture(val_furniture);
		}
		else{
			String StrFurniture=formMap.getField("furniture").getValue();
			val_furniture= Double.parseDouble(StrFurniture);
			setFurniture(val_furniture);
		}
		double val_intangible=0.0d;
		if (formMap.getField("intangible").getValue().isEmpty()){
			setIntangible(val_intangible);
		}
		else{
			String StrIntangible=formMap.getField("intangible").getValue();
			val_intangible= Double.parseDouble(StrIntangible);
			setIntangible(val_intangible);
		}
		double val_ships=0.0d;
		if (formMap.getField("ships").getValue().isEmpty()){
			setShips(val_ships);
		}
		else{
			String StrShips=formMap.getField("ships").getValue();
			val_ships= Double.parseDouble(StrShips);
			setShips(val_ships);
		}
		double val_total2=0.0d;
		if (formMap.getField("total2").getValue().isEmpty()){
			setTotal2(val_total2);
		}
		else{
			String StrTotal2=formMap.getField("total2").getValue();
			val_total2= Double.parseDouble(StrTotal2);
			setTotal2(val_total2);
		}
		
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
	
	
}
