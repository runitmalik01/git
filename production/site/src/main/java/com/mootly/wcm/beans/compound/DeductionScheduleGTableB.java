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

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Bean mapping class for the 'mootlywcm:address' document type
 */
@Node(jcrType = "mootlywcm:DeductionScheduleGTableB")
public class DeductionScheduleGTableB extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(DeductionScheduleGTableB.class);
	
	private String[]  nameB;
	private String[]  addressB;
	private String[]  cityB;
	private String[]  clickforstatecodeB;
	private String[]  pincodeB;
	private String[]  amountofdonationB;
	private String[]  limitB;
	private String[]  deductionamountB;

	
	public String[] getNameB() {
		if (nameB == null) nameB = getProperty("mootlywcm:nameB",new String[]{""});
		return nameB;
	}
	public String[] getAddressB() {
		if (addressB == null) addressB = getProperty("mootlywcm:addressB",new String[]{""});
		return addressB;
	}
	public String[] getCityB() {
		if (cityB == null) cityB = getProperty("mootlywcm:cityB",new String[]{""});
		return cityB;
	}
	public String[] getClickForStateCodeB() {
		if (clickforstatecodeB == null) clickforstatecodeB = getProperty("mootlywcm:clickforstatecodeB",new String[]{""});
		return clickforstatecodeB;
	}
	public String[] getPinCodeB() {
		if (pincodeB == null) pincodeB = getProperty("mootlywcm:pincodeB",new String[]{""});
		return pincodeB;
	}
	public String[] getAmountOfDonationB() {
		if (amountofdonationB == null) amountofdonationB = getProperty("mootlywcm:amountofdonationB",new String[]{""});
		return amountofdonationB;
	}
	public String[] getLimitB() {
		if (limitB == null) limitB = getProperty("mootlywcm:limitB",new String[]{""});
		return limitB;
	}
	public String[] getDeductionAmountB() {
		if (deductionamountB == null) deductionamountB = getProperty("mootlywcm:deductionamountB",new String[]{""});
		return deductionamountB;
	}
	
    

 
    
    public void bindToNode(javax.jcr.Node node) throws RepositoryException {
    	try {
	    	node.setProperty("mootlywcm:nameB",getNameB());
	    	node.setProperty("mootlywcm:addressB",getAddressB());
	    	node.setProperty("mootlywcm:cityB", getCityB());
	    	node.setProperty("mootlywcm:clickforstatecodeB", getClickForStateCodeB());
	    	node.setProperty("mootlywcm:pincodeB", getPinCodeB());
	    	node.setProperty("mootlywcm:amountofdonationB", getAmountOfDonationB());
	    	node.setProperty("mootlywcm:limitB", getLimitB());
	    	node.setProperty("mootlywcm:deductionamountB", getDeductionAmountB());

    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		throw re;
    	}
    	
    }

	public final void setNameB(String[] nameB) {
		this.nameB = nameB;
	}

	public final void setAddressB(String[] addressB) {
		this.addressB = addressB;
	}

	public final void setCityB(String[] cityB) {
		this.cityB = cityB;
	}

	public final void setClickForStateCodeB(String[] clickforstatecodeB) {
		this.clickforstatecodeB = clickforstatecodeB;
	}

	public final void setPinCodeB(String[] pincodeB) {
		this.pincodeB = pincodeB;
	}

	public final void setAmountOfDonationB(String[] amountofdonationB) {
		this.amountofdonationB = amountofdonationB;
	}

	public final void setLimitB(String[] limitB) {
		this.limitB = limitB;
	}

	public final void setDeductionAmountB(String[] deductionamountB) {
		this.deductionamountB = deductionamountB;
	}

	
}    	