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
@Node(jcrType = "mootlywcm:DeductionScheduleGTableC")
public class DeductionScheduleGTableC extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(DeductionScheduleGTableC.class);
	
	private String[]  nameC;
	private String[]  addressC;
	private String[]  cityC;
	private String[]  clickforstatecodeC;
	private String[]  pincodeC;
	private String[]  amountofdonationC;
	private String[]  limitC;
	private String[]  deductionamountC;

	
	public String[] getNameC() {
		if (nameC == null) nameC = getProperty("mootlywcm:nameC",new String[]{""});
		return nameC;
	}
	public String[] getAddressC() {
		if (addressC == null) addressC = getProperty("mootlywcm:addressC",new String[]{""});
		return addressC;
	}
	public String[] getCityC() {
		if (cityC == null) cityC = getProperty("mootlywcm:cityC",new String[]{""});
		return cityC;
	}
	public String[] getClickForStateCodeC() {
		if (clickforstatecodeC == null) clickforstatecodeC = getProperty("mootlywcm:clickforstatecodeC",new String[]{""});
		return clickforstatecodeC;
	}
	public String[] getPinCodeC() {
		if (pincodeC == null) pincodeC = getProperty("mootlywcm:pincodeC",new String[]{""});
		return pincodeC;
	}
	public String[] getAmountOfDonationC() {
		if (amountofdonationC == null) amountofdonationC = getProperty("mootlywcm:amountofdonationC",new String[]{""});
		return amountofdonationC;
	}
	public String[] getLimitC() {
		if (limitC == null) limitC = getProperty("mootlywcm:limitC",new String[]{""});
		return limitC;
	}
	public String[] getDeductionAmountC() {
		if (deductionamountC == null) deductionamountC = getProperty("mootlywcm:deductionamountC",new String[]{""});
		return deductionamountC;
	}
	
    

 
    
    public void bindToNode(javax.jcr.Node node) throws RepositoryException {
    	try {
	    	node.setProperty("mootlywcm:nameC",getNameC());
	    	node.setProperty("mootlywcm:addressC",getAddressC());
	    	node.setProperty("mootlywcm:cityC", getCityC());
	    	node.setProperty("mootlywcm:clickforstatecodeC", getClickForStateCodeC());
	    	node.setProperty("mootlywcm:pincodeC", getPinCodeC());
	    	node.setProperty("mootlywcm:amountofdonationC", getAmountOfDonationC());
	    	node.setProperty("mootlywcm:limitC", getLimitC());
	    	node.setProperty("mootlywcm:deductionamountC", getDeductionAmountC());

    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		throw re;
    	}
    	
    }

	public final void setNameC(String[] nameC) {
		this.nameC = nameC;
	}

	public final void setAddressC(String[] addressC) {
		this.addressC = addressC;
	}

	public final void setCityC(String[] cityC) {
		this.cityC = cityC;
	}

	public final void setClickForStateCodeC(String[] clickforstatecodeC) {
		this.clickforstatecodeC = clickforstatecodeC;
	}

	public final void setPinCodeC(String[] pincodeC) {
		this.pincodeC = pincodeC;
	}

	public final void setAmountOfDonationC(String[] amountofdonationC) {
		this.amountofdonationC = amountofdonationC;
	}

	public final void setLimitC(String[] limitC) {
		this.limitC = limitC;
	}

	public final void setDeductionAmountC(String[] deductionamountC) {
		this.deductionamountC = deductionamountC;
	}

	
}    	