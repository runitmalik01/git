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
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

/**
 * author: Pankaj Singh
 * Date:  6/3/2013
 * Description: This is bean file which save data of capital asset form
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:capitalasset")
public class CapitalAssetInformation extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:capitalasset";
	static final public String NODE_NAME = "capitalasset";
	
	
	
	private String dateAcquisition;
	private String costAcquisition;
	private String dateSale;
	private String costIndexAcquisition;
	private String saleConsideration;
	private String costIndexConsideration;
	private String capitalGain;
	

	 public String getDateAcquisition() {
	    	if (dateAcquisition == null) dateAcquisition = getProperty("mootlywcm:Date_acquisition");
	    	return dateAcquisition;
	 }
	
	 
	 public String getCostAcquisition() {
	    	if (costAcquisition == null) costAcquisition = getProperty("mootlywcm:cost_acquisition");
	    	return costAcquisition;
	 }
	 
	 public String getDateSale() {
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
   
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is Contact bean");
			System.out.println(" inside of cbean starting");
			CapitalAssetInformation capitalasset = (CapitalAssetInformation) content;
			node.setProperty("mootlywcm:Date_acquisition", capitalasset.getDateAcquisition());
	    	node.setProperty("mootlywcm:cost_acquisition", capitalasset.getCostAcquisition());
	    	node.setProperty("mootlywcm:Date_sale", capitalasset.getDateSale());
	    	node.setProperty("mootlywcm:sale_consideration", capitalasset.getSaleConsideration());
	    	node.setProperty("mootlywcm:inflation_acquisition", capitalasset.getCostIndexAcquisition());
	    	node.setProperty("mootlywcm:inflation_consideration", capitalasset.getCostIndexConsideration());
	    	node.setProperty("mootlywcm:capital_gain", capitalasset.getCapitalGain());
	    		
	    
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		System.out.println(" in the c catch of bean");
    		
    	}
		return true;
	}
}
