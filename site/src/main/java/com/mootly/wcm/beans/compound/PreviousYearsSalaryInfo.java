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


import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormMapFiller;


/**
 * Bean mapping class for the 'mootlywcm:address' document type
 */
@Node(jcrType = "mootlywcm:PreviousYearsSalaryInfo")
public class PreviousYearsSalaryInfo extends HippoItem implements FormMapFiller {
	
	private static final Logger log = LoggerFactory.getLogger(PreviousYearsSalaryInfo.class);
	
	private String prevyear;
	private double previncome;
	private double prevarrears;
	private double prevtotalincome;
	private double prevtaxtotalincome;
	private double prevtaxincome;
	private double prevtaxdiff;

	private boolean markedForDeletion;
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	
    public String getPrevYear() {
        if (prevyear==null) prevyear = getProperty("mootlywcm:prevYear");
        return prevyear;
    }

    public double getPrevIncome() {
    	if (previncome==0.0) previncome = getProperty("mootlywcm:prevIncome");
    	return previncome;
    }

    public double getPrevArrears() {
    	if (prevarrears == 0.0) prevarrears = getProperty("mootlywcm:prevArrears");
    	return prevarrears;
    }

    public double getPrevTotalIncome() {
    	if (prevtotalincome == 0.0) prevtotalincome = getProperty("mootlywcm:prevTotalIncome");
    	return prevtotalincome;
    }

    public double getPrevTaxTotalIncome() {
    	if (prevtaxtotalincome == 0.0) prevtaxtotalincome = getProperty("mootlywcm:prevTaxTotalIncome");
    	return prevtaxtotalincome;
    }

    public double getPrevTaxIncome() {
    	if (prevtaxincome == 0.0) prevtaxincome = getProperty("mootlywcm:prevTaxIncome");
    	return prevtaxincome;
    }

    public double getPrevTaxDiff() {
    	if (prevtaxdiff == 0.0) prevtaxdiff = getProperty("mootlywcm:prevTaxDiff");
    	return prevtaxdiff;
    }

    public void bindToNode(javax.jcr.Node node) throws RepositoryException {
    	try {
	    	node.setProperty("mootlywcm:prevYear",getPrevYear());
	    	node.setProperty("mootlywcm:prevIncome",getPrevIncome());
	    	node.setProperty("mootlywcm:prevArrears", getPrevArrears());
	    	node.setProperty("mootlywcm:prevTotalIncome", getPrevTotalIncome());
	    	node.setProperty("mootlywcm:prevTaxTotalIncome", getPrevTaxTotalIncome());
	    	node.setProperty("mootlywcm:prevTaxIncome", getPrevTaxIncome());	    	
	    	node.setProperty("mootlywcm:prevTaxDiff", getPrevTaxDiff());
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		throw re;
    	}
    	
    }

	public final void setPrevYear(String prevyear) {
		this.prevyear = prevyear;
	}

	public final void setPrevIncome(Double previncome) {
		this.previncome = previncome;
	}

	public final void setPrevArrears(Double prevarrears) {
		this.prevarrears = prevarrears;
	}

	public final void setPrevTotalIncome(Double prevtotalincome) {
		this.prevtotalincome = prevtotalincome;
	}

	public final void setPrevTaxTotalIncome(Double prevtaxtotalincome) {
		this.prevtaxtotalincome = prevtaxtotalincome;
	}

	public final void setPrevTaxIncome(Double prevtaxincome) {
		this.prevtaxincome = prevtaxincome;
	}

	public final void setPrevTaxDiff(Double prevtaxdiff) {
		this.prevtaxdiff = prevtaxdiff;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if ( formMap.getField("prevyear") != null) {
			setPrevYear(formMap.getField("prevyear").getValue());
		}
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if ( formMap.getField("previncome") != null) {
			if(formMap.getField("previncome").getValue().isEmpty()){
				setPrevIncome(0.0);
			}else{
				setPrevIncome(Double.valueOf(formMap.getField("previncome").getValue()));	
			}
		}
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if ( formMap.getField("prevarrears") != null) {
			if(formMap.getField("prevarrears").getValue().isEmpty()){
				setPrevArrears(0.0);
			}else{
				setPrevArrears(Double.valueOf(formMap.getField("prevarrears").getValue()));
			}
		}
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if ( formMap.getField("prevtotal") != null) {
			if(formMap.getField("prevtotal").getValue().isEmpty()){
				setPrevTotalIncome(0.0);
			}else{
				setPrevTotalIncome(Double.valueOf(formMap.getField("prevtotal").getValue()));
			}
		}
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if ( formMap.getField("prevtaxontotal") != null) {
			if(formMap.getField("prevtaxontotal").getValue().isEmpty()){
				setPrevTaxTotalIncome(0.0);
			}else{
				setPrevTaxTotalIncome(Double.valueOf(formMap.getField("prevtaxontotal").getValue()));
			}
		}
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if ( formMap.getField("prevtaxincome") != null) {
			if(formMap.getField("prevtaxincome").getValue().isEmpty()){
				setPrevTaxIncome(0.0);
			}else{
				setPrevTaxIncome(Double.valueOf(formMap.getField("prevtaxincome").getValue()));
			}
		}
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if ( formMap.getField("prevtaxdiffer") != null) {
			if(formMap.getField("prevtaxdiffer").getValue().isEmpty()){
				setPrevTaxDiff(0.0);
			}else{
				setPrevTaxDiff(Double.valueOf(formMap.getField("prevtaxdiffer").getValue()));
			}
		}		
	}
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		PreviousYearsSalaryInfo prevsalinfo = (PreviousYearsSalaryInfo) sourceBean;
		setPrevYear(prevsalinfo.getPrevYear());
		setPrevIncome(prevsalinfo.getPrevIncome());
		setPrevArrears(prevsalinfo.getPrevArrears());
		setPrevTotalIncome(prevsalinfo.getPrevTotalIncome());
		setPrevTaxTotalIncome(prevsalinfo.getPrevTaxTotalIncome());
		setPrevTaxIncome(prevsalinfo.getPrevTaxIncome());
		setPrevTaxDiff(prevsalinfo.getPrevTaxDiff());
	};
    	
}    	