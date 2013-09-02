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
		

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			BusinessProfessionDocument bsp = (BusinessProfessionDocument) content;
			
			node.setProperty("mootlywcm:advancRecover", bsp.getGrossPresumptIncome());
			node.setProperty("mootlywcm:balanceBank", bsp.getGrossTurnOver());
			node.setProperty("mootlywcm:balWthRevenAuth", bsp.getIncChargBusiness());

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

	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}

	public Double getGrossTurnOver() {
		return grossTurnOver;
	}

	public void setGrossTurnOver(Double grossTurnOver) {
		this.grossTurnOver = grossTurnOver;
	}

	public Double getGrossPresumptIncome() {
		return grossPresumptIncome;
	}

	public void setGrossPresumptIncome(Double grossPresumptIncome) {
		this.grossPresumptIncome = grossPresumptIncome;
	}

	public Double getIncChargBusiness() {
		return incChargBusiness;
	}

	public void setIncChargBusiness(Double incChargBusiness) {
		this.incChargBusiness = incChargBusiness;
	}

	
}
