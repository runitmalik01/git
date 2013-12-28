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
@Node(jcrType = "mootlywcm:scheduleamtcdocument")
public class ScheduleAMTCDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:scheduleamtcdocument";
	static final public String NODE_NAME = "scheduleamtcdocument";

	private Double taxUndSec115JC;
	private Double taxUnderOtherProv;
	private Double taxAgainstCredit;
	private Double amtCreditGross;
	private Double amtCreditSetOff;
	private Double amtCreditBrghtFwrd;
	private Double amtCreditUnlisted;
	private Double amtCreditCarriedFwrd;
	private Double liabAvailCredit;
	private Double unlistCreditUndSec115JD;

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			ScheduleAMTCDocument bsp = (ScheduleAMTCDocument) content;
			
			node.setProperty("mootlywcm:taxUnderOtherProv", bsp.getTaxUnderOtherProv());
			node.setProperty("mootlywcm:taxUndSec115JC", bsp.getTaxUndSec115JC());
			node.setProperty("mootlywcm:taxAgainstCredit", bsp.getTaxAgainstCredit());
			node.setProperty("mootlywcm:amtCreditGross", bsp.getAmtCreditGross());
			node.setProperty("mootlywcm:amtCreditSetOff", bsp.getAmtCreditSetOff());
			node.setProperty("mootlywcm:amtCreditBrghtFwrd", bsp.getAmtCreditBrghtFwrd());
			node.setProperty("mootlywcm:amtCreditUnlisted", bsp.getAmtCreditUnlisted());
			node.setProperty("mootlywcm:amtCreditCarriedFwrd", bsp.getAmtCreditCarriedFwrd());
			node.setProperty("mootlywcm:liabAvailCredit", bsp.getLiabAvailCredit());
			node.setProperty("mootlywcm:unlistCreditUndSec115JD", bsp.getUnlistCreditUndSec115JD());
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
		
		if(formMap.getField("taxUndSec115JC")!=null) setTaxUnderOtherProv(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("taxUndSec115JC").getValue()) ? formMap.getField("taxUndSec115JC").getValue() : "0"));
		if(formMap.getField("taxUnderOtherProv")!=null) setTaxUndSec115JC(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("taxUnderOtherProv").getValue()) ? formMap.getField("taxUnderOtherProv").getValue() : "0"));
		if(formMap.getField("taxAgainstCredit")!=null) setTaxAgainstCredit(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("taxAgainstCredit").getValue()) ? formMap.getField("taxAgainstCredit").getValue() : "0"));
		if(formMap.getField("amtCreditUnlisted")!=null) setAmtCreditUnlisted(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("amtCreditUnlisted").getValue()) ? formMap.getField("amtCreditUnlisted").getValue() : "0"));
		if(formMap.getField("amtCreditBrghtFwrd")!=null) setAmtCreditBrghtFwrd(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("amtCreditBrghtFwrd").getValue()) ? formMap.getField("amtCreditBrghtFwrd").getValue() : "0"));
		if(formMap.getField("amtCreditSetOff")!=null) setAmtCreditSetOff(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("amtCreditSetOff").getValue()) ? formMap.getField("amtCreditSetOff").getValue()  : "0"));
		if(formMap.getField("amtCreditGross")!=null) setAmtCreditGross(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("amtCreditGross").getValue()) ? formMap.getField("amtCreditGross").getValue() : "0"));
		
		if(formMap.getField("amtCreditCarriedFwrd")!=null) setAmtCreditCarriedFwrd(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("amtCreditCarriedFwrd").getValue()) ? formMap.getField("amtCreditCarriedFwrd").getValue() : "0"));
		if(formMap.getField("liabAvailCredit")!=null) setLiabAvailCredit(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("liabAvailCredit").getValue()) ? formMap.getField("liabAvailCredit").getValue() : "0"));
		if(formMap.getField("unlistCreditUndSec115JD")!=null) setUnlistCreditUndSec115JD(Double.parseDouble(StringUtils.isNotBlank(formMap.getField("unlistCreditUndSec115JD").getValue()) ? formMap.getField("unlistCreditUndSec115JD").getValue() : "0"));

	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}

	public Double getTaxUndSec115JC() {
		if(taxUndSec115JC==null) taxUndSec115JC = getProperty("mootlywcm:taxUndSec115JC");
		return taxUndSec115JC;
	}

	public void setTaxUndSec115JC(Double taxUndSec115JC) {
		this.taxUndSec115JC = taxUndSec115JC;
	}

	public Double getTaxUnderOtherProv() {
		if(taxUnderOtherProv==null) taxUnderOtherProv = getProperty("mootlywcm:taxUnderOtherProv");
		return taxUnderOtherProv;
	}

	public void setTaxUnderOtherProv(Double taxUnderOtherProv) {
		this.taxUnderOtherProv = taxUnderOtherProv;
	}

	public Double getTaxAgainstCredit() {
		if(taxAgainstCredit==null) taxAgainstCredit = getProperty("mootlywcm:taxAgainstCredit");
		return taxAgainstCredit;
	}

	public void setTaxAgainstCredit(Double taxAgainstCredit) {
		this.taxAgainstCredit = taxAgainstCredit;
	}

	public Double getAmtCreditGross() {
		if(amtCreditGross==null) amtCreditGross = getProperty("mootlywcm:amtCreditGross");
		return amtCreditGross;
	}

	public void setAmtCreditGross(Double amtCreditGross) {
		this.amtCreditGross = amtCreditGross;
	}

	public Double getAmtCreditSetOff() {
		if(amtCreditSetOff==null) amtCreditSetOff = getProperty("mootlywcm:amtCreditSetOff");
		return amtCreditSetOff;
	}

	public void setAmtCreditSetOff(Double amtCreditSetOff) {
		this.amtCreditSetOff = amtCreditSetOff;
	}

	public Double getAmtCreditBrghtFwrd() {
		if(amtCreditBrghtFwrd==null) amtCreditBrghtFwrd = getProperty("mootlywcm:amtCreditBrghtFwrd");
		return amtCreditBrghtFwrd;
	}

	public void setAmtCreditBrghtFwrd(Double amtCreditBrghtFwrd) {
		this.amtCreditBrghtFwrd = amtCreditBrghtFwrd;
	}

	public Double getAmtCreditUnlisted() {
		if(amtCreditUnlisted==null) amtCreditUnlisted = getProperty("mootlywcm:amtCreditUnlisted");
		return amtCreditUnlisted;
	}

	public void setAmtCreditUnlisted(Double amtCreditUnlisted) {
		this.amtCreditUnlisted = amtCreditUnlisted;
	}

	public Double getAmtCreditCarriedFwrd() {
		if(amtCreditCarriedFwrd==null) amtCreditCarriedFwrd = getProperty("mootlywcm:amtCreditCarriedFwrd");
		return amtCreditCarriedFwrd;
	}

	public void setAmtCreditCarriedFwrd(Double amtCreditCarriedFwrd) {
		this.amtCreditCarriedFwrd = amtCreditCarriedFwrd;
	}

	public Double getLiabAvailCredit() {
		if(liabAvailCredit==null) liabAvailCredit = getProperty("mootlywcm:liabAvailCredit");
		return liabAvailCredit;
	}

	public void setLiabAvailCredit(Double liabAvailCredit) {
		this.liabAvailCredit = liabAvailCredit;
	}

	public Double getUnlistCreditUndSec115JD() {
		if(unlistCreditUndSec115JD==null) unlistCreditUndSec115JD = getProperty("mootlywcm:unlistCreditUndSec115JD");
		return unlistCreditUndSec115JD;
	}

	public void setUnlistCreditUndSec115JD(Double unlistCreditUndSec115JD) {
		this.unlistCreditUndSec115JD = unlistCreditUndSec115JD;
	}

	
}
