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

import static com.mootly.wcm.utils.Constants.AMOUNT;
import static com.mootly.wcm.utils.Constants.AMOUNT1;
import static com.mootly.wcm.utils.Constants.BSR;
import static com.mootly.wcm.utils.Constants.BSR1;
import static com.mootly.wcm.utils.Constants.DATE;
import static com.mootly.wcm.utils.Constants.DATE1;
import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_SALARIES;
import static com.mootly.wcm.utils.Constants.PROP_EMPLOYER_TAN;
import static com.mootly.wcm.utils.Constants.PROP_TOTAL_TAX_DEDUCTED;
import static com.mootly.wcm.utils.Constants.SERIAL;
import static com.mootly.wcm.utils.Constants.SERIAL1;
import static com.mootly.wcm.utils.Constants.tan_deductor;
import static com.mootly.wcm.utils.Constants.name_deductor;

import static com.mootly.wcm.utils.Constants.total_taxdeducted;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.AdvanceTaxInformation;

/**
 * author: Pankaj Singh
 * Date: 2/4/2012
 * 
 */

// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:advancetaxinfo")
public class AdvanceTaxInfo extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(AdvanceTaxInfo.class);

	
	private String val_BSR ;
	private Calendar val_Date ;
	private String val_serial ;
	private String	val_amount;
	
	
   

    public String getP_BSR() {
    	if (val_BSR == null) val_BSR = getProperty(BSR);
    	return val_BSR;
    }

    public Calendar getP_Date() {
    	if (val_Date == null) val_Date = getProperty(DATE);
    	return val_Date;
    }
   

    public String getP_Serial() {
    	if (val_serial == null) val_serial = getProperty(SERIAL);
    	return val_serial;
    }

    public String getP_Amount() {
    	if (val_amount == null) val_amount = getProperty(AMOUNT);
    	return val_amount;
    }

   

	  public void bindToNode(javax.jcr.Node node) throws RepositoryException {
	    	try {
	    		log.warn("Bind to Node for TdsSalary Called");
	    		node.setProperty(BSR,getP_BSR());
				node.setProperty(SERIAL, getP_Serial());
				node.setProperty(DATE, getP_Date());
				node.setProperty(AMOUNT,getP_Amount());
	    	}catch (RepositoryException re) {
	    		log.error("Binding Node Error",re);
	    		throw re;
	    	}
	    	
	    }
public final void setP_BSR(String val_BSR) {
		this.val_BSR = val_BSR;
	}


 	
 public final void setP_Date(Calendar val_Date) {
	this.val_Date = val_Date;
}
	

	public final void setP_Serial(String val_serial) {
		this.val_serial = val_serial;
	}

	public final void setP_Amount(String val_amount) {
		this.val_amount = val_amount;
	}
	

	
}
