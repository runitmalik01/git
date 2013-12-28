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
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.FormMapFiller;


/**
 * author: Pankaj Singh
 * Date:  6/3/2013
 * Description: This is bean file which save data of capital asset form
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:securitiescomp")

@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class SecuritiesComp extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:securitiescomp";
	static final public String NODE_NAME = SecuritiesComp.class.getName().toLowerCase();
	
	private final static Logger log = LoggerFactory.getLogger(SecuritiesComp.class); 
	
	
	
	private String dateAcquisition;
	private String costAcquisition;
	private String dateSale;
	private String costIndexAcquisition;
	private String saleConsideration;
	private String costIndexConsideration;
	private String capitalGain;
	private String personalInfoUuid;
	
	private boolean markedForDeletion;
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	
	 public String getDateAcquisition() {
	    	if (dateAcquisition == null) dateAcquisition = getProperty("mootlywcm:year_acquisition");
	    	return dateAcquisition;
	 }
	
	 
	 public String getCostAcquisition() {
	    	if (costAcquisition == null) costAcquisition = getProperty("mootlywcm:cost_acquisition");
	    	return costAcquisition;
	 }
	 
	 public String getDateSale() {
	    	if (dateSale == null) dateSale = getProperty("mootlywcm:year_sale");
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
	 
	 
	
	
	 
	 
	     
    
    
    public final void setDateAcquisition(String dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}
    public final void setCostAcquisition(String costAcquisition) {
		this.costAcquisition = costAcquisition;
	}
    public final void setDateSale(String dateSale) {
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
			log.warn("this is Contact bean");
			System.out.println(" inside of cbean starting");
			
			node.setProperty("mootlywcm:year_acquisition", getDateAcquisition());
	    	node.setProperty("mootlywcm:cost_acquisition", getCostAcquisition());
	    	node.setProperty("mootlywcm:year_sale", getDateSale());
	    	node.setProperty("mootlywcm:sale_consideration", getSaleConsideration());
	    	node.setProperty("mootlywcm:inflation_acquisition",getCostIndexAcquisition());
	    	node.setProperty("mootlywcm:inflation_consideration",getCostIndexConsideration());
	    	node.setProperty("mootlywcm:capital_gain",getCapitalGain());
	    		
	    
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		System.out.println(" in the c catch of bean");
    		
    	}
		return true;
	}
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		log.info("inside the function fill in the capital asset bean");
		if (formMap == null) return;
		if (formMap.getField("hidDateAcquisition") != null) setDateAcquisition(formMap.getField("hidDateAcquisition").getValue());
		if (formMap.getField("cost_acquisition") != null) setCostAcquisition(formMap.getField("cost_acquisition").getValue());
		if (formMap.getField("hidDateSale") != null) setDateSale(formMap.getField("hidDateSale").getValue());
		if (formMap.getField("sale_consideration") != null) setSaleConsideration(formMap.getField("sale_consideration").getValue());
		if (formMap.getField("inflation_acquisition") != null) setCostIndexAcquisition(formMap.getField("inflation_acquisition").getValue());
		if (formMap.getField("inflation_consideration") != null)  setCostIndexConsideration(formMap.getField("inflation_consideration").getValue());
		if (formMap.getField("capital_gain") != null) setCapitalGain(formMap.getField("capital_gain").getValue()); 
		log.info("at  the end of the function fill in the capital asset bean");
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
	
		// TODO Auto-generated method stub
		SecuritiesComp objSecuritiesdetail = (SecuritiesComp) sourceBean;
		setDateAcquisition(objSecuritiesdetail.getDateAcquisition());
		setCostAcquisition(objSecuritiesdetail.getCostAcquisition());
		setDateSale(objSecuritiesdetail.getDateSale());
		setSaleConsideration(objSecuritiesdetail.getSaleConsideration());
		setCostIndexAcquisition(objSecuritiesdetail.getCostIndexConsideration());
		setCostIndexConsideration(objSecuritiesdetail.getCostIndexConsideration());
		setCapitalGain(objSecuritiesdetail.getCapitalGain());
	}
	
}
