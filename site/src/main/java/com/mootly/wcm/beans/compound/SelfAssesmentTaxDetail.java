/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.beans.compound;

import static com.mootly.wcm.utils.Constants.AMOUNT;
import static com.mootly.wcm.utils.Constants.BSR;
import static com.mootly.wcm.utils.Constants.DATE;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.SERIAL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormMapFiller;

/**
 * author: Pankaj Singh
 * Date: 2/4/2012
 * 
 */

// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:selfassesmenttaxdetail")
public class SelfAssesmentTaxDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:selfassesmenttaxdetail";   
	static final public String NODE_NAME = SelfAssesmentTaxDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(SelfAssesmentTaxDetail.class); 

	
	private String val_BSR ;
	private Calendar val_Date ;
	private String val_serial ;
	private String	val_amount;
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	
	public String getP_BSR() {
    	if (val_BSR == null) val_BSR = getProperty(BSR);
    	return val_BSR;
    }


    public String getP_Serial() {
    	if (val_serial == null) val_serial = getProperty(SERIAL);
    	return val_serial;
    }

    public String getP_Amount() {
    	if (val_amount == null) val_amount = getProperty(AMOUNT);
    	return val_amount;
    }
    public Calendar getP_Date() {
    	if (val_Date == null) val_Date = getProperty(DATE);
    	return val_Date;
    }
	  
    public String getDateStr() {
    	if (val_Date == null) val_Date = getProperty(DATE);
    	if (val_Date != null) {
    		String dateStr = getIndianDateFormatter().format(val_Date.getTime());
    		return dateStr;
    	}
    	return null;
    }
   
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
	public void bindToNode(javax.jcr.Node node) throws RepositoryException {
	    	try {
	    		log.warn("Bind to Node for TdsSalary Called");
	    		node.setProperty(BSR,getP_BSR());
				node.setProperty(SERIAL, getP_Serial());
				node.setProperty(DATE, getP_Date());
				node.setProperty(AMOUNT,getP_Amount());
	    	}catch (RepositoryException re) {
	    		log.error("Binding Node Error",re);
	    		throw re;
	    	}
	    	
	    }
	public final void setP_BSR(String val_BSR) {
		this.val_BSR = val_BSR;
	}


 	
	public final void setP_Date(Calendar val_Date) {
	this.val_Date = val_Date;
}
	

	public final void setP_Serial(String val_serial) {
		this.val_serial = val_serial;
	}

	public final void setP_Amount(String val_amount) {
		this.val_amount = val_amount;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		
		if ( formMap.getField("bsr_code") != null) {
			setP_BSR(formMap.getField("bsr_code").getValue());
		}
		
		if ( formMap.getField("Serial_challan") != null) {
			setP_Serial(formMap.getField("Serial_challan").getValue());
		}
		if ( formMap.getField("amount") != null) {
			setP_Amount(formMap.getField("amount").getValue());
		}
		if ( formMap.getField("date_credit") != null) {
			String strDate = formMap.getField("date_credit").getValue();
			Date date = null ;
			DateFormat formatter ; 
			formatter = getIndianDateFormatter();
			Calendar cal=Calendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate); 
				log.info("date"+date);
				cal.setTime(date);
				setP_Date(cal);
			}
			catch(Exception e){
				log.info("calendar error"+e);
			}
		}
		
	}
	 public static final SimpleDateFormat getIndianDateFormatter() {
	      return new SimpleDateFormat("dd/MM/yyyy");
	     }
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		SelfAssesmentTaxDetail objSelfAssesment = (SelfAssesmentTaxDetail) sourceBean;
		setP_BSR(objSelfAssesment.getP_BSR());
		setP_Serial(objSelfAssesment.getP_Serial());
		setP_Amount(objSelfAssesment.getP_Amount());
		setP_Date(objSelfAssesment.getP_Date());
		
		
	}
	

	
}
