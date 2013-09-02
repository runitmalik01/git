package com.mootly.wcm.beans;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.FilingSection;
import com.mootly.wcm.model.FinancialYear;

/**
 * 
 * @author BEN-10
 * 
 * */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:businessprofessiondocument")
public class BusinessProfessionDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:businessprofessiondocument";
	static final public String NODE_NAME = "businessprofessiondocument";

	private Double grossTurnOver;
	private Double grossPresumptIncome;
	private Double incChargBusiness;
	private Double grossSundryDebt;
	private Double grossSundryCredit;
	private Double grossStockTrade;
	private Double grossCashBalance;

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			BusinessProfessionDocument bsp = (BusinessProfessionDocument) content;
			
			node.setProperty("mootlywcm:grossPresumptIncome", bsp.getGrossPresumptIncome());
			node.setProperty("mootlywcm:grossTurnOver", bsp.getGrossTurnOver());
			node.setProperty("mootlywcm:incChargBusiness", bsp.getIncChargBusiness());
			node.setProperty("mootlywcm:grossSundryDebt", bsp.getGrossSundryDebt());
			node.setProperty("mootlywcm:grossSundryCredit", bsp.getGrossSundryCredit());
			node.setProperty("mootlywcm:grossStockTrade", bsp.getGrossStockTrade());
			node.setProperty("mootlywcm:grossCashBalance", bsp.getGrossCashBalance());

		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);

		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		super.fill(formMap);
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");
		}
		if (formMap == null) return;
		
		if(formMap.getField("grossTurnOver")!=null) setGrossPresumptIncome(Double.parseDouble(formMap.getField("grossTurnOver").getValue()));
		if(formMap.getField("grossPresumptIncome")!=null) setGrossTurnOver(Double.parseDouble(formMap.getField("grossPresumptIncome").getValue()));
		if(formMap.getField("incChargBusiness")!=null) setIncChargBusiness(Double.parseDouble(formMap.getField("incChargBusiness").getValue()));
		if(formMap.getField("grossCashBalance")!=null) setGrossCashBalance(Double.parseDouble(formMap.getField("grossCashBalance").getValue()));
		if(formMap.getField("grossStockTrade")!=null) setGrossStockTrade(Double.parseDouble(formMap.getField("grossStockTrade").getValue()));
		if(formMap.getField("grossSundryCredit")!=null) setGrossSundryCredit(Double.parseDouble(formMap.getField("grossSundryCredit").getValue()));
		if(formMap.getField("grossSundryDebt")!=null) setGrossSundryDebt(Double.parseDouble(formMap.getField("grossSundryDebt").getValue()));

	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}

	public Double getGrossTurnOver() {
		if(grossTurnOver==null) grossTurnOver = getProperty("mootlywcm:grossTurnOver");
		return grossTurnOver;
	}

	public void setGrossTurnOver(Double grossTurnOver) {
		this.grossTurnOver = grossTurnOver;
	}

	public Double getGrossPresumptIncome() {
		if(grossPresumptIncome==null) grossPresumptIncome = getProperty("mootlywcm:grossPresumptIncome");
		return grossPresumptIncome;
	}

	public void setGrossPresumptIncome(Double grossPresumptIncome) {
		this.grossPresumptIncome = grossPresumptIncome;
	}

	public Double getIncChargBusiness() {
		if(incChargBusiness==null) incChargBusiness = getProperty("mootlywcm:incChargBusiness");
		return incChargBusiness;
	}

	public void setIncChargBusiness(Double incChargBusiness) {
		this.incChargBusiness = incChargBusiness;
	}

	public Double getGrossSundryDebt() {
		if(grossSundryDebt==null) grossSundryDebt = getProperty("mootlywcm:grossSundryDebt");
		return grossSundryDebt;
	}

	public void setGrossSundryDebt(Double grossSundryDebt) {
		this.grossSundryDebt = grossSundryDebt;
	}

	public Double getGrossSundryCredit() {
		if(grossSundryCredit==null) grossSundryCredit = getProperty("mootlywcm:grossSundryCredit");
		return grossSundryCredit;
	}

	public void setGrossSundryCredit(Double grossSundryCredit) {
		this.grossSundryCredit = grossSundryCredit;
	}

	public Double getGrossStockTrade() {
		if(grossStockTrade==null) grossStockTrade = getProperty("mootlywcm:grossStockTrade");
		return grossStockTrade;
	}

	public void setGrossStockTrade(Double grossStockTrade) {
		this.grossStockTrade = grossStockTrade;
	}

	public Double getGrossCashBalance() {
		if(grossCashBalance==null) grossCashBalance = getProperty("mootlywcm:grossCashBalance");
		return grossCashBalance;
	}

	public void setGrossCashBalance(Double grossCashBalance) {
		this.grossCashBalance = grossCashBalance;
	}

	
}
