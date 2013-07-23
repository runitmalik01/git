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

import java.util.Calendar;

import javax.jcr.RepositoryException;
import static com.mootly.wcm.utils.Constants.amount;

import static com.mootly.wcm.utils.Constants.deducted_year;

import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_SALARIES;
import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_TAN;
import static com.mootly.wcm.utils.Constants.PROP_TOTAL_TAX_DEDUCTED;
import static com.mootly.wcm.utils.Constants.tan_deductor;
import static com.mootly.wcm.utils.Constants.name_deductor;

import static com.mootly.wcm.utils.Constants.total_taxdeducted;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:CompTdsOthers")
public class CompTdsothers extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(CompTdsothers.class);
	
	private String tan_Deductor ;
	private String total_TaxDeductor ;
	private String val_amount;
	private String name_Deductor;
	
	public String getTan_Deductor() {
    	if (tan_Deductor == null) tan_Deductor = getProperty(tan_deductor);
    	return tan_Deductor;
    }

    public String getTotal_TaxDeductor() {
    	if (total_TaxDeductor == null) total_TaxDeductor = getProperty(total_taxdeducted);
    	return total_TaxDeductor;
    }

    public String getP_Amount() {
    	if (val_amount == null) val_amount = getProperty(amount);
    	return val_amount;
    }
    public String getName_Deductor() {
    	if (name_Deductor == null) name_Deductor = getProperty(name_deductor);
    	return name_Deductor;
    }
    
    public void bindToNode(javax.jcr.Node node) throws RepositoryException {
    	try {
    		log.warn("Bind to Node for TdsSalary Called");
	    	node.setProperty(tan_deductor,getTan_Deductor());
	    	node.setProperty(total_taxdeducted,getTotal_TaxDeductor() );
	    	node.setProperty(amount, getP_Amount());
	    	node.setProperty(name_deductor, getName_Deductor());
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		throw re;
    	}
    	
    }
    public final void setTan_Deductor(String tan_Deductor) {
		this.tan_Deductor = tan_Deductor;
	}
	public final void setTotal_TaxDeductor(String total_TaxDeductor) {
		this.total_TaxDeductor = total_TaxDeductor;
	}
	public final void setName_Deductor(String name_Deductor) {
		this.name_Deductor = name_Deductor;
	}
	

	public final void setP_Amount(String val_amount) {
		this.val_amount = val_amount;
	}
		
}
