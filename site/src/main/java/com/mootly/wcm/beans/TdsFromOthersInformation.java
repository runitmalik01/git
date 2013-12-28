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

import static com.mootly.wcm.utils.Constants.amount;
import static com.mootly.wcm.utils.Constants.name_deductor;
import static com.mootly.wcm.utils.Constants.tan_deductor;
import static com.mootly.wcm.utils.Constants.total_taxdeducted;

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

@Node(jcrType = "mootlywcm:tdsfromothersinfo")
public class TdsFromOthersInformation extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:tdsfromothersinfo";            
	static final public String NODE_NAME = "tdsfromothersinfo";
	

	
	private String[] tan_Deductor ;
	
	private String[] total_TaxDeductor ;
	private String []val_amount;
	private String []name_Deductor;
	private String total_value;
	
   

    public String[] getTan_Deductor() {
    	if (tan_Deductor == null) tan_Deductor = getProperty(tan_deductor,new String[]{""});
    	return tan_Deductor;
    }

   

    public String[] getTotal_TaxDeductor() {
    	if (total_TaxDeductor == null) total_TaxDeductor = getProperty(total_taxdeducted,new String[]{""});
    	return total_TaxDeductor;
    }

    public String[] getP_Amount() {
    	if (val_amount == null) val_amount = getProperty(amount,new String[]{""});
    	return val_amount;
    }
    public String[] getName_Deductor() {
    	if (name_Deductor == null) name_Deductor = getProperty(name_deductor,new String[]{""});
    	return name_Deductor;
    }
    public String getTotal_Value() {
    	if (total_value == null) total_value = getProperty("mootlywcm:totaloftaxdeducted");
    	return total_value;
 }
   
   
    
    

	public final void setTan_Deductor(String[] tan_Deductor) {
		this.tan_Deductor = tan_Deductor;
	}


 
	
	

	public final void setTotal_TaxDeductor(String[] total_TaxDeductor) {
		this.total_TaxDeductor = total_TaxDeductor;
	}
	public final void setName_Deductor(String[] name_Deductor) {
		this.name_Deductor = name_Deductor;
	}
	

	public final void setP_Amount(String[] val_amount) {
		this.val_amount = val_amount;
	}
	 public final void setTotal_Value(String totalvalue) {
			this.total_value = totalvalue;
		}
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			TdsFromOthersInformation tds_salary = (TdsFromOthersInformation) content;
			


			
	       if (tds_salary.getTan_Deductor() != null) {
				node.setProperty(tan_deductor, tds_salary.getTan_Deductor());
			}
	      
	       if (tds_salary.getTotal_TaxDeductor() != null) {
				node.setProperty(total_taxdeducted, tds_salary.getTotal_TaxDeductor());
			}
	       if (tds_salary.getName_Deductor() != null) {
				node.setProperty(name_deductor, tds_salary.getName_Deductor());
			}
	      
	       if (tds_salary.getP_Amount() != null) {
				node.setProperty(amount, tds_salary.getP_Amount());
			}
	   	node.setProperty("mootlywcm:totaloftaxdeducted", tds_salary.getTotal_Value());
	    	

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
