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
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jcr.RepositoryException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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

@Node(jcrType = "mootlywcm:advancetaxdetail")
public class AdvanceTaxDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:advancetaxdetail";   
	static final public String NODE_NAME = AdvanceTaxDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(AdvanceTaxDetail.class); 


	private String val_BSR ;
	private GregorianCalendar val_Date ;
	private String val_serial ;
	private Double	val_amount;

	private String personalInfoUuid;
	private boolean markedForDeletion;

	Boolean isImported;
	private boolean isReviewed;
	private Boolean isImportedFromDIT;
	
	public Boolean getIsImported() {
		if (isImported == null) isImported = getProperty("mootlywcm:isimport");
		return isImported;
	}
	public void setIsImported(Boolean isImported) {
		this.isImported = isImported;
	}
	
	public final Boolean isImportedFromDIT() {
		if ( isImportedFromDIT == null) isImportedFromDIT = getProperty("mootlywcm:isImportedFromDIT");
		return isImportedFromDIT;
	}
	

	public final void setImportedFromDIT(boolean isImportedFromDIT) {
		this.isImportedFromDIT = isImportedFromDIT;
	}
	
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

	public GregorianCalendar getP_Date() {
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
	//created for xml
	public XMLGregorianCalendar getGregorianP_Date() {
		if (val_Date == null) val_Date = getProperty(DATE);
		String dobStr = getIndianDateFormatter().format(val_Date.getTime());
		XMLGregorianCalendar date2=null;
		try {
			//date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(dobStr);
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(val_Date);

		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
	}

	public String getP_Serial() {
		if (val_serial == null) val_serial = getProperty(SERIAL);
		return val_serial;
	}

	public Double getP_Amount() {
		if (val_amount == null) val_amount = getProperty(AMOUNT);
		return val_amount;
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
			node.setProperty(BSR,getP_BSR());
			node.setProperty(SERIAL, getP_Serial());
			node.setProperty(DATE, getP_Date());
			node.setProperty(AMOUNT,getP_Amount());
			if (isImportedFromDIT() != null) node.setProperty("mootlywcm:isImportedFromDIT", isImportedFromDIT());
		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);
			throw re;
		}

	}
	public final void setP_BSR(String val_BSR) {
		this.val_BSR = val_BSR;
	}



	public final void setP_Date(GregorianCalendar val_Date) {
		this.val_Date = val_Date;
	}


	public final void setP_Serial(String val_serial) {
		this.val_serial = val_serial;
	}

	public final void setP_Amount(Double val_amount) {
		this.val_amount = val_amount;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;

		if ( formMap.getField("bsr_codeadv") != null) {
			setP_BSR(formMap.getField("bsr_codeadv").getValue());
		}

		if ( formMap.getField("Serial_challanadv") != null) {
			setP_Serial(formMap.getField("Serial_challanadv").getValue());
		}
		if ( formMap.getField("amountadv") != null) {
			String strAmount=formMap.getField("amountadv").getValue();
			double amt=Double.parseDouble(strAmount);
			setP_Amount(amt);
		}
		
		if ( formMap.getField("isImportedFromDIT") != null) {
			String isImportedFromDIT=formMap.getField("isImportedFromDIT").getValue();			
			setImportedFromDIT(Boolean.valueOf(isImportedFromDIT));
		}
		
		if ( formMap.getField("date_creditadv") != null) {
			String strDate = formMap.getField("date_creditadv").getValue();
			Date date = null ;
			DateFormat formatter ; 
			formatter = getIndianDateFormatter();
			GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate); 
				//log.info("date"+date);
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
		AdvanceTaxDetail objAdvanceTax = (AdvanceTaxDetail) sourceBean;
		setP_BSR(objAdvanceTax.getP_BSR());
		setP_Serial(objAdvanceTax.getP_Serial());
		setP_Amount(objAdvanceTax.getP_Amount());
		setP_Date(objAdvanceTax.getP_Date());
	}

}
