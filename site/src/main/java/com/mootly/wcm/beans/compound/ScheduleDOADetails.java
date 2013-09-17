package com.mootly.wcm.beans.compound;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormMapFiller;
@Node(jcrType = "mootlywcm:scheduledoadetails")
public class ScheduleDOADetails extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:scheduledoadetails";   
	static final public String NODE_NAME = ScheduleDOADetails.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(ScheduleDOADetails.class); 
	
	private String type_Asset;
	private String rates;
	private Double valFirstDayPrevYr;
	private Double periodMore180Day;
	private Double prevYrConsider;
	private Double amtDepreciationFullRate;
	private Double periodLess180Day;
	private Double considerOrRealDuringYr;
	
	private Double halfRateDepreciation;
	private Double amtDepreciationHalfRate;
	private Double depreciationFullRate;
	private Double depreciationHalfRate;
	private Double addDepreciatMore180Day;
	private Double addDepreciatLess180Day;
	private Double totalDepreciation;
	private Double expense_TransferAsset;
	private Double capitalGain_LossSec50;
	private Double valLastDayPrevYr;
	private boolean markedForDeletion;
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	public String getType_Asset(){
		if(type_Asset == null) type_Asset = getProperty("mootlywcm:type_Asset");
		return type_Asset;
	}
	public void setType_Asset(String type_Asset){
		this.type_Asset = type_Asset;
	}
	public String getRates() {
		if(rates == null) rates = getProperty("mootlywcm:rates");
		return rates;
	}

	public void setRates(String rates) {
		this.rates = rates;
	}

	public Double getValFirstDayPrevYr() {
		if(valFirstDayPrevYr == null) valFirstDayPrevYr = getProperty("mootlywcm:valFirstDayPrevYr");
		return valFirstDayPrevYr;
	}

	public void setValFirstDayPrevYr(Double valFirstDayPrevYr) {
		this.valFirstDayPrevYr = valFirstDayPrevYr;
	}

	public Double getPeriodMore180Day() {
		if(periodMore180Day == null) periodMore180Day = getProperty("mootlywcm:periodMore180Day");
		return periodMore180Day;
	}

	public void setPeriodMore180Day(Double periodMore180Day) {
		
		this.periodMore180Day = periodMore180Day;
	}

	public Double getPrevYrConsider() {
		if(prevYrConsider == null) prevYrConsider = getProperty("mootlywcm:prevYrConsider");
		return prevYrConsider;
	}

	public void setPrevYrConsider(Double prevYrConsider) {
		this.prevYrConsider = prevYrConsider;
	}

	public Double getAmtDepreciationFullRate() {
		if(amtDepreciationFullRate == null) amtDepreciationFullRate = getProperty("mootlywcm:amtDepreciationFullRate");
		return amtDepreciationFullRate;
	}

	public void setAmtDepreciationFullRate(Double amtDepreciationFullRate) {
		this.amtDepreciationFullRate = amtDepreciationFullRate;
	}

	public Double getPeriodLess180Day() {
		if(periodLess180Day == null) periodLess180Day = getProperty("mootlywcm:periodLess180Day");
		return periodLess180Day;
	}

	public void setPeriodLess180Day(Double periodLess180Day) {
		this.periodLess180Day = periodLess180Day;
	}

	public Double getConsiderOrRealDuringYr() {
		if(considerOrRealDuringYr == null) considerOrRealDuringYr = getProperty("mootlywcm:considerOrRealDuringYr");
		return considerOrRealDuringYr;
	}

	public void setConsiderOrRealDuringYr(Double considerOrRealDuringYr) {
		this.considerOrRealDuringYr = considerOrRealDuringYr;
	}

	public Double getHalfRateDepreciation() {
		if(halfRateDepreciation == null) halfRateDepreciation = getProperty("mootlywcm:halfRateDepreciation");
		return halfRateDepreciation;
	}

	public void setHalfRateDepreciation(Double halfRateDepreciation) {
		this.halfRateDepreciation = halfRateDepreciation;
	}

	public Double getAmtDepreciationHalfRate() {
		if(amtDepreciationHalfRate == null) amtDepreciationHalfRate = getProperty("mootlywcm:amtDepreciationHalfRate");
		return amtDepreciationHalfRate;
	}

	public void setAmtDepreciationHalfRate(Double amtDepreciationHalfRate) {
		this.amtDepreciationHalfRate = amtDepreciationHalfRate;
	}

	public Double getDepreciationFullRate() {
		if(depreciationFullRate == null) depreciationFullRate = getProperty("mootlywcm:depreciationFullRate");
		return depreciationFullRate;
	}

	public void setDepreciationFullRate(Double depreciationFullRate) {
		this.depreciationFullRate = depreciationFullRate;
	}

	public Double getDepreciationHalfRate() {
		if(depreciationHalfRate == null) depreciationHalfRate = getProperty("mootlywcm:depreciationHalfRate");
		return depreciationHalfRate;
	}

	public void setDepreciationHalfRate(Double depreciationHalfRate) {
		this.depreciationHalfRate = depreciationHalfRate;
	}

	public Double getAddDepreciatMore180Day() {
		if(addDepreciatMore180Day == null) addDepreciatMore180Day = getProperty("mootlywcm:addDepreciatMore180Day");
		return addDepreciatMore180Day;
	}

	public void setAddDepreciatMore180Day(Double addDepreciatMore180Day) {
		this.addDepreciatMore180Day = addDepreciatMore180Day;
	}

	public Double getAddDepreciatLess180Day() {
		if(addDepreciatLess180Day == null) addDepreciatLess180Day = getProperty("mootlywcm:addDepreciatLess180Day");
		return addDepreciatLess180Day;
	}

	public void setAddDepreciatLess180Day(Double addDepreciatLess180Day) {
		this.addDepreciatLess180Day = addDepreciatLess180Day;
	}

	public Double getTotalDepreciation() {
		if(totalDepreciation == null) totalDepreciation = getProperty("mootlywcm:totalDepreciation");
		return totalDepreciation;
	}

	public void setTotalDepreciation(Double totalDepreciation) {
		this.totalDepreciation = totalDepreciation;
	}

	public Double getExpense_TransferAsset() {
		if(expense_TransferAsset == null) expense_TransferAsset = getProperty("mootlywcm:expense_TransferAsset");
		return expense_TransferAsset;
	}

	public void setExpense_TransferAsset(Double expense_TransferAsset) {
		this.expense_TransferAsset = expense_TransferAsset;
	}

	public Double getCapitalGain_LossSec50() {
		if(capitalGain_LossSec50 == null) capitalGain_LossSec50 = getProperty("mootlywcm:capitalGain_LossSec50");
		return capitalGain_LossSec50;
	}

	public void setCapitalGain_LossSec50(Double capitalGain_LossSec50) {
		this.capitalGain_LossSec50 = capitalGain_LossSec50;
	}

	public Double getValLastDayPrevYr() {
		if(valLastDayPrevYr == null) valLastDayPrevYr = getProperty("mootlywcm:valLastDayPrevYr");
		return valLastDayPrevYr;
	}

	public void setValLastDayPrevYr(Double valLastDayPrevYr) {
		this.valLastDayPrevYr = valLastDayPrevYr;
	}
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
	// TODO Auto-generated method stub
	try {
		
				node.setProperty("mootlywcm:type_Asset", getType_Asset());
				node.setProperty("mootlywcm:rates",getRates());
				node.setProperty("mootlywcm:valFirstDayPrevYr", getValFirstDayPrevYr());
				node.setProperty("mootlywcm:periodMore180Day", getPeriodMore180Day());
				node.setProperty("mootlywcm:prevYrConsider", getPrevYrConsider());
				node.setProperty("mootlywcm:amtDepreciationFullRate", getAmtDepreciationFullRate());
				node.setProperty("mootlywcm:periodLess180Day", getPeriodLess180Day());
				node.setProperty("mootlywcm:considerOrRealDuringYr", getConsiderOrRealDuringYr());
				node.setProperty("mootlywcm:halfRateDepreciation", getHalfRateDepreciation());
				node.setProperty("mootlywcm:amtDepreciationHalfRate", getAmtDepreciationHalfRate());
				node.setProperty("mootlywcm:depreciationFullRate", getDepreciationFullRate());
				node.setProperty("mootlywcm:depreciationHalfRate", getDepreciationHalfRate());
				node.setProperty("mootlywcm:addDepreciatMore180Day", getAddDepreciatMore180Day());
				node.setProperty("mootlywcm:totalDepreciation", getTotalDepreciation());
				node.setProperty("mootlywcm:expense_TransferAsset", getExpense_TransferAsset());
				node.setProperty("mootlywcm:capitalGain_LossSec50", getCapitalGain_LossSec50());
				node.setProperty("mootlywcm:valLastDayPrevYr", getValLastDayPrevYr());
				node.setProperty("mootlywcm:addDepreciatLess180Day", getAddDepreciatLess180Day());
			

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		
		double defValueifNull=0.0d;
		if (!(formMap.getField("type_Asset").getValue().isEmpty())){
			String type_AssetStr=formMap.getField("type_Asset").getValue();
			setType_Asset(type_AssetStr);
		}
		if (!(formMap.getField("rates").getValue().isEmpty())){
			String ratesStr=formMap.getField("rates").getValue();
			setRates(ratesStr);
		}
		if (formMap.getField("valFirstDayPrevYr").getValue().isEmpty()){
			setValFirstDayPrevYr(defValueifNull);
		}
		else{
			String valFirstDayPrevYrStr=formMap.getField("valFirstDayPrevYr").getValue();
			double val_valFirstDayPrevYr= Double.parseDouble(valFirstDayPrevYrStr);
			setValFirstDayPrevYr(val_valFirstDayPrevYr);
		}
		if (formMap.getField("periodMore180Day").getValue().isEmpty()){
			setPeriodMore180Day(defValueifNull);
		}
		else{
			String periodMore180DayStr=formMap.getField("periodMore180Day").getValue();
			double val_periodMore180Day= Double.parseDouble(periodMore180DayStr);
			setPeriodMore180Day(val_periodMore180Day);
		}

		if (formMap.getField("prevYrConsider").getValue().isEmpty()){
			setPrevYrConsider(defValueifNull);
		}
		else{
			String prevYrConsiderStr=formMap.getField("prevYrConsider").getValue();
			double val_prevYrConsider= Double.parseDouble(prevYrConsiderStr);
			setPrevYrConsider(val_prevYrConsider);
		}
		if (formMap.getField("amtDepreciationFullRate").getValue().isEmpty()){
			setAmtDepreciationFullRate(defValueifNull);
		}
		else{
			String amtDepreciationFullRateStr=formMap.getField("amtDepreciationFullRate").getValue();
			double val_amtDepreciationFullRate= Double.parseDouble(amtDepreciationFullRateStr);
			setAmtDepreciationFullRate(val_amtDepreciationFullRate);
		}
		if (formMap.getField("periodLess180Day").getValue().isEmpty()){
			setPeriodLess180Day(defValueifNull);
		}
		else{
			String periodLess180DayStr=formMap.getField("periodLess180Day").getValue();
			double val_periodLess180Day= Double.parseDouble(periodLess180DayStr);
			setPeriodLess180Day(val_periodLess180Day);
		}


		if (formMap.getField("considerOrRealDuringYr").getValue().isEmpty()){
			setConsiderOrRealDuringYr(defValueifNull);
		}
		else{
			String considerOrRealDuringYrStr=formMap.getField("considerOrRealDuringYr").getValue();
			double val_considerOrRealDuringYr= Double.parseDouble(considerOrRealDuringYrStr);
			setConsiderOrRealDuringYr(val_considerOrRealDuringYr);
		}
		if (formMap.getField("halfRateDepreciation").getValue().isEmpty()){
			setHalfRateDepreciation(defValueifNull);
		}
		else{
			String halfRateDepreciationStr=formMap.getField("halfRateDepreciation").getValue();
			double val_halfRateDepreciation= Double.parseDouble(halfRateDepreciationStr);
			setHalfRateDepreciation(val_halfRateDepreciation);
		}
		if (formMap.getField("amtDepreciationHalfRate").getValue().isEmpty()){
			setAmtDepreciationHalfRate(defValueifNull);
		}
		else{
			String amtDepreciationHalfRateStr=formMap.getField("amtDepreciationHalfRate").getValue();
			double val_amtDepreciationHalfRate= Double.parseDouble(amtDepreciationHalfRateStr);
			setAmtDepreciationHalfRate(val_amtDepreciationHalfRate);
		}

		if (formMap.getField("depreciationFullRate").getValue().isEmpty()){
			setDepreciationFullRate(defValueifNull);
		}
		else{
			String depreciationFullRateStr=formMap.getField("depreciationFullRate").getValue();
			double val_depreciationFullRate= Double.parseDouble(depreciationFullRateStr);
			setDepreciationFullRate(val_depreciationFullRate);
		}
		if (formMap.getField("depreciationHalfRate").getValue().isEmpty()){
			setDepreciationHalfRate(defValueifNull);
		}
		else{
			String depreciationHalfRateStr=formMap.getField("depreciationHalfRate").getValue();
			double val_depreciationHalfRate= Double.parseDouble(depreciationHalfRateStr);
			setDepreciationHalfRate(val_depreciationHalfRate);
		}
		if (formMap.getField("addDepreciatMore180Day").getValue().isEmpty()){
			setAddDepreciatMore180Day(defValueifNull);
		}
		else{
			String addDepreciatMore180DayStr=formMap.getField("addDepreciatMore180Day").getValue();
			double val_addDepreciatMore180Day= Double.parseDouble(addDepreciatMore180DayStr);
			setAddDepreciatMore180Day(val_addDepreciatMore180Day);
		}
		if (formMap.getField("addDepreciatLess180Day").getValue().isEmpty()){
			setAddDepreciatLess180Day(defValueifNull);
		}
		else{
			String addDepreciatLess180DayStr=formMap.getField("addDepreciatLess180Day").getValue();
			double val_addDepreciatLess180Day= Double.parseDouble(addDepreciatLess180DayStr);
			setAddDepreciatLess180Day(val_addDepreciatLess180Day);
		}
		
		if (formMap.getField("totalDepreciation").getValue().isEmpty()){
			setTotalDepreciation(defValueifNull);
		}
		else{
			String totalDepreciationStr=formMap.getField("totalDepreciation").getValue();
			double val_totalDepreciation= Double.parseDouble(totalDepreciationStr);
			setTotalDepreciation(val_totalDepreciation);
		}
		if (formMap.getField("expense_TransferAsset").getValue().isEmpty()){
			setExpense_TransferAsset(defValueifNull);
		}
		else{
			String expense_TransferAssetStr=formMap.getField("expense_TransferAsset").getValue();
			double val_expense_TransferAsset= Double.parseDouble(expense_TransferAssetStr);
			setExpense_TransferAsset(val_expense_TransferAsset);
		}
		if (formMap.getField("capitalGain_LossSec50").getValue().isEmpty()){
			setCapitalGain_LossSec50(defValueifNull);
		}
		else{
			String capitalGain_LossSec50Str=formMap.getField("capitalGain_LossSec50").getValue();
			double val_capitalGain_LossSec50= Double.parseDouble(capitalGain_LossSec50Str);
			setCapitalGain_LossSec50(val_capitalGain_LossSec50);
		}

		if (formMap.getField("valLastDayPrevYr").getValue().isEmpty()){
			setValLastDayPrevYr(defValueifNull);
		}
		else{
			String valLastDayPrevYrStr=formMap.getField("valLastDayPrevYr").getValue();
			double val_valLastDayPrevYr= Double.parseDouble(valLastDayPrevYrStr);
			setValLastDayPrevYr(val_valLastDayPrevYr);
		}
}

	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		ScheduleDOADetails objScheduleDPMDetails = (ScheduleDOADetails) sourceBean;
		setType_Asset(objScheduleDPMDetails.getType_Asset());
		setRates(objScheduleDPMDetails.getRates());
		setValFirstDayPrevYr(objScheduleDPMDetails.getValFirstDayPrevYr());
		setPeriodMore180Day(objScheduleDPMDetails.getPeriodMore180Day());
		setPrevYrConsider(objScheduleDPMDetails.getPrevYrConsider());
		setAmtDepreciationFullRate(objScheduleDPMDetails.getAmtDepreciationFullRate());
		setPeriodLess180Day(objScheduleDPMDetails.getPeriodLess180Day());
		setConsiderOrRealDuringYr(objScheduleDPMDetails.getConsiderOrRealDuringYr());
		setHalfRateDepreciation(objScheduleDPMDetails.getHalfRateDepreciation());
		setConsiderOrRealDuringYr(objScheduleDPMDetails.getConsiderOrRealDuringYr());
		setAmtDepreciationHalfRate(objScheduleDPMDetails.getAmtDepreciationHalfRate());
		setDepreciationFullRate(objScheduleDPMDetails.getDepreciationFullRate());
		setDepreciationHalfRate(objScheduleDPMDetails.getDepreciationHalfRate());
		setAddDepreciatMore180Day(objScheduleDPMDetails.getAddDepreciatMore180Day());
		setAddDepreciatLess180Day(objScheduleDPMDetails.getAddDepreciatLess180Day());
		setTotalDepreciation(objScheduleDPMDetails.getTotalDepreciation());
		setExpense_TransferAsset(objScheduleDPMDetails.getExpense_TransferAsset());
		setCapitalGain_LossSec50(objScheduleDPMDetails.getCapitalGain_LossSec50());
		setValLastDayPrevYr(objScheduleDPMDetails.getValLastDayPrevYr());
		
		
	}
	

	



	

}
