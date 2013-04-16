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

package com.mootly.wcm.beans;
import java.util.Calendar;
import java.util.Date;

import javax.jcr.RepositoryException;
import javax.jcr.Value;

import static com.mootly.wcm.utils.Constants.PROP_PI_AREA_LOCALITY;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMPLOYER_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FATHER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FILING_STATUS;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FLAT_FLOOR_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PAN;
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_RESIDENT_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_SEX;
import static com.mootly.wcm.utils.Constants.PROP_PI_STATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_TOWN_CITY_DISTRICT;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:capitalgain")
public class CapitalGainInformation extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:capitalgain";
	static final public String NODE_NAME = "capitalgain";
	
	
	
	private Calendar dateAcquisition;
	private String costAcquisition;
	private Calendar dateSale;
	private String costIndexAcquisition;
	private String saleConsideration;
	private String costIndexConsideration;
	private String capitalGain;
	

	 public Calendar getDateAcquisition() {
	    	if (dateAcquisition == null) dateAcquisition = getProperty("mootlywcm:Date_acquisition");
	    	return dateAcquisition;
	 }
	
	 
	 public String getCostAcquisition() {
	    	if (costAcquisition == null) costAcquisition = getProperty("mootlywcm:cost_acquisition");
	    	return costAcquisition;
	 }
	 
	 public Calendar getDateSale() {
	    	if (dateSale == null) dateSale = getProperty("mootlywcm:Date_sale");
	    	return dateSale;
	 }
	 public String getSaleConsideration() {
	    	if (saleConsideration == null) saleConsideration = getProperty("mootlywcm:sale_consideration");
	    	return saleConsideration;
	 }
	 public String getCostIndexAcquisition() {
	    	if (costIndexAcquisition == null) costIndexAcquisition = getProperty("mootlywcm:inflation_acquisition");
	    	return costIndexAcquisition;
	 }
	 public String getCostIndexConsideration() {
	    	if (costIndexConsideration == null) costIndexConsideration = getProperty("mootlywcm:inflation_consideration");
	    	return costIndexConsideration;
	 }
	 public String getCapitalGain() {
	    	if (capitalGain == null) capitalGain = getProperty("mootlywcm:capital_gain");
	    	return capitalGain;
	 }
	 
	 
	 
	 
	 
	     
    
    
    public final void setDateAcquisition(Calendar dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}
    public final void setCostAcquisition(String costAcquisition) {
		this.costAcquisition = costAcquisition;
	}
    public final void setDateSale(Calendar dateSale) {
		this.dateSale = dateSale;
    }
    public final void setSaleConsideration(String saleConsideration) {
		this.saleConsideration = saleConsideration;
	}
    public final void setCostIndexAcquisition(String costIndexAcquisition) {
		this.costIndexAcquisition = costIndexAcquisition;
	}
    
    public final void setCostIndexConsideration(String costIndexConsideration) {
		this.costIndexConsideration = costIndexConsideration;
	}
    public final void setCapitalGain(String capitalGain) {
		this.capitalGain = capitalGain;
	}
   
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is Contact bean");
			System.out.println(" inside of cbean starting");
			CapitalGainInformation capitalgain = (CapitalGainInformation) content;
			node.setProperty("mootlywcm:Date_acquisition", capitalgain.getDateAcquisition());
	    	node.setProperty("mootlywcm:cost_acquisition", capitalgain.getCostAcquisition());
	    	node.setProperty("mootlywcm:Date_sale", capitalgain.getDateSale());
	    	node.setProperty("mootlywcm:sale_consideration", capitalgain.getSaleConsideration());
	    	node.setProperty("mootlywcm:inflation_acquisition", capitalgain.getCostIndexAcquisition());
	    	node.setProperty("mootlywcm:inflation_consideration", capitalgain.getCostIndexConsideration());
	    	node.setProperty("mootlywcm:capital_gain", capitalgain.getCapitalGain());
	    		
	    
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		System.out.println(" in the c catch of bean");
    		
    	}
		return true;
	}
}
