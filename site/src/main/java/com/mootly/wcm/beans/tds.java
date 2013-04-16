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

import java.util.Calendar;

import javax.jcr.RepositoryException;
import static com.mootly.wcm.utils.Constants.AMOUNT;

import static com.mootly.wcm.utils.Constants.DATE;

import static com.mootly.wcm.utils.Constants.BSR;
import static com.mootly.wcm.utils.Constants.SERIAL;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:tds")
public class tds extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:tds";            
	static final public String NODE_NAME = "tds";
	

	
	private String[] val_BSR ;
	private String[] val_Date ;
	private String[] val_serial ;
	private String []val_amount;
	
   

    public String[] getP_BSR() {
    	if (val_BSR == null) val_BSR = getProperty(BSR,new String[]{""});
    	return val_BSR;
    }

    public String[] getP_Date() {
    	if (val_Date == null) val_Date = getProperty(DATE,new String[]{""});
    	return val_Date;
    }

    public String[] getP_Serial() {
    	if (val_serial == null) val_serial = getProperty(SERIAL,new String[]{""});
    	return val_serial;
    }

    public String[] getP_Amount() {
    	if (val_amount == null) val_amount = getProperty(AMOUNT,new String[]{""});
    	return val_amount;
    }

   
    
    

	public final void setP_BSR(String[] val_BSR) {
		this.val_BSR = val_BSR;
	}


 
	public final void setP_Date(String[] val_Date) {
		this.val_Date = val_Date;
	}
	

	public final void setP_Serial(String[] val_serial) {
		this.val_serial = val_serial;
	}

	public final void setP_Amount(String[] val_amount) {
		this.val_amount = val_amount;
	}
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			tds tds_salary = (tds) content;
			


			
	       if (tds_salary.getP_BSR() != null) {
				node.setProperty(BSR, tds_salary.getP_BSR());
			}
	       if (tds_salary.getP_Date() != null) {
				node.setProperty(DATE, tds_salary.getP_Date());
			}
	       if (tds_salary.getP_Serial() != null) {
				node.setProperty(SERIAL, tds_salary.getP_Serial());
			}
	       if (tds_salary.getP_Amount() != null) {
				node.setProperty(AMOUNT, tds_salary.getP_Amount());
			}
	    	

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
