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
	
	private Double prevyear;
	private Double previncome;
	private Double prevarrears;
	private Double prevtotalincome;
	private Double prevtaxtotalincome;
	private Double prevtaxincome;
	private Double prevtaxdiff;

	private boolean markedForDeletion;
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	
    public Double getPrevYear() {
        if (prevyear == null) prevyear = getProperty("mootlywcm:prevYear");
        return prevyear;
    }

    public Double getPrevIncome() {
    	if (previncome == null) previncome = getProperty("mootlywcm:prevIncome");
    	return previncome;
    }

    public Double getPrevArrears() {
    	if (prevarrears == null) prevarrears = getProperty("mootlywcm:prevArrears");
    	return prevarrears;
    }

    public Double getPrevTotalIncome() {
    	if (prevtotalincome == null) prevtotalincome = getProperty("mootlywcm:prevTotalIncome");
    	return prevtotalincome;
    }

    public Double getPrevTaxTotalIncome() {
    	if (prevtaxtotalincome == null) prevtaxtotalincome = getProperty("mootlywcm:prevTaxTotalIncome");
    	return prevtaxtotalincome;
    }

    public Double getPrevTaxIncome() {
    	if (prevtaxincome == null) prevtaxincome = getProperty("mootlywcm:prevTaxIncome");
    	return prevtaxincome;
    }

    public Double getPrevTaxDiff() {
    	if (prevtaxdiff == null) prevtaxdiff = getProperty("mootlywcm:prevTaxDiff");
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

	public final void setPrevYear(Double prevyear) {
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
		
		if ( formMap.getField("prevyear") != null) {
			setPrevYear(Double.parseDouble(formMap.getField("prevyear").getValue()));
		}
		if ( formMap.getField("previncome") != null) {
			setPrevIncome(Double.parseDouble(formMap.getField("previncome").getValue()));
		}
		if ( formMap.getField("prevarrears") != null) {
			setPrevArrears(Double.parseDouble(formMap.getField("prevarrears").getValue()));
		}
		if ( formMap.getField("prevtotal") != null) {
			setPrevTotalIncome(Double.parseDouble(formMap.getField("prevtotal").getValue()));
		}
		if ( formMap.getField("prevtaxontotal") != null) {
			setPrevTaxTotalIncome(Double.parseDouble(formMap.getField("prevtaxontotal").getValue()));
		}
		if ( formMap.getField("prevtaxincome") != null) {
			setPrevTaxIncome(Double.parseDouble(formMap.getField("prevtaxincome").getValue()));
		}
		if ( formMap.getField("prevtaxdiff") != null) {
			setPrevTaxDiff(Double.parseDouble(formMap.getField("prevtaxdiff").getValue()));
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