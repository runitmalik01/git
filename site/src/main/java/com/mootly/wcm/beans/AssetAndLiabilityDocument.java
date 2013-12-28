
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
@Node(jcrType = "mootlywcm:assetandliabilitydocument")
public class AssetAndLiabilityDocument extends BaseDocument implements ContentNodeBinder, FormMapFiller{
	static final public String NAMESPACE = "mootlywcm:assetandliabilitydocument";
	static final public String NODE_NAME = "assetandliabilitydocument";


	private Double land;
	private Double building;
	private Double deposit_Bank;
	private Double shares;
	private Double insurance;
	private Double loans_Adv;
	private Double cash;
	private Double jewellery;
	private Double drawing;
	private Double vehicles;
	private Double total;
	private Double liability;
	
	
	
	
	
	public  Double getLand() {
		if (land == null) land = getProperty("mootlywcm:land");
		return land;
	}
	public  Double getBuilding() {
		if (building == null) building = getProperty("mootlywcm:building");
		return building;
	}
	
	public  Double getDeposit_Bank() {
		if (deposit_Bank == null) deposit_Bank = getProperty("mootlywcm:deposit_Bank");
		return deposit_Bank;
	}
	public  Double getShares() {
		if (shares == null) shares = getProperty("mootlywcm:shares");
		return shares;
	}
	public  Double getInsurance() {
		if (insurance == null) insurance = getProperty("mootlywcm:insurance");
		return insurance;
	}
	public  Double getLoans_Adv() {
		if (loans_Adv == null) loans_Adv = getProperty("mootlywcm:loans_Adv");
		return loans_Adv;
	}
	public  Double getCash() {
		if (cash == null) cash = getProperty("mootlywcm:cash");
		return cash;
	}
	public Double getJewellery() {
		if (jewellery == null) jewellery = getProperty("mootlywcm:jewellery");
		return jewellery;
	}
	public  Double getDrawing() {
		if (drawing== null) drawing = getProperty("mootlywcm:drawing");
		return drawing;
	}
	public  Double getVehicles() {
		if (vehicles== null) vehicles = getProperty("mootlywcm:vehicles");
		return vehicles;
	}
	public  Double getTotal() {
		if (total== null) total = getProperty("mootlywcm:total");
		return total;
	}
	public  Double getLiability() {
		if (liability== null) liability = getProperty("mootlywcm:liability");
		return liability;
	}
	
	//set
	
	
	public void setLiability(Double liability) {
		this.liability = liability;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setVehicles(Double vehicles) {
		this.vehicles = vehicles;
	}
	public void setDrawing(Double drawing) {
		this.drawing = drawing;
	}
	public void setJewellery(Double jewellery) {
		this.jewellery = jewellery;
	}
	public void setCash(Double cash) {
		this.cash = cash;
	}
	public void setDeposit_Bank(Double deposit_Bank) {
		this.deposit_Bank= deposit_Bank;
	}
	public void setLand(Double land) {
		this.land = land;
	}
	public void setInsurance(Double insurance) {
		this.insurance= insurance;
	}
	public void setBuilding(Double building) {
		this.building = building;
	}
	public void setLoans_Adv(Double loans_Adv) {
		this.loans_Adv = loans_Adv;
	}
	public void setShares(Double shares) {
		this.shares = shares;
	}
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub   
		try{
			
		AssetAndLiabilityDocument objAssetAndLiabilityDocument= (AssetAndLiabilityDocument) content;
		
		node.setProperty("mootlywcm:land",objAssetAndLiabilityDocument.getLand());
		node.setProperty("mootlywcm:building", objAssetAndLiabilityDocument.getBuilding());
		node.setProperty("mootlywcm:deposit_Bank", objAssetAndLiabilityDocument.getDeposit_Bank());
		node.setProperty("mootlywcm:shares", objAssetAndLiabilityDocument.getShares());
		node.setProperty("mootlywcm:insurance", objAssetAndLiabilityDocument.getInsurance());
		node.setProperty("mootlywcm:loans_Adv", objAssetAndLiabilityDocument.getLoans_Adv());
		node.setProperty("mootlywcm:cash", objAssetAndLiabilityDocument.getCash());
		node.setProperty("mootlywcm:jewellery", objAssetAndLiabilityDocument.getJewellery());
		node.setProperty("mootlywcm:drawing", objAssetAndLiabilityDocument.getDrawing());
		node.setProperty("mootlywcm:vehicles", objAssetAndLiabilityDocument.getVehicles());
		node.setProperty("mootlywcm:total", objAssetAndLiabilityDocument.getTotal());
		node.setProperty("mootlywcm:liability", objAssetAndLiabilityDocument.getLiability());
		
		
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}	
	
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		
		double val_land=0.0d;
		if (formMap.getField("land").getValue().isEmpty()) {
			setLand(val_land);
		}
		else{
			String strLand=formMap.getField("land").getValue();
			val_land= Double.parseDouble(strLand);
			setLand(val_land);
		}
		double val_building=0.0d;
		if (formMap.getField("building").getValue().isEmpty()) {
			setBuilding(val_building);
		}
		else{
			String strBuilding=formMap.getField("building").getValue();
			val_building= Double.parseDouble(strBuilding);
			setBuilding(val_building);
		}
         double val_deposit_Bank=0.0d;
		if (formMap.getField("deposit_Bank").getValue().isEmpty()){
			setDeposit_Bank(val_deposit_Bank);
		}
		else{
			String strDeposit_Bank=formMap.getField("deposit_Bank").getValue();
			val_deposit_Bank= Double.parseDouble(strDeposit_Bank);
			setDeposit_Bank(val_deposit_Bank);
		}
          double val_shares=0.0d;
		if (formMap.getField("shares").getValue().isEmpty()) {
			setShares(val_shares);
		}
		else{
			String strShares=formMap.getField("shares").getValue();
			val_shares= Double.parseDouble(strShares);
			setShares(val_shares);
		}
		double val_insurance=0.0d;
		if (formMap.getField("insurance").getValue().isEmpty()){
			setInsurance(val_insurance);
		}
		else{
			String StrInsurance=formMap.getField("insurance").getValue();
			val_insurance= Double.parseDouble(StrInsurance);
			setInsurance(val_insurance);
		}
		double val_cash=0.0d;
		if (formMap.getField("cash").getValue().isEmpty()){
			setCash(val_cash);
		}
		else{
			String StrCash=formMap.getField("cash").getValue();
			val_cash= Double.parseDouble(StrCash);
			setCash(val_cash);
		}
		double val_loans_Adv=0.0d;
		if (formMap.getField("loans_Adv").getValue().isEmpty()){
			setLoans_Adv(val_loans_Adv);
		}
		else{
			String StrLoans_Adv=formMap.getField("loans_Adv").getValue();
			val_loans_Adv= Double.parseDouble(StrLoans_Adv);
			setLoans_Adv(val_loans_Adv);
		}
		double val_jewellery=0.0d;
		if (formMap.getField("jewellery").getValue().isEmpty()){
			setJewellery(val_jewellery);
		}
		else{
			String StrJewellery=formMap.getField("jewellery").getValue();
			val_jewellery= Double.parseDouble(StrJewellery);
			setJewellery(val_jewellery);
		}
		double val_drawing=0.0d;
		if (formMap.getField("drawing").getValue().isEmpty()){
			setDrawing(val_drawing);
		}
		else{
			String StrDrawing=formMap.getField("drawing").getValue();
			val_drawing= Double.parseDouble(StrDrawing);
			setDrawing(val_drawing);
		}
		double val_vehicles=0.0d;
		if (formMap.getField("vehicles").getValue().isEmpty()){
			setVehicles(val_vehicles);
		}
		else{
			String StrVehicles=formMap.getField("vehicles").getValue();
			val_vehicles= Double.parseDouble(StrVehicles);
			setVehicles(val_vehicles);
		}
		double val_total=0.0d;
		if (formMap.getField("total").getValue().isEmpty()){
			setTotal(val_total);
		}
		else{
			String StrTotal=formMap.getField("total").getValue();
			val_total= Double.parseDouble(StrTotal);
			setTotal(val_total);
		}
		double val_liability=0.0d;
		if (formMap.getField("liability").getValue().isEmpty()){
			setLiability(val_liability);
		}
		else{
			String StrLiability=formMap.getField("liability").getValue();
			val_liability= Double.parseDouble(StrLiability);
			setLiability(val_liability);
		}
		
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
	
	
}
