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

import static com.mootly.wcm.utils.Constants.AMOUNT;
import static com.mootly.wcm.utils.Constants.AMOUNT1;
import static com.mootly.wcm.utils.Constants.BSR;
import static com.mootly.wcm.utils.Constants.BSR1;
import static com.mootly.wcm.utils.Constants.DATE;
import static com.mootly.wcm.utils.Constants.DATE1;
import static com.mootly.wcm.utils.Constants.SERIAL;
import static com.mootly.wcm.utils.Constants.SERIAL1;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:advancetaxinformation")
public class AdvanceTaxInformation extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:advancetaxinformation";            
	static final public String NODE_NAME = "advancetaxinformation";
	

	
	private String[] val_BSR ;
	private String[] val_Date ;
	private String[] val_serial ;
	private String []val_amount;
	
	private String[] val_BSR1 ;
	private String[] val_Date1 ;
	private String[] val_serial1 ;
	private String []val_amount1;
	private String total_value;
   

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

    
    public String[] getP_BSR1() {
    	if (val_BSR1 == null) val_BSR1 = getProperty(BSR1,new String[]{""});
    	return val_BSR1;
    }

    public String[] getP_Date1() {
    	if (val_Date1 == null) val_Date1 = getProperty(DATE1,new String[]{""});
    	return val_Date1;
    }

    public String[] getP_Serial1() {
    	if (val_serial1 == null) val_serial1 = getProperty(SERIAL1,new String[]{""});
    	return val_serial1;
    }

    public String[] getP_Amount1() {
    	if (val_amount1 == null) val_amount1 = getProperty(AMOUNT1,new String[]{""});
    	return val_amount1;
    }
    public String getTotal_Value() {
    	if (total_value == null) total_value = getProperty("mootlywcm:totalofamount");
    	return total_value;
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
	public final void setP_BSR1(String[] val_BSR1) {
		this.val_BSR1 = val_BSR1;
	}


 
	public final void setP_Date1(String[] val_Date1) {
		this.val_Date1 = val_Date1;
	}
	

	public final void setP_Serial1(String[] val_serial1) {
		this.val_serial1 = val_serial1;
	}

	public final void setP_Amount1(String[] val_amount1) {
		this.val_amount1 = val_amount1;
	}
	 public final void setTotal_Value(String totalvalue) {
			this.total_value = totalvalue;
		}
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			AdvanceTaxInformation tds_salary = (AdvanceTaxInformation) content;
			


			
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
	   	
	       if (tds_salary.getP_BSR1() != null) {
				node.setProperty(BSR1, tds_salary.getP_BSR1());
			}
	       if (tds_salary.getP_Date1() != null) {
				node.setProperty(DATE1, tds_salary.getP_Date1());
			}
	       if (tds_salary.getP_Serial1() != null) {
				node.setProperty(SERIAL1, tds_salary.getP_Serial1());
			}
	       if (tds_salary.getP_Amount1() != null) {
				node.setProperty(AMOUNT1, tds_salary.getP_Amount1());
			}
	   	node.setProperty("mootlywcm:totalofamount", tds_salary.getTotal_Value());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
