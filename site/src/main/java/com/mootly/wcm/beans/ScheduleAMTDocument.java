package com.mootly.wcm.beans;

import javax.jcr.RepositoryException;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.standard.FlexibleDocument;

/**
 * 
 * @author BEN-10
 * 
 * */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:scheduleamtdocument")
public class ScheduleAMTDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:scheduleamtdocument";
	static final public String NODE_NAME = "scheduleamtdocument";

	private Double totalIncomeItem13;
	private Double dedClaimChapSix;
	private Double dedClaimTenAA;
	private Double incUndSec115JC;
	private Double taxPayUndSec115JC;
	private Double totalAdjustment;

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			ScheduleAMTDocument bsp = (ScheduleAMTDocument) content;
			
			node.setProperty("mootlywcm:dedClaimChapSix", bsp.getDedClaimChapSix());
			node.setProperty("mootlywcm:totalIncomeItem13", bsp.getTotalIncomeItem13());
			node.setProperty("mootlywcm:dedClaimTenAA", bsp.getDedClaimTenAA());
			node.setProperty("mootlywcm:incUndSec115JC", bsp.getIncUndSec115JC());
			node.setProperty("mootlywcm:taxPayUndSec115JC", bsp.getTaxPayUndSec115JC());
			node.setProperty("mootlywcm:totalAdjustment", bsp.getTotalAdjustment());

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
		
		if(formMap.getField("totalIncomeItem13")!=null) setDedClaimChapSix(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("totalIncomeItem13").getValue()) ? formMap.getField("totalIncomeItem13").getValue() : "0"));
		if(formMap.getField("dedClaimChapSix")!=null) setTotalIncomeItem13(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("dedClaimChapSix").getValue()) ? formMap.getField("dedClaimChapSix").getValue() : "0"));
		if(formMap.getField("dedClaimTenAA")!=null) setDedClaimTenAA(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("dedClaimTenAA").getValue()) ? formMap.getField("dedClaimTenAA").getValue() : "0"));
		if(formMap.getField("totalAdjustment")!=null) setTotalAdjustment(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("totalAdjustment").getValue()) ? formMap.getField("totalAdjustment").getValue() : "0"));
		if(formMap.getField("taxPayUndSec115JC")!=null) setTaxPayUndSec115JC(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("taxPayUndSec115JC").getValue()) ? formMap.getField("taxPayUndSec115JC").getValue()  : "0"));
		if(formMap.getField("incUndSec115JC")!=null) setIncUndSec115JC(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("incUndSec115JC").getValue()) ? formMap.getField("incUndSec115JC").getValue() : "0"));

	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}

	public Double getTotalIncomeItem13() {
		if(totalIncomeItem13==null) totalIncomeItem13 = getProperty("mootlywcm:totalIncomeItem13");
		return totalIncomeItem13;
	}

	public void setTotalIncomeItem13(Double totalIncomeItem13) {
		this.totalIncomeItem13 = totalIncomeItem13;
	}

	public Double getDedClaimChapSix() {
		if(dedClaimChapSix==null) dedClaimChapSix = getProperty("mootlywcm:dedClaimChapSix");
		return dedClaimChapSix;
	}

	public void setDedClaimChapSix(Double dedClaimChapSix) {
		this.dedClaimChapSix = dedClaimChapSix;
	}

	public Double getDedClaimTenAA() {
		if(dedClaimTenAA==null) dedClaimTenAA = getProperty("mootlywcm:dedClaimTenAA");
		return dedClaimTenAA;
	}

	public void setDedClaimTenAA(Double dedClaimTenAA) {
		this.dedClaimTenAA = dedClaimTenAA;
	}

	public Double getIncUndSec115JC() {
		if(incUndSec115JC==null) incUndSec115JC = getProperty("mootlywcm:incUndSec115JC");
		return incUndSec115JC;
	}

	public void setIncUndSec115JC(Double incUndSec115JC) {
		this.incUndSec115JC = incUndSec115JC;
	}

	public Double getTaxPayUndSec115JC() {
		if(taxPayUndSec115JC==null) taxPayUndSec115JC = getProperty("mootlywcm:taxPayUndSec115JC");
		return taxPayUndSec115JC;
	}

	public void setTaxPayUndSec115JC(Double taxPayUndSec115JC) {
		this.taxPayUndSec115JC = taxPayUndSec115JC;
	}

	public Double getTotalAdjustment() {
		if(totalAdjustment==null) totalAdjustment = getProperty("mootlywcm:totalAdjustment");
		return totalAdjustment;
	}

	public void setTotalAdjustment(Double totalAdjustment) {
		this.totalAdjustment = totalAdjustment;
	}
}
