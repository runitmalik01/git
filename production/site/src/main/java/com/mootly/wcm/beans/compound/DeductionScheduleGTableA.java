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
@Node(jcrType = "mootlywcm:DeductionScheduleGTableA")
public class DeductionScheduleGTableA extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(DeductionScheduleGTableA.class);
	
	private String[]  nameA;
	private String[]  addressA;
	private String[]  cityA;
	private String[]  clickforstatecodeA;
	private String[]  pincodeA;
	private String[]  amountofdonationA;
	private String[]  limitA;
	private String[]  deductionamountA;

	
	public String[] getNameA() {
		if (nameA == null) nameA = getProperty("mootlywcm:nameA",new String[]{""});
		return nameA;
	}
	public String[] getAddressA() {
		if (addressA == null) addressA = getProperty("mootlywcm:addressA",new String[]{""});
		return addressA;
	}
	public String[] getCityA() {
		if (cityA == null) cityA = getProperty("mootlywcm:cityA",new String[]{""});
		return cityA;
	}
	public String[] getClickForStateCodeA() {
		if (clickforstatecodeA == null) clickforstatecodeA = getProperty("mootlywcm:clickforstatecodeA",new String[]{""});
		return clickforstatecodeA;
	}
	public String[] getPinCodeA() {
		if (pincodeA == null) pincodeA = getProperty("mootlywcm:pincodeA",new String[]{""});
		return pincodeA;
	}
	public String[] getAmountOfDonationA() {
		if (amountofdonationA == null) amountofdonationA = getProperty("mootlywcm:amountofdonationA",new String[]{""});
		return amountofdonationA;
	}
	public String[] getLimitA() {
		if (limitA == null) limitA = getProperty("mootlywcm:limitA",new String[]{""});
		return limitA;
	}
	public String[] getDeductionAmountA() {
		if (deductionamountA == null) deductionamountA = getProperty("mootlywcm:deductionamountA",new String[]{""});
		return deductionamountA;
	}
	
    

 
    
    public void bindToNode(javax.jcr.Node node) throws RepositoryException {
    	try {
	    	node.setProperty("mootlywcm:nameA",getNameA());
	    	node.setProperty("mootlywcm:addressA",getAddressA());
	    	node.setProperty("mootlywcm:cityA", getCityA());
	    	node.setProperty("mootlywcm:clickforstatecodeA", getClickForStateCodeA());
	    	node.setProperty("mootlywcm:pincodeA", getPinCodeA());
	    	node.setProperty("mootlywcm:amountofdonationA", getAmountOfDonationA());
	    	node.setProperty("mootlywcm:limitA", getLimitA());
	    	node.setProperty("mootlywcm:deductionamountA", getDeductionAmountA());

    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		throw re;
    	}
    	
    }

	public final void setNameA(String[] nameA) {
		this.nameA = nameA;
	}

	public final void setAddressA(String[] addressA) {
		this.addressA = addressA;
	}

	public final void setCityA(String[] cityA) {
		this.cityA = cityA;
	}

	public final void setClickForStateCodeA(String[] clickforstatecodeA) {
		this.clickforstatecodeA = clickforstatecodeA;
	}

	public final void setPinCodeA(String[] pincodeA) {
		this.pincodeA = pincodeA;
	}

	public final void setAmountOfDonationA(String[] amountofdonationA) {
		this.amountofdonationA = amountofdonationA;
	}

	public final void setLimitA(String[] limitA) {
		this.limitA = limitA;
	}

	public final void setDeductionAmountA(String[] deductionamountA) {
		this.deductionamountA = deductionamountA;
	}

	
}    	