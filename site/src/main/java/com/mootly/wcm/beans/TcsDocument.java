
/**
 * 
 * User: Dhananjay
 * Date: march 20, 2013
 * 
 * 
 */

package com.mootly.wcm.beans;
import java.util.Calendar;
import java.util.Date;

import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:tcsdocument")
public class TcsDocument extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:tcsdocument";
	static final public String NODE_NAME = "tcsdocument";
	private String Naturepayment;
	private String tan;
	private String name;
	private String Taxcalcamount;
	private String Taxcollected;
	private String Amountclaimed;
	
	//for Adjustment of losses
	
	public final String getNaturepayment() {
		if (Naturepayment == null) Naturepayment = getProperty("mootlywcm:naturepayment");
		return Naturepayment;
	}
	public final String getTan() {
		if (tan == null) tan = getProperty("mootlywcm:tan");
		return tan;
	}
	public final String getName() {
		if (name == null) name = getProperty("mootlywcm:name");
		return name;
	}
	public final String getTaxCalcAmount() {
		if (Taxcalcamount == null) Taxcalcamount = getProperty("mootlywcm:taxcalcamount");
		return Taxcalcamount;
	}
	public final String getTaxCollected() {
		if (Taxcollected == null) Taxcollected = getProperty("mootlywcm:taxcollected");
		return Taxcollected;
	}
	public final String getAmountClaimed() {
		if (Amountclaimed == null) Amountclaimed = getProperty("mootlywcm:Amountclaimed");
		return Amountclaimed;
	}
	
	
	
	
	public final void setNaturepayment(String naturepayment) {
		this.Naturepayment = naturepayment;
	}
	public final void setTan(String Tan) {
		this.tan = Tan;
	}
	public final void setName(String Name) {
		this.name = Name;
	}
	public final void setTaxCalcAmount(String taxcalcamount) {
		this.Taxcalcamount = taxcalcamount;
	}
	
	public final void setTaxCollected(String taxcollected) {
		this.Taxcollected = taxcollected;
	}
	public final void setAmountClaimed(String amountclaimed) {
		this.Amountclaimed = amountclaimed;
	}
	    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is tcsdocument Bean");
			TcsDocument tdsdoc = (TcsDocument) content;
			node.setProperty("mootlywcm:naturepayment", tdsdoc.getNaturepayment());
			node.setProperty("mootlywcm:tan", tdsdoc.getTan());
			node.setProperty("mootlywcm:name", tdsdoc.getName());
			node.setProperty("mootlywcm:taxcalcamount", tdsdoc.getTaxCalcAmount());
			node.setProperty("mootlywcm:taxcollected", tdsdoc.getTaxCollected());
			node.setProperty("mootlywcm:Amountclaimed", tdsdoc.getAmountClaimed());
			
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
