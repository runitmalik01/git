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

import static com.mootly.wcm.utils.Constants.AMOUNT1;
import static com.mootly.wcm.utils.Constants.BSR1;
import static com.mootly.wcm.utils.Constants.DATE1;
import static com.mootly.wcm.utils.Constants.SERIAL1;

import java.util.Calendar;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author: Pankaj Singh
 * Date1: 2/4/2012
 * 
 */

// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:selfassesmentinfo")
public class SelfAssesmentInfo extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(SelfAssesmentInfo.class);
	
	
	private String val_BSR1 ;
	private Calendar val_Date1 ;
	private String val_serial1 ;
	private String	val_amount1;
	
	
   

    public String getP_BSR1() {
    	if (val_BSR1 == null) val_BSR1 = getProperty(BSR1);
    	return val_BSR1;
    }

    public Calendar getP_Date1() {
    	if (val_Date1 == null) val_Date1 = getProperty(DATE1);
    	return val_Date1;
    }
   

    public String getP_Serial1() {
    	if (val_serial1 == null) val_serial1 = getProperty(SERIAL1);
    	return val_serial1;
    }

    public String getP_Amount1() {
    	if (val_amount1 == null) val_amount1 = getProperty(AMOUNT1);
    	return val_amount1;
    }

   
	
	  public void bindToNode(javax.jcr.Node node) throws RepositoryException {
	    	try {
	    		log.warn("Bind to Node for TdsSalary Called");
	    		node.setProperty(BSR1,getP_BSR1());
				node.setProperty(SERIAL1, getP_Serial1());
				node.setProperty(DATE1, getP_Date1());
				node.setProperty(AMOUNT1,getP_Amount1());
	    	}catch (RepositoryException re) {
	    		log.error("Binding Node Error",re);
	    		throw re;
	    	}
	    	
	    }
    
public final void setP_BSR1(String val_BSR1) {
		this.val_BSR1 = val_BSR1;
	}


 	
 public final void setP_Date1(Calendar val_Date1) {
	this.val_Date1 = val_Date1;
}
	

	public final void setP_serial1(String val_serial1) {
		this.val_serial1 = val_serial1;
	}

	public final void setP_amount1(String val_amount1) {
		this.val_amount1 = val_amount1;
	}
	
}
