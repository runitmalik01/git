
/**
 * 
 * User: Dhananjay
 * Date: march 20, 2013
 * 
 * 
 */

package com.mootly.wcm.beans.compound;

import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;

import com.mootly.wcm.beans.FormMapFiller;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:adjustmentoflossescom")
public class AdjustmentOfLossesCom extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:adjustmentoflossescom";
	static final public String NODE_NAME = AdjustmentOfLossesCom.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(AdjustmentOfLossesDoc.class); 
	private String AssessmentYear;
	private String NameOfHead;
	private Double Amount;
	private Calendar DateOfFilingYear;
	private String DueDate;
	
    private String personalInfoUuid;
	private boolean markedForDeletion;
	
	//for Adjustment of losses
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	
	public final String getAssessmentYear() {
		if (AssessmentYear == null) AssessmentYear = getProperty("mootlywcm:AssessmentYear");
		return AssessmentYear;
	}
	public final String getNameOfHead() {
		if (NameOfHead == null) NameOfHead = getProperty("mootlywcm:NameOfHead");
		return NameOfHead;
	}
	public final Double getAmount() {
		if (Amount == null) Amount = getProperty("mootlywcm:Amount");
		return Amount;
	}
	public final Calendar getDateOfFilingYear() {
		if (DateOfFilingYear == null) DateOfFilingYear = getProperty("mootlywcm:DateOfFilingYear");
		return DateOfFilingYear;
	}
	  
    public String getDOBStr() {
    	if (DateOfFilingYear == null) DateOfFilingYear = getProperty("mootlywcm:DateOfFilingYear");
    	if (DateOfFilingYear != null) {
    		String dobStr = getIndianDateFormatter().format(DateOfFilingYear.getTime());
    		return dobStr;
    	}
    	return null;
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
	public final void setAmount(Double Amount) {
		this.Amount = Amount;
	}
	public final void setDateOfFilingYear(Calendar DateOfFilingYear) {
		this.DateOfFilingYear = DateOfFilingYear;
	}
	public final void setDueDate(String DueDate) {
		this.DueDate = DueDate;
	}
	
	//for personal information
		public final String getPersonalInfoUuid() {
			return personalInfoUuid;
		}
		
		public final void setPersonalInfoUuid(String personalInfoUuid) {
			this.personalInfoUuid = personalInfoUuid;
		}
		
		public PersonalInformation getPersonalInformation() {
	        HippoBean bean = getBean(NT_PERSONAL_INFO_LINK);
	        if (!(bean instanceof HippoMirror)) {
	            return null;
	        }

	        PersonalInformation prdBean = (PersonalInformation) ((HippoMirror) bean).getReferencedBean();

	        if (prdBean == null) {
	            return null;
	        }
	        return prdBean;
	    }
		
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is adjustment of losses Bean");
		
			node.setProperty("mootlywcm:AssessmentYear",getAssessmentYear());
			node.setProperty("mootlywcm:NameOfHead", getNameOfHead());
			node.setProperty("mootlywcm:Amount", getAmount());
			node.setProperty("mootlywcm:DateOfFilingYear", getDateOfFilingYear());
			node.setProperty("mootlywcm:DueDate", getDueDate());
			
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		
		if ( formMap.getField("AssessmentYear") != null) {
			setAssessmentYear(formMap.getField("AssessmentYear").getValue());
		}
		if ( formMap.getField("NameOfHead") != null) {
			setNameOfHead(formMap.getField("NameOfHead").getValue());
		}
		if ( formMap.getField("Amount") != null) {
			String strAmount=formMap.getField("Amount").getValue();
			double amt = Double.parseDouble(strAmount);
			setAmount(amt);
		}
		if ( formMap.getField("DueDate") != null) {
			setDueDate(formMap.getField("DueDate").getValue());
		}
		if ( formMap.getField("DateOfFilingYear") != null) {
			String strDate = formMap.getField("DateOfFilingYear").getValue();
			Date date = null ;
			DateFormat formatter ; 
			formatter = getIndianDateFormatter();
			Calendar cal=Calendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate); 
				log.info("date"+date);
				cal.setTime(date);
				setDateOfFilingYear(cal);
			}
			catch(Exception e){
				log.info("calendar error"+e);
			}
		}	
	
	}
	 public static final SimpleDateFormat getIndianDateFormatter() {
	    	return new SimpleDateFormat("dd/MM/yyyy");
	    }
	 
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		AdjustmentOfLossesCom adjustmentoflossescom = (AdjustmentOfLossesCom) sourceBean;
		setAssessmentYear(adjustmentoflossescom.getAssessmentYear());
		setNameOfHead(adjustmentoflossescom.getNameOfHead());
		setAmount(adjustmentoflossescom.getAmount());
		setDateOfFilingYear(adjustmentoflossescom.getDateOfFilingYear());
		setDueDate(adjustmentoflossescom.getDueDate());	
	};
}
