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

import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_SALARIES;
import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_TAN;
import static com.mootly.wcm.utils.Constants.PROP_TOTAL_TAX_DEDUCTED;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Bean mapping class for the 'mootlywcm:address' document type
 */
@Node(jcrType = "mootlywcm:tdssalary")
public class TdsSalary extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(TdsSalary.class);
	
	private String employerName;
	private String employerTan;
	private Double employerSalaries;
	private Double totalTaxDeducted;
	
	public String getEmployerTan() {
    	if (employerTan == null) employerTan = getProperty(PROP_EMPLOYER_TAN);
    	return employerTan;
    }

    public String getEmployerName() {
        if (employerName == null) employerName = getProperty(PROP_EMPLOYER_NAME);
        return employerName;
    }

    
    public Double getEmployerSalaries() {
    	if (employerSalaries == null) employerSalaries = getProperty(PROP_EMPLOYER_SALARIES);
    	return employerSalaries;
    }

    public Double getTotalTaxDeducted() {
    	if (totalTaxDeducted == null) totalTaxDeducted = getProperty(PROP_TOTAL_TAX_DEDUCTED);
    	return totalTaxDeducted;
    }

    
    public void bindToNode(javax.jcr.Node node) throws RepositoryException {
    	try {
    		log.warn("Bind to Node for TdsSalary Called");
	    	node.setProperty(PROP_EMPLOYER_TAN,getEmployerTan());
	    	node.setProperty(PROP_EMPLOYER_NAME,getEmployerName());
	    	node.setProperty(PROP_EMPLOYER_SALARIES, getEmployerSalaries());
	    	node.setProperty(PROP_TOTAL_TAX_DEDUCTED, getTotalTaxDeducted());
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		throw re;
    	}
    	
    }

	public final void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public final void setEmployerTan(String employerTan) {
		this.employerTan = employerTan;
	}

	public final void setEmployerSalaries(Double employerSalaries) {
		this.employerSalaries = employerSalaries;
	}

	public final void setTotalTaxDeducted(Double totalTaxDeducted) {
		this.totalTaxDeducted = totalTaxDeducted;
	}
    
}    	