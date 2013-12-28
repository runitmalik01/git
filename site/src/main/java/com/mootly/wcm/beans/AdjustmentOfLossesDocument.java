
/**
 * 
 * User: Dhananjay
 * Date: march 20, 2013
 * 
 * 
 */

package com.mootly.wcm.beans;
import java.util.Calendar;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:adjustmentoflosses")
public class AdjustmentOfLossesDocument extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:adjustmentoflosses";
	static final public String NODE_NAME = "adjustmentoflosses";
	private String AssessmentYear;
	private String NameOfHead;
	private String Amount;
	private Calendar DateOfFilingYear;
	private String DueDate;
	
	//for Adjustment of losses
	
	public final String getAssessmentYear() {
		if (AssessmentYear == null) AssessmentYear = getProperty("mootlywcm:AssessmentYear");
		return AssessmentYear;
	}
	public final String getNameOfHead() {
		if (NameOfHead == null) NameOfHead = getProperty("mootlywcm:NameOfHead");
		return NameOfHead;
	}
	public final String getAmount() {
		if (Amount == null) Amount = getProperty("mootlywcm:Amount");
		return Amount;
	}
	public final Calendar getDateOfFilingYear() {
		if (DateOfFilingYear == null) DateOfFilingYear = getProperty("mootlywcm:DateOfFilingYear");
		return DateOfFilingYear;
	}
	public final String getDueDate() {
		if (DueDate == null) DueDate = getProperty("mootlywcm:DueDate");
		return DueDate;
	}
	
	public final void setAssessmentYear(String AssessmentYear) {
		this.AssessmentYear = AssessmentYear;
	}
	public final void setNameOfHead(String NameOfHead) {
		this.NameOfHead = NameOfHead;
	}
	public final void setAmount(String Amount) {
		this.Amount = Amount;
	}
	public final void setDateOfFilingYear(Calendar DateOfFilingYear) {
		this.DateOfFilingYear = DateOfFilingYear;
	}
	public final void setDueDate(String DueDate) {
		this.DueDate = DueDate;
	}
	    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is adjustment of losses Bean");
			AdjustmentOfLossesDocument adjustmentoflosses = (AdjustmentOfLossesDocument) content;
			node.setProperty("mootlywcm:AssessmentYear", adjustmentoflosses.getAssessmentYear());
			node.setProperty("mootlywcm:NameOfHead", adjustmentoflosses.getNameOfHead());
			node.setProperty("mootlywcm:Amount", adjustmentoflosses.getAmount());
			node.setProperty("mootlywcm:DateOfFilingYear", adjustmentoflosses.getDateOfFilingYear());
			node.setProperty("mootlywcm:DueDate", adjustmentoflosses.getDueDate());
			
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
